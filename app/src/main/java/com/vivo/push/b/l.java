package com.vivo.push.b;

/* loaded from: classes4.dex */
public final class l extends s {

    /* renamed from: a */
    private int f30907a;

    /* renamed from: b */
    private int f30908b;

    public l() {
        super(2016);
        this.f30907a = -1;
        this.f30908b = -1;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    protected final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("key_dispatch_environment", this.f30907a);
        aVar.a("key_dispatch_area", this.f30908b);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    protected final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f30907a = aVar.b("key_dispatch_environment", 1);
        this.f30908b = aVar.b("key_dispatch_area", 1);
    }

    public final int e() {
        return this.f30908b;
    }

    public final int d() {
        return this.f30907a;
    }
}
