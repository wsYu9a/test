package com.baidu.mobads.sdk.internal.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.internal.concrete.ViewCompatDelegate;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class ViewPager2 extends ViewGroup {

    /* renamed from: a */
    public static final int f5904a = 0;

    /* renamed from: b */
    public static final int f5905b = 1;

    /* renamed from: c */
    public static final int f5906c = 0;

    /* renamed from: d */
    public static final int f5907d = 1;

    /* renamed from: e */
    public static final int f5908e = 2;

    /* renamed from: f */
    public static final int f5909f = -1;

    /* renamed from: g */
    static boolean f5910g = true;
    private int A;

    /* renamed from: h */
    int f5911h;

    /* renamed from: i */
    boolean f5912i;

    /* renamed from: j */
    RecyclerView f5913j;
    ScrollEventAdapter k;
    AccessibilityProvider l;
    private final Rect m;
    private final Rect n;
    private CompositeOnPageChangeCallback o;
    private RecyclerView.AdapterDataObserver p;
    private LinearLayoutManager q;
    private int r;
    private Parcelable s;
    private PagerSnapHelper t;
    private CompositeOnPageChangeCallback u;
    private FakeDrag v;
    private PageTransformerAdapter w;
    private RecyclerView.ItemAnimator x;
    private boolean y;
    private boolean z;

    /* renamed from: com.baidu.mobads.sdk.internal.widget.ViewPager2$1 */
    class AnonymousClass1 extends DataSetChangeObserver {
        AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f5912i = true;
            viewPager2.k.a();
        }
    }

    /* renamed from: com.baidu.mobads.sdk.internal.widget.ViewPager2$2 */
    class AnonymousClass2 extends OnPageChangeCallback {
        AnonymousClass2() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i2) {
            if (i2 == 0) {
                ViewPager2.this.a();
            }
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i2) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.f5911h != i2) {
                viewPager2.f5911h = i2;
                viewPager2.l.e();
            }
        }
    }

    /* renamed from: com.baidu.mobads.sdk.internal.widget.ViewPager2$3 */
    class AnonymousClass3 extends OnPageChangeCallback {
        AnonymousClass3() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i2) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.f5913j.requestFocus(2);
            }
        }
    }

    /* renamed from: com.baidu.mobads.sdk.internal.widget.ViewPager2$4 */
    class AnonymousClass4 implements RecyclerView.OnChildAttachStateChangeListener {
        AnonymousClass4() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(@NonNull View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) layoutParams).width != -1 || ((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
                throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(@NonNull View view) {
        }
    }

    /* renamed from: com.baidu.mobads.sdk.internal.widget.ViewPager2$5 */
    class AnonymousClass5 extends OnPageChangeCallback {

        /* renamed from: a */
        boolean f5918a = false;

        /* renamed from: b */
        boolean f5919b = false;

        /* renamed from: c */
        boolean f5920c = false;

        /* renamed from: d */
        final /* synthetic */ OnOverScrollListener f5921d;

        AnonymousClass5(OnOverScrollListener onOverScrollListener) {
            onOverScrollListener = onOverScrollListener;
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i2) {
            if (i2 != 0) {
                if (i2 == 1) {
                    this.f5920c = true;
                    return;
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    this.f5918a = false;
                    this.f5919b = false;
                    return;
                }
            }
            RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
            if (adapter == null || adapter.getItemCount() <= 1 || !this.f5920c) {
                return;
            }
            if (1 == ViewPager2.this.getOrientation()) {
                if (ViewPager2.this.canScrollVertically(-1)) {
                    if (!ViewPager2.this.canScrollVertically(1)) {
                        if (this.f5919b) {
                            onOverScrollListener.onOverScrollEnd();
                        } else {
                            this.f5919b = true;
                        }
                    }
                } else if (this.f5918a) {
                    onOverScrollListener.onOverScrollStart();
                } else {
                    this.f5918a = true;
                }
            } else if (ViewPager2.this.getOrientation() == 0) {
                if (ViewPager2.this.canScrollHorizontally(-1)) {
                    if (!ViewPager2.this.canScrollHorizontally(1)) {
                        if (this.f5919b) {
                            onOverScrollListener.onOverScrollEnd();
                        } else {
                            this.f5919b = true;
                        }
                    }
                } else if (this.f5918a) {
                    onOverScrollListener.onOverScrollStart();
                } else {
                    this.f5918a = true;
                }
            }
            this.f5920c = false;
        }
    }

    private abstract class AccessibilityProvider {
        private AccessibilityProvider() {
        }

        void a(@NonNull AccessibilityEvent accessibilityEvent) {
        }

        void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        void a(@Nullable RecyclerView.Adapter<?> adapter) {
        }

        void a(@NonNull CompositeOnPageChangeCallback compositeOnPageChangeCallback, @NonNull RecyclerView recyclerView) {
        }

        boolean a() {
            return false;
        }

        boolean a(int i2, Bundle bundle) {
            return false;
        }

        String b() {
            throw new IllegalStateException("Not implemented.");
        }

        void b(@Nullable RecyclerView.Adapter<?> adapter) {
        }

        void c() {
        }

        void d() {
        }

        void e() {
        }

        void f() {
        }

        void g() {
        }

        boolean handlesLmPerformAccessibilityAction(int i2) {
            return false;
        }

        boolean handlesRvGetAccessibilityClassName() {
            return false;
        }

        void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        boolean onLmPerformAccessibilityAction(int i2) {
            throw new IllegalStateException("Not implemented.");
        }

        CharSequence onRvGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        /* synthetic */ AccessibilityProvider(ViewPager2 viewPager2, AnonymousClass1 anonymousClass1) {
            this();
        }

        boolean b(int i2, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }
    }

    class BasicAccessibilityProvider extends AccessibilityProvider {
        BasicAccessibilityProvider() {
            super();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean handlesLmPerformAccessibilityAction(int i2) {
            return (i2 == 8192 || i2 == 4096) && !ViewPager2.this.isUserInputEnabled();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean handlesRvGetAccessibilityClassName() {
            return true;
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (ViewPager2.this.isUserInputEnabled()) {
                return;
            }
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfoCompat.setScrollable(false);
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean onLmPerformAccessibilityAction(int i2) {
            if (handlesLmPerformAccessibilityAction(i2)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public CharSequence onRvGetAccessibilityClassName() {
            if (handlesRvGetAccessibilityClassName()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    public static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i2, int i3, int i4) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i2, int i3, @Nullable Object obj) {
            onChanged();
        }
    }

    private class LinearLayoutManagerImpl extends LinearLayoutManager {
        LinearLayoutManagerImpl(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected int getExtraLayoutSpace(RecyclerView.State state) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            return offscreenPageLimit == -1 ? super.getExtraLayoutSpace(state) : ViewPager2.this.b() * offscreenPageLimit;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
            ViewPager2.this.l.onLmInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int i2, @Nullable Bundle bundle) {
            return ViewPager2.this.l.handlesLmPerformAccessibilityAction(i2) ? ViewPager2.this.l.onLmPerformAccessibilityAction(i2) : super.performAccessibilityAction(recycler, state, i2, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z, boolean z2) {
            return false;
        }
    }

    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    public @interface OffscreenPageLimit {
    }

    public interface OnOverScrollListener {
        void onOverScrollEnd();

        void onOverScrollStart();
    }

    public static abstract class OnPageChangeCallback {
        public void onPageScrollStateChanged(int i2) {
        }

        public void onPageScrolled(int i2, float f2, @Px int i3) {
        }

        public void onPageSelected(int i2) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public interface PageTransformer {
        void transformPage(@NonNull View view, float f2);
    }

    private class PagerSnapHelperImpl extends PagerSnapHelper {
        PagerSnapHelperImpl() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        @Nullable
        public View findSnapView(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.isFakeDragging()) {
                return null;
            }
            return super.findSnapView(layoutManager);
        }
    }

    private class RecyclerViewImpl extends RecyclerView {
        RecyclerViewImpl(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        @RequiresApi(23)
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.l.handlesRvGetAccessibilityClassName() ? ViewPager2.this.l.onRvGetAccessibilityClassName() : super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f5911h);
            accessibilityEvent.setToIndex(ViewPager2.this.f5911h);
            ViewPager2.this.l.a(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onTouchEvent(motionEvent);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollState {
    }

    private static class SmoothScrollToPosition implements Runnable {

        /* renamed from: a */
        private final int f5932a;

        /* renamed from: b */
        private final RecyclerView f5933b;

        SmoothScrollToPosition(int i2, RecyclerView recyclerView) {
            this.f5932a = i2;
            this.f5933b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5933b.smoothScrollToPosition(this.f5932a);
        }
    }

    public ViewPager2(@NonNull Context context) {
        super(context);
        this.m = new Rect();
        this.n = new Rect();
        this.o = new CompositeOnPageChangeCallback(3);
        this.f5912i = false;
        this.p = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            AnonymousClass1() {
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f5912i = true;
                viewPager2.k.a();
            }
        };
        this.r = -1;
        this.x = null;
        this.y = false;
        this.z = true;
        this.A = -1;
        a(context, (AttributeSet) null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.l = new BasicAccessibilityProvider();
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.f5913j = recyclerViewImpl;
        recyclerViewImpl.setId(ViewCompatDelegate.generateViewId());
        this.f5913j.setDescendantFocusability(131072);
        LinearLayoutManagerImpl linearLayoutManagerImpl = new LinearLayoutManagerImpl(context);
        this.q = linearLayoutManagerImpl;
        this.f5913j.setLayoutManager(linearLayoutManagerImpl);
        this.f5913j.setScrollingTouchSlop(1);
        setOrientation(0);
        this.f5913j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f5913j.addOnChildAttachStateChangeListener(e());
        ScrollEventAdapter scrollEventAdapter = new ScrollEventAdapter(this);
        this.k = scrollEventAdapter;
        this.v = new FakeDrag(this, scrollEventAdapter, this.f5913j);
        PagerSnapHelperImpl pagerSnapHelperImpl = new PagerSnapHelperImpl();
        this.t = pagerSnapHelperImpl;
        pagerSnapHelperImpl.attachToRecyclerView(this.f5913j);
        this.f5913j.addOnScrollListener(this.k);
        CompositeOnPageChangeCallback compositeOnPageChangeCallback = new CompositeOnPageChangeCallback(3);
        this.u = compositeOnPageChangeCallback;
        this.k.a(compositeOnPageChangeCallback);
        AnonymousClass2 anonymousClass2 = new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.2
            AnonymousClass2() {
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i2) {
                if (i2 == 0) {
                    ViewPager2.this.a();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i2) {
                ViewPager2 viewPager2 = ViewPager2.this;
                if (viewPager2.f5911h != i2) {
                    viewPager2.f5911h = i2;
                    viewPager2.l.e();
                }
            }
        };
        AnonymousClass3 anonymousClass3 = new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.3
            AnonymousClass3() {
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i2) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.f5913j.requestFocus(2);
                }
            }
        };
        this.u.a(anonymousClass2);
        this.u.a(anonymousClass3);
        this.l.a(this.u, this.f5913j);
        this.u.a(this.o);
        PageTransformerAdapter pageTransformerAdapter = new PageTransformerAdapter(this.q);
        this.w = pageTransformerAdapter;
        this.u.a(pageTransformerAdapter);
        RecyclerView recyclerView = this.f5913j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void b(@Nullable RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.p);
        }
    }

    private RecyclerView.OnChildAttachStateChangeListener e() {
        return new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.4
            AnonymousClass4() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewAttachedToWindow(@NonNull View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) layoutParams).width != -1 || ((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewDetachedFromWindow(@NonNull View view) {
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f() {
        RecyclerView.Adapter adapter;
        if (this.r == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.s;
        if (parcelable != null) {
            if (adapter instanceof StatefulAdapter) {
                ((StatefulAdapter) adapter).restoreState(parcelable);
            }
            this.s = null;
        }
        int max = Math.max(0, Math.min(this.r, adapter.getItemCount() - 1));
        this.f5911h = max;
        this.r = -1;
        this.f5913j.scrollToPosition(max);
        this.l.c();
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.f5913j.addItemDecoration(itemDecoration);
    }

    public boolean beginFakeDrag() {
        return this.v.b();
    }

    boolean c() {
        return this.q.getLayoutDirection() == 1;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        return this.f5913j.canScrollHorizontally(i2);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i2) {
        return this.f5913j.canScrollVertically(i2);
    }

    void d() {
        View findSnapView = this.t.findSnapView(this.q);
        if (findSnapView == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = this.t.calculateDistanceToFinalSnap(this.q, findSnapView);
        if (calculateDistanceToFinalSnap[0] == 0 && calculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.f5913j.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i2 = ((SavedState) parcelable).f5929a;
            sparseArray.put(this.f5913j.getId(), sparseArray.get(i2));
            sparseArray.remove(i2);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        f();
    }

    public boolean endFakeDrag() {
        return this.v.c();
    }

    public boolean fakeDragBy(@Px @SuppressLint({"SupportAnnotationUsage"}) float f2) {
        return this.v.a(f2);
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(23)
    public CharSequence getAccessibilityClassName() {
        return this.l.a() ? this.l.b() : super.getAccessibilityClassName();
    }

    @Nullable
    public RecyclerView.Adapter getAdapter() {
        return this.f5913j.getAdapter();
    }

    public int getCurrentItem() {
        return this.f5911h;
    }

    @NonNull
    public RecyclerView.ItemDecoration getItemDecorationAt(int i2) {
        return this.f5913j.getItemDecorationAt(i2);
    }

    public int getItemDecorationCount() {
        return this.f5913j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.A;
    }

    public int getOrientation() {
        return this.q.getOrientation();
    }

    public int getScrollState() {
        return this.k.d();
    }

    public void invalidateItemDecorations() {
        this.f5913j.invalidateItemDecorations();
    }

    public boolean isFakeDragging() {
        return this.v.a();
    }

    public boolean isUserInputEnabled() {
        return this.z;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.l.a(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = this.f5913j.getMeasuredWidth();
        int measuredHeight = this.f5913j.getMeasuredHeight();
        this.m.left = getPaddingLeft();
        this.m.right = (i4 - i2) - getPaddingRight();
        this.m.top = getPaddingTop();
        this.m.bottom = (i5 - i3) - getPaddingBottom();
        Gravity.apply(BadgeDrawable.f6713b, measuredWidth, measuredHeight, this.m, this.n);
        RecyclerView recyclerView = this.f5913j;
        Rect rect = this.n;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f5912i) {
            a();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        measureChild(this.f5913j, i2, i3);
        int measuredWidth = this.f5913j.getMeasuredWidth();
        int measuredHeight = this.f5913j.getMeasuredHeight();
        int measuredState = this.f5913j.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, measuredState), ViewGroup.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, measuredState << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.r = savedState.f5930b;
        this.s = savedState.f5931c;
    }

    @Override // android.view.View
    @Nullable
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5929a = this.f5913j.getId();
        int i2 = this.r;
        if (i2 == -1) {
            i2 = this.f5911h;
        }
        savedState.f5930b = i2;
        Parcelable parcelable = this.s;
        if (parcelable != null) {
            savedState.f5931c = parcelable;
        } else {
            Object adapter = this.f5913j.getAdapter();
            if (adapter instanceof StatefulAdapter) {
                savedState.f5931c = ((StatefulAdapter) adapter).saveState();
            }
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(getClass().getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    @RequiresApi(16)
    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        return this.l.a(i2, bundle) ? this.l.b(i2, bundle) : super.performAccessibilityAction(i2, bundle);
    }

    public void registerOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.o.a(onPageChangeCallback);
    }

    public void removeItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.f5913j.removeItemDecoration(itemDecoration);
    }

    public void removeItemDecorationAt(int i2) {
        this.f5913j.removeItemDecorationAt(i2);
    }

    public void requestTransform() {
        if (this.w.a() == null) {
            return;
        }
        double h2 = this.k.h();
        int i2 = (int) h2;
        double d2 = i2;
        Double.isNaN(d2);
        float f2 = (float) (h2 - d2);
        this.w.onPageScrolled(i2, f2, Math.round(b() * f2));
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f5913j.getAdapter();
        this.l.b(adapter2);
        b(adapter2);
        this.f5913j.setAdapter(adapter);
        this.f5911h = 0;
        f();
        this.l.a((RecyclerView.Adapter<?>) adapter);
        a(adapter);
    }

    public void setCurrentItem(int i2) {
        setCurrentItem(i2, true);
    }

    @Override // android.view.View
    @RequiresApi(17)
    public void setLayoutDirection(int i2) {
        super.setLayoutDirection(i2);
        this.l.g();
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1 && i2 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.A = i2;
        this.f5913j.requestLayout();
    }

    public void setOnOverScrollListener(OnOverScrollListener onOverScrollListener) {
        if (onOverScrollListener == null) {
            return;
        }
        registerOnPageChangeCallback(new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.5

            /* renamed from: a */
            boolean f5918a = false;

            /* renamed from: b */
            boolean f5919b = false;

            /* renamed from: c */
            boolean f5920c = false;

            /* renamed from: d */
            final /* synthetic */ OnOverScrollListener f5921d;

            AnonymousClass5(OnOverScrollListener onOverScrollListener2) {
                onOverScrollListener = onOverScrollListener2;
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i2) {
                if (i2 != 0) {
                    if (i2 == 1) {
                        this.f5920c = true;
                        return;
                    } else {
                        if (i2 != 2) {
                            return;
                        }
                        this.f5918a = false;
                        this.f5919b = false;
                        return;
                    }
                }
                RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
                if (adapter == null || adapter.getItemCount() <= 1 || !this.f5920c) {
                    return;
                }
                if (1 == ViewPager2.this.getOrientation()) {
                    if (ViewPager2.this.canScrollVertically(-1)) {
                        if (!ViewPager2.this.canScrollVertically(1)) {
                            if (this.f5919b) {
                                onOverScrollListener.onOverScrollEnd();
                            } else {
                                this.f5919b = true;
                            }
                        }
                    } else if (this.f5918a) {
                        onOverScrollListener.onOverScrollStart();
                    } else {
                        this.f5918a = true;
                    }
                } else if (ViewPager2.this.getOrientation() == 0) {
                    if (ViewPager2.this.canScrollHorizontally(-1)) {
                        if (!ViewPager2.this.canScrollHorizontally(1)) {
                            if (this.f5919b) {
                                onOverScrollListener.onOverScrollEnd();
                            } else {
                                this.f5919b = true;
                            }
                        }
                    } else if (this.f5918a) {
                        onOverScrollListener.onOverScrollStart();
                    } else {
                        this.f5918a = true;
                    }
                }
                this.f5920c = false;
            }
        });
    }

    public void setOrientation(int i2) {
        this.q.setOrientation(i2);
        this.l.d();
    }

    public void setPageTransformer(@Nullable PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.y) {
                this.x = this.f5913j.getItemAnimator();
                this.y = true;
            }
            this.f5913j.setItemAnimator(null);
        } else if (this.y) {
            this.f5913j.setItemAnimator(this.x);
            this.x = null;
            this.y = false;
        }
        if (pageTransformer == this.w.a()) {
            return;
        }
        this.w.a(pageTransformer);
        requestTransform();
    }

    public void setUserInputEnabled(boolean z) {
        this.z = z;
        this.l.f();
    }

    public void unregisterOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.o.b(onPageChangeCallback);
    }

    static class SavedState extends View.BaseSavedState {

        /* renamed from: d */
        public static final Parcelable.Creator<SavedState> f5928d = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState.1
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, (ClassLoader) null);
            }
        };

        /* renamed from: a */
        int f5929a;

        /* renamed from: b */
        int f5930b;

        /* renamed from: c */
        Parcelable f5931c;

        /* renamed from: com.baidu.mobads.sdk.internal.widget.ViewPager2$SavedState$1 */
        final class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, (ClassLoader) null);
            }
        }

        @RequiresApi(24)
        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f5929a = parcel.readInt();
            this.f5930b = parcel.readInt();
            this.f5931c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f5929a);
            parcel.writeInt(this.f5930b);
            parcel.writeParcelable(this.f5931c, i2);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            a(parcel, null);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration, int i2) {
        this.f5913j.addItemDecoration(itemDecoration, i2);
    }

    int b() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f5913j;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public void setCurrentItem(int i2, boolean z) {
        if (isFakeDragging()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        a(i2, z);
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = new Rect();
        this.n = new Rect();
        this.o = new CompositeOnPageChangeCallback(3);
        this.f5912i = false;
        this.p = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            AnonymousClass1() {
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f5912i = true;
                viewPager2.k.a();
            }
        };
        this.r = -1;
        this.x = null;
        this.y = false;
        this.z = true;
        this.A = -1;
        a(context, attributeSet);
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = new Rect();
        this.n = new Rect();
        this.o = new CompositeOnPageChangeCallback(3);
        this.f5912i = false;
        this.p = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            AnonymousClass1() {
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f5912i = true;
                viewPager2.k.a();
            }
        };
        this.r = -1;
        this.x = null;
        this.y = false;
        this.z = true;
        this.A = -1;
        a(context, attributeSet);
    }

    private void a(@Nullable RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.p);
        }
    }

    void a() {
        PagerSnapHelper pagerSnapHelper = this.t;
        if (pagerSnapHelper != null) {
            View findSnapView = pagerSnapHelper.findSnapView(this.q);
            if (findSnapView == null) {
                return;
            }
            int position = this.q.getPosition(findSnapView);
            if (position != this.f5911h && getScrollState() == 0) {
                this.u.onPageSelected(position);
            }
            this.f5912i = false;
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    void a(int i2, boolean z) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.r != -1) {
                this.r = Math.max(i2, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int min = Math.min(Math.max(i2, 0), adapter.getItemCount() - 1);
        if (min == this.f5911h && this.k.e()) {
            return;
        }
        int i3 = this.f5911h;
        if (min == i3 && z) {
            return;
        }
        double d2 = i3;
        this.f5911h = min;
        this.l.e();
        if (!this.k.e()) {
            d2 = this.k.h();
        }
        this.k.a(min, z);
        if (!z) {
            this.f5913j.scrollToPosition(min);
            return;
        }
        double d3 = min;
        Double.isNaN(d3);
        if (Math.abs(d3 - d2) > 3.0d) {
            this.f5913j.scrollToPosition(d3 > d2 ? min - 3 : min + 3);
            RecyclerView recyclerView = this.f5913j;
            recyclerView.post(new SmoothScrollToPosition(min, recyclerView));
            return;
        }
        this.f5913j.smoothScrollToPosition(min);
    }

    @RequiresApi(21)
    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.m = new Rect();
        this.n = new Rect();
        this.o = new CompositeOnPageChangeCallback(3);
        this.f5912i = false;
        this.p = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            AnonymousClass1() {
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f5912i = true;
                viewPager2.k.a();
            }
        };
        this.r = -1;
        this.x = null;
        this.y = false;
        this.z = true;
        this.A = -1;
        a(context, attributeSet);
    }
}
