package com.tencent.bugly.beta.upgrade;

/* loaded from: classes4.dex */
public class c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f22147a;

    /* renamed from: b */
    final /* synthetic */ d f22148b;

    public c(d dVar, boolean z10) {
        this.f22148b = dVar;
        this.f22147a = z10;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f22148b.a(this.f22147a);
    }
}
