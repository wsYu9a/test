package xj;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import qj.a;
import qj.d;

/* loaded from: classes5.dex */
public class m2<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final b<T> f32444b;

    /* renamed from: c */
    public final c<T> f32445c;

    /* renamed from: d */
    public final qj.a<? extends T> f32446d;

    /* renamed from: e */
    public final qj.d f32447e;

    public interface b<T> extends wj.q<d<T>, Long, d.a, qj.h> {
    }

    public interface c<T> extends wj.r<d<T>, Long, T, d.a, qj.h> {
    }

    public static final class d<T> extends qj.g<T> {

        /* renamed from: o */
        public static final AtomicIntegerFieldUpdater<d> f32448o = AtomicIntegerFieldUpdater.newUpdater(d.class, "m");

        /* renamed from: p */
        public static final AtomicLongFieldUpdater<d> f32449p = AtomicLongFieldUpdater.newUpdater(d.class, "n");

        /* renamed from: g */
        public final ik.e f32450g;

        /* renamed from: h */
        public final Object f32451h;

        /* renamed from: i */
        public final ek.d<T> f32452i;

        /* renamed from: j */
        public final c<T> f32453j;

        /* renamed from: k */
        public final qj.a<? extends T> f32454k;

        /* renamed from: l */
        public final d.a f32455l;

        /* renamed from: m */
        public volatile int f32456m;

        /* renamed from: n */
        public volatile long f32457n;

        public /* synthetic */ d(ek.d dVar, c cVar, ik.e eVar, qj.a aVar, d.a aVar2, a aVar3) {
            this(dVar, cVar, eVar, aVar, aVar2);
        }

        public void g(long j10) {
            boolean z10;
            synchronized (this.f32451h) {
                try {
                    if (j10 == this.f32457n) {
                        z10 = true;
                        if (f32448o.getAndSet(this, 1) == 0) {
                        }
                    }
                    z10 = false;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (z10) {
                qj.a<? extends T> aVar = this.f32454k;
                if (aVar == null) {
                    this.f32452i.onError(new TimeoutException());
                } else {
                    aVar.T4(this.f32452i);
                    this.f32450g.b(this.f32452i);
                }
            }
        }

        @Override // qj.b
        public void onCompleted() {
            boolean z10;
            synchronized (this.f32451h) {
                z10 = true;
                if (f32448o.getAndSet(this, 1) != 0) {
                    z10 = false;
                }
            }
            if (z10) {
                this.f32450g.unsubscribe();
                this.f32452i.onCompleted();
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            boolean z10;
            synchronized (this.f32451h) {
                z10 = true;
                if (f32448o.getAndSet(this, 1) != 0) {
                    z10 = false;
                }
            }
            if (z10) {
                this.f32450g.unsubscribe();
                this.f32452i.onError(th2);
            }
        }

        @Override // qj.b
        public void onNext(T t10) {
            boolean z10;
            synchronized (this.f32451h) {
                try {
                    if (this.f32456m == 0) {
                        f32449p.incrementAndGet(this);
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (z10) {
                this.f32452i.onNext(t10);
                this.f32450g.b(this.f32453j.call(this, Long.valueOf(this.f32457n), t10, this.f32455l));
            }
        }

        public d(ek.d<T> dVar, c<T> cVar, ik.e eVar, qj.a<? extends T> aVar, d.a aVar2) {
            super(dVar);
            this.f32451h = new Object();
            this.f32452i = dVar;
            this.f32453j = cVar;
            this.f32450g = eVar;
            this.f32454k = aVar;
            this.f32455l = aVar2;
        }
    }

    public m2(b<T> bVar, c<T> cVar, qj.a<? extends T> aVar, qj.d dVar) {
        this.f32444b = bVar;
        this.f32445c = cVar;
        this.f32446d = aVar;
        this.f32447e = dVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        d.a a10 = this.f32447e.a();
        gVar.b(a10);
        ik.e eVar = new ik.e();
        gVar.b(eVar);
        d dVar = new d(new ek.d(gVar), this.f32445c, eVar, this.f32446d, a10);
        eVar.b(this.f32444b.call(dVar, 0L, a10));
        return dVar;
    }
}
