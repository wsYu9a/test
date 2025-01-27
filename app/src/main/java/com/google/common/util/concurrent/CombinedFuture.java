package com.google.common.util.concurrent;

import b5.u;
import com.google.common.collect.ImmutableCollection;
import com.google.common.util.concurrent.AggregateFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.CheckForNull;
import p5.c0;
import p5.l0;

@a5.b
@p5.m
/* loaded from: classes2.dex */
public final class CombinedFuture<V> extends AggregateFuture<Object, V> {

    /* renamed from: j */
    @CheckForNull
    public CombinedFuture<V>.CombinedFutureInterruptibleTask<?> f10336j;

    public final class AsyncCallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<c0<V>> {
        private final p5.e<V> callable;

        public AsyncCallableInterruptibleTask(p5.e<V> eVar, Executor executor) {
            super(executor);
            this.callable = (p5.e) u.E(eVar);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public c0<V> runInterruptibly() throws Exception {
            return (c0) u.V(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public void setValue(c0<V> c0Var) {
            CombinedFuture.this.setFuture(c0Var);
        }
    }

    public final class CallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<V> {
        private final Callable<V> callable;

        public CallableInterruptibleTask(Callable<V> callable, Executor executor) {
            super(executor);
            this.callable = (Callable) u.E(callable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        @l0
        public V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public void setValue(@l0 V v10) {
            CombinedFuture.this.set(v10);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    public abstract class CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {
        private final Executor listenerExecutor;

        public CombinedFutureInterruptibleTask(Executor executor) {
            this.listenerExecutor = (Executor) u.E(executor);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final void afterRanInterruptiblyFailure(Throwable th2) {
            CombinedFuture.this.f10336j = null;
            if (th2 instanceof ExecutionException) {
                CombinedFuture.this.setException(((ExecutionException) th2).getCause());
            } else if (th2 instanceof CancellationException) {
                CombinedFuture.this.cancel(false);
            } else {
                CombinedFuture.this.setException(th2);
            }
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final void afterRanInterruptiblySuccess(@l0 T t10) {
            CombinedFuture.this.f10336j = null;
            setValue(t10);
        }

        public final void execute() {
            try {
                this.listenerExecutor.execute(this);
            } catch (RejectedExecutionException e10) {
                CombinedFuture.this.setException(e10);
            }
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            return CombinedFuture.this.isDone();
        }

        public abstract void setValue(@l0 T t10);
    }

    public CombinedFuture(ImmutableCollection<? extends c0<?>> immutableCollection, boolean z10, Executor executor, p5.e<V> eVar) {
        super(immutableCollection, z10, false);
        this.f10336j = new AsyncCallableInterruptibleTask(eVar, executor);
        C();
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    public void A() {
        CombinedFuture<V>.CombinedFutureInterruptibleTask<?> combinedFutureInterruptibleTask = this.f10336j;
        if (combinedFutureInterruptibleTask != null) {
            combinedFutureInterruptibleTask.execute();
        }
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    public void H(AggregateFuture.ReleaseResourcesReason releaseResourcesReason) {
        super.H(releaseResourcesReason);
        if (releaseResourcesReason == AggregateFuture.ReleaseResourcesReason.OUTPUT_FUTURE_DONE) {
            this.f10336j = null;
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void interruptTask() {
        CombinedFuture<V>.CombinedFutureInterruptibleTask<?> combinedFutureInterruptibleTask = this.f10336j;
        if (combinedFutureInterruptibleTask != null) {
            combinedFutureInterruptibleTask.interruptTask();
        }
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    public void x(int i10, @CheckForNull Object obj) {
    }

    public CombinedFuture(ImmutableCollection<? extends c0<?>> immutableCollection, boolean z10, Executor executor, Callable<V> callable) {
        super(immutableCollection, z10, false);
        this.f10336j = new CallableInterruptibleTask(callable, executor);
        C();
    }
}
