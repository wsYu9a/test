package com.google.common.util.concurrent;

import b5.u;
import com.google.common.util.concurrent.j;
import com.google.errorprone.annotations.ForOverride;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;
import p5.c0;
import p5.l0;

@a5.b
@p5.m
/* loaded from: classes2.dex */
public abstract class f<I, O, F, T> extends j.a<O> implements Runnable {

    /* renamed from: b */
    @CheckForNull
    public c0<? extends I> f10478b;

    /* renamed from: c */
    @CheckForNull
    public F f10479c;

    public static final class a<I, O> extends f<I, O, p5.f<? super I, ? extends O>, c0<? extends O>> {
        public a(c0<? extends I> c0Var, p5.f<? super I, ? extends O> fVar) {
            super(c0Var, fVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.f
        /* renamed from: y */
        public c0<? extends O> x(p5.f<? super I, ? extends O> fVar, @l0 I i10) throws Exception {
            c0<? extends O> apply = fVar.apply(i10);
            u.V(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", fVar);
            return apply;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.f
        public void setResult(c0<? extends O> c0Var) {
            setFuture(c0Var);
        }
    }

    public static final class b<I, O> extends f<I, O, b5.n<? super I, ? extends O>, O> {
        public b(c0<? extends I> c0Var, b5.n<? super I, ? extends O> nVar) {
            super(c0Var, nVar);
        }

        @Override // com.google.common.util.concurrent.f
        public void setResult(@l0 O o10) {
            set(o10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.f
        @l0
        /* renamed from: y */
        public O x(b5.n<? super I, ? extends O> nVar, @l0 I i10) {
            return nVar.apply(i10);
        }
    }

    public f(c0<? extends I> c0Var, F f10) {
        this.f10478b = (c0) u.E(c0Var);
        this.f10479c = (F) u.E(f10);
    }

    public static <I, O> c0<O> v(c0<I> c0Var, b5.n<? super I, ? extends O> nVar, Executor executor) {
        u.E(nVar);
        b bVar = new b(c0Var, nVar);
        c0Var.addListener(bVar, p.p(executor, bVar));
        return bVar;
    }

    public static <I, O> c0<O> w(c0<I> c0Var, p5.f<? super I, ? extends O> fVar, Executor executor) {
        u.E(executor);
        a aVar = new a(c0Var, fVar);
        c0Var.addListener(aVar, p.p(executor, aVar));
        return aVar;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        maybePropagateCancellationTo(this.f10478b);
        this.f10478b = null;
        this.f10479c = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    public String pendingToString() {
        String str;
        c0<? extends I> c0Var = this.f10478b;
        F f10 = this.f10479c;
        String pendingToString = super.pendingToString();
        if (c0Var != null) {
            String valueOf = String.valueOf(c0Var);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 16);
            sb2.append("inputFuture=[");
            sb2.append(valueOf);
            sb2.append("], ");
            str = sb2.toString();
        } else {
            str = "";
        }
        if (f10 == null) {
            if (pendingToString == null) {
                return null;
            }
            String valueOf2 = String.valueOf(str);
            return pendingToString.length() != 0 ? valueOf2.concat(pendingToString) : new String(valueOf2);
        }
        String valueOf3 = String.valueOf(f10);
        StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 11 + valueOf3.length());
        sb3.append(str);
        sb3.append("function=[");
        sb3.append(valueOf3);
        sb3.append("]");
        return sb3.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        c0<? extends I> c0Var = this.f10478b;
        F f10 = this.f10479c;
        if ((isCancelled() | (c0Var == null)) || (f10 == null)) {
            return;
        }
        this.f10478b = null;
        if (c0Var.isCancelled()) {
            setFuture(c0Var);
            return;
        }
        try {
            try {
                Object x10 = x(f10, l.h(c0Var));
                this.f10479c = null;
                setResult(x10);
            } catch (Throwable th2) {
                try {
                    setException(th2);
                } finally {
                    this.f10479c = null;
                }
            }
        } catch (Error e10) {
            setException(e10);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e11) {
            setException(e11);
        } catch (ExecutionException e12) {
            setException(e12.getCause());
        }
    }

    @ForOverride
    public abstract void setResult(@l0 T t10);

    @ForOverride
    @l0
    public abstract T x(F f10, @l0 I i10) throws Exception;
}
