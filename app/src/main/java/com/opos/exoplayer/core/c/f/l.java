package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;
import com.opos.exoplayer.core.drm.DrmInitData;

/* loaded from: classes4.dex */
public final class l implements h {

    /* renamed from: a */
    private final com.opos.exoplayer.core.i.m f18196a = new com.opos.exoplayer.core.i.m(10);

    /* renamed from: b */
    private com.opos.exoplayer.core.c.n f18197b;

    /* renamed from: c */
    private boolean f18198c;

    /* renamed from: d */
    private long f18199d;

    /* renamed from: e */
    private int f18200e;

    /* renamed from: f */
    private int f18201f;

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        this.f18198c = false;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j2, boolean z) {
        if (z) {
            this.f18198c = true;
            this.f18199d = j2;
            this.f18200e = 0;
            this.f18201f = 0;
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        com.opos.exoplayer.core.c.n a2 = gVar.a(dVar.b(), 4);
        this.f18197b = a2;
        a2.a(Format.a(dVar.c(), "application/id3", (String) null, -1, (DrmInitData) null));
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.m mVar) {
        if (this.f18198c) {
            int b2 = mVar.b();
            int i2 = this.f18201f;
            if (i2 < 10) {
                int min = Math.min(b2, 10 - i2);
                System.arraycopy(mVar.f19048a, mVar.d(), this.f18196a.f19048a, this.f18201f, min);
                if (min + this.f18201f == 10) {
                    this.f18196a.c(0);
                    if (73 != this.f18196a.g() || 68 != this.f18196a.g() || 51 != this.f18196a.g()) {
                        com.opos.cmn.an.f.a.c("Id3Reader", "Discarding invalid ID3 tag");
                        this.f18198c = false;
                        return;
                    } else {
                        this.f18196a.d(3);
                        this.f18200e = this.f18196a.t() + 10;
                    }
                }
            }
            int min2 = Math.min(b2, this.f18200e - this.f18201f);
            this.f18197b.a(mVar, min2);
            this.f18201f = min2 + this.f18201f;
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
        int i2;
        if (this.f18198c && (i2 = this.f18200e) != 0 && this.f18201f == i2) {
            this.f18197b.a(this.f18199d, 1, i2, 0, null);
            this.f18198c = false;
        }
    }
}
