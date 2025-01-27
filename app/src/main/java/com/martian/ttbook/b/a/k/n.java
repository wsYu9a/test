package com.martian.ttbook.b.a.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class n {

    /* renamed from: a */
    static final String f15064a = "n";

    /* renamed from: b */
    private static final int f15065b;

    /* renamed from: c */
    private static final int f15066c;

    /* renamed from: d */
    private static final int f15067d;

    /* renamed from: e */
    private static final ThreadFactory f15068e;

    /* renamed from: f */
    private static final ThreadFactory f15069f;

    /* renamed from: g */
    private static final BlockingQueue<Runnable> f15070g;

    /* renamed from: h */
    static final Executor f15071h;

    /* renamed from: i */
    private static Handler f15072i;

    static class a implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f15073a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdSdk-api-Thread #" + this.f15073a.getAndIncrement());
        }
    }

    static class b implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f15074a = new AtomicInteger(1);

        b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdSdk-api-Thread2 #" + this.f15074a.getAndIncrement());
        }
    }

    static class c implements RejectedExecutionHandler {
        c() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Log.i(n.f15064a, "******Task rejected, too many task!");
        }
    }

    private static class d extends Handler {
        public d() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                Pair pair = (Pair) message.obj;
                try {
                    ((Runnable) pair.first).run();
                } finally {
                    Object obj = pair.second;
                    if (obj != null) {
                        ((CountDownLatch) obj).countDown();
                    }
                }
            }
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f15065b = availableProcessors;
        int i2 = availableProcessors + 1;
        f15066c = i2;
        int i3 = (availableProcessors * 2) + 1;
        f15067d = i3;
        a aVar = new a();
        f15068e = aVar;
        b bVar = new b();
        f15069f = bVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        f15070g = linkedBlockingQueue;
        new ThreadPoolExecutor(i2, i3, 1L, TimeUnit.SECONDS, linkedBlockingQueue, aVar, new c());
        f15071h = Executors.newCachedThreadPool(bVar);
    }

    public static Handler a() {
        Handler handler;
        synchronized (n.class) {
            if (f15072i == null) {
                f15072i = new d();
            }
            handler = f15072i;
        }
        return handler;
    }

    public static void b(Runnable runnable) {
        f15071h.execute(runnable);
    }

    public static void c(Runnable runnable, long j2) {
        a().postDelayed(runnable, j2);
    }

    public static void d(Runnable runnable, boolean z) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
            return;
        }
        CountDownLatch countDownLatch = z ? new CountDownLatch(1) : null;
        a().obtainMessage(1, new Pair(runnable, countDownLatch)).sendToTarget();
        if (z) {
            try {
                countDownLatch.await();
            } catch (InterruptedException e2) {
                Log.w(f15064a, e2);
            }
        }
    }

    public static void e(Runnable runnable) {
        d(runnable, false);
    }
}
