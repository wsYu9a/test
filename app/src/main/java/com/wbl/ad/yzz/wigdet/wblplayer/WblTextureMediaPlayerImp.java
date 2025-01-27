package com.wbl.ad.yzz.wigdet.wblplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public class WblTextureMediaPlayerImp extends FrameLayout {

    /* renamed from: a */
    public MediaPlayer f34660a;

    /* renamed from: b */
    public com.wbl.ad.yzz.wigdet.k.a f34661b;

    /* renamed from: c */
    public Context f34662c;

    /* renamed from: d */
    public String f34663d;

    /* renamed from: e */
    public boolean f34664e;

    /* renamed from: f */
    public int f34665f;

    public class a implements TextureView.SurfaceTextureListener {

        /* renamed from: com.wbl.ad.yzz.wigdet.wblplayer.WblTextureMediaPlayerImp$a$a */
        public class C0803a implements MediaPlayer.OnPreparedListener {
            public C0803a() {
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7913, this, mediaPlayer);
            }
        }

        public a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7916, this, surfaceTexture, Integer.valueOf(i2), Integer.valueOf(i3));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7915, this, surfaceTexture);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7910, this, surfaceTexture, Integer.valueOf(i2), Integer.valueOf(i3));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7909, this, surfaceTexture);
        }
    }

    public class b implements MediaPlayer.OnInfoListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7912, this, mediaPlayer, Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    public class c implements MediaPlayer.OnBufferingUpdateListener {
        public c(WblTextureMediaPlayerImp wblTextureMediaPlayerImp) {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7911, this, mediaPlayer, Integer.valueOf(i2));
        }
    }

    public class d implements MediaPlayer.OnSeekCompleteListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7906, this, mediaPlayer);
        }
    }

    public class e implements MediaPlayer.OnCompletionListener {
        public e() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7905, this, mediaPlayer);
        }
    }

    public class f implements MediaPlayer.OnErrorListener {
        public f() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7908, this, mediaPlayer, Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    public WblTextureMediaPlayerImp(Context context) {
        this(context, null);
    }

    public static /* synthetic */ MediaPlayer a(WblTextureMediaPlayerImp wblTextureMediaPlayerImp) {
        return (MediaPlayer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7907, null, wblTextureMediaPlayerImp);
    }

    public static /* synthetic */ MediaPlayer a(WblTextureMediaPlayerImp wblTextureMediaPlayerImp, MediaPlayer mediaPlayer) {
        return (MediaPlayer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7934, null, wblTextureMediaPlayerImp, mediaPlayer);
    }

    public static /* synthetic */ String c(WblTextureMediaPlayerImp wblTextureMediaPlayerImp) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7936, null, wblTextureMediaPlayerImp);
    }

    public void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7929, this, Integer.valueOf(i2));
    }

    public void a(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7932, this, Boolean.valueOf(z));
    }

    public boolean a() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7931, this, null);
    }

    public void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7926, this, null);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7925, this, null);
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7928, this, null);
    }

    public void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7927, this, null);
    }

    public void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7922, this, null);
    }

    public int getCurrentPosition() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-7921, this, null);
    }

    public int getDuration() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-7924, this, null);
    }

    public String getUrl() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7923, this, null);
    }

    public Object getVideoPlayer() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7886, this, null);
    }

    public boolean getVoice() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7885, this, null);
    }

    public void setContentUrl(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7888, this, str);
    }

    public void setListener(com.wbl.ad.yzz.wigdet.k.a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7887, this, aVar);
    }

    public WblTextureMediaPlayerImp(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WblTextureMediaPlayerImp(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f34664e = false;
        this.f34665f = 0;
        this.f34662c = context;
    }

    public WblTextureMediaPlayerImp(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f34664e = false;
        this.f34665f = 0;
        this.f34662c = context;
    }
}
