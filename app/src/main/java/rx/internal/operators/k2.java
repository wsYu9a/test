package rx.internal.operators;

import rx.a;

/* loaded from: classes5.dex */
public final class k2<T> implements a.n0<rx.n.i<T>, T> {

    /* renamed from: a */
    private final rx.d f36206a;

    class a extends rx.g<T> {

        /* renamed from: f */
        private long f36207f;

        /* renamed from: g */
        final /* synthetic */ rx.g f36208g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36208g = gVar2;
            this.f36207f = k2.this.f36206a.b();
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36208g.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36208g.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            long b2 = k2.this.f36206a.b();
            this.f36208g.onNext(new rx.n.i(b2 - this.f36207f, t));
            this.f36207f = b2;
        }
    }

    public k2(rx.d dVar) {
        this.f36206a = dVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super rx.n.i<T>> gVar) {
        return new a(gVar, gVar);
    }
}
