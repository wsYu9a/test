package com.vivo.push.b;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;

/* loaded from: classes4.dex */
public class s extends com.vivo.push.o {

    /* renamed from: a */
    private String f24948a;

    /* renamed from: b */
    private int f24949b;

    public s(int i10) {
        super(i10);
        this.f24948a = null;
        this.f24949b = 0;
    }

    @Override // com.vivo.push.o
    public void c(com.vivo.push.a aVar) {
        aVar.a(ExposeManager.UtArgsNames.reqId, this.f24948a);
        aVar.a("status_msg_code", this.f24949b);
    }

    @Override // com.vivo.push.o
    public void d(com.vivo.push.a aVar) {
        this.f24948a = aVar.a(ExposeManager.UtArgsNames.reqId);
        this.f24949b = aVar.b("status_msg_code", this.f24949b);
    }

    public final String g() {
        return this.f24948a;
    }

    public final int h() {
        return this.f24949b;
    }

    @Override // com.vivo.push.o
    public String toString() {
        return "OnReceiveCommand";
    }
}
