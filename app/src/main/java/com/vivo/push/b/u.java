package com.vivo.push.b;

/* loaded from: classes4.dex */
public final class u extends v {

    /* renamed from: a */
    private long f30925a;

    /* renamed from: b */
    private int f30926b;

    public u() {
        super(20);
        this.f30925a = -1L;
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.o
    protected final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("undo_msg_v1", this.f30925a);
        aVar.a("undo_msg_type_v1", this.f30926b);
    }

    public final long d() {
        return this.f30925a;
    }

    public final String e() {
        long j2 = this.f30925a;
        if (j2 != -1) {
            return String.valueOf(j2);
        }
        return null;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnUndoMsgCommand";
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.o
    protected final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f30925a = aVar.b("undo_msg_v1", this.f30925a);
        this.f30926b = aVar.b("undo_msg_type_v1", 0);
    }
}
