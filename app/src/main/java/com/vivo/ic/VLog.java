package com.vivo.ic;

import android.text.TextUtils;
import j.a.b;

/* loaded from: classes4.dex */
public class VLog {
    static String PRE_TAG = "LIB-";
    static final String PRE_TAG_DEFAULT = "LIB-";
    static boolean isVLoggable = true;
    static boolean isDLoggable = SystemUtils.getSystemProperties("persist.sys.log.ctrl", "no").equals("yes");
    static boolean isILoggable = true;
    static boolean isWLoggable = true;
    static boolean isELoggable = true;

    public static void d(String str, String str2) {
        if (isDLoggable) {
            b.a(PRE_TAG + str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (isELoggable) {
            b.c(PRE_TAG + str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (isILoggable) {
            b.f(PRE_TAG + str, str2);
        }
    }

    public static void setPreTag(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PRE_TAG = str;
    }

    public static void v(String str, String str2) {
        if (isVLoggable) {
            b.j(PRE_TAG + str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (isWLoggable) {
            b.m(PRE_TAG + str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (isDLoggable) {
            b.b(PRE_TAG + str, str2, th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (isELoggable) {
            b.d(PRE_TAG + str, str2, th);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (isILoggable) {
            b.g(PRE_TAG + str, str2, th);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (isVLoggable) {
            b.k(PRE_TAG + str, str2, th);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (isWLoggable) {
            b.n(PRE_TAG + str, str2, th);
        }
    }
}
