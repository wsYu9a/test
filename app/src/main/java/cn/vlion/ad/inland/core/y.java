package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;

/* loaded from: classes.dex */
public final class y implements c0 {

    /* renamed from: a */
    public final /* synthetic */ u f3803a;

    public y(u uVar) {
        this.f3803a = uVar;
    }

    @Override // cn.vlion.ad.inland.core.c0
    public final void a(double d10) {
        LogVlion.e("VlionLoadAdSourceManager isLoadBannerWaterfall  onAdLoadSuccess bidPrice=" + d10);
        this.f3803a.e();
    }

    @Override // cn.vlion.ad.inland.core.c0
    public final void onAdLoadFailure(VlionAdError vlionAdError) {
        LogVlion.e("VlionLoadAdSourceManager isLoadBannerWaterfall  onAdLoadFailure ");
        this.f3803a.a(vlionAdError);
    }
}
