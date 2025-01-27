package com.vivo.push;

import com.vivo.push.e;

/* loaded from: classes4.dex */
final class g implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ e.a f25053a;

    /* renamed from: b */
    final /* synthetic */ e f25054b;

    public g(e eVar, e.a aVar) {
        this.f25054b = eVar;
        this.f25053a = aVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i10) {
        com.vivo.push.util.b bVar;
        if (i10 != 0) {
            this.f25054b.f25034k = null;
            bVar = this.f25054b.f25033j;
            bVar.b("APP_TOKEN");
        } else {
            Object[] b10 = this.f25053a.b();
            if (b10 == null || b10.length == 0) {
                com.vivo.push.util.p.a("PushClientManager", "bind app result is null");
            } else {
                this.f25054b.a((String) this.f25053a.b()[0]);
            }
        }
    }
}
