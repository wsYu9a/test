package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
public final class s implements q {

    /* renamed from: a */
    private com.opos.exoplayer.core.i.s f18254a;

    /* renamed from: b */
    private com.opos.exoplayer.core.c.n f18255b;

    /* renamed from: c */
    private boolean f18256c;

    @Override // com.opos.exoplayer.core.c.f.q
    public void a(com.opos.exoplayer.core.i.m mVar) {
        if (!this.f18256c) {
            if (this.f18254a.c() == C.TIME_UNSET) {
                return;
            }
            this.f18255b.a(Format.a((String) null, "application/x-scte35", this.f18254a.c()));
            this.f18256c = true;
        }
        int b2 = mVar.b();
        this.f18255b.a(mVar, b2);
        this.f18255b.a(this.f18254a.b(), 1, b2, 0, null);
    }

    @Override // com.opos.exoplayer.core.c.f.q
    public void a(com.opos.exoplayer.core.i.s sVar, com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        this.f18254a = sVar;
        dVar.a();
        com.opos.exoplayer.core.c.n a2 = gVar.a(dVar.b(), 4);
        this.f18255b = a2;
        a2.a(Format.a(dVar.c(), "application/x-scte35", (String) null, -1, (DrmInitData) null));
    }
}
