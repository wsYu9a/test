package com.alimm.tanx.core.log;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class tanxc_for {
    private static long tanxc_do;
    private static Handler tanxc_for;
    private static final ThreadPoolExecutor tanxc_if;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 8, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(100), new ThreadFactory() { // from class: com.alimm.tanx.core.log.tanxc_for.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable runnable) {
                return new Thread(runnable, "LogLoopThreadPool-" + tanxc_for.tanxc_do());
            }
        });
        tanxc_if = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() { // from class: com.alimm.tanx.core.log.tanxc_for.2
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
            Log.d("LogLoopThreadPool", "ILog :post exception", th2);
        }
    }

    public static void tanxc_do(@NonNull final Runnable runnable, int i10) {
        if (i10 == 0) {
            tanxc_do(runnable);
        } else if (i10 > 0) {
            if (tanxc_for == null) {
                tanxc_for = new Handler(Looper.getMainLooper());
            }
            tanxc_for.postDelayed(new Runnable() { // from class: com.alimm.tanx.core.log.tanxc_for.3
                @Override // java.lang.Runnable
                public void run() {
                    tanxc_for.tanxc_do(runnable);
                }
            }, i10);
        }
    }
}
