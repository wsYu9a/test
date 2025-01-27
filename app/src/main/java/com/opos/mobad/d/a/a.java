package com.opos.mobad.d.a;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.opos.mobad.d.a.c;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.HashSet;

/* loaded from: classes4.dex */
public class a implements c {

    /* renamed from: a */
    private NotificationManager f20386a;

    /* renamed from: b */
    private NotificationCompat.Builder f20387b;

    /* renamed from: c */
    private Notification f20388c;

    /* renamed from: d */
    private Notification f20389d;

    /* renamed from: e */
    private RemoteViews f20390e;

    /* renamed from: f */
    private Context f20391f;

    /* renamed from: g */
    private f f20392g;

    /* renamed from: h */
    private HashSet<Integer> f20393h = new HashSet<>();

    public a(Context context, e eVar) {
        this.f20391f = context;
        this.f20386a = (NotificationManager) context.getSystemService("notification");
        this.f20388c = a(eVar, eVar.f20419b, true, false);
        this.f20389d = Build.VERSION.SDK_INT >= 23 ? a(eVar, true, false, true) : a(eVar, false, true, true);
        this.f20392g = new f(this.f20391f);
    }

    private Notification a(e eVar, boolean z, boolean z2, boolean z3) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.f20391f);
        this.f20387b = builder;
        builder.setSmallIcon(eVar.f20418a);
        this.f20387b.setAutoCancel(z);
        this.f20387b.setOngoing(z2);
        this.f20387b.setOnlyAlertOnce(true);
        this.f20387b.setContentTitle(z3 ? "应用下载完成" : "应用下载");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(eVar.f20420c, eVar.f20421d, eVar.f20422e);
            notificationChannel.enableVibration(false);
            notificationChannel.setLockscreenVisibility(-1);
            notificationChannel.setSound(null, null);
            notificationChannel.setShowBadge(false);
            if (i2 >= 29) {
                notificationChannel.setImportance(2);
            }
            this.f20387b.setChannelId(eVar.f20420c);
            this.f20386a.createNotificationChannel(notificationChannel);
        }
        return this.f20387b.build();
    }

    private void a(int i2, PendingIntent pendingIntent) {
        com.opos.cmn.an.f.a.b("DownloadNotification", "show showNotificationCancelable:" + i2 + ",intent:" + pendingIntent);
        if (pendingIntent != null) {
            this.f20389d.deleteIntent = pendingIntent;
        }
        Notification notification = this.f20389d;
        notification.contentView = this.f20390e;
        this.f20386a.notify(i2, notification);
    }

    private void b(int i2) {
        Notification notification = this.f20388c;
        notification.contentView = this.f20390e;
        this.f20386a.notify(i2, notification);
    }

    @Override // com.opos.mobad.d.a.c
    public void a() {
        com.opos.cmn.an.f.a.b("DownloadNotification", "onCancelAllNotification");
        HashSet<Integer> hashSet = this.f20393h;
        if (hashSet != null) {
            hashSet.clear();
        }
        NotificationManager notificationManager = this.f20386a;
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
        this.f20392g.a();
    }

    @Override // com.opos.mobad.d.a.c
    public void a(int i2) {
        com.opos.cmn.an.f.a.b("DownloadNotification", "onCancelNotification");
        HashSet<Integer> hashSet = this.f20393h;
        if (hashSet != null) {
            hashSet.remove(Integer.valueOf(i2));
        }
        NotificationManager notificationManager = this.f20386a;
        if (notificationManager != null) {
            notificationManager.cancel(i2);
        }
        f fVar = this.f20392g;
        if (fVar != null) {
            fVar.a(i2);
        }
    }

    @Override // com.opos.mobad.d.a.c
    public void a(int i2, c.a aVar) {
        int i3 = aVar.f20403c;
        String str = aVar.f20401a;
        String str2 = aVar.f20402b;
        Intent intent = aVar.f20405e;
        Intent intent2 = aVar.f20406f;
        if (i3 == 105) {
            a(str, str2, i3, intent, intent2, aVar.f20407g, i2, aVar.f20404d);
        } else {
            a(str, str2, i3, intent, intent2, i2, aVar.f20404d);
        }
    }

    public void a(String str, String str2, int i2, Intent intent, Intent intent2, int i3, int i4) {
        com.opos.cmn.an.f.a.b("DownloadNotification", "onShowNotification download appName:" + str + ",process:" + str2 + ",statusCode:" + i2);
        RemoteViews a2 = this.f20392g.a(str, str2, i2, i4, i3);
        int i5 = Build.VERSION.SDK_INT >= 23 ? 67108864 : 0;
        if (this.f20393h.contains(Integer.valueOf(i3))) {
            int i6 = i5 | 134217728;
            a2.setOnClickPendingIntent(com.opos.mobad.service.e.a(this.f20391f, "dl_ctrl_bt", "id"), PendingIntent.getService(this.f20391f, i3, intent, i6));
            a2.setOnClickPendingIntent(com.opos.mobad.service.e.a(this.f20391f, "dl_delete_bt", "id"), PendingIntent.getService(this.f20391f, i3, intent2, i6));
        } else {
            int i7 = i5 | DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP;
            a2.setOnClickPendingIntent(com.opos.mobad.service.e.a(this.f20391f, "dl_ctrl_bt", "id"), PendingIntent.getService(this.f20391f, i3, intent, i7));
            a2.setOnClickPendingIntent(com.opos.mobad.service.e.a(this.f20391f, "dl_delete_bt", "id"), PendingIntent.getService(this.f20391f, i3, intent2, i7));
            this.f20393h.add(Integer.valueOf(i3));
            com.opos.cmn.an.f.a.b("DownloadNotification", "onShowNotification add download list");
        }
        this.f20390e = a2;
        b(i3);
    }

    public void a(String str, String str2, int i2, Intent intent, Intent intent2, Intent intent3, int i3, int i4) {
        PendingIntent service;
        com.opos.cmn.an.f.a.b("DownloadNotification", "onShowNotification download appName:" + str + ",process:" + str2 + ",statusCode:" + i2);
        RemoteViews a2 = this.f20392g.a(str, str2, i2, i4, i3);
        int i5 = Build.VERSION.SDK_INT >= 23 ? 67108864 : 0;
        if (this.f20393h.contains(Integer.valueOf(i3))) {
            int i6 = i5 | 134217728;
            a2.setOnClickPendingIntent(com.opos.mobad.service.e.a(this.f20391f, "dl_ctrl_bt", "id"), PendingIntent.getActivity(this.f20391f, i3, intent, i6));
            a2.setOnClickPendingIntent(com.opos.mobad.service.e.a(this.f20391f, "dl_delete_bt", "id"), PendingIntent.getService(this.f20391f, i3, intent2, i6));
            service = PendingIntent.getService(this.f20391f, i3, intent3, i6);
        } else {
            int i7 = i5 | DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP;
            a2.setOnClickPendingIntent(com.opos.mobad.service.e.a(this.f20391f, "dl_ctrl_bt", "id"), PendingIntent.getActivity(this.f20391f, i3, intent, i7));
            a2.setOnClickPendingIntent(com.opos.mobad.service.e.a(this.f20391f, "dl_delete_bt", "id"), PendingIntent.getService(this.f20391f, i3, intent2, i7));
            service = PendingIntent.getService(this.f20391f, i3, intent3, i7);
            this.f20393h.add(Integer.valueOf(i3));
            com.opos.cmn.an.f.a.b("DownloadNotification", "onShowNotification add download list");
        }
        this.f20390e = a2;
        a(i3, service);
    }
}
