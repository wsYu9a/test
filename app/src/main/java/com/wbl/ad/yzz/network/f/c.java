package com.wbl.ad.yzz.network.f;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a */
    public static final BlockingQueue<Runnable> f33768a;

    /* renamed from: b */
    public static final ThreadPoolExecutor f33769b;

    /* renamed from: c */
    @f.b.a.d
    public static final c f33770c = new c();

    static {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(400);
        f33768a = linkedBlockingQueue;
        f33769b = new ThreadPoolExecutor(4, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE, 5, TimeUnit.SECONDS, linkedBlockingQueue, new e());
    }

    public final void a(Runnable runnable) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10587, this, runnable);
    }
}
