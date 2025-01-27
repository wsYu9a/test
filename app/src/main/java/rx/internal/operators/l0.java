package rx.internal.operators;

import rx.a;

/* loaded from: classes5.dex */
public final class l0<T, V> implements a.n0<T, T> {

    /* renamed from: a */
    final rx.a<? extends T> f36211a;

    /* renamed from: b */
    final rx.k.o<? super T, ? extends rx.a<V>> f36212b;

    class a extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.o.c f36213f;

        /* renamed from: g */
        final /* synthetic */ rx.l.d f36214g;

        /* renamed from: rx.internal.operators.l0$a$a */
        class C0862a implements rx.k.o<V, T> {

            /* renamed from: a */
            final /* synthetic */ Object f36216a;

            C0862a(Object obj) {
                this.f36216a = obj;
            }

            @Override // rx.k.o
            public T call(V v) {
                return (T) this.f36216a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.o.c cVar, rx.l.d dVar) {
            super(gVar);
            this.f36213f = cVar;
            this.f36214g = dVar;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36213f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36214g.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.b
        public void onNext(T t) {
            try {
                this.f36213f.onNext(l0.this.f36212b.call(t).S3(1).f0(null).D1(new C0862a(t)));
            } catch (Throwable th) {
                onError(th);
            }
        }
    }

    public l0(rx.a<? extends T> aVar, rx.k.o<? super T, ? extends rx.a<V>> oVar) {
        this.f36211a = aVar;
        this.f36212b = oVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        rx.l.d dVar = new rx.l.d(gVar);
        rx.o.c F5 = rx.o.c.F5();
        gVar.b(rx.a.I1(F5).T4(rx.l.e.e(dVar)));
        return new a(gVar, F5, dVar);
    }
}
