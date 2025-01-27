package com.vivo.push.b;

import com.kwai.sodler.lib.ext.PluginError;

/* loaded from: classes4.dex */
public final class b extends c {

    /* renamed from: a */
    private String f30889a;

    /* renamed from: b */
    private String f30890b;

    /* renamed from: c */
    private String f30891c;

    /* renamed from: d */
    private String f30892d;

    /* renamed from: e */
    private boolean f30893e;

    public b(boolean z, String str) {
        super(z ? PluginError.ERROR_UPD_REQUEST : PluginError.ERROR_UPD_NOT_WIFI_DOWNLOAD, str);
        this.f30893e = false;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("sdk_clients", this.f30889a);
        aVar.a("sdk_version", 323L);
        aVar.a("BaseAppCommand.EXTRA_APPID", this.f30891c);
        aVar.a("BaseAppCommand.EXTRA_APPKEY", this.f30890b);
        aVar.a("PUSH_REGID", this.f30892d);
    }

    public final void d() {
        this.f30891c = null;
    }

    public final void e() {
        this.f30890b = null;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final String toString() {
        return "AppCommand:" + b();
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f30889a = aVar.a("sdk_clients");
        this.f30891c = aVar.a("BaseAppCommand.EXTRA_APPID");
        this.f30890b = aVar.a("BaseAppCommand.EXTRA_APPKEY");
        this.f30892d = aVar.a("PUSH_REGID");
    }
}
