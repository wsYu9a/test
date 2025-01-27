package com.baidu.mobads.sdk.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
final class bf implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f6870a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "TaskScheduler #" + this.f6870a.getAndIncrement());
        thread.setUncaughtExceptionHandler(new bg(this));
        return thread;
    }
}
