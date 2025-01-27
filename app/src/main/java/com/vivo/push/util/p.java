package com.vivo.push.util;

import android.content.Context;

/* loaded from: classes4.dex */
public final class p {

    /* renamed from: a */
    public static final o f31106a = new n();

    /* renamed from: b */
    private static boolean f31107b;

    /* renamed from: c */
    private static boolean f31108c;

    static {
        b();
    }

    public static boolean a() {
        return f31107b && f31108c;
    }

    private static void b() {
        f31107b = z.b("persist.sys.log.ctrl", "no").equals("yes");
    }

    public static int c(String str, String str2) {
        return f31106a.c(str, str2);
    }

    public static int d(String str, String str2) {
        return f31106a.d(str, str2);
    }

    public static int e(String str, String str2) {
        return f31106a.e(str, str2);
    }

    public static int b(String str, String str2) {
        return f31106a.b(str, str2);
    }

    public static void c(Context context, String str) {
        f31106a.c(context, str);
    }

    public static void a(boolean z) {
        b();
        f31108c = z;
    }

    public static int b(String str, String str2, Throwable th) {
        return f31106a.b(str, str2, th);
    }

    public static void b(Context context, String str) {
        f31106a.b(context, str);
    }

    public static int a(String str, String str2) {
        return f31106a.a(str, str2);
    }

    public static int a(String str, Throwable th) {
        return f31106a.a(str, th);
    }

    public static int a(String str, String str2, Throwable th) {
        return f31106a.a(str, str2, th);
    }

    public static String a(Throwable th) {
        return f31106a.a(th);
    }

    public static void a(Context context, String str) {
        f31106a.a(context, str);
    }
}
