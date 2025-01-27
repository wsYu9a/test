package com.vivo.push.b;

/* loaded from: classes4.dex */
public class s extends com.vivo.push.o {

    /* renamed from: a */
    private String f30921a;

    /* renamed from: b */
    private int f30922b;

    public s(int i2) {
        super(i2);
        this.f30921a = null;
        this.f30922b = 0;
    }

    @Override // com.vivo.push.o
    protected void c(com.vivo.push.a aVar) {
        aVar.a("req_id", this.f30921a);
        aVar.a("status_msg_code", this.f30922b);
    }

    @Override // com.vivo.push.o
    protected void d(com.vivo.push.a aVar) {
        this.f30921a = aVar.a("req_id");
        this.f30922b = aVar.b("status_msg_code", this.f30922b);
    }

    public final String g() {
        return this.f30921a;
    }

    public final int h() {
        return this.f30922b;
    }

    @Override // com.vivo.push.o
    public String toString() {
        return "OnReceiveCommand";
    }
}
