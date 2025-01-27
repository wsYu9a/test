package cn.vlion.ad.inland.ad.view.video;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.FrameLayout;
import cn.vlion.ad.inland.base.f0;
import cn.vlion.ad.inland.base.g1;
import cn.vlion.ad.inland.base.i1;
import cn.vlion.ad.inland.base.l1;
import cn.vlion.ad.inland.base.util.VlionHandlerUtils;
import cn.vlion.ad.inland.base.util.app.VlionAppInfo;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.w5;
import java.io.File;

/* loaded from: classes.dex */
public class VlionBaseVideoView extends FrameLayout implements cn.vlion.ad.inland.base.d {

    /* renamed from: a */
    public Context f2496a;

    /* renamed from: b */
    public f0 f2497b;

    /* renamed from: c */
    public SurfaceHolder f2498c;

    /* renamed from: d */
    public MediaPlayer f2499d;

    /* renamed from: e */
    public boolean f2500e;

    /* renamed from: f */
    public boolean f2501f;

    /* renamed from: g */
    public boolean f2502g;

    /* renamed from: h */
    public boolean f2503h;

    /* renamed from: i */
    public i f2504i;

    /* renamed from: j */
    public boolean f2505j;

    /* renamed from: k */
    public cn.vlion.ad.inland.base.c f2506k;

    /* renamed from: l */
    public int f2507l;

    /* renamed from: m */
    public int f2508m;

    /* renamed from: n */
    public boolean f2509n;

    /* renamed from: o */
    public String f2510o;

    public class a implements MediaPlayer.OnPreparedListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer mediaPlayer) {
            try {
                LogVlion.e("VlionBaseVideoView onPrepared getCurrentPosition" + Math.round(VlionBaseVideoView.this.f2499d.getCurrentPosition() / 1000.0f));
                cn.vlion.ad.inland.base.c cVar = VlionBaseVideoView.this.f2506k;
                if (cVar != null) {
                    g1 g1Var = ((w5) cVar).f3483a.f2323a;
                    if (g1Var != null) {
                        g1Var.onAdVideoStart();
                    }
                    VlionBaseVideoView.this.f2506k.getClass();
                }
                VlionBaseVideoView vlionBaseVideoView = VlionBaseVideoView.this;
                boolean z10 = true;
                vlionBaseVideoView.f2502g = true;
                vlionBaseVideoView.f2500e = true;
                vlionBaseVideoView.f2507l = mediaPlayer.getVideoWidth();
                VlionBaseVideoView.this.f2508m = mediaPlayer.getVideoHeight();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("VlionBaseVideoView onPrepared null!=mSurfaceView =");
                if (VlionBaseVideoView.this.f2497b == null) {
                    z10 = false;
                }
                sb2.append(z10);
                LogVlion.e(sb2.toString());
                VlionBaseVideoView vlionBaseVideoView2 = VlionBaseVideoView.this;
                f0 f0Var = vlionBaseVideoView2.f2497b;
                if (f0Var != null) {
                    int i10 = vlionBaseVideoView2.f2507l;
                    int i11 = vlionBaseVideoView2.f2508m;
                    f0Var.f2775b = i10;
                    f0Var.f2776c = i11;
                    f0Var.requestLayout();
                }
                VlionBaseVideoView.this.f();
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements MediaPlayer.OnErrorListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
            try {
                LogVlion.e("VlionBaseVideoView onError()" + i10 + " extra=" + i11);
                cn.vlion.ad.inland.base.c cVar = VlionBaseVideoView.this.f2506k;
                if (cVar == null) {
                    return false;
                }
                i1 i1Var = i1.f2915e;
                w5 w5Var = (w5) cVar;
                try {
                    g1 g1Var = w5Var.f3483a.f2323a;
                    if (g1Var != null) {
                        g1Var.onAdPlayFailure(i1Var.f2920a, i1Var.f2921b);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                w5Var.f3483a.finish();
                return false;
            } catch (Throwable th3) {
                VlionSDkManager.getInstance().upLoadCatchException(th3);
                return false;
            }
        }
    }

    public class c implements MediaPlayer.OnCompletionListener {
        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
        }
    }

    public class d implements MediaPlayer.OnVideoSizeChangedListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i10, int i11) {
            int i12;
            try {
                LogVlion.e("VlionBaseVideoView onVideoSizeChanged() mVideoWidth=" + VlionBaseVideoView.this.f2507l + " width=" + i10 + "mVideoHeight = " + VlionBaseVideoView.this.f2508m + " height=" + i11);
                VlionBaseVideoView vlionBaseVideoView = VlionBaseVideoView.this;
                int i13 = vlionBaseVideoView.f2507l;
                if (i13 <= 0 || (i12 = vlionBaseVideoView.f2508m) <= 0) {
                    return;
                }
                if (i10 == i13 && i11 == i12) {
                    return;
                }
                LogVlion.e("VlionBaseVideoView onVideoSizeChanged() requestLayout=");
                VlionBaseVideoView.this.f2507l = mediaPlayer.getVideoWidth();
                VlionBaseVideoView.this.f2508m = mediaPlayer.getVideoHeight();
                VlionBaseVideoView vlionBaseVideoView2 = VlionBaseVideoView.this;
                f0 f0Var = vlionBaseVideoView2.f2497b;
                int i14 = vlionBaseVideoView2.f2507l;
                int i15 = vlionBaseVideoView2.f2508m;
                f0Var.f2775b = i14;
                f0Var.f2776c = i15;
                f0Var.requestLayout();
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class e implements MediaPlayer.OnInfoListener {
        @Override // android.media.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer mediaPlayer, int i10, int i11) {
            LogVlion.e("VlionBaseVideoView onInfo() what=" + i10 + " extra=" + i11);
            return false;
        }
    }

    public class f implements MediaPlayer.OnSeekCompleteListener {
        public f() {
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("VlionBaseVideoView onSeekComplete isAutoPlay=");
                sb2.append(VlionBaseVideoView.this.f2505j);
                sb2.append(" !isPaused=");
                sb2.append(!VlionBaseVideoView.this.f2501f);
                LogVlion.e(sb2.toString());
                VlionBaseVideoView vlionBaseVideoView = VlionBaseVideoView.this;
                if (!vlionBaseVideoView.f2505j || vlionBaseVideoView.f2501f) {
                    return;
                }
                MediaPlayer mediaPlayer2 = vlionBaseVideoView.f2499d;
                if (mediaPlayer2 != null) {
                    mediaPlayer2.start();
                }
                VlionBaseVideoView vlionBaseVideoView2 = VlionBaseVideoView.this;
                vlionBaseVideoView2.getClass();
                try {
                    LogVlion.e("VlionBaseVideoView startUpdateTimer");
                    try {
                        LogVlion.e("VlionBaseVideoView cancelUpdateTimer");
                        if (vlionBaseVideoView2.f2504i != null) {
                            VlionHandlerUtils.instant().removeCallbacks(vlionBaseVideoView2.f2504i);
                        }
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                    if (vlionBaseVideoView2.f2504i != null) {
                        VlionHandlerUtils.instant().post(vlionBaseVideoView2.f2504i);
                    }
                } catch (Throwable th3) {
                    VlionSDkManager.getInstance().upLoadCatchException(th3);
                }
                VlionBaseVideoView.this.g();
            } catch (Throwable th4) {
                VlionSDkManager.getInstance().upLoadCatchException(th4);
            }
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                LogVlion.e("VlionBaseVideoView this: onClick getmProgress=" + Math.round(VlionBaseVideoView.this.f2499d.getCurrentPosition() / 1000.0f));
                cn.vlion.ad.inland.base.c cVar = VlionBaseVideoView.this.f2506k;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class h implements SurfaceHolder.Callback {
        public h() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            try {
                MediaPlayer mediaPlayer = VlionBaseVideoView.this.f2499d;
                if (mediaPlayer != null) {
                    mediaPlayer.setDisplay(surfaceHolder);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            try {
                MediaPlayer mediaPlayer = VlionBaseVideoView.this.f2499d;
                if (mediaPlayer != null) {
                    mediaPlayer.setDisplay(null);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                LogVlion.e("VlionBaseVideoView run() isFinished =" + VlionBaseVideoView.this.f2503h);
                VlionBaseVideoView vlionBaseVideoView = VlionBaseVideoView.this;
                MediaPlayer mediaPlayer = vlionBaseVideoView.f2499d;
                if (mediaPlayer != null && !vlionBaseVideoView.f2503h) {
                    int duration = mediaPlayer.getDuration();
                    int currentPosition = VlionBaseVideoView.this.f2499d.getCurrentPosition();
                    LogVlion.e("VlionBaseVideoView currentPosition=" + currentPosition);
                    int round = Math.round(((float) currentPosition) / 1000.0f);
                    int round2 = Math.round(((float) duration) / 1000.0f);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("VlionBaseVideoView onAdVideoPlaying current=");
                    sb2.append(round);
                    sb2.append("  total=");
                    sb2.append(round2);
                    sb2.append("  (total- current)=");
                    int i10 = round2 - round;
                    sb2.append(i10);
                    LogVlion.e(sb2.toString());
                    cn.vlion.ad.inland.base.c cVar = VlionBaseVideoView.this.f2506k;
                    if (cVar != null) {
                        ((w5) cVar).a(round, round2);
                    }
                    if (i10 <= 1) {
                        if (VlionBaseVideoView.this.f2499d != null) {
                            LogVlion.e("VlionBaseVideoView onCompletion() onAdVideoEnd=");
                            cn.vlion.ad.inland.base.c cVar2 = VlionBaseVideoView.this.f2506k;
                            if (cVar2 != null) {
                                ((w5) cVar2).a();
                            }
                            if (VlionBaseVideoView.this.f2504i != null) {
                                VlionHandlerUtils.instant().removeCallbacks(VlionBaseVideoView.this.f2504i);
                            }
                        }
                        VlionBaseVideoView.this.f2503h = true;
                    }
                    VlionHandlerUtils.instant().postDelayed(this, 1000L);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public VlionBaseVideoView(Context context) {
        this(context, null);
    }

    public final void a() {
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            f0 f0Var = new f0(this.f2496a);
            this.f2497b = f0Var;
            SurfaceHolder holder = f0Var.getHolder();
            this.f2498c = holder;
            holder.addCallback(new h());
            this.f2497b.setLayoutParams(layoutParams);
            this.f2504i = new i();
            addView(this.f2497b);
            b();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void b() {
        try {
            LogVlion.e("VlionBaseVideoView MediaPlayer()");
            SurfaceHolder holder = this.f2497b.getHolder();
            this.f2498c = holder;
            holder.addCallback(new h());
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f2499d = mediaPlayer;
            mediaPlayer.setOnPreparedListener(new a());
            this.f2499d.setOnErrorListener(new b());
            this.f2499d.setOnCompletionListener(new c());
            this.f2499d.setOnVideoSizeChangedListener(new d());
            this.f2499d.setOnInfoListener(new e());
            this.f2499d.setOnSeekCompleteListener(new f());
            setOnClickListener(new g());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void c() {
        MediaPlayer mediaPlayer;
        try {
            this.f2501f = false;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("VlionBaseVideoView onResume null!= mMediaPlayer=");
            sb2.append(this.f2499d != null);
            LogVlion.e(sb2.toString());
            if (this.f2505j && this.f2500e && (mediaPlayer = this.f2499d) != null && !mediaPlayer.isPlaying()) {
                int currentPosition = this.f2499d.getCurrentPosition();
                LogVlion.e("VlionBaseVideoView onResumeVideo current=" + currentPosition);
                if (currentPosition <= 0) {
                    f();
                } else if (Build.VERSION.SDK_INT >= 26) {
                    this.f2499d.seekTo(currentPosition, 3);
                } else {
                    this.f2499d.seekTo(currentPosition);
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void d() {
        try {
            float systemVolume = VlionAppInfo.getInstance().getSystemVolume(this.f2496a);
            LogVlion.e("VlionBaseVideoView openVolume+++volume=" + systemVolume);
            if (systemVolume == 0.0f) {
                systemVolume = 0.1f;
            }
            LogVlion.e("VlionBaseVideoView openVolume  volume=" + systemVolume);
            MediaPlayer mediaPlayer = this.f2499d;
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(systemVolume, systemVolume);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.d
    public final void destroy() {
        try {
            LogVlion.e("VlionBaseVideoView destroy()");
            if (this.f2500e) {
                this.f2500e = false;
                MediaPlayer mediaPlayer = this.f2499d;
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    this.f2499d.release();
                    this.f2499d = null;
                }
            }
            if (this.f2506k != null) {
                this.f2506k = null;
            }
            SurfaceHolder surfaceHolder = this.f2498c;
            if (surfaceHolder != null) {
                Surface surface = surfaceHolder.getSurface();
                if (surface != null) {
                    surface.release();
                }
                this.f2498c = null;
            }
            if (this.f2497b != null) {
                this.f2497b = null;
            }
            if (this.f2504i != null) {
                VlionHandlerUtils.instant().removeCallbacks(this.f2504i);
            }
            setVisibility(8);
            removeAllViews();
            String str = this.f2510o;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void e() {
        try {
            this.f2499d.prepareAsync();
            setLooping(false);
            LogVlion.e("VlionBaseVideoView prepareAsync =");
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            LogVlion.e("VlionBaseVideoView prepareAsync onAdVideoPlayError=" + th2.getMessage());
            cn.vlion.ad.inland.base.c cVar = this.f2506k;
            if (cVar != null) {
                i1 i1Var = i1.f2915e;
                w5 w5Var = (w5) cVar;
                try {
                    g1 g1Var = w5Var.f3483a.f2323a;
                    if (g1Var != null) {
                        g1Var.onAdPlayFailure(i1Var.f2920a, i1Var.f2921b);
                    }
                } catch (Throwable th3) {
                    VlionSDkManager.getInstance().upLoadCatchException(th3);
                }
                w5Var.f3483a.finish();
            }
        }
    }

    public final void f() {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("VlionBaseVideoView startVideo null!= mMediaPlayer=");
            sb2.append(this.f2499d != null);
            LogVlion.e(sb2.toString());
            MediaPlayer mediaPlayer = this.f2499d;
            if (mediaPlayer == null || mediaPlayer.isPlaying()) {
                return;
            }
            LogVlion.e("VlionBaseVideoView startVideo current=" + this.f2499d.getCurrentPosition());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("VlionBaseVideoView startVideo isAutoPlay=");
            sb3.append(this.f2505j);
            sb3.append("  !isPaused=");
            sb3.append(!this.f2501f);
            LogVlion.e(sb3.toString());
            if (!this.f2505j || this.f2501f) {
                return;
            }
            this.f2499d.start();
            try {
                LogVlion.e("VlionBaseVideoView startUpdateTimer");
                try {
                    LogVlion.e("VlionBaseVideoView cancelUpdateTimer");
                    if (this.f2504i != null) {
                        VlionHandlerUtils.instant().removeCallbacks(this.f2504i);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                if (this.f2504i != null) {
                    VlionHandlerUtils.instant().post(this.f2504i);
                }
            } catch (Throwable th3) {
                VlionSDkManager.getInstance().upLoadCatchException(th3);
            }
            g();
        } catch (Throwable th4) {
            VlionSDkManager.getInstance().upLoadCatchException(th4);
        }
    }

    public final void g() {
        try {
            if (this.f2509n) {
                try {
                    LogVlion.e("VlionBaseVideoView closeVolume()");
                    MediaPlayer mediaPlayer = this.f2499d;
                    if (mediaPlayer != null) {
                        mediaPlayer.setVolume(0.001f, 0.001f);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            } else {
                d();
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public void getLeftSec() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        StringBuilder a10 = l1.a("VlionBaseVideoView onAttachedToWindow onAttachedToWindow------isStarted=");
        a10.append(this.f2502g);
        a10.append("  isFinished=");
        a10.append(this.f2503h);
        LogVlion.e(a10.toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        StringBuilder a10 = l1.a("VlionBaseVideoView onDetachedFromWindow onDetachedFromWindow------isStarted=");
        a10.append(this.f2502g);
        a10.append("  isFinished=");
        a10.append(this.f2503h);
        LogVlion.e(a10.toString());
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        LogVlion.e("VlionBaseVideoView onMeasure() widthMeasureSpec=" + i10 + " heightMeasureSpec=" + i11);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i10) {
        String str;
        super.onVisibilityChanged(view, i10);
        if (i10 == 0) {
            str = "VlionBaseVideoView onVisibilityChanged:VISIBLE";
        } else if (8 == i10) {
            str = "VlionBaseVideoView onVisibilityChanged:GONE";
        } else if (4 == i10) {
            str = "VlionBaseVideoView onVisibilityChanged:INVISIBLE";
        } else {
            try {
                str = "VlionBaseVideoView onVisibilityChanged:" + i10;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                return;
            }
        }
        LogVlion.e(str);
    }

    public void setAdVideoListener(cn.vlion.ad.inland.base.c cVar) {
        this.f2506k = cVar;
    }

    public void setClosedVolumePlay(boolean z10) {
        try {
            LogVlion.e("VlionBaseVideoView setClosedVolumePlay=" + z10);
            this.f2509n = z10;
            g();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setDataSource(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f2510o = str;
            this.f2499d.reset();
            this.f2499d.setDataSource(str);
            LogVlion.e("VlionBaseVideoView setDataSource setDataSource=");
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            LogVlion.e("VlionBaseVideoView setDataSource onAdVideoPlayError=" + th2.getMessage());
            cn.vlion.ad.inland.base.c cVar = this.f2506k;
            if (cVar != null) {
                i1 i1Var = i1.f2914d;
                w5 w5Var = (w5) cVar;
                try {
                    g1 g1Var = w5Var.f3483a.f2323a;
                    if (g1Var != null) {
                        g1Var.onAdPlayFailure(i1Var.f2920a, i1Var.f2921b);
                    }
                } catch (Throwable th3) {
                    VlionSDkManager.getInstance().upLoadCatchException(th3);
                }
                w5Var.f3483a.finish();
            }
        }
    }

    public void setIsAutoPlay(boolean z10) {
        this.f2505j = z10;
    }

    public void setLooping(boolean z10) {
        try {
            MediaPlayer mediaPlayer = this.f2499d;
            if (mediaPlayer != null) {
                mediaPlayer.setLooping(z10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setVideoScaleMode(int i10) {
        try {
            f0 f0Var = this.f2497b;
            if (f0Var != null) {
                f0Var.setVideoScaleMode(i10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public VlionBaseVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VlionBaseVideoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2500e = false;
        this.f2501f = false;
        this.f2502g = false;
        this.f2503h = false;
        this.f2505j = true;
        this.f2507l = 0;
        this.f2508m = 0;
        this.f2509n = false;
        this.f2496a = context;
        a();
    }
}
