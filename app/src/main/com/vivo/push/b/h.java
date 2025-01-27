package com.vivo.push.b;

/* loaded from: classes4.dex */
public final class h extends com.vivo.push.o {

    /* renamed from: a */
    private String f24928a;

    public h() {
        super(2013);
    }

    @Override // com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        aVar.a("MsgArriveCommand.MSG_TAG", this.f24928a);
    }

    @Override // com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        this.f24928a = aVar.a("MsgArriveCommand.MSG_TAG");
    }

    public h(String str) {
        this();
        this.f24928a = str;
    }
}
