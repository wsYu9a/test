package com.qq.e.ads.nativ;

/* loaded from: classes4.dex */
public interface CustomizeVideo {
    String getVideoUrl();

    void reportVideoCompleted();

    void reportVideoError(long j2, int i2, int i3);

    void reportVideoPause(long j2);

    void reportVideoPreload();

    void reportVideoResume(long j2);

    void reportVideoStart();
}
