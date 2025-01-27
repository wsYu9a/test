package com.vivo.push;

/* loaded from: classes4.dex */
final class i implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ e f31022a;

    i(e eVar) {
        this.f31022a = eVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        com.vivo.push.util.b bVar;
        com.vivo.push.util.b bVar2;
        if (i2 != 0) {
            this.f31022a.k = null;
            bVar = this.f31022a.f31006j;
            bVar.b("APP_TOKEN");
        } else {
            this.f31022a.k = "";
            bVar2 = this.f31022a.f31006j;
            bVar2.a("APP_TOKEN", "");
            this.f31022a.m();
            this.f31022a.f31006j.b("APP_TAGS");
        }
    }
}
