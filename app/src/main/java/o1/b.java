package o1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p1.f;

/* loaded from: classes.dex */
public class b extends ThreadPoolExecutor {

    /* renamed from: b */
    public static final int f28992b;

    /* renamed from: c */
    public static final int f28993c;

    /* renamed from: d */
    public static final int f28994d;

    /* renamed from: e */
    public static final long f28995e = 30;

    /* renamed from: f */
    public static volatile b f28996f;

    public class a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            n1.a.f28723e.error("ARouter::", "Task rejected, too many task!");
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f28992b = availableProcessors;
        int i10 = availableProcessors + 1;
        f28993c = i10;
        f28994d = i10;
    }

    public b(int i10, int i11, long j10, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i10, i11, j10, timeUnit, blockingQueue, threadFactory, new a());
    }

    public static b a() {
        if (f28996f == null) {
            synchronized (b.class) {
                try {
                    if (f28996f == null) {
                        f28996f = new b(f28993c, f28994d, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(64), new c());
                    }
                } finally {
                }
            }
        }
        return f28996f;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th2) {
        super.afterExecute(runnable, th2);
        if (th2 == null && (runnable instanceof Future)) {
            try {
                ((Future) runnable).get();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (CancellationException e10) {
                th2 = e10;
            } catch (ExecutionException e11) {
                th2 = e11.getCause();
            }
        }
        if (th2 != null) {
            n1.a.f28723e.warning("ARouter::", "Running task appeared exception! Thread [" + Thread.currentThread().getName() + "], because [" + th2.getMessage() + "]\n" + f.a(th2.getStackTrace()));
        }
    }
}
