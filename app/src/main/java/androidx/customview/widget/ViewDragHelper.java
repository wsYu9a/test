package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ViewDragHelper {
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;

    /* renamed from: a */
    private static final String f2250a = "ViewDragHelper";

    /* renamed from: b */
    private static final int f2251b = 20;

    /* renamed from: c */
    private static final int f2252c = 256;

    /* renamed from: d */
    private static final int f2253d = 600;

    /* renamed from: e */
    private static final Interpolator f2254e = new Interpolator() { // from class: androidx.customview.widget.ViewDragHelper.1
        AnonymousClass1() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private final ViewGroup A;

    /* renamed from: f */
    private int f2255f;

    /* renamed from: g */
    private int f2256g;

    /* renamed from: i */
    private float[] f2258i;

    /* renamed from: j */
    private float[] f2259j;
    private float[] k;
    private float[] l;
    private int[] m;
    private int[] n;
    private int[] o;
    private int p;
    private VelocityTracker q;
    private float r;
    private float s;
    private int t;
    private final int u;
    private int v;
    private OverScroller w;
    private final Callback x;
    private View y;
    private boolean z;

    /* renamed from: h */
    private int f2257h = -1;
    private final Runnable B = new Runnable() { // from class: androidx.customview.widget.ViewDragHelper.2
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper.this.u(0);
        }
    };

    /* renamed from: androidx.customview.widget.ViewDragHelper$1 */
    class AnonymousClass1 implements Interpolator {
        AnonymousClass1() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    /* renamed from: androidx.customview.widget.ViewDragHelper$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper.this.u(0);
        }
    }

    public static abstract class Callback {
        public int clampViewPositionHorizontal(@NonNull View view, int i2, int i3) {
            return 0;
        }

        public int clampViewPositionVertical(@NonNull View view, int i2, int i3) {
            return 0;
        }

        public int getOrderedChildIndex(int i2) {
            return i2;
        }

        public int getViewHorizontalDragRange(@NonNull View view) {
            return 0;
        }

        public int getViewVerticalDragRange(@NonNull View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i2, int i3) {
        }

        public boolean onEdgeLock(int i2) {
            return false;
        }

        public void onEdgeTouched(int i2, int i3) {
        }

        public void onViewCaptured(@NonNull View view, int i2) {
        }

        public void onViewDragStateChanged(int i2) {
        }

        public void onViewPositionChanged(@NonNull View view, int i2, int i3, @Px int i4, @Px int i5) {
        }

        public void onViewReleased(@NonNull View view, float f2, float f3) {
        }

        public abstract boolean tryCaptureView(@NonNull View view, int i2);
    }

    private ViewDragHelper(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (callback == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.A = viewGroup;
        this.x = callback;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i2 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.u = i2;
        this.t = i2;
        this.f2256g = viewConfiguration.getScaledTouchSlop();
        this.r = viewConfiguration.getScaledMaximumFlingVelocity();
        this.s = viewConfiguration.getScaledMinimumFlingVelocity();
        this.w = new OverScroller(context, f2254e);
    }

    private boolean b(float f2, float f3, int i2, int i3) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.m[i2] & i3) != i3 || (this.v & i3) == 0 || (this.o[i2] & i3) == i3 || (this.n[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.f2256g;
        if (abs <= i4 && abs2 <= i4) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.x.onEdgeLock(i3)) {
            return (this.n[i2] & i3) == 0 && abs > ((float) this.f2256g);
        }
        int[] iArr = this.o;
        iArr[i2] = iArr[i2] | i3;
        return false;
    }

    private boolean c(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z = this.x.getViewHorizontalDragRange(view) > 0;
        boolean z2 = this.x.getViewVerticalDragRange(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f2) > ((float) this.f2256g) : z2 && Math.abs(f3) > ((float) this.f2256g);
        }
        float f4 = (f2 * f2) + (f3 * f3);
        int i2 = this.f2256g;
        return f4 > ((float) (i2 * i2));
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private float d(float f2, float f3, float f4) {
        float abs = Math.abs(f2);
        if (abs < f3) {
            return 0.0f;
        }
        return abs > f4 ? f2 > 0.0f ? f4 : -f4 : f2;
    }

    private int e(int i2, int i3, int i4) {
        int abs = Math.abs(i2);
        if (abs < i3) {
            return 0;
        }
        return abs > i4 ? i2 > 0 ? i4 : -i4 : i2;
    }

    private void f() {
        float[] fArr = this.f2258i;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f2259j, 0.0f);
        Arrays.fill(this.k, 0.0f);
        Arrays.fill(this.l, 0.0f);
        Arrays.fill(this.m, 0);
        Arrays.fill(this.n, 0);
        Arrays.fill(this.o, 0);
        this.p = 0;
    }

    private void g(int i2) {
        if (this.f2258i == null || !isPointerDown(i2)) {
            return;
        }
        this.f2258i[i2] = 0.0f;
        this.f2259j[i2] = 0.0f;
        this.k[i2] = 0.0f;
        this.l[i2] = 0.0f;
        this.m[i2] = 0;
        this.n[i2] = 0;
        this.o[i2] = 0;
        this.p = ((1 << i2) ^ (-1)) & this.p;
    }

    private int h(int i2, int i3, int i4) {
        if (i2 == 0) {
            return 0;
        }
        int width = this.A.getWidth();
        float f2 = width / 2;
        float k = f2 + (k(Math.min(1.0f, Math.abs(i2) / width)) * f2);
        int abs = Math.abs(i3);
        return Math.min(abs > 0 ? Math.round(Math.abs(k / abs) * 1000.0f) * 4 : (int) (((Math.abs(i2) / i4) + 1.0f) * 256.0f), f2253d);
    }

    private int i(View view, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int e2 = e(i4, (int) this.s, (int) this.r);
        int e3 = e(i5, (int) this.s, (int) this.r);
        int abs = Math.abs(i2);
        int abs2 = Math.abs(i3);
        int abs3 = Math.abs(e2);
        int abs4 = Math.abs(e3);
        int i6 = abs3 + abs4;
        int i7 = abs + abs2;
        if (e2 != 0) {
            f2 = abs3;
            f3 = i6;
        } else {
            f2 = abs;
            f3 = i7;
        }
        float f6 = f2 / f3;
        if (e3 != 0) {
            f4 = abs4;
            f5 = i6;
        } else {
            f4 = abs2;
            f5 = i7;
        }
        return (int) ((h(i2, e2, this.x.getViewHorizontalDragRange(view)) * f6) + (h(i3, e3, this.x.getViewVerticalDragRange(view)) * (f4 / f5)));
    }

    private void j(float f2, float f3) {
        this.z = true;
        this.x.onViewReleased(this.y, f2, f3);
        this.z = false;
        if (this.f2255f == 1) {
            u(0);
        }
    }

    private float k(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    private void l(int i2, int i3, int i4, int i5) {
        int left = this.y.getLeft();
        int top = this.y.getTop();
        if (i4 != 0) {
            i2 = this.x.clampViewPositionHorizontal(this.y, i2, i4);
            ViewCompat.offsetLeftAndRight(this.y, i2 - left);
        }
        int i6 = i2;
        if (i5 != 0) {
            i3 = this.x.clampViewPositionVertical(this.y, i3, i5);
            ViewCompat.offsetTopAndBottom(this.y, i3 - top);
        }
        int i7 = i3;
        if (i4 == 0 && i5 == 0) {
            return;
        }
        this.x.onViewPositionChanged(this.y, i6, i7, i6 - left, i7 - top);
    }

    private void m(int i2) {
        float[] fArr = this.f2258i;
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
                float[] fArr6 = this.f2259j;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.k;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.l;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.m;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.n;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.o;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f2258i = fArr2;
            this.f2259j = fArr3;
            this.k = fArr4;
            this.l = fArr5;
            this.m = iArr;
            this.n = iArr2;
            this.o = iArr3;
        }
    }

    private boolean n(int i2, int i3, int i4, int i5) {
        int left = this.y.getLeft();
        int top = this.y.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.w.abortAnimation();
            u(0);
            return false;
        }
        this.w.startScroll(left, top, i6, i7, i(this.y, i6, i7, i4, i5));
        u(2);
        return true;
    }

    private int o(int i2, int i3) {
        int i4 = i2 < this.A.getLeft() + this.t ? 1 : 0;
        if (i3 < this.A.getTop() + this.t) {
            i4 |= 4;
        }
        if (i2 > this.A.getRight() - this.t) {
            i4 |= 2;
        }
        return i3 > this.A.getBottom() - this.t ? i4 | 8 : i4;
    }

    private boolean p(int i2) {
        if (isPointerDown(i2)) {
            return true;
        }
        Log.e(f2250a, "Ignoring pointerId=" + i2 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void q() {
        this.q.computeCurrentVelocity(1000, this.r);
        j(d(this.q.getXVelocity(this.f2257h), this.s, this.r), d(this.q.getYVelocity(this.f2257h), this.s, this.r));
    }

    private void r(float f2, float f3, int i2) {
        int i3 = b(f2, f3, i2, 1) ? 1 : 0;
        if (b(f3, f2, i2, 4)) {
            i3 |= 4;
        }
        if (b(f2, f3, i2, 2)) {
            i3 |= 2;
        }
        if (b(f3, f2, i2, 8)) {
            i3 |= 8;
        }
        if (i3 != 0) {
            int[] iArr = this.n;
            iArr[i2] = iArr[i2] | i3;
            this.x.onEdgeDragStarted(i3, i2);
        }
    }

    private void s(float f2, float f3, int i2) {
        m(i2);
        float[] fArr = this.f2258i;
        this.k[i2] = f2;
        fArr[i2] = f2;
        float[] fArr2 = this.f2259j;
        this.l[i2] = f3;
        fArr2[i2] = f3;
        this.m[i2] = o((int) f2, (int) f3);
        this.p |= 1 << i2;
    }

    private void t(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            if (p(pointerId)) {
                float x = motionEvent.getX(i2);
                float y = motionEvent.getY(i2);
                this.k[pointerId] = x;
                this.l[pointerId] = y;
            }
        }
    }

    protected boolean a(@NonNull View view, boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i7 = i4 + scrollX;
                if (i7 >= childAt.getLeft() && i7 < childAt.getRight() && (i6 = i5 + scrollY) >= childAt.getTop() && i6 < childAt.getBottom() && a(childAt, true, i2, i3, i7 - childAt.getLeft(), i6 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && (view.canScrollHorizontally(-i2) || view.canScrollVertically(-i3));
    }

    public void abort() {
        cancel();
        if (this.f2255f == 2) {
            int currX = this.w.getCurrX();
            int currY = this.w.getCurrY();
            this.w.abortAnimation();
            int currX2 = this.w.getCurrX();
            int currY2 = this.w.getCurrY();
            this.x.onViewPositionChanged(this.y, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        u(0);
    }

    public void cancel() {
        this.f2257h = -1;
        f();
        VelocityTracker velocityTracker = this.q;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.q = null;
        }
    }

    public void captureChildView(@NonNull View view, int i2) {
        if (view.getParent() == this.A) {
            this.y = view;
            this.f2257h = i2;
            this.x.onViewCaptured(view, i2);
            u(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.A + ")");
    }

    public boolean checkTouchSlop(int i2) {
        int length = this.f2258i.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (checkTouchSlop(i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public boolean continueSettling(boolean z) {
        if (this.f2255f == 2) {
            boolean computeScrollOffset = this.w.computeScrollOffset();
            int currX = this.w.getCurrX();
            int currY = this.w.getCurrY();
            int left = currX - this.y.getLeft();
            int top = currY - this.y.getTop();
            if (left != 0) {
                ViewCompat.offsetLeftAndRight(this.y, left);
            }
            if (top != 0) {
                ViewCompat.offsetTopAndBottom(this.y, top);
            }
            if (left != 0 || top != 0) {
                this.x.onViewPositionChanged(this.y, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.w.getFinalX() && currY == this.w.getFinalY()) {
                this.w.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.A.post(this.B);
                } else {
                    u(0);
                }
            }
        }
        return this.f2255f == 2;
    }

    @Nullable
    public View findTopChildUnder(int i2, int i3) {
        for (int childCount = this.A.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.A.getChildAt(this.x.getOrderedChildIndex(childCount));
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i2, int i3, int i4, int i5) {
        if (!this.z) {
            throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        }
        this.w.fling(this.y.getLeft(), this.y.getTop(), (int) this.q.getXVelocity(this.f2257h), (int) this.q.getYVelocity(this.f2257h), i2, i4, i3, i5);
        u(2);
    }

    public int getActivePointerId() {
        return this.f2257h;
    }

    @Nullable
    public View getCapturedView() {
        return this.y;
    }

    @Px
    public int getDefaultEdgeSize() {
        return this.u;
    }

    @Px
    public int getEdgeSize() {
        return this.t;
    }

    public float getMinVelocity() {
        return this.s;
    }

    @Px
    public int getTouchSlop() {
        return this.f2256g;
    }

    public int getViewDragState() {
        return this.f2255f;
    }

    public boolean isCapturedViewUnder(int i2, int i3) {
        return isViewUnder(this.y, i2, i3);
    }

    public boolean isEdgeTouched(int i2) {
        int length = this.m.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (isEdgeTouched(i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPointerDown(int i2) {
        return ((1 << i2) & this.p) != 0;
    }

    public boolean isViewUnder(@Nullable View view, int i2, int i3) {
        return view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom();
    }

    public void processTouchEvent(@NonNull MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.q == null) {
            this.q = VelocityTracker.obtain();
        }
        this.q.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View findTopChildUnder = findTopChildUnder((int) x, (int) y);
            s(x, y, pointerId);
            v(findTopChildUnder, pointerId);
            int i4 = this.m[pointerId];
            int i5 = this.v;
            if ((i4 & i5) != 0) {
                this.x.onEdgeTouched(i4 & i5, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f2255f == 1) {
                q();
            }
            cancel();
            return;
        }
        if (actionMasked == 2) {
            if (this.f2255f == 1) {
                if (p(this.f2257h)) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f2257h);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.k;
                    int i6 = this.f2257h;
                    int i7 = (int) (x2 - fArr[i6]);
                    int i8 = (int) (y2 - this.l[i6]);
                    l(this.y.getLeft() + i7, this.y.getTop() + i8, i7, i8);
                    t(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i3 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i3);
                if (p(pointerId2)) {
                    float x3 = motionEvent.getX(i3);
                    float y3 = motionEvent.getY(i3);
                    float f2 = x3 - this.f2258i[pointerId2];
                    float f3 = y3 - this.f2259j[pointerId2];
                    r(f2, f3, pointerId2);
                    if (this.f2255f != 1) {
                        View findTopChildUnder2 = findTopChildUnder((int) x3, (int) y3);
                        if (c(findTopChildUnder2, f2, f3) && v(findTopChildUnder2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i3++;
            }
            t(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f2255f == 1) {
                j(0.0f, 0.0f);
            }
            cancel();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x4 = motionEvent.getX(actionIndex);
            float y4 = motionEvent.getY(actionIndex);
            s(x4, y4, pointerId3);
            if (this.f2255f != 0) {
                if (isCapturedViewUnder((int) x4, (int) y4)) {
                    v(this.y, pointerId3);
                    return;
                }
                return;
            } else {
                v(findTopChildUnder((int) x4, (int) y4), pointerId3);
                int i9 = this.m[pointerId3];
                int i10 = this.v;
                if ((i9 & i10) != 0) {
                    this.x.onEdgeTouched(i9 & i10, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f2255f == 1 && pointerId4 == this.f2257h) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i3 >= pointerCount2) {
                    i2 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i3);
                if (pointerId5 != this.f2257h) {
                    View findTopChildUnder3 = findTopChildUnder((int) motionEvent.getX(i3), (int) motionEvent.getY(i3));
                    View view = this.y;
                    if (findTopChildUnder3 == view && v(view, pointerId5)) {
                        i2 = this.f2257h;
                        break;
                    }
                }
                i3++;
            }
            if (i2 == -1) {
                q();
            }
        }
        g(pointerId4);
    }

    public void setEdgeSize(@IntRange(from = 0) @Px int i2) {
        this.t = i2;
    }

    public void setEdgeTrackingEnabled(int i2) {
        this.v = i2;
    }

    public void setMinVelocity(float f2) {
        this.s = f2;
    }

    public boolean settleCapturedViewAt(int i2, int i3) {
        if (this.z) {
            return n(i2, i3, (int) this.q.getXVelocity(this.f2257h), (int) this.q.getYVelocity(this.f2257h));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00dd, code lost:
    
        if (r12 != r11) goto L139;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean shouldInterceptTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.shouldInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean smoothSlideViewTo(@NonNull View view, int i2, int i3) {
        this.y = view;
        this.f2257h = -1;
        boolean n = n(i2, i3, 0, 0);
        if (!n && this.f2255f == 0 && this.y != null) {
            this.y = null;
        }
        return n;
    }

    void u(int i2) {
        this.A.removeCallbacks(this.B);
        if (this.f2255f != i2) {
            this.f2255f = i2;
            this.x.onViewDragStateChanged(i2);
            if (this.f2255f == 0) {
                this.y = null;
            }
        }
    }

    boolean v(View view, int i2) {
        if (view == this.y && this.f2257h == i2) {
            return true;
        }
        if (view == null || !this.x.tryCaptureView(view, i2)) {
            return false;
        }
        this.f2257h = i2;
        captureChildView(view, i2);
        return true;
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, float f2, @NonNull Callback callback) {
        ViewDragHelper create = create(viewGroup, callback);
        create.f2256g = (int) (create.f2256g * (1.0f / f2));
        return create;
    }

    public boolean checkTouchSlop(int i2, int i3) {
        if (!isPointerDown(i3)) {
            return false;
        }
        boolean z = (i2 & 1) == 1;
        boolean z2 = (i2 & 2) == 2;
        float f2 = this.k[i3] - this.f2258i[i3];
        float f3 = this.l[i3] - this.f2259j[i3];
        if (!z || !z2) {
            return z ? Math.abs(f2) > ((float) this.f2256g) : z2 && Math.abs(f3) > ((float) this.f2256g);
        }
        float f4 = (f2 * f2) + (f3 * f3);
        int i4 = this.f2256g;
        return f4 > ((float) (i4 * i4));
    }

    public boolean isEdgeTouched(int i2, int i3) {
        return isPointerDown(i3) && (i2 & this.m[i3]) != 0;
    }
}
