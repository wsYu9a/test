package cn.vlion.ad.inland.base.bid;

/* loaded from: classes.dex */
public interface VlionBiddingRewardVideoListener {
    void onAdBiddingFailure(int i10, String str);

    void onAdBiddingSuccess(double d10);

    void onAdClick();

    void onAdClose();

    void onAdExposure();

    void onAdPlayFailure(int i10, String str);

    void onAdRenderFailure(int i10, String str);

    void onAdRenderSuccess();

    void onAdReward();

    void onAdShowFailure(int i10, String str);

    void onAdVideoPlayComplete();

    void onAdVideoPlaying(int i10, int i11);

    void onAdVideoSkip();

    void onAdVideoStart();
}
