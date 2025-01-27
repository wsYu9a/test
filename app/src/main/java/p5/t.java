package p5;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@a5.b
@m
/* loaded from: classes2.dex */
public final class t<V> extends com.google.common.util.concurrent.j<V> {

    /* renamed from: b */
    public final c0<V> f29830b;

    public t(c0<V> c0Var) {
        this.f29830b = (c0) b5.u.E(c0Var);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, p5.c0
    public void addListener(Runnable runnable, Executor executor) {
        this.f29830b.addListener(runnable, executor);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        return this.f29830b.cancel(z10);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    @l0
    public V get() throws InterruptedException, ExecutionException {
        return this.f29830b.get();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f29830b.isCancelled();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public boolean isDone() {
        return this.f29830b.isDone();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String toString() {
        return this.f29830b.toString();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    @l0
    public V get(long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f29830b.get(j10, timeUnit);
    }
}
