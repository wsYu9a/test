package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.a1;
import com.vivo.google.android.exoplayer3.util.Util;

/* loaded from: classes4.dex */
public final class z0 implements a1.a {

    /* renamed from: a */
    public final long f28305a;

    /* renamed from: b */
    public final int f28306b;

    /* renamed from: c */
    public final long f28307c;

    public z0(long j2, int i2, long j3) {
        this.f28305a = j2;
        this.f28306b = i2;
        this.f28307c = j3 == -1 ? C.TIME_UNSET : c(j3);
    }

    @Override // com.vivo.google.android.exoplayer3.m0
    public long a(long j2) {
        long j3 = this.f28307c;
        if (j3 == C.TIME_UNSET) {
            return 0L;
        }
        return this.f28305a + ((Util.constrainValue(j2, 0L, j3) * this.f28306b) / 8000000);
    }

    @Override // com.vivo.google.android.exoplayer3.m0
    public boolean a() {
        return this.f28307c != C.TIME_UNSET;
    }

    @Override // com.vivo.google.android.exoplayer3.m0
    public long c() {
        return this.f28307c;
    }

    @Override // com.vivo.google.android.exoplayer3.a1.a
    public long c(long j2) {
        return ((Math.max(0L, j2 - this.f28305a) * C.MICROS_PER_SECOND) * 8) / this.f28306b;
    }
}
