package com.tencent.bugly.beta.utils;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    private static Handler f24703a;

    private static Handler a() {
        if (f24703a == null && Looper.getMainLooper() != null) {
            f24703a = new Handler(Looper.getMainLooper());
        }
        return f24703a;
    }

    public static void b(Runnable runnable) {
        if (a() != null) {
            f24703a.removeCallbacks(runnable);
        }
    }

    public static void a(Runnable runnable) {
        if (a() != null) {
            f24703a.post(runnable);
        }
    }

    public static void a(Runnable runnable, long j2) {
        if (a() != null) {
            f24703a.postDelayed(runnable, j2);
        }
    }
}
