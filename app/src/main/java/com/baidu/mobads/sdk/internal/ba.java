package com.baidu.mobads.sdk.internal;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ba {

    /* renamed from: a */
    private static final String f5568a = "TaskScheduler";

    /* renamed from: d */
    private static volatile ba f5569d;

    /* renamed from: b */
    private ThreadPoolExecutor f5570b;

    /* renamed from: c */
    private ScheduledThreadPoolExecutor f5571c;

    private ba() {
        b();
    }

    public static ba a() {
        if (f5569d == null) {
            synchronized (ba.class) {
                if (f5569d == null) {
                    f5569d = new ba();
                }
            }
        }
        return f5569d;
    }

    private void b() {
        this.f5570b = bb.a(1, 1);
        this.f5571c = bb.a(1);
    }

    public void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor;
        if (runnable == null || (threadPoolExecutor = this.f5570b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            this.f5570b.submit(runnable);
        } catch (Throwable unused) {
        }
    }

    public void a(h hVar) {
        ThreadPoolExecutor threadPoolExecutor;
        if (hVar == null || (threadPoolExecutor = this.f5570b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            hVar.a(System.currentTimeMillis());
            FutureTask futureTask = null;
            ThreadPoolExecutor threadPoolExecutor2 = this.f5570b;
            if (threadPoolExecutor2 != null && !threadPoolExecutor2.isShutdown()) {
                futureTask = (FutureTask) this.f5570b.submit(hVar);
            }
            hVar.a((Future) futureTask);
        } catch (Throwable unused) {
        }
    }

    public void a(h hVar, long j2, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (hVar == null || (scheduledThreadPoolExecutor = this.f5571c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            hVar.a(System.currentTimeMillis());
            hVar.a((Future) this.f5571c.schedule(hVar, j2, timeUnit));
        } catch (Throwable unused) {
        }
    }

    public void a(h hVar, long j2, long j3, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (hVar == null || (scheduledThreadPoolExecutor = this.f5571c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            hVar.a(System.currentTimeMillis());
            hVar.a((Future) this.f5571c.scheduleAtFixedRate(hVar, j2, j3, timeUnit));
        } catch (Throwable unused) {
        }
    }
}
