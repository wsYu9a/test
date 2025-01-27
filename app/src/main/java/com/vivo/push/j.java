package com.vivo.push;

/* loaded from: classes4.dex */
final class j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ com.vivo.push.b.b f31023a;

    /* renamed from: b */
    final /* synthetic */ String f31024b;

    /* renamed from: c */
    final /* synthetic */ e f31025c;

    j(e eVar, com.vivo.push.b.b bVar, String str) {
        this.f31025c = eVar;
        this.f31023a = bVar;
        this.f31024b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f31025c.a(this.f31023a);
        this.f31025c.e(this.f31024b);
    }
}
