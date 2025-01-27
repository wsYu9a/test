package xj;

import qj.a;
import rx.exceptions.OnErrorThrowable;

/* loaded from: classes5.dex */
public final class x0<T, R> implements a.n0<R, T> {

    /* renamed from: b */
    public final wj.o<? super T, ? extends R> f32822b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ qj.g f32823g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32823g = gVar2;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32823g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32823g.onError(th2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // qj.b
        public void onNext(T t10) {
            try {
                this.f32823g.onNext(x0.this.f32822b.call(t10));
            } catch (Throwable th2) {
                vj.a.e(th2);
                onError(OnErrorThrowable.addValueAsLastCause(th2, t10));
            }
        }
    }

    public x0(wj.o<? super T, ? extends R> oVar) {
        this.f32822b = oVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super R> gVar) {
        return new a(gVar, gVar);
    }
}
