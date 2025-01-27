package rx.internal.operators;

import rx.a;
import rx.exceptions.OnErrorThrowable;

/* loaded from: classes5.dex */
public final class x0<T, R> implements a.n0<R, T> {

    /* renamed from: a */
    private final rx.k.o<? super T, ? extends R> f36610a;

    class a extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.g f36611f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36611f = gVar2;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36611f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36611f.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.b
        public void onNext(T t) {
            try {
                this.f36611f.onNext(x0.this.f36610a.call(t));
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }
    }

    public x0(rx.k.o<? super T, ? extends R> oVar) {
        this.f36610a = oVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super R> gVar) {
        return new a(gVar, gVar);
    }
}
