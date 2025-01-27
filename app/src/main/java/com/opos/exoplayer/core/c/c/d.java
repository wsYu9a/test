package com.opos.exoplayer.core.c.c;

import com.opos.exoplayer.core.c.c.a;
import com.opos.exoplayer.core.c.j;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
final class d implements a.InterfaceC0400a {

    /* renamed from: a */
    private final long f17857a;

    /* renamed from: b */
    private final int f17858b;

    /* renamed from: c */
    private final long f17859c;

    /* renamed from: d */
    private final long f17860d;

    /* renamed from: e */
    private final long[] f17861e;

    private d(long j2, int i2, long j3) {
        this(j2, i2, j3, -1L, null);
    }

    private d(long j2, int i2, long j3, long j4, long[] jArr) {
        this.f17857a = j2;
        this.f17858b = i2;
        this.f17859c = j3;
        this.f17860d = j4;
        this.f17861e = jArr;
    }

    private long a(int i2) {
        return (this.f17859c * i2) / 100;
    }

    public static d a(long j2, long j3, j jVar, m mVar) {
        int u;
        int i2 = jVar.f18322g;
        int i3 = jVar.f18319d;
        int o = mVar.o();
        if ((o & 1) != 1 || (u = mVar.u()) == 0) {
            return null;
        }
        long d2 = u.d(u, i2 * C.MICROS_PER_SECOND, i3);
        if ((o & 6) != 6) {
            return new d(j3, jVar.f18318c, d2);
        }
        long u2 = mVar.u();
        long[] jArr = new long[100];
        for (int i4 = 0; i4 < 100; i4++) {
            jArr[i4] = mVar.g();
        }
        if (j2 != -1) {
            long j4 = j3 + u2;
            if (j2 != j4) {
                com.opos.cmn.an.f.a.c("XingSeeker", "XING data size mismatch: " + j2 + ", " + j4);
            }
        }
        return new d(j3, jVar.f18318c, d2, u2, jArr);
    }

    @Override // com.opos.exoplayer.core.c.c.a.InterfaceC0400a
    public long a(long j2) {
        double d2;
        long j3 = j2 - this.f17857a;
        if (!a() || j3 <= this.f17858b) {
            return 0L;
        }
        double d3 = j3;
        Double.isNaN(d3);
        double d4 = this.f17860d;
        Double.isNaN(d4);
        double d5 = (d3 * 256.0d) / d4;
        int a2 = u.a(this.f17861e, (long) d5, true, true);
        long a3 = a(a2);
        long j4 = this.f17861e[a2];
        int i2 = a2 + 1;
        long a4 = a(i2);
        long j5 = a2 == 99 ? 256L : this.f17861e[i2];
        if (j4 == j5) {
            d2 = 0.0d;
        } else {
            double d6 = j4;
            Double.isNaN(d6);
            double d7 = j5 - j4;
            Double.isNaN(d7);
            d2 = (d5 - d6) / d7;
        }
        double d8 = a4 - a3;
        Double.isNaN(d8);
        return Math.round(d2 * d8) + a3;
    }

    @Override // com.opos.exoplayer.core.c.l
    public boolean a() {
        return this.f17861e != null;
    }

    @Override // com.opos.exoplayer.core.c.l
    public long b() {
        return this.f17859c;
    }

    @Override // com.opos.exoplayer.core.c.l
    public l.a b(long j2) {
        if (!a()) {
            return new l.a(new com.opos.exoplayer.core.c.m(0L, this.f17857a + this.f17858b));
        }
        long a2 = u.a(j2, 0L, this.f17859c);
        double d2 = a2;
        Double.isNaN(d2);
        double d3 = this.f17859c;
        Double.isNaN(d3);
        double d4 = (d2 * 100.0d) / d3;
        double d5 = 0.0d;
        if (d4 > 0.0d) {
            if (d4 >= 100.0d) {
                d5 = 256.0d;
            } else {
                int i2 = (int) d4;
                double d6 = this.f17861e[i2];
                double d7 = i2 == 99 ? 256.0d : r3[i2 + 1];
                Double.isNaN(d6);
                double d8 = i2;
                Double.isNaN(d8);
                Double.isNaN(d6);
                d5 = d6 + ((d7 - d6) * (d4 - d8));
            }
        }
        double d9 = this.f17860d;
        Double.isNaN(d9);
        return new l.a(new com.opos.exoplayer.core.c.m(a2, u.a(Math.round((d5 / 256.0d) * d9), this.f17858b, this.f17860d - 1) + this.f17857a));
    }
}
