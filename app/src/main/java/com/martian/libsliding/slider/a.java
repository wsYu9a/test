package com.martian.libsliding.slider;

import android.graphics.Canvas;
import android.view.MotionEvent;
import com.martian.libsliding.SlidingLayout;

/* loaded from: classes.dex */
public abstract class a implements g {

    /* renamed from: a */
    public static final int f10529a = 0;

    /* renamed from: b */
    public static final int f10530b = 1;

    /* renamed from: c */
    public static final int f10531c = 2;

    /* renamed from: d */
    public static final int f10532d = 4;

    /* renamed from: e */
    public static final int f10533e = 0;

    /* renamed from: f */
    public static final int f10534f = 1;

    /* renamed from: g */
    private SlidingLayout f10535g;

    @Override // com.martian.libsliding.slider.g
    public boolean a(Canvas canvas) {
        return false;
    }

    @Override // com.martian.libsliding.slider.g
    public boolean b(boolean changed, int l, int t, int r, int b2) {
        int childCount = k().getChildCount() - 1;
        k().getChildAt(childCount).layout(l, t, r, b2);
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            k().getChildAt(i2).layout(l - l(), t, r - l(), b2);
        }
        return true;
    }

    @Override // com.martian.libsliding.slider.g
    public void e(SlidingLayout slidingLayout) {
        this.f10535g = slidingLayout;
    }

    @Override // com.martian.libsliding.slider.g
    public boolean h(MotionEvent event) {
        return onTouchEvent(event);
    }

    public com.martian.libsliding.e i() {
        return k().getAdapter();
    }

    public int j() {
        int measuredHeight = k().getMeasuredHeight();
        return measuredHeight == 0 ? k().getContext().getResources().getDisplayMetrics().heightPixels : measuredHeight;
    }

    public SlidingLayout k() {
        return this.f10535g;
    }

    public int l() {
        int measuredWidth = k().getMeasuredWidth();
        return measuredWidth == 0 ? k().getContext().getResources().getDisplayMetrics().widthPixels : measuredWidth;
    }

    public void m() {
        k().invalidate();
    }

    public void n() {
        k().postInvalidate();
    }
}
