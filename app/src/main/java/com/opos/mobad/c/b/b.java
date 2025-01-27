package com.opos.mobad.c.b;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static Handler f20036a = new Handler(Looper.getMainLooper());

    public static final Handler a() {
        return f20036a;
    }

    public static void a(Runnable runnable) {
        f20036a.post(runnable);
    }

    public static final void a(Runnable runnable, long j2) {
        f20036a.postDelayed(runnable, j2);
    }

    public static final void b(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f20036a.post(runnable);
        }
    }
}
