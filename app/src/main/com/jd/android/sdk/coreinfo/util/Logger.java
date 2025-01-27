package com.jd.android.sdk.coreinfo.util;

import android.util.Log;

/* loaded from: classes2.dex */
public class Logger {
    public static boolean D = false;
    public static boolean E = false;
    public static boolean I = false;
    public static boolean W = false;
    public static boolean printStack = false;

    public static void d(String str, String str2) {
        if (D) {
            Log.d(str, str2);
        }
    }

    public static void debugWithStackTrace(String str, String str2) {
        if (D) {
            Log.d(str, str2);
            if (printStack) {
                Log.d(str, getStackTrace());
            }
        }
    }

    public static void e(String str, String str2) {
        if (E) {
            Log.e(str, str2);
        }
    }

    public static void enableLogger(boolean z10) {
        E = z10;
        W = z10;
        I = z10;
        D = z10;
    }

    public static void errorWithStackTrace(String str, String str2) {
        if (E) {
            Log.e(str, str2);
            if (printStack) {
                Log.e(str, getStackTrace());
            }
        }
    }

    public static String getStackTrace() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuilder sb2 = new StringBuilder("stacktrace: \n");
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb2.append(stackTraceElement.toString());
                sb2.append("\n");
            }
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void i(String str, String str2) {
        if (I) {
            Log.i(str, str2);
        }
    }

    public static void infoWithStackTrace(String str, String str2) {
        if (I) {
            Log.i(str, str2);
            if (printStack) {
                Log.i(str, getStackTrace());
            }
        }
    }

    public static void w(String str, String str2) {
        if (W) {
            Log.w(str, str2);
        }
    }

    public static void warnWithStackTrace(String str, String str2) {
        if (W) {
            Log.w(str, str2);
            if (printStack) {
                Log.w(str, getStackTrace());
            }
        }
    }

    public static void e(String str, String str2, Throwable th2) {
        if (E) {
            Log.e(str, str2, th2);
        }
    }
}
