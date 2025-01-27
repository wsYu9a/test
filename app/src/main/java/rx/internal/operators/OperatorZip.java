package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.a;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;

/* loaded from: classes5.dex */
public final class OperatorZip<R> implements a.n0<R, rx.a<?>[]> {

    /* renamed from: a */
    final rx.k.x<? extends R> f35832a;

    private static final class ZipProducer<R> extends AtomicLong implements rx.c {
        private static final long serialVersionUID = -1216676403723546796L;
        private a<R> zipper;

        public ZipProducer(a<R> aVar) {
            this.zipper = aVar;
        }

        @Override // rx.c
        public void request(long j2) {
            rx.internal.operators.a.a(this, j2);
            this.zipper.c();
        }
    }

    private static final class a<R> {

        /* renamed from: a */
        static final AtomicLongFieldUpdater<a> f35833a = AtomicLongFieldUpdater.newUpdater(a.class, "f");

        /* renamed from: b */
        static final int f35834b;

        /* renamed from: c */
        private final rx.b<? super R> f35835c;

        /* renamed from: d */
        private final rx.k.x<? extends R> f35836d;

        /* renamed from: e */
        private final rx.p.b f35837e;

        /* renamed from: f */
        volatile long f35838f;

        /* renamed from: g */
        int f35839g;

        /* renamed from: h */
        private Object[] f35840h;

        /* renamed from: i */
        private AtomicLong f35841i;

        /* renamed from: rx.internal.operators.OperatorZip$a$a */
        final class C0847a extends rx.g {

            /* renamed from: f */
            final rx.internal.util.e f35842f = rx.internal.util.e.f();

            C0847a() {
            }

            @Override // rx.g
            public void d() {
                e(rx.internal.util.e.f36784c);
            }

            public void g(long j2) {
                e(j2);
            }

            @Override // rx.b
            public void onCompleted() {
                this.f35842f.l();
                a.this.c();
            }

            @Override // rx.b
            public void onError(Throwable th) {
                a.this.f35835c.onError(th);
            }

            @Override // rx.b
            public void onNext(Object obj) {
                try {
                    this.f35842f.n(obj);
                } catch (MissingBackpressureException e2) {
                    onError(e2);
                }
                a.this.c();
            }
        }

        static {
            double d2 = rx.internal.util.e.f36784c;
            Double.isNaN(d2);
            f35834b = (int) (d2 * 0.7d);
        }

        public a(rx.g<? super R> gVar, rx.k.x<? extends R> xVar) {
            rx.p.b bVar = new rx.p.b();
            this.f35837e = bVar;
            this.f35839g = 0;
            this.f35835c = gVar;
            this.f35836d = xVar;
            gVar.b(bVar);
        }

        public void b(rx.a[] aVarArr, AtomicLong atomicLong) {
            this.f35840h = new Object[aVarArr.length];
            this.f35841i = atomicLong;
            for (int i2 = 0; i2 < aVarArr.length; i2++) {
                C0847a c0847a = new C0847a();
                this.f35840h[i2] = c0847a;
                this.f35837e.a(c0847a);
            }
            for (int i3 = 0; i3 < aVarArr.length; i3++) {
                aVarArr[i3].T4((C0847a) this.f35840h[i3]);
            }
        }

        void c() {
            Object[] objArr = this.f35840h;
            if (objArr == null || f35833a.getAndIncrement(this) != 0) {
                return;
            }
            int length = objArr.length;
            rx.b<? super R> bVar = this.f35835c;
            AtomicLong atomicLong = this.f35841i;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i2 = 0; i2 < length; i2++) {
                    rx.internal.util.e eVar = ((C0847a) objArr[i2]).f35842f;
                    Object o = eVar.o();
                    if (o == null) {
                        z = false;
                    } else {
                        if (eVar.i(o)) {
                            bVar.onCompleted();
                            this.f35837e.unsubscribe();
                            return;
                        }
                        objArr2[i2] = eVar.h(o);
                    }
                }
                if (atomicLong.get() > 0 && z) {
                    try {
                        bVar.onNext(this.f35836d.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.f35839g++;
                        for (Object obj : objArr) {
                            rx.internal.util.e eVar2 = ((C0847a) obj).f35842f;
                            eVar2.p();
                            if (eVar2.i(eVar2.o())) {
                                bVar.onCompleted();
                                this.f35837e.unsubscribe();
                                return;
                            }
                        }
                        if (this.f35839g > f35834b) {
                            for (Object obj2 : objArr) {
                                ((C0847a) obj2).g(this.f35839g);
                            }
                            this.f35839g = 0;
                        }
                    } catch (Throwable th) {
                        bVar.onError(OnErrorThrowable.addValueAsLastCause(th, objArr2));
                        return;
                    }
                } else if (f35833a.decrementAndGet(this) <= 0) {
                    return;
                }
            }
        }
    }

    private final class b extends rx.g<rx.a[]> {

        /* renamed from: f */
        final rx.g<? super R> f35844f;

        /* renamed from: g */
        final a<R> f35845g;

        /* renamed from: h */
        final ZipProducer<R> f35846h;

        /* renamed from: i */
        boolean f35847i;

        public b(rx.g<? super R> gVar, a<R> aVar, ZipProducer<R> zipProducer) {
            super(gVar);
            this.f35847i = false;
            this.f35844f = gVar;
            this.f35845g = aVar;
            this.f35846h = zipProducer;
        }

        @Override // rx.b
        /* renamed from: g */
        public void onNext(rx.a[] aVarArr) {
            if (aVarArr == null || aVarArr.length == 0) {
                this.f35844f.onCompleted();
            } else {
                this.f35847i = true;
                this.f35845g.b(aVarArr, this.f35846h);
            }
        }

        @Override // rx.b
        public void onCompleted() {
            if (this.f35847i) {
                return;
            }
            this.f35844f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f35844f.onError(th);
        }
    }

    public OperatorZip(rx.k.x<? extends R> xVar) {
        this.f35832a = xVar;
    }

    @Override // rx.k.o
    public rx.g<? super rx.a[]> call(rx.g<? super R> gVar) {
        a aVar = new a(gVar, this.f35832a);
        ZipProducer zipProducer = new ZipProducer(aVar);
        gVar.f(zipProducer);
        return new b(gVar, aVar, zipProducer);
    }

    public OperatorZip(rx.k.p pVar) {
        this.f35832a = rx.k.z.g(pVar);
    }

    public OperatorZip(rx.k.q qVar) {
        this.f35832a = rx.k.z.h(qVar);
    }

    public OperatorZip(rx.k.r rVar) {
        this.f35832a = rx.k.z.i(rVar);
    }

    public OperatorZip(rx.k.s sVar) {
        this.f35832a = rx.k.z.j(sVar);
    }

    public OperatorZip(rx.k.t tVar) {
        this.f35832a = rx.k.z.k(tVar);
    }

    public OperatorZip(rx.k.u uVar) {
        this.f35832a = rx.k.z.l(uVar);
    }

    public OperatorZip(rx.k.v vVar) {
        this.f35832a = rx.k.z.m(vVar);
    }

    public OperatorZip(rx.k.w wVar) {
        this.f35832a = rx.k.z.n(wVar);
    }
}
