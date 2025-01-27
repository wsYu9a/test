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

/* loaded from: classes2.dex */
public class ViewPager2 extends ViewGroup {

    /* renamed from: a */
    public static final int f7305a = 0;

    /* renamed from: b */
    public static final int f7306b = 1;

    /* renamed from: c */
    public static final int f7307c = 0;

    /* renamed from: d */
    public static final int f7308d = 1;

    /* renamed from: e */
    public static final int f7309e = 2;

    /* renamed from: f */
    public static final int f7310f = -1;

    /* renamed from: g */
    static boolean f7311g = true;
    private boolean A;
    private int B;

    /* renamed from: h */
    int f7312h;

    /* renamed from: i */
    boolean f7313i;

    /* renamed from: j */
    RecyclerView f7314j;

    /* renamed from: k */
    ScrollEventAdapter f7315k;

    /* renamed from: l */
    AccessibilityProvider f7316l;

    /* renamed from: m */
    private final Rect f7317m;

    /* renamed from: n */
    private final Rect f7318n;

    /* renamed from: o */
    private final int[] f7319o;

    /* renamed from: p */
    private CompositeOnPageChangeCallback f7320p;

    /* renamed from: q */
    private RecyclerView.AdapterDataObserver f7321q;

    /* renamed from: r */
    private LinearLayoutManager f7322r;

    /* renamed from: s */
    private int f7323s;

    /* renamed from: t */
    private Parcelable f7324t;

    /* renamed from: u */
    private PagerSnapHelper f7325u;

    /* renamed from: v */
    private CompositeOnPageChangeCallback f7326v;

    /* renamed from: w */
    private FakeDrag f7327w;

    /* renamed from: x */
    private PageTransformerAdapter f7328x;

    /* renamed from: y */
    private RecyclerView.ItemAnimator f7329y;

    /* renamed from: z */
    private boolean f7330z;

    /* renamed from: com.baidu.mobads.sdk.internal.widget.ViewPager2$1 */
    class AnonymousClass1 extends DataSetChangeObserver {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f7313i = true;
            viewPager2.f7315k.a();
        }
    }

    /* renamed from: com.baidu.mobads.sdk.internal.widget.ViewPager2$2 */
    class AnonymousClass2 extends OnPageChangeCallback {
        public AnonymousClass2() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i10) {
            if (i10 == 0) {
                ViewPager2.this.a();
            }
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i10) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.f7312h != i10) {
                viewPager2.f7312h = i10;
                viewPager2.f7316l.e();
            }
        }
    }

    /* renamed from: com.baidu.mobads.sdk.internal.widget.ViewPager2$3 */
    class AnonymousClass3 extends OnPageChangeCallback {
        public AnonymousClass3() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i10) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.f7314j.requestFocus(2);
            }
        }
    }

    /* renamed from: com.baidu.mobads.sdk.internal.widget.ViewPager2$4 */
    class AnonymousClass4 implements RecyclerView.OnChildAttachStateChangeListener {
        public AnonymousClass4() {
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
        boolean f7335a = false;

        /* renamed from: b */
        boolean f7336b = false;

        /* renamed from: c */
        boolean f7337c = false;

        /* renamed from: d */
        final /* synthetic */ OnOverScrollListener f7338d;

        public AnonymousClass5(OnOverScrollListener onOverScrollListener) {
            onOverScrollListener = onOverScrollListener;
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i10) {
            if (i10 != 0) {
                if (i10 == 1) {
                    this.f7337c = true;
                    return;
                } else {
                    if (i10 != 2) {
                        return;
                    }
                    this.f7335a = false;
                    this.f7336b = false;
                    return;
                }
            }
            RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
            if (adapter == null || adapter.getPageSize() <= 0 || !this.f7337c) {
                return;
            }
            if (1 == ViewPager2.this.getOrientation()) {
                if (!ViewPager2.this.canScrollVertically(-1) && ViewPager2.this.getOverScrolledDirection() < 0) {
                    onOverScrollListener.onOverScrollStart();
                } else if (!ViewPager2.this.canScrollVertically(1) && ViewPager2.this.getOverScrolledDirection() > 0) {
                    onOverScrollListener.onOverScrollEnd();
                }
            } else if (ViewPager2.this.getOrientation() == 0) {
                if (!ViewPager2.this.canScrollHorizontally(-1) && ViewPager2.this.getOverScrolledDirection() < 0) {
                    onOverScrollListener.onOverScrollStart();
                } else if (!ViewPager2.this.canScrollHorizontally(1) && ViewPager2.this.getOverScrolledDirection() > 0) {
                    onOverScrollListener.onOverScrollEnd();
                }
            }
            this.f7337c = false;
        }
    }

    public abstract class AccessibilityProvider {
        private AccessibilityProvider() {
        }

        public void a(@NonNull AccessibilityEvent accessibilityEvent) {
        }

        public void b(@Nullable RecyclerView.Adapter<?> adapter) {
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }

        public void f() {
        }

        public void g() {
        }

        public boolean handlesLmPerformAccessibilityAction(int i10) {
            return false;
        }

        public boolean handlesRvGetAccessibilityClassName() {
            return false;
        }

        public void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public boolean onLmPerformAccessibilityAction(int i10) {
            throw new IllegalStateException("Not implemented.");
        }

        public CharSequence onRvGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        public /* synthetic */ AccessibilityProvider(ViewPager2 viewPager2, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        public String b() {
            throw new IllegalStateException("Not implemented.");
        }

        public void a(@Nullable RecyclerView.Adapter<?> adapter) {
        }

        public boolean b(int i10, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        public void a(@NonNull CompositeOnPageChangeCallback compositeOnPageChangeCallback, @NonNull RecyclerView recyclerView) {
        }

        public boolean a() {
            return false;
        }

        public boolean a(int i10, Bundle bundle) {
            return false;
        }
    }

    public class BasicAccessibilityProvider extends AccessibilityProvider {
        public BasicAccessibilityProvider() {
            super();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean handlesLmPerformAccessibilityAction(int i10) {
            return (i10 == 8192 || i10 == 4096) && !ViewPager2.this.isUserInputEnabled();
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
        public boolean onLmPerformAccessibilityAction(int i10) {
            if (handlesLmPerformAccessibilityAction(i10)) {
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
        public final void onItemRangeChanged(int i10, int i11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i10, int i11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i10, int i11, int i12) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i10, int i11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i10, int i11, @Nullable Object obj) {
            onChanged();
        }
    }

    public class LinearLayoutManagerImpl extends LinearLayoutManager {
        public LinearLayoutManagerImpl(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public int getExtraLayoutSpace(RecyclerView.State state) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            return offscreenPageLimit == -1 ? super.getExtraLayoutSpace(state) : ViewPager2.this.b() * offscreenPageLimit;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
            ViewPager2.this.f7316l.onLmInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int i10, @Nullable Bundle bundle) {
            return ViewPager2.this.f7316l.handlesLmPerformAccessibilityAction(i10) ? ViewPager2.this.f7316l.onLmPerformAccessibilityAction(i10) : super.performAccessibilityAction(recycler, state, i10, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z10, boolean z11) {
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
        public void onPageScrollStateChanged(int i10) {
        }

        public void onPageScrolled(int i10, float f10, @Px int i11) {
        }

        public void onPageSelected(int i10) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public interface PageTransformer {
        void transformPage(@NonNull View view, float f10);
    }

    public class PagerSnapHelperImpl extends PagerSnapHelper {
        public PagerSnapHelperImpl() {
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

    public class RecyclerViewImpl extends RecyclerView {
        public RecyclerViewImpl(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
        public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr, int i14) {
            ViewPager2.this.f7319o[1] = ViewPager2.this.f7319o[0];
            if (1 == ViewPager2.this.getOrientation()) {
                ViewPager2.this.f7319o[0] = i13;
            } else {
                ViewPager2.this.f7319o[0] = i12;
            }
            return super.dispatchNestedScroll(i10, i11, i12, i13, iArr, i14);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        @RequiresApi(23)
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.f7316l.handlesRvGetAccessibilityClassName() ? ViewPager2.this.f7316l.onRvGetAccessibilityClassName() : super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f7312h);
            accessibilityEvent.setToIndex(ViewPager2.this.f7312h);
            ViewPager2.this.f7316l.a(accessibilityEvent);
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

    public static class SmoothScrollToPosition implements Runnable {

        /* renamed from: a */
        private final int f7349a;

        /* renamed from: b */
        private final RecyclerView f7350b;

        public SmoothScrollToPosition(int i10, RecyclerView recyclerView) {
            this.f7349a = i10;
            this.f7350b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7350b.smoothScrollToPosition(this.f7349a);
        }
    }

    public ViewPager2(@NonNull Context context) {
        super(context);
        this.f7317m = new Rect();
        this.f7318n = new Rect();
        this.f7319o = new int[2];
        this.f7320p = new CompositeOnPageChangeCallback(3);
        this.f7313i = false;
        this.f7321q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            public AnonymousClass1() {
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f7313i = true;
                viewPager2.f7315k.a();
            }
        };
        this.f7323s = -1;
        this.f7329y = null;
        this.f7330z = false;
        this.A = true;
        this.B = -1;
        a(context, (AttributeSet) null);
    }

    private void b(@Nullable RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.f7321q);
        }
    }

    private RecyclerView.OnChildAttachStateChangeListener e() {
        return new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.4
            public AnonymousClass4() {
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
        if (this.f7323s == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.f7324t;
        if (parcelable != null) {
            if (adapter instanceof StatefulAdapter) {
                ((StatefulAdapter) adapter).restoreState(parcelable);
            }
            this.f7324t = null;
        }
        int max = Math.max(0, Math.min(this.f7323s, adapter.getPageSize() - 1));
        this.f7312h = max;
        this.f7323s = -1;
        this.f7314j.scrollToPosition(max);
        this.f7316l.c();
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.f7314j.addItemDecoration(itemDecoration);
    }

    public boolean beginFakeDrag() {
        return this.f7327w.b();
    }

    public boolean c() {
        return this.f7322r.getLayoutDirection() == 1;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        return this.f7314j.canScrollHorizontally(i10);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i10) {
        return this.f7314j.canScrollVertically(i10);
    }

    public void d() {
        View findSnapView = this.f7325u.findSnapView(this.f7322r);
        if (findSnapView == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = this.f7325u.calculateDistanceToFinalSnap(this.f7322r, findSnapView);
        int i10 = calculateDistanceToFinalSnap[0];
        if (i10 == 0 && calculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.f7314j.smoothScrollBy(i10, calculateDistanceToFinalSnap[1]);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i10 = ((SavedState) parcelable).f7346a;
            sparseArray.put(this.f7314j.getId(), sparseArray.get(i10));
            sparseArray.remove(i10);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        f();
    }

    public boolean endFakeDrag() {
        return this.f7327w.c();
    }

    public boolean fakeDragBy(@Px @SuppressLint({"SupportAnnotationUsage"}) float f10) {
        return this.f7327w.a(f10);
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(23)
    public CharSequence getAccessibilityClassName() {
        return this.f7316l.a() ? this.f7316l.b() : super.getAccessibilityClassName();
    }

    @Nullable
    public RecyclerView.Adapter getAdapter() {
        return this.f7314j.getAdapter();
    }

    public int getCurrentItem() {
        return this.f7312h;
    }

    @NonNull
    public RecyclerView.ItemDecoration getItemDecorationAt(int i10) {
        return this.f7314j.getItemDecorationAt(i10);
    }

    public int getItemDecorationCount() {
        return this.f7314j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.B;
    }

    public int getOrientation() {
        return this.f7322r.getOrientation();
    }

    public int getOverScrolledDirection() {
        int[] iArr = this.f7319o;
        int i10 = iArr[0];
        return i10 == 0 ? iArr[1] : i10;
    }

    public int getScrollState() {
        return this.f7315k.d();
    }

    public void invalidateItemDecorations() {
        this.f7314j.invalidateItemDecorations();
    }

    public boolean isFakeDragging() {
        return this.f7327w.a();
    }

    public boolean isUserInputEnabled() {
        return this.A;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f7316l.a(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = this.f7314j.getMeasuredWidth();
        int measuredHeight = this.f7314j.getMeasuredHeight();
        this.f7317m.left = getPaddingLeft();
        this.f7317m.right = (i12 - i10) - getPaddingRight();
        this.f7317m.top = getPaddingTop();
        this.f7317m.bottom = (i13 - i11) - getPaddingBottom();
        Gravity.apply(BadgeDrawable.TOP_START, measuredWidth, measuredHeight, this.f7317m, this.f7318n);
        RecyclerView recyclerView = this.f7314j;
        Rect rect = this.f7318n;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f7313i) {
            a();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        measureChild(this.f7314j, i10, i11);
        int measuredWidth = this.f7314j.getMeasuredWidth();
        int measuredHeight = this.f7314j.getMeasuredHeight();
        int measuredState = this.f7314j.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i10, measuredState), View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i11, measuredState << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f7323s = savedState.f7347b;
        this.f7324t = savedState.f7348c;
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f7346a = this.f7314j.getId();
        int i10 = this.f7323s;
        if (i10 == -1) {
            i10 = this.f7312h;
        }
        savedState.f7347b = i10;
        Parcelable parcelable = this.f7324t;
        if (parcelable != null) {
            savedState.f7348c = parcelable;
        } else {
            Object adapter = this.f7314j.getAdapter();
            if (adapter instanceof StatefulAdapter) {
                savedState.f7348c = ((StatefulAdapter) adapter).saveState();
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
    public boolean performAccessibilityAction(int i10, Bundle bundle) {
        return this.f7316l.a(i10, bundle) ? this.f7316l.b(i10, bundle) : super.performAccessibilityAction(i10, bundle);
    }

    public void registerOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.f7320p.a(onPageChangeCallback);
    }

    public void removeItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.f7314j.removeItemDecoration(itemDecoration);
    }

    public void removeItemDecorationAt(int i10) {
        this.f7314j.removeItemDecorationAt(i10);
    }

    public void requestTransform() {
        if (this.f7328x.a() == null) {
            return;
        }
        double h10 = this.f7315k.h();
        int i10 = (int) h10;
        float f10 = (float) (h10 - i10);
        this.f7328x.onPageScrolled(i10, f10, Math.round(b() * f10));
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f7314j.getAdapter();
        this.f7316l.b(adapter2);
        b(adapter2);
        this.f7314j.setAdapter(adapter);
        this.f7312h = 0;
        f();
        this.f7316l.a((RecyclerView.Adapter<?>) adapter);
        a((RecyclerView.Adapter<?>) adapter);
    }

    public void setCurrentItem(int i10) {
        setCurrentItem(i10, true);
    }

    @Override // android.view.View
    @RequiresApi(17)
    public void setLayoutDirection(int i10) {
        super.setLayoutDirection(i10);
        this.f7316l.g();
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 < 1 && i10 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.B = i10;
        this.f7314j.requestLayout();
    }

    public void setOnOverScrollListener(OnOverScrollListener onOverScrollListener) {
        if (onOverScrollListener == null) {
            return;
        }
        registerOnPageChangeCallback(new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.5

            /* renamed from: a */
            boolean f7335a = false;

            /* renamed from: b */
            boolean f7336b = false;

            /* renamed from: c */
            boolean f7337c = false;

            /* renamed from: d */
            final /* synthetic */ OnOverScrollListener f7338d;

            public AnonymousClass5(OnOverScrollListener onOverScrollListener2) {
                onOverScrollListener = onOverScrollListener2;
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i10) {
                if (i10 != 0) {
                    if (i10 == 1) {
                        this.f7337c = true;
                        return;
                    } else {
                        if (i10 != 2) {
                            return;
                        }
                        this.f7335a = false;
                        this.f7336b = false;
                        return;
                    }
                }
                RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
                if (adapter == null || adapter.getPageSize() <= 0 || !this.f7337c) {
                    return;
                }
                if (1 == ViewPager2.this.getOrientation()) {
                    if (!ViewPager2.this.canScrollVertically(-1) && ViewPager2.this.getOverScrolledDirection() < 0) {
                        onOverScrollListener.onOverScrollStart();
                    } else if (!ViewPager2.this.canScrollVertically(1) && ViewPager2.this.getOverScrolledDirection() > 0) {
                        onOverScrollListener.onOverScrollEnd();
                    }
                } else if (ViewPager2.this.getOrientation() == 0) {
                    if (!ViewPager2.this.canScrollHorizontally(-1) && ViewPager2.this.getOverScrolledDirection() < 0) {
                        onOverScrollListener.onOverScrollStart();
                    } else if (!ViewPager2.this.canScrollHorizontally(1) && ViewPager2.this.getOverScrolledDirection() > 0) {
                        onOverScrollListener.onOverScrollEnd();
                    }
                }
                this.f7337c = false;
            }
        });
    }

    public void setOrientation(int i10) {
        this.f7322r.setOrientation(i10);
        this.f7316l.d();
    }

    public void setPageTransformer(@Nullable PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.f7330z) {
                this.f7329y = this.f7314j.getItemAnimator();
                this.f7330z = true;
            }
            this.f7314j.setItemAnimator(null);
        } else if (this.f7330z) {
            this.f7314j.setItemAnimator(this.f7329y);
            this.f7329y = null;
            this.f7330z = false;
        }
        if (pageTransformer == this.f7328x.a()) {
            return;
        }
        this.f7328x.a(pageTransformer);
        requestTransform();
    }

    public void setUserInputEnabled(boolean z10) {
        this.A = z10;
        this.f7316l.f();
    }

    public void unregisterOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.f7320p.b(onPageChangeCallback);
    }

    public static class SavedState extends View.BaseSavedState {

        /* renamed from: d */
        public static final Parcelable.Creator<SavedState> f7345d = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
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
        int f7346a;

        /* renamed from: b */
        int f7347b;

        /* renamed from: c */
        Parcelable f7348c;

        /* renamed from: com.baidu.mobads.sdk.internal.widget.ViewPager2$SavedState$1 */
        final class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
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
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f7346a = parcel.readInt();
            this.f7347b = parcel.readInt();
            this.f7348c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f7346a);
            parcel.writeInt(this.f7347b);
            parcel.writeParcelable(this.f7348c, i10);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            a(parcel, null);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f7316l = new BasicAccessibilityProvider();
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.f7314j = recyclerViewImpl;
        recyclerViewImpl.setId(ViewCompatDelegate.generateViewId());
        this.f7314j.setDescendantFocusability(131072);
        LinearLayoutManagerImpl linearLayoutManagerImpl = new LinearLayoutManagerImpl(context);
        this.f7322r = linearLayoutManagerImpl;
        this.f7314j.setLayoutManager(linearLayoutManagerImpl);
        this.f7314j.setScrollingTouchSlop(1);
        setOrientation(0);
        this.f7314j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f7314j.addOnChildAttachStateChangeListener(e());
        ScrollEventAdapter scrollEventAdapter = new ScrollEventAdapter(this);
        this.f7315k = scrollEventAdapter;
        this.f7327w = new FakeDrag(this, scrollEventAdapter, this.f7314j);
        PagerSnapHelperImpl pagerSnapHelperImpl = new PagerSnapHelperImpl();
        this.f7325u = pagerSnapHelperImpl;
        pagerSnapHelperImpl.attachToRecyclerView(this.f7314j);
        this.f7314j.addOnScrollListener(this.f7315k);
        CompositeOnPageChangeCallback compositeOnPageChangeCallback = new CompositeOnPageChangeCallback(3);
        this.f7326v = compositeOnPageChangeCallback;
        this.f7315k.a(compositeOnPageChangeCallback);
        AnonymousClass2 anonymousClass2 = new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.2
            public AnonymousClass2() {
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i10) {
                if (i10 == 0) {
                    ViewPager2.this.a();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i10) {
                ViewPager2 viewPager2 = ViewPager2.this;
                if (viewPager2.f7312h != i10) {
                    viewPager2.f7312h = i10;
                    viewPager2.f7316l.e();
                }
            }
        };
        AnonymousClass3 anonymousClass3 = new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.3
            public AnonymousClass3() {
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i10) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.f7314j.requestFocus(2);
                }
            }
        };
        this.f7326v.a(anonymousClass2);
        this.f7326v.a(anonymousClass3);
        this.f7316l.a(this.f7326v, this.f7314j);
        this.f7326v.a(this.f7320p);
        PageTransformerAdapter pageTransformerAdapter = new PageTransformerAdapter(this.f7322r);
        this.f7328x = pageTransformerAdapter;
        this.f7326v.a(pageTransformerAdapter);
        RecyclerView recyclerView = this.f7314j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration, int i10) {
        this.f7314j.addItemDecoration(itemDecoration, i10);
    }

    public int b() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f7314j;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public void setCurrentItem(int i10, boolean z10) {
        if (isFakeDragging()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        a(i10, z10);
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7317m = new Rect();
        this.f7318n = new Rect();
        this.f7319o = new int[2];
        this.f7320p = new CompositeOnPageChangeCallback(3);
        this.f7313i = false;
        this.f7321q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            public AnonymousClass1() {
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f7313i = true;
                viewPager2.f7315k.a();
            }
        };
        this.f7323s = -1;
        this.f7329y = null;
        this.f7330z = false;
        this.A = true;
        this.B = -1;
        a(context, attributeSet);
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7317m = new Rect();
        this.f7318n = new Rect();
        this.f7319o = new int[2];
        this.f7320p = new CompositeOnPageChangeCallback(3);
        this.f7313i = false;
        this.f7321q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            public AnonymousClass1() {
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f7313i = true;
                viewPager2.f7315k.a();
            }
        };
        this.f7323s = -1;
        this.f7329y = null;
        this.f7330z = false;
        this.A = true;
        this.B = -1;
        a(context, attributeSet);
    }

    private void a(@Nullable RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f7321q);
        }
    }

    public void a() {
        PagerSnapHelper pagerSnapHelper = this.f7325u;
        if (pagerSnapHelper != null) {
            View findSnapView = pagerSnapHelper.findSnapView(this.f7322r);
            if (findSnapView == null) {
                return;
            }
            int position = this.f7322r.getPosition(findSnapView);
            if (position != this.f7312h && getScrollState() == 0) {
                this.f7326v.onPageSelected(position);
            }
            this.f7313i = false;
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public void a(int i10, boolean z10) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.f7323s != -1) {
                this.f7323s = Math.max(i10, 0);
                return;
            }
            return;
        }
        if (adapter.getPageSize() <= 0) {
            return;
        }
        int min = Math.min(Math.max(i10, 0), adapter.getPageSize() - 1);
        if (min == this.f7312h && this.f7315k.e()) {
            return;
        }
        int i11 = this.f7312h;
        if (min == i11 && z10) {
            return;
        }
        double d10 = i11;
        this.f7312h = min;
        this.f7316l.e();
        if (!this.f7315k.e()) {
            d10 = this.f7315k.h();
        }
        this.f7315k.a(min, z10);
        if (!z10) {
            this.f7314j.scrollToPosition(min);
            return;
        }
        double d11 = min;
        if (Math.abs(d11 - d10) > 3.0d) {
            this.f7314j.scrollToPosition(d11 > d10 ? min - 3 : min + 3);
            RecyclerView recyclerView = this.f7314j;
            recyclerView.post(new SmoothScrollToPosition(min, recyclerView));
            return;
        }
        this.f7314j.smoothScrollToPosition(min);
    }

    @RequiresApi(21)
    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f7317m = new Rect();
        this.f7318n = new Rect();
        this.f7319o = new int[2];
        this.f7320p = new CompositeOnPageChangeCallback(3);
        this.f7313i = false;
        this.f7321q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            public AnonymousClass1() {
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f7313i = true;
                viewPager2.f7315k.a();
            }
        };
        this.f7323s = -1;
        this.f7329y = null;
        this.f7330z = false;
        this.A = true;
        this.B = -1;
        a(context, attributeSet);
    }
}
