package com.martian.libmars.widget.recyclerview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.libmars.R;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.libmars.widget.recyclerview.e.e;

/* loaded from: classes2.dex */
public class IRecyclerView extends NestRecyclerview {

    /* renamed from: f */
    private static final String f10430f = IRecyclerView.class.getSimpleName();

    /* renamed from: g */
    private static final int f10431g = 0;

    /* renamed from: h */
    private static final int f10432h = 1;

    /* renamed from: i */
    private static final int f10433i = 2;

    /* renamed from: j */
    private static final int f10434j = 3;
    private static final boolean k = false;
    private int A;
    private int B;
    private int C;
    ValueAnimator D;
    ValueAnimator.AnimatorUpdateListener E;
    Animator.AnimatorListener F;
    com.martian.libmars.widget.recyclerview.h.b G;
    private int l;
    private boolean m;
    private boolean n;
    private int o;
    private com.martian.libmars.widget.recyclerview.f.b p;
    private com.martian.libmars.widget.recyclerview.f.a q;
    private com.martian.libsupport.recyclerView.b r;
    private RefreshHeaderLayout s;
    private FrameLayout t;
    private LinearLayout u;
    private LinearLayout v;
    private View w;
    private View x;

    @LayoutRes
    int y;

    @LayoutRes
    int z;

    class a extends com.martian.libsupport.recyclerView.b {
        a() {
        }

        @Override // com.martian.libsupport.recyclerView.b
        public void b(RecyclerView recyclerView) {
            if (IRecyclerView.this.q == null || IRecyclerView.this.l != 0) {
                return;
            }
            IRecyclerView.this.q.onLoadMore(IRecyclerView.this.x);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            int intValue = ((Integer) animation.getAnimatedValue()).intValue();
            IRecyclerView.this.setRefreshHeaderContainerHeight(intValue);
            int i2 = IRecyclerView.this.l;
            if (i2 == 1 || i2 == 2) {
                IRecyclerView.this.G.a(false, true, intValue);
            } else {
                if (i2 != 3) {
                    return;
                }
                IRecyclerView.this.G.a(true, true, intValue);
            }
        }
    }

    class c extends com.martian.libmars.widget.recyclerview.f.d {
        c() {
        }

        @Override // com.martian.libmars.widget.recyclerview.f.d, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            int unused = IRecyclerView.this.l;
            int i2 = IRecyclerView.this.l;
            if (i2 == 1) {
                if (!IRecyclerView.this.m) {
                    IRecyclerView.this.s.getLayoutParams().height = 0;
                    IRecyclerView.this.s.requestLayout();
                    IRecyclerView.this.setStatus(0);
                    return;
                }
                IRecyclerView.this.s.getLayoutParams().height = IRecyclerView.this.w.getMeasuredHeight();
                IRecyclerView.this.s.requestLayout();
                IRecyclerView.this.setStatus(3);
                if (IRecyclerView.this.p != null) {
                    IRecyclerView.this.p.onRefresh();
                    IRecyclerView.this.G.onRefresh();
                    return;
                }
                return;
            }
            if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                IRecyclerView.this.m = false;
                IRecyclerView.this.s.getLayoutParams().height = 0;
                IRecyclerView.this.s.requestLayout();
                IRecyclerView.this.setStatus(0);
                IRecyclerView.this.G.d();
                return;
            }
            IRecyclerView.this.s.getLayoutParams().height = IRecyclerView.this.w.getMeasuredHeight();
            IRecyclerView.this.s.requestLayout();
            IRecyclerView.this.setStatus(3);
            if (IRecyclerView.this.p != null) {
                IRecyclerView.this.p.onRefresh();
                IRecyclerView.this.G.onRefresh();
            }
        }
    }

    class d implements com.martian.libmars.widget.recyclerview.h.b {
        d() {
        }

        @Override // com.martian.libmars.widget.recyclerview.h.b
        public void a(boolean finished, boolean automatic, int moved) {
            if (IRecyclerView.this.w == null || !(IRecyclerView.this.w instanceof com.martian.libmars.widget.recyclerview.h.b)) {
                return;
            }
            ((com.martian.libmars.widget.recyclerview.h.b) IRecyclerView.this.w).a(finished, automatic, moved);
        }

        @Override // com.martian.libmars.widget.recyclerview.h.b
        public void b(boolean automatic, int headerHeight, int finalHeight) {
            if (IRecyclerView.this.w == null || !(IRecyclerView.this.w instanceof com.martian.libmars.widget.recyclerview.h.b)) {
                return;
            }
            ((com.martian.libmars.widget.recyclerview.h.b) IRecyclerView.this.w).b(automatic, headerHeight, finalHeight);
        }

        @Override // com.martian.libmars.widget.recyclerview.h.b
        public void c() {
            if (IRecyclerView.this.w == null || !(IRecyclerView.this.w instanceof com.martian.libmars.widget.recyclerview.h.b)) {
                return;
            }
            ((com.martian.libmars.widget.recyclerview.h.b) IRecyclerView.this.w).c();
        }

        @Override // com.martian.libmars.widget.recyclerview.h.b
        public void d() {
            if (IRecyclerView.this.w == null || !(IRecyclerView.this.w instanceof com.martian.libmars.widget.recyclerview.h.b)) {
                return;
            }
            ((com.martian.libmars.widget.recyclerview.h.b) IRecyclerView.this.w).d();
        }

        @Override // com.martian.libmars.widget.recyclerview.h.b
        public void onRefresh() {
            if (IRecyclerView.this.w == null || !(IRecyclerView.this.w instanceof com.martian.libmars.widget.recyclerview.h.b)) {
                return;
            }
            ((com.martian.libmars.widget.recyclerview.h.b) IRecyclerView.this.w).onRefresh();
        }

        @Override // com.martian.libmars.widget.recyclerview.h.b
        public void onRelease() {
            if (IRecyclerView.this.w == null || !(IRecyclerView.this.w instanceof com.martian.libmars.widget.recyclerview.h.b)) {
                return;
            }
            ((com.martian.libmars.widget.recyclerview.h.b) IRecyclerView.this.w).onRelease();
        }
    }

    public IRecyclerView(Context context) {
        this(context, null);
    }

    private void A(int dy) {
        if (dy != 0) {
            int measuredHeight = this.s.getMeasuredHeight() + dy;
            setRefreshHeaderContainerHeight(measuredHeight);
            this.G.a(false, false, measuredHeight);
        }
    }

    private void B() {
        int i2 = this.l;
        if (i2 == 2) {
            K();
        } else if (i2 == 1) {
            L();
        }
    }

    private void C() {
        Log.i(f10430f, x(this.l));
    }

    private void F() {
        FrameLayout frameLayout = this.t;
        if (frameLayout != null) {
            frameLayout.removeView(this.x);
        }
    }

    private void G() {
        RefreshHeaderLayout refreshHeaderLayout = this.s;
        if (refreshHeaderLayout != null) {
            refreshHeaderLayout.removeView(this.w);
        }
    }

    private void H(final int time, final Interpolator interpolator, int value, int toValue) {
        if (this.D == null) {
            this.D = new ValueAnimator();
        }
        this.D.removeAllUpdateListeners();
        this.D.removeAllListeners();
        this.D.cancel();
        this.D.setIntValues(value, toValue);
        this.D.setDuration(time);
        this.D.setInterpolator(interpolator);
        this.D.addUpdateListener(this.E);
        this.D.addListener(this.F);
        this.D.start();
    }

    private void I() {
        this.G.b(true, this.w.getMeasuredHeight(), this.o);
        int measuredHeight = this.w.getMeasuredHeight();
        H(400, new AccelerateInterpolator(), this.s.getMeasuredHeight(), measuredHeight);
    }

    private void J() {
        this.G.c();
        H(400, new DecelerateInterpolator(), this.s.getMeasuredHeight(), 0);
    }

    private void K() {
        this.G.onRelease();
        int measuredHeight = this.w.getMeasuredHeight();
        H(300, new DecelerateInterpolator(), this.s.getMeasuredHeight(), measuredHeight);
    }

    private void L() {
        H(300, new DecelerateInterpolator(), this.s.getMeasuredHeight(), 0);
    }

    private void onPointerUp(MotionEvent e2) {
        int actionIndex = MotionEventCompat.getActionIndex(e2);
        if (MotionEventCompat.getPointerId(e2, actionIndex) == this.A) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.A = MotionEventCompat.getPointerId(e2, i2);
            this.B = v(e2, i2);
            this.C = w(e2, i2);
        }
    }

    private void q() {
        if (this.v == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.v = linearLayout;
            linearLayout.setOrientation(1);
            this.v.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
    }

    private void r() {
        if (this.u == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.u = linearLayout;
            linearLayout.setOrientation(1);
            this.u.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
    }

    private void s() {
        if (this.t == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.t = frameLayout;
            frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
    }

    public void setRefreshHeaderContainerHeight(int height) {
        this.s.getLayoutParams().height = height;
        this.s.requestLayout();
    }

    public void setStatus(int status) {
        this.l = status;
    }

    private void t() {
        if (this.s == null) {
            RefreshHeaderLayout refreshHeaderLayout = new RefreshHeaderLayout(getContext());
            this.s = refreshHeaderLayout;
            refreshHeaderLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, 0));
        }
    }

    private void u(int dy) {
        double d2 = dy * 0.5f;
        Double.isNaN(d2);
        int i2 = (int) (d2 + 0.5d);
        int measuredHeight = this.s.getMeasuredHeight();
        int i3 = this.o;
        int i4 = measuredHeight + i2;
        if (i3 > 0 && i4 > i3) {
            i2 = i3 - measuredHeight;
        }
        if (i4 < 0) {
            i2 = -measuredHeight;
        }
        A(i2);
    }

    private int v(MotionEvent e2, int pointerIndex) {
        return (int) (MotionEventCompat.getX(e2, pointerIndex) + 0.5f);
    }

    private int w(MotionEvent e2, int pointerIndex) {
        return (int) (MotionEventCompat.getY(e2, pointerIndex) + 0.5f);
    }

    private String x(int status) {
        return status != 0 ? status != 1 ? status != 2 ? status != 3 ? "status_illegal!" : "status_refreshing" : "status_release_to_refresh" : "status_swiping_to_refresh" : "status_default";
    }

    private boolean y() {
        return getScrollState() == 1;
    }

    private boolean z(View refreshHeaderView) {
        return refreshHeaderView instanceof com.martian.libmars.widget.recyclerview.h.b;
    }

    public void D() {
        LinearLayout linearLayout = this.v;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            RecyclerView.Adapter adapter = getAdapter();
            if (adapter != null) {
                adapter.notifyItemChanged(adapter.getItemCount() - 2);
            }
        }
    }

    public void E() {
        LinearLayout linearLayout = this.u;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            RecyclerView.Adapter adapter = getAdapter();
            if (adapter != null) {
                adapter.notifyItemChanged(1);
            }
        }
    }

    public void M() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public LinearLayout getFooterContainer() {
        q();
        return this.v;
    }

    public LinearLayout getHeaderContainer() {
        r();
        return this.u;
    }

    public int getHeaderViewCount() {
        LinearLayout linearLayout = this.u;
        if (linearLayout != null) {
            return linearLayout.getChildCount();
        }
        return 0;
    }

    public RecyclerView.Adapter getIAdapter() {
        e eVar = (e) getAdapter();
        if (eVar != null) {
            return eVar.E();
        }
        return null;
    }

    public View getLoadMoreFooterView() {
        return this.x;
    }

    public View getRefreshHeaderView() {
        return this.w;
    }

    public void l(View footerView) {
        q();
        this.v.addView(footerView);
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(adapter.getItemCount() - 2);
        }
    }

    public void m(View headerView) {
        r();
        this.u.addView(headerView);
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(1);
        }
    }

    public void n(View headerView, int position) {
        r();
        this.u.addView(headerView, position);
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(1);
        }
    }

    public boolean o() {
        View view = this.x;
        if (view instanceof LoadMoreFooterView) {
            return ((LoadMoreFooterView) view).a();
        }
        return false;
    }

    @Override // com.martian.libmars.widget.recyclerview.NestRecyclerview, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent e2) {
        int actionMasked = MotionEventCompat.getActionMasked(e2);
        int actionIndex = MotionEventCompat.getActionIndex(e2);
        if (actionMasked == 0) {
            this.A = MotionEventCompat.getPointerId(e2, 0);
            this.B = (int) (MotionEventCompat.getX(e2, actionIndex) + 0.5f);
            this.C = (int) (MotionEventCompat.getY(e2, actionIndex) + 0.5f);
        } else if (actionMasked == 5) {
            this.A = MotionEventCompat.getPointerId(e2, actionIndex);
            this.B = (int) (MotionEventCompat.getX(e2, actionIndex) + 0.5f);
            this.C = (int) (MotionEventCompat.getY(e2, actionIndex) + 0.5f);
        } else if (actionMasked == 6) {
            onPointerUp(e2);
        }
        return super.onInterceptTouchEvent(e2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        View view = this.w;
        if (view == null || view.getMeasuredHeight() <= this.o) {
            return;
        }
        this.o = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b2, code lost:
    
        if (r8.l == 0) goto L116;
     */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            int r0 = androidx.core.view.MotionEventCompat.getActionMasked(r9)
            r1 = 0
            if (r0 == 0) goto Lcc
            r2 = 1
            if (r0 == r2) goto Lc8
            r3 = 2
            if (r0 == r3) goto L35
            r1 = 3
            if (r0 == r1) goto Lc8
            r1 = 5
            if (r0 == r1) goto L1d
            r1 = 6
            if (r0 == r1) goto L18
            goto Le2
        L18:
            r8.onPointerUp(r9)
            goto Le2
        L1d:
            int r0 = androidx.core.view.MotionEventCompat.getActionIndex(r9)
            int r1 = androidx.core.view.MotionEventCompat.getPointerId(r9, r0)
            r8.A = r1
            int r1 = r8.v(r9, r0)
            r8.B = r1
            int r0 = r8.w(r9, r0)
            r8.C = r0
            goto Le2
        L35:
            int r0 = r8.A
            int r0 = androidx.core.view.MotionEventCompat.findPointerIndex(r9, r0)
            if (r0 >= 0) goto L59
            java.lang.String r9 = com.martian.libmars.widget.recyclerview.IRecyclerView.f10430f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error processing scroll; pointer index for id "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = " not found. Did any MotionEvents get skipped?"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.util.Log.e(r9, r0)
            return r1
        L59:
            int r4 = r8.v(r9, r0)
            int r0 = r8.w(r9, r0)
            int r5 = r8.C
            int r5 = r0 - r5
            r8.B = r4
            r8.C = r0
            boolean r0 = r8.isEnabled()
            if (r0 == 0) goto L85
            boolean r0 = r8.n
            if (r0 == 0) goto L85
            android.view.View r0 = r8.w
            if (r0 == 0) goto L85
            boolean r0 = r8.y()
            if (r0 == 0) goto L85
            boolean r0 = r8.p()
            if (r0 == 0) goto L85
            r0 = 1
            goto L86
        L85:
            r0 = 0
        L86:
            if (r0 == 0) goto Le2
            com.martian.libmars.widget.recyclerview.RefreshHeaderLayout r0 = r8.s
            int r0 = r0.getMeasuredHeight()
            android.view.View r4 = r8.w
            int r4 = r4.getMeasuredHeight()
            if (r5 <= 0) goto La5
            int r6 = r8.l
            if (r6 != 0) goto La5
            r8.setStatus(r2)
            com.martian.libmars.widget.recyclerview.h.b r6 = r8.G
            int r7 = r8.o
            r6.b(r1, r4, r7)
            goto Lb5
        La5:
            if (r5 >= 0) goto Lb5
            int r6 = r8.l
            if (r6 != r2) goto Lb0
            if (r0 > 0) goto Lb0
            r8.setStatus(r1)
        Lb0:
            int r1 = r8.l
            if (r1 != 0) goto Lb5
            goto Le2
        Lb5:
            int r1 = r8.l
            if (r1 == r2) goto Lbb
            if (r1 != r3) goto Le2
        Lbb:
            if (r0 < r4) goto Lc1
            r8.setStatus(r3)
            goto Lc4
        Lc1:
            r8.setStatus(r2)
        Lc4:
            r8.u(r5)
            return r2
        Lc8:
            r8.B()
            goto Le2
        Lcc:
            int r0 = androidx.core.view.MotionEventCompat.getActionIndex(r9)
            int r1 = androidx.core.view.MotionEventCompat.getPointerId(r9, r1)
            r8.A = r1
            int r1 = r8.v(r9, r0)
            r8.B = r1
            int r0 = r8.w(r9, r0)
            r8.C = r0
        Le2:
            boolean r9 = super.onTouchEvent(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.libmars.widget.recyclerview.IRecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean p() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null || adapter.getItemCount() <= 0) {
            return true;
        }
        View childAt = getChildAt(0);
        return getChildLayoutPosition(childAt) == 0 && childAt.getTop() == this.s.getTop();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        t();
        r();
        q();
        s();
        super.setAdapter(new e(adapter, this.s, this.u, this.v, this.t));
    }

    public void setLoadMoreBackgroundColor(int color) {
        View view = this.x;
        if (view != null) {
            view.setBackgroundColor(color);
        }
    }

    public void setLoadMoreEnabled(boolean enabled) {
        if (enabled) {
            com.martian.libsupport.recyclerView.b bVar = this.r;
            if (bVar == null) {
                this.r = new a();
            } else {
                removeOnScrollListener(bVar);
            }
            addOnScrollListener(this.r);
            return;
        }
        if (this.x != null) {
            F();
        }
        com.martian.libsupport.recyclerView.b bVar2 = this.r;
        if (bVar2 != null) {
            removeOnScrollListener(bVar2);
        }
    }

    public void setLoadMoreEndStatus(String desc) {
        View view = this.x;
        if (view instanceof LoadMoreFooterView) {
            ((LoadMoreFooterView) view).setEndStatus(desc);
        }
    }

    public void setLoadMoreFooterView(View loadMoreFooterView) {
        if (this.x != null) {
            F();
        }
        if (this.x != loadMoreFooterView) {
            this.x = loadMoreFooterView;
            s();
            this.t.addView(loadMoreFooterView);
        }
    }

    public void setLoadMoreStatus(LoadMoreFooterView.Status status) {
        View view = this.x;
        if (view instanceof LoadMoreFooterView) {
            ((LoadMoreFooterView) view).setStatus(status);
        }
    }

    public void setOnLoadMoreListener(com.martian.libmars.widget.recyclerview.f.a listener) {
        this.q = listener;
    }

    public void setOnRefreshListener(com.martian.libmars.widget.recyclerview.f.b listener) {
        this.p = listener;
    }

    public void setRefreshEnabled(boolean enabled) {
        this.n = enabled;
    }

    public void setRefreshFinalMoveOffset(int refreshFinalMoveOffset) {
        this.o = refreshFinalMoveOffset;
    }

    public void setRefreshHeaderView(View refreshHeaderView) {
        if (!z(refreshHeaderView)) {
            throw new ClassCastException("Refresh header view must be an implement of RefreshTrigger");
        }
        if (this.w != null) {
            G();
        }
        if (this.w != refreshHeaderView) {
            this.w = refreshHeaderView;
            t();
            this.s.addView(refreshHeaderView);
        }
    }

    public void setRefreshing(boolean refreshing) {
        int i2 = this.l;
        if (i2 == 0 && refreshing) {
            this.m = true;
            setStatus(1);
            I();
        } else if (i2 != 3 || refreshing) {
            this.m = false;
        } else {
            this.m = false;
            J();
        }
    }

    public IRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.A = -1;
        this.B = 0;
        this.C = 0;
        this.E = new b();
        this.F = new c();
        this.G = new d();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.IRecyclerView, defStyle, 0);
        try {
            boolean z = obtainStyledAttributes.getBoolean(R.styleable.IRecyclerView_refreshEnabled, false);
            boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.IRecyclerView_loadMoreEnabled, false);
            this.y = obtainStyledAttributes.getResourceId(R.styleable.IRecyclerView_refreshHeaderLayout, -1);
            this.z = obtainStyledAttributes.getResourceId(R.styleable.IRecyclerView_loadMoreFooterLayout, -1);
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.IRecyclerView_refreshFinalMoveOffset, -1);
            obtainStyledAttributes.recycle();
            setRefreshEnabled(z);
            setLoadMoreEnabled(z2);
            int i2 = this.y;
            if (i2 != -1) {
                setRefreshHeaderView(i2);
            } else if (z) {
                int i3 = R.layout.layout_irecyclerview_classic_refresh_header;
                this.y = i3;
                setRefreshHeaderView(i3);
            }
            int i4 = this.z;
            if (i4 != -1) {
                setLoadMoreFooterView(i4);
            } else if (z2) {
                int i5 = R.layout.layout_irecyclerview_load_more_footer;
                this.z = i5;
                setLoadMoreFooterView(i5);
            }
            if (dimensionPixelOffset != -1) {
                setRefreshFinalMoveOffset(dimensionPixelOffset);
            }
            setStatus(0);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setLoadMoreFooterView(@LayoutRes int loadMoreFooterLayoutRes) {
        s();
        View inflate = LayoutInflater.from(getContext()).inflate(loadMoreFooterLayoutRes, (ViewGroup) this.t, false);
        if (inflate != null) {
            setLoadMoreFooterView(inflate);
        }
    }

    public void setRefreshHeaderView(@LayoutRes int refreshHeaderLayoutRes) {
        t();
        View inflate = LayoutInflater.from(getContext()).inflate(refreshHeaderLayoutRes, (ViewGroup) this.s, false);
        if (inflate != null) {
            setRefreshHeaderView(inflate);
        }
    }
}
