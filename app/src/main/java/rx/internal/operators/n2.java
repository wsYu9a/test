package rx.internal.operators;

import rx.d;
import rx.internal.operators.m2;

/* loaded from: classes5.dex */
public class n2<T, U, V> extends m2<T> {

    class a implements m2.b<T> {

        /* renamed from: a */
        final /* synthetic */ rx.k.n f36283a;

        /* renamed from: rx.internal.operators.n2$a$a */
        class C0866a extends rx.g<U> {

            /* renamed from: f */
            final /* synthetic */ m2.d f36284f;

            /* renamed from: g */
            final /* synthetic */ Long f36285g;

            C0866a(m2.d dVar, Long l) {
                this.f36284f = dVar;
                this.f36285g = l;
            }

            @Override // rx.b
            public void onCompleted() {
                this.f36284f.g(this.f36285g.longValue());
            }

            @Override // rx.b
            public void onError(Throwable th) {
                this.f36284f.onError(th);
            }

            @Override // rx.b
            public void onNext(U u) {
                this.f36284f.g(this.f36285g.longValue());
            }
        }

        a(rx.k.n nVar) {
            this.f36283a = nVar;
        }

        @Override // rx.k.q
        public rx.h call(m2.d<T> dVar, Long l, d.a aVar) {
            rx.k.n nVar = this.f36283a;
            if (nVar == null) {
                return rx.p.f.e();
            }
            try {
                return ((rx.a) nVar.call()).T4(new C0866a(dVar, l));
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                dVar.onError(th);
                return rx.p.f.e();
            }
        }
    }

    class b implements m2.c<T> {

        /* renamed from: a */
        final /* synthetic */ rx.k.o f36287a;

        class a extends rx.g<V> {

            /* renamed from: f */
            final /* synthetic */ m2.d f36288f;

            /* renamed from: g */
            final /* synthetic */ Long f36289g;

            a(m2.d dVar, Long l) {
                this.f36288f = dVar;
                this.f36289g = l;
            }

            @Override // rx.b
            public void onCompleted() {
                this.f36288f.g(this.f36289g.longValue());
            }

            @Override // rx.b
            public void onError(Throwable th) {
                this.f36288f.onError(th);
            }

            @Override // rx.b
            public void onNext(V v) {
                this.f36288f.g(this.f36289g.longValue());
            }
        }

        b(rx.k.o oVar) {
            this.f36287a = oVar;
        }

        @Override // rx.k.r
        public /* bridge */ /* synthetic */ rx.h call(Object obj, Long l, Object obj2, d.a aVar) {
            return call((m2.d<Long>) obj, l, (Long) obj2, aVar);
        }

        public rx.h call(m2.d<T> dVar, Long l, T t, d.a aVar) {
            try {
                return ((rx.a) this.f36287a.call(t)).T4(new a(dVar, l));
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                dVar.onError(th);
                return rx.p.f.e();
            }
        }
    }

    public n2(rx.k.n<? extends rx.a<U>> nVar, rx.k.o<? super T, ? extends rx.a<V>> oVar, rx.a<? extends T> aVar) {
        super(new a(nVar), new b(oVar), aVar, rx.n.f.c());
    }

    @Override // rx.internal.operators.m2
    public /* bridge */ /* synthetic */ rx.g call(rx.g gVar) {
        return super.call(gVar);
    }
}
