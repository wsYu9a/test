package com.tencent.bugly.crashreport.biz;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy;

/* loaded from: classes4.dex */
class d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f24730a;

    /* renamed from: b */
    final /* synthetic */ BuglyStrategy f24731b;

    d(Context context, BuglyStrategy buglyStrategy) {
        this.f24730a = context;
        this.f24731b = buglyStrategy;
    }

    @Override // java.lang.Runnable
    public void run() {
        f.c(this.f24730a, this.f24731b);
    }
}
