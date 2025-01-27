package com.vivo.ic.dm;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.Downloads;
import com.vivo.ic.dm.impl.DownloadNotification;
import com.vivo.ic.dm.util.KeepAliveService;
import java.util.Collection;

/* loaded from: classes4.dex */
public abstract class DownloadNotifier extends a implements DownloadNotification {
    public static final String TAG = Constants.PRE_TAG + "DownloadNotifier";
    private NotificationItem mLastNotiItem;
    private volatile NotificationCallback mNotificationCallback;
    private final NotificationManager mNotificationManager;
    private boolean mIsNotifyWarn = false;
    private long mLastNotifyTime = 0;
    private volatile boolean mIsKeepAlive = false;
    private Object mKeepAliveLock = new Object();

    public interface NotificationCallback {
        void cancelDownloading(int i2);
    }

    public static class NotificationItem {
        String mDescription;
        int mId;
        String mTitle;
        int mTitleCount = 0;
        long mTotalCurrent = 0;
        long mTotalTotal = 0;
    }

    public DownloadNotifier(Context context) {
        this.mContext = context;
        this.mRes = context.getResources();
        this.mNotificationManager = (NotificationManager) this.mContext.getSystemService("notification");
    }

    private void cancelDownloading() {
        setKeepAlive(false);
        if (this.mNotificationCallback != null) {
            this.mNotificationCallback.cancelDownloading(getNotiIdDownloading());
        }
    }

    private boolean checkDownloadingNotify() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (Math.abs(elapsedRealtime - this.mLastNotifyTime) < l.j().i()) {
            return false;
        }
        this.mLastNotifyTime = elapsedRealtime;
        return true;
    }

    private void notifyDownloading(Notification notification) {
        synchronized (this.mKeepAliveLock) {
            if (!this.mIsKeepAlive) {
                this.mIsKeepAlive = true;
                KeepAliveService.a(this.mContext, getNotiIdDownloading(), notification);
            }
        }
    }

    private void setCompleteNotificationShown(DownloadInfo downloadInfo) {
        if (downloadInfo.isCompleteShown()) {
            return;
        }
        Uri withAppendedId = ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, downloadInfo.getId());
        ContentValues contentValues = new ContentValues();
        contentValues.put(Downloads.Column.COMPLETE_NOTIFICATION_SHOWN, (Integer) 1);
        try {
            this.mContext.getContentResolver().update(withAppendedId, contentValues, null, null);
        } catch (Exception unused) {
        }
    }

    public String buildPercentageLabel(Context context, long j2, long j3) {
        if (j2 <= 0) {
            return "0%";
        }
        return ((int) ((j3 * 100) / j2)) + "%";
    }

    @Override // com.vivo.ic.dm.impl.DownloadNotification
    public void cancelAllNotification(int i2) {
        VLog.i(TAG, "cancelAllNotification id:" + i2);
        NotificationManager notificationManager = this.mNotificationManager;
        if (notificationManager != null) {
            notificationManager.cancel(getNotiIdDownloading());
            this.mNotificationManager.cancel(getNotiIdDownloadFinished(i2));
            hideNetPauseNotification();
        }
    }

    public NotificationItem getActiveNotificationItem(Collection<DownloadInfo> collection) {
        NotificationItem notificationItem = null;
        for (DownloadInfo downloadInfo : collection) {
            if (isActiveAndVisible(downloadInfo)) {
                long totalBytes = downloadInfo.getTotalBytes();
                long currentBytes = downloadInfo.getCurrentBytes();
                long id = downloadInfo.getId();
                String title = downloadInfo.getTitle();
                if (TextUtils.isEmpty(title)) {
                    title = getStringUnknownTitle();
                }
                if (notificationItem == null) {
                    notificationItem = new NotificationItem();
                    notificationItem.mId = (int) id;
                    notificationItem.mDescription = downloadInfo.getDescription();
                    notificationItem.mTotalCurrent = currentBytes;
                    notificationItem.mTotalTotal = totalBytes;
                    notificationItem.mTitle = title;
                }
                notificationItem.mTitleCount++;
            } else {
                VLog.d(TAG, "getActiveNotificationItem isActiveAndVisible false");
            }
        }
        return notificationItem;
    }

    @Override // com.vivo.ic.dm.a
    public /* bridge */ /* synthetic */ Bitmap getLargeIconDownloadFailed() {
        return super.getLargeIconDownloadFailed();
    }

    @Override // com.vivo.ic.dm.a
    public /* bridge */ /* synthetic */ Bitmap getLargeIconDownloadSuccess() {
        return super.getLargeIconDownloadSuccess();
    }

    @Override // com.vivo.ic.dm.a
    public /* bridge */ /* synthetic */ Bitmap getLargeIconDownloading() {
        return super.getLargeIconDownloading();
    }

    @Override // com.vivo.ic.dm.a
    public /* bridge */ /* synthetic */ Bitmap getLargeIconIdDownloadWarn() {
        return super.getLargeIconIdDownloadWarn();
    }

    @Override // com.vivo.ic.dm.a
    public /* bridge */ /* synthetic */ String getNotificationChannel() {
        return super.getNotificationChannel();
    }

    @Override // com.vivo.ic.dm.a
    public /* bridge */ /* synthetic */ String[] getNotificationChannels() {
        return super.getNotificationChannels();
    }

    @Override // com.vivo.ic.dm.a
    public /* bridge */ /* synthetic */ Bundle getNotificationExtrasDownloadFailed() {
        return super.getNotificationExtrasDownloadFailed();
    }

    @Override // com.vivo.ic.dm.a
    public /* bridge */ /* synthetic */ Bundle getNotificationExtrasDownloadSuccess() {
        return super.getNotificationExtrasDownloadSuccess();
    }

    @Override // com.vivo.ic.dm.a
    public /* bridge */ /* synthetic */ Bundle getNotificationExtrasDownloadWarn() {
        return super.getNotificationExtrasDownloadWarn();
    }

    @Override // com.vivo.ic.dm.a
    public /* bridge */ /* synthetic */ Bundle getNotificationExtrasDownloading() {
        return super.getNotificationExtrasDownloading();
    }

    protected String getPercentInfo(int i2) {
        return i2 + "%";
    }

    @Override // com.vivo.ic.dm.impl.DownloadNotification
    public void hideNetPauseNotification() {
        NotificationManager notificationManager = this.mNotificationManager;
        if (notificationManager == null || !this.mIsNotifyWarn) {
            return;
        }
        notificationManager.cancel(getNotiIdDownloadWarn());
        this.mIsNotifyWarn = false;
    }

    public boolean isActiveAndVisible(DownloadInfo downloadInfo) {
        return (downloadInfo.getStatus() < 100 || downloadInfo.getStatus() >= 200 || downloadInfo.getStatus() == 198 || downloadInfo.getVisibility() == 3 || downloadInfo.getVisibility() == 2 || downloadInfo.getControl() == 1) ? false : true;
    }

    public boolean isCompleteAndVisible(DownloadInfo downloadInfo) {
        return ((downloadInfo.getStatus() < 200 && downloadInfo.getStatus() != 198) || downloadInfo.getVisibility() == 3 || downloadInfo.getVisibility() == 1 || downloadInfo.getStatus() == 2000) ? false : true;
    }

    public boolean isKeepAlive() {
        return this.mIsKeepAlive;
    }

    @TargetApi(19)
    public void postActiveNotification(NotificationItem notificationItem) {
        String str = TAG;
        VLog.d(str, "postActiveNotification NotificationItem:" + notificationItem.toString());
        Notification.Builder createNotificationBuilder = createNotificationBuilder(0);
        int iconIdDownloading = getIconIdDownloading();
        createNotificationBuilder.setOnlyAlertOnce(true);
        createNotificationBuilder.setSmallIcon(iconIdDownloading).setLargeIcon(getLargeIconDownloading()).setOngoing(true);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            createNotificationBuilder.setExtras(getNotificationExtrasDownloading());
        }
        if (!TextUtils.isEmpty(notificationItem.mDescription)) {
            createNotificationBuilder.setContentText(notificationItem.mDescription);
        }
        Uri withAppendedId = ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, notificationItem.mId);
        int i3 = notificationItem.mTitleCount;
        if (i3 > 1) {
            createNotificationBuilder.setContentTitle(getStringMultiDownloading(i3));
            if (i2 > 23) {
                createNotificationBuilder.setShowWhen(true);
            }
            createNotificationBuilder.setContentIntent(PendingIntent.getBroadcast(this.mContext, 0, new Intent(Downloads.Action.NOTI_DOWNLOAD_CLICKED, withAppendedId, this.mContext, DownloadReceiver.class), com.vivo.ic.dm.util.d.b(0)));
            hideNetPauseNotification();
            if (checkDownloadingNotify()) {
                this.mNotificationManager.notify(10000, createNotificationBuilder.getNotification());
                return;
            }
            return;
        }
        String str2 = notificationItem.mTitle;
        long j2 = notificationItem.mTotalTotal;
        if (j2 != -1) {
            long j3 = notificationItem.mTotalCurrent;
            if (j2 < j3) {
                notificationItem.mTotalTotal = j3;
                VLog.w(str, "updateActiveNotification: mTotalCurrent is: " + notificationItem.mTotalCurrent + " more than mTotalTotal: " + notificationItem.mTotalTotal + " and set to same");
            }
        }
        long j4 = notificationItem.mTotalTotal;
        int i4 = j4 != -1 ? (int) ((notificationItem.mTotalCurrent * 100.0f) / j4) : 0;
        createNotificationBuilder.setProgress(100, i4, j4 == -1);
        String percentInfo = getPercentInfo(i4);
        if (i2 > 23) {
            createNotificationBuilder.setShowWhen(true);
            if (!TextUtils.isEmpty(percentInfo)) {
                createNotificationBuilder.setSubText(percentInfo);
            }
        }
        if (!TextUtils.isEmpty(percentInfo)) {
            createNotificationBuilder.setContentInfo(percentInfo);
        }
        createNotificationBuilder.setContentTitle(str2);
        createNotificationBuilder.setContentIntent(PendingIntent.getBroadcast(this.mContext, 0, new Intent(Downloads.Action.NOTI_DOWNLOAD_CLICKED, withAppendedId, this.mContext, DownloadReceiver.class), com.vivo.ic.dm.util.d.b(0)));
        hideNetPauseNotification();
        Notification notification = createNotificationBuilder.getNotification();
        this.mNotificationManager.notify(getNotiIdDownloading(), notification);
        notifyDownloading(notification);
    }

    public void postCompleteNotification(DownloadInfo downloadInfo) {
        String stringDownloadSuccess;
        Bitmap largeIconDownloadSuccess;
        Bundle notificationExtrasDownloadSuccess;
        if (!isCompleteAndVisible(downloadInfo)) {
            VLog.d(TAG, "postCompleteNotification cancel " + downloadInfo.getId() + " ; status = " + downloadInfo.getStatus() + " ; visibility = " + downloadInfo.getVisibility());
            this.mNotificationManager.cancel(getNotiIdDownloadFinished((int) downloadInfo.getId()));
            return;
        }
        VLog.d(TAG, "postCompleteNotification show " + downloadInfo.getId() + " ; status = " + downloadInfo.getStatus() + " ; visibility = " + downloadInfo.getVisibility());
        String title = downloadInfo.getTitle();
        long id = downloadInfo.getId();
        int status = downloadInfo.getStatus();
        long lastMod = downloadInfo.getLastMod();
        Notification.Builder createNotificationBuilder = createNotificationBuilder(1);
        if (title == null || title.length() == 0) {
            title = getStringUnknownTitle();
        }
        Uri withAppendedId = ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, id);
        if (Downloads.Impl.isStatusError(status)) {
            createNotificationBuilder.setSmallIcon(getIconIdDownloadFailed());
            stringDownloadSuccess = getStringDownloadFailed();
            largeIconDownloadSuccess = getLargeIconDownloadFailed();
            notificationExtrasDownloadSuccess = getNotificationExtrasDownloadFailed();
        } else {
            createNotificationBuilder.setSmallIcon(getIconIdDownloadSuccess());
            stringDownloadSuccess = getStringDownloadSuccess();
            largeIconDownloadSuccess = getLargeIconDownloadSuccess();
            notificationExtrasDownloadSuccess = getNotificationExtrasDownloadSuccess();
        }
        createNotificationBuilder.setLargeIcon(largeIconDownloadSuccess).setWhen(lastMod).setContentTitle(title).setContentText(stringDownloadSuccess).setTicker(title);
        if (notificationExtrasDownloadSuccess != null && Build.VERSION.SDK_INT >= 19) {
            createNotificationBuilder.setExtras(notificationExtrasDownloadSuccess);
        }
        if (Build.VERSION.SDK_INT > 23) {
            createNotificationBuilder.setShowWhen(true);
        }
        createNotificationBuilder.setContentIntent(PendingIntent.getBroadcast(this.mContext, 0, new Intent(Downloads.Action.NOTI_COMPLETE_CLICKED, withAppendedId, this.mContext, DownloadReceiver.class), com.vivo.ic.dm.util.d.b(0)));
        createNotificationBuilder.setDeleteIntent(PendingIntent.getBroadcast(this.mContext, 0, new Intent(Downloads.Action.NOTI_HIDE, withAppendedId, this.mContext, DownloadReceiver.class), com.vivo.ic.dm.util.d.b(0)));
        Notification notification = createNotificationBuilder.getNotification();
        notification.flags |= 16;
        this.mNotificationManager.cancel(getNotiIdDownloading());
        this.mNotificationManager.notify(getNotiIdDownloadFinished((int) id), notification);
        setCompleteNotificationShown(downloadInfo);
    }

    public void setKeepAlive(boolean z) {
        synchronized (this.mKeepAliveLock) {
            this.mIsKeepAlive = z;
        }
    }

    public void setNotificationCallback(NotificationCallback notificationCallback) {
        this.mNotificationCallback = notificationCallback;
    }

    @Override // com.vivo.ic.dm.impl.DownloadNotification
    public void showNetPauseNotification() {
        VLog.i(TAG, "showNetPauseNotification");
        PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, 0, new Intent(Downloads.Action.NOTI_CONFIRM, null, this.mContext, DownloadReceiver.class), com.vivo.ic.dm.util.d.b(0));
        Notification.Builder createNotificationBuilder = createNotificationBuilder(1);
        createNotificationBuilder.setSmallIcon(getIconIdDownloadWarn()).setLargeIcon(getLargeIconIdDownloadWarn()).setContentText(getStringDownloadWarnContent()).setContentTitle(getStringDownloadWarnTitle()).setContentIntent(broadcast).setTicker(getStringDownloadWarnTitle());
        if (Build.VERSION.SDK_INT >= 19) {
            createNotificationBuilder.setExtras(getNotificationExtrasDownloadWarn());
        }
        Notification notification = createNotificationBuilder.getNotification();
        notification.flags |= 16;
        NotificationManager notificationManager = this.mNotificationManager;
        if (notificationManager != null) {
            notificationManager.notify(getNotiIdDownloadWarn(), notification);
            this.mIsNotifyWarn = true;
        }
    }

    public void updateActiveNotification(Collection<DownloadInfo> collection) {
        NotificationItem activeNotificationItem = getActiveNotificationItem(collection);
        NotificationItem notificationItem = this.mLastNotiItem;
        if (notificationItem != null && (activeNotificationItem == null || activeNotificationItem.mId != notificationItem.mId)) {
            this.mNotificationManager.cancel(getNotiIdDownloading());
        }
        if (activeNotificationItem == null) {
            cancelDownloading();
        } else {
            this.mLastNotiItem = activeNotificationItem;
            postActiveNotification(activeNotificationItem);
        }
    }

    public void updateCompletedNotification(Collection<DownloadInfo> collection) {
        for (DownloadInfo downloadInfo : collection) {
            if (!downloadInfo.isCompleteShown()) {
                postCompleteNotification(downloadInfo);
            }
        }
    }

    @Override // com.vivo.ic.dm.impl.DownloadNotification
    public void updateWith(Collection<DownloadInfo> collection) {
        updateActiveNotification(collection);
        updateCompletedNotification(collection);
    }
}
