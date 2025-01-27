package cn.vlion.ad.inland.core.interstitial;

import android.app.Activity;
import cn.vlion.ad.inland.base.adapter.VlionBidderSource;
import cn.vlion.ad.inland.base.adapter.VlionLossReason;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;
import cn.vlion.ad.inland.core.config.VlionSlotConfig;
import cn.vlion.ad.inland.core.t;

/* loaded from: classes.dex */
public class VlionInterstitialAd {
    private Activity activity;
    private VlionInterstitialListener vlionInterstitialListener;
    private t vlionInterstitialManager;
    private VlionSlotConfig vlionSlotConfig;

    public VlionInterstitialAd(Activity activity, VlionSlotConfig vlionSlotConfig) {
        this.activity = activity;
        this.vlionSlotConfig = vlionSlotConfig;
    }

    public void destroy() {
        try {
            t tVar = this.vlionInterstitialManager;
            if (tVar != null) {
                tVar.d();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void loadAd() {
        try {
            t tVar = this.vlionInterstitialManager;
            if (tVar != null) {
                tVar.d();
            }
            t tVar2 = new t(this.activity, this.vlionSlotConfig);
            this.vlionInterstitialManager = tVar2;
            tVar2.a(this.vlionInterstitialListener);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void notifyWinPrice(double d10, VlionBidderSource vlionBidderSource) {
        try {
            t tVar = this.vlionInterstitialManager;
            if (tVar != null) {
                tVar.a(d10, vlionBidderSource);
            } else {
                VlionInterstitialListener vlionInterstitialListener = this.vlionInterstitialListener;
                if (vlionInterstitialListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_NOT_LOAD_WIN_PRICE_ERROR;
                    vlionInterstitialListener.onAdRenderFailure(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void notifyWinPriceFailure(double d10, VlionBidderSource vlionBidderSource, VlionLossReason vlionLossReason) {
        try {
            t tVar = this.vlionInterstitialManager;
            if (tVar != null) {
                tVar.a(d10, vlionBidderSource, vlionLossReason);
            } else {
                LogVlion.e("VlionInterstitialAd notifyWinPriceFailure ad is not ready");
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setVlionInterstitialListener(VlionInterstitialListener vlionInterstitialListener) {
        this.vlionInterstitialListener = vlionInterstitialListener;
    }

    public void showAd(Activity activity) {
        try {
            t tVar = this.vlionInterstitialManager;
            if (tVar != null) {
                tVar.a(activity);
            } else {
                VlionInterstitialListener vlionInterstitialListener = this.vlionInterstitialListener;
                if (vlionInterstitialListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_NOT_LOAD_ERROR;
                    vlionInterstitialListener.onAdRenderFailure(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
