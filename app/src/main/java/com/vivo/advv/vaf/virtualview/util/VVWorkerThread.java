package com.vivo.advv.vaf.virtualview.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: classes4.dex */
public class VVWorkerThread {
    private static ExecutorService sExecutorService = Executors.newCachedThreadPool();

    private VVWorkerThread() {
    }

    public static void runOnExecutor(Runnable runnable) {
        sExecutorService.execute(runnable);
    }

    public static <T> Future<T> submitOnExecutor(Callable<T> callable) {
        return sExecutorService.submit(callable);
    }
}
