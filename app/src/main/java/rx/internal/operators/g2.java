package rx.internal.operators;

import rx.a;

/* loaded from: classes5.dex */
public final class g2<T, E> implements a.n0<T, T> {

    /* renamed from: a */
    private final rx.a<? extends E> f36073a;

    class a extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.g f36074f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, boolean z, rx.g gVar2) {
            super(gVar, z);
            this.f36074f = gVar2;
        }

        @Override // rx.b
        public void onCompleted() {
            try {
                this.f36074f.onCompleted();
            } finally {
                this.f36074f.unsubscribe();
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            try {
                this.f36074f.onError(th);
            } finally {
                this.f36074f.unsubscribe();
            }
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f36074f.onNext(t);
        }
    }

    class b extends rx.g<E> {

        /* renamed from: f */
        final /* synthetic */ rx.g f36076f;

        b(rx.g gVar) {
            this.f36076f = gVar;
        }

        @Override // rx.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36076f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36076f.onError(th);
        }

        @Override // rx.b
        public void onNext(E e2) {
            onCompleted();
        }
    }

    public g2(rx.a<? extends E> aVar) {
        this.f36073a = aVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        rx.l.d dVar = new rx.l.d(gVar, false);
        a aVar = new a(dVar, false, dVar);
        b bVar = new b(aVar);
        dVar.b(aVar);
        dVar.b(bVar);
        gVar.b(dVar);
        this.f36073a.T4(bVar);
        return aVar;
    }
}
