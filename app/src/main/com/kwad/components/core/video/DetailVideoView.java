package com.kwad.components.core.video;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.video.VideoAdapters;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes3.dex */
public class DetailVideoView extends KSFrameLayout implements View.OnClickListener {
    public com.kwad.components.core.page.widget.b WZ;
    private b Xa;
    private SurfaceTexture Xb;
    public Surface Xc;
    private a Xd;
    private PhotoInfo.VideoInfo Xe;
    private final RectF Xf;
    private int Xg;
    private int Xh;

    @NonNull
    private final d Xi;
    private Matrix mMatrix;

    /* renamed from: com.kwad.components.core.video.DetailVideoView$1 */
    public class AnonymousClass1 implements TextureView.SurfaceTextureListener {
        public AnonymousClass1() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
            if (DetailVideoView.this.Xb == surfaceTexture) {
                return;
            }
            DetailVideoView.this.Xb = surfaceTexture;
            DetailVideoView.this.sD();
            DetailVideoView.this.Xc = new Surface(surfaceTexture);
            if (DetailVideoView.this.Xa != null) {
                DetailVideoView.this.Xa.setSurface(DetailVideoView.this.Xc);
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

    /* renamed from: com.kwad.components.core.video.DetailVideoView$2 */
    public class AnonymousClass2 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ boolean Xk;
        final /* synthetic */ float Xl;
        final /* synthetic */ ViewGroup.LayoutParams Xm;
        final /* synthetic */ ValueAnimator.AnimatorUpdateListener Xn;

        public AnonymousClass2(boolean z10, float f10, ViewGroup.LayoutParams layoutParams, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            W = z10;
            width = f10;
            layoutParams = layoutParams;
            animatorUpdateListener = animatorUpdateListener;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (W) {
                int i10 = (int) (intValue / width);
                ViewGroup.LayoutParams layoutParams = layoutParams;
                if (layoutParams != null) {
                    layoutParams.height = intValue;
                    layoutParams.width = i10;
                    DetailVideoView.this.setLayoutParams(layoutParams);
                }
                DetailVideoView.this.adaptVideoSize(i10, intValue);
            } else {
                ViewGroup.LayoutParams layoutParams2 = layoutParams;
                if (layoutParams2 != null) {
                    layoutParams2.height = intValue;
                    layoutParams2.width = -1;
                    DetailVideoView.this.setLayoutParams(layoutParams2);
                }
            }
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = animatorUpdateListener;
            if (animatorUpdateListener != null) {
                animatorUpdateListener.onAnimationUpdate(valueAnimator);
            }
        }
    }

    public interface a {
        void onClickRootView();

        void onClickVideoView();
    }

    public DetailVideoView(Context context) {
        super(context);
        this.Xf = new RectF();
        this.Xg = 0;
        this.Xh = 0;
        this.Xi = new d();
        A(context);
    }

    private void A(Context context) {
        this.mMatrix = new Matrix();
        this.WZ = new com.kwad.components.core.page.widget.b(context);
        addView(this.WZ, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        sC();
    }

    private void sC() {
        this.WZ.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.kwad.components.core.video.DetailVideoView.1
            public AnonymousClass1() {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
                if (DetailVideoView.this.Xb == surfaceTexture) {
                    return;
                }
                DetailVideoView.this.Xb = surfaceTexture;
                DetailVideoView.this.sD();
                DetailVideoView.this.Xc = new Surface(surfaceTexture);
                if (DetailVideoView.this.Xa != null) {
                    DetailVideoView.this.Xa.setSurface(DetailVideoView.this.Xc);
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
        });
    }

    public void sD() {
        Surface surface = this.Xc;
        if (surface != null) {
            try {
                surface.release();
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTrace(th2);
            }
            this.Xc = null;
        }
    }

    public final void adaptVideoSize(int i10, int i11) {
        if (this.WZ == null) {
            com.kwad.sdk.core.d.c.w("DetailVideoView", "adaptVideoSize mTextureView is null");
            return;
        }
        this.Xh = i11;
        this.Xg = i10;
        if (this.Xi.sE()) {
            int sF = this.Xi.sF();
            c bVar = sF != 1 ? sF != 2 ? null : new VideoAdapters.b() : new VideoAdapters.c();
            if (bVar != null) {
                com.kwad.components.core.page.widget.b bVar2 = this.WZ;
                bVar.a(bVar2, (View) bVar2.getParent(), i10, i11);
                return;
            }
            return;
        }
        if (this.Xi.sK()) {
            com.kwad.sdk.c.a.a.F(this.WZ);
            return;
        }
        if (this.Xi.sG()) {
            com.kwad.sdk.c.a.a.e(this.WZ, i10, i11);
            return;
        }
        if (this.Xi.sI()) {
            com.kwad.sdk.c.a.a.f(this.WZ, i10, i11);
            return;
        }
        if (this.Xi.sH()) {
            com.kwad.sdk.c.a.a.d(this.WZ, i10, i11);
            return;
        }
        if (this.Xi.sJ()) {
            a(this.WZ, i10, i11);
            return;
        }
        View view = (View) this.WZ.getParent();
        if (view == null) {
            return;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        PhotoInfo.VideoInfo videoInfo = this.Xe;
        if (videoInfo == null || !com.kwad.sdk.core.response.b.h.a(this.mMatrix, width, height, videoInfo)) {
            ViewGroup.LayoutParams layoutParams = this.WZ.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = (int) ((i11 / (i10 * 1.0f)) * width);
            this.mMatrix.reset();
            this.WZ.setTransform(this.mMatrix);
            this.WZ.setLayoutParams(layoutParams);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.WZ.getLayoutParams();
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            this.WZ.setTransform(this.mMatrix);
            this.WZ.setLayoutParams(layoutParams2);
        }
        this.Xf.set(this.WZ.getLeft(), this.WZ.getTop(), this.WZ.getRight(), this.WZ.getBottom());
    }

    @Deprecated
    public final void fixWidth(boolean z10) {
        this.Xi.aS(z10);
    }

    public final void g(boolean z10, int i10) {
        this.Xi.setAd(true);
        this.Xi.aO(i10);
    }

    public int getTextureViewGravity() {
        com.kwad.components.core.page.widget.b bVar = this.WZ;
        if (bVar == null) {
            return 17;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 17;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.WZ) {
            a aVar = this.Xd;
            if (aVar != null) {
                aVar.onClickVideoView();
                return;
            }
            return;
        }
        a aVar2 = this.Xd;
        if (aVar2 != null) {
            aVar2.onClickRootView();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        sD();
        SurfaceTexture surfaceTexture = this.Xb;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.Xb = null;
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        int i14;
        super.onSizeChanged(i10, i11, i12, i13);
        int i15 = this.Xg;
        if (i15 <= 0 || (i14 = this.Xh) <= 0) {
            return;
        }
        adaptVideoSize(i15, i14);
    }

    @Deprecated
    public void setAd(boolean z10) {
        this.Xi.setAd(z10);
    }

    public void setClickListener(a aVar) {
        this.Xd = aVar;
        setOnClickListener(this);
    }

    @Deprecated
    public void setFillXY(boolean z10) {
        this.Xi.setFillXY(z10);
    }

    @Deprecated
    public void setForce(boolean z10) {
        this.Xi.setForce(z10);
    }

    public void setHorizontalVideo(boolean z10) {
        this.Xi.setHorizontalVideo(z10);
    }

    public void setMediaPlayer(b bVar) {
        this.Xa = bVar;
        Surface surface = this.Xc;
        if (surface == null || bVar == null) {
            return;
        }
        bVar.setSurface(surface);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void setRadius(float f10) {
        com.kwad.components.core.widget.h.b(this, f10);
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        this.Xe = videoInfo;
    }

    public final void updateTextureViewGravity(int i10) {
        com.kwad.components.core.page.widget.b bVar = this.WZ;
        if (bVar == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i10;
            this.WZ.requestLayout();
        }
    }

    private void a(View view, long j10, long j11) {
        View view2;
        if (view == null || j10 == 0 || j11 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        view.getLayoutParams();
        float f10 = j10 / j11;
        float f11 = height * f10;
        float f12 = width;
        if (f11 > f12) {
            height = (int) (f12 / f10);
        } else {
            width = (int) f11;
        }
        if (width == 0 || height == 0) {
            height = -1;
            width = -1;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.WZ.setLayoutParams(layoutParams);
    }

    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Xf = new RectF();
        this.Xg = 0;
        this.Xh = 0;
        this.Xi = new d();
        A(context);
    }

    public final ValueAnimator a(AdTemplate adTemplate, int i10, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        float height = getHeight();
        boolean W = com.kwad.sdk.core.response.b.a.W(com.kwad.sdk.core.response.b.e.eb(adTemplate));
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt((int) height, i10);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.video.DetailVideoView.2
            final /* synthetic */ boolean Xk;
            final /* synthetic */ float Xl;
            final /* synthetic */ ViewGroup.LayoutParams Xm;
            final /* synthetic */ ValueAnimator.AnimatorUpdateListener Xn;

            public AnonymousClass2(boolean W2, float f10, ViewGroup.LayoutParams layoutParams2, ValueAnimator.AnimatorUpdateListener animatorUpdateListener2) {
                W = W2;
                width = f10;
                layoutParams = layoutParams2;
                animatorUpdateListener = animatorUpdateListener2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (W) {
                    int i102 = (int) (intValue / width);
                    ViewGroup.LayoutParams layoutParams2 = layoutParams;
                    if (layoutParams2 != null) {
                        layoutParams2.height = intValue;
                        layoutParams2.width = i102;
                        DetailVideoView.this.setLayoutParams(layoutParams2);
                    }
                    DetailVideoView.this.adaptVideoSize(i102, intValue);
                } else {
                    ViewGroup.LayoutParams layoutParams22 = layoutParams;
                    if (layoutParams22 != null) {
                        layoutParams22.height = intValue;
                        layoutParams22.width = -1;
                        DetailVideoView.this.setLayoutParams(layoutParams22);
                    }
                }
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener2 = animatorUpdateListener;
                if (animatorUpdateListener2 != null) {
                    animatorUpdateListener2.onAnimationUpdate(valueAnimator);
                }
            }
        });
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ofInt.setDuration(500L);
        ofInt.setInterpolator(create);
        return ofInt;
    }
}
