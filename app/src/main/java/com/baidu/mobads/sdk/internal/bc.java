package com.baidu.mobads.sdk.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
final class bc implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f5579a = new AtomicInteger(1);

    bc() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "TaskScheduler #" + this.f5579a.getAndIncrement());
        thread.setUncaughtExceptionHandler(new bd(this));
        return thread;
    }
}
