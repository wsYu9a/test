package p5;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import p5.b0;

@a5.a
@a5.c
@m
/* loaded from: classes2.dex */
public final class b0 {

    public static class a<V> extends u<V> implements c0<V> {

        /* renamed from: f */
        public static final ThreadFactory f29779f;

        /* renamed from: g */
        public static final Executor f29780g;

        /* renamed from: b */
        public final Executor f29781b;

        /* renamed from: c */
        public final n f29782c;

        /* renamed from: d */
        public final AtomicBoolean f29783d;

        /* renamed from: e */
        public final Future<V> f29784e;

        static {
            ThreadFactory b10 = new y0().e(true).f("ListenableFutureAdapter-thread-%d").b();
            f29779f = b10;
            f29780g = Executors.newCachedThreadPool(b10);
        }

        public a(Future<V> future) {
            this(future, f29780g);
        }

        @Override // p5.c0
        public void addListener(Runnable runnable, Executor executor) {
            this.f29782c.a(runnable, executor);
            if (this.f29783d.compareAndSet(false, true)) {
                if (this.f29784e.isDone()) {
                    this.f29782c.b();
                } else {
                    this.f29781b.execute(new Runnable() { // from class: p5.a0
                        public /* synthetic */ a0() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            b0.a.this.g();
                        }
                    });
                }
            }
        }

        @Override // p5.u, e5.l0
        /* renamed from: e */
        public Future<V> delegate() {
            return this.f29784e;
        }

        public final /* synthetic */ void g() {
            try {
                b1.f(this.f29784e);
            } catch (Throwable unused) {
            }
            this.f29782c.b();
        }

        public a(Future<V> future, Executor executor) {
            this.f29782c = new n();
            this.f29783d = new AtomicBoolean(false);
            this.f29784e = (Future) b5.u.E(future);
            this.f29781b = (Executor) b5.u.E(executor);
        }
    }

    public static <V> c0<V> a(Future<V> future) {
        return future instanceof c0 ? (c0) future : new a(future);
    }

    public static <V> c0<V> b(Future<V> future, Executor executor) {
        b5.u.E(executor);
        return future instanceof c0 ? (c0) future : new a(future, executor);
    }
}
