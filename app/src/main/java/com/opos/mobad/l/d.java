package com.opos.mobad.l;

/* loaded from: classes4.dex */
public abstract class d extends k implements com.opos.mobad.ad.b.c {

    /* renamed from: a */
    private com.opos.mobad.ad.b.d f21181a;

    public d(com.opos.mobad.ad.b.d dVar) {
        super(dVar);
        this.f21181a = dVar;
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        this.f21181a = null;
        super.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h() {
        com.opos.mobad.ad.b.d dVar;
        if (d() == 5 || (dVar = this.f21181a) == null) {
            return;
        }
        dVar.c();
    }
}
