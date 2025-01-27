package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {

    /* renamed from: d */
    private static final int f6687d = -1;

    /* renamed from: e */
    @Nullable
    private Runnable f6688e;

    /* renamed from: f */
    OverScroller f6689f;

    /* renamed from: g */
    private boolean f6690g;

    /* renamed from: h */
    private int f6691h;

    /* renamed from: i */
    private int f6692i;

    /* renamed from: j */
    private int f6693j;

    @Nullable
    private VelocityTracker k;

    private class a implements Runnable {

        /* renamed from: a */
        private final CoordinatorLayout f6694a;

        /* renamed from: b */
        private final V f6695b;

        a(CoordinatorLayout coordinatorLayout, V v) {
            this.f6694a = coordinatorLayout;
            this.f6695b = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f6695b == null || (overScroller = HeaderBehavior.this.f6689f) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                HeaderBehavior.this.p(this.f6694a, this.f6695b);
                return;
            }
            HeaderBehavior headerBehavior = HeaderBehavior.this;
            headerBehavior.r(this.f6694a, this.f6695b, headerBehavior.f6689f.getCurrY());
            ViewCompat.postOnAnimation(this.f6695b, this);
        }
    }

    public HeaderBehavior() {
        this.f6691h = -1;
        this.f6693j = -1;
    }

    private void k() {
        if (this.k == null) {
            this.k = VelocityTracker.obtain();
        }
    }

    boolean j(V v) {
        return false;
    }

    final boolean l(CoordinatorLayout coordinatorLayout, @NonNull V v, int i2, int i3, float f2) {
        Runnable runnable = this.f6688e;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.f6688e = null;
        }
        if (this.f6689f == null) {
            this.f6689f = new OverScroller(v.getContext());
        }
        this.f6689f.fling(0, b(), 0, Math.round(f2), 0, 0, i2, i3);
        if (!this.f6689f.computeScrollOffset()) {
            p(coordinatorLayout, v);
            return false;
        }
        a aVar = new a(coordinatorLayout, v);
        this.f6688e = aVar;
        ViewCompat.postOnAnimation(v, aVar);
        return true;
    }

    int m(@NonNull V v) {
        return -v.getHeight();
    }

    int n(@NonNull V v) {
        return v.getHeight();
    }

    int o() {
        return b();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.f6693j < 0) {
            this.f6693j = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f6690g) {
            int i2 = this.f6691h;
            if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y - this.f6692i) > this.f6693j) {
                this.f6692i = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f6691h = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            boolean z = j(v) && coordinatorLayout.isPointInChildBounds(v, x, y2);
            this.f6690g = z;
            if (z) {
                this.f6692i = y2;
                this.f6691h = motionEvent.getPointerId(0);
                k();
                OverScroller overScroller = this.f6689f;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f6689f.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.k;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007b  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r12, @androidx.annotation.NonNull V r13, @androidx.annotation.NonNull android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r14.getActionMasked()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L4e
            r4 = 2
            if (r0 == r4) goto L2d
            r12 = 3
            if (r0 == r12) goto L72
            r12 = 6
            if (r0 == r12) goto L13
            goto L4c
        L13:
            int r12 = r14.getActionIndex()
            if (r12 != 0) goto L1b
            r12 = 1
            goto L1c
        L1b:
            r12 = 0
        L1c:
            int r13 = r14.getPointerId(r12)
            r11.f6691h = r13
            float r12 = r14.getY(r12)
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            int r12 = (int) r12
            r11.f6692i = r12
            goto L4c
        L2d:
            int r0 = r11.f6691h
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r1) goto L36
            return r3
        L36:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r1 = r11.f6692i
            int r7 = r1 - r0
            r11.f6692i = r0
            int r8 = r11.m(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.q(r5, r6, r7, r8, r9)
        L4c:
            r12 = 0
            goto L81
        L4e:
            android.view.VelocityTracker r0 = r11.k
            if (r0 == 0) goto L72
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.k
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.k
            int r4 = r11.f6691h
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.n(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.l(r6, r7, r8, r9, r10)
            r12 = 1
            goto L73
        L72:
            r12 = 0
        L73:
            r11.f6690g = r3
            r11.f6691h = r1
            android.view.VelocityTracker r13 = r11.k
            if (r13 == 0) goto L81
            r13.recycle()
            r13 = 0
            r11.k = r13
        L81:
            android.view.VelocityTracker r13 = r11.k
            if (r13 == 0) goto L88
            r13.addMovement(r14)
        L88:
            boolean r13 = r11.f6690g
            if (r13 != 0) goto L90
            if (r12 == 0) goto L8f
            goto L90
        L8f:
            r2 = 0
        L90:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    void p(CoordinatorLayout coordinatorLayout, V v) {
    }

    final int q(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        return s(coordinatorLayout, v, o() - i2, i3, i4);
    }

    int r(CoordinatorLayout coordinatorLayout, V v, int i2) {
        return s(coordinatorLayout, v, i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int s(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        int clamp;
        int b2 = b();
        if (i3 == 0 || b2 < i3 || b2 > i4 || b2 == (clamp = MathUtils.clamp(i2, i3, i4))) {
            return 0;
        }
        h(clamp);
        return b2 - clamp;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6691h = -1;
        this.f6693j = -1;
    }
}
