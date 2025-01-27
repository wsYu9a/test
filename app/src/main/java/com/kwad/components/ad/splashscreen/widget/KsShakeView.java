package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.r.m;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes2.dex */
public class KsShakeView extends KSFrameLayout {
    private int ES;
    private float ET;

    @ColorInt
    private int EU;

    @ColorInt
    private int EV;

    @ColorInt
    private int EW;
    private float EX;
    private float EY;

    @DrawableRes
    private int EZ;
    private Animator Fa;
    private boolean Fb;
    private ImageView fp;

    @Nullable
    private Animator fq;
    private Paint mPaint;

    /* renamed from: com.kwad.components.ad.splashscreen.widget.KsShakeView$1 */
    final class AnonymousClass1 extends AnimatorListenerAdapter {
        AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            KsShakeView.this.fp.setRotation(0.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (KsShakeView.this.Fb || KsShakeView.this.fq == null) {
                return;
            }
            KsShakeView.this.fq.start();
        }
    }

    public KsShakeView(@NonNull Context context) {
        this(context, null, 0);
    }

    public KsShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KsShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mPaint = new Paint();
        this.Fb = false;
        init(context, attributeSet, i2);
    }

    private Animator a(View view, long j2, float f2) {
        Interpolator create;
        float height;
        if (view == null) {
            return null;
        }
        if (this.ES == 1) {
            create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
            view.setPivotX(view.getWidth());
            height = view.getHeight();
        } else {
            create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.36f, 1.0f);
            view.setPivotX(view.getWidth() / 2.0f);
            height = view.getHeight() / 2.0f;
        }
        view.setPivotY(height);
        return m.a(view, create, 100L, 16.0f);
    }

    private static Animator b(View view, long j2, float f2) {
        Interpolator create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.36f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", f2).setDuration(100L);
        duration.setInterpolator(create);
        float f3 = -f2;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "translationY", f3).setDuration(200L);
        duration2.setInterpolator(create);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "translationY", f2).setDuration(200L);
        duration3.setInterpolator(create);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, "translationY", f3).setDuration(200L);
        duration4.setInterpolator(create);
        animatorSet.playSequentially(duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, "translationY", f2).setDuration(100L), ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f).setDuration(100L));
        return animatorSet;
    }

    @SuppressLint({"CustomViewStyleable"})
    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i2, 0);
        this.ET = obtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_outerStrokeWidth, 1.0f);
        this.EU = obtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_outerStrokeColor, Color.parseColor("#4DFFFFFF"));
        this.EV = obtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_solidColor, Color.parseColor("#66000000"));
        this.ES = obtainStyledAttributes.getInteger(R.styleable.ksad_KsShakeView_ksad_shakeViewStyle, 1);
        this.EW = obtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_innerCircleStrokeColor, Color.parseColor("#B3FFFFFF"));
        this.EX = obtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_innerCircleStrokeWidth, 1.0f);
        this.EZ = obtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_ic_shake_hand);
        this.EY = obtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_innerCirclePadding, com.kwad.sdk.c.kwai.a.a(context, 10.0f));
        obtainStyledAttributes.recycle();
        this.fp = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.fp, layoutParams);
        lb();
    }

    private void lb() {
        this.fp.setImageResource(this.EZ);
    }

    private void setBgCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.EV);
        paint.setAntiAlias(true);
    }

    private void setInnerCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.EX);
        paint.setColor(this.EW);
        paint.setAntiAlias(true);
    }

    private void setOuterCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.ET);
        paint.setColor(this.EU);
        paint.setAntiAlias(true);
    }

    public final void ah(int i2) {
        this.ES = i2;
        setIconDrawableRes(i2 != 2 ? R.drawable.ksad_ic_shake_hand : R.drawable.ksad_ic_shake_phone);
    }

    public final void b(AnimatorListenerAdapter animatorListenerAdapter) {
        this.Fb = true;
        Animator animator = this.fq;
        if (animator != null) {
            animator.cancel();
        }
        this.fp.setRotation(0.0f);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ksad_splash_shake_animator_height);
        Animator animator2 = this.Fa;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator b2 = b(this, 100L, dimensionPixelSize);
        this.Fa = b2;
        b2.addListener(animatorListenerAdapter);
        this.Fa.start();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float min = Math.min(getWidth(), getHeight()) / 2.0f;
        setBgCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.mPaint);
        setOuterCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.mPaint);
        if (this.ES == 2) {
            setInnerCirclePaint(this.mPaint);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min - this.EY, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    public final void jW() {
        Animator animator = this.fq;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.Fa;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.fq = null;
        this.Fa = null;
    }

    @MainThread
    public final void lw() {
        this.Fb = false;
        Animator animator = this.fq;
        if (animator != null) {
            animator.cancel();
            this.fq = null;
        }
        Animator a2 = a(this.fp, 100L, 16.0f);
        this.fq = a2;
        if (a2 != null) {
            a2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.KsShakeView.1
                AnonymousClass1() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    KsShakeView.this.fp.setRotation(0.0f);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (KsShakeView.this.Fb || KsShakeView.this.fq == null) {
                        return;
                    }
                    KsShakeView.this.fq.start();
                }
            });
            this.fq.start();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void onViewDetached() {
        super.onViewDetached();
        Animator animator = this.fq;
        if (animator != null) {
            animator.cancel();
        }
    }

    @MainThread
    public void setIconDrawableRes(@DrawableRes int i2) {
        ImageView imageView = this.fp;
        if (imageView != null) {
            imageView.setImageResource(i2);
        }
    }
}
