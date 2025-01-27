package com.baidu.mobads.sdk.api;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.DrawableRes;
import androidx.core.app.NotificationCompat;
import com.baidu.mobads.proxy.R;
import com.baidu.mobads.sdk.internal.bm;

/* loaded from: classes2.dex */
public class CustomNotification {
    private static String mChannel = "down";

    @DrawableRes
    private static int mSmallIcon = 17301634;
    private NotificationCompat.Style mStyle = new NotificationCompat.DecoratedCustomViewStyle();

    public static void initNotification(@DrawableRes int i10, String str) {
        mSmallIcon = i10;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        mChannel = str;
    }

    public static void setNotificationChannel(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        mChannel = str;
    }

    public static void setNotificationIcon(@DrawableRes int i10) {
        mSmallIcon = i10;
    }

    private void setRemoteViewText(RemoteViews remoteViews, int i10, String str) {
        if (remoteViews != null) {
            if (TextUtils.isEmpty(str)) {
                remoteViews.setViewVisibility(i10, 8);
            } else {
                remoteViews.setTextViewText(i10, str);
                remoteViews.setViewVisibility(i10, 0);
            }
        }
    }

    @TargetApi(16)
    public Notification getCustomNotification(Context context, String str, String str2, Bitmap bitmap, String str3, String str4, String str5, boolean z10, int i10, int i11, String str6, PendingIntent pendingIntent) {
        NotificationCompat.Builder builder;
        if (bm.a(context).a() < 26) {
            builder = new NotificationCompat.Builder(context);
        } else {
            if (TextUtils.isEmpty(str)) {
                str = "down";
            }
            try {
                builder = new NotificationCompat.Builder(context, str);
            } catch (NoSuchMethodError unused) {
                builder = new NotificationCompat.Builder(context);
            }
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.mobads_cutom_notification_layout);
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(R.id.left_icon, bitmap);
        } else {
            remoteViews.setImageViewResource(R.id.left_icon, R.drawable.ic_stat_bd_notif_download);
        }
        setRemoteViewText(remoteViews, R.id.notification_title, str3);
        if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5)) {
            remoteViews.setViewVisibility(R.id.content_layout, 8);
        } else {
            remoteViews.setViewVisibility(R.id.content_layout, 0);
            setRemoteViewText(remoteViews, R.id.content_text, str4);
            setRemoteViewText(remoteViews, R.id.content_status, str5);
        }
        if (i10 < 0 || i10 > 100) {
            remoteViews.setViewVisibility(R.id.progress_bar, 8);
        } else {
            remoteViews.setProgressBar(R.id.progress_bar, 100, i10, false);
            remoteViews.setViewVisibility(R.id.progress_bar, 0);
        }
        remoteViews.setTextViewText(R.id.btn_action, str6);
        remoteViews.setOnClickPendingIntent(R.id.btn_action, pendingIntent);
        return builder.setSmallIcon(i11).setOngoing(false).setTicker(str2).setAutoCancel(z10).setWhen(System.currentTimeMillis()).setCustomContentView(remoteViews).build();
    }

    @TargetApi(16)
    public Notification getNewNotification(Context context, String str, boolean z10, Bitmap bitmap, String str2, String str3, int i10, boolean z11, String str4, PendingIntent pendingIntent, String str5, PendingIntent pendingIntent2) {
        NotificationCompat.Builder builder;
        if (bm.a(context).a() < 26) {
            builder = new NotificationCompat.Builder(context);
        } else {
            try {
                builder = new NotificationCompat.Builder(context, mChannel);
            } catch (NoSuchMethodError unused) {
                builder = new NotificationCompat.Builder(context);
            }
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.baidu_mobads_notification_layout);
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(R.id.icon, bitmap);
        } else {
            remoteViews.setImageViewResource(R.id.icon, R.drawable.ic_stat_bd_notif_download);
        }
        setRemoteViewText(remoteViews, R.id.title, str2);
        setRemoteViewText(remoteViews, R.id.desc, str3);
        if (i10 < 0 || i10 > 100) {
            remoteViews.setViewVisibility(R.id.progress, 8);
        } else {
            remoteViews.setProgressBar(R.id.progress, 100, i10, z11);
            remoteViews.setViewVisibility(R.id.progress, 0);
        }
        remoteViews.setTextViewText(R.id.button1, str4);
        remoteViews.setOnClickPendingIntent(R.id.button1, pendingIntent);
        if (TextUtils.isEmpty(str5)) {
            remoteViews.setViewVisibility(R.id.button2, 8);
        } else {
            remoteViews.setViewVisibility(R.id.button2, 0);
            remoteViews.setTextViewText(R.id.button2, str5);
            remoteViews.setOnClickPendingIntent(R.id.button2, pendingIntent2);
        }
        return builder.setStyle(this.mStyle).setSmallIcon(mSmallIcon).setOngoing(false).setTicker(str).setAutoCancel(z10).setWhen(System.currentTimeMillis()).setCustomContentView(remoteViews).build();
    }
}
