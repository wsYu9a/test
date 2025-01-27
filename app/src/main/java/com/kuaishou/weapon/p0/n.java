package com.kuaishou.weapon.p0;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static volatile n f9349a = null;

    /* renamed from: b, reason: collision with root package name */
    private static int f9350b = 3;

    /* renamed from: c, reason: collision with root package name */
    private static int f9351c = 6;

    /* renamed from: d, reason: collision with root package name */
    private static ThreadPoolExecutor f9352d;

    private n() {
    }

    public static n a() {
        if (f9349a == null) {
            synchronized (n.class) {
                if (f9349a == null) {
                    f9349a = new n();
                }
                if (f9352d == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f9350b, f9351c, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(10), new RejectedExecutionHandler() { // from class: com.kuaishou.weapon.p0.n.1
                        @Override // java.util.concurrent.RejectedExecutionHandler
                        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                        }
                    });
                    f9352d = threadPoolExecutor;
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f9349a;
    }

    public static n a(int i2, int i3) {
        if (f9349a == null) {
            synchronized (n.class) {
                if (f9349a == null) {
                    f9350b = i2;
                    f9351c = i3;
                    f9349a = new n();
                    if (f9352d == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f9350b, f9351c, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(10), new RejectedExecutionHandler() { // from class: com.kuaishou.weapon.p0.n.2
                            @Override // java.util.concurrent.RejectedExecutionHandler
                            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                            }
                        });
                        f9352d = threadPoolExecutor;
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    }
                }
            }
        }
        return f9349a;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                f9352d.execute(runnable);
            } catch (Exception unused) {
            }
        }
    }
}
