package xj;

import qj.a;

/* loaded from: classes5.dex */
public final class s1<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final int f32619b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public int f32620g;

        /* renamed from: h */
        public final /* synthetic */ qj.g f32621h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32621h = gVar2;
            this.f32620g = 0;
        }

        @Override // qj.g
        public void f(qj.c cVar) {
            this.f32621h.f(cVar);
            cVar.request(s1.this.f32619b);
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32621h.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32621h.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            int i10 = this.f32620g;
            if (i10 >= s1.this.f32619b) {
                this.f32621h.onNext(t10);
            } else {
                this.f32620g = i10 + 1;
            }
        }
    }

    public s1(int i10) {
        this.f32619b = i10;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
