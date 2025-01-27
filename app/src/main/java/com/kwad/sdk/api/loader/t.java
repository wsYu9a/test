package com.kwad.sdk.api.loader;

import android.annotation.SuppressLint;
import android.content.Context;

/* loaded from: classes2.dex */
public final class t {
    @SuppressLint({"ApplySharedPref"})
    public static void a(Context context, String str, long j2) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putLong(str, j2).commit();
        } catch (Throwable unused) {
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public static void a(Context context, String str, boolean z) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean(str, z).commit();
        } catch (Throwable unused) {
        }
    }

    private static long b(Context context, String str, long j2) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getLong(str, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static boolean b(Context context, String str, boolean z) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getBoolean(str, false);
        } catch (Throwable unused) {
            return false;
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public static void c(Context context, String str, String str2) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putString(str, str2).commit();
        } catch (Throwable unused) {
        }
    }

    public static String d(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static String getString(Context context, String str) {
        return d(context, str, "");
    }

    public static long s(Context context, String str) {
        return b(context, str, 0L);
    }
}
