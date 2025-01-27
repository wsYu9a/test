package com.martian.libsliding.slider;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.martian.libsliding.SlidingLayout;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.tencent.bugly.beta.tinker.TinkerReport;

/* loaded from: classes.dex */
public class d extends b {

    /* renamed from: i */
    protected Scroller f10538i;

    /* renamed from: j */
    protected VelocityTracker f10539j;
    protected int r;
    protected int s;
    protected int t;
    protected float u;
    protected GradientDrawable v;

    /* renamed from: h */
    protected int f10537h = 0;
    protected int k = 0;
    protected int l = 0;
    protected int m = 4;
    protected int n = 4;
    protected int o = 0;
    protected Float p = null;
    protected long q = 0;
    protected boolean w = true;
    private boolean x = false;

    private void F(com.martian.libsliding.e adapter) {
        k().removeAllViews();
        if (i().o()) {
            k().addView(adapter.f());
        }
        if (i().p()) {
            k().addView(adapter.h());
        }
        k().addView(adapter.j());
    }

    protected boolean A() {
        return (this.m == 4 && this.f10538i.isFinished()) ? false : true;
    }

    public boolean B() {
        View n;
        if (!i().o()) {
            return false;
        }
        View h2 = i().h();
        i().s();
        k().C(i().c());
        if (i().o() && h2 != null && (n = i().n(h2, i().e())) != h2) {
            i().z(n);
        }
        F(i());
        return true;
    }

    public boolean C() {
        View n;
        if (!i().p()) {
            return false;
        }
        View f2 = i().f();
        i().t();
        k().C(i().c());
        if (i().p() && f2 != null && f2 != (n = i().n(f2, i().g()))) {
            i().A(n);
        }
        F(i());
        return true;
    }

    protected void D(MotionEvent event) {
        if (this.f10539j == null) {
            this.f10539j = VelocityTracker.obtain();
        }
        this.f10539j.addMovement(event);
    }

    protected void E() {
        VelocityTracker velocityTracker = this.f10539j;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f10539j = null;
        }
    }

    protected void G() {
        this.n = 4;
        this.o = 0;
        this.p = null;
        this.q = 0L;
        E();
    }

    protected void H(int xPos) {
        this.f10537h = xPos;
    }

    public void I(boolean enabled) {
        this.w = enabled;
    }

    @Override // com.martian.libsliding.slider.a, com.martian.libsliding.slider.g
    public boolean a(Canvas canvas) {
        int i2;
        int i3 = -l();
        int i4 = this.f10537h;
        if (i4 > 0) {
            i3 = (-l()) + this.f10537h;
            i4 = 0;
            i2 = 1;
        } else if (i4 < 0) {
            i2 = 0;
        } else {
            i4 = 0;
            i2 = 4;
        }
        boolean u = u();
        if (u) {
            o(i2);
        }
        if (i2 == 4) {
            i().d().draw(canvas);
            return true;
        }
        View x = x();
        if (x != null && this.f10537h < 0) {
            canvas.save();
            canvas.clipRect(l() + this.f10537h, 0, l(), x.getHeight());
            if (this.f10537h == 0 || !u || s() == null || s().isRecycled()) {
                x.draw(canvas);
            } else {
                canvas.drawBitmap(s(), 0.0f, 0.0f, (Paint) null);
            }
            canvas.restore();
        }
        View y = y();
        if (y != null) {
            canvas.translate(i4, 0.0f);
            if (this.f10537h == 0 || !u || r() == null || r().isRecycled()) {
                y.draw(canvas);
            } else {
                canvas.drawBitmap(r(), 0.0f, 0.0f, (Paint) null);
            }
            canvas.translate(-i4, 0.0f);
            if (i4 < 0 && i4 > (-l()) + 20) {
                w(canvas, l() + i4);
            }
        }
        View z = z();
        if (z != null && this.f10537h > 0) {
            canvas.translate(i3, 0.0f);
            if (this.f10537h == 0 || !u || s() == null || s().isRecycled()) {
                z.draw(canvas);
            } else {
                canvas.drawBitmap(s(), 0.0f, 0.0f, (Paint) null);
            }
            canvas.translate(-i3, 0.0f);
            if (i3 > (-l()) && i3 < 20) {
                w(canvas, i3 + l());
            }
        }
        return true;
    }

    @Override // com.martian.libsliding.slider.g
    public void c(boolean fromTouch) {
        if (i().p()) {
            boolean A = A();
            if (A && !fromTouch) {
                this.f10538i.abortAnimation();
                g();
            } else if (A) {
                return;
            }
            this.f10538i.startScroll(0, 0, l(), 0, 1000);
            this.m = 1;
            k().B(1);
            m();
        }
    }

    @Override // com.martian.libsliding.slider.g
    public void d() {
        k().removeAllViews();
        if (i().o()) {
            k().addView(i().k());
        }
        if (i().p()) {
            k().addView(i().l());
        }
        k().addView(i().j());
        t();
    }

    @Override // com.martian.libsliding.slider.a, com.martian.libsliding.slider.g
    @TargetApi(11)
    public void e(SlidingLayout slidingLayout) {
        super.e(slidingLayout);
        this.f10538i = new Scroller(slidingLayout.getContext());
        DisplayMetrics displayMetrics = slidingLayout.getContext().getResources().getDisplayMetrics();
        this.u = displayMetrics.density;
        int i2 = displayMetrics.widthPixels;
        this.l = i2;
        this.k = i2 / 5;
        this.r = (i2 * 2700) / DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED;
        this.s = ((i2 * 1000) * 3) / DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED;
        this.t = ((i2 * TinkerReport.KEY_APPLIED_VERSION_CHECK) * 3) / DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, new int[]{0, 939524096});
        this.v = gradientDrawable;
        gradientDrawable.setGradientType(0);
        if (Build.VERSION.SDK_INT < 19) {
            slidingLayout.setLayerType(2, null);
        }
    }

    @Override // com.martian.libsliding.slider.g
    public void f(boolean fromTouch) {
        if (i().o()) {
            boolean A = A();
            if (A && !fromTouch) {
                this.f10538i.abortAnimation();
                g();
            } else if (A) {
                return;
            }
            this.f10538i.startScroll(0, 0, -l(), 0, 1000);
            this.m = 0;
            k().B(0);
            m();
        }
    }

    @Override // com.martian.libsliding.slider.g
    public void g() {
        int i2;
        if (!this.f10538i.computeScrollOffset()) {
            if (!this.f10538i.isFinished() || (i2 = this.m) == 4) {
                return;
            }
            if (i2 == 0) {
                B();
            } else {
                C();
            }
            this.m = 4;
            k().B(4);
            this.f10537h = 0;
            this.x = false;
            t();
            return;
        }
        int currX = this.f10538i.getCurrX();
        H(currX);
        if (this.w) {
            int finalX = this.f10538i.getFinalX() - currX;
            if (Math.abs(finalX) < 200 && !this.x) {
                int duration = this.f10538i.getDuration() - this.f10538i.timePassed();
                if (duration < 0) {
                    duration = 2;
                }
                this.f10538i.startScroll(currX, 0, finalX, 0, duration / 2);
                this.x = true;
            }
        }
        m();
    }

    @Override // com.martian.libsliding.slider.a, com.martian.libsliding.slider.g
    public boolean h(MotionEvent event) {
        int action = event.getAction();
        if (action == 0) {
            this.p = Float.valueOf(event.getX());
            this.q = System.currentTimeMillis();
            if (!A()) {
                return false;
            }
        } else if (action != 1) {
            if (action != 2) {
                return false;
            }
            if (this.o != 1 && !A() && (this.p == null || Math.abs(event.getX() - this.p.floatValue()) < this.u * 10.0f)) {
                return false;
            }
        } else if (this.o != 1) {
            return false;
        }
        return true;
    }

    @Override // com.martian.libsliding.slider.a
    public int l() {
        int measuredWidth = k().getMeasuredWidth();
        return measuredWidth == 0 ? this.l : measuredWidth;
    }

    @Override // com.martian.libsliding.slider.g
    public boolean onTouchEvent(MotionEvent event) {
        int i2;
        D(event);
        int action = event.getAction();
        boolean z = false;
        if (action != 0) {
            if (action == 1) {
                int i3 = this.f10537h;
                float abs = (int) Math.abs(this.f10539j.getXVelocity());
                int min = Math.min(this.r, this.t + ((int) ((this.u * abs) / 20.0f)));
                int i4 = this.o;
                if (i4 == 1 && this.n == 0) {
                    int i5 = -i3;
                    if (i5 > this.k || abs > this.u * 300.0f) {
                        this.m = 0;
                        this.f10538i.startScroll(i3, 0, (-l()) - i3, 0, ((l() - Math.abs(i3)) * 1000) / min);
                    } else {
                        this.m = 4;
                        this.f10538i.startScroll(i3, 0, i5, 0, (Math.abs(i3) * 1000) / min);
                    }
                } else {
                    if (i4 == 1 && this.n == 1) {
                        if (i3 > this.k || abs > this.u * 300.0f) {
                            this.m = 1;
                            this.f10538i.startScroll(i3, 0, l() - i3, 0, ((l() - Math.abs(i3)) * 1000) / min);
                        } else {
                            this.m = 4;
                            this.f10538i.startScroll(i3, 0, -i3, 0, (Math.abs(i3) * 1000) / min);
                        }
                    }
                    G();
                    m();
                }
                z = true;
                G();
                m();
            } else if (action == 2) {
                if (A()) {
                    this.f10538i.abortAnimation();
                    g();
                    this.p = null;
                }
                if (this.p == null) {
                    this.p = Float.valueOf(event.getX());
                    this.q = System.currentTimeMillis();
                }
                if (this.o != 0 || Math.abs(event.getX() - this.p.floatValue()) >= this.u * 10.0f) {
                    float x = event.getX();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j2 = currentTimeMillis - this.q;
                    float floatValue = x - this.p.floatValue();
                    if (j2 > 0) {
                        float f2 = (j2 * this.s) / 1000;
                        if (Math.abs(floatValue) > f2) {
                            floatValue = (f2 * Math.abs(floatValue)) / floatValue;
                        }
                    }
                    this.q = currentTimeMillis;
                    this.p = Float.valueOf(x);
                    int i6 = (int) (floatValue + this.f10537h);
                    if (this.n == 4) {
                        if (i().o() && i6 < 0) {
                            this.n = 0;
                            k().B(0);
                        } else if (i().p() && i6 > 0) {
                            this.n = 1;
                            k().B(1);
                        }
                    }
                    if (this.o == 0 && ((this.n == 0 && i().o()) || (this.n == 1 && i().p()))) {
                        this.o = 1;
                    }
                    if (this.o == 1 && (((i2 = this.n) == 0 && i6 >= 0) || (i2 == 1 && i6 <= 0))) {
                        this.o = 0;
                    }
                    if (this.n != 4 && this.o == 1) {
                        this.f10539j.computeCurrentVelocity(1000, ViewConfiguration.getMaximumFlingVelocity());
                        H(i6);
                        z = true;
                    }
                    m();
                }
            }
        } else if (A()) {
            this.f10538i.abortAnimation();
            g();
        }
        return z;
    }

    protected void w(Canvas canvas, int offset) {
        this.v.setBounds(offset, 0, ((int) (this.u * 10.0f)) + offset, k().getHeight());
        this.v.draw(canvas);
    }

    public View x() {
        return i().f();
    }

    public View y() {
        return i().d();
    }

    public View z() {
        return i().h();
    }
}
