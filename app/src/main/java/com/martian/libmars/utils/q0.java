package com.martian.libmars.utils;

import android.util.Log;
import com.google.gson.Gson;

/* loaded from: classes.dex */
public class q0 {
    public static void a(String msg) {
        if (com.martian.libmars.d.h.F().J0()) {
            Log.d("adxDebug", msg);
        }
    }

    public static void b(Class clazz, String msg) {
        f(clazz.getSimpleName(), msg);
    }

    public static void c(Object obj, Object msg) {
        f(obj.getClass().getSimpleName(), new Gson().toJson(msg));
    }

    public static void d(Object obj, String msg) {
        f(obj.getClass().getSimpleName(), msg);
    }

    public static void e(String msg) {
        if (com.martian.libmars.d.h.F().J0()) {
            Log.d("zzz", msg);
        }
    }

    public static void f(String tag, String msg) {
        if (com.martian.libmars.d.h.F().J0()) {
            Log.d(tag, msg);
        }
    }

    public static void g(Class clazz, String msg) {
        i(clazz.getSimpleName(), msg);
    }

    public static void h(Object obj, String msg) {
        i(obj.getClass().getSimpleName(), msg);
    }

    public static void i(String tag, String msg) {
        Log.e(tag, msg);
    }
}
