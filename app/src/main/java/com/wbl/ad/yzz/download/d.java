package com.wbl.ad.yzz.download;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a */
    public static final ThreadPoolExecutor f31998a;

    /* renamed from: b */
    @f.b.a.d
    public static final b f31999b = new b(null);

    public static final class a extends ThreadPoolExecutor.DiscardPolicy {
        @Override // java.util.concurrent.ThreadPoolExecutor.DiscardPolicy, java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14773, this, runnable, threadPoolExecutor);
        }
    }

    public static final class b {
        public b() {
        }

        public final boolean a(Runnable runnable) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14776, this, runnable);
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int i2;
        try {
            i2 = Math.max(2, Math.min(((Runtime.getRuntime().availableProcessors() * 2) + 1) - 1, 4));
        } catch (Exception e2) {
            com.wbl.ad.yzz.network.f.f.a("DownloadThreadPool", e2);
            i2 = 2;
        }
        int i3 = i2 < 2 ? 2 : i2;
        f31998a = new ThreadPoolExecutor(i3, (i3 * 2) + 1, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), new a());
    }

    public static final /* synthetic */ ThreadPoolExecutor a() {
        return (ThreadPoolExecutor) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14775, null, null);
    }
}
