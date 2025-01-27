package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity;
import cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class l3 implements VlionVideoEndCardView.a {

    /* renamed from: a */
    public final /* synthetic */ w3 f3064a;

    /* renamed from: b */
    public final /* synthetic */ k3 f3065b;

    public l3(k3 k3Var, w3 w3Var) {
        this.f3065b = k3Var;
        this.f3064a = w3Var;
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView.a
    public final void a(VlionADClickType vlionADClickType) {
        w3 w3Var = this.f3064a;
        if (w3Var != null) {
            LogVlion.e("VlionCustomInterstitialActivity onAdEndCardButtonClick ");
            VlionCustomInterstitialActivity.a(VlionCustomInterstitialActivity.this, vlionADClickType);
        }
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView.a
    public final void b(VlionADClickType vlionADClickType) {
        w3 w3Var = this.f3064a;
        if (w3Var != null) {
            LogVlion.e("VlionCustomInterstitialActivity onAdEndCardAdClick ");
            VlionCustomInterstitialActivity.b(VlionCustomInterstitialActivity.this, vlionADClickType);
        }
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView.a
    public final void onAdClose() {
        w3 w3Var = this.f3064a;
        if (w3Var != null) {
            ((VlionCustomInterstitialActivity.e) w3Var).a(this.f3065b.f3026b.getCurrent());
        }
    }
}
