package aa;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.Scroller;
import com.martian.libsliding.SlidingLayout;

/* loaded from: classes3.dex */
public class c extends b {

    /* renamed from: i */
    public Scroller f98i;

    /* renamed from: j */
    public VelocityTracker f99j;

    /* renamed from: r */
    public int f107r;

    /* renamed from: s */
    public int f108s;

    /* renamed from: t */
    public int f109t;

    /* renamed from: u */
    public float f110u;

    /* renamed from: v */
    public GradientDrawable f111v;

    /* renamed from: h */
    public int f97h = 0;

    /* renamed from: k */
    public int f100k = 0;

    /* renamed from: l */
    public int f101l = 0;

    /* renamed from: m */
    public int f102m = 4;

    /* renamed from: n */
    public int f103n = 4;

    /* renamed from: o */
    public int f104o = 0;

    /* renamed from: p */
    public Float f105p = null;

    /* renamed from: q */
    public long f106q = 0;

    /* renamed from: w */
    public boolean f112w = true;

    /* renamed from: x */
    public boolean f113x = false;

    public View A() {
        return k().e();
    }

    public View B() {
        return k().i();
    }

    public boolean C() {
        return (this.f102m == 4 && this.f98i.isFinished()) ? false : true;
    }

    public final boolean D() {
        return this.f112w;
    }

    public void E() {
        if (k().p()) {
            k().s();
            m().G(k().d());
            I();
        }
    }

    public void F() {
        if (k().q()) {
            k().t();
            m().G(k().d());
            I();
        }
    }

    public void G(MotionEvent motionEvent) {
        if (this.f99j == null) {
            this.f99j = VelocityTracker.obtain();
        }
        this.f99j.addMovement(motionEvent);
    }

    public void H() {
        VelocityTracker velocityTracker = this.f99j;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f99j = null;
        }
    }

    public final void I() {
        m().removeAllViews();
        if (k().p()) {
            m().addView(k().l());
        }
        if (k().q()) {
            m().addView(k().m());
        }
        m().addView(k().k());
        u();
    }

    public void J() {
        this.f103n = 4;
        this.f104o = 0;
        this.f105p = null;
        this.f106q = 0L;
        H();
    }

    public void K(int i10) {
        this.f97h = i10;
    }

    @Override // aa.f
    public void a() {
        if (k().p()) {
            boolean z10 = k().g() != null;
            View l10 = k().l();
            if (!z10) {
                m().addView(l10, 0);
            }
        }
        if (k().q()) {
            boolean z11 = k().i() != null;
            View m10 = k().m();
            if (!z11) {
                m().addView(m10, 1);
            }
        }
        k().k();
        u();
    }

    @Override // aa.a, aa.f
    public boolean b(Canvas canvas) {
        int i10;
        int i11 = -n();
        int i12 = this.f97h;
        if (i12 < 0) {
            i10 = 0;
        } else if (i12 > 0) {
            i11 = (-n()) + this.f97h;
            i12 = 0;
            i10 = 1;
        } else {
            i12 = 0;
            i10 = 4;
        }
        boolean v10 = v();
        if (v10) {
            q(i10);
        }
        if (i10 == 4) {
            k().e().draw(canvas);
            return true;
        }
        View z10 = z();
        if (z10 != null && this.f97h < 0) {
            canvas.save();
            canvas.clipRect(n() + this.f97h, 0, n(), z10.getHeight());
            if (this.f97h == 0 || !v10 || t() == null || t().isRecycled()) {
                z10.draw(canvas);
            } else {
                canvas.drawBitmap(t(), 0.0f, 0.0f, (Paint) null);
            }
            canvas.restore();
        }
        View A = A();
        if (A != null) {
            canvas.translate(i12, 0.0f);
            if (this.f97h == 0 || !v10 || s() == null || s().isRecycled()) {
                A.draw(canvas);
            } else {
                canvas.drawBitmap(s(), 0.0f, 0.0f, (Paint) null);
            }
            canvas.translate(-i12, 0.0f);
            if (i12 < 0 && i12 > (-n()) + 20) {
                y(canvas, n() + i12);
            }
        }
        View B = B();
        if (B != null && this.f97h > 0) {
            canvas.translate(i11, 0.0f);
            if (this.f97h == 0 || !v10 || t() == null || t().isRecycled()) {
                B.draw(canvas);
            } else {
                canvas.drawBitmap(t(), 0.0f, 0.0f, (Paint) null);
            }
            canvas.translate(-i11, 0.0f);
            if (i11 > (-n()) && i11 < 20) {
                y(canvas, i11 + n());
            }
        }
        return true;
    }

    @Override // aa.f
    public void d(boolean z10) {
        if (k().q()) {
            boolean C = C();
            if (C && !z10) {
                this.f98i.abortAnimation();
                i();
            } else if (C) {
                return;
            }
            this.f98i.startScroll(0, 0, n(), 0, 200);
            this.f102m = 1;
            m().F(1);
            o();
        }
    }

    @Override // aa.f
    public boolean e() {
        return this.f104o == 1 || C();
    }

    @Override // aa.f
    public void f() {
        I();
        u();
    }

    @Override // aa.a, aa.f
    public void g(SlidingLayout slidingLayout) {
        super.g(slidingLayout);
        this.f98i = new Scroller(slidingLayout.getContext());
        DisplayMetrics displayMetrics = slidingLayout.getContext().getResources().getDisplayMetrics();
        this.f110u = displayMetrics.density;
        int i10 = displayMetrics.widthPixels;
        this.f101l = i10;
        this.f100k = i10 / 2;
        this.f107r = i10 * 5;
        this.f108s = i10 * 6;
        this.f109t = i10 * 2;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, new int[]{0, 268435456});
        this.f111v = gradientDrawable;
        gradientDrawable.setGradientType(0);
    }

    @Override // aa.f
    public void h(boolean z10) {
        if (k().p()) {
            boolean C = C();
            if (C && !z10) {
                this.f98i.abortAnimation();
                i();
            } else if (C) {
                return;
            }
            this.f98i.startScroll(0, 0, -n(), 0, 200);
            this.f102m = 0;
            m().F(0);
            o();
        }
    }

    @Override // aa.f
    public void i() {
        int i10;
        if (!this.f98i.computeScrollOffset()) {
            if (!this.f98i.isFinished() || (i10 = this.f102m) == 4) {
                return;
            }
            if (i10 == 0) {
                E();
            } else {
                F();
            }
            this.f102m = 4;
            m().F(4);
            this.f97h = 0;
            this.f113x = false;
            u();
            return;
        }
        int currX = this.f98i.getCurrX();
        K(currX);
        if (D()) {
            int finalX = this.f98i.getFinalX() - currX;
            if (Math.abs(finalX) < 200 && !this.f113x) {
                int duration = this.f98i.getDuration() - this.f98i.timePassed();
                if (duration < 0) {
                    duration = 2;
                }
                this.f98i.startScroll(currX, 0, finalX, 0, duration / 2);
                this.f113x = true;
            }
        }
        o();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
    
        if (r0 != 3) goto L125;
     */
    @Override // aa.a, aa.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean j(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getAction()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L63
            if (r0 == r1) goto L59
            r3 = 2
            if (r0 == r3) goto L12
            r6 = 3
            if (r0 == r6) goto L59
            goto L7a
        L12:
            int r0 = r5.f104o
            if (r0 == r1) goto L7b
            boolean r0 = r5.C()
            if (r0 == 0) goto L1d
            goto L7b
        L1d:
            java.lang.Float r0 = r5.f105p
            if (r0 == 0) goto L7a
            float r6 = r6.getX()
            java.lang.Float r0 = r5.f105p
            float r0 = r0.floatValue()
            float r6 = r6 - r0
            r0 = 0
            int r3 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r3 <= 0) goto L3b
            z9.d r3 = r5.k()
            boolean r3 = r3.q()
            if (r3 == 0) goto L7a
        L3b:
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 >= 0) goto L4a
            z9.d r0 = r5.k()
            boolean r0 = r0.p()
            if (r0 != 0) goto L4a
            goto L7a
        L4a:
            float r6 = java.lang.Math.abs(r6)
            r0 = 1092616192(0x41200000, float:10.0)
            float r3 = r5.f110u
            float r3 = r3 * r0
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 < 0) goto L7a
            goto L7b
        L59:
            int r6 = r5.f104o
            if (r6 != r1) goto L5e
            goto L5f
        L5e:
            r1 = 0
        L5f:
            r6 = 0
            r5.f105p = r6
            goto L7b
        L63:
            float r6 = r6.getX()
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            r5.f105p = r6
            long r3 = java.lang.System.currentTimeMillis()
            r5.f106q = r3
            boolean r6 = r5.C()
            if (r6 == 0) goto L7a
            goto L7b
        L7a:
            r1 = 0
        L7b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: aa.c.j(android.view.MotionEvent):boolean");
    }

    @Override // aa.a
    public int n() {
        int measuredWidth = m().getMeasuredWidth();
        return measuredWidth == 0 ? this.f101l : measuredWidth;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
    
        if (r0 != 3) goto L277;
     */
    @Override // aa.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aa.c.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void x() {
        this.f112w = false;
    }

    public void y(Canvas canvas, int i10) {
        this.f111v.setBounds(i10, 0, ((int) (this.f110u * 10.0f)) + i10, m().getHeight());
        this.f111v.draw(canvas);
    }

    public View z() {
        return k().g();
    }
}
