package com.wbl.ad.yzz.network.f;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a */
    public static final BlockingQueue<Runnable> f33771a;

    /* renamed from: b */
    public static final ThreadPoolExecutor f33772b;

    /* renamed from: c */
    @f.b.a.d
    public static final d f33773c = new d();

    static {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(400);
        f33771a = linkedBlockingQueue;
        f33772b = new ThreadPoolExecutor(4, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE, 5, TimeUnit.SECONDS, linkedBlockingQueue, new e());
    }

    public final void a(Runnable runnable) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10582, this, runnable);
    }
}
