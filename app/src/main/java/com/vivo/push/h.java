package com.vivo.push;

/* loaded from: classes4.dex */
final class h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ com.vivo.push.b.b f31019a;

    /* renamed from: b */
    final /* synthetic */ String f31020b;

    /* renamed from: c */
    final /* synthetic */ e f31021c;

    h(e eVar, com.vivo.push.b.b bVar, String str) {
        this.f31021c = eVar;
        this.f31019a = bVar;
        this.f31020b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f31021c.a(this.f31019a);
        this.f31021c.e(this.f31020b);
    }
}
