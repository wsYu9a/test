package com.jd.ad.sdk.dl.event;

/* loaded from: classes2.dex */
public interface JADVideoReporter {
    void reportVideoCompleted(float f10);

    void reportVideoError(float f10, int i10, int i11);

    void reportVideoPause(float f10);

    void reportVideoPreloadCompleted();

    void reportVideoResume(float f10);

    void reportVideoStart(float f10);

    void reportVideoWillStart();
}
