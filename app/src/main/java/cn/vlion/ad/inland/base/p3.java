package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity;
import cn.vlion.ad.inland.ad.view.video.VlionDownloadVideoLayout;
import cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class p3 implements VlionVideoEndCardView.a {

    /* renamed from: a */
    public final /* synthetic */ w3 f3277a;

    /* renamed from: b */
    public final /* synthetic */ o3 f3278b;

    public p3(o3 o3Var, w3 w3Var) {
        this.f3278b = o3Var;
        this.f3277a = w3Var;
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView.a
    public final void a(VlionADClickType vlionADClickType) {
        try {
            w3 w3Var = this.f3277a;
            if (w3Var != null) {
                LogVlion.e("VlionCustomInterstitialActivity onAdEndCardButtonClick ");
                VlionCustomInterstitialActivity.a(VlionCustomInterstitialActivity.this, vlionADClickType);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView.a
    public final void b(VlionADClickType vlionADClickType) {
        try {
            w3 w3Var = this.f3277a;
            if (w3Var != null) {
                LogVlion.e("VlionCustomInterstitialActivity onAdEndCardAdClick ");
                VlionCustomInterstitialActivity.b(VlionCustomInterstitialActivity.this, vlionADClickType);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView.a
    public final void onAdClose() {
        try {
            VlionDownloadVideoLayout vlionDownloadVideoLayout = this.f3278b.f3245b;
            int current = vlionDownloadVideoLayout != null ? vlionDownloadVideoLayout.getCurrent() : 0;
            w3 w3Var = this.f3277a;
            if (w3Var != null) {
                ((VlionCustomInterstitialActivity.e) w3Var).a(current);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
