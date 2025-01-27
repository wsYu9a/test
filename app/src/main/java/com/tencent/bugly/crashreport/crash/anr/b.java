package com.tencent.bugly.crashreport.crash.anr;

/* loaded from: classes4.dex */
class b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f24810a;

    /* renamed from: b */
    final /* synthetic */ c f24811b;

    b(c cVar, String str) {
        this.f24811b = cVar;
        this.f24810a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f24811b.f24812a.a(this.f24810a);
    }
}
