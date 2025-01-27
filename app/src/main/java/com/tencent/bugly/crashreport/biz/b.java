package com.tencent.bugly.crashreport.biz;

import com.tencent.bugly.proguard.X;

/* loaded from: classes4.dex */
public class b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ c f22250a;

    public b(c cVar) {
        this.f22250a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f22250a.c();
        } catch (Throwable th2) {
            X.b(th2);
        }
    }
}
