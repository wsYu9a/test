package com.aggmoread.sdk.z.b.m;

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

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    static final String f4729a = "n";

    /* renamed from: b, reason: collision with root package name */
    private static final int f4730b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f4731c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f4732d;

    /* renamed from: e, reason: collision with root package name */
    private static final ThreadFactory f4733e;

    /* renamed from: f, reason: collision with root package name */
    private static final ThreadFactory f4734f;

    /* renamed from: g, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f4735g;

    /* renamed from: h, reason: collision with root package name */
    static final Executor f4736h;

    /* renamed from: i, reason: collision with root package name */
    private static Handler f4737i;

    public static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f4738a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdSdk-api-Thread #" + this.f4738a.getAndIncrement());
        }
    }

    public static class b implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f4739a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdSdk-api-Thread2 #" + this.f4739a.getAndIncrement());
        }
    }

    public static class c implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Log.i(n.f4729a, "******Task rejected, too many task!");
        }
    }

    public static class d extends Handler {
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
        f4730b = availableProcessors;
        int i10 = availableProcessors + 1;
        f4731c = i10;
        int i11 = (availableProcessors * 2) + 1;
        f4732d = i11;
        a aVar = new a();
        f4733e = aVar;
        b bVar = new b();
        f4734f = bVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        f4735g = linkedBlockingQueue;
        new ThreadPoolExecutor(i10, i11, 1L, TimeUnit.SECONDS, linkedBlockingQueue, aVar, new c());
        f4736h = Executors.newCachedThreadPool(bVar);
    }

    public static Handler a() {
        Handler handler;
        synchronized (n.class) {
            try {
                if (f4737i == null) {
                    f4737i = new d();
                }
                handler = f4737i;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return handler;
    }

    public static void b(Runnable runnable) {
        a(runnable, false);
    }

    public static void a(Runnable runnable) {
        f4736h.execute(runnable);
    }

    public static void a(Runnable runnable, boolean z10) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
            return;
        }
        CountDownLatch countDownLatch = z10 ? new CountDownLatch(1) : null;
        a().obtainMessage(1, new Pair(runnable, countDownLatch)).sendToTarget();
        if (z10) {
            try {
                countDownLatch.await();
            } catch (InterruptedException e10) {
                Log.w(f4729a, e10);
            }
        }
    }
}
