package com.vivo.ic.dm;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;

/* loaded from: classes4.dex */
abstract class a {
    static final int CHANNEL_TYPE_COMMON = 0;
    static final int CHANNEL_TYPE_FLOAT = 1;
    protected Context mContext;
    protected Resources mRes;

    a() {
    }

    protected final Notification.Builder createNotificationBuilder(int i2) {
        if (Build.VERSION.SDK_INT < 26) {
            return new Notification.Builder(this.mContext);
        }
        String[] notificationChannels = getNotificationChannels();
        String notificationChannel = getNotificationChannel();
        return (notificationChannels == null || notificationChannels.length != 2) ? notificationChannel != null ? new Notification.Builder(this.mContext, notificationChannel) : new Notification.Builder(this.mContext) : i2 == 1 ? new Notification.Builder(this.mContext, notificationChannels[1]) : new Notification.Builder(this.mContext, notificationChannels[0]);
    }

    public abstract int getIconIdDownloadFailed();

    public abstract int getIconIdDownloadSuccess();

    public abstract int getIconIdDownloadWarn();

    public abstract int getIconIdDownloading();

    public Bitmap getLargeIconDownloadFailed() {
        return null;
    }

    public Bitmap getLargeIconDownloadSuccess() {
        return null;
    }

    public Bitmap getLargeIconDownloading() {
        return null;
    }

    public Bitmap getLargeIconIdDownloadWarn() {
        return null;
    }

    public abstract int getNotiIdDownloadFinished(int i2);

    public abstract int getNotiIdDownloadWarn();

    public abstract int getNotiIdDownloading();

    public String getNotificationChannel() {
        return null;
    }

    public String[] getNotificationChannels() {
        return null;
    }

    public Bundle getNotificationExtrasDownloadFailed() {
        return null;
    }

    public Bundle getNotificationExtrasDownloadSuccess() {
        return null;
    }

    public Bundle getNotificationExtrasDownloadWarn() {
        return null;
    }

    public Bundle getNotificationExtrasDownloading() {
        return null;
    }

    public abstract String getStringDownloadFailed();

    public abstract String getStringDownloadSuccess();

    public abstract String getStringDownloadWarnContent();

    public abstract String getStringDownloadWarnTitle();

    public abstract String getStringMultiDownloading(int i2);

    public abstract String getStringUnknownTitle();
}
