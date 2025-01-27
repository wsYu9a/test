package com.opos.mobad.service;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private static Handler f23546a = new Handler(Looper.getMainLooper());

    public static final Handler a() {
        return f23546a;
    }

    public static void a(Runnable runnable) {
        f23546a.post(runnable);
    }

    public static final void a(Runnable runnable, long j2) {
        f23546a.postDelayed(runnable, j2);
    }

    public static final void b(Runnable runnable) {
        f23546a.removeCallbacks(runnable);
    }

    public static final void c(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f23546a.post(runnable);
        }
    }
}
