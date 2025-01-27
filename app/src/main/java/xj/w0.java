package xj;

import qj.a;

/* loaded from: classes5.dex */
public class w0<T> implements a.n0<T, T> {

    public static class b {

        /* renamed from: a */
        public static final w0<?> f32787a = new w0<>(null);
    }

    public /* synthetic */ w0(a aVar) {
        this();
    }

    public static <T> w0<T> a() {
        return (w0<T>) b.f32787a;
    }

    public w0() {
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        a aVar = new a(gVar);
        gVar.b(aVar);
        return aVar;
    }

    public class a extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ qj.g f32785g;

        public a(qj.g gVar) {
            this.f32785g = gVar;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32785g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32785g.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
        }
    }
}
