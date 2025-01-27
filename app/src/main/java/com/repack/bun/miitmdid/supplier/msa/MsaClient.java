package com.repack.bun.miitmdid.supplier.msa;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Keep;
import jh.a;
import jh.c;

@Keep
/* loaded from: classes3.dex */
public class MsaClient {
    private static String TAG = "MSA Client library";
    private static String TARGET_PACKAGE = "com.mdid.msa";
    private w0.a _BindService;
    private ServiceConnection mConnection;
    private Context mContext;
    private jh.a mDeviceidInterface;

    public class a implements ServiceConnection {

        /* renamed from: b */
        public final w0.a f16631b;

        public a(w0.a aVar) {
            this.f16631b = aVar;
        }

        @Override // android.content.ServiceConnection
        public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            jh.a c0719a;
            try {
                MsaClient msaClient = MsaClient.this;
                int i10 = a.AbstractBinderC0718a.f27575b;
                if (iBinder == null) {
                    c0719a = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
                    if (queryLocalInterface != null && (queryLocalInterface instanceof jh.a)) {
                        c0719a = (jh.a) queryLocalInterface;
                    }
                    c0719a = new a.AbstractBinderC0718a.C0719a(iBinder);
                }
                msaClient.mDeviceidInterface = c0719a;
                new nj.a(MsaClient.this.mDeviceidInterface, this.f16631b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                c.a(MsaClient.TAG, "Service onServiceConnected");
            } catch (Throwable th2) {
                throw th2;
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            MsaClient.this.mDeviceidInterface = null;
            c.a(MsaClient.TAG, "Service onServiceDisconnected");
            MsaClient.this.mDeviceidInterface = null;
        }
    }

    public MsaClient(Context context, w0.a aVar) {
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.mContext = context;
        this._BindService = aVar;
        this.mConnection = new a(aVar);
    }

    public static boolean CheckService(Context context) {
        try {
            context.getPackageManager().getPackageInfo(TARGET_PACKAGE, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void StartMsaKlService(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName(TARGET_PACKAGE, "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            if (context.startService(intent) == null) {
                c.g(TAG, "start msa kl service error");
            }
        } catch (Exception e10) {
            c.b(TAG, "start msa kl service exception", e10);
        }
    }

    public void BindService(String str) {
        String str2;
        String str3;
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        if (this.mContext.bindService(intent, this.mConnection, 1)) {
            str2 = TAG;
            str3 = "bindService Successful!";
        } else {
            w0.a aVar = this._BindService;
            if (aVar != null) {
                aVar.m();
            }
            str2 = TAG;
            str3 = "bindService Failed!";
        }
        c.a(str2, str3);
    }

    public String getAAID() {
        try {
            jh.a aVar = this.mDeviceidInterface;
            return aVar != null ? aVar.getAAID() : "";
        } catch (RemoteException unused) {
            c.a(TAG, "getAAID error, RemoteException!");
            return "";
        }
    }

    public String getOAID() {
        try {
            jh.a aVar = this.mDeviceidInterface;
            return aVar != null ? aVar.getOAID() : "";
        } catch (RemoteException e10) {
            c.g(TAG, "getOAID error, RemoteException!");
            e10.printStackTrace();
            return "";
        }
    }

    public String getUDID() {
        return "";
    }

    public String getVAID() {
        try {
            jh.a aVar = this.mDeviceidInterface;
            return aVar != null ? aVar.getVAID() : "";
        } catch (RemoteException unused) {
            c.a(TAG, "getVAID error, RemoteException!");
            return "";
        }
    }

    public boolean isSupported() {
        try {
            if (this.mDeviceidInterface == null) {
                return false;
            }
            c.a(TAG, "Device support opendeviceid");
            return this.mDeviceidInterface.isSupported();
        } catch (Exception unused) {
            c.a(TAG, "isSupport error, RemoteException!");
            return false;
        }
    }

    public void shutdown() {
        jh.a aVar = this.mDeviceidInterface;
        if (aVar != null) {
            try {
                aVar.shutDown();
                ServiceConnection serviceConnection = this.mConnection;
                if (serviceConnection != null) {
                    this.mContext.unbindService(serviceConnection);
                }
                c.a(TAG, "unBind Service successful");
            } catch (Exception unused) {
                c.a(TAG, "unBind Service exception");
            } catch (Throwable th2) {
                this.mConnection = null;
                this.mDeviceidInterface = null;
                throw th2;
            }
            this.mConnection = null;
            this.mDeviceidInterface = null;
        }
    }
}
