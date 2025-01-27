package rx.internal.operators;

import rx.a;

/* loaded from: classes5.dex */
public final class j1<T> implements a.n0<T, T> {

    /* renamed from: a */
    final rx.a<? extends T> f36156a;

    class a extends rx.g<T> {

        /* renamed from: f */
        private boolean f36157f = false;

        /* renamed from: g */
        final /* synthetic */ rx.g f36158g;

        /* renamed from: rx.internal.operators.j1$a$a */
        class C0860a implements rx.c {

            /* renamed from: a */
            final /* synthetic */ rx.c f36160a;

            C0860a(rx.c cVar) {
                this.f36160a = cVar;
            }

            @Override // rx.c
            public void request(long j2) {
                this.f36160a.request(j2);
            }
        }

        a(rx.g gVar) {
            this.f36158g = gVar;
        }

        @Override // rx.g
        public void f(rx.c cVar) {
            this.f36158g.f(new C0860a(cVar));
        }

        @Override // rx.b
        public void onCompleted() {
            if (this.f36157f) {
                return;
            }
            this.f36157f = true;
            this.f36158g.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            if (this.f36157f) {
                rx.exceptions.a.e(th);
                return;
            }
            this.f36157f = true;
            if (!(th instanceof Exception)) {
                this.f36158g.onError(th);
                return;
            }
            rx.m.d.b().a().a(th);
            unsubscribe();
            j1.this.f36156a.T4(this.f36158g);
        }

        @Override // rx.b
        public void onNext(T t) {
            if (this.f36157f) {
                return;
            }
            this.f36158g.onNext(t);
        }
    }

    public j1(rx.a<? extends T> aVar) {
        this.f36156a = aVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        a aVar = new a(gVar);
        gVar.b(aVar);
        return aVar;
    }
}
