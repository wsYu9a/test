package com.bytedance.pangle.d;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static Executor f6038a = Executors.newCachedThreadPool(new ThreadFactory() { // from class: com.bytedance.pangle.d.e.1

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f6041a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pangle-Fast-" + this.f6041a.getAndIncrement());
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private static final Object f6039b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static Handler f6040c = null;

    public static void a(Runnable runnable) {
        f6038a.execute(runnable);
    }

    public static void b(Runnable runnable) {
        if (a().getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            a().post(runnable);
        }
    }

    public static ExecutorService a(int i2) {
        return Executors.newFixedThreadPool(i2, new ThreadFactory() { // from class: com.bytedance.pangle.d.e.2

            /* renamed from: a, reason: collision with root package name */
            private final AtomicInteger f6042a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "pangle-Install-" + this.f6042a.getAndIncrement());
            }
        });
    }

    private static Handler a() {
        Handler handler;
        synchronized (f6039b) {
            if (f6040c == null) {
                f6040c = new Handler(Looper.getMainLooper());
            }
            handler = f6040c;
        }
        return handler;
    }
}
