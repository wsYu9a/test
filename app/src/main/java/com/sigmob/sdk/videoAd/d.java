package com.sigmob.sdk.videoAd;

import android.os.Handler;
import com.czhj.sdk.common.ThreadPool.RepeatingHandlerRunnable;
import com.czhj.sdk.common.utils.Preconditions;

/* loaded from: classes4.dex */
public class d extends RepeatingHandlerRunnable {

    /* renamed from: a */
    public final n f20416a;

    /* renamed from: b */
    public final a f20417b;

    public d(n nVar, a aVar, Handler handler) {
        super(handler);
        Preconditions.NoThrow.checkNotNull(nVar);
        Preconditions.NoThrow.checkNotNull(aVar);
        this.f20416a = nVar;
        this.f20417b = aVar;
    }

    @Override // com.czhj.sdk.common.ThreadPool.RepeatingHandlerRunnable
    public void doWork() {
    }
}
