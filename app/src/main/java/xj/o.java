package xj;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import qj.a;

/* loaded from: classes5.dex */
public final class o<T> implements a.m0<T> {

    /* renamed from: b */
    public final Iterable<? extends T> f32482b;

    public static final class b<T> implements qj.c {

        /* renamed from: e */
        public static final AtomicLongFieldUpdater<b> f32483e = AtomicLongFieldUpdater.newUpdater(b.class, "d");

        /* renamed from: b */
        public final qj.g<? super T> f32484b;

        /* renamed from: c */
        public final Iterator<? extends T> f32485c;

        /* renamed from: d */
        public volatile long f32486d;

        public /* synthetic */ b(qj.g gVar, Iterator it, a aVar) {
            this(gVar, it);
        }

        @Override // qj.c
        public void request(long j10) {
            long j11;
            if (this.f32486d == Long.MAX_VALUE) {
                return;
            }
            if (j10 == Long.MAX_VALUE && f32483e.compareAndSet(this, 0L, Long.MAX_VALUE)) {
                while (!this.f32484b.isUnsubscribed()) {
                    if (!this.f32485c.hasNext()) {
                        if (this.f32484b.isUnsubscribed()) {
                            return;
                        }
                        this.f32484b.onCompleted();
                        return;
                    }
                    this.f32484b.onNext(this.f32485c.next());
                }
                return;
            }
            if (j10 <= 0 || xj.a.b(f32483e, this, j10) != 0) {
                return;
            }
            do {
                j11 = this.f32486d;
                long j12 = j11;
                while (!this.f32484b.isUnsubscribed()) {
                    if (!this.f32485c.hasNext()) {
                        if (this.f32484b.isUnsubscribed()) {
                            return;
                        }
                        this.f32484b.onCompleted();
                        return;
                    } else {
                        j12--;
                        if (j12 >= 0) {
                            this.f32484b.onNext(this.f32485c.next());
                        }
                    }
                }
                return;
            } while (f32483e.addAndGet(this, -j11) != 0);
        }

        public b(qj.g<? super T> gVar, Iterator<? extends T> it) {
            this.f32486d = 0L;
            this.f32484b = gVar;
            this.f32485c = it;
        }
    }

    public o(Iterable<? extends T> iterable) {
        if (iterable == null) {
            throw new NullPointerException("iterable must not be null");
        }
        this.f32482b = iterable;
    }

    @Override // wj.b
    public void call(qj.g<? super T> gVar) {
        Iterator<? extends T> it = this.f32482b.iterator();
        if (it.hasNext() || gVar.isUnsubscribed()) {
            gVar.f(new b(gVar, it));
        } else {
            gVar.onCompleted();
        }
    }
}
