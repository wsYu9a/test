package rx.internal.operators;

import java.util.BitSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.a;
import rx.exceptions.MissingBackpressureException;

/* loaded from: classes5.dex */
public final class k<T, R> implements a.m0<R> {

    /* renamed from: a */
    final List<? extends rx.a<? extends T>> f36167a;

    /* renamed from: b */
    final rx.k.x<? extends R> f36168b;

    static final class a<T, R> implements rx.c {

        /* renamed from: a */
        private static final AtomicLongFieldUpdater<a> f36169a = AtomicLongFieldUpdater.newUpdater(a.class, "n");

        /* renamed from: d */
        private final List<? extends rx.a<? extends T>> f36172d;

        /* renamed from: e */
        private final rx.g<? super R> f36173e;

        /* renamed from: f */
        private final rx.k.x<? extends R> f36174f;

        /* renamed from: g */
        private final b<T, R>[] f36175g;

        /* renamed from: i */
        private final Object[] f36177i;

        /* renamed from: j */
        private final BitSet f36178j;
        private volatile int k;
        private final BitSet l;
        private volatile int m;
        private volatile long n;

        /* renamed from: b */
        private final AtomicBoolean f36170b = new AtomicBoolean();

        /* renamed from: c */
        private final AtomicLong f36171c = new AtomicLong();

        /* renamed from: h */
        private final rx.internal.util.e f36176h = rx.internal.util.e.f();

        public a(rx.g<? super R> gVar, List<? extends rx.a<? extends T>> list, rx.k.x<? extends R> xVar) {
            this.f36172d = list;
            this.f36173e = gVar;
            this.f36174f = xVar;
            int size = list.size();
            this.f36175g = new b[size];
            this.f36177i = new Object[size];
            this.f36178j = new BitSet(size);
            this.l = new BitSet(size);
        }

        public void a(int i2, boolean z) {
            boolean z2;
            if (!z) {
                this.f36173e.onCompleted();
                return;
            }
            synchronized (this) {
                z2 = false;
                if (!this.l.get(i2)) {
                    this.l.set(i2);
                    this.m++;
                    if (this.m == this.f36177i.length) {
                        z2 = true;
                    }
                }
            }
            if (z2) {
                this.f36176h.l();
                d();
            }
        }

        public void b(Throwable th) {
            this.f36173e.onError(th);
        }

        public boolean c(int i2, T t) {
            synchronized (this) {
                if (!this.f36178j.get(i2)) {
                    this.f36178j.set(i2);
                    this.k++;
                }
                this.f36177i[i2] = t;
                int i3 = this.k;
                Object[] objArr = this.f36177i;
                if (i3 != objArr.length) {
                    return false;
                }
                try {
                    this.f36176h.n(this.f36174f.call(objArr));
                } catch (MissingBackpressureException e2) {
                    b(e2);
                } catch (Throwable th) {
                    b(th);
                }
                d();
                return true;
            }
        }

        void d() {
            Object p;
            if (f36169a.getAndIncrement(this) == 0) {
                int i2 = 0;
                do {
                    if (this.f36171c.get() > 0 && (p = this.f36176h.p()) != null) {
                        if (this.f36176h.i(p)) {
                            this.f36173e.onCompleted();
                        } else {
                            this.f36176h.a(p, this.f36173e);
                            i2++;
                            this.f36171c.decrementAndGet();
                        }
                    }
                } while (f36169a.decrementAndGet(this) > 0);
                if (i2 > 0) {
                    for (b<T, R> bVar : this.f36175g) {
                        bVar.g(i2);
                    }
                }
            }
        }

        @Override // rx.c
        public void request(long j2) {
            rx.internal.operators.a.a(this.f36171c, j2);
            if (!this.f36170b.get()) {
                int i2 = 0;
                if (this.f36170b.compareAndSet(false, true)) {
                    int i3 = rx.internal.util.e.f36784c;
                    int size = i3 / this.f36172d.size();
                    int size2 = i3 % this.f36172d.size();
                    while (i2 < this.f36172d.size()) {
                        rx.a<? extends T> aVar = this.f36172d.get(i2);
                        b<T, R> bVar = new b<>(i2, i2 == this.f36172d.size() - 1 ? size + size2 : size, this.f36173e, this);
                        this.f36175g[i2] = bVar;
                        aVar.T4(bVar);
                        i2++;
                    }
                }
            }
            d();
        }
    }

    static final class b<T, R> extends rx.g<T> {

        /* renamed from: f */
        final a<T, R> f36179f;

        /* renamed from: g */
        final int f36180g;

        /* renamed from: h */
        final AtomicLong f36181h;

        /* renamed from: i */
        boolean f36182i;

        public b(int i2, int i3, rx.g<? super R> gVar, a<T, R> aVar) {
            super(gVar);
            this.f36181h = new AtomicLong();
            this.f36182i = false;
            this.f36180g = i2;
            this.f36179f = aVar;
            e(i3);
        }

        public void g(long j2) {
            long j3;
            long min;
            do {
                j3 = this.f36181h.get();
                min = Math.min(j3, j2);
            } while (!this.f36181h.compareAndSet(j3, j3 - min));
            e(min);
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36179f.a(this.f36180g, this.f36182i);
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36179f.b(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f36182i = true;
            this.f36181h.incrementAndGet();
            if (this.f36179f.c(this.f36180g, t)) {
                return;
            }
            e(1L);
        }
    }

    static final class c<T, R> implements rx.c {

        /* renamed from: a */
        final AtomicBoolean f36183a = new AtomicBoolean();

        /* renamed from: b */
        final rx.a<? extends T> f36184b;

        /* renamed from: c */
        final rx.g<? super R> f36185c;

        /* renamed from: d */
        final rx.k.x<? extends R> f36186d;

        /* renamed from: e */
        final d<T, R> f36187e;

        public c(rx.g<? super R> gVar, rx.a<? extends T> aVar, rx.k.x<? extends R> xVar) {
            this.f36184b = aVar;
            this.f36185c = gVar;
            this.f36186d = xVar;
            this.f36187e = new d<>(gVar, xVar);
        }

        @Override // rx.c
        public void request(long j2) {
            this.f36187e.g(j2);
            if (this.f36183a.compareAndSet(false, true)) {
                this.f36184b.T4(this.f36187e);
            }
        }
    }

    static final class d<T, R> extends rx.g<T> {

        /* renamed from: f */
        private final rx.g<? super R> f36188f;

        /* renamed from: g */
        private final rx.k.x<? extends R> f36189g;

        d(rx.g<? super R> gVar, rx.k.x<? extends R> xVar) {
            super(gVar);
            this.f36188f = gVar;
            this.f36189g = xVar;
        }

        public void g(long j2) {
            e(j2);
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36188f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36188f.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f36188f.onNext(this.f36189g.call(t));
        }
    }

    public k(List<? extends rx.a<? extends T>> list, rx.k.x<? extends R> xVar) {
        this.f36167a = list;
        this.f36168b = xVar;
        if (list.size() > rx.internal.util.e.f36784c) {
            throw new IllegalArgumentException("More than RxRingBuffer.SIZE sources to combineLatest is not supported.");
        }
    }

    @Override // rx.k.b
    public void call(rx.g<? super R> gVar) {
        if (this.f36167a.isEmpty()) {
            gVar.onCompleted();
        } else if (this.f36167a.size() == 1) {
            gVar.f(new c(gVar, this.f36167a.get(0), this.f36168b));
        } else {
            gVar.f(new a(gVar, this.f36167a, this.f36168b));
        }
    }
}
