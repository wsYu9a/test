package com.vivo.push.b;

import com.tencent.connect.common.Constants;

/* loaded from: classes4.dex */
public final class i extends s {

    /* renamed from: a */
    private String f24929a;

    /* renamed from: b */
    private String f24930b;

    /* renamed from: c */
    private String f24931c;

    public i(int i10) {
        super(i10);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("app_id", this.f24929a);
        aVar.a(Constants.PARAM_CLIENT_ID, this.f24930b);
        aVar.a("client_token", this.f24931c);
    }

    public final String d() {
        return this.f24929a;
    }

    public final String e() {
        return this.f24931c;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnBindCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f24929a = aVar.a("app_id");
        this.f24930b = aVar.a(Constants.PARAM_CLIENT_ID);
        this.f24931c = aVar.a("client_token");
    }
}
