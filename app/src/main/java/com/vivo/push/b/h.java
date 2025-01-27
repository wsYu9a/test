package com.vivo.push.b;

/* loaded from: classes4.dex */
public final class h extends com.vivo.push.o {

    /* renamed from: a */
    private String f30901a;

    public h() {
        super(2013);
    }

    @Override // com.vivo.push.o
    protected final void c(com.vivo.push.a aVar) {
        aVar.a("MsgArriveCommand.MSG_TAG", this.f30901a);
    }

    @Override // com.vivo.push.o
    protected final void d(com.vivo.push.a aVar) {
        this.f30901a = aVar.a("MsgArriveCommand.MSG_TAG");
    }

    public h(String str) {
        this();
        this.f30901a = str;
    }
}
