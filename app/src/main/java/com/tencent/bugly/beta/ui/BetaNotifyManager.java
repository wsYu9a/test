package com.tencent.bugly.beta.ui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.a;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.proguard.B;
import com.tencent.bugly.proguard.C0920y;
import com.tencent.bugly.proguard.X;
import java.util.Locale;

/* loaded from: classes4.dex */
public class BetaNotifyManager {
    private static final String CHANNEL_DESCRIPTION = "bugly upgrade";
    private static final String CHANNEL_ID = "001";
    private static final String CHANNEL_NAME = "bugly_upgrade";
    private static final int NOTIFICATION_DOWNLOAD_ID = 1000;
    private static final int NOTIFICATION_UPGRADE_ID = 1001;
    private static final long NOTIFY_LEN = 307200;
    public static final int REQUEST_CODE_DOWNLOAD = 1;
    public static final int REQUEST_CODE_UPGRADE = 2;
    public static BetaNotifyManager instance = new BetaNotifyManager();
    public BaseFrag fragment;
    private long lastLen;
    private NotificationCompat.Builder mBuilder;
    private Notification mNotification;
    public B strategy;
    public DownloadTask task;
    private boolean hasNotification = true;
    private Context mContext = e.f24621b.v;
    public String intentFilter = this.mContext.getPackageName() + ".beta.DOWNLOAD_NOTIFY";
    private NotificationManager mManager = (NotificationManager) this.mContext.getSystemService("notification");

    private BetaNotifyManager() {
        this.mContext.registerReceiver(new BetaReceiver(), new IntentFilter(this.intentFilter));
        adaptNotificationChannel();
    }

    private void adaptNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, 2);
            notificationChannel.setDescription(CHANNEL_DESCRIPTION);
            notificationChannel.enableVibration(false);
            notificationChannel.setVibrationPattern(new long[]{0});
            this.mManager.createNotificationChannel(notificationChannel);
        }
    }

    public void initNotify(DownloadTask downloadTask) {
        ApplicationInfo applicationInfo;
        this.task = downloadTask;
        this.lastLen = downloadTask.getSavedLength();
        boolean isNeededNotify = downloadTask.isNeededNotify();
        this.hasNotification = isNeededNotify;
        if (isNeededNotify && e.f24621b.T) {
            this.mManager.cancel(1000);
            Intent intent = new Intent(this.intentFilter);
            intent.putExtra("request", 1);
            if (this.mBuilder == null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    try {
                        this.mBuilder = new NotificationCompat.Builder(this.mContext, CHANNEL_ID);
                    } catch (Throwable unused) {
                        this.mBuilder = new NotificationCompat.Builder(this.mContext);
                    }
                } else {
                    this.mBuilder = new NotificationCompat.Builder(this.mContext);
                }
            }
            NotificationCompat.Builder contentTitle = this.mBuilder.setTicker(Beta.strNotificationDownloading + e.f24621b.B).setContentTitle(e.f24621b.B);
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[2];
            objArr[0] = Beta.strNotificationDownloading;
            objArr[1] = Integer.valueOf((int) (this.task.getTotalLength() != 0 ? (this.task.getSavedLength() * 100) / this.task.getTotalLength() : 0L));
            contentTitle.setContentText(String.format(locale, "%s %d%%", objArr)).setContentIntent(PendingIntent.getBroadcast(this.mContext, 1, intent, DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP)).setAutoCancel(false);
            e eVar = e.f24621b;
            int i2 = eVar.f24628i;
            if (i2 > 0) {
                this.mBuilder.setSmallIcon(i2);
            } else {
                PackageInfo packageInfo = eVar.C;
                if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                    this.mBuilder.setSmallIcon(applicationInfo.icon);
                }
            }
            try {
                if (e.f24621b.f24629j > 0 && this.mContext.getResources().getDrawable(e.f24621b.f24629j) != null) {
                    this.mBuilder.setLargeIcon(a.a(this.mContext.getResources().getDrawable(e.f24621b.f24629j)));
                }
            } catch (Resources.NotFoundException e2) {
                X.b(BetaNotifyManager.class, "[initNotify] " + e2.getMessage(), new Object[0]);
            }
            Notification build = this.mBuilder.build();
            this.mNotification = build;
            this.mManager.notify(1000, build);
        }
    }

    public void postDownloadNotify() {
        DownloadTask downloadTask;
        if (this.hasNotification && (downloadTask = this.task) != null && e.f24621b.T) {
            if (downloadTask.getSavedLength() - this.lastLen > NOTIFY_LEN || this.task.getStatus() == 1 || this.task.getStatus() == 5 || this.task.getStatus() == 3) {
                this.lastLen = this.task.getSavedLength();
                if (this.task.getStatus() == 1) {
                    this.mBuilder.setAutoCancel(true).setContentText(Beta.strNotificationClickToInstall).setContentTitle(String.format("%s %s", e.f24621b.B, Beta.strNotificationDownloadSucc));
                } else if (this.task.getStatus() == 5) {
                    this.mBuilder.setAutoCancel(false).setContentText(Beta.strNotificationClickToRetry).setContentTitle(String.format("%s %s", e.f24621b.B, Beta.strNotificationDownloadError));
                } else {
                    if (this.task.getStatus() == 2) {
                        NotificationCompat.Builder contentTitle = this.mBuilder.setContentTitle(e.f24621b.B);
                        Locale locale = Locale.getDefault();
                        Object[] objArr = new Object[2];
                        objArr[0] = Beta.strNotificationDownloading;
                        objArr[1] = Integer.valueOf((int) (this.task.getTotalLength() != 0 ? (this.task.getSavedLength() * 100) / this.task.getTotalLength() : 0L));
                        contentTitle.setContentText(String.format(locale, "%s %d%%", objArr)).setAutoCancel(false);
                    } else if (this.task.getStatus() == 3) {
                        NotificationCompat.Builder contentTitle2 = this.mBuilder.setContentTitle(e.f24621b.B);
                        Locale locale2 = Locale.getDefault();
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = Beta.strNotificationClickToContinue;
                        objArr2[1] = Integer.valueOf((int) (this.task.getTotalLength() != 0 ? (this.task.getSavedLength() * 100) / this.task.getTotalLength() : 0L));
                        contentTitle2.setContentText(String.format(locale2, "%s %d%%", objArr2)).setAutoCancel(false);
                    }
                }
                Notification build = this.mBuilder.build();
                this.mNotification = build;
                this.mManager.notify(1000, build);
            }
        }
    }

    public synchronized void postUpgradeNotify(B b2, BaseFrag baseFrag) {
        ApplicationInfo applicationInfo;
        this.strategy = b2;
        this.fragment = baseFrag;
        this.mManager.cancel(1001);
        Intent intent = new Intent(this.intentFilter);
        intent.putExtra("request", 2);
        if (this.mBuilder == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    this.mBuilder = new NotificationCompat.Builder(this.mContext, CHANNEL_ID);
                } catch (Throwable unused) {
                    this.mBuilder = new NotificationCompat.Builder(this.mContext);
                }
            } else {
                this.mBuilder = new NotificationCompat.Builder(this.mContext);
            }
        }
        NotificationCompat.Builder autoCancel = this.mBuilder.setTicker(e.f24621b.B + Beta.strNotificationHaveNewVersion).setContentTitle(String.format("%s %s", e.f24621b.B, Beta.strNotificationHaveNewVersion)).setContentIntent(PendingIntent.getBroadcast(this.mContext, 2, intent, DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP)).setAutoCancel(true);
        C0920y c0920y = b2.f24932j;
        autoCancel.setContentText(String.format("%s.%s", c0920y.f25186e, Integer.valueOf(c0920y.f25185d)));
        e eVar = e.f24621b;
        int i2 = eVar.f24628i;
        if (i2 > 0) {
            this.mBuilder.setSmallIcon(i2);
        } else {
            PackageInfo packageInfo = eVar.C;
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                this.mBuilder.setSmallIcon(applicationInfo.icon);
            }
        }
        if (e.f24621b.f24629j > 0 && this.mContext.getResources().getDrawable(e.f24621b.f24629j) != null) {
            this.mBuilder.setLargeIcon(a.a(this.mContext.getResources().getDrawable(e.f24621b.f24629j)));
        }
        Notification build = this.mBuilder.build();
        this.mNotification = build;
        this.mManager.notify(1001, build);
    }
}
