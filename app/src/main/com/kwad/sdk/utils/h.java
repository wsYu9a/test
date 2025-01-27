package com.kwad.sdk.utils;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class h {
    private static volatile Executor aSJ;
    private static volatile ScheduledExecutorService aSK;

    public static void execute(Runnable runnable) {
        if (aSJ == null) {
            synchronized (h.class) {
                try {
                    if (aSJ == null) {
                        aSJ = GlobalThreadPools.Hs();
                    }
                } finally {
                }
            }
        }
        aSJ.execute(runnable);
    }

    public static void schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        if (aSK == null) {
            synchronized (h.class) {
                try {
                    if (aSK == null) {
                        aSK = GlobalThreadPools.Ht();
                    }
                } finally {
                }
            }
        }
        aSK.schedule(runnable, j10, timeUnit);
    }
}
