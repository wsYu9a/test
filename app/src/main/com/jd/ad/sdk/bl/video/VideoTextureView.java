package com.jd.ad.sdk.bl.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.jd.ad.sdk.bl.video.jad_an;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class VideoTextureView extends TextureView implements com.jd.ad.sdk.bl.video.jad_an {
    public jad_an.InterfaceC0315jad_an jad_an;
    public SurfaceTexture jad_bo;
    public boolean jad_cp;
    public int jad_dq;
    public int jad_er;
    public Surface jad_fs;

    public static final class jad_bo implements jad_an.jad_bo {
        public WeakReference<Surface> jad_an;
        public WeakReference<VideoTextureView> jad_bo;

        public jad_bo(VideoTextureView videoTextureView, SurfaceTexture surfaceTexture) {
            this.jad_bo = new WeakReference<>(videoTextureView);
            this.jad_an = new WeakReference<>(new Surface(surfaceTexture));
        }
    }

    public class jad_cp implements TextureView.SurfaceTextureListener {
        public jad_cp() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
            VideoTextureView videoTextureView = VideoTextureView.this;
            jad_an.InterfaceC0315jad_an interfaceC0315jad_an = videoTextureView.jad_an;
            if (interfaceC0315jad_an != null) {
                jad_bo jad_boVar = new jad_bo(videoTextureView, surfaceTexture);
                VideoRenderView videoRenderView = ((com.jd.ad.sdk.bl.video.jad_cp) interfaceC0315jad_an).jad_an;
                videoRenderView.jad_jt = jad_boVar;
                MediaPlayer mediaPlayer = videoRenderView.jad_an;
                WeakReference<VideoTextureView> weakReference = jad_boVar.jad_bo;
                VideoTextureView videoTextureView2 = weakReference != null ? weakReference.get() : null;
                if (mediaPlayer == null || jad_boVar.jad_an == null || videoTextureView2 == null) {
                    return;
                }
                SurfaceTexture ownSurfaceTexture = videoTextureView2.getOwnSurfaceTexture();
                SurfaceTexture surfaceTexture2 = videoTextureView2.getSurfaceTexture();
                boolean z10 = false;
                boolean isReleased = (ownSurfaceTexture == null || Build.VERSION.SDK_INT < 26) ? false : ownSurfaceTexture.isReleased();
                if (ownSurfaceTexture != null && !isReleased) {
                    z10 = true;
                }
                if (!videoTextureView2.jad_cp || !z10) {
                    Surface surface = jad_boVar.jad_an.get();
                    if (surface != null) {
                        mediaPlayer.setSurface(surface);
                        videoTextureView2.setSurface(surface);
                        return;
                    }
                    return;
                }
                if (!ownSurfaceTexture.equals(surfaceTexture2)) {
                    videoTextureView2.setSurfaceTexture(ownSurfaceTexture);
                    return;
                }
                Surface surface2 = videoTextureView2.getSurface();
                if (surface2 != null) {
                    surface2.release();
                }
                Surface surface3 = new Surface(ownSurfaceTexture);
                mediaPlayer.setSurface(surface3);
                videoTextureView2.setSurface(surface3);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            VideoTextureView videoTextureView = VideoTextureView.this;
            jad_an.InterfaceC0315jad_an interfaceC0315jad_an = videoTextureView.jad_an;
            if (interfaceC0315jad_an != null) {
                new WeakReference(videoTextureView);
                new WeakReference(new Surface(surfaceTexture));
                ((com.jd.ad.sdk.bl.video.jad_cp) interfaceC0315jad_an).jad_an.jad_jt = null;
            }
            VideoTextureView videoTextureView2 = VideoTextureView.this;
            boolean z10 = videoTextureView2.jad_cp;
            if (z10) {
                videoTextureView2.jad_bo = surfaceTexture;
            }
            return !z10;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
            VideoTextureView videoTextureView = VideoTextureView.this;
            if (videoTextureView.jad_an != null) {
                new WeakReference(videoTextureView);
                new WeakReference(new Surface(surfaceTexture));
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public /* synthetic */ jad_cp(VideoTextureView videoTextureView, jad_an jad_anVar) {
            this();
        }
    }

    public VideoTextureView(Context context) {
        this(context, null);
    }

    public SurfaceTexture getOwnSurfaceTexture() {
        return this.jad_bo;
    }

    public View getRenderView() {
        return this;
    }

    public Surface getSurface() {
        return this.jad_fs;
    }

    @Override // com.jd.ad.sdk.bl.video.jad_an
    public void jad_an(int i10, int i11) {
        this.jad_dq = i10;
        this.jad_er = i11;
        requestLayout();
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        float f10;
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (this.jad_dq > 0 && this.jad_er > 0) {
            if (mode == 0 || mode2 == 0) {
                if (mode == 0) {
                    i10 = (int) (size2 * 0.5625f);
                } else if (mode2 == 0) {
                    f10 = size;
                    i11 = (int) (f10 / 0.5625f);
                    i10 = size;
                } else {
                    i10 = size;
                }
                i11 = size2;
            } else {
                f10 = size;
                float f11 = size2;
                if (f10 / f11 <= 0.5625f) {
                    i10 = (int) (f11 * 0.5625f);
                    i11 = size2;
                }
                i11 = (int) (f10 / 0.5625f);
                i10 = size;
            }
        }
        setMeasuredDimension(i10, i11);
    }

    @Override // com.jd.ad.sdk.bl.video.jad_an
    public void setRenderCallback(jad_an.InterfaceC0315jad_an interfaceC0315jad_an) {
        this.jad_an = interfaceC0315jad_an;
    }

    public void setSurface(Surface surface) {
        this.jad_fs = surface;
    }

    public void setTakeOverSurfaceTexture(boolean z10) {
        this.jad_cp = z10;
    }

    public VideoTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoTextureView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        setSurfaceTextureListener(new jad_cp());
    }

    @Override // com.jd.ad.sdk.bl.video.jad_an
    public void jad_an() {
        SurfaceTexture surfaceTexture = this.jad_bo;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.jad_bo = null;
        }
        Surface surface = this.jad_fs;
        if (surface != null) {
            surface.release();
            this.jad_fs = null;
        }
        setSurfaceTextureListener(null);
    }
}
