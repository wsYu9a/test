package com.vivo.push.b;

/* loaded from: classes4.dex */
public final class b extends c {

    /* renamed from: a */
    private String f24916a;

    /* renamed from: b */
    private String f24917b;

    /* renamed from: c */
    private String f24918c;

    /* renamed from: d */
    private String f24919d;

    /* renamed from: e */
    private boolean f24920e;

    public b(boolean z10, String str) {
        super(z10 ? 2006 : 2007, str);
        this.f24920e = false;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("sdk_clients", this.f24916a);
        aVar.a("sdk_version", 323L);
        aVar.a("BaseAppCommand.EXTRA_APPID", this.f24918c);
        aVar.a("BaseAppCommand.EXTRA_APPKEY", this.f24917b);
        aVar.a("PUSH_REGID", this.f24919d);
    }

    public final void d() {
        this.f24918c = null;
    }

    public final void e() {
        this.f24917b = null;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final String toString() {
        return "AppCommand:" + b();
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f24916a = aVar.a("sdk_clients");
        this.f24918c = aVar.a("BaseAppCommand.EXTRA_APPID");
        this.f24917b = aVar.a("BaseAppCommand.EXTRA_APPKEY");
        this.f24919d = aVar.a("PUSH_REGID");
    }
}
