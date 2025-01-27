package rx.internal.operators;

import rx.a;

/* loaded from: classes5.dex */
public class w0<T> implements a.n0<T, T> {

    class a extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.g f36573f;

        a(rx.g gVar) {
            this.f36573f = gVar;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36573f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36573f.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
        }
    }

    private static class b {

        /* renamed from: a */
        static final w0<?> f36575a = new w0<>(null);

        private b() {
        }
    }

    /* synthetic */ w0(a aVar) {
        this();
    }

    public static <T> w0<T> a() {
        return (w0<T>) b.f36575a;
    }

    private w0() {
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        a aVar = new a(gVar);
        gVar.b(aVar);
        return aVar;
    }
}
