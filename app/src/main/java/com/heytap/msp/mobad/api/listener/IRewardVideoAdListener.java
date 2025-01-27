package com.heytap.msp.mobad.api.listener;

/* loaded from: classes.dex */
public interface IRewardVideoAdListener extends IRewardListener {
    void onAdClick(long j2);

    void onAdFailed(int i2, String str);

    @Deprecated
    void onAdFailed(String str);

    void onAdSuccess();

    void onLandingPageClose();

    void onLandingPageOpen();

    void onVideoPlayClose(long j2);

    void onVideoPlayComplete();

    void onVideoPlayError(String str);

    void onVideoPlayStart();
}
