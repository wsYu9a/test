package com.sntech.net;

import androidx.annotation.Keep;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Keep
/* loaded from: classes4.dex */
public class NetFuture<V> implements ScheduledFuture<V> {
    private ScheduledFuture<V> mScheduleFuture;

    public NetFuture(ScheduledFuture<V> scheduledFuture) {
        this.mScheduleFuture = scheduledFuture;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        return this.mScheduleFuture.cancel(z10);
    }

    @Override // java.util.concurrent.Future
    public V get() {
        return this.mScheduleFuture.get();
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return this.mScheduleFuture.getDelay(timeUnit);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.mScheduleFuture.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.mScheduleFuture.isDone();
    }

    @Override // java.lang.Comparable
    public int compareTo(Delayed delayed) {
        return this.mScheduleFuture.compareTo(delayed);
    }

    @Override // java.util.concurrent.Future
    public V get(long j10, TimeUnit timeUnit) {
        return this.mScheduleFuture.get(j10, timeUnit);
    }
}
