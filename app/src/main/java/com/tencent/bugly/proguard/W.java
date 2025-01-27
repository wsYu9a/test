package com.tencent.bugly.proguard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class W {

    /* renamed from: a */
    private static final AtomicInteger f25015a = new AtomicInteger(1);

    /* renamed from: b */
    private static W f25016b;

    /* renamed from: c */
    private ScheduledExecutorService f25017c;

    protected W() {
        this.f25017c = null;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3, new V(this));
        this.f25017c = newScheduledThreadPool;
        if (newScheduledThreadPool == null || newScheduledThreadPool.isShutdown()) {
            X.e("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    public static synchronized W c() {
        W w;
        synchronized (W.class) {
            if (f25016b == null) {
                f25016b = new W();
            }
            w = f25016b;
        }
        return w;
    }

    public synchronized void b() {
        ScheduledExecutorService scheduledExecutorService = this.f25017c;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            X.a("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.f25017c.shutdownNow();
        }
    }

    public synchronized boolean d() {
        boolean z;
        ScheduledExecutorService scheduledExecutorService = this.f25017c;
        if (scheduledExecutorService != null) {
            z = scheduledExecutorService.isShutdown() ? false : true;
        }
        return z;
    }

    public synchronized boolean a(Runnable runnable, long j2) {
        if (!d()) {
            X.e("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            X.e("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        if (j2 <= 0) {
            j2 = 0;
        }
        X.a("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j2), runnable.getClass().getName());
        try {
            this.f25017c.schedule(runnable, j2, TimeUnit.MILLISECONDS);
            return true;
        } catch (Throwable th) {
            if (com.tencent.bugly.b.f24588c) {
                th.printStackTrace();
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
            this.f25017c.execute(runnable);
            return true;
        } catch (Throwable th) {
            if (com.tencent.bugly.b.f24588c) {
                th.printStackTrace();
            }
            return false;
        }
    }
}
