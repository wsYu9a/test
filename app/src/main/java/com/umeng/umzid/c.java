package com.umeng.umzid;

import android.util.Log;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    public static volatile ScheduledThreadPoolExecutor f26531a;

    /* renamed from: b */
    public static ThreadFactory f26532b = new a();

    public static class a implements ThreadFactory {

        /* renamed from: a */
        public AtomicInteger f26533a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("ZIDThreadPoolExecutor" + this.f26533a.addAndGet(1));
            return thread;
        }
    }

    public static ScheduledThreadPoolExecutor a() {
        if (f26531a == null) {
            synchronized (c.class) {
                if (f26531a == null) {
                    f26531a = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4, f26532b);
                }
            }
        }
        return f26531a;
    }

    public static void a(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Throwable unused) {
            Log.e("com.umeng.umzid.c", "UmengThreadPoolExecutorFactory execute exception");
        }
    }
}
