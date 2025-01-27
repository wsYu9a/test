package com.opos.exoplayer.core.c.c;

import com.opos.exoplayer.core.c.c.a;
import com.opos.exoplayer.core.c.j;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.c.m;
import com.opos.exoplayer.core.i.u;
import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
final class b implements a.InterfaceC0400a {

    /* renamed from: a */
    private final long f17849a;

    /* renamed from: b */
    private final int f17850b;

    /* renamed from: c */
    private final long f17851c;

    /* renamed from: d */
    private final int f17852d;

    /* renamed from: e */
    private final long f17853e;

    public b(long j2, long j3, j jVar) {
        long a2;
        this.f17849a = j3;
        this.f17850b = jVar.f18318c;
        this.f17852d = jVar.f18321f;
        if (j2 == -1) {
            this.f17851c = -1L;
            a2 = C.TIME_UNSET;
        } else {
            this.f17851c = j2 - j3;
            a2 = a(j2);
        }
        this.f17853e = a2;
    }

    @Override // com.opos.exoplayer.core.c.c.a.InterfaceC0400a
    public long a(long j2) {
        return ((Math.max(0L, j2 - this.f17849a) * C.MICROS_PER_SECOND) * 8) / this.f17852d;
    }

    @Override // com.opos.exoplayer.core.c.l
    public boolean a() {
        return this.f17851c != -1;
    }

    @Override // com.opos.exoplayer.core.c.l
    public long b() {
        return this.f17853e;
    }

    @Override // com.opos.exoplayer.core.c.l
    public l.a b(long j2) {
        long j3 = this.f17851c;
        if (j3 == -1) {
            return new l.a(new m(0L, this.f17849a));
        }
        int i2 = this.f17850b;
        long a2 = u.a((((this.f17852d * j2) / 8000000) / i2) * i2, 0L, j3 - i2);
        long j4 = this.f17849a + a2;
        long a3 = a(j4);
        m mVar = new m(a3, j4);
        if (a3 < j2) {
            long j5 = this.f17851c;
            int i3 = this.f17850b;
            if (a2 != j5 - i3) {
                long j6 = i3 + j4;
                return new l.a(mVar, new m(a(j6), j6));
            }
        }
        return new l.a(mVar);
    }
}
