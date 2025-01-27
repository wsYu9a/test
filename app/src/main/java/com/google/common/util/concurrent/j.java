package com.google.common.util.concurrent;

import b5.u;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.q;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p5.c0;
import p5.l0;
import p5.x;
import p5.y;

@a5.b(emulated = true)
@DoNotMock("Use FluentFuture.from(Futures.immediate*Future) or SettableFuture")
@p5.m
/* loaded from: classes2.dex */
public abstract class j<V> extends y<V> {

    public static abstract class a<V> extends j<V> implements AbstractFuture.h<V> {
        @Override // com.google.common.util.concurrent.AbstractFuture, p5.c0
        public final void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final boolean cancel(boolean z10) {
            return super.cancel(z10);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        @l0
        public final V get() throws InterruptedException, ExecutionException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        @l0
        public final V get(long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) super.get(j10, timeUnit);
        }
    }

    @Deprecated
    public static <V> j<V> q(j<V> jVar) {
        return (j) u.E(jVar);
    }

    public static <V> j<V> r(c0<V> c0Var) {
        return c0Var instanceof j ? (j) c0Var : new p5.t(c0Var);
    }

    public final void n(x<? super V> xVar, Executor executor) {
        l.a(this, xVar, executor);
    }

    @a5.a
    @q.a("AVAILABLE but requires exceptionType to be Throwable.class")
    public final <X extends Throwable> j<V> o(Class<X> cls, b5.n<? super X, ? extends V> nVar, Executor executor) {
        return (j) l.d(this, cls, nVar, executor);
    }

    @a5.a
    @q.a("AVAILABLE but requires exceptionType to be Throwable.class")
    public final <X extends Throwable> j<V> p(Class<X> cls, p5.f<? super X, ? extends V> fVar, Executor executor) {
        return (j) l.e(this, cls, fVar, executor);
    }

    @a5.a
    public final <T> j<T> s(b5.n<? super V, T> nVar, Executor executor) {
        return (j) l.x(this, nVar, executor);
    }

    @a5.a
    public final <T> j<T> t(p5.f<? super V, T> fVar, Executor executor) {
        return (j) l.y(this, fVar, executor);
    }

    @a5.a
    @a5.c
    public final j<V> u(long j10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return (j) l.D(this, j10, timeUnit, scheduledExecutorService);
    }
}
