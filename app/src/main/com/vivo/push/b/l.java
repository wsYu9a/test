package com.vivo.push.b;

/* loaded from: classes4.dex */
public final class l extends s {

    /* renamed from: a */
    private int f24934a;

    /* renamed from: b */
    private int f24935b;

    public l() {
        super(2016);
        this.f24934a = -1;
        this.f24935b = -1;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("key_dispatch_environment", this.f24934a);
        aVar.a("key_dispatch_area", this.f24935b);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f24934a = aVar.b("key_dispatch_environment", 1);
        this.f24935b = aVar.b("key_dispatch_area", 1);
    }

    public final int e() {
        return this.f24935b;
    }

    public final int d() {
        return this.f24934a;
    }
}
