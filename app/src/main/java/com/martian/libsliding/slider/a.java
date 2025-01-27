package com.martian.libsliding.slider;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.martian.libsliding.SlidingLayout;
import com.martian.libsliding.slider.AutoSlider;
import z9.d;

/* loaded from: classes3.dex */
public class a extends AutoSlider {

    /* renamed from: j */
    public GradientDrawable f12959j;

    /* renamed from: k */
    public Scroller f12960k;

    /* renamed from: l */
    public float f12961l;

    /* renamed from: m */
    public int f12962m;

    /* renamed from: n */
    public boolean f12963n = false;

    /* renamed from: o */
    public Float f12964o = null;

    public a() {
        this.f12939i = 70;
    }

    @Override // com.martian.libsliding.slider.AutoSlider
    public boolean A() {
        this.f12960k.forceFinished(true);
        return true;
    }

    @Override // com.martian.libsliding.slider.AutoSlider
    public boolean B() {
        return L(this.f12962m);
    }

    @Override // com.martian.libsliding.slider.AutoSlider
    public void C(int i10) {
    }

    @Override // com.martian.libsliding.slider.AutoSlider
    public boolean D() {
        if (k() == null || !k().p()) {
            return false;
        }
        return L(0);
    }

    @Override // com.martian.libsliding.slider.AutoSlider
    public boolean E() {
        this.f12960k.forceFinished(true);
        return true;
    }

    public boolean L(int i10) {
        int l10 = l();
        if (i10 < 0 || i10 >= l10) {
            return false;
        }
        this.f12962m = i10;
        this.f12938h = AutoSlider.SlideStatus.SS_START;
        this.f12960k.startScroll(0, i10, 0, l10 - i10, (int) ((r5 * 1000) / (this.f12939i * this.f12961l)));
        m().requestLayout();
        o();
        return true;
    }

    public void M(int i10) {
        F();
        this.f12962m = i10;
        o();
    }

    public void N() {
        if (k().p()) {
            k().s();
            m().G(k().d());
            O(k());
        }
    }

    public final void O(d dVar) {
        m().removeAllViews();
        if (dVar.q()) {
            m().addView(dVar.m());
        }
        m().addView(dVar.k());
    }

    @Override // aa.f
    public void a() {
        if (k().q()) {
            boolean z10 = k().i() != null;
            View m10 = k().m();
            if (!z10) {
                m().addView(m10, 1);
            }
        }
        k().k();
        u();
    }

    @Override // aa.a, aa.f
    public boolean b(Canvas canvas) {
        if (this.f12938h == AutoSlider.SlideStatus.SS_STOP) {
            k().e().draw(canvas);
            return true;
        }
        if (v()) {
            q(1);
        }
        canvas.save();
        canvas.clipRect(0, 0, n(), this.f12962m);
        if (!v() || s() == null || s().isRecycled()) {
            k().k().draw(canvas);
        } else {
            canvas.drawBitmap(s(), 0.0f, 0.0f, (Paint) null);
        }
        canvas.restore();
        View i10 = k().i();
        if (i10 != null) {
            canvas.save();
            canvas.clipRect(0, this.f12962m, n(), l());
            if (!v() || t() == null || t().isRecycled()) {
                i10.draw(canvas);
            } else {
                canvas.drawBitmap(t(), 0.0f, 0.0f, (Paint) null);
            }
            canvas.restore();
        }
        int i11 = this.f12962m;
        if (i11 > 0 && i11 < l()) {
            this.f12959j.setBounds(0, this.f12962m, n(), this.f12962m + 20);
            this.f12959j.draw(canvas);
        }
        return true;
    }

    @Override // aa.a, aa.f
    public boolean c(boolean z10, int i10, int i11, int i12, int i13) {
        View childAt;
        int childCount = m().getChildCount();
        View childAt2 = m().getChildAt(childCount - 1);
        if (childAt2 != null) {
            childAt2.layout(i10, i11, i12, i13);
        }
        int i14 = childCount - 2;
        if (i14 != 0 || (childAt = m().getChildAt(i14)) == null) {
            return true;
        }
        childAt.layout(i10, i11, i12, i13);
        return true;
    }

    @Override // aa.f
    public void d(boolean z10) {
    }

    @Override // aa.f
    public boolean e() {
        return y();
    }

    @Override // aa.f
    public void f() {
        if (k().q()) {
            m().addView(k().m());
        }
        m().addView(k().k());
        u();
    }

    @Override // aa.a, aa.f
    public void g(SlidingLayout slidingLayout) {
        super.g(slidingLayout);
        this.f12962m = 0;
        this.f12938h = AutoSlider.SlideStatus.SS_STOP;
        this.f12960k = new Scroller(m().getContext(), new LinearInterpolator());
        this.f12961l = slidingLayout.getContext().getResources().getDisplayMetrics().density;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{0, 939524096});
        this.f12959j = gradientDrawable;
        gradientDrawable.setGradientType(0);
    }

    @Override // aa.f
    public void h(boolean z10) {
    }

    @Override // aa.f
    public void i() {
        if (this.f12960k.computeScrollOffset()) {
            this.f12962m = this.f12960k.getCurrY();
            m().requestLayout();
            o();
        } else if (this.f12960k.isFinished() && this.f12938h == AutoSlider.SlideStatus.SS_START) {
            this.f12938h = AutoSlider.SlideStatus.SS_STOP;
            N();
            m().requestLayout();
            u();
        }
    }

    @Override // aa.a, aa.f
    public boolean j(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f12964o = Float.valueOf(motionEvent.getY());
            return false;
        }
        if (action == 1) {
            return this.f12963n;
        }
        if (action != 2) {
            return false;
        }
        return this.f12963n || (this.f12964o != null && Math.abs(motionEvent.getY() - this.f12964o.floatValue()) >= this.f12961l * 10.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
    
        if (r0 != 3) goto L71;
     */
    @Override // aa.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getAction()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L4a
            r3 = 2
            if (r0 == r3) goto Lf
            r3 = 3
            if (r0 == r3) goto L4a
            goto L59
        Lf:
            java.lang.Float r0 = r4.f12964o
            if (r0 != 0) goto L1d
            float r0 = r5.getY()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            r4.f12964o = r0
        L1d:
            boolean r0 = r4.f12963n
            if (r0 != 0) goto L37
            float r0 = r5.getY()
            java.lang.Float r3 = r4.f12964o
            float r3 = r3.floatValue()
            float r0 = r0 - r3
            float r0 = java.lang.Math.abs(r0)
            r3 = 1101004800(0x41a00000, float:20.0)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L37
            goto L59
        L37:
            float r5 = r5.getY()
            int r5 = (int) r5
            r4.M(r5)
            r4.f12963n = r1
            com.martian.libsliding.SlidingLayout r5 = r4.m()
            r0 = 4
            r5.F(r0)
            goto L5a
        L4a:
            boolean r0 = r4.f12963n
            if (r0 == 0) goto L59
            r4.f12963n = r2
            float r5 = r5.getY()
            int r5 = (int) r5
            r4.L(r5)
            goto L5a
        L59:
            r1 = 0
        L5a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.libsliding.slider.a.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public a(int i10) {
        this.f12939i = i10;
    }
}
