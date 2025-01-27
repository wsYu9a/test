package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a */
    protected static final int f6733a = 225;

    /* renamed from: b */
    protected static final int f6734b = 175;

    /* renamed from: c */
    private static final int f6735c = 1;

    /* renamed from: d */
    private static final int f6736d = 2;

    /* renamed from: e */
    private int f6737e;

    /* renamed from: f */
    private int f6738f;

    /* renamed from: g */
    private int f6739g;

    /* renamed from: h */
    @Nullable
    private ViewPropertyAnimator f6740h;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f6740h = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.f6737e = 0;
        this.f6738f = 2;
        this.f6739g = 0;
    }

    private void b(@NonNull V v, int i2, long j2, TimeInterpolator timeInterpolator) {
        this.f6740h = v.animate().translationY(i2).setInterpolator(timeInterpolator).setDuration(j2).setListener(new a());
    }

    public void c(@NonNull V v, @Dimension int i2) {
        this.f6739g = i2;
        if (this.f6738f == 1) {
            v.setTranslationY(this.f6737e + i2);
        }
    }

    public void d(@NonNull V v) {
        if (this.f6738f == 1) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f6740h;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f6738f = 1;
        b(v, this.f6737e + this.f6739g, 175L, com.google.android.material.a.a.f6609c);
    }

    public void e(@NonNull V v) {
        if (this.f6738f == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f6740h;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f6738f = 2;
        b(v, 0, 225L, com.google.android.material.a.a.f6610d);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        this.f6737e = v.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).bottomMargin;
        return super.onLayoutChild(coordinatorLayout, v, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, int i4, int i5, int i6, @NonNull int[] iArr) {
        if (i3 > 0) {
            d(v);
        } else if (i3 < 0) {
            e(v);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2, int i3) {
        return i2 == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6737e = 0;
        this.f6738f = 2;
        this.f6739g = 0;
    }
}
