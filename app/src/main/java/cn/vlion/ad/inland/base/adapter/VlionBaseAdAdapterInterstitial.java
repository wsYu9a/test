package cn.vlion.ad.inland.base.adapter;

import android.app.Activity;
import android.content.Context;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;

/* loaded from: classes.dex */
public abstract class VlionBaseAdAdapterInterstitial extends VlionBaseAdAdapterAdLoad {
    public VlionBaseAdAdapterInterstitial(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
    }

    public abstract void destroy();

    public abstract int getPrice();

    public abstract void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason);

    public abstract void showAd(Activity activity);
}
