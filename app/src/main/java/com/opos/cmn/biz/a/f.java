package com.opos.cmn.biz.a;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes4.dex */
public final class f {
    public static String a(Context context) {
        SharedPreferences c2 = c(context);
        String string = c2 != null ? c2.getString("LAST_BRAND", "") : "";
        com.opos.cmn.an.f.a.b("SPUtils", "getLastBrand=" + string);
        return string;
    }

    public static void a(Context context, String str) {
        try {
            SharedPreferences c2 = c(context);
            if (c2 == null || str == null) {
                return;
            }
            com.opos.cmn.an.f.a.b("SPUtils", "setLastBrand=" + str);
            SharedPreferences.Editor edit = c2.edit();
            edit.putString("LAST_BRAND", str);
            edit.commit();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("SPUtils", "setLastBrand", e2);
        }
    }

    public static String b(Context context) {
        SharedPreferences c2 = c(context);
        String string = c2 != null ? c2.getString("LAST_REGION", "") : "";
        com.opos.cmn.an.f.a.b("SPUtils", "getLastRegion=" + string);
        return string;
    }

    public static void b(Context context, String str) {
        try {
            SharedPreferences c2 = c(context);
            if (c2 == null || str == null) {
                return;
            }
            com.opos.cmn.an.f.a.b("SPUtils", "setLastRegion=" + str);
            SharedPreferences.Editor edit = c2.edit();
            edit.putString("LAST_REGION", str);
            edit.commit();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("SPUtils", "setLastRegion", e2);
        }
    }

    private static final SharedPreferences c(Context context) {
        return context.getSharedPreferences("com.opos.cmn.biz.ext.prefs", 0);
    }
}
