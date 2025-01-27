package com.kwad.sdk.components;

/* loaded from: classes3.dex */
public interface i {
    void onDownloadFailed();

    void onDownloadFinished();

    void onDownloadStarted();

    void onIdle();

    void onInstalled();

    void onPaused(int i10, long j10, long j11);

    void onProgressUpdate(int i10, long j10, long j11);
}
