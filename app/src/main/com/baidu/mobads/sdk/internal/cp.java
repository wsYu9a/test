package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* loaded from: classes2.dex */
public class cp {

    /* renamed from: a */
    private static volatile cp f7110a;

    private cp() {
    }

    public static cp a() {
        if (f7110a == null) {
            synchronized (cp.class) {
                try {
                    if (f7110a == null) {
                        f7110a = new cp();
                    }
                } finally {
                }
            }
        }
        return f7110a;
    }

    private NetworkCapabilities c(Context context) {
        Network activeNetwork;
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f11101b) != 0) {
                return null;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
            activeNetwork = connectivityManager.getActiveNetwork();
            return connectivityManager.getNetworkCapabilities(activeNetwork);
        } catch (Throwable unused) {
            return null;
        }
    }

    public NetworkInfo b(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f11101b) == 0) {
                return ((ConnectivityManager) applicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Boolean a(Context context) {
        try {
            boolean z10 = false;
            if (bm.a(context).a() < 29) {
                NetworkInfo b10 = b(context);
                if (b10 != null && b10.isConnected() && b10.getType() == 1) {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            }
            NetworkCapabilities c10 = c(context);
            if (c10 != null && c10.hasCapability(12) && c10.hasCapability(16) && c10.hasTransport(1)) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }
}
