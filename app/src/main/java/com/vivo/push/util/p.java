package com.vivo.push.util;

import android.content.Context;

/* loaded from: classes4.dex */
public final class p {

    /* renamed from: a */
    public static final o f25142a = new n();

    /* renamed from: b */
    private static boolean f25143b;

    /* renamed from: c */
    private static boolean f25144c;

    static {
        b();
    }

    public static boolean a() {
        return f25143b && f25144c;
    }

    private static void b() {
        f25143b = z.b("persist.sys.log.ctrl", "no").equals("yes");
    }

    public static int c(String str, String str2) {
        return f25142a.c(str, str2);
    }

    public static int d(String str, String str2) {
        return f25142a.d(str, str2);
    }

    public static int e(String str, String str2) {
        return f25142a.e(str, str2);
    }

    public static int b(String str, String str2) {
        return f25142a.b(str, str2);
    }

    public static void c(Context context, String str) {
        f25142a.c(context, str);
    }

    public static void a(boolean z10) {
        b();
        f25144c = z10;
    }

    public static int b(String str, String str2, Throwable th2) {
        return f25142a.b(str, str2, th2);
    }

    public static void b(Context context, String str) {
        f25142a.b(context, str);
    }

    public static int a(String str, String str2) {
        return f25142a.a(str, str2);
    }

    public static int a(String str, Throwable th2) {
        return f25142a.a(str, th2);
    }

    public static int a(String str, String str2, Throwable th2) {
        return f25142a.a(str, str2, th2);
    }

    public static String a(Throwable th2) {
        return f25142a.a(th2);
    }

    public static void a(Context context, String str) {
        f25142a.a(context, str);
    }
}
