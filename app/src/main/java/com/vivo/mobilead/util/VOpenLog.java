package com.vivo.mobilead.util;

/* loaded from: classes4.dex */
public final class VOpenLog {
    private static final String PRE_TAG = "adsdk-open-";
    private static boolean sEnableLog = false;

    public static void d(String str, String str2) {
        if (sEnableLog) {
            j.a.b.a(PRE_TAG + str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (sEnableLog) {
            j.a.b.c(PRE_TAG + str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (sEnableLog) {
            j.a.b.f(PRE_TAG + str, str2);
        }
    }

    public static void setEnableLog(boolean z) {
        sEnableLog = z;
    }

    public static void v(String str, String str2) {
        if (sEnableLog) {
            j.a.b.j(PRE_TAG + str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (sEnableLog) {
            j.a.b.m(PRE_TAG + str, str2);
        }
    }
}
