package rx.internal.operators;

import rx.a;

/* loaded from: classes5.dex */
public final class s1<T> implements a.n0<T, T> {

    /* renamed from: a */
    final int f36426a;

    class a extends rx.g<T> {

        /* renamed from: f */
        int f36427f;

        /* renamed from: g */
        final /* synthetic */ rx.g f36428g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36428g = gVar2;
            this.f36427f = 0;
        }

        @Override // rx.g
        public void f(rx.c cVar) {
            this.f36428g.f(cVar);
            cVar.request(s1.this.f36426a);
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36428g.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36428g.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            int i2 = this.f36427f;
            if (i2 >= s1.this.f36426a) {
                this.f36428g.onNext(t);
            } else {
                this.f36427f = i2 + 1;
            }
        }
    }

    public s1(int i2) {
        this.f36426a = i2;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
