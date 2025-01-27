package xj;

import qj.a;
import rx.exceptions.OnErrorThrowable;
import rx.internal.producers.SingleDelayedProducer;

/* loaded from: classes5.dex */
public final class a0<T> implements a.n0<Boolean, T> {

    /* renamed from: b */
    public final wj.o<? super T, Boolean> f32010b;

    /* renamed from: c */
    public final boolean f32011c;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public boolean f32012g;

        /* renamed from: h */
        public boolean f32013h;

        /* renamed from: i */
        public final /* synthetic */ SingleDelayedProducer f32014i;

        /* renamed from: j */
        public final /* synthetic */ qj.g f32015j;

        public a(SingleDelayedProducer singleDelayedProducer, qj.g gVar) {
            this.f32014i = singleDelayedProducer;
            this.f32015j = gVar;
        }

        @Override // qj.b
        public void onCompleted() {
            if (this.f32013h) {
                return;
            }
            this.f32013h = true;
            if (this.f32012g) {
                this.f32014i.setValue(Boolean.FALSE);
            } else {
                this.f32014i.setValue(Boolean.valueOf(a0.this.f32011c));
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32015j.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32012g = true;
            try {
                if (!((Boolean) a0.this.f32010b.call(t10)).booleanValue() || this.f32013h) {
                    return;
                }
                this.f32013h = true;
                this.f32014i.setValue(Boolean.valueOf(true ^ a0.this.f32011c));
                unsubscribe();
            } catch (Throwable th2) {
                vj.a.e(th2);
                onError(OnErrorThrowable.addValueAsLastCause(th2, t10));
            }
        }
    }

    public a0(wj.o<? super T, Boolean> oVar, boolean z10) {
        this.f32010b = oVar;
        this.f32011c = z10;
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
