package com.aggmoread.sdk.z.d.a.a.d.a.d.r;

/* loaded from: classes.dex */
public class k extends c {

    /* renamed from: l */
    private com.aggmoread.sdk.z.d.a.a.d.b.e f5569l;

    public k(com.aggmoread.sdk.z.d.a.a.d.b.e eVar, com.aggmoread.sdk.z.d.a.a.e.f fVar, int i10) {
        this.f5569l = eVar;
        this.f5905a = eVar.f5905a;
        this.f5906b = eVar.f5906b;
        this.f5910f = i10;
        this.f5908d = eVar.f5908d;
        this.f5907c = fVar;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.e
    public void a(com.aggmoread.sdk.z.d.a.a.d.b.k kVar) {
        this.f5569l.a(kVar);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.e
    public void b(com.aggmoread.sdk.z.d.a.a.d.b.k kVar) {
        this.f5569l.b(kVar);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.e
    public boolean h() {
        return this.f5569l.h();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.e
    public void j() {
        this.f5569l.j();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.e
    public void k() {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.e
    public boolean l() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("ACWFRTAG", "con tryNextSDK , rid " + this.f5905a.f5857c + ", listener0 " + this.f5905a.f5861g);
        com.aggmoread.sdk.z.d.a.a.c.f fVar = this.f5905a.f5861g;
        if (fVar == null) {
            return true;
        }
        fVar.a(new com.aggmoread.sdk.z.d.a.a.d.b.i(-20000, "未匹配到合适的广告"));
        return true;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.e
    public void a(boolean z10) {
        this.f5569l.a(true);
    }
}
