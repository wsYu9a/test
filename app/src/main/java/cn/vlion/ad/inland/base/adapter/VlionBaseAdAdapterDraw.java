package cn.vlion.ad.inland.base.adapter;

import android.content.Context;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener;

/* loaded from: classes.dex */
public abstract class VlionBaseAdAdapterDraw extends VlionBaseAdAdapterAdLoad {
    public VlionBaseAdAdapterDraw(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener, VlionNativesAdVideoListener vlionNativesAdVideoListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
        setVlionNativesAdVideoListener(vlionNativesAdVideoListener);
    }

    public abstract void destroy();

    public abstract int getPrice();

    public abstract void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason);
}
