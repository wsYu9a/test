package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.a;

/* loaded from: classes5.dex */
public final class o<T> implements a.m0<T> {

    /* renamed from: a */
    final Iterable<? extends T> f36291a;

    private static final class b<T> implements rx.c {

        /* renamed from: a */
        private static final AtomicLongFieldUpdater<b> f36292a = AtomicLongFieldUpdater.newUpdater(b.class, "d");

        /* renamed from: b */
        private final rx.g<? super T> f36293b;

        /* renamed from: c */
        private final Iterator<? extends T> f36294c;

        /* renamed from: d */
        private volatile long f36295d;

        /* synthetic */ b(rx.g gVar, Iterator it, a aVar) {
            this(gVar, it);
        }

        @Override // rx.c
        public void request(long j2) {
            long j3;
            if (this.f36295d == Long.MAX_VALUE) {
                return;
            }
            if (j2 == Long.MAX_VALUE && f36292a.compareAndSet(this, 0L, Long.MAX_VALUE)) {
                while (!this.f36293b.isUnsubscribed()) {
                    if (!this.f36294c.hasNext()) {
                        if (this.f36293b.isUnsubscribed()) {
                            return;
                        }
                        this.f36293b.onCompleted();
                        return;
                    }
                    this.f36293b.onNext(this.f36294c.next());
                }
                return;
            }
            if (j2 <= 0 || rx.internal.operators.a.b(f36292a, this, j2) != 0) {
                return;
            }
            do {
                j3 = this.f36295d;
                long j4 = j3;
                while (!this.f36293b.isUnsubscribed()) {
                    if (!this.f36294c.hasNext()) {
                        if (this.f36293b.isUnsubscribed()) {
                            return;
                        }
                        this.f36293b.onCompleted();
                        return;
                    } else {
                        j4--;
                        if (j4 >= 0) {
                            this.f36293b.onNext(this.f36294c.next());
                        }
                    }
                }
                return;
            } while (f36292a.addAndGet(this, -j3) != 0);
        }

        private b(rx.g<? super T> gVar, Iterator<? extends T> it) {
            this.f36295d = 0L;
            this.f36293b = gVar;
            this.f36294c = it;
        }
    }

    public o(Iterable<? extends T> iterable) {
        if (iterable == null) {
            throw new NullPointerException("iterable must not be null");
        }
        this.f36291a = iterable;
    }

    @Override // rx.k.b
    public void call(rx.g<? super T> gVar) {
        Iterator<? extends T> it = this.f36291a.iterator();
        if (it.hasNext() || gVar.isUnsubscribed()) {
            gVar.f(new b(gVar, it));
        } else {
            gVar.onCompleted();
        }
    }
}
