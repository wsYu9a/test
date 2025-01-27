package com.vivo.advv.vaf.virtualview.util;

import android.util.Log;

/* loaded from: classes4.dex */
public class VVLog {
    private static final String PRE_TAG = "_VV_";
    private static boolean sEnableLog = false;

    private VVLog() {
    }

    public static void d(String str, String str2) {
        if (sEnableLog) {
            Log.d(PRE_TAG + str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (sEnableLog) {
            Log.e(PRE_TAG + str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (sEnableLog) {
            Log.i(PRE_TAG + str, str2);
        }
    }

    public static void setEnableLog(boolean z) {
        sEnableLog = z;
    }

    public static void v(String str, String str2) {
        if (sEnableLog) {
            Log.v(PRE_TAG + str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (sEnableLog) {
            Log.w(PRE_TAG + str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (sEnableLog) {
            Log.d(PRE_TAG + str, str2, th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (sEnableLog) {
            Log.e(PRE_TAG + str, str2, th);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (sEnableLog) {
            Log.w(PRE_TAG + str, str2, th);
        }
    }
}
