package com.kwad.components.core.n.b.c;

import android.media.TimedText;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.h;
import com.kwad.components.core.video.k;
import com.kwad.components.offline.api.core.video.IMediaPlayer;
import com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener;
import com.kwad.components.offline.api.core.video.listener.OfflineVideoPlayStateListener;
import com.kwad.components.offline.api.core.video.listener.ReleaseCallback;
import com.kwad.components.offline.api.core.video.mdoel.KsPlayerLogParams;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: com.kwad.components.core.n.b.c.d$1 */
    public class AnonymousClass1 implements c.e {
        final /* synthetic */ IMediaPlayer PI;

        public AnonymousClass1(IMediaPlayer iMediaPlayer) {
            iMediaPlayer = iMediaPlayer;
        }

        @Override // com.kwad.sdk.core.video.a.c.e
        public final void a(com.kwad.sdk.core.video.a.c cVar) {
            try {
                IMediaPlayer.OnPreparedListener.this.onPrepared(iMediaPlayer);
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    /* renamed from: com.kwad.components.core.n.b.c.d$10 */
    public class AnonymousClass10 implements c.h {
        final /* synthetic */ IMediaPlayer PI;

        public AnonymousClass10(IMediaPlayer iMediaPlayer) {
            iMediaPlayer = iMediaPlayer;
        }

        @Override // com.kwad.sdk.core.video.a.c.h
        public final void a(TimedText timedText) {
            IMediaPlayer.OnTimedTextListener.this.onTimedText(iMediaPlayer, timedText);
        }
    }

    /* renamed from: com.kwad.components.core.n.b.c.d$11 */
    public class AnonymousClass11 implements k {
        public AnonymousClass11() {
        }

        @Override // com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            OfflineVideoPlayStateListener.this.onMediaPlayCompleted();
        }

        @Override // com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            OfflineVideoPlayStateListener.this.onMediaPlayError(i10, i11);
        }

        @Override // com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
            OfflineVideoPlayStateListener.this.onMediaPlayPaused();
        }

        @Override // com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            OfflineVideoPlayStateListener.this.onMediaPlayProgress(j10, j11);
        }

        @Override // com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            OfflineVideoPlayStateListener.this.onMediaPlayStart();
        }

        @Override // com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            OfflineVideoPlayStateListener.this.onMediaPlaying();
        }

        @Override // com.kwad.components.core.video.h
        public final void onMediaPrepared() {
            OfflineVideoPlayStateListener.this.onMediaPrepared();
        }

        @Override // com.kwad.components.core.video.h
        public final void onMediaPreparing() {
            OfflineVideoPlayStateListener.this.onMediaPreparing();
        }

        @Override // com.kwad.components.core.video.k
        public final void onVideoPlayBufferingPaused() {
            OfflineVideoPlayStateListener.this.onVideoPlayBufferingPaused();
        }

        @Override // com.kwad.components.core.video.k
        public final void onVideoPlayBufferingPlaying() {
            OfflineVideoPlayStateListener.this.onVideoPlayBufferingPlaying();
        }
    }

    /* renamed from: com.kwad.components.core.n.b.c.d$2 */
    public class AnonymousClass2 implements h {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            OfflineMediaPlayStateListener.this.onMediaPlayCompleted();
        }

        @Override // com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            OfflineMediaPlayStateListener.this.onMediaPlayError(i10, i11);
        }

        @Override // com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
            OfflineMediaPlayStateListener.this.onMediaPlayPaused();
        }

        @Override // com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            OfflineMediaPlayStateListener.this.onMediaPlayProgress(j10, j11);
        }

        @Override // com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            OfflineMediaPlayStateListener.this.onMediaPlayStart();
        }

        @Override // com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            OfflineMediaPlayStateListener.this.onMediaPlaying();
        }

        @Override // com.kwad.components.core.video.h
        public final void onMediaPrepared() {
            OfflineMediaPlayStateListener.this.onMediaPrepared();
        }

        @Override // com.kwad.components.core.video.h
        public final void onMediaPreparing() {
            OfflineMediaPlayStateListener.this.onMediaPreparing();
        }
    }

    /* renamed from: com.kwad.components.core.n.b.c.d$3 */
    public class AnonymousClass3 implements b.a {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.b.a
        public final void onReleaseSuccess() {
            ReleaseCallback.this.onReleaseSuccess();
        }
    }

    /* renamed from: com.kwad.components.core.n.b.c.d$4 */
    public class AnonymousClass4 implements c.b {
        final /* synthetic */ IMediaPlayer PI;

        public AnonymousClass4(IMediaPlayer iMediaPlayer) {
            iMediaPlayer = iMediaPlayer;
        }

        @Override // com.kwad.sdk.core.video.a.c.b
        public final void pO() {
            IMediaPlayer.OnCompletionListener.this.onCompletion(iMediaPlayer);
        }
    }

    /* renamed from: com.kwad.components.core.n.b.c.d$5 */
    public class AnonymousClass5 implements c.a {
        final /* synthetic */ IMediaPlayer PI;

        public AnonymousClass5(IMediaPlayer iMediaPlayer) {
            iMediaPlayer = iMediaPlayer;
        }

        @Override // com.kwad.sdk.core.video.a.c.a
        public final void aw(int i10) {
            IMediaPlayer.OnBufferingUpdateListener.this.onBufferingUpdate(iMediaPlayer, i10);
        }
    }

    /* renamed from: com.kwad.components.core.n.b.c.d$6 */
    public class AnonymousClass6 implements c.g {
        final /* synthetic */ IMediaPlayer PI;

        public AnonymousClass6(IMediaPlayer iMediaPlayer) {
            iMediaPlayer = iMediaPlayer;
        }

        @Override // com.kwad.sdk.core.video.a.c.g
        public final void pP() {
            IMediaPlayer.OnSeekCompleteListener.this.onSeekComplete(iMediaPlayer);
        }
    }

    /* renamed from: com.kwad.components.core.n.b.c.d$7 */
    public class AnonymousClass7 implements c.i {
        final /* synthetic */ IMediaPlayer PI;

        public AnonymousClass7(IMediaPlayer iMediaPlayer) {
            iMediaPlayer = iMediaPlayer;
        }

        @Override // com.kwad.sdk.core.video.a.c.i
        public final void k(int i10, int i11) {
            IMediaPlayer.OnVideoSizeChangedListener.this.onVideoSizeChanged(iMediaPlayer, i10, i11);
        }
    }

    /* renamed from: com.kwad.components.core.n.b.c.d$8 */
    public class AnonymousClass8 implements c.InterfaceC0500c {
        final /* synthetic */ IMediaPlayer PI;

        public AnonymousClass8(IMediaPlayer iMediaPlayer) {
            iMediaPlayer = iMediaPlayer;
        }

        @Override // com.kwad.sdk.core.video.a.c.InterfaceC0500c
        public final boolean l(int i10, int i11) {
            return IMediaPlayer.OnErrorListener.this.onError(iMediaPlayer, i10, i11);
        }
    }

    /* renamed from: com.kwad.components.core.n.b.c.d$9 */
    public class AnonymousClass9 implements c.d {
        final /* synthetic */ IMediaPlayer PI;

        public AnonymousClass9(IMediaPlayer iMediaPlayer) {
            iMediaPlayer = iMediaPlayer;
        }

        @Override // com.kwad.sdk.core.video.a.c.d
        public final boolean m(int i10, int i11) {
            return IMediaPlayer.OnInfoListener.this.onInfo(iMediaPlayer, i10, i11);
        }
    }

    public static com.kwad.sdk.contentalliance.a.a.b a(PlayVideoInfo playVideoInfo) {
        if (playVideoInfo == null) {
            return null;
        }
        return new b.a(playVideoInfo.videoUrl).dd(playVideoInfo.manifest).b(a(playVideoInfo.ksplayerLogParams)).a(playVideoInfo.videoPlayerStatus).bm(playVideoInfo.isNoCache).Cz();
    }

    public static com.kwad.sdk.contentalliance.a.a.a a(KsPlayerLogParams ksPlayerLogParams) {
        if (ksPlayerLogParams == null) {
            return null;
        }
        com.kwad.sdk.contentalliance.a.a.a aVar = new com.kwad.sdk.contentalliance.a.a.a();
        aVar.photoId = ksPlayerLogParams.photoId;
        aVar.clickTime = ksPlayerLogParams.clickTime;
        aVar.adStyle = ksPlayerLogParams.adStyle;
        aVar.contentType = ksPlayerLogParams.contentType;
        return aVar;
    }

    public static c.e a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnPreparedListener onPreparedListener) {
        if (onPreparedListener == null) {
            return null;
        }
        return new c.e() { // from class: com.kwad.components.core.n.b.c.d.1
            final /* synthetic */ IMediaPlayer PI;

            public AnonymousClass1(IMediaPlayer iMediaPlayer2) {
                iMediaPlayer = iMediaPlayer2;
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    IMediaPlayer.OnPreparedListener.this.onPrepared(iMediaPlayer);
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }
        };
    }

    public static c.b a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnCompletionListener onCompletionListener) {
        if (onCompletionListener == null) {
            return null;
        }
        return new c.b() { // from class: com.kwad.components.core.n.b.c.d.4
            final /* synthetic */ IMediaPlayer PI;

            public AnonymousClass4(IMediaPlayer iMediaPlayer2) {
                iMediaPlayer = iMediaPlayer2;
            }

            @Override // com.kwad.sdk.core.video.a.c.b
            public final void pO() {
                IMediaPlayer.OnCompletionListener.this.onCompletion(iMediaPlayer);
            }
        };
    }

    public static c.a a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        if (onBufferingUpdateListener == null) {
            return null;
        }
        return new c.a() { // from class: com.kwad.components.core.n.b.c.d.5
            final /* synthetic */ IMediaPlayer PI;

            public AnonymousClass5(IMediaPlayer iMediaPlayer2) {
                iMediaPlayer = iMediaPlayer2;
            }

            @Override // com.kwad.sdk.core.video.a.c.a
            public final void aw(int i10) {
                IMediaPlayer.OnBufferingUpdateListener.this.onBufferingUpdate(iMediaPlayer, i10);
            }
        };
    }

    public static c.g a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        if (onSeekCompleteListener == null) {
            return null;
        }
        return new c.g() { // from class: com.kwad.components.core.n.b.c.d.6
            final /* synthetic */ IMediaPlayer PI;

            public AnonymousClass6(IMediaPlayer iMediaPlayer2) {
                iMediaPlayer = iMediaPlayer2;
            }

            @Override // com.kwad.sdk.core.video.a.c.g
            public final void pP() {
                IMediaPlayer.OnSeekCompleteListener.this.onSeekComplete(iMediaPlayer);
            }
        };
    }

    public static c.i a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener == null) {
            return null;
        }
        return new c.i() { // from class: com.kwad.components.core.n.b.c.d.7
            final /* synthetic */ IMediaPlayer PI;

            public AnonymousClass7(IMediaPlayer iMediaPlayer2) {
                iMediaPlayer = iMediaPlayer2;
            }

            @Override // com.kwad.sdk.core.video.a.c.i
            public final void k(int i10, int i11) {
                IMediaPlayer.OnVideoSizeChangedListener.this.onVideoSizeChanged(iMediaPlayer, i10, i11);
            }
        };
    }

    public static c.InterfaceC0500c a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnErrorListener onErrorListener) {
        if (onErrorListener == null) {
            return null;
        }
        return new c.InterfaceC0500c() { // from class: com.kwad.components.core.n.b.c.d.8
            final /* synthetic */ IMediaPlayer PI;

            public AnonymousClass8(IMediaPlayer iMediaPlayer2) {
                iMediaPlayer = iMediaPlayer2;
            }

            @Override // com.kwad.sdk.core.video.a.c.InterfaceC0500c
            public final boolean l(int i10, int i11) {
                return IMediaPlayer.OnErrorListener.this.onError(iMediaPlayer, i10, i11);
            }
        };
    }

    public static c.d a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnInfoListener onInfoListener) {
        if (onInfoListener == null) {
            return null;
        }
        return new c.d() { // from class: com.kwad.components.core.n.b.c.d.9
            final /* synthetic */ IMediaPlayer PI;

            public AnonymousClass9(IMediaPlayer iMediaPlayer2) {
                iMediaPlayer = iMediaPlayer2;
            }

            @Override // com.kwad.sdk.core.video.a.c.d
            public final boolean m(int i10, int i11) {
                return IMediaPlayer.OnInfoListener.this.onInfo(iMediaPlayer, i10, i11);
            }
        };
    }

    public static c.h a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        if (onTimedTextListener == null) {
            return null;
        }
        return new c.h() { // from class: com.kwad.components.core.n.b.c.d.10
            final /* synthetic */ IMediaPlayer PI;

            public AnonymousClass10(IMediaPlayer iMediaPlayer2) {
                iMediaPlayer = iMediaPlayer2;
            }

            @Override // com.kwad.sdk.core.video.a.c.h
            public final void a(TimedText timedText) {
                IMediaPlayer.OnTimedTextListener.this.onTimedText(iMediaPlayer, timedText);
            }
        };
    }

    public static k a(OfflineVideoPlayStateListener offlineVideoPlayStateListener) {
        if (offlineVideoPlayStateListener == null) {
            return null;
        }
        return new k() { // from class: com.kwad.components.core.n.b.c.d.11
            public AnonymousClass11() {
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                OfflineVideoPlayStateListener.this.onMediaPlayCompleted();
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPlayError(int i10, int i11) {
                OfflineVideoPlayStateListener.this.onMediaPlayError(i10, i11);
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPlayPaused() {
                OfflineVideoPlayStateListener.this.onMediaPlayPaused();
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j10, long j11) {
                OfflineVideoPlayStateListener.this.onMediaPlayProgress(j10, j11);
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                OfflineVideoPlayStateListener.this.onMediaPlayStart();
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                OfflineVideoPlayStateListener.this.onMediaPlaying();
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPrepared() {
                OfflineVideoPlayStateListener.this.onMediaPrepared();
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPreparing() {
                OfflineVideoPlayStateListener.this.onMediaPreparing();
            }

            @Override // com.kwad.components.core.video.k
            public final void onVideoPlayBufferingPaused() {
                OfflineVideoPlayStateListener.this.onVideoPlayBufferingPaused();
            }

            @Override // com.kwad.components.core.video.k
            public final void onVideoPlayBufferingPlaying() {
                OfflineVideoPlayStateListener.this.onVideoPlayBufferingPlaying();
            }
        };
    }

    public static h a(OfflineMediaPlayStateListener offlineMediaPlayStateListener) {
        if (offlineMediaPlayStateListener == null) {
            return null;
        }
        return new h() { // from class: com.kwad.components.core.n.b.c.d.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                OfflineMediaPlayStateListener.this.onMediaPlayCompleted();
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPlayError(int i10, int i11) {
                OfflineMediaPlayStateListener.this.onMediaPlayError(i10, i11);
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPlayPaused() {
                OfflineMediaPlayStateListener.this.onMediaPlayPaused();
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j10, long j11) {
                OfflineMediaPlayStateListener.this.onMediaPlayProgress(j10, j11);
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                OfflineMediaPlayStateListener.this.onMediaPlayStart();
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                OfflineMediaPlayStateListener.this.onMediaPlaying();
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPrepared() {
                OfflineMediaPlayStateListener.this.onMediaPrepared();
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPreparing() {
                OfflineMediaPlayStateListener.this.onMediaPreparing();
            }
        };
    }

    public static b.a a(ReleaseCallback releaseCallback) {
        if (releaseCallback == null) {
            return null;
        }
        return new b.a() { // from class: com.kwad.components.core.n.b.c.d.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.components.core.video.b.a
            public final void onReleaseSuccess() {
                ReleaseCallback.this.onReleaseSuccess();
            }
        };
    }
}
