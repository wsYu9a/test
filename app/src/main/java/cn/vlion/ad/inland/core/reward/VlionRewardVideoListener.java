package cn.vlion.ad.inland.core.reward;

import cn.vlion.ad.inland.core.config.VlionAdError;

/* loaded from: classes.dex */
public interface VlionRewardVideoListener {
    void onAdClick();

    void onAdClose();

    void onAdExposure();

    void onAdLoadFailure(VlionAdError vlionAdError);

    void onAdLoadSuccess(double d10);

    void onAdPlayFailure(VlionAdError vlionAdError);

    void onAdRenderFailure(VlionAdError vlionAdError);

    void onAdRenderSuccess();

    void onAdReward();

    void onAdShowFailure(VlionAdError vlionAdError);

    void onAdVideoSkip();

    void onVideoCompleted();

    void onVideoStart();
}
