package rx.internal.operators;

import rx.a;
import rx.exceptions.OnErrorThrowable;

/* loaded from: classes5.dex */
public final class y0<T, U, R> implements a.n0<rx.a<? extends R>, T> {

    /* renamed from: a */
    final rx.k.o<? super T, ? extends rx.a<? extends U>> f36637a;

    /* renamed from: b */
    final rx.k.p<? super T, ? super U, ? extends R> f36638b;

    static class a implements rx.k.o<T, rx.a<U>> {

        /* renamed from: a */
        final /* synthetic */ rx.k.o f36639a;

        a(rx.k.o oVar) {
            this.f36639a = oVar;
        }

        @Override // rx.k.o
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((a) obj);
        }

        @Override // rx.k.o
        public rx.a<U> call(T t) {
            return rx.a.Y0((Iterable) this.f36639a.call(t));
        }
    }

    class b extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.g f36640f;

        class a implements rx.k.o<U, R> {

            /* renamed from: a */
            final /* synthetic */ Object f36642a;

            a(Object obj) {
                this.f36642a = obj;
            }

            @Override // rx.k.o
            public R call(U u) {
                return y0.this.f36638b.call((Object) this.f36642a, u);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36640f = gVar2;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36640f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36640f.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            try {
                this.f36640f.onNext(y0.this.f36637a.call(t).D1(new a(t)));
            } catch (Throwable th) {
                this.f36640f.onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }
    }

    public y0(rx.k.o<? super T, ? extends rx.a<? extends U>> oVar, rx.k.p<? super T, ? super U, ? extends R> pVar) {
        this.f36637a = oVar;
        this.f36638b = pVar;
    }

    public static <T, U> rx.k.o<T, rx.a<U>> a(rx.k.o<? super T, ? extends Iterable<? extends U>> oVar) {
        return new a(oVar);
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super rx.a<? extends R>> gVar) {
        return new b(gVar, gVar);
    }
}
