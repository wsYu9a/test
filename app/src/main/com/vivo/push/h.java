package com.vivo.push;

/* loaded from: classes4.dex */
final class h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ com.vivo.push.b.b f25055a;

    /* renamed from: b */
    final /* synthetic */ String f25056b;

    /* renamed from: c */
    final /* synthetic */ e f25057c;

    public h(e eVar, com.vivo.push.b.b bVar, String str) {
        this.f25057c = eVar;
        this.f25055a = bVar;
        this.f25056b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f25057c.a(this.f25055a);
        this.f25057c.e(this.f25056b);
    }
}
