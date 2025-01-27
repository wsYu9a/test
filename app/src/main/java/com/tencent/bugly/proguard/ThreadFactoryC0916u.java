package com.tencent.bugly.proguard;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.tencent.bugly.proguard.u */
/* loaded from: classes4.dex */
class ThreadFactoryC0916u implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ C0917v f25165a;

    ThreadFactoryC0916u(C0917v c0917v) {
        this.f25165a = c0917v;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("BETA_SDK_DOWNLOAD");
        return thread;
    }
}
