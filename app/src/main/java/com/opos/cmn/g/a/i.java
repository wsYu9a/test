package com.opos.cmn.g.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public abstract class i {

    /* renamed from: a */
    private static final String f17412a = "i";

    public static String a(Context context) {
        SharedPreferences g2 = g(context);
        return g2 != null ? g2.getString("ouid", "") : "";
    }

    public static void a(Context context, String str) {
        SharedPreferences g2;
        if (TextUtils.isEmpty(str) || (g2 = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g2.edit();
        edit.putString("ouid", str);
        edit.apply();
    }

    public static void a(Context context, boolean z) {
        SharedPreferences g2 = g(context);
        if (g2 != null) {
            SharedPreferences.Editor edit = g2.edit();
            edit.putBoolean("ouid_status", z);
            edit.apply();
        }
    }

    public static String b(Context context) {
        SharedPreferences g2 = g(context);
        return g2 != null ? g2.getString("duid", "") : "";
    }

    public static void b(Context context, String str) {
        SharedPreferences g2;
        if (TextUtils.isEmpty(str) || (g2 = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g2.edit();
        edit.putString("duid", str);
        edit.apply();
    }

    public static void b(Context context, boolean z) {
        SharedPreferences g2 = g(context);
        if (g2 != null) {
            SharedPreferences.Editor edit = g2.edit();
            edit.putBoolean("gaid_status", z);
            edit.apply();
        }
    }

    public static String c(Context context) {
        SharedPreferences g2 = g(context);
        return g2 != null ? g2.getString("guid", "") : "";
    }

    public static void c(Context context, String str) {
        SharedPreferences g2;
        if (TextUtils.isEmpty(str) || (g2 = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g2.edit();
        edit.putString("guid", str);
        edit.apply();
    }

    public static String d(Context context) {
        SharedPreferences g2 = g(context);
        return g2 != null ? g2.getString("gaid", "") : "";
    }

    public static void d(Context context, String str) {
        SharedPreferences g2;
        if (TextUtils.isEmpty(str) || (g2 = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g2.edit();
        edit.putString("gaid", str);
        edit.apply();
    }

    public static void e(Context context, String str) {
        SharedPreferences g2;
        if (TextUtils.isEmpty(str) || (g2 = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g2.edit();
        edit.putString("localId", str);
        edit.apply();
    }

    public static boolean e(Context context) {
        SharedPreferences g2 = g(context);
        if (g2 != null) {
            return g2.getBoolean("ouid_status", false);
        }
        return false;
    }

    public static String f(Context context) {
        SharedPreferences g2 = g(context);
        return g2 != null ? g2.getString("localId", "") : "";
    }

    private static final SharedPreferences g(Context context) {
        return context.getSharedPreferences("com.opos.cmn.third.id.prefs", 0);
    }
}
