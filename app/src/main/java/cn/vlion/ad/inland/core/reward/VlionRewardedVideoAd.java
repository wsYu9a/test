package cn.vlion.ad.inland.core.reward;

import android.app.Activity;
import android.content.Context;
import cn.vlion.ad.inland.base.adapter.VlionBidderSource;
import cn.vlion.ad.inland.base.adapter.VlionLossReason;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;
import cn.vlion.ad.inland.core.config.VlionSlotConfig;
import cn.vlion.ad.inland.core.h0;

/* loaded from: classes.dex */
public class VlionRewardedVideoAd {
    private Context context;
    private VlionRewardVideoListener vlionRewardVideoListener;
    private h0 vlionRewardVideoManager;
    private VlionSlotConfig vlionSlotConfig;

    public VlionRewardedVideoAd(Context context, VlionSlotConfig vlionSlotConfig) {
        this.context = context;
        this.vlionSlotConfig = vlionSlotConfig;
    }

    public void destroy() {
        try {
            h0 h0Var = this.vlionRewardVideoManager;
            if (h0Var != null) {
                h0Var.d();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void loadAd() {
        try {
            h0 h0Var = this.vlionRewardVideoManager;
            if (h0Var != null) {
                h0Var.d();
            }
            h0 h0Var2 = new h0(this.context, this.vlionSlotConfig);
            this.vlionRewardVideoManager = h0Var2;
            h0Var2.a(this.vlionRewardVideoListener);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void notifyWinPrice(double d10, VlionBidderSource vlionBidderSource) {
        try {
            h0 h0Var = this.vlionRewardVideoManager;
            if (h0Var != null) {
                h0Var.a(d10, vlionBidderSource);
            } else {
                VlionRewardVideoListener vlionRewardVideoListener = this.vlionRewardVideoListener;
                if (vlionRewardVideoListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_NOT_LOAD_WIN_PRICE_ERROR;
                    vlionRewardVideoListener.onAdRenderFailure(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void notifyWinPriceFailure(double d10, VlionBidderSource vlionBidderSource, VlionLossReason vlionLossReason) {
        try {
            h0 h0Var = this.vlionRewardVideoManager;
            if (h0Var != null) {
                h0Var.a(d10, vlionBidderSource, vlionLossReason);
            } else {
                LogVlion.e("VlionRewardedVideoAd notifyWinPriceFailure ad is not ready");
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setVlionRewardVideoListener(VlionRewardVideoListener vlionRewardVideoListener) {
        this.vlionRewardVideoListener = vlionRewardVideoListener;
    }

    public void showAd(Activity activity) {
        try {
            h0 h0Var = this.vlionRewardVideoManager;
            if (h0Var != null) {
                h0Var.a(activity);
            } else {
                VlionRewardVideoListener vlionRewardVideoListener = this.vlionRewardVideoListener;
                if (vlionRewardVideoListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_NOT_LOAD_ERROR;
                    vlionRewardVideoListener.onAdRenderFailure(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
