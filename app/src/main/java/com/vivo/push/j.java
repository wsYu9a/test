package com.vivo.push;

/* loaded from: classes4.dex */
final class j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ com.vivo.push.b.b f25059a;

    /* renamed from: b */
    final /* synthetic */ String f25060b;

    /* renamed from: c */
    final /* synthetic */ e f25061c;

    public j(e eVar, com.vivo.push.b.b bVar, String str) {
        this.f25061c = eVar;
        this.f25059a = bVar;
        this.f25060b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f25061c.a(this.f25059a);
        this.f25061c.e(this.f25060b);
    }
}
