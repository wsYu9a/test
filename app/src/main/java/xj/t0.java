package xj;

import qj.a;
import rx.exceptions.OnErrorThrowable;

/* loaded from: classes5.dex */
public final class t0<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final wj.o<? super T, Boolean> f32670b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ qj.g f32671g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32671g = gVar2;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32671g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32671g.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            try {
                if (((Boolean) t0.this.f32670b.call(t10)).booleanValue()) {
                    this.f32671g.onNext(t10);
                } else {
                    e(1L);
                }
            } catch (Throwable th2) {
                this.f32671g.onError(OnErrorThrowable.addValueAsLastCause(th2, t10));
            }
        }
    }

    public t0(wj.o<? super T, Boolean> oVar) {
        this.f32670b = oVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
