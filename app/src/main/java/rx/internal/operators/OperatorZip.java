package rx.internal.operators;

import ak.e;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import qj.a;
import qj.c;
import qj.g;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import wj.p;
import wj.q;
import wj.r;
import wj.s;
import wj.t;
import wj.u;
import wj.v;
import wj.w;
import wj.x;
import wj.z;

/* loaded from: classes5.dex */
public final class OperatorZip<R> implements a.n0<R, qj.a<?>[]> {

    /* renamed from: b */
    public final x<? extends R> f30521b;

    public static final class ZipProducer<R> extends AtomicLong implements c {
        private static final long serialVersionUID = -1216676403723546796L;
        private a<R> zipper;

        public ZipProducer(a<R> aVar) {
            this.zipper = aVar;
        }

        @Override // qj.c
        public void request(long j10) {
            xj.a.a(this, j10);
            this.zipper.c();
        }
    }

    public static final class a<R> {

        /* renamed from: h */
        public static final AtomicLongFieldUpdater<a> f30522h = AtomicLongFieldUpdater.newUpdater(a.class, "d");

        /* renamed from: i */
        public static final int f30523i = (int) (e.f246h * 0.7d);

        /* renamed from: a */
        public final qj.b<? super R> f30524a;

        /* renamed from: b */
        public final x<? extends R> f30525b;

        /* renamed from: c */
        public final ik.b f30526c;

        /* renamed from: d */
        public volatile long f30527d;

        /* renamed from: e */
        public int f30528e;

        /* renamed from: f */
        public Object[] f30529f;

        /* renamed from: g */
        public AtomicLong f30530g;

        /* renamed from: rx.internal.operators.OperatorZip$a$a */
        public final class C0785a extends g {

            /* renamed from: g */
            public final e f30531g = e.f();

            public C0785a() {
            }

            @Override // qj.g
            public void d() {
                e(e.f246h);
            }

            public void g(long j10) {
                e(j10);
            }

            @Override // qj.b
            public void onCompleted() {
                this.f30531g.l();
                a.this.c();
            }

            @Override // qj.b
            public void onError(Throwable th2) {
                a.this.f30524a.onError(th2);
            }

            @Override // qj.b
            public void onNext(Object obj) {
                try {
                    this.f30531g.n(obj);
                } catch (MissingBackpressureException e10) {
                    onError(e10);
                }
                a.this.c();
            }
        }

        public a(g<? super R> gVar, x<? extends R> xVar) {
            ik.b bVar = new ik.b();
            this.f30526c = bVar;
            this.f30528e = 0;
            this.f30524a = gVar;
            this.f30525b = xVar;
            gVar.b(bVar);
        }

        public void b(qj.a[] aVarArr, AtomicLong atomicLong) {
            this.f30529f = new Object[aVarArr.length];
            this.f30530g = atomicLong;
            for (int i10 = 0; i10 < aVarArr.length; i10++) {
                C0785a c0785a = new C0785a();
                this.f30529f[i10] = c0785a;
                this.f30526c.a(c0785a);
            }
            for (int i11 = 0; i11 < aVarArr.length; i11++) {
                aVarArr[i11].T4((C0785a) this.f30529f[i11]);
            }
        }

        public void c() {
            Object[] objArr = this.f30529f;
            if (objArr == null || f30522h.getAndIncrement(this) != 0) {
                return;
            }
            int length = objArr.length;
            qj.b<? super R> bVar = this.f30524a;
            AtomicLong atomicLong = this.f30530g;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z10 = true;
                for (int i10 = 0; i10 < length; i10++) {
                    e eVar = ((C0785a) objArr[i10]).f30531g;
                    Object o10 = eVar.o();
                    if (o10 == null) {
                        z10 = false;
                    } else {
                        if (eVar.i(o10)) {
                            bVar.onCompleted();
                            this.f30526c.unsubscribe();
                            return;
                        }
                        objArr2[i10] = eVar.h(o10);
                    }
                }
                if (atomicLong.get() > 0 && z10) {
                    try {
                        bVar.onNext(this.f30525b.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.f30528e++;
                        for (Object obj : objArr) {
                            e eVar2 = ((C0785a) obj).f30531g;
                            eVar2.p();
                            if (eVar2.i(eVar2.o())) {
                                bVar.onCompleted();
                                this.f30526c.unsubscribe();
                                return;
                            }
                        }
                        if (this.f30528e > f30523i) {
                            for (Object obj2 : objArr) {
                                ((C0785a) obj2).g(this.f30528e);
                            }
                            this.f30528e = 0;
                        }
                    } catch (Throwable th2) {
                        bVar.onError(OnErrorThrowable.addValueAsLastCause(th2, objArr2));
                        return;
                    }
                } else if (f30522h.decrementAndGet(this) <= 0) {
                    return;
                }
            }
        }
    }

    public final class b extends g<qj.a[]> {

        /* renamed from: g */
        public final g<? super R> f30533g;

        /* renamed from: h */
        public final a<R> f30534h;

        /* renamed from: i */
        public final ZipProducer<R> f30535i;

        /* renamed from: j */
        public boolean f30536j;

        public b(g<? super R> gVar, a<R> aVar, ZipProducer<R> zipProducer) {
            super(gVar);
            this.f30536j = false;
            this.f30533g = gVar;
            this.f30534h = aVar;
            this.f30535i = zipProducer;
        }

        @Override // qj.b
        /* renamed from: g */
        public void onNext(qj.a[] aVarArr) {
            if (aVarArr == null || aVarArr.length == 0) {
                this.f30533g.onCompleted();
            } else {
                this.f30536j = true;
                this.f30534h.b(aVarArr, this.f30535i);
            }
        }

        @Override // qj.b
        public void onCompleted() {
            if (this.f30536j) {
                return;
            }
            this.f30533g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f30533g.onError(th2);
        }
    }

    public OperatorZip(x<? extends R> xVar) {
        this.f30521b = xVar;
    }

    @Override // wj.o
    public g<? super qj.a[]> call(g<? super R> gVar) {
        a aVar = new a(gVar, this.f30521b);
        ZipProducer zipProducer = new ZipProducer(aVar);
        gVar.f(zipProducer);
        return new b(gVar, aVar, zipProducer);
    }

    public OperatorZip(p pVar) {
        this.f30521b = z.g(pVar);
    }

    public OperatorZip(q qVar) {
        this.f30521b = z.h(qVar);
    }

    public OperatorZip(r rVar) {
        this.f30521b = z.i(rVar);
    }

    public OperatorZip(s sVar) {
        this.f30521b = z.j(sVar);
    }

    public OperatorZip(t tVar) {
        this.f30521b = z.k(tVar);
    }

    public OperatorZip(u uVar) {
        this.f30521b = z.l(uVar);
    }

    public OperatorZip(v vVar) {
        this.f30521b = z.m(vVar);
    }

    public OperatorZip(w wVar) {
        this.f30521b = z.n(wVar);
    }
}
