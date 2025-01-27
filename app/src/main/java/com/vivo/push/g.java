package com.vivo.push;

import com.vivo.push.e;

/* loaded from: classes4.dex */
final class g implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ e.a f31017a;

    /* renamed from: b */
    final /* synthetic */ e f31018b;

    g(e eVar, e.a aVar) {
        this.f31018b = eVar;
        this.f31017a = aVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        com.vivo.push.util.b bVar;
        if (i2 != 0) {
            this.f31018b.k = null;
            bVar = this.f31018b.f31006j;
            bVar.b("APP_TOKEN");
        } else {
            Object[] b2 = this.f31017a.b();
            if (b2 == null || b2.length == 0) {
                com.vivo.push.util.p.a("PushClientManager", "bind app result is null");
            } else {
                this.f31018b.a((String) this.f31017a.b()[0]);
            }
        }
    }
}
