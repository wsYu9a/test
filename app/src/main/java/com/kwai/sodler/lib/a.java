package com.kwai.sodler.lib;

import android.util.Log;

/* loaded from: classes2.dex */
public final class a {
    public static void e(String str, String str2) {
        Log.e(str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }

    public static void e(String str, Throwable th) {
        Log.e(str, "", th);
    }

    public static void w(String str, String str2) {
        Log.w(str, str2);
    }
}
