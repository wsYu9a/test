package rx.internal.operators;

import rx.a;
import rx.internal.util.UtilityFunctions;

/* loaded from: classes5.dex */
public final class o0<T, U> implements a.n0<T, T> {

    /* renamed from: a */
    final rx.k.o<? super T, ? extends U> f36296a;

    class a extends rx.g<T> {

        /* renamed from: f */
        U f36297f;

        /* renamed from: g */
        boolean f36298g;

        /* renamed from: h */
        final /* synthetic */ rx.g f36299h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36299h = gVar2;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36299h.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36299h.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            U u = this.f36297f;
            U call = o0.this.f36296a.call(t);
            this.f36297f = call;
            if (!this.f36298g) {
                this.f36298g = true;
                this.f36299h.onNext(t);
            } else if (u == call || (call != null && call.equals(u))) {
                e(1L);
            } else {
                this.f36299h.onNext(t);
            }
        }
    }

    private static class b {

        /* renamed from: a */
        static final o0<?, ?> f36301a = new o0<>(UtilityFunctions.c());

        private b() {
        }
    }

    public o0(rx.k.o<? super T, ? extends U> oVar) {
        this.f36296a = oVar;
    }

    public static <T> o0<T, T> a() {
        return (o0<T, T>) b.f36301a;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
