package com.kwad.components.core.n.b.c;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.components.offline.api.core.video.IKsMediaPlayer;
import com.kwad.components.offline.api.core.video.IKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IMediaPlayer;
import com.kwad.components.offline.api.core.video.listener.OfflineVideoPlayStateListener;
import com.kwad.components.offline.api.core.video.listener.ReleaseCallback;
import com.kwad.components.offline.api.core.video.listener.VideoMuteStateChangeListener;
import com.kwad.components.offline.api.core.video.mdoel.KsPlayerLogParams;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;

/* loaded from: classes3.dex */
final class a implements IKsMediaPlayer {
    private com.kwad.components.core.video.b Pw;
    private c Px;
    private VideoMuteStateChangeListener Py;
    private boolean Pz;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private boolean zq;
    private OfflineOnAudioConflictListener zt;
    private boolean oI = true;
    private int PA = -1;

    /* renamed from: com.kwad.components.core.n.b.c.a$1 */
    public class AnonymousClass1 extends bd {

        /* renamed from: rf */
        final /* synthetic */ boolean f11928rf;

        public AnonymousClass1(boolean z10) {
            z10 = z10;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            a.this.Pw.setAudioEnabled(z10);
            if (a.this.Py != null) {
                a.this.Py.onMuteStateChanged(!z10);
            }
        }
    }

    /* renamed from: com.kwad.components.core.n.b.c.a$2 */
    public class AnonymousClass2 implements OfflineOnAudioConflictListener {

        /* renamed from: com.kwad.components.core.n.b.c.a$2$1 */
        public class AnonymousClass1 extends bd {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                a.this.Pw.setAudioEnabled(false);
                if (a.this.Py != null) {
                    a.this.Py.onMuteStateChanged(true);
                }
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            if (a.this.oI) {
                a.this.zq = true;
                a.b(a.this, false);
            }
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.n.b.c.a.2.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    a.this.Pw.setAudioEnabled(false);
                    if (a.this.Py != null) {
                        a.this.Py.onMuteStateChanged(true);
                    }
                }
            });
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
            a.this.zq = false;
        }
    }

    private OfflineOnAudioConflictListener pL() {
        if (this.zt == null) {
            this.zt = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.n.b.c.a.2

                /* renamed from: com.kwad.components.core.n.b.c.a$2$1 */
                public class AnonymousClass1 extends bd {
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        a.this.Pw.setAudioEnabled(false);
                        if (a.this.Py != null) {
                            a.this.Py.onMuteStateChanged(true);
                        }
                    }
                }

                public AnonymousClass2() {
                }

                @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
                public final void onAudioBeOccupied() {
                    if (a.this.oI) {
                        a.this.zq = true;
                        a.b(a.this, false);
                    }
                    bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.n.b.c.a.2.1
                        public AnonymousClass1() {
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            a.this.Pw.setAudioEnabled(false);
                            if (a.this.Py != null) {
                                a.this.Py.onMuteStateChanged(true);
                            }
                        }
                    });
                }

                @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
                public final void onAudioBeReleased() {
                    a.this.zq = false;
                }
            };
        }
        return this.zt;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void addOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.Pw.a(d.a(getMediaPlayer(), onInfoListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void addOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.Pw.a(d.a(getMediaPlayer(), onPreparedListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void clear() {
        this.Pw.clear();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getBufferPercentage() {
        return this.Pw.getBufferPercentage();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final String getCurrentPlayingUrl() {
        return this.Pw.getCurrentPlayingUrl();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final long getCurrentPosition() {
        return this.Pw.getCurrentPosition();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final long getDuration() {
        return this.Pw.getDuration();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getMaxVolume() {
        return 0;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final IMediaPlayer getMediaPlayer() {
        com.kwad.sdk.core.video.a.c sv = this.Pw.sv();
        if (sv == null) {
            return null;
        }
        c cVar = this.Px;
        if (cVar == null || cVar.pN() != sv) {
            this.Px = new c().b(sv);
        }
        return this.Px;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getMediaPlayerType() {
        return this.Pw.getMediaPlayerType();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final long getPlayDuration() {
        return this.Pw.getPlayDuration();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final String getStateString(int i10) {
        return com.kwad.components.core.video.b.getStateString(i10);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getVideoHeight() {
        return this.Pw.getVideoHeight();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getVideoWidth() {
        return this.Pw.getVideoWidth();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getVolume() {
        return 0;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void initMediaPlayer(@NonNull PlayVideoInfo playVideoInfo, @NonNull IKsMediaPlayerView iKsMediaPlayerView) {
        if (!(iKsMediaPlayerView instanceof b)) {
            com.kwad.sdk.core.d.c.e("KsMediaPlayer", "videoView not instanceof KsMediaPlayerView");
            return;
        }
        DetailVideoView pM = ((b) iKsMediaPlayerView).pM();
        this.mDetailVideoView = pM;
        this.mContext = pM.getContext().getApplicationContext();
        this.Pw.a(d.a(playVideoInfo), this.mDetailVideoView);
        int i10 = this.PA;
        if (i10 != -1) {
            setVideoAdaptStrategy(i10);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean isPlaying() {
        return this.Pw.isPlaying();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean isPrepared() {
        return this.Pw.isPrepared();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean isPreparing() {
        return this.Pw.isPreparing();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void notifyOnInfoListener(IMediaPlayer iMediaPlayer, int i10, int i11) {
        if (iMediaPlayer instanceof c) {
            this.Pw.a(((c) iMediaPlayer).pN(), i10, i11);
        } else {
            com.kwad.sdk.core.d.c.e("KsMediaPlayer", "videoView not instanceof KsMediaPlayerView");
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void onPlayStateChanged(int i10) {
        this.Pw.onPlayStateChanged(i10);
    }

    public final com.kwad.components.core.video.b pK() {
        return this.Pw;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean pause() {
        return this.Pw.pause();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void prepareAsync() {
        this.Pw.prepareAsync();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void registerVideoMuteStateListener(VideoMuteStateChangeListener videoMuteStateChangeListener) {
        this.Py = videoMuteStateChangeListener;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void registerVideoPlayStateListener(OfflineVideoPlayStateListener offlineVideoPlayStateListener) {
        this.Pw.c(d.a(offlineVideoPlayStateListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void release(ReleaseCallback releaseCallback, boolean z10) {
        this.Pw.a(d.a(releaseCallback), z10);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void releaseAsync() {
        com.kwad.components.core.s.a.av(this.mContext).b(this.zt);
        this.Pw.releaseAsync();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void removeInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.Pw.b(d.a(getMediaPlayer(), onInfoListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void resetAndPlay(PlayVideoInfo playVideoInfo) {
        com.kwad.components.core.video.b bVar = this.Pw;
        d.a(playVideoInfo);
        bVar.sy();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void restart() {
        this.Pw.restart();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void resume() {
        this.Pw.resume();
        if (this.oI || (this.Pz && this.zq)) {
            com.kwad.components.core.s.a.av(this.mContext).aO(this.Pz);
            if (this.Pz && this.zq) {
                this.zq = false;
                setAudioEnabled(true);
                this.oI = true;
            } else if (this.zq) {
                setAudioEnabled(false);
            }
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void seekTo(long j10) {
        this.Pw.seekTo(j10);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setAudioEnabled(boolean z10) {
        if (z10) {
            com.kwad.components.core.s.a.av(this.mContext).aO(true);
        }
        if (z10 == this.oI) {
            com.kwad.sdk.core.video.a.a.a.eH("autoVoice");
        } else {
            this.oI = z10;
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.n.b.c.a.1

                /* renamed from: rf */
                final /* synthetic */ boolean f11928rf;

                public AnonymousClass1(boolean z102) {
                    z10 = z102;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    a.this.Pw.setAudioEnabled(z10);
                    if (a.this.Py != null) {
                        a.this.Py.onMuteStateChanged(!z10);
                    }
                }
            });
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setDataSource(@NonNull PlayVideoInfo playVideoInfo) {
        this.Pw.a(d.a(playVideoInfo));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setForceGetAudioFocus(boolean z10) {
        this.Pz = z10;
        Context context = this.mContext;
        if (context != null) {
            com.kwad.components.core.s.a.av(context).a(pL());
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setRadius(float f10, float f11, float f12, float f13) {
        this.Pw.setRadius(f10, f11, f12, f13);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setSpeed(float f10) {
        this.Pw.setSpeed(f10);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setSurface(Surface surface) {
        this.Pw.setSurface(surface);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setVideoAdaptStrategy(int i10) {
        this.PA = i10;
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.g(true, i10);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setVolume(float f10, float f11) {
        this.Pw.setVolume(f10, f11);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void start() {
        this.Pw.start();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void stopAndPrepareAsync() {
        this.Pw.stopAndPrepareAsync();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void unRegisterVideoPlayStateListener(OfflineVideoPlayStateListener offlineVideoPlayStateListener) {
        this.Pw.d(d.a(offlineVideoPlayStateListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void updateKsPlayLogParam(KsPlayerLogParams ksPlayerLogParams) {
        this.Pw.a(d.a(ksPlayerLogParams));
    }

    public static /* synthetic */ boolean b(a aVar, boolean z10) {
        aVar.oI = false;
        return false;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void release(ReleaseCallback releaseCallback) {
        this.Pw.a(d.a(releaseCallback));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void start(long j10) {
        this.Pw.start(j10);
    }

    public final a a(@NonNull com.kwad.components.core.video.b bVar) {
        au.checkNotNull(bVar);
        this.Pw = bVar;
        return this;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void release() {
        this.Pw.release();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void initMediaPlayer(@NonNull PlayVideoInfo playVideoInfo, boolean z10, boolean z11, @NonNull IKsMediaPlayerView iKsMediaPlayerView) {
        if (!(iKsMediaPlayerView instanceof b)) {
            com.kwad.sdk.core.d.c.e("KsMediaPlayer", "videoView not instanceof KsMediaPlayerView");
        } else {
            this.Pw.a(d.a(playVideoInfo), z10, z11, ((b) iKsMediaPlayerView).pM());
        }
    }
}
