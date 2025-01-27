package com.martian.libsliding.slider;

import android.graphics.Canvas;
import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.martian.libsliding.SlidingLayout;

/* loaded from: classes.dex */
public class h extends a {

    /* renamed from: h */
    private VelocityTracker f10543h;

    /* renamed from: i */
    private int f10544i = 0;

    /* renamed from: j */
    private int f10545j = 0;
    private int k = 4;
    private int l = 0;
    private Float m = null;
    protected float n;

    private boolean o() {
        if (!i().o()) {
            return false;
        }
        i().s();
        r();
        k().C(i().c());
        k().removeAllViews();
        k().addView(i().j());
        n();
        return true;
    }

    private boolean p() {
        if (!i().p()) {
            return false;
        }
        i().t();
        s();
        k().C(i().c());
        k().removeAllViews();
        k().addView(i().j());
        n();
        return true;
    }

    private void q(MotionEvent event) {
        if (this.f10543h == null) {
            this.f10543h = VelocityTracker.obtain();
        }
        this.f10543h.addMovement(event);
    }

    private void t() {
        VelocityTracker velocityTracker = this.f10543h;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f10543h = null;
        }
    }

    private void u() {
        this.k = 4;
        this.l = 0;
        this.m = null;
        t();
    }

    @Override // com.martian.libsliding.slider.a, com.martian.libsliding.slider.g
    public boolean a(Canvas canvas) {
        i().d().draw(canvas);
        return true;
    }

    @Override // com.martian.libsliding.slider.g
    public void c(boolean fromTouch) {
        k().B(1);
        p();
    }

    @Override // com.martian.libsliding.slider.g
    public void d() {
        k().addView(i().j());
    }

    @Override // com.martian.libsliding.slider.a, com.martian.libsliding.slider.g
    public void e(SlidingLayout slidingLayout) {
        super.e(slidingLayout);
        int i2 = slidingLayout.getContext().getResources().getDisplayMetrics().widthPixels;
        this.f10545j = i2;
        this.f10544i = i2 / 5;
        this.n = slidingLayout.getContext().getResources().getDisplayMetrics().density;
        if (Build.VERSION.SDK_INT < 19) {
            k().setLayerType(2, null);
        }
    }

    @Override // com.martian.libsliding.slider.g
    public void f(boolean fromTouch) {
        k().B(0);
        o();
    }

    @Override // com.martian.libsliding.slider.g
    public void g() {
    }

    @Override // com.martian.libsliding.slider.a, com.martian.libsliding.slider.g
    public boolean h(MotionEvent event) {
        int action = event.getAction();
        if (action == 0) {
            this.m = Float.valueOf(event.getX());
            return false;
        }
        if (action != 1) {
            if (action != 2) {
                return false;
            }
            if (this.l != 1 && (this.m == null || Math.abs(event.getX() - this.m.floatValue()) < this.n * 10.0f)) {
                return false;
            }
        } else if (this.l != 1) {
            return false;
        }
        return true;
    }

    @Override // com.martian.libsliding.slider.g
    public boolean onTouchEvent(MotionEvent event) {
        int i2;
        int i3;
        q(event);
        int action = event.getAction();
        boolean z = false;
        if (action != 1) {
            if (action == 2) {
                if (this.m == null) {
                    this.m = Float.valueOf(event.getX());
                }
                if (this.l != 0 || Math.abs(event.getX() - this.m.floatValue()) >= this.n * 10.0f) {
                    int floatValue = (int) (this.m.floatValue() - event.getX());
                    if (this.k == 4) {
                        if (floatValue > 0) {
                            this.k = 0;
                            k().B(0);
                        } else if (floatValue < 0) {
                            this.k = 1;
                            k().B(1);
                        }
                    }
                    if (this.l == 0 && ((i3 = this.k) == 0 || i3 == 1)) {
                        this.l = 1;
                    }
                    if (this.l == 1 && (((i2 = this.k) == 0 && floatValue <= 0) || (i2 == 1 && floatValue >= 0))) {
                        this.l = 0;
                    }
                    if (this.k != 4 && this.l == 1) {
                        this.f10543h.computeCurrentVelocity(1000, ViewConfiguration.getMaximumFlingVelocity());
                        z = true;
                    }
                    n();
                }
            }
        } else {
            if (this.k == 4) {
                return false;
            }
            int xVelocity = (int) this.f10543h.getXVelocity();
            int floatValue2 = (int) (this.m.floatValue() - event.getX());
            int i4 = this.l;
            if (i4 != 1 || this.k != 0) {
                if (i4 == 1 && this.k == 1) {
                    if (this.f10545j - floatValue2 > this.f10544i || xVelocity > 500) {
                        p();
                    }
                }
                u();
                n();
            } else if (floatValue2 > this.f10544i || xVelocity < -500) {
                o();
            }
            z = true;
            u();
            n();
        }
        return z;
    }

    protected void r() {
    }

    protected void s() {
    }
}
