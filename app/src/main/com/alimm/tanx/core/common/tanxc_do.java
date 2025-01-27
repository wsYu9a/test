package com.alimm.tanx.core.common;

import androidx.annotation.NonNull;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class tanxc_do {
    private static long tanxc_do;
    private static final ThreadPoolExecutor tanxc_if;

    /* renamed from: com.alimm.tanx.core.common.tanxc_do$1 */
    public static class AnonymousClass1 implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, "AdThread-" + tanxc_do.tanxc_do());
        }
    }

    /* renamed from: com.alimm.tanx.core.common.tanxc_do$2 */
    public static class AnonymousClass2 implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 4, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(100), new ThreadFactory() { // from class: com.alimm.tanx.core.common.tanxc_do.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable runnable) {
                return new Thread(runnable, "AdThread-" + tanxc_do.tanxc_do());
            }
        });
        tanxc_if = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() { // from class: com.alimm.tanx.core.common.tanxc_do.2
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
            }
        });
    }

    public static /* synthetic */ long tanxc_do() {
        long j10 = tanxc_do;
        tanxc_do = 1 + j10;
        return j10;
    }

    public static void tanxc_do(@NonNull Runnable runnable) {
        try {
            tanxc_if.execute(runnable);
        } catch (Throwable th2) {
            LogUtils.d("AdThreadPoolExecutor", "post exception", th2);
        }
    }
}
