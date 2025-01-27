package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.a;
import rx.d;

/* loaded from: classes5.dex */
public final class n1<T> implements a.n0<T, T> {

    /* renamed from: a */
    final long f36276a;

    /* renamed from: b */
    final TimeUnit f36277b;

    /* renamed from: c */
    final rx.d f36278c;

    static final class a<T> extends rx.g<T> implements rx.k.a {

        /* renamed from: f */
        private static final Object f36279f = new Object();

        /* renamed from: g */
        static final AtomicReferenceFieldUpdater<a, Object> f36280g = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "i");

        /* renamed from: h */
        private final rx.g<? super T> f36281h;

        /* renamed from: i */
        volatile Object f36282i = f36279f;

        public a(rx.g<? super T> gVar) {
            this.f36281h = gVar;
        }

        @Override // rx.k.a
        public void call() {
            AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater = f36280g;
            Object obj = f36279f;
            Object andSet = atomicReferenceFieldUpdater.getAndSet(this, obj);
            if (andSet != obj) {
                try {
                    this.f36281h.onNext(andSet);
                } catch (Throwable th) {
                    onError(th);
                }
            }
        }

        @Override // rx.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36281h.onCompleted();
            unsubscribe();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36281h.onError(th);
            unsubscribe();
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f36282i = t;
        }
    }

    public n1(long j2, TimeUnit timeUnit, rx.d dVar) {
        this.f36276a = j2;
        this.f36277b = timeUnit;
        this.f36278c = dVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        rx.l.d dVar = new rx.l.d(gVar);
        d.a a2 = this.f36278c.a();
        gVar.b(a2);
        a aVar = new a(dVar);
        gVar.b(aVar);
        long j2 = this.f36276a;
        a2.f(aVar, j2, j2, this.f36277b);
        return aVar;
    }
}
