package com.baidu.mobads.sdk.internal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class be implements RejectedExecutionHandler {
    be() {
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        ThreadPoolExecutor threadPoolExecutor2;
        ThreadPoolExecutor threadPoolExecutor3;
        LinkedBlockingQueue linkedBlockingQueue;
        ThreadFactory threadFactory;
        av.h("ThreadPoolFactory").e("Exceeded ThreadPoolExecutor pool size");
        synchronized (this) {
            threadPoolExecutor2 = bb.f5575d;
            if (threadPoolExecutor2 == null) {
                LinkedBlockingQueue unused = bb.f5576e = new LinkedBlockingQueue();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                linkedBlockingQueue = bb.f5576e;
                threadFactory = bb.f5577f;
                ThreadPoolExecutor unused2 = bb.f5575d = new ThreadPoolExecutor(2, 2, 60L, timeUnit, linkedBlockingQueue, threadFactory);
            }
        }
        threadPoolExecutor3 = bb.f5575d;
        threadPoolExecutor3.execute(runnable);
    }
}
