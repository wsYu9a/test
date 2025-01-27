package androidx.viewpager2.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
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
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.StatefulAdapter;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {
    public static final int OFFSCREEN_PAGE_LIMIT_DEFAULT = -1;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;

    /* renamed from: a */
    static boolean f4127a = true;

    /* renamed from: b */
    private final Rect f4128b;

    /* renamed from: c */
    private final Rect f4129c;

    /* renamed from: d */
    private CompositeOnPageChangeCallback f4130d;

    /* renamed from: e */
    int f4131e;

    /* renamed from: f */
    boolean f4132f;

    /* renamed from: g */
    private RecyclerView.AdapterDataObserver f4133g;

    /* renamed from: h */
    private LinearLayoutManager f4134h;

    /* renamed from: i */
    private int f4135i;

    /* renamed from: j */
    private Parcelable f4136j;
    RecyclerView k;
    private PagerSnapHelper l;
    ScrollEventAdapter m;
    private CompositeOnPageChangeCallback n;
    private FakeDrag o;
    private PageTransformerAdapter p;
    private RecyclerView.ItemAnimator q;
    private boolean r;
    private boolean s;
    private int t;
    AccessibilityProvider u;

    /* renamed from: androidx.viewpager2.widget.ViewPager2$1 */
    class AnonymousClass1 extends DataSetChangeObserver {
        AnonymousClass1() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f4132f = true;
            viewPager2.m.u();
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$2 */
    class AnonymousClass2 extends OnPageChangeCallback {
        AnonymousClass2() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i2) {
            if (i2 == 0) {
                ViewPager2.this.j();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i2) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.f4131e != i2) {
                viewPager2.f4131e = i2;
                viewPager2.u.onSetNewCurrentItem();
            }
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$3 */
    class AnonymousClass3 extends OnPageChangeCallback {
        AnonymousClass3() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i2) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.k.requestFocus(2);
            }
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$4 */
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

    private abstract class AccessibilityProvider {
        private AccessibilityProvider() {
        }

        boolean handlesGetAccessibilityClassName() {
            return false;
        }

        boolean handlesLmPerformAccessibilityAction(int i2) {
            return false;
        }

        boolean handlesPerformAccessibilityAction(int i2, Bundle bundle) {
            return false;
        }

        boolean handlesRvGetAccessibilityClassName() {
            return false;
        }

        void onAttachAdapter(@Nullable RecyclerView.Adapter<?> adapter) {
        }

        void onDetachAdapter(@Nullable RecyclerView.Adapter<?> adapter) {
        }

        String onGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        void onInitialize(@NonNull CompositeOnPageChangeCallback compositeOnPageChangeCallback, @NonNull RecyclerView recyclerView) {
        }

        void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        boolean onLmPerformAccessibilityAction(int i2) {
            throw new IllegalStateException("Not implemented.");
        }

        boolean onPerformAccessibilityAction(int i2, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        void onRestorePendingState() {
        }

        CharSequence onRvGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        void onRvInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        }

        void onSetLayoutDirection() {
        }

        void onSetNewCurrentItem() {
        }

        void onSetOrientation() {
        }

        void onSetUserInputEnabled() {
        }

        /* synthetic */ AccessibilityProvider(ViewPager2 viewPager2, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    class BasicAccessibilityProvider extends AccessibilityProvider {
        BasicAccessibilityProvider() {
            super();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean handlesLmPerformAccessibilityAction(int i2) {
            return (i2 == 8192 || i2 == 4096) && !ViewPager2.this.isUserInputEnabled();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean handlesRvGetAccessibilityClassName() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (ViewPager2.this.isUserInputEnabled()) {
                return;
            }
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfoCompat.setScrollable(false);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean onLmPerformAccessibilityAction(int i2) {
            if (handlesLmPerformAccessibilityAction(i2)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public CharSequence onRvGetAccessibilityClassName() {
            if (handlesRvGetAccessibilityClassName()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    private static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        private DataSetChangeObserver() {
        }

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

        /* synthetic */ DataSetChangeObserver(AnonymousClass1 anonymousClass1) {
            this();
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
        protected void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(state, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
            ViewPager2.this.u.onLmInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int i2, @Nullable Bundle bundle) {
            return ViewPager2.this.u.handlesLmPerformAccessibilityAction(i2) ? ViewPager2.this.u.onLmPerformAccessibilityAction(i2) : super.performAccessibilityAction(recycler, state, i2, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z, boolean z2) {
            return false;
        }
    }

    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface OffscreenPageLimit {
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
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Orientation {
    }

    class PageAwareAccessibilityProvider extends AccessibilityProvider {

        /* renamed from: b */
        private final AccessibilityViewCommand f4144b;

        /* renamed from: c */
        private final AccessibilityViewCommand f4145c;

        /* renamed from: d */
        private RecyclerView.AdapterDataObserver f4146d;

        /* renamed from: androidx.viewpager2.widget.ViewPager2$PageAwareAccessibilityProvider$1 */
        class AnonymousClass1 implements AccessibilityViewCommand {
            AnonymousClass1() {
            }

            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                PageAwareAccessibilityProvider.this.c(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        /* renamed from: androidx.viewpager2.widget.ViewPager2$PageAwareAccessibilityProvider$2 */
        class AnonymousClass2 implements AccessibilityViewCommand {
            AnonymousClass2() {
            }

            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                PageAwareAccessibilityProvider.this.c(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        /* renamed from: androidx.viewpager2.widget.ViewPager2$PageAwareAccessibilityProvider$3 */
        class AnonymousClass3 extends DataSetChangeObserver {
            AnonymousClass3() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                PageAwareAccessibilityProvider.this.d();
            }
        }

        PageAwareAccessibilityProvider() {
            super();
            this.f4144b = new AccessibilityViewCommand() { // from class: androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.1
                AnonymousClass1() {
                }

                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                    PageAwareAccessibilityProvider.this.c(((ViewPager2) view).getCurrentItem() + 1);
                    return true;
                }
            };
            this.f4145c = new AccessibilityViewCommand() { // from class: androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.2
                AnonymousClass2() {
                }

                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                    PageAwareAccessibilityProvider.this.c(((ViewPager2) view).getCurrentItem() - 1);
                    return true;
                }
            };
        }

        private void a(AccessibilityNodeInfo accessibilityNodeInfo) {
            int i2;
            int i3;
            if (ViewPager2.this.getAdapter() == null) {
                i2 = 0;
            } else {
                if (ViewPager2.this.getOrientation() != 1) {
                    i3 = ViewPager2.this.getAdapter().getItemCount();
                    i2 = 0;
                    AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(i2, i3, false, 0));
                }
                i2 = ViewPager2.this.getAdapter().getItemCount();
            }
            i3 = 0;
            AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(i2, i3, false, 0));
        }

        private void b(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
            if (adapter == null || (itemCount = adapter.getItemCount()) == 0 || !ViewPager2.this.isUserInputEnabled()) {
                return;
            }
            if (ViewPager2.this.f4131e > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (ViewPager2.this.f4131e < itemCount - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
            accessibilityNodeInfo.setScrollable(true);
        }

        void c(int i2) {
            if (ViewPager2.this.isUserInputEnabled()) {
                ViewPager2.this.f(i2, true);
            }
        }

        void d() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i2 = R.id.accessibilityActionPageLeft;
            ViewCompat.removeAccessibilityAction(viewPager2, R.id.accessibilityActionPageLeft);
            ViewCompat.removeAccessibilityAction(viewPager2, R.id.accessibilityActionPageRight);
            ViewCompat.removeAccessibilityAction(viewPager2, R.id.accessibilityActionPageUp);
            ViewCompat.removeAccessibilityAction(viewPager2, R.id.accessibilityActionPageDown);
            if (ViewPager2.this.getAdapter() == null || (itemCount = ViewPager2.this.getAdapter().getItemCount()) == 0 || !ViewPager2.this.isUserInputEnabled()) {
                return;
            }
            if (ViewPager2.this.getOrientation() != 0) {
                if (ViewPager2.this.f4131e < itemCount - 1) {
                    ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageDown, null), null, this.f4144b);
                }
                if (ViewPager2.this.f4131e > 0) {
                    ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageUp, null), null, this.f4145c);
                    return;
                }
                return;
            }
            boolean c2 = ViewPager2.this.c();
            int i3 = c2 ? R.id.accessibilityActionPageLeft : R.id.accessibilityActionPageRight;
            if (c2) {
                i2 = R.id.accessibilityActionPageRight;
            }
            if (ViewPager2.this.f4131e < itemCount - 1) {
                ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i3, null), null, this.f4144b);
            }
            if (ViewPager2.this.f4131e > 0) {
                ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i2, null), null, this.f4145c);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean handlesGetAccessibilityClassName() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean handlesPerformAccessibilityAction(int i2, Bundle bundle) {
            return i2 == 8192 || i2 == 4096;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onAttachAdapter(@Nullable RecyclerView.Adapter<?> adapter) {
            d();
            if (adapter != null) {
                adapter.registerAdapterDataObserver(this.f4146d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onDetachAdapter(@Nullable RecyclerView.Adapter<?> adapter) {
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(this.f4146d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public String onGetAccessibilityClassName() {
            if (handlesGetAccessibilityClassName()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onInitialize(@NonNull CompositeOnPageChangeCallback compositeOnPageChangeCallback, @NonNull RecyclerView recyclerView) {
            ViewCompat.setImportantForAccessibility(recyclerView, 2);
            this.f4146d = new DataSetChangeObserver() { // from class: androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.3
                AnonymousClass3() {
                }

                @Override // androidx.viewpager2.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void onChanged() {
                    PageAwareAccessibilityProvider.this.d();
                }
            };
            if (ViewCompat.getImportantForAccessibility(ViewPager2.this) == 0) {
                ViewCompat.setImportantForAccessibility(ViewPager2.this, 1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            a(accessibilityNodeInfo);
            if (Build.VERSION.SDK_INT >= 16) {
                b(accessibilityNodeInfo);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean onPerformAccessibilityAction(int i2, Bundle bundle) {
            if (!handlesPerformAccessibilityAction(i2, bundle)) {
                throw new IllegalStateException();
            }
            c(i2 == 8192 ? ViewPager2.this.getCurrentItem() - 1 : ViewPager2.this.getCurrentItem() + 1);
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onRestorePendingState() {
            d();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onRvInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(onGetAccessibilityClassName());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onSetLayoutDirection() {
            d();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onSetNewCurrentItem() {
            d();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onSetOrientation() {
            d();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onSetUserInputEnabled() {
            d();
            if (Build.VERSION.SDK_INT < 21) {
                ViewPager2.this.sendAccessibilityEvent(2048);
            }
        }
    }

    public interface PageTransformer {
        void transformPage(@NonNull View view, float f2);
    }

    private class PagerSnapHelperImpl extends PagerSnapHelper {
        PagerSnapHelperImpl() {
        }

        @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        @Nullable
        public View findSnapView(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.isFakeDragging()) {
                return null;
            }
            return super.findSnapView(layoutManager);
        }
    }

    private class RecyclerViewImpl extends RecyclerView {
        RecyclerViewImpl(@NonNull Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        @RequiresApi(23)
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.u.handlesRvGetAccessibilityClassName() ? ViewPager2.this.u.onRvGetAccessibilityClassName() : super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f4131e);
            accessibilityEvent.setToIndex(ViewPager2.this.f4131e);
            ViewPager2.this.u.onRvInitializeAccessibilityEvent(accessibilityEvent);
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
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ScrollState {
    }

    private static class SmoothScrollToPosition implements Runnable {

        /* renamed from: a */
        private final int f4156a;

        /* renamed from: b */
        private final RecyclerView f4157b;

        SmoothScrollToPosition(int i2, RecyclerView recyclerView) {
            this.f4156a = i2;
            this.f4157b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4157b.smoothScrollToPosition(this.f4156a);
        }
    }

    public ViewPager2(@NonNull Context context) {
        super(context);
        this.f4128b = new Rect();
        this.f4129c = new Rect();
        this.f4130d = new CompositeOnPageChangeCallback(3);
        this.f4132f = false;
        this.f4133g = new DataSetChangeObserver() { // from class: androidx.viewpager2.widget.ViewPager2.1
            AnonymousClass1() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f4132f = true;
                viewPager2.m.u();
            }
        };
        this.f4135i = -1;
        this.q = null;
        this.r = false;
        this.s = true;
        this.t = -1;
        b(context, null);
    }

    private RecyclerView.OnChildAttachStateChangeListener a() {
        return new RecyclerView.OnChildAttachStateChangeListener() { // from class: androidx.viewpager2.widget.ViewPager2.4
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

    private void b(Context context, AttributeSet attributeSet) {
        this.u = f4127a ? new PageAwareAccessibilityProvider() : new BasicAccessibilityProvider();
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.k = recyclerViewImpl;
        recyclerViewImpl.setId(ViewCompat.generateViewId());
        this.k.setDescendantFocusability(131072);
        LinearLayoutManagerImpl linearLayoutManagerImpl = new LinearLayoutManagerImpl(context);
        this.f4134h = linearLayoutManagerImpl;
        this.k.setLayoutManager(linearLayoutManagerImpl);
        this.k.setScrollingTouchSlop(1);
        g(context, attributeSet);
        this.k.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.k.addOnChildAttachStateChangeListener(a());
        ScrollEventAdapter scrollEventAdapter = new ScrollEventAdapter(this);
        this.m = scrollEventAdapter;
        this.o = new FakeDrag(this, scrollEventAdapter, this.k);
        PagerSnapHelperImpl pagerSnapHelperImpl = new PagerSnapHelperImpl();
        this.l = pagerSnapHelperImpl;
        pagerSnapHelperImpl.attachToRecyclerView(this.k);
        this.k.addOnScrollListener(this.m);
        CompositeOnPageChangeCallback compositeOnPageChangeCallback = new CompositeOnPageChangeCallback(3);
        this.n = compositeOnPageChangeCallback;
        this.m.y(compositeOnPageChangeCallback);
        AnonymousClass2 anonymousClass2 = new OnPageChangeCallback() { // from class: androidx.viewpager2.widget.ViewPager2.2
            AnonymousClass2() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i2) {
                if (i2 == 0) {
                    ViewPager2.this.j();
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i2) {
                ViewPager2 viewPager2 = ViewPager2.this;
                if (viewPager2.f4131e != i2) {
                    viewPager2.f4131e = i2;
                    viewPager2.u.onSetNewCurrentItem();
                }
            }
        };
        AnonymousClass3 anonymousClass3 = new OnPageChangeCallback() { // from class: androidx.viewpager2.widget.ViewPager2.3
            AnonymousClass3() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i2) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.k.requestFocus(2);
                }
            }
        };
        this.n.a(anonymousClass2);
        this.n.a(anonymousClass3);
        this.u.onInitialize(this.n, this.k);
        this.n.a(this.f4130d);
        PageTransformerAdapter pageTransformerAdapter = new PageTransformerAdapter(this.f4134h);
        this.p = pageTransformerAdapter;
        this.n.a(pageTransformerAdapter);
        RecyclerView recyclerView = this.k;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void d(@Nullable RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f4133g);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e() {
        RecyclerView.Adapter adapter;
        if (this.f4135i == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.f4136j;
        if (parcelable != null) {
            if (adapter instanceof StatefulAdapter) {
                ((StatefulAdapter) adapter).restoreState(parcelable);
            }
            this.f4136j = null;
        }
        int max = Math.max(0, Math.min(this.f4135i, adapter.getItemCount() - 1));
        this.f4131e = max;
        this.f4135i = -1;
        this.k.scrollToPosition(max);
        this.u.onRestorePendingState();
    }

    private void g(Context context, AttributeSet attributeSet) {
        int[] iArr = androidx.viewpager2.R.styleable.ViewPager2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(obtainStyledAttributes.getInt(androidx.viewpager2.R.styleable.ViewPager2_android_orientation, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void i(@Nullable RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.f4133g);
        }
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.k.addItemDecoration(itemDecoration);
    }

    public boolean beginFakeDrag() {
        return this.o.b();
    }

    boolean c() {
        return this.f4134h.getLayoutDirection() == 1;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        return this.k.canScrollHorizontally(i2);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i2) {
        return this.k.canScrollVertically(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i2 = ((SavedState) parcelable).f4153a;
            sparseArray.put(this.k.getId(), sparseArray.get(i2));
            sparseArray.remove(i2);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        e();
    }

    public boolean endFakeDrag() {
        return this.o.d();
    }

    void f(int i2, boolean z) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.f4135i != -1) {
                this.f4135i = Math.max(i2, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int min = Math.min(Math.max(i2, 0), adapter.getItemCount() - 1);
        if (min == this.f4131e && this.m.r()) {
            return;
        }
        int i3 = this.f4131e;
        if (min == i3 && z) {
            return;
        }
        double d2 = i3;
        this.f4131e = min;
        this.u.onSetNewCurrentItem();
        if (!this.m.r()) {
            d2 = this.m.n();
        }
        this.m.w(min, z);
        if (!z) {
            this.k.scrollToPosition(min);
            return;
        }
        double d3 = min;
        Double.isNaN(d3);
        if (Math.abs(d3 - d2) <= 3.0d) {
            this.k.smoothScrollToPosition(min);
            return;
        }
        this.k.scrollToPosition(d3 > d2 ? min - 3 : min + 3);
        RecyclerView recyclerView = this.k;
        recyclerView.post(new SmoothScrollToPosition(min, recyclerView));
    }

    public boolean fakeDragBy(@Px @SuppressLint({"SupportAnnotationUsage"}) float f2) {
        return this.o.e(f2);
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(23)
    public CharSequence getAccessibilityClassName() {
        return this.u.handlesGetAccessibilityClassName() ? this.u.onGetAccessibilityClassName() : super.getAccessibilityClassName();
    }

    @Nullable
    public RecyclerView.Adapter getAdapter() {
        return this.k.getAdapter();
    }

    public int getCurrentItem() {
        return this.f4131e;
    }

    @NonNull
    public RecyclerView.ItemDecoration getItemDecorationAt(int i2) {
        return this.k.getItemDecorationAt(i2);
    }

    public int getItemDecorationCount() {
        return this.k.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.t;
    }

    public int getOrientation() {
        return this.f4134h.getOrientation();
    }

    int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.k;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.m.o();
    }

    void h() {
        View findSnapView = this.l.findSnapView(this.f4134h);
        if (findSnapView == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = this.l.calculateDistanceToFinalSnap(this.f4134h, findSnapView);
        if (calculateDistanceToFinalSnap[0] == 0 && calculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.k.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
    }

    public void invalidateItemDecorations() {
        this.k.invalidateItemDecorations();
    }

    public boolean isFakeDragging() {
        return this.o.f();
    }

    public boolean isUserInputEnabled() {
        return this.s;
    }

    void j() {
        PagerSnapHelper pagerSnapHelper = this.l;
        if (pagerSnapHelper == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View findSnapView = pagerSnapHelper.findSnapView(this.f4134h);
        if (findSnapView == null) {
            return;
        }
        int position = this.f4134h.getPosition(findSnapView);
        if (position != this.f4131e && getScrollState() == 0) {
            this.n.onPageSelected(position);
        }
        this.f4132f = false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.u.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = this.k.getMeasuredWidth();
        int measuredHeight = this.k.getMeasuredHeight();
        this.f4128b.left = getPaddingLeft();
        this.f4128b.right = (i4 - i2) - getPaddingRight();
        this.f4128b.top = getPaddingTop();
        this.f4128b.bottom = (i5 - i3) - getPaddingBottom();
        Gravity.apply(BadgeDrawable.f6713b, measuredWidth, measuredHeight, this.f4128b, this.f4129c);
        RecyclerView recyclerView = this.k;
        Rect rect = this.f4129c;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f4132f) {
            j();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        measureChild(this.k, i2, i3);
        int measuredWidth = this.k.getMeasuredWidth();
        int measuredHeight = this.k.getMeasuredHeight();
        int measuredState = this.k.getMeasuredState();
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
        this.f4135i = savedState.f4154b;
        this.f4136j = savedState.f4155c;
    }

    @Override // android.view.View
    @Nullable
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4153a = this.k.getId();
        int i2 = this.f4135i;
        if (i2 == -1) {
            i2 = this.f4131e;
        }
        savedState.f4154b = i2;
        Parcelable parcelable = this.f4136j;
        if (parcelable != null) {
            savedState.f4155c = parcelable;
        } else {
            Object adapter = this.k.getAdapter();
            if (adapter instanceof StatefulAdapter) {
                savedState.f4155c = ((StatefulAdapter) adapter).saveState();
            }
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    @RequiresApi(16)
    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        return this.u.handlesPerformAccessibilityAction(i2, bundle) ? this.u.onPerformAccessibilityAction(i2, bundle) : super.performAccessibilityAction(i2, bundle);
    }

    public void registerOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.f4130d.a(onPageChangeCallback);
    }

    public void removeItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.k.removeItemDecoration(itemDecoration);
    }

    public void removeItemDecorationAt(int i2) {
        this.k.removeItemDecorationAt(i2);
    }

    public void requestTransform() {
        if (this.p.a() == null) {
            return;
        }
        double n = this.m.n();
        int i2 = (int) n;
        double d2 = i2;
        Double.isNaN(d2);
        float f2 = (float) (n - d2);
        this.p.onPageScrolled(i2, f2, Math.round(getPageSize() * f2));
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.k.getAdapter();
        this.u.onDetachAdapter(adapter2);
        i(adapter2);
        this.k.setAdapter(adapter);
        this.f4131e = 0;
        e();
        this.u.onAttachAdapter(adapter);
        d(adapter);
    }

    public void setCurrentItem(int i2) {
        setCurrentItem(i2, true);
    }

    @Override // android.view.View
    @RequiresApi(17)
    public void setLayoutDirection(int i2) {
        super.setLayoutDirection(i2);
        this.u.onSetLayoutDirection();
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1 && i2 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.t = i2;
        this.k.requestLayout();
    }

    public void setOrientation(int i2) {
        this.f4134h.setOrientation(i2);
        this.u.onSetOrientation();
    }

    public void setPageTransformer(@Nullable PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.r) {
                this.q = this.k.getItemAnimator();
                this.r = true;
            }
            this.k.setItemAnimator(null);
        } else if (this.r) {
            this.k.setItemAnimator(this.q);
            this.q = null;
            this.r = false;
        }
        if (pageTransformer == this.p.a()) {
            return;
        }
        this.p.b(pageTransformer);
        requestTransform();
    }

    public void setUserInputEnabled(boolean z) {
        this.s = z;
        this.u.onSetUserInputEnabled();
    }

    public void unregisterOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.f4130d.b(onPageChangeCallback);
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.viewpager2.widget.ViewPager2.SavedState.1
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
        int f4153a;

        /* renamed from: b */
        int f4154b;

        /* renamed from: c */
        Parcelable f4155c;

        /* renamed from: androidx.viewpager2.widget.ViewPager2$SavedState$1 */
        static class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
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
            this.f4153a = parcel.readInt();
            this.f4154b = parcel.readInt();
            this.f4155c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f4153a);
            parcel.writeInt(this.f4154b);
            parcel.writeParcelable(this.f4155c, i2);
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
        this.k.addItemDecoration(itemDecoration, i2);
    }

    public void setCurrentItem(int i2, boolean z) {
        if (isFakeDragging()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        f(i2, z);
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4128b = new Rect();
        this.f4129c = new Rect();
        this.f4130d = new CompositeOnPageChangeCallback(3);
        this.f4132f = false;
        this.f4133g = new DataSetChangeObserver() { // from class: androidx.viewpager2.widget.ViewPager2.1
            AnonymousClass1() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f4132f = true;
                viewPager2.m.u();
            }
        };
        this.f4135i = -1;
        this.q = null;
        this.r = false;
        this.s = true;
        this.t = -1;
        b(context, attributeSet);
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4128b = new Rect();
        this.f4129c = new Rect();
        this.f4130d = new CompositeOnPageChangeCallback(3);
        this.f4132f = false;
        this.f4133g = new DataSetChangeObserver() { // from class: androidx.viewpager2.widget.ViewPager2.1
            AnonymousClass1() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f4132f = true;
                viewPager2.m.u();
            }
        };
        this.f4135i = -1;
        this.q = null;
        this.r = false;
        this.s = true;
        this.t = -1;
        b(context, attributeSet);
    }

    @RequiresApi(21)
    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f4128b = new Rect();
        this.f4129c = new Rect();
        this.f4130d = new CompositeOnPageChangeCallback(3);
        this.f4132f = false;
        this.f4133g = new DataSetChangeObserver() { // from class: androidx.viewpager2.widget.ViewPager2.1
            AnonymousClass1() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f4132f = true;
                viewPager2.m.u();
            }
        };
        this.f4135i = -1;
        this.q = null;
        this.r = false;
        this.s = true;
        this.t = -1;
        b(context, attributeSet);
    }
}
