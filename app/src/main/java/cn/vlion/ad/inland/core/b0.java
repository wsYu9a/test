package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;

/* loaded from: classes.dex */
public final class b0 implements c0 {

    /* renamed from: a */
    public final /* synthetic */ u f3571a;

    public b0(u uVar) {
        this.f3571a = uVar;
    }

    @Override // cn.vlion.ad.inland.core.c0
    public final void a(double d10) {
        LogVlion.e("VlionLoadAdSourceManager isLoadFeedWaterfall  onAdLoadSuccess bidPrice=" + d10);
        this.f3571a.e();
    }

    @Override // cn.vlion.ad.inland.core.c0
    public final void onAdLoadFailure(VlionAdError vlionAdError) {
        LogVlion.e("VlionLoadAdSourceManager isLoadFeedWaterfall  onAdLoadFailure ");
        this.f3571a.a(vlionAdError);
    }
}
