package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;

/* loaded from: classes.dex */
public final class z implements c0 {

    /* renamed from: a */
    public final /* synthetic */ u f3804a;

    public z(u uVar) {
        this.f3804a = uVar;
    }

    @Override // cn.vlion.ad.inland.core.c0
    public final void a(double d10) {
        LogVlion.e("VlionLoadAdSourceManager isLoadInterstitialWaterfall  onAdLoadSuccess bidPrice=" + d10);
        this.f3804a.e();
    }

    @Override // cn.vlion.ad.inland.core.c0
    public final void onAdLoadFailure(VlionAdError vlionAdError) {
        LogVlion.e("VlionLoadAdSourceManager isLoadInterstitialWaterfall  onAdLoadFailure ");
        this.f3804a.a(vlionAdError);
    }
}
