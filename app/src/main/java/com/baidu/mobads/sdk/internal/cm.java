package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* loaded from: classes.dex */
public class cm {

    /* renamed from: a */
    private static volatile cm f5741a;

    private cm() {
    }

    public static cm a() {
        if (f5741a == null) {
            synchronized (cm.class) {
                if (f5741a == null) {
                    f5741a = new cm();
                }
            }
        }
        return f5741a;
    }

    private NetworkCapabilities c(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f9317b) != 0) {
                return null;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
            return connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        } catch (Throwable unused) {
            return null;
        }
    }

    public NetworkInfo b(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f9317b) == 0) {
                return ((ConnectivityManager) applicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Boolean a(Context context) {
        try {
            boolean z = false;
            if (bj.a(context).a() < 29) {
                NetworkInfo b2 = b(context);
                if (b2 != null && b2.isConnected() && b2.getType() == 1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
            NetworkCapabilities c2 = c(context);
            if (c2 != null && c2.hasCapability(12) && c2.hasCapability(16) && c2.hasTransport(1)) {
                z = true;
            }
            return Boolean.valueOf(z);
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }
}
