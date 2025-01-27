package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.a;

/* loaded from: classes5.dex */
public class d2<T> implements a.n0<T, T> {

    class a implements rx.c {

        /* renamed from: a */
        final /* synthetic */ c f35979a;

        a(c cVar) {
            this.f35979a = cVar;
        }

        @Override // rx.c
        public void request(long j2) {
            this.f35979a.h(j2);
        }
    }

    private static class b {

        /* renamed from: a */
        static final d2<Object> f35981a = new d2<>(null);

        private b() {
        }
    }

    private static class c<T> extends rx.g<T> {

        /* renamed from: f */
        private static final int f35982f = 0;

        /* renamed from: g */
        private static final int f35983g = 1;

        /* renamed from: h */
        private static final int f35984h = 2;

        /* renamed from: i */
        private static final int f35985i = 3;

        /* renamed from: j */
        private static final Object f35986j = new Object();
        private final rx.g<? super T> k;
        private T l = (T) f35986j;
        private final AtomicInteger m = new AtomicInteger(0);

        c(rx.g<? super T> gVar) {
            this.k = gVar;
        }

        private void g() {
            if (isUnsubscribed()) {
                this.l = null;
                return;
            }
            T t = this.l;
            this.l = null;
            if (t != f35986j) {
                try {
                    this.k.onNext(t);
                } catch (Throwable th) {
                    this.k.onError(th);
                    return;
                }
            }
            if (isUnsubscribed()) {
                return;
            }
            this.k.onCompleted();
        }

        void h(long j2) {
            if (j2 <= 0) {
                return;
            }
            while (true) {
                int i2 = this.m.get();
                if (i2 == 0) {
                    if (this.m.compareAndSet(0, 2)) {
                        return;
                    }
                } else {
                    if (i2 != 1) {
                        return;
                    }
                    if (this.m.compareAndSet(1, 3)) {
                        g();
                        return;
                    }
                }
            }
        }

        @Override // rx.b
        public void onCompleted() {
            if (this.l == f35986j) {
                this.k.onCompleted();
                return;
            }
            while (true) {
                int i2 = this.m.get();
                if (i2 == 0) {
                    if (this.m.compareAndSet(0, 1)) {
                        return;
                    }
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    if (this.m.compareAndSet(2, 3)) {
                        g();
                        return;
                    }
                }
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.k.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            this.l = t;
        }
    }

    /* synthetic */ d2(a aVar) {
        this();
    }

    public static <T> d2<T> a() {
        return (d2<T>) b.f35981a;
    }

    private d2() {
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        c cVar = new c(gVar);
        gVar.f(new a(cVar));
        gVar.b(cVar);
        return cVar;
    }
}
