package com.vivo.mobilead.util.f1;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class c {

    private static class a {

        /* renamed from: a */
        private static final ThreadPoolExecutor f30626a = new ThreadPoolExecutor(4, 4, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new com.vivo.mobilead.util.f1.a("ad_common"));
    }

    private static class b {

        /* renamed from: a */
        private static final HandlerThread f30627a;

        /* renamed from: b */
        private static Handler f30628b;

        static {
            HandlerThread handlerThread = new HandlerThread("ad_delay");
            f30627a = handlerThread;
            handlerThread.start();
            f30628b = new Handler(handlerThread.getLooper());
        }
    }

    /* renamed from: com.vivo.mobilead.util.f1.c$c */
    private static class C0668c {

        /* renamed from: a */
        private static final ThreadPoolExecutor f30629a = new ThreadPoolExecutor(2, 2, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new com.vivo.mobilead.util.f1.a("ad_report"));
    }

    private static class d {

        /* renamed from: a */
        private static final Handler f30630a = new Handler(Looper.getMainLooper());
    }

    public static void a(Runnable runnable) {
        a.f30626a.execute(runnable);
    }

    public static void b(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            a.f30626a.execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static void c(Runnable runnable) {
        C0668c.f30629a.execute(runnable);
    }

    public static void d(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            d.f30630a.post(runnable);
        }
    }

    public static void e(Runnable runnable) {
        d.f30630a.removeCallbacks(runnable);
    }

    public static void a(Runnable runnable, long j2) {
        b.f30628b.removeCallbacksAndMessages(null);
        b.f30628b.postDelayed(runnable, j2);
    }

    public static void a() {
        b.f30628b.removeCallbacksAndMessages(null);
    }

    public static void b(Runnable runnable, long j2) {
        d.f30630a.postDelayed(runnable, j2);
    }
}
