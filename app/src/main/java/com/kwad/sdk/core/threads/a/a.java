package com.kwad.sdk.core.threads.a;

import android.os.SystemClock;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes3.dex */
public final class a extends ScheduledThreadPoolExecutor implements c {
    public static volatile boolean aFg = false;
    private final ConcurrentHashMap<Runnable, Long> aFh;
    private long aFi;
    private int aFj;

    public a(int i10, ThreadFactory threadFactory) {
        super(1, threadFactory);
        this.aFh = new ConcurrentHashMap<>();
        this.aFi = 0L;
        this.aFj = 0;
    }

    @Override // com.kwad.sdk.core.threads.a.c
    public final long HE() {
        return this.aFi;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (aFg && this.aFh.containsKey(runnable) && this.aFh.get(runnable) != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.aFh.get(runnable).longValue();
            if (elapsedRealtime >= 0 && elapsedRealtime < 1800000) {
                long j10 = this.aFi;
                int i10 = this.aFj;
                this.aFi = ((j10 * i10) + elapsedRealtime) / (i10 + 1);
                this.aFj = i10 + 1;
            }
            this.aFh.remove(runnable);
        }
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (aFg) {
            this.aFh.put(runnable, Long.valueOf(SystemClock.elapsedRealtime()));
        }
        super.execute(runnable);
    }
}
