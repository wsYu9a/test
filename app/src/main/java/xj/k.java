package xj;

import java.util.BitSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import qj.a;
import rx.exceptions.MissingBackpressureException;

/* loaded from: classes5.dex */
public final class k<T, R> implements a.m0<R> {

    /* renamed from: b */
    public final List<? extends qj.a<? extends T>> f32348b;

    /* renamed from: c */
    public final wj.x<? extends R> f32349c;

    public static final class a<T, R> implements qj.c {

        /* renamed from: o */
        public static final AtomicLongFieldUpdater<a> f32350o = AtomicLongFieldUpdater.newUpdater(a.class, "n");

        /* renamed from: d */
        public final List<? extends qj.a<? extends T>> f32353d;

        /* renamed from: e */
        public final qj.g<? super R> f32354e;

        /* renamed from: f */
        public final wj.x<? extends R> f32355f;

        /* renamed from: g */
        public final b<T, R>[] f32356g;

        /* renamed from: i */
        public final Object[] f32358i;

        /* renamed from: j */
        public final BitSet f32359j;

        /* renamed from: k */
        public volatile int f32360k;

        /* renamed from: l */
        public final BitSet f32361l;

        /* renamed from: m */
        public volatile int f32362m;

        /* renamed from: n */
        public volatile long f32363n;

        /* renamed from: b */
        public final AtomicBoolean f32351b = new AtomicBoolean();

        /* renamed from: c */
        public final AtomicLong f32352c = new AtomicLong();

        /* renamed from: h */
        public final ak.e f32357h = ak.e.f();

        public a(qj.g<? super R> gVar, List<? extends qj.a<? extends T>> list, wj.x<? extends R> xVar) {
            this.f32353d = list;
            this.f32354e = gVar;
            this.f32355f = xVar;
            int size = list.size();
            this.f32356g = new b[size];
            this.f32358i = new Object[size];
            this.f32359j = new BitSet(size);
            this.f32361l = new BitSet(size);
        }

        public void a(int i10, boolean z10) {
            boolean z11;
            if (!z10) {
                this.f32354e.onCompleted();
                return;
            }
            synchronized (this) {
                try {
                    z11 = false;
                    if (!this.f32361l.get(i10)) {
                        this.f32361l.set(i10);
                        this.f32362m++;
                        if (this.f32362m == this.f32358i.length) {
                            z11 = true;
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (z11) {
                this.f32357h.l();
                d();
            }
        }

        public void b(Throwable th2) {
            this.f32354e.onError(th2);
        }

        public boolean c(int i10, T t10) {
            synchronized (this) {
                try {
                    if (!this.f32359j.get(i10)) {
                        this.f32359j.set(i10);
                        this.f32360k++;
                    }
                    this.f32358i[i10] = t10;
                    int i11 = this.f32360k;
                    Object[] objArr = this.f32358i;
                    if (i11 != objArr.length) {
                        return false;
                    }
                    try {
                        this.f32357h.n(this.f32355f.call(objArr));
                    } catch (MissingBackpressureException e10) {
                        b(e10);
                    } catch (Throwable th2) {
                        b(th2);
                    }
                    d();
                    return true;
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }

        public void d() {
            Object p10;
            if (f32350o.getAndIncrement(this) == 0) {
                int i10 = 0;
                do {
                    if (this.f32352c.get() > 0 && (p10 = this.f32357h.p()) != null) {
                        if (this.f32357h.i(p10)) {
                            this.f32354e.onCompleted();
                        } else {
                            this.f32357h.a(p10, this.f32354e);
                            i10++;
                            this.f32352c.decrementAndGet();
                        }
                    }
                } while (f32350o.decrementAndGet(this) > 0);
                if (i10 > 0) {
                    for (b<T, R> bVar : this.f32356g) {
                        bVar.g(i10);
                    }
                }
            }
        }

        @Override // qj.c
        public void request(long j10) {
            xj.a.a(this.f32352c, j10);
            if (!this.f32351b.get()) {
                int i10 = 0;
                if (this.f32351b.compareAndSet(false, true)) {
                    int i11 = ak.e.f246h;
                    int size = i11 / this.f32353d.size();
                    int size2 = i11 % this.f32353d.size();
                    while (i10 < this.f32353d.size()) {
                        qj.a<? extends T> aVar = this.f32353d.get(i10);
                        b<T, R> bVar = new b<>(i10, i10 == this.f32353d.size() - 1 ? size + size2 : size, this.f32354e, this);
                        this.f32356g[i10] = bVar;
                        aVar.T4(bVar);
                        i10++;
                    }
                }
            }
            d();
        }
    }

    public static final class b<T, R> extends qj.g<T> {

        /* renamed from: g */
        public final a<T, R> f32364g;

        /* renamed from: h */
        public final int f32365h;

        /* renamed from: i */
        public final AtomicLong f32366i;

        /* renamed from: j */
        public boolean f32367j;

        public b(int i10, int i11, qj.g<? super R> gVar, a<T, R> aVar) {
            super(gVar);
            this.f32366i = new AtomicLong();
            this.f32367j = false;
            this.f32365h = i10;
            this.f32364g = aVar;
            e(i11);
        }

        public void g(long j10) {
            long j11;
            long min;
            do {
                j11 = this.f32366i.get();
                min = Math.min(j11, j10);
            } while (!this.f32366i.compareAndSet(j11, j11 - min));
            e(min);
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32364g.a(this.f32365h, this.f32367j);
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32364g.b(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32367j = true;
            this.f32366i.incrementAndGet();
            if (this.f32364g.c(this.f32365h, t10)) {
                return;
            }
            e(1L);
        }
    }

    public static final class c<T, R> implements qj.c {

        /* renamed from: b */
        public final AtomicBoolean f32368b = new AtomicBoolean();

        /* renamed from: c */
        public final qj.a<? extends T> f32369c;

        /* renamed from: d */
        public final qj.g<? super R> f32370d;

        /* renamed from: e */
        public final wj.x<? extends R> f32371e;

        /* renamed from: f */
        public final d<T, R> f32372f;

        public c(qj.g<? super R> gVar, qj.a<? extends T> aVar, wj.x<? extends R> xVar) {
            this.f32369c = aVar;
            this.f32370d = gVar;
            this.f32371e = xVar;
            this.f32372f = new d<>(gVar, xVar);
        }

        @Override // qj.c
        public void request(long j10) {
            this.f32372f.g(j10);
            if (this.f32368b.compareAndSet(false, true)) {
                this.f32369c.T4(this.f32372f);
            }
        }
    }

    public static final class d<T, R> extends qj.g<T> {

        /* renamed from: g */
        public final qj.g<? super R> f32373g;

        /* renamed from: h */
        public final wj.x<? extends R> f32374h;

        public d(qj.g<? super R> gVar, wj.x<? extends R> xVar) {
            super(gVar);
            this.f32373g = gVar;
            this.f32374h = xVar;
        }

        public void g(long j10) {
            e(j10);
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32373g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32373g.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32373g.onNext(this.f32374h.call(t10));
        }
    }

    public k(List<? extends qj.a<? extends T>> list, wj.x<? extends R> xVar) {
        this.f32348b = list;
        this.f32349c = xVar;
        if (list.size() > ak.e.f246h) {
            throw new IllegalArgumentException("More than RxRingBuffer.SIZE sources to combineLatest is not supported.");
        }
    }

    @Override // wj.b
    public void call(qj.g<? super R> gVar) {
        if (this.f32348b.isEmpty()) {
            gVar.onCompleted();
        } else if (this.f32348b.size() == 1) {
            gVar.f(new c(gVar, this.f32348b.get(0), this.f32349c));
        } else {
            gVar.f(new a(gVar, this.f32348b, this.f32349c));
        }
    }
}
