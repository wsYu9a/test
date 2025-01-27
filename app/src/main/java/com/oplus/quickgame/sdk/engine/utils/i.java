package com.oplus.quickgame.sdk.engine.utils;

import android.util.Log;

/* loaded from: classes4.dex */
public class i {

    /* renamed from: a */
    private static boolean f16238a;

    public static void a() {
        f16238a = true;
    }

    public static void a(String str, String str2) {
        if (f16238a) {
            Log.d(str, str2);
        }
    }

    public static void b() {
        f16238a = false;
    }

    public static void b(String str, String str2) {
        Log.e(str, str2);
    }

    public static void c(String str, String str2) {
        if (f16238a) {
            Log.i(str, str2);
        }
    }
}
