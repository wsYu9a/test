package com.heytap.mcssdk.o;

import android.util.Log;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f8936a = "mcssdk---";

    /* renamed from: b, reason: collision with root package name */
    private static String f8937b = "MCS";

    /* renamed from: c, reason: collision with root package name */
    private static boolean f8938c = false;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f8939d = false;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f8940e = true;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f8941f = true;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f8942g = true;

    /* renamed from: h, reason: collision with root package name */
    private static String f8943h = "-->";

    /* renamed from: i, reason: collision with root package name */
    private static boolean f8944i = true;

    public static void A(String str) {
        if (f8941f && f8944i) {
            Log.w(f8936a, f8937b + f8943h + str);
        }
    }

    public static void B(String str, String str2) {
        if (f8941f && f8944i) {
            Log.w(str, f8937b + f8943h + str2);
        }
    }

    public static void a(String str) {
        if (f8940e && f8944i) {
            Log.d(f8936a, f8937b + f8943h + str);
        }
    }

    public static void b(String str, String str2) {
        if (f8940e && f8944i) {
            Log.d(str, f8937b + f8943h + str2);
        }
    }

    public static void c(Exception exc) {
        if (f8942g) {
            exc.printStackTrace();
        }
    }

    public static void d(String str) {
        if (f8942g && f8944i) {
            Log.e(f8936a, f8937b + f8943h + str);
        }
    }

    public static void e(String str, String str2) {
        if (f8942g && f8944i) {
            Log.e(str, f8937b + f8943h + str2);
        }
    }

    public static void f(String str, Throwable th) {
        if (f8942g) {
            Log.e(str, th.toString());
        }
    }

    public static String g() {
        return f8943h;
    }

    public static String h() {
        return f8937b;
    }

    public static void i(String str) {
        if (f8939d && f8944i) {
            Log.i(f8936a, f8937b + f8943h + str);
        }
    }

    public static void j(String str, String str2) {
        if (f8939d && f8944i) {
            Log.i(str, f8937b + f8943h + str2);
        }
    }

    public static boolean k() {
        return f8940e;
    }

    public static boolean l() {
        return f8944i;
    }

    public static boolean m() {
        return f8942g;
    }

    public static boolean n() {
        return f8939d;
    }

    public static boolean o() {
        return f8938c;
    }

    public static boolean p() {
        return f8941f;
    }

    public static void q(boolean z) {
        f8940e = z;
    }

    public static void r(boolean z) {
        f8944i = z;
        boolean z2 = z;
        f8938c = z2;
        f8940e = z2;
        f8939d = z2;
        f8941f = z2;
        f8942g = z2;
    }

    public static void s(boolean z) {
        f8942g = z;
    }

    public static void t(boolean z) {
        f8939d = z;
    }

    public static void u(String str) {
        f8943h = str;
    }

    public static void v(String str) {
        f8937b = str;
    }

    public static void w(boolean z) {
        f8938c = z;
    }

    public static void x(boolean z) {
        f8941f = z;
    }

    public static void y(String str) {
        if (f8938c && f8944i) {
            Log.v(f8936a, f8937b + f8943h + str);
        }
    }

    public static void z(String str, String str2) {
        if (f8938c && f8944i) {
            Log.v(str, f8937b + f8943h + str2);
        }
    }
}
