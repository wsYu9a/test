package com.kwad.components.core.offline.init.b;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.video.BaseKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IKsMediaPlayer;
import com.kwad.components.offline.api.core.video.IKsMediaPlayerView;
import com.kwad.sdk.utils.ao;

/* loaded from: classes2.dex */
final class b extends BaseKsMediaPlayerView {
    private DetailVideoView KK;

    /* renamed from: com.kwad.components.core.offline.init.b.b$1 */
    final class AnonymousClass1 implements DetailVideoView.a {
        final /* synthetic */ IKsMediaPlayerView.VideoViewClickListener KL;

        AnonymousClass1(IKsMediaPlayerView.VideoViewClickListener videoViewClickListener) {
            videoViewClickListener = videoViewClickListener;
        }

        @Override // com.kwad.components.core.video.DetailVideoView.a
        public final void onClickRootView() {
            videoViewClickListener.onClickRootView();
        }

        @Override // com.kwad.components.core.video.DetailVideoView.a
        public final void onClickVideoView() {
            videoViewClickListener.onClickVideoView();
        }
    }

    public b(Context context) {
        super(context);
    }

    public final b a(@NonNull DetailVideoView detailVideoView) {
        ao.checkNotNull(detailVideoView);
        addView(detailVideoView);
        this.KK = detailVideoView;
        return this;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void adaptVideoSize(int i2, int i3) {
        this.KK.adaptVideoSize(i2, i3);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void fixWidth(boolean z) {
        this.KK.fixWidth(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final int getTextureViewGravity() {
        return this.KK.getTextureViewGravity();
    }

    public final DetailVideoView nS() {
        return this.KK;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setAd(boolean z) {
        this.KK.setAd(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setClickListener(IKsMediaPlayerView.VideoViewClickListener videoViewClickListener) {
        this.KK.setClickListener(videoViewClickListener == null ? null : new DetailVideoView.a() { // from class: com.kwad.components.core.offline.init.b.b.1
            final /* synthetic */ IKsMediaPlayerView.VideoViewClickListener KL;

            AnonymousClass1(IKsMediaPlayerView.VideoViewClickListener videoViewClickListener2) {
                videoViewClickListener = videoViewClickListener2;
            }

            @Override // com.kwad.components.core.video.DetailVideoView.a
            public final void onClickRootView() {
                videoViewClickListener.onClickRootView();
            }

            @Override // com.kwad.components.core.video.DetailVideoView.a
            public final void onClickVideoView() {
                videoViewClickListener.onClickVideoView();
            }
        });
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setForce(boolean z) {
        this.KK.setForce(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setHorizontalVideo(boolean z) {
        this.KK.setHorizontalVideo(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setMediaPlayer(IKsMediaPlayer iKsMediaPlayer) {
        if (!(iKsMediaPlayer instanceof a)) {
            throw new IllegalArgumentException("mediaPlayer not instanceof KsMediaPlayer");
        }
        this.KK.setMediaPlayer(((a) iKsMediaPlayer).nQ());
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setRadius(float f2) {
        this.KK.setRadius(f2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void updateTextureViewGravity(int i2) {
        this.KK.updateTextureViewGravity(i2);
    }
}
