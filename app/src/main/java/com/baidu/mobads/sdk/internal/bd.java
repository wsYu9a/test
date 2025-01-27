package com.baidu.mobads.sdk.internal;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class bd {

    /* renamed from: a */
    private static final String f6859a = "TaskScheduler";

    /* renamed from: d */
    private static volatile bd f6860d;

    /* renamed from: b */
    private ThreadPoolExecutor f6861b;

    /* renamed from: c */
    private ScheduledThreadPoolExecutor f6862c;

    private bd() {
        b();
    }

    public static bd a() {
        if (f6860d == null) {
            synchronized (bd.class) {
                try {
                    if (f6860d == null) {
                        f6860d = new bd();
                    }
                } finally {
                }
            }
        }
        return f6860d;
    }

    private void b() {
        this.f6861b = be.a(1, 1);
        this.f6862c = be.a(1);
    }

    public void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor;
        if (runnable == null || (threadPoolExecutor = this.f6861b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            this.f6861b.submit(runnable);
        } catch (Throwable unused) {
        }
    }

    public void a(j jVar) {
        ThreadPoolExecutor threadPoolExecutor;
        if (jVar == null || (threadPoolExecutor = this.f6861b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            jVar.a(System.currentTimeMillis());
            ThreadPoolExecutor threadPoolExecutor2 = this.f6861b;
            jVar.a((Future) ((threadPoolExecutor2 == null || threadPoolExecutor2.isShutdown()) ? null : (FutureTask) this.f6861b.submit(jVar)));
        } catch (Throwable unused) {
        }
    }

    public void a(j jVar, long j10, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (jVar == null || (scheduledThreadPoolExecutor = this.f6862c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            jVar.a(System.currentTimeMillis());
            jVar.a((Future) this.f6862c.schedule(jVar, j10, timeUnit));
        } catch (Throwable unused) {
        }
    }

    public void a(j jVar, long j10, long j11, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (jVar == null || (scheduledThreadPoolExecutor = this.f6862c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            jVar.a(System.currentTimeMillis());
            jVar.a((Future) this.f6862c.scheduleAtFixedRate(jVar, j10, j11, timeUnit));
        } catch (Throwable unused) {
        }
    }
}
