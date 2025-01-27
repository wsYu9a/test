package z0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import b.a;
import k3.a;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public Context f33583a;

    /* renamed from: b */
    public b.a f33584b;

    /* renamed from: c */
    public ServiceConnectionC0851a f33585c;

    /* renamed from: d */
    public w0.a f33586d;

    /* renamed from: z0.a$a */
    public class ServiceConnectionC0851a implements ServiceConnection {
        public ServiceConnectionC0851a() {
        }

        @Override // android.content.ServiceConnection
        public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.a c0012a;
            try {
                a aVar = a.this;
                int i10 = a.AbstractBinderC0011a.f1088b;
                if (iBinder == null) {
                    c0012a = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface(a.AbstractBinderC0721a.f27611b);
                    if (queryLocalInterface != null && (queryLocalInterface instanceof b.a)) {
                        c0012a = (b.a) queryLocalInterface;
                    }
                    c0012a = new a.AbstractBinderC0011a.C0012a(iBinder);
                }
                aVar.f33584b = c0012a;
                w0.a aVar2 = a.this.f33586d;
                if (aVar2 != null) {
                    aVar2.l();
                }
                a.this.getClass();
            } catch (Throwable th2) {
                throw th2;
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            a.this.f33584b = null;
        }
    }

    public a(Context context, w0.a aVar) {
        w0.a aVar2;
        this.f33583a = null;
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.f33583a = context;
        this.f33586d = aVar;
        this.f33585c = new ServiceConnectionC0851a();
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.f33583a.bindService(intent, this.f33585c, 1) || (aVar2 = this.f33586d) == null) {
            return;
        }
        aVar2.m();
    }
}
