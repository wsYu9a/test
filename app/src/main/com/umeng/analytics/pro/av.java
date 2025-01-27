package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class av {

    /* renamed from: a */
    private static final String f23469a = "UMExecutor";

    /* renamed from: b */
    private static volatile ScheduledThreadPoolExecutor f23470b;

    /* renamed from: c */
    private static final ThreadFactory f23471c = new ThreadFactory() { // from class: com.umeng.analytics.pro.av.1

        /* renamed from: a */
        private final AtomicInteger f23472a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ccg-" + this.f23472a.incrementAndGet());
        }
    };

    /* renamed from: com.umeng.analytics.pro.av$1 */
    public static class AnonymousClass1 implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f23472a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ccg-" + this.f23472a.incrementAndGet());
        }
    }

    private static ScheduledThreadPoolExecutor a() {
        if (f23470b == null) {
            synchronized (av.class) {
                try {
                    if (f23470b == null) {
                        f23470b = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f23471c);
                        f23470b.setKeepAliveTime(3L, TimeUnit.SECONDS);
                        f23470b.allowCoreThreadTimeOut(true);
                    }
                } finally {
                }
            }
        }
        return f23470b;
    }

    public static void a(Runnable runnable, long j10, TimeUnit timeUnit) {
        try {
            a().schedule(runnable, j10, timeUnit);
        } catch (Throwable th2) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "schedule error:" + th2.getMessage());
        }
    }
}
