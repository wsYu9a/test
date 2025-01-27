package com.opos.mobad.d.a;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.a.c;

/* loaded from: classes4.dex */
public class g implements c {

    /* renamed from: a */
    private NotificationManager f20430a;

    /* renamed from: b */
    private e f20431b;

    /* renamed from: c */
    private Context f20432c;

    public g(Context context, e eVar) {
        this.f20432c = context;
        this.f20430a = (NotificationManager) context.getSystemService("notification");
        this.f20431b = eVar;
    }

    private Notification a(int i2, e eVar, c.a aVar) {
        NotificationCompat.Builder contentTitle = new NotificationCompat.Builder(this.f20432c).setSmallIcon(eVar.f20418a).setAutoCancel(false).setOnlyAlertOnce(true).setSmallIcon(eVar.f20418a).setContentTitle(aVar.f20401a);
        a(i2, contentTitle, aVar);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(eVar.f20420c, eVar.f20421d, eVar.f20422e);
            notificationChannel.enableVibration(false);
            notificationChannel.setLockscreenVisibility(-1);
            notificationChannel.setSound(null, null);
            notificationChannel.setShowBadge(false);
            if (i3 >= 29) {
                notificationChannel.setImportance(2);
            }
            contentTitle.setChannelId(eVar.f20420c);
            this.f20430a.createNotificationChannel(notificationChannel);
        }
        return contentTitle.build();
    }

    private void a(int i2, NotificationCompat.Builder builder, c.a aVar) {
        Resources resources;
        int i3;
        StringBuilder sb = new StringBuilder();
        int i4 = (Build.VERSION.SDK_INT >= 23 ? 67108864 : 0) | 134217728;
        PendingIntent activity = aVar.f20403c == 105 ? PendingIntent.getActivity(this.f20432c, i2, aVar.f20405e, i4) : PendingIntent.getService(this.f20432c, i2, aVar.f20405e, i4);
        PendingIntent service = PendingIntent.getService(this.f20432c, i2, aVar.f20407g, i4);
        switch (aVar.f20403c) {
            case 102:
                sb.append(this.f20432c.getResources().getString(R.string.download_status_new_downloading_txt));
                sb.append(" ");
                sb.append(String.format("%s", Integer.valueOf(aVar.f20404d)));
                sb.append("%");
                builder.setContentIntent(activity);
                builder.setOngoing(true);
                builder.setProgress(100, aVar.f20404d, false);
                break;
            case 103:
                sb.append(this.f20432c.getResources().getString(R.string.download_status_new_pause_txt));
                sb.append(" ");
                sb.append(String.format("%s", Integer.valueOf(aVar.f20404d)));
                sb.append("%");
                builder.setContentIntent(activity);
                builder.setDeleteIntent(service);
                builder.setOngoing(false);
                break;
            case 105:
                resources = this.f20432c.getResources();
                i3 = R.string.download_status_new_complete_txt;
                sb.append(resources.getString(i3));
                builder.setContentIntent(activity);
                builder.setDeleteIntent(service);
                builder.setOngoing(false);
                break;
            case 106:
                resources = this.f20432c.getResources();
                i3 = R.string.download_status_new_fail_txt;
                sb.append(resources.getString(i3));
                builder.setContentIntent(activity);
                builder.setDeleteIntent(service);
                builder.setOngoing(false);
                break;
            case 107:
                sb.append(this.f20432c.getResources().getString(R.string.download_status_waiting_txt));
                builder.setDeleteIntent(service);
                builder.setOngoing(false);
                break;
        }
        builder.setContentText(sb);
    }

    @Override // com.opos.mobad.d.a.c
    public void a() {
        this.f20430a.cancelAll();
    }

    @Override // com.opos.mobad.d.a.c
    public void a(int i2) {
        this.f20430a.cancel(i2);
    }

    @Override // com.opos.mobad.d.a.c
    public void a(int i2, c.a aVar) {
        this.f20430a.notify(i2, a(i2, this.f20431b, aVar));
    }
}
