package com.kwad.components.core.n.b.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.video.BaseKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IKsMediaPlayer;
import com.kwad.components.offline.api.core.video.IKsMediaPlayerView;
import com.kwad.sdk.utils.au;

/* loaded from: classes3.dex */
final class b extends BaseKsMediaPlayerView {
    private DetailVideoView PD;

    /* renamed from: com.kwad.components.core.n.b.c.b$1 */
    public class AnonymousClass1 implements DetailVideoView.a {
        final /* synthetic */ IKsMediaPlayerView.VideoViewClickListener PE;

        public AnonymousClass1(IKsMediaPlayerView.VideoViewClickListener videoViewClickListener) {
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

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void adaptVideoSize(int i10, int i11) {
        this.PD.adaptVideoSize(i10, i11);
    }

    public final b b(@NonNull DetailVideoView detailVideoView) {
        au.checkNotNull(detailVideoView);
        addView(detailVideoView);
        this.PD = detailVideoView;
        return this;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void fixWidth(boolean z10) {
        this.PD.fixWidth(z10);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final int getTextureViewGravity() {
        return this.PD.getTextureViewGravity();
    }

    public final DetailVideoView pM() {
        return this.PD;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setAd(boolean z10) {
        this.PD.setAd(z10);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setClickListener(IKsMediaPlayerView.VideoViewClickListener videoViewClickListener) {
        this.PD.setClickListener(videoViewClickListener == null ? null : new DetailVideoView.a() { // from class: com.kwad.components.core.n.b.c.b.1
            final /* synthetic */ IKsMediaPlayerView.VideoViewClickListener PE;

            public AnonymousClass1(IKsMediaPlayerView.VideoViewClickListener videoViewClickListener2) {
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
    public final void setForce(boolean z10) {
        this.PD.setForce(z10);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setHorizontalVideo(boolean z10) {
        this.PD.setHorizontalVideo(z10);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setMediaPlayer(IKsMediaPlayer iKsMediaPlayer) {
        if (!(iKsMediaPlayer instanceof a)) {
            throw new IllegalArgumentException("mediaPlayer not instanceof KsMediaPlayer");
        }
        this.PD.setMediaPlayer(((a) iKsMediaPlayer).pK());
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setRadius(float f10) {
        this.PD.setRadius(f10);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void updateTextureViewGravity(int i10) {
        this.PD.updateTextureViewGravity(i10);
    }
}
