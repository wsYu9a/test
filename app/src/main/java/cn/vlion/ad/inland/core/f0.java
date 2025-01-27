package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;

/* loaded from: classes.dex */
public final class f0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ boolean f3583a;

    /* renamed from: b */
    public final /* synthetic */ d0 f3584b;

    public f0(d0 d0Var, boolean z10) {
        this.f3584b = d0Var;
        this.f3583a = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StringBuilder a10 = f.a("VlionManagerBase loadTimeOver checkScheduled isServiceTimeOut=");
        a10.append(this.f3583a);
        LogVlion.e(a10.toString());
        if (this.f3583a) {
            u uVar = this.f3584b.f3573a;
            if (uVar != null) {
                uVar.a(true);
                return;
            }
            return;
        }
        d0 d0Var = this.f3584b;
        u uVar2 = d0Var.f3573a;
        if (uVar2 != null) {
            uVar2.a(false);
        } else {
            VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_IS_NOT_FILL_TIME_OUT;
            d0Var.a(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage(), "", ""));
        }
    }
}
