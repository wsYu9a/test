package com.vivo.ic.dm.util;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.DownloadNotifier;
import com.vivo.ic.dm.l;

/* loaded from: classes4.dex */
public class KeepAliveService extends Service implements DownloadNotifier.NotificationCallback {

    /* renamed from: a */
    private static final String f28627a = "KeepAliveService";

    /* renamed from: b */
    private static final String f28628b = "NOTIFY_ID";

    /* renamed from: c */
    private static final String f28629c = "NOTIFICATION";

    /* renamed from: d */
    private DownloadNotifier f28630d;

    private void a() {
        DownloadNotifier downloadNotifier = this.f28630d;
        if (downloadNotifier == null) {
            VLog.i(f28627a, "onStartCommand error by mDownloadNotifier is null");
        } else {
            if (downloadNotifier.isKeepAlive()) {
                return;
            }
            b();
        }
    }

    private void b() {
        stopForeground(false);
        stopSelf();
        VLog.i(f28627a, "stopForegroundService success");
    }

    @Override // com.vivo.ic.dm.DownloadNotifier.NotificationCallback
    public void cancelDownloading(int i2) {
        DownloadNotifier downloadNotifier = this.f28630d;
        if (downloadNotifier != null) {
            downloadNotifier.setNotificationCallback(null);
            VLog.i(f28627a, "cancelDownloading destory");
        } else {
            VLog.i(f28627a, "cancelDownloading null error by mDownloadNotifier is null");
        }
        b();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f28630d = l.j().m();
        a();
        DownloadNotifier downloadNotifier = this.f28630d;
        if (downloadNotifier == null) {
            VLog.i(f28627a, "setNotificationCallback error by mDownloadNotifier is null");
        } else {
            downloadNotifier.setNotificationCallback(this);
            VLog.i(f28627a, "KeepAliveService create");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        DownloadNotifier downloadNotifier = this.f28630d;
        if (downloadNotifier == null) {
            VLog.i(f28627a, "setNotificationCallback null error by mDownloadNotifier is null");
        } else {
            downloadNotifier.setNotificationCallback(null);
            VLog.i(f28627a, "KeepAliveService destory");
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        int intExtra = intent.getIntExtra(f28628b, -1);
        Notification notification = (Notification) intent.getParcelableExtra(f28629c);
        if (notification == null) {
            VLog.i(f28627a, "onStartCommand error by notification is null");
            b();
            return 2;
        }
        startForeground(intExtra, notification);
        a();
        return 2;
    }

    public static void a(Context context, int i2, Notification notification) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26 && l.j().r()) {
            Intent intent = new Intent(context, (Class<?>) KeepAliveService.class);
            intent.putExtra(f28628b, i2);
            intent.putExtra(f28629c, notification);
            context.startForegroundService(intent);
            VLog.i(f28627a, "start keep alive service");
            return;
        }
        VLog.i(f28627a, "start keep alive service ignore by " + i3);
    }
}
