package com.shu.priory.videolib;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.TextureView;
import com.shu.priory.utils.h;

/* loaded from: classes3.dex */
public class c implements TextureView.SurfaceTextureListener {

    /* renamed from: a */
    public static JZTextureView f17376a;

    /* renamed from: b */
    public static c f17377b;

    /* renamed from: c */
    public static SurfaceTexture f17378c;

    /* renamed from: d */
    public static Surface f17379d;

    /* renamed from: e */
    public b f17380e;

    /* renamed from: f */
    public int f17381f = -1;

    /* renamed from: g */
    public int f17382g = 0;

    /* renamed from: h */
    public int f17383h = 0;

    /* renamed from: i */
    public HandlerThread f17384i;

    /* renamed from: j */
    public a f17385j;

    /* renamed from: k */
    public Handler f17386k;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i10 = message.what;
            if (i10 != 0) {
                if (i10 != 2) {
                    return;
                }
                c.this.f17380e.d();
                return;
            }
            c cVar = c.this;
            cVar.f17382g = 0;
            cVar.f17383h = 0;
            cVar.f17380e.b();
            Surface surface = c.f17379d;
            if (surface != null) {
                surface.release();
            }
            Surface surface2 = new Surface(c.f17378c);
            c.f17379d = surface2;
            c.this.f17380e.a(surface2);
        }
    }

    public c() {
        HandlerThread handlerThread = new HandlerThread("JZVideoPlayer");
        this.f17384i = handlerThread;
        handlerThread.start();
        this.f17385j = new a(this.f17384i.getLooper());
        this.f17386k = new Handler();
        if (this.f17380e == null) {
            this.f17380e = new d();
        }
    }

    public static c a() {
        if (f17377b == null) {
            f17377b = new c();
        }
        return f17377b;
    }

    public static Object b() {
        if (a().f17380e.f17375a == null) {
            return null;
        }
        return a().f17380e.f17375a.a();
    }

    public static long c() {
        return a().f17380e.e();
    }

    public static long d() {
        return a().f17380e.f();
    }

    public static void e() {
        a().f17380e.c();
    }

    public static void f() {
        a().f17380e.a();
    }

    public void g() {
        Message message = new Message();
        message.what = 2;
        this.f17385j.sendMessage(message);
    }

    public void h() {
        g();
        Message message = new Message();
        message.what = 0;
        this.f17385j.sendMessage(message);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    @TargetApi(16)
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        if (f.c() == null) {
            return;
        }
        h.a("JZVideoPlayer", "onSurfaceTextureAvailable");
        try {
            SurfaceTexture surfaceTexture2 = f17378c;
            if (surfaceTexture2 == null) {
                f17378c = surfaceTexture;
                h();
            } else {
                f17376a.setSurfaceTexture(surfaceTexture2);
            }
        } catch (Throwable th2) {
            h.d("JZVideoPlayer", "onSurfaceTextureAvailable:" + th2.getMessage());
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return f17378c == null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public static void a(long j10) {
        a().f17380e.a(j10);
    }

    public static void a(com.shu.priory.videolib.a aVar) {
        a().f17380e.f17375a = aVar;
    }

    public static void a(boolean z10) {
        a().f17380e.a(z10);
    }
}
