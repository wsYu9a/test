package com.opos.exoplayer.core.c.a;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.a.b;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.k;
import com.opos.exoplayer.core.i.m;

/* loaded from: classes4.dex */
final class e extends b {

    /* renamed from: b */
    private final m f17777b;

    /* renamed from: c */
    private final m f17778c;

    /* renamed from: d */
    private int f17779d;

    /* renamed from: e */
    private boolean f17780e;

    /* renamed from: f */
    private int f17781f;

    public e(n nVar) {
        super(nVar);
        this.f17777b = new m(k.f19027a);
        this.f17778c = new m(4);
    }

    @Override // com.opos.exoplayer.core.c.a.b
    protected boolean a(m mVar) {
        int g2 = mVar.g();
        int i2 = (g2 >> 4) & 15;
        int i3 = g2 & 15;
        if (i3 == 7) {
            this.f17781f = i2;
            return i2 != 5;
        }
        throw new b.a("Video format not supported: " + i3);
    }

    @Override // com.opos.exoplayer.core.c.a.b
    protected void b(m mVar, long j2) {
        int g2 = mVar.g();
        long l = mVar.l();
        if (g2 == 0 && !this.f17780e) {
            m mVar2 = new m(new byte[mVar.b()]);
            mVar.a(mVar2.f19048a, 0, mVar.b());
            com.opos.exoplayer.core.video.a a2 = com.opos.exoplayer.core.video.a.a(mVar2);
            this.f17779d = a2.f19220b;
            this.f17771a.a(Format.a((String) null, "video/avc", (String) null, -1, -1, a2.f19221c, a2.f19222d, -1.0f, a2.f19219a, -1, a2.f19223e, (DrmInitData) null));
            this.f17780e = true;
            return;
        }
        if (g2 == 1 && this.f17780e) {
            byte[] bArr = this.f17778c.f19048a;
            byte b2 = (byte) 0;
            bArr[0] = b2;
            bArr[1] = b2;
            bArr[2] = b2;
            int i2 = this.f17779d;
            int i3 = 0;
            while (mVar.b() > 0) {
                mVar.a(this.f17778c.f19048a, 4 - i2, this.f17779d);
                this.f17778c.c(0);
                int u = this.f17778c.u();
                this.f17777b.c(0);
                this.f17771a.a(this.f17777b, 4);
                this.f17771a.a(mVar, u);
                i3 = i3 + 4 + u;
            }
            this.f17771a.a((l * 1000) + j2, this.f17781f == 1 ? 1 : 0, i3, 0, null);
        }
    }
}
