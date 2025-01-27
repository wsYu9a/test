package com.kwai.filedownloader.e;

import android.util.Log;

/* loaded from: classes2.dex */
public final class d {
    public static boolean aJq = false;

    private static void a(int i2, Object obj, String str, Object... objArr) {
        a(i2, obj, null, str, objArr);
    }

    private static void a(int i2, Object obj, Throwable th, String str, Object... objArr) {
        if ((i2 >= 5) || aJq) {
            Log.println(i2, l(obj), f.j(str, objArr));
            if (th != null) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Object obj, Throwable th, String str, Object... objArr) {
        a(6, obj, th, str, objArr);
    }

    public static void e(Object obj, String str, Object... objArr) {
        a(6, obj, str, objArr);
    }

    public static void f(Object obj, String str, Object... objArr) {
        a(4, obj, str, objArr);
    }

    public static void g(Object obj, String str, Object... objArr) {
        a(3, obj, str, objArr);
    }

    public static void h(Object obj, String str, Object... objArr) {
        a(5, obj, str, objArr);
    }

    public static void i(Object obj, String str, Object... objArr) {
        a(2, obj, str, objArr);
    }

    private static String l(Object obj) {
        StringBuilder sb = new StringBuilder("FileDownloader.");
        sb.append((obj instanceof Class ? (Class) obj : obj.getClass()).getSimpleName());
        return sb.toString();
    }
}
