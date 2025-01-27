package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;

/* loaded from: classes.dex */
public final class a0 implements c0 {

    /* renamed from: a */
    public final /* synthetic */ u f3554a;

    public a0(u uVar) {
        this.f3554a = uVar;
    }

    @Override // cn.vlion.ad.inland.core.c0
    public final void a(double d10) {
        LogVlion.e("VlionLoadAdSourceManager isLoadSplashWaterfall  onAdLoadSuccess bidPrice=" + d10);
        this.f3554a.e();
    }

    @Override // cn.vlion.ad.inland.core.c0
    public final void onAdLoadFailure(VlionAdError vlionAdError) {
        LogVlion.e("VlionLoadAdSourceManager isLoadSplashWaterfall  onAdLoadFailure ");
        this.f3554a.a(vlionAdError);
    }
}
