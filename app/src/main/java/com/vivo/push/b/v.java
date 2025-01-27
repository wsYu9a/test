package com.vivo.push.b;

/* loaded from: classes4.dex */
public abstract class v extends s {

    /* renamed from: a */
    private String f24954a;

    /* renamed from: b */
    private long f24955b;

    public v(int i10) {
        super(i10);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.f24954a);
        aVar.a("notify_id", this.f24955b);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f24954a = aVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.f24955b = aVar.b("notify_id", -1L);
    }

    public final long f() {
        return this.f24955b;
    }

    public final String i() {
        return this.f24954a;
    }
}
