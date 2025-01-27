package rx.internal.operators;

import rx.a;

/* loaded from: classes5.dex */
public final class a2<T> implements a.n0<T, T> {

    /* renamed from: a */
    private final rx.a<? extends T> f35870a;

    private static final class a<T> extends rx.g<T> {

        /* renamed from: f */
        private final rx.internal.producers.a f35871f;

        /* renamed from: g */
        private final rx.g<? super T> f35872g;

        a(rx.g<? super T> gVar, rx.internal.producers.a aVar) {
            this.f35872g = gVar;
            this.f35871f = aVar;
        }

        @Override // rx.g
        public void f(rx.c cVar) {
            this.f35871f.c(cVar);
        }

        @Override // rx.b
        public void onCompleted() {
            this.f35872g.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f35872g.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f35872g.onNext(t);
            this.f35871f.b(1L);
        }
    }

    private static final class b<T> extends rx.g<T> {

        /* renamed from: f */
        private boolean f35873f = true;

        /* renamed from: g */
        private final rx.g<? super T> f35874g;

        /* renamed from: h */
        private final rx.p.e f35875h;

        /* renamed from: i */
        private final rx.internal.producers.a f35876i;

        /* renamed from: j */
        private final rx.a<? extends T> f35877j;

        b(rx.g<? super T> gVar, rx.p.e eVar, rx.internal.producers.a aVar, rx.a<? extends T> aVar2) {
            this.f35874g = gVar;
            this.f35875h = eVar;
            this.f35876i = aVar;
            this.f35877j = aVar2;
        }

        private void g() {
            a aVar = new a(this.f35874g, this.f35876i);
            this.f35875h.b(aVar);
            this.f35877j.T4(aVar);
        }

        @Override // rx.g
        public void f(rx.c cVar) {
            this.f35876i.c(cVar);
        }

        @Override // rx.b
        public void onCompleted() {
            if (!this.f35873f) {
                this.f35874g.onCompleted();
            } else {
                if (this.f35874g.isUnsubscribed()) {
                    return;
                }
                g();
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f35874g.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f35873f = false;
            this.f35874g.onNext(t);
            this.f35876i.b(1L);
        }
    }

    public a2(rx.a<? extends T> aVar) {
        this.f35870a = aVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        rx.p.e eVar = new rx.p.e();
        rx.internal.producers.a aVar = new rx.internal.producers.a();
        b bVar = new b(gVar, eVar, aVar, this.f35870a);
        eVar.b(bVar);
        gVar.b(eVar);
        gVar.f(aVar);
        return bVar;
    }
}
