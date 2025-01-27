package com.martian.mibook.ui.recybanner;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class BannerLayoutManager extends RecyclerView.LayoutManager {

    /* renamed from: a */
    public static final int f14862a = -1;

    /* renamed from: b */
    public static final int f14863b = 0;

    /* renamed from: c */
    public static final int f14864c = 1;

    /* renamed from: d */
    private static final int f14865d = -1;

    /* renamed from: e */
    private static final int f14866e = 0;

    /* renamed from: f */
    private static final int f14867f = 1;

    /* renamed from: g */
    protected static final int f14868g = Integer.MAX_VALUE;
    private int A;
    private int B;
    private Interpolator C;
    private int D;
    private View E;
    private int F;
    private float G;
    private float H;

    /* renamed from: h */
    private final SparseArray<View> f14869h;

    /* renamed from: i */
    protected int f14870i;

    /* renamed from: j */
    protected int f14871j;
    int k;
    protected int l;
    protected int m;
    protected float n;
    protected OrientationHelper o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private b t;
    protected float u;
    a v;
    private boolean w;
    private boolean x;
    private boolean y;
    private int z;

    public interface a {
        void onPageScrollStateChanged(int state);

        void onPageSelected(int position);
    }

    private static class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: a */
        int f14872a;

        /* renamed from: b */
        float f14873b;

        /* renamed from: c */
        boolean f14874c;

        static class a implements Parcelable.Creator<b> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public b createFromParcel(Parcel in) {
                return new b(in);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public b[] newArray(int size) {
                return new b[size];
            }
        }

        b() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f14872a);
            parcel.writeFloat(this.f14873b);
            parcel.writeInt(this.f14874c ? 1 : 0);
        }

        b(Parcel in) {
            this.f14872a = in.readInt();
            this.f14873b = in.readFloat();
            this.f14874c = in.readInt() == 1;
        }

        public b(b other) {
            this.f14872a = other.f14872a;
            this.f14873b = other.f14873b;
            this.f14874c = other.f14874c;
        }
    }

    public BannerLayoutManager(Context context) {
        this(context, 0, false);
    }

    private boolean C(float targetOffset) {
        return targetOffset > A() || targetOffset < B();
    }

    private void D(View v) {
        v.setRotation(0.0f);
        v.setRotationY(0.0f);
        v.setRotationX(0.0f);
        v.setScaleX(1.0f);
        v.setScaleY(1.0f);
        v.setAlpha(1.0f);
    }

    private boolean O() {
        return this.B != -1;
    }

    private float c(float x) {
        float abs = Math.abs(x - ((this.o.getTotalSpace() - this.f14870i) / 2.0f));
        int i2 = this.f14870i;
        return (((this.G - 1.0f) / i2) * (((float) i2) - abs > 0.0f ? i2 - abs : 0.0f)) + 1.0f;
    }

    private int d() {
        if (getChildCount() == 0) {
            return 0;
        }
        if (this.r) {
            return (int) this.u;
        }
        return 1;
    }

    private int e() {
        if (getChildCount() == 0) {
            return 0;
        }
        if (!this.r) {
            return !this.q ? g() : (getItemCount() - g()) - 1;
        }
        float s = s();
        return !this.q ? (int) s : (int) (((getItemCount() - 1) * this.u) + s);
    }

    private int f() {
        if (getChildCount() == 0) {
            return 0;
        }
        return !this.r ? getItemCount() : (int) (getItemCount() * this.u);
    }

    private int h() {
        return Math.round(this.n / this.u);
    }

    private int q(int i2) {
        if (this.k == 1) {
            if (i2 == 33) {
                return !this.q ? 1 : 0;
            }
            if (i2 == 130) {
                return this.q ? 1 : 0;
            }
            return -1;
        }
        if (i2 == 17) {
            return !this.q ? 1 : 0;
        }
        if (i2 == 66) {
            return this.q ? 1 : 0;
        }
        return -1;
    }

    private void resolveShouldLayoutReverse() {
        if (this.k == 0 && getLayoutDirection() == 1) {
            this.p = !this.p;
        }
    }

    private float s() {
        if (this.q) {
            if (!this.x) {
                return this.n;
            }
            float f2 = this.n;
            if (f2 <= 0.0f) {
                return f2 % (this.u * getItemCount());
            }
            float itemCount = getItemCount();
            float f3 = this.u;
            return (itemCount * (-f3)) + (this.n % (f3 * getItemCount()));
        }
        if (!this.x) {
            return this.n;
        }
        float f4 = this.n;
        if (f4 >= 0.0f) {
            return f4 % (this.u * getItemCount());
        }
        float itemCount2 = getItemCount();
        float f5 = this.u;
        return (itemCount2 * f5) + (this.n % (f5 * getItemCount()));
    }

    private int scrollBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || dy == 0) {
            return 0;
        }
        ensureLayoutState();
        float f2 = dy;
        float i2 = f2 / i();
        if (Math.abs(i2) < 1.0E-8f) {
            return 0;
        }
        float f3 = this.n + i2;
        if (!this.x && f3 < p()) {
            dy = (int) (f2 - ((f3 - p()) * i()));
        } else if (!this.x && f3 > n()) {
            dy = (int) ((n() - this.n) * i());
        }
        this.n += dy / i();
        y(recycler);
        return dy;
    }

    private float v(int position) {
        return position * (this.q ? -this.u : this.u);
    }

    private void y(RecyclerView.Recycler recycler) {
        int i2;
        int i3;
        int i4;
        detachAndScrapAttachedViews(recycler);
        this.f14869h.clear();
        int itemCount = getItemCount();
        if (itemCount == 0) {
            return;
        }
        int h2 = this.q ? -h() : h();
        int i5 = h2 - this.z;
        int i6 = this.A + h2;
        if (O()) {
            int i7 = this.B;
            if (i7 % 2 == 0) {
                i3 = i7 / 2;
                i4 = (h2 - i3) + 1;
            } else {
                i3 = (i7 - 1) / 2;
                i4 = h2 - i3;
            }
            int i8 = i4;
            i6 = i3 + h2 + 1;
            i5 = i8;
        }
        if (!this.x) {
            if (i5 < 0) {
                if (O()) {
                    i6 = this.B;
                }
                i5 = 0;
            }
            if (i6 > itemCount) {
                i6 = itemCount;
            }
        }
        float f2 = Float.MIN_VALUE;
        while (i5 < i6) {
            if (O() || !C(v(i5) - this.n)) {
                if (i5 >= itemCount) {
                    i2 = i5 % itemCount;
                } else if (i5 < 0) {
                    int i9 = (-i5) % itemCount;
                    if (i9 == 0) {
                        i9 = itemCount;
                    }
                    i2 = itemCount - i9;
                } else {
                    i2 = i5;
                }
                View viewForPosition = recycler.getViewForPosition(i2);
                measureChildWithMargins(viewForPosition, 0, 0);
                D(viewForPosition);
                z(viewForPosition, v(i5) - this.n);
                float f3 = this.y ? 0.0f : i2;
                if (f3 > f2) {
                    addView(viewForPosition);
                } else {
                    addView(viewForPosition, 0);
                }
                if (i5 == h2) {
                    this.E = viewForPosition;
                }
                this.f14869h.put(i5, viewForPosition);
                f2 = f3;
            }
            i5++;
        }
        this.E.requestFocus();
    }

    private void z(View scrap, float targetOffset) {
        int a2 = a(scrap, targetOffset);
        int b2 = b(scrap, targetOffset);
        if (this.k == 1) {
            int i2 = this.m;
            int i3 = this.l;
            layoutDecorated(scrap, i2 + a2, i3 + b2, i2 + a2 + this.f14871j, i3 + b2 + this.f14870i);
        } else {
            int i4 = this.l;
            int i5 = this.m;
            layoutDecorated(scrap, i4 + a2, i5 + b2, i4 + a2 + this.f14870i, i5 + b2 + this.f14871j);
        }
        J(scrap, targetOffset);
    }

    protected float A() {
        return this.o.getTotalSpace() - this.l;
    }

    protected float B() {
        return ((-this.f14870i) - this.o.getStartAfterPadding()) - this.l;
    }

    public void E(float centerScale) {
        this.G = centerScale;
    }

    public void F(int mDistanceToBottom) {
        assertNotInLayoutOrScroll(null);
        if (this.D == mDistanceToBottom) {
            return;
        }
        this.D = mDistanceToBottom;
        removeAllViews();
    }

    public void G(boolean bringCenterToTop) {
        assertNotInLayoutOrScroll(null);
        if (this.y == bringCenterToTop) {
            return;
        }
        this.y = bringCenterToTop;
        requestLayout();
    }

    public void H(boolean enable) {
        assertNotInLayoutOrScroll(null);
        if (enable == this.x) {
            return;
        }
        this.x = enable;
        requestLayout();
    }

    public void I(int itemSpace) {
        this.F = itemSpace;
    }

    protected void J(View itemView, float targetOffset) {
        float c2 = c(targetOffset + this.l);
        itemView.setScaleX(c2);
        itemView.setScaleY(c2);
    }

    public void K(int mMaxVisibleItemCount) {
        assertNotInLayoutOrScroll(null);
        if (this.B == mMaxVisibleItemCount) {
            return;
        }
        this.B = mMaxVisibleItemCount;
        removeAllViews();
    }

    public void L(float moveSpeed) {
        assertNotInLayoutOrScroll(null);
        if (this.H == moveSpeed) {
            return;
        }
        this.H = moveSpeed;
    }

    public void M(a onPageChangeListener) {
        this.v = onPageChangeListener;
    }

    public void N(Interpolator smoothScrollInterpolator) {
        this.C = smoothScrollInterpolator;
    }

    protected int a(View itemView, float targetOffset) {
        if (this.k == 1) {
            return 0;
        }
        return (int) targetOffset;
    }

    protected int b(View itemView, float targetOffset) {
        if (this.k == 1) {
            return (int) targetOffset;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.k == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.k == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(@NonNull RecyclerView.State state) {
        return d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(@NonNull RecyclerView.State state) {
        return e();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(@NonNull RecyclerView.State state) {
        return f();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(@NonNull RecyclerView.State state) {
        return d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(@NonNull RecyclerView.State state) {
        return e();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(@NonNull RecyclerView.State state) {
        return f();
    }

    void ensureLayoutState() {
        if (this.o == null) {
            this.o = OrientationHelper.createOrientationHelper(this, this.k);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View findViewByPosition(int position) {
        int itemCount = getItemCount();
        if (itemCount == 0) {
            return null;
        }
        for (int i2 = 0; i2 < this.f14869h.size(); i2++) {
            int keyAt = this.f14869h.keyAt(i2);
            if (keyAt < 0) {
                int i3 = keyAt % itemCount;
                if (i3 == 0) {
                    i3 = -itemCount;
                }
                if (i3 + itemCount == position) {
                    return this.f14869h.valueAt(i2);
                }
            } else if (position == keyAt % itemCount) {
                return this.f14869h.valueAt(i2);
            }
        }
        return null;
    }

    public int g() {
        if (getItemCount() == 0) {
            return 0;
        }
        int h2 = h();
        if (!this.x) {
            return Math.abs(h2);
        }
        int itemCount = !this.q ? h2 >= 0 ? h2 % getItemCount() : (h2 % getItemCount()) + getItemCount() : h2 > 0 ? getItemCount() - (h2 % getItemCount()) : (-h2) % getItemCount();
        if (itemCount == getItemCount()) {
            return 0;
        }
        return itemCount;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public int getOrientation() {
        return this.k;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.w;
    }

    public boolean getReverseLayout() {
        return this.p;
    }

    protected float i() {
        float f2 = this.H;
        if (f2 == 0.0f) {
            return Float.MAX_VALUE;
        }
        return 1.0f / f2;
    }

    public int j() {
        int i2 = this.D;
        return i2 == Integer.MAX_VALUE ? (x() - this.f14871j) / 2 : i2;
    }

    public boolean k() {
        return this.y;
    }

    public boolean l() {
        return this.x;
    }

    protected float m() {
        return (this.f14870i * (((this.G - 1.0f) / 2.0f) + 1.0f)) + this.F;
    }

    float n() {
        if (this.q) {
            return 0.0f;
        }
        return (getItemCount() - 1) * this.u;
    }

    public int o() {
        return this.B;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter oldAdapter, RecyclerView.Adapter newAdapter) {
        removeAllViews();
        this.n = 0.0f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean onAddFocusables(@NonNull RecyclerView recyclerView, @NonNull ArrayList<View> views, int direction, int focusableMode) {
        int g2 = g();
        View findViewByPosition = findViewByPosition(g2);
        if (findViewByPosition == null) {
            return true;
        }
        if (recyclerView.hasFocus()) {
            int q = q(direction);
            if (q != -1) {
                recyclerView.smoothScrollToPosition(q == 1 ? g2 - 1 : g2 + 1);
            }
        } else {
            findViewByPosition.addFocusables(views, direction, focusableMode);
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView view, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(view, recycler);
        if (this.w) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(@NonNull View focused, int focusDirection, @NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state) {
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            this.n = 0.0f;
            return;
        }
        ensureLayoutState();
        resolveShouldLayoutReverse();
        View viewForPosition = recycler.getViewForPosition(0);
        measureChildWithMargins(viewForPosition, 0, 0);
        this.f14870i = this.o.getDecoratedMeasurement(viewForPosition);
        this.f14871j = this.o.getDecoratedMeasurementInOther(viewForPosition);
        this.l = (this.o.getTotalSpace() - this.f14870i) / 2;
        if (this.D == Integer.MAX_VALUE) {
            this.m = (x() - this.f14871j) / 2;
        } else {
            this.m = (x() - this.f14871j) - this.D;
        }
        this.u = m();
        this.z = ((int) Math.abs(B() / this.u)) + 1;
        this.A = ((int) Math.abs(A() / this.u)) + 1;
        b bVar = this.t;
        if (bVar != null) {
            this.q = bVar.f14874c;
            this.s = bVar.f14872a;
            this.n = bVar.f14873b;
        }
        int i2 = this.s;
        if (i2 != -1) {
            this.n = i2 * (this.q ? -this.u : this.u);
        }
        detachAndScrapAttachedViews(recycler);
        y(recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.t = null;
        this.s = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof b) {
            this.t = new b((b) state);
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.t != null) {
            return new b(this.t);
        }
        b bVar = new b();
        bVar.f14872a = this.s;
        bVar.f14873b = this.n;
        bVar.f14874c = this.q;
        return bVar;
    }

    float p() {
        if (this.q) {
            return (-(getItemCount() - 1)) * this.u;
        }
        return 0.0f;
    }

    protected float r() {
        return this.f14870i * ((this.G - 1.0f) / 2.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.k == 1) {
            return 0;
        }
        return scrollBy(dx, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int position) {
        if (this.x || (position >= 0 && position < getItemCount())) {
            this.s = position;
            this.n = position * (this.q ? -this.u : this.u);
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.k == 0) {
            return 0;
        }
        return scrollBy(dy, recycler, state);
    }

    public void setOrientation(int orientation) {
        if (orientation != 0 && orientation != 1) {
            throw new IllegalArgumentException("invalid orientation:" + orientation);
        }
        assertNotInLayoutOrScroll(null);
        if (orientation == this.k) {
            return;
        }
        this.k = orientation;
        this.o = null;
        this.D = Integer.MAX_VALUE;
        removeAllViews();
    }

    public void setRecycleChildrenOnDetach(boolean recycleChildrenOnDetach) {
        this.w = recycleChildrenOnDetach;
    }

    public void setReverseLayout(boolean reverseLayout) {
        assertNotInLayoutOrScroll(null);
        if (reverseLayout == this.p) {
            return;
        }
        this.p = reverseLayout;
        removeAllViews();
    }

    public void setSmoothScrollbarEnabled(boolean enabled) {
        this.r = enabled;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        int u = u(position);
        if (this.k == 1) {
            recyclerView.smoothScrollBy(0, u, this.C);
        } else {
            recyclerView.smoothScrollBy(u, 0, this.C);
        }
    }

    public int t() {
        float g2;
        float i2;
        if (this.x) {
            g2 = (h() * this.u) - this.n;
            i2 = i();
        } else {
            g2 = (g() * (!this.q ? this.u : -this.u)) - this.n;
            i2 = i();
        }
        return (int) (g2 * i2);
    }

    public int u(int position) {
        float f2;
        float i2;
        if (this.x) {
            f2 = ((h() + (!this.q ? position - g() : g() - position)) * this.u) - this.n;
            i2 = i();
        } else {
            f2 = (position * (!this.q ? this.u : -this.u)) - this.n;
            i2 = i();
        }
        return (int) (f2 * i2);
    }

    public boolean w() {
        return this.r;
    }

    public int x() {
        int width;
        int paddingRight;
        if (this.k == 0) {
            width = getHeight() - getPaddingTop();
            paddingRight = getPaddingBottom();
        } else {
            width = getWidth() - getPaddingLeft();
            paddingRight = getPaddingRight();
        }
        return width - paddingRight;
    }

    public BannerLayoutManager(Context context, int orientation) {
        this(context, orientation, false);
    }

    public BannerLayoutManager(Context context, int orientation, boolean reverseLayout) {
        this.f14869h = new SparseArray<>();
        this.p = false;
        this.q = false;
        this.r = true;
        this.s = -1;
        this.t = null;
        this.x = true;
        this.B = -1;
        this.D = Integer.MAX_VALUE;
        this.F = 20;
        this.G = 1.2f;
        this.H = 1.0f;
        G(true);
        K(5);
        setOrientation(orientation);
        setReverseLayout(reverseLayout);
        setItemPrefetchEnabled(false);
    }
}
