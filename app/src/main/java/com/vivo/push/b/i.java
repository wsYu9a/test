package com.vivo.push.b;

import com.tencent.connect.common.Constants;

/* loaded from: classes4.dex */
public final class i extends s {

    /* renamed from: a */
    private String f30902a;

    /* renamed from: b */
    private String f30903b;

    /* renamed from: c */
    private String f30904c;

    public i(int i2) {
        super(i2);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    protected final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("app_id", this.f30902a);
        aVar.a(Constants.PARAM_CLIENT_ID, this.f30903b);
        aVar.a("client_token", this.f30904c);
    }

    public final String d() {
        return this.f30902a;
    }

    public final String e() {
        return this.f30904c;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnBindCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    protected final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f30902a = aVar.a("app_id");
        this.f30903b = aVar.a(Constants.PARAM_CLIENT_ID);
        this.f30904c = aVar.a("client_token");
    }
}
