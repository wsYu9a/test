package xj;

import qj.a;

/* loaded from: classes5.dex */
public final class q1<T> implements a.n0<T, T> {

    public class a extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ qj.g f32577g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32577g = gVar2;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32577g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32577g.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32577g.onNext(t10);
        }
    }

    public static final class b {

        /* renamed from: a */
        public static final q1<Object> f32579a = new q1<>(null);
    }

    public /* synthetic */ q1(a aVar) {
        this();
    }

    public static <T> q1<T> a() {
        return (q1<T>) b.f32579a;
    }

    public q1() {
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        return new ek.d(new a(gVar, gVar));
    }
}
