package com.tencent.bugly.proguard;

/* renamed from: com.tencent.bugly.proguard.q */
/* loaded from: classes4.dex */
class RunnableC0913q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0919x f25122a;

    /* renamed from: b */
    final /* synthetic */ r f25123b;

    RunnableC0913q(r rVar, C0919x c0919x) {
        this.f25123b = rVar;
        this.f25122a = c0919x;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.bugly.beta.global.e.f24621b.Y.onPatchReceived(this.f25122a.a());
    }
}
