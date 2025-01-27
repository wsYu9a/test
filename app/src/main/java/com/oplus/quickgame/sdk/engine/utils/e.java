package com.oplus.quickgame.sdk.engine.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.oplus.quickgame.sdk.engine.ui.MD5Util;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    private static String f16218a = "";

    /* renamed from: b */
    private static boolean f16219b = false;

    /* renamed from: c */
    private static boolean f16220c = false;

    /* renamed from: e */
    private static String f16222e = "";

    /* renamed from: f */
    private static boolean f16223f;

    /* renamed from: g */
    private static Handler f16224g;

    /* renamed from: h */
    private static HandlerThread f16225h;

    /* renamed from: d */
    private static Object f16221d = new Object();

    /* renamed from: i */
    private static final Object f16226i = new Object();

    static final class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f16227a;

        a(Context context) {
            this.f16227a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (TextUtils.isEmpty(e.f16222e)) {
                    e.e(this.f16227a);
                    String unused = e.f16222e = b.h.b.a.a.g(this.f16227a);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void a(Context context, h hVar) {
        String str = f16218a;
        String b2 = b.c.a.b.f.f4313d.b(context);
        if (!b(b2) || TextUtils.equals(b2, str)) {
            return;
        }
        a(context, b2);
        f16218a = b2;
        hVar.a(str, b2);
    }

    private static void a(Context context, String str) {
        String b2 = b.b(MD5Util.md5Hex(context.getPackageName()), str);
        SharedPreferences.Editor edit = context.getSharedPreferences("com.nearme.common.util.DeviceUtil", 0).edit();
        edit.putString("imei", b2);
        edit.commit();
    }

    protected static Handler b() {
        Handler handler;
        synchronized (f16226i) {
            HandlerThread handlerThread = f16225h;
            if (handlerThread == null || !handlerThread.isAlive()) {
                HandlerThread handlerThread2 = new HandlerThread("xgame_getDeviceId");
                f16225h = handlerThread2;
                handlerThread2.start();
                Looper looper = f16225h.getLooper();
                f16224g = looper != null ? new Handler(looper) : new Handler();
            }
            handler = f16224g;
        }
        return handler;
    }

    public static String b(Context context) {
        return b(context, null);
    }

    public static String b(Context context, h hVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        synchronized (e.class) {
            try {
                if (!b(f16218a)) {
                    String c2 = c(context);
                    f16218a = c2;
                    if (!b(c2)) {
                        String b2 = b.c.a.b.f.f4313d.b(context);
                        f16218a = b2;
                        if (b(b2)) {
                            a(context, f16218a);
                        }
                    }
                }
                if (hVar != null && (!f16219b || f16223f)) {
                    f16223f = false;
                    a(context, hVar);
                    f16219b = true;
                }
            } catch (Throwable unused) {
            }
        }
        return f16218a;
    }

    private static boolean b(String str) {
        return (TextUtils.isEmpty(str) || "000000000000000".equals(str)) ? false : true;
    }

    public static int c() {
        return Build.VERSION.SDK_INT;
    }

    private static String c(Context context) {
        String string = context.getSharedPreferences("com.nearme.common.util.DeviceUtil", 0).getString("imei", f16218a);
        if (!TextUtils.isEmpty(string)) {
            try {
                return com.oplus.quickgame.sdk.engine.utils.a.a(MD5Util.md5Hex(context.getPackageName()), string);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return "";
    }

    public static String d(Context context) {
        if (Build.VERSION.SDK_INT < 29) {
            return "";
        }
        b().post(new a(context));
        return f16222e;
    }

    public static void e(Context context) {
        if (f16220c) {
            return;
        }
        synchronized (f16221d) {
            if (!f16220c) {
                b.h.b.a.a.c(context);
                f16220c = true;
            }
        }
    }
}
