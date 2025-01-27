package ba;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public static final int f1499a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f1500b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f1501c = 30;

    /* renamed from: d, reason: collision with root package name */
    public static final int f1502d = 128;

    /* renamed from: e, reason: collision with root package name */
    public static final ThreadFactory f1503e;

    /* renamed from: f, reason: collision with root package name */
    public static final ThreadPoolExecutor f1504f;

    /* renamed from: g, reason: collision with root package name */
    public static final ThreadPoolExecutor f1505g;

    /* renamed from: h, reason: collision with root package name */
    public static Handler f1506h;

    public class a implements ThreadFactory {

        /* renamed from: b, reason: collision with root package name */
        public final AtomicInteger f1507b = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.f1507b.getAndIncrement());
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f1499a = availableProcessors;
        int max = Math.max(availableProcessors, 5);
        f1500b = max;
        a aVar = new a();
        f1503e = aVar;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f1504f = new ThreadPoolExecutor(max, max, 30L, timeUnit, new LinkedBlockingQueue(128), aVar);
        f1505g = new ThreadPoolExecutor(1, 2, 30L, timeUnit, new LinkedBlockingQueue(128), aVar);
        f1506h = new Handler(Looper.getMainLooper());
    }

    public static /* synthetic */ void b(Runnable runnable) {
        f1506h.post(runnable);
    }

    public static <T> Future<T> c(Callable<T> callable) {
        return f1504f.submit(callable);
    }

    public static void d(Runnable runnable) {
        f1504f.execute(runnable);
    }

    public static void e(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            f1506h.post(runnable);
        }
    }

    public static void f(final Runnable runnable) {
        f1504f.execute(new Runnable() { // from class: ba.n
            @Override // java.lang.Runnable
            public final void run() {
                o.b(runnable);
            }
        });
    }
}
