package p5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@a5.b
@CanIgnoreReturnValue
@m
/* loaded from: classes2.dex */
public abstract class u<V> extends e5.l0 implements Future<V> {

    public static abstract class a<V> extends u<V> {

        /* renamed from: b */
        public final Future<V> f29832b;

        public a(Future<V> future) {
            this.f29832b = (Future) b5.u.E(future);
        }

        @Override // p5.u, e5.l0
        /* renamed from: e */
        public final Future<V> delegate() {
            return this.f29832b;
        }
    }

    public boolean cancel(boolean z10) {
        return delegate().cancel(z10);
    }

    @Override // e5.l0
    /* renamed from: e */
    public abstract Future<? extends V> delegate();

    @Override // java.util.concurrent.Future
    @l0
    public V get() throws InterruptedException, ExecutionException {
        return delegate().get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return delegate().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return delegate().isDone();
    }

    @Override // java.util.concurrent.Future
    @l0
    public V get(long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return delegate().get(j10, timeUnit);
    }
}
