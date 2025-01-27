package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.view.video.VlionDownloadVideoLayout;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class m3 implements VlionDownloadVideoLayout.d {

    /* renamed from: a */
    public final /* synthetic */ w3 f3090a;

    /* renamed from: b */
    public final /* synthetic */ VlionCustomParseAdData f3091b;

    /* renamed from: c */
    public final /* synthetic */ int f3092c;

    /* renamed from: d */
    public final /* synthetic */ o3 f3093d;

    public m3(o3 o3Var, VlionCustomInterstitialActivity.e eVar, VlionCustomParseAdData vlionCustomParseAdData, boolean z10, int i10) {
        this.f3093d = o3Var;
        this.f3090a = eVar;
        this.f3091b = vlionCustomParseAdData;
        this.f3092c = i10;
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionDownloadVideoLayout.d
    public final void a(VlionADClickType vlionADClickType) {
        w3 w3Var = this.f3090a;
        if (w3Var != null) {
            LogVlion.e("VlionCustomInterstitialActivity onAdViewClick ");
            VlionCustomInterstitialActivity.b(VlionCustomInterstitialActivity.this, vlionADClickType);
        }
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionDownloadVideoLayout.d
    public final void onAdVideoPlayComplete() {
        try {
            w3 w3Var = this.f3090a;
            if (w3Var != null) {
                ((VlionCustomInterstitialActivity.e) w3Var).a();
            }
            this.f3093d.f3245b.c();
            this.f3093d.f3251h.removeAllViews();
            o3 o3Var = this.f3093d;
            VlionCustomParseAdData vlionCustomParseAdData = this.f3091b;
            int i10 = this.f3092c;
            w3 w3Var2 = this.f3090a;
            o3Var.getClass();
            try {
                o3Var.f3249f.setVisibility(0);
                o3Var.f3249f.a(vlionCustomParseAdData, i10, new p3(o3Var, w3Var2));
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionDownloadVideoLayout.d
    public final void onAdVideoPlaying(int i10, int i11) {
        w3 w3Var = this.f3090a;
        if (w3Var != null) {
            ((VlionCustomInterstitialActivity.e) w3Var).a(i10, i11);
        }
    }

    @Override // cn.vlion.ad.inland.ad.view.video.VlionDownloadVideoLayout.d
    public final void onAdVideoStart() {
        w3 w3Var = this.f3090a;
        if (w3Var != null) {
            ((VlionCustomInterstitialActivity.e) w3Var).b();
        }
    }
}
