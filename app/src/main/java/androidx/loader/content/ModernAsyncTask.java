package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import androidx.annotation.RestrictTo;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
abstract class ModernAsyncTask<Params, Progress, Result> {
    public static final Executor THREAD_POOL_EXECUTOR;

    /* renamed from: a, reason: collision with root package name */
    private static final String f2683a = "AsyncTask";

    /* renamed from: b, reason: collision with root package name */
    private static final int f2684b = 5;

    /* renamed from: c, reason: collision with root package name */
    private static final int f2685c = 128;

    /* renamed from: d, reason: collision with root package name */
    private static final int f2686d = 1;

    /* renamed from: e, reason: collision with root package name */
    private static final ThreadFactory f2687e;

    /* renamed from: f, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f2688f;

    /* renamed from: g, reason: collision with root package name */
    private static final int f2689g = 1;

    /* renamed from: h, reason: collision with root package name */
    private static final int f2690h = 2;

    /* renamed from: i, reason: collision with root package name */
    private static InternalHandler f2691i;

    /* renamed from: j, reason: collision with root package name */
    private static volatile Executor f2692j;
    private final WorkerRunnable<Params, Result> k;
    private final FutureTask<Result> l;
    private volatile Status m = Status.PENDING;
    final AtomicBoolean n = new AtomicBoolean();
    final AtomicBoolean o = new AtomicBoolean();

    /* renamed from: androidx.loader.content.ModernAsyncTask$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2696a;

        static {
            int[] iArr = new int[Status.values().length];
            f2696a = iArr;
            try {
                iArr[Status.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2696a[Status.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static class AsyncTaskResult<Data> {

        /* renamed from: a, reason: collision with root package name */
        final ModernAsyncTask f2697a;

        /* renamed from: b, reason: collision with root package name */
        final Data[] f2698b;

        AsyncTaskResult(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.f2697a = modernAsyncTask;
            this.f2698b = dataArr;
        }
    }

    private static class InternalHandler extends Handler {
        InternalHandler() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                asyncTaskResult.f2697a.b(asyncTaskResult.f2698b[0]);
            } else {
                if (i2 != 2) {
                    return;
                }
                asyncTaskResult.f2697a.h(asyncTaskResult.f2698b);
            }
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {

        /* renamed from: a, reason: collision with root package name */
        Params[] f2699a;

        WorkerRunnable() {
        }
    }

    static {
        ThreadFactory threadFactory = new ThreadFactory() { // from class: androidx.loader.content.ModernAsyncTask.1

            /* renamed from: a, reason: collision with root package name */
            private final AtomicInteger f2693a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "ModernAsyncTask #" + this.f2693a.getAndIncrement());
            }
        };
        f2687e = threadFactory;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        f2688f = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, linkedBlockingQueue, threadFactory);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
        f2692j = threadPoolExecutor;
    }

    ModernAsyncTask() {
        WorkerRunnable<Params, Result> workerRunnable = new WorkerRunnable<Params, Result>() { // from class: androidx.loader.content.ModernAsyncTask.2
            @Override // java.util.concurrent.Callable
            public Result call() throws Exception {
                ModernAsyncTask.this.o.set(true);
                Result result = null;
                try {
                    Process.setThreadPriority(10);
                    result = (Result) ModernAsyncTask.this.a(this.f2699a);
                    Binder.flushPendingCommands();
                    return result;
                } finally {
                }
            }
        };
        this.k = workerRunnable;
        this.l = new FutureTask<Result>(workerRunnable) { // from class: androidx.loader.content.ModernAsyncTask.3
            @Override // java.util.concurrent.FutureTask
            protected void done() {
                try {
                    ModernAsyncTask.this.j(get());
                } catch (InterruptedException e2) {
                    Log.w(ModernAsyncTask.f2683a, e2);
                } catch (CancellationException unused) {
                    ModernAsyncTask.this.j(null);
                } catch (ExecutionException e3) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", e3.getCause());
                } catch (Throwable th) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", th);
                }
            }
        };
    }

    private static Handler c() {
        InternalHandler internalHandler;
        synchronized (ModernAsyncTask.class) {
            if (f2691i == null) {
                f2691i = new InternalHandler();
            }
            internalHandler = f2691i;
        }
        return internalHandler;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setDefaultExecutor(Executor executor) {
        f2692j = executor;
    }

    protected abstract Result a(Params... paramsArr);

    void b(Result result) {
        if (isCancelled()) {
            e(result);
        } else {
            f(result);
        }
        this.m = Status.FINISHED;
    }

    public final boolean cancel(boolean z) {
        this.n.set(true);
        return this.l.cancel(z);
    }

    protected void d() {
    }

    protected void e(Result result) {
        d();
    }

    public final ModernAsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return executeOnExecutor(f2692j, paramsArr);
    }

    public final ModernAsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (this.m == Status.PENDING) {
            this.m = Status.RUNNING;
            g();
            this.k.f2699a = paramsArr;
            executor.execute(this.l);
            return this;
        }
        int i2 = AnonymousClass4.f2696a[this.m.ordinal()];
        if (i2 == 1) {
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        if (i2 != 2) {
            throw new IllegalStateException("We should never reach this state");
        }
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }

    protected void f(Result result) {
    }

    protected void g() {
    }

    public final Result get() throws InterruptedException, ExecutionException {
        return this.l.get();
    }

    public final Status getStatus() {
        return this.m;
    }

    protected void h(Progress... progressArr) {
    }

    Result i(Result result) {
        c().obtainMessage(1, new AsyncTaskResult(this, result)).sendToTarget();
        return result;
    }

    public final boolean isCancelled() {
        return this.n.get();
    }

    void j(Result result) {
        if (this.o.get()) {
            return;
        }
        i(result);
    }

    protected final void k(Progress... progressArr) {
        if (isCancelled()) {
            return;
        }
        c().obtainMessage(2, new AsyncTaskResult(this, progressArr)).sendToTarget();
    }

    public static void execute(Runnable runnable) {
        f2692j.execute(runnable);
    }

    public final Result get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.l.get(j2, timeUnit);
    }
}
