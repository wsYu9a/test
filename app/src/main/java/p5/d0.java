package p5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@a5.c
@m
/* loaded from: classes2.dex */
public class d0<V> extends FutureTask<V> implements c0<V> {

    /* renamed from: b */
    public final n f29791b;

    public d0(Callable<V> callable) {
        super(callable);
        this.f29791b = new n();
    }

    public static <V> d0<V> a(Runnable runnable, @l0 V v10) {
        return new d0<>(runnable, v10);
    }

    public static <V> d0<V> b(Callable<V> callable) {
        return new d0<>(callable);
    }

    @Override // p5.c0
    public void addListener(Runnable runnable, Executor executor) {
        this.f29791b.a(runnable, executor);
    }

    @Override // java.util.concurrent.FutureTask
    public void done() {
        this.f29791b.b();
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    @CanIgnoreReturnValue
    @l0
    public V get(long j10, TimeUnit timeUnit) throws TimeoutException, InterruptedException, ExecutionException {
        long nanos = timeUnit.toNanos(j10);
        return nanos <= k0.f29801a ? (V) super.get(j10, timeUnit) : (V) super.get(Math.min(nanos, k0.f29801a), TimeUnit.NANOSECONDS);
    }

    public d0(Runnable runnable, @l0 V v10) {
        super(runnable, v10);
        this.f29791b = new n();
    }
}
