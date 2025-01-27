package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;

/* loaded from: classes.dex */
public final class v implements c0 {

    /* renamed from: a */
    public final /* synthetic */ u f3789a;

    public v(u uVar) {
        this.f3789a = uVar;
    }

    @Override // cn.vlion.ad.inland.core.c0
    public final void a(double d10) {
        LogVlion.e("VlionLoadAdSourceManager isLoadNativeWaterfall  onAdLoadSuccess bidPrice=" + d10);
        this.f3789a.e();
    }

    @Override // cn.vlion.ad.inland.core.c0
    public final void onAdLoadFailure(VlionAdError vlionAdError) {
        LogVlion.e("VlionLoadAdSourceManager isLoadNativeWaterfall  onAdLoadFailure ");
        this.f3789a.a(vlionAdError);
    }
}
