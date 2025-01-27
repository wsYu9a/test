package com.baidu.mobads.sdk.internal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class be {

    /* renamed from: a */
    private static final String f6863a = "ThreadPoolFactory";

    /* renamed from: b */
    private static final int f6864b = 2;

    /* renamed from: c */
    private static final int f6865c = 60;

    /* renamed from: d */
    private static ThreadPoolExecutor f6866d;

    /* renamed from: e */
    private static LinkedBlockingQueue<Runnable> f6867e;

    /* renamed from: f */
    private static final ThreadFactory f6868f = new bf();

    /* renamed from: g */
    private static final RejectedExecutionHandler f6869g = new bh();

    public static ThreadPoolExecutor a(int i10, int i11) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i10, i11, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f6868f);
        threadPoolExecutor.setRejectedExecutionHandler(f6869g);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static ScheduledThreadPoolExecutor a(int i10) {
        return new ScheduledThreadPoolExecutor(i10, f6868f);
    }
}
