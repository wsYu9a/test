package xj;

import qj.a;
import rx.exceptions.OnErrorThrowable;

/* loaded from: classes5.dex */
public class p0<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final qj.b<? super T> f32538b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public boolean f32539g;

        /* renamed from: h */
        public final /* synthetic */ qj.g f32540h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32540h = gVar2;
            this.f32539g = false;
        }

        @Override // qj.b
        public void onCompleted() {
            if (this.f32539g) {
                return;
            }
            try {
                p0.this.f32538b.onCompleted();
                this.f32539g = true;
                this.f32540h.onCompleted();
            } catch (Throwable th2) {
                onError(th2);
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            vj.a.e(th2);
            if (this.f32539g) {
                return;
            }
            this.f32539g = true;
            try {
                p0.this.f32538b.onError(th2);
                this.f32540h.onError(th2);
            } catch (Throwable th3) {
                this.f32540h.onError(th3);
            }
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (this.f32539g) {
                return;
            }
            try {
                p0.this.f32538b.onNext(t10);
                this.f32540h.onNext(t10);
            } catch (Throwable th2) {
                onError(OnErrorThrowable.addValueAsLastCause(th2, t10));
            }
        }
    }

    public p0(qj.b<? super T> bVar) {
        this.f32538b = bVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
