package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;
import com.opos.exoplayer.core.drm.DrmInitData;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class g implements h {

    /* renamed from: a */
    private final List<u.a> f18125a;

    /* renamed from: b */
    private final com.opos.exoplayer.core.c.n[] f18126b;

    /* renamed from: c */
    private boolean f18127c;

    /* renamed from: d */
    private int f18128d;

    /* renamed from: e */
    private int f18129e;

    /* renamed from: f */
    private long f18130f;

    public g(List<u.a> list) {
        this.f18125a = list;
        this.f18126b = new com.opos.exoplayer.core.c.n[list.size()];
    }

    private boolean a(com.opos.exoplayer.core.i.m mVar, int i2) {
        if (mVar.b() == 0) {
            return false;
        }
        if (mVar.g() != i2) {
            this.f18127c = false;
        }
        this.f18128d--;
        return this.f18127c;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        this.f18127c = false;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j2, boolean z) {
        if (z) {
            this.f18127c = true;
            this.f18130f = j2;
            this.f18129e = 0;
            this.f18128d = 2;
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        for (int i2 = 0; i2 < this.f18126b.length; i2++) {
            u.a aVar = this.f18125a.get(i2);
            dVar.a();
            com.opos.exoplayer.core.c.n a2 = gVar.a(dVar.b(), 3);
            a2.a(Format.a(dVar.c(), "application/dvbsubs", (String) null, -1, 0, (List<byte[]>) Collections.singletonList(aVar.f18276c), aVar.f18274a, (DrmInitData) null));
            this.f18126b[i2] = a2;
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.m mVar) {
        if (this.f18127c) {
            if (this.f18128d != 2 || a(mVar, 32)) {
                if (this.f18128d != 1 || a(mVar, 0)) {
                    int d2 = mVar.d();
                    int b2 = mVar.b();
                    for (com.opos.exoplayer.core.c.n nVar : this.f18126b) {
                        mVar.c(d2);
                        nVar.a(mVar, b2);
                    }
                    this.f18129e += b2;
                }
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
        if (this.f18127c) {
            for (com.opos.exoplayer.core.c.n nVar : this.f18126b) {
                nVar.a(this.f18130f, 1, this.f18129e, 0, null);
            }
            this.f18127c = false;
        }
    }
}
