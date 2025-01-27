package com.kwad.sdk.utils;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class g {
    private static volatile Executor azg;
    private static volatile ScheduledExecutorService azh;

    public static void execute(Runnable runnable) {
        if (azg == null) {
            synchronized (g.class) {
                if (azg == null) {
                    azg = GlobalThreadPools.xU();
                }
            }
        }
        azg.execute(runnable);
    }

    public static void schedule(Runnable runnable, long j2, TimeUnit timeUnit) {
        if (azh == null) {
            synchronized (g.class) {
                if (azh == null) {
                    azh = GlobalThreadPools.xV();
                }
            }
        }
        azh.schedule(runnable, j2, timeUnit);
    }
}
