package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    public static final float NO_MAX = Float.MAX_VALUE;
    public static final float NO_MIN = 0.0f;
    public static final float RELATIVE_UNSPECIFIED = 0.0f;

    /* renamed from: a */
    private static final int f2164a = 0;

    /* renamed from: b */
    private static final int f2165b = 1;

    /* renamed from: c */
    private static final int f2166c = 1;

    /* renamed from: d */
    private static final int f2167d = 315;

    /* renamed from: e */
    private static final int f2168e = 1575;

    /* renamed from: f */
    private static final float f2169f = Float.MAX_VALUE;

    /* renamed from: g */
    private static final float f2170g = 0.2f;

    /* renamed from: h */
    private static final float f2171h = 1.0f;

    /* renamed from: i */
    private static final int f2172i = ViewConfiguration.getTapTimeout();

    /* renamed from: j */
    private static final int f2173j = 500;
    private static final int k = 500;
    private boolean A;
    private boolean B;
    final View n;
    private Runnable o;
    private int r;
    private int s;
    private boolean w;
    boolean x;
    boolean y;
    boolean z;
    final ClampedScroller l = new ClampedScroller();
    private final Interpolator m = new AccelerateInterpolator();
    private float[] p = {0.0f, 0.0f};
    private float[] q = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] t = {0.0f, 0.0f};
    private float[] u = {0.0f, 0.0f};
    private float[] v = {Float.MAX_VALUE, Float.MAX_VALUE};

    private static class ClampedScroller {

        /* renamed from: a */
        private int f2174a;

        /* renamed from: b */
        private int f2175b;

        /* renamed from: c */
        private float f2176c;

        /* renamed from: d */
        private float f2177d;

        /* renamed from: j */
        private float f2183j;
        private int k;

        /* renamed from: e */
        private long f2178e = Long.MIN_VALUE;

        /* renamed from: i */
        private long f2182i = -1;

        /* renamed from: f */
        private long f2179f = 0;

        /* renamed from: g */
        private int f2180g = 0;

        /* renamed from: h */
        private int f2181h = 0;

        ClampedScroller() {
        }

        private float a(long j2) {
            if (j2 < this.f2178e) {
                return 0.0f;
            }
            long j3 = this.f2182i;
            if (j3 < 0 || j2 < j3) {
                return AutoScrollHelper.c((j2 - r0) / this.f2174a, 0.0f, 1.0f) * 0.5f;
            }
            float f2 = this.f2183j;
            return (1.0f - f2) + (f2 * AutoScrollHelper.c((j2 - j3) / this.k, 0.0f, 1.0f));
        }

        private float b(float f2) {
            return ((-4.0f) * f2 * f2) + (f2 * 4.0f);
        }

        public void computeScrollDelta() {
            if (this.f2179f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float b2 = b(a(currentAnimationTimeMillis));
            long j2 = currentAnimationTimeMillis - this.f2179f;
            this.f2179f = currentAnimationTimeMillis;
            float f2 = j2 * b2;
            this.f2180g = (int) (this.f2176c * f2);
            this.f2181h = (int) (f2 * this.f2177d);
        }

        public int getDeltaX() {
            return this.f2180g;
        }

        public int getDeltaY() {
            return this.f2181h;
        }

        public int getHorizontalDirection() {
            float f2 = this.f2176c;
            return (int) (f2 / Math.abs(f2));
        }

        public int getVerticalDirection() {
            float f2 = this.f2177d;
            return (int) (f2 / Math.abs(f2));
        }

        public boolean isFinished() {
            return this.f2182i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f2182i + ((long) this.k);
        }

        public void requestStop() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = AutoScrollHelper.d((int) (currentAnimationTimeMillis - this.f2178e), 0, this.f2175b);
            this.f2183j = a(currentAnimationTimeMillis);
            this.f2182i = currentAnimationTimeMillis;
        }

        public void setRampDownDuration(int i2) {
            this.f2175b = i2;
        }

        public void setRampUpDuration(int i2) {
            this.f2174a = i2;
        }

        public void setTargetVelocity(float f2, float f3) {
            this.f2176c = f2;
            this.f2177d = f3;
        }

        public void start() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2178e = currentAnimationTimeMillis;
            this.f2182i = -1L;
            this.f2179f = currentAnimationTimeMillis;
            this.f2183j = 0.5f;
            this.f2180g = 0;
            this.f2181h = 0;
        }
    }

    private class ScrollAnimationRunnable implements Runnable {
        ScrollAnimationRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
            if (autoScrollHelper.z) {
                if (autoScrollHelper.x) {
                    autoScrollHelper.x = false;
                    autoScrollHelper.l.start();
                }
                ClampedScroller clampedScroller = AutoScrollHelper.this.l;
                if (clampedScroller.isFinished() || !AutoScrollHelper.this.h()) {
                    AutoScrollHelper.this.z = false;
                    return;
                }
                AutoScrollHelper autoScrollHelper2 = AutoScrollHelper.this;
                if (autoScrollHelper2.y) {
                    autoScrollHelper2.y = false;
                    autoScrollHelper2.a();
                }
                clampedScroller.computeScrollDelta();
                AutoScrollHelper.this.scrollTargetBy(clampedScroller.getDeltaX(), clampedScroller.getDeltaY());
                ViewCompat.postOnAnimation(AutoScrollHelper.this.n, this);
            }
        }
    }

    public AutoScrollHelper(@NonNull View view) {
        this.n = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float f3 = (int) ((1575.0f * f2) + 0.5f);
        setMaximumVelocity(f3, f3);
        float f4 = (int) ((f2 * 315.0f) + 0.5f);
        setMinimumVelocity(f4, f4);
        setEdgeType(1);
        setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        setRelativeEdges(0.2f, 0.2f);
        setRelativeVelocity(1.0f, 1.0f);
        setActivationDelay(f2172i);
        setRampUpDuration(500);
        setRampDownDuration(500);
    }

    private float b(int i2, float f2, float f3, float f4) {
        float f5 = f(this.p[i2], f3, this.q[i2], f2);
        if (f5 == 0.0f) {
            return 0.0f;
        }
        float f6 = this.t[i2];
        float f7 = this.u[i2];
        float f8 = this.v[i2];
        float f9 = f6 * f4;
        return f5 > 0.0f ? c(f5 * f9, f7, f8) : -c((-f5) * f9, f7, f8);
    }

    static float c(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    static int d(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    private float e(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i2 = this.r;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f3) {
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f3);
                }
                if (this.z && i2 == 1) {
                    return 1.0f;
                }
            }
        } else if (i2 == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
        return 0.0f;
    }

    private float f(float f2, float f3, float f4, float f5) {
        float interpolation;
        float c2 = c(f2 * f3, 0.0f, f4);
        float e2 = e(f3 - f5, c2) - e(f5, c2);
        if (e2 < 0.0f) {
            interpolation = -this.m.getInterpolation(-e2);
        } else {
            if (e2 <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.m.getInterpolation(e2);
        }
        return c(interpolation, -1.0f, 1.0f);
    }

    private void g() {
        if (this.x) {
            this.z = false;
        } else {
            this.l.requestStop();
        }
    }

    private void i() {
        int i2;
        if (this.o == null) {
            this.o = new ScrollAnimationRunnable();
        }
        this.z = true;
        this.x = true;
        if (this.w || (i2 = this.s) <= 0) {
            this.o.run();
        } else {
            ViewCompat.postOnAnimationDelayed(this.n, this.o, i2);
        }
        this.w = true;
    }

    void a() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.n.onTouchEvent(obtain);
        obtain.recycle();
    }

    public abstract boolean canTargetScrollHorizontally(int i2);

    public abstract boolean canTargetScrollVertically(int i2);

    boolean h() {
        ClampedScroller clampedScroller = this.l;
        int verticalDirection = clampedScroller.getVerticalDirection();
        int horizontalDirection = clampedScroller.getHorizontalDirection();
        return (verticalDirection != 0 && canTargetScrollVertically(verticalDirection)) || (horizontalDirection != 0 && canTargetScrollHorizontally(horizontalDirection));
    }

    public boolean isEnabled() {
        return this.A;
    }

    public boolean isExclusive() {
        return this.B;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
    
        if (r0 != 3) goto L48;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.A
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.g()
            goto L58
        L1a:
            r5.y = r2
            r5.w = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.n
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.b(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.n
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.b(r2, r7, r6, r3)
            androidx.core.widget.AutoScrollHelper$ClampedScroller r7 = r5.l
            r7.setTargetVelocity(r0, r6)
            boolean r6 = r5.z
            if (r6 != 0) goto L58
            boolean r6 = r5.h()
            if (r6 == 0) goto L58
            r5.i()
        L58:
            boolean r6 = r5.B
            if (r6 == 0) goto L61
            boolean r6 = r5.z
            if (r6 == 0) goto L61
            r1 = 1
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public abstract void scrollTargetBy(int i2, int i3);

    @NonNull
    public AutoScrollHelper setActivationDelay(int i2) {
        this.s = i2;
        return this;
    }

    @NonNull
    public AutoScrollHelper setEdgeType(int i2) {
        this.r = i2;
        return this;
    }

    public AutoScrollHelper setEnabled(boolean z) {
        if (this.A && !z) {
            g();
        }
        this.A = z;
        return this;
    }

    public AutoScrollHelper setExclusive(boolean z) {
        this.B = z;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMaximumEdges(float f2, float f3) {
        float[] fArr = this.q;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMaximumVelocity(float f2, float f3) {
        float[] fArr = this.v;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMinimumVelocity(float f2, float f3) {
        float[] fArr = this.u;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    @NonNull
    public AutoScrollHelper setRampDownDuration(int i2) {
        this.l.setRampDownDuration(i2);
        return this;
    }

    @NonNull
    public AutoScrollHelper setRampUpDuration(int i2) {
        this.l.setRampUpDuration(i2);
        return this;
    }

    @NonNull
    public AutoScrollHelper setRelativeEdges(float f2, float f3) {
        float[] fArr = this.p;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    @NonNull
    public AutoScrollHelper setRelativeVelocity(float f2, float f3) {
        float[] fArr = this.t;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }
}
