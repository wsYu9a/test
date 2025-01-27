package com.google.common.util.concurrent;

import b5.u;
import com.google.common.util.concurrent.ExecutionSequencer;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.CheckForNull;
import p5.c0;

@p5.m
/* loaded from: classes2.dex */
public final class ExecutionSequencer {

    /* renamed from: a */
    public final AtomicReference<c0<Void>> f10345a = new AtomicReference<>(l.n());

    /* renamed from: b */
    public c f10346b = new c(null);

    public enum RunningState {
        NOT_RUN,
        CANCELLED,
        STARTED
    }

    public static final class TaskNonReentrantExecutor extends AtomicReference<RunningState> implements Executor, Runnable {

        @CheckForNull
        Executor delegate;

        @CheckForNull
        ExecutionSequencer sequencer;

        @CheckForNull
        Thread submitting;

        @CheckForNull
        Runnable task;

        public /* synthetic */ TaskNonReentrantExecutor(Executor executor, ExecutionSequencer executionSequencer, a aVar) {
            this(executor, executionSequencer);
        }

        public boolean trySetCancelled() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.CANCELLED);
        }

        public boolean trySetStarted() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.STARTED);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (get() == RunningState.CANCELLED) {
                this.delegate = null;
                this.sequencer = null;
                return;
            }
            this.submitting = Thread.currentThread();
            try {
                ExecutionSequencer executionSequencer = this.sequencer;
                Objects.requireNonNull(executionSequencer);
                c cVar = executionSequencer.f10346b;
                if (cVar.f10350a == this.submitting) {
                    this.sequencer = null;
                    u.g0(cVar.f10351b == null);
                    cVar.f10351b = runnable;
                    Executor executor = this.delegate;
                    Objects.requireNonNull(executor);
                    cVar.f10352c = executor;
                    this.delegate = null;
                } else {
                    Executor executor2 = this.delegate;
                    Objects.requireNonNull(executor2);
                    this.delegate = null;
                    this.task = runnable;
                    executor2.execute(this);
                }
                this.submitting = null;
            } catch (Throwable th2) {
                this.submitting = null;
                throw th2;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Executor executor;
            Thread currentThread = Thread.currentThread();
            if (currentThread != this.submitting) {
                Runnable runnable = this.task;
                Objects.requireNonNull(runnable);
                this.task = null;
                runnable.run();
                return;
            }
            c cVar = new c(null);
            cVar.f10350a = currentThread;
            ExecutionSequencer executionSequencer = this.sequencer;
            Objects.requireNonNull(executionSequencer);
            executionSequencer.f10346b = cVar;
            this.sequencer = null;
            try {
                Runnable runnable2 = this.task;
                Objects.requireNonNull(runnable2);
                this.task = null;
                runnable2.run();
                while (true) {
                    Runnable runnable3 = cVar.f10351b;
                    if (runnable3 == null || (executor = cVar.f10352c) == null) {
                        break;
                    }
                    cVar.f10351b = null;
                    cVar.f10352c = null;
                    executor.execute(runnable3);
                }
            } finally {
                cVar.f10350a = null;
            }
        }

        private TaskNonReentrantExecutor(Executor executor, ExecutionSequencer executionSequencer) {
            super(RunningState.NOT_RUN);
            this.delegate = executor;
            this.sequencer = executionSequencer;
        }
    }

    public class a<T> implements p5.e<T> {

        /* renamed from: a */
        public final /* synthetic */ Callable f10347a;

        public a(ExecutionSequencer executionSequencer, Callable callable) {
            this.f10347a = callable;
        }

        @Override // p5.e
        public c0<T> call() throws Exception {
            return l.m(this.f10347a.call());
        }

        public String toString() {
            return this.f10347a.toString();
        }
    }

    public class b<T> implements p5.e<T> {

        /* renamed from: a */
        public final /* synthetic */ TaskNonReentrantExecutor f10348a;

        /* renamed from: b */
        public final /* synthetic */ p5.e f10349b;

        public b(ExecutionSequencer executionSequencer, TaskNonReentrantExecutor taskNonReentrantExecutor, p5.e eVar) {
            this.f10348a = taskNonReentrantExecutor;
            this.f10349b = eVar;
        }

        @Override // p5.e
        public c0<T> call() throws Exception {
            return !this.f10348a.trySetStarted() ? l.k() : this.f10349b.call();
        }

        public String toString() {
            return this.f10349b.toString();
        }
    }

    public static final class c {

        /* renamed from: a */
        @CheckForNull
        public Thread f10350a;

        /* renamed from: b */
        @CheckForNull
        public Runnable f10351b;

        /* renamed from: c */
        @CheckForNull
        public Executor f10352c;

        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public static ExecutionSequencer d() {
        return new ExecutionSequencer();
    }

    public static /* synthetic */ void e(TrustedListenableFutureTask trustedListenableFutureTask, s sVar, c0 c0Var, c0 c0Var2, TaskNonReentrantExecutor taskNonReentrantExecutor) {
        if (trustedListenableFutureTask.isDone()) {
            sVar.setFuture(c0Var);
        } else if (c0Var2.isCancelled() && taskNonReentrantExecutor.trySetCancelled()) {
            trustedListenableFutureTask.cancel(false);
        }
    }

    public <T> c0<T> f(Callable<T> callable, Executor executor) {
        u.E(callable);
        u.E(executor);
        return g(new a(this, callable), executor);
    }

    public <T> c0<T> g(p5.e<T> eVar, Executor executor) {
        u.E(eVar);
        u.E(executor);
        TaskNonReentrantExecutor taskNonReentrantExecutor = new TaskNonReentrantExecutor(executor, this, null);
        b bVar = new b(this, taskNonReentrantExecutor, eVar);
        s n10 = s.n();
        c0<Void> andSet = this.f10345a.getAndSet(n10);
        TrustedListenableFutureTask x10 = TrustedListenableFutureTask.x(bVar);
        andSet.addListener(x10, taskNonReentrantExecutor);
        c0<T> q10 = l.q(x10);
        i iVar = new Runnable() { // from class: com.google.common.util.concurrent.i

            /* renamed from: c */
            public final /* synthetic */ s f10489c;

            /* renamed from: d */
            public final /* synthetic */ c0 f10490d;

            /* renamed from: e */
            public final /* synthetic */ c0 f10491e;

            /* renamed from: f */
            public final /* synthetic */ ExecutionSequencer.TaskNonReentrantExecutor f10492f;

            public /* synthetic */ i(s n102, c0 andSet2, c0 q102, ExecutionSequencer.TaskNonReentrantExecutor taskNonReentrantExecutor2) {
                n10 = n102;
                andSet = andSet2;
                q10 = q102;
                taskNonReentrantExecutor = taskNonReentrantExecutor2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ExecutionSequencer.e(TrustedListenableFutureTask.this, n10, andSet, q10, taskNonReentrantExecutor);
            }
        };
        q102.addListener(iVar, p.c());
        x10.addListener(iVar, p.c());
        return q102;
    }
}
