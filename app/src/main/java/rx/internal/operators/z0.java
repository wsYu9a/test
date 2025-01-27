package rx.internal.operators;

import rx.Notification;
import rx.a;

/* loaded from: classes5.dex */
public final class z0<T> implements a.n0<Notification<T>, T> {

    class a extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.g f36691f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36691f = gVar2;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36691f.onNext(Notification.b());
            this.f36691f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            rx.m.d.b().a().a(th);
            this.f36691f.onNext(Notification.d(th));
            this.f36691f.onCompleted();
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f36691f.onNext(Notification.e(t));
        }
    }

    private static final class b {

        /* renamed from: a */
        static final z0<Object> f36693a = new z0<>(null);

        private b() {
        }
    }

    /* synthetic */ z0(a aVar) {
        this();
    }

    public static <T> z0<T> a() {
        return (z0<T>) b.f36693a;
    }

    private z0() {
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super Notification<T>> gVar) {
        return new a(gVar, gVar);
    }
}
