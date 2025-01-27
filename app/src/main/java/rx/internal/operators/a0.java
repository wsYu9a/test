package rx.internal.operators;

import rx.a;
import rx.exceptions.OnErrorThrowable;
import rx.internal.producers.SingleDelayedProducer;

/* loaded from: classes5.dex */
public final class a0<T> implements a.n0<Boolean, T> {

    /* renamed from: a */
    private final rx.k.o<? super T, Boolean> f35849a;

    /* renamed from: b */
    private final boolean f35850b;

    class a extends rx.g<T> {

        /* renamed from: f */
        boolean f35851f;

        /* renamed from: g */
        boolean f35852g;

        /* renamed from: h */
        final /* synthetic */ SingleDelayedProducer f35853h;

        /* renamed from: i */
        final /* synthetic */ rx.g f35854i;

        a(SingleDelayedProducer singleDelayedProducer, rx.g gVar) {
            this.f35853h = singleDelayedProducer;
            this.f35854i = gVar;
        }

        @Override // rx.b
        public void onCompleted() {
            if (this.f35852g) {
                return;
            }
            this.f35852g = true;
            if (this.f35851f) {
                this.f35853h.setValue(Boolean.FALSE);
            } else {
                this.f35853h.setValue(Boolean.valueOf(a0.this.f35850b));
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f35854i.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f35851f = true;
            try {
                if (!((Boolean) a0.this.f35849a.call(t)).booleanValue() || this.f35852g) {
                    return;
                }
                this.f35852g = true;
                this.f35853h.setValue(Boolean.valueOf(true ^ a0.this.f35850b));
                unsubscribe();
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }
    }

    public a0(rx.k.o<? super T, Boolean> oVar, boolean z) {
        this.f35849a = oVar;
        this.f35850b = z;
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
