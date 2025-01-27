package com.tencent.bugly.beta.upgrade;

/* loaded from: classes4.dex */
class c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f24646a;

    /* renamed from: b */
    final /* synthetic */ d f24647b;

    c(d dVar, boolean z) {
        this.f24647b = dVar;
        this.f24646a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f24647b.a(this.f24646a);
    }
}
