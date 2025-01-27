package com.wbl.ad.yzz.wigdet.wblplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public class WblTextureMediaPlayer extends FrameLayout {

    /* renamed from: a */
    public TextureView f34643a;

    /* renamed from: b */
    public MediaPlayer f34644b;

    /* renamed from: c */
    public com.wbl.ad.yzz.wigdet.k.c f34645c;

    /* renamed from: d */
    public Context f34646d;

    /* renamed from: e */
    public String f34647e;

    /* renamed from: f */
    public View f34648f;

    /* renamed from: g */
    public View f34649g;

    /* renamed from: h */
    public float f34650h;

    /* renamed from: i */
    public ImageView f34651i;

    /* renamed from: j */
    public ImageView f34652j;
    public boolean k;

    public class a implements TextureView.SurfaceTextureListener {

        /* renamed from: com.wbl.ad.yzz.wigdet.wblplayer.WblTextureMediaPlayer$a$a */
        public class C0802a implements MediaPlayer.OnPreparedListener {
            public C0802a() {
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7824, this, mediaPlayer);
            }
        }

        public a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7823, this, surfaceTexture, Integer.valueOf(i2), Integer.valueOf(i3));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7818, this, surfaceTexture);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7817, this, surfaceTexture, Integer.valueOf(i2), Integer.valueOf(i3));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7820, this, surfaceTexture);
        }
    }

    public class b implements MediaPlayer.OnInfoListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7819, this, mediaPlayer, Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    public class c implements MediaPlayer.OnBufferingUpdateListener {
        public c(WblTextureMediaPlayer wblTextureMediaPlayer) {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7814, this, mediaPlayer, Integer.valueOf(i2));
        }
    }

    public class d implements MediaPlayer.OnSeekCompleteListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7813, this, mediaPlayer);
        }
    }

    public class e implements MediaPlayer.OnCompletionListener {
        public e() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7816, this, mediaPlayer);
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7815, this, view);
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7810, this, view);
        }
    }

    public interface h {
    }

    public WblTextureMediaPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34650h = 1.5f;
        this.k = false;
    }

    public static /* synthetic */ MediaPlayer a(WblTextureMediaPlayer wblTextureMediaPlayer) {
        return (MediaPlayer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7809, null, wblTextureMediaPlayer);
    }

    public static /* synthetic */ MediaPlayer a(WblTextureMediaPlayer wblTextureMediaPlayer, MediaPlayer mediaPlayer) {
        return (MediaPlayer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7812, null, wblTextureMediaPlayer, mediaPlayer);
    }

    public static /* synthetic */ TextureView a(WblTextureMediaPlayer wblTextureMediaPlayer, TextureView textureView) {
        return (TextureView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7811, null, wblTextureMediaPlayer, textureView);
    }

    public static /* synthetic */ View a(WblTextureMediaPlayer wblTextureMediaPlayer, View view) {
        return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7838, null, wblTextureMediaPlayer, view);
    }

    public static /* synthetic */ Context b(WblTextureMediaPlayer wblTextureMediaPlayer) {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7839, null, wblTextureMediaPlayer);
    }

    public static /* synthetic */ TextureView c(WblTextureMediaPlayer wblTextureMediaPlayer) {
        return (TextureView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7834, null, wblTextureMediaPlayer);
    }

    public static /* synthetic */ String d(WblTextureMediaPlayer wblTextureMediaPlayer) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7833, null, wblTextureMediaPlayer);
    }

    public static /* synthetic */ View e(WblTextureMediaPlayer wblTextureMediaPlayer) {
        return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7836, null, wblTextureMediaPlayer);
    }

    public static /* synthetic */ ImageView f(WblTextureMediaPlayer wblTextureMediaPlayer) {
        return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7835, null, wblTextureMediaPlayer);
    }

    public void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7830, this, Integer.valueOf(i2));
    }

    public final void a(int i2, int i3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7829, this, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public final void a(Context context, TextureView textureView) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7832, this, context, textureView);
    }

    public void a(Context context, String str, com.wbl.ad.yzz.wigdet.k.c cVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7831, this, context, str, cVar);
    }

    public void a(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7826, this, Boolean.valueOf(z));
    }

    public boolean a() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7825, this, null);
    }

    public void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7828, this, null);
    }

    public void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7827, this, null);
    }

    public int getCurrentPosition() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-7918, this, null);
    }

    public String getUrl() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7917, this, null);
    }

    public Object getVideoPlayer() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7920, this, null);
    }

    public boolean getVoice() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7919, this, null);
    }

    public void setClickListener(h hVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7914, this, hVar);
    }
}
