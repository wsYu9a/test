package xj;

import qj.a;

/* loaded from: classes5.dex */
public final class k1 {

    public static class a<T> implements a.m0<T> {

        /* renamed from: b */
        public final /* synthetic */ qj.a f32388b;

        public a(qj.a aVar) {
            this.f32388b = aVar;
        }

        @Override // wj.b
        public void call(qj.g<? super T> gVar) {
            k1.b(this.f32388b).call(gVar);
        }
    }

    public static class b<T> implements a.m0<T> {

        /* renamed from: b */
        public final /* synthetic */ qj.a f32389b;

        public b(qj.a aVar) {
            this.f32389b = aVar;
        }

        @Override // wj.b
        public void call(qj.g<? super T> gVar) {
            this.f32389b.T4(gVar);
        }
    }

    public static final class c<T> extends hk.f<T, T> {

        /* renamed from: e */
        public final hk.f<T, T> f32390e;

        public c(a.m0<T> m0Var, hk.f<T, T> fVar) {
            super(m0Var);
            this.f32390e = fVar;
        }

        @Override // hk.f
        public boolean B5() {
            return this.f32390e.B5();
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32390e.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32390e.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32390e.onNext(t10);
        }
    }

    public k1() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> hk.f<T, T> a(hk.f<T, T> fVar, qj.d dVar) {
        return new c(new a(fVar.h2(dVar)), fVar);
    }

    public static <T> a.m0<T> b(qj.a<T> aVar) {
        return new b(aVar);
    }
}
