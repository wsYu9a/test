package me.jessyan.autosize.utils;

import android.util.Log;

/* loaded from: classes4.dex */
public class AutoSizeLog {
    private static final String TAG = "AndroidAutoSize";
    private static boolean debug;

    private AutoSizeLog() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    public static void d(String str) {
        if (debug) {
            Log.d(TAG, str);
        }
    }

    public static void e(String str) {
        if (debug) {
            Log.e(TAG, str);
        }
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean z10) {
        debug = z10;
    }

    public static void w(String str) {
        if (debug) {
            Log.w(TAG, str);
        }
    }
}
