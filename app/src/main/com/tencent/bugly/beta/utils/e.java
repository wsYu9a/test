package com.tencent.bugly.beta.utils;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    private static Handler f22224a;

    private static Handler a() {
        if (f22224a == null && Looper.getMainLooper() != null) {
            f22224a = new Handler(Looper.getMainLooper());
        }
        return f22224a;
    }

    public static void b(Runnable runnable) {
        if (a() != null) {
            f22224a.removeCallbacks(runnable);
        }
    }

    public static void a(Runnable runnable) {
        if (a() != null) {
            f22224a.post(runnable);
        }
    }

    public static void a(Runnable runnable, long j10) {
        if (a() != null) {
            f22224a.postDelayed(runnable, j10);
        }
    }
}
