package com.tanx.onlyid.api.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tanx.onlyid.api.OAIDException;
import d7.a;
import d7.b;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
class HonorImpl implements ug.d {

    /* renamed from: b */
    public final Context f21999b;

    /* renamed from: f */
    public ug.c f22003f;

    /* renamed from: g */
    public d f22004g;

    /* renamed from: a */
    public String f21998a = "HonorImpl";

    /* renamed from: c */
    public final Handler f22000c = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    public String f22001d = "com.hihonor.id";

    /* renamed from: e */
    public String f22002e = "com.hihonor.id.HnOaIdService";

    /* renamed from: h */
    public long f22005h = System.currentTimeMillis();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HonorImpl.this.s();
        }
    }

    public class b implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ String f22007b;

        public b(String str) {
            this.f22007b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HonorImpl.this.f22003f != null) {
                HonorImpl.this.f22003f.oaidSucc(this.f22007b);
                Log.d(HonorImpl.this.f21998a, "耗时：" + (System.currentTimeMillis() - HonorImpl.this.f22005h));
            } else {
                Log.e(HonorImpl.this.f21998a, "iGetter==null,无法回调");
            }
            HonorImpl honorImpl = HonorImpl.this;
            honorImpl.t(honorImpl.f22004g);
        }
    }

    public class c implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ Exception f22009b;

        public c(Exception exc) {
            this.f22009b = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HonorImpl.this.f22003f != null) {
                HonorImpl.this.f22003f.oaidError(this.f22009b);
            } else {
                Log.e(HonorImpl.this.f21998a, "iGetter==null,无法回调");
            }
            HonorImpl honorImpl = HonorImpl.this;
            honorImpl.t(honorImpl.f22004g);
        }
    }

    public class d implements ServiceConnection {

        /* renamed from: b */
        public String f22011b = "HiHonorServiceConnection";

        public d() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i(this.f22011b, "onServiceConnected ");
            try {
                d7.b g10 = b.AbstractBinderC0688b.g(iBinder);
                g10.f(HonorImpl.this.new e());
                g10.a(HonorImpl.this.new f());
            } catch (Exception e10) {
                HonorImpl.this.q(e10);
                Log.e(this.f22011b, "onServiceConnected error:" + e10.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            HonorImpl.this.f22004g = null;
        }
    }

    public class e extends a.b {
        public e() {
        }

        @Override // d7.a
        public void b(int i10, long j10, boolean z10, float f10, double d10, String str) throws RemoteException {
        }

        @Override // d7.a
        public void c(int i10, Bundle bundle) throws RemoteException {
            Log.d("OAIDCallBack", "OAIDCallBack handleResult retCode=" + i10 + " retInfo=" + bundle);
            if (i10 != 0 || bundle == null) {
                return;
            }
            HonorImpl.this.r(bundle.getString("oa_id_flag"));
        }
    }

    public class f extends a.b {
        public f() {
        }

        @Override // d7.a
        public void b(int i10, long j10, boolean z10, float f10, double d10, String str) throws RemoteException {
        }

        @Override // d7.a
        public void c(int i10, Bundle bundle) throws RemoteException {
            Log.d("OAIDLimitCallback", "OAIDCallBack handleResult retCode=" + i10 + " retInfo=" + bundle);
            if (i10 != 0 || bundle == null) {
                return;
            }
            if (!bundle.getBoolean(xg.a.f32009c)) {
                Log.i("OAIDLimitCallback", "OAIDLimitCallback handleResult success");
                return;
            }
            HonorImpl.this.q(new OAIDException("用户启用了oaid限制获取开关"));
            HonorImpl honorImpl = HonorImpl.this;
            honorImpl.t(honorImpl.f22004g);
        }
    }

    public HonorImpl(Context context) {
        this.f21999b = context;
    }

    private void bindService(Context context) {
        Intent intent = new Intent();
        intent.setAction(this.f22002e);
        intent.setPackage(this.f22001d);
        d dVar = this.f22004g;
        if (dVar != null) {
            boolean bindService = context.bindService(intent, dVar, 1);
            Log.e(this.f21998a, "bind service failed: " + bindService);
        }
    }

    public static String l(String str) {
        String str2;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str2 = (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
        } catch (ClassNotFoundException e10) {
            Log.e(ke.e.f27805c, "getBuildVersion ClassNotFoundException" + e10.getMessage());
            str2 = "";
            Log.i(ke.e.f27805c, "getBuildVersion: " + str2);
            return str2;
        } catch (IllegalAccessException e11) {
            Log.e(ke.e.f27805c, "getBuildVersion IllegalAccessException" + e11.getMessage());
            str2 = "";
            Log.i(ke.e.f27805c, "getBuildVersion: " + str2);
            return str2;
        } catch (NoSuchMethodException e12) {
            Log.e(ke.e.f27805c, "getBuildVersion NoSuchMethodException" + e12.getMessage());
            str2 = "";
            Log.i(ke.e.f27805c, "getBuildVersion: " + str2);
            return str2;
        } catch (InvocationTargetException e13) {
            Log.e(ke.e.f27805c, "getBuildVersion InvocationTargetException" + e13.getMessage());
            str2 = "";
            Log.i(ke.e.f27805c, "getBuildVersion: " + str2);
            return str2;
        } catch (Exception e14) {
            Log.e(ke.e.f27805c, "getBuildVersion Exception" + e14.getMessage());
            str2 = "";
            Log.i(ke.e.f27805c, "getBuildVersion: " + str2);
            return str2;
        }
        Log.i(ke.e.f27805c, "getBuildVersion: " + str2);
        return str2;
    }

    public static boolean n() {
        return Build.MANUFACTURER.equalsIgnoreCase(ke.e.f27805c);
    }

    public static boolean o() {
        return n() && !p();
    }

    public static boolean p() {
        return !TextUtils.isEmpty(l("ro.build.version.emui"));
    }

    @Override // ug.d
    public void a(ug.c cVar) {
        if (this.f21999b == null || cVar == null) {
            return;
        }
        this.f22003f = cVar;
        Executors.newSingleThreadExecutor().execute(new a());
    }

    @Override // ug.d
    public boolean b() {
        Context context = this.f21999b;
        if (context == null) {
            return false;
        }
        return m(context);
    }

    public final boolean m(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(this.f22002e);
        intent.setPackage(this.f22001d);
        if ((packageManager != null ? packageManager.queryIntentServices(intent, 0) : null) != null) {
            return !r3.isEmpty();
        }
        return false;
    }

    public final void q(Exception exc) {
        this.f22000c.post(new c(exc));
    }

    public final void r(String str) {
        this.f22000c.post(new b(str));
    }

    public final void s() {
        try {
            if (this.f22004g == null) {
                this.f22004g = new d();
            }
            t(this.f22004g);
            bindService(this.f21999b);
        } catch (Exception e10) {
            Log.e(this.f21998a, "bind service exception: " + e10.getMessage());
            ug.e.b(e10);
            q(new OAIDException(e10));
        }
    }

    public final void t(ServiceConnection serviceConnection) {
        try {
            Context context = this.f21999b;
            if (context == null || serviceConnection == null) {
                return;
            }
            context.unbindService(serviceConnection);
        } catch (Exception unused) {
        }
    }
}
