package com.martian.libsliding.slider;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public class e extends d {
    private int y = 0;

    public e() {
        I(false);
    }

    @Override // com.martian.libsliding.slider.d, com.martian.libsliding.slider.a, com.martian.libsliding.slider.g
    public boolean a(Canvas canvas) {
        int i2;
        int i3 = -l();
        int l = l();
        int i4 = this.f10537h;
        if (i4 > 0) {
            int i5 = -l();
            i4 = this.f10537h;
            i3 = i5 + i4;
            i2 = 1;
        } else if (i4 < 0) {
            l = l() + this.f10537h;
            i2 = 0;
        } else {
            i4 = 0;
            i2 = 4;
        }
        boolean z = !(Build.VERSION.SDK_INT >= 18 && canvas.isHardwareAccelerated()) || u();
        if (z) {
            o(i2);
        }
        if (i2 == 4) {
            i().d().draw(canvas);
            return true;
        }
        View z2 = z();
        if (z2 != null && i3 >= (-l())) {
            canvas.translate(i3, 0.0f);
            if (this.f10537h == 0 || !z || s() == null) {
                z2.draw(canvas);
            } else {
                canvas.drawBitmap(s(), 0.0f, 0.0f, (Paint) null);
            }
            canvas.translate(-i3, 0.0f);
        }
        View y = y();
        if (y != null) {
            canvas.translate(i4, 0.0f);
            if (this.f10537h == 0 || !z || r() == null) {
                y.draw(canvas);
            } else {
                canvas.drawBitmap(r(), 0.0f, 0.0f, (Paint) null);
            }
            canvas.translate(-i4, 0.0f);
        }
        View x = x();
        if (x != null && l <= l()) {
            canvas.translate(l, 0.0f);
            if (this.f10537h == 0 || !z || s() == null) {
                x.draw(canvas);
            } else {
                canvas.drawBitmap(s(), 0.0f, 0.0f, (Paint) null);
            }
            canvas.translate(-l, 0.0f);
        }
        return true;
    }

    @Override // com.martian.libsliding.slider.d, com.martian.libsliding.slider.g
    public boolean onTouchEvent(MotionEvent event) {
        int i2;
        D(event);
        int action = event.getAction();
        boolean z = false;
        if (action == 0) {
            if (A()) {
                this.f10538i.abortAnimation();
                g();
            }
            this.y = (int) event.getX();
            return false;
        }
        boolean z2 = true;
        if (action == 1) {
            int i3 = this.f10537h;
            int abs = (int) Math.abs(this.f10539j.getXVelocity());
            int min = Math.min(this.r, Math.max(this.t, abs));
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
            } else if (i4 != 1 || this.n != 1) {
                z2 = false;
            } else if (i3 > this.k || abs > this.u * 300.0f) {
                this.m = 1;
                this.f10538i.startScroll(i3, 0, l() - i3, 0, ((l() - Math.abs(i3)) * 1000) / min);
            } else {
                this.m = 4;
                this.f10538i.startScroll(i3, 0, -i3, 0, (Math.abs(i3) * 1000) / min);
            }
            G();
            this.y = 0;
            m();
            return z2;
        }
        if (action != 2) {
            return false;
        }
        if (A()) {
            this.f10538i.abortAnimation();
            g();
            this.y = 0;
        }
        if (this.y == 0) {
            this.y = (int) event.getX();
        }
        if (this.o == 0 && Math.abs(event.getX() - this.y) < this.u * 10.0f) {
            return false;
        }
        int x = (int) (event.getX() - this.y);
        if (this.n == 4) {
            if (i().o() && x < 0) {
                this.n = 0;
                k().B(0);
            } else if (i().p() && x > 0) {
                this.n = 1;
                k().B(1);
            }
        }
        if (this.o == 0 && ((this.n == 0 && i().o()) || (this.n == 1 && i().p()))) {
            this.o = 1;
        }
        if (this.o == 1 && (((i2 = this.n) == 0 && x >= 0) || (i2 == 1 && x <= 0))) {
            this.o = 0;
        }
        if (this.n != 4 && this.o == 1) {
            this.f10539j.computeCurrentVelocity(1000, ViewConfiguration.getMaximumFlingVelocity());
            H(x);
            z = true;
        }
        m();
        return z;
    }
}
