package com.tencent.bugly.proguard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class W {

    /* renamed from: a */
    private static final AtomicInteger f22675a = new AtomicInteger(1);

    /* renamed from: b */
    private static W f22676b;

    /* renamed from: c */
    private ScheduledExecutorService f22677c;

    public W() {
        this.f22677c = null;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3, new V(this));
        this.f22677c = newScheduledThreadPool;
        if (newScheduledThreadPool == null || newScheduledThreadPool.isShutdown()) {
            X.e("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    public static synchronized W c() {
        W w10;
        synchronized (W.class) {
            try {
                if (f22676b == null) {
                    f22676b = new W();
                }
                w10 = f22676b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return w10;
    }

    public synchronized void b() {
        ScheduledExecutorService scheduledExecutorService = this.f22677c;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            X.a("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.f22677c.shutdownNow();
        }
    }

    public synchronized boolean d() {
        boolean z10;
        ScheduledExecutorService scheduledExecutorService = this.f22677c;
        if (scheduledExecutorService != null) {
            z10 = scheduledExecutorService.isShutdown() ? false : true;
        }
        return z10;
    }

    public synchronized boolean a(Runnable runnable, long j10) {
        if (!d()) {
            X.e("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            X.e("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        if (j10 <= 0) {
            j10 = 0;
        }
        X.a("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j10), runnable.getClass().getName());
        try {
            this.f22677c.schedule(runnable, j10, TimeUnit.MILLISECONDS);
            return true;
        } catch (Throwable th2) {
            if (com.tencent.bugly.b.f22066c) {
                th2.printStackTrace();
            }
            return false;
        }
    }

    public synchronized boolean a(Runnable runnable) {
        if (!d()) {
            X.e("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            X.e("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        X.a("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
        try {
            this.f22677c.execute(runnable);
            return true;
        } catch (Throwable th2) {
            if (com.tencent.bugly.b.f22066c) {
                th2.printStackTrace();
            }
            return false;
        }
    }
}
