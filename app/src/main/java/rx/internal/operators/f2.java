package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.a;
import rx.d;

/* loaded from: classes5.dex */
public final class f2<T> implements a.n0<T, T> {

    /* renamed from: a */
    final long f36048a;

    /* renamed from: b */
    final TimeUnit f36049b;

    /* renamed from: c */
    final rx.d f36050c;

    static final class a<T> extends rx.g<T> implements rx.k.a {

        /* renamed from: f */
        final rx.g<? super T> f36051f;

        public a(rx.g<? super T> gVar) {
            super(gVar);
            this.f36051f = gVar;
        }

        @Override // rx.k.a
        public void call() {
            onCompleted();
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36051f.onCompleted();
            unsubscribe();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36051f.onError(th);
            unsubscribe();
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f36051f.onNext(t);
        }
    }

    public f2(long j2, TimeUnit timeUnit, rx.d dVar) {
        this.f36048a = j2;
        this.f36049b = timeUnit;
        this.f36050c = dVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        d.a a2 = this.f36050c.a();
        gVar.b(a2);
        a aVar = new a(new rx.l.d(gVar));
        a2.e(aVar, this.f36048a, this.f36049b);
        return aVar;
    }
}
