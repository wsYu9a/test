package cn.vlion.ad.inland.core.interstitial;

import cn.vlion.ad.inland.core.config.VlionAdError;

/* loaded from: classes.dex */
public interface VlionInterstitialListener {
    void onAdClick();

    void onAdClose();

    void onAdExposure();

    void onAdLoadFailure(VlionAdError vlionAdError);

    void onAdLoadSuccess(double d10);

    void onAdRenderFailure(VlionAdError vlionAdError);

    void onAdRenderSuccess();

    void onAdShowFailure(VlionAdError vlionAdError);
}
