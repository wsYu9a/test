package com.tencent.bugly.crashreport.crash.anr;

/* loaded from: classes4.dex */
public class b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f22413a;

    /* renamed from: b */
    final /* synthetic */ c f22414b;

    public b(c cVar, String str) {
        this.f22414b = cVar;
        this.f22413a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f22414b.f22415a.a(this.f22413a);
    }
}
