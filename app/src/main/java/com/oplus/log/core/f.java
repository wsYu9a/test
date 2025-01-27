package com.oplus.log.core;

/* loaded from: classes4.dex */
final class f implements g {

    /* renamed from: a */
    private g f16148a;

    /* renamed from: b */
    private boolean f16149b;

    /* renamed from: c */
    private i f16150c;

    f() {
    }

    @Override // com.oplus.log.core.g
    public final void logan_debug(boolean z) {
        g gVar = this.f16148a;
        if (gVar != null) {
            gVar.logan_debug(z);
        }
    }

    @Override // com.oplus.log.core.g
    public final void logan_flush() {
        g gVar = this.f16148a;
        if (gVar != null) {
            gVar.logan_flush();
        }
    }

    @Override // com.oplus.log.core.g
    public final void logan_init(String str, String str2, int i2, String str3, String str4) {
        if (this.f16149b) {
            return;
        }
        if (!CLoganProtocol.isCloganSuccess()) {
            this.f16148a = null;
            return;
        }
        CLoganProtocol cLoganProtocol = new CLoganProtocol();
        this.f16148a = cLoganProtocol;
        cLoganProtocol.setOnLoganProtocolStatus(this.f16150c);
        this.f16148a.logan_init(str, str2, i2, str3, str4);
        this.f16149b = true;
    }

    @Override // com.oplus.log.core.g
    public final void logan_open(String str) {
        g gVar = this.f16148a;
        if (gVar != null) {
            gVar.logan_open(str);
        }
    }

    @Override // com.oplus.log.core.g
    public final void logan_write(int i2, String str, long j2, String str2, long j3) {
        g gVar = this.f16148a;
        if (gVar != null) {
            gVar.logan_write(i2, str, j2, str2, j3);
        }
    }

    @Override // com.oplus.log.core.g
    public final void setOnLoganProtocolStatus(i iVar) {
        this.f16150c = iVar;
    }
}
