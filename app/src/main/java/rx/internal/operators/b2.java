package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.a;

/* loaded from: classes5.dex */
public final class b2<T> implements a.n0<T, T> {

    /* renamed from: a */
    final int f35903a;

    class a extends rx.g<T> {

        /* renamed from: f */
        int f35904f = 0;

        /* renamed from: g */
        boolean f35905g = false;

        /* renamed from: h */
        final /* synthetic */ rx.g f35906h;

        /* renamed from: rx.internal.operators.b2$a$a */
        class C0850a implements rx.c {

            /* renamed from: a */
            final AtomicLong f35908a = new AtomicLong(0);

            /* renamed from: b */
            final /* synthetic */ rx.c f35909b;

            C0850a(rx.c cVar) {
                this.f35909b = cVar;
            }

            @Override // rx.c
            public void request(long j2) {
                long j3;
                long min;
                if (j2 <= 0 || a.this.f35905g) {
                    return;
                }
                do {
                    j3 = this.f35908a.get();
                    min = Math.min(j2, b2.this.f35903a - j3);
                    if (min == 0) {
                        return;
                    }
                } while (!this.f35908a.compareAndSet(j3, j3 + min));
                this.f35909b.request(min);
            }
        }

        a(rx.g gVar) {
            this.f35906h = gVar;
        }

        @Override // rx.g
        public void f(rx.c cVar) {
            this.f35906h.f(new C0850a(cVar));
        }

        @Override // rx.b
        public void onCompleted() {
            if (this.f35905g) {
                return;
            }
            this.f35906h.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            if (this.f35905g) {
                return;
            }
            this.f35906h.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            if (isUnsubscribed()) {
                return;
            }
            int i2 = this.f35904f + 1;
            this.f35904f = i2;
            if (i2 >= b2.this.f35903a) {
                this.f35905g = true;
            }
            this.f35906h.onNext(t);
            if (this.f35905g) {
                this.f35906h.onCompleted();
                unsubscribe();
            }
        }
    }

    public b2(int i2) {
        this.f35903a = i2;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        a aVar = new a(gVar);
        if (this.f35903a == 0) {
            gVar.onCompleted();
            aVar.unsubscribe();
        }
        gVar.b(aVar);
        return aVar;
    }
}
