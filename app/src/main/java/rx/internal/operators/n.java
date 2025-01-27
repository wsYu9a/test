package rx.internal.operators;

import rx.a;

/* loaded from: classes5.dex */
public final class n<T, U> implements a.m0<T> {

    /* renamed from: a */
    final rx.a<? extends T> f36267a;

    /* renamed from: b */
    final rx.k.n<? extends rx.a<U>> f36268b;

    class a extends rx.g<U> {

        /* renamed from: f */
        final /* synthetic */ rx.g f36269f;

        a(rx.g gVar) {
            this.f36269f = gVar;
        }

        @Override // rx.b
        public void onCompleted() {
            n.this.f36267a.T4(rx.l.e.f(this.f36269f));
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36269f.onError(th);
        }

        @Override // rx.b
        public void onNext(U u) {
        }
    }

    public n(rx.a<? extends T> aVar, rx.k.n<? extends rx.a<U>> nVar) {
        this.f36267a = aVar;
        this.f36268b = nVar;
    }

    @Override // rx.k.b
    public void call(rx.g<? super T> gVar) {
        try {
            this.f36268b.call().S3(1).T4(new a(gVar));
        } catch (Throwable th) {
            gVar.onError(th);
        }
    }
}
