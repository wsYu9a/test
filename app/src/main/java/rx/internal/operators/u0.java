package rx.internal.operators;

import rx.a;

/* loaded from: classes5.dex */
public final class u0<T> implements a.n0<T, T> {

    /* renamed from: a */
    final rx.k.a f36504a;

    class a extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.g f36505f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36505f = gVar2;
        }

        @Override // rx.b
        public void onCompleted() {
            try {
                this.f36505f.onCompleted();
            } finally {
                u0.this.f36504a.call();
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            try {
                this.f36505f.onError(th);
            } finally {
                u0.this.f36504a.call();
            }
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f36505f.onNext(t);
        }
    }

    public u0(rx.k.a aVar) {
        this.f36504a = aVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
