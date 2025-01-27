package com.wbl.ad.yzz.download.h;

import android.os.Handler;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a */
    public Handler f32042a;

    public static final class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Runnable f32043a;

        public a(Runnable runnable) {
            this.f32043a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13868, this, null);
        }
    }

    public final Handler a() {
        return (Handler) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13867, this, null);
    }

    public final void a(boolean z, Runnable runnable) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13862, this, Boolean.valueOf(z), runnable);
    }
}
