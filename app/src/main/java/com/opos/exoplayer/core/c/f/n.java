package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;
import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
public final class n implements h {

    /* renamed from: a */
    private final com.opos.exoplayer.core.i.m f18212a;

    /* renamed from: b */
    private final com.opos.exoplayer.core.c.j f18213b;

    /* renamed from: c */
    private final String f18214c;

    /* renamed from: d */
    private String f18215d;

    /* renamed from: e */
    private com.opos.exoplayer.core.c.n f18216e;

    /* renamed from: f */
    private int f18217f;

    /* renamed from: g */
    private int f18218g;

    /* renamed from: h */
    private boolean f18219h;

    /* renamed from: i */
    private boolean f18220i;

    /* renamed from: j */
    private long f18221j;
    private int k;
    private long l;

    public n() {
        this(null);
    }

    public n(String str) {
        this.f18217f = 0;
        com.opos.exoplayer.core.i.m mVar = new com.opos.exoplayer.core.i.m(4);
        this.f18212a = mVar;
        mVar.f19048a[0] = (byte) (-1);
        this.f18213b = new com.opos.exoplayer.core.c.j();
        this.f18214c = str;
    }

    private void b(com.opos.exoplayer.core.i.m mVar) {
        byte[] bArr = mVar.f19048a;
        int c2 = mVar.c();
        for (int d2 = mVar.d(); d2 < c2; d2++) {
            boolean z = (bArr[d2] & 255) == 255;
            boolean z2 = this.f18220i && (bArr[d2] & 224) == 224;
            this.f18220i = z;
            if (z2) {
                mVar.c(d2 + 1);
                this.f18220i = false;
                this.f18212a.f19048a[1] = bArr[d2];
                this.f18218g = 2;
                this.f18217f = 1;
                return;
            }
        }
        mVar.c(c2);
    }

    private void c(com.opos.exoplayer.core.i.m mVar) {
        int min = Math.min(mVar.b(), 4 - this.f18218g);
        mVar.a(this.f18212a.f19048a, this.f18218g, min);
        int i2 = min + this.f18218g;
        this.f18218g = i2;
        if (i2 < 4) {
            return;
        }
        this.f18212a.c(0);
        if (!com.opos.exoplayer.core.c.j.a(this.f18212a.o(), this.f18213b)) {
            this.f18218g = 0;
            this.f18217f = 1;
            return;
        }
        com.opos.exoplayer.core.c.j jVar = this.f18213b;
        this.k = jVar.f18318c;
        if (!this.f18219h) {
            long j2 = jVar.f18322g * C.MICROS_PER_SECOND;
            int i3 = jVar.f18319d;
            this.f18221j = j2 / i3;
            this.f18216e.a(Format.a(this.f18215d, jVar.f18317b, null, -1, 4096, jVar.f18320e, i3, null, null, 0, this.f18214c));
            this.f18219h = true;
        }
        this.f18212a.c(0);
        this.f18216e.a(this.f18212a, 4);
        this.f18217f = 2;
    }

    private void d(com.opos.exoplayer.core.i.m mVar) {
        int min = Math.min(mVar.b(), this.k - this.f18218g);
        this.f18216e.a(mVar, min);
        int i2 = min + this.f18218g;
        this.f18218g = i2;
        int i3 = this.k;
        if (i2 < i3) {
            return;
        }
        this.f18216e.a(this.l, 1, i3, 0, null);
        this.l += this.f18221j;
        this.f18218g = 0;
        this.f18217f = 0;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        this.f18217f = 0;
        this.f18218g = 0;
        this.f18220i = false;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j2, boolean z) {
        this.l = j2;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        this.f18215d = dVar.c();
        this.f18216e = gVar.a(dVar.b(), 1);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.m mVar) {
        while (mVar.b() > 0) {
            int i2 = this.f18217f;
            if (i2 == 0) {
                b(mVar);
            } else if (i2 == 1) {
                c(mVar);
            } else if (i2 == 2) {
                d(mVar);
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
    }
}
