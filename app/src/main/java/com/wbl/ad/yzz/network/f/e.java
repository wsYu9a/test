package com.wbl.ad.yzz.network.f;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes5.dex */
public final class e implements RejectedExecutionHandler {
    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10581, this, runnable, threadPoolExecutor);
    }
}
