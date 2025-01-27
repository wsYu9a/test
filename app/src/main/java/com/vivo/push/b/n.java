package com.vivo.push.b;

/* loaded from: classes4.dex */
public final class n extends s {

    /* renamed from: a */
    private String f30910a;

    /* renamed from: b */
    private int f30911b;

    /* renamed from: c */
    private boolean f30912c;

    public n() {
        super(7);
        this.f30911b = 0;
        this.f30912c = false;
    }

    public final void a(int i2) {
        this.f30911b = i2;
    }

    public final void b(String str) {
        this.f30910a = str;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    protected final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.f30910a);
        aVar.a("log_level", this.f30911b);
        aVar.a("is_server_log", this.f30912c);
    }

    public final String d() {
        return this.f30910a;
    }

    public final int e() {
        return this.f30911b;
    }

    public final boolean f() {
        return this.f30912c;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnLogCommand";
    }

    public final void a(boolean z) {
        this.f30912c = z;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    protected final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f30910a = aVar.a("content");
        this.f30911b = aVar.b("log_level", 0);
        this.f30912c = aVar.e("is_server_log");
    }
}
