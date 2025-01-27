package rx.internal.operators;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.a;

/* loaded from: classes5.dex */
public final class y {

    static class a<T> implements a.m0<T> {

        /* renamed from: a */
        private final Future<? extends T> f36633a;

        /* renamed from: b */
        private final long f36634b;

        /* renamed from: c */
        private final TimeUnit f36635c;

        /* renamed from: rx.internal.operators.y$a$a */
        class C0875a implements rx.k.a {
            C0875a() {
            }

            @Override // rx.k.a
            public void call() {
                a.this.f36633a.cancel(true);
            }
        }

        public a(Future<? extends T> future) {
            this.f36633a = future;
            this.f36634b = 0L;
            this.f36635c = null;
        }

        @Override // rx.k.b
        public void call(rx.g<? super T> gVar) {
            gVar.b(rx.p.f.a(new C0875a()));
            try {
                if (gVar.isUnsubscribed()) {
                    return;
                }
                TimeUnit timeUnit = this.f36635c;
                gVar.onNext(timeUnit == null ? this.f36633a.get() : this.f36633a.get(this.f36634b, timeUnit));
                gVar.onCompleted();
            } catch (Throwable th) {
                if (gVar.isUnsubscribed()) {
                    return;
                }
                gVar.onError(th);
            }
        }

        public a(Future<? extends T> future, long j2, TimeUnit timeUnit) {
            this.f36633a = future;
            this.f36634b = j2;
            this.f36635c = timeUnit;
        }
    }

    private y() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> a.m0<T> a(Future<? extends T> future) {
        return new a(future);
    }

    public static <T> a.m0<T> b(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        return new a(future, j2, timeUnit);
    }
}
