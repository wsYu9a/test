package com.wbl.ad.yzz.ms.data.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public class MuVideoTextureView extends TextureView {

    /* renamed from: a */
    public String f33112a;

    /* renamed from: b */
    public MediaPlayer f33113b;

    /* renamed from: c */
    public MediaPlayer.OnPreparedListener f33114c;

    /* renamed from: d */
    public MediaPlayer.OnCompletionListener f33115d;

    /* renamed from: e */
    public MediaPlayer.OnInfoListener f33116e;

    /* renamed from: f */
    public MediaPlayer.OnVideoSizeChangedListener f33117f;

    /* renamed from: g */
    public boolean f33118g;

    /* renamed from: h */
    public Surface f33119h;

    /* renamed from: i */
    public int f33120i;

    /* renamed from: j */
    public int f33121j;
    public boolean k;
    public Surface l;
    public int m;
    public TextureView.SurfaceTextureListener n;

    public class a implements TextureView.SurfaceTextureListener {
        public a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11993, this, surfaceTexture, Integer.valueOf(i2), Integer.valueOf(i3));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-11996, this, surfaceTexture);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11995, this, surfaceTexture, Integer.valueOf(i2), Integer.valueOf(i3));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11990, this, surfaceTexture);
        }
    }

    public class b implements MediaPlayer.OnPreparedListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11989, this, mediaPlayer);
        }
    }

    public class c implements MediaPlayer.OnCompletionListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11992, this, mediaPlayer);
        }
    }

    public class d implements MediaPlayer.OnBufferingUpdateListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11991, this, mediaPlayer, Integer.valueOf(i2));
        }
    }

    public class e implements MediaPlayer.OnInfoListener {
        public e() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-11986, this, mediaPlayer, Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    public class f implements MediaPlayer.OnVideoSizeChangedListener {
        public f() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11985, this, mediaPlayer, Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11988, this, null);
        }
    }

    public MuVideoTextureView(Context context) {
        super(context);
        this.f33112a = getClass().getSimpleName();
        this.f33118g = false;
        this.k = true;
        this.m = 1;
        this.n = new a();
        b();
    }

    public static /* synthetic */ MediaPlayer a(MuVideoTextureView muVideoTextureView) {
        return (MediaPlayer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12078, null, muVideoTextureView);
    }

    public static /* synthetic */ Surface a(MuVideoTextureView muVideoTextureView, Surface surface) {
        return (Surface) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12077, null, muVideoTextureView, surface);
    }

    public static /* synthetic */ Surface b(MuVideoTextureView muVideoTextureView) {
        return (Surface) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12073, null, muVideoTextureView);
    }

    public static /* synthetic */ Surface c(MuVideoTextureView muVideoTextureView) {
        return (Surface) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12076, null, muVideoTextureView);
    }

    public static /* synthetic */ MediaPlayer.OnPreparedListener e(MuVideoTextureView muVideoTextureView) {
        return (MediaPlayer.OnPreparedListener) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12070, null, muVideoTextureView);
    }

    public static /* synthetic */ MediaPlayer.OnCompletionListener f(MuVideoTextureView muVideoTextureView) {
        return (MediaPlayer.OnCompletionListener) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12069, null, muVideoTextureView);
    }

    public static /* synthetic */ String g(MuVideoTextureView muVideoTextureView) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12072, null, muVideoTextureView);
    }

    public static /* synthetic */ MediaPlayer.OnInfoListener h(MuVideoTextureView muVideoTextureView) {
        return (MediaPlayer.OnInfoListener) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12071, null, muVideoTextureView);
    }

    public static /* synthetic */ MediaPlayer.OnVideoSizeChangedListener i(MuVideoTextureView muVideoTextureView) {
        return (MediaPlayer.OnVideoSizeChangedListener) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12066, null, muVideoTextureView);
    }

    public Matrix a(float f2, float f3) {
        return (Matrix) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12065, this, Float.valueOf(f2), Float.valueOf(f3));
    }

    public void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12068, this, null);
    }

    public void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12067, this, Integer.valueOf(i2));
    }

    public final void a(int i2, int i3, Matrix matrix) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12094, this, Integer.valueOf(i2), Integer.valueOf(i3), matrix);
    }

    public void a(Surface surface) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12093, this, surface);
    }

    public void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12096, this, null);
    }

    public boolean c() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12095, this, null);
    }

    public boolean d() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12090, this, null);
    }

    public void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12089, this, null);
    }

    public void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12092, this, null);
    }

    public void g() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12091, this, null);
    }

    public int getCurrentPosition() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-12086, this, null);
    }

    public int getDuration() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-12085, this, null);
    }

    public MediaPlayer getMediaPlayer() {
        return (MediaPlayer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12088, this, null);
    }

    public void h() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12087, this, null);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12082, this, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    @Override // android.view.TextureView, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12081, this, drawable);
    }

    public void setDisplayMode(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12084, this, Integer.valueOf(i2));
    }

    public void setInitMute(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12083, this, Boolean.valueOf(z));
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12046, this, onCompletionListener);
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12045, this, onErrorListener);
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12048, this, onInfoListener);
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12047, this, onPreparedListener);
    }

    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12042, this, onVideoSizeChangedListener);
    }

    public void setUseTransform(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12041, this, Boolean.valueOf(z));
    }

    public void setVideoPath(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12044, this, str);
    }

    public MuVideoTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33112a = getClass().getSimpleName();
        this.f33118g = false;
        this.k = true;
        this.m = 1;
        this.n = new a();
        b();
    }

    public MuVideoTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f33112a = getClass().getSimpleName();
        this.f33118g = false;
        this.k = true;
        this.m = 1;
        this.n = new a();
        b();
    }
}
