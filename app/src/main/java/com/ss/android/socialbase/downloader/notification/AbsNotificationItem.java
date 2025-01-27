package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: classes4.dex */
public abstract class AbsNotificationItem {
    private int clickInstallTimes;
    private long curBytes;
    private String description;
    private long firstShowTime;
    private int id;
    protected Notification notification;
    private boolean ongoing;
    private int status = 0;
    private String title;
    private long totalBytes;

    public AbsNotificationItem(int i2, String str) {
        this.id = i2;
        this.title = str;
    }

    public void cancel() {
        if (this.id == 0) {
            return;
        }
        DownloadNotificationManager.getInstance().cancel(this.id);
    }

    public int getClickInstallTimes() {
        return this.clickInstallTimes;
    }

    public long getCurBytes() {
        return this.curBytes;
    }

    public String getDescription() {
        return this.description;
    }

    public long getFirstShowTime() {
        if (this.firstShowTime == 0) {
            this.firstShowTime = System.currentTimeMillis();
        }
        return this.firstShowTime;
    }

    public int getId() {
        return this.id;
    }

    public Notification getNotification() {
        return this.notification;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public boolean isOngoing() {
        return this.ongoing;
    }

    public void notify(Notification notification) {
        if (this.id == 0 || notification == null) {
            return;
        }
        DownloadNotificationManager.getInstance().notifyByService(this.id, this.status, notification);
    }

    public synchronized void recordClickInstall() {
        this.clickInstallTimes++;
    }

    public void refreshProgress(long j2, long j3) {
        this.curBytes = j2;
        this.totalBytes = j3;
        this.status = 4;
        updateNotification(null, false);
    }

    public void refreshStatus(int i2, BaseException baseException, boolean z) {
        refreshStatus(i2, baseException, z, false);
    }

    public void setCurBytes(long j2) {
        this.curBytes = j2;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    protected void setOngoing(boolean z) {
        this.ongoing = z;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTotalBytes(long j2) {
        this.totalBytes = j2;
    }

    public abstract void updateNotification(BaseException baseException, boolean z);

    public void updateNotificationItem(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.id = downloadInfo.getId();
        this.title = downloadInfo.getTitle();
    }

    public void refreshStatus(int i2, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.status != i2) {
            this.status = i2;
            updateNotification(baseException, z);
        }
    }
}
