package com.vivo.push.b;

/* loaded from: classes4.dex */
public final class n extends s {

    /* renamed from: a */
    private String f24937a;

    /* renamed from: b */
    private int f24938b;

    /* renamed from: c */
    private boolean f24939c;

    public n() {
        super(7);
        this.f24938b = 0;
        this.f24939c = false;
    }

    public final void a(int i10) {
        this.f24938b = i10;
    }

    public final void b(String str) {
        this.f24937a = str;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.f24937a);
        aVar.a("log_level", this.f24938b);
        aVar.a("is_server_log", this.f24939c);
    }

    public final String d() {
        return this.f24937a;
    }

    public final int e() {
        return this.f24938b;
    }

    public final boolean f() {
        return this.f24939c;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnLogCommand";
    }

    public final void a(boolean z10) {
        this.f24939c = z10;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f24937a = aVar.a("content");
        this.f24938b = aVar.b("log_level", 0);
        this.f24939c = aVar.e("is_server_log");
    }
}
