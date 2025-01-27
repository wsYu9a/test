package com.baidu.mobads.sdk.internal;

import java.lang.Thread;

/* loaded from: classes.dex */
class bd implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    final /* synthetic */ bc f5580a;

    bd(bc bcVar) {
        this.f5580a = bcVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        av.h("ThreadPoolFactory").c("线程名字=" + thread.getName() + "线程crash信息", th);
    }
}
