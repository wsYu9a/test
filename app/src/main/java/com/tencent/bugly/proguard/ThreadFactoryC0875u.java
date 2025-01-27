package com.tencent.bugly.proguard;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.tencent.bugly.proguard.u */
/* loaded from: classes4.dex */
public class ThreadFactoryC0875u implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ C0876v f22874a;

    public ThreadFactoryC0875u(C0876v c0876v) {
        this.f22874a = c0876v;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("BETA_SDK_DOWNLOAD");
        return thread;
    }
}
