package rx.internal.operators;

import rx.a;
import rx.exceptions.OnErrorThrowable;

/* loaded from: classes5.dex */
public final class t0<T> implements a.n0<T, T> {

    /* renamed from: a */
    private final rx.k.o<? super T, Boolean> f36477a;

    class a extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.g f36478f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36478f = gVar2;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36478f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36478f.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            try {
                if (((Boolean) t0.this.f36477a.call(t)).booleanValue()) {
                    this.f36478f.onNext(t);
                } else {
                    e(1L);
                }
            } catch (Throwable th) {
                this.f36478f.onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }
    }

    public t0(rx.k.o<? super T, Boolean> oVar) {
        this.f36477a = oVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
