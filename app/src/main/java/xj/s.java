package xj;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import qj.a;

/* loaded from: classes5.dex */
public final class s implements a.m0<Integer> {

    /* renamed from: b */
    public final int f32611b;

    /* renamed from: c */
    public final int f32612c;

    public static final class b implements qj.c {

        /* renamed from: f */
        public static final AtomicLongFieldUpdater<b> f32613f = AtomicLongFieldUpdater.newUpdater(b.class, "c");

        /* renamed from: b */
        public final qj.g<? super Integer> f32614b;

        /* renamed from: c */
        public volatile long f32615c;

        /* renamed from: d */
        public long f32616d;

        /* renamed from: e */
        public final int f32617e;

        public /* synthetic */ b(qj.g gVar, int i10, int i11, a aVar) {
            this(gVar, i10, i11);
        }

        @Override // qj.c
        public void request(long j10) {
            long min;
            if (this.f32615c == Long.MAX_VALUE) {
                return;
            }
            if (j10 == Long.MAX_VALUE && f32613f.compareAndSet(this, 0L, Long.MAX_VALUE)) {
                for (long j11 = this.f32616d; j11 <= this.f32617e; j11++) {
                    if (this.f32614b.isUnsubscribed()) {
                        return;
                    }
                    this.f32614b.onNext(Integer.valueOf((int) j11));
                }
                if (this.f32614b.isUnsubscribed()) {
                    return;
                }
                this.f32614b.onCompleted();
                return;
            }
            if (j10 <= 0 || xj.a.b(f32613f, this, j10) != 0) {
                return;
            }
            do {
                long j12 = this.f32615c;
                long j13 = this.f32616d;
                long j14 = (this.f32617e - j13) + 1;
                min = Math.min(j14, j12);
                boolean z10 = j14 <= j12;
                long j15 = min + j13;
                while (j13 < j15) {
                    if (this.f32614b.isUnsubscribed()) {
                        return;
                    }
                    this.f32614b.onNext(Integer.valueOf((int) j13));
                    j13++;
                }
                this.f32616d = j15;
                if (z10) {
                    this.f32614b.onCompleted();
                    return;
                }
            } while (f32613f.addAndGet(this, -min) != 0);
        }

        public b(qj.g<? super Integer> gVar, int i10, int i11) {
            this.f32614b = gVar;
            this.f32616d = i10;
            this.f32617e = i11;
        }
    }

    public s(int i10, int i11) {
        this.f32611b = i10;
        this.f32612c = i11;
    }

    @Override // wj.b
    public void call(qj.g<? super Integer> gVar) {
        gVar.f(new b(gVar, this.f32611b, this.f32612c));
    }
}
