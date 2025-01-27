package rx.internal.operators;

import rx.a;
import rx.exceptions.OnErrorThrowable;

/* loaded from: classes5.dex */
public class g0<T, R> implements a.n0<R, T> {

    /* renamed from: a */
    private final Class<R> f36063a;

    class a extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.g f36064f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36064f = gVar2;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36064f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36064f.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.b
        public void onNext(T t) {
            try {
                this.f36064f.onNext(g0.this.f36063a.cast(t));
            } catch (Throwable th) {
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }
    }

    public g0(Class<R> cls) {
        this.f36063a = cls;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super R> gVar) {
        return new a(gVar, gVar);
    }
}
