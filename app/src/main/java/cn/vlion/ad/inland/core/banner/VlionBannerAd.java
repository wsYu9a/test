package cn.vlion.ad.inland.core.banner;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import cn.vlion.ad.inland.base.adapter.VlionBidderSource;
import cn.vlion.ad.inland.base.adapter.VlionLossReason;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;
import cn.vlion.ad.inland.core.config.VlionSlotConfig;
import cn.vlion.ad.inland.core.g;
import cn.vlion.ad.inland.core.l;

/* loaded from: classes.dex */
public class VlionBannerAd extends FrameLayout {
    private Activity activity;
    private VlionBannerListener vlionBannerListener;
    private g vlionBannerManager;
    private VlionSlotConfig vlionSlotConfig;

    public class a implements l {
        public a() {
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void a(double d10) {
            if (VlionBannerAd.this.vlionBannerListener != null) {
                VlionBannerAd.this.vlionBannerListener.onAdLoadSuccess(d10);
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdClick() {
            if (VlionBannerAd.this.vlionBannerListener != null) {
                VlionBannerAd.this.vlionBannerListener.onAdClick();
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdClose() {
            VlionBannerAd.this.removeAllViews();
            if (VlionBannerAd.this.vlionBannerListener != null) {
                VlionBannerAd.this.vlionBannerListener.onAdClose();
            }
            VlionBannerAd.this.destroy();
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdExposure() {
            if (VlionBannerAd.this.vlionBannerListener != null) {
                VlionBannerAd.this.vlionBannerListener.onAdExposure();
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdRenderFailure(VlionAdError vlionAdError) {
            if (VlionBannerAd.this.vlionBannerListener != null) {
                VlionBannerAd.this.vlionBannerListener.onAdRenderFailure(vlionAdError);
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdRenderSuccess(View view) {
            try {
                if (VlionBannerAd.this.vlionBannerListener != null) {
                    VlionBannerAd.this.vlionBannerListener.onAdRenderSuccess();
                }
                if (view != null) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
                    VlionBannerAd.this.removeAllViews();
                    view.setLayoutParams(layoutParams);
                    VlionBannerAd.this.addView(view);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdShowFailure(VlionAdError vlionAdError) {
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdSkip() {
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void a(VlionAdError vlionAdError) {
            if (VlionBannerAd.this.vlionBannerListener != null) {
                VlionBannerAd.this.vlionBannerListener.onAdLoadFailure(vlionAdError);
            }
        }
    }

    public VlionBannerAd(Activity activity, VlionSlotConfig vlionSlotConfig) {
        super(activity);
        try {
            this.activity = activity;
            this.vlionSlotConfig = vlionSlotConfig;
            setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void destroy() {
        try {
            g gVar = this.vlionBannerManager;
            if (gVar != null) {
                gVar.d();
                this.vlionBannerManager = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void loadAd() {
        try {
            g gVar = this.vlionBannerManager;
            if (gVar != null) {
                gVar.d();
                this.vlionBannerManager = null;
            }
            g gVar2 = new g(this.activity, this.vlionSlotConfig);
            this.vlionBannerManager = gVar2;
            gVar2.a(new a());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void notifyWinPrice(double d10, VlionBidderSource vlionBidderSource) {
        try {
            g gVar = this.vlionBannerManager;
            if (gVar != null) {
                gVar.a(d10, vlionBidderSource);
            } else {
                VlionBannerListener vlionBannerListener = this.vlionBannerListener;
                if (vlionBannerListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_NOT_LOAD_WIN_PRICE_ERROR;
                    vlionBannerListener.onAdRenderFailure(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void notifyWinPriceFailure(double d10, VlionBidderSource vlionBidderSource, VlionLossReason vlionLossReason) {
        try {
            g gVar = this.vlionBannerManager;
            if (gVar != null) {
                gVar.a(d10, vlionBidderSource, vlionLossReason);
            } else {
                LogVlion.e("VlionBannerAd notifyWinPriceFailure ad is not ready");
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setVlionBannerListener(VlionBannerListener vlionBannerListener) {
        this.vlionBannerListener = vlionBannerListener;
    }
}
