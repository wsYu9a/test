package com.bytedance.pangle.d;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static Executor f7533a = Executors.newCachedThreadPool(new ThreadFactory() { // from class: com.bytedance.pangle.d.e.1

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f7536a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pangle-Fast-" + this.f7536a.getAndIncrement());
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private static final Object f7534b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static Handler f7535c = null;

    public static void a(Runnable runnable) {
        f7533a.execute(runnable);
    }

    public static void b(Runnable runnable) {
        if (a().getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            a().post(runnable);
        }
    }

    public static ExecutorService a(int i10) {
        return Executors.newFixedThreadPool(i10, new ThreadFactory() { // from class: com.bytedance.pangle.d.e.2

            /* renamed from: a, reason: collision with root package name */
            private final AtomicInteger f7537a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "pangle-Install-" + this.f7537a.getAndIncrement());
            }
        });
    }

    private static Handler a() {
        Handler handler;
        synchronized (f7534b) {
            try {
                if (f7535c == null) {
                    f7535c = new Handler(Looper.getMainLooper());
                }
                handler = f7535c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return handler;
    }
}
