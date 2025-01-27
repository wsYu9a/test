package com.aggmoread.sdk.z.b.m;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes.dex */
public final class e extends HandlerThread {

    /* renamed from: b, reason: collision with root package name */
    private static e f4700b;

    /* renamed from: c, reason: collision with root package name */
    private static Handler f4701c;

    private e() {
        super("AdSdk-api.bg.tasks", 0);
    }

    private static void a() {
        if (f4700b == null) {
            e eVar = new e();
            f4700b = eVar;
            eVar.start();
            f4701c = new Handler(f4700b.getLooper());
        }
    }

    public static Handler b() {
        Handler handler;
        synchronized (e.class) {
            a();
            handler = f4701c;
        }
        return handler;
    }

    public static void a(Runnable runnable) {
        b().removeCallbacks(runnable);
    }
}
