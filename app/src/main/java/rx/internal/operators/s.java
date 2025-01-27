package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.a;

/* loaded from: classes5.dex */
public final class s implements a.m0<Integer> {

    /* renamed from: a */
    private final int f36418a;

    /* renamed from: b */
    private final int f36419b;

    private static final class b implements rx.c {

        /* renamed from: a */
        private static final AtomicLongFieldUpdater<b> f36420a = AtomicLongFieldUpdater.newUpdater(b.class, "c");

        /* renamed from: b */
        private final rx.g<? super Integer> f36421b;

        /* renamed from: c */
        private volatile long f36422c;

        /* renamed from: d */
        private long f36423d;

        /* renamed from: e */
        private final int f36424e;

        /* synthetic */ b(rx.g gVar, int i2, int i3, a aVar) {
            this(gVar, i2, i3);
        }

        @Override // rx.c
        public void request(long j2) {
            long min;
            if (this.f36422c == Long.MAX_VALUE) {
                return;
            }
            if (j2 == Long.MAX_VALUE && f36420a.compareAndSet(this, 0L, Long.MAX_VALUE)) {
                for (long j3 = this.f36423d; j3 <= this.f36424e; j3++) {
                    if (this.f36421b.isUnsubscribed()) {
                        return;
                    }
                    this.f36421b.onNext(Integer.valueOf((int) j3));
                }
                if (this.f36421b.isUnsubscribed()) {
                    return;
                }
                this.f36421b.onCompleted();
                return;
            }
            if (j2 <= 0 || rx.internal.operators.a.b(f36420a, this, j2) != 0) {
                return;
            }
            do {
                long j4 = this.f36422c;
                long j5 = this.f36423d;
                long j6 = (this.f36424e - j5) + 1;
                min = Math.min(j6, j4);
                boolean z = j6 <= j4;
                long j7 = min + j5;
                while (j5 < j7) {
                    if (this.f36421b.isUnsubscribed()) {
                        return;
                    }
                    this.f36421b.onNext(Integer.valueOf((int) j5));
                    j5++;
                }
                this.f36423d = j7;
                if (z) {
                    this.f36421b.onCompleted();
                    return;
                }
            } while (f36420a.addAndGet(this, -min) != 0);
        }

        private b(rx.g<? super Integer> gVar, int i2, int i3) {
            this.f36421b = gVar;
            this.f36423d = i2;
            this.f36424e = i3;
        }
    }

    public s(int i2, int i3) {
        this.f36418a = i2;
        this.f36419b = i3;
    }

    @Override // rx.k.b
    public void call(rx.g<? super Integer> gVar) {
        gVar.f(new b(gVar, this.f36418a, this.f36419b));
    }
}
