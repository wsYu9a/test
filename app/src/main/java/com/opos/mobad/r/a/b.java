package com.opos.mobad.r.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.opos.cmn.j.a;
import com.opos.libs.a.a;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
class b implements com.opos.mobad.c.c.a {

    /* renamed from: a */
    private Context f23396a;

    /* renamed from: b */
    private com.opos.mobad.c.c.b f23397b;

    /* renamed from: c */
    private MediaPlayer f23398c;

    /* renamed from: d */
    private RelativeLayout f23399d;

    /* renamed from: e */
    private View f23400e;

    /* renamed from: f */
    private com.opos.libs.a.a f23401f;

    /* renamed from: g */
    private com.opos.exoplayer.a.a f23402g;

    /* renamed from: h */
    private float f23403h;

    /* renamed from: i */
    private SurfaceView f23404i;

    /* renamed from: j */
    private TextureView f23405j;
    private Surface k;
    private ImageView l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private Handler q;

    /* renamed from: com.opos.mobad.r.a.b$1 */
    class AnonymousClass1 extends Handler {
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull @f.b.a.d Message message) {
            com.opos.mobad.c.c.b bVar;
            int i2 = message.what;
            if (i2 == 1) {
                b.this.m = true;
                b.this.f23401f.a(1);
                if (b.this.f23397b != null) {
                    b.this.f23397b.c();
                }
            } else if (i2 != 2) {
                if (i2 == 3) {
                    if (b.this.f23397b != null) {
                        b.this.f23397b.h();
                        return;
                    }
                    return;
                } else if (i2 == 4) {
                    if (b.this.f23397b != null) {
                        b.this.f23397b.i();
                        return;
                    }
                    return;
                } else {
                    if (i2 == 5 && (bVar = b.this.f23397b) != null) {
                        bVar.j();
                        return;
                    }
                    return;
                }
            }
            b.this.p();
        }
    }

    /* renamed from: com.opos.mobad.r.a.b$10 */
    class AnonymousClass10 implements MediaPlayer.OnPreparedListener {
        AnonymousClass10() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "player prepared duration:" + mediaPlayer.getDuration() + "," + b.this.k);
            b.this.a(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            b.this.q.obtainMessage(1).sendToTarget();
        }
    }

    /* renamed from: com.opos.mobad.r.a.b$11 */
    class AnonymousClass11 implements a.InterfaceC0396a {
        AnonymousClass11() {
        }

        @Override // com.opos.cmn.j.a.InterfaceC0396a
        public void a() {
        }

        @Override // com.opos.cmn.j.a.InterfaceC0396a
        public void b() {
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "view attach to window");
            if (b.this.f23401f.a() == 6 || b.this.f23399d.isHardwareAccelerated()) {
                return;
            }
            b.this.k();
        }
    }

    /* renamed from: com.opos.mobad.r.a.b$12 */
    class AnonymousClass12 implements TextureView.SurfaceTextureListener {
        AnonymousClass12() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "onSurfaceTextureAvailable");
            b.this.a(new Surface(surfaceTexture));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "onSurfaceTextureDestroyed");
            b.this.n();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* renamed from: com.opos.mobad.r.a.b$13 */
    class AnonymousClass13 implements SurfaceHolder.Callback {
        AnonymousClass13() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "surfaceCreated");
            b.this.a(surfaceHolder.getSurface());
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "surfaceDestroyed");
            b.this.n();
        }
    }

    /* renamed from: com.opos.mobad.r.a.b$14 */
    class AnonymousClass14 implements Callable<Boolean> {
        AnonymousClass14() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            b.this.q();
            return Boolean.TRUE;
        }
    }

    /* renamed from: com.opos.mobad.r.a.b$15 */
    class AnonymousClass15 implements Callable<Boolean> {

        /* renamed from: com.opos.mobad.r.a.b$15$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f23397b != null) {
                    b.this.f23397b.g();
                }
            }
        }

        AnonymousClass15() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            b.this.r();
            b.this.m();
            b.this.q.post(new Runnable() { // from class: com.opos.mobad.r.a.b.15.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f23397b != null) {
                        b.this.f23397b.g();
                    }
                }
            });
            return Boolean.TRUE;
        }
    }

    /* renamed from: com.opos.mobad.r.a.b$16 */
    class AnonymousClass16 implements PixelCopy.OnPixelCopyFinishedListener {

        /* renamed from: a */
        final /* synthetic */ Bitmap f23414a;

        AnonymousClass16(Bitmap bitmap) {
            createBitmap = bitmap;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int i2) {
            b.this.l.setImageBitmap(createBitmap);
        }
    }

    /* renamed from: com.opos.mobad.r.a.b$17 */
    class AnonymousClass17 implements Callable<Boolean> {

        /* renamed from: com.opos.mobad.r.a.b$17$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f23397b != null) {
                    if (!b.this.p) {
                        b.this.p = true;
                        b.this.f23397b.d();
                    }
                    b.this.f23397b.f();
                }
            }
        }

        AnonymousClass17() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            b.this.q();
            b.this.q.post(new Runnable() { // from class: com.opos.mobad.r.a.b.17.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f23397b != null) {
                        if (!b.this.p) {
                            b.this.p = true;
                            b.this.f23397b.d();
                        }
                        b.this.f23397b.f();
                    }
                }
            });
            return Boolean.TRUE;
        }
    }

    /* renamed from: com.opos.mobad.r.a.b$18 */
    class AnonymousClass18 implements Callable<Boolean> {
        AnonymousClass18() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            if (b.this.f23398c != null) {
                b.this.f23398c.release();
                b.this.f23398c = null;
            }
            b.this.n();
            return Boolean.TRUE;
        }
    }

    /* renamed from: com.opos.mobad.r.a.b$2 */
    class AnonymousClass2 implements Callable<Boolean> {
        AnonymousClass2() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            if (b.this.f23398c != null) {
                b.this.f23398c.reset();
                b.this.f23398c = null;
            }
            return Boolean.TRUE;
        }
    }

    /* renamed from: com.opos.mobad.r.a.b$3 */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.p = true;
            if (b.this.f23397b != null) {
                b.this.f23397b.d();
            }
        }
    }

    /* renamed from: com.opos.mobad.r.a.b$4 */
    class AnonymousClass4 implements Callable<Boolean> {

        /* renamed from: com.opos.mobad.r.a.b$4$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.p = true;
                if (b.this.f23397b != null) {
                    b.this.f23397b.d();
                }
            }
        }

        AnonymousClass4() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            if (!b.this.q()) {
                return Boolean.FALSE;
            }
            b.this.q.post(new Runnable() { // from class: com.opos.mobad.r.a.b.4.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    b.this.p = true;
                    if (b.this.f23397b != null) {
                        b.this.f23397b.d();
                    }
                }
            });
            return Boolean.TRUE;
        }
    }

    /* renamed from: com.opos.mobad.r.a.b$5 */
    class AnonymousClass5 implements Callable<Boolean> {

        /* renamed from: a */
        final /* synthetic */ String f23423a;

        AnonymousClass5(String str) {
            str = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            try {
                b.this.c(str);
                return Boolean.TRUE;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "init fail", e2);
                if (b.this.f23397b != null) {
                    b.this.f23397b.a(-1, "");
                }
                return Boolean.FALSE;
            }
        }
    }

    /* renamed from: com.opos.mobad.r.a.b$6 */
    class AnonymousClass6 implements MediaPlayer.OnVideoSizeChangedListener {
        AnonymousClass6() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            b.this.a(i2, i3);
        }
    }

    /* renamed from: com.opos.mobad.r.a.b$7 */
    class AnonymousClass7 implements MediaPlayer.OnCompletionListener {
        AnonymousClass7() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            b.this.f23401f.a(5);
            b.this.m();
            if (b.this.f23397b != null) {
                b.this.f23397b.e();
            }
        }
    }

    /* renamed from: com.opos.mobad.r.a.b$8 */
    class AnonymousClass8 implements MediaPlayer.OnErrorListener {
        AnonymousClass8() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "play fail:" + i2 + "," + i3 + ",state:" + b.this.f23401f.a());
            if (-38 == i2) {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "ignore error");
                return true;
            }
            if (b.this.f23401f.a() == 0 || 6 == b.this.f23401f.a()) {
                return true;
            }
            b.this.f23401f.a(0);
            if (b.this.f23397b == null) {
                return true;
            }
            b.this.f23397b.a(2, "code:" + i2 + ",extra:" + i3);
            return true;
        }
    }

    /* renamed from: com.opos.mobad.r.a.b$9 */
    class AnonymousClass9 implements MediaPlayer.OnInfoListener {
        AnonymousClass9() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            Handler handler;
            int i4;
            Message message;
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "play info:" + i2 + "," + i3);
            if (i2 == 3) {
                handler = b.this.q;
                i4 = 5;
            } else {
                if (i2 == 701) {
                    message = b.this.q.obtainMessage(3);
                    message.sendToTarget();
                    return false;
                }
                if (i2 != 702) {
                    return false;
                }
                handler = b.this.q;
                i4 = 4;
            }
            message = handler.obtainMessage(i4);
            message.sendToTarget();
            return false;
        }
    }

    public b(Context context, com.opos.mobad.c.c.b bVar) {
        this(context, bVar, true);
    }

    public b(Context context, com.opos.mobad.c.c.b bVar, boolean z) {
        this.f23403h = 1.0f;
        this.m = false;
        this.o = false;
        this.p = false;
        this.q = new Handler(Looper.getMainLooper()) { // from class: com.opos.mobad.r.a.b.1
            AnonymousClass1(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(@NonNull @f.b.a.d Message message) {
                com.opos.mobad.c.c.b bVar2;
                int i2 = message.what;
                if (i2 == 1) {
                    b.this.m = true;
                    b.this.f23401f.a(1);
                    if (b.this.f23397b != null) {
                        b.this.f23397b.c();
                    }
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        if (b.this.f23397b != null) {
                            b.this.f23397b.h();
                            return;
                        }
                        return;
                    } else if (i2 == 4) {
                        if (b.this.f23397b != null) {
                            b.this.f23397b.i();
                            return;
                        }
                        return;
                    } else {
                        if (i2 == 5 && (bVar2 = b.this.f23397b) != null) {
                            bVar2.j();
                            return;
                        }
                        return;
                    }
                }
                b.this.p();
            }
        };
        this.f23396a = context;
        this.f23397b = bVar;
        this.n = z;
        a();
        this.f23401f = new a.C0418a(0).a(0, 7, 6).a(7, 1, 3, 2, 0, 6).a(1, 3, 2, 5, 0, 6).a(2, 3, 5, 0, 6).a(3, 2, 0, 6).a(5, 2, 0, 6).a();
    }

    private void a() {
        this.f23399d = new RelativeLayout(this.f23396a);
        View view = new View(this.f23396a);
        this.f23400e = view;
        view.setBackgroundColor(-16777216);
        this.f23399d.addView(this.f23400e, new ViewGroup.LayoutParams(-1, -1));
        this.f23402g = new com.opos.exoplayer.a.a(this.f23396a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f23399d.addView(this.f23402g, layoutParams);
        this.f23402g.setId(View.generateViewId());
        this.l = new ImageView(this.f23396a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(6, this.f23402g.getId());
        layoutParams2.addRule(8, this.f23402g.getId());
        layoutParams2.addRule(7, this.f23402g.getId());
        layoutParams2.addRule(5, this.f23402g.getId());
        this.f23399d.addView(this.l, layoutParams2);
        this.l.setVisibility(8);
        com.opos.cmn.j.a aVar = new com.opos.cmn.j.a(this.f23396a);
        this.f23399d.addView(aVar, new ViewGroup.LayoutParams(0, 0));
        aVar.a(new a.InterfaceC0396a() { // from class: com.opos.mobad.r.a.b.11
            AnonymousClass11() {
            }

            @Override // com.opos.cmn.j.a.InterfaceC0396a
            public void a() {
            }

            @Override // com.opos.cmn.j.a.InterfaceC0396a
            public void b() {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "view attach to window");
                if (b.this.f23401f.a() == 6 || b.this.f23399d.isHardwareAccelerated()) {
                    return;
                }
                b.this.k();
            }
        });
        j();
    }

    public void a(int i2, int i3) {
        this.f23402g.a(i2 / i3);
    }

    public void a(Surface surface) {
        if (this.f23401f.a() == 6) {
            return;
        }
        this.k = surface;
        this.q.obtainMessage(2).sendToTarget();
    }

    public void c(String str) throws Exception {
        this.m = false;
        MediaPlayer mediaPlayer = this.f23398c;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        } else {
            this.f23398c = new MediaPlayer();
        }
        this.f23398c.setDataSource(this.f23396a, Uri.parse(str), (Map<String, String>) null);
        this.f23398c.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.opos.mobad.r.a.b.6
            AnonymousClass6() {
            }

            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer2, int i2, int i3) {
                b.this.a(i2, i3);
            }
        });
        this.f23398c.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.opos.mobad.r.a.b.7
            AnonymousClass7() {
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer2) {
                b.this.f23401f.a(5);
                b.this.m();
                if (b.this.f23397b != null) {
                    b.this.f23397b.e();
                }
            }
        });
        this.f23398c.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.opos.mobad.r.a.b.8
            AnonymousClass8() {
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer2, int i2, int i3) {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "play fail:" + i2 + "," + i3 + ",state:" + b.this.f23401f.a());
                if (-38 == i2) {
                    com.opos.cmn.an.f.a.b("MiniVideoPlayer", "ignore error");
                    return true;
                }
                if (b.this.f23401f.a() == 0 || 6 == b.this.f23401f.a()) {
                    return true;
                }
                b.this.f23401f.a(0);
                if (b.this.f23397b == null) {
                    return true;
                }
                b.this.f23397b.a(2, "code:" + i2 + ",extra:" + i3);
                return true;
            }
        });
        this.f23398c.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.opos.mobad.r.a.b.9
            AnonymousClass9() {
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer2, int i2, int i3) {
                Handler handler;
                int i4;
                Message message;
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "play info:" + i2 + "," + i3);
                if (i2 == 3) {
                    handler = b.this.q;
                    i4 = 5;
                } else {
                    if (i2 == 701) {
                        message = b.this.q.obtainMessage(3);
                        message.sendToTarget();
                        return false;
                    }
                    if (i2 != 702) {
                        return false;
                    }
                    handler = b.this.q;
                    i4 = 4;
                }
                message = handler.obtainMessage(i4);
                message.sendToTarget();
                return false;
            }
        });
        this.f23398c.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.opos.mobad.r.a.b.10
            AnonymousClass10() {
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer2) {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "player prepared duration:" + mediaPlayer2.getDuration() + "," + b.this.k);
                b.this.a(mediaPlayer2.getVideoWidth(), mediaPlayer2.getVideoHeight());
                b.this.q.obtainMessage(1).sendToTarget();
            }
        });
        MediaPlayer mediaPlayer2 = this.f23398c;
        float f2 = this.f23403h;
        mediaPlayer2.setVolume(f2, f2);
        if (this.o) {
            this.f23398c.setLooping(true);
        }
        this.f23398c.prepareAsync();
    }

    private void j() {
        TextureView textureView = new TextureView(this.f23396a);
        this.f23405j = textureView;
        this.f23402g.addView(textureView, new ViewGroup.LayoutParams(-1, -1));
        this.f23405j.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.opos.mobad.r.a.b.12
            AnonymousClass12() {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "onSurfaceTextureAvailable");
                b.this.a(new Surface(surfaceTexture));
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "onSurfaceTextureDestroyed");
                b.this.n();
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }

    public void k() {
        if (this.f23404i != null) {
            return;
        }
        com.opos.cmn.an.f.a.b("MiniVideoPlayer", "reset surface");
        this.f23402g.removeAllViews();
        if (this.k != null) {
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "surface release");
            this.k.release();
        }
        this.f23405j = null;
        SurfaceView surfaceView = new SurfaceView(this.f23396a);
        this.f23404i = surfaceView;
        this.f23402g.addView(surfaceView, new ViewGroup.LayoutParams(-1, -1));
        this.f23404i.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.opos.mobad.r.a.b.13
            AnonymousClass13() {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "surfaceCreated");
                b.this.a(surfaceHolder.getSurface());
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                com.opos.cmn.an.f.a.b("MiniVideoPlayer", "surfaceDestroyed");
                b.this.n();
            }
        });
    }

    private void l() {
        this.l.setVisibility(8);
    }

    public void m() {
        this.l.setVisibility(0);
        this.l.setImageBitmap(null);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "show cover");
            TextureView textureView = this.f23405j;
            if (textureView != null) {
                this.l.setImageBitmap(textureView.getBitmap());
            } else {
                SurfaceView surfaceView = this.f23404i;
                if (surfaceView != null && Build.VERSION.SDK_INT >= 25) {
                    Bitmap createBitmap = Bitmap.createBitmap(surfaceView.getWidth(), this.f23404i.getHeight(), Bitmap.Config.ARGB_8888);
                    PixelCopy.request(this.f23404i, createBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.opos.mobad.r.a.b.16

                        /* renamed from: a */
                        final /* synthetic */ Bitmap f23414a;

                        AnonymousClass16(Bitmap createBitmap2) {
                            createBitmap = createBitmap2;
                        }

                        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                        public void onPixelCopyFinished(int i2) {
                            b.this.l.setImageBitmap(createBitmap);
                        }
                    }, this.f23404i.getHandler());
                }
            }
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "show cover end:" + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception unused) {
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "show cover fail");
        }
    }

    public void n() {
        Surface surface = this.k;
        if (surface != null) {
            com.opos.cmn.an.f.a.b("MiniVideoPlayer", "surface release");
            surface.release();
        }
        this.k = null;
    }

    private void o() {
        this.f23401f.a(0, new Callable<Boolean>() { // from class: com.opos.mobad.r.a.b.2
            AnonymousClass2() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                if (b.this.f23398c != null) {
                    b.this.f23398c.reset();
                    b.this.f23398c = null;
                }
                return Boolean.TRUE;
            }
        });
    }

    public void p() {
        com.opos.cmn.an.f.a.b("MiniVideoPlayer", "start :" + this.f23401f.a());
        if (this.f23401f.a() == 2) {
            if (q()) {
                this.q.post(new Runnable() { // from class: com.opos.mobad.r.a.b.3
                    AnonymousClass3() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.p = true;
                        if (b.this.f23397b != null) {
                            b.this.f23397b.d();
                        }
                    }
                });
            }
        } else if (this.f23401f.a() == 1 && this.n) {
            this.f23401f.a(2, new Callable<Boolean>() { // from class: com.opos.mobad.r.a.b.4

                /* renamed from: com.opos.mobad.r.a.b$4$1 */
                class AnonymousClass1 implements Runnable {
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.p = true;
                        if (b.this.f23397b != null) {
                            b.this.f23397b.d();
                        }
                    }
                }

                AnonymousClass4() {
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    if (!b.this.q()) {
                        return Boolean.FALSE;
                    }
                    b.this.q.post(new Runnable() { // from class: com.opos.mobad.r.a.b.4.1
                        AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.p = true;
                            if (b.this.f23397b != null) {
                                b.this.f23397b.d();
                            }
                        }
                    });
                    return Boolean.TRUE;
                }
            });
        }
    }

    public boolean q() {
        if (this.k == null || !this.m) {
            return false;
        }
        com.opos.cmn.an.f.a.b("MiniVideoPlayer", "check to start");
        this.f23398c.setSurface(this.k);
        this.f23398c.start();
        this.f23400e.setVisibility(8);
        l();
        return true;
    }

    public void r() {
        if (this.k == null || !this.m) {
            return;
        }
        this.f23398c.pause();
    }

    @Override // com.opos.mobad.c.c.a
    public void a(float f2) {
        this.f23403h = f2;
        MediaPlayer mediaPlayer = this.f23398c;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f2, f2);
        }
    }

    @Override // com.opos.mobad.c.c.a
    public void a(long j2) {
        com.opos.cmn.an.f.a.b("MiniVideoPlayer", "seekTo");
        int a2 = this.f23401f.a();
        if (2 == a2 || 4 == a2 || 3 == a2 || 5 == a2) {
            this.f23398c.seekTo((int) j2);
        }
    }

    @Override // com.opos.mobad.c.c.a
    public void a(com.opos.mobad.c.c.b bVar) {
        this.f23397b = bVar;
    }

    @Override // com.opos.mobad.c.c.a
    public void a(String str) {
        a(str, false);
    }

    @Override // com.opos.mobad.c.c.a
    public void a(String str, boolean z) {
        this.o = z;
        o();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.opos.cmn.an.f.a.b("MiniVideoPlayer", "start video path:" + str);
        this.f23401f.a(7, new Callable<Boolean>() { // from class: com.opos.mobad.r.a.b.5

            /* renamed from: a */
            final /* synthetic */ String f23423a;

            AnonymousClass5(String str2) {
                str = str2;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                try {
                    b.this.c(str);
                    return Boolean.TRUE;
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("MiniVideoPlayer", "init fail", e2);
                    if (b.this.f23397b != null) {
                        b.this.f23397b.a(-1, "");
                    }
                    return Boolean.FALSE;
                }
            }
        });
    }

    @Override // com.opos.mobad.c.c.a
    public Bitmap b(String str) {
        Object obj = this.f23405j;
        if (obj == null) {
            obj = this.f23404i;
        }
        return c.a(obj, str);
    }

    @Override // com.opos.mobad.c.c.a
    public View b() {
        return this.f23399d;
    }

    @Override // com.opos.mobad.c.c.a
    public long c() {
        if (this.f23398c != null) {
            return r0.getDuration();
        }
        return 0L;
    }

    @Override // com.opos.mobad.c.c.a
    public void c(int i2) {
        this.f23402g.a(i2);
    }

    @Override // com.opos.mobad.c.c.a
    public long d() {
        if (this.f23398c != null) {
            return this.f23401f.a() == 5 ? this.f23398c.getDuration() : this.f23398c.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.opos.mobad.c.c.a
    public void d(int i2) {
        this.f23400e.setBackgroundColor(i2);
    }

    @Override // com.opos.mobad.c.c.a
    public void e() {
        com.opos.cmn.an.f.a.b("MiniVideoPlayer", "start");
        this.f23401f.a(2, new Callable<Boolean>() { // from class: com.opos.mobad.r.a.b.14
            AnonymousClass14() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                b.this.q();
                return Boolean.TRUE;
            }
        });
    }

    @Override // com.opos.mobad.c.c.a
    public void f() {
        this.f23401f.a(3, new Callable<Boolean>() { // from class: com.opos.mobad.r.a.b.15

            /* renamed from: com.opos.mobad.r.a.b$15$1 */
            class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f23397b != null) {
                        b.this.f23397b.g();
                    }
                }
            }

            AnonymousClass15() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                b.this.r();
                b.this.m();
                b.this.q.post(new Runnable() { // from class: com.opos.mobad.r.a.b.15.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.f23397b != null) {
                            b.this.f23397b.g();
                        }
                    }
                });
                return Boolean.TRUE;
            }
        });
    }

    @Override // com.opos.mobad.c.c.a
    public void g() {
        com.opos.cmn.an.f.a.b("MiniVideoPlayer", "resume");
        this.f23401f.a(2, new Callable<Boolean>() { // from class: com.opos.mobad.r.a.b.17

            /* renamed from: com.opos.mobad.r.a.b$17$1 */
            class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f23397b != null) {
                        if (!b.this.p) {
                            b.this.p = true;
                            b.this.f23397b.d();
                        }
                        b.this.f23397b.f();
                    }
                }
            }

            AnonymousClass17() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                b.this.q();
                b.this.q.post(new Runnable() { // from class: com.opos.mobad.r.a.b.17.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.f23397b != null) {
                            if (!b.this.p) {
                                b.this.p = true;
                                b.this.f23397b.d();
                            }
                            b.this.f23397b.f();
                        }
                    }
                });
                return Boolean.TRUE;
            }
        });
    }

    @Override // com.opos.mobad.c.c.a
    public void h() {
        this.f23401f.a(6, new Callable<Boolean>() { // from class: com.opos.mobad.r.a.b.18
            AnonymousClass18() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                if (b.this.f23398c != null) {
                    b.this.f23398c.release();
                    b.this.f23398c = null;
                }
                b.this.n();
                return Boolean.TRUE;
            }
        });
    }

    @Override // com.opos.mobad.c.c.a
    public int i() {
        return this.f23401f.a();
    }
}
