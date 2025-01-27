package com.nostra13.universalimageloader.core;

import android.content.Context;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: com.nostra13.universalimageloader.core.a$a */
    private static class ThreadFactoryC0362a implements ThreadFactory {

        /* renamed from: a */
        private static final AtomicInteger f15907a = new AtomicInteger(1);

        /* renamed from: d */
        private final String f15910d;

        /* renamed from: e */
        private final int f15911e;

        /* renamed from: c */
        private final AtomicInteger f15909c = new AtomicInteger(1);

        /* renamed from: b */
        private final ThreadGroup f15908b = Thread.currentThread().getThreadGroup();

        ThreadFactoryC0362a(int i2, String str) {
            this.f15911e = i2;
            this.f15910d = str + f15907a.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f15908b, runnable, this.f15910d + this.f15909c.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.f15911e);
            return thread;
        }
    }

    public static com.nostra13.universalimageloader.core.i.a a() {
        return new com.nostra13.universalimageloader.core.i.e();
    }

    public static b.g.a.a.a.b b(Context context, b.g.a.a.a.d.a aVar, long j2, int i2) {
        File h2 = h(context);
        if (j2 > 0 || i2 > 0) {
            try {
                return new b.g.a.a.a.c.d.b(b.g.a.b.f.d(context), h2, aVar, j2, i2);
            } catch (IOException e2) {
                b.g.a.b.d.d(e2);
            }
        }
        return new b.g.a.a.a.c.c(b.g.a.b.f.a(context), h2, aVar);
    }

    public static Executor c(int i2, int i3, QueueProcessingType queueProcessingType) {
        return new ThreadPoolExecutor(i2, i2, 0L, TimeUnit.MILLISECONDS, (BlockingQueue<Runnable>) (queueProcessingType == QueueProcessingType.LIFO ? new LIFOLinkedBlockingDeque() : new LinkedBlockingQueue()), j(i3, "uil-pool-"));
    }

    public static b.g.a.a.a.d.a d() {
        return new b.g.a.a.a.d.b();
    }

    public static com.nostra13.universalimageloader.core.h.b e(boolean z) {
        return new com.nostra13.universalimageloader.core.h.a(z);
    }

    public static ImageDownloader f(Context context) {
        return new BaseImageDownloader(context);
    }

    public static b.g.a.a.b.c g(int i2) {
        if (i2 == 0) {
            i2 = (int) (Runtime.getRuntime().maxMemory() / 8);
        }
        return new b.g.a.a.b.e.f(i2);
    }

    private static File h(Context context) {
        File b2 = b.g.a.b.f.b(context, false);
        File file = new File(b2, "uil-images");
        return (file.exists() || file.mkdir()) ? file : b2;
    }

    public static Executor i() {
        return Executors.newCachedThreadPool(j(5, "uil-pool-d-"));
    }

    private static ThreadFactory j(int i2, String str) {
        return new ThreadFactoryC0362a(i2, str);
    }
}
