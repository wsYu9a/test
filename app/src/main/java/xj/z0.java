package xj;

import qj.a;
import rx.Notification;

/* loaded from: classes5.dex */
public final class z0<T> implements a.n0<Notification<T>, T> {

    public class a extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ qj.g f32907g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32907g = gVar2;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32907g.onNext(Notification.b());
            this.f32907g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            fk.d.b().a().a(th2);
            this.f32907g.onNext(Notification.d(th2));
            this.f32907g.onCompleted();
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32907g.onNext(Notification.e(t10));
        }
    }

    public static final class b {

        /* renamed from: a */
        public static final z0<Object> f32909a = new z0<>(null);
    }

    public /* synthetic */ z0(a aVar) {
        this();
    }

    public static <T> z0<T> a() {
        return (z0<T>) b.f32909a;
    }

    public z0() {
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super Notification<T>> gVar) {
        return new a(gVar, gVar);
    }
}
