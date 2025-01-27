package xj;

import qj.a;

/* loaded from: classes5.dex */
public final class o2<T> implements a.n0<gk.j<T>, T> {

    /* renamed from: b */
    public final qj.d f32506b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ qj.g f32507g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32507g = gVar2;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32507g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32507g.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32507g.onNext(new gk.j(o2.this.f32506b.b(), t10));
        }
    }

    public o2(qj.d dVar) {
        this.f32506b = dVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super gk.j<T>> gVar) {
        return new a(gVar, gVar);
    }
}
