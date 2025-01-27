package cn.vlion.ad.inland.base.adapter;

import android.content.Context;
import android.view.ViewGroup;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;

/* loaded from: classes.dex */
public abstract class VlionBaseAdAdapterSplash extends VlionBaseAdAdapterAdLoad {
    public VlionBaseAdAdapterSplash(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
    }

    public abstract void destroy();

    public abstract int getPrice();

    public abstract void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason);

    public abstract void showAd(ViewGroup viewGroup);
}
