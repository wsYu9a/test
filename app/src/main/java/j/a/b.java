package j.a;

import android.util.Log;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a */
    public static final int f35316a = 2;

    /* renamed from: b */
    public static final int f35317b = 3;

    /* renamed from: c */
    public static final int f35318c = 4;

    /* renamed from: d */
    public static final int f35319d = 5;

    /* renamed from: e */
    public static final int f35320e = 6;

    /* renamed from: f */
    public static final int f35321f = 7;

    /* renamed from: g */
    private static final String f35322g = "_V_";

    private b() {
    }

    public static int a(String str, String str2) {
        return Log.d(l(str), str2);
    }

    public static int b(String str, String str2, Throwable th) {
        return Log.d(l(str), str2, th);
    }

    public static int c(String str, String str2) {
        return Log.e(l(str), str2);
    }

    public static int d(String str, String str2, Throwable th) {
        return Log.e(l(str), str2, th);
    }

    public static String e(Throwable th) {
        return Log.getStackTraceString(th);
    }

    public static int f(String str, String str2) {
        return Log.i(l(str), str2);
    }

    public static int g(String str, String str2, Throwable th) {
        return Log.i(l(str), str2, th);
    }

    public static boolean h(String str, int i2) {
        return Log.isLoggable(str, i2);
    }

    public static int i(int i2, String str, String str2) {
        return Log.println(i2, l(str), str2);
    }

    public static int j(String str, String str2) {
        return Log.v(l(str), str2);
    }

    public static int k(String str, String str2, Throwable th) {
        return Log.v(l(str), str2, th);
    }

    private static String l(String str) {
        return f35322g + str;
    }

    public static int m(String str, String str2) {
        return Log.w(l(str), str2);
    }

    public static int n(String str, String str2, Throwable th) {
        return Log.w(l(str), str2, th);
    }

    public static int o(String str, Throwable th) {
        return Log.w(l(str), th);
    }

    public static int p(String str, String str2) {
        return Log.wtf(l(str), str2);
    }

    public static int q(String str, String str2, Throwable th) {
        return Log.wtf(l(str), str2, th);
    }

    public static int r(String str, Throwable th) {
        return Log.wtf(l(str), th);
    }
}
