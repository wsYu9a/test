package cn.vlion.ad.inland.base.natives;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import cn.vlion.ad.inland.base.adapter.VlionBidderSource;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import java.util.List;

/* loaded from: classes.dex */
public interface VlionNativeAdMaterialListener {
    void destroy();

    View getMediaView();

    void notifyWinPrice(double d10, VlionBidderSource vlionBidderSource);

    void notifyWinPriceFailure(double d10, VlionBidderSource vlionBidderSource, VlionLossBiddingReason vlionLossBiddingReason);

    void onAdRender(Context context, VlionNativeAdData vlionNativeAdData);

    void onNativeAdRenderFailure(VlionAdBaseError vlionAdBaseError);

    void onNativeAdRenderSuccess();

    void registerNativeView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, VlionNativeADEventListener vlionNativeADEventListener);
}
