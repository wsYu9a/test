package com.martian.ttbook.b.a.k;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes4.dex */
public final class e extends HandlerThread {

    /* renamed from: a */
    private static e f15047a;

    /* renamed from: b */
    private static Handler f15048b;

    private e() {
        super("AdSdk-api.bg.tasks", 0);
    }

    private static void c() {
        if (f15047a == null) {
            e eVar = new e();
            f15047a = eVar;
            eVar.start();
            f15048b = new Handler(f15047a.getLooper());
        }
    }

    public static void d(Runnable runnable) {
        e().removeCallbacks(runnable);
    }

    public static Handler e() {
        Handler handler;
        synchronized (e.class) {
            c();
            handler = f15048b;
        }
        return handler;
    }
}
