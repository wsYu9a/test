package com.martian.mibook.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.martian.libmars.utils.q0;
import com.opos.ads.IRemoteOposAdsInterface;

/* loaded from: classes.dex */
public abstract class SplashSwitchClient {

    /* renamed from: a */
    static final String f11637a = "com.opos.ads";

    /* renamed from: b */
    static final String f11638b = "com.opos.ads.OposAdsRemoteService";

    /* renamed from: c */
    private final Context f11639c;

    /* renamed from: d */
    private ServiceConnection f11640d;

    /* renamed from: e */
    private volatile boolean f11641e;

    /* renamed from: f */
    IRemoteOposAdsInterface f11642f;

    /* loaded from: classes3.dex */
    class a implements ServiceConnection {

        /* renamed from: a */
        final /* synthetic */ boolean f11643a;

        a(final boolean val$showSplash) {
            this.f11643a = val$showSplash;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            q0.e("onServiceConnected:" + componentName);
            try {
                SplashSwitchClient.this.f11641e = true;
                SplashSwitchClient.this.f11642f = IRemoteOposAdsInterface.Stub.asInterface(iBinder);
                SplashSwitchClient.this.f11642f.setShowSplashFlag(this.f11643a);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            q0.e("onServiceDisconnected:" + componentName);
            SplashSwitchClient splashSwitchClient = SplashSwitchClient.this;
            splashSwitchClient.f11642f = null;
            splashSwitchClient.f11641e = false;
        }
    }

    public SplashSwitchClient(Context context) {
        this.f11639c = context;
    }

    public static boolean b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(f11637a, f11638b));
        return packageManager.queryIntentServices(intent, 65536).size() > 0;
    }

    public void bindService(boolean showSplash) {
        this.f11640d = new a(showSplash);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(f11637a, f11638b));
        this.f11639c.bindService(intent, this.f11640d, 1);
    }

    public void c() {
        if (this.f11641e) {
            this.f11639c.unbindService(this.f11640d);
            this.f11641e = false;
        }
    }
}
