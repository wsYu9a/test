package com.kwai.filedownloader.e;

import com.kwad.sdk.service.ServiceProvider;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class b {
    private static volatile ThreadPoolExecutor aJn;

    static class a implements ThreadFactory {
        private static final AtomicInteger aJo = new AtomicInteger(1);
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group = Thread.currentThread().getThreadGroup();

        a(String str) {
            this.namePrefix = f.fE(str);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, "ksad-" + this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    private static ThreadPoolExecutor IY() {
        if (aJn == null) {
            synchronized (b.class) {
                if (aJn == null) {
                    com.kwad.sdk.core.threads.kwai.b bVar = new com.kwad.sdk.core.threads.kwai.b(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(""));
                    aJn = bVar;
                    com.kwad.sdk.core.threads.c.a(bVar, "ksad-filedownload-default");
                }
            }
        }
        return aJn;
    }

    @Deprecated
    public static ThreadPoolExecutor a(int i2, LinkedBlockingQueue<Runnable> linkedBlockingQueue, String str) {
        if (sL()) {
            return IY();
        }
        com.kwad.sdk.core.threads.kwai.b bVar = new com.kwad.sdk.core.threads.kwai.b(i2, i2, 15L, TimeUnit.SECONDS, linkedBlockingQueue, new a(str));
        com.kwad.sdk.core.threads.c.a(bVar, "ksad-" + str);
        bVar.allowCoreThreadTimeOut(true);
        return bVar;
    }

    @Deprecated
    public static ThreadPoolExecutor fy(String str) {
        if (sL()) {
            return IY();
        }
        com.kwad.sdk.core.threads.kwai.b bVar = new com.kwad.sdk.core.threads.kwai.b(0, Integer.MAX_VALUE, 15L, TimeUnit.SECONDS, new SynchronousQueue(), new a(str));
        com.kwad.sdk.core.threads.c.a(bVar, "ksad-" + str);
        return bVar;
    }

    @Deprecated
    public static ThreadPoolExecutor n(int i2, String str) {
        return sL() ? IY() : a(i2, new LinkedBlockingQueue(), str);
    }

    private static boolean sL() {
        com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class);
        if (fVar != null) {
            return fVar.sL();
        }
        return false;
    }
}
