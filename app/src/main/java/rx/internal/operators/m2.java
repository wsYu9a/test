package rx.internal.operators;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.a;
import rx.d;

/* loaded from: classes5.dex */
class m2<T> implements a.n0<T, T> {

    /* renamed from: a */
    private final b<T> f36258a;

    /* renamed from: b */
    private final c<T> f36259b;

    /* renamed from: c */
    private final rx.a<? extends T> f36260c;

    /* renamed from: d */
    private final rx.d f36261d;

    interface b<T> extends rx.k.q<d<T>, Long, d.a, rx.h> {
    }

    interface c<T> extends rx.k.r<d<T>, Long, T, d.a, rx.h> {
    }

    static final class d<T> extends rx.g<T> {

        /* renamed from: f */
        static final AtomicIntegerFieldUpdater<d> f36262f = AtomicIntegerFieldUpdater.newUpdater(d.class, "n");

        /* renamed from: g */
        static final AtomicLongFieldUpdater<d> f36263g = AtomicLongFieldUpdater.newUpdater(d.class, "o");

        /* renamed from: h */
        private final rx.p.e f36264h;

        /* renamed from: i */
        private final Object f36265i;

        /* renamed from: j */
        private final rx.l.d<T> f36266j;
        private final c<T> k;
        private final rx.a<? extends T> l;
        private final d.a m;
        volatile int n;
        volatile long o;

        /* synthetic */ d(rx.l.d dVar, c cVar, rx.p.e eVar, rx.a aVar, d.a aVar2, a aVar3) {
            this(dVar, cVar, eVar, aVar, aVar2);
        }

        public void g(long j2) {
            boolean z;
            synchronized (this.f36265i) {
                z = true;
                if (j2 != this.o || f36262f.getAndSet(this, 1) != 0) {
                    z = false;
                }
            }
            if (z) {
                rx.a<? extends T> aVar = this.l;
                if (aVar == null) {
                    this.f36266j.onError(new TimeoutException());
                } else {
                    aVar.T4(this.f36266j);
                    this.f36264h.b(this.f36266j);
                }
            }
        }

        @Override // rx.b
        public void onCompleted() {
            boolean z;
            synchronized (this.f36265i) {
                z = true;
                if (f36262f.getAndSet(this, 1) != 0) {
                    z = false;
                }
            }
            if (z) {
                this.f36264h.unsubscribe();
                this.f36266j.onCompleted();
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            boolean z;
            synchronized (this.f36265i) {
                z = true;
                if (f36262f.getAndSet(this, 1) != 0) {
                    z = false;
                }
            }
            if (z) {
                this.f36264h.unsubscribe();
                this.f36266j.onError(th);
            }
        }

        @Override // rx.b
        public void onNext(T t) {
            boolean z;
            synchronized (this.f36265i) {
                if (this.n == 0) {
                    f36263g.incrementAndGet(this);
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                this.f36266j.onNext(t);
                this.f36264h.b(this.k.call(this, Long.valueOf(this.o), t, this.m));
            }
        }

        private d(rx.l.d<T> dVar, c<T> cVar, rx.p.e eVar, rx.a<? extends T> aVar, d.a aVar2) {
            super(dVar);
            this.f36265i = new Object();
            this.f36266j = dVar;
            this.k = cVar;
            this.f36264h = eVar;
            this.l = aVar;
            this.m = aVar2;
        }
    }

    m2(b<T> bVar, c<T> cVar, rx.a<? extends T> aVar, rx.d dVar) {
        this.f36258a = bVar;
        this.f36259b = cVar;
        this.f36260c = aVar;
        this.f36261d = dVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        d.a a2 = this.f36261d.a();
        gVar.b(a2);
        rx.p.e eVar = new rx.p.e();
        gVar.b(eVar);
        d dVar = new d(new rx.l.d(gVar), this.f36259b, eVar, this.f36260c, a2);
        eVar.b(this.f36258a.call(dVar, 0L, a2));
        return dVar;
    }
}
