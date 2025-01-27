package xj;

import qj.a;
import rx.exceptions.OnErrorThrowable;

/* loaded from: classes5.dex */
public final class y0<T, U, R> implements a.n0<qj.a<? extends R>, T> {

    /* renamed from: b */
    public final wj.o<? super T, ? extends qj.a<? extends U>> f32850b;

    /* renamed from: c */
    public final wj.p<? super T, ? super U, ? extends R> f32851c;

    public static class a implements wj.o<T, qj.a<U>> {

        /* renamed from: b */
        public final /* synthetic */ wj.o f32852b;

        public a(wj.o oVar) {
            this.f32852b = oVar;
        }

        @Override // wj.o
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((a) obj);
        }

        @Override // wj.o
        public qj.a<U> call(T t10) {
            return qj.a.Y0((Iterable) this.f32852b.call(t10));
        }
    }

    public class b extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ qj.g f32853g;

        public class a implements wj.o<U, R> {

            /* renamed from: b */
            public final /* synthetic */ Object f32855b;

            public a(Object obj) {
                this.f32855b = obj;
            }

            @Override // wj.o
            public R call(U u10) {
                return y0.this.f32851c.call((Object) this.f32855b, u10);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32853g = gVar2;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32853g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32853g.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            try {
                this.f32853g.onNext(y0.this.f32850b.call(t10).D1(new a(t10)));
            } catch (Throwable th2) {
                this.f32853g.onError(OnErrorThrowable.addValueAsLastCause(th2, t10));
            }
        }
    }

    public y0(wj.o<? super T, ? extends qj.a<? extends U>> oVar, wj.p<? super T, ? super U, ? extends R> pVar) {
        this.f32850b = oVar;
        this.f32851c = pVar;
    }

    public static <T, U> wj.o<T, qj.a<U>> a(wj.o<? super T, ? extends Iterable<? extends U>> oVar) {
        return new a(oVar);
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super qj.a<? extends R>> gVar) {
        return new b(gVar, gVar);
    }
}
