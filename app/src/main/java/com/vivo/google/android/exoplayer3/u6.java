package com.vivo.google.android.exoplayer3;

/* loaded from: classes4.dex */
public final class u6 {

    /* renamed from: a */
    public long f28139a;

    /* renamed from: b */
    public long f28140b;

    /* renamed from: c */
    public volatile long f28141c = C.TIME_UNSET;

    public u6(long j2) {
        c(j2);
    }

    public long a() {
        if (this.f28139a == Long.MAX_VALUE) {
            return 0L;
        }
        return this.f28141c == C.TIME_UNSET ? C.TIME_UNSET : this.f28140b;
    }

    public long a(long j2) {
        if (j2 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (this.f28141c != C.TIME_UNSET) {
            this.f28141c = j2;
        } else {
            long j3 = this.f28139a;
            if (j3 != Long.MAX_VALUE) {
                this.f28140b = j3 - j2;
            }
            synchronized (this) {
                this.f28141c = j2;
                notifyAll();
            }
        }
        return j2 + this.f28140b;
    }

    public long b(long j2) {
        if (j2 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (this.f28141c != C.TIME_UNSET) {
            long j3 = (this.f28141c * 90000) / C.MICROS_PER_SECOND;
            long j4 = (4294967296L + j3) / 8589934592L;
            long j5 = ((j4 - 1) * 8589934592L) + j2;
            j2 += j4 * 8589934592L;
            if (Math.abs(j5 - j3) < Math.abs(j2 - j3)) {
                j2 = j5;
            }
        }
        return a((j2 * C.MICROS_PER_SECOND) / 90000);
    }

    public synchronized void c(long j2) {
        g1.b(this.f28141c == C.TIME_UNSET);
        this.f28139a = j2;
    }
}
