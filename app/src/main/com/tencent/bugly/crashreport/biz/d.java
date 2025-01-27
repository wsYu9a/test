package com.tencent.bugly.crashreport.biz;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy;

/* loaded from: classes4.dex */
public class d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f22261a;

    /* renamed from: b */
    final /* synthetic */ BuglyStrategy f22262b;

    public d(Context context, BuglyStrategy buglyStrategy) {
        this.f22261a = context;
        this.f22262b = buglyStrategy;
    }

    @Override // java.lang.Runnable
    public void run() {
        f.c(this.f22261a, this.f22262b);
    }
}
