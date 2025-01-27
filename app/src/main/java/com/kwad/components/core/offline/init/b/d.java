package com.kwad.components.core.offline.init.b;

import android.media.TimedText;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.i;
import com.kwad.components.offline.api.core.video.IMediaPlayer;
import com.kwad.components.offline.api.core.video.listener.ReleaseCallback;
import com.kwad.components.offline.api.core.video.listener.VideoPlayStateListener;
import com.kwad.components.offline.api.core.video.mdoel.KsPlayerLogParams;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.video.kwai.c;

/* loaded from: classes2.dex */
final class d {

    /* renamed from: com.kwad.components.core.offline.init.b.d$1 */
    static class AnonymousClass1 implements c.e {
        final /* synthetic */ IMediaPlayer KP;

        AnonymousClass1(IMediaPlayer iMediaPlayer) {
            iMediaPlayer = iMediaPlayer;
        }

        @Override // com.kwad.sdk.core.video.kwai.c.e
        public final void a(com.kwad.sdk.core.video.kwai.c cVar) {
            IMediaPlayer.OnPreparedListener.this.onPrepared(iMediaPlayer);
        }
    }

    /* renamed from: com.kwad.components.core.offline.init.b.d$10 */
    static class AnonymousClass10 implements i {
        AnonymousClass10() {
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayBufferingPaused() {
            VideoPlayStateListener.this.onVideoPlayBufferingPaused();
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayBufferingPlaying() {
            VideoPlayStateListener.this.onVideoPlayBufferingPlaying();
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            VideoPlayStateListener.this.onVideoPlayCompleted();
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            VideoPlayStateListener.this.onVideoPlayError(i2, i3);
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayPaused() {
            VideoPlayStateListener.this.onVideoPlayPaused();
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            VideoPlayStateListener.this.onVideoPlayProgress(j2, j3);
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            VideoPlayStateListener.this.onVideoPlayStart();
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlaying() {
            VideoPlayStateListener.this.onVideoPlaying();
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPrepared() {
            VideoPlayStateListener.this.onVideoPrepared();
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPreparing() {
            VideoPlayStateListener.this.onVideoPreparing();
        }
    }

    /* renamed from: com.kwad.components.core.offline.init.b.d$2 */
    static class AnonymousClass2 implements b.a {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.b.a
        public final void onReleaseSuccess() {
            ReleaseCallback.this.onReleaseSuccess();
        }
    }

    /* renamed from: com.kwad.components.core.offline.init.b.d$3 */
    static class AnonymousClass3 implements c.b {
        final /* synthetic */ IMediaPlayer KP;

        AnonymousClass3(IMediaPlayer iMediaPlayer) {
            iMediaPlayer = iMediaPlayer;
        }

        @Override // com.kwad.sdk.core.video.kwai.c.b
        public final void nU() {
            IMediaPlayer.OnCompletionListener.this.onCompletion(iMediaPlayer);
        }
    }

    /* renamed from: com.kwad.components.core.offline.init.b.d$4 */
    static class AnonymousClass4 implements c.a {
        final /* synthetic */ IMediaPlayer KP;

        AnonymousClass4(IMediaPlayer iMediaPlayer) {
            iMediaPlayer = iMediaPlayer;
        }

        @Override // com.kwad.sdk.core.video.kwai.c.a
        public final void ax(int i2) {
            IMediaPlayer.OnBufferingUpdateListener.this.onBufferingUpdate(iMediaPlayer, i2);
        }
    }

    /* renamed from: com.kwad.components.core.offline.init.b.d$5 */
    static class AnonymousClass5 implements c.f {
        final /* synthetic */ IMediaPlayer KP;

        AnonymousClass5(IMediaPlayer iMediaPlayer) {
            iMediaPlayer = iMediaPlayer;
        }

        @Override // com.kwad.sdk.core.video.kwai.c.f
        public final void nV() {
            IMediaPlayer.OnSeekCompleteListener.this.onSeekComplete(iMediaPlayer);
        }
    }

    /* renamed from: com.kwad.components.core.offline.init.b.d$6 */
    static class AnonymousClass6 implements c.h {
        final /* synthetic */ IMediaPlayer KP;

        AnonymousClass6(IMediaPlayer iMediaPlayer) {
            iMediaPlayer = iMediaPlayer;
        }

        @Override // com.kwad.sdk.core.video.kwai.c.h
        public final void i(int i2, int i3) {
            IMediaPlayer.OnVideoSizeChangedListener.this.onVideoSizeChanged(iMediaPlayer, i2, i3);
        }
    }

    /* renamed from: com.kwad.components.core.offline.init.b.d$7 */
    static class AnonymousClass7 implements c.InterfaceC0220c {
        final /* synthetic */ IMediaPlayer KP;

        AnonymousClass7(IMediaPlayer iMediaPlayer) {
            iMediaPlayer = iMediaPlayer;
        }

        @Override // com.kwad.sdk.core.video.kwai.c.InterfaceC0220c
        public final boolean j(int i2, int i3) {
            return IMediaPlayer.OnErrorListener.this.onError(iMediaPlayer, i2, i3);
        }
    }

    /* renamed from: com.kwad.components.core.offline.init.b.d$8 */
    static class AnonymousClass8 implements c.d {
        final /* synthetic */ IMediaPlayer KP;

        AnonymousClass8(IMediaPlayer iMediaPlayer) {
            iMediaPlayer = iMediaPlayer;
        }

        @Override // com.kwad.sdk.core.video.kwai.c.d
        public final boolean k(int i2, int i3) {
            return IMediaPlayer.OnInfoListener.this.onInfo(iMediaPlayer, i2, i3);
        }
    }

    /* renamed from: com.kwad.components.core.offline.init.b.d$9 */
    static class AnonymousClass9 implements c.g {
        final /* synthetic */ IMediaPlayer KP;

        AnonymousClass9(IMediaPlayer iMediaPlayer) {
            iMediaPlayer = iMediaPlayer;
        }

        @Override // com.kwad.sdk.core.video.kwai.c.g
        public final void a(TimedText timedText) {
            IMediaPlayer.OnTimedTextListener.this.onTimedText(iMediaPlayer, timedText);
        }
    }

    public static b.a a(ReleaseCallback releaseCallback) {
        if (releaseCallback == null) {
            return null;
        }
        return new b.a() { // from class: com.kwad.components.core.offline.init.b.d.2
            AnonymousClass2() {
            }

            @Override // com.kwad.components.core.video.b.a
            public final void onReleaseSuccess() {
                ReleaseCallback.this.onReleaseSuccess();
            }
        };
    }

    public static i a(VideoPlayStateListener videoPlayStateListener) {
        if (videoPlayStateListener == null) {
            return null;
        }
        return new i() { // from class: com.kwad.components.core.offline.init.b.d.10
            AnonymousClass10() {
            }

            @Override // com.kwad.components.core.video.i
            public final void onVideoPlayBufferingPaused() {
                VideoPlayStateListener.this.onVideoPlayBufferingPaused();
            }

            @Override // com.kwad.components.core.video.i
            public final void onVideoPlayBufferingPlaying() {
                VideoPlayStateListener.this.onVideoPlayBufferingPlaying();
            }

            @Override // com.kwad.components.core.video.i
            public final void onVideoPlayCompleted() {
                VideoPlayStateListener.this.onVideoPlayCompleted();
            }

            @Override // com.kwad.components.core.video.i
            public final void onVideoPlayError(int i2, int i3) {
                VideoPlayStateListener.this.onVideoPlayError(i2, i3);
            }

            @Override // com.kwad.components.core.video.i
            public final void onVideoPlayPaused() {
                VideoPlayStateListener.this.onVideoPlayPaused();
            }

            @Override // com.kwad.components.core.video.i
            public final void onVideoPlayProgress(long j2, long j3) {
                VideoPlayStateListener.this.onVideoPlayProgress(j2, j3);
            }

            @Override // com.kwad.components.core.video.i
            public final void onVideoPlayStart() {
                VideoPlayStateListener.this.onVideoPlayStart();
            }

            @Override // com.kwad.components.core.video.i
            public final void onVideoPlaying() {
                VideoPlayStateListener.this.onVideoPlaying();
            }

            @Override // com.kwad.components.core.video.i
            public final void onVideoPrepared() {
                VideoPlayStateListener.this.onVideoPrepared();
            }

            @Override // com.kwad.components.core.video.i
            public final void onVideoPreparing() {
                VideoPlayStateListener.this.onVideoPreparing();
            }
        };
    }

    public static com.kwad.sdk.contentalliance.kwai.kwai.a a(KsPlayerLogParams ksPlayerLogParams) {
        if (ksPlayerLogParams == null) {
            return null;
        }
        com.kwad.sdk.contentalliance.kwai.kwai.a aVar = new com.kwad.sdk.contentalliance.kwai.kwai.a();
        aVar.photoId = ksPlayerLogParams.photoId;
        aVar.clickTime = ksPlayerLogParams.clickTime;
        aVar.adStyle = ksPlayerLogParams.adStyle;
        aVar.contentType = ksPlayerLogParams.contentType;
        return aVar;
    }

    public static com.kwad.sdk.contentalliance.kwai.kwai.b a(PlayVideoInfo playVideoInfo) {
        if (playVideoInfo == null) {
            return null;
        }
        return new b.a(playVideoInfo.videoUrl).bt(playVideoInfo.manifest).b(a(playVideoInfo.ksplayerLogParams)).a(playVideoInfo.videoPlayerStatus).aV(playVideoInfo.isNoCache).tR();
    }

    public static c.a a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        if (onBufferingUpdateListener == null) {
            return null;
        }
        return new c.a() { // from class: com.kwad.components.core.offline.init.b.d.4
            final /* synthetic */ IMediaPlayer KP;

            AnonymousClass4(IMediaPlayer iMediaPlayer2) {
                iMediaPlayer = iMediaPlayer2;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.a
            public final void ax(int i2) {
                IMediaPlayer.OnBufferingUpdateListener.this.onBufferingUpdate(iMediaPlayer, i2);
            }
        };
    }

    public static c.b a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnCompletionListener onCompletionListener) {
        if (onCompletionListener == null) {
            return null;
        }
        return new c.b() { // from class: com.kwad.components.core.offline.init.b.d.3
            final /* synthetic */ IMediaPlayer KP;

            AnonymousClass3(IMediaPlayer iMediaPlayer2) {
                iMediaPlayer = iMediaPlayer2;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.b
            public final void nU() {
                IMediaPlayer.OnCompletionListener.this.onCompletion(iMediaPlayer);
            }
        };
    }

    public static c.InterfaceC0220c a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnErrorListener onErrorListener) {
        if (onErrorListener == null) {
            return null;
        }
        return new c.InterfaceC0220c() { // from class: com.kwad.components.core.offline.init.b.d.7
            final /* synthetic */ IMediaPlayer KP;

            AnonymousClass7(IMediaPlayer iMediaPlayer2) {
                iMediaPlayer = iMediaPlayer2;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.InterfaceC0220c
            public final boolean j(int i2, int i3) {
                return IMediaPlayer.OnErrorListener.this.onError(iMediaPlayer, i2, i3);
            }
        };
    }

    public static c.d a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnInfoListener onInfoListener) {
        if (onInfoListener == null) {
            return null;
        }
        return new c.d() { // from class: com.kwad.components.core.offline.init.b.d.8
            final /* synthetic */ IMediaPlayer KP;

            AnonymousClass8(IMediaPlayer iMediaPlayer2) {
                iMediaPlayer = iMediaPlayer2;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.d
            public final boolean k(int i2, int i3) {
                return IMediaPlayer.OnInfoListener.this.onInfo(iMediaPlayer, i2, i3);
            }
        };
    }

    public static c.e a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnPreparedListener onPreparedListener) {
        if (onPreparedListener == null) {
            return null;
        }
        return new c.e() { // from class: com.kwad.components.core.offline.init.b.d.1
            final /* synthetic */ IMediaPlayer KP;

            AnonymousClass1(IMediaPlayer iMediaPlayer2) {
                iMediaPlayer = iMediaPlayer2;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(com.kwad.sdk.core.video.kwai.c cVar) {
                IMediaPlayer.OnPreparedListener.this.onPrepared(iMediaPlayer);
            }
        };
    }

    public static c.f a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        if (onSeekCompleteListener == null) {
            return null;
        }
        return new c.f() { // from class: com.kwad.components.core.offline.init.b.d.5
            final /* synthetic */ IMediaPlayer KP;

            AnonymousClass5(IMediaPlayer iMediaPlayer2) {
                iMediaPlayer = iMediaPlayer2;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.f
            public final void nV() {
                IMediaPlayer.OnSeekCompleteListener.this.onSeekComplete(iMediaPlayer);
            }
        };
    }

    public static c.g a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        if (onTimedTextListener == null) {
            return null;
        }
        return new c.g() { // from class: com.kwad.components.core.offline.init.b.d.9
            final /* synthetic */ IMediaPlayer KP;

            AnonymousClass9(IMediaPlayer iMediaPlayer2) {
                iMediaPlayer = iMediaPlayer2;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.g
            public final void a(TimedText timedText) {
                IMediaPlayer.OnTimedTextListener.this.onTimedText(iMediaPlayer, timedText);
            }
        };
    }

    public static c.h a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener == null) {
            return null;
        }
        return new c.h() { // from class: com.kwad.components.core.offline.init.b.d.6
            final /* synthetic */ IMediaPlayer KP;

            AnonymousClass6(IMediaPlayer iMediaPlayer2) {
                iMediaPlayer = iMediaPlayer2;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.h
            public final void i(int i2, int i3) {
                IMediaPlayer.OnVideoSizeChangedListener.this.onVideoSizeChanged(iMediaPlayer, i2, i3);
            }
        };
    }
}
