package cn.vlion.ad.inland.base.bid;

import cn.vlion.ad.inland.base.adapter.VlionBidderSource;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;

/* loaded from: classes.dex */
public interface VlionNativeActionListener {
    void notifyWinPrice(double d10, VlionBidderSource vlionBidderSource);

    void notifyWinPriceFailure(double d10, VlionBidderSource vlionBidderSource, VlionLossBiddingReason vlionLossBiddingReason);

    void onAdRenderFailure(VlionAdBaseError vlionAdBaseError);

    void onAdRenderSuccess();

    void onClick();

    void onClose();

    void onExposure();
}
