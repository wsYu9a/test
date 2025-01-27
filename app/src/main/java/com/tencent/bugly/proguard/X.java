package com.tencent.bugly.proguard;

import android.util.Log;
import java.util.Locale;

/* loaded from: classes4.dex */
public class X {

    /* renamed from: a */
    public static String f25018a = "CrashReportInfo";

    /* renamed from: b */
    public static String f25019b = "CrashReport";

    /* renamed from: c */
    public static boolean f25020c = false;

    private static boolean a(int i2, String str, Object... objArr) {
        if (!f25020c) {
            return false;
        }
        String f2 = f(str, objArr);
        if (i2 == 0) {
            Log.i(f25019b, f2);
            return true;
        }
        if (i2 == 1) {
            Log.d(f25019b, f2);
            return true;
        }
        if (i2 == 2) {
            Log.w(f25019b, f2);
            return true;
        }
        if (i2 == 3) {
            Log.e(f25019b, f2);
            return true;
        }
        if (i2 != 5) {
            return false;
        }
        Log.i(f25018a, f2);
        return true;
    }

    public static boolean b(Throwable th) {
        return a(2, th);
    }

    public static boolean c(String str, Object... objArr) {
        return a(0, str, objArr);
    }

    public static boolean d(String str, Object... objArr) {
        return a(5, str, objArr);
    }

    public static boolean e(String str, Object... objArr) {
        return a(2, str, objArr);
    }

    private static String f(String str, Object... objArr) {
        return str == null ? "null" : (objArr == null || objArr.length == 0) ? str : String.format(Locale.US, str, objArr);
    }

    public static boolean b(String str, Object... objArr) {
        return a(3, str, objArr);
    }

    public static boolean c(Class cls, String str, Object... objArr) {
        return a(0, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean b(Class cls, String str, Object... objArr) {
        return a(3, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    private static boolean a(int i2, Throwable th) {
        if (f25020c) {
            return a(i2, ca.b(th), new Object[0]);
        }
        return false;
    }

    public static boolean a(String str, Object... objArr) {
        return a(1, str, objArr);
    }

    public static boolean a(Class cls, String str, Object... objArr) {
        return a(1, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean a(Throwable th) {
        return a(3, th);
    }
}
