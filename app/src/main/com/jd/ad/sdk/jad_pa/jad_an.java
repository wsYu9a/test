package com.jd.ad.sdk.jad_pa;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.jd.ad.sdk.jad_gr.jad_ly;
import com.jd.ad.sdk.logger.Logger;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class jad_an implements ExecutorService {
    public static final long jad_bo = TimeUnit.SECONDS.toMillis(10);
    public static volatile int jad_cp;
    public final ExecutorService jad_an;

    /* renamed from: com.jd.ad.sdk.jad_pa.jad_an$jad_an */
    public static final class ThreadFactoryC0342jad_an implements ThreadFactory {

        /* renamed from: com.jd.ad.sdk.jad_pa.jad_an$jad_an$jad_an */
        public class C0343jad_an extends Thread {
            public C0343jad_an(ThreadFactoryC0342jad_an threadFactoryC0342jad_an, Runnable runnable) {
                super(runnable);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                super.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new C0343jad_an(this, runnable);
        }
    }

    public static final class jad_bo implements ThreadFactory {
        public final ThreadFactory jad_an;
        public final String jad_bo;
        public final jad_cp jad_cp;
        public final boolean jad_dq;
        public final AtomicInteger jad_er = new AtomicInteger();

        /* renamed from: com.jd.ad.sdk.jad_pa.jad_an$jad_bo$jad_an */
        public class RunnableC0344jad_an implements Runnable {
            public final /* synthetic */ Runnable jad_an;

            public RunnableC0344jad_an(Runnable runnable) {
                this.jad_an = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (jad_bo.this.jad_dq) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    this.jad_an.run();
                } catch (Throwable th2) {
                    jad_bo.this.jad_cp.jad_an(th2);
                }
            }
        }

        public jad_bo(ThreadFactory threadFactory, String str, jad_cp jad_cpVar, boolean z10) {
            this.jad_an = threadFactory;
            this.jad_bo = str;
            this.jad_cp = jad_cpVar;
            this.jad_dq = z10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread newThread = this.jad_an.newThread(new RunnableC0344jad_an(runnable));
            StringBuilder jad_an = jad_ly.jad_an("glide-");
            jad_an.append(this.jad_bo);
            jad_an.append("-thread-");
            jad_an.append(this.jad_er.getAndIncrement());
            newThread.setName(jad_an.toString());
            return newThread;
        }
    }

    public interface jad_cp {
        public static final jad_cp jad_an = new C0345jad_an();

        /* renamed from: com.jd.ad.sdk.jad_pa.jad_an$jad_cp$jad_an */
        public class C0345jad_an implements jad_cp {
            @Override // com.jd.ad.sdk.jad_pa.jad_an.jad_cp
            public void jad_an(Throwable th2) {
                if (Log.isLoggable("GlideExecutor", 6)) {
                    Logger.e("GlideExecutor", "Request threw uncaught throwable", th2);
                }
            }
        }

        void jad_an(Throwable th2);
    }

    @VisibleForTesting
    public jad_an(ExecutorService executorService) {
        this.jad_an = executorService;
    }

    public static int jad_an() {
        if (jad_cp == 0) {
            jad_cp = Math.min(4, Runtime.getRuntime().availableProcessors());
        }
        return jad_cp;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j10, @NonNull TimeUnit timeUnit) {
        return this.jad_an.awaitTermination(j10, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.jad_an.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) {
        return this.jad_an.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) {
        return (T) this.jad_an.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.jad_an.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.jad_an.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.jad_an.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.jad_an.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.jad_an.submit(runnable);
    }

    public String toString() {
        return this.jad_an.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j10, @NonNull TimeUnit timeUnit) {
        return this.jad_an.invokeAll(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j10, @NonNull TimeUnit timeUnit) {
        return (T) this.jad_an.invokeAny(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t10) {
        return this.jad_an.submit(runnable, t10);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.jad_an.submit(callable);
    }
}
