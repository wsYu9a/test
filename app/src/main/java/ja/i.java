package ja;

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
import com.martian.libvideoplayer.JCResizeTextureView;
import java.util.Map;

/* loaded from: classes3.dex */
public class i implements TextureView.SurfaceTextureListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener {

    /* renamed from: h */
    public static String f27263h = "JieCaoVideoPlayer";

    /* renamed from: i */
    public static i f27264i = null;

    /* renamed from: j */
    public static JCResizeTextureView f27265j = null;

    /* renamed from: k */
    public static SurfaceTexture f27266k = null;

    /* renamed from: l */
    public static String f27267l = null;

    /* renamed from: m */
    public static boolean f27268m = false;

    /* renamed from: n */
    public static Map<String, String> f27269n = null;

    /* renamed from: o */
    public static final int f27270o = 0;

    /* renamed from: p */
    public static final int f27271p = 2;

    /* renamed from: b */
    public MediaPlayer f27272b = new MediaPlayer();

    /* renamed from: c */
    public int f27273c = 0;

    /* renamed from: d */
    public int f27274d = 0;

    /* renamed from: e */
    public HandlerThread f27275e;

    /* renamed from: f */
    public a f27276f;

    /* renamed from: g */
    public Handler f27277g;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            int i10 = message.what;
            if (i10 != 0) {
                if (i10 != 2) {
                    return;
                }
                i.this.f27272b.release();
                return;
            }
            try {
                i iVar = i.this;
                iVar.f27273c = 0;
                iVar.f27274d = 0;
                iVar.f27272b.release();
                i.this.f27272b = new MediaPlayer();
                i.this.f27272b.setAudioStreamType(3);
                MediaPlayer.class.getDeclaredMethod("setDataSource", String.class, Map.class).invoke(i.this.f27272b, i.f27267l, i.f27269n);
                i.this.f27272b.setLooping(i.f27268m);
                i iVar2 = i.this;
                iVar2.f27272b.setOnPreparedListener(iVar2);
                i iVar3 = i.this;
                iVar3.f27272b.setOnCompletionListener(iVar3);
                i iVar4 = i.this;
                iVar4.f27272b.setOnBufferingUpdateListener(iVar4);
                i.this.f27272b.setScreenOnWhilePlaying(true);
                i iVar5 = i.this;
                iVar5.f27272b.setOnSeekCompleteListener(iVar5);
                i iVar6 = i.this;
                iVar6.f27272b.setOnErrorListener(iVar6);
                i iVar7 = i.this;
                iVar7.f27272b.setOnInfoListener(iVar7);
                i iVar8 = i.this;
                iVar8.f27272b.setOnVideoSizeChangedListener(iVar8);
                i.this.f27272b.prepareAsync();
                i.this.f27272b.setSurface(new Surface(i.f27266k));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public i() {
        HandlerThread handlerThread = new HandlerThread(f27263h);
        this.f27275e = handlerThread;
        handlerThread.start();
        this.f27276f = new a(this.f27275e.getLooper());
        this.f27277g = new Handler();
    }

    public static i i() {
        if (f27264i == null) {
            f27264i = new i();
        }
        return f27264i;
    }

    public static /* synthetic */ void j(int i10) {
        if (o.b() != null) {
            o.b().setBufferProgress(i10);
        }
    }

    public static /* synthetic */ void k() {
        if (o.b() != null) {
            o.b().r();
        }
    }

    public static /* synthetic */ void l(int i10, int i11) {
        if (o.b() != null) {
            o.b().t(i10, i11);
        }
    }

    public static /* synthetic */ void m(int i10, int i11) {
        if (o.b() != null) {
            o.b().v(i10, i11);
        }
    }

    public static /* synthetic */ void n() {
        if (o.b() != null) {
            o.b().w();
        }
    }

    public static /* synthetic */ void o() {
        if (o.b() != null) {
            o.b().x();
        }
    }

    public static /* synthetic */ void p() {
        if (o.b() != null) {
            o.b().G();
        }
    }

    public Point h() {
        if (this.f27273c == 0 || this.f27274d == 0) {
            return null;
        }
        return new Point(this.f27273c, this.f27274d);
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i10) {
        this.f27277g.post(new Runnable() { // from class: ja.c

            /* renamed from: b */
            public final /* synthetic */ int f27258b;

            public /* synthetic */ c(int i102) {
                i10 = i102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                i.j(i10);
            }
        });
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f27277g.post(new Runnable() { // from class: ja.b
            @Override // java.lang.Runnable
            public final void run() {
                i.k();
            }
        });
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
        this.f27277g.post(new Runnable() { // from class: ja.e

            /* renamed from: b */
            public final /* synthetic */ int f27259b;

            /* renamed from: c */
            public final /* synthetic */ int f27260c;

            public /* synthetic */ e(int i102, int i112) {
                i10 = i102;
                i11 = i112;
            }

            @Override // java.lang.Runnable
            public final void run() {
                i.l(i10, i11);
            }
        });
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i10, int i11) {
        this.f27277g.post(new Runnable() { // from class: ja.h

            /* renamed from: b */
            public final /* synthetic */ int f27261b;

            /* renamed from: c */
            public final /* synthetic */ int f27262c;

            public /* synthetic */ h(int i102, int i112) {
                i10 = i102;
                i11 = i112;
            }

            @Override // java.lang.Runnable
            public final void run() {
                i.m(i10, i11);
            }
        });
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f27272b.start();
        this.f27277g.post(new Runnable() { // from class: ja.f
            @Override // java.lang.Runnable
            public final void run() {
                i.n();
            }
        });
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        this.f27277g.post(new Runnable() { // from class: ja.d
            @Override // java.lang.Runnable
            public final void run() {
                i.o();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        SurfaceTexture surfaceTexture2 = f27266k;
        if (surfaceTexture2 != null) {
            f27265j.setSurfaceTexture(surfaceTexture2);
        } else {
            f27266k = surfaceTexture;
            q();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return f27266k == null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
        Log.i(f27263h, "onSurfaceTextureSizeChanged [" + o.b().hashCode() + "] ");
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i10, int i11) {
        this.f27273c = i10;
        this.f27274d = i11;
        this.f27277g.post(new Runnable() { // from class: ja.g
            @Override // java.lang.Runnable
            public final void run() {
                i.p();
            }
        });
    }

    public void q() {
        r();
        Message message = new Message();
        message.what = 0;
        this.f27276f.sendMessage(message);
    }

    public void r() {
        Message message = new Message();
        message.what = 2;
        this.f27276f.sendMessage(message);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
