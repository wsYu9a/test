package org.repackage.com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import org.repackage.com.zui.deviceidservice.IDeviceidInterface;

/* loaded from: classes4.dex */
public class OpenDeviceId {

    /* renamed from: c */
    private static String f29473c = "OpenDeviceId library";

    /* renamed from: d */
    private static boolean f29474d = false;

    /* renamed from: b */
    private IDeviceidInterface f29476b;

    /* renamed from: e */
    private ServiceConnection f29477e;

    /* renamed from: a */
    private Context f29475a = null;

    /* renamed from: f */
    private CallBack f29478f = null;

    /* renamed from: org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId$1 */
    public class AnonymousClass1 implements ServiceConnection {
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                OpenDeviceId.this.f29476b = IDeviceidInterface.Stub.a(iBinder);
                if (OpenDeviceId.this.f29478f != null) {
                    OpenDeviceId.this.f29478f.a("Deviceid Service Connected", OpenDeviceId.this);
                }
                OpenDeviceId.this.a("Service onServiceConnected");
            } catch (Throwable th2) {
                throw th2;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            OpenDeviceId.this.f29476b = null;
            OpenDeviceId.this.a("Service onServiceDisconnected");
        }
    }

    public interface CallBack<T> {
        void a(T t10, OpenDeviceId openDeviceId);
    }

    public String b() {
        if (this.f29475a == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            IDeviceidInterface iDeviceidInterface = this.f29476b;
            if (iDeviceidInterface != null) {
                return iDeviceidInterface.b();
            }
            return null;
        } catch (RemoteException e10) {
            b("getUDID error, RemoteException!");
            e10.printStackTrace();
            return null;
        } catch (Exception e11) {
            b("getUDID error, Exception!");
            e11.printStackTrace();
            return null;
        }
    }

    public boolean c() {
        try {
            if (this.f29476b == null) {
                return false;
            }
            a("Device support opendeviceid");
            return this.f29476b.c();
        } catch (RemoteException unused) {
            b("isSupport error, RemoteException!");
            return false;
        }
    }

    public String d() {
        Context context = this.f29475a;
        if (context == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        a("liufeng, getVAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            a("input package is null!");
            return null;
        }
        try {
            IDeviceidInterface iDeviceidInterface = this.f29476b;
            if (iDeviceidInterface != null) {
                return iDeviceidInterface.a(packageName);
            }
            return null;
        } catch (RemoteException e10) {
            b("getVAID error, RemoteException!");
            e10.printStackTrace();
            return null;
        }
    }

    public String e() {
        Context context = this.f29475a;
        if (context == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        a("liufeng, getAAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            a("input package is null!");
            return null;
        }
        try {
            IDeviceidInterface iDeviceidInterface = this.f29476b;
            if (iDeviceidInterface == null) {
                return null;
            }
            String b10 = iDeviceidInterface.b(packageName);
            return ((b10 == null || "".equals(b10)) && this.f29476b.c(packageName)) ? this.f29476b.b(packageName) : b10;
        } catch (RemoteException unused) {
            b("getAAID error, RemoteException!");
            return null;
        }
    }

    public void f() {
        try {
            this.f29475a.unbindService(this.f29477e);
            a("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            b("unBind Service exception");
        }
        this.f29476b = null;
    }

    public int a(Context context, CallBack<String> callBack) {
        if (context != null) {
            this.f29475a = context;
            this.f29478f = callBack;
            this.f29477e = new ServiceConnection() { // from class: org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId.1
                public AnonymousClass1() {
                }

                @Override // android.content.ServiceConnection
                public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    try {
                        OpenDeviceId.this.f29476b = IDeviceidInterface.Stub.a(iBinder);
                        if (OpenDeviceId.this.f29478f != null) {
                            OpenDeviceId.this.f29478f.a("Deviceid Service Connected", OpenDeviceId.this);
                        }
                        OpenDeviceId.this.a("Service onServiceConnected");
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    OpenDeviceId.this.f29476b = null;
                    OpenDeviceId.this.a("Service onServiceDisconnected");
                }
            };
            Intent intent = new Intent();
            intent.setClassName("org.repackage.com.zui.deviceidservice", "org.repackage.com.zui.deviceidservice.DeviceidService");
            if (this.f29475a.bindService(intent, this.f29477e, 1)) {
                a("bindService Successful!");
                return 1;
            }
            a("bindService Failed!");
            return -1;
        }
        throw new NullPointerException("Context can not be null.");
    }

    private void b(String str) {
        if (f29474d) {
            Log.e(f29473c, str);
        }
    }

    public String a() {
        if (this.f29475a != null) {
            try {
                IDeviceidInterface iDeviceidInterface = this.f29476b;
                if (iDeviceidInterface != null) {
                    return iDeviceidInterface.a();
                }
                return null;
            } catch (RemoteException e10) {
                b("getOAID error, RemoteException!");
                e10.printStackTrace();
                return null;
            }
        }
        b("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public void a(boolean z10) {
        f29474d = z10;
    }

    public void a(String str) {
        if (f29474d) {
            Log.i(f29473c, str);
        }
    }
}
