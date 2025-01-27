package cn.vlion.ad.inland.core.splash;

import android.content.Context;
import android.view.ViewGroup;
import cn.vlion.ad.inland.base.adapter.VlionBidderSource;
import cn.vlion.ad.inland.base.adapter.VlionLossReason;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;
import cn.vlion.ad.inland.core.config.VlionSlotConfig;
import cn.vlion.ad.inland.core.l0;

/* loaded from: classes.dex */
public class VlionSplashAd {
    private Context context;
    private VlionSlotConfig vlionSlotConfig;
    private VlionSplashListener vlionSplashListener;
    private l0 vlionSplashManager;

    public VlionSplashAd(Context context, VlionSlotConfig vlionSlotConfig) {
        this.context = context;
        this.vlionSlotConfig = vlionSlotConfig;
    }

    public void destroy() {
        try {
            l0 l0Var = this.vlionSplashManager;
            if (l0Var != null) {
                l0Var.d();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void loadAd() {
        try {
            l0 l0Var = this.vlionSplashManager;
            if (l0Var != null) {
                l0Var.d();
            }
            l0 l0Var2 = new l0(this.context, this.vlionSlotConfig);
            this.vlionSplashManager = l0Var2;
            l0Var2.a(this.vlionSplashListener);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void notifyWinPrice(double d10, VlionBidderSource vlionBidderSource) {
        try {
            l0 l0Var = this.vlionSplashManager;
            if (l0Var != null) {
                l0Var.a(d10, vlionBidderSource);
            } else {
                VlionSplashListener vlionSplashListener = this.vlionSplashListener;
                if (vlionSplashListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_NOT_LOAD_WIN_PRICE_ERROR;
                    vlionSplashListener.onAdRenderFailure(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void notifyWinPriceFailure(double d10, VlionBidderSource vlionBidderSource, VlionLossReason vlionLossReason) {
        try {
            l0 l0Var = this.vlionSplashManager;
            if (l0Var != null) {
                l0Var.a(d10, vlionBidderSource, vlionLossReason);
            } else {
                LogVlion.e("VlionSplashAd notifyWinPriceFailure ad is not ready");
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setVlionSplashListener(VlionSplashListener vlionSplashListener) {
        this.vlionSplashListener = vlionSplashListener;
    }

    public void showAd(ViewGroup viewGroup) {
        try {
            l0 l0Var = this.vlionSplashManager;
            if (l0Var != null) {
                l0Var.a(viewGroup);
            } else {
                VlionSplashListener vlionSplashListener = this.vlionSplashListener;
                if (vlionSplashListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_NOT_LOAD_ERROR;
                    vlionSplashListener.onAdRenderFailure(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
