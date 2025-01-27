package com.tencent.bugly.crashreport.biz;

import com.tencent.bugly.proguard.X;

/* loaded from: classes4.dex */
class b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ c f24719a;

    b(c cVar) {
        this.f24719a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f24719a.c();
        } catch (Throwable th) {
            X.b(th);
        }
    }
}
