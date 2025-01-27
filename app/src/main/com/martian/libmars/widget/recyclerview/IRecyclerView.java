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
import com.martian.libmars.widget.recyclerview.adatper.WrapperAdapter;
import com.martian.libsupport.recyclerView.OnLoadMoreScrollListener;

/* loaded from: classes3.dex */
public class IRecyclerView extends NestRecyclerview {
    public static final String C = "IRecyclerView";
    public static final int D = 0;
    public static final int E = 1;
    public static final int F = 2;
    public static final int G = 3;
    public static final boolean H = false;
    public Animator.AnimatorListener A;
    public u9.b B;

    /* renamed from: g */
    public int f12769g;

    /* renamed from: h */
    public boolean f12770h;

    /* renamed from: i */
    public boolean f12771i;

    /* renamed from: j */
    public int f12772j;

    /* renamed from: k */
    public s9.b f12773k;

    /* renamed from: l */
    public s9.a f12774l;

    /* renamed from: m */
    public OnLoadMoreScrollListener f12775m;

    /* renamed from: n */
    public RefreshHeaderLayout f12776n;

    /* renamed from: o */
    public FrameLayout f12777o;

    /* renamed from: p */
    public LinearLayout f12778p;

    /* renamed from: q */
    public LinearLayout f12779q;

    /* renamed from: r */
    public View f12780r;

    /* renamed from: s */
    public View f12781s;

    /* renamed from: t */
    @LayoutRes
    public int f12782t;

    /* renamed from: u */
    @LayoutRes
    public int f12783u;

    /* renamed from: v */
    public int f12784v;

    /* renamed from: w */
    public int f12785w;

    /* renamed from: x */
    public int f12786x;

    /* renamed from: y */
    public ValueAnimator f12787y;

    /* renamed from: z */
    public ValueAnimator.AnimatorUpdateListener f12788z;

    public class a extends OnLoadMoreScrollListener {
        public a() {
        }

        @Override // com.martian.libsupport.recyclerView.OnLoadMoreScrollListener
        public void b(RecyclerView recyclerView) {
            if (IRecyclerView.this.f12774l == null || IRecyclerView.this.f12769g != 0) {
                return;
            }
            IRecyclerView.this.f12774l.onLoadMore(IRecyclerView.this.f12781s);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            IRecyclerView.this.setRefreshHeaderContainerHeight(intValue);
            int i10 = IRecyclerView.this.f12769g;
            if (i10 == 1 || i10 == 2) {
                IRecyclerView.this.B.a(false, true, intValue);
            } else {
                if (i10 != 3) {
                    return;
                }
                IRecyclerView.this.B.a(true, true, intValue);
            }
        }
    }

    public class c extends s9.d {
        public c() {
        }

        @Override // s9.d, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            int unused = IRecyclerView.this.f12769g;
            int i10 = IRecyclerView.this.f12769g;
            if (i10 == 1) {
                if (!IRecyclerView.this.f12770h) {
                    IRecyclerView.this.f12776n.getLayoutParams().height = 0;
                    IRecyclerView.this.f12776n.requestLayout();
                    IRecyclerView.this.setStatus(0);
                    return;
                }
                IRecyclerView.this.f12776n.getLayoutParams().height = IRecyclerView.this.f12780r.getMeasuredHeight();
                IRecyclerView.this.f12776n.requestLayout();
                IRecyclerView.this.setStatus(3);
                if (IRecyclerView.this.f12773k != null) {
                    IRecyclerView.this.f12773k.onRefresh();
                    IRecyclerView.this.B.onRefresh();
                    return;
                }
                return;
            }
            if (i10 != 2) {
                if (i10 != 3) {
                    return;
                }
                IRecyclerView.this.f12770h = false;
                IRecyclerView.this.f12776n.getLayoutParams().height = 0;
                IRecyclerView.this.f12776n.requestLayout();
                IRecyclerView.this.setStatus(0);
                IRecyclerView.this.B.onReset();
                return;
            }
            IRecyclerView.this.f12776n.getLayoutParams().height = IRecyclerView.this.f12780r.getMeasuredHeight();
            IRecyclerView.this.f12776n.requestLayout();
            IRecyclerView.this.setStatus(3);
            if (IRecyclerView.this.f12773k != null) {
                IRecyclerView.this.f12773k.onRefresh();
                IRecyclerView.this.B.onRefresh();
            }
        }
    }

    public class d implements u9.b {
        public d() {
        }

        @Override // u9.b
        public void a(boolean z10, boolean z11, int i10) {
            if (IRecyclerView.this.f12780r == null || !(IRecyclerView.this.f12780r instanceof u9.b)) {
                return;
            }
            ((u9.b) IRecyclerView.this.f12780r).a(z10, z11, i10);
        }

        @Override // u9.b
        public void b(boolean z10, int i10, int i11) {
            if (IRecyclerView.this.f12780r == null || !(IRecyclerView.this.f12780r instanceof u9.b)) {
                return;
            }
            ((u9.b) IRecyclerView.this.f12780r).b(z10, i10, i11);
        }

        @Override // u9.b
        public void onComplete() {
            if (IRecyclerView.this.f12780r == null || !(IRecyclerView.this.f12780r instanceof u9.b)) {
                return;
            }
            ((u9.b) IRecyclerView.this.f12780r).onComplete();
        }

        @Override // u9.b
        public void onRefresh() {
            if (IRecyclerView.this.f12780r == null || !(IRecyclerView.this.f12780r instanceof u9.b)) {
                return;
            }
            ((u9.b) IRecyclerView.this.f12780r).onRefresh();
        }

        @Override // u9.b
        public void onRelease() {
            if (IRecyclerView.this.f12780r == null || !(IRecyclerView.this.f12780r instanceof u9.b)) {
                return;
            }
            ((u9.b) IRecyclerView.this.f12780r).onRelease();
        }

        @Override // u9.b
        public void onReset() {
            if (IRecyclerView.this.f12780r == null || !(IRecyclerView.this.f12780r instanceof u9.b)) {
                return;
            }
            ((u9.b) IRecyclerView.this.f12780r).onReset();
        }
    }

    public IRecyclerView(Context context) {
        this(context, null);
    }

    public void setRefreshHeaderContainerHeight(int i10) {
        this.f12776n.getLayoutParams().height = i10;
        this.f12776n.requestLayout();
    }

    public void setStatus(int i10) {
        this.f12769g = i10;
    }

    public final void A() {
        Log.i(C, v(this.f12769g));
    }

    public void B() {
        LinearLayout linearLayout = this.f12778p;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            RecyclerView.Adapter adapter = getAdapter();
            if (adapter != null) {
                adapter.notifyItemChanged(1);
            }
        }
    }

    public final void C() {
        FrameLayout frameLayout = this.f12777o;
        if (frameLayout != null) {
            frameLayout.removeView(this.f12781s);
        }
    }

    public final void D() {
        RefreshHeaderLayout refreshHeaderLayout = this.f12776n;
        if (refreshHeaderLayout != null) {
            refreshHeaderLayout.removeView(this.f12780r);
        }
    }

    public final void E(int i10, Interpolator interpolator, int i11, int i12) {
        if (this.f12787y == null) {
            this.f12787y = new ValueAnimator();
        }
        this.f12787y.removeAllUpdateListeners();
        this.f12787y.removeAllListeners();
        this.f12787y.cancel();
        this.f12787y.setIntValues(i11, i12);
        this.f12787y.setDuration(i10);
        this.f12787y.setInterpolator(interpolator);
        this.f12787y.addUpdateListener(this.f12788z);
        this.f12787y.addListener(this.A);
        this.f12787y.start();
    }

    public final void F() {
        this.B.b(true, this.f12780r.getMeasuredHeight(), this.f12772j);
        int measuredHeight = this.f12780r.getMeasuredHeight();
        E(400, new AccelerateInterpolator(), this.f12776n.getMeasuredHeight(), measuredHeight);
    }

    public final void G() {
        this.B.onComplete();
        E(400, new DecelerateInterpolator(), this.f12776n.getMeasuredHeight(), 0);
    }

    public final void H() {
        this.B.onRelease();
        int measuredHeight = this.f12780r.getMeasuredHeight();
        E(300, new DecelerateInterpolator(), this.f12776n.getMeasuredHeight(), measuredHeight);
    }

    public final void I() {
        E(300, new DecelerateInterpolator(), this.f12776n.getMeasuredHeight(), 0);
    }

    public LinearLayout getFooterContainer() {
        n();
        return this.f12779q;
    }

    public LinearLayout getHeaderContainer() {
        o();
        return this.f12778p;
    }

    public View getLoadMoreFooterView() {
        return this.f12781s;
    }

    public View getRefreshHeaderView() {
        return this.f12780r;
    }

    public void k(View view) {
        o();
        this.f12778p.addView(view);
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public boolean l() {
        View view = this.f12781s;
        if (view instanceof LoadMoreFooterView) {
            return ((LoadMoreFooterView) view).b();
        }
        return false;
    }

    public boolean m() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null || adapter.getPageSize() <= 0) {
            return true;
        }
        View childAt = getChildAt(0);
        return getChildLayoutPosition(childAt) == 0 && childAt.getTop() == this.f12776n.getTop();
    }

    public final void n() {
        if (this.f12779q == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.f12779q = linearLayout;
            linearLayout.setOrientation(1);
            this.f12779q.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
    }

    public final void o() {
        if (this.f12778p == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.f12778p = linearLayout;
            linearLayout.setOrientation(1);
            this.f12778p.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
    }

    @Override // com.martian.libmars.widget.recyclerview.NestRecyclerview, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            this.f12784v = MotionEventCompat.getPointerId(motionEvent, 0);
            this.f12785w = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
            this.f12786x = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
        } else if (actionMasked == 5) {
            this.f12784v = MotionEventCompat.getPointerId(motionEvent, actionIndex);
            this.f12785w = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
            this.f12786x = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        View view = this.f12780r;
        if (view == null || view.getMeasuredHeight() <= this.f12772j) {
            return;
        }
        this.f12772j = 0;
    }

    public final void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f12784v) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.f12784v = MotionEventCompat.getPointerId(motionEvent, i10);
            this.f12785w = t(motionEvent, i10);
            this.f12786x = u(motionEvent, i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i10) {
        super.onScrollStateChanged(i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0092, code lost:
    
        if (r8.f12769g == 0) goto L163;
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
            if (r0 == 0) goto Lac
            r2 = 1
            if (r0 == r2) goto La8
            r3 = 2
            if (r0 == r3) goto L35
            r1 = 3
            if (r0 == r1) goto La8
            r1 = 5
            if (r0 == r1) goto L1d
            r1 = 6
            if (r0 == r1) goto L18
            goto Lc2
        L18:
            r8.onPointerUp(r9)
            goto Lc2
        L1d:
            int r0 = androidx.core.view.MotionEventCompat.getActionIndex(r9)
            int r1 = androidx.core.view.MotionEventCompat.getPointerId(r9, r0)
            r8.f12784v = r1
            int r1 = r8.t(r9, r0)
            r8.f12785w = r1
            int r0 = r8.u(r9, r0)
            r8.f12786x = r0
            goto Lc2
        L35:
            int r0 = r8.f12784v
            int r0 = androidx.core.view.MotionEventCompat.findPointerIndex(r9, r0)
            if (r0 >= 0) goto L3e
            return r1
        L3e:
            int r4 = r8.t(r9, r0)
            int r0 = r8.u(r9, r0)
            int r5 = r8.f12786x
            int r5 = r0 - r5
            r8.f12785w = r4
            r8.f12786x = r0
            boolean r0 = r8.isEnabled()
            if (r0 == 0) goto Lc2
            boolean r0 = r8.f12771i
            if (r0 == 0) goto Lc2
            android.view.View r0 = r8.f12780r
            if (r0 == 0) goto Lc2
            boolean r0 = r8.w()
            if (r0 == 0) goto Lc2
            boolean r0 = r8.m()
            if (r0 == 0) goto Lc2
            com.martian.libmars.widget.recyclerview.RefreshHeaderLayout r0 = r8.f12776n
            int r0 = r0.getMeasuredHeight()
            android.view.View r4 = r8.f12780r
            int r4 = r4.getMeasuredHeight()
            if (r5 <= 0) goto L85
            int r6 = r8.f12769g
            if (r6 != 0) goto L85
            r8.setStatus(r2)
            u9.b r6 = r8.B
            int r7 = r8.f12772j
            r6.b(r1, r4, r7)
            goto L95
        L85:
            if (r5 >= 0) goto L95
            int r6 = r8.f12769g
            if (r6 != r2) goto L90
            if (r0 > 0) goto L90
            r8.setStatus(r1)
        L90:
            int r1 = r8.f12769g
            if (r1 != 0) goto L95
            goto Lc2
        L95:
            int r1 = r8.f12769g
            if (r1 == r2) goto L9b
            if (r1 != r3) goto Lc2
        L9b:
            if (r0 < r4) goto La1
            r8.setStatus(r3)
            goto La4
        La1:
            r8.setStatus(r2)
        La4:
            r8.s(r5)
            return r2
        La8:
            r8.z()
            goto Lc2
        Lac:
            int r0 = androidx.core.view.MotionEventCompat.getActionIndex(r9)
            int r1 = androidx.core.view.MotionEventCompat.getPointerId(r9, r1)
            r8.f12784v = r1
            int r1 = r8.t(r9, r0)
            r8.f12785w = r1
            int r0 = r8.u(r9, r0)
            r8.f12786x = r0
        Lc2:
            boolean r9 = super.onTouchEvent(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.libmars.widget.recyclerview.IRecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void q() {
        if (this.f12777o == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.f12777o = frameLayout;
            frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
    }

    public final void r() {
        if (this.f12776n == null) {
            RefreshHeaderLayout refreshHeaderLayout = new RefreshHeaderLayout(getContext());
            this.f12776n = refreshHeaderLayout;
            refreshHeaderLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, 0));
        }
    }

    public final void s(int i10) {
        int i11 = (int) ((i10 * 0.5f) + 0.5d);
        int measuredHeight = this.f12776n.getMeasuredHeight();
        int i12 = this.f12772j;
        int i13 = measuredHeight + i11;
        if (i12 > 0 && i13 > i12) {
            i11 = i12 - measuredHeight;
        }
        if (i13 < 0) {
            i11 = -measuredHeight;
        }
        y(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        r();
        o();
        n();
        q();
        super.setAdapter(new WrapperAdapter(adapter, this.f12776n, this.f12778p, this.f12779q, this.f12777o));
    }

    public void setLoadMoreBackgroundColor(int i10) {
        View view = this.f12781s;
        if (view != null) {
            view.setBackgroundColor(i10);
        }
    }

    public void setLoadMoreEnabled(boolean z10) {
        if (z10) {
            OnLoadMoreScrollListener onLoadMoreScrollListener = this.f12775m;
            if (onLoadMoreScrollListener == null) {
                this.f12775m = new a();
            } else {
                removeOnScrollListener(onLoadMoreScrollListener);
            }
            addOnScrollListener(this.f12775m);
            return;
        }
        if (this.f12781s != null) {
            C();
        }
        OnLoadMoreScrollListener onLoadMoreScrollListener2 = this.f12775m;
        if (onLoadMoreScrollListener2 != null) {
            removeOnScrollListener(onLoadMoreScrollListener2);
        }
    }

    public void setLoadMoreEndStatus(String str) {
        View view = this.f12781s;
        if (view instanceof LoadMoreFooterView) {
            ((LoadMoreFooterView) view).setEndStatus(str);
        }
    }

    public void setLoadMoreFooterView(View view) {
        if (this.f12781s != null) {
            C();
        }
        if (this.f12781s != view) {
            this.f12781s = view;
            q();
            this.f12777o.addView(view);
        }
    }

    public void setLoadMoreStatus(LoadMoreFooterView.Status status) {
        View view = this.f12781s;
        if (view instanceof LoadMoreFooterView) {
            ((LoadMoreFooterView) view).setStatus(status);
        }
    }

    public void setOnLoadMoreListener(s9.a aVar) {
        this.f12774l = aVar;
    }

    public void setOnRefreshListener(s9.b bVar) {
        this.f12773k = bVar;
    }

    public void setRefreshEnabled(boolean z10) {
        this.f12771i = z10;
    }

    public void setRefreshFinalMoveOffset(int i10) {
        this.f12772j = i10;
    }

    public void setRefreshHeaderView(View view) {
        if (!x(view)) {
            throw new ClassCastException("Refresh header view must be an implement of RefreshTrigger");
        }
        if (this.f12780r != null) {
            D();
        }
        if (this.f12780r != view) {
            this.f12780r = view;
            r();
            this.f12776n.addView(view);
        }
    }

    public void setRefreshing(boolean z10) {
        int i10 = this.f12769g;
        if (i10 == 0 && z10) {
            this.f12770h = true;
            setStatus(1);
            F();
        } else if (i10 != 3 || z10) {
            this.f12770h = false;
        } else {
            this.f12770h = false;
            G();
        }
    }

    public final int t(MotionEvent motionEvent, int i10) {
        return (int) (MotionEventCompat.getX(motionEvent, i10) + 0.5f);
    }

    public final int u(MotionEvent motionEvent, int i10) {
        return (int) (MotionEventCompat.getY(motionEvent, i10) + 0.5f);
    }

    public final String v(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? "status_illegal!" : "status_refreshing" : "status_release_to_refresh" : "status_swiping_to_refresh" : "status_default";
    }

    public final boolean w() {
        return getScrollState() == 1;
    }

    public final boolean x(View view) {
        return view instanceof u9.b;
    }

    public final void y(int i10) {
        if (i10 != 0) {
            int measuredHeight = this.f12776n.getMeasuredHeight() + i10;
            setRefreshHeaderContainerHeight(measuredHeight);
            this.B.a(false, false, measuredHeight);
        }
    }

    public final void z() {
        int i10 = this.f12769g;
        if (i10 == 2) {
            H();
        } else if (i10 == 1) {
            I();
        }
    }

    public IRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12784v = -1;
        this.f12785w = 0;
        this.f12786x = 0;
        this.f12788z = new b();
        this.A = new c();
        this.B = new d();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IRecyclerView, i10, 0);
        try {
            boolean z10 = obtainStyledAttributes.getBoolean(R.styleable.IRecyclerView_refreshEnabled, false);
            boolean z11 = obtainStyledAttributes.getBoolean(R.styleable.IRecyclerView_loadMoreEnabled, false);
            this.f12782t = obtainStyledAttributes.getResourceId(R.styleable.IRecyclerView_refreshHeaderLayout, -1);
            this.f12783u = obtainStyledAttributes.getResourceId(R.styleable.IRecyclerView_loadMoreFooterLayout, -1);
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.IRecyclerView_refreshFinalMoveOffset, -1);
            obtainStyledAttributes.recycle();
            setRefreshEnabled(z10);
            setLoadMoreEnabled(z11);
            int i11 = this.f12782t;
            if (i11 != -1) {
                setRefreshHeaderView(i11);
            } else if (z10) {
                int i12 = R.layout.layout_irecyclerview_classic_refresh_header;
                this.f12782t = i12;
                setRefreshHeaderView(i12);
            }
            int i13 = this.f12783u;
            if (i13 != -1) {
                setLoadMoreFooterView(i13);
            } else if (z11) {
                int i14 = R.layout.layout_irecyclerview_load_more_footer;
                this.f12783u = i14;
                setLoadMoreFooterView(i14);
            }
            if (dimensionPixelOffset != -1) {
                setRefreshFinalMoveOffset(dimensionPixelOffset);
            }
            setStatus(0);
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    public void setLoadMoreFooterView(@LayoutRes int i10) {
        q();
        View inflate = LayoutInflater.from(getContext()).inflate(i10, (ViewGroup) this.f12777o, false);
        if (inflate != null) {
            setLoadMoreFooterView(inflate);
        }
    }

    public void setRefreshHeaderView(@LayoutRes int i10) {
        r();
        View inflate = LayoutInflater.from(getContext()).inflate(i10, (ViewGroup) this.f12776n, false);
        if (inflate != null) {
            setRefreshHeaderView(inflate);
        }
    }
}
