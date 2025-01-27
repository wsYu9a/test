package com.kwad.components.offline.api.core.adlive.listener;

/* loaded from: classes3.dex */
public interface AdLivePlayStateListener {
    void onLiveAudioEnableChange(boolean z10);

    void onLivePlayCompleted();

    void onLivePlayEnd();

    void onLivePlayPause();

    void onLivePlayProgress(long j10);

    void onLivePlayResume();

    void onLivePlayStart();

    void onLivePrepared();
}
