package com.kwad.components.offline.api.tk;

/* loaded from: classes3.dex */
public interface IOfflineApkLoadStatusListener {
    void onDownloadFailed();

    void onDownloadFinished();

    void onDownloadStarted();

    void onIdle();

    void onInstalled();

    void onPaused(int i10, long j10, long j11);

    void onProgressUpdate(int i10, long j10, long j11);
}
