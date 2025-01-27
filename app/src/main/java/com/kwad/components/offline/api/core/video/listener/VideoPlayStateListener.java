package com.kwad.components.offline.api.core.video.listener;

/* loaded from: classes2.dex */
public interface VideoPlayStateListener {
    void onVideoPlayBufferingPaused();

    void onVideoPlayBufferingPlaying();

    void onVideoPlayCompleted();

    void onVideoPlayError(int i2, int i3);

    void onVideoPlayPaused();

    void onVideoPlayProgress(long j2, long j3);

    void onVideoPlayStart();

    void onVideoPlaying();

    void onVideoPrepared();

    void onVideoPreparing();
}
