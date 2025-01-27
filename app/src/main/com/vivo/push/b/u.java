package com.vivo.push.b;

/* loaded from: classes4.dex */
public final class u extends v {

    /* renamed from: a */
    private long f24952a;

    /* renamed from: b */
    private int f24953b;

    public u() {
        super(20);
        this.f24952a = -1L;
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("undo_msg_v1", this.f24952a);
        aVar.a("undo_msg_type_v1", this.f24953b);
    }

    public final long d() {
        return this.f24952a;
    }

    public final String e() {
        long j10 = this.f24952a;
        if (j10 != -1) {
            return String.valueOf(j10);
        }
        return null;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnUndoMsgCommand";
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f24952a = aVar.b("undo_msg_v1", this.f24952a);
        this.f24953b = aVar.b("undo_msg_type_v1", 0);
    }
}
