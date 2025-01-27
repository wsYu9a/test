package com.umeng.umzid;

import android.util.Log;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    public static volatile ScheduledThreadPoolExecutor f24898a;

    /* renamed from: b */
    public static ThreadFactory f24899b = new a();

    public static class a implements ThreadFactory {

        /* renamed from: a */
        public AtomicInteger f24900a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("ZIDThreadPoolExecutor" + this.f24900a.addAndGet(1));
            return thread;
        }
    }

    public static ScheduledThreadPoolExecutor a() {
        if (f24898a == null) {
            synchronized (c.class) {
                try {
                    if (f24898a == null) {
                        f24898a = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4, f24899b);
                    }
                } finally {
                }
            }
        }
        return f24898a;
    }

    public static void a(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Throwable unused) {
            Log.e("com.umeng.umzid.c", "UmengThreadPoolExecutorFactory execute exception");
        }
    }
}
