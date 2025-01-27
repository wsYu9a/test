package com.vivo.mobilead.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class a1 {

    /* renamed from: a */
    private static HandlerThread f30532a = new HandlerThread("adsdk_thread");

    /* renamed from: b */
    private static ExecutorService f30533b = Executors.newCachedThreadPool();

    /* renamed from: c */
    private static ExecutorService f30534c = Executors.newCachedThreadPool();

    /* renamed from: d */
    private static Handler f30535d;

    private static class a {

        /* renamed from: a */
        private static final Handler f30536a = new Handler(Looper.getMainLooper());
    }

    static {
        f30532a.setPriority(5);
        f30532a.start();
        new ThreadPoolExecutor(1, 8, 10L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        f30535d = new Handler(f30532a.getLooper());
    }

    public static void a(Runnable runnable, long j2) {
        if (f30532a.getThreadId() == Process.myTid()) {
            runnable.run();
        } else {
            f30535d.postDelayed(runnable, j2);
        }
    }

    public static void b(Runnable runnable) {
        f30534c.execute(runnable);
    }

    public static void c(Runnable runnable) {
        f30533b.execute(runnable);
    }

    public static void d(Runnable runnable) {
        a.f30536a.post(runnable);
    }

    public static void e(Runnable runnable) {
        a(runnable, 0L);
    }

    public static void a(Runnable runnable) {
        f30535d.removeCallbacks(runnable);
    }

    public static <T> Future<T> a(Callable<T> callable) {
        return f30533b.submit(callable);
    }
}
