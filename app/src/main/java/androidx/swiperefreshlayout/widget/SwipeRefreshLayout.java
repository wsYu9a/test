package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ListViewCompat;

/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static final int DEFAULT = 1;
    public static final int DEFAULT_SLINGSHOT_DISTANCE = -1;
    public static final int LARGE = 0;

    /* renamed from: a */
    @VisibleForTesting
    static final int f3657a = 40;

    /* renamed from: b */
    @VisibleForTesting
    static final int f3658b = 56;

    /* renamed from: d */
    private static final int f3660d = 255;

    /* renamed from: e */
    private static final int f3661e = 76;

    /* renamed from: f */
    private static final float f3662f = 2.0f;

    /* renamed from: g */
    private static final int f3663g = -1;

    /* renamed from: h */
    private static final float f3664h = 0.5f;

    /* renamed from: i */
    private static final float f3665i = 0.8f;

    /* renamed from: j */
    private static final int f3666j = 150;
    private static final int k = 300;
    private static final int l = 200;
    private static final int m = 200;
    private static final int n = -328966;
    private static final int o = 64;
    private boolean A;
    private int B;
    int C;
    private float D;
    private float E;
    private boolean F;
    private int G;
    boolean H;
    private boolean I;
    private final DecelerateInterpolator J;
    CircleImageView K;
    private int L;
    protected int M;
    float N;
    protected int O;
    int P;
    int Q;
    CircularProgressDrawable R;
    private Animation S;
    private Animation T;
    private Animation U;
    private Animation V;
    private Animation W;
    boolean a0;
    private int b0;
    boolean c0;
    private OnChildScrollUpCallback d0;
    private Animation.AnimationListener e0;
    private final Animation f0;
    private final Animation g0;
    private View q;
    OnRefreshListener r;
    boolean s;
    private int t;
    private float u;
    private float v;
    private final NestedScrollingParentHelper w;
    private final NestedScrollingChildHelper x;
    private final int[] y;
    private final int[] z;

    /* renamed from: c */
    private static final String f3659c = SwipeRefreshLayout.class.getSimpleName();
    private static final int[] p = {R.attr.enabled};

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$1 */
    class AnonymousClass1 implements Animation.AnimationListener {
        AnonymousClass1() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            OnRefreshListener onRefreshListener;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.s) {
                swipeRefreshLayout.j();
                return;
            }
            swipeRefreshLayout.R.setAlpha(255);
            SwipeRefreshLayout.this.R.start();
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            if (swipeRefreshLayout2.a0 && (onRefreshListener = swipeRefreshLayout2.r) != null) {
                onRefreshListener.onRefresh();
            }
            SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
            swipeRefreshLayout3.C = swipeRefreshLayout3.K.getTop();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$2 */
    class AnonymousClass2 extends Animation {
        AnonymousClass2() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f2);
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$3 */
    class AnonymousClass3 extends Animation {
        AnonymousClass3() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f2);
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$4 */
    class AnonymousClass4 extends Animation {

        /* renamed from: a */
        final /* synthetic */ int f3670a;

        /* renamed from: b */
        final /* synthetic */ int f3671b;

        AnonymousClass4(int i2, int i3) {
            i2 = i2;
            i3 = i3;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout.this.R.setAlpha((int) (i2 + ((i3 - r0) * f2)));
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$5 */
    class AnonymousClass5 implements Animation.AnimationListener {
        AnonymousClass5() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.H) {
                return;
            }
            swipeRefreshLayout.p(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$6 */
    class AnonymousClass6 extends Animation {
        AnonymousClass6() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            int abs = !swipeRefreshLayout.c0 ? swipeRefreshLayout.P - Math.abs(swipeRefreshLayout.O) : swipeRefreshLayout.P;
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((swipeRefreshLayout2.M + ((int) ((abs - r1) * f2))) - swipeRefreshLayout2.K.getTop());
            SwipeRefreshLayout.this.R.setArrowScale(1.0f - f2);
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$7 */
    class AnonymousClass7 extends Animation {
        AnonymousClass7() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout.this.h(f2);
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$8 */
    class AnonymousClass8 extends Animation {
        AnonymousClass8() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f3 = swipeRefreshLayout.N;
            swipeRefreshLayout.setAnimationProgress(f3 + ((-f3) * f2));
            SwipeRefreshLayout.this.h(f2);
        }
    }

    public interface OnChildScrollUpCallback {
        boolean canChildScrollUp(@NonNull SwipeRefreshLayout swipeRefreshLayout, @Nullable View view);
    }

    public interface OnRefreshListener {
        void onRefresh();
    }

    public SwipeRefreshLayout(@NonNull Context context) {
        this(context, null);
    }

    private void a(int i2, Animation.AnimationListener animationListener) {
        this.M = i2;
        this.f0.reset();
        this.f0.setDuration(200L);
        this.f0.setInterpolator(this.J);
        if (animationListener != null) {
            this.K.setAnimationListener(animationListener);
        }
        this.K.clearAnimation();
        this.K.startAnimation(this.f0);
    }

    private void b(int i2, Animation.AnimationListener animationListener) {
        if (this.H) {
            q(i2, animationListener);
            return;
        }
        this.M = i2;
        this.g0.reset();
        this.g0.setDuration(200L);
        this.g0.setInterpolator(this.J);
        if (animationListener != null) {
            this.K.setAnimationListener(animationListener);
        }
        this.K.clearAnimation();
        this.K.startAnimation(this.g0);
    }

    private void c() {
        this.K = new CircleImageView(getContext(), n);
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(getContext());
        this.R = circularProgressDrawable;
        circularProgressDrawable.setStyle(1);
        this.K.setImageDrawable(this.R);
        this.K.setVisibility(8);
        addView(this.K);
    }

    private void d() {
        if (this.q == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.K)) {
                    this.q = childAt;
                    return;
                }
            }
        }
    }

    private void e(float f2) {
        if (f2 > this.u) {
            k(true, true);
            return;
        }
        this.s = false;
        this.R.setStartEndTrim(0.0f, 0.0f);
        b(this.C, this.H ? null : new Animation.AnimationListener() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.5
            AnonymousClass5() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                if (swipeRefreshLayout.H) {
                    return;
                }
                swipeRefreshLayout.p(null);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.R.setArrowEnabled(false);
    }

    private boolean f(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void g(float f2) {
        this.R.setArrowEnabled(true);
        float min = Math.min(1.0f, Math.abs(f2 / this.u));
        double d2 = min;
        Double.isNaN(d2);
        float max = (((float) Math.max(d2 - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f2) - this.u;
        int i2 = this.Q;
        if (i2 <= 0) {
            i2 = this.c0 ? this.P - this.O : this.P;
        }
        float f3 = i2;
        double max2 = Math.max(0.0f, Math.min(abs, f3 * f3662f) / f3) / 4.0f;
        double pow = Math.pow(max2, 2.0d);
        Double.isNaN(max2);
        float f4 = ((float) (max2 - pow)) * f3662f;
        int i3 = this.O + ((int) ((f3 * min) + (f3 * f4 * f3662f)));
        if (this.K.getVisibility() != 0) {
            this.K.setVisibility(0);
        }
        if (!this.H) {
            this.K.setScaleX(1.0f);
            this.K.setScaleY(1.0f);
        }
        if (this.H) {
            setAnimationProgress(Math.min(1.0f, f2 / this.u));
        }
        if (f2 < this.u) {
            if (this.R.getAlpha() > 76 && !f(this.U)) {
                o();
            }
        } else if (this.R.getAlpha() < 255 && !f(this.V)) {
            n();
        }
        this.R.setStartEndTrim(0.0f, Math.min(f3665i, max * f3665i));
        this.R.setArrowScale(Math.min(1.0f, max));
        this.R.setProgressRotation((((max * 0.4f) - 0.25f) + (f4 * f3662f)) * 0.5f);
        setTargetOffsetTopAndBottom(i3 - this.C);
    }

    private void i(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.G) {
            this.G = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void k(boolean z, boolean z2) {
        if (this.s != z) {
            this.a0 = z2;
            d();
            this.s = z;
            if (z) {
                a(this.C, this.e0);
            } else {
                p(this.e0);
            }
        }
    }

    private Animation l(int i2, int i3) {
        AnonymousClass4 anonymousClass4 = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.4

            /* renamed from: a */
            final /* synthetic */ int f3670a;

            /* renamed from: b */
            final /* synthetic */ int f3671b;

            AnonymousClass4(int i22, int i32) {
                i2 = i22;
                i3 = i32;
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.R.setAlpha((int) (i2 + ((i3 - r0) * f2)));
            }
        };
        anonymousClass4.setDuration(300L);
        this.K.setAnimationListener(null);
        this.K.clearAnimation();
        this.K.startAnimation(anonymousClass4);
        return anonymousClass4;
    }

    private void m(float f2) {
        float f3 = this.E;
        float f4 = f2 - f3;
        int i2 = this.t;
        if (f4 <= i2 || this.F) {
            return;
        }
        this.D = f3 + i2;
        this.F = true;
        this.R.setAlpha(76);
    }

    private void n() {
        this.V = l(this.R.getAlpha(), 255);
    }

    private void o() {
        this.U = l(this.R.getAlpha(), 76);
    }

    private void q(int i2, Animation.AnimationListener animationListener) {
        this.M = i2;
        this.N = this.K.getScaleX();
        AnonymousClass8 anonymousClass8 = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.8
            AnonymousClass8() {
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                float f3 = swipeRefreshLayout.N;
                swipeRefreshLayout.setAnimationProgress(f3 + ((-f3) * f2));
                SwipeRefreshLayout.this.h(f2);
            }
        };
        this.W = anonymousClass8;
        anonymousClass8.setDuration(150L);
        if (animationListener != null) {
            this.K.setAnimationListener(animationListener);
        }
        this.K.clearAnimation();
        this.K.startAnimation(this.W);
    }

    private void r(Animation.AnimationListener animationListener) {
        this.K.setVisibility(0);
        this.R.setAlpha(255);
        AnonymousClass2 anonymousClass2 = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.2
            AnonymousClass2() {
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f2);
            }
        };
        this.S = anonymousClass2;
        anonymousClass2.setDuration(this.B);
        if (animationListener != null) {
            this.K.setAnimationListener(animationListener);
        }
        this.K.clearAnimation();
        this.K.startAnimation(this.S);
    }

    private void setColorViewAlpha(int i2) {
        this.K.getBackground().setAlpha(i2);
        this.R.setAlpha(i2);
    }

    public boolean canChildScrollUp() {
        OnChildScrollUpCallback onChildScrollUpCallback = this.d0;
        if (onChildScrollUpCallback != null) {
            return onChildScrollUpCallback.canChildScrollUp(this, this.q);
        }
        View view = this.q;
        return view instanceof ListView ? ListViewCompat.canScrollList((ListView) view, -1) : view.canScrollVertically(-1);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.x.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.x.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.x.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.x.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.L;
        return i4 < 0 ? i3 : i3 == i2 + (-1) ? i4 : i3 >= i4 ? i3 + 1 : i3;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.w.getNestedScrollAxes();
    }

    public int getProgressCircleDiameter() {
        return this.b0;
    }

    public int getProgressViewEndOffset() {
        return this.P;
    }

    public int getProgressViewStartOffset() {
        return this.O;
    }

    void h(float f2) {
        setTargetOffsetTopAndBottom((this.M + ((int) ((this.O - r0) * f2))) - this.K.getTop());
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.x.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.x.isNestedScrollingEnabled();
    }

    public boolean isRefreshing() {
        return this.s;
    }

    void j() {
        this.K.clearAnimation();
        this.R.stop();
        this.K.setVisibility(8);
        setColorViewAlpha(255);
        if (this.H) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.O - this.C);
        }
        this.C = this.K.getTop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        d();
        int actionMasked = motionEvent.getActionMasked();
        if (this.I && actionMasked == 0) {
            this.I = false;
        }
        if (!isEnabled() || this.I || canChildScrollUp() || this.s || this.A) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.G;
                    if (i2 == -1) {
                        Log.e(f3659c, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i2);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    m(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        i(motionEvent);
                    }
                }
            }
            this.F = false;
            this.G = -1;
        } else {
            setTargetOffsetTopAndBottom(this.O - this.K.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.G = pointerId;
            this.F = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.E = motionEvent.getY(findPointerIndex2);
        }
        return this.F;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.q == null) {
            d();
        }
        View view = this.q;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.K.getMeasuredWidth();
        int measuredHeight2 = this.K.getMeasuredHeight();
        int i6 = measuredWidth / 2;
        int i7 = measuredWidth2 / 2;
        int i8 = this.C;
        this.K.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.q == null) {
            d();
        }
        View view = this.q;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.K.measure(View.MeasureSpec.makeMeasureSpec(this.b0, 1073741824), View.MeasureSpec.makeMeasureSpec(this.b0, 1073741824));
        this.L = -1;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) == this.K) {
                this.L = i4;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f2 = this.v;
            if (f2 > 0.0f) {
                float f3 = i3;
                if (f3 > f2) {
                    iArr[1] = i3 - ((int) f2);
                    this.v = 0.0f;
                } else {
                    this.v = f2 - f3;
                    iArr[1] = i3;
                }
                g(this.v);
            }
        }
        if (this.c0 && i3 > 0 && this.v == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.K.setVisibility(8);
        }
        int[] iArr2 = this.y;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        dispatchNestedScroll(i2, i3, i4, i5, this.z);
        if (i5 + this.z[1] >= 0 || canChildScrollUp()) {
            return;
        }
        float abs = this.v + Math.abs(r11);
        this.v = abs;
        g(abs);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.w.onNestedScrollAccepted(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.v = 0.0f;
        this.A = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return (!isEnabled() || this.I || this.s || (i2 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.w.onStopNestedScroll(view);
        this.A = false;
        float f2 = this.v;
        if (f2 > 0.0f) {
            e(f2);
            this.v = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.I && actionMasked == 0) {
            this.I = false;
        }
        if (!isEnabled() || this.I || canChildScrollUp() || this.s || this.A) {
            return false;
        }
        if (actionMasked == 0) {
            this.G = motionEvent.getPointerId(0);
            this.F = false;
        } else {
            if (actionMasked == 1) {
                int findPointerIndex = motionEvent.findPointerIndex(this.G);
                if (findPointerIndex < 0) {
                    Log.e(f3659c, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.F) {
                    float y = (motionEvent.getY(findPointerIndex) - this.D) * 0.5f;
                    this.F = false;
                    e(y);
                }
                this.G = -1;
                return false;
            }
            if (actionMasked == 2) {
                int findPointerIndex2 = motionEvent.findPointerIndex(this.G);
                if (findPointerIndex2 < 0) {
                    Log.e(f3659c, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y2 = motionEvent.getY(findPointerIndex2);
                m(y2);
                if (this.F) {
                    float f2 = (y2 - this.D) * 0.5f;
                    if (f2 <= 0.0f) {
                        return false;
                    }
                    g(f2);
                }
            } else {
                if (actionMasked == 3) {
                    return false;
                }
                if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex < 0) {
                        Log.e(f3659c, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.G = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    i(motionEvent);
                }
            }
        }
        return true;
    }

    void p(Animation.AnimationListener animationListener) {
        AnonymousClass3 anonymousClass3 = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.3
            AnonymousClass3() {
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f2);
            }
        };
        this.T = anonymousClass3;
        anonymousClass3.setDuration(150L);
        this.K.setAnimationListener(animationListener);
        this.K.clearAnimation();
        this.K.startAnimation(this.T);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.q instanceof AbsListView)) {
            View view = this.q;
            if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    void setAnimationProgress(float f2) {
        this.K.setScaleX(f2);
        this.K.setScaleY(f2);
    }

    @Deprecated
    public void setColorScheme(@ColorRes int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(@ColorInt int... iArr) {
        d();
        this.R.setColorSchemeColors(iArr);
    }

    public void setColorSchemeResources(@ColorRes int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = ContextCompat.getColor(context, iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i2) {
        this.u = i2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            return;
        }
        j();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.x.setNestedScrollingEnabled(z);
    }

    public void setOnChildScrollUpCallback(@Nullable OnChildScrollUpCallback onChildScrollUpCallback) {
        this.d0 = onChildScrollUpCallback;
    }

    public void setOnRefreshListener(@Nullable OnRefreshListener onRefreshListener) {
        this.r = onRefreshListener;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeColor(@ColorInt int i2) {
        this.K.setBackgroundColor(i2);
    }

    public void setProgressBackgroundColorSchemeResource(@ColorRes int i2) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), i2));
    }

    public void setProgressViewEndTarget(boolean z, int i2) {
        this.P = i2;
        this.H = z;
        this.K.invalidate();
    }

    public void setProgressViewOffset(boolean z, int i2, int i3) {
        this.H = z;
        this.O = i2;
        this.P = i3;
        this.c0 = true;
        j();
        this.s = false;
    }

    public void setRefreshing(boolean z) {
        if (!z || this.s == z) {
            k(z, false);
            return;
        }
        this.s = z;
        setTargetOffsetTopAndBottom((!this.c0 ? this.P + this.O : this.P) - this.C);
        this.a0 = false;
        r(this.e0);
    }

    public void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i2 == 0) {
                this.b0 = (int) (displayMetrics.density * 56.0f);
            } else {
                this.b0 = (int) (displayMetrics.density * 40.0f);
            }
            this.K.setImageDrawable(null);
            this.R.setStyle(i2);
            this.K.setImageDrawable(this.R);
        }
    }

    public void setSlingshotDistance(@Px int i2) {
        this.Q = i2;
    }

    void setTargetOffsetTopAndBottom(int i2) {
        this.K.bringToFront();
        ViewCompat.offsetTopAndBottom(this.K, i2);
        this.C = this.K.getTop();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        return this.x.startNestedScroll(i2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.x.stopNestedScroll();
    }

    public SwipeRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = false;
        this.u = -1.0f;
        this.y = new int[2];
        this.z = new int[2];
        this.G = -1;
        this.L = -1;
        this.e0 = new Animation.AnimationListener() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.1
            AnonymousClass1() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                OnRefreshListener onRefreshListener;
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                if (!swipeRefreshLayout.s) {
                    swipeRefreshLayout.j();
                    return;
                }
                swipeRefreshLayout.R.setAlpha(255);
                SwipeRefreshLayout.this.R.start();
                SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                if (swipeRefreshLayout2.a0 && (onRefreshListener = swipeRefreshLayout2.r) != null) {
                    onRefreshListener.onRefresh();
                }
                SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
                swipeRefreshLayout3.C = swipeRefreshLayout3.K.getTop();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        };
        this.f0 = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.6
            AnonymousClass6() {
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                int abs = !swipeRefreshLayout.c0 ? swipeRefreshLayout.P - Math.abs(swipeRefreshLayout.O) : swipeRefreshLayout.P;
                SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((swipeRefreshLayout2.M + ((int) ((abs - r1) * f2))) - swipeRefreshLayout2.K.getTop());
                SwipeRefreshLayout.this.R.setArrowScale(1.0f - f2);
            }
        };
        this.g0 = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.7
            AnonymousClass7() {
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.h(f2);
            }
        };
        this.t = ViewConfiguration.get(context).getScaledTouchSlop();
        this.B = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.J = new DecelerateInterpolator(f3662f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.b0 = (int) (displayMetrics.density * 40.0f);
        c();
        setChildrenDrawingOrderEnabled(true);
        int i2 = (int) (displayMetrics.density * 64.0f);
        this.P = i2;
        this.u = i2;
        this.w = new NestedScrollingParentHelper(this);
        this.x = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i3 = -this.b0;
        this.C = i3;
        this.O = i3;
        h(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }
}
