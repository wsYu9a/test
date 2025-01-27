package com.vivo.push.b;

/* loaded from: classes4.dex */
public final class y extends com.vivo.push.o {

    /* renamed from: a */
    private String f24959a;

    public y(String str) {
        super(2008);
        this.f24959a = str;
    }

    @Override // com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.f24959a);
    }

    @Override // com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        this.f24959a = aVar.a("package_name");
    }

    @Override // com.vivo.push.o
    public final String toString() {
        return "StopServiceCommand";
    }

    public y() {
        super(2008);
    }
}
