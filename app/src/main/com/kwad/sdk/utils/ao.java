package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class ao {
    private static long aUa;
    private static long aUb;
    private static HashMap<String, PackageInfo> aUc;
    public static String[] requestedPermissions = new String[0];
    public static AtomicBoolean LB = new AtomicBoolean(false);

    private static synchronized boolean NT() {
        synchronized (ao.class) {
            if (aUa <= 0) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - aUb <= aUa) {
                return false;
            }
            aUb = currentTimeMillis;
            return true;
        }
    }

    @RequiresApi(api = 26)
    public static boolean cH(Context context) {
        boolean canRequestPackageInstalls;
        try {
            init(context);
            canRequestPackageInstalls = context.getPackageManager().canRequestPackageInstalls();
            return canRequestPackageInstalls;
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            return false;
        }
    }

    @Nullable
    public static String[] cI(Context context) {
        String[] strArr = requestedPermissions;
        if (strArr != null && strArr.length > 0) {
            return strArr;
        }
        try {
            PackageInfo packageInfo = getPackageInfo(context, context.getPackageName(), 4096);
            if (packageInfo == null) {
                return null;
            }
            String[] strArr2 = packageInfo.requestedPermissions;
            requestedPermissions = strArr2;
            return strArr2;
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            return null;
        }
    }

    public static PackageInfo d(Context context, String str, int i10) {
        PackageInfo packageInfo;
        try {
            init(context);
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
        }
        if (!NT()) {
            com.kwad.sdk.core.d.c.d("PackageInfoLimiter", "调用频次过高，跳过本次调用");
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        HashMap<String, PackageInfo> hashMap = aUc;
        if (hashMap != null) {
            hashMap.put(str, packageInfo);
        }
        return packageInfo;
    }

    public static PackageInfo getPackageInfo(Context context, String str, int i10) {
        HashMap<String, PackageInfo> hashMap;
        PackageInfo packageInfo;
        try {
            init(context);
            hashMap = aUc;
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
        }
        if (hashMap != null && hashMap.containsKey(str)) {
            return aUc.get(str);
        }
        if (!NT()) {
            com.kwad.sdk.core.d.c.d("PackageInfoLimiter", "调用频次过高，跳过本次调用");
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, i10);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        HashMap<String, PackageInfo> hashMap2 = aUc;
        if (hashMap2 != null) {
            hashMap2.put(str, packageInfo);
        }
        return packageInfo;
    }

    private static void init(Context context) {
        if (LB.compareAndSet(false, true)) {
            long j10 = context.getSharedPreferences("ksadsdk_config", 0).getLong("packageInfoLimiter", 0L);
            aUa = j10;
            if (j10 > 0) {
                aUc = new HashMap<>();
            }
        }
    }
}
