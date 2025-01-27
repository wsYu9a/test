package com.google.common.util.concurrent;

import b5.u;
import com.google.common.util.concurrent.j;
import com.google.errorprone.annotations.ForOverride;
import java.lang.Throwable;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;
import p5.c0;
import p5.l0;

@a5.b
@p5.m
/* loaded from: classes2.dex */
public abstract class a<V, X extends Throwable, F, T> extends j.a<V> implements Runnable {

    /* renamed from: b */
    @CheckForNull
    public c0<? extends V> f10405b;

    /* renamed from: c */
    @CheckForNull
    public Class<X> f10406c;

    /* renamed from: d */
    @CheckForNull
    public F f10407d;

    /* renamed from: com.google.common.util.concurrent.a$a */
    public static final class C0305a<V, X extends Throwable> extends a<V, X, p5.f<? super X, ? extends V>, c0<? extends V>> {
        public C0305a(c0<? extends V> c0Var, Class<X> cls, p5.f<? super X, ? extends V> fVar) {
            super(c0Var, cls, fVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.a
        /* renamed from: y */
        public c0<? extends V> x(p5.f<? super X, ? extends V> fVar, X x10) throws Exception {
            c0<? extends V> apply = fVar.apply(x10);
            u.V(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", fVar);
            return apply;
        }

        @Override // com.google.common.util.concurrent.a
        public void setResult(c0<? extends V> c0Var) {
            setFuture(c0Var);
        }
    }

    public static final class b<V, X extends Throwable> extends a<V, X, b5.n<? super X, ? extends V>, V> {
        public b(c0<? extends V> c0Var, Class<X> cls, b5.n<? super X, ? extends V> nVar) {
            super(c0Var, cls, nVar);
        }

        @Override // com.google.common.util.concurrent.a
        public void setResult(@l0 V v10) {
            set(v10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.a
        @l0
        /* renamed from: y */
        public V x(b5.n<? super X, ? extends V> nVar, X x10) throws Exception {
            return nVar.apply(x10);
        }
    }

    public a(c0<? extends V> c0Var, Class<X> cls, F f10) {
        this.f10405b = (c0) u.E(c0Var);
        this.f10406c = (Class) u.E(cls);
        this.f10407d = (F) u.E(f10);
    }

    public static <V, X extends Throwable> c0<V> v(c0<? extends V> c0Var, Class<X> cls, b5.n<? super X, ? extends V> nVar, Executor executor) {
        b bVar = new b(c0Var, cls, nVar);
        c0Var.addListener(bVar, p.p(executor, bVar));
        return bVar;
    }

    public static <X extends Throwable, V> c0<V> w(c0<? extends V> c0Var, Class<X> cls, p5.f<? super X, ? extends V> fVar, Executor executor) {
        C0305a c0305a = new C0305a(c0Var, cls, fVar);
        c0Var.addListener(c0305a, p.p(executor, c0305a));
        return c0305a;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        maybePropagateCancellationTo(this.f10405b);
        this.f10405b = null;
        this.f10406c = null;
        this.f10407d = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    public String pendingToString() {
        String str;
        c0<? extends V> c0Var = this.f10405b;
        Class<X> cls = this.f10406c;
        F f10 = this.f10407d;
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
        if (cls == null || f10 == null) {
            if (pendingToString == null) {
                return null;
            }
            String valueOf2 = String.valueOf(str);
            return pendingToString.length() != 0 ? valueOf2.concat(pendingToString) : new String(valueOf2);
        }
        String valueOf3 = String.valueOf(cls);
        String valueOf4 = String.valueOf(f10);
        StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 29 + valueOf3.length() + valueOf4.length());
        sb3.append(str);
        sb3.append("exceptionType=[");
        sb3.append(valueOf3);
        sb3.append("], fallback=[");
        sb3.append(valueOf4);
        sb3.append("]");
        return sb3.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008e  */
    /* JADX WARN: Type inference failed for: r3v4, types: [F, java.lang.Class<X extends java.lang.Throwable>] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r9 = this;
            p5.c0<? extends V> r0 = r9.f10405b
            java.lang.Class<X extends java.lang.Throwable> r1 = r9.f10406c
            F r2 = r9.f10407d
            r3 = 0
            r4 = 1
            if (r0 != 0) goto Lc
            r5 = 1
            goto Ld
        Lc:
            r5 = 0
        Ld:
            if (r1 != 0) goto L11
            r6 = 1
            goto L12
        L11:
            r6 = 0
        L12:
            r5 = r5 | r6
            if (r2 != 0) goto L16
            r3 = 1
        L16:
            r3 = r3 | r5
            if (r3 != 0) goto Lb3
            boolean r3 = r9.isCancelled()
            if (r3 == 0) goto L21
            goto Lb3
        L21:
            r3 = 0
            r9.f10405b = r3
            boolean r4 = r0 instanceof q5.a     // Catch: java.lang.Throwable -> L30 java.util.concurrent.ExecutionException -> L32
            if (r4 == 0) goto L34
            r4 = r0
            q5.a r4 = (q5.a) r4     // Catch: java.lang.Throwable -> L30 java.util.concurrent.ExecutionException -> L32
            java.lang.Throwable r4 = q5.b.a(r4)     // Catch: java.lang.Throwable -> L30 java.util.concurrent.ExecutionException -> L32
            goto L35
        L30:
            r4 = move-exception
            goto L3c
        L32:
            r4 = move-exception
            goto L3e
        L34:
            r4 = r3
        L35:
            if (r4 != 0) goto L3c
            java.lang.Object r5 = com.google.common.util.concurrent.l.h(r0)     // Catch: java.lang.Throwable -> L30 java.util.concurrent.ExecutionException -> L32
            goto L84
        L3c:
            r5 = r3
            goto L84
        L3e:
            java.lang.Throwable r5 = r4.getCause()
            if (r5 != 0) goto L82
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.Class r6 = r0.getClass()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r7 = r6.length()
            int r7 = r7 + 35
            int r8 = r4.length()
            int r7 = r7 + r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r7)
            java.lang.String r7 = "Future type "
            r8.append(r7)
            r8.append(r6)
            java.lang.String r6 = " threw "
            r8.append(r6)
            r8.append(r4)
            java.lang.String r4 = " without a cause"
            r8.append(r4)
            java.lang.String r4 = r8.toString()
            r5.<init>(r4)
        L82:
            r4 = r5
            goto L3c
        L84:
            if (r4 != 0) goto L8e
            java.lang.Object r0 = p5.j0.a(r5)
            r9.set(r0)
            return
        L8e:
            boolean r1 = p5.m0.a(r4, r1)
            if (r1 != 0) goto L98
            r9.setFuture(r0)
            return
        L98:
            java.lang.Object r0 = r9.x(r2, r4)     // Catch: java.lang.Throwable -> La4
            r9.f10406c = r3
            r9.f10407d = r3
            r9.setResult(r0)
            return
        La4:
            r0 = move-exception
            r9.setException(r0)     // Catch: java.lang.Throwable -> Lad
            r9.f10406c = r3
            r9.f10407d = r3
            return
        Lad:
            r0 = move-exception
            r9.f10406c = r3
            r9.f10407d = r3
            throw r0
        Lb3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.a.run():void");
    }

    @ForOverride
    public abstract void setResult(@l0 T t10);

    @ForOverride
    @l0
    public abstract T x(F f10, X x10) throws Exception;
}
