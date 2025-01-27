package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.a;

/* loaded from: classes5.dex */
public final class h0<T> implements a.n0<T, rx.a<? extends T>> {

    static class b<T> extends rx.g<T> {

        /* renamed from: f */
        private static final AtomicIntegerFieldUpdater<b> f36088f = AtomicIntegerFieldUpdater.newUpdater(b.class, "i");

        /* renamed from: g */
        private final rx.g<T> f36089g;

        /* renamed from: h */
        private final d<T> f36090h;

        /* renamed from: i */
        private volatile int f36091i = 0;

        /* renamed from: j */
        private final rx.internal.producers.a f36092j;

        public b(d<T> dVar, rx.g<T> gVar, rx.internal.producers.a aVar) {
            this.f36090h = dVar;
            this.f36089g = gVar;
            this.f36092j = aVar;
        }

        @Override // rx.g
        public void f(rx.c cVar) {
            this.f36092j.c(cVar);
        }

        @Override // rx.b
        public void onCompleted() {
            if (f36088f.compareAndSet(this, 0, 1)) {
                this.f36090h.i();
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            if (f36088f.compareAndSet(this, 0, 1)) {
                this.f36090h.onError(th);
            }
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f36089g.onNext(t);
            this.f36090h.j();
            this.f36092j.b(1L);
        }
    }

    static final class c<T> implements rx.c {

        /* renamed from: a */
        final d<T> f36093a;

        c(d<T> dVar) {
            this.f36093a = dVar;
        }

        @Override // rx.c
        public void request(long j2) {
            this.f36093a.l(j2);
        }
    }

    static final class d<T> extends rx.g<rx.a<? extends T>> {

        /* renamed from: f */
        static final AtomicIntegerFieldUpdater<d> f36094f = AtomicIntegerFieldUpdater.newUpdater(d.class, "m");

        /* renamed from: g */
        private static final AtomicLongFieldUpdater<d> f36095g = AtomicLongFieldUpdater.newUpdater(d.class, "n");

        /* renamed from: h */
        final NotificationLite<rx.a<? extends T>> f36096h;

        /* renamed from: i */
        private final rx.g<T> f36097i;

        /* renamed from: j */
        private final rx.p.e f36098j;
        final ConcurrentLinkedQueue<Object> k;
        volatile b<T> l;
        volatile int m;
        private volatile long n;
        private final rx.internal.producers.a o;

        class a implements rx.k.a {
            a() {
            }

            @Override // rx.k.a
            public void call() {
                d.this.k.clear();
            }
        }

        public d(rx.g<T> gVar, rx.p.e eVar) {
            super(gVar);
            this.f36096h = NotificationLite.f();
            this.f36097i = gVar;
            this.f36098j = eVar;
            this.o = new rx.internal.producers.a();
            this.k = new ConcurrentLinkedQueue<>();
            b(rx.p.f.a(new a()));
        }

        public void j() {
            f36095g.decrementAndGet(this);
        }

        public void l(long j2) {
            if (j2 <= 0) {
                return;
            }
            long b2 = rx.internal.operators.a.b(f36095g, this, j2);
            this.o.request(j2);
            if (b2 == 0 && this.l == null && this.m > 0) {
                m();
            }
        }

        @Override // rx.g
        public void d() {
            e(2L);
        }

        void i() {
            this.l = null;
            if (f36094f.decrementAndGet(this) > 0) {
                m();
            }
            e(1L);
        }

        @Override // rx.b
        /* renamed from: k */
        public void onNext(rx.a<? extends T> aVar) {
            this.k.add(this.f36096h.l(aVar));
            if (f36094f.getAndIncrement(this) == 0) {
                m();
            }
        }

        void m() {
            if (this.n <= 0) {
                if (this.f36096h.g(this.k.peek())) {
                    this.f36097i.onCompleted();
                    return;
                }
                return;
            }
            Object poll = this.k.poll();
            if (this.f36096h.g(poll)) {
                this.f36097i.onCompleted();
            } else if (poll != null) {
                rx.a<? extends T> e2 = this.f36096h.e(poll);
                this.l = new b<>(this, this.f36097i, this.o);
                this.f36098j.b(this.l);
                e2.T4(this.l);
            }
        }

        @Override // rx.b
        public void onCompleted() {
            this.k.add(this.f36096h.b());
            if (f36094f.getAndIncrement(this) == 0) {
                m();
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36097i.onError(th);
            unsubscribe();
        }
    }

    private static final class e {

        /* renamed from: a */
        static final h0<Object> f36100a = new h0<>();

        private e() {
        }
    }

    /* synthetic */ h0(a aVar) {
        this();
    }

    public static <T> h0<T> a() {
        return (h0<T>) e.f36100a;
    }

    private h0() {
    }

    @Override // rx.k.o
    public rx.g<? super rx.a<? extends T>> call(rx.g<? super T> gVar) {
        rx.l.d dVar = new rx.l.d(gVar);
        rx.p.e eVar = new rx.p.e();
        gVar.b(eVar);
        d dVar2 = new d(dVar, eVar);
        gVar.f(new c(dVar2));
        return dVar2;
    }
}
