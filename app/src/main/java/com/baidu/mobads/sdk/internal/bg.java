package com.baidu.mobads.sdk.internal;

import java.lang.Thread;

/* loaded from: classes2.dex */
class bg implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    final /* synthetic */ bf f6871a;

    public bg(bf bfVar) {
        this.f6871a = bfVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        ay.h("ThreadPoolFactory").c("线程名字=" + thread.getName() + "线程crash信息", th2);
    }
}
