package com.opos.exoplayer.core.c.c;

import com.opos.exoplayer.core.c.c.a;
import com.opos.exoplayer.core.c.j;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
final class c implements a.InterfaceC0400a {

    /* renamed from: a */
    private final long[] f17854a;

    /* renamed from: b */
    private final long[] f17855b;

    /* renamed from: c */
    private final long f17856c;

    private c(long[] jArr, long[] jArr2, long j2) {
        this.f17854a = jArr;
        this.f17855b = jArr2;
        this.f17856c = j2;
    }

    public static c a(long j2, long j3, j jVar, m mVar) {
        int g2;
        mVar.d(10);
        int o = mVar.o();
        if (o > 0) {
            int i2 = jVar.f18319d;
            long d2 = u.d(o, (i2 >= 32000 ? 1152 : 576) * C.MICROS_PER_SECOND, i2);
            int h2 = mVar.h();
            int h3 = mVar.h();
            int h4 = mVar.h();
            mVar.d(2);
            long j4 = jVar.f18318c;
            long[] jArr = new long[h2];
            long[] jArr2 = new long[h2];
            int i3 = 0;
            long j5 = j3;
            while (i3 < h2) {
                long j6 = j4;
                long j7 = d2;
                jArr[i3] = (i3 * d2) / h2;
                long j8 = j5;
                jArr2[i3] = Math.max(j8, j3 + j6);
                if (h4 == 1) {
                    g2 = mVar.g();
                } else if (h4 == 2) {
                    g2 = mVar.h();
                } else if (h4 == 3) {
                    g2 = mVar.k();
                } else if (h4 == 4) {
                    g2 = mVar.u();
                }
                j5 = j8 + (g2 * h3);
                i3++;
                j4 = j6;
                d2 = j7;
            }
            long j9 = d2;
            long j10 = j5;
            if (j2 != -1 && j2 != j10) {
                com.opos.cmn.an.f.a.c("VbriSeeker", "VBRI data size mismatch: " + j2 + ", " + j10);
            }
            return new c(jArr, jArr2, j9);
        }
        return null;
    }

    @Override // com.opos.exoplayer.core.c.c.a.InterfaceC0400a
    public long a(long j2) {
        return this.f17854a[u.a(this.f17855b, j2, true, true)];
    }

    @Override // com.opos.exoplayer.core.c.l
    public boolean a() {
        return true;
    }

    @Override // com.opos.exoplayer.core.c.l
    public long b() {
        return this.f17856c;
    }

    @Override // com.opos.exoplayer.core.c.l
    public l.a b(long j2) {
        int a2 = u.a(this.f17854a, j2, true, true);
        com.opos.exoplayer.core.c.m mVar = new com.opos.exoplayer.core.c.m(this.f17854a[a2], this.f17855b[a2]);
        if (mVar.f18329b >= j2 || a2 == this.f17854a.length - 1) {
            return new l.a(mVar);
        }
        int i2 = a2 + 1;
        return new l.a(mVar, new com.opos.exoplayer.core.c.m(this.f17854a[i2], this.f17855b[i2]));
    }
}
