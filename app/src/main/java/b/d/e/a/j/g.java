package b.d.e.a.j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class g {

    /* renamed from: a */
    static final String f4538a = "g";

    /* renamed from: b */
    private static final int f4539b;

    /* renamed from: c */
    private static final int f4540c;

    /* renamed from: d */
    private static final int f4541d;

    /* renamed from: e */
    private static final ThreadFactory f4542e;

    /* renamed from: f */
    private static final ThreadFactory f4543f;

    /* renamed from: g */
    private static final BlockingQueue<Runnable> f4544g;

    /* renamed from: h */
    private static Handler f4545h;

    static class a implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f4546a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdSdk-adv1-Thread #" + this.f4546a.getAndIncrement());
        }
    }

    static class b implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f4547a = new AtomicInteger(1);

        b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdSdk-adv1-cache-Thread #" + this.f4547a.getAndIncrement());
        }
    }

    static class c implements RejectedExecutionHandler {
        c() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Log.e(g.f4538a, "******Task rejected, too many task!");
        }
    }

    static class d implements RejectedExecutionHandler {
        d() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Log.e(g.f4538a, "******single pool reject!");
        }
    }

    private static class e extends Handler {
        public e() {
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
        f4539b = availableProcessors;
        int i2 = availableProcessors + 1;
        f4540c = i2;
        int i3 = (availableProcessors * 2) + 1;
        f4541d = i3;
        a aVar = new a();
        f4542e = aVar;
        b bVar = new b();
        f4543f = bVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        f4544g = linkedBlockingQueue;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        new ThreadPoolExecutor(i2, i3, 1L, timeUnit, linkedBlockingQueue, aVar, new c());
        Executors.newCachedThreadPool(bVar);
        new ThreadPoolExecutor(1, 1, 0L, timeUnit, new LinkedBlockingQueue(), aVar, new d());
    }

    public static Handler a() {
        Handler handler;
        synchronized (g.class) {
            if (f4545h == null) {
                f4545h = new e();
            }
            handler = f4545h;
        }
        return handler;
    }

    public static void b(Runnable runnable) {
        b.d.e.a.j.a.d(runnable);
    }

    public static void c(Runnable runnable, boolean z) {
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
                Log.e(f4538a, e2.getMessage());
            }
        }
    }

    public static void d() {
        a();
        b.d.e.a.j.a.e();
    }

    public static void e(Runnable runnable) {
        c(runnable, false);
    }
}
