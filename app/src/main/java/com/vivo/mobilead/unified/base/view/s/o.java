package com.vivo.mobilead.unified.base.view.s;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.util.y0;

/* loaded from: classes4.dex */
public abstract class o extends com.vivo.mobilead.unified.base.view.s.a {
    protected d H;
    private boolean I;
    private MediaListener J;
    private ViewTreeObserver.OnGlobalLayoutListener K;

    class a implements MediaListener {
        a() {
        }

        @Override // com.vivo.mobilead.unified.base.callback.MediaListener
        public void onVideoCached() {
            MediaListener mediaListener = o.this.n;
            if (mediaListener != null) {
                mediaListener.onVideoCached();
            }
        }

        @Override // com.vivo.mobilead.unified.base.callback.MediaListener
        public void onVideoCompletion() {
            MediaListener mediaListener = o.this.n;
            if (mediaListener != null) {
                mediaListener.onVideoCompletion();
            }
            o oVar = o.this;
            if (oVar.u != null && com.vivo.mobilead.util.d.i(oVar.v)) {
                o.this.u.setVisibility(8);
            }
            o oVar2 = o.this;
            d dVar = oVar2.H;
            if (dVar == null || dVar.indexOfChild(oVar2.C) <= 0) {
                return;
            }
            o oVar3 = o.this;
            oVar3.H.removeView(oVar3.C);
        }

        @Override // com.vivo.mobilead.unified.base.callback.MediaListener
        public void onVideoError(VivoAdError vivoAdError) {
            MediaListener mediaListener = o.this.n;
            if (mediaListener != null) {
                mediaListener.onVideoError(vivoAdError);
            }
            o oVar = o.this;
            d dVar = oVar.H;
            if (dVar == null || dVar.indexOfChild(oVar.C) <= 0) {
                return;
            }
            o oVar2 = o.this;
            oVar2.H.removeView(oVar2.C);
        }

        @Override // com.vivo.mobilead.unified.base.callback.MediaListener
        public void onVideoPause() {
            MediaListener mediaListener = o.this.n;
            if (mediaListener != null) {
                mediaListener.onVideoPause();
            }
        }

        @Override // com.vivo.mobilead.unified.base.callback.MediaListener
        public void onVideoPlay() {
            MediaListener mediaListener = o.this.n;
            if (mediaListener != null) {
                mediaListener.onVideoPlay();
            }
            com.vivo.mobilead.unified.base.view.a aVar = o.this.u;
            if (aVar != null) {
                aVar.setVisibility(0);
            }
        }

        @Override // com.vivo.mobilead.unified.base.callback.MediaListener
        public void onVideoStart() {
            o.this.I = true;
            MediaListener mediaListener = o.this.n;
            if (mediaListener != null) {
                mediaListener.onVideoStart();
            }
            com.vivo.mobilead.unified.base.view.a aVar = o.this.u;
            if (aVar != null) {
                aVar.setVisibility(0);
            }
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (com.vivo.mobilead.unified.nativead.f.e().a() && y0.a(o.this.H, 25)) {
                com.vivo.mobilead.unified.nativead.f.e().b();
            }
            if (Build.VERSION.SDK_INT >= 16) {
                o.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                o.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    public o(@NonNull Context context) {
        super(context);
        this.I = false;
        this.J = new a();
        this.K = new b();
    }

    public void a(String str, Bitmap bitmap) {
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a
    public void b(com.vivo.ad.model.b bVar, AdParams adParams) {
        com.vivo.mobilead.unified.nativead.f.e().a(adParams == null ? 0 : adParams.getVideoPolicy());
        super.b(bVar, adParams);
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a
    protected void c(com.vivo.ad.model.b bVar, AdParams adParams) {
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a
    public void e() {
        super.e();
        d dVar = this.H;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a
    protected int[] getMinSize() {
        return new int[0];
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a
    public void h() {
        if (this.H != null) {
            com.vivo.mobilead.unified.nativead.f.e().c(this.H);
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a
    public void i() {
        if (this.H != null) {
            com.vivo.mobilead.unified.nativead.f.e().d(this.H);
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a
    public void j() {
        if (this.H == null || !this.I) {
            return;
        }
        if (g()) {
            this.H.e();
        } else {
            this.H.c();
        }
    }

    protected d k() {
        d dVar = new d(this.f30039i, this.q);
        dVar.setMediaListener(this.J);
        dVar.setBtnClickListener(this.k);
        dVar.setLayoutParams(new FrameLayout.LayoutParams(getMaterialContainerWidth(), getMaterialContainerHeight()));
        return dVar;
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.K);
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public o(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.I = false;
        this.J = new a();
        this.K = new b();
    }
}
