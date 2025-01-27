package aa;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.martian.libsliding.SlidingLayout;

/* loaded from: classes3.dex */
public class g extends a {

    /* renamed from: h */
    public VelocityTracker f124h;

    /* renamed from: i */
    public int f125i = 0;

    /* renamed from: j */
    public int f126j = 0;

    /* renamed from: k */
    public int f127k = 4;

    /* renamed from: l */
    public int f128l = 0;

    /* renamed from: m */
    public Float f129m = null;

    /* renamed from: n */
    public float f130n;

    private void q() {
        if (k().p()) {
            k().s();
            t();
            m().G(k().d());
            m().removeAllViews();
            m().addView(k().k());
            p();
        }
    }

    private void r() {
        if (k().q()) {
            k().t();
            u();
            m().G(k().d());
            m().removeAllViews();
            m().addView(k().k());
            m().F(4);
            p();
        }
    }

    private void s(MotionEvent motionEvent) {
        if (this.f124h == null) {
            this.f124h = VelocityTracker.obtain();
        }
        this.f124h.addMovement(motionEvent);
    }

    private void v() {
        VelocityTracker velocityTracker = this.f124h;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f124h = null;
        }
    }

    private void w() {
        this.f127k = 4;
        this.f128l = 0;
        this.f129m = null;
        v();
    }

    @Override // aa.f
    public void a() {
        k().k();
    }

    @Override // aa.a, aa.f
    public boolean b(Canvas canvas) {
        k().e().draw(canvas);
        return true;
    }

    @Override // aa.f
    public void d(boolean z10) {
        m().F(1);
        r();
    }

    @Override // aa.f
    public boolean e() {
        return false;
    }

    @Override // aa.f
    public void f() {
        m().addView(k().k());
    }

    @Override // aa.a, aa.f
    public void g(SlidingLayout slidingLayout) {
        super.g(slidingLayout);
        int i10 = slidingLayout.getContext().getResources().getDisplayMetrics().widthPixels;
        this.f126j = i10;
        this.f125i = i10 / 5;
        this.f130n = slidingLayout.getContext().getResources().getDisplayMetrics().density;
    }

    @Override // aa.f
    public void h(boolean z10) {
        m().F(0);
        q();
    }

    @Override // aa.a, aa.f
    public boolean j(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f129m = Float.valueOf(motionEvent.getX());
            return false;
        }
        if (action != 1) {
            if (action != 2) {
                return false;
            }
            if (this.f128l != 1) {
                Float f10 = this.f129m;
                if (f10 == null || f10.floatValue() == 0.0f) {
                    return false;
                }
                float x10 = motionEvent.getX() - this.f129m.floatValue();
                if (x10 > 0.0f && !k().q()) {
                    return false;
                }
                if ((x10 < 0.0f && !k().p()) || Math.abs(x10) < this.f130n * 10.0f) {
                    return false;
                }
            }
        } else if (this.f128l != 1) {
            return false;
        }
        return true;
    }

    @Override // aa.f
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i10;
        int i11;
        s(motionEvent);
        int action = motionEvent.getAction();
        boolean z10 = true;
        if (action != 1) {
            if (action == 2) {
                if (this.f129m == null) {
                    this.f129m = Float.valueOf(motionEvent.getX());
                }
                if (this.f128l == 0 && Math.abs(motionEvent.getX() - this.f129m.floatValue()) < this.f130n * 10.0f) {
                    return false;
                }
                int floatValue = (int) (this.f129m.floatValue() - motionEvent.getX());
                if (this.f127k == 4) {
                    if (floatValue > 0) {
                        this.f127k = 0;
                        m().F(0);
                    } else if (floatValue < 0) {
                        this.f127k = 1;
                        m().F(1);
                    }
                }
                if (this.f128l == 0 && ((i11 = this.f127k) == 0 || i11 == 1)) {
                    this.f128l = 1;
                }
                if (this.f128l == 1 && (((i10 = this.f127k) == 0 && floatValue <= 0) || (i10 == 1 && floatValue >= 0))) {
                    this.f128l = 0;
                }
                if (this.f127k == 4 || this.f128l != 1) {
                    z10 = false;
                } else {
                    this.f124h.computeCurrentVelocity(1000);
                }
                p();
                return z10;
            }
            if (action != 3) {
                return false;
            }
        }
        if (this.f127k == 4) {
            return false;
        }
        int xVelocity = (int) this.f124h.getXVelocity();
        int floatValue2 = (int) (this.f129m.floatValue() - motionEvent.getX());
        int i12 = this.f128l;
        if (i12 == 1 && this.f127k == 0) {
            if (floatValue2 > this.f125i || xVelocity < -500) {
                q();
            }
        } else if (i12 != 1 || this.f127k != 1) {
            z10 = false;
        } else if (this.f126j - floatValue2 > this.f125i || xVelocity > 500) {
            r();
        }
        w();
        p();
        return z10;
    }

    @Override // aa.f
    public void i() {
    }

    public void t() {
    }

    public void u() {
    }
}
