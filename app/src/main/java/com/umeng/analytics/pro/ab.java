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
public class ab implements z {

    /* renamed from: a */
    private static final String f25623a = "Coolpad";

    /* renamed from: b */
    private static final String f25624b = "com.coolpad.deviceidsupport";

    /* renamed from: c */
    private static final String f25625c = "com.coolpad.deviceidsupport.DeviceIdService";

    /* renamed from: d */
    private static a f25626d;

    /* renamed from: f */
    private CountDownLatch f25628f;

    /* renamed from: g */
    private Context f25629g;

    /* renamed from: e */
    private String f25627e = "";

    /* renamed from: h */
    private final ServiceConnection f25630h = new ServiceConnection() { // from class: com.umeng.analytics.pro.ab.1
        AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a unused = ab.f25626d = a.AbstractBinderC0535a.a(iBinder);
                ab.this.f25627e = ab.f25626d.b(ab.this.f25629g.getPackageName());
                Log.d(ab.f25623a, "onServiceConnected: oaid = " + ab.this.f25627e);
            } catch (RemoteException | NullPointerException e2) {
                Log.e(ab.f25623a, "onServiceConnected failed e=" + e2.getMessage());
            }
            ab.this.f25628f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(ab.f25623a, "onServiceDisconnected");
            a unused = ab.f25626d = null;
        }
    };

    /* renamed from: com.umeng.analytics.pro.ab$1 */
    class AnonymousClass1 implements ServiceConnection {
        AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a unused = ab.f25626d = a.AbstractBinderC0535a.a(iBinder);
                ab.this.f25627e = ab.f25626d.b(ab.this.f25629g.getPackageName());
                Log.d(ab.f25623a, "onServiceConnected: oaid = " + ab.this.f25627e);
            } catch (RemoteException | NullPointerException e2) {
                Log.e(ab.f25623a, "onServiceConnected failed e=" + e2.getMessage());
            }
            ab.this.f25628f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(ab.f25623a, "onServiceDisconnected");
            a unused = ab.f25626d = null;
        }
    }

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(f25624b, f25625c));
            if (context.bindService(intent, this.f25630h, 1)) {
                return;
            }
            Log.e(f25623a, "bindService return false");
        } catch (Throwable th) {
            Log.e(f25623a, "bindService failed. e=" + th.getMessage());
            this.f25628f.countDown();
        }
    }

    private void c(Context context) {
        try {
            Log.d(f25623a, "call unbindService.");
            context.unbindService(this.f25630h);
        } catch (Throwable th) {
            Log.e(f25623a, "unbindService failed. e=" + th.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        this.f25629g = context.getApplicationContext();
        this.f25628f = new CountDownLatch(1);
        try {
            b(context);
            if (!this.f25628f.await(500L, TimeUnit.MILLISECONDS)) {
                Log.e(f25623a, "getOAID time-out");
            }
            return this.f25627e;
        } catch (InterruptedException e2) {
            Log.e(f25623a, "getOAID interrupted. e=" + e2.getMessage());
            return null;
        } finally {
            c(context);
        }
    }
}
