package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.umeng.analytics.pro.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class bg implements be {

    /* renamed from: a */
    private static final String f23551a = "Coolpad";

    /* renamed from: b */
    private static final String f23552b = "com.coolpad.deviceidsupport";

    /* renamed from: c */
    private static final String f23553c = "com.coolpad.deviceidsupport.DeviceIdService";

    /* renamed from: d */
    private static a f23554d;

    /* renamed from: f */
    private CountDownLatch f23556f;

    /* renamed from: g */
    private Context f23557g;

    /* renamed from: e */
    private String f23555e = "";

    /* renamed from: h */
    private final ServiceConnection f23558h = new ServiceConnection() { // from class: com.umeng.analytics.pro.bg.1
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a unused = bg.f23554d = a.b.a(iBinder);
                bg.this.f23555e = bg.f23554d.b(bg.this.f23557g.getPackageName());
                Log.d(bg.f23551a, "onServiceConnected: oaid = " + bg.this.f23555e);
            } catch (RemoteException | NullPointerException e10) {
                Log.e(bg.f23551a, "onServiceConnected failed e=" + e10.getMessage());
            }
            bg.this.f23556f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(bg.f23551a, "onServiceDisconnected");
            a unused = bg.f23554d = null;
        }
    };

    /* renamed from: com.umeng.analytics.pro.bg$1 */
    public class AnonymousClass1 implements ServiceConnection {
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a unused = bg.f23554d = a.b.a(iBinder);
                bg.this.f23555e = bg.f23554d.b(bg.this.f23557g.getPackageName());
                Log.d(bg.f23551a, "onServiceConnected: oaid = " + bg.this.f23555e);
            } catch (RemoteException | NullPointerException e10) {
                Log.e(bg.f23551a, "onServiceConnected failed e=" + e10.getMessage());
            }
            bg.this.f23556f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(bg.f23551a, "onServiceDisconnected");
            a unused = bg.f23554d = null;
        }
    }

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(f23552b, f23553c));
            if (context.bindService(intent, this.f23558h, 1)) {
                return;
            }
            Log.e(f23551a, "bindService return false");
        } catch (Throwable th2) {
            Log.e(f23551a, "bindService failed. e=" + th2.getMessage());
            this.f23556f.countDown();
        }
    }

    private void c(Context context) {
        try {
            Log.d(f23551a, "call unbindService.");
            context.unbindService(this.f23558h);
        } catch (Throwable th2) {
            Log.e(f23551a, "unbindService failed. e=" + th2.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.be
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        this.f23557g = context.getApplicationContext();
        this.f23556f = new CountDownLatch(1);
        try {
            try {
                b(context);
                if (!this.f23556f.await(500L, TimeUnit.MILLISECONDS)) {
                    Log.e(f23551a, "getOAID time-out");
                }
                String str = this.f23555e;
                c(context);
                return str;
            } catch (InterruptedException e10) {
                Log.e(f23551a, "getOAID interrupted. e=" + e10.getMessage());
                c(context);
                return null;
            }
        } catch (Throwable th2) {
            c(context);
            throw th2;
        }
    }
}
