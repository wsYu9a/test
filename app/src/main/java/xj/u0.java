package xj;

import qj.a;

/* loaded from: classes5.dex */
public final class u0<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final wj.a f32697b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ qj.g f32698g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32698g = gVar2;
        }

        @Override // qj.b
        public void onCompleted() {
            try {
                this.f32698g.onCompleted();
            } finally {
                u0.this.f32697b.call();
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            try {
                this.f32698g.onError(th2);
            } finally {
                u0.this.f32697b.call();
            }
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32698g.onNext(t10);
        }
    }

    public u0(wj.a aVar) {
        this.f32697b = aVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
