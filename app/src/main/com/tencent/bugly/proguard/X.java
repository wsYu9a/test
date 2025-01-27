package com.tencent.bugly.proguard;

import android.util.Log;
import java.util.Locale;

/* loaded from: classes4.dex */
public class X {

    /* renamed from: a */
    public static String f22678a = "CrashReportInfo";

    /* renamed from: b */
    public static String f22679b = "CrashReport";

    /* renamed from: c */
    public static boolean f22680c = false;

    private static boolean a(int i10, String str, Object... objArr) {
        if (!f22680c) {
            return false;
        }
        String f10 = f(str, objArr);
        if (i10 == 0) {
            Log.i(f22679b, f10);
            return true;
        }
        if (i10 == 1) {
            Log.d(f22679b, f10);
            return true;
        }
        if (i10 == 2) {
            Log.w(f22679b, f10);
            return true;
        }
        if (i10 == 3) {
            Log.e(f22679b, f10);
            return true;
        }
        if (i10 != 5) {
            return false;
        }
        Log.i(f22678a, f10);
        return true;
    }

    public static boolean b(Throwable th2) {
        return a(2, th2);
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

    private static boolean a(int i10, Throwable th2) {
        if (f22680c) {
            return a(i10, ca.b(th2), new Object[0]);
        }
        return false;
    }

    public static boolean a(String str, Object... objArr) {
        return a(1, str, objArr);
    }

    public static boolean a(Class cls, String str, Object... objArr) {
        return a(1, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean a(Throwable th2) {
        return a(3, th2);
    }
}
