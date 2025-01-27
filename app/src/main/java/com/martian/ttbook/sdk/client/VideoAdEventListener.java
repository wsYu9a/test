package com.martian.ttbook.sdk.client;

/* loaded from: classes4.dex */
public interface VideoAdEventListener {
    void onVideoComplete();

    void onVideoError(AdError adError);

    void onVideoInit();

    void onVideoLoading();

    void onVideoPageClose();

    void onVideoPageOpen();

    void onVideoPause();

    void onVideoReady(long j2);

    void onVideoStart();
}
