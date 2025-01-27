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

/* loaded from: classes4.dex */
public class a {
    public static final int A = 2;
    public static final int B = 1;
    public static final int C = 2;
    public static final int D = 4;
    public static final int E = 8;
    public static final int F = 15;
    public static final int G = 1;
    public static final int H = 2;
    public static final int I = 3;
    public static final int J = 20;
    public static final int K = 256;
    public static final int L = 600;
    public static final Interpolator M = new InterpolatorC0742a();

    /* renamed from: w */
    public static final String f28662w = "ViewDragHelper";

    /* renamed from: x */
    public static final int f28663x = -1;

    /* renamed from: y */
    public static final int f28664y = 0;

    /* renamed from: z */
    public static final int f28665z = 1;

    /* renamed from: a */
    public int f28666a;

    /* renamed from: b */
    public int f28667b;

    /* renamed from: d */
    public float[] f28669d;

    /* renamed from: e */
    public float[] f28670e;

    /* renamed from: f */
    public float[] f28671f;

    /* renamed from: g */
    public float[] f28672g;

    /* renamed from: h */
    public int[] f28673h;

    /* renamed from: i */
    public int[] f28674i;

    /* renamed from: j */
    public int[] f28675j;

    /* renamed from: k */
    public int f28676k;

    /* renamed from: l */
    public VelocityTracker f28677l;

    /* renamed from: m */
    public float f28678m;

    /* renamed from: n */
    public float f28679n;

    /* renamed from: o */
    public int f28680o;

    /* renamed from: p */
    public int f28681p;

    /* renamed from: q */
    public ScrollerCompat f28682q;

    /* renamed from: r */
    public final c f28683r;

    /* renamed from: s */
    public View f28684s;

    /* renamed from: t */
    public boolean f28685t;

    /* renamed from: u */
    public final ViewGroup f28686u;

    /* renamed from: c */
    public int f28668c = -1;

    /* renamed from: v */
    public final Runnable f28687v = new b();

    /* renamed from: me.imid.swipebacklayout.lib.a$a */
    public static class InterpolatorC0742a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.P(0);
        }
    }

    public static abstract class c {
        public int a(View view, int i10, int i11) {
            return 0;
        }

        public int b(View view, int i10, int i11) {
            return 0;
        }

        public int c(int i10) {
            return i10;
        }

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public void f(int i10, int i11) {
        }

        public boolean g(int i10) {
            return false;
        }

        public void h(int i10, int i11) {
        }

        public void i(View view, int i10) {
        }

        public void j(int i10) {
        }

        public void k(View view, int i10, int i11, int i12, int i13) {
        }

        public void l(View view, float f10, float f11) {
        }

        public abstract boolean m(View view, int i10);
    }

    public a(Context context, ViewGroup viewGroup, c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (cVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f28686u = viewGroup;
        this.f28683r = cVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f28680o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f28667b = viewConfiguration.getScaledTouchSlop();
        this.f28678m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f28679n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f28682q = ScrollerCompat.create(context, M);
    }

    public static a p(ViewGroup viewGroup, float f10, c cVar) {
        a q10 = q(viewGroup, cVar);
        q10.f28667b = (int) (q10.f28667b * (1.0f / f10));
        return q10;
    }

    public static a q(ViewGroup viewGroup, c cVar) {
        return new a(viewGroup.getContext(), viewGroup, cVar);
    }

    public int A() {
        return this.f28680o;
    }

    public final int B(int i10, int i11) {
        int i12 = i10 < this.f28686u.getLeft() + this.f28680o ? 1 : 0;
        if (i11 < this.f28686u.getTop() + this.f28680o) {
            i12 = 4;
        }
        if (i10 > this.f28686u.getRight() - this.f28680o) {
            i12 = 2;
        }
        if (i11 > this.f28686u.getBottom() - this.f28680o) {
            return 8;
        }
        return i12;
    }

    public float C() {
        return this.f28679n;
    }

    public int D() {
        return this.f28667b;
    }

    public int E() {
        return this.f28666a;
    }

    public boolean F(int i10, int i11) {
        return J(this.f28684s, i10, i11);
    }

    public boolean G(int i10) {
        int length = this.f28673h.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (H(i10, i11)) {
                return true;
            }
        }
        return false;
    }

    public boolean H(int i10, int i11) {
        return I(i11) && (i10 & this.f28673h[i11]) != 0;
    }

    public boolean I(int i10) {
        return ((1 << i10) & this.f28676k) != 0;
    }

    public boolean J(View view, int i10, int i11) {
        return view != null && i10 >= view.getLeft() && i10 < view.getRight() && i11 >= view.getTop() && i11 < view.getBottom();
    }

    public void K(MotionEvent motionEvent) {
        int i10;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            c();
        }
        if (this.f28677l == null) {
            this.f28677l = VelocityTracker.obtain();
        }
        this.f28677l.addMovement(motionEvent);
        int i11 = 0;
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            View v10 = v((int) x10, (int) y10);
            N(x10, y10, pointerId);
            Y(v10, pointerId);
            int i12 = this.f28673h[pointerId];
            int i13 = this.f28681p;
            if ((i12 & i13) != 0) {
                this.f28683r.h(i12 & i13, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f28666a == 1) {
                L();
            }
            c();
            return;
        }
        if (actionMasked == 2) {
            if (this.f28666a == 1) {
                int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f28668c);
                float x11 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                float y11 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                float[] fArr = this.f28671f;
                int i14 = this.f28668c;
                int i15 = (int) (x11 - fArr[i14]);
                int i16 = (int) (y11 - this.f28672g[i14]);
                t(this.f28684s.getLeft() + i15, this.f28684s.getTop() + i16, i15, i16);
                O(motionEvent);
                return;
            }
            int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
            while (i11 < pointerCount) {
                int pointerId2 = MotionEventCompat.getPointerId(motionEvent, i11);
                float x12 = MotionEventCompat.getX(motionEvent, i11);
                float y12 = MotionEventCompat.getY(motionEvent, i11);
                float f10 = x12 - this.f28669d[pointerId2];
                float f11 = y12 - this.f28670e[pointerId2];
                M(f10, f11, pointerId2);
                if (this.f28666a != 1) {
                    View v11 = v((int) x12, (int) y12);
                    if (h(v11, f10, f11) && Y(v11, pointerId2)) {
                        break;
                    } else {
                        i11++;
                    }
                } else {
                    break;
                }
            }
            O(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f28666a == 1) {
                r(0.0f, 0.0f);
            }
            c();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
            float x13 = MotionEventCompat.getX(motionEvent, actionIndex);
            float y13 = MotionEventCompat.getY(motionEvent, actionIndex);
            N(x13, y13, pointerId3);
            if (this.f28666a != 0) {
                if (F((int) x13, (int) y13)) {
                    Y(this.f28684s, pointerId3);
                    return;
                }
                return;
            } else {
                Y(v((int) x13, (int) y13), pointerId3);
                int i17 = this.f28673h[pointerId3];
                int i18 = this.f28681p;
                if ((i17 & i18) != 0) {
                    this.f28683r.h(i17 & i18, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
        if (this.f28666a == 1 && pointerId4 == this.f28668c) {
            int pointerCount2 = MotionEventCompat.getPointerCount(motionEvent);
            while (true) {
                if (i11 >= pointerCount2) {
                    i10 = -1;
                    break;
                }
                int pointerId5 = MotionEventCompat.getPointerId(motionEvent, i11);
                if (pointerId5 != this.f28668c) {
                    View v12 = v((int) MotionEventCompat.getX(motionEvent, i11), (int) MotionEventCompat.getY(motionEvent, i11));
                    View view = this.f28684s;
                    if (v12 == view && Y(view, pointerId5)) {
                        i10 = this.f28668c;
                        break;
                    }
                }
                i11++;
            }
            if (i10 == -1) {
                L();
            }
        }
        l(pointerId4);
    }

    public final void L() {
        this.f28677l.computeCurrentVelocity(1000, this.f28678m);
        r(i(VelocityTrackerCompat.getXVelocity(this.f28677l, this.f28668c), this.f28679n, this.f28678m), i(VelocityTrackerCompat.getYVelocity(this.f28677l, this.f28668c), this.f28679n, this.f28678m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r3v3, types: [me.imid.swipebacklayout.lib.a$c] */
    public final void M(float f10, float f11, int i10) {
        boolean e10 = e(f10, f11, i10, 1);
        boolean z10 = e10;
        if (e(f11, f10, i10, 4)) {
            z10 = (e10 ? 1 : 0) | 4;
        }
        boolean z11 = z10;
        if (e(f10, f11, i10, 2)) {
            z11 = (z10 ? 1 : 0) | 2;
        }
        ?? r02 = z11;
        if (e(f11, f10, i10, 8)) {
            r02 = (z11 ? 1 : 0) | 8;
        }
        if (r02 != 0) {
            int[] iArr = this.f28674i;
            iArr[i10] = iArr[i10] | r02;
            this.f28683r.f(r02, i10);
        }
    }

    public final void N(float f10, float f11, int i10) {
        u(i10);
        float[] fArr = this.f28669d;
        this.f28671f[i10] = f10;
        fArr[i10] = f10;
        float[] fArr2 = this.f28670e;
        this.f28672g[i10] = f11;
        fArr2[i10] = f11;
        this.f28673h[i10] = B((int) f10, (int) f11);
        this.f28676k |= 1 << i10;
    }

    public final void O(MotionEvent motionEvent) {
        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
        for (int i10 = 0; i10 < pointerCount; i10++) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, i10);
            float x10 = MotionEventCompat.getX(motionEvent, i10);
            float y10 = MotionEventCompat.getY(motionEvent, i10);
            this.f28671f[pointerId] = x10;
            this.f28672g[pointerId] = y10;
        }
    }

    public void P(int i10) {
        if (this.f28666a != i10) {
            this.f28666a = i10;
            this.f28683r.j(i10);
            if (i10 == 0) {
                this.f28684s = null;
            }
        }
    }

    public void Q(int i10) {
        this.f28680o = i10;
    }

    public void R(int i10) {
        this.f28681p = i10;
    }

    public void S(float f10) {
        this.f28678m = f10;
    }

    public void T(float f10) {
        this.f28679n = f10;
    }

    public void U(Context context, float f10) {
        this.f28667b = (int) (ViewConfiguration.get(context).getScaledTouchSlop() * (1.0f / Math.max(0.0f, Math.min(1.0f, f10))));
    }

    public boolean V(int i10, int i11) {
        if (this.f28685t) {
            return x(i10, i11, (int) VelocityTrackerCompat.getXVelocity(this.f28677l, this.f28668c), (int) VelocityTrackerCompat.getYVelocity(this.f28677l, this.f28668c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public boolean W(MotionEvent motionEvent) {
        View v10;
        View v11;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            c();
        }
        if (this.f28677l == null) {
            this.f28677l = VelocityTracker.obtain();
        }
        this.f28677l.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
                    for (int i10 = 0; i10 < pointerCount; i10++) {
                        int pointerId = MotionEventCompat.getPointerId(motionEvent, i10);
                        float x10 = MotionEventCompat.getX(motionEvent, i10);
                        float y10 = MotionEventCompat.getY(motionEvent, i10);
                        float f10 = x10 - this.f28669d[pointerId];
                        float f11 = y10 - this.f28670e[pointerId];
                        M(f10, f11, pointerId);
                        if (this.f28666a == 1 || ((v10 = v((int) x10, (int) y10)) != null && h(v10, f10, f11) && Y(v10, pointerId))) {
                            break;
                        }
                    }
                    O(motionEvent);
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        int pointerId2 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                        float x11 = MotionEventCompat.getX(motionEvent, actionIndex);
                        float y11 = MotionEventCompat.getY(motionEvent, actionIndex);
                        N(x11, y11, pointerId2);
                        int i11 = this.f28666a;
                        if (i11 == 0) {
                            int i12 = this.f28673h[pointerId2];
                            int i13 = this.f28681p;
                            if ((i12 & i13) != 0) {
                                this.f28683r.h(i12 & i13, pointerId2);
                            }
                        } else if (i11 == 2 && (v11 = v((int) x11, (int) y11)) == this.f28684s) {
                            Y(v11, pointerId2);
                        }
                    } else if (actionMasked == 6) {
                        l(MotionEventCompat.getPointerId(motionEvent, actionIndex));
                    }
                }
            }
            c();
        } else {
            float x12 = motionEvent.getX();
            float y12 = motionEvent.getY();
            int pointerId3 = MotionEventCompat.getPointerId(motionEvent, 0);
            N(x12, y12, pointerId3);
            View v12 = v((int) x12, (int) y12);
            if (v12 == this.f28684s && this.f28666a == 2) {
                Y(v12, pointerId3);
            }
            int i14 = this.f28673h[pointerId3];
            int i15 = this.f28681p;
            if ((i14 & i15) != 0) {
                this.f28683r.h(i14 & i15, pointerId3);
            }
        }
        return this.f28666a == 1;
    }

    public boolean X(View view, int i10, int i11) {
        this.f28684s = view;
        this.f28668c = -1;
        return x(i10, i11, 0, 0);
    }

    public boolean Y(View view, int i10) {
        if (view == this.f28684s && this.f28668c == i10) {
            return true;
        }
        if (view == null || !this.f28683r.m(view, i10)) {
            return false;
        }
        this.f28668c = i10;
        d(view, i10);
        return true;
    }

    public void a() {
        c();
        if (this.f28666a == 2) {
            int currX = this.f28682q.getCurrX();
            int currY = this.f28682q.getCurrY();
            this.f28682q.abortAnimation();
            int currX2 = this.f28682q.getCurrX();
            int currY2 = this.f28682q.getCurrY();
            this.f28683r.k(this.f28684s, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        P(0);
    }

    public boolean b(View view, boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i15 = i12 + scrollX;
                if (i15 >= childAt.getLeft() && i15 < childAt.getRight() && (i14 = i13 + scrollY) >= childAt.getTop() && i14 < childAt.getBottom() && b(childAt, true, i10, i11, i15 - childAt.getLeft(), i14 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z10 && (ViewCompat.canScrollHorizontally(view, -i10) || ViewCompat.canScrollVertically(view, -i11));
    }

    public void c() {
        this.f28668c = -1;
        k();
        VelocityTracker velocityTracker = this.f28677l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f28677l = null;
        }
    }

    public void d(View view, int i10) {
        if (view.getParent() == this.f28686u) {
            this.f28684s = view;
            this.f28668c = i10;
            this.f28683r.i(view, i10);
            P(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f28686u + ")");
    }

    public final boolean e(float f10, float f11, int i10, int i11) {
        float abs = Math.abs(f10);
        float abs2 = Math.abs(f11);
        if ((this.f28673h[i10] & i11) != i11 || (this.f28681p & i11) == 0 || (this.f28675j[i10] & i11) == i11 || (this.f28674i[i10] & i11) == i11) {
            return false;
        }
        int i12 = this.f28667b;
        if (abs <= i12 && abs2 <= i12) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f28683r.g(i11)) {
            return (this.f28674i[i10] & i11) == 0 && abs > ((float) this.f28667b);
        }
        int[] iArr = this.f28675j;
        iArr[i10] = iArr[i10] | i11;
        return false;
    }

    public boolean f(int i10) {
        int length = this.f28669d.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (g(i10, i11)) {
                return true;
            }
        }
        return false;
    }

    public boolean g(int i10, int i11) {
        if (!I(i11)) {
            return false;
        }
        boolean z10 = (i10 & 1) == 1;
        boolean z11 = (i10 & 2) == 2;
        float f10 = this.f28671f[i11] - this.f28669d[i11];
        float f11 = this.f28672g[i11] - this.f28670e[i11];
        if (!z10 || !z11) {
            return z10 ? Math.abs(f10) > ((float) this.f28667b) : z11 && Math.abs(f11) > ((float) this.f28667b);
        }
        float f12 = (f10 * f10) + (f11 * f11);
        int i12 = this.f28667b;
        return f12 > ((float) (i12 * i12));
    }

    public final boolean h(View view, float f10, float f11) {
        if (view == null) {
            return false;
        }
        boolean z10 = this.f28683r.d(view) > 0;
        boolean z11 = this.f28683r.e(view) > 0;
        if (!z10 || !z11) {
            return z10 ? Math.abs(f10) > ((float) this.f28667b) : z11 && Math.abs(f11) > ((float) this.f28667b);
        }
        float f12 = (f10 * f10) + (f11 * f11);
        int i10 = this.f28667b;
        return f12 > ((float) (i10 * i10));
    }

    public final float i(float f10, float f11, float f12) {
        float abs = Math.abs(f10);
        if (abs < f11) {
            return 0.0f;
        }
        return abs > f12 ? f10 > 0.0f ? f12 : -f12 : f10;
    }

    public final int j(int i10, int i11, int i12) {
        int abs = Math.abs(i10);
        if (abs < i11) {
            return 0;
        }
        return abs > i12 ? i10 > 0 ? i12 : -i12 : i10;
    }

    public final void k() {
        float[] fArr = this.f28669d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f28670e, 0.0f);
        Arrays.fill(this.f28671f, 0.0f);
        Arrays.fill(this.f28672g, 0.0f);
        Arrays.fill(this.f28673h, 0);
        Arrays.fill(this.f28674i, 0);
        Arrays.fill(this.f28675j, 0);
        this.f28676k = 0;
    }

    public final void l(int i10) {
        float[] fArr = this.f28669d;
        if (fArr == null) {
            return;
        }
        fArr[i10] = 0.0f;
        this.f28670e[i10] = 0.0f;
        this.f28671f[i10] = 0.0f;
        this.f28672g[i10] = 0.0f;
        this.f28673h[i10] = 0;
        this.f28674i[i10] = 0;
        this.f28675j[i10] = 0;
        this.f28676k = (~(1 << i10)) & this.f28676k;
    }

    public final int m(int i10, int i11, int i12) {
        if (i10 == 0) {
            return 0;
        }
        int width = this.f28686u.getWidth();
        float f10 = width / 2;
        float s10 = f10 + (s(Math.min(1.0f, Math.abs(i10) / width)) * f10);
        int abs = Math.abs(i11);
        return Math.min(abs > 0 ? Math.round(Math.abs(s10 / abs) * 1000.0f) * 4 : (int) (((Math.abs(i10) / i12) + 1.0f) * 256.0f), 600);
    }

    public final int n(View view, int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float f12;
        float f13;
        int j10 = j(i12, (int) this.f28679n, (int) this.f28678m);
        int j11 = j(i13, (int) this.f28679n, (int) this.f28678m);
        int abs = Math.abs(i10);
        int abs2 = Math.abs(i11);
        int abs3 = Math.abs(j10);
        int abs4 = Math.abs(j11);
        int i14 = abs3 + abs4;
        int i15 = abs + abs2;
        if (j10 != 0) {
            f10 = abs3;
            f11 = i14;
        } else {
            f10 = abs;
            f11 = i15;
        }
        float f14 = f10 / f11;
        if (j11 != 0) {
            f12 = abs4;
            f13 = i14;
        } else {
            f12 = abs2;
            f13 = i15;
        }
        return (int) ((m(i10, j10, this.f28683r.d(view)) * f14) + (m(i11, j11, this.f28683r.e(view)) * (f12 / f13)));
    }

    public boolean o(boolean z10) {
        if (this.f28666a == 2) {
            boolean computeScrollOffset = this.f28682q.computeScrollOffset();
            int currX = this.f28682q.getCurrX();
            int currY = this.f28682q.getCurrY();
            int left = currX - this.f28684s.getLeft();
            int top = currY - this.f28684s.getTop();
            if (left != 0) {
                this.f28684s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.f28684s.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.f28683r.k(this.f28684s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f28682q.getFinalX() && currY == this.f28682q.getFinalY()) {
                this.f28682q.abortAnimation();
                computeScrollOffset = this.f28682q.isFinished();
            }
            if (!computeScrollOffset) {
                if (z10) {
                    this.f28686u.post(this.f28687v);
                } else {
                    P(0);
                }
            }
        }
        return this.f28666a == 2;
    }

    public final void r(float f10, float f11) {
        this.f28685t = true;
        this.f28683r.l(this.f28684s, f10, f11);
        this.f28685t = false;
        if (this.f28666a == 1) {
            P(0);
        }
    }

    public final float s(float f10) {
        return (float) Math.sin((float) ((f10 - 0.5f) * 0.4712389167638204d));
    }

    public final void t(int i10, int i11, int i12, int i13) {
        int left = this.f28684s.getLeft();
        int top = this.f28684s.getTop();
        if (i12 != 0) {
            i10 = this.f28683r.a(this.f28684s, i10, i12);
            this.f28684s.offsetLeftAndRight(i10 - left);
        }
        int i14 = i10;
        if (i13 != 0) {
            i11 = this.f28683r.b(this.f28684s, i11, i13);
            this.f28684s.offsetTopAndBottom(i11 - top);
        }
        int i15 = i11;
        if (i12 == 0 && i13 == 0) {
            return;
        }
        this.f28683r.k(this.f28684s, i14, i15, i14 - left, i15 - top);
    }

    public final void u(int i10) {
        float[] fArr = this.f28669d;
        if (fArr == null || fArr.length <= i10) {
            int i11 = i10 + 1;
            float[] fArr2 = new float[i11];
            float[] fArr3 = new float[i11];
            float[] fArr4 = new float[i11];
            float[] fArr5 = new float[i11];
            int[] iArr = new int[i11];
            int[] iArr2 = new int[i11];
            int[] iArr3 = new int[i11];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f28670e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f28671f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f28672g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f28673h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f28674i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f28675j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f28669d = fArr2;
            this.f28670e = fArr3;
            this.f28671f = fArr4;
            this.f28672g = fArr5;
            this.f28673h = iArr;
            this.f28674i = iArr2;
            this.f28675j = iArr3;
        }
    }

    public View v(int i10, int i11) {
        for (int childCount = this.f28686u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f28686u.getChildAt(this.f28683r.c(childCount));
            if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && i11 >= childAt.getTop() && i11 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void w(int i10, int i11, int i12, int i13) {
        if (!this.f28685t) {
            throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        }
        this.f28682q.fling(this.f28684s.getLeft(), this.f28684s.getTop(), (int) VelocityTrackerCompat.getXVelocity(this.f28677l, this.f28668c), (int) VelocityTrackerCompat.getYVelocity(this.f28677l, this.f28668c), i10, i12, i11, i13);
        P(2);
    }

    public final boolean x(int i10, int i11, int i12, int i13) {
        int left = this.f28684s.getLeft();
        int top = this.f28684s.getTop();
        int i14 = i10 - left;
        int i15 = i11 - top;
        if (i14 == 0 && i15 == 0) {
            this.f28682q.abortAnimation();
            P(0);
            return false;
        }
        this.f28682q.startScroll(left, top, i14, i15, n(this.f28684s, i14, i15, i12, i13));
        P(2);
        return true;
    }

    public int y() {
        return this.f28668c;
    }

    public View z() {
        return this.f28684s;
    }
}
