package com.sigmob.sdk.base.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: classes4.dex */
public class m0 extends View {

    /* renamed from: a */
    public Paint f18781a;

    /* renamed from: b */
    public RectF f18782b;

    /* renamed from: c */
    public float f18783c;

    /* renamed from: d */
    public float f18784d;

    /* renamed from: e */
    public float f18785e;

    /* renamed from: f */
    public int f18786f;

    /* renamed from: g */
    public int f18787g;

    /* renamed from: h */
    public int f18788h;

    /* renamed from: i */
    public int f18789i;

    /* renamed from: j */
    public int f18790j;

    /* renamed from: k */
    public int f18791k;

    /* renamed from: l */
    public int f18792l;

    /* renamed from: m */
    public Path f18793m;

    /* renamed from: n */
    public AnimatorSet f18794n;

    /* renamed from: o */
    public boolean f18795o;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            m0.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            m0.this.b();
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            m0.this.f18783c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            m0.this.invalidate();
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            m0.this.f18784d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            m0.this.invalidate();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            m0.this.f18785e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            m0.this.invalidate();
        }
    }

    public class e implements Animator.AnimatorListener {
        public e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (m0.this.f18794n == null || !m0.this.f18795o) {
                return;
            }
            m0.this.f18794n.start();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public m0(Context context) {
        super(context);
        this.f18781a = new Paint(1);
        this.f18793m = new Path();
        this.f18782b = new RectF();
        c();
    }

    private Animator getFlipLeftAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "rotationY", 0.0f, 45.0f, 0.0f);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, this.f18791k * 0.6f, 0.0f);
        ofFloat2.addUpdateListener(new c());
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.setDuration(1000L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    private Animator getFlipRightAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "rotationY", 0.0f, -45.0f, 0.0f);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, (-this.f18791k) * 0.6f, 0.0f);
        ofFloat2.addUpdateListener(new d());
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.setDuration(1000L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    public void d() {
        this.f18795o = true;
        AnimatorSet animatorSet = this.f18794n;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public void e() {
        this.f18795o = false;
        AnimatorSet animatorSet = this.f18794n;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f18791k == 0 || this.f18792l == 0) {
            return;
        }
        this.f18781a.setStyle(Paint.Style.STROKE);
        this.f18781a.setColor(-1);
        this.f18793m.reset();
        RectF rectF = this.f18782b;
        float f10 = this.f18787g;
        rectF.set(f10, f10, this.f18791k - r1, this.f18792l - r1);
        Path path = this.f18793m;
        RectF rectF2 = this.f18782b;
        float f11 = this.f18786f;
        path.addRoundRect(rectF2, f11, f11, Path.Direction.CCW);
        canvas.drawPath(this.f18793m, this.f18781a);
        canvas.clipPath(this.f18793m);
        Paint paint = this.f18781a;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.f18781a.setColor(-7829368);
        this.f18781a.setAlpha(204);
        canvas.drawRect(0.0f, 0.0f, this.f18791k, this.f18792l, this.f18781a);
        this.f18781a.setColor(-3355444);
        this.f18781a.setAlpha(255);
        float f12 = this.f18792l;
        canvas.drawRect(0.0f, f12 + this.f18783c, this.f18791k, f12, this.f18781a);
        float f13 = this.f18784d;
        canvas.drawRect(((-this.f18791k) * 0.6f) + f13, 0.0f, f13, this.f18792l, this.f18781a);
        float f14 = this.f18791k;
        float f15 = this.f18785e;
        canvas.drawRect(f14 + f15, 0.0f, (f14 * 1.6f) + f15, this.f18792l, this.f18781a);
        this.f18781a.setStyle(style);
        int i10 = this.f18791k;
        int i11 = this.f18788h;
        int i12 = (i10 - i11) / 2;
        int i13 = this.f18792l - this.f18790j;
        float f16 = i12 + i11;
        float f17 = this.f18789i;
        canvas.drawRoundRect(i12, i13, f16, i13 + r0, f17, f17, this.f18781a);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        c();
    }

    public m0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public m0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        c();
    }

    public final void a() {
        AnimatorSet animatorSet = this.f18794n;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.f18794n = new AnimatorSet();
        this.f18794n.playSequentially(a(-45), a(45), getFlipLeftAnimation(), getFlipRightAnimation());
        this.f18794n.addListener(new e());
        if (this.f18795o) {
            this.f18794n.start();
        }
    }

    public final void b() {
        this.f18791k = getWidth();
        int height = getHeight();
        this.f18792l = height;
        if (this.f18791k == 0 || height == 0) {
            return;
        }
        this.f18781a.setStyle(Paint.Style.STROKE);
        int dipsToIntPixels = Dips.dipsToIntPixels(1.0f, getContext());
        this.f18787g = dipsToIntPixels;
        this.f18781a.setStrokeWidth(dipsToIntPixels);
        this.f18781a.setColor(-1);
        this.f18786f = (int) ((this.f18791k / (this.f18787g * 75.0f)) * Dips.dipsToIntPixels(5.0f, getContext()));
        setLayerType(2, null);
        float f10 = this.f18791k;
        int i10 = this.f18787g;
        float f11 = i10;
        this.f18788h = Math.max((int) ((f10 / (f11 * 25.0f)) * f11 * 11.0f), i10 * 3);
        float f12 = this.f18791k;
        int i11 = this.f18787g;
        float f13 = i11;
        this.f18789i = Math.max((int) ((f12 / (f13 * 25.0f)) * 3.0f * f13), i11 * 2);
        float f14 = this.f18791k;
        int i12 = this.f18787g;
        float f15 = i12;
        this.f18790j = Math.max((int) ((f14 / (25.0f * f15)) * 11.0f * f15), i12 * 5);
        a();
    }

    public final void c() {
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public final Animator a(int i10) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "rotation", 0.0f, i10, 0.0f);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, (-this.f18792l) * 0.6f, 0.0f);
        ofFloat2.addUpdateListener(new b());
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.setDuration(1000L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }
}
