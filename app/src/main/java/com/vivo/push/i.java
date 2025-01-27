package com.vivo.push;

/* loaded from: classes4.dex */
final class i implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ e f25058a;

    public i(e eVar) {
        this.f25058a = eVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i10) {
        com.vivo.push.util.b bVar;
        com.vivo.push.util.b bVar2;
        if (i10 != 0) {
            this.f25058a.f25034k = null;
            bVar = this.f25058a.f25033j;
            bVar.b("APP_TOKEN");
        } else {
            this.f25058a.f25034k = "";
            bVar2 = this.f25058a.f25033j;
            bVar2.a("APP_TOKEN", "");
            this.f25058a.m();
            this.f25058a.f25033j.b("APP_TAGS");
        }
    }
}
