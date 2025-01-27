package com.martian.libsliding.slider;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.martian.libsliding.SlidingLayout;

/* loaded from: classes.dex */
public class f extends b {

    /* renamed from: i */
    private Float f10541i;
    protected float m;
    protected int n;
    protected Scroller o;
    protected VelocityTracker p;

    /* renamed from: h */
    private boolean f10540h = false;

    /* renamed from: j */
    private boolean f10542j = false;
    private Integer k = null;
    private boolean l = false;

    private View A(int index, boolean forceUpdate) {
        if (index == 0) {
            com.martian.libsliding.e i2 = i();
            return forceUpdate ? i2.l() : i2.h();
        }
        if (index == 1) {
            com.martian.libsliding.e i3 = i();
            return forceUpdate ? i3.j() : i3.d();
        }
        if (index != 2) {
            throw new IllegalStateException("暂时不支持同时显示超过3个view");
        }
        com.martian.libsliding.e i4 = i();
        return forceUpdate ? i4.k() : i4.f();
    }

    private boolean B() {
        return !this.o.isFinished();
    }

    private void C() {
        k().requestLayout();
        this.l = true;
    }

    private void D() {
        for (int i2 = 0; i2 < 3; i2++) {
            x(A(i2, true));
        }
        t();
    }

    private void E(int diffY) {
        int i2 = this.n + diffY;
        this.n = i2;
        if (i2 <= 0) {
            if (i2 < 0) {
                i().t();
                if (i().p()) {
                    k().C(i().c());
                    D();
                    return;
                } else {
                    i().s();
                    this.n = 0;
                    return;
                }
            }
            return;
        }
        if (z(0) == null) {
            return;
        }
        int height = z(0).getHeight();
        if (!i().o()) {
            if (z(1) == null) {
                return;
            }
            int height2 = z(1).getHeight() + height;
            if (this.n + j() >= height2) {
                this.n = height2 - j();
                return;
            }
        }
        int i3 = this.n;
        if (i3 >= height) {
            this.n = i3 - height;
            i().s();
            k().C(i().c());
            D();
        }
    }

    private void F() {
        if (this.n < 0) {
            this.n = z(0).getMeasuredHeight() + this.n;
        }
    }

    private void w(MotionEvent event) {
        this.p.addMovement(event);
    }

    private void x(View view) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        } else {
            layoutParams.height = -2;
        }
        view.setMinimumHeight(j() / 2);
        k().addView(view);
    }

    private void y() {
        this.o.forceFinished(true);
        g();
    }

    private View z(int index) {
        return k().getChildAt(index);
    }

    @Override // com.martian.libsliding.slider.a, com.martian.libsliding.slider.g
    public boolean a(Canvas canvas) {
        canvas.translate(0.0f, -this.n);
        for (int i2 = 0; i2 < k().getChildCount(); i2++) {
            View A = A(i2, this.l);
            if (A != null) {
                A.draw(canvas);
                canvas.translate(0.0f, A.getMeasuredHeight());
            }
        }
        this.l = false;
        return true;
    }

    @Override // com.martian.libsliding.slider.a, com.martian.libsliding.slider.g
    public boolean b(boolean changed, int l, int t, int r, int b2) {
        F();
        int i2 = -this.n;
        int i3 = 0;
        while (i3 < k().getChildCount()) {
            View childAt = k().getChildAt(i3);
            int measuredHeight = childAt.getMeasuredHeight() + i2;
            childAt.layout(0, i2, childAt.getMeasuredWidth(), measuredHeight);
            i3++;
            i2 = measuredHeight;
        }
        return true;
    }

    @Override // com.martian.libsliding.slider.g
    public void c(boolean fromTouch) {
        this.o.startScroll(0, this.n, 0, (-j()) + ((int) (this.m * 30.0f)), 500);
        m();
    }

    @Override // com.martian.libsliding.slider.g
    public void d() {
        if (!i().p()) {
            i().s();
        }
        D();
    }

    @Override // com.martian.libsliding.slider.a, com.martian.libsliding.slider.g
    public void e(SlidingLayout slidingLayout) {
        super.e(slidingLayout);
        this.o = new Scroller(slidingLayout.getContext());
        this.p = VelocityTracker.obtain();
        this.n = 0;
        this.m = slidingLayout.getContext().getResources().getDisplayMetrics().density;
    }

    @Override // com.martian.libsliding.slider.g
    public void f(boolean fromTouch) {
        this.o.startScroll(0, this.n, 0, j() - ((int) (this.m * 30.0f)), 500);
        m();
    }

    @Override // com.martian.libsliding.slider.g
    public void g() {
        if (!this.o.computeScrollOffset()) {
            if (this.f10542j) {
                this.f10542j = false;
                this.k = null;
                C();
                m();
                return;
            }
            return;
        }
        if (this.k == null) {
            this.k = Integer.valueOf(this.o.getStartY());
        }
        int currY = this.o.getCurrY();
        E(currY - this.k.intValue());
        this.k = Integer.valueOf(currY);
        this.f10542j = true;
        m();
    }

    @Override // com.martian.libsliding.slider.a, com.martian.libsliding.slider.g
    public boolean h(MotionEvent event) {
        int action = event.getAction();
        if (action == 0) {
            this.f10541i = Float.valueOf(event.getY());
            if (!B()) {
                return false;
            }
        } else {
            if (action == 1) {
                return this.f10540h;
            }
            if (action != 2) {
                return false;
            }
            if (!this.f10540h && !B() && (this.f10541i == null || Math.abs(event.getY() - this.f10541i.floatValue()) < this.m * 10.0f)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.martian.libsliding.slider.g
    public boolean onTouchEvent(MotionEvent motionEvent) {
        w(motionEvent);
        int action = motionEvent.getAction();
        boolean z = false;
        boolean z2 = false;
        if (action == 0) {
            this.f10540h = false;
            if (B()) {
                y();
                this.f10540h = true;
                z = true;
            }
            this.f10541i = Float.valueOf(motionEvent.getY());
            return z;
        }
        if (action == 1) {
            if (this.f10540h) {
                this.p.computeCurrentVelocity(1000, ViewConfiguration.getMaximumFlingVelocity());
                this.o.fling(0, this.n, 0, (int) (-this.p.getYVelocity()), 0, 0, this.n - (j() * 2), this.n + (j() * 2));
                this.f10540h = false;
                this.p.clear();
                z2 = true;
            }
            m();
            return z2;
        }
        if (action != 2) {
            return false;
        }
        if (B()) {
            y();
            this.f10540h = true;
            this.f10541i = null;
        }
        if (this.f10541i == null) {
            this.f10541i = Float.valueOf(motionEvent.getY());
        }
        float y = motionEvent.getY();
        int floatValue = (int) (this.f10541i.floatValue() - y);
        if (!this.f10540h && Math.abs(floatValue) < this.m * 10.0f) {
            return false;
        }
        this.f10541i = Float.valueOf(y);
        k().B(floatValue <= 0 ? 1 : 0);
        E(floatValue);
        this.f10540h = true;
        m();
        return true;
    }
}
