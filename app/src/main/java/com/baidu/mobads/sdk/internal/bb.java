package com.baidu.mobads.sdk.internal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class bb {

    /* renamed from: a */
    private static final String f5572a = "ThreadPoolFactory";

    /* renamed from: b */
    private static final int f5573b = 2;

    /* renamed from: c */
    private static final int f5574c = 60;

    /* renamed from: d */
    private static ThreadPoolExecutor f5575d;

    /* renamed from: e */
    private static LinkedBlockingQueue<Runnable> f5576e;

    /* renamed from: f */
    private static final ThreadFactory f5577f = new bc();

    /* renamed from: g */
    private static final RejectedExecutionHandler f5578g = new be();

    public static ThreadPoolExecutor a(int i2, int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f5577f);
        threadPoolExecutor.setRejectedExecutionHandler(f5578g);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static ScheduledThreadPoolExecutor a(int i2) {
        return new ScheduledThreadPoolExecutor(i2, f5577f);
    }
}
