package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.view.video.VlionDownloadVideoLayout;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class d3 implements VlionDownloadVideoLayout.d {

    /* renamed from: a */
    public final /* synthetic */ w3 f2703a;

    /* renamed from: b */
    public final /* synthetic */ VlionCustomParseAdData f2704b;

    /* renamed from: c */
    public final /* synthetic */ int f2705c;

    /* renamed from: d */
    public final /* synthetic */ f3 f2706d;

    public d3(f3 f3Var, VlionCustomInterstitialActivity.e eVar, VlionCustomParseAdData vlionCustomParseAdData, boolean z10, int i10) {
        this.f2706d = f3Var;
        this.f2703a = eVar;
        this.f2704b = vlionCustomParseAdData;
        this.f2705c = i10;
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionDownloadVideoLayout.d
    public final void a(VlionADClickType vlionADClickType) {
        w3 w3Var = this.f2703a;
        if (w3Var != null) {
            LogVlion.e("VlionCustomInterstitialActivity onAdViewClick ");
            VlionCustomInterstitialActivity.b(VlionCustomInterstitialActivity.this, vlionADClickType);
        }
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionDownloadVideoLayout.d
    public final void onAdVideoPlayComplete() {
        try {
            w3 w3Var = this.f2703a;
            if (w3Var != null) {
                ((VlionCustomInterstitialActivity.e) w3Var).a();
            }
            this.f2706d.f2783b.c();
            this.f2706d.f2784c.removeAllViews();
            this.f2706d.f2784c.setVisibility(0);
            f3 f3Var = this.f2706d;
            VlionCustomParseAdData vlionCustomParseAdData = this.f2704b;
            int i10 = this.f2705c;
            w3 w3Var2 = this.f2703a;
            f3Var.getClass();
            try {
                f3Var.f2785d.setVisibility(0);
                f3Var.f2785d.a(vlionCustomParseAdData, i10, new g3(f3Var, w3Var2));
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionDownloadVideoLayout.d
    public final void onAdVideoPlaying(int i10, int i11) {
        w3 w3Var = this.f2703a;
        if (w3Var != null) {
            ((VlionCustomInterstitialActivity.e) w3Var).a(i10, i11);
        }
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionDownloadVideoLayout.d
    public final void onAdVideoStart() {
        w3 w3Var = this.f2703a;
        if (w3Var != null) {
            ((VlionCustomInterstitialActivity.e) w3Var).b();
        }
    }
}
