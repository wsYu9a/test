package com.shu.priory.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public class e {
    public static int a(Context context, String str) {
        return a(context).getInt(str, -1);
    }

    public static long b(Context context, String str) {
        return a(context).getLong(str, 0L);
    }

    public static String c(Context context, String str) {
        return a(context).getString(str, "");
    }

    public static boolean d(Context context, String str) {
        return a(context).getBoolean(str, false);
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("IFLY_AD_SHARED", 0);
    }

    public static void a(Context context, String str, int i10) {
        a(context).edit().putInt(str, i10).apply();
    }

    public static void a(Context context, String str, long j10) {
        a(context).edit().putLong(str, j10).apply();
    }

    public static void a(Context context, String str, String str2) {
        a(context).edit().putString(str, str2).apply();
    }

    public static void a(Context context, String str, boolean z10) {
        a(context).edit().putBoolean(str, z10).apply();
    }
}
