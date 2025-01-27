package rx.internal.operators;

import rx.a;
import rx.exceptions.OnErrorThrowable;
import rx.internal.producers.SingleDelayedProducer;

/* loaded from: classes5.dex */
public final class z<T> implements a.n0<Boolean, T> {

    /* renamed from: a */
    private final rx.k.o<? super T, Boolean> f36686a;

    class a extends rx.g<T> {

        /* renamed from: f */
        boolean f36687f;

        /* renamed from: g */
        final /* synthetic */ SingleDelayedProducer f36688g;

        /* renamed from: h */
        final /* synthetic */ rx.g f36689h;

        a(SingleDelayedProducer singleDelayedProducer, rx.g gVar) {
            this.f36688g = singleDelayedProducer;
            this.f36689h = gVar;
        }

        @Override // rx.b
        public void onCompleted() {
            if (this.f36687f) {
                return;
            }
            this.f36687f = true;
            this.f36688g.setValue(Boolean.TRUE);
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36689h.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            try {
                if (((Boolean) z.this.f36686a.call(t)).booleanValue() || this.f36687f) {
                    return;
                }
                this.f36687f = true;
                this.f36688g.setValue(Boolean.FALSE);
                unsubscribe();
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }
    }

    public z(rx.k.o<? super T, Boolean> oVar) {
        this.f36686a = oVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super Boolean> gVar) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(gVar);
        a aVar = new a(singleDelayedProducer, gVar);
        gVar.b(aVar);
        gVar.f(singleDelayedProducer);
        return aVar;
    }
}
