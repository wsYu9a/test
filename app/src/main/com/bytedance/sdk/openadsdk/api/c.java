package com.bytedance.sdk.openadsdk.api;

import android.util.Log;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f8038a = false;

    /* renamed from: b, reason: collision with root package name */
    private static int f8039b = 4;

    public static void a(int i10) {
        f8039b = i10;
    }

    public static void b(String str, String str2) {
        if (f8038a && str2 != null && f8039b <= 3) {
            Log.d(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (f8038a && str2 != null && f8039b <= 4) {
            Log.i(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (f8038a && str2 != null && f8039b <= 5) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (f8038a && str2 != null && f8039b <= 6) {
            Log.e(str, str2);
        }
    }

    public static void a() {
        f8038a = true;
        a(3);
    }

    public static void a(String str, String str2) {
        if (f8038a && str2 != null && f8039b <= 2) {
            Log.v(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th2) {
        if (f8038a) {
            if (!(str2 == null && th2 == null) && f8039b <= 5) {
                Log.w(str, str2, th2);
            }
        }
    }

    public static void c(String str, String str2, Throwable th2) {
        if (f8038a) {
            if (!(str2 == null && th2 == null) && f8039b <= 6) {
                Log.e(str, str2, th2);
            }
        }
    }

    public static void a(String str, String str2, Throwable th2) {
        if (f8038a) {
            if (!(str2 == null && th2 == null) && f8039b <= 3) {
                Log.d(str, str2, th2);
            }
        }
    }

    public static void b(String str, Object... objArr) {
        if (f8038a && objArr != null && f8039b <= 5) {
            Log.v(str, a(objArr));
        }
    }

    public static void a(String str, Object... objArr) {
        if (f8038a && objArr != null && f8039b <= 3) {
            Log.d(str, a(objArr));
        }
    }

    public static void a(String str) {
        if (f8038a) {
            d("TTLogger", str);
        }
    }

    private static String a(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            StringBuilder sb2 = new StringBuilder();
            for (Object obj : objArr) {
                if (obj != null) {
                    sb2.append(obj.toString());
                } else {
                    sb2.append(" null ");
                }
                sb2.append(" ");
            }
            return sb2.toString();
        }
        return "";
    }
}
