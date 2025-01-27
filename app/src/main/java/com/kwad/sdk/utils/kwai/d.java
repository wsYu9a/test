package com.kwad.sdk.utils.kwai;

import com.kwad.sdk.utils.kwai.c;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class d {
    static volatile Executor aCA;
    static ExecutorService aCB = Executors.newSingleThreadExecutor();
    static c.d aCz;

    private d() {
    }

    public static void a(c.d dVar) {
        aCz = dVar;
    }

    static Executor getExecutor() {
        if (aCA == null) {
            synchronized (d.class) {
                if (aCA == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    aCA = threadPoolExecutor;
                }
            }
        }
        return aCA;
    }

    public static void setExecutor(Executor executor) {
        if (executor != null) {
            aCA = executor;
        }
    }
}
