package com.vivo.push.b;

/* loaded from: classes4.dex */
public abstract class v extends s {

    /* renamed from: a */
    private String f30927a;

    /* renamed from: b */
    private long f30928b;

    public v(int i2) {
        super(i2);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    protected void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.f30927a);
        aVar.a("notify_id", this.f30928b);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    protected void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f30927a = aVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.f30928b = aVar.b("notify_id", -1L);
    }

    public final long f() {
        return this.f30928b;
    }

    public final String i() {
        return this.f30927a;
    }
}
