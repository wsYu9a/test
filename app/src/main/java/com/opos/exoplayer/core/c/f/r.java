package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.c.f.u;

/* loaded from: classes4.dex */
public final class r implements u {

    /* renamed from: a */
    private final q f18248a;

    /* renamed from: b */
    private final com.opos.exoplayer.core.i.m f18249b = new com.opos.exoplayer.core.i.m(32);

    /* renamed from: c */
    private int f18250c;

    /* renamed from: d */
    private int f18251d;

    /* renamed from: e */
    private boolean f18252e;

    /* renamed from: f */
    private boolean f18253f;

    public r(q qVar) {
        this.f18248a = qVar;
    }

    @Override // com.opos.exoplayer.core.c.f.u
    public void a() {
        this.f18253f = true;
    }

    @Override // com.opos.exoplayer.core.c.f.u
    public void a(com.opos.exoplayer.core.i.m mVar, boolean z) {
        int g2 = z ? mVar.g() + mVar.d() : -1;
        if (this.f18253f) {
            if (!z) {
                return;
            }
            this.f18253f = false;
            mVar.c(g2);
            this.f18251d = 0;
        }
        while (mVar.b() > 0) {
            int i2 = this.f18251d;
            if (i2 < 3) {
                if (i2 == 0) {
                    int g3 = mVar.g();
                    mVar.c(mVar.d() - 1);
                    if (g3 == 255) {
                        this.f18253f = true;
                        return;
                    }
                }
                int min = Math.min(mVar.b(), 3 - this.f18251d);
                mVar.a(this.f18249b.f19048a, this.f18251d, min);
                int i3 = min + this.f18251d;
                this.f18251d = i3;
                if (i3 == 3) {
                    this.f18249b.a(3);
                    this.f18249b.d(1);
                    int g4 = this.f18249b.g();
                    int g5 = this.f18249b.g();
                    this.f18252e = (g4 & 128) != 0;
                    this.f18250c = (((g4 & 15) << 8) | g5) + 3;
                    int e2 = this.f18249b.e();
                    int i4 = this.f18250c;
                    if (e2 < i4) {
                        com.opos.exoplayer.core.i.m mVar2 = this.f18249b;
                        byte[] bArr = mVar2.f19048a;
                        mVar2.a(Math.min(4098, Math.max(i4, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.f18249b.f19048a, 0, 3);
                    }
                }
            } else {
                int min2 = Math.min(mVar.b(), this.f18250c - this.f18251d);
                mVar.a(this.f18249b.f19048a, this.f18251d, min2);
                int i5 = min2 + this.f18251d;
                this.f18251d = i5;
                int i6 = this.f18250c;
                if (i5 != i6) {
                    continue;
                } else {
                    if (!this.f18252e) {
                        this.f18249b.a(i6);
                    } else {
                        if (com.opos.exoplayer.core.i.u.a(this.f18249b.f19048a, 0, i6, -1) != 0) {
                            this.f18253f = true;
                            return;
                        }
                        this.f18249b.a(this.f18250c - 4);
                    }
                    this.f18248a.a(this.f18249b);
                    this.f18251d = 0;
                }
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.u
    public void a(com.opos.exoplayer.core.i.s sVar, com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        this.f18248a.a(sVar, gVar, dVar);
        this.f18253f = true;
    }
}
