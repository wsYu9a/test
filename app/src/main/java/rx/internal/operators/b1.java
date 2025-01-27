package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.a;
import rx.d;
import rx.exceptions.MissingBackpressureException;

/* loaded from: classes5.dex */
public final class b1<T> implements a.n0<T, T> {

    /* renamed from: a */
    private final rx.d f35890a;

    private static final class a<T> extends rx.g<T> {

        /* renamed from: f */
        static final AtomicLongFieldUpdater<a> f35891f = AtomicLongFieldUpdater.newUpdater(a.class, "n");

        /* renamed from: g */
        static final AtomicLongFieldUpdater<a> f35892g = AtomicLongFieldUpdater.newUpdater(a.class, "o");

        /* renamed from: h */
        final rx.g<? super T> f35893h;

        /* renamed from: i */
        final d.a f35894i;

        /* renamed from: j */
        final b f35895j;
        final Queue<Object> l;
        volatile long o;
        volatile Throwable p;
        final NotificationLite<T> k = NotificationLite.f();
        volatile boolean m = false;
        volatile long n = 0;
        final rx.k.a q = new b();

        /* renamed from: rx.internal.operators.b1$a$a */
        class C0849a implements rx.c {
            C0849a() {
            }

            @Override // rx.c
            public void request(long j2) {
                rx.internal.operators.a.b(a.f35891f, a.this, j2);
                a.this.i();
            }
        }

        class b implements rx.k.a {
            b() {
            }

            @Override // rx.k.a
            public void call() {
                a.this.h();
            }
        }

        public a(rx.d dVar, rx.g<? super T> gVar) {
            this.f35893h = gVar;
            d.a a2 = dVar.a();
            this.f35894i = a2;
            if (rx.internal.util.m.g0.f()) {
                this.l = new rx.internal.util.m.y(rx.internal.util.e.f36784c);
            } else {
                this.l = new rx.internal.util.k(rx.internal.util.e.f36784c);
            }
            this.f35895j = new b(a2);
        }

        @Override // rx.g
        public void d() {
            e(rx.internal.util.e.f36784c);
        }

        void g() {
            this.f35893h.b(this.f35895j);
            this.f35893h.f(new C0849a());
            this.f35893h.b(this.f35894i);
            this.f35893h.b(this);
        }

        void h() {
            Object poll;
            int i2 = 0;
            do {
                this.o = 1L;
                long j2 = this.n;
                long j3 = 0;
                while (!this.f35893h.isUnsubscribed()) {
                    if (this.m) {
                        Throwable th = this.p;
                        if (th != null) {
                            this.l.clear();
                            this.f35893h.onError(th);
                            return;
                        } else if (this.l.isEmpty()) {
                            this.f35893h.onCompleted();
                            return;
                        }
                    }
                    if (j2 > 0 && (poll = this.l.poll()) != null) {
                        this.f35893h.onNext(this.k.e(poll));
                        j2--;
                        i2++;
                        j3++;
                    } else if (j3 > 0 && this.n != Long.MAX_VALUE) {
                        f35891f.addAndGet(this, -j3);
                    }
                }
                return;
            } while (f35892g.decrementAndGet(this) > 0);
            if (i2 > 0) {
                e(i2);
            }
        }

        protected void i() {
            if (f35892g.getAndIncrement(this) == 0) {
                this.f35894i.d(this.q);
            }
        }

        @Override // rx.b
        public void onCompleted() {
            if (isUnsubscribed() || this.m) {
                return;
            }
            this.m = true;
            i();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            if (isUnsubscribed() || this.m) {
                return;
            }
            this.p = th;
            unsubscribe();
            this.m = true;
            i();
        }

        @Override // rx.b
        public void onNext(T t) {
            if (isUnsubscribed()) {
                return;
            }
            if (this.l.offer(this.k.l(t))) {
                i();
            } else {
                onError(new MissingBackpressureException());
            }
        }
    }

    static final class b implements rx.h {

        /* renamed from: a */
        static final AtomicIntegerFieldUpdater<b> f35898a = AtomicIntegerFieldUpdater.newUpdater(b.class, "c");

        /* renamed from: b */
        final d.a f35899b;

        /* renamed from: c */
        volatile int f35900c;

        /* renamed from: d */
        volatile boolean f35901d = false;

        class a implements rx.k.a {
            a() {
            }

            @Override // rx.k.a
            public void call() {
                b.this.f35899b.unsubscribe();
                b.this.f35901d = true;
            }
        }

        public b(d.a aVar) {
            this.f35899b = aVar;
        }

        @Override // rx.h
        public boolean isUnsubscribed() {
            return this.f35901d;
        }

        @Override // rx.h
        public void unsubscribe() {
            if (f35898a.getAndSet(this, 1) == 0) {
                this.f35899b.d(new a());
            }
        }
    }

    public b1(rx.d dVar) {
        this.f35890a = dVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        rx.d dVar = this.f35890a;
        if ((dVar instanceof rx.n.d) || (dVar instanceof rx.n.k)) {
            return gVar;
        }
        a aVar = new a(this.f35890a, gVar);
        aVar.g();
        return aVar;
    }
}
