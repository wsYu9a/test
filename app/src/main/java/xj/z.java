package xj;

import qj.a;
import rx.exceptions.OnErrorThrowable;
import rx.internal.producers.SingleDelayedProducer;

/* loaded from: classes5.dex */
public final class z<T> implements a.n0<Boolean, T> {

    /* renamed from: b */
    public final wj.o<? super T, Boolean> f32902b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public boolean f32903g;

        /* renamed from: h */
        public final /* synthetic */ SingleDelayedProducer f32904h;

        /* renamed from: i */
        public final /* synthetic */ qj.g f32905i;

        public a(SingleDelayedProducer singleDelayedProducer, qj.g gVar) {
            this.f32904h = singleDelayedProducer;
            this.f32905i = gVar;
        }

        @Override // qj.b
        public void onCompleted() {
            if (this.f32903g) {
                return;
            }
            this.f32903g = true;
            this.f32904h.setValue(Boolean.TRUE);
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32905i.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            try {
                if (((Boolean) z.this.f32902b.call(t10)).booleanValue() || this.f32903g) {
                    return;
                }
                this.f32903g = true;
                this.f32904h.setValue(Boolean.FALSE);
                unsubscribe();
            } catch (Throwable th2) {
                vj.a.e(th2);
                onError(OnErrorThrowable.addValueAsLastCause(th2, t10));
            }
        }
    }

    public z(wj.o<? super T, Boolean> oVar) {
        this.f32902b = oVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super Boolean> gVar) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(gVar);
        a aVar = new a(singleDelayedProducer, gVar);
        gVar.b(aVar);
        gVar.f(singleDelayedProducer);
        return aVar;
    }
}
