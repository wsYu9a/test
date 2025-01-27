package com.sigmob.sdk.base.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.czhj.sdk.common.mta.PointEntitySuper;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.AppInfo;
import com.sigmob.sdk.base.models.rtb.Ad;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.windad.WindAdError;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    public static Boolean f17741a;

    /* JADX WARN: Code restructure failed: missing block: B:39:0x008d, code lost:
    
        r3 = com.sigmob.sdk.a.d().getPackageManager().getProviderInfo(new android.content.ComponentName(com.sigmob.sdk.a.d(), r7.name), 128).metaData;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a8, code lost:
    
        if (r3 == null) goto L221;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00aa, code lost:
    
        r3 = r3.getInt("android.support.FILE_PROVIDER_PATHS");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized boolean a() {
        /*
            Method dump skipped, instructions count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.f.a():boolean");
    }

    public static WindAdError b() {
        Context d10 = com.sigmob.sdk.a.d();
        try {
            SigmobLog.e("checkActivity: " + AdActivity.class.getName());
            d10.getPackageManager().getActivityInfo(new ComponentName(d10, (Class<?>) AdActivity.class), 128);
        } catch (PackageManager.NameNotFoundException e10) {
            SigmobLog.e("checkActivity: " + e10.getMessage());
            return WindAdError.ERROR_LOAD_FILTER_FOR_ACTIVITY_ERROR;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            if (!Ad.class.getName().endsWith("base.models.rtb.Ad")) {
                SigmobLog.e("checkProguard Ad: " + Ad.class.getName());
                return WindAdError.ERROR_LOAD_FILTER_FOR_PROGUARD_ERROR;
            }
            if (!MaterialMeta.class.getName().endsWith("base.models.rtb.MaterialMeta")) {
                SigmobLog.e("checkProguard Strategy: " + MaterialMeta.class.getName());
                return WindAdError.ERROR_LOAD_FILTER_FOR_PROGUARD_ERROR;
            }
            if (!AppInfo.class.getName().endsWith("base.models.AppInfo")) {
                SigmobLog.e("checkProguard AppInfo: " + AppInfo.class.getName());
                return WindAdError.ERROR_LOAD_FILTER_FOR_PROGUARD_ERROR;
            }
            if (PointEntitySuper.class.getName().endsWith("common.mta.PointEntitySuper")) {
                return null;
            }
            SigmobLog.e("checkProguard PointCategory: " + PointEntitySuper.class.getName());
            return WindAdError.ERROR_LOAD_FILTER_FOR_PROGUARD_ERROR;
        } catch (Throwable th3) {
            SigmobLog.e("checkProguard: " + th3.getMessage());
            return null;
        }
    }

    public static String[] c() {
        Context d10 = com.sigmob.sdk.a.d();
        if (d10 == null) {
            return null;
        }
        try {
            return d10.getPackageManager().getPackageInfo(d10.getPackageName(), 4096).requestedPermissions;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean d() {
        String[] c10 = c();
        if (c10 != null) {
            for (String str : c10) {
                if (str.equals("android.permission.QUERY_ALL_PACKAGES")) {
                    return true;
                }
            }
        }
        return false;
    }
}
