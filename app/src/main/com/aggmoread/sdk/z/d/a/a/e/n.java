package com.aggmoread.sdk.z.d.a.a.e;

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

/* loaded from: classes.dex */
public class n {

    /* renamed from: a */
    public static Handler f6105a;

    /* renamed from: b */
    private static final int f6106b;

    /* renamed from: c */
    private static final int f6107c;

    /* renamed from: d */
    private static final int f6108d;

    /* renamed from: e */
    private static final ThreadFactory f6109e;

    /* renamed from: f */
    private static final ThreadFactory f6110f;

    /* renamed from: g */
    private static final BlockingQueue<Runnable> f6111g;

    /* renamed from: h */
    static final Executor f6112h;

    public static class a implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f6113a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AMSdkThread # " + this.f6113a.getAndIncrement());
        }
    }

    public static class b implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f6114a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AMSdkThread # cache-" + this.f6114a.getAndIncrement());
        }
    }

    public static class c implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            e.a("******Task rejected, too many task!");
        }
    }

    public static class d implements Runnable {

        /* renamed from: b */
        final /* synthetic */ Runnable f6115b;

        public d(Runnable runnable) {
            this.f6115b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb2;
            String str;
            try {
                n.f6112h.execute(this.f6115b);
            } catch (InternalError e10) {
                e = e10;
                sb2 = new StringBuilder();
                str = "internal  err ";
                sb2.append(str);
                sb2.append(e.getMessage());
                e.a(sb2.toString());
            } catch (OutOfMemoryError e11) {
                e = e11;
                sb2 = new StringBuilder();
                str = "ooe err ";
                sb2.append(str);
                sb2.append(e.getMessage());
                e.a(sb2.toString());
            }
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f6106b = availableProcessors;
        int i10 = availableProcessors >= 4 ? 4 : 1;
        f6107c = i10;
        int i11 = availableProcessors >= 4 ? 4 : 1;
        f6108d = i11;
        a aVar = new a();
        f6109e = aVar;
        b bVar = new b();
        f6110f = bVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        f6111g = linkedBlockingQueue;
        new ThreadPoolExecutor(i10, i11, 1L, TimeUnit.SECONDS, linkedBlockingQueue, aVar, new c());
        f6112h = Executors.newCachedThreadPool(bVar);
    }

    public static Handler a() {
        if (f6105a == null) {
            synchronized (n.class) {
                try {
                    if (f6105a == null) {
                        f6105a = new Handler(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        return f6105a;
    }

    public static void b() {
    }

    public static void a(Runnable runnable, long j10) {
        a().postDelayed(runnable, j10);
    }

    public static boolean b(Runnable runnable) {
        StringBuilder sb2;
        String str;
        try {
            a(new d(runnable));
            return true;
        } catch (InternalError e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "internal  err ";
            sb2.append(str);
            sb2.append(e.getMessage());
            e.a(sb2.toString());
            return false;
        } catch (OutOfMemoryError e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "ooe err ";
            sb2.append(str);
            sb2.append(e.getMessage());
            e.a(sb2.toString());
            return false;
        }
    }

    public static boolean a(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
            return false;
        }
        a().post(runnable);
        return true;
    }
}
