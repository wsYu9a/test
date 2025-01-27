package rx.internal.operators;

import rx.a;

/* loaded from: classes5.dex */
public final class o2<T> implements a.n0<rx.n.j<T>, T> {

    /* renamed from: a */
    private final rx.d f36315a;

    class a extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.g f36316f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36316f = gVar2;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36316f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36316f.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f36316f.onNext(new rx.n.j(o2.this.f36315a.b(), t));
        }
    }

    public o2(rx.d dVar) {
        this.f36315a = dVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super rx.n.j<T>> gVar) {
        return new a(gVar, gVar);
    }
}
