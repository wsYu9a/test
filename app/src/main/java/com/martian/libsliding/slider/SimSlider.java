package com.martian.libsliding.slider;

import aa.b;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Region;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.martian.libsliding.SlidingLayout;
import z9.d;

/* loaded from: classes3.dex */
public class SimSlider extends b {
    public VelocityTracker B;
    public int[] C;
    public int[] D;
    public GradientDrawable E;
    public GradientDrawable F;
    public GradientDrawable G;
    public GradientDrawable H;
    public GradientDrawable I;
    public GradientDrawable J;
    public GradientDrawable K;
    public GradientDrawable L;
    public Paint M;
    public Scroller N;
    public float O;

    /* renamed from: j */
    public Path f12942j;

    /* renamed from: k */
    public Path f12943k;

    /* renamed from: u */
    public float f12953u;

    /* renamed from: v */
    public float f12954v;

    /* renamed from: w */
    public float f12955w;

    /* renamed from: x */
    public float f12956x;

    /* renamed from: y */
    public ColorMatrixColorFilter f12957y;

    /* renamed from: z */
    public Matrix f12958z;

    /* renamed from: h */
    public int f12940h = 0;

    /* renamed from: i */
    public int f12941i = 0;

    /* renamed from: l */
    public PointF f12944l = new PointF();

    /* renamed from: m */
    public PointF f12945m = new PointF();

    /* renamed from: n */
    public PointF f12946n = new PointF();

    /* renamed from: o */
    public PointF f12947o = new PointF();

    /* renamed from: p */
    public PointF f12948p = new PointF();

    /* renamed from: q */
    public PointF f12949q = new PointF();

    /* renamed from: r */
    public PointF f12950r = new PointF();

    /* renamed from: s */
    public PointF f12951s = new PointF();

    /* renamed from: t */
    public PointF f12952t = new PointF();
    public float[] A = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    public int P = 4;
    public int Q = 4;
    public MoveMode R = MoveMode.MOVE_NONE;
    public final PointF S = new PointF();

    public enum MoveMode {
        MOVE_NONE,
        MOVE_RIGHT_TOP,
        MOVE_RIGHT_BOTTOM,
        MOVE_CENTER
    }

    private void L(MotionEvent motionEvent) {
        if (this.B == null) {
            this.B = VelocityTracker.obtain();
        }
        this.B.addMovement(motionEvent);
    }

    private void M() {
        VelocityTracker velocityTracker = this.B;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.B = null;
        }
    }

    private void N(d dVar) {
        m().removeAllViews();
        if (k().p()) {
            m().addView(dVar.l());
        }
        if (k().q()) {
            m().addView(dVar.m());
        }
        m().addView(dVar.k());
    }

    private void O() {
        PointF pointF = this.S;
        pointF.x = 0.0f;
        pointF.y = 0.0f;
        M();
    }

    public boolean A() {
        return Math.abs(this.f12944l.x) > ((float) n()) / 5.0f || this.B.getXVelocity() > this.O * 500.0f;
    }

    public final void B() {
        int[] iArr = {5592405, -1336584875};
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.RIGHT_LEFT;
        GradientDrawable gradientDrawable = new GradientDrawable(orientation, iArr);
        this.H = gradientDrawable;
        gradientDrawable.setGradientType(0);
        GradientDrawable.Orientation orientation2 = GradientDrawable.Orientation.LEFT_RIGHT;
        GradientDrawable gradientDrawable2 = new GradientDrawable(orientation2, iArr);
        this.G = gradientDrawable2;
        gradientDrawable2.setGradientType(0);
        this.C = new int[]{-1336584875, 5592405};
        GradientDrawable gradientDrawable3 = new GradientDrawable(orientation, this.C);
        this.F = gradientDrawable3;
        gradientDrawable3.setGradientType(0);
        GradientDrawable gradientDrawable4 = new GradientDrawable(orientation2, this.C);
        this.E = gradientDrawable4;
        gradientDrawable4.setGradientType(0);
        this.D = new int[]{-2141891243, 5592405};
        GradientDrawable gradientDrawable5 = new GradientDrawable(orientation2, this.D);
        this.K = gradientDrawable5;
        gradientDrawable5.setGradientType(0);
        GradientDrawable gradientDrawable6 = new GradientDrawable(orientation, this.D);
        this.L = gradientDrawable6;
        gradientDrawable6.setGradientType(0);
        GradientDrawable gradientDrawable7 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.D);
        this.J = gradientDrawable7;
        gradientDrawable7.setGradientType(0);
        GradientDrawable gradientDrawable8 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, this.D);
        this.I = gradientDrawable8;
        gradientDrawable8.setGradientType(0);
    }

    public final void C(Canvas canvas, Bitmap bitmap) {
        int i10;
        int i11;
        GradientDrawable gradientDrawable;
        float f10 = this.f12945m.x;
        float abs = Math.abs((((int) (f10 + r1)) / 2) - this.f12946n.x);
        float f11 = this.f12949q.y;
        float min = Math.min(abs, Math.abs((((int) (f11 + r2)) / 2) - this.f12950r.y));
        this.f12943k.reset();
        Path path = this.f12943k;
        PointF pointF = this.f12951s;
        path.moveTo(pointF.x, pointF.y);
        Path path2 = this.f12943k;
        PointF pointF2 = this.f12947o;
        path2.lineTo(pointF2.x, pointF2.y);
        Path path3 = this.f12943k;
        PointF pointF3 = this.f12948p;
        path3.lineTo(pointF3.x, pointF3.y);
        Path path4 = this.f12943k;
        PointF pointF4 = this.f12944l;
        path4.lineTo(pointF4.x, pointF4.y);
        Path path5 = this.f12943k;
        PointF pointF5 = this.f12952t;
        path5.lineTo(pointF5.x, pointF5.y);
        this.f12943k.close();
        if (this.R == MoveMode.MOVE_RIGHT_TOP) {
            float f12 = this.f12945m.x;
            i10 = (int) (f12 - 1.0f);
            i11 = (int) (f12 + min + 1.0f);
            gradientDrawable = this.G;
        } else {
            float f13 = this.f12945m.x;
            i10 = (int) ((f13 - min) - 1.0f);
            i11 = (int) (f13 + 1.0f);
            gradientDrawable = this.H;
        }
        canvas.save();
        canvas.clipPath(this.f12942j);
        canvas.clipPath(this.f12943k, Region.Op.INTERSECT);
        this.M.setColorFilter(this.f12957y);
        float hypot = (float) Math.hypot(this.f12940h - this.f12946n.x, this.f12950r.y - this.f12941i);
        float f14 = (this.f12940h - this.f12946n.x) / hypot;
        float f15 = (this.f12950r.y - this.f12941i) / hypot;
        float[] fArr = this.A;
        fArr[0] = 1.0f - ((f15 * 2.0f) * f15);
        float f16 = 2.0f * f14;
        float f17 = f15 * f16;
        fArr[1] = f17;
        fArr[3] = f17;
        fArr[4] = 1.0f - (f16 * f14);
        this.f12958z.reset();
        this.f12958z.setValues(this.A);
        Matrix matrix = this.f12958z;
        PointF pointF6 = this.f12946n;
        matrix.preTranslate(-pointF6.x, -pointF6.y);
        Matrix matrix2 = this.f12958z;
        PointF pointF7 = this.f12946n;
        matrix2.postTranslate(pointF7.x, pointF7.y);
        canvas.drawBitmap(bitmap, this.f12958z, this.M);
        this.M.setColorFilter(null);
        float f18 = this.f12955w;
        PointF pointF8 = this.f12945m;
        canvas.rotate(f18, pointF8.x, pointF8.y);
        float f19 = this.f12945m.y;
        gradientDrawable.setBounds(i10, (int) f19, i11, (int) (f19 + H()));
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    public final void D(Canvas canvas, View view, Bitmap bitmap) {
        this.f12942j.reset();
        Path path = this.f12942j;
        PointF pointF = this.f12945m;
        path.moveTo(pointF.x, pointF.y);
        Path path2 = this.f12942j;
        PointF pointF2 = this.f12946n;
        float f10 = pointF2.x;
        float f11 = pointF2.y;
        PointF pointF3 = this.f12948p;
        path2.quadTo(f10, f11, pointF3.x, pointF3.y);
        Path path3 = this.f12942j;
        PointF pointF4 = this.f12944l;
        path3.lineTo(pointF4.x, pointF4.y);
        Path path4 = this.f12942j;
        PointF pointF5 = this.f12952t;
        path4.lineTo(pointF5.x, pointF5.y);
        Path path5 = this.f12942j;
        PointF pointF6 = this.f12950r;
        float f12 = pointF6.x;
        float f13 = pointF6.y;
        PointF pointF7 = this.f12949q;
        path5.quadTo(f12, f13, pointF7.x, pointF7.y);
        this.f12942j.lineTo(this.f12940h, this.f12941i);
        this.f12942j.close();
        canvas.save();
        canvas.clipPath(this.f12942j, Region.Op.DIFFERENCE);
        if (v()) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        } else {
            view.draw(canvas);
        }
        canvas.restore();
    }

    public void E(Canvas canvas) {
        double atan2;
        int i10;
        int i11;
        GradientDrawable gradientDrawable;
        int i12;
        int i13;
        GradientDrawable gradientDrawable2;
        MoveMode moveMode = this.R;
        MoveMode moveMode2 = MoveMode.MOVE_RIGHT_TOP;
        if (moveMode == moveMode2) {
            float f10 = this.f12946n.y;
            PointF pointF = this.f12944l;
            atan2 = Math.atan2(f10 - pointF.y, pointF.x - r0.x);
        } else {
            float f11 = this.f12944l.y;
            PointF pointF2 = this.f12946n;
            atan2 = Math.atan2(f11 - pointF2.y, r0.x - pointF2.x);
        }
        double d10 = 0.7853981633974483d - atan2;
        double cos = Math.cos(d10) * 35.35d;
        double sin = Math.sin(d10) * 35.35d;
        PointF pointF3 = this.f12944l;
        float f12 = (float) (pointF3.x + cos);
        float f13 = (float) (this.R == moveMode2 ? pointF3.y + sin : pointF3.y - sin);
        this.f12943k.reset();
        this.f12943k.moveTo(f12, f13);
        Path path = this.f12943k;
        PointF pointF4 = this.f12944l;
        path.lineTo(pointF4.x, pointF4.y);
        Path path2 = this.f12943k;
        PointF pointF5 = this.f12946n;
        path2.lineTo(pointF5.x, pointF5.y);
        Path path3 = this.f12943k;
        PointF pointF6 = this.f12945m;
        path3.lineTo(pointF6.x, pointF6.y);
        this.f12943k.close();
        canvas.save();
        Path path4 = this.f12942j;
        Region.Op op = Region.Op.DIFFERENCE;
        canvas.clipPath(path4, op);
        Path path5 = this.f12943k;
        Region.Op op2 = Region.Op.INTERSECT;
        canvas.clipPath(path5, op2);
        if (this.R == moveMode2) {
            float f14 = this.f12946n.x;
            i10 = (int) f14;
            i11 = ((int) f14) + 25;
            gradientDrawable = this.K;
        } else {
            float f15 = this.f12946n.x;
            i10 = (int) (f15 - 25.0f);
            i11 = ((int) f15) + 1;
            gradientDrawable = this.L;
        }
        float f16 = this.f12944l.x;
        PointF pointF7 = this.f12946n;
        float degrees = (float) Math.toDegrees(Math.atan2(f16 - pointF7.x, pointF7.y - r9.y));
        PointF pointF8 = this.f12946n;
        canvas.rotate(degrees, pointF8.x, pointF8.y);
        gradientDrawable.setBounds(i10, (int) (this.f12946n.y - H()), i11, (int) this.f12946n.y);
        gradientDrawable.draw(canvas);
        canvas.restore();
        this.f12943k.reset();
        this.f12943k.moveTo(f12, f13);
        Path path6 = this.f12943k;
        PointF pointF9 = this.f12944l;
        path6.lineTo(pointF9.x, pointF9.y);
        Path path7 = this.f12943k;
        PointF pointF10 = this.f12950r;
        path7.lineTo(pointF10.x, pointF10.y);
        Path path8 = this.f12943k;
        PointF pointF11 = this.f12949q;
        path8.lineTo(pointF11.x, pointF11.y);
        this.f12943k.close();
        canvas.save();
        canvas.clipPath(this.f12942j, op);
        canvas.clipPath(this.f12943k, op2);
        if (this.R == moveMode2) {
            float f17 = this.f12950r.y;
            i12 = (int) f17;
            i13 = (int) (f17 + 25.0f);
            gradientDrawable2 = this.J;
        } else {
            float f18 = this.f12950r.y;
            i12 = (int) (f18 - 25.0f);
            i13 = (int) (f18 + 1.0f);
            gradientDrawable2 = this.I;
        }
        float f19 = this.f12950r.y;
        PointF pointF12 = this.f12944l;
        float degrees2 = (float) Math.toDegrees(Math.atan2(f19 - pointF12.y, r3.x - pointF12.x));
        PointF pointF13 = this.f12950r;
        canvas.rotate(degrees2, pointF13.x, pointF13.y);
        float f20 = this.f12950r.y;
        if (f20 < 0.0f) {
            f20 -= l();
        }
        int hypot = (int) Math.hypot(this.f12950r.x, f20);
        if (hypot > H()) {
            float f21 = this.f12950r.x;
            gradientDrawable2.setBounds(((int) (f21 - 25.0f)) - hypot, i12, ((int) (f21 + H())) - hypot, i13);
        } else {
            gradientDrawable2.setBounds((int) (this.f12950r.x - H()), i12, (int) this.f12950r.x, i13);
        }
        gradientDrawable2.draw(canvas);
        canvas.restore();
    }

    public final void F(Canvas canvas, View view, Bitmap bitmap) {
        int i10;
        int i11;
        GradientDrawable gradientDrawable;
        if (view == null) {
            return;
        }
        this.f12943k.reset();
        Path path = this.f12943k;
        PointF pointF = this.f12945m;
        path.moveTo(pointF.x, pointF.y);
        Path path2 = this.f12943k;
        PointF pointF2 = this.f12947o;
        path2.lineTo(pointF2.x, pointF2.y);
        Path path3 = this.f12943k;
        PointF pointF3 = this.f12951s;
        path3.lineTo(pointF3.x, pointF3.y);
        Path path4 = this.f12943k;
        PointF pointF4 = this.f12949q;
        path4.lineTo(pointF4.x, pointF4.y);
        this.f12943k.lineTo(this.f12940h, this.f12941i);
        this.f12943k.close();
        this.f12955w = (float) Math.toDegrees(Math.atan2(this.f12946n.x - this.f12940h, this.f12950r.y - this.f12941i));
        if (this.R == MoveMode.MOVE_RIGHT_TOP) {
            float f10 = this.f12945m.x;
            i10 = (int) f10;
            i11 = (int) (f10 + (this.f12956x / 4.0f));
            gradientDrawable = this.E;
        } else {
            float f11 = this.f12945m.x;
            i10 = (int) (f11 - (this.f12956x / 4.0f));
            i11 = (int) f11;
            gradientDrawable = this.F;
        }
        canvas.save();
        canvas.clipPath(this.f12942j);
        canvas.clipPath(this.f12943k, Region.Op.INTERSECT);
        if (v()) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        } else {
            view.draw(canvas);
        }
        float f12 = this.f12955w;
        PointF pointF5 = this.f12945m;
        canvas.rotate(f12, pointF5.x, pointF5.y);
        gradientDrawable.setBounds(i10, (int) this.f12945m.y, i11, (int) (H() + this.f12945m.y));
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    public PointF G(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        PointF pointF5 = new PointF();
        float f10 = pointF2.y;
        float f11 = pointF.y;
        float f12 = pointF2.x;
        float f13 = pointF.x;
        float f14 = (f10 - f11) / (f12 - f13);
        float f15 = ((f10 * f13) - (f11 * f12)) / (f13 - f12);
        float f16 = pointF4.y;
        float f17 = pointF3.y;
        float f18 = pointF4.x;
        float f19 = pointF3.x;
        float f20 = ((((f16 * f19) - (f17 * f18)) / (f19 - f18)) - f15) / (f14 - ((f16 - f17) / (f18 - f19)));
        pointF5.x = f20;
        pointF5.y = (f14 * f20) + f15;
        return pointF5;
    }

    public float H() {
        return (float) Math.hypot(n(), l());
    }

    public boolean I() {
        return (this.Q == 4 && this.N.isFinished()) ? false : true;
    }

    public void J() {
        View o10;
        if (k().p()) {
            View i10 = k().i();
            k().s();
            m().G(k().d());
            if (k().p() && i10 != null && (o10 = k().o(i10, k().f())) != i10) {
                k().y(o10);
            }
            N(k());
        }
    }

    public void K() {
        if (k().q()) {
            k().t();
            m().G(k().d());
            N(k());
        }
    }

    public final void P() {
        this.f12940h = n();
        this.f12941i = l();
        this.f12944l.y = r0 - 1;
        this.R = MoveMode.MOVE_CENTER;
    }

    public final void Q(int i10) {
        int i11 = this.P;
        if (i11 == 1) {
            float f10 = this.f12940h;
            float f11 = this.f12944l.x;
            this.N.startScroll((int) f11, l() - 1, (-((int) (f10 + f11))) + 20, 0, i10);
            return;
        }
        if (i11 == 0) {
            float f12 = this.f12940h;
            PointF pointF = this.f12944l;
            float f13 = pointF.x;
            int i12 = (int) (f12 - f13);
            if (this.R == MoveMode.MOVE_CENTER) {
                this.N.startScroll((int) f13, l() - 1, i12, 0, i10);
                return;
            }
            float f14 = this.f12941i;
            float f15 = pointF.y;
            this.N.startScroll((int) f13, (int) f15, i12, (int) (f14 - f15), i10);
        }
    }

    public final void R(int i10) {
        int n10 = this.f12940h > 0 ? -((int) (n() + this.f12944l.x)) : (int) ((n() - this.f12944l.x) + n());
        if (this.R == MoveMode.MOVE_CENTER) {
            this.N.startScroll((int) this.f12944l.x, l() - 1, n10 + 20, 0, i10);
            return;
        }
        int l10 = this.f12941i > 0 ? (int) ((l() - this.f12944l.y) - 10.0f) : (int) (10.0f - this.f12944l.y);
        Scroller scroller = this.N;
        PointF pointF = this.f12944l;
        scroller.startScroll((int) pointF.x, (int) pointF.y, n10, l10, i10);
    }

    public final void S(int i10) {
        PointF pointF = this.f12944l;
        int i11 = (int) pointF.x;
        pointF.y = l() - 1;
        this.N.startScroll(i11, l() - 1, (n() - i11) + 200, 0, i10);
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
        Bitmap s10;
        Bitmap t10;
        View e10;
        View i10;
        q(this.P);
        if (this.P == 4) {
            k().e().draw(canvas);
            return true;
        }
        y();
        if (this.P == 0) {
            s10 = t();
            t10 = s();
            e10 = k().g();
            i10 = k().e();
        } else {
            s10 = s();
            t10 = t();
            e10 = k().e();
            i10 = k().i();
        }
        if (s10 != null && t10 != null) {
            D(canvas, i10, t10);
            F(canvas, e10, s10);
            E(canvas);
            C(canvas, t10);
        }
        return true;
    }

    @Override // aa.f
    public void d(boolean z10) {
        if (k().q()) {
            boolean I = I();
            if (I && !z10) {
                this.N.abortAnimation();
                i();
            } else if (I) {
                return;
            }
            P();
            PointF pointF = this.f12944l;
            pointF.x = 1.0f;
            pointF.y = 1.0f;
            S(500);
            this.Q = 1;
            this.P = 1;
            m().F(1);
            o();
        }
    }

    @Override // aa.f
    public boolean e() {
        return (this.P == 4 && this.N.isFinished()) ? false : true;
    }

    @Override // aa.f
    public void f() {
        if (k().p()) {
            m().addView(k().l());
        }
        if (k().q()) {
            m().addView(k().m());
        }
        m().addView(k().k());
        u();
    }

    @Override // aa.a, aa.f
    public void g(SlidingLayout slidingLayout) {
        super.g(slidingLayout);
        this.f12942j = new Path();
        this.f12943k = new Path();
        B();
        Paint paint = new Paint();
        this.M = paint;
        paint.setStyle(Paint.Style.FILL);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2f, 0.0f});
        this.f12957y = new ColorMatrixColorFilter(colorMatrix);
        this.f12958z = new Matrix();
        this.N = new Scroller(slidingLayout.getContext(), new LinearInterpolator());
        PointF pointF = this.f12944l;
        pointF.x = 0.01f;
        pointF.y = 0.01f;
        PointF pointF2 = this.S;
        pointF2.x = 0.0f;
        pointF2.y = 0.0f;
        this.O = slidingLayout.getContext().getResources().getDisplayMetrics().density;
    }

    @Override // aa.f
    public void h(boolean z10) {
        if (k().p()) {
            boolean I = I();
            if (I && !z10) {
                this.N.abortAnimation();
                i();
            } else if (I) {
                return;
            }
            if (!z10) {
                this.S.x = n() - 10;
                this.S.y = l() / 2.0f;
            }
            PointF pointF = this.S;
            x(pointF.x, pointF.y);
            PointF pointF2 = this.f12944l;
            PointF pointF3 = this.S;
            pointF2.x = pointF3.x;
            pointF2.y = pointF3.y;
            R(500);
            this.Q = 0;
            this.P = 0;
            m().F(0);
            o();
        }
    }

    @Override // aa.f
    public void i() {
        int i10;
        if (this.N.computeScrollOffset()) {
            float currX = this.N.getCurrX();
            float currY = this.N.getCurrY();
            PointF pointF = this.f12944l;
            pointF.x = currX;
            pointF.y = currY;
            o();
            return;
        }
        if (!this.N.isFinished() || ((i10 = this.Q) != 1 && i10 != 0)) {
            if (this.N.isFinished() && this.Q == 2) {
                this.P = 4;
                this.R = MoveMode.MOVE_NONE;
                this.Q = 4;
                PointF pointF2 = this.f12944l;
                pointF2.x = 0.0f;
                pointF2.y = 0.0f;
                o();
                return;
            }
            return;
        }
        this.P = 4;
        this.R = MoveMode.MOVE_NONE;
        if (i10 == 0) {
            J();
        } else {
            K();
        }
        this.Q = 4;
        m().F(4);
        PointF pointF3 = this.f12944l;
        pointF3.x = 0.0f;
        pointF3.y = 0.0f;
        u();
    }

    @Override // aa.a, aa.f
    public boolean j(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.S.x = motionEvent.getX();
            this.S.y = motionEvent.getY();
            if (I()) {
                return true;
            }
        } else if (action != 1) {
            if (action == 2) {
                if (this.P != 4 || I()) {
                    return true;
                }
                if (this.S.x != 0.0f) {
                    float x10 = motionEvent.getX() - this.S.x;
                    if ((x10 <= 0.0f || k().q()) && ((x10 >= 0.0f || k().p()) && Math.abs(x10) >= this.O * 10.0f)) {
                        return true;
                    }
                }
            }
        } else if (this.P != 4) {
            return true;
        }
        return false;
    }

    @Override // aa.a
    public int l() {
        int measuredHeight = m().getMeasuredHeight();
        return measuredHeight == 0 ? m().getContext().getResources().getDisplayMetrics().heightPixels : measuredHeight;
    }

    @Override // aa.a
    public int n() {
        int measuredWidth = m().getMeasuredWidth();
        return measuredWidth == 0 ? m().getContext().getResources().getDisplayMetrics().widthPixels : measuredWidth;
    }

    @Override // aa.a
    public void o() {
        m().postInvalidate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0011, code lost:
    
        if (r0 != 3) goto L182;
     */
    @Override // aa.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.libsliding.slider.SimSlider.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void x(float f10, float f11) {
        this.f12940h = n();
        if (f11 <= l() / 3.0f) {
            this.f12941i = 0;
            this.R = MoveMode.MOVE_RIGHT_TOP;
        } else if (f11 < (l() * 2) / 3.0f) {
            P();
        } else {
            this.f12941i = l();
            this.R = MoveMode.MOVE_RIGHT_BOTTOM;
        }
    }

    public final void y() {
        PointF pointF = this.f12944l;
        float f10 = pointF.x;
        int i10 = this.f12940h;
        float f11 = (f10 + i10) / 2.0f;
        this.f12953u = f11;
        float f12 = pointF.y;
        int i11 = this.f12941i;
        float f13 = (f12 + i11) / 2.0f;
        this.f12954v = f13;
        PointF pointF2 = this.f12946n;
        pointF2.x = f11 - (((i11 - f13) * (i11 - f13)) / (i10 - f11));
        pointF2.y = i11;
        PointF pointF3 = this.f12950r;
        pointF3.x = i10;
        pointF3.y = f13 - (((i10 - f11) * (i10 - f11)) / (i11 - f13));
        PointF pointF4 = this.f12945m;
        float f14 = pointF2.x;
        pointF4.x = f14 - ((i10 - f14) / 2.0f);
        pointF4.y = i11;
        float f15 = pointF.x;
        if (f15 > 0.0f && f15 < n()) {
            float f16 = this.f12945m.x;
            if (f16 < 0.0f || f16 > n()) {
                PointF pointF5 = this.f12945m;
                if (pointF5.x < 0.0f) {
                    pointF5.x = n() - this.f12945m.x;
                }
                float abs = Math.abs(this.f12940h - this.f12944l.x);
                this.f12944l.x = Math.abs(this.f12940h - ((n() * abs) / this.f12945m.x));
                this.f12944l.y = Math.abs(this.f12941i - ((Math.abs(this.f12940h - this.f12944l.x) * Math.abs(this.f12941i - this.f12944l.y)) / abs));
                PointF pointF6 = this.f12944l;
                float f17 = pointF6.x;
                int i12 = this.f12940h;
                float f18 = (f17 + i12) / 2.0f;
                this.f12953u = f18;
                float f19 = pointF6.y;
                int i13 = this.f12941i;
                float f20 = (f19 + i13) / 2.0f;
                this.f12954v = f20;
                PointF pointF7 = this.f12946n;
                pointF7.x = f18 - (((i13 - f20) * (i13 - f20)) / (i12 - f18));
                pointF7.y = i13;
                PointF pointF8 = this.f12950r;
                pointF8.x = i12;
                pointF8.y = f20 - (((i12 - f18) * (i12 - f18)) / (i13 - f20));
                PointF pointF9 = this.f12945m;
                float f21 = pointF7.x;
                pointF9.x = f21 - ((i12 - f21) / 2.0f);
            }
        }
        PointF pointF10 = this.f12949q;
        pointF10.x = this.f12940h;
        float f22 = this.f12950r.y;
        pointF10.y = f22 - ((this.f12941i - f22) / 2.0f);
        PointF pointF11 = this.f12944l;
        this.f12956x = (float) Math.hypot(pointF11.x - r1, pointF11.y - r4);
        this.f12948p = G(this.f12944l, this.f12946n, this.f12945m, this.f12949q);
        PointF G = G(this.f12944l, this.f12950r, this.f12945m, this.f12949q);
        this.f12952t = G;
        PointF pointF12 = this.f12947o;
        PointF pointF13 = this.f12945m;
        float f23 = pointF13.x;
        PointF pointF14 = this.f12946n;
        float f24 = f23 + (pointF14.x * 2.0f);
        PointF pointF15 = this.f12948p;
        pointF12.x = (f24 + pointF15.x) / 4.0f;
        pointF12.y = (((pointF14.y * 2.0f) + pointF13.y) + pointF15.y) / 4.0f;
        PointF pointF16 = this.f12951s;
        PointF pointF17 = this.f12949q;
        float f25 = pointF17.x;
        PointF pointF18 = this.f12950r;
        pointF16.x = ((f25 + (pointF18.x * 2.0f)) + G.x) / 4.0f;
        pointF16.y = (((pointF18.y * 2.0f) + pointF17.y) + G.y) / 4.0f;
    }

    public boolean z() {
        return Math.abs(this.f12944l.x - ((float) this.f12940h)) > ((float) n()) / 5.0f || Math.abs(this.f12944l.y - ((float) this.f12941i)) > ((float) l()) / 5.0f || this.B.getXVelocity() < (-this.O) * 500.0f;
    }
}
