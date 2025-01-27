package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.reward.VlionRewardVideoActivity;
import cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class z5 implements VlionVideoEndCardView.a {

    /* renamed from: a */
    public final /* synthetic */ VlionRewardVideoActivity f3549a;

    public z5(VlionRewardVideoActivity vlionRewardVideoActivity) {
        this.f3549a = vlionRewardVideoActivity;
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView.a
    public final void a(VlionADClickType vlionADClickType) {
        LogVlion.e("VlionRewardVideoActivity addEndCard onAdEndCardButtonClick------------");
        VlionRewardVideoActivity.a(this.f3549a, vlionADClickType);
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView.a
    public final void b(VlionADClickType vlionADClickType) {
        LogVlion.e("VlionRewardVideoActivity addEndCard onAdEndCardAdClick------------");
        VlionRewardVideoActivity.b(this.f3549a, vlionADClickType);
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView.a
    public final void onAdClose() {
        this.f3549a.finish();
    }
}
