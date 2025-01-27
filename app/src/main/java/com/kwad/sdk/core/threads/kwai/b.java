package com.kwad.sdk.core.threads.kwai;

import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class b extends ThreadPoolExecutor implements c {
    public static volatile boolean amK = false;
    private final ConcurrentHashMap<Runnable, Long> amL;
    private long amM;
    private int amN;

    public b(int i2, int i3, long j2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i2, i3, j2, timeUnit, blockingQueue, threadFactory);
        this.amL = new ConcurrentHashMap<>();
        this.amM = 0L;
        this.amN = 0;
    }

    public b(int i2, int i3, long j2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i2, i3, j2, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.amL = new ConcurrentHashMap<>();
        this.amM = 0L;
        this.amN = 0;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (amK && this.amL.containsKey(runnable) && this.amL.get(runnable) != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.amL.get(runnable).longValue();
            if (elapsedRealtime >= 0 && elapsedRealtime < 1800000) {
                long j2 = this.amM;
                int i2 = this.amN;
                this.amM = ((j2 * i2) + elapsedRealtime) / (i2 + 1);
                this.amN = i2 + 1;
            }
            this.amL.remove(runnable);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (amK) {
            this.amL.put(runnable, Long.valueOf(SystemClock.elapsedRealtime()));
        }
        super.execute(runnable);
    }

    @Override // com.kwad.sdk.core.threads.kwai.c
    public final long yg() {
        return this.amM;
    }
}
