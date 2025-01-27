package org.repackage.com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import org.repackage.com.zui.deviceidservice.IDeviceidInterface;

/* loaded from: classes5.dex */
public class OpenDeviceId {

    /* renamed from: c */
    private static String f35633c = "OpenDeviceId library";

    /* renamed from: d */
    private static boolean f35634d = false;

    /* renamed from: b */
    private IDeviceidInterface f35636b;

    /* renamed from: e */
    private ServiceConnection f35637e;

    /* renamed from: a */
    private Context f35635a = null;

    /* renamed from: f */
    private CallBack f35638f = null;

    /* renamed from: org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId$1 */
    class AnonymousClass1 implements ServiceConnection {
        AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            OpenDeviceId.this.f35636b = IDeviceidInterface.Stub.a(iBinder);
            if (OpenDeviceId.this.f35638f != null) {
                OpenDeviceId.this.f35638f.a("Deviceid Service Connected", OpenDeviceId.this);
            }
            OpenDeviceId.this.a("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            OpenDeviceId.this.f35636b = null;
            OpenDeviceId.this.a("Service onServiceDisconnected");
        }
    }

    public interface CallBack<T> {
        void a(T t, OpenDeviceId openDeviceId);
    }

    public String b() {
        if (this.f35635a == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            IDeviceidInterface iDeviceidInterface = this.f35636b;
            if (iDeviceidInterface != null) {
                return iDeviceidInterface.b();
            }
            return null;
        } catch (RemoteException e2) {
            b("getUDID error, RemoteException!");
            e2.printStackTrace();
            return null;
        } catch (Exception e3) {
            b("getUDID error, Exception!");
            e3.printStackTrace();
            return null;
        }
    }

    public boolean c() {
        try {
            if (this.f35636b == null) {
                return false;
            }
            a("Device support opendeviceid");
            return this.f35636b.c();
        } catch (RemoteException unused) {
            b("isSupport error, RemoteException!");
            return false;
        }
    }

    public String d() {
        Context context = this.f35635a;
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
            IDeviceidInterface iDeviceidInterface = this.f35636b;
            if (iDeviceidInterface != null) {
                return iDeviceidInterface.a(packageName);
            }
            return null;
        } catch (RemoteException e2) {
            b("getVAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public String e() {
        Context context = this.f35635a;
        if (context == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        a("liufeng, getAAID package：" + packageName);
        String str = null;
        if (packageName == null || packageName.equals("")) {
            a("input package is null!");
            return null;
        }
        try {
            IDeviceidInterface iDeviceidInterface = this.f35636b;
            if (iDeviceidInterface == null) {
                return null;
            }
            str = iDeviceidInterface.b(packageName);
            return ((str == null || "".equals(str)) && this.f35636b.c(packageName)) ? this.f35636b.b(packageName) : str;
        } catch (RemoteException unused) {
            b("getAAID error, RemoteException!");
            return str;
        }
    }

    public void f() {
        try {
            this.f35635a.unbindService(this.f35637e);
            a("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            b("unBind Service exception");
        }
        this.f35636b = null;
    }

    public int a(Context context, CallBack<String> callBack) {
        if (context != null) {
            this.f35635a = context;
            this.f35638f = callBack;
            this.f35637e = new ServiceConnection() { // from class: org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId.1
                AnonymousClass1() {
                }

                @Override // android.content.ServiceConnection
                public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    OpenDeviceId.this.f35636b = IDeviceidInterface.Stub.a(iBinder);
                    if (OpenDeviceId.this.f35638f != null) {
                        OpenDeviceId.this.f35638f.a("Deviceid Service Connected", OpenDeviceId.this);
                    }
                    OpenDeviceId.this.a("Service onServiceConnected");
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    OpenDeviceId.this.f35636b = null;
                    OpenDeviceId.this.a("Service onServiceDisconnected");
                }
            };
            Intent intent = new Intent();
            intent.setClassName("org.repackage.com.zui.deviceidservice", "org.repackage.com.zui.deviceidservice.DeviceidService");
            if (this.f35635a.bindService(intent, this.f35637e, 1)) {
                a("bindService Successful!");
                return 1;
            }
            a("bindService Failed!");
            return -1;
        }
        throw new NullPointerException("Context can not be null.");
    }

    private void b(String str) {
        if (f35634d) {
            Log.e(f35633c, str);
        }
    }

    public String a() {
        if (this.f35635a != null) {
            try {
                IDeviceidInterface iDeviceidInterface = this.f35636b;
                if (iDeviceidInterface != null) {
                    return iDeviceidInterface.a();
                }
                return null;
            } catch (RemoteException e2) {
                b("getOAID error, RemoteException!");
                e2.printStackTrace();
                return null;
            }
        }
        b("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public void a(boolean z) {
        f35634d = z;
    }

    public void a(String str) {
        if (f35634d) {
            Log.i(f35633c, str);
        }
    }
}
