package com.martian.libsliding.slider;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.martian.libsliding.SlidingLayout;
import com.martian.libsliding.slider.AutoSlider;

/* loaded from: classes3.dex */
public class c extends AutoSlider {

    /* renamed from: j */
    private GradientDrawable f10536j;
    private Scroller k;
    private float l;
    private int m;
    private boolean n = false;
    private Float o = null;

    public c() {
        this.f10525i = 70;
    }

    private void N(com.martian.libsliding.e adapter) {
        k().removeAllViews();
        if (adapter.p()) {
            k().addView(adapter.l());
        }
        k().addView(adapter.j());
    }

    @Override // com.martian.libsliding.slider.AutoSlider
    public boolean A() {
        return K(this.m);
    }

    @Override // com.martian.libsliding.slider.AutoSlider
    protected void B(int speed) {
    }

    @Override // com.martian.libsliding.slider.AutoSlider
    public boolean C() {
        if (i() == null || !i().o()) {
            return false;
        }
        return K(0);
    }

    @Override // com.martian.libsliding.slider.AutoSlider
    public boolean D() {
        this.k.forceFinished(true);
        return true;
    }

    protected boolean K(int startPosY) {
        int j2 = j();
        if (startPosY < 0 || startPosY >= j2) {
            return false;
        }
        this.m = startPosY;
        this.f10524h = AutoSlider.SlideStatus.SS_START;
        this.k.startScroll(0, startPosY, 0, j2 - startPosY, (int) ((r5 * 1000) / (this.f10525i * this.l)));
        k().requestLayout();
        m();
        return true;
    }

    public void L(int posY) {
        E();
        this.m = posY;
        m();
    }

    public boolean M() {
        if (!i().o()) {
            return false;
        }
        i().s();
        k().C(i().c());
        N(i());
        return true;
    }

    @Override // com.martian.libsliding.slider.a, com.martian.libsliding.slider.g
    public boolean a(Canvas canvas) {
        if (this.f10524h == AutoSlider.SlideStatus.SS_STOP) {
            i().d().draw(canvas);
            return true;
        }
        if (u()) {
            o(1);
        }
        canvas.save();
        canvas.clipRect(0, 0, l(), this.m);
        if (!u() || r() == null || r().isRecycled()) {
            i().j().draw(canvas);
        } else {
            canvas.drawBitmap(r(), 0.0f, 0.0f, (Paint) null);
        }
        canvas.restore();
        View h2 = i().h();
        if (h2 != null) {
            canvas.save();
            canvas.clipRect(0, this.m, l(), j());
            if (!u() || s() == null || s().isRecycled()) {
                h2.draw(canvas);
            } else {
                canvas.drawBitmap(s(), 0.0f, 0.0f, (Paint) null);
            }
            canvas.restore();
        }
        int i2 = this.m;
        if (i2 > 0 && i2 < j()) {
            this.f10536j.setBounds(0, this.m, l(), this.m + 20);
            this.f10536j.draw(canvas);
        }
        return true;
    }

    @Override // com.martian.libsliding.slider.a, com.martian.libsliding.slider.g
    public boolean b(boolean changed, int l, int t, int r, int b2) {
        View childAt;
        int childCount = k().getChildCount() - 1;
        View childAt2 = k().getChildAt(childCount);
        if (childAt2 != null) {
            childAt2.layout(l, t, r, this.m + t);
        }
        int i2 = childCount - 1;
        if (i2 == 0 && (childAt = k().getChildAt(i2)) != null) {
            childAt.layout(l, t + this.m, r, b2);
        }
        return true;
    }

    @Override // com.martian.libsliding.slider.g
    public void c(boolean fromTouch) {
    }

    @Override // com.martian.libsliding.slider.g
    public void d() {
        if (i().p()) {
            k().addView(i().l());
        }
        k().addView(i().j());
        t();
    }

    @Override // com.martian.libsliding.slider.a, com.martian.libsliding.slider.g
    public void e(SlidingLayout slidingLayout) {
        super.e(slidingLayout);
        this.m = 0;
        this.f10524h = AutoSlider.SlideStatus.SS_STOP;
        this.k = new Scroller(k().getContext(), new LinearInterpolator());
        this.l = slidingLayout.getContext().getResources().getDisplayMetrics().density;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{0, 939524096});
        this.f10536j = gradientDrawable;
        gradientDrawable.setGradientType(0);
        if (Build.VERSION.SDK_INT < 19) {
            k().setLayerType(2, null);
        }
    }

    @Override // com.martian.libsliding.slider.g
    public void f(boolean fromTouch) {
    }

    @Override // com.martian.libsliding.slider.g
    public void g() {
        if (this.k.computeScrollOffset()) {
            this.m = this.k.getCurrY();
            k().requestLayout();
            m();
        } else if (this.k.isFinished() && this.f10524h == AutoSlider.SlideStatus.SS_START) {
            this.f10524h = AutoSlider.SlideStatus.SS_STOP;
            M();
            k().requestLayout();
            t();
        }
    }

    @Override // com.martian.libsliding.slider.a, com.martian.libsliding.slider.g
    public boolean h(MotionEvent event) {
        int action = event.getAction();
        if (action == 0) {
            this.o = Float.valueOf(event.getY());
            return false;
        }
        if (action == 1) {
            return this.n;
        }
        if (action != 2) {
            return false;
        }
        return this.n || (this.o != null && Math.abs(event.getY() - this.o.floatValue()) >= this.l * 10.0f);
    }

    @Override // com.martian.libsliding.slider.g
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action != 1) {
            if (action != 2) {
                return false;
            }
            if (this.o == null) {
                this.o = Float.valueOf(event.getY());
            }
            if (!this.n && Math.abs(event.getY() - this.o.floatValue()) < 20.0f) {
                return false;
            }
            L((int) event.getY());
            this.n = true;
            k().B(4);
        } else {
            if (!this.n) {
                return false;
            }
            this.n = false;
            K((int) event.getY());
        }
        return true;
    }

    @Override // com.martian.libsliding.slider.AutoSlider
    public boolean z() {
        this.k.forceFinished(true);
        return true;
    }

    public c(int ddps) {
        this.f10525i = ddps;
    }
}
