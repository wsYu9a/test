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
import com.sigmob.sdk.base.common.y;
import com.vivo.push.util.t;
import com.vivo.push.util.z;
import com.vivo.vms.IPCInvoke;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class b implements ServiceConnection {

    /* renamed from: a */
    private static final Object f24905a = new Object();

    /* renamed from: b */
    private static Map<String, b> f24906b = new HashMap();

    /* renamed from: c */
    private boolean f24907c;

    /* renamed from: d */
    private String f24908d;

    /* renamed from: e */
    private Context f24909e;

    /* renamed from: g */
    private volatile IPCInvoke f24911g;

    /* renamed from: i */
    private String f24913i;

    /* renamed from: j */
    private Handler f24914j;

    /* renamed from: h */
    private Object f24912h = new Object();

    /* renamed from: f */
    private AtomicInteger f24910f = new AtomicInteger(1);

    private b(Context context, String str) {
        this.f24908d = null;
        this.f24914j = null;
        this.f24909e = context;
        this.f24913i = str;
        this.f24914j = new Handler(Looper.getMainLooper(), new c(this));
        String b10 = t.b(context);
        this.f24908d = b10;
        if (!TextUtils.isEmpty(b10) && !TextUtils.isEmpty(this.f24913i)) {
            this.f24907c = z.a(context, this.f24908d) >= 1260;
            b();
            return;
        }
        com.vivo.push.util.p.c(this.f24909e, "init error : push pkgname is " + this.f24908d + " ; action is " + this.f24913i);
        this.f24907c = false;
    }

    private void d() {
        this.f24914j.removeMessages(1);
        this.f24914j.sendEmptyMessageDelayed(1, 3000L);
    }

    private void e() {
        this.f24914j.removeMessages(1);
    }

    public void f() {
        try {
            this.f24909e.unbindService(this);
        } catch (Exception e10) {
            com.vivo.push.util.p.a("AidlManager", "On unBindServiceException:" + e10.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        com.vivo.push.util.p.b("AidlManager", "onBindingDied : ".concat(String.valueOf(componentName)));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e();
        this.f24911g = IPCInvoke.Stub.asInterface(iBinder);
        if (this.f24911g == null) {
            com.vivo.push.util.p.d("AidlManager", "onServiceConnected error : aidl must not be null.");
            f();
            this.f24910f.set(1);
            return;
        }
        if (this.f24910f.get() == 2) {
            a(4);
        } else if (this.f24910f.get() != 4) {
            f();
        }
        synchronized (this.f24912h) {
            this.f24912h.notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f24911g = null;
        a(1);
    }

    public static b a(Context context, String str) {
        b bVar = f24906b.get(str);
        if (bVar == null) {
            synchronized (f24905a) {
                try {
                    bVar = f24906b.get(str);
                    if (bVar == null) {
                        bVar = new b(context, str);
                        f24906b.put(str, bVar);
                    }
                } finally {
                }
            }
        }
        return bVar;
    }

    private void b() {
        int i10 = this.f24910f.get();
        com.vivo.push.util.p.d("AidlManager", "Enter connect, Connection Status: ".concat(String.valueOf(i10)));
        if (i10 == 4 || i10 == 2 || i10 == 3 || i10 == 5 || !this.f24907c) {
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
        Intent intent = new Intent(this.f24913i);
        intent.setPackage(this.f24908d);
        try {
            return this.f24909e.bindService(intent, this, 1);
        } catch (Exception e10) {
            com.vivo.push.util.p.a("AidlManager", "bind core error", e10);
            return false;
        }
    }

    public final boolean a() {
        String b10 = t.b(this.f24909e);
        this.f24908d = b10;
        if (TextUtils.isEmpty(b10)) {
            com.vivo.push.util.p.c(this.f24909e, "push pkgname is null");
            return false;
        }
        boolean z10 = z.a(this.f24909e, this.f24908d) >= 1260;
        this.f24907c = z10;
        return z10;
    }

    public void a(int i10) {
        this.f24910f.set(i10);
    }

    public final boolean a(Bundle bundle) {
        b();
        if (this.f24910f.get() == 2) {
            synchronized (this.f24912h) {
                try {
                    this.f24912h.wait(y.f.f18076n);
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
            }
        }
        try {
            int i10 = this.f24910f.get();
            if (i10 == 4) {
                this.f24914j.removeMessages(2);
                this.f24914j.sendEmptyMessageDelayed(2, 30000L);
                this.f24911g.asyncCall(bundle, null);
                return true;
            }
            com.vivo.push.util.p.d("AidlManager", "invoke error : connect status = ".concat(String.valueOf(i10)));
            return false;
        } catch (Exception e11) {
            com.vivo.push.util.p.a("AidlManager", "invoke error ", e11);
            int i11 = this.f24910f.get();
            com.vivo.push.util.p.d("AidlManager", "Enter disconnect, Connection Status: ".concat(String.valueOf(i11)));
            if (i11 == 2) {
                e();
                a(1);
                return false;
            }
            if (i11 == 3) {
                a(1);
                return false;
            }
            if (i11 != 4) {
                return false;
            }
            a(1);
            f();
            return false;
        }
    }
}
