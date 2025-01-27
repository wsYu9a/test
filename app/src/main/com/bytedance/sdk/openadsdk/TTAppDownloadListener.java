package com.bytedance.sdk.openadsdk;

/* loaded from: classes2.dex */
public interface TTAppDownloadListener {
    void onDownloadActive(long j10, long j11, String str, String str2);

    void onDownloadFailed(long j10, long j11, String str, String str2);

    void onDownloadFinished(long j10, String str, String str2);

    void onDownloadPaused(long j10, long j11, String str, String str2);

    void onIdle();

    void onInstalled(String str, String str2);
}
