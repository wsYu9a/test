package com.bytedance.sdk.openadsdk;

/* loaded from: classes2.dex */
public interface TTFeedAd extends TTNativeAd {

    public interface CustomizeVideo {
        String getVideoUrl();

        void reportVideoAutoStart();

        void reportVideoBreak(long j10);

        void reportVideoContinue(long j10);

        void reportVideoError(long j10, int i10, int i11);

        void reportVideoFinish();

        void reportVideoPause(long j10);

        void reportVideoStart();

        void reportVideoStartError(int i10, int i11);
    }

    public interface VideoAdListener {
        void onProgressUpdate(long j10, long j11);

        void onVideoAdComplete(TTFeedAd tTFeedAd);

        void onVideoAdContinuePlay(TTFeedAd tTFeedAd);

        void onVideoAdPaused(TTFeedAd tTFeedAd);

        void onVideoAdStartPlay(TTFeedAd tTFeedAd);

        void onVideoError(int i10, int i11);

        void onVideoLoad(TTFeedAd tTFeedAd);
    }

    public interface VideoRewardListener {
        void onFeedRewardCountDown(int i10);
    }

    int getAdViewHeight();

    int getAdViewWidth();

    CustomizeVideo getCustomVideo();

    double getVideoDuration();

    void setVideoAdListener(VideoAdListener videoAdListener);

    void setVideoRewardListener(VideoRewardListener videoRewardListener);
}
