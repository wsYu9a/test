package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.NotificationConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class DownloadNotificationManager {
    private static final String KEY_NOTIFS_STRING = "notifs_string";
    private static volatile DownloadNotificationManager instance;
    private static final Object sLock = new Object();
    private final long PROGRESS_NOTIFY_DURATION = 1000;
    private final Map<Integer, Long> PROGRESS_NOTIFY_LAST_TIME_INFO = new HashMap();
    private final Set<String> notificationTagSet = new HashSet();
    private final SparseArray<AbsNotificationItem> notificationItemArray = new SparseArray<>();

    private DownloadNotificationManager() {
    }

    public static DownloadNotificationManager getInstance() {
        if (instance == null) {
            synchronized (DownloadNotificationManager.class) {
                if (instance == null) {
                    instance = new DownloadNotificationManager();
                }
            }
        }
        return instance;
    }

    static boolean isCompleteAndVisible(DownloadInfo downloadInfo) {
        return downloadInfo.isDownloadOverStatus() && isCompleteVisibility(downloadInfo.getNotificationVisibility());
    }

    static boolean isCompleteVisibility(int i2) {
        return i2 == 1 || i2 == 3;
    }

    public void addNotification(AbsNotificationItem absNotificationItem) {
        if (absNotificationItem == null) {
            return;
        }
        synchronized (this.notificationItemArray) {
            this.notificationItemArray.put(absNotificationItem.getId(), absNotificationItem);
        }
    }

    public void cancel(int i2) {
        Context appContext = DownloadComponentManager.getAppContext();
        if (appContext == null || i2 == 0) {
            return;
        }
        try {
            Intent intent = new Intent(appContext, (Class<?>) DownloadNotificationService.class);
            intent.setAction(NotificationConstants.ACTION_NOTIFICATION_CANCEL);
            intent.putExtra(NotificationConstants.EXTRA_NOTIFICATION_ID, i2);
            appContext.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    void cancelCompleteNotification(DownloadInfo downloadInfo) {
        if (isCompleteAndVisible(downloadInfo)) {
            cancelNotification(downloadInfo.getId());
        }
    }

    public void cancelNotification(int i2) {
        removeNotification(i2);
        if (i2 != 0) {
            getInstance().cancel(i2);
        }
    }

    public void clearNotification() {
        SparseArray<AbsNotificationItem> clone;
        synchronized (this.notificationItemArray) {
            clone = this.notificationItemArray.clone();
            this.notificationItemArray.clear();
        }
        for (int i2 = 0; i2 < clone.size(); i2++) {
            clone.get(clone.keyAt(i2)).cancel();
        }
    }

    SparseArray<AbsNotificationItem> getAllNotificationItems() {
        SparseArray<AbsNotificationItem> sparseArray;
        synchronized (this.notificationItemArray) {
            sparseArray = this.notificationItemArray;
        }
        return sparseArray;
    }

    public AbsNotificationItem getNotificationItem(int i2) {
        AbsNotificationItem absNotificationItem;
        if (i2 == 0) {
            return null;
        }
        synchronized (this.notificationItemArray) {
            absNotificationItem = this.notificationItemArray.get(i2);
        }
        return absNotificationItem;
    }

    public void hideNotification(int i2) {
        DownloadInfo downloadInfo = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(i2);
        if (downloadInfo == null) {
            return;
        }
        updateNotificationState(downloadInfo);
        cancelCompleteNotification(downloadInfo);
    }

    public void notifyByService(int i2, int i3, Notification notification) {
        Context appContext = DownloadComponentManager.getAppContext();
        if (appContext == null || i2 == 0 || notification == null) {
            return;
        }
        if (i3 == 4) {
            synchronized (this.PROGRESS_NOTIFY_LAST_TIME_INFO) {
                Long l = this.PROGRESS_NOTIFY_LAST_TIME_INFO.get(Integer.valueOf(i2));
                long currentTimeMillis = System.currentTimeMillis();
                if (l != null && Math.abs(currentTimeMillis - l.longValue()) < 1000) {
                    return;
                } else {
                    this.PROGRESS_NOTIFY_LAST_TIME_INFO.put(Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
                }
            }
        }
        try {
            Intent intent = new Intent(appContext, (Class<?>) DownloadNotificationService.class);
            intent.setAction(NotificationConstants.ACTION_NOTIFICATION_NOTIFY);
            intent.putExtra(NotificationConstants.EXTRA_NOTIFICATION_STATUS, i3);
            intent.putExtra(NotificationConstants.EXTRA_NOTIFICATION_ID, i2);
            intent.putExtra(NotificationConstants.EXTRA_NOTIFICATION, notification);
            appContext.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public AbsNotificationItem removeNotification(int i2) {
        AbsNotificationItem absNotificationItem;
        if (i2 == 0) {
            return null;
        }
        synchronized (this.notificationItemArray) {
            absNotificationItem = this.notificationItemArray.get(i2);
            if (absNotificationItem != null) {
                this.notificationItemArray.remove(i2);
                Logger.d("removeNotificationId " + i2);
            }
        }
        return absNotificationItem;
    }

    void updateNotificationState(DownloadInfo downloadInfo) {
        IDownloadCache downloadCache = DownloadComponentManager.getDownloadCache();
        if (downloadCache != null && downloadInfo.isDownloadOverStatus()) {
            downloadInfo.setNotificationVisibility(3);
            try {
                downloadCache.updateDownloadInfo(downloadInfo);
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
        }
    }
}
