package com.kwad.components.offline.api.core.video;

/* loaded from: classes2.dex */
public interface IKsMediaPlayerView {

    public interface VideoViewClickListener {
        void onClickRootView();

        void onClickVideoView();
    }

    void adaptVideoSize(int i2, int i3);

    void fixWidth(boolean z);

    int getTextureViewGravity();

    void setAd(boolean z);

    void setClickListener(VideoViewClickListener videoViewClickListener);

    void setForce(boolean z);

    void setHorizontalVideo(boolean z);

    void setMediaPlayer(IKsMediaPlayer iKsMediaPlayer);

    void setRadius(float f2);

    void updateTextureViewGravity(int i2);
}
