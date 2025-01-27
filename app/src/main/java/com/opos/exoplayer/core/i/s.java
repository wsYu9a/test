package com.opos.exoplayer.core.i;

import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
public final class s {

    /* renamed from: a */
    private long f19075a;

    /* renamed from: b */
    private long f19076b;

    /* renamed from: c */
    private volatile long f19077c = C.TIME_UNSET;

    public s(long j2) {
        a(j2);
    }

    public static long d(long j2) {
        return (j2 * C.MICROS_PER_SECOND) / 90000;
    }

    public static long e(long j2) {
        return (j2 * 90000) / C.MICROS_PER_SECOND;
    }

    public long a() {
        return this.f19075a;
    }

    public void a(long j2) {
        synchronized (this) {
            a.b(this.f19077c == C.TIME_UNSET);
            this.f19075a = j2;
        }
    }

    public long b() {
        if (this.f19077c != C.TIME_UNSET) {
            return this.f19077c;
        }
        long j2 = this.f19075a;
        return j2 != Long.MAX_VALUE ? j2 : C.TIME_UNSET;
    }

    public long b(long j2) {
        if (j2 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (this.f19077c != C.TIME_UNSET) {
            long e2 = e(this.f19077c);
            long j3 = (4294967296L + e2) / 8589934592L;
            long j4 = ((j3 - 1) * 8589934592L) + j2;
            j2 += j3 * 8589934592L;
            if (Math.abs(j4 - e2) < Math.abs(j2 - e2)) {
                j2 = j4;
            }
        }
        return c(d(j2));
    }

    public long c() {
        if (this.f19075a == Long.MAX_VALUE) {
            return 0L;
        }
        return this.f19077c != C.TIME_UNSET ? this.f19076b : C.TIME_UNSET;
    }

    public long c(long j2) {
        if (j2 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (this.f19077c != C.TIME_UNSET) {
            this.f19077c = j2;
        } else {
            long j3 = this.f19075a;
            if (j3 != Long.MAX_VALUE) {
                this.f19076b = j3 - j2;
            }
            synchronized (this) {
                this.f19077c = j2;
                notifyAll();
            }
        }
        return this.f19076b + j2;
    }

    public void d() {
        this.f19077c = C.TIME_UNSET;
    }
}
