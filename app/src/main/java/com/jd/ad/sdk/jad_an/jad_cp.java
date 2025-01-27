package com.jd.ad.sdk.jad_an;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.jd.android.sdk.coreinfo.util.Logger;

/* loaded from: classes2.dex */
public final class jad_cp {
    public static String jad_an = "";
    public static String jad_bo = "";
    public static String jad_cp = "";
    public static int jad_dq;
    public static long jad_er;
    public static long jad_fs;
    public static long jad_jt;

    public static PackageInfo jad_an(Context context, int i10) {
        try {
            return context.getPackageManager().getPackageInfo(jad_an(context), i10);
        } catch (Exception e10) {
            Logger.e("AppInfo", "An exception happends when call getPackageInfo().", e10);
            return null;
        }
    }

    public static long jad_bo(Context context) {
        String str;
        if (jad_jt <= 0) {
            if (context == null) {
                str = "context is null";
            } else {
                if (jad_an(context, 64) == null) {
                    str = "packageInfo is null";
                } else {
                    jad_jt = r5.signatures[0].hashCode();
                }
            }
            Logger.w("AppInfo", str);
            return 0L;
        }
        return jad_jt;
    }

    public static String jad_an(Context context) {
        if (TextUtils.isEmpty(jad_bo)) {
            if (context == null) {
                Logger.w("AppInfo", "context is null");
                return "";
            }
            jad_bo = context.getPackageName();
        }
        return jad_bo;
    }
}
