package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.core.video.a.e;
import com.kwad.sdk.core.video.a.f;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.i;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@Deprecated
/* loaded from: classes3.dex */
public final class a extends AdBasePvFrameLayout implements TextureView.SurfaceTextureListener, c {
    private static AtomicBoolean aFS = new AtomicBoolean(false);
    private com.kwad.sdk.core.video.a.c WA;
    private int WB;
    private long WC;
    private com.kwad.sdk.contentalliance.a.a.b WE;
    private c.e WO;
    private c.i WP;
    private c.b WQ;
    private c.InterfaceC0500c WR;
    private c.d WS;
    private c.a WT;
    private int Wz;
    private SurfaceTexture Xb;
    private Surface Xc;
    private AudioManager aFO;
    private com.kwad.sdk.core.video.a aFP;
    private b aFQ;
    private boolean aFR;
    private boolean aFT;
    private boolean aFU;
    private ImageView aFV;
    private com.kwad.sdk.contentalliance.a.a.a eq;

    /* renamed from: jg */
    private FrameLayout f11974jg;
    private Context mContext;
    private Map<String, String> mHeaders;
    private String mUrl;

    /* renamed from: com.kwad.sdk.core.video.videoview.a$1 */
    public class AnonymousClass1 implements c.e {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.video.a.c.e
        public final void a(com.kwad.sdk.core.video.a.c cVar) {
            try {
                a.this.Wz = 2;
                a.this.aFQ.onPlayStateChanged(a.this.Wz);
                com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onPrepared ——> STATE_PREPARED");
                cVar.start();
                if (a.this.aFR) {
                    cVar.seekTo((int) ad.U(a.this.mContext, a.this.mUrl));
                }
                if (a.this.WC != 0) {
                    cVar.seekTo((int) a.this.WC);
                }
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    /* renamed from: com.kwad.sdk.core.video.videoview.a$2 */
    public class AnonymousClass2 implements c.i {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.video.a.c.i
        public final void k(int i10, int i11) {
            if (!a.this.aFU || i11 <= i10) {
                a.this.aFP.adaptVideoSize(i10, i11);
                com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onVideoSizeChanged ——> width：" + i10 + "， height：" + i11);
            }
        }
    }

    /* renamed from: com.kwad.sdk.core.video.videoview.a$3 */
    public class AnonymousClass3 implements c.b {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.video.a.c.b
        public final void pO() {
            if (a.this.Wz != 9) {
                a.this.Wz = 9;
                a.this.aFQ.onPlayStateChanged(a.this.Wz);
                com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onCompletion ——> STATE_COMPLETED");
                a.this.f11974jg.setKeepScreenOn(false);
            }
        }
    }

    /* renamed from: com.kwad.sdk.core.video.videoview.a$4 */
    public class AnonymousClass4 implements c.InterfaceC0500c {
        public AnonymousClass4() {
        }

        @Override // com.kwad.sdk.core.video.a.c.InterfaceC0500c
        public final boolean l(int i10, int i11) {
            if (i10 == -38) {
                return true;
            }
            a.this.Wz = -1;
            a.this.aFQ.n(i10, i11);
            a.this.aFQ.onPlayStateChanged(a.this.Wz);
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onError ——> STATE_ERROR ———— what：" + i10 + ", extra: " + i11);
            return true;
        }
    }

    /* renamed from: com.kwad.sdk.core.video.videoview.a$5 */
    public class AnonymousClass5 implements c.d {
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.core.video.a.c.d
        public final boolean m(int i10, int i11) {
            if (i10 == 3) {
                a.this.Wz = 4;
                a.this.aFQ.onPlayStateChanged(a.this.Wz);
                com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING");
                return true;
            }
            if (i10 == 701) {
                if (a.this.Wz == 5 || a.this.Wz == 7) {
                    a.this.Wz = 7;
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED");
                } else {
                    a.this.Wz = 6;
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING");
                }
                a.this.aFQ.onPlayStateChanged(a.this.Wz);
                return true;
            }
            if (i10 == 702) {
                if (a.this.Wz == 6) {
                    a.this.Wz = 4;
                    a.this.aFQ.onPlayStateChanged(a.this.Wz);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                }
                if (a.this.Wz != 7) {
                    return true;
                }
                a.this.Wz = 5;
                a.this.aFQ.onPlayStateChanged(a.this.Wz);
                com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED");
                return true;
            }
            if (i10 == 10001) {
                if (a.this.aFP == null) {
                    return true;
                }
                a.this.aFP.setRotation(i11);
                com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "视频旋转角度：" + i11);
                return true;
            }
            if (i10 == 801) {
                com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "视频不能seekTo，为直播视频");
                return true;
            }
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> what：" + i10);
            return true;
        }
    }

    /* renamed from: com.kwad.sdk.core.video.videoview.a$6 */
    public class AnonymousClass6 implements c.a {
        public AnonymousClass6() {
        }

        @Override // com.kwad.sdk.core.video.a.c.a
        public final void aw(int i10) {
            a.this.WB = i10;
        }
    }

    /* renamed from: com.kwad.sdk.core.video.videoview.a$7 */
    public class AnonymousClass7 extends bd {
        public AnonymousClass7() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            a.this.f11974jg.removeView(a.this.aFP);
        }
    }

    public a(Context context) {
        this(context, null);
    }

    private ImageView HW() {
        ImageView imageView = new ImageView(this.mContext);
        addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        return imageView;
    }

    private boolean HX() {
        return this.Wz == 6;
    }

    private void HZ() {
        if (this.WA == null) {
            f fVar = (f) ServiceProvider.get(f.class);
            com.kwad.sdk.core.video.a.c a10 = e.a(this.mContext, false, fVar != null && fVar.zz(), fVar != null && fVar.zA(), 0);
            this.WA = a10;
            a10.setAudioStreamType(3);
            if (this.aFT) {
                return;
            }
            this.WA.setVolume(0.0f, 0.0f);
        }
    }

    private void Ia() {
        this.f11974jg.removeView(this.aFP);
        this.f11974jg.addView(this.aFP, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private void Ib() {
        com.kwad.sdk.contentalliance.a.a.a aVar;
        this.f11974jg.setKeepScreenOn(true);
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        if (cVar == null) {
            com.kwad.sdk.core.d.c.w("KSVideoPlayerViewView", "mMediaPlayer is null");
            return;
        }
        cVar.b(this.WO);
        this.WA.a(this.WP);
        this.WA.a(this.WQ);
        this.WA.a(this.WR);
        this.WA.c(this.WS);
        this.WA.a(this.WT);
        try {
            com.kwad.sdk.contentalliance.a.a.b bVar = this.WE;
            if (bVar != null && (aVar = this.eq) != null) {
                bVar.asp = aVar;
            }
            this.WA.a(bVar);
            if (this.Xc == null) {
                this.Xc = new Surface(this.Xb);
            }
            this.WA.setSurface(this.Xc);
            if (this.WA.prepareAsync()) {
                this.Wz = 1;
                this.aFQ.onPlayStateChanged(1);
                com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "STATE_PREPARING");
            }
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
            com.kwad.sdk.core.d.c.e("KSVideoPlayerViewView", "打开播放器发生错误", e10);
        }
    }

    private void Ic() {
        AudioManager audioManager = this.aFO;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
            this.aFO = null;
        }
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        if (cVar != null) {
            cVar.release();
            this.WA = null;
            com.kwad.sdk.core.video.a.a.a.eH("videoFinishPlay");
        }
        bt.runOnUiThread(new bd() { // from class: com.kwad.sdk.core.video.videoview.a.7
            public AnonymousClass7() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                a.this.f11974jg.removeView(a.this.aFP);
            }
        });
        Surface surface = this.Xc;
        if (surface != null) {
            surface.release();
            this.Xc = null;
        }
        SurfaceTexture surfaceTexture = this.Xb;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.Xb = null;
        }
        this.Wz = 0;
    }

    private void ew(AdTemplate adTemplate) {
        i iVar = (i) ServiceProvider.get(i.class);
        if (iVar != null) {
            iVar.load(this.aFV, com.kwad.sdk.core.response.b.e.ef(adTemplate), adTemplate);
        }
    }

    private void init() {
        this.aFV = HW();
        this.f11974jg = new FrameLayout(this.mContext);
        addView(this.f11974jg, new FrameLayout.LayoutParams(-1, -1));
    }

    private void sC() {
        if (this.aFP == null) {
            com.kwad.sdk.core.video.a aVar = new com.kwad.sdk.core.video.a(this.mContext);
            this.aFP = aVar;
            aVar.setSurfaceTextureListener(this);
        }
    }

    private void setPlayType(int i10) {
        VideoPlayerStatus videoPlayerStatus;
        com.kwad.sdk.contentalliance.a.a.b bVar = this.WE;
        if (bVar == null || (videoPlayerStatus = bVar.videoPlayerStatus) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i10;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean HY() {
        return this.Wz == 7;
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, Map<String, String> map) {
        this.WE = bVar;
        this.mUrl = bVar.videoUrl;
        this.mHeaders = null;
        ew(bVar.adTemplate);
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final int getBufferPercentage() {
        return this.WB;
    }

    public final b getController() {
        return this.aFQ;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final long getCurrentPosition() {
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final long getDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        if (cVar != null) {
            return cVar.getDuration();
        }
        return 0L;
    }

    public final int getMaxVolume() {
        AudioManager audioManager = this.aFO;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 0;
    }

    public final b getVideoController() {
        return this.aFQ;
    }

    public final int getVolume() {
        AudioManager audioManager = this.aFO;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    public final boolean isCompleted() {
        return this.Wz == 9;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean isIdle() {
        return this.Wz == 0;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean isPaused() {
        return this.Wz == 5;
    }

    public final boolean isPlaying() {
        return this.Wz == 4;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        SurfaceTexture surfaceTexture2 = this.Xb;
        if (surfaceTexture2 != null) {
            this.aFP.setSurfaceTexture(surfaceTexture2);
        } else {
            this.Xb = surfaceTexture;
            Ib();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void pause() {
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        if (cVar == null) {
            return;
        }
        int i10 = this.Wz;
        if (i10 == 4) {
            cVar.pause();
            com.kwad.sdk.core.video.a.a.a.eH("videoPausePlay");
            this.Wz = 5;
            this.aFQ.onPlayStateChanged(5);
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "STATE_PAUSED");
            return;
        }
        if (i10 == 6) {
            cVar.pause();
            com.kwad.sdk.core.video.a.a.a.eH("videoPausePlay");
            this.Wz = 7;
            this.aFQ.onPlayStateChanged(7);
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "STATE_BUFFERING_PAUSED");
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void release() {
        if (this.aFR) {
            if (isPlaying() || HX() || HY() || isPaused()) {
                ad.e(this.mContext, this.mUrl, getCurrentPosition());
            } else if (isCompleted()) {
                ad.e(this.mContext, this.mUrl, 0L);
            }
        }
        Ic();
        b bVar = this.aFQ;
        if (bVar != null) {
            bVar.reset();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void restart() {
        int i10 = this.Wz;
        if (i10 == 5) {
            this.WA.start();
            com.kwad.sdk.core.video.a.a.a.eH("videoResumePlay");
            this.Wz = 4;
            this.aFQ.onPlayStateChanged(4);
            setPlayType(2);
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "STATE_PLAYING");
            return;
        }
        if (i10 == 7) {
            this.WA.start();
            com.kwad.sdk.core.video.a.a.a.eH("videoResumePlay");
            this.Wz = 6;
            this.aFQ.onPlayStateChanged(6);
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "STATE_BUFFERING_PLAYING");
            return;
        }
        if (i10 == 9 || i10 == -1) {
            this.WA.reset();
            Ib();
            setPlayType(3);
        } else {
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "KSVideoPlayer在状态为 " + this.Wz + " 时不能调用restart()方法.");
        }
    }

    public final void seekTo(int i10) {
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        if (cVar != null) {
            cVar.seekTo(i10);
        }
    }

    public final void setController(b bVar) {
        this.f11974jg.removeView(this.aFQ);
        this.aFQ = bVar;
        bVar.reset();
        this.f11974jg.addView(this.aFQ, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void setKsPlayLogParam(@NonNull com.kwad.sdk.contentalliance.a.a.a aVar) {
        this.eq = aVar;
    }

    public final void setLooping(boolean z10) {
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        if (cVar != null) {
            cVar.setLooping(z10);
        }
    }

    public final void setPortraitFullscreen(boolean z10) {
        this.aFU = z10;
    }

    public final void setVideoSoundEnable(boolean z10) {
        this.aFT = z10;
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        if (cVar != null) {
            if (z10) {
                cVar.setVolume(1.0f, 1.0f);
            } else {
                cVar.setVolume(0.0f, 0.0f);
            }
        }
    }

    public final void setVolume(int i10) {
        AudioManager audioManager = this.aFO;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i10, 0);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void start() {
        VideoPlayerStatus videoPlayerStatus;
        if (this.Wz != 0) {
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "KSVideoPlayer只有在状态为STATE_IDLE时才能调用start方法.");
            return;
        }
        HZ();
        sC();
        Ia();
        com.kwad.sdk.contentalliance.a.a.b bVar = this.WE;
        if (bVar != null && (videoPlayerStatus = bVar.videoPlayerStatus) != null) {
            if (videoPlayerStatus.mVideoPlayerType == 0) {
                setPlayType(1);
            } else {
                setPlayType(3);
            }
        }
        com.kwad.sdk.core.video.a.a.a.eH("videoStartPlay");
    }

    private a(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.Wz = 0;
        this.aFR = false;
        this.aFT = false;
        this.aFU = false;
        this.WO = new c.e() { // from class: com.kwad.sdk.core.video.videoview.a.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    a.this.Wz = 2;
                    a.this.aFQ.onPlayStateChanged(a.this.Wz);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onPrepared ——> STATE_PREPARED");
                    cVar.start();
                    if (a.this.aFR) {
                        cVar.seekTo((int) ad.U(a.this.mContext, a.this.mUrl));
                    }
                    if (a.this.WC != 0) {
                        cVar.seekTo((int) a.this.WC);
                    }
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }
        };
        this.WP = new c.i() { // from class: com.kwad.sdk.core.video.videoview.a.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.core.video.a.c.i
            public final void k(int i10, int i11) {
                if (!a.this.aFU || i11 <= i10) {
                    a.this.aFP.adaptVideoSize(i10, i11);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onVideoSizeChanged ——> width：" + i10 + "， height：" + i11);
                }
            }
        };
        this.WQ = new c.b() { // from class: com.kwad.sdk.core.video.videoview.a.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.video.a.c.b
            public final void pO() {
                if (a.this.Wz != 9) {
                    a.this.Wz = 9;
                    a.this.aFQ.onPlayStateChanged(a.this.Wz);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onCompletion ——> STATE_COMPLETED");
                    a.this.f11974jg.setKeepScreenOn(false);
                }
            }
        };
        this.WR = new c.InterfaceC0500c() { // from class: com.kwad.sdk.core.video.videoview.a.4
            public AnonymousClass4() {
            }

            @Override // com.kwad.sdk.core.video.a.c.InterfaceC0500c
            public final boolean l(int i10, int i11) {
                if (i10 == -38) {
                    return true;
                }
                a.this.Wz = -1;
                a.this.aFQ.n(i10, i11);
                a.this.aFQ.onPlayStateChanged(a.this.Wz);
                com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onError ——> STATE_ERROR ———— what：" + i10 + ", extra: " + i11);
                return true;
            }
        };
        this.WS = new c.d() { // from class: com.kwad.sdk.core.video.videoview.a.5
            public AnonymousClass5() {
            }

            @Override // com.kwad.sdk.core.video.a.c.d
            public final boolean m(int i10, int i11) {
                if (i10 == 3) {
                    a.this.Wz = 4;
                    a.this.aFQ.onPlayStateChanged(a.this.Wz);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING");
                    return true;
                }
                if (i10 == 701) {
                    if (a.this.Wz == 5 || a.this.Wz == 7) {
                        a.this.Wz = 7;
                        com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED");
                    } else {
                        a.this.Wz = 6;
                        com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING");
                    }
                    a.this.aFQ.onPlayStateChanged(a.this.Wz);
                    return true;
                }
                if (i10 == 702) {
                    if (a.this.Wz == 6) {
                        a.this.Wz = 4;
                        a.this.aFQ.onPlayStateChanged(a.this.Wz);
                        com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (a.this.Wz != 7) {
                        return true;
                    }
                    a.this.Wz = 5;
                    a.this.aFQ.onPlayStateChanged(a.this.Wz);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED");
                    return true;
                }
                if (i10 == 10001) {
                    if (a.this.aFP == null) {
                        return true;
                    }
                    a.this.aFP.setRotation(i11);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "视频旋转角度：" + i11);
                    return true;
                }
                if (i10 == 801) {
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "视频不能seekTo，为直播视频");
                    return true;
                }
                com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> what：" + i10);
                return true;
            }
        };
        this.WT = new c.a() { // from class: com.kwad.sdk.core.video.videoview.a.6
            public AnonymousClass6() {
            }

            @Override // com.kwad.sdk.core.video.a.c.a
            public final void aw(int i10) {
                a.this.WB = i10;
            }
        };
        this.mContext = context;
        init();
    }
}
