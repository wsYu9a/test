package com.martian.ttbook.b.a.i;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;

/* loaded from: classes4.dex */
public class k {

    /* renamed from: a */
    private NotificationCompat.Builder f14996a;

    /* renamed from: b */
    private NotificationManager f14997b;

    /* renamed from: c */
    private String f14998c;

    /* renamed from: d */
    private String f14999d;

    /* renamed from: e */
    private String f15000e;

    /* renamed from: f */
    private PendingIntent f15001f;

    /* renamed from: g */
    private int f15002g;

    /* renamed from: h */
    private int f15003h;

    /* renamed from: i */
    private boolean f15004i;

    public k(Context context, int i2, PendingIntent pendingIntent, String str, String str2, String str3, int i3) {
        this.f14997b = (NotificationManager) context.getSystemService("notification");
        this.f15002g = i2;
        this.f14998c = str2;
        this.f14999d = str3;
        this.f15000e = str;
        this.f15003h = i3;
        this.f15001f = pendingIntent;
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(str, "下载通知", 2);
            try {
                notificationChannel.setSound(null, null);
                notificationChannel.enableVibration(false);
                notificationChannel.enableLights(false);
            } catch (Exception unused) {
            }
            this.f14997b.createNotificationChannel(notificationChannel);
        }
        this.f14996a = new NotificationCompat.Builder(context, str).setWhen(System.currentTimeMillis()).setAutoCancel(false).setOngoing(true).setOnlyAlertOnce(true).setPriority(2);
        i();
        f();
        g();
    }

    private void f() {
        if (TextUtils.isEmpty(this.f14999d)) {
            return;
        }
        this.f14996a.setContentText(this.f14999d);
    }

    private void h() {
        PendingIntent pendingIntent = this.f15001f;
        if (pendingIntent != null) {
            this.f14996a.setContentIntent(pendingIntent);
        }
    }

    private void i() {
        if (TextUtils.isEmpty(this.f14998c)) {
            return;
        }
        this.f14996a.setContentTitle(this.f14998c);
    }

    public void a(int i2) {
        b.d.e.c.a.d.k("DownloadNotification", "show#1 = " + i2);
        i();
        f();
        this.f14996a.setProgress(100, i2, false);
        this.f14997b.notify(this.f15002g, this.f14996a.build());
    }

    public void b(Bitmap bitmap) {
        if (bitmap != null) {
            this.f14996a.setLargeIcon(bitmap);
            this.f14997b.notify(this.f15002g, this.f14996a.build());
            this.f15004i = true;
        }
    }

    public void c(o oVar) {
        b.d.e.c.a.d.k("DownloadNotification", "show#2 enter,downloadState = " + oVar + " , id = " + this.f15002g);
        i();
        if (oVar == o.f15033d) {
            this.f14999d = "已经下载,点击安装!";
            h();
        } else if (oVar == o.f15034e) {
            this.f14996a.setAutoCancel(true);
            this.f14996a.setOngoing(false);
            this.f14999d = "下载失败";
        } else {
            this.f14996a.setProgress(100, 0, true);
        }
        f();
        this.f14997b.notify(this.f15002g, this.f14996a.build());
    }

    public void d(String str) {
        b.d.e.c.a.d.k("DownloadNotification", "show#3 enter");
        this.f14999d = str;
        i();
        f();
        this.f14997b.notify(this.f15002g, this.f14996a.build());
    }

    public boolean e() {
        return this.f15004i;
    }

    public void g() {
        int i2 = this.f15003h;
        if (i2 != 0) {
            this.f14996a.setSmallIcon(i2);
        }
    }

    public void j() {
        this.f14999d = "已经安装,点击启动!";
        this.f14996a.setAutoCancel(true);
        this.f14996a.setOngoing(false);
        h();
        f();
        this.f14997b.notify(this.f15002g, this.f14996a.build());
    }

    public String toString() {
        return "DownloadNotification{builder=" + this.f14996a + ", notificationManager=" + this.f14997b + ", title='" + this.f14998c + "', desc='" + this.f14999d + "', channelId='" + this.f15000e + "', pendingIntent=" + this.f15001f + ", id=" + this.f15002g + ", icon=" + this.f15003h + '}';
    }
}
