package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;

/* loaded from: classes.dex */
public final class x implements c0 {

    /* renamed from: a */
    public final /* synthetic */ u f3802a;

    public x(u uVar) {
        this.f3802a = uVar;
    }

    @Override // cn.vlion.ad.inland.core.c0
    public final void a(double d10) {
        LogVlion.e("VlionLoadAdSourceManager isLoadDrawWaterfall  onAdLoadSuccess bidPrice=" + d10);
        this.f3802a.e();
    }

    @Override // cn.vlion.ad.inland.core.c0
    public final void onAdLoadFailure(VlionAdError vlionAdError) {
        LogVlion.e("VlionLoadAdSourceManager isLoadDrawWaterfall  onAdLoadFailure ");
        this.f3802a.a(vlionAdError);
    }
}
