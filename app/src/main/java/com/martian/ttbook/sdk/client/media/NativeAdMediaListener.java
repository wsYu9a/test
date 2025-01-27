package com.martian.ttbook.sdk.client.media;

import com.martian.ttbook.sdk.client.AdError;

/* loaded from: classes4.dex */
public interface NativeAdMediaListener {
    void onVideoClicked();

    void onVideoCompleted();

    void onVideoError(AdError adError);

    void onVideoInit();

    void onVideoLoaded(int i2);

    void onVideoLoading();

    void onVideoPause();

    void onVideoReady();

    void onVideoResume();

    void onVideoStart();

    void onVideoStop();
}
