package com.alimm.tanx.ui.image.glide.load.engine.executor;

import android.os.Process;
import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import ok.a;

/* loaded from: classes.dex */
public class FifoPriorityThreadPoolExecutor extends ThreadPoolExecutor {
    private static final String TAG = "PriorityExecutor";
    private final AtomicInteger ordering;
    private final UncaughtThrowableStrategy uncaughtThrowableStrategy;

    public static class DefaultThreadFactory implements ThreadFactory {
        int threadNum = 0;

        /* renamed from: com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor$DefaultThreadFactory$1 */
        public class AnonymousClass1 extends Thread {
            public AnonymousClass1(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                super.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            StringBuilder a10 = a.a("fifo-pool-thread-");
            a10.append(this.threadNum);
            AnonymousClass1 anonymousClass1 = new Thread(runnable, a10.toString()) { // from class: com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.DefaultThreadFactory.1
                public AnonymousClass1(Runnable runnable2, String str) {
                    super(runnable2, str);
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(10);
                    super.run();
                }
            };
            this.threadNum++;
            return anonymousClass1;
        }
    }

    public static class LoadTask<T> extends FutureTask<T> implements Comparable<LoadTask<?>> {
        private final int order;
        private final int priority;

        public LoadTask(Runnable runnable, T t10, int i10) {
            super(runnable, t10);
            if (!(runnable instanceof Prioritized)) {
                throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
            }
            this.priority = ((Prioritized) runnable).getPriority();
            this.order = i10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof LoadTask)) {
                return false;
            }
            LoadTask loadTask = (LoadTask) obj;
            return this.order == loadTask.order && this.priority == loadTask.priority;
        }

        public int hashCode() {
            return (this.priority * 31) + this.order;
        }

        @Override // java.lang.Comparable
        public int compareTo(LoadTask<?> loadTask) {
            int i10 = this.priority - loadTask.priority;
            return i10 == 0 ? this.order - loadTask.order : i10;
        }
    }

    public enum UncaughtThrowableStrategy {
        IGNORE,
        LOG { // from class: com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy.1
            @Override // com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy
            public void handle(Throwable th2) {
                if (Log.isLoggable(FifoPriorityThreadPoolExecutor.TAG, 6)) {
                    Log.e(FifoPriorityThreadPoolExecutor.TAG, "Request threw uncaught throwable", th2);
                }
            }
        },
        THROW { // from class: com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy.2
            @Override // com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy
            public void handle(Throwable th2) {
                throw new RuntimeException(th2);
            }
        };

        /* renamed from: com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor$UncaughtThrowableStrategy$1 */
        public enum AnonymousClass1 extends UncaughtThrowableStrategy {
            @Override // com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy
            public void handle(Throwable th2) {
                if (Log.isLoggable(FifoPriorityThreadPoolExecutor.TAG, 6)) {
                    Log.e(FifoPriorityThreadPoolExecutor.TAG, "Request threw uncaught throwable", th2);
                }
            }
        }

        /* renamed from: com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor$UncaughtThrowableStrategy$2 */
        public enum AnonymousClass2 extends UncaughtThrowableStrategy {
            @Override // com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy
            public void handle(Throwable th2) {
                throw new RuntimeException(th2);
            }
        }

        public void handle(Throwable th2) {
        }

        /* synthetic */ UncaughtThrowableStrategy(AnonymousClass1 anonymousClass1) {
        }
    }

    public FifoPriorityThreadPoolExecutor(int i10) {
        this(i10, UncaughtThrowableStrategy.LOG);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th2) {
        super.afterExecute(runnable, th2);
        if (th2 == null && (runnable instanceof Future)) {
            Future future = (Future) runnable;
            if (!future.isDone() || future.isCancelled()) {
                return;
            }
            try {
                future.get();
            } catch (InterruptedException e10) {
                this.uncaughtThrowableStrategy.handle(e10);
            } catch (ExecutionException e11) {
                this.uncaughtThrowableStrategy.handle(e11);
            }
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t10) {
        return new LoadTask(runnable, t10, this.ordering.getAndIncrement());
    }

    public FifoPriorityThreadPoolExecutor(int i10, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        this(i10, i10, 0L, TimeUnit.MILLISECONDS, new DefaultThreadFactory(), uncaughtThrowableStrategy);
    }

    public FifoPriorityThreadPoolExecutor(int i10, int i11, long j10, TimeUnit timeUnit, ThreadFactory threadFactory, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        super(i10, i11, j10, timeUnit, new PriorityBlockingQueue(), threadFactory);
        this.ordering = new AtomicInteger();
        this.uncaughtThrowableStrategy = uncaughtThrowableStrategy;
    }
}
