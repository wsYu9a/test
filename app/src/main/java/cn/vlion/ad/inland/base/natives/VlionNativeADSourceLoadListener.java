package cn.vlion.ad.inland.base.natives;

import cn.vlion.ad.inland.base.adapter.VlionBidderSource;
import cn.vlion.ad.inland.base.adapter.VlionLossReason;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;

/* loaded from: classes.dex */
public interface VlionNativeADSourceLoadListener extends VlionNativeADSourceListener, VlionNativeADEventListener {
    void notifyWinPrice(double d10, VlionBidderSource vlionBidderSource);

    void notifyWinPriceFailure(double d10, VlionBidderSource vlionBidderSource, VlionLossReason vlionLossReason);

    void onAdRenderFailure(VlionAdBaseError vlionAdBaseError);

    void onAdRenderSuccess();
}
