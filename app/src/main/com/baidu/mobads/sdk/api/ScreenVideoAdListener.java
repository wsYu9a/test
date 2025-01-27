package com.baidu.mobads.sdk.api;

/* loaded from: classes2.dex */
public interface ScreenVideoAdListener {
    void onAdClick();

    void onAdClose(float f10);

    void onAdFailed(String str);

    void onAdLoaded();

    void onAdShow();

    void onAdSkip(float f10);

    void onVideoDownloadFailed();

    void onVideoDownloadSuccess();

    void playCompletion();
}
