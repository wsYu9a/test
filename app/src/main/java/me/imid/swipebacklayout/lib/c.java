package me.imid.swipebacklayout.lib;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ScrollerCompat;
import java.util.Arrays;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: a */
    private static final String f35341a = "ViewDragHelper";

    /* renamed from: b */
    public static final int f35342b = -1;

    /* renamed from: c */
    public static final int f35343c = 0;

    /* renamed from: d */
    public static final int f35344d = 1;

    /* renamed from: e */
    public static final int f35345e = 2;

    /* renamed from: f */
    public static final int f35346f = 1;

    /* renamed from: g */
    public static final int f35347g = 2;

    /* renamed from: h */
    public static final int f35348h = 4;

    /* renamed from: i */
    public static final int f35349i = 8;

    /* renamed from: j */
    public static final int f35350j = 15;
    public static final int k = 1;
    public static final int l = 2;
    public static final int m = 3;
    public static final int n = 20;
    private static final int o = 256;
    private static final int p = 600;
    private static final Interpolator q = new a();
    private int[] A;
    private int B;
    private VelocityTracker C;
    private float D;
    private float E;
    private int F;
    private int G;
    private ScrollerCompat H;
    private final AbstractC0829c I;
    private View J;
    private boolean K;
    private final ViewGroup L;
    private int r;
    private int s;
    private float[] u;
    private float[] v;
    private float[] w;
    private float[] x;
    private int[] y;
    private int[] z;
    private int t = -1;
    private final Runnable M = new b();

    static class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.P(0);
        }
    }

    /* renamed from: me.imid.swipebacklayout.lib.c$c */
    public static abstract class AbstractC0829c {
        public int a(View view, int i2, int i3) {
            return 0;
        }

        public int b(View view, int i2, int i3) {
            return 0;
        }

        public int c(int i2) {
            return i2;
        }

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public void f(int i2, int i3) {
        }

        public boolean g(int i2) {
            return false;
        }

        public void h(int i2, int i3) {
        }

        public void i(View view, int i2) {
        }

        public void j(int i2) {
        }

        public void k(View view, int i2, int i3, int i4, int i5) {
        }

        public void l(View view, float f2, float f3) {
        }

        public abstract boolean m(View view, int i2);
    }

    private c(Context context, ViewGroup viewGroup, AbstractC0829c abstractC0829c) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC0829c == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.L = viewGroup;
        this.I = abstractC0829c;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.F = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.s = viewConfiguration.getScaledTouchSlop();
        this.D = viewConfiguration.getScaledMaximumFlingVelocity();
        this.E = viewConfiguration.getScaledMinimumFlingVelocity();
        this.H = ScrollerCompat.create(context, q);
    }

    private int B(int i2, int i3) {
        int i4 = i2 < this.L.getLeft() + this.F ? 1 : 0;
        if (i3 < this.L.getTop() + this.F) {
            i4 = 4;
        }
        if (i2 > this.L.getRight() - this.F) {
            i4 = 2;
        }
        if (i3 > this.L.getBottom() - this.F) {
            return 8;
        }
        return i4;
    }

    private void L() {
        this.C.computeCurrentVelocity(1000, this.D);
        r(i(VelocityTrackerCompat.getXVelocity(this.C, this.t), this.E, this.D), i(VelocityTrackerCompat.getYVelocity(this.C, this.t), this.E, this.D));
    }

    private void M(float f2, float f3, int i2) {
        int i3 = e(f2, f3, i2, 1) ? 1 : 0;
        if (e(f3, f2, i2, 4)) {
            i3 |= 4;
        }
        if (e(f2, f3, i2, 2)) {
            i3 |= 2;
        }
        if (e(f3, f2, i2, 8)) {
            i3 |= 8;
        }
        if (i3 != 0) {
            int[] iArr = this.z;
            iArr[i2] = iArr[i2] | i3;
            this.I.f(i3, i2);
        }
    }

    private void N(float f2, float f3, int i2) {
        u(i2);
        float[] fArr = this.u;
        this.w[i2] = f2;
        fArr[i2] = f2;
        float[] fArr2 = this.v;
        this.x[i2] = f3;
        fArr2[i2] = f3;
        this.y[i2] = B((int) f2, (int) f3);
        this.B |= 1 << i2;
    }

    private void O(MotionEvent motionEvent) {
        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, i2);
            float x = MotionEventCompat.getX(motionEvent, i2);
            float y = MotionEventCompat.getY(motionEvent, i2);
            this.w[pointerId] = x;
            this.x[pointerId] = y;
        }
    }

    private boolean e(float f2, float f3, int i2, int i3) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.y[i2] & i3) != i3 || (this.G & i3) == 0 || (this.A[i2] & i3) == i3 || (this.z[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.s;
        if (abs <= i4 && abs2 <= i4) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.I.g(i3)) {
            return (this.z[i2] & i3) == 0 && abs > ((float) this.s);
        }
        int[] iArr = this.A;
        iArr[i2] = iArr[i2] | i3;
        return false;
    }

    private boolean h(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z = this.I.d(view) > 0;
        boolean z2 = this.I.e(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f2) > ((float) this.s) : z2 && Math.abs(f3) > ((float) this.s);
        }
        float f4 = (f2 * f2) + (f3 * f3);
        int i2 = this.s;
        return f4 > ((float) (i2 * i2));
    }

    private float i(float f2, float f3, float f4) {
        float abs = Math.abs(f2);
        if (abs < f3) {
            return 0.0f;
        }
        return abs > f4 ? f2 > 0.0f ? f4 : -f4 : f2;
    }

    private int j(int i2, int i3, int i4) {
        int abs = Math.abs(i2);
        if (abs < i3) {
            return 0;
        }
        return abs > i4 ? i2 > 0 ? i4 : -i4 : i2;
    }

    private void k() {
        float[] fArr = this.u;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.v, 0.0f);
        Arrays.fill(this.w, 0.0f);
        Arrays.fill(this.x, 0.0f);
        Arrays.fill(this.y, 0);
        Arrays.fill(this.z, 0);
        Arrays.fill(this.A, 0);
        this.B = 0;
    }

    private void l(int i2) {
        float[] fArr = this.u;
        if (fArr == null) {
            return;
        }
        fArr[i2] = 0.0f;
        this.v[i2] = 0.0f;
        this.w[i2] = 0.0f;
        this.x[i2] = 0.0f;
        this.y[i2] = 0;
        this.z[i2] = 0;
        this.A[i2] = 0;
        this.B = ((1 << i2) ^ (-1)) & this.B;
    }

    private int m(int i2, int i3, int i4) {
        if (i2 == 0) {
            return 0;
        }
        int width = this.L.getWidth();
        float f2 = width / 2;
        float s = f2 + (s(Math.min(1.0f, Math.abs(i2) / width)) * f2);
        int abs = Math.abs(i3);
        return Math.min(abs > 0 ? Math.round(Math.abs(s / abs) * 1000.0f) * 4 : (int) (((Math.abs(i2) / i4) + 1.0f) * 256.0f), p);
    }

    private int n(View view, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int j2 = j(i4, (int) this.E, (int) this.D);
        int j3 = j(i5, (int) this.E, (int) this.D);
        int abs = Math.abs(i2);
        int abs2 = Math.abs(i3);
        int abs3 = Math.abs(j2);
        int abs4 = Math.abs(j3);
        int i6 = abs3 + abs4;
        int i7 = abs + abs2;
        if (j2 != 0) {
            f2 = abs3;
            f3 = i6;
        } else {
            f2 = abs;
            f3 = i7;
        }
        float f6 = f2 / f3;
        if (j3 != 0) {
            f4 = abs4;
            f5 = i6;
        } else {
            f4 = abs2;
            f5 = i7;
        }
        return (int) ((m(i2, j2, this.I.d(view)) * f6) + (m(i3, j3, this.I.e(view)) * (f4 / f5)));
    }

    public static c p(ViewGroup viewGroup, float f2, AbstractC0829c abstractC0829c) {
        c q2 = q(viewGroup, abstractC0829c);
        q2.s = (int) (q2.s * (1.0f / f2));
        return q2;
    }

    public static c q(ViewGroup viewGroup, AbstractC0829c abstractC0829c) {
        return new c(viewGroup.getContext(), viewGroup, abstractC0829c);
    }

    private void r(float f2, float f3) {
        this.K = true;
        this.I.l(this.J, f2, f3);
        this.K = false;
        if (this.r == 1) {
            P(0);
        }
    }

    private float s(float f2) {
        Double.isNaN(f2 - 0.5f);
        return (float) Math.sin((float) (r0 * 0.4712389167638204d));
    }

    private void t(int i2, int i3, int i4, int i5) {
        int left = this.J.getLeft();
        int top = this.J.getTop();
        if (i4 != 0) {
            i2 = this.I.a(this.J, i2, i4);
            this.J.offsetLeftAndRight(i2 - left);
        }
        int i6 = i2;
        if (i5 != 0) {
            i3 = this.I.b(this.J, i3, i5);
            this.J.offsetTopAndBottom(i3 - top);
        }
        int i7 = i3;
        if (i4 == 0 && i5 == 0) {
            return;
        }
        this.I.k(this.J, i6, i7, i6 - left, i7 - top);
    }

    private void u(int i2) {
        float[] fArr = this.u;
        if (fArr == null || fArr.length <= i2) {
            int i3 = i2 + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.v;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.w;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.x;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.y;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.z;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.A;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.u = fArr2;
            this.v = fArr3;
            this.w = fArr4;
            this.x = fArr5;
            this.y = iArr;
            this.z = iArr2;
            this.A = iArr3;
        }
    }

    private boolean x(int i2, int i3, int i4, int i5) {
        int left = this.J.getLeft();
        int top = this.J.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.H.abortAnimation();
            P(0);
            return false;
        }
        this.H.startScroll(left, top, i6, i7, n(this.J, i6, i7, i4, i5));
        P(2);
        return true;
    }

    public int A() {
        return this.F;
    }

    public float C() {
        return this.E;
    }

    public int D() {
        return this.s;
    }

    public int E() {
        return this.r;
    }

    public boolean F(int i2, int i3) {
        return J(this.J, i2, i3);
    }

    public boolean G(int i2) {
        int length = this.y.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (H(i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public boolean H(int i2, int i3) {
        return I(i3) && (i2 & this.y[i3]) != 0;
    }

    public boolean I(int i2) {
        return ((1 << i2) & this.B) != 0;
    }

    public boolean J(View view, int i2, int i3) {
        return view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom();
    }

    public void K(MotionEvent motionEvent) {
        int i2;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            c();
        }
        if (this.C == null) {
            this.C = VelocityTracker.obtain();
        }
        this.C.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            View v = v((int) x, (int) y);
            N(x, y, pointerId);
            Y(v, pointerId);
            int i4 = this.y[pointerId];
            int i5 = this.G;
            if ((i4 & i5) != 0) {
                this.I.h(i4 & i5, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.r == 1) {
                L();
            }
            c();
            return;
        }
        if (actionMasked == 2) {
            if (this.r == 1) {
                int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.t);
                float x2 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                float[] fArr = this.w;
                int i6 = this.t;
                int i7 = (int) (x2 - fArr[i6]);
                int i8 = (int) (y2 - this.x[i6]);
                t(this.J.getLeft() + i7, this.J.getTop() + i8, i7, i8);
                O(motionEvent);
                return;
            }
            int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
            while (i3 < pointerCount) {
                int pointerId2 = MotionEventCompat.getPointerId(motionEvent, i3);
                float x3 = MotionEventCompat.getX(motionEvent, i3);
                float y3 = MotionEventCompat.getY(motionEvent, i3);
                float f2 = x3 - this.u[pointerId2];
                float f3 = y3 - this.v[pointerId2];
                M(f2, f3, pointerId2);
                if (this.r != 1) {
                    View v2 = v((int) x3, (int) y3);
                    if (h(v2, f2, f3) && Y(v2, pointerId2)) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    break;
                }
            }
            O(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.r == 1) {
                r(0.0f, 0.0f);
            }
            c();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
            float x4 = MotionEventCompat.getX(motionEvent, actionIndex);
            float y4 = MotionEventCompat.getY(motionEvent, actionIndex);
            N(x4, y4, pointerId3);
            if (this.r != 0) {
                if (F((int) x4, (int) y4)) {
                    Y(this.J, pointerId3);
                    return;
                }
                return;
            } else {
                Y(v((int) x4, (int) y4), pointerId3);
                int i9 = this.y[pointerId3];
                int i10 = this.G;
                if ((i9 & i10) != 0) {
                    this.I.h(i9 & i10, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
        if (this.r == 1 && pointerId4 == this.t) {
            int pointerCount2 = MotionEventCompat.getPointerCount(motionEvent);
            while (true) {
                if (i3 >= pointerCount2) {
                    i2 = -1;
                    break;
                }
                int pointerId5 = MotionEventCompat.getPointerId(motionEvent, i3);
                if (pointerId5 != this.t) {
                    View v3 = v((int) MotionEventCompat.getX(motionEvent, i3), (int) MotionEventCompat.getY(motionEvent, i3));
                    View view = this.J;
                    if (v3 == view && Y(view, pointerId5)) {
                        i2 = this.t;
                        break;
                    }
                }
                i3++;
            }
            if (i2 == -1) {
                L();
            }
        }
        l(pointerId4);
    }

    void P(int i2) {
        if (this.r != i2) {
            this.r = i2;
            this.I.j(i2);
            if (i2 == 0) {
                this.J = null;
            }
        }
    }

    public void Q(int i2) {
        this.F = i2;
    }

    public void R(int i2) {
        this.G = i2;
    }

    public void S(float f2) {
        this.D = f2;
    }

    public void T(float f2) {
        this.E = f2;
    }

    public void U(Context context, float f2) {
        this.s = (int) (ViewConfiguration.get(context).getScaledTouchSlop() * (1.0f / Math.max(0.0f, Math.min(1.0f, f2))));
    }

    public boolean V(int i2, int i3) {
        if (this.K) {
            return x(i2, i3, (int) VelocityTrackerCompat.getXVelocity(this.C, this.t), (int) VelocityTrackerCompat.getYVelocity(this.C, this.t));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public boolean W(MotionEvent motionEvent) {
        View v;
        View v2;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            c();
        }
        if (this.C == null) {
            this.C = VelocityTracker.obtain();
        }
        this.C.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
                    for (int i2 = 0; i2 < pointerCount; i2++) {
                        int pointerId = MotionEventCompat.getPointerId(motionEvent, i2);
                        float x = MotionEventCompat.getX(motionEvent, i2);
                        float y = MotionEventCompat.getY(motionEvent, i2);
                        float f2 = x - this.u[pointerId];
                        float f3 = y - this.v[pointerId];
                        M(f2, f3, pointerId);
                        if (this.r == 1 || ((v = v((int) x, (int) y)) != null && h(v, f2, f3) && Y(v, pointerId))) {
                            break;
                        }
                    }
                    O(motionEvent);
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        int pointerId2 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                        float x2 = MotionEventCompat.getX(motionEvent, actionIndex);
                        float y2 = MotionEventCompat.getY(motionEvent, actionIndex);
                        N(x2, y2, pointerId2);
                        int i3 = this.r;
                        if (i3 == 0) {
                            int i4 = this.y[pointerId2];
                            int i5 = this.G;
                            if ((i4 & i5) != 0) {
                                this.I.h(i4 & i5, pointerId2);
                            }
                        } else if (i3 == 2 && (v2 = v((int) x2, (int) y2)) == this.J) {
                            Y(v2, pointerId2);
                        }
                    } else if (actionMasked == 6) {
                        l(MotionEventCompat.getPointerId(motionEvent, actionIndex));
                    }
                }
            }
            c();
        } else {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            int pointerId3 = MotionEventCompat.getPointerId(motionEvent, 0);
            N(x3, y3, pointerId3);
            View v3 = v((int) x3, (int) y3);
            if (v3 == this.J && this.r == 2) {
                Y(v3, pointerId3);
            }
            int i6 = this.y[pointerId3];
            int i7 = this.G;
            if ((i6 & i7) != 0) {
                this.I.h(i6 & i7, pointerId3);
            }
        }
        return this.r == 1;
    }

    public boolean X(View view, int i2, int i3) {
        this.J = view;
        this.t = -1;
        return x(i2, i3, 0, 0);
    }

    boolean Y(View view, int i2) {
        if (view == this.J && this.t == i2) {
            return true;
        }
        if (view == null || !this.I.m(view, i2)) {
            return false;
        }
        this.t = i2;
        d(view, i2);
        return true;
    }

    public void a() {
        c();
        if (this.r == 2) {
            int currX = this.H.getCurrX();
            int currY = this.H.getCurrY();
            this.H.abortAnimation();
            int currX2 = this.H.getCurrX();
            int currY2 = this.H.getCurrY();
            this.I.k(this.J, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        P(0);
    }

    protected boolean b(View view, boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i7 = i4 + scrollX;
                if (i7 >= childAt.getLeft() && i7 < childAt.getRight() && (i6 = i5 + scrollY) >= childAt.getTop() && i6 < childAt.getBottom() && b(childAt, true, i2, i3, i7 - childAt.getLeft(), i6 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && (ViewCompat.canScrollHorizontally(view, -i2) || ViewCompat.canScrollVertically(view, -i3));
    }

    public void c() {
        this.t = -1;
        k();
        VelocityTracker velocityTracker = this.C;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.C = null;
        }
    }

    public void d(View view, int i2) {
        if (view.getParent() == this.L) {
            this.J = view;
            this.t = i2;
            this.I.i(view, i2);
            P(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.L + ")");
    }

    public boolean f(int i2) {
        int length = this.u.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (g(i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public boolean g(int i2, int i3) {
        if (!I(i3)) {
            return false;
        }
        boolean z = (i2 & 1) == 1;
        boolean z2 = (i2 & 2) == 2;
        float f2 = this.w[i3] - this.u[i3];
        float f3 = this.x[i3] - this.v[i3];
        if (!z || !z2) {
            return z ? Math.abs(f2) > ((float) this.s) : z2 && Math.abs(f3) > ((float) this.s);
        }
        float f4 = (f2 * f2) + (f3 * f3);
        int i4 = this.s;
        return f4 > ((float) (i4 * i4));
    }

    public boolean o(boolean z) {
        if (this.r == 2) {
            boolean computeScrollOffset = this.H.computeScrollOffset();
            int currX = this.H.getCurrX();
            int currY = this.H.getCurrY();
            int left = currX - this.J.getLeft();
            int top = currY - this.J.getTop();
            if (left != 0) {
                this.J.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.J.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.I.k(this.J, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.H.getFinalX() && currY == this.H.getFinalY()) {
                this.H.abortAnimation();
                computeScrollOffset = this.H.isFinished();
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.L.post(this.M);
                } else {
                    P(0);
                }
            }
        }
        return this.r == 2;
    }

    public View v(int i2, int i3) {
        for (int childCount = this.L.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.L.getChildAt(this.I.c(childCount));
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void w(int i2, int i3, int i4, int i5) {
        if (!this.K) {
            throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        }
        this.H.fling(this.J.getLeft(), this.J.getTop(), (int) VelocityTrackerCompat.getXVelocity(this.C, this.t), (int) VelocityTrackerCompat.getYVelocity(this.C, this.t), i2, i4, i3, i5);
        P(2);
    }

    public int y() {
        return this.t;
    }

    public View z() {
        return this.J;
    }
}
