package rx.internal.operators;

import rx.a;

/* loaded from: classes5.dex */
public final class h1<T> implements a.n0<T, T> {

    /* renamed from: a */
    final rx.a<? extends T> f36101a;

    class a extends rx.g<T> {

        /* renamed from: f */
        private boolean f36102f = false;

        /* renamed from: g */
        final /* synthetic */ rx.g f36103g;

        /* renamed from: rx.internal.operators.h1$a$a */
        class C0856a implements rx.c {

            /* renamed from: a */
            final /* synthetic */ rx.c f36105a;

            C0856a(rx.c cVar) {
                this.f36105a = cVar;
            }

            @Override // rx.c
            public void request(long j2) {
                this.f36105a.request(j2);
            }
        }

        a(rx.g gVar) {
            this.f36103g = gVar;
        }

        @Override // rx.g
        public void f(rx.c cVar) {
            this.f36103g.f(new C0856a(cVar));
        }

        @Override // rx.b
        public void onCompleted() {
            if (this.f36102f) {
                return;
            }
            this.f36102f = true;
            this.f36103g.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            if (this.f36102f) {
                rx.exceptions.a.e(th);
                return;
            }
            this.f36102f = true;
            rx.m.d.b().a().a(th);
            unsubscribe();
            h1.this.f36101a.T4(this.f36103g);
        }

        @Override // rx.b
        public void onNext(T t) {
            if (this.f36102f) {
                return;
            }
            this.f36103g.onNext(t);
        }
    }

    public h1(rx.a<? extends T> aVar) {
        this.f36101a = aVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        a aVar = new a(gVar);
        gVar.b(aVar);
        return aVar;
    }
}
