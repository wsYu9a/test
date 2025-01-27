package com.alimm.tanx.core.web.cache;

import android.util.Log;

/* loaded from: classes.dex */
class CacheWebViewLog {
    private static final String TAG = "WebViewCache";

    public static void d(String str) {
        Log.d(TAG, str);
    }

    public static void d(String str, boolean z10) {
        if (z10) {
            d(str);
        }
    }
}
