package m3;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import k3.a;

/* loaded from: classes.dex */
public class b {

    /* renamed from: e */
    public static String f28281e = "OpenDeviceId library";

    /* renamed from: f */
    public static boolean f28282f = false;

    /* renamed from: b */
    public k3.a f28284b;

    /* renamed from: c */
    public ServiceConnection f28285c;

    /* renamed from: a */
    public Context f28283a = null;

    /* renamed from: d */
    public InterfaceC0741b f28286d = null;

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                b.this.f28284b = a.AbstractBinderC0721a.g(iBinder);
                if (b.this.f28286d != null) {
                    b.this.f28286d.a("Deviceid Service Connected", b.this);
                }
                b.this.i("Service onServiceConnected");
            } catch (Throwable th2) {
                throw th2;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.f28284b = null;
            b.this.i("Service onServiceDisconnected");
        }
    }

    /* renamed from: m3.b$b */
    public interface InterfaceC0741b<T> {
        void a(T t10, b bVar);
    }

    public int a(Context context, InterfaceC0741b<String> interfaceC0741b) {
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.f28283a = context;
        this.f28286d = interfaceC0741b;
        this.f28285c = new a();
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.f28283a.bindService(intent, this.f28285c, 1)) {
            i("bindService Successful!");
            return 1;
        }
        i("bindService Failed!");
        return -1;
    }

    public String b() {
        Context context = this.f28283a;
        if (context == null) {
            i("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        i("liufeng, getAAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            i("input package is null!");
            return null;
        }
        try {
            k3.a aVar = this.f28284b;
            if (aVar == null) {
                return null;
            }
            String a10 = aVar.a(packageName);
            return ((a10 == null || "".equals(a10)) && this.f28284b.c(packageName)) ? this.f28284b.a(packageName) : a10;
        } catch (RemoteException unused) {
            e("getAAID error, RemoteException!");
            return null;
        }
    }

    public final void e(String str) {
        if (f28282f) {
            Log.e(f28281e, str);
        }
    }

    public void g(boolean z10) {
        f28282f = z10;
    }

    public String h() {
        if (this.f28283a == null) {
            e("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            k3.a aVar = this.f28284b;
            if (aVar != null) {
                return aVar.a();
            }
            return null;
        } catch (RemoteException e10) {
            e("getOAID error, RemoteException!");
            e10.printStackTrace();
            return null;
        }
    }

    public final void i(String str) {
        if (f28282f) {
            Log.i(f28281e, str);
        }
    }

    public String j() {
        if (this.f28283a == null) {
            e("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            k3.a aVar = this.f28284b;
            if (aVar != null) {
                return aVar.b();
            }
            return null;
        } catch (RemoteException e10) {
            e("getUDID error, RemoteException!");
            e10.printStackTrace();
            return null;
        } catch (Exception e11) {
            e("getUDID error, Exception!");
            e11.printStackTrace();
            return null;
        }
    }

    public String k() {
        Context context = this.f28283a;
        if (context == null) {
            i("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        i("liufeng, getVAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            i("input package is null!");
            return null;
        }
        try {
            k3.a aVar = this.f28284b;
            if (aVar != null) {
                return aVar.b(packageName);
            }
            return null;
        } catch (RemoteException e10) {
            e("getVAID error, RemoteException!");
            e10.printStackTrace();
            return null;
        }
    }

    public boolean l() {
        try {
            if (this.f28284b == null) {
                return false;
            }
            i("Device support opendeviceid");
            return this.f28284b.c();
        } catch (RemoteException unused) {
            e("isSupport error, RemoteException!");
            return false;
        }
    }

    public void m() {
        try {
            this.f28283a.unbindService(this.f28285c);
            i("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            e("unBind Service exception");
        }
        this.f28284b = null;
    }
}
