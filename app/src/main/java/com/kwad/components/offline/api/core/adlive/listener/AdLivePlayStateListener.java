package com.kwad.components.offline.api.core.adlive.listener;

/* loaded from: classes2.dex */
public interface AdLivePlayStateListener {
    void onLiveAudioEnableChange(boolean z);

    void onLivePlayCompleted();

    void onLivePlayEnd();

    void onLivePlayPause();

    void onLivePlayProgress(long j2);

    void onLivePlayResume();

    void onLivePlayStart();

    void onLivePrepared();
}
