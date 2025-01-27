package com.vivo.push.b;

/* loaded from: classes4.dex */
public final class w extends com.vivo.push.o {

    /* renamed from: a */
    private int f30929a;

    public w() {
        super(2011);
        this.f30929a = 0;
    }

    @Override // com.vivo.push.o
    protected final void c(com.vivo.push.a aVar) {
        aVar.a("com.bbk.push.ikey.MODE_TYPE", this.f30929a);
    }

    @Override // com.vivo.push.o
    public final boolean c() {
        return true;
    }

    public final int d() {
        return this.f30929a;
    }

    @Override // com.vivo.push.o
    public final String toString() {
        return "PushModeCommand";
    }

    @Override // com.vivo.push.o
    protected final void d(com.vivo.push.a aVar) {
        this.f30929a = aVar.b("com.bbk.push.ikey.MODE_TYPE", 0);
    }
}
