package com.tencent.bugly.proguard;

/* renamed from: com.tencent.bugly.proguard.q */
/* loaded from: classes4.dex */
public class RunnableC0872q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0878x f22826a;

    /* renamed from: b */
    final /* synthetic */ r f22827b;

    public RunnableC0872q(r rVar, C0878x c0878x) {
        this.f22827b = rVar;
        this.f22826a = c0878x;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.bugly.beta.global.e.f22100b.Y.onPatchReceived(this.f22826a.a());
    }
}
