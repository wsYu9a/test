package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;

/* loaded from: classes.dex */
public final class w implements c0 {

    /* renamed from: a */
    public final /* synthetic */ u f3795a;

    public w(u uVar) {
        this.f3795a = uVar;
    }

    @Override // cn.vlion.ad.inland.core.c0
    public final void a(double d10) {
        LogVlion.e("VlionLoadAdSourceManager isLoadRewardVideoWaterfall  onAdLoadSuccess bidPrice=" + d10);
        this.f3795a.e();
    }

    @Override // cn.vlion.ad.inland.core.c0
    public final void onAdLoadFailure(VlionAdError vlionAdError) {
        LogVlion.e("VlionLoadAdSourceManager isLoadRewardVideoWaterfall  onAdLoadFailure ");
        this.f3795a.a(vlionAdError);
    }
}
