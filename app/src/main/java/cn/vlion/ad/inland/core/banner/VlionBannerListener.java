package cn.vlion.ad.inland.core.banner;

import cn.vlion.ad.inland.core.config.VlionAdError;

/* loaded from: classes.dex */
public interface VlionBannerListener {
    void onAdClick();

    void onAdClose();

    void onAdExposure();

    void onAdLoadFailure(VlionAdError vlionAdError);

    void onAdLoadSuccess(double d10);

    void onAdRenderFailure(VlionAdError vlionAdError);

    void onAdRenderSuccess();

    void onAdShowFailure(VlionAdError vlionAdError);
}
