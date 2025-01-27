package com.vivo.mobilead.c;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.vivo.mobad.R;
import com.vivo.mobilead.util.g;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: g */
    private static volatile c f28707g;

    /* renamed from: a */
    private NotificationManager f28708a;

    /* renamed from: b */
    private Context f28709b;

    /* renamed from: c */
    private Bitmap f28710c;

    /* renamed from: d */
    private String f28711d;

    /* renamed from: e */
    private NotificationCompat.Builder f28712e;

    /* renamed from: f */
    private NotificationChannel f28713f;

    private c() {
    }

    public static c b() {
        if (f28707g == null) {
            synchronized (c.class) {
                if (f28707g == null) {
                    f28707g = new c();
                }
            }
        }
        return f28707g;
    }

    public void a(Context context) {
        this.f28708a = (NotificationManager) context.getSystemService("notification");
        this.f28709b = context;
    }

    public void a(float f2, String str) {
        if (this.f28708a == null || this.f28709b == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (this.f28713f == null) {
                NotificationChannel notificationChannel = new NotificationChannel("ad_dm_chanel_common", "ad_dm_chanel_common", 3);
                this.f28713f = notificationChannel;
                notificationChannel.setDescription("descroption");
                this.f28713f.enableLights(false);
                this.f28713f.enableVibration(false);
            }
            this.f28708a.createNotificationChannel(this.f28713f);
        }
        if (this.f28712e == null) {
            this.f28712e = new NotificationCompat.Builder(this.f28709b, "ad_dm_chanel_common").setAutoCancel(false).setOngoing(false).setSmallIcon(R.drawable.vivo_module_ad_download).setPriority(0);
        }
        if (!TextUtils.isEmpty(str) && !str.equals(this.f28711d)) {
            this.f28711d = str;
            this.f28710c = com.vivo.mobilead.h.b.a().a(this.f28711d);
        }
        if (this.f28710c == null) {
            Bitmap a2 = com.vivo.mobilead.h.b.a().a(this.f28711d);
            this.f28710c = a2;
            if (a2 == null) {
                this.f28710c = g.a(this.f28709b, "vivo_module_exit_float_default.png");
            }
        }
        this.f28712e.setLargeIcon(this.f28710c);
        NotificationCompat.Builder builder = this.f28712e;
        StringBuilder sb = new StringBuilder();
        sb.append("正在下载中...");
        int i2 = (int) f2;
        sb.append(i2);
        sb.append("%");
        builder.setContentTitle(sb.toString());
        this.f28712e.setProgress(100, i2, false);
        this.f28708a.notify(11, this.f28712e.build());
    }

    public void a() {
        NotificationManager notificationManager = this.f28708a;
        if (notificationManager != null) {
            notificationManager.cancel(11);
        }
    }
}
