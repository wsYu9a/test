package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity;
import cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class g3 implements VlionVideoEndCardView.a {

    /* renamed from: a */
    public final /* synthetic */ w3 f2816a;

    /* renamed from: b */
    public final /* synthetic */ f3 f2817b;

    public g3(f3 f3Var, w3 w3Var) {
        this.f2817b = f3Var;
        this.f2816a = w3Var;
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView.a
    public final void a(VlionADClickType vlionADClickType) {
        w3 w3Var = this.f2816a;
        if (w3Var != null) {
            LogVlion.e("VlionCustomInterstitialActivity onAdEndCardButtonClick ");
            VlionCustomInterstitialActivity.a(VlionCustomInterstitialActivity.this, vlionADClickType);
        }
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView.a
    public final void b(VlionADClickType vlionADClickType) {
        w3 w3Var = this.f2816a;
        if (w3Var != null) {
            LogVlion.e("VlionCustomInterstitialActivity onAdEndCardAdClick ");
            VlionCustomInterstitialActivity.b(VlionCustomInterstitialActivity.this, vlionADClickType);
        }
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView.a
    public final void onAdClose() {
        w3 w3Var = this.f2816a;
        if (w3Var != null) {
            ((VlionCustomInterstitialActivity.e) w3Var).a(this.f2817b.f2783b.getCurrent());
        }
    }
}
