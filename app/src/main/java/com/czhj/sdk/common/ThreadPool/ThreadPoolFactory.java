package com.czhj.sdk.common.ThreadPool;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ThreadPoolFactory {

    /* renamed from: a */
    public static final int f8459a;

    /* renamed from: b */
    public static final TimeUnit f8460b;

    /* renamed from: c */
    public static Handler f8461c;

    /* renamed from: d */
    public static Handler f8462d;

    /* renamed from: e */
    public static ExecutorService f8463e;

    /* renamed from: f */
    public static HandlerThread f8464f;

    public static class BackgroundThreadPool {

        /* renamed from: d */
        public static BackgroundThreadPool f8465d;

        /* renamed from: a */
        public final int f8466a = 2;

        /* renamed from: b */
        public final BlockingQueue<Runnable> f8467b = new LinkedBlockingQueue();

        /* renamed from: c */
        public final ExecutorService f8468c = ThreadPoolFactory.f8463e;

        public BackgroundThreadPool() {
            HandlerThread unused = ThreadPoolFactory.f8464f = new HandlerThread("ioThread");
            ThreadPoolFactory.f8464f.start();
            Handler unused2 = ThreadPoolFactory.f8462d = new Handler(ThreadPoolFactory.f8464f.getLooper());
        }

        public static BackgroundThreadPool getInstance() {
            if (f8465d == null) {
                synchronized (BackgroundThreadPool.class) {
                    try {
                        if (f8465d == null) {
                            f8465d = new BackgroundThreadPool();
                        }
                    } finally {
                    }
                }
            }
            return f8465d;
        }

        public ExecutorService getExecutorService() {
            return this.f8468c;
        }

        public Handler getIOHandler() {
            return ThreadPoolFactory.f8462d;
        }

        public Looper getIOLooper() {
            return ThreadPoolFactory.f8464f.getLooper();
        }

        public void submit(Runnable runnable) {
            try {
                this.f8468c.submit(runnable);
            } catch (Throwable unused) {
            }
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f8459a = availableProcessors;
        f8460b = TimeUnit.SECONDS;
        f8461c = new Handler(Looper.getMainLooper());
        f8463e = Executors.newFixedThreadPool(availableProcessors + 2, new BackgroundThreadFactory());
    }

    public static void MainThreadRun(Runnable runnable) {
        f8461c.post(runnable);
    }

    public static ExecutorService getFixIOExecutor() {
        return f8463e;
    }
}
