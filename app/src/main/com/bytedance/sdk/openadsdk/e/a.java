package com.bytedance.sdk.openadsdk.e;

import com.bytedance.sdk.openadsdk.api.c;
import com.sigmob.sdk.base.mta.PointCategory;
import hf.e;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a */
    private static volatile a f8181a;

    /* renamed from: b */
    private volatile ExecutorService f8182b;

    /* renamed from: c */
    private volatile ThreadPoolExecutor f8183c;

    /* renamed from: d */
    private volatile ThreadPoolExecutor f8184d;

    /* renamed from: com.bytedance.sdk.openadsdk.e.a$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f8183c != null) {
                try {
                    a aVar = a.this;
                    aVar.a(aVar.f8183c);
                    c.b("ApiThread", "release init pool!");
                } catch (Throwable th2) {
                    c.a("ApiThread", "release mInitExecutor failed", th2);
                }
                a.this.f8183c = null;
            }
            if (a.this.f8184d != null) {
                try {
                    a aVar2 = a.this;
                    aVar2.a(aVar2.f8184d);
                    c.b("ApiThread", "release api pool!");
                } catch (Throwable th3) {
                    c.a("ApiThread", "release mApiExecutor failed", th3);
                }
                a.this.f8184d = null;
            }
        }
    }

    private a() {
    }

    private ExecutorService c() {
        if (this.f8184d == null) {
            this.f8184d = new ThreadPoolExecutor(2, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0241a());
        }
        return this.f8184d;
    }

    public static a a() {
        if (f8181a == null) {
            synchronized (a.class) {
                f8181a = new a();
            }
        }
        return f8181a;
    }

    private ExecutorService b() {
        if (this.f8183c == null) {
            this.f8183c = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0241a(PointCategory.INIT));
        }
        return this.f8183c;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.e.a$a */
    public static class ThreadFactoryC0241a implements ThreadFactory {

        /* renamed from: a */
        private final ThreadGroup f8186a;

        /* renamed from: b */
        private final AtomicInteger f8187b;

        /* renamed from: c */
        private final String f8188c;

        public ThreadFactoryC0241a() {
            this.f8187b = new AtomicInteger(1);
            this.f8186a = new ThreadGroup("csj_api");
            this.f8188c = "csj_api";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f8186a, runnable, this.f8188c + e.f26694a + this.f8187b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 10) {
                thread.setPriority(10);
            }
            return thread;
        }

        public ThreadFactoryC0241a(String str) {
            this.f8187b = new AtomicInteger(1);
            this.f8186a = new ThreadGroup("csj_api");
            this.f8188c = "csj_api_" + str;
        }
    }

    public void b(Runnable runnable) {
        if (runnable != null) {
            try {
                a(false).execute(runnable);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private void b(ExecutorService executorService) {
        executorService.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.e.a.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f8183c != null) {
                    try {
                        a aVar = a.this;
                        aVar.a(aVar.f8183c);
                        c.b("ApiThread", "release init pool!");
                    } catch (Throwable th2) {
                        c.a("ApiThread", "release mInitExecutor failed", th2);
                    }
                    a.this.f8183c = null;
                }
                if (a.this.f8184d != null) {
                    try {
                        a aVar2 = a.this;
                        aVar2.a(aVar2.f8184d);
                        c.b("ApiThread", "release api pool!");
                    } catch (Throwable th3) {
                        c.a("ApiThread", "release mApiExecutor failed", th3);
                    }
                    a.this.f8184d = null;
                }
            }
        });
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                a(true).execute(runnable);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private ExecutorService a(boolean z10) {
        if (this.f8182b == null) {
            return z10 ? b() : c();
        }
        return this.f8182b;
    }

    public void a(ExecutorService executorService) {
        if (executorService != null) {
            this.f8182b = executorService;
            if (this.f8184d == null && this.f8183c == null) {
                return;
            }
            b(executorService);
        }
    }

    public void a(ThreadPoolExecutor threadPoolExecutor) {
        threadPoolExecutor.setKeepAliveTime(1L, TimeUnit.MILLISECONDS);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        while (true) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException unused) {
            }
            if (threadPoolExecutor.getQueue().size() <= 0 && threadPoolExecutor.getActiveCount() == 0) {
                threadPoolExecutor.shutdown();
                return;
            }
        }
    }
}
