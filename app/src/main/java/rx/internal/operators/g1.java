package rx.internal.operators;

import rx.a;

/* loaded from: classes5.dex */
public final class g1<T> implements a.n0<T, T> {

    /* renamed from: a */
    private final rx.k.o<Throwable, ? extends rx.a<? extends T>> f36066a;

    class a extends rx.g<T> {

        /* renamed from: f */
        private boolean f36067f = false;

        /* renamed from: g */
        final /* synthetic */ rx.g f36068g;

        /* renamed from: h */
        final /* synthetic */ rx.internal.producers.a f36069h;

        /* renamed from: i */
        final /* synthetic */ rx.p.e f36070i;

        /* renamed from: rx.internal.operators.g1$a$a */
        class C0855a extends rx.g<T> {
            C0855a() {
            }

            @Override // rx.g
            public void f(rx.c cVar) {
                a.this.f36069h.c(cVar);
            }

            @Override // rx.b
            public void onCompleted() {
                a.this.f36068g.onCompleted();
            }

            @Override // rx.b
            public void onError(Throwable th) {
                a.this.f36068g.onError(th);
            }

            @Override // rx.b
            public void onNext(T t) {
                a.this.f36068g.onNext(t);
            }
        }

        a(rx.g gVar, rx.internal.producers.a aVar, rx.p.e eVar) {
            this.f36068g = gVar;
            this.f36069h = aVar;
            this.f36070i = eVar;
        }

        @Override // rx.g
        public void f(rx.c cVar) {
            this.f36069h.c(cVar);
        }

        @Override // rx.b
        public void onCompleted() {
            if (this.f36067f) {
                return;
            }
            this.f36067f = true;
            this.f36068g.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            if (this.f36067f) {
                rx.exceptions.a.e(th);
                return;
            }
            this.f36067f = true;
            try {
                rx.m.d.b().a().a(th);
                unsubscribe();
                C0855a c0855a = new C0855a();
                this.f36070i.b(c0855a);
                ((rx.a) g1.this.f36066a.call(th)).T4(c0855a);
            } catch (Throwable th2) {
                this.f36068g.onError(th2);
            }
        }

        @Override // rx.b
        public void onNext(T t) {
            if (this.f36067f) {
                return;
            }
            this.f36068g.onNext(t);
        }
    }

    public g1(rx.k.o<Throwable, ? extends rx.a<? extends T>> oVar) {
        this.f36066a = oVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        rx.internal.producers.a aVar = new rx.internal.producers.a();
        rx.p.e eVar = new rx.p.e();
        a aVar2 = new a(gVar, aVar, eVar);
        gVar.b(eVar);
        eVar.b(aVar2);
        gVar.f(aVar);
        return aVar2;
    }
}
