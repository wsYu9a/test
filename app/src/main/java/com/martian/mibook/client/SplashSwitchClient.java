package com.martian.mibook.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.opos.ads.IRemoteOposAdsInterface;

/* loaded from: classes3.dex */
public abstract class SplashSwitchClient {

    /* renamed from: e */
    public static final String f13591e = "com.opos.ads";

    /* renamed from: f */
    public static final String f13592f = "com.opos.ads.OposAdsRemoteService";

    /* renamed from: a */
    public final Context f13593a;

    /* renamed from: b */
    public ServiceConnection f13594b;

    /* renamed from: c */
    public volatile boolean f13595c;

    /* renamed from: d */
    public IRemoteOposAdsInterface f13596d;

    public class a implements ServiceConnection {

        /* renamed from: b */
        public final /* synthetic */ boolean f13597b;

        public a(boolean z10) {
            this.f13597b = z10;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                try {
                    SplashSwitchClient.this.f13595c = true;
                    SplashSwitchClient.this.f13596d = IRemoteOposAdsInterface.Stub.asInterface(iBinder);
                    SplashSwitchClient.this.f13596d.setShowSplashFlag(this.f13597b);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            } finally {
                SplashSwitchClient.this.e();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            SplashSwitchClient.this.f13596d = null;
            SplashSwitchClient.this.f13595c = false;
        }
    }

    public SplashSwitchClient(Context context) {
        this.f13593a = context;
    }

    public static boolean d(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(f13591e, f13592f));
        return packageManager.queryIntentServices(intent, 65536).size() > 0;
    }

    public void bindService(boolean z10) {
        this.f13594b = new a(z10);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(f13591e, f13592f));
        this.f13593a.bindService(intent, this.f13594b, 1);
    }

    public void e() {
        if (this.f13595c) {
            this.f13593a.unbindService(this.f13594b);
            this.f13595c = false;
        }
    }
}
