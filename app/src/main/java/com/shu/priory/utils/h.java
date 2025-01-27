package com.shu.priory.utils;

import android.util.Log;

/* loaded from: classes3.dex */
public class h {

    /* renamed from: a */
    private static boolean f17310a = false;

    public static void a(String str, String str2) {
        if (f17310a) {
            e(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (f17310a) {
            Log.i(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (f17310a) {
            Log.w(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (f17310a) {
            Log.e(str, str2);
            g.a(str2);
        }
    }

    private static void e(String str, String str2) {
        int length = 2001 - str.length();
        while (str2.length() > length) {
            Log.d(str, str2.substring(0, length));
            str2 = str2.substring(length);
        }
        Log.d(str, str2);
    }

    public static void a(boolean z10) {
        f17310a = z10;
    }
}
