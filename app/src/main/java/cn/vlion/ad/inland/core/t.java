package cn.vlion.ad.inland.core;

import android.app.Activity;
import android.view.View;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;
import cn.vlion.ad.inland.core.config.VlionSlotConfig;
import cn.vlion.ad.inland.core.interstitial.VlionInterstitialListener;

/* loaded from: classes.dex */
public final class t extends d0 {

    /* renamed from: h */
    public VlionInterstitialListener f3768h;

    /* renamed from: i */
    public Activity f3769i;

    public class a implements l {
        public a() {
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void a(double d10) {
            LogVlion.e("VlionInterstitialManager onAdBiddingSuccess price=" + d10 + " isFinished=" + t.this.f3576d);
            t.this.b();
            if (t.this.f3768h != null) {
                t.this.f3768h.onAdLoadSuccess(d10);
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdClick() {
            LogVlion.e("VlionInterstitialManager onAdClick ");
            if (t.this.f3768h != null) {
                t.this.f3768h.onAdClick();
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdClose() {
            LogVlion.e("VlionInterstitialManager onAdClose ");
            if (t.this.f3768h != null) {
                t.this.f3768h.onAdClose();
            }
            t.this.d();
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdExposure() {
            LogVlion.e("VlionInterstitialManager onAdExposure ");
            if (t.this.f3768h != null) {
                t.this.f3768h.onAdExposure();
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdRenderFailure(VlionAdError vlionAdError) {
            LogVlion.e("VlionInterstitialManager onAdRenderFailure ");
            if (t.this.f3768h != null) {
                t.this.f3768h.onAdRenderFailure(vlionAdError);
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdRenderSuccess(View view) {
            LogVlion.e("VlionInterstitialManager onAdRenderSuccess ");
            if (t.this.f3768h != null) {
                t.this.f3768h.onAdRenderSuccess();
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdShowFailure(VlionAdError vlionAdError) {
            LogVlion.e("VlionInterstitialManager onAdShowFailure ");
            if (t.this.f3768h != null) {
                t.this.f3768h.onAdShowFailure(vlionAdError);
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdSkip() {
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void a(VlionAdError vlionAdError) {
            StringBuilder a10 = f.a("VlionInterstitialManager onAdBiddingFailure  isFinished=");
            a10.append(t.this.f3576d);
            LogVlion.e(a10.toString());
            t.this.b();
            if (t.this.f3768h != null) {
                t.this.f3768h.onAdLoadFailure(vlionAdError);
            }
        }
    }

    public t(Activity activity, VlionSlotConfig vlionSlotConfig) {
        super(activity);
        try {
            this.f3769i = activity;
            this.f3574b = d.a(vlionSlotConfig, 4);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(Activity activity) {
        try {
            u uVar = this.f3573a;
            if (uVar != null) {
                uVar.a(activity);
            } else {
                VlionInterstitialListener vlionInterstitialListener = this.f3768h;
                if (vlionInterstitialListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_NOT_READY_ERROR;
                    vlionInterstitialListener.onAdRenderFailure(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.core.d0
    public final void d() {
        try {
            super.d();
            if (this.f3768h != null) {
                this.f3768h = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.core.d0
    public final void a(VlionServiceConfig.DataBean.AdBean.PlacementBean placementBean) {
        try {
            Activity activity = this.f3769i;
            if (activity != null) {
                u uVar = new u(activity, this.f3574b, placementBean);
                this.f3573a = uVar;
                uVar.a(new a());
                this.f3573a.i();
                return;
            }
            LogVlion.e("VlionBannerManager onAdBiddingFailure  isFinished=" + this.f3576d);
            b();
            VlionInterstitialListener vlionInterstitialListener = this.f3768h;
            VlionAdBaseError vlionAdBaseError = VlionAdBaseError.LOAD_AD_CONTEXT_IS_NULL;
            vlionInterstitialListener.onAdRenderFailure(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.core.d0
    public final void a(VlionAdError vlionAdError) {
        VlionInterstitialListener vlionInterstitialListener = this.f3768h;
        if (vlionInterstitialListener != null) {
            vlionInterstitialListener.onAdLoadFailure(vlionAdError);
        }
    }

    public final void a(VlionInterstitialListener vlionInterstitialListener) {
        this.f3768h = vlionInterstitialListener;
        try {
            VlionAdError a10 = e.a(this.f3575c, this.f3574b);
            if (a10 == null) {
                e();
            } else if (vlionInterstitialListener != null) {
                vlionInterstitialListener.onAdLoadFailure(a10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
