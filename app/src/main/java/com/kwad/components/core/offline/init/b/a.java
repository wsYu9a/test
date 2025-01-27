package com.kwad.components.core.offline.init.b;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.components.offline.api.core.video.IKsMediaPlayer;
import com.kwad.components.offline.api.core.video.IKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IMediaPlayer;
import com.kwad.components.offline.api.core.video.listener.ReleaseCallback;
import com.kwad.components.offline.api.core.video.listener.VideoMuteStateChangeListener;
import com.kwad.components.offline.api.core.video.listener.VideoPlayStateListener;
import com.kwad.components.offline.api.core.video.mdoel.KsPlayerLogParams;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bi;

/* loaded from: classes2.dex */
final class a implements IKsMediaPlayer {
    private com.kwad.components.core.video.b KE;
    private c KF;
    private VideoMuteStateChangeListener KG;
    private boolean KH;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private boolean nJ = true;
    private OfflineOnAudioConflictListener xB;
    private boolean xy;

    /* renamed from: com.kwad.components.core.offline.init.b.a$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ boolean pU;

        AnonymousClass1(boolean z) {
            z = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.KE.setAudioEnabled(z);
            if (a.this.KG != null) {
                a.this.KG.onMuteStateChanged(!z);
            }
        }
    }

    /* renamed from: com.kwad.components.core.offline.init.b.a$2 */
    final class AnonymousClass2 implements OfflineOnAudioConflictListener {

        /* renamed from: com.kwad.components.core.offline.init.b.a$2$1 */
        final class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.this.KE.setAudioEnabled(false);
                if (a.this.KG != null) {
                    a.this.KG.onMuteStateChanged(true);
                }
            }
        }

        AnonymousClass2() {
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            a.a(a.this, true);
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.offline.init.b.a.2.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a.this.KE.setAudioEnabled(false);
                    if (a.this.KG != null) {
                        a.this.KG.onMuteStateChanged(true);
                    }
                }
            });
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
        }
    }

    a() {
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.xy = true;
        return true;
    }

    private OfflineOnAudioConflictListener nR() {
        if (this.xB == null) {
            this.xB = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.offline.init.b.a.2

                /* renamed from: com.kwad.components.core.offline.init.b.a$2$1 */
                final class AnonymousClass1 implements Runnable {
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.KE.setAudioEnabled(false);
                        if (a.this.KG != null) {
                            a.this.KG.onMuteStateChanged(true);
                        }
                    }
                }

                AnonymousClass2() {
                }

                @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
                public final void onAudioBeOccupied() {
                    a.a(a.this, true);
                    bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.offline.init.b.a.2.1
                        AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.KE.setAudioEnabled(false);
                            if (a.this.KG != null) {
                                a.this.KG.onMuteStateChanged(true);
                            }
                        }
                    });
                }

                @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
                public final void onAudioBeReleased() {
                }
            };
        }
        return this.xB;
    }

    public final a a(@NonNull com.kwad.components.core.video.b bVar) {
        ao.checkNotNull(bVar);
        this.KE = bVar;
        return this;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void addOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.KE.a(d.a(getMediaPlayer(), onInfoListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void addOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.KE.a(d.a(getMediaPlayer(), onPreparedListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void clear() {
        this.KE.clear();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getBufferPercentage() {
        return this.KE.getBufferPercentage();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final String getCurrentPlayingUrl() {
        return this.KE.getCurrentPlayingUrl();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final long getCurrentPosition() {
        return this.KE.getCurrentPosition();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final long getDuration() {
        return this.KE.getDuration();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getMaxVolume() {
        return 0;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final IMediaPlayer getMediaPlayer() {
        com.kwad.sdk.core.video.kwai.c qe = this.KE.qe();
        if (qe == null) {
            return null;
        }
        c cVar = this.KF;
        if (cVar == null || cVar.nT() != qe) {
            this.KF = new c().b(qe);
        }
        return this.KF;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getMediaPlayerType() {
        return this.KE.getMediaPlayerType();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final long getPlayDuration() {
        return this.KE.getPlayDuration();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final String getStateString(int i2) {
        return com.kwad.components.core.video.b.getStateString(i2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getVideoHeight() {
        return this.KE.getVideoHeight();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getVideoWidth() {
        return this.KE.getVideoWidth();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getVolume() {
        return 0;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void initMediaPlayer(@NonNull PlayVideoInfo playVideoInfo, @NonNull IKsMediaPlayerView iKsMediaPlayerView) {
        if (!(iKsMediaPlayerView instanceof b)) {
            com.kwad.sdk.core.d.b.e("KsMediaPlayer", "videoView not instanceof KsMediaPlayerView");
            return;
        }
        DetailVideoView nS = ((b) iKsMediaPlayerView).nS();
        this.mDetailVideoView = nS;
        this.mContext = nS.getContext().getApplicationContext();
        this.KE.a(d.a(playVideoInfo), this.mDetailVideoView);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void initMediaPlayer(@NonNull PlayVideoInfo playVideoInfo, boolean z, boolean z2, @NonNull IKsMediaPlayerView iKsMediaPlayerView) {
        if (iKsMediaPlayerView instanceof b) {
            this.KE.a(d.a(playVideoInfo), z, z2, ((b) iKsMediaPlayerView).nS());
        } else {
            com.kwad.sdk.core.d.b.e("KsMediaPlayer", "videoView not instanceof KsMediaPlayerView");
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean isPlaying() {
        return this.KE.isPlaying();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean isPrepared() {
        return this.KE.isPrepared();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean isPreparing() {
        return this.KE.isPreparing();
    }

    public final com.kwad.components.core.video.b nQ() {
        return this.KE;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void notifyOnInfoListener(IMediaPlayer iMediaPlayer, int i2, int i3) {
        if (iMediaPlayer instanceof c) {
            this.KE.a(((c) iMediaPlayer).nT(), i2, i3);
        } else {
            com.kwad.sdk.core.d.b.e("KsMediaPlayer", "videoView not instanceof KsMediaPlayerView");
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void onPlayStateChanged(int i2) {
        this.KE.onPlayStateChanged(i2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean pause() {
        return this.KE.pause();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void prepareAsync() {
        this.KE.prepareAsync();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void registerVideoMuteStateListener(VideoMuteStateChangeListener videoMuteStateChangeListener) {
        this.KG = videoMuteStateChangeListener;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void registerVideoPlayStateListener(VideoPlayStateListener videoPlayStateListener) {
        this.KE.c(d.a(videoPlayStateListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void release() {
        this.KE.release();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void release(ReleaseCallback releaseCallback) {
        this.KE.a(d.a(releaseCallback));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void release(ReleaseCallback releaseCallback, boolean z) {
        this.KE.a(d.a(releaseCallback), z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void releaseSync() {
        this.KE.releaseSync();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void removeInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.KE.b(d.a(getMediaPlayer(), onInfoListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void resetAndPlay(PlayVideoInfo playVideoInfo) {
        com.kwad.components.core.video.b bVar = this.KE;
        d.a(playVideoInfo);
        bVar.qh();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void restart() {
        this.KE.restart();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void resume() {
        this.KE.resume();
        if (this.nJ || (this.KH && this.xy)) {
            com.kwad.components.core.r.a.aj(this.mContext).aL(this.KH);
            if (this.KH && this.xy) {
                this.xy = false;
                setAudioEnabled(true);
                this.nJ = true;
            } else if (com.kwad.components.core.r.a.aj(this.mContext).pI()) {
                this.nJ = false;
                setAudioEnabled(false);
            }
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void seekTo(long j2) {
        this.KE.seekTo(j2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setAudioEnabled(boolean z) {
        if (z) {
            com.kwad.components.core.r.a.aj(this.mContext).aL(true);
        }
        if (z == this.nJ) {
            com.kwad.sdk.core.video.kwai.kwai.a.cN("autoVoice");
        } else {
            this.nJ = z;
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.offline.init.b.a.1
                final /* synthetic */ boolean pU;

                AnonymousClass1(boolean z2) {
                    z = z2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a.this.KE.setAudioEnabled(z);
                    if (a.this.KG != null) {
                        a.this.KG.onMuteStateChanged(!z);
                    }
                }
            });
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setDataSource(@NonNull PlayVideoInfo playVideoInfo) {
        this.KE.a(d.a(playVideoInfo));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setForceGetAudioFocus(boolean z) {
        this.KH = z;
        Context context = this.mContext;
        if (context != null) {
            com.kwad.components.core.r.a.aj(context).a(nR());
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setRadius(float f2, float f3, float f4, float f5) {
        this.KE.setRadius(f2, f3, f4, f5);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setSpeed(float f2) {
        this.KE.setSpeed(f2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setSurface(Surface surface) {
        this.KE.setSurface(surface);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setVideoAdaptStrategy(int i2) {
        this.mDetailVideoView.f(true, i2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setVolume(float f2, float f3) {
        this.KE.setVolume(f2, f3);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void start() {
        this.KE.start();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void start(long j2) {
        this.KE.start(j2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void stopAndPrepareAsync() {
        this.KE.stopAndPrepareAsync();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void unRegisterVideoPlayStateListener(VideoPlayStateListener videoPlayStateListener) {
        this.KE.d(d.a(videoPlayStateListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void updateKsPlayLogParam(KsPlayerLogParams ksPlayerLogParams) {
        this.KE.a(d.a(ksPlayerLogParams));
    }
}
