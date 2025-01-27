package com.sigmob.sdk.videoplayer;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import java.util.Map;

/* loaded from: classes4.dex */
public class k extends com.sigmob.sdk.videoplayer.j implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener {

    /* renamed from: g */
    public static final String f20805g = "VideoPlayerMediaSystem";

    /* renamed from: e */
    public MediaPlayer f20806e;

    /* renamed from: f */
    public boolean f20807f;

    public class a implements Runnable {

        /* renamed from: com.sigmob.sdk.videoplayer.k$a$a */
        public class RunnableC0626a implements Runnable {
            public RunnableC0626a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.sigmob.sdk.videoplayer.i iVar = k.this.f20804d;
                if (iVar != null) {
                    iVar.a(0, 0);
                }
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.sigmob.sdk.videoplayer.h videoPlayerDataSource = k.this.f20804d.getVideoPlayerDataSource();
                k.this.f20806e = new MediaPlayer();
                k.this.f20806e.setAudioStreamType(3);
                k.this.f20806e.setLooping(videoPlayerDataSource.f20799d);
                k kVar = k.this;
                kVar.f20806e.setOnPreparedListener(kVar);
                k kVar2 = k.this;
                kVar2.f20806e.setOnCompletionListener(kVar2);
                k kVar3 = k.this;
                kVar3.f20806e.setOnBufferingUpdateListener(kVar3);
                k.this.f20806e.setScreenOnWhilePlaying(true);
                k kVar4 = k.this;
                kVar4.f20806e.setOnSeekCompleteListener(kVar4);
                k kVar5 = k.this;
                kVar5.f20806e.setOnErrorListener(kVar5);
                k kVar6 = k.this;
                kVar6.f20806e.setOnInfoListener(kVar6);
                k kVar7 = k.this;
                kVar7.f20806e.setOnVideoSizeChangedListener(kVar7);
                MediaPlayer.class.getDeclaredMethod("setDataSource", String.class, Map.class).invoke(k.this.f20806e, videoPlayerDataSource.c().toString(), videoPlayerDataSource.f20798c);
                k.this.f20806e.prepareAsync();
                k kVar8 = k.this;
                if (kVar8.f20801a != null) {
                    kVar8.f20807f = false;
                    k.this.f20806e.setSurface(new Surface(k.this.f20801a));
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                k.this.f20803c.post(new RunnableC0626a());
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sigmob.sdk.videoplayer.i iVar = k.this.f20804d;
            if (iVar == null) {
                return;
            }
            iVar.b();
        }
    }

    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ int f20811a;

        /* renamed from: b */
        public final /* synthetic */ int f20812b;

        public c(int i10, int i11) {
            this.f20811a = i10;
            this.f20812b = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sigmob.sdk.videoplayer.i iVar = k.this.f20804d;
            if (iVar == null) {
                return;
            }
            iVar.a(this.f20811a, this.f20812b);
        }
    }

    public class d implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ int f20814a;

        /* renamed from: b */
        public final /* synthetic */ int f20815b;

        public d(int i10, int i11) {
            this.f20814a = i10;
            this.f20815b = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sigmob.sdk.videoplayer.i iVar = k.this.f20804d;
            if (iVar == null) {
                return;
            }
            iVar.b(this.f20814a, this.f20815b);
        }
    }

    public class e implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ int f20817a;

        /* renamed from: b */
        public final /* synthetic */ int f20818b;

        public e(int i10, int i11) {
            this.f20817a = i10;
            this.f20818b = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sigmob.sdk.videoplayer.i iVar = k.this.f20804d;
            if (iVar == null) {
                return;
            }
            iVar.c(this.f20817a, this.f20818b);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaPlayer mediaPlayer = k.this.f20806e;
            if (mediaPlayer == null) {
                return;
            }
            mediaPlayer.start();
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaPlayer mediaPlayer = k.this.f20806e;
            if (mediaPlayer == null) {
                return;
            }
            mediaPlayer.pause();
        }
    }

    public class h implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ long f20822a;

        public h(long j10) {
            this.f20822a = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                MediaPlayer mediaPlayer = k.this.f20806e;
                if (mediaPlayer == null) {
                    return;
                }
                mediaPlayer.seekTo((int) this.f20822a);
            } catch (IllegalStateException e10) {
                e10.printStackTrace();
            }
        }
    }

    public class i implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ MediaPlayer f20824a;

        public i(MediaPlayer mediaPlayer) {
            this.f20824a = mediaPlayer;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f20824a.setSurface(null);
            this.f20824a.release();
            k.this.f20802b = null;
        }
    }

    public class j implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ float f20826a;

        public j(float f10) {
            this.f20826a = f10;
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaPlayer mediaPlayer = k.this.f20806e;
            if (mediaPlayer == null) {
                return;
            }
            float f10 = this.f20826a;
            mediaPlayer.setVolume(f10, f10);
        }
    }

    /* renamed from: com.sigmob.sdk.videoplayer.k$k */
    public class RunnableC0627k implements Runnable {
        public RunnableC0627k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sigmob.sdk.videoplayer.i iVar = k.this.f20804d;
            if (iVar == null) {
                return;
            }
            iVar.c();
        }
    }

    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sigmob.sdk.videoplayer.i iVar = k.this.f20804d;
            if (iVar == null) {
                return;
            }
            iVar.a();
        }
    }

    public class m implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ int f20830a;

        public m(int i10) {
            this.f20830a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sigmob.sdk.videoplayer.i iVar = k.this.f20804d;
            if (iVar == null) {
                return;
            }
            iVar.setBufferProgress(this.f20830a);
        }
    }

    public k(com.sigmob.sdk.videoplayer.i iVar) {
        super(iVar);
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public long b() {
        if (this.f20806e != null) {
            return r0.getDuration();
        }
        return 0L;
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public int c() {
        MediaPlayer mediaPlayer = this.f20806e;
        if (mediaPlayer == null) {
            return 0;
        }
        mediaPlayer.getVideoHeight();
        return 0;
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public int d() {
        MediaPlayer mediaPlayer = this.f20806e;
        if (mediaPlayer == null) {
            return 0;
        }
        mediaPlayer.getVideoWidth();
        return 0;
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public boolean e() {
        MediaPlayer mediaPlayer = this.f20806e;
        if (mediaPlayer == null) {
            return false;
        }
        return mediaPlayer.isPlaying();
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public void f() {
        Handler handler = this.f20802b;
        if (handler == null || this.f20806e == null) {
            return;
        }
        handler.post(new g());
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public void g() {
        MediaPlayer mediaPlayer;
        if (this.f20807f && (mediaPlayer = this.f20806e) != null && this.f20801a != null) {
            this.f20807f = false;
            mediaPlayer.setSurface(new Surface(this.f20801a));
            return;
        }
        i();
        this.f20803c = new Handler();
        Handler iOHandler = ThreadPoolFactory.BackgroundThreadPool.getInstance().getIOHandler();
        this.f20802b = iOHandler;
        iOHandler.post(new a());
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public void h() {
        g();
        this.f20807f = true;
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public void i() {
        MediaPlayer mediaPlayer;
        Handler handler = this.f20802b;
        if (handler == null || (mediaPlayer = this.f20806e) == null) {
            return;
        }
        handler.post(new i(mediaPlayer));
        this.f20806e = null;
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public void j() {
        Handler handler = this.f20802b;
        if (handler == null) {
            return;
        }
        handler.post(new f());
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i10) {
        Handler handler = this.f20803c;
        if (handler == null) {
            return;
        }
        handler.post(new m(i10));
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        Handler handler = this.f20803c;
        if (handler == null) {
            return;
        }
        handler.post(new l());
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
        Handler handler = this.f20803c;
        if (handler == null) {
            return false;
        }
        handler.post(new c(i10, i11));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i10, int i11) {
        Handler handler = this.f20803c;
        if (handler != null && this.f20804d != null) {
            handler.post(new d(i10, i11));
        }
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Handler handler = this.f20803c;
        if (handler == null) {
            return;
        }
        handler.post(new RunnableC0627k());
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        Handler handler = this.f20803c;
        if (handler == null) {
            return;
        }
        handler.post(new b());
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        com.sigmob.sdk.videoplayer.i iVar = this.f20804d;
        if (iVar == null) {
            return;
        }
        SurfaceTexture surfaceTexture2 = this.f20801a;
        if (surfaceTexture2 != null) {
            iVar.setSurfaceTexture(surfaceTexture2);
        } else {
            this.f20801a = surfaceTexture;
            g();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i10, int i11) {
        Handler handler = this.f20803c;
        if (handler == null) {
            return;
        }
        handler.post(new e(i10, i11));
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public long a() {
        if (this.f20806e != null) {
            return r0.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public void b(float f10) {
        Handler handler = this.f20802b;
        if (handler == null) {
            return;
        }
        handler.post(new j(f10));
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public void a(long j10) {
        Handler handler = this.f20802b;
        if (handler == null) {
            return;
        }
        handler.post(new h(j10));
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public void a(boolean z10) {
        MediaPlayer mediaPlayer = this.f20806e;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setLooping(z10);
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public void a(float f10) {
        PlaybackParams playbackParams;
        MediaPlayer mediaPlayer = this.f20806e;
        if (mediaPlayer != null && Build.VERSION.SDK_INT >= 23) {
            playbackParams = mediaPlayer.getPlaybackParams();
            playbackParams.setSpeed(f10);
            this.f20806e.setPlaybackParams(playbackParams);
        }
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public void a(Surface surface) {
        MediaPlayer mediaPlayer = this.f20806e;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setSurface(surface);
    }
}
