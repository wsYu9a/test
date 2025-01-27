package rx.internal.operators;

import rx.a;

/* loaded from: classes5.dex */
public final class k1 {

    static class a<T> implements a.m0<T> {

        /* renamed from: a */
        final /* synthetic */ rx.a f36203a;

        a(rx.a aVar) {
            this.f36203a = aVar;
        }

        @Override // rx.k.b
        public void call(rx.g<? super T> gVar) {
            k1.b(this.f36203a).call(gVar);
        }
    }

    static class b<T> implements a.m0<T> {

        /* renamed from: a */
        final /* synthetic */ rx.a f36204a;

        b(rx.a aVar) {
            this.f36204a = aVar;
        }

        @Override // rx.k.b
        public void call(rx.g<? super T> gVar) {
            this.f36204a.T4(gVar);
        }
    }

    public static final class c<T> extends rx.o.f<T, T> {

        /* renamed from: d */
        final rx.o.f<T, T> f36205d;

        public c(a.m0<T> m0Var, rx.o.f<T, T> fVar) {
            super(m0Var);
            this.f36205d = fVar;
        }

        @Override // rx.o.f
        public boolean B5() {
            return this.f36205d.B5();
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36205d.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36205d.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f36205d.onNext(t);
        }
    }

    private k1() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> rx.o.f<T, T> a(rx.o.f<T, T> fVar, rx.d dVar) {
        return new c(new a(fVar.h2(dVar)), fVar);
    }

    public static <T> a.m0<T> b(rx.a<T> aVar) {
        return new b(aVar);
    }
}
