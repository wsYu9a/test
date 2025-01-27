package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.view.video.VlionDownloadVideoLayout;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class i3 implements VlionDownloadVideoLayout.d {

    /* renamed from: a */
    public final /* synthetic */ w3 f2942a;

    /* renamed from: b */
    public final /* synthetic */ VlionCustomParseAdData f2943b;

    /* renamed from: c */
    public final /* synthetic */ int f2944c;

    /* renamed from: d */
    public final /* synthetic */ k3 f2945d;

    public i3(k3 k3Var, VlionCustomInterstitialActivity.e eVar, VlionCustomParseAdData vlionCustomParseAdData, boolean z10, int i10) {
        this.f2945d = k3Var;
        this.f2942a = eVar;
        this.f2943b = vlionCustomParseAdData;
        this.f2944c = i10;
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionDownloadVideoLayout.d
    public final void a(VlionADClickType vlionADClickType) {
        w3 w3Var = this.f2942a;
        if (w3Var != null) {
            LogVlion.e("VlionCustomInterstitialActivity onAdViewClick ");
            VlionCustomInterstitialActivity.b(VlionCustomInterstitialActivity.this, vlionADClickType);
        }
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionDownloadVideoLayout.d
    public final void onAdVideoPlayComplete() {
        try {
            w3 w3Var = this.f2942a;
            if (w3Var != null) {
                ((VlionCustomInterstitialActivity.e) w3Var).a();
            }
            this.f2945d.f3026b.c();
            this.f2945d.f3032h.removeAllViews();
            this.f2945d.f3032h.setVisibility(0);
            k3 k3Var = this.f2945d;
            VlionCustomParseAdData vlionCustomParseAdData = this.f2943b;
            int i10 = this.f2944c;
            w3 w3Var2 = this.f2942a;
            k3Var.getClass();
            try {
                k3Var.f3030f.setVisibility(0);
                k3Var.f3030f.a(vlionCustomParseAdData, i10, new l3(k3Var, w3Var2));
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionDownloadVideoLayout.d
    public final void onAdVideoPlaying(int i10, int i11) {
        w3 w3Var = this.f2942a;
        if (w3Var != null) {
            ((VlionCustomInterstitialActivity.e) w3Var).a(i10, i11);
        }
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionDownloadVideoLayout.d
    public final void onAdVideoStart() {
        w3 w3Var = this.f2942a;
        if (w3Var != null) {
            ((VlionCustomInterstitialActivity.e) w3Var).b();
        }
    }
}
