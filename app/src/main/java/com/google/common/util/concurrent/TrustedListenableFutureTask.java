package com.google.common.util.concurrent;

import b5.u;
import com.google.common.util.concurrent.j;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.CheckForNull;
import p5.c0;
import p5.l0;

@a5.b
@p5.m
/* loaded from: classes2.dex */
public class TrustedListenableFutureTask<V> extends j.a<V> implements RunnableFuture<V> {

    /* renamed from: b */
    @CheckForNull
    public volatile InterruptibleTask<?> f10404b;

    public final class TrustedFutureInterruptibleAsyncTask extends InterruptibleTask<c0<V>> {
        private final p5.e<V> callable;

        public TrustedFutureInterruptibleAsyncTask(p5.e<V> eVar) {
            this.callable = (p5.e) u.E(eVar);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptiblyFailure(Throwable th2) {
            TrustedListenableFutureTask.this.setException(th2);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptiblySuccess(c0<V> c0Var) {
            TrustedListenableFutureTask.this.setFuture(c0Var);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public c0<V> runInterruptibly() throws Exception {
            return (c0) u.V(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
        }
    }

    public final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {
        private final Callable<V> callable;

        public TrustedFutureInterruptibleTask(Callable<V> callable) {
            this.callable = (Callable) u.E(callable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptiblyFailure(Throwable th2) {
            TrustedListenableFutureTask.this.setException(th2);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptiblySuccess(@l0 V v10) {
            TrustedListenableFutureTask.this.set(v10);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        @l0
        public V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    public TrustedListenableFutureTask(Callable<V> callable) {
        this.f10404b = new TrustedFutureInterruptibleTask(callable);
    }

    public static <V> TrustedListenableFutureTask<V> v(Runnable runnable, @l0 V v10) {
        return new TrustedListenableFutureTask<>(Executors.callable(runnable, v10));
    }

    public static <V> TrustedListenableFutureTask<V> w(Callable<V> callable) {
        return new TrustedListenableFutureTask<>(callable);
    }

    public static <V> TrustedListenableFutureTask<V> x(p5.e<V> eVar) {
        return new TrustedListenableFutureTask<>(eVar);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void afterDone() {
        InterruptibleTask<?> interruptibleTask;
        super.afterDone();
        if (wasInterrupted() && (interruptibleTask = this.f10404b) != null) {
            interruptibleTask.interruptTask();
        }
        this.f10404b = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    public String pendingToString() {
        InterruptibleTask<?> interruptibleTask = this.f10404b;
        if (interruptibleTask == null) {
            return super.pendingToString();
        }
        String valueOf = String.valueOf(interruptibleTask);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 7);
        sb2.append("task=[");
        sb2.append(valueOf);
        sb2.append("]");
        return sb2.toString();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        InterruptibleTask<?> interruptibleTask = this.f10404b;
        if (interruptibleTask != null) {
            interruptibleTask.run();
        }
        this.f10404b = null;
    }

    public TrustedListenableFutureTask(p5.e<V> eVar) {
        this.f10404b = new TrustedFutureInterruptibleAsyncTask(eVar);
    }
}
