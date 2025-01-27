package cn.vlion.ad.inland.core.feed;

import android.app.Activity;
import android.content.Context;
import cn.vlion.ad.inland.base.adapter.VlionBidderSource;
import cn.vlion.ad.inland.base.adapter.VlionLossReason;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;
import cn.vlion.ad.inland.core.config.VlionSlotConfig;
import cn.vlion.ad.inland.core.s;

/* loaded from: classes.dex */
public class VlionFeedAd {
    private Context context;
    private VlionFeedListener vlionFeedListener;
    private s vlionFeedManager;
    private VlionSlotConfig vlionSlotConfig;

    public VlionFeedAd(Activity activity, VlionSlotConfig vlionSlotConfig) {
        this.context = activity;
        this.vlionSlotConfig = vlionSlotConfig;
    }

    public void destroy() {
        try {
            s sVar = this.vlionFeedManager;
            if (sVar != null) {
                sVar.d();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void loadAd() {
        try {
            s sVar = this.vlionFeedManager;
            if (sVar != null) {
                sVar.d();
            }
            s sVar2 = new s(this.context, this.vlionSlotConfig);
            this.vlionFeedManager = sVar2;
            sVar2.a(this.vlionFeedListener);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void notifyWinPrice(double d10, VlionBidderSource vlionBidderSource) {
        try {
            s sVar = this.vlionFeedManager;
            if (sVar != null) {
                sVar.a(d10, vlionBidderSource);
            } else {
                VlionFeedListener vlionFeedListener = this.vlionFeedListener;
                if (vlionFeedListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_NOT_LOAD_WIN_PRICE_ERROR;
                    vlionFeedListener.onAdRenderFailure(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void notifyWinPriceFailure(double d10, VlionBidderSource vlionBidderSource, VlionLossReason vlionLossReason) {
        try {
            s sVar = this.vlionFeedManager;
            if (sVar != null) {
                sVar.a(d10, vlionBidderSource, vlionLossReason);
            } else {
                LogVlion.e("VlionFeedAd notifyWinPriceFailure ad is not ready");
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setVlionFeedListener(VlionFeedListener vlionFeedListener) {
        this.vlionFeedListener = vlionFeedListener;
    }
}
