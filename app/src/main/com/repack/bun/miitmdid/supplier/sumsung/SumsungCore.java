package com.repack.bun.miitmdid.supplier.sumsung;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Keep;
import jh.c;
import lj.a;
import y2.a;

@Keep
/* loaded from: classes3.dex */
public class SumsungCore {
    private static boolean DBG = false;
    private static String SAMSUNGTAG = "Samsung_DeviceIdService";
    private static String TAG = "SumsungCore library";
    private w0.a mCallerCallBack;
    private ServiceConnection mConnection;
    private Context mContext;
    private lj.a mDeviceidInterface;

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            lj.a c0740a;
            try {
                SumsungCore sumsungCore = SumsungCore.this;
                int i10 = a.AbstractBinderC0739a.f28140b;
                if (iBinder == null) {
                    c0740a = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface(a.AbstractBinderC0847a.f32952b);
                    if (queryLocalInterface != null && (queryLocalInterface instanceof lj.a)) {
                        c0740a = (lj.a) queryLocalInterface;
                    }
                    c0740a = new a.AbstractBinderC0739a.C0740a(iBinder);
                }
                sumsungCore.mDeviceidInterface = c0740a;
                if (SumsungCore.this.mCallerCallBack != null) {
                    SumsungCore.this.mCallerCallBack.l();
                }
                c.a(SumsungCore.TAG, "Service onServiceConnected");
            } catch (Throwable th2) {
                throw th2;
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            SumsungCore.this.mDeviceidInterface = null;
            c.a(SumsungCore.TAG, "Service onServiceDisconnected");
        }
    }

    public SumsungCore(Context context, w0.a aVar) {
        this.mCallerCallBack = null;
        this.mContext = null;
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.mContext = context;
        this.mCallerCallBack = aVar;
        this.mConnection = new a();
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (this.mContext.bindService(intent, this.mConnection, 1)) {
            c.a(TAG, "bindService Successful!");
            return;
        }
        this.mContext.unbindService(this.mConnection);
        c.a(TAG, "bindService Failed!");
        w0.a aVar2 = this.mCallerCallBack;
        if (aVar2 != null) {
            aVar2.m();
        }
    }

    public String getAAID() {
        String str;
        String str2;
        Context context = this.mContext;
        if (context == null) {
            c.a(TAG, "Context is null.");
            throw new IllegalArgumentException("Context is null, must be new SumsungCore first");
        }
        String packageName = context.getPackageName();
        c.a(TAG, "liufeng, getAAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            str = TAG;
            str2 = "input package is null!";
        } else {
            try {
                if (this.mDeviceidInterface == null) {
                    return null;
                }
                Log.d(SAMSUNGTAG, "getAAID Package: " + packageName);
                return this.mDeviceidInterface.getAAID(packageName);
            } catch (RemoteException unused) {
                str = TAG;
                str2 = "getAAID error, RemoteException!";
            }
        }
        c.a(str, str2);
        return null;
    }

    public String getOAID() {
        if (this.mContext == null) {
            c.g(TAG, "Context is null.");
            throw new IllegalArgumentException("Context is null, must be new SumsungCore first");
        }
        try {
            if (this.mDeviceidInterface == null) {
                return null;
            }
            Log.d(SAMSUNGTAG, "getOAID call");
            return this.mDeviceidInterface.getOAID();
        } catch (RemoteException e10) {
            c.g(TAG, "getOAID error, RemoteException!");
            e10.printStackTrace();
            return null;
        }
    }

    public String getUDID() {
        return "";
    }

    public String getVAID() {
        Context context = this.mContext;
        if (context == null) {
            c.a(TAG, "Context is null.");
            throw new IllegalArgumentException("Context is null, must be new SumsungCore first");
        }
        String packageName = context.getPackageName();
        c.a(TAG, "liufeng, getVAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            c.a(TAG, "input package is null!");
            return null;
        }
        try {
            if (this.mDeviceidInterface == null) {
                return null;
            }
            Log.d(SAMSUNGTAG, "getVAID Package: " + packageName);
            return this.mDeviceidInterface.getVAID(packageName);
        } catch (RemoteException e10) {
            c.a(TAG, "getVAID error, RemoteException!");
            e10.printStackTrace();
            return null;
        }
    }

    public boolean isSupported() {
        try {
            if (this.mDeviceidInterface == null) {
                return false;
            }
            c.a(TAG, "Device support opendeviceid");
            return true;
        } catch (Exception unused) {
            c.a(TAG, "isSupport error, RemoteException!");
            return false;
        }
    }

    public void shutdown() {
        try {
            this.mContext.unbindService(this.mConnection);
            c.a(TAG, "unBind Service successful");
        } catch (IllegalArgumentException unused) {
            c.a(TAG, "unBind Service exception");
        }
        this.mDeviceidInterface = null;
    }
}
