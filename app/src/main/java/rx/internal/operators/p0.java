package rx.internal.operators;

import rx.a;
import rx.exceptions.OnErrorThrowable;

/* loaded from: classes5.dex */
public class p0<T> implements a.n0<T, T> {

    /* renamed from: a */
    private final rx.b<? super T> f36346a;

    class a extends rx.g<T> {

        /* renamed from: f */
        private boolean f36347f;

        /* renamed from: g */
        final /* synthetic */ rx.g f36348g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36348g = gVar2;
            this.f36347f = false;
        }

        @Override // rx.b
        public void onCompleted() {
            if (this.f36347f) {
                return;
            }
            try {
                p0.this.f36346a.onCompleted();
                this.f36347f = true;
                this.f36348g.onCompleted();
            } catch (Throwable th) {
                onError(th);
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            rx.exceptions.a.e(th);
            if (this.f36347f) {
                return;
            }
            this.f36347f = true;
            try {
                p0.this.f36346a.onError(th);
                this.f36348g.onError(th);
            } catch (Throwable th2) {
                this.f36348g.onError(th2);
            }
        }

        @Override // rx.b
        public void onNext(T t) {
            if (this.f36347f) {
                return;
            }
            try {
                p0.this.f36346a.onNext(t);
                this.f36348g.onNext(t);
            } catch (Throwable th) {
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }
    }

    public p0(rx.b<? super T> bVar) {
        this.f36346a = bVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
