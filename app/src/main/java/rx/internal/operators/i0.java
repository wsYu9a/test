package rx.internal.operators;

import rx.a;
import rx.internal.operators.j0;

/* loaded from: classes5.dex */
public final class i0<T, U> implements a.n0<T, T> {

    /* renamed from: a */
    final rx.k.o<? super T, ? extends rx.a<U>> f36117a;

    class a extends rx.g<T> {

        /* renamed from: f */
        final j0.b<T> f36118f;

        /* renamed from: g */
        final rx.g<?> f36119g;

        /* renamed from: h */
        final /* synthetic */ rx.l.d f36120h;

        /* renamed from: i */
        final /* synthetic */ rx.p.e f36121i;

        /* renamed from: rx.internal.operators.i0$a$a */
        class C0857a extends rx.g<U> {

            /* renamed from: f */
            final /* synthetic */ int f36123f;

            C0857a(int i2) {
                this.f36123f = i2;
            }

            @Override // rx.b
            public void onCompleted() {
                a aVar = a.this;
                aVar.f36118f.b(this.f36123f, aVar.f36120h, aVar.f36119g);
                unsubscribe();
            }

            @Override // rx.b
            public void onError(Throwable th) {
                a.this.f36119g.onError(th);
            }

            @Override // rx.b
            public void onNext(U u) {
                onCompleted();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.l.d dVar, rx.p.e eVar) {
            super(gVar);
            this.f36120h = dVar;
            this.f36121i = eVar;
            this.f36118f = new j0.b<>();
            this.f36119g = this;
        }

        @Override // rx.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36118f.c(this.f36120h, this);
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36120h.onError(th);
            unsubscribe();
            this.f36118f.a();
        }

        @Override // rx.b
        public void onNext(T t) {
            try {
                rx.a<U> call = i0.this.f36117a.call(t);
                C0857a c0857a = new C0857a(this.f36118f.d(t));
                this.f36121i.b(c0857a);
                call.T4(c0857a);
            } catch (Throwable th) {
                onError(th);
            }
        }
    }

    public i0(rx.k.o<? super T, ? extends rx.a<U>> oVar) {
        this.f36117a = oVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        rx.l.d dVar = new rx.l.d(gVar);
        rx.p.e eVar = new rx.p.e();
        gVar.b(eVar);
        return new a(gVar, dVar, eVar);
    }
}
