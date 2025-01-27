package com.martian.libsliding.slider;

import android.annotation.TargetApi;
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
import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.martian.libsliding.SlidingLayout;

/* loaded from: classes.dex */
public class SimSlider extends b {
    private VelocityTracker B;
    int[] C;
    int[] D;
    GradientDrawable E;
    GradientDrawable F;
    GradientDrawable G;
    GradientDrawable H;
    GradientDrawable I;
    GradientDrawable J;
    GradientDrawable K;
    GradientDrawable L;
    Paint M;
    Scroller N;
    private float O;

    /* renamed from: j */
    private Path f10528j;
    private Path k;
    float u;
    float v;
    float w;
    float x;
    ColorMatrixColorFilter y;
    Matrix z;

    /* renamed from: h */
    private int f10526h = 0;

    /* renamed from: i */
    private int f10527i = 0;
    PointF l = new PointF();
    PointF m = new PointF();
    PointF n = new PointF();
    PointF o = new PointF();
    PointF p = new PointF();
    PointF q = new PointF();
    PointF r = new PointF();
    PointF s = new PointF();
    PointF t = new PointF();
    float[] A = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private int P = 4;
    private int Q = 4;
    private MoveMode R = MoveMode.MOVE_NONE;
    private final PointF S = new PointF();

    /* loaded from: classes3.dex */
    private enum MoveMode {
        MOVE_NONE,
        MOVE_RIGHT_TOP,
        MOVE_RIGHT_BOTTOM,
        MOVE_CENTER
    }

    private void B() {
        int[] iArr = {5592405, -1336584875};
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, iArr);
        this.H = gradientDrawable;
        gradientDrawable.setGradientType(0);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr);
        this.G = gradientDrawable2;
        gradientDrawable2.setGradientType(0);
        this.C = new int[]{-1336584875, 5592405};
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, this.C);
        this.F = gradientDrawable3;
        gradientDrawable3.setGradientType(0);
        GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, this.C);
        this.E = gradientDrawable4;
        gradientDrawable4.setGradientType(0);
        this.D = new int[]{-2141891243, 5592405};
        GradientDrawable gradientDrawable5 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, this.D);
        this.K = gradientDrawable5;
        gradientDrawable5.setGradientType(0);
        GradientDrawable gradientDrawable6 = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, this.D);
        this.L = gradientDrawable6;
        gradientDrawable6.setGradientType(0);
        GradientDrawable gradientDrawable7 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.D);
        this.J = gradientDrawable7;
        gradientDrawable7.setGradientType(0);
        GradientDrawable gradientDrawable8 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, this.D);
        this.I = gradientDrawable8;
        gradientDrawable8.setGradientType(0);
    }

    private void C(Canvas canvas, Bitmap bitmap) {
        int i2;
        int i3;
        GradientDrawable gradientDrawable;
        float f2 = this.m.x;
        float abs = Math.abs((((int) (f2 + r1)) / 2) - this.n.x);
        float f3 = this.q.y;
        float min = Math.min(abs, Math.abs((((int) (f3 + r2)) / 2) - this.r.y));
        this.k.reset();
        Path path = this.k;
        PointF pointF = this.s;
        path.moveTo(pointF.x, pointF.y);
        Path path2 = this.k;
        PointF pointF2 = this.o;
        path2.lineTo(pointF2.x, pointF2.y);
        Path path3 = this.k;
        PointF pointF3 = this.p;
        path3.lineTo(pointF3.x, pointF3.y);
        Path path4 = this.k;
        PointF pointF4 = this.l;
        path4.lineTo(pointF4.x, pointF4.y);
        Path path5 = this.k;
        PointF pointF5 = this.t;
        path5.lineTo(pointF5.x, pointF5.y);
        this.k.close();
        if (this.R == MoveMode.MOVE_RIGHT_TOP) {
            float f4 = this.m.x;
            i2 = (int) (f4 - 1.0f);
            i3 = (int) (f4 + min + 1.0f);
            gradientDrawable = this.G;
        } else {
            float f5 = this.m.x;
            i2 = (int) ((f5 - min) - 1.0f);
            i3 = (int) (f5 + 1.0f);
            gradientDrawable = this.H;
        }
        canvas.save();
        canvas.clipPath(this.f10528j);
        canvas.clipPath(this.k, Region.Op.INTERSECT);
        this.M.setColorFilter(this.y);
        float hypot = (float) Math.hypot(this.f10526h - this.n.x, this.r.y - this.f10527i);
        float f6 = (this.f10526h - this.n.x) / hypot;
        float f7 = (this.r.y - this.f10527i) / hypot;
        float[] fArr = this.A;
        fArr[0] = 1.0f - ((f7 * 2.0f) * f7);
        float f8 = 2.0f * f6;
        fArr[1] = f7 * f8;
        fArr[3] = fArr[1];
        fArr[4] = 1.0f - (f8 * f6);
        this.z.reset();
        this.z.setValues(this.A);
        Matrix matrix = this.z;
        PointF pointF6 = this.n;
        matrix.preTranslate(-pointF6.x, -pointF6.y);
        Matrix matrix2 = this.z;
        PointF pointF7 = this.n;
        matrix2.postTranslate(pointF7.x, pointF7.y);
        canvas.drawBitmap(bitmap, this.z, this.M);
        this.M.setColorFilter(null);
        float f9 = this.w;
        PointF pointF8 = this.m;
        canvas.rotate(f9, pointF8.x, pointF8.y);
        float f10 = this.m.y;
        gradientDrawable.setBounds(i2, (int) f10, i3, (int) (f10 + H()));
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    private void D(Canvas canvas, View view, Bitmap bitmap) {
        this.f10528j.reset();
        Path path = this.f10528j;
        PointF pointF = this.m;
        path.moveTo(pointF.x, pointF.y);
        Path path2 = this.f10528j;
        PointF pointF2 = this.n;
        float f2 = pointF2.x;
        float f3 = pointF2.y;
        PointF pointF3 = this.p;
        path2.quadTo(f2, f3, pointF3.x, pointF3.y);
        Path path3 = this.f10528j;
        PointF pointF4 = this.l;
        path3.lineTo(pointF4.x, pointF4.y);
        Path path4 = this.f10528j;
        PointF pointF5 = this.t;
        path4.lineTo(pointF5.x, pointF5.y);
        Path path5 = this.f10528j;
        PointF pointF6 = this.r;
        float f4 = pointF6.x;
        float f5 = pointF6.y;
        PointF pointF7 = this.q;
        path5.quadTo(f4, f5, pointF7.x, pointF7.y);
        this.f10528j.lineTo(this.f10526h, this.f10527i);
        this.f10528j.close();
        canvas.save();
        canvas.clipPath(this.f10528j, Region.Op.XOR);
        if (u()) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        } else {
            view.draw(canvas);
        }
        canvas.restore();
    }

    private void F(Canvas canvas, View bottomView, Bitmap bottomBitmap) {
        int i2;
        int i3;
        GradientDrawable gradientDrawable;
        this.k.reset();
        Path path = this.k;
        PointF pointF = this.m;
        path.moveTo(pointF.x, pointF.y);
        Path path2 = this.k;
        PointF pointF2 = this.o;
        path2.lineTo(pointF2.x, pointF2.y);
        Path path3 = this.k;
        PointF pointF3 = this.s;
        path3.lineTo(pointF3.x, pointF3.y);
        Path path4 = this.k;
        PointF pointF4 = this.q;
        path4.lineTo(pointF4.x, pointF4.y);
        this.k.lineTo(this.f10526h, this.f10527i);
        this.k.close();
        this.w = (float) Math.toDegrees(Math.atan2(this.n.x - this.f10526h, this.r.y - this.f10527i));
        if (this.R == MoveMode.MOVE_RIGHT_TOP) {
            float f2 = this.m.x;
            i2 = (int) f2;
            i3 = (int) (f2 + (this.x / 4.0f));
            gradientDrawable = this.E;
        } else {
            float f3 = this.m.x;
            i2 = (int) (f3 - (this.x / 4.0f));
            i3 = (int) f3;
            gradientDrawable = this.F;
        }
        canvas.save();
        canvas.clipPath(this.f10528j);
        canvas.clipPath(this.k, Region.Op.INTERSECT);
        if (u()) {
            canvas.drawBitmap(bottomBitmap, 0.0f, 0.0f, (Paint) null);
        } else {
            bottomView.draw(canvas);
        }
        float f4 = this.w;
        PointF pointF5 = this.m;
        canvas.rotate(f4, pointF5.x, pointF5.y);
        gradientDrawable.setBounds(i2, (int) this.m.y, i3, (int) (H() + this.m.y));
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    private boolean I() {
        return (this.Q == 4 && this.N.isFinished()) ? false : true;
    }

    private void L(MotionEvent event) {
        if (this.B == null) {
            this.B = VelocityTracker.obtain();
        }
        this.B.addMovement(event);
    }

    private void M() {
        VelocityTracker velocityTracker = this.B;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.B = null;
        }
    }

    private void N(com.martian.libsliding.e adapter) {
        k().removeAllViews();
        if (i().o()) {
            k().addView(adapter.f());
        }
        if (i().p()) {
            k().addView(adapter.h());
        }
        k().addView(adapter.j());
    }

    private void O() {
        PointF pointF = this.S;
        pointF.x = 0.0f;
        pointF.y = 0.0f;
        M();
    }

    private void P() {
        this.f10526h = l();
        this.f10527i = j();
        this.l.y = r0 - 1;
        this.R = MoveMode.MOVE_CENTER;
    }

    private void Q(int delayMillis) {
        int i2 = this.P;
        if (i2 == 1) {
            float f2 = this.f10526h;
            float f3 = this.l.x;
            this.N.startScroll((int) f3, j() - 1, (-((int) (f2 + f3))) + 20, 0, delayMillis);
            return;
        }
        if (i2 == 0) {
            float f4 = this.f10526h;
            PointF pointF = this.l;
            float f5 = pointF.x;
            int i3 = (int) (f4 - f5);
            if (this.R == MoveMode.MOVE_CENTER) {
                this.N.startScroll((int) f5, j() - 1, i3, 0, delayMillis);
                return;
            }
            float f6 = this.f10527i;
            float f7 = pointF.y;
            this.N.startScroll((int) f5, (int) f7, i3, (int) (f6 - f7), delayMillis);
        }
    }

    private void R(int delayMillis) {
        int l = this.f10526h > 0 ? -((int) (l() + this.l.x)) : (int) ((l() - this.l.x) + l());
        if (this.R == MoveMode.MOVE_CENTER) {
            this.N.startScroll((int) this.l.x, j() - 1, l + 20, 0, delayMillis);
            return;
        }
        int j2 = this.f10527i > 0 ? (int) ((j() - this.l.y) - 10.0f) : (int) (10.0f - this.l.y);
        Scroller scroller = this.N;
        PointF pointF = this.l;
        scroller.startScroll((int) pointF.x, (int) pointF.y, l, j2, delayMillis);
    }

    private void S(int delayMillis) {
        PointF pointF = this.l;
        int i2 = (int) pointF.x;
        pointF.y = j() - 1;
        this.N.startScroll(i2, j() - 1, (l() - i2) + 200, 0, delayMillis);
    }

    private void y() {
        PointF pointF = this.l;
        float f2 = pointF.x;
        int i2 = this.f10526h;
        float f3 = (f2 + i2) / 2.0f;
        this.u = f3;
        float f4 = pointF.y;
        int i3 = this.f10527i;
        float f5 = (f4 + i3) / 2.0f;
        this.v = f5;
        PointF pointF2 = this.n;
        pointF2.x = f3 - (((i3 - f5) * (i3 - f5)) / (i2 - f3));
        pointF2.y = i3;
        PointF pointF3 = this.r;
        pointF3.x = i2;
        pointF3.y = f5 - (((i2 - f3) * (i2 - f3)) / (i3 - f5));
        PointF pointF4 = this.m;
        float f6 = pointF2.x;
        pointF4.x = f6 - ((i2 - f6) / 2.0f);
        pointF4.y = i3;
        float f7 = pointF.x;
        if (f7 > 0.0f && f7 < l()) {
            float f8 = this.m.x;
            if (f8 < 0.0f || f8 > l()) {
                PointF pointF5 = this.m;
                if (pointF5.x < 0.0f) {
                    pointF5.x = l() - this.m.x;
                }
                float abs = Math.abs(this.f10526h - this.l.x);
                this.l.x = Math.abs(this.f10526h - ((l() * abs) / this.m.x));
                this.l.y = Math.abs(this.f10527i - ((Math.abs(this.f10526h - this.l.x) * Math.abs(this.f10527i - this.l.y)) / abs));
                PointF pointF6 = this.l;
                float f9 = pointF6.x;
                int i4 = this.f10526h;
                float f10 = (f9 + i4) / 2.0f;
                this.u = f10;
                float f11 = pointF6.y;
                int i5 = this.f10527i;
                float f12 = (f11 + i5) / 2.0f;
                this.v = f12;
                PointF pointF7 = this.n;
                pointF7.x = f10 - (((i5 - f12) * (i5 - f12)) / (i4 - f10));
                pointF7.y = i5;
                PointF pointF8 = this.r;
                pointF8.x = i4;
                pointF8.y = f12 - (((i4 - f10) * (i4 - f10)) / (i5 - f12));
                PointF pointF9 = this.m;
                float f13 = pointF7.x;
                pointF9.x = f13 - ((i4 - f13) / 2.0f);
            }
        }
        PointF pointF10 = this.q;
        pointF10.x = this.f10526h;
        float f14 = this.r.y;
        pointF10.y = f14 - ((this.f10527i - f14) / 2.0f);
        PointF pointF11 = this.l;
        this.x = (float) Math.hypot(pointF11.x - r1, pointF11.y - r4);
        this.p = G(this.l, this.n, this.m, this.q);
        PointF G = G(this.l, this.r, this.m, this.q);
        this.t = G;
        PointF pointF12 = this.o;
        PointF pointF13 = this.m;
        float f15 = pointF13.x;
        PointF pointF14 = this.n;
        float f16 = f15 + (pointF14.x * 2.0f);
        PointF pointF15 = this.p;
        pointF12.x = (f16 + pointF15.x) / 4.0f;
        pointF12.y = (((pointF14.y * 2.0f) + pointF13.y) + pointF15.y) / 4.0f;
        PointF pointF16 = this.s;
        PointF pointF17 = this.q;
        float f17 = pointF17.x;
        PointF pointF18 = this.r;
        pointF16.x = ((f17 + (pointF18.x * 2.0f)) + G.x) / 4.0f;
        pointF16.y = (((pointF18.y * 2.0f) + pointF17.y) + G.y) / 4.0f;
    }

    public boolean A() {
        return Math.abs(this.l.x) > ((float) l()) / 5.0f || this.B.getXVelocity() > this.O * 500.0f;
    }

    public void E(Canvas canvas) {
        double atan2;
        double d2;
        int i2;
        int i3;
        GradientDrawable gradientDrawable;
        int i4;
        int i5;
        GradientDrawable gradientDrawable2;
        MoveMode moveMode = this.R;
        MoveMode moveMode2 = MoveMode.MOVE_RIGHT_TOP;
        if (moveMode == moveMode2) {
            float f2 = this.n.y;
            PointF pointF = this.l;
            atan2 = Math.atan2(f2 - pointF.y, pointF.x - r0.x);
        } else {
            float f3 = this.l.y;
            PointF pointF2 = this.n;
            atan2 = Math.atan2(f3 - pointF2.y, r0.x - pointF2.x);
        }
        double d3 = 0.7853981633974483d - atan2;
        double cos = Math.cos(d3) * 35.35d;
        double sin = Math.sin(d3) * 35.35d;
        PointF pointF3 = this.l;
        double d4 = pointF3.x;
        Double.isNaN(d4);
        float f4 = (float) (d4 + cos);
        if (this.R == moveMode2) {
            double d5 = pointF3.y;
            Double.isNaN(d5);
            d2 = d5 + sin;
        } else {
            double d6 = pointF3.y;
            Double.isNaN(d6);
            d2 = d6 - sin;
        }
        float f5 = (float) d2;
        this.k.reset();
        this.k.moveTo(f4, f5);
        Path path = this.k;
        PointF pointF4 = this.l;
        path.lineTo(pointF4.x, pointF4.y);
        Path path2 = this.k;
        PointF pointF5 = this.n;
        path2.lineTo(pointF5.x, pointF5.y);
        Path path3 = this.k;
        PointF pointF6 = this.m;
        path3.lineTo(pointF6.x, pointF6.y);
        this.k.close();
        canvas.save();
        canvas.clipPath(this.f10528j, Region.Op.XOR);
        canvas.clipPath(this.k, Region.Op.INTERSECT);
        if (this.R == moveMode2) {
            float f6 = this.n.x;
            i2 = (int) f6;
            i3 = ((int) f6) + 25;
            gradientDrawable = this.K;
        } else {
            float f7 = this.n.x;
            i2 = (int) (f7 - 25.0f);
            i3 = ((int) f7) + 1;
            gradientDrawable = this.L;
        }
        float f8 = this.l.x;
        PointF pointF7 = this.n;
        float degrees = (float) Math.toDegrees(Math.atan2(f8 - pointF7.x, pointF7.y - r7.y));
        PointF pointF8 = this.n;
        canvas.rotate(degrees, pointF8.x, pointF8.y);
        gradientDrawable.setBounds(i2, (int) (this.n.y - H()), i3, (int) this.n.y);
        gradientDrawable.draw(canvas);
        canvas.restore();
        this.k.reset();
        this.k.moveTo(f4, f5);
        Path path4 = this.k;
        PointF pointF9 = this.l;
        path4.lineTo(pointF9.x, pointF9.y);
        Path path5 = this.k;
        PointF pointF10 = this.r;
        path5.lineTo(pointF10.x, pointF10.y);
        Path path6 = this.k;
        PointF pointF11 = this.q;
        path6.lineTo(pointF11.x, pointF11.y);
        this.k.close();
        canvas.save();
        canvas.clipPath(this.f10528j, Region.Op.XOR);
        canvas.clipPath(this.k, Region.Op.INTERSECT);
        if (this.R == moveMode2) {
            float f9 = this.r.y;
            i4 = (int) f9;
            i5 = (int) (f9 + 25.0f);
            gradientDrawable2 = this.J;
        } else {
            float f10 = this.r.y;
            i4 = (int) (f10 - 25.0f);
            i5 = (int) (f10 + 1.0f);
            gradientDrawable2 = this.I;
        }
        float f11 = this.r.y;
        PointF pointF12 = this.l;
        float degrees2 = (float) Math.toDegrees(Math.atan2(f11 - pointF12.y, r4.x - pointF12.x));
        PointF pointF13 = this.r;
        canvas.rotate(degrees2, pointF13.x, pointF13.y);
        float f12 = this.r.y;
        if (f12 < 0.0f) {
            f12 -= j();
        }
        int hypot = (int) Math.hypot(this.r.x, f12);
        if (hypot > H()) {
            float f13 = this.r.x;
            gradientDrawable2.setBounds(((int) (f13 - 25.0f)) - hypot, i4, ((int) (f13 + H())) - hypot, i5);
        } else {
            gradientDrawable2.setBounds((int) (this.r.x - H()), i4, (int) this.r.x, i5);
        }
        gradientDrawable2.draw(canvas);
        canvas.restore();
    }

    public PointF G(PointF P1, PointF P2, PointF P3, PointF P4) {
        PointF pointF = new PointF();
        float f2 = P2.y;
        float f3 = P1.y;
        float f4 = P2.x;
        float f5 = P1.x;
        float f6 = (f2 - f3) / (f4 - f5);
        float f7 = ((f2 * f5) - (f3 * f4)) / (f5 - f4);
        float f8 = P4.y;
        float f9 = P3.y;
        float f10 = P4.x;
        float f11 = P3.x;
        float f12 = ((((f8 * f11) - (f9 * f10)) / (f11 - f10)) - f7) / (f6 - ((f8 - f9) / (f10 - f11)));
        pointF.x = f12;
        pointF.y = (f6 * f12) + f7;
        return pointF;
    }

    public float H() {
        return (float) Math.hypot(l(), j());
    }

    public boolean J() {
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
        N(i());
        return true;
    }

    public boolean K() {
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
        N(i());
        return true;
    }

    @Override // com.martian.libsliding.slider.a, com.martian.libsliding.slider.g
    public boolean a(Canvas canvas) {
        Bitmap r;
        Bitmap s;
        View d2;
        View h2;
        o(this.P);
        if (this.P == 4) {
            i().d().draw(canvas);
            return true;
        }
        y();
        if (this.P == 0) {
            r = s();
            s = r();
            d2 = i().f();
            h2 = i().d();
        } else {
            r = r();
            s = s();
            d2 = i().d();
            h2 = i().h();
        }
        if (r != null && s != null) {
            D(canvas, h2, s);
            F(canvas, d2, r);
            E(canvas);
            C(canvas, s);
        }
        return true;
    }

    @Override // com.martian.libsliding.slider.g
    public void c(boolean fromTouch) {
        if (i().p()) {
            boolean I = I();
            if (I && !fromTouch) {
                this.N.abortAnimation();
                g();
            } else if (I) {
                return;
            }
            P();
            PointF pointF = this.l;
            pointF.x = 1.0f;
            pointF.y = 1.0f;
            S(500);
            this.Q = 1;
            this.P = 1;
            k().B(1);
            m();
        }
    }

    @Override // com.martian.libsliding.slider.g
    public void d() {
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
        this.f10528j = new Path();
        this.k = new Path();
        B();
        Paint paint = new Paint();
        this.M = paint;
        paint.setStyle(Paint.Style.FILL);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2f, 0.0f});
        this.y = new ColorMatrixColorFilter(colorMatrix);
        this.z = new Matrix();
        this.N = new Scroller(slidingLayout.getContext(), new LinearInterpolator());
        PointF pointF = this.l;
        pointF.x = 0.01f;
        pointF.y = 0.01f;
        PointF pointF2 = this.S;
        pointF2.x = 0.0f;
        pointF2.y = 0.0f;
        this.O = slidingLayout.getContext().getResources().getDisplayMetrics().density;
        if (Build.VERSION.SDK_INT < 19) {
            k().setLayerType(1, null);
        }
    }

    @Override // com.martian.libsliding.slider.g
    public void f(boolean fromTouch) {
        if (i().o()) {
            boolean I = I();
            if (I && !fromTouch) {
                this.N.abortAnimation();
                g();
            } else if (I) {
                return;
            }
            if (!fromTouch) {
                this.S.x = l() - 10;
                this.S.y = j() / 2.0f;
            }
            PointF pointF = this.S;
            x(pointF.x, pointF.y);
            PointF pointF2 = this.l;
            PointF pointF3 = this.S;
            pointF2.x = pointF3.x;
            pointF2.y = pointF3.y;
            R(500);
            this.Q = 0;
            this.P = 0;
            k().B(0);
            m();
        }
    }

    @Override // com.martian.libsliding.slider.g
    public void g() {
        int i2;
        if (this.N.computeScrollOffset()) {
            float currX = this.N.getCurrX();
            float currY = this.N.getCurrY();
            PointF pointF = this.l;
            pointF.x = currX;
            pointF.y = currY;
            m();
            return;
        }
        if (!this.N.isFinished() || ((i2 = this.Q) != 1 && i2 != 0)) {
            if (this.N.isFinished() && this.Q == 2) {
                this.P = 4;
                this.R = MoveMode.MOVE_NONE;
                this.Q = 4;
                PointF pointF2 = this.l;
                pointF2.x = 0.0f;
                pointF2.y = 0.0f;
                m();
                return;
            }
            return;
        }
        this.P = 4;
        this.R = MoveMode.MOVE_NONE;
        if (i2 == 0) {
            J();
        } else {
            K();
        }
        this.Q = 4;
        k().B(4);
        PointF pointF3 = this.l;
        pointF3.x = 0.0f;
        pointF3.y = 0.0f;
        t();
    }

    @Override // com.martian.libsliding.slider.a, com.martian.libsliding.slider.g
    public boolean h(MotionEvent event) {
        int action = event.getAction();
        if (action == 0) {
            this.S.x = event.getX();
            this.S.y = event.getY();
            if (!I()) {
                return false;
            }
        } else if (action != 1) {
            if (action != 2) {
                return false;
            }
            if (this.P == 4 && !I() && (this.S.x == 0.0f || Math.abs(event.getX() - this.S.x) < this.O * 10.0f)) {
                return false;
            }
        } else if (this.P == 4) {
            return false;
        }
        return true;
    }

    @Override // com.martian.libsliding.slider.a
    public int j() {
        int measuredHeight = k().getMeasuredHeight();
        return measuredHeight == 0 ? k().getContext().getResources().getDisplayMetrics().heightPixels : measuredHeight;
    }

    @Override // com.martian.libsliding.slider.a
    public int l() {
        int measuredWidth = k().getMeasuredWidth();
        return measuredWidth == 0 ? k().getContext().getResources().getDisplayMetrics().widthPixels : measuredWidth;
    }

    @Override // com.martian.libsliding.slider.a
    public void m() {
        k().postInvalidate();
    }

    @Override // com.martian.libsliding.slider.g
    public boolean onTouchEvent(MotionEvent event) {
        L(event);
        int action = event.getAction();
        boolean z = false;
        if (action == 0) {
            if (I()) {
                this.N.abortAnimation();
                g();
            }
            this.S.x = event.getX();
            this.S.y = event.getY();
            PointF pointF = this.l;
            x(pointF.x, pointF.y);
        } else if (action == 1) {
            this.B.computeCurrentVelocity(1000, ViewConfiguration.getMaximumFlingVelocity());
            int i2 = this.P;
            if (i2 != 0) {
                if (i2 == 1) {
                    if (A()) {
                        this.Q = 1;
                        S(400);
                    } else {
                        this.Q = 2;
                        Q(300);
                    }
                }
                O();
                m();
            } else if (z()) {
                this.Q = 0;
                R(400);
            } else {
                this.Q = 2;
                Q(200);
            }
            z = true;
            O();
            m();
        } else if (action == 2) {
            if (I()) {
                this.N.abortAnimation();
                g();
            }
            PointF pointF2 = this.S;
            if (pointF2.x == 0.0f || pointF2.y == 0.0f) {
                pointF2.x = event.getX();
                this.S.y = event.getY();
            } else if (this.P != 4 || Math.abs(event.getX() - this.S.x) >= this.O * 10.0f) {
                this.l.x = event.getX();
                this.l.y = event.getY();
                if (this.P == 4) {
                    if (this.l.x - this.S.x < -10.0f && i().o()) {
                        this.P = 0;
                        k().B(0);
                    } else if (this.l.x - this.S.x > 10.0f && i().p()) {
                        this.P = 1;
                        k().B(1);
                    }
                }
                int i3 = this.P;
                if (i3 == 0) {
                    PointF pointF3 = this.S;
                    x(pointF3.x, pointF3.y);
                } else {
                    if (i3 == 1) {
                        P();
                    }
                    m();
                }
                z = true;
                m();
            }
        }
        return z;
    }

    public void w() {
        if (this.N.isFinished()) {
            return;
        }
        this.N.abortAnimation();
    }

    public void x(float x, float y) {
        this.f10526h = l();
        if (y <= j() / 3.0f) {
            this.f10527i = 0;
            this.R = MoveMode.MOVE_RIGHT_TOP;
        } else if (y < (j() * 2) / 3.0f) {
            P();
        } else {
            this.f10527i = j();
            this.R = MoveMode.MOVE_RIGHT_BOTTOM;
        }
    }

    public boolean z() {
        return Math.abs(this.l.x - ((float) this.f10526h)) > ((float) l()) / 5.0f || Math.abs(this.l.y - ((float) this.f10527i)) > ((float) j()) / 5.0f || this.B.getXVelocity() < (-this.O) * 500.0f;
    }
}
