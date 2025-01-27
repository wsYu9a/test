package com.kwad.sdk.utils.a;

import com.kwad.sdk.utils.a.c;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class d {
    static c.d aWJ;
    static volatile Executor aWK;
    static ExecutorService aWL = Executors.newSingleThreadExecutor();

    private d() {
    }

    public static void a(c.d dVar) {
        aWJ = dVar;
    }

    public static Executor getExecutor() {
        if (aWK == null) {
            synchronized (d.class) {
                try {
                    if (aWK == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        aWK = threadPoolExecutor;
                    }
                } finally {
                }
            }
        }
        return aWK;
    }

    public static void setExecutor(Executor executor) {
        if (executor != null) {
            aWK = executor;
        }
    }
}
