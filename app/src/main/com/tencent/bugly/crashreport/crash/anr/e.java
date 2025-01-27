package com.tencent.bugly.crashreport.crash.anr;

/* loaded from: classes4.dex */
public class e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ h f22417a;

    public e(h hVar) {
        this.f22417a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f22417a.d();
    }
}
