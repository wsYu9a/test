package cn.vlion.ad.inland.ad.view.active;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import cn.vlion.ad.inland.base.R;
import cn.vlion.ad.inland.base.d;
import cn.vlion.ad.inland.base.h6;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public class VlionShakeGuideLayout extends FrameLayout implements d {

    /* renamed from: a */
    public ImageView f2422a;

    /* renamed from: b */
    public boolean f2423b;

    /* renamed from: c */
    public RotateAnimation f2424c;

    public VlionShakeGuideLayout(Context context) {
        this(context, null);
    }

    @Override // cn.vlion.ad.inland.base.d
    public void destroy() {
        try {
            RotateAnimation rotateAnimation = this.f2424c;
            if (rotateAnimation != null) {
                rotateAnimation.cancel();
                this.f2424c = null;
                this.f2423b = false;
            }
            ImageView imageView = this.f2422a;
            if (imageView != null) {
                imageView.clearAnimation();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        ImageView imageView;
        super.onAttachedToWindow();
        try {
            if (!this.f2423b && (imageView = this.f2422a) != null) {
                imageView.post(new h6(this));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            this.f2423b = false;
            ImageView imageView = this.f2422a;
            if (imageView != null) {
                imageView.clearAnimation();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
    }

    public void startAnimator(boolean z10) {
        ImageView imageView;
        try {
            if (!this.f2423b && (imageView = this.f2422a) != null) {
                imageView.post(new h6(this));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public VlionShakeGuideLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VlionShakeGuideLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2423b = false;
        try {
            LayoutInflater.from(context).inflate(R.layout.vlion_cn_ad_shake_guide, (ViewGroup) this, true);
            this.f2422a = (ImageView) findViewById(R.id.vlion_img_shake);
            this.f2423b = false;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
