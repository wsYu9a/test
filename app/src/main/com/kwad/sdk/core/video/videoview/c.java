package com.kwad.sdk.core.video.videoview;

/* loaded from: classes3.dex */
public interface c {
    boolean HY();

    int getBufferPercentage();

    long getCurrentPosition();

    long getDuration();

    boolean isIdle();

    boolean isPaused();

    void pause();

    void release();

    void restart();

    void setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a aVar);

    void start();
}
