package cn.vlion.ad.inland.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import cn.vlion.ad.inland.base.a7;
import cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener;
import cn.vlion.ad.inland.base.util.VlionHandlerUtils;
import cn.vlion.ad.inland.base.util.app.VlionAppInfo;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.util.Random;

/* loaded from: classes.dex */
public abstract class e1 extends FrameLayout {

    /* renamed from: a */
    public Context f2720a;

    /* renamed from: b */
    public boolean f2721b;

    /* renamed from: c */
    public boolean f2722c;

    /* renamed from: d */
    public boolean f2723d;

    /* renamed from: e */
    public boolean f2724e;

    /* renamed from: f */
    public MediaPlayer f2725f;

    /* renamed from: g */
    public w0 f2726g;

    /* renamed from: h */
    public d1 f2727h;

    /* renamed from: i */
    public Surface f2728i;

    /* renamed from: j */
    public boolean f2729j;

    /* renamed from: k */
    public boolean f2730k;

    /* renamed from: l */
    public boolean f2731l;

    /* renamed from: m */
    public boolean f2732m;

    /* renamed from: n */
    public int f2733n;

    /* renamed from: o */
    public k f2734o;

    /* renamed from: p */
    public ImageView f2735p;

    /* renamed from: q */
    public int f2736q;

    /* renamed from: r */
    public int f2737r;

    /* renamed from: s */
    public c1 f2738s;

    /* renamed from: t */
    public volatile boolean f2739t;

    /* renamed from: u */
    public String f2740u;

    /* renamed from: v */
    public boolean f2741v;

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ boolean f2742a;

        public a(boolean z10) {
            this.f2742a = z10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Bitmap bitmap;
            try {
                e1 e1Var = e1.this;
                if (e1Var.f2724e && e1Var.f2735p == null) {
                    return;
                }
                d1 d1Var = e1Var.f2727h;
                if (d1Var != null && (bitmap = d1Var.getBitmap(d1Var.getWidth(), e1.this.f2727h.getHeight())) != null) {
                    e1.this.f2735p.setImageBitmap(bitmap);
                }
                e1.this.f2735p.setVisibility(0);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                e1.this.f2735p.setVisibility(this.f2742a ? 0 : 8);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            e1.this.h();
        }
    }

    public class c implements MediaPlayer.OnPreparedListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer mediaPlayer) {
            w0 w0Var;
            try {
                e1 e1Var = e1.this;
                e1Var.f2741v = true;
                if (e1Var.f2724e) {
                    return;
                }
                e1Var.f2736q = mediaPlayer.getVideoWidth();
                e1.this.f2737r = mediaPlayer.getVideoHeight();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("VlionBaseVideoView onPrepared null!=mSurfaceView =");
                sb2.append(e1.this.f2727h != null);
                LogVlion.e(sb2.toString());
                e1 e1Var2 = e1.this;
                d1 d1Var = e1Var2.f2727h;
                if (d1Var != null) {
                    int i10 = e1Var2.f2736q;
                    int i11 = e1Var2.f2737r;
                    d1Var.f2697b = i10;
                    d1Var.f2698c = i11;
                    LogVlion.e("VlionBaseVideoSurfaceView  setVideoDimension mVideoWidth= " + d1Var.f2697b + "  mVideoHeight= " + d1Var.f2698c);
                    e1.this.f2727h.requestLayout();
                }
                LogVlion.e("VlionBaseVideoViewCenter onPrepared isAutoPlay" + e1.this.f2722c + " ismClick=" + e1.this.f2730k);
                e1 e1Var3 = e1.this;
                if (!e1Var3.f2722c && !e1Var3.f2730k) {
                    e1Var3.a(true);
                    if (e1.this.f2738s != null) {
                        LogVlion.e("VlionBaseVideoViewCenter showProgressIcon = false  4444");
                        ((a7.b) e1.this.f2738s).a(false);
                        ((a7.b) e1.this.f2738s).b(true);
                    }
                    e1 e1Var4 = e1.this;
                    w0Var = e1Var4.f2726g;
                    if (w0Var != null || e1Var4.f2732m) {
                    }
                    LogVlion.e("VlionVideoViewBaseGroup onVideoLoad=");
                    VlionNativesAdVideoListener vlionNativesAdVideoListener = a7.this.f2629l;
                    if (vlionNativesAdVideoListener != null) {
                        vlionNativesAdVideoListener.onVideoLoad();
                    }
                    e1.this.f2732m = true;
                    return;
                }
                if (e1Var3.f2738s != null) {
                    LogVlion.e("VlionBaseVideoViewCenter showProgressIcon = false  3333");
                    ((a7.b) e1.this.f2738s).a(false);
                    ((a7.b) e1.this.f2738s).b(false);
                }
                e1.this.g();
                e1 e1Var42 = e1.this;
                w0Var = e1Var42.f2726g;
                if (w0Var != null) {
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class d implements MediaPlayer.OnErrorListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
            LogVlion.e("VlionBaseVideoViewCenter onError()" + i10 + " extra=" + i11);
            w0 w0Var = e1.this.f2726g;
            if (w0Var == null) {
                return true;
            }
            LogVlion.e("VlionVideoViewBaseGroup onVideoError errorCode=" + i10 + " extraCode=" + i11);
            VlionNativesAdVideoListener vlionNativesAdVideoListener = a7.this.f2629l;
            if (vlionNativesAdVideoListener == null) {
                return true;
            }
            vlionNativesAdVideoListener.onVideoError(i10, i11);
            return true;
        }
    }

    public class e implements MediaPlayer.OnSeekCompleteListener {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                e1 e1Var = e1.this;
                if (e1Var.f2722c || e1Var.f2730k) {
                    c1 c1Var = e1Var.f2738s;
                    if (c1Var != null) {
                        ((a7.b) c1Var).b(false);
                    }
                    e1.this.a(false);
                    e1 e1Var2 = e1.this;
                    if (e1Var2.f2725f != null) {
                        e1Var2.b();
                        return;
                    }
                    return;
                }
                boolean z10 = e1Var.f2731l;
                c1 c1Var2 = e1Var.f2738s;
                if (!z10) {
                    if (c1Var2 != null) {
                        LogVlion.e("VlionBaseVideoViewCenter showProgressIcon = true  6666");
                        ((a7.b) e1.this.f2738s).a(true);
                    }
                    c1Var2 = e1.this.f2738s;
                    if (c1Var2 == null) {
                        return;
                    }
                } else if (c1Var2 == null) {
                    return;
                }
                ((a7.b) c1Var2).b(true);
            }
        }

        public e() {
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                LogVlion.e("VlionBaseVideoViewCenter onSeekComplete isAutoPlay=" + e1.this.f2722c + "  ismClick=" + e1.this.f2730k);
                if (e1.this.f2724e) {
                    return;
                }
                VlionHandlerUtils.instant().post(new a());
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class f implements MediaPlayer.OnCompletionListener {
        public f() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("VlionBaseVideoViewCenter onCompletion() onAdVideoEnd  isLoop=");
                sb2.append(e1.this.f2723d);
                sb2.append(" isDestroy=");
                sb2.append(e1.this.f2724e);
                sb2.append(" (null != mMediaPlayer)=");
                sb2.append(e1.this.f2725f != null);
                LogVlion.e(sb2.toString());
                e1 e1Var = e1.this;
                if (e1Var.f2724e || e1Var.f2725f == null) {
                    return;
                }
                e1Var.f2729j = true;
                if (e1Var.f2723d) {
                    e1Var.g();
                } else {
                    c1 c1Var = e1Var.f2738s;
                    if (c1Var != null) {
                        ((a7.b) c1Var).b(true);
                    }
                }
                w0 w0Var = e1.this.f2726g;
                if (w0Var != null) {
                    LogVlion.e("VlionVideoViewBaseGroup onVideoAdComplete");
                    VlionNativesAdVideoListener vlionNativesAdVideoListener = a7.this.f2629l;
                    if (vlionNativesAdVideoListener != null) {
                        vlionNativesAdVideoListener.onVideoAdComplete();
                    }
                }
                e1 e1Var2 = e1.this;
                k kVar = e1Var2.f2734o;
                if (kVar != null) {
                    e1Var2.removeCallbacks(kVar);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class g implements MediaPlayer.OnVideoSizeChangedListener {
        public g() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i10, int i11) {
            LogVlion.e(" VlionBaseVideoOnLineView onVideoSizeChanged width=" + i10 + "  height=" + i11);
            LogVlion.e("VlionBaseVideoView onVideoSizeChanged() mVideoWidth=" + e1.this.f2736q + " width=" + i10 + "mVideoHeight = " + e1.this.f2737r + " height=" + i11);
            if (i10 > 0 && i11 > 0) {
                e1 e1Var = e1.this;
                if (i10 != e1Var.f2736q || i11 != e1Var.f2737r) {
                    LogVlion.e("VlionBaseVideoView onVideoSizeChanged() requestLayout=");
                    e1.this.f2736q = mediaPlayer.getVideoWidth();
                    e1.this.f2737r = mediaPlayer.getVideoHeight();
                    e1 e1Var2 = e1.this;
                    d1 d1Var = e1Var2.f2727h;
                    int i12 = e1Var2.f2736q;
                    int i13 = e1Var2.f2737r;
                    d1Var.f2697b = i12;
                    d1Var.f2698c = i13;
                    StringBuilder a10 = l1.a("VlionBaseVideoSurfaceView  setVideoDimension mVideoWidth= ");
                    a10.append(d1Var.f2697b);
                    a10.append("  mVideoHeight= ");
                    a10.append(d1Var.f2698c);
                    LogVlion.e(a10.toString());
                    e1.this.f2727h.requestLayout();
                }
            }
            LogVlion.e("VlionBaseVideoOnLineView mVideoCover onVideoSizeChanged getWidth==" + i10 + "  ---getHeight =" + i11);
        }
    }

    public class h implements TextureView.SurfaceTextureListener {

        /* renamed from: a */
        public final /* synthetic */ j f2751a;

        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ SurfaceTexture f2753a;

            public a(SurfaceTexture surfaceTexture) {
                this.f2753a = surfaceTexture;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    e1.this.f2728i = new Surface(this.f2753a);
                    e1 e1Var = e1.this;
                    e1Var.f2725f.setSurface(e1Var.f2728i);
                    j jVar = h.this.f2751a;
                    if (jVar != null) {
                        jVar.a();
                    }
                    e1.this.f2739t = true;
                    LogVlion.e("VlionBaseVideoViewCenter ----------------------");
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        public h(j jVar) {
            this.f2751a = jVar;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
            try {
                LogVlion.e("VlionBaseVideoViewCenter onSurfaceTextureAvailable width=" + i10 + " height=" + i11);
                d1 d1Var = e1.this.f2727h;
                if (d1Var != null) {
                    d1Var.post(new a(surfaceTexture));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
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
    }

    public class i implements j {
        public i() {
        }

        @Override // cn.vlion.ad.inland.base.e1.j
        public final void a() {
            try {
                e1.this.b();
                w0 w0Var = e1.this.f2726g;
                if (w0Var != null) {
                    LogVlion.e("VlionVideoViewBaseGroup onVideoAdStartPlay");
                    VlionNativesAdVideoListener vlionNativesAdVideoListener = a7.this.f2629l;
                    if (vlionNativesAdVideoListener != null) {
                        vlionNativesAdVideoListener.onVideoAdStartPlay();
                    }
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public interface j {
        void a();
    }

    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                LogVlion.e("VlionBaseVideoViewCenter run()");
                MediaPlayer mediaPlayer = e1.this.f2725f;
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    e1 e1Var = e1.this;
                    if (e1Var.f2726g != null) {
                        int duration = e1Var.f2725f.getDuration();
                        int round = Math.round(e1.this.f2725f.getCurrentPosition() / 1000.0f);
                        int round2 = Math.round(duration / 1000.0f);
                        LogVlion.e("VlionBaseVideoViewCenter onAdVideoPlaying current=" + round + "  total=" + round2);
                        w0 w0Var = e1.this.f2726g;
                        if (w0Var != null) {
                            LogVlion.e("VlionVideoViewBaseGroup onVideoError current=" + round + " total=" + round2);
                            VlionNativesAdVideoListener vlionNativesAdVideoListener = a7.this.f2629l;
                            if (vlionNativesAdVideoListener != null) {
                                vlionNativesAdVideoListener.onProgressUpdate(round, round2);
                            }
                        }
                        e1.this.getClass();
                        e1 e1Var2 = e1.this;
                        e1Var2.postDelayed(e1Var2.f2734o, 1000L);
                        return;
                    }
                }
                e1.this.getClass();
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        public /* synthetic */ k(e1 e1Var, int i10) {
            this();
        }
    }

    public e1(Context context) {
        this(context, 0);
    }

    public void a() {
        try {
            LogVlion.e("VlionBaseVideoViewCenter destroy--=");
            this.f2724e = true;
            MediaPlayer mediaPlayer = this.f2725f;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                this.f2725f.release();
                this.f2725f = null;
            }
            Surface surface = this.f2728i;
            if (surface != null) {
                surface.release();
                this.f2728i = null;
            }
            if (this.f2727h != null) {
                this.f2727h = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void b() {
        StringBuilder a10 = l1.a("VlionBaseVideoViewCenter mediaPlayerStart isExposurePlay=");
        a10.append(this.f2731l);
        LogVlion.e(a10.toString());
        try {
            MediaPlayer mediaPlayer = this.f2725f;
            if (mediaPlayer != null) {
                if (!this.f2731l) {
                    h();
                    return;
                }
                mediaPlayer.start();
                try {
                    LogVlion.e("VlionBaseVideoViewCenter startUpdateTimer---isShown ==" + isShown());
                    try {
                        LogVlion.e("VlionBaseVideoViewCenter cancelUpdateTimer");
                        k kVar = this.f2734o;
                        if (kVar != null) {
                            removeCallbacks(kVar);
                        }
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                    k kVar2 = this.f2734o;
                    if (kVar2 != null) {
                        post(kVar2);
                    }
                } catch (Throwable th3) {
                    VlionSDkManager.getInstance().upLoadCatchException(th3);
                }
                try {
                    if (this.f2721b) {
                        try {
                            LogVlion.e("VlionBaseVideoViewCenter closeVolume()");
                            MediaPlayer mediaPlayer2 = this.f2725f;
                            if (mediaPlayer2 != null) {
                                mediaPlayer2.setVolume(0.001f, 0.001f);
                            }
                        } catch (Throwable th4) {
                            VlionSDkManager.getInstance().upLoadCatchException(th4);
                        }
                    } else {
                        c();
                    }
                } catch (Throwable th5) {
                    VlionSDkManager.getInstance().upLoadCatchException(th5);
                }
                a(false);
            }
        } catch (Throwable th6) {
            VlionSDkManager.getInstance().upLoadCatchException(th6);
        }
    }

    public final void c() {
        try {
            float systemVolume = VlionAppInfo.getInstance().getSystemVolume(this.f2720a);
            LogVlion.e("VlionBaseVideoViewCenter openVolume+++volume=" + systemVolume);
            if (systemVolume == 0.0f) {
                systemVolume = 0.1f;
            }
            LogVlion.e("VlionBaseVideoViewCenter openVolume  volume=" + systemVolume);
            MediaPlayer mediaPlayer = this.f2725f;
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(systemVolume, systemVolume);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void d() {
        try {
            MediaPlayer mediaPlayer = this.f2725f;
            if (mediaPlayer != null) {
                mediaPlayer.setOnPreparedListener(new c());
                this.f2725f.setOnErrorListener(new d());
                this.f2725f.setOnSeekCompleteListener(new e());
                this.f2725f.setOnCompletionListener(new f());
                e();
                try {
                    this.f2725f.setOnVideoSizeChangedListener(new g());
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public abstract void e();

    public final void f() {
        try {
            this.f2730k = false;
            LogVlion.e("VlionBaseVideoViewCenter startExposureVideo isExposurePlay= " + this.f2731l + " isOnPrepared=" + this.f2741v + " isAutoPlay=" + this.f2722c + " ismClick=" + this.f2730k + " isLoop=" + this.f2723d + " isCompletion=" + this.f2729j);
            if (this.f2725f != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("VlionBaseVideoViewCenter startExposureVideo !mMediaPlayer.isPlaying()=");
                sb2.append(!this.f2725f.isPlaying());
                sb2.append(" isOnPrepared=");
                sb2.append(this.f2741v);
                LogVlion.e(sb2.toString());
            }
            if (this.f2722c) {
                if (!this.f2723d && this.f2729j) {
                    return;
                }
                g();
                return;
            }
            MediaPlayer mediaPlayer = this.f2725f;
            if (mediaPlayer == null || mediaPlayer.isPlaying() || !this.f2741v) {
                return;
            }
            c1 c1Var = this.f2738s;
            if (c1Var != null) {
                ((a7.b) c1Var).b(true);
            }
            if (this.f2738s != null) {
                LogVlion.e("VlionBaseVideoViewCenter showProgressIcon = false  1111");
                ((a7.b) this.f2738s).a(false);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void g() {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("VlionBaseVideoViewCenter startVideo null!= mMediaPlayer=");
            int i10 = 0;
            sb2.append(this.f2725f != null);
            LogVlion.e(sb2.toString());
            MediaPlayer mediaPlayer = this.f2725f;
            if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                int currentPosition = this.f2725f.getCurrentPosition();
                LogVlion.e("VlionBaseVideoViewCenter startVideo current=" + currentPosition);
                LogVlion.e("VlionBaseVideoViewCenter startVideo isAutoPlay=" + this.f2722c);
                LogVlion.e("VlionBaseVideoViewCenter onResumeVideo getDuration=" + this.f2725f.getDuration());
                LogVlion.e("VlionBaseVideoViewCenter isCompletion current=" + this.f2729j);
                if (!this.f2729j) {
                    i10 = currentPosition;
                }
                if (i10 <= 0) {
                    LogVlion.e("VlionBaseVideoViewCenter isSurfacePrepared=" + this.f2739t);
                    if (this.f2739t) {
                        b();
                        w0 w0Var = this.f2726g;
                        if (w0Var != null) {
                            LogVlion.e("VlionVideoViewBaseGroup onVideoAdStartPlay");
                            VlionNativesAdVideoListener vlionNativesAdVideoListener = a7.this.f2629l;
                            if (vlionNativesAdVideoListener != null) {
                                vlionNativesAdVideoListener.onVideoAdStartPlay();
                            }
                        }
                    } else {
                        a(new i());
                    }
                } else if (Build.VERSION.SDK_INT >= 26) {
                    this.f2725f.seekTo(i10, 3);
                } else {
                    this.f2725f.seekTo(i10);
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void h() {
        try {
            try {
                LogVlion.e("VlionBaseVideoViewCenter cancelUpdateTimer");
                k kVar = this.f2734o;
                if (kVar != null) {
                    removeCallbacks(kVar);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            LogVlion.e("VlionBaseVideoViewCenter stopVideo --:");
            MediaPlayer mediaPlayer = this.f2725f;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            LogVlion.e("VlionBaseVideoViewCenter mMediaPlayer.pause():");
            this.f2725f.pause();
            a(true);
            w0 w0Var = this.f2726g;
            if (w0Var != null) {
                LogVlion.e("VlionVideoViewBaseGroup onVideoAdPaused");
                VlionNativesAdVideoListener vlionNativesAdVideoListener = a7.this.f2629l;
                if (vlionNativesAdVideoListener != null) {
                    vlionNativesAdVideoListener.onVideoAdPaused();
                }
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            LogVlion.e("VlionBaseVideoViewCenter onDetachedFromWindow onDetachedFromWindow------isStarted=");
            post(new b());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    public void setAdVideoListener(w0 w0Var) {
        this.f2726g = w0Var;
    }

    public void setAutoPlay(boolean z10) {
        this.f2722c = z10;
    }

    public void setClosedVolumePlay(boolean z10) {
        try {
            LogVlion.e("VlionBaseVideoViewCenter setClosedVolumePlay=" + z10);
            this.f2721b = z10;
            try {
                if (z10) {
                    try {
                        LogVlion.e("VlionBaseVideoViewCenter closeVolume()");
                        MediaPlayer mediaPlayer = this.f2725f;
                        if (mediaPlayer != null) {
                            mediaPlayer.setVolume(0.001f, 0.001f);
                        }
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                } else {
                    c();
                }
            } catch (Throwable th3) {
                VlionSDkManager.getInstance().upLoadCatchException(th3);
            }
        } catch (Throwable th4) {
            VlionSDkManager.getInstance().upLoadCatchException(th4);
        }
    }

    public void setExposurePlay(boolean z10) {
        this.f2731l = z10;
    }

    public void setLoop(boolean z10) {
        this.f2723d = z10;
    }

    public void setVideoScaleMode(int i10) {
        String str;
        LogVlion.e("VlionBaseVideoViewCenter setVideoScaleMode=" + i10);
        d1 d1Var = this.f2727h;
        if (d1Var != null) {
            d1Var.setVideoScaleMode(i10);
        }
        if (this.f2735p != null) {
            ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_CENTER;
            if (i10 == 2) {
                scaleType = ImageView.ScaleType.CENTER_CROP;
                str = "VlionBaseVideoViewCenter scale=CENTER_CROP";
            } else {
                if (i10 != 3) {
                    if (i10 == 4) {
                        str = "VlionBaseVideoViewCenter scale=FIT_CENTER";
                    }
                    this.f2735p.setScaleType(scaleType);
                }
                scaleType = ImageView.ScaleType.FIT_XY;
                str = "VlionBaseVideoViewCenter scale=FIT_XY";
            }
            LogVlion.e(str);
            this.f2735p.setScaleType(scaleType);
        }
    }

    public void setVlionBaseVideoStatueController(c1 c1Var) {
        this.f2738s = c1Var;
    }

    public e1(Context context, int i10) {
        super(context, null, 0);
        this.f2721b = true;
        this.f2722c = false;
        this.f2723d = false;
        this.f2724e = false;
        this.f2729j = false;
        this.f2730k = false;
        this.f2732m = false;
        this.f2733n = 0;
        this.f2736q = 0;
        this.f2737r = 0;
        this.f2740u = "";
        this.f2741v = false;
        try {
            this.f2720a = context;
            this.f2725f = new MediaPlayer();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            d1 d1Var = new d1(this.f2720a);
            this.f2727h = d1Var;
            addView(d1Var, layoutParams);
            this.f2727h.setMeasuredDimensionListener(new f1(this));
            a((j) null);
            this.f2734o = new k(this, 0);
            this.f2733n = new Random().nextInt();
            LogVlion.e("VlionBaseVideoViewCenter serialNumber ==========" + this.f2733n);
            ImageView imageView = new ImageView(this.f2720a);
            this.f2735p = imageView;
            imageView.setVisibility(8);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams2.gravity = 17;
            addView(this.f2735p, layoutParams2);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(j jVar) {
        try {
            if (this.f2727h == null || this.f2725f == null) {
                return;
            }
            LogVlion.e("VlionBaseVideoViewCenter bindMediaPlayer ----------------------");
            this.f2727h.setSurfaceTextureListener(new h(jVar));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void a(String str, String str2) {
        try {
            d();
            MediaPlayer mediaPlayer = this.f2725f;
            if (mediaPlayer != null) {
                this.f2740u = str;
                mediaPlayer.reset();
                this.f2725f.setDataSource(str);
                this.f2725f.prepareAsync();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            try {
                VlionSDkManager.getInstance().upLoadCatchException(new Throwable("setDataSource error filepath = " + str));
            } catch (Throwable unused) {
            }
        }
    }

    public final void a(boolean z10) {
        LogVlion.e("VlionBaseVideoViewCenter showFirstImageView isShow=" + z10);
        try {
            if (this.f2735p != null) {
                if (!z10 || this.f2725f == null || TextUtils.isEmpty(this.f2740u) || this.f2725f.getCurrentPosition() <= 1000) {
                    this.f2735p.setVisibility(z10 ? 0 : 8);
                } else {
                    LogVlion.e("VlionBaseVideoViewCenter videoPath=" + this.f2740u);
                    this.f2735p.post(new a(z10));
                }
            }
        } catch (Throwable th2) {
            this.f2735p.setVisibility(z10 ? 0 : 8);
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
