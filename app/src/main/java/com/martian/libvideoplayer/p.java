package com.martian.libvideoplayer;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import androidx.annotation.NonNull;
import java.util.Map;

/* loaded from: classes3.dex */
public class p implements TextureView.SurfaceTextureListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener {

    /* renamed from: a */
    public static String f10712a = "JieCaoVideoPlayer";

    /* renamed from: b */
    private static p f10713b = null;

    /* renamed from: c */
    public static JCResizeTextureView f10714c = null;

    /* renamed from: d */
    public static SurfaceTexture f10715d = null;

    /* renamed from: e */
    public static String f10716e = null;

    /* renamed from: f */
    public static boolean f10717f = false;

    /* renamed from: g */
    public static Map<String, String> f10718g = null;

    /* renamed from: h */
    public static final int f10719h = 0;

    /* renamed from: i */
    public static final int f10720i = 2;

    /* renamed from: j */
    public MediaPlayer f10721j = new MediaPlayer();
    public int k = 0;
    public int l = 0;
    HandlerThread m;
    a n;
    Handler o;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            int i2 = msg.what;
            if (i2 != 0) {
                if (i2 != 2) {
                    return;
                }
                p.this.f10721j.release();
                return;
            }
            try {
                p pVar = p.this;
                pVar.k = 0;
                pVar.l = 0;
                pVar.f10721j.release();
                p.this.f10721j = new MediaPlayer();
                p.this.f10721j.setAudioStreamType(3);
                MediaPlayer.class.getDeclaredMethod("setDataSource", String.class, Map.class).invoke(p.this.f10721j, p.f10716e, p.f10718g);
                p.this.f10721j.setLooping(p.f10717f);
                p pVar2 = p.this;
                pVar2.f10721j.setOnPreparedListener(pVar2);
                p pVar3 = p.this;
                pVar3.f10721j.setOnCompletionListener(pVar3);
                p pVar4 = p.this;
                pVar4.f10721j.setOnBufferingUpdateListener(pVar4);
                p.this.f10721j.setScreenOnWhilePlaying(true);
                p pVar5 = p.this;
                pVar5.f10721j.setOnSeekCompleteListener(pVar5);
                p pVar6 = p.this;
                pVar6.f10721j.setOnErrorListener(pVar6);
                p pVar7 = p.this;
                pVar7.f10721j.setOnInfoListener(pVar7);
                p pVar8 = p.this;
                pVar8.f10721j.setOnVideoSizeChangedListener(pVar8);
                p.this.f10721j.prepareAsync();
                p.this.f10721j.setSurface(new Surface(p.f10715d));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public p() {
        HandlerThread handlerThread = new HandlerThread(f10712a);
        this.m = handlerThread;
        handlerThread.start();
        this.n = new a(this.m.getLooper());
        this.o = new Handler();
    }

    public static p b() {
        if (f10713b == null) {
            f10713b = new p();
        }
        return f10713b;
    }

    static /* synthetic */ void c(final int percent) {
        if (u.b() != null) {
            u.b().setBufferProgress(percent);
        }
    }

    static /* synthetic */ void d() {
        if (u.b() != null) {
            u.b().q();
        }
    }

    static /* synthetic */ void e(final int what, final int extra) {
        if (u.b() != null) {
            u.b().s(what, extra);
        }
    }

    static /* synthetic */ void f(final int what, final int extra) {
        if (u.b() != null) {
            u.b().u(what, extra);
        }
    }

    static /* synthetic */ void g() {
        if (u.b() != null) {
            u.b().v();
        }
    }

    static /* synthetic */ void h() {
        if (u.b() != null) {
            u.b().w();
        }
    }

    static /* synthetic */ void i() {
        if (u.b() != null) {
            u.b().F();
        }
    }

    public Point a() {
        if (this.k == 0 || this.l == 0) {
            return null;
        }
        return new Point(this.k, this.l);
    }

    public void j() {
        k();
        Message message = new Message();
        message.what = 0;
        this.n.sendMessage(message);
    }

    public void k() {
        Message message = new Message();
        message.what = 2;
        this.n.sendMessage(message);
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mp, final int percent) {
        this.o.post(new Runnable() { // from class: com.martian.libvideoplayer.a
            @Override // java.lang.Runnable
            public final void run() {
                p.c(percent);
            }
        });
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mp) {
        this.o.post(new Runnable() { // from class: com.martian.libvideoplayer.c
            @Override // java.lang.Runnable
            public final void run() {
                p.d();
            }
        });
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mp, final int what, final int extra) {
        this.o.post(new Runnable() { // from class: com.martian.libvideoplayer.d
            @Override // java.lang.Runnable
            public final void run() {
                p.e(what, extra);
            }
        });
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mp, final int what, final int extra) {
        this.o.post(new Runnable() { // from class: com.martian.libvideoplayer.b
            @Override // java.lang.Runnable
            public final void run() {
                p.f(what, extra);
            }
        });
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mp) {
        this.f10721j.start();
        this.o.post(new Runnable() { // from class: com.martian.libvideoplayer.g
            @Override // java.lang.Runnable
            public final void run() {
                p.g();
            }
        });
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mp) {
        this.o.post(new Runnable() { // from class: com.martian.libvideoplayer.f
            @Override // java.lang.Runnable
            public final void run() {
                p.h();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i1) {
        if (f10715d == null) {
            f10715d = surfaceTexture;
            j();
        } else if (com.martian.libsupport.l.m()) {
            f10714c.setSurfaceTexture(f10715d);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return f10715d == null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i1) {
        Log.i(f10712a, "onSurfaceTextureSizeChanged [" + u.b().hashCode() + "] ");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
        this.k = width;
        this.l = height;
        this.o.post(new Runnable() { // from class: com.martian.libvideoplayer.e
            @Override // java.lang.Runnable
            public final void run() {
                p.i();
            }
        });
    }
}
