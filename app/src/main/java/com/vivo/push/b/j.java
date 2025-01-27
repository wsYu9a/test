package com.vivo.push.b;

/* loaded from: classes4.dex */
public final class j extends s {

    /* renamed from: a */
    private int f24932a;

    /* renamed from: b */
    private int f24933b;

    public j() {
        super(12);
        this.f24932a = -1;
        this.f24933b = -1;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f24932a);
        aVar.a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f24933b);
    }

    public final int d() {
        return this.f24932a;
    }

    public final int e() {
        return this.f24933b;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnChangePushStatusCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f24932a = aVar.b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f24932a);
        this.f24933b = aVar.b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f24933b);
    }
}
