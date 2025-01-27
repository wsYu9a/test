package com.vivo.push.b;

/* loaded from: classes4.dex */
public final class j extends s {

    /* renamed from: a */
    private int f30905a;

    /* renamed from: b */
    private int f30906b;

    public j() {
        super(12);
        this.f30905a = -1;
        this.f30906b = -1;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    protected final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f30905a);
        aVar.a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f30906b);
    }

    public final int d() {
        return this.f30905a;
    }

    public final int e() {
        return this.f30906b;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnChangePushStatusCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    protected final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f30905a = aVar.b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f30905a);
        this.f30906b = aVar.b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f30906b);
    }
}
