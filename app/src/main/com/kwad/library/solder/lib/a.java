package com.kwad.library.solder.lib;

import android.util.Log;

/* loaded from: classes3.dex */
public final class a {
    private static String C(String str, String str2) {
        return "[" + str + "]: " + str2 + " " + yd();
    }

    public static void e(String str, String str2) {
        Log.e("Sodler", C(str, str2));
    }

    private static String yd() {
        return "";
    }

    public static void e(String str, Throwable th2) {
        Log.e("Sodler", C(str, ""), th2);
    }

    public static void e(String str, String str2, Throwable th2) {
        Log.e("Sodler", C(str, str2), th2);
    }
}
