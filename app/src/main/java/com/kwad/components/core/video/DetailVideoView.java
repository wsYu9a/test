package com.kwad.components.core.video;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.video.VideoAdapters;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes2.dex */
public class DetailVideoView extends KSFrameLayout implements View.OnClickListener {
    public com.kwad.components.core.page.widget.b QZ;
    private b Ra;
    private SurfaceTexture Rb;
    public Surface Rc;
    private a Rd;
    private PhotoInfo.VideoInfo Re;
    private final RectF Rf;
    private int Rg;
    private int Rh;

    @NonNull
    private final d Ri;
    private Matrix mMatrix;

    /* renamed from: com.kwad.components.core.video.DetailVideoView$1 */
    final class AnonymousClass1 implements TextureView.SurfaceTextureListener {
        AnonymousClass1() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            if (DetailVideoView.this.Rb == surfaceTexture) {
                return;
            }
            DetailVideoView.this.Rb = surfaceTexture;
            DetailVideoView.this.ql();
            DetailVideoView.this.Rc = new Surface(surfaceTexture);
            if (DetailVideoView.this.Ra != null) {
                DetailVideoView.this.Ra.setSurface(DetailVideoView.this.Rc);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* renamed from: com.kwad.components.core.video.DetailVideoView$2 */
    final class AnonymousClass2 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ boolean Rk;
        final /* synthetic */ float Rl;
        final /* synthetic */ ViewGroup.LayoutParams Rm;
        final /* synthetic */ ValueAnimator.AnimatorUpdateListener Rn;

        AnonymousClass2(boolean z, float f2, ViewGroup.LayoutParams layoutParams, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            N = z;
            width = f2;
            layoutParams = layoutParams;
            animatorUpdateListener = animatorUpdateListener;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (N) {
                int i2 = (int) (intValue / width);
                ViewGroup.LayoutParams layoutParams = layoutParams;
                if (layoutParams != null) {
                    layoutParams.height = intValue;
                    layoutParams.width = i2;
                    DetailVideoView.this.setLayoutParams(layoutParams);
                }
                DetailVideoView.this.adaptVideoSize(i2, intValue);
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

    /* renamed from: com.kwad.components.core.video.DetailVideoView$3 */
    final class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ float Rl;
        final /* synthetic */ ViewGroup.LayoutParams Rm;

        AnonymousClass3(float f2, ViewGroup.LayoutParams layoutParams) {
            f2 = f2;
            layoutParams = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            int i2 = (int) (intValue / f2);
            ViewGroup.LayoutParams layoutParams = layoutParams;
            layoutParams.height = i2;
            layoutParams.width = intValue;
            DetailVideoView.this.setLayoutParams(layoutParams);
        }
    }

    public interface a {
        void onClickRootView();

        void onClickVideoView();
    }

    public DetailVideoView(Context context) {
        super(context);
        this.Rf = new RectF();
        this.Rg = 0;
        this.Rh = 0;
        this.Ri = new d();
        D(context);
    }

    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Rf = new RectF();
        this.Rg = 0;
        this.Rh = 0;
        this.Ri = new d();
        D(context);
    }

    private void D(Context context) {
        this.mMatrix = new Matrix();
        this.QZ = new com.kwad.components.core.page.widget.b(context);
        addView(this.QZ, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        qk();
    }

    private void a(View view, long j2, long j3) {
        View view2;
        if (view == null || j2 == 0 || j3 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        view.getLayoutParams();
        float f2 = j2 / j3;
        float f3 = height * f2;
        float f4 = width;
        if (f3 > f4) {
            height = (int) (f4 / f2);
        } else {
            width = (int) f3;
        }
        if (width == 0 || height == 0) {
            height = -1;
            width = -1;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.QZ.setLayoutParams(layoutParams);
    }

    private void qk() {
        this.QZ.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.kwad.components.core.video.DetailVideoView.1
            AnonymousClass1() {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                if (DetailVideoView.this.Rb == surfaceTexture) {
                    return;
                }
                DetailVideoView.this.Rb = surfaceTexture;
                DetailVideoView.this.ql();
                DetailVideoView.this.Rc = new Surface(surfaceTexture);
                if (DetailVideoView.this.Ra != null) {
                    DetailVideoView.this.Ra.setSurface(DetailVideoView.this.Rc);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }

    public void ql() {
        Surface surface = this.Rc;
        if (surface != null) {
            try {
                surface.release();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
            }
            this.Rc = null;
        }
    }

    public final ValueAnimator a(AdTemplate adTemplate, int i2, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        float height = getHeight();
        boolean N = com.kwad.sdk.core.response.a.a.N(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt((int) height, i2);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.video.DetailVideoView.2
            final /* synthetic */ boolean Rk;
            final /* synthetic */ float Rl;
            final /* synthetic */ ViewGroup.LayoutParams Rm;
            final /* synthetic */ ValueAnimator.AnimatorUpdateListener Rn;

            AnonymousClass2(boolean N2, float f2, ViewGroup.LayoutParams layoutParams2, ValueAnimator.AnimatorUpdateListener animatorUpdateListener2) {
                N = N2;
                width = f2;
                layoutParams = layoutParams2;
                animatorUpdateListener = animatorUpdateListener2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (N) {
                    int i22 = (int) (intValue / width);
                    ViewGroup.LayoutParams layoutParams2 = layoutParams;
                    if (layoutParams2 != null) {
                        layoutParams2.height = intValue;
                        layoutParams2.width = i22;
                        DetailVideoView.this.setLayoutParams(layoutParams2);
                    }
                    DetailVideoView.this.adaptVideoSize(i22, intValue);
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

    @Nullable
    public final ValueAnimator aM(int i2) {
        float height = getHeight();
        float width = getWidth();
        float f2 = width / height;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            return null;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt((int) width, i2);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.video.DetailVideoView.3
            final /* synthetic */ float Rl;
            final /* synthetic */ ViewGroup.LayoutParams Rm;

            AnonymousClass3(float f22, ViewGroup.LayoutParams layoutParams2) {
                f2 = f22;
                layoutParams = layoutParams2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                int i22 = (int) (intValue / f2);
                ViewGroup.LayoutParams layoutParams2 = layoutParams;
                layoutParams2.height = i22;
                layoutParams2.width = intValue;
                DetailVideoView.this.setLayoutParams(layoutParams2);
            }
        });
        return ofInt;
    }

    public final void adaptVideoSize(int i2, int i3) {
        if (this.QZ == null) {
            com.kwad.sdk.core.d.b.w("DetailVideoView", "adaptVideoSize mTextureView is null");
            return;
        }
        this.Rh = i3;
        this.Rg = i2;
        if (this.Ri.qm()) {
            int qn = this.Ri.qn();
            VideoAdapters.a aVar = null;
            if (qn == 1) {
                aVar = new VideoAdapters.c();
            } else if (qn == 2) {
                aVar = new VideoAdapters.b();
            }
            if (aVar != null) {
                com.kwad.components.core.page.widget.b bVar = this.QZ;
                aVar.a(bVar, (View) bVar.getParent(), i2, i3);
                return;
            }
            return;
        }
        if (this.Ri.qs()) {
            com.kwad.sdk.c.kwai.a.B(this.QZ);
            return;
        }
        if (this.Ri.qo()) {
            com.kwad.sdk.c.kwai.a.e(this.QZ, i2, i3);
            return;
        }
        if (this.Ri.qq()) {
            com.kwad.sdk.c.kwai.a.f(this.QZ, i2, i3);
            return;
        }
        if (this.Ri.qp()) {
            com.kwad.sdk.c.kwai.a.d(this.QZ, i2, i3);
            return;
        }
        if (this.Ri.qr()) {
            a(this.QZ, i2, i3);
            return;
        }
        View view = (View) this.QZ.getParent();
        if (view == null) {
            return;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        PhotoInfo.VideoInfo videoInfo = this.Re;
        if (videoInfo == null || !com.kwad.sdk.core.response.a.f.a(this.mMatrix, width, height, videoInfo)) {
            ViewGroup.LayoutParams layoutParams = this.QZ.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = (int) ((i3 / (i2 * 1.0f)) * width);
            this.mMatrix.reset();
            this.QZ.setTransform(this.mMatrix);
            this.QZ.setLayoutParams(layoutParams);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.QZ.getLayoutParams();
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            this.QZ.setTransform(this.mMatrix);
            this.QZ.setLayoutParams(layoutParams2);
        }
        this.Rf.set(this.QZ.getLeft(), this.QZ.getTop(), this.QZ.getRight(), this.QZ.getBottom());
    }

    public final void f(boolean z, int i2) {
        this.Ri.setAd(true);
        this.Ri.aN(i2);
    }

    @Deprecated
    public final void fixWidth(boolean z) {
        this.Ri.aN(z);
    }

    public int getTextureViewGravity() {
        com.kwad.components.core.page.widget.b bVar = this.QZ;
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
        if (view == this.QZ) {
            a aVar = this.Rd;
            if (aVar != null) {
                aVar.onClickVideoView();
                return;
            }
            return;
        }
        a aVar2 = this.Rd;
        if (aVar2 != null) {
            aVar2.onClickRootView();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ql();
        SurfaceTexture surfaceTexture = this.Rb;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.Rb = null;
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        int i6;
        super.onSizeChanged(i2, i3, i4, i5);
        int i7 = this.Rg;
        if (i7 <= 0 || (i6 = this.Rh) <= 0) {
            return;
        }
        adaptVideoSize(i7, i6);
    }

    @Deprecated
    public void setAd(boolean z) {
        this.Ri.setAd(z);
    }

    public void setClickListener(a aVar) {
        this.Rd = aVar;
        setOnClickListener(this);
    }

    @Deprecated
    public void setFillXY(boolean z) {
        this.Ri.setFillXY(z);
    }

    @Deprecated
    public void setForce(boolean z) {
        this.Ri.setForce(z);
    }

    public void setHorizontalVideo(boolean z) {
        this.Ri.setHorizontalVideo(z);
    }

    public void setMediaPlayer(b bVar) {
        this.Ra = bVar;
        Surface surface = this.Rc;
        if (surface == null || bVar == null) {
            return;
        }
        bVar.setSurface(surface);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void setRadius(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            com.kwad.components.core.widget.f.b(this, f2);
        }
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        this.Re = videoInfo;
    }

    public final void updateTextureViewGravity(int i2) {
        com.kwad.components.core.page.widget.b bVar = this.QZ;
        if (bVar == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i2;
            this.QZ.requestLayout();
        }
    }
}
