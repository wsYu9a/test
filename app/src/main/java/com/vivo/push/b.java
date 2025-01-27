package com.vivo.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.vivo.push.util.t;
import com.vivo.push.util.z;
import com.vivo.vms.IPCInvoke;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class b implements ServiceConnection {

    /* renamed from: a */
    private static final Object f30878a = new Object();

    /* renamed from: b */
    private static Map<String, b> f30879b = new HashMap();

    /* renamed from: c */
    private boolean f30880c;

    /* renamed from: d */
    private String f30881d;

    /* renamed from: e */
    private Context f30882e;

    /* renamed from: g */
    private volatile IPCInvoke f30884g;

    /* renamed from: i */
    private String f30886i;

    /* renamed from: j */
    private Handler f30887j;

    /* renamed from: h */
    private Object f30885h = new Object();

    /* renamed from: f */
    private AtomicInteger f30883f = new AtomicInteger(1);

    private b(Context context, String str) {
        this.f30881d = null;
        this.f30887j = null;
        this.f30882e = context;
        this.f30886i = str;
        this.f30887j = new Handler(Looper.getMainLooper(), new c(this));
        String b2 = t.b(context);
        this.f30881d = b2;
        if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(this.f30886i)) {
            this.f30880c = z.a(context, this.f30881d) >= 1260;
            b();
            return;
        }
        com.vivo.push.util.p.c(this.f30882e, "init error : push pkgname is " + this.f30881d + " ; action is " + this.f30886i);
        this.f30880c = false;
    }

    private void d() {
        this.f30887j.removeMessages(1);
        this.f30887j.sendEmptyMessageDelayed(1, 3000L);
    }

    private void e() {
        this.f30887j.removeMessages(1);
    }

    public void f() {
        try {
            this.f30882e.unbindService(this);
        } catch (Exception e2) {
            com.vivo.push.util.p.a("AidlManager", "On unBindServiceException:" + e2.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        com.vivo.push.util.p.b("AidlManager", "onBindingDied : ".concat(String.valueOf(componentName)));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e();
        this.f30884g = IPCInvoke.Stub.asInterface(iBinder);
        if (this.f30884g == null) {
            com.vivo.push.util.p.d("AidlManager", "onServiceConnected error : aidl must not be null.");
            f();
            this.f30883f.set(1);
            return;
        }
        if (this.f30883f.get() == 2) {
            a(4);
        } else if (this.f30883f.get() != 4) {
            f();
        }
        synchronized (this.f30885h) {
            this.f30885h.notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f30884g = null;
        a(1);
    }

    public static b a(Context context, String str) {
        b bVar = f30879b.get(str);
        if (bVar == null) {
            synchronized (f30878a) {
                bVar = f30879b.get(str);
                if (bVar == null) {
                    bVar = new b(context, str);
                    f30879b.put(str, bVar);
                }
            }
        }
        return bVar;
    }

    private void b() {
        int i2 = this.f30883f.get();
        com.vivo.push.util.p.d("AidlManager", "Enter connect, Connection Status: ".concat(String.valueOf(i2)));
        if (i2 == 4 || i2 == 2 || i2 == 3 || i2 == 5 || !this.f30880c) {
            return;
        }
        a(2);
        if (c()) {
            d();
        } else {
            a(1);
            com.vivo.push.util.p.a("AidlManager", "bind core service fail");
        }
    }

    private boolean c() {
        Intent intent = new Intent(this.f30886i);
        intent.setPackage(this.f30881d);
        try {
            return this.f30882e.bindService(intent, this, 1);
        } catch (Exception e2) {
            com.vivo.push.util.p.a("AidlManager", "bind core error", e2);
            return false;
        }
    }

    public final boolean a() {
        String b2 = t.b(this.f30882e);
        this.f30881d = b2;
        if (TextUtils.isEmpty(b2)) {
            com.vivo.push.util.p.c(this.f30882e, "push pkgname is null");
            return false;
        }
        boolean z = z.a(this.f30882e, this.f30881d) >= 1260;
        this.f30880c = z;
        return z;
    }

    public void a(int i2) {
        this.f30883f.set(i2);
    }

    public final boolean a(Bundle bundle) {
        b();
        if (this.f30883f.get() == 2) {
            synchronized (this.f30885h) {
                try {
                    this.f30885h.wait(2000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            int i2 = this.f30883f.get();
            if (i2 == 4) {
                this.f30887j.removeMessages(2);
                this.f30887j.sendEmptyMessageDelayed(2, 30000L);
                this.f30884g.asyncCall(bundle, null);
                return true;
            }
            com.vivo.push.util.p.d("AidlManager", "invoke error : connect status = ".concat(String.valueOf(i2)));
            return false;
        } catch (Exception e3) {
            com.vivo.push.util.p.a("AidlManager", "invoke error ", e3);
            int i3 = this.f30883f.get();
            com.vivo.push.util.p.d("AidlManager", "Enter disconnect, Connection Status: ".concat(String.valueOf(i3)));
            if (i3 == 2) {
                e();
                a(1);
                return false;
            }
            if (i3 == 3) {
                a(1);
                return false;
            }
            if (i3 != 4) {
                return false;
            }
            a(1);
            f();
            return false;
        }
    }
}
