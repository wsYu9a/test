package com.vivo.ic.dm.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.DownloadService;
import com.vivo.ic.dm.l;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    private static final String f28634a = "SystemAdapterUtil";

    /* renamed from: b */
    private static Context f28635b = null;

    /* renamed from: c */
    private static boolean f28636c = false;

    /* renamed from: d */
    private static Messenger f28637d;

    /* renamed from: e */
    private static ServiceConnection f28638e = new a();

    /* renamed from: f */
    static Messenger f28639f = new Messenger(new b(Looper.getMainLooper()));

    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder == null) {
                Messenger unused = e.f28637d = null;
                boolean unused2 = e.f28636c = false;
                VLog.w(e.f28634a, "DownloadService connected but innerService is null " + iBinder);
                return;
            }
            Messenger unused3 = e.f28637d = new Messenger(iBinder);
            e.c();
            boolean unused4 = e.f28636c = true;
            VLog.i(e.f28634a, "onServiceConnected " + iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Messenger unused = e.f28637d = null;
            boolean unused2 = e.f28636c = false;
            VLog.i(e.f28634a, "onServiceDisconnected " + componentName);
        }
    }

    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 2) {
                e.c(e.f28635b, "stop by server");
            }
        }
    }

    public static void c() {
        Message obtain = Message.obtain((Handler) null, 1);
        obtain.replyTo = f28639f;
        try {
            f28637d.send(obtain);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            c(f28635b, "send messenger error");
        }
    }

    public static void b(Context context, String str) {
        if (context == null) {
            VLog.w(f28634a, "startDownloadService error by context is null");
            return;
        }
        f28635b = context.getApplicationContext();
        VLog.i(f28634a, "start download service by: " + str);
        Intent intent = new Intent(f28635b, (Class<?>) DownloadService.class);
        try {
            if (!l.j().s()) {
                f28635b.startService(intent);
                return;
            }
            if (f28636c) {
                c();
            } else if (f28635b.bindService(intent, f28638e, 1)) {
                VLog.i(f28634a, "DownloadService bind success");
            } else {
                VLog.w(f28634a, "DownloadService bind error");
            }
        } catch (Exception e2) {
            VLog.e(f28634a, "start download error by: " + e2, e2);
            c(f28635b, "start error");
        }
    }

    public static void c(Context context, String str) {
        if (context == null) {
            VLog.w(f28634a, "stopDownloadService error by context is null");
            return;
        }
        try {
            if (l.j().s()) {
                VLog.i(f28634a, "unbindDownloadService for reason " + str);
                context.unbindService(f28638e);
                f28636c = false;
            } else {
                VLog.i(f28634a, "stopDownloadService for reason " + str);
                context.stopService(new Intent(context, (Class<?>) DownloadService.class));
            }
        } catch (Exception e2) {
            VLog.w(f28634a, "stopDownloadService error ", e2);
        }
    }
}
