package com.cdo.oaps.ad.compatible.base.launcher;

import android.util.Log;

/* loaded from: classes.dex */
public class OapsLog {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6524a = "oaps_sdk";

    /* renamed from: b, reason: collision with root package name */
    public static final String f6525b = "oaps_sdk_download";

    /* renamed from: c, reason: collision with root package name */
    public static final String f6526c = "oaps_sdk_storage";

    /* renamed from: d, reason: collision with root package name */
    public static final String f6527d = "oaps_sdk_listener";

    /* renamed from: e, reason: collision with root package name */
    private static final boolean f6528e = false;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f6529f;

    public static void d(String str, String str2) {
        if (f6529f) {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (f6529f) {
            Log.e(str, str2);
        }
    }

    public static void i(String str) {
        if (f6529f) {
            Log.i(f6524a, str);
        }
    }

    public static void i(String str, String str2) {
        if (f6529f) {
            Log.i(str, str2);
        }
    }

    public static boolean isDebugable() {
        return f6529f;
    }

    public static void setDebug(boolean z) {
        f6529f = z;
    }

    public static void w(String str, String str2) {
        if (f6529f) {
            Log.w(str, str2);
        }
    }
}
