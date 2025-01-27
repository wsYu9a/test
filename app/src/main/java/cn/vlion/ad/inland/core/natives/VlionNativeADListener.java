package cn.vlion.ad.inland.core.natives;

import cn.vlion.ad.inland.base.natives.VlionNativeAdvert;
import cn.vlion.ad.inland.core.config.VlionAdError;

/* loaded from: classes.dex */
public interface VlionNativeADListener {
    void onAdLoadFailure(VlionAdError vlionAdError);

    void onAdLoadSuccess(VlionNativeAdvert vlionNativeAdvert);
}
