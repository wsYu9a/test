package xj;

import qj.a;
import rx.exceptions.OnErrorThrowable;

/* loaded from: classes5.dex */
public class g0<T, R> implements a.n0<R, T> {

    /* renamed from: b */
    public final Class<R> f32238b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ qj.g f32239g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32239g = gVar2;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32239g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32239g.onError(th2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // qj.b
        public void onNext(T t10) {
            try {
                this.f32239g.onNext(g0.this.f32238b.cast(t10));
            } catch (Throwable th2) {
                onError(OnErrorThrowable.addValueAsLastCause(th2, t10));
            }
        }
    }

    public g0(Class<R> cls) {
        this.f32238b = cls;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super R> gVar) {
        return new a(gVar, gVar);
    }
}
