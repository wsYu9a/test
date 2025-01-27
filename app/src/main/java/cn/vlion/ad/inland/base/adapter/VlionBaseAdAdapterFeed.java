package cn.vlion.ad.inland.base.adapter;

import android.content.Context;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;

/* loaded from: classes.dex */
public abstract class VlionBaseAdAdapterFeed extends VlionBaseAdAdapterAdLoad {
    public VlionBaseAdAdapterFeed(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
    }

    public abstract void destroy();

    public abstract int getPrice();

    public abstract void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason);
}
