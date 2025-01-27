package com.sigmob.sdk.downloader;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RemoteViews;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.czhj.sdk.logger.SigmobLog;
import q.s2;
import q.t2;
import q.z;

/* loaded from: classes4.dex */
public class h extends com.sigmob.sdk.downloader.core.listener.c {

    /* renamed from: b */
    public Notification.Builder f19430b;

    /* renamed from: c */
    public NotificationManager f19431c;

    /* renamed from: d */
    public RemoteViews f19432d;

    /* renamed from: e */
    public Context f19433e;

    public class a implements ImageManager.BitmapLoadedListener {
        public a() {
        }

        @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
        public void onBitmapLoadFailed() {
        }

        @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
        public void onBitmapLoaded(Bitmap bitmap) {
            h.this.f19432d.setImageViewBitmap(ResourceUtil.getId(h.this.f19433e, "sig_download_notification_icon"), bitmap);
        }
    }

    public h(Context context) {
        this.f19433e = context.getApplicationContext();
        this.f19432d = new RemoteViews(context.getPackageName(), ResourceUtil.getLayoutId(context, "sig_download_notification_layout"));
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.a.InterfaceC0590a
    public void a(f fVar, com.sigmob.sdk.downloader.core.cause.b bVar) {
    }

    @Override // com.sigmob.sdk.downloader.core.listener.c
    public void c(f fVar) {
        if (!fVar.z().renameTo(fVar.j())) {
            SigmobLog.e("download temp file renameTo failed");
        }
        SigmobLog.d("FileDownloaderNotificationListener completed ");
        this.f19432d.setTextViewText(ResourceUtil.getId(this.f19433e, "sig_download_notification_speed"), "下载完成,立即安装");
        this.f19432d.setViewVisibility(ResourceUtil.getId(this.f19433e, "sig_download_notification_button"), 4);
        this.f19432d.setViewVisibility(ResourceUtil.getId(this.f19433e, "sig_download_notification_status"), 8);
        this.f19430b.setOngoing(false);
        this.f19430b.setAutoCancel(true);
        this.f19431c.notify(fVar.b(), this.f19430b.build());
    }

    @Override // com.sigmob.sdk.downloader.core.listener.c
    public void d(f fVar) {
        this.f19432d.setTextViewText(ResourceUtil.getId(this.f19433e, "sig_download_notification_status"), "准备下载");
        this.f19432d.setTextViewText(ResourceUtil.getId(this.f19433e, "sig_download_notification_button"), "暂停");
        this.f19432d.setViewVisibility(ResourceUtil.getId(this.f19433e, "sig_download_notification_button"), 0);
        this.f19431c.notify(fVar.b(), this.f19430b.build());
    }

    @Override // com.sigmob.sdk.downloader.core.listener.c
    public void e(f fVar) {
    }

    @Override // com.sigmob.sdk.downloader.core.listener.c
    public void b(f fVar) {
        this.f19432d.setTextViewText(ResourceUtil.getId(this.f19433e, "sig_download_notification_status"), "下载暂停");
        this.f19432d.setTextViewText(ResourceUtil.getId(this.f19433e, "sig_download_notification_button"), "继续");
        this.f19432d.setViewVisibility(ResourceUtil.getId(this.f19433e, "sig_download_notification_button"), 0);
        this.f19431c.notify(fVar.b(), this.f19430b.build());
    }

    public void a(f fVar, int i10, long j10, long j11) {
        StringBuilder sb2;
        String str;
        RemoteViews remoteViews = this.f19432d;
        int id2 = ResourceUtil.getId(this.f19433e, "sig_download_notification_speed");
        if (j10 > 1048576) {
            sb2 = new StringBuilder();
            sb2.append((j10 / 1024) / 1024);
            str = "M/";
        } else {
            sb2 = new StringBuilder();
            sb2.append(j10 / 1024);
            str = "KB/";
        }
        sb2.append(str);
        sb2.append((j11 / 1024) / 1024);
        sb2.append("M");
        remoteViews.setTextViewText(id2, sb2.toString());
        this.f19432d.setTextViewText(ResourceUtil.getId(this.f19433e, "sig_download_notification_status"), "正在下载");
        this.f19432d.setViewVisibility(ResourceUtil.getId(this.f19433e, "sig_download_notification_button"), 0);
        this.f19431c.notify(fVar.b(), this.f19430b.build());
    }

    public void b(PendingIntent pendingIntent) {
        this.f19430b.setContentIntent(pendingIntent);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.c
    public void a(f fVar, Exception exc) {
        this.f19432d.setTextViewText(ResourceUtil.getId(this.f19433e, "sig_download_notification_status"), "下载失败");
        this.f19432d.setTextViewText(ResourceUtil.getId(this.f19433e, "sig_download_notification_button"), "重试");
        this.f19432d.setViewVisibility(ResourceUtil.getId(this.f19433e, "sig_download_notification_button"), 0);
        this.f19431c.notify(fVar.b(), this.f19430b.build());
    }

    public void a(String str, String str2, String str3) {
        Notification.Builder builder;
        this.f19431c = (NotificationManager) this.f19433e.getSystemService("notification");
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            this.f19431c.createNotificationChannel(z.a("sig_filedownloader_notification", "sig_filedownloader", 1));
        }
        if (i10 >= 26) {
            t2.a();
            builder = s2.a(this.f19433e, "sig_filedownloader_notification");
        } else {
            builder = new Notification.Builder(this.f19433e);
        }
        this.f19430b = builder;
        this.f19432d.setTextViewText(ResourceUtil.getId(this.f19433e, "sig_download_notification_title"), str2);
        if (!TextUtils.isEmpty(str)) {
            try {
                com.sigmob.sdk.base.common.h.o().getBitmap(str, new a());
            } catch (Throwable unused) {
            }
        }
        this.f19432d.setProgressBar(ResourceUtil.getId(this.f19433e, "sig_download_notification_progress"), 100, 0, false);
        this.f19432d.setTextViewText(ResourceUtil.getId(this.f19433e, "sig_download_notification_speed"), "0M/0M");
        this.f19432d.setTextViewText(ResourceUtil.getId(this.f19433e, "sig_download_notification_status"), "等待开始");
        this.f19432d.setViewVisibility(ResourceUtil.getId(this.f19433e, "sig_download_notification_button"), 0);
        this.f19430b.setDefaults(4).setOngoing(true).setSmallIcon(this.f19433e.getApplicationInfo().icon).setPriority(0);
        if (Build.VERSION.SDK_INT >= 24) {
            this.f19430b.setCustomContentView(this.f19432d);
        } else {
            this.f19430b.setContent(this.f19432d);
        }
    }

    public void a(f fVar, long j10, long j11) {
        StringBuilder sb2;
        String str;
        Log.d("NotificationActivity", "progress " + j10);
        RemoteViews remoteViews = this.f19432d;
        int id2 = ResourceUtil.getId(this.f19433e, "sig_download_notification_speed");
        if (j10 > 1048576) {
            sb2 = new StringBuilder();
            sb2.append((j10 / 1024) / 1024);
            str = "M/";
        } else {
            sb2 = new StringBuilder();
            sb2.append(j10 / 1024);
            str = "KB/";
        }
        sb2.append(str);
        sb2.append((j11 / 1024) / 1024);
        sb2.append("M");
        remoteViews.setTextViewText(id2, sb2.toString());
        if (j11 > 0) {
            this.f19432d.setProgressBar(ResourceUtil.getId(this.f19433e, "sig_download_notification_progressBar"), 100, (int) ((j10 * 100) / j11), false);
        }
        this.f19432d.setViewVisibility(ResourceUtil.getId(this.f19433e, "sig_download_notification_button"), 0);
        this.f19431c.notify(fVar.b(), this.f19430b.build());
    }

    public void a(PendingIntent pendingIntent) {
        this.f19432d.setOnClickPendingIntent(ResourceUtil.getId(this.f19433e, "sig_download_notification_button"), pendingIntent);
    }
}
