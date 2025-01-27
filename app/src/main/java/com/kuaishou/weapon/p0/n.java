package com.kuaishou.weapon.p0;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static volatile n f11134a = null;

    /* renamed from: b, reason: collision with root package name */
    private static int f11135b = 3;

    /* renamed from: c, reason: collision with root package name */
    private static int f11136c = 6;

    /* renamed from: d, reason: collision with root package name */
    private static ThreadPoolExecutor f11137d;

    private n() {
    }

    public static n a() {
        if (f11134a == null) {
            synchronized (n.class) {
                try {
                    if (f11134a == null) {
                        f11134a = new n();
                    }
                    if (f11137d == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f11135b, f11136c, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(50), new RejectedExecutionHandler() { // from class: com.kuaishou.weapon.p0.n.1
                            @Override // java.util.concurrent.RejectedExecutionHandler
                            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                            }
                        });
                        f11137d = threadPoolExecutor;
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    }
                } finally {
                }
            }
        }
        return f11134a;
    }

    public static n a(int i10, int i11) {
        if (f11134a == null) {
            synchronized (n.class) {
                try {
                    if (f11134a == null) {
                        f11135b = i10;
                        f11136c = i11;
                        f11134a = new n();
                        if (f11137d == null) {
                            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f11135b, f11136c, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(50), new RejectedExecutionHandler() { // from class: com.kuaishou.weapon.p0.n.2
                                @Override // java.util.concurrent.RejectedExecutionHandler
                                public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                                }
                            });
                            f11137d = threadPoolExecutor;
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                        }
                    }
                } finally {
                }
            }
        }
        return f11134a;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                f11137d.execute(runnable);
            } catch (Exception unused) {
            }
        }
    }
}
