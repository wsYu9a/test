package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

@VisibleForTesting
/* loaded from: classes.dex */
class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {

    /* renamed from: a */
    private static final int f3256a = 0;

    /* renamed from: b */
    private static final int f3257b = 1;

    /* renamed from: c */
    private static final int f3258c = 2;

    /* renamed from: d */
    private static final int f3259d = 0;

    /* renamed from: e */
    private static final int f3260e = 1;

    /* renamed from: f */
    private static final int f3261f = 2;

    /* renamed from: g */
    private static final int f3262g = 0;

    /* renamed from: h */
    private static final int f3263h = 1;

    /* renamed from: i */
    private static final int f3264i = 2;

    /* renamed from: j */
    private static final int f3265j = 3;
    private static final int k = 500;
    private static final int l = 1500;
    private static final int m = 1200;
    private static final int n = 500;
    private static final int o = 255;
    private static final int[] p = {R.attr.state_pressed};
    private static final int[] q = new int[0];
    private final int A;

    @VisibleForTesting
    int B;

    @VisibleForTesting
    int C;

    @VisibleForTesting
    float D;

    @VisibleForTesting
    int E;

    @VisibleForTesting
    int F;

    @VisibleForTesting
    float G;
    private RecyclerView J;
    final ValueAnimator Q;
    int R;
    private final Runnable S;
    private final RecyclerView.OnScrollListener T;
    private final int r;
    private final int s;
    final StateListDrawable t;
    final Drawable u;
    private final int v;
    private final int w;
    private final StateListDrawable x;
    private final Drawable y;
    private final int z;
    private int H = 0;
    private int I = 0;
    private boolean K = false;
    private boolean L = false;
    private int M = 0;
    private int N = 0;
    private final int[] O = new int[2];
    private final int[] P = new int[2];

    /* renamed from: androidx.recyclerview.widget.FastScroller$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FastScroller.this.k(500);
        }
    }

    /* renamed from: androidx.recyclerview.widget.FastScroller$2 */
    class AnonymousClass2 extends RecyclerView.OnScrollListener {
        AnonymousClass2() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            FastScroller.this.v(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    private class AnimatorListener extends AnimatorListenerAdapter {

        /* renamed from: a */
        private boolean f3268a = false;

        AnimatorListener() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3268a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f3268a) {
                this.f3268a = false;
                return;
            }
            if (((Float) FastScroller.this.Q.getAnimatedValue()).floatValue() == 0.0f) {
                FastScroller fastScroller = FastScroller.this;
                fastScroller.R = 0;
                fastScroller.t(0);
            } else {
                FastScroller fastScroller2 = FastScroller.this;
                fastScroller2.R = 2;
                fastScroller2.q();
            }
        }
    }

    private class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        AnimatorUpdater() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller.this.t.setAlpha(floatValue);
            FastScroller.this.u.setAlpha(floatValue);
            FastScroller.this.q();
        }
    }

    FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.Q = ofFloat;
        this.R = 0;
        this.S = new Runnable() { // from class: androidx.recyclerview.widget.FastScroller.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                FastScroller.this.k(500);
            }
        };
        this.T = new RecyclerView.OnScrollListener() { // from class: androidx.recyclerview.widget.FastScroller.2
            AnonymousClass2() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i22, int i32) {
                FastScroller.this.v(recyclerView2.computeHorizontalScrollOffset(), recyclerView2.computeVerticalScrollOffset());
            }
        };
        this.t = stateListDrawable;
        this.u = drawable;
        this.x = stateListDrawable2;
        this.y = drawable2;
        this.v = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.w = Math.max(i2, drawable.getIntrinsicWidth());
        this.z = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.A = Math.max(i2, drawable2.getIntrinsicWidth());
        this.r = i3;
        this.s = i4;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new AnimatorListener());
        ofFloat.addUpdateListener(new AnimatorUpdater());
        attachToRecyclerView(recyclerView);
    }

    private void a() {
        this.J.removeCallbacks(this.S);
    }

    private void b() {
        this.J.removeItemDecoration(this);
        this.J.removeOnItemTouchListener(this);
        this.J.removeOnScrollListener(this.T);
        a();
    }

    private void c(Canvas canvas) {
        int i2 = this.I;
        int i3 = this.z;
        int i4 = this.F;
        int i5 = this.E;
        this.x.setBounds(0, 0, i5, i3);
        this.y.setBounds(0, 0, this.H, this.A);
        canvas.translate(0.0f, i2 - i3);
        this.y.draw(canvas);
        canvas.translate(i4 - (i5 / 2), 0.0f);
        this.x.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    private void d(Canvas canvas) {
        int i2 = this.H;
        int i3 = this.v;
        int i4 = i2 - i3;
        int i5 = this.C;
        int i6 = this.B;
        int i7 = i5 - (i6 / 2);
        this.t.setBounds(0, 0, i3, i6);
        this.u.setBounds(0, 0, this.w, this.I);
        if (!m()) {
            canvas.translate(i4, 0.0f);
            this.u.draw(canvas);
            canvas.translate(0.0f, i7);
            this.t.draw(canvas);
            canvas.translate(-i4, -i7);
            return;
        }
        this.u.draw(canvas);
        canvas.translate(this.v, i7);
        canvas.scale(-1.0f, 1.0f);
        this.t.draw(canvas);
        canvas.scale(1.0f, 1.0f);
        canvas.translate(-this.v, -i7);
    }

    private int[] e() {
        int[] iArr = this.P;
        int i2 = this.s;
        iArr[0] = i2;
        iArr[1] = this.H - i2;
        return iArr;
    }

    private int[] h() {
        int[] iArr = this.O;
        int i2 = this.s;
        iArr[0] = i2;
        iArr[1] = this.I - i2;
        return iArr;
    }

    private void l(float f2) {
        int[] e2 = e();
        float max = Math.max(e2[0], Math.min(e2[1], f2));
        if (Math.abs(this.F - max) < 2.0f) {
            return;
        }
        int s = s(this.G, max, e2, this.J.computeHorizontalScrollRange(), this.J.computeHorizontalScrollOffset(), this.H);
        if (s != 0) {
            this.J.scrollBy(s, 0);
        }
        this.G = max;
    }

    private boolean m() {
        return ViewCompat.getLayoutDirection(this.J) == 1;
    }

    private void r(int i2) {
        a();
        this.J.postDelayed(this.S, i2);
    }

    private int s(float f2, float f3, int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 == 0) {
            return 0;
        }
        int i6 = i2 - i4;
        int i7 = (int) (((f3 - f2) / i5) * i6);
        int i8 = i3 + i7;
        if (i8 >= i6 || i8 < 0) {
            return 0;
        }
        return i7;
    }

    private void u() {
        this.J.addItemDecoration(this);
        this.J.addOnItemTouchListener(this);
        this.J.addOnScrollListener(this.T);
    }

    private void w(float f2) {
        int[] h2 = h();
        float max = Math.max(h2[0], Math.min(h2[1], f2));
        if (Math.abs(this.C - max) < 2.0f) {
            return;
        }
        int s = s(this.D, max, h2, this.J.computeVerticalScrollRange(), this.J.computeVerticalScrollOffset(), this.I);
        if (s != 0) {
            this.J.scrollBy(0, s);
        }
        this.D = max;
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.J;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            b();
        }
        this.J = recyclerView;
        if (recyclerView != null) {
            u();
        }
    }

    @VisibleForTesting
    Drawable f() {
        return this.x;
    }

    @VisibleForTesting
    Drawable g() {
        return this.y;
    }

    @VisibleForTesting
    Drawable i() {
        return this.t;
    }

    public boolean isDragging() {
        return this.M == 2;
    }

    @VisibleForTesting
    Drawable j() {
        return this.u;
    }

    @VisibleForTesting
    void k(int i2) {
        int i3 = this.R;
        if (i3 == 1) {
            this.Q.cancel();
        } else if (i3 != 2) {
            return;
        }
        this.R = 3;
        ValueAnimator valueAnimator = this.Q;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.Q.setDuration(i2);
        this.Q.start();
    }

    @VisibleForTesting
    boolean n(float f2, float f3) {
        if (f3 >= this.I - this.z) {
            int i2 = this.F;
            int i3 = this.E;
            if (f2 >= i2 - (i3 / 2) && f2 <= i2 + (i3 / 2)) {
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    boolean o(float f2, float f3) {
        if (!m() ? f2 >= this.H - this.v : f2 <= this.v / 2) {
            int i2 = this.C;
            int i3 = this.B;
            if (f3 >= i2 - (i3 / 2) && f3 <= i2 + (i3 / 2)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.H != this.J.getWidth() || this.I != this.J.getHeight()) {
            this.H = this.J.getWidth();
            this.I = this.J.getHeight();
            t(0);
        } else if (this.R != 0) {
            if (this.K) {
                d(canvas);
            }
            if (this.L) {
                c(canvas);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        int i2 = this.M;
        if (i2 == 1) {
            boolean o2 = o(motionEvent.getX(), motionEvent.getY());
            boolean n2 = n(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!o2 && !n2) {
                return false;
            }
            if (n2) {
                this.N = 1;
                this.G = (int) motionEvent.getX();
            } else if (o2) {
                this.N = 2;
                this.D = (int) motionEvent.getY();
            }
            t(2);
        } else if (i2 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        if (this.M == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean o2 = o(motionEvent.getX(), motionEvent.getY());
            boolean n2 = n(motionEvent.getX(), motionEvent.getY());
            if (o2 || n2) {
                if (n2) {
                    this.N = 1;
                    this.G = (int) motionEvent.getX();
                } else if (o2) {
                    this.N = 2;
                    this.D = (int) motionEvent.getY();
                }
                t(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.M == 2) {
            this.D = 0.0f;
            this.G = 0.0f;
            t(1);
            this.N = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.M == 2) {
            show();
            if (this.N == 1) {
                l(motionEvent.getX());
            }
            if (this.N == 2) {
                w(motionEvent.getY());
            }
        }
    }

    @VisibleForTesting
    boolean p() {
        return this.M == 1;
    }

    void q() {
        this.J.invalidate();
    }

    public void show() {
        int i2 = this.R;
        if (i2 != 0) {
            if (i2 != 3) {
                return;
            } else {
                this.Q.cancel();
            }
        }
        this.R = 1;
        ValueAnimator valueAnimator = this.Q;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.Q.setDuration(500L);
        this.Q.setStartDelay(0L);
        this.Q.start();
    }

    void t(int i2) {
        if (i2 == 2 && this.M != 2) {
            this.t.setState(p);
            a();
        }
        if (i2 == 0) {
            q();
        } else {
            show();
        }
        if (this.M == 2 && i2 != 2) {
            this.t.setState(q);
            r(m);
        } else if (i2 == 1) {
            r(1500);
        }
        this.M = i2;
    }

    void v(int i2, int i3) {
        int computeVerticalScrollRange = this.J.computeVerticalScrollRange();
        int i4 = this.I;
        this.K = computeVerticalScrollRange - i4 > 0 && i4 >= this.r;
        int computeHorizontalScrollRange = this.J.computeHorizontalScrollRange();
        int i5 = this.H;
        boolean z = computeHorizontalScrollRange - i5 > 0 && i5 >= this.r;
        this.L = z;
        boolean z2 = this.K;
        if (!z2 && !z) {
            if (this.M != 0) {
                t(0);
                return;
            }
            return;
        }
        if (z2) {
            float f2 = i4;
            this.C = (int) ((f2 * (i3 + (f2 / 2.0f))) / computeVerticalScrollRange);
            this.B = Math.min(i4, (i4 * i4) / computeVerticalScrollRange);
        }
        if (this.L) {
            float f3 = i5;
            this.F = (int) ((f3 * (i2 + (f3 / 2.0f))) / computeHorizontalScrollRange);
            this.E = Math.min(i5, (i5 * i5) / computeHorizontalScrollRange);
        }
        int i6 = this.M;
        if (i6 == 0 || i6 == 1) {
            t(1);
        }
    }
}
