package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;
import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
public final class f implements h {

    /* renamed from: b */
    private final String f18116b;

    /* renamed from: c */
    private String f18117c;

    /* renamed from: d */
    private com.opos.exoplayer.core.c.n f18118d;

    /* renamed from: f */
    private int f18120f;

    /* renamed from: g */
    private int f18121g;

    /* renamed from: h */
    private long f18122h;

    /* renamed from: i */
    private Format f18123i;

    /* renamed from: j */
    private int f18124j;
    private long k;

    /* renamed from: a */
    private final com.opos.exoplayer.core.i.m f18115a = new com.opos.exoplayer.core.i.m(new byte[18]);

    /* renamed from: e */
    private int f18119e = 0;

    public f(String str) {
        this.f18116b = str;
    }

    private boolean a(com.opos.exoplayer.core.i.m mVar, byte[] bArr, int i2) {
        int min = Math.min(mVar.b(), i2 - this.f18120f);
        mVar.a(bArr, this.f18120f, min);
        int i3 = min + this.f18120f;
        this.f18120f = i3;
        return i3 == i2;
    }

    private boolean b(com.opos.exoplayer.core.i.m mVar) {
        while (mVar.b() > 0) {
            int i2 = this.f18121g << 8;
            this.f18121g = i2;
            int g2 = i2 | mVar.g();
            this.f18121g = g2;
            if (com.opos.exoplayer.core.a.h.a(g2)) {
                byte[] bArr = this.f18115a.f19048a;
                int i3 = this.f18121g;
                bArr[0] = (byte) ((i3 >> 24) & 255);
                bArr[1] = (byte) ((i3 >> 16) & 255);
                bArr[2] = (byte) ((i3 >> 8) & 255);
                bArr[3] = (byte) (i3 & 255);
                this.f18120f = 4;
                this.f18121g = 0;
                return true;
            }
        }
        return false;
    }

    private void c() {
        byte[] bArr = this.f18115a.f19048a;
        if (this.f18123i == null) {
            Format a2 = com.opos.exoplayer.core.a.h.a(bArr, this.f18117c, this.f18116b, null);
            this.f18123i = a2;
            this.f18118d.a(a2);
        }
        this.f18124j = com.opos.exoplayer.core.a.h.b(bArr);
        this.f18122h = (int) ((com.opos.exoplayer.core.a.h.a(bArr) * C.MICROS_PER_SECOND) / this.f18123i.s);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        this.f18119e = 0;
        this.f18120f = 0;
        this.f18121g = 0;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j2, boolean z) {
        this.k = j2;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        this.f18117c = dVar.c();
        this.f18118d = gVar.a(dVar.b(), 1);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.m mVar) {
        while (mVar.b() > 0) {
            int i2 = this.f18119e;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        int min = Math.min(mVar.b(), this.f18124j - this.f18120f);
                        this.f18118d.a(mVar, min);
                        int i3 = min + this.f18120f;
                        this.f18120f = i3;
                        int i4 = this.f18124j;
                        if (i3 == i4) {
                            this.f18118d.a(this.k, 1, i4, 0, null);
                            this.k += this.f18122h;
                            this.f18119e = 0;
                        }
                    }
                } else if (a(mVar, this.f18115a.f19048a, 18)) {
                    c();
                    this.f18115a.c(0);
                    this.f18118d.a(this.f18115a, 18);
                    this.f18119e = 2;
                }
            } else if (b(mVar)) {
                this.f18119e = 1;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
    }
}
