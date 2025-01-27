package com.bytedance.sdk.openadsdk.api;

import android.util.Log;

/* loaded from: classes.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static boolean f6371j = false;
    private static int zx = 4;

    public static void g(String str, String str2) {
        if (f6371j && str2 != null && zx <= 5) {
            Log.w(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (f6371j && str2 != null && zx <= 4) {
            Log.i(str, str2);
        }
    }

    public static void j(int i2) {
        zx = i2;
    }

    public static void q(String str, String str2) {
        if (f6371j && str2 != null && zx <= 6) {
            Log.e(str, str2);
        }
    }

    public static void zx(String str, String str2) {
        if (f6371j && str2 != null && zx <= 3) {
            Log.d(str, str2);
        }
    }

    public static void j() {
        f6371j = true;
        j(3);
    }

    public static void j(String str, String str2) {
        if (f6371j && str2 != null && zx <= 2) {
            Log.v(str, str2);
        }
    }

    public static void zx(String str, String str2, Throwable th) {
        if (f6371j) {
            if (!(str2 == null && th == null) && zx <= 6) {
                Log.e(str, str2, th);
            }
        }
    }

    public static void j(String str) {
        if (f6371j) {
            g("TTLogger", str);
        }
    }

    public static void j(String str, String str2, Throwable th) {
        if (f6371j) {
            if (!(str2 == null && th == null) && zx <= 5) {
                Log.w(str, str2, th);
            }
        }
    }

    public static void j(String str, Object... objArr) {
        if (f6371j && objArr != null && zx <= 5) {
            Log.v(str, j(objArr));
        }
    }

    private static String j(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            } else {
                sb.append(" null ");
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}
