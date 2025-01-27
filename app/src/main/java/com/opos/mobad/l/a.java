package com.opos.mobad.l;

/* loaded from: classes4.dex */
public abstract class a extends j implements com.opos.mobad.ad.a.a {

    /* renamed from: a */
    private com.opos.mobad.ad.a.b f21180a;

    public a(com.opos.mobad.ad.a.b bVar) {
        super(bVar);
        this.f21180a = bVar;
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        if (this.f21180a != null) {
            this.f21180a = null;
        }
        super.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g_() {
        com.opos.mobad.ad.a.b bVar;
        if (d() == 5 || (bVar = this.f21180a) == null) {
            return;
        }
        bVar.a("");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i() {
        com.opos.mobad.ad.a.b bVar;
        if (5 == d() || (bVar = this.f21180a) == null) {
            return;
        }
        bVar.a(0L);
    }
}
