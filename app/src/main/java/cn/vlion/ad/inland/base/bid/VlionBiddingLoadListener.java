package cn.vlion.ad.inland.base.bid;

import cn.vlion.ad.inland.base.natives.VlionNativeAdvert;

/* loaded from: classes.dex */
public interface VlionBiddingLoadListener {
    void onAdLoadFailure(int i10, String str);

    void onAdLoadSuccess(double d10);

    void onAdLoadSuccess(VlionNativeAdvert vlionNativeAdvert);
}
