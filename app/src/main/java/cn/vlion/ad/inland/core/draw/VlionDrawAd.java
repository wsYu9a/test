package cn.vlion.ad.inland.core.draw;

import android.app.Activity;
import android.content.Context;
import cn.vlion.ad.inland.base.adapter.VlionBidderSource;
import cn.vlion.ad.inland.base.adapter.VlionLossReason;
import cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;
import cn.vlion.ad.inland.core.config.VlionSlotConfig;
import cn.vlion.ad.inland.core.q;

/* loaded from: classes.dex */
public class VlionDrawAd {
    private Context context;
    private VlionDrawListener vlionDrawListener;
    private q vlionDrawManager;
    private VlionNativesAdVideoListener vlionNativesAdVideoListener;
    private VlionSlotConfig vlionSlotConfig;

    public VlionDrawAd(Activity activity, VlionSlotConfig vlionSlotConfig) {
        this.context = activity;
        this.vlionSlotConfig = vlionSlotConfig;
    }

    public void destroy() {
        try {
            q qVar = this.vlionDrawManager;
            if (qVar != null) {
                qVar.d();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void loadAd() {
        try {
            q qVar = this.vlionDrawManager;
            if (qVar != null) {
                qVar.d();
            }
            q qVar2 = new q(this.context, this.vlionSlotConfig);
            this.vlionDrawManager = qVar2;
            qVar2.a(this.vlionDrawListener, this.vlionNativesAdVideoListener);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void notifyWinPrice(double d10, VlionBidderSource vlionBidderSource) {
        try {
            q qVar = this.vlionDrawManager;
            if (qVar != null) {
                qVar.a(d10, vlionBidderSource);
            } else {
                VlionDrawListener vlionDrawListener = this.vlionDrawListener;
                if (vlionDrawListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_NOT_LOAD_WIN_PRICE_ERROR;
                    vlionDrawListener.onAdRenderFailure(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void notifyWinPriceFailure(double d10, VlionBidderSource vlionBidderSource, VlionLossReason vlionLossReason) {
        try {
            q qVar = this.vlionDrawManager;
            if (qVar != null) {
                qVar.a(d10, vlionBidderSource, vlionLossReason);
            } else {
                LogVlion.e("VlionDrawAd notifyWinPriceFailure ad is not ready");
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setAdVideoListener(VlionNativesAdVideoListener vlionNativesAdVideoListener) {
        try {
            this.vlionNativesAdVideoListener = vlionNativesAdVideoListener;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setVlionDrawListener(VlionDrawListener vlionDrawListener) {
        this.vlionDrawListener = vlionDrawListener;
    }
}
