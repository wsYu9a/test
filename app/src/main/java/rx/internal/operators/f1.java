package rx.internal.operators;

import rx.a;
import rx.exceptions.OnErrorThrowable;

/* loaded from: classes5.dex */
public final class f1<T> implements a.n0<T, T> {

    /* renamed from: a */
    private final rx.k.o<OnErrorThrowable, ? extends rx.a<? extends T>> f36044a;

    class a extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.g f36045f;

        /* renamed from: rx.internal.operators.f1$a$a */
        class C0854a extends rx.g<T> {
            C0854a() {
            }

            @Override // rx.b
            public void onCompleted() {
            }

            @Override // rx.b
            public void onError(Throwable th) {
                a.this.f36045f.onError(th);
            }

            @Override // rx.b
            public void onNext(T t) {
                a.this.f36045f.onNext(t);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36045f = gVar2;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36045f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            try {
                rx.m.d.b().a().a(th);
                ((rx.a) f1.this.f36044a.call(OnErrorThrowable.from(th))).T4(new C0854a());
            } catch (Throwable th2) {
                this.f36045f.onError(th2);
            }
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f36045f.onNext(t);
        }
    }

    public f1(rx.k.o<OnErrorThrowable, ? extends rx.a<? extends T>> oVar) {
        this.f36044a = oVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
