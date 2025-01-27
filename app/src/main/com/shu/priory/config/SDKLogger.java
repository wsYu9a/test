package com.shu.priory.config;

import android.util.Log;

/* loaded from: classes3.dex */
public class SDKLogger {
    public static boolean dev = false;

    public static void d(String str) {
        if (dev) {
            Log.d(SDKConstants.TAG, str);
        }
    }

    public static void e(String str) {
        if (dev) {
            Log.e(SDKConstants.TAG, str);
        }
    }

    public static void setDebug(boolean z10) {
        dev = z10;
    }

    public static void d(String str, String str2) {
        if (dev) {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (dev) {
            Log.e(str, str2);
        }
    }
}
