package xj;

import qj.a;

/* loaded from: classes5.dex */
public final class k2<T> implements a.n0<gk.i<T>, T> {

    /* renamed from: b */
    public final qj.d f32391b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public long f32392g;

        /* renamed from: h */
        public final /* synthetic */ qj.g f32393h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32393h = gVar2;
            this.f32392g = k2.this.f32391b.b();
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32393h.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32393h.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            long b10 = k2.this.f32391b.b();
            this.f32393h.onNext(new gk.i(b10 - this.f32392g, t10));
            this.f32392g = b10;
        }
    }

    public k2(qj.d dVar) {
        this.f32391b = dVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super gk.i<T>> gVar) {
        return new a(gVar, gVar);
    }
}
