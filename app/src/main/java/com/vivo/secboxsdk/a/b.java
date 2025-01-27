package com.vivo.secboxsdk.a;

import android.util.Log;

/* loaded from: classes4.dex */
public final class b {
    private static String a(String str) {
        return "_V_".concat(String.valueOf(str));
    }

    public static int b(String str, String str2) {
        return Log.e(a(str), str2);
    }

    public static int a(String str, String str2) {
        return Log.i(a(str), str2);
    }

    public static int a(String str, String str2, Throwable th) {
        return Log.e(a(str), str2, th);
    }
}
