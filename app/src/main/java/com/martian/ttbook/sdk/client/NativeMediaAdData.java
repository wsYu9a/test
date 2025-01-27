package com.martian.ttbook.sdk.client;

import android.view.View;
import com.martian.ttbook.sdk.client.media.MediaAdView;
import com.martian.ttbook.sdk.client.media.NativeAdMediaListener;

/* loaded from: classes4.dex */
public interface NativeMediaAdData {
    void bindMediaView(MediaAdView mediaAdView, VideoSettings videoSettings, NativeAdMediaListener nativeAdMediaListener);

    void bindMediaView(MediaAdView mediaAdView, NativeAdMediaListener nativeAdMediaListener);

    int getAppStatus();

    int getMediaHeight();

    int getMediaWidth();

    int getVideoCurrentPosition();

    int getVideoDuration();

    boolean isBindedMediaView();

    boolean isVideoAd();

    boolean isVideoAdExposured();

    void onVideoAdExposured(View view);

    void pauseAppDownload();

    void pauseVideo();

    void resumeAppDownload();

    void resumeVideo();

    void setVideoMute(boolean z);

    void startVideo();

    void stopVideo();
}
