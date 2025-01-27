package rx.internal.operators;

import rx.a;

/* loaded from: classes5.dex */
public final class q1<T> implements a.n0<T, T> {

    class a extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.g f36385f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36385f = gVar2;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36385f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36385f.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f36385f.onNext(t);
        }
    }

    private static final class b {

        /* renamed from: a */
        static final q1<Object> f36387a = new q1<>(null);

        private b() {
        }
    }

    /* synthetic */ q1(a aVar) {
        this();
    }

    public static <T> q1<T> a() {
        return (q1<T>) b.f36387a;
    }

    private q1() {
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        return new rx.l.d(new a(gVar, gVar));
    }
}
