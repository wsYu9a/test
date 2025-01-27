package com.bytedance.sdk.openadsdk.zx;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class j {
    private static volatile j zx;

    /* renamed from: j */
    private volatile ThreadPoolExecutor f6495j = new ThreadPoolExecutor(3, 3, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0080j(), new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.zx.j.1
        AnonymousClass1() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            com.bytedance.sdk.openadsdk.api.j.g("TTThreadManager", "TTThreadManager rejectedExecution:  ");
        }
    });

    /* renamed from: com.bytedance.sdk.openadsdk.zx.j$1 */
    class AnonymousClass1 implements RejectedExecutionHandler {
        AnonymousClass1() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            com.bytedance.sdk.openadsdk.api.j.g("TTThreadManager", "TTThreadManager rejectedExecution:  ");
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.zx.j$j */
    public static class ThreadFactoryC0080j implements ThreadFactory {

        /* renamed from: i */
        private final String f6497i;

        /* renamed from: j */
        private final ThreadGroup f6498j;
        private final AtomicInteger zx;

        ThreadFactoryC0080j() {
            this("csj_g_pl_mgr");
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f6498j, runnable, this.f6497i + this.zx.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }

        ThreadFactoryC0080j(String str) {
            this.zx = new AtomicInteger(1);
            this.f6498j = new ThreadGroup("csj_g_pl_mgr");
            this.f6497i = str;
        }
    }

    public j() {
        this.f6495j.allowCoreThreadTimeOut(true);
    }

    public static j j() {
        if (zx == null) {
            synchronized (j.class) {
                zx = new j();
            }
        }
        return zx;
    }

    public void j(Runnable runnable) {
        if (runnable != null) {
            try {
                this.f6495j.execute(runnable);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
