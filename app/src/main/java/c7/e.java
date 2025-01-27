package c7;

import android.util.Log;

/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1710a = "mcssdk---";

    /* renamed from: b, reason: collision with root package name */
    public static String f1711b = "MCS";

    /* renamed from: c, reason: collision with root package name */
    public static boolean f1712c = false;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f1713d = false;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f1714e = true;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f1715f = true;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f1716g = true;

    /* renamed from: h, reason: collision with root package name */
    public static String f1717h = "-->";

    /* renamed from: i, reason: collision with root package name */
    public static boolean f1718i = true;

    public static void A(String str) {
        if (f1715f && f1718i) {
            Log.w(f1710a, f1711b + f1717h + str);
        }
    }

    public static void B(String str, String str2) {
        if (f1715f && f1718i) {
            Log.w(str, f1711b + f1717h + str2);
        }
    }

    public static void a(String str) {
        if (f1714e && f1718i) {
            Log.d(f1710a, f1711b + f1717h + str);
        }
    }

    public static void b(String str, String str2) {
        if (f1714e && f1718i) {
            Log.d(str, f1711b + f1717h + str2);
        }
    }

    public static void c(Exception exc) {
        if (f1716g) {
            exc.printStackTrace();
        }
    }

    public static void d(String str) {
        if (f1716g && f1718i) {
            Log.e(f1710a, f1711b + f1717h + str);
        }
    }

    public static void e(String str, String str2) {
        if (f1716g && f1718i) {
            Log.e(str, f1711b + f1717h + str2);
        }
    }

    public static void f(String str, Throwable th2) {
        if (f1716g) {
            Log.e(str, th2.toString());
        }
    }

    public static String g() {
        return f1717h;
    }

    public static String h() {
        return f1711b;
    }

    public static void i(String str) {
        if (f1713d && f1718i) {
            Log.i(f1710a, f1711b + f1717h + str);
        }
    }

    public static void j(String str, String str2) {
        if (f1713d && f1718i) {
            Log.i(str, f1711b + f1717h + str2);
        }
    }

    public static boolean k() {
        return f1714e;
    }

    public static boolean l() {
        return f1718i;
    }

    public static boolean m() {
        return f1716g;
    }

    public static boolean n() {
        return f1713d;
    }

    public static boolean o() {
        return f1712c;
    }

    public static boolean p() {
        return f1715f;
    }

    public static void q(boolean z10) {
        f1714e = z10;
    }

    public static void r(boolean z10) {
        f1718i = z10;
        boolean z11 = z10;
        f1712c = z11;
        f1714e = z11;
        f1713d = z11;
        f1715f = z11;
        f1716g = z11;
    }

    public static void s(boolean z10) {
        f1716g = z10;
    }

    public static void t(boolean z10) {
        f1713d = z10;
    }

    public static void u(String str) {
        f1717h = str;
    }

    public static void v(String str) {
        f1711b = str;
    }

    public static void w(boolean z10) {
        f1712c = z10;
    }

    public static void x(boolean z10) {
        f1715f = z10;
    }

    public static void y(String str) {
        if (f1712c && f1718i) {
            Log.v(f1710a, f1711b + f1717h + str);
        }
    }

    public static void z(String str, String str2) {
        if (f1712c && f1718i) {
            Log.v(str, f1711b + f1717h + str2);
        }
    }
}
