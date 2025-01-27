package aa;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.martian.libsliding.SlidingLayout;

/* loaded from: classes3.dex */
public class e extends b {

    /* renamed from: i */
    public Float f116i;

    /* renamed from: m */
    public float f120m;

    /* renamed from: n */
    public int f121n;

    /* renamed from: o */
    public Scroller f122o;

    /* renamed from: p */
    public VelocityTracker f123p;

    /* renamed from: h */
    public boolean f115h = false;

    /* renamed from: j */
    public boolean f117j = false;

    /* renamed from: k */
    public Integer f118k = null;

    /* renamed from: l */
    public boolean f119l = false;

    public final View A(int i10) {
        return m().getChildAt(i10);
    }

    public final View B(int i10, boolean z10) {
        if (i10 == 0) {
            z9.d k10 = k();
            return z10 ? k10.m() : k10.i();
        }
        if (i10 == 1) {
            z9.d k11 = k();
            return z10 ? k11.k() : k11.e();
        }
        if (i10 != 2) {
            throw new IllegalStateException("暂时不支持同时显示超过3个view");
        }
        z9.d k12 = k();
        return z10 ? k12.l() : k12.g();
    }

    public final boolean C() {
        return !this.f122o.isFinished();
    }

    public final void D() {
        m().requestLayout();
        this.f119l = true;
    }

    public final void E() {
        for (int i10 = 0; i10 < 3; i10++) {
            y(B(i10, true));
        }
        u();
    }

    public final void F(int i10) {
        int i11 = this.f121n + i10;
        this.f121n = i11;
        if (i11 <= 0) {
            if (i11 < 0) {
                k().t();
                if (k().q()) {
                    m().G(k().d());
                    E();
                    return;
                } else {
                    k().s();
                    this.f121n = 0;
                    return;
                }
            }
            return;
        }
        if (A(0) == null) {
            return;
        }
        int height = A(0).getHeight();
        if (!k().p()) {
            if (A(1) == null) {
                return;
            }
            int height2 = A(1).getHeight() + height;
            if (this.f121n + l() >= height2) {
                this.f121n = height2 - l();
                return;
            }
        }
        int i12 = this.f121n;
        if (i12 >= height) {
            this.f121n = i12 - height;
            k().s();
            m().G(k().d());
            E();
        }
    }

    public final void G() {
        if (this.f121n < 0) {
            this.f121n = A(0).getMeasuredHeight() + this.f121n;
        }
    }

    @Override // aa.f
    public void a() {
        for (int i10 = 0; i10 < 3; i10++) {
            if (B(i10, false) == null) {
                y(B(i10, true));
            } else {
                B(i10, true);
            }
        }
        u();
    }

    @Override // aa.a, aa.f
    public boolean b(Canvas canvas) {
        canvas.translate(0.0f, -this.f121n);
        for (int i10 = 0; i10 < m().getChildCount(); i10++) {
            View B = B(i10, this.f119l);
            if (B != null) {
                B.draw(canvas);
                canvas.translate(0.0f, B.getMeasuredHeight());
            }
        }
        this.f119l = false;
        return true;
    }

    @Override // aa.a, aa.f
    public boolean c(boolean z10, int i10, int i11, int i12, int i13) {
        G();
        int i14 = -this.f121n;
        for (int i15 = 0; i15 < m().getChildCount(); i15++) {
            View childAt = m().getChildAt(i15);
            if (childAt != null) {
                int measuredHeight = childAt.getMeasuredHeight() + i14;
                childAt.layout(0, i14, childAt.getMeasuredWidth(), measuredHeight);
                i14 = measuredHeight;
            }
        }
        return true;
    }

    @Override // aa.f
    public void d(boolean z10) {
        this.f122o.startScroll(0, this.f121n, 0, (-l()) + ((int) (this.f120m * 30.0f)), 500);
        o();
    }

    @Override // aa.f
    public boolean e() {
        return C() || this.f115h;
    }

    @Override // aa.f
    public void f() {
        if (!k().q()) {
            k().s();
        }
        E();
    }

    @Override // aa.a, aa.f
    public void g(SlidingLayout slidingLayout) {
        super.g(slidingLayout);
        this.f122o = new Scroller(slidingLayout.getContext());
        this.f123p = VelocityTracker.obtain();
        this.f121n = 0;
        this.f120m = slidingLayout.getContext().getResources().getDisplayMetrics().density;
    }

    @Override // aa.f
    public void h(boolean z10) {
        this.f122o.startScroll(0, this.f121n, 0, l() - ((int) (this.f120m * 30.0f)), 500);
        o();
    }

    @Override // aa.f
    public void i() {
        if (this.f122o.computeScrollOffset()) {
            if (this.f118k == null) {
                this.f118k = Integer.valueOf(this.f122o.getStartY());
            }
            int currY = this.f122o.getCurrY();
            F(currY - this.f118k.intValue());
            this.f118k = Integer.valueOf(currY);
            this.f117j = true;
            o();
        } else if (this.f117j) {
            this.f117j = false;
            this.f118k = null;
            D();
            o();
        }
        if (this.f122o.isFinished()) {
            m().F(4);
        }
    }

    @Override // aa.a, aa.f
    public boolean j(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f116i = Float.valueOf(motionEvent.getY());
            if (C()) {
                return true;
            }
        } else {
            if (action == 1) {
                return this.f115h;
            }
            if (action == 2) {
                if (this.f115h || C()) {
                    return true;
                }
                if (this.f116i != null && Math.abs(motionEvent.getY() - this.f116i.floatValue()) >= this.f120m * 10.0f) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0011, code lost:
    
        if (r0 != 3) goto L100;
     */
    @Override // aa.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r14) {
        /*
            r13 = this;
            r13.x(r14)
            int r0 = r14.getAction()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto Lab
            r3 = 2
            if (r0 == r1) goto L6c
            if (r0 == r3) goto L14
            r14 = 3
            if (r0 == r14) goto L6c
            goto L4f
        L14:
            boolean r0 = r13.C()
            if (r0 == 0) goto L22
            r13.z()
            r13.f115h = r1
            r0 = 0
            r13.f116i = r0
        L22:
            java.lang.Float r0 = r13.f116i
            if (r0 != 0) goto L30
            float r0 = r14.getY()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            r13.f116i = r0
        L30:
            float r14 = r14.getY()
            java.lang.Float r0 = r13.f116i
            float r0 = r0.floatValue()
            float r0 = r0 - r14
            int r0 = (int) r0
            boolean r3 = r13.f115h
            if (r3 != 0) goto L52
            int r3 = java.lang.Math.abs(r0)
            float r3 = (float) r3
            float r4 = r13.f120m
            r5 = 1092616192(0x41200000, float:10.0)
            float r4 = r4 * r5
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L52
        L4f:
            r1 = 0
            goto Lc4
        L52:
            java.lang.Float r14 = java.lang.Float.valueOf(r14)
            r13.f116i = r14
            com.martian.libsliding.SlidingLayout r14 = r13.m()
            if (r0 <= 0) goto L5f
            goto L60
        L5f:
            r2 = 1
        L60:
            r14.F(r2)
            r13.F(r0)
            r13.f115h = r1
            r13.o()
            goto Lc4
        L6c:
            boolean r14 = r13.f115h
            if (r14 == 0) goto La6
            android.view.VelocityTracker r14 = r13.f123p
            r0 = 1000(0x3e8, float:1.401E-42)
            r14.computeCurrentVelocity(r0)
            android.view.VelocityTracker r14 = r13.f123p
            float r14 = r14.getYVelocity()
            float r14 = -r14
            int r8 = (int) r14
            int r14 = r13.f121n
            int r0 = r13.l()
            int r0 = r0 * 2
            int r11 = r14 - r0
            int r14 = r13.f121n
            int r0 = r13.l()
            int r0 = r0 * 2
            int r12 = r14 + r0
            android.widget.Scroller r4 = r13.f122o
            int r6 = r13.f121n
            r9 = 0
            r10 = 0
            r5 = 0
            r7 = 0
            r4.fling(r5, r6, r7, r8, r9, r10, r11, r12)
            r13.f115h = r2
            android.view.VelocityTracker r14 = r13.f123p
            r14.clear()
            goto La7
        La6:
            r1 = 0
        La7:
            r13.o()
            goto Lc4
        Lab:
            r13.f115h = r2
            boolean r0 = r13.C()
            if (r0 == 0) goto Lb9
            r13.z()
            r13.f115h = r1
            goto Lba
        Lb9:
            r1 = 0
        Lba:
            float r14 = r14.getY()
            java.lang.Float r14 = java.lang.Float.valueOf(r14)
            r13.f116i = r14
        Lc4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: aa.e.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void x(MotionEvent motionEvent) {
        this.f123p.addMovement(motionEvent);
    }

    public final void y(View view) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        } else {
            layoutParams.height = -2;
        }
        view.setMinimumHeight(l() / 2);
        m().addView(view);
    }

    public final void z() {
        this.f122o.forceFinished(true);
        i();
    }
}
