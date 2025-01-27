package com.martian.ttbook.b.c.a.a.e;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: a */
    public static Handler f15837a;

    /* renamed from: b */
    private static final int f15838b;

    /* renamed from: c */
    private static final int f15839c;

    /* renamed from: d */
    private static final int f15840d;

    /* renamed from: e */
    private static final ThreadFactory f15841e;

    /* renamed from: f */
    private static final ThreadFactory f15842f;

    /* renamed from: g */
    private static final BlockingQueue<Runnable> f15843g;

    /* renamed from: h */
    static final Executor f15844h;

    static class a implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f15845a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdSdkThread # " + this.f15845a.getAndIncrement());
        }
    }

    static class b implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f15846a = new AtomicInteger(1);

        b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdSdkThread # cache-" + this.f15846a.getAndIncrement());
        }
    }

    static class c implements RejectedExecutionHandler {
        c() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            com.martian.ttbook.b.c.a.a.e.d.a("******Task rejected, too many task!");
        }
    }

    static class d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Runnable f15847a;

        d(Runnable runnable) {
            this.f15847a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb;
            String message;
            try {
                j.f15844h.execute(this.f15847a);
            } catch (InternalError e2) {
                sb = new StringBuilder();
                sb.append("internal  err ");
                message = e2.getMessage();
                sb.append(message);
                com.martian.ttbook.b.c.a.a.e.d.a(sb.toString());
            } catch (OutOfMemoryError e3) {
                sb = new StringBuilder();
                sb.append("ooe err ");
                message = e3.getMessage();
                sb.append(message);
                com.martian.ttbook.b.c.a.a.e.d.a(sb.toString());
            }
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f15838b = availableProcessors;
        int i2 = availableProcessors >= 4 ? 4 : 1;
        f15839c = i2;
        int i3 = availableProcessors >= 4 ? 4 : 1;
        f15840d = i3;
        a aVar = new a();
        f15841e = aVar;
        b bVar = new b();
        f15842f = bVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        f15843g = linkedBlockingQueue;
        new ThreadPoolExecutor(i2, i3, 1L, TimeUnit.SECONDS, linkedBlockingQueue, aVar, new c());
        f15844h = Executors.newCachedThreadPool(bVar);
    }

    public static Handler a() {
        if (f15837a == null) {
            synchronized (j.class) {
                if (f15837a == null) {
                    f15837a = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f15837a;
    }

    public static void b(Runnable runnable, long j2) {
        a().postDelayed(runnable, j2);
    }

    public static boolean c(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
            return false;
        }
        a().post(runnable);
        return true;
    }

    public static void d() {
    }

    public static boolean e(Runnable runnable) {
        StringBuilder sb;
        String message;
        try {
            c(new d(runnable));
            return true;
        } catch (InternalError e2) {
            sb = new StringBuilder();
            sb.append("internal  err ");
            message = e2.getMessage();
            sb.append(message);
            com.martian.ttbook.b.c.a.a.e.d.a(sb.toString());
            return false;
        } catch (OutOfMemoryError e3) {
            sb = new StringBuilder();
            sb.append("ooe err ");
            message = e3.getMessage();
            sb.append(message);
            com.martian.ttbook.b.c.a.a.e.d.a(sb.toString());
            return false;
        }
    }
}
