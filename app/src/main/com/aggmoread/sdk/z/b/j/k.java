package com.aggmoread.sdk.z.b.j;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import q.z;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a */
    private NotificationCompat.Builder f4597a;

    /* renamed from: b */
    private NotificationManager f4598b;

    /* renamed from: c */
    private String f4599c;

    /* renamed from: d */
    private String f4600d;

    /* renamed from: e */
    private String f4601e;

    /* renamed from: f */
    private PendingIntent f4602f;

    /* renamed from: g */
    private int f4603g;

    /* renamed from: h */
    private int f4604h;

    /* renamed from: i */
    private boolean f4605i;

    public k(Context context, int i10, PendingIntent pendingIntent, String str, String str2, String str3, int i11) {
        this.f4598b = (NotificationManager) context.getSystemService("notification");
        this.f4603g = i10;
        this.f4599c = str2;
        this.f4600d = str3;
        this.f4601e = str;
        this.f4604h = i11;
        this.f4602f = pendingIntent;
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel a10 = z.a(str, "下载通知", 2);
            try {
                a10.setSound(null, null);
                a10.enableVibration(false);
                a10.enableLights(false);
            } catch (Exception unused) {
            }
            this.f4598b.createNotificationChannel(a10);
        }
        this.f4597a = new NotificationCompat.Builder(context, str).setWhen(System.currentTimeMillis()).setAutoCancel(false).setOngoing(true).setOnlyAlertOnce(true).setPriority(2);
        f();
        c();
        d();
    }

    private void c() {
        if (TextUtils.isEmpty(this.f4600d)) {
            return;
        }
        this.f4597a.setContentText(this.f4600d);
    }

    private void e() {
        PendingIntent pendingIntent = this.f4602f;
        if (pendingIntent != null) {
            this.f4597a.setContentIntent(pendingIntent);
        }
    }

    private void f() {
        if (TextUtils.isEmpty(this.f4599c)) {
            return;
        }
        this.f4597a.setContentTitle(this.f4599c);
    }

    public void a() {
        this.f4598b.cancel(this.f4603g);
    }

    public boolean b() {
        return this.f4605i;
    }

    public void d() {
        int i10 = this.f4604h;
        if (i10 != 0) {
            this.f4597a.setSmallIcon(i10);
        }
    }

    public void g() {
        this.f4600d = "已经安装,点击启动!";
        this.f4597a.setAutoCancel(true);
        this.f4597a.setOngoing(false);
        e();
        c();
        this.f4598b.notify(this.f4603g, this.f4597a.build());
    }

    public String toString() {
        return "DownloadNotification{builder=" + this.f4597a + ", notificationManager=" + this.f4598b + ", title='" + this.f4599c + "', desc='" + this.f4600d + "', channelId='" + this.f4601e + "', pendingIntent=" + this.f4602f + ", id=" + this.f4603g + ", icon=" + this.f4604h + '}';
    }

    public void a(int i10) {
        com.aggmoread.sdk.z.b.d.c("DownloadNotification", "show#1 = " + i10);
        f();
        c();
        this.f4597a.setProgress(100, i10, false);
        this.f4598b.notify(this.f4603g, this.f4597a.build());
    }

    public void a(Bitmap bitmap) {
        if (bitmap != null) {
            this.f4597a.setLargeIcon(bitmap);
            this.f4598b.notify(this.f4603g, this.f4597a.build());
            this.f4605i = true;
        }
    }

    public void a(o oVar) {
        com.aggmoread.sdk.z.b.d.c("DownloadNotification", "show#2 enter,downloadState = " + oVar + " , id = " + this.f4603g);
        f();
        if (oVar == o.f4642d) {
            this.f4600d = "已经下载,点击安装!";
            e();
        } else if (oVar == o.f4643e) {
            this.f4597a.setAutoCancel(true);
            this.f4597a.setOngoing(false);
            this.f4600d = "下载失败";
        } else {
            this.f4597a.setProgress(100, 0, true);
        }
        c();
        this.f4598b.notify(this.f4603g, this.f4597a.build());
    }

    public void a(String str) {
        com.aggmoread.sdk.z.b.d.c("DownloadNotification", "show#3 enter");
        this.f4600d = str;
        f();
        c();
        this.f4598b.notify(this.f4603g, this.f4597a.build());
    }
}
