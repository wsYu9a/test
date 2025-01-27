package com.opos.mobad.l;

/* loaded from: classes4.dex */
public abstract class i extends j implements com.opos.mobad.ad.e.b {

    /* renamed from: a */
    private com.opos.mobad.ad.e.c f21197a;

    public i(com.opos.mobad.ad.e.c cVar) {
        super(cVar);
        this.f21197a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(String str) {
        com.opos.mobad.ad.e.c cVar;
        if (5 == d() || (cVar = this.f21197a) == null) {
            return;
        }
        cVar.a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i() {
        com.opos.mobad.ad.e.c cVar;
        if (5 == d() || (cVar = this.f21197a) == null) {
            return;
        }
        cVar.a(0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.mobad.l.j
    public void i_() {
        com.opos.mobad.ad.e.c cVar;
        if (5 == d() || (cVar = this.f21197a) == null) {
            return;
        }
        cVar.b();
    }
}
