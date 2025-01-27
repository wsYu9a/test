package com.vivo.mobilead.manager;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.vivo.ad.model.n;
import com.vivo.mobilead.util.x0;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private static volatile d f29526a;

    private d() {
    }

    public static d a() {
        if (f29526a == null) {
            synchronized (d.class) {
                if (f29526a == null) {
                    f29526a = new d();
                }
            }
        }
        return f29526a;
    }

    public n a(Context context) {
        PackageInfo packageInfo = null;
        if (context == null) {
            return null;
        }
        n nVar = new n();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                packageInfo = packageManager.getPackageInfo("com.vivo.hybrid", 128);
            } catch (Exception e2) {
                x0.a("RpkManager", "getHybridPlatformInfo exception: ", e2);
            }
        }
        if (packageInfo != null) {
            nVar.a(packageInfo.versionCode);
            nVar.a(packageInfo.versionName);
            Bundle bundle = packageInfo.applicationInfo.metaData;
            if (bundle != null) {
                Object obj = bundle.get("platformVersion");
                Object obj2 = bundle.get("platformVersionName");
                if (obj != null) {
                    nVar.b(Integer.valueOf(obj.toString()).intValue());
                }
                if (obj2 != null) {
                    nVar.b(obj2.toString());
                }
            }
        }
        return nVar;
    }
}
