package com.sigmob.sdk.base.views;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.Dips;
import com.sigmob.sdk.R;

/* loaded from: classes4.dex */
public class c0 extends v {

    /* renamed from: a */
    public ImageView f18490a;

    /* renamed from: b */
    public ObjectAnimator f18491b;

    /* renamed from: c */
    public boolean f18492c;

    /* renamed from: d */
    public f f18493d;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int height = c0.this.getHeight();
            int width = c0.this.getWidth();
            if (height == 0 || width == 0) {
                return;
            }
            c0.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = c0.this.f18490a.getLayoutParams();
            int i10 = height / 2;
            layoutParams.width = i10;
            layoutParams.height = i10;
            c0.this.f18490a.setLayoutParams(layoutParams);
            float f10 = i10;
            c0.this.f18490a.setPivotX(f10);
            c0.this.f18490a.setPivotY(f10 * 0.8f);
        }
    }

    public class b implements Animator.AnimatorListener {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c0.this.f18491b.start();
            }
        }

        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (c0.this.f18492c) {
                new Handler(Looper.getMainLooper()).postDelayed(new a(), 300L);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public c0(Context context) {
        super(context);
        c();
    }

    public final void d() {
        if (this.f18491b != null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f18490a, "rotation", 0.0f, 18.0f, 0.0f, -18.0f, 0.0f, 18.0f, 0.0f, -18.0f, 0.0f, 18.0f, 0.0f);
        this.f18491b = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.f18491b.addListener(new b());
        this.f18491b.setDuration(1200L);
    }

    public final void e() {
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        e();
        d();
        if (this.f18492c) {
            this.f18491b.cancel();
            this.f18491b.start();
        }
    }

    public c0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    @Override // com.sigmob.sdk.base.views.v
    public void a() {
        ObjectAnimator objectAnimator = this.f18491b;
        if (objectAnimator != null && !this.f18492c) {
            objectAnimator.start();
        }
        this.f18492c = true;
    }

    @Override // com.sigmob.sdk.base.views.v
    public void b() {
        ObjectAnimator objectAnimator = this.f18491b;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.f18492c = false;
    }

    public final void c() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        f fVar = new f(getContext());
        this.f18493d = fVar;
        addView(fVar, layoutParams);
        int dipsToIntPixels = Dips.dipsToIntPixels(45.0f, getContext());
        this.f18490a = new ImageView(getContext());
        this.f18490a.setImageDrawable(getResources().getDrawable(R.drawable.sig_image_shake_new));
        this.f18490a.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams2.addRule(13);
        addView(this.f18490a, layoutParams2);
        e();
    }

    public c0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        c();
    }
}
