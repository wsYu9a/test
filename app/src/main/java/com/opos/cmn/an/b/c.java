package com.opos.cmn.an.b;

import android.content.Context;
import android.os.Build;

/* loaded from: classes4.dex */
public final class c {
    public static String a() {
        String str = Build.MODEL;
        return str != null ? str : "";
    }

    public static String a(Context context) {
        String str;
        String str2 = "";
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            try {
                if (Build.VERSION.SDK_INT > 28 ? !(applicationContext.checkCallingOrSelfPermission("android.permission.READ_PRIVILEGED_PHONE_STATE") != 0 || (str = Build.SERIAL) == null) : (str = Build.SERIAL) != null) {
                    str2 = str;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("OSBuildTool", "getSerial", e2);
            }
        }
        return str2;
    }

    public static int b() {
        return Build.VERSION.SDK_INT;
    }

    public static String c() {
        String str = Build.VERSION.RELEASE;
        return str != null ? str : "";
    }

    public static String d() {
        String str = Build.BRAND;
        return str != null ? str : "";
    }

    public static String e() {
        String str = Build.MANUFACTURER;
        return str != null ? str : "";
    }
}
