package com.baidu.mobads.sdk.internal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
final class bh implements RejectedExecutionHandler {
    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        ThreadPoolExecutor threadPoolExecutor2;
        ThreadPoolExecutor threadPoolExecutor3;
        LinkedBlockingQueue linkedBlockingQueue;
        ThreadFactory threadFactory;
        ay.h("ThreadPoolFactory").e("Exceeded ThreadPoolExecutor pool size");
        synchronized (this) {
            try {
                threadPoolExecutor2 = be.f6866d;
                if (threadPoolExecutor2 == null) {
                    LinkedBlockingQueue unused = be.f6867e = new LinkedBlockingQueue();
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    linkedBlockingQueue = be.f6867e;
                    threadFactory = be.f6868f;
                    ThreadPoolExecutor unused2 = be.f6866d = new ThreadPoolExecutor(2, 2, 60L, timeUnit, linkedBlockingQueue, threadFactory);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        threadPoolExecutor3 = be.f6866d;
        threadPoolExecutor3.execute(runnable);
    }
}
