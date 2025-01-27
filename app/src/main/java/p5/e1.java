package p5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@CanIgnoreReturnValue
@a5.c
@m
/* loaded from: classes2.dex */
public abstract class e1 extends d1 implements ScheduledExecutorService {

    /* renamed from: c */
    public final ScheduledExecutorService f29793c;

    public e1(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.f29793c = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        return this.f29793c.schedule(c(runnable), j10, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        return this.f29793c.scheduleAtFixedRate(c(runnable), j10, j11, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        return this.f29793c.scheduleWithFixedDelay(c(runnable), j10, j11, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final <V> ScheduledFuture<V> schedule(Callable<V> callable, long j10, TimeUnit timeUnit) {
        return this.f29793c.schedule(d(callable), j10, timeUnit);
    }
}
