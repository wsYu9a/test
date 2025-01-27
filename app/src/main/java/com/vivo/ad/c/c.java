package com.vivo.ad.c;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.vivo.google.android.exoplayer3.DefaultLoadControl;
import com.vivo.google.android.exoplayer3.DefaultRenderersFactory;
import com.vivo.google.android.exoplayer3.ExoPlaybackException;
import com.vivo.google.android.exoplayer3.ExoPlayer;
import com.vivo.google.android.exoplayer3.ExoPlayerImpl;
import com.vivo.google.android.exoplayer3.Format;
import com.vivo.google.android.exoplayer3.PlaybackParameters;
import com.vivo.google.android.exoplayer3.Renderer;
import com.vivo.google.android.exoplayer3.Timeline;
import com.vivo.google.android.exoplayer3.audio.AudioRendererEventListener;
import com.vivo.google.android.exoplayer3.decoder.DecoderCounters;
import com.vivo.google.android.exoplayer3.extractor.DefaultExtractorsFactory;
import com.vivo.google.android.exoplayer3.metadata.Metadata;
import com.vivo.google.android.exoplayer3.metadata.MetadataRenderer;
import com.vivo.google.android.exoplayer3.source.ExtractorMediaSource;
import com.vivo.google.android.exoplayer3.source.MediaSource;
import com.vivo.google.android.exoplayer3.source.TrackGroupArray;
import com.vivo.google.android.exoplayer3.text.Cue;
import com.vivo.google.android.exoplayer3.text.TextRenderer;
import com.vivo.google.android.exoplayer3.trackselection.AdaptiveTrackSelection;
import com.vivo.google.android.exoplayer3.trackselection.DefaultTrackSelector;
import com.vivo.google.android.exoplayer3.trackselection.TrackSelectionArray;
import com.vivo.google.android.exoplayer3.trackselection.TrackSelector;
import com.vivo.google.android.exoplayer3.upstream.DefaultBandwidthMeter;
import com.vivo.google.android.exoplayer3.video.VideoRendererEventListener;
import java.util.List;

/* loaded from: classes4.dex */
public class c extends com.vivo.ad.c.a {

    /* renamed from: d */
    private ExoPlayer f26585d;

    /* renamed from: e */
    private MediaSource f26586e;

    /* renamed from: f */
    private DefaultBandwidthMeter f26587f;

    /* renamed from: g */
    private TrackSelector f26588g;

    /* renamed from: h */
    private Context f26589h;
    private long k;
    private Renderer[] l;

    /* renamed from: i */
    private int f26590i = 0;

    /* renamed from: j */
    private int f26591j = 0;
    private ExoPlayer.EventListener m = new b();
    private VideoRendererEventListener n = new C0552c();
    private AudioRendererEventListener o = new d(this);
    private TextRenderer.Output p = new e(this);
    private MetadataRenderer.Output q = new f(this);

    class a extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ Surface f26592a;

        a(Surface surface) {
            this.f26592a = surface;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            ExoPlayer.ExoPlayerMessage[] exoPlayerMessageArr = new ExoPlayer.ExoPlayerMessage[c.this.f26590i];
            int i2 = 0;
            for (Renderer renderer : c.this.l) {
                if (renderer.getTrackType() == 2) {
                    exoPlayerMessageArr[i2] = new ExoPlayer.ExoPlayerMessage(renderer, 1, this.f26592a);
                    i2++;
                }
            }
            c cVar = c.this;
            Surface surface = cVar.f26581b;
            if (surface == null || surface == this.f26592a) {
                if (cVar.f26585d != null) {
                    c.this.f26585d.sendMessages(exoPlayerMessageArr);
                }
            } else if (cVar.f26585d != null) {
                c.this.f26585d.blockingSendMessages(exoPlayerMessageArr);
            }
            c.this.f26581b = this.f26592a;
        }
    }

    class b implements ExoPlayer.EventListener {
        b() {
        }

        @Override // com.vivo.google.android.exoplayer3.ExoPlayer.EventListener
        public void onLoadingChanged(boolean z) {
        }

        @Override // com.vivo.google.android.exoplayer3.ExoPlayer.EventListener
        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        }

        @Override // com.vivo.google.android.exoplayer3.ExoPlayer.EventListener
        public void onPlayerError(ExoPlaybackException exoPlaybackException) {
            try {
                if (c.this.f26585d != null) {
                    c cVar = c.this;
                    cVar.k = cVar.f26585d.getCurrentPosition();
                }
            } catch (Exception unused) {
            }
            com.vivo.ad.d.a.a aVar = c.this.f26580a;
            if (aVar != null) {
                aVar.onError(0, 99);
            }
        }

        @Override // com.vivo.google.android.exoplayer3.ExoPlayer.EventListener
        public void onPlayerStateChanged(boolean z, int i2) {
            com.vivo.ad.d.a.a aVar;
            if (i2 == 2) {
                com.vivo.ad.d.a.a aVar2 = c.this.f26580a;
                if (aVar2 != null) {
                    aVar2.onLoading();
                    return;
                }
                return;
            }
            if (i2 != 3) {
                if (i2 == 4 && (aVar = c.this.f26580a) != null) {
                    aVar.onCompletion();
                    return;
                }
                return;
            }
            com.vivo.ad.d.a.a aVar3 = c.this.f26580a;
            if (aVar3 != null) {
                aVar3.onLoadEnd();
            }
        }

        @Override // com.vivo.google.android.exoplayer3.ExoPlayer.EventListener
        public void onPositionDiscontinuity() {
        }

        @Override // com.vivo.google.android.exoplayer3.ExoPlayer.EventListener
        public void onTimelineChanged(Timeline timeline, Object obj) {
        }

        @Override // com.vivo.google.android.exoplayer3.ExoPlayer.EventListener
        public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        }
    }

    /* renamed from: com.vivo.ad.c.c$c */
    class C0552c implements VideoRendererEventListener {
        C0552c() {
        }

        @Override // com.vivo.google.android.exoplayer3.video.VideoRendererEventListener
        public void onDroppedFrames(int i2, long j2) {
        }

        @Override // com.vivo.google.android.exoplayer3.video.VideoRendererEventListener
        public void onRenderedFirstFrame(Surface surface) {
            com.vivo.ad.d.a.a aVar = c.this.f26580a;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.vivo.google.android.exoplayer3.video.VideoRendererEventListener
        public void onVideoDecoderInitialized(String str, long j2, long j3) {
        }

        @Override // com.vivo.google.android.exoplayer3.video.VideoRendererEventListener
        public void onVideoDisabled(DecoderCounters decoderCounters) {
        }

        @Override // com.vivo.google.android.exoplayer3.video.VideoRendererEventListener
        public void onVideoEnabled(DecoderCounters decoderCounters) {
            com.vivo.ad.d.a.a aVar = c.this.f26580a;
            if (aVar != null) {
                aVar.onPrepared();
            }
        }

        @Override // com.vivo.google.android.exoplayer3.video.VideoRendererEventListener
        public void onVideoInputFormatChanged(Format format) {
        }

        @Override // com.vivo.google.android.exoplayer3.video.VideoRendererEventListener
        public void onVideoSizeChanged(int i2, int i3, int i4, float f2) {
            com.vivo.ad.d.a.a aVar = c.this.f26580a;
            if (aVar != null) {
                aVar.onInfo(i2, i3);
            }
        }
    }

    class d implements AudioRendererEventListener {
        d(c cVar) {
        }

        @Override // com.vivo.google.android.exoplayer3.audio.AudioRendererEventListener
        public void onAudioDecoderInitialized(String str, long j2, long j3) {
        }

        @Override // com.vivo.google.android.exoplayer3.audio.AudioRendererEventListener
        public void onAudioDisabled(DecoderCounters decoderCounters) {
        }

        @Override // com.vivo.google.android.exoplayer3.audio.AudioRendererEventListener
        public void onAudioEnabled(DecoderCounters decoderCounters) {
        }

        @Override // com.vivo.google.android.exoplayer3.audio.AudioRendererEventListener
        public void onAudioInputFormatChanged(Format format) {
        }

        @Override // com.vivo.google.android.exoplayer3.audio.AudioRendererEventListener
        public void onAudioSessionId(int i2) {
        }

        @Override // com.vivo.google.android.exoplayer3.audio.AudioRendererEventListener
        public void onAudioTrackUnderrun(int i2, long j2, long j3) {
        }
    }

    class e implements TextRenderer.Output {
        e(c cVar) {
        }

        @Override // com.vivo.google.android.exoplayer3.text.TextRenderer.Output
        public void onCues(List<Cue> list) {
        }
    }

    class f implements MetadataRenderer.Output {
        f(c cVar) {
        }

        @Override // com.vivo.google.android.exoplayer3.metadata.MetadataRenderer.Output
        public void onMetadata(Metadata metadata) {
        }
    }

    public c(Context context) {
        this.f26589h = context;
        h();
    }

    private boolean g() {
        if (this.f26586e != null || TextUtils.isEmpty(this.f26582c)) {
            return false;
        }
        this.f26586e = new ExtractorMediaSource(Uri.parse(this.f26582c), new com.vivo.ad.c.b(this.f26589h), new DefaultExtractorsFactory(), null, null);
        return true;
    }

    private void h() {
        Handler handler = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        DefaultBandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter();
        this.f26587f = defaultBandwidthMeter;
        this.f26588g = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(defaultBandwidthMeter));
        Renderer[] createRenderers = new DefaultRenderersFactory(this.f26589h).createRenderers(handler, this.n, this.o, this.p, this.q);
        this.l = createRenderers;
        ExoPlayerImpl exoPlayerImpl = new ExoPlayerImpl(createRenderers, this.f26588g, new DefaultLoadControl());
        this.f26585d = exoPlayerImpl;
        exoPlayerImpl.setPlayWhenReady(false);
        this.f26585d.addListener(this.m);
        int i2 = 0;
        int i3 = 0;
        for (Renderer renderer : this.l) {
            int trackType = renderer.getTrackType();
            if (trackType == 1) {
                i3++;
            } else if (trackType == 2) {
                i2++;
            }
        }
        this.f26590i = i2;
        this.f26591j = i3;
    }

    @Override // com.vivo.ad.c.a
    public void d() {
        try {
            h();
            if (this.f26585d != null && g()) {
                this.f26585d.prepare(this.f26586e);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.vivo.ad.c.a
    public void e() {
        try {
            ExoPlayer exoPlayer = this.f26585d;
            if (exoPlayer != null) {
                exoPlayer.release();
                this.f26585d = null;
            }
            MediaSource mediaSource = this.f26586e;
            if (mediaSource != null) {
                mediaSource.releaseSource();
                this.f26586e = null;
            }
            this.k = 0L;
            this.f26588g = null;
        } catch (Exception unused) {
        }
    }

    @Override // com.vivo.ad.c.a
    public void f() {
        try {
            ExoPlayer exoPlayer = this.f26585d;
            if (exoPlayer != null) {
                exoPlayer.setPlayWhenReady(true);
                long j2 = this.k;
                if (j2 > 0) {
                    this.f26585d.seekTo(j2);
                }
            }
        } catch (Exception unused) {
        }
    }

    private void b(Surface surface) {
        com.vivo.mobilead.util.f1.c.a(new a(surface));
    }

    @Override // com.vivo.ad.c.a
    public void c() {
        try {
            ExoPlayer exoPlayer = this.f26585d;
            if (exoPlayer != null) {
                this.k = exoPlayer.getCurrentPosition();
                this.f26585d.setPlayWhenReady(false);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.vivo.ad.c.a
    public void a(float f2) {
        try {
            ExoPlayer.ExoPlayerMessage[] exoPlayerMessageArr = new ExoPlayer.ExoPlayerMessage[this.f26591j];
            int i2 = 0;
            for (Renderer renderer : this.l) {
                if (renderer.getTrackType() == 1) {
                    exoPlayerMessageArr[i2] = new ExoPlayer.ExoPlayerMessage(renderer, 2, Float.valueOf(f2));
                    i2++;
                }
            }
            ExoPlayer exoPlayer = this.f26585d;
            if (exoPlayer != null) {
                exoPlayer.sendMessages(exoPlayerMessageArr);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.vivo.ad.c.a
    public long b() {
        try {
            ExoPlayer exoPlayer = this.f26585d;
            if (exoPlayer != null) {
                return exoPlayer.getDuration();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.vivo.ad.c.a
    public void a(long j2) {
        try {
            ExoPlayer exoPlayer = this.f26585d;
            if (exoPlayer != null) {
                exoPlayer.setPlayWhenReady(true);
                if (j2 > 0) {
                    this.f26585d.seekTo(j2);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.vivo.ad.c.a
    public void a(String str) {
        this.f26582c = str;
    }

    @Override // com.vivo.ad.c.a
    public long a() {
        try {
            ExoPlayer exoPlayer = this.f26585d;
            if (exoPlayer != null) {
                return exoPlayer.getCurrentPosition();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.vivo.ad.c.a
    public void a(Surface surface) {
        b(surface);
    }
}
