package com.google.common.util.concurrent;

import b5.u;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.h;
import com.google.common.util.concurrent.m;
import com.google.common.util.concurrent.q;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;
import p5.b1;
import p5.c0;
import p5.l0;
import p5.x;
import p5.z;

@a5.b(emulated = true)
@p5.m
/* loaded from: classes2.dex */
public final class l extends z {

    public class a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ Future f10494b;

        public a(Future future) {
            this.f10494b = future;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10494b.cancel(false);
        }
    }

    public class b<O> implements Future<O> {

        /* renamed from: b */
        public final /* synthetic */ Future f10495b;

        /* renamed from: c */
        public final /* synthetic */ b5.n f10496c;

        public b(Future future, b5.n nVar) {
            this.f10495b = future;
            this.f10496c = nVar;
        }

        public final O a(I i10) throws ExecutionException {
            try {
                return (O) this.f10496c.apply(i10);
            } catch (Throwable th2) {
                throw new ExecutionException(th2);
            }
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z10) {
            return this.f10495b.cancel(z10);
        }

        @Override // java.util.concurrent.Future
        public O get() throws InterruptedException, ExecutionException {
            return a(this.f10495b.get());
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f10495b.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f10495b.isDone();
        }

        @Override // java.util.concurrent.Future
        public O get(long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return a(this.f10495b.get(j10, timeUnit));
        }
    }

    public class c implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ g f10497b;

        /* renamed from: c */
        public final /* synthetic */ ImmutableList f10498c;

        /* renamed from: d */
        public final /* synthetic */ int f10499d;

        public c(g gVar, ImmutableList immutableList, int i10) {
            this.f10497b = gVar;
            this.f10498c = immutableList;
            this.f10499d = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10497b.f(this.f10498c, this.f10499d);
        }
    }

    public static final class d<V> implements Runnable {

        /* renamed from: b */
        public final Future<V> f10500b;

        /* renamed from: c */
        public final x<? super V> f10501c;

        public d(Future<V> future, x<? super V> xVar) {
            this.f10500b = future;
            this.f10501c = xVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable a10;
            Future<V> future = this.f10500b;
            if ((future instanceof q5.a) && (a10 = q5.b.a((q5.a) future)) != null) {
                this.f10501c.onFailure(a10);
                return;
            }
            try {
                this.f10501c.onSuccess(l.h(this.f10500b));
            } catch (Error e10) {
                e = e10;
                this.f10501c.onFailure(e);
            } catch (RuntimeException e11) {
                e = e11;
                this.f10501c.onFailure(e);
            } catch (ExecutionException e12) {
                this.f10501c.onFailure(e12.getCause());
            }
        }

        public String toString() {
            return com.google.common.base.a.c(this).s(this.f10501c).toString();
        }
    }

    @a5.b
    @a5.a
    @CanIgnoreReturnValue
    public static final class e<V> {

        /* renamed from: a */
        public final boolean f10502a;

        /* renamed from: b */
        public final ImmutableList<c0<? extends V>> f10503b;

        public class a implements Callable<Void> {

            /* renamed from: b */
            public final /* synthetic */ Runnable f10504b;

            public a(e eVar, Runnable runnable) {
                this.f10504b = runnable;
            }

            @Override // java.util.concurrent.Callable
            @CheckForNull
            public Void call() throws Exception {
                this.f10504b.run();
                return null;
            }
        }

        public /* synthetic */ e(boolean z10, ImmutableList immutableList, a aVar) {
            this(z10, immutableList);
        }

        public <C> c0<C> a(p5.e<C> eVar, Executor executor) {
            return new CombinedFuture(this.f10503b, this.f10502a, executor, eVar);
        }

        public c0<?> b(Runnable runnable, Executor executor) {
            return call(new a(this, runnable), executor);
        }

        @CanIgnoreReturnValue
        public <C> c0<C> call(Callable<C> callable, Executor executor) {
            return new CombinedFuture(this.f10503b, this.f10502a, executor, callable);
        }

        public e(boolean z10, ImmutableList<c0<? extends V>> immutableList) {
            this.f10502a = z10;
            this.f10503b = immutableList;
        }
    }

    public static final class f<T> extends AbstractFuture<T> {

        /* renamed from: b */
        @CheckForNull
        public g<T> f10505b;

        public /* synthetic */ f(g gVar, a aVar) {
            this(gVar);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public void afterDone() {
            this.f10505b = null;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean cancel(boolean z10) {
            g<T> gVar = this.f10505b;
            if (!super.cancel(z10)) {
                return false;
            }
            Objects.requireNonNull(gVar);
            gVar.g(z10);
            return true;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        @CheckForNull
        public String pendingToString() {
            g<T> gVar = this.f10505b;
            if (gVar == null) {
                return null;
            }
            int length = gVar.f10509d.length;
            int i10 = gVar.f10508c.get();
            StringBuilder sb2 = new StringBuilder(49);
            sb2.append("inputCount=[");
            sb2.append(length);
            sb2.append("], remaining=[");
            sb2.append(i10);
            sb2.append("]");
            return sb2.toString();
        }

        public f(g<T> gVar) {
            this.f10505b = gVar;
        }
    }

    public static final class g<T> {

        /* renamed from: a */
        public boolean f10506a;

        /* renamed from: b */
        public boolean f10507b;

        /* renamed from: c */
        public final AtomicInteger f10508c;

        /* renamed from: d */
        public final c0<? extends T>[] f10509d;

        /* renamed from: e */
        public volatile int f10510e;

        public /* synthetic */ g(c0[] c0VarArr, a aVar) {
            this(c0VarArr);
        }

        public final void e() {
            if (this.f10508c.decrementAndGet() == 0 && this.f10506a) {
                for (c0<? extends T> c0Var : this.f10509d) {
                    if (c0Var != null) {
                        c0Var.cancel(this.f10507b);
                    }
                }
            }
        }

        public final void f(ImmutableList<AbstractFuture<T>> immutableList, int i10) {
            c0<? extends T> c0Var = this.f10509d[i10];
            Objects.requireNonNull(c0Var);
            c0<? extends T> c0Var2 = c0Var;
            this.f10509d[i10] = null;
            for (int i11 = this.f10510e; i11 < immutableList.size(); i11++) {
                if (immutableList.get(i11).setFuture(c0Var2)) {
                    e();
                    this.f10510e = i11 + 1;
                    return;
                }
            }
            this.f10510e = immutableList.size();
        }

        public final void g(boolean z10) {
            this.f10506a = true;
            if (!z10) {
                this.f10507b = false;
            }
            e();
        }

        public g(c0<? extends T>[] c0VarArr) {
            this.f10506a = false;
            this.f10507b = true;
            this.f10510e = 0;
            this.f10509d = c0VarArr;
            this.f10508c = new AtomicInteger(c0VarArr.length);
        }
    }

    public static final class h<V> extends AbstractFuture.i<V> implements Runnable {

        /* renamed from: b */
        @CheckForNull
        public c0<V> f10511b;

        public h(c0<V> c0Var) {
            this.f10511b = c0Var;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public void afterDone() {
            this.f10511b = null;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        @CheckForNull
        public String pendingToString() {
            c0<V> c0Var = this.f10511b;
            if (c0Var == null) {
                return null;
            }
            String valueOf = String.valueOf(c0Var);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 11);
            sb2.append("delegate=[");
            sb2.append(valueOf);
            sb2.append("]");
            return sb2.toString();
        }

        @Override // java.lang.Runnable
        public void run() {
            c0<V> c0Var = this.f10511b;
            if (c0Var != null) {
                setFuture(c0Var);
            }
        }
    }

    @SafeVarargs
    @a5.a
    public static <V> e<V> A(c0<? extends V>... c0VarArr) {
        return new e<>(false, ImmutableList.copyOf(c0VarArr), null);
    }

    @a5.a
    public static <V> e<V> B(Iterable<? extends c0<? extends V>> iterable) {
        return new e<>(true, ImmutableList.copyOf(iterable), null);
    }

    @SafeVarargs
    @a5.a
    public static <V> e<V> C(c0<? extends V>... c0VarArr) {
        return new e<>(true, ImmutableList.copyOf(c0VarArr), null);
    }

    @a5.a
    @a5.c
    public static <V> c0<V> D(c0<V> c0Var, long j10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return c0Var.isDone() ? c0Var : TimeoutFuture.y(c0Var, j10, timeUnit, scheduledExecutorService);
    }

    public static void E(Throwable th2) {
        if (!(th2 instanceof Error)) {
            throw new UncheckedExecutionException(th2);
        }
        throw new ExecutionError((Error) th2);
    }

    public static <V> void a(c0<V> c0Var, x<? super V> xVar, Executor executor) {
        u.E(xVar);
        c0Var.addListener(new d(c0Var, xVar), executor);
    }

    @a5.a
    public static <V> c0<List<V>> b(Iterable<? extends c0<? extends V>> iterable) {
        return new h.a(ImmutableList.copyOf(iterable), true);
    }

    @SafeVarargs
    @a5.a
    public static <V> c0<List<V>> c(c0<? extends V>... c0VarArr) {
        return new h.a(ImmutableList.copyOf(c0VarArr), true);
    }

    @a5.a
    @q.a("AVAILABLE but requires exceptionType to be Throwable.class")
    public static <V, X extends Throwable> c0<V> d(c0<? extends V> c0Var, Class<X> cls, b5.n<? super X, ? extends V> nVar, Executor executor) {
        return com.google.common.util.concurrent.a.v(c0Var, cls, nVar, executor);
    }

    @a5.a
    @q.a("AVAILABLE but requires exceptionType to be Throwable.class")
    public static <V, X extends Throwable> c0<V> e(c0<? extends V> c0Var, Class<X> cls, p5.f<? super X, ? extends V> fVar, Executor executor) {
        return com.google.common.util.concurrent.a.w(c0Var, cls, fVar, executor);
    }

    @a5.a
    @l0
    @CanIgnoreReturnValue
    @a5.c
    public static <V, X extends Exception> V f(Future<V> future, Class<X> cls) throws Exception {
        return (V) FuturesGetChecked.d(future, cls);
    }

    @a5.a
    @l0
    @CanIgnoreReturnValue
    @a5.c
    public static <V, X extends Exception> V g(Future<V> future, Class<X> cls, long j10, TimeUnit timeUnit) throws Exception {
        return (V) FuturesGetChecked.e(future, cls, j10, timeUnit);
    }

    @CanIgnoreReturnValue
    @l0
    public static <V> V h(Future<V> future) throws ExecutionException {
        u.x0(future.isDone(), "Future was expected to be done: %s", future);
        return (V) b1.f(future);
    }

    @CanIgnoreReturnValue
    @l0
    public static <V> V i(Future<V> future) {
        u.E(future);
        try {
            return (V) b1.f(future);
        } catch (ExecutionException e10) {
            E(e10.getCause());
            throw new AssertionError();
        }
    }

    public static <T> c0<? extends T>[] j(Iterable<? extends c0<? extends T>> iterable) {
        return (c0[]) (iterable instanceof Collection ? (Collection) iterable : ImmutableList.copyOf(iterable)).toArray(new c0[0]);
    }

    public static <V> c0<V> k() {
        m.a<Object> aVar = m.a.f10515b;
        return aVar != null ? aVar : new m.a();
    }

    public static <V> c0<V> l(Throwable th2) {
        u.E(th2);
        return new m.b(th2);
    }

    public static <V> c0<V> m(@l0 V v10) {
        return v10 == null ? (c0<V>) m.f10512c : new m(v10);
    }

    public static c0<Void> n() {
        return m.f10512c;
    }

    public static <T> ImmutableList<c0<T>> o(Iterable<? extends c0<? extends T>> iterable) {
        c0[] j10 = j(iterable);
        g gVar = new g(j10, null);
        ImmutableList.a builderWithExpectedSize = ImmutableList.builderWithExpectedSize(j10.length);
        for (int i10 = 0; i10 < j10.length; i10++) {
            builderWithExpectedSize.a(new f(gVar, null));
        }
        ImmutableList<c0<T>> e10 = builderWithExpectedSize.e();
        for (int i11 = 0; i11 < j10.length; i11++) {
            j10[i11].addListener(new c(gVar, e10, i11), p.c());
        }
        return e10;
    }

    @a5.a
    @a5.c
    public static <I, O> Future<O> p(Future<I> future, b5.n<? super I, ? extends O> nVar) {
        u.E(future);
        u.E(nVar);
        return new b(future, nVar);
    }

    public static <V> c0<V> q(c0<V> c0Var) {
        if (c0Var.isDone()) {
            return c0Var;
        }
        h hVar = new h(c0Var);
        c0Var.addListener(hVar, p.c());
        return hVar;
    }

    @a5.c
    public static <O> c0<O> r(p5.e<O> eVar, long j10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        TrustedListenableFutureTask x10 = TrustedListenableFutureTask.x(eVar);
        x10.addListener(new a(scheduledExecutorService.schedule(x10, j10, timeUnit)), p.c());
        return x10;
    }

    public static c0<Void> s(Runnable runnable, Executor executor) {
        TrustedListenableFutureTask v10 = TrustedListenableFutureTask.v(runnable, null);
        executor.execute(v10);
        return v10;
    }

    public static <O> c0<O> t(Callable<O> callable, Executor executor) {
        TrustedListenableFutureTask w10 = TrustedListenableFutureTask.w(callable);
        executor.execute(w10);
        return w10;
    }

    public static <O> c0<O> u(p5.e<O> eVar, Executor executor) {
        TrustedListenableFutureTask x10 = TrustedListenableFutureTask.x(eVar);
        executor.execute(x10);
        return x10;
    }

    @a5.a
    public static <V> c0<List<V>> v(Iterable<? extends c0<? extends V>> iterable) {
        return new h.a(ImmutableList.copyOf(iterable), false);
    }

    @SafeVarargs
    @a5.a
    public static <V> c0<List<V>> w(c0<? extends V>... c0VarArr) {
        return new h.a(ImmutableList.copyOf(c0VarArr), false);
    }

    @a5.a
    public static <I, O> c0<O> x(c0<I> c0Var, b5.n<? super I, ? extends O> nVar, Executor executor) {
        return com.google.common.util.concurrent.f.v(c0Var, nVar, executor);
    }

    @a5.a
    public static <I, O> c0<O> y(c0<I> c0Var, p5.f<? super I, ? extends O> fVar, Executor executor) {
        return com.google.common.util.concurrent.f.w(c0Var, fVar, executor);
    }

    @a5.a
    public static <V> e<V> z(Iterable<? extends c0<? extends V>> iterable) {
        return new e<>(false, ImmutableList.copyOf(iterable), null);
    }
}
