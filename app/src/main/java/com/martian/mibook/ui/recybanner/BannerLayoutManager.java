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

/* loaded from: classes3.dex */
public class BannerLayoutManager extends RecyclerView.LayoutManager {
    public static final int C = -1;
    public static final int D = 0;
    public static final int E = 1;
    public static final int F = -1;
    public static final int G = 0;
    public static final int H = 1;
    public static final int I = Integer.MAX_VALUE;
    public float A;
    public float B;

    /* renamed from: b */
    public final SparseArray<View> f16104b;

    /* renamed from: c */
    public int f16105c;

    /* renamed from: d */
    public int f16106d;

    /* renamed from: e */
    public int f16107e;

    /* renamed from: f */
    public int f16108f;

    /* renamed from: g */
    public int f16109g;

    /* renamed from: h */
    public float f16110h;

    /* renamed from: i */
    public OrientationHelper f16111i;

    /* renamed from: j */
    public boolean f16112j;

    /* renamed from: k */
    public boolean f16113k;

    /* renamed from: l */
    public boolean f16114l;

    /* renamed from: m */
    public int f16115m;

    /* renamed from: n */
    public SavedState f16116n;

    /* renamed from: o */
    public float f16117o;

    /* renamed from: p */
    public a f16118p;

    /* renamed from: q */
    public boolean f16119q;

    /* renamed from: r */
    public boolean f16120r;

    /* renamed from: s */
    public boolean f16121s;

    /* renamed from: t */
    public int f16122t;

    /* renamed from: u */
    public int f16123u;

    /* renamed from: v */
    public int f16124v;

    /* renamed from: w */
    public Interpolator f16125w;

    /* renamed from: x */
    public int f16126x;

    /* renamed from: y */
    public View f16127y;

    /* renamed from: z */
    public int f16128z;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: b */
        public int f16129b;

        /* renamed from: c */
        public float f16130c;

        /* renamed from: d */
        public boolean f16131d;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f16129b);
            parcel.writeFloat(this.f16130c);
            parcel.writeInt(this.f16131d ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            this.f16129b = parcel.readInt();
            this.f16130c = parcel.readFloat();
            this.f16131d = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f16129b = savedState.f16129b;
            this.f16130c = savedState.f16130c;
            this.f16131d = savedState.f16131d;
        }
    }

    public interface a {
        void onPageScrollStateChanged(int i10);

        void onPageSelected(int i10);
    }

    public BannerLayoutManager(Context context) {
        this(context, 0, false);
    }

    private int A(int i10) {
        if (this.f16107e == 1) {
            if (i10 == 33) {
                return !this.f16113k ? 1 : 0;
            }
            if (i10 == 130) {
                return this.f16113k ? 1 : 0;
            }
            return -1;
        }
        if (i10 == 17) {
            return !this.f16113k ? 1 : 0;
        }
        if (i10 == 66) {
            return this.f16113k ? 1 : 0;
        }
        return -1;
    }

    private float C() {
        if (this.f16113k) {
            if (!this.f16120r) {
                return this.f16110h;
            }
            float f10 = this.f16110h;
            if (f10 <= 0.0f) {
                return f10 % (this.f16117o * getItemCount());
            }
            float itemCount = getItemCount();
            float f11 = this.f16117o;
            return (itemCount * (-f11)) + (this.f16110h % (f11 * getItemCount()));
        }
        if (!this.f16120r) {
            return this.f16110h;
        }
        float f12 = this.f16110h;
        if (f12 >= 0.0f) {
            return f12 % (this.f16117o * getItemCount());
        }
        float itemCount2 = getItemCount();
        float f13 = this.f16117o;
        return (itemCount2 * f13) + (this.f16110h % (f13 * getItemCount()));
    }

    private float F(int i10) {
        return i10 * (this.f16113k ? -this.f16117o : this.f16117o);
    }

    private void I(RecyclerView.Recycler recycler) {
        int i10;
        int i11;
        int i12;
        detachAndScrapAttachedViews(recycler);
        this.f16104b.clear();
        int itemCount = getItemCount();
        if (itemCount == 0) {
            return;
        }
        int r10 = this.f16113k ? -r() : r();
        int i13 = r10 - this.f16122t;
        int i14 = this.f16123u + r10;
        if (Y()) {
            int i15 = this.f16124v;
            if (i15 % 2 == 0) {
                i11 = i15 / 2;
                i12 = (r10 - i11) + 1;
            } else {
                i11 = (i15 - 1) / 2;
                i12 = r10 - i11;
            }
            int i16 = i12;
            i14 = i11 + r10 + 1;
            i13 = i16;
        }
        if (!this.f16120r) {
            if (i13 < 0) {
                if (Y()) {
                    i14 = this.f16124v;
                }
                i13 = 0;
            }
            if (i14 > itemCount) {
                i14 = itemCount;
            }
        }
        float f10 = Float.MIN_VALUE;
        while (i13 < i14) {
            if (Y() || !M(F(i13) - this.f16110h)) {
                if (i13 >= itemCount) {
                    i10 = i13 % itemCount;
                } else if (i13 < 0) {
                    int i17 = (-i13) % itemCount;
                    if (i17 == 0) {
                        i17 = itemCount;
                    }
                    i10 = itemCount - i17;
                } else {
                    i10 = i13;
                }
                View viewForPosition = recycler.getViewForPosition(i10);
                measureChildWithMargins(viewForPosition, 0, 0);
                N(viewForPosition);
                J(viewForPosition, F(i13) - this.f16110h);
                float f11 = this.f16121s ? 0.0f : i10;
                if (f11 > f10) {
                    addView(viewForPosition);
                } else {
                    addView(viewForPosition, 0);
                }
                if (i13 == r10) {
                    this.f16127y = viewForPosition;
                }
                this.f16104b.put(i13, viewForPosition);
                f10 = f11;
            }
            i13++;
        }
        this.f16127y.requestFocus();
    }

    private void J(View view, float f10) {
        int k10 = k(view, f10);
        int l10 = l(view, f10);
        if (this.f16107e == 1) {
            int i10 = this.f16109g;
            int i11 = this.f16108f;
            layoutDecorated(view, i10 + k10, i11 + l10, i10 + k10 + this.f16106d, i11 + l10 + this.f16105c);
        } else {
            int i12 = this.f16108f;
            int i13 = this.f16109g;
            layoutDecorated(view, i12 + k10, i13 + l10, i12 + k10 + this.f16105c, i13 + l10 + this.f16106d);
        }
        T(view, f10);
    }

    private boolean M(float f10) {
        return f10 > K() || f10 < L();
    }

    private void N(View view) {
        view.setRotation(0.0f);
        view.setRotationY(0.0f);
        view.setRotationX(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setAlpha(1.0f);
    }

    private boolean Y() {
        return this.f16124v != -1;
    }

    private float m(float f10) {
        float abs = Math.abs(f10 - ((this.f16111i.getTotalSpace() - this.f16105c) / 2.0f));
        int i10 = this.f16105c;
        return (((this.A - 1.0f) / i10) * (((float) i10) - abs > 0.0f ? i10 - abs : 0.0f)) + 1.0f;
    }

    private int n() {
        if (getChildCount() == 0) {
            return 0;
        }
        if (this.f16114l) {
            return (int) this.f16117o;
        }
        return 1;
    }

    private int o() {
        if (getChildCount() == 0) {
            return 0;
        }
        if (!this.f16114l) {
            return !this.f16113k ? q() : (getItemCount() - q()) - 1;
        }
        float C2 = C();
        return !this.f16113k ? (int) C2 : (int) (((getItemCount() - 1) * this.f16117o) + C2);
    }

    private int p() {
        if (getChildCount() == 0) {
            return 0;
        }
        return !this.f16114l ? getItemCount() : (int) (getItemCount() * this.f16117o);
    }

    private int r() {
        return Math.round(this.f16110h / this.f16117o);
    }

    private void resolveShouldLayoutReverse() {
        if (this.f16107e == 0 && getLayoutDirection() == 1) {
            this.f16112j = !this.f16112j;
        }
    }

    private int scrollBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        ensureLayoutState();
        float f10 = i10;
        float s10 = f10 / s();
        if (Math.abs(s10) < 1.0E-8f) {
            return 0;
        }
        float f11 = this.f16110h + s10;
        if (!this.f16120r && f11 < z()) {
            i10 = (int) (f10 - ((f11 - z()) * s()));
        } else if (!this.f16120r && f11 > x()) {
            i10 = (int) ((x() - this.f16110h) * s());
        }
        this.f16110h += i10 / s();
        I(recycler);
        return i10;
    }

    public float B() {
        return this.f16105c * ((this.A - 1.0f) / 2.0f);
    }

    public int D() {
        float q10;
        float s10;
        if (this.f16120r) {
            q10 = (r() * this.f16117o) - this.f16110h;
            s10 = s();
        } else {
            q10 = (q() * (!this.f16113k ? this.f16117o : -this.f16117o)) - this.f16110h;
            s10 = s();
        }
        return (int) (q10 * s10);
    }

    public int E(int i10) {
        float f10;
        float s10;
        if (this.f16120r) {
            f10 = ((r() + (!this.f16113k ? i10 - q() : q() - i10)) * this.f16117o) - this.f16110h;
            s10 = s();
        } else {
            f10 = (i10 * (!this.f16113k ? this.f16117o : -this.f16117o)) - this.f16110h;
            s10 = s();
        }
        return (int) (f10 * s10);
    }

    public boolean G() {
        return this.f16114l;
    }

    public int H() {
        int width;
        int paddingRight;
        if (this.f16107e == 0) {
            width = getHeight() - getPaddingTop();
            paddingRight = getPaddingBottom();
        } else {
            width = getWidth() - getPaddingLeft();
            paddingRight = getPaddingRight();
        }
        return width - paddingRight;
    }

    public float K() {
        return this.f16111i.getTotalSpace() - this.f16108f;
    }

    public float L() {
        return ((-this.f16105c) - this.f16111i.getStartAfterPadding()) - this.f16108f;
    }

    public void O(float f10) {
        this.A = f10;
    }

    public void P(int i10) {
        assertNotInLayoutOrScroll(null);
        if (this.f16126x == i10) {
            return;
        }
        this.f16126x = i10;
        removeAllViews();
    }

    public void Q(boolean z10) {
        assertNotInLayoutOrScroll(null);
        if (this.f16121s == z10) {
            return;
        }
        this.f16121s = z10;
        requestLayout();
    }

    public void R(boolean z10) {
        assertNotInLayoutOrScroll(null);
        if (z10 == this.f16120r) {
            return;
        }
        this.f16120r = z10;
        requestLayout();
    }

    public void S(int i10) {
        this.f16128z = i10;
    }

    public void T(View view, float f10) {
        float m10 = m(f10 + this.f16108f);
        view.setScaleX(m10);
        view.setScaleY(m10);
    }

    public void U(int i10) {
        assertNotInLayoutOrScroll(null);
        if (this.f16124v == i10) {
            return;
        }
        this.f16124v = i10;
        removeAllViews();
    }

    public void V(float f10) {
        assertNotInLayoutOrScroll(null);
        if (this.B == f10) {
            return;
        }
        this.B = f10;
    }

    public void W(a aVar) {
        this.f16118p = aVar;
    }

    public void X(Interpolator interpolator) {
        this.f16125w = interpolator;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.f16107e == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.f16107e == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(@NonNull RecyclerView.State state) {
        return n();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(@NonNull RecyclerView.State state) {
        return o();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(@NonNull RecyclerView.State state) {
        return p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(@NonNull RecyclerView.State state) {
        return n();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(@NonNull RecyclerView.State state) {
        return o();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(@NonNull RecyclerView.State state) {
        return p();
    }

    public void ensureLayoutState() {
        if (this.f16111i == null) {
            this.f16111i = OrientationHelper.createOrientationHelper(this, this.f16107e);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View findViewByPosition(int i10) {
        int itemCount = getItemCount();
        if (itemCount == 0) {
            return null;
        }
        for (int i11 = 0; i11 < this.f16104b.size(); i11++) {
            int keyAt = this.f16104b.keyAt(i11);
            if (keyAt < 0) {
                int i12 = keyAt % itemCount;
                if (i12 == 0) {
                    i12 = -itemCount;
                }
                if (i12 + itemCount == i10) {
                    return this.f16104b.valueAt(i11);
                }
            } else if (i10 == keyAt % itemCount) {
                return this.f16104b.valueAt(i11);
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public int getOrientation() {
        return this.f16107e;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.f16119q;
    }

    public boolean getReverseLayout() {
        return this.f16112j;
    }

    public int k(View view, float f10) {
        if (this.f16107e == 1) {
            return 0;
        }
        return (int) f10;
    }

    public int l(View view, float f10) {
        if (this.f16107e == 1) {
            return (int) f10;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
        this.f16110h = 0.0f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean onAddFocusables(@NonNull RecyclerView recyclerView, @NonNull ArrayList<View> arrayList, int i10, int i11) {
        int q10 = q();
        View findViewByPosition = findViewByPosition(q10);
        if (findViewByPosition == null) {
            return true;
        }
        if (recyclerView.hasFocus()) {
            int A = A(i10);
            if (A != -1) {
                recyclerView.smoothScrollToPosition(A == 1 ? q10 - 1 : q10 + 1);
            }
        } else {
            findViewByPosition.addFocusables(arrayList, i10, i11);
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.f16119q) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(@NonNull View view, int i10, @NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state) {
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        float f10;
        float f11;
        if (state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            this.f16110h = 0.0f;
            return;
        }
        ensureLayoutState();
        resolveShouldLayoutReverse();
        View viewForPosition = recycler.getViewForPosition(0);
        measureChildWithMargins(viewForPosition, 0, 0);
        this.f16105c = this.f16111i.getDecoratedMeasurement(viewForPosition);
        this.f16106d = this.f16111i.getDecoratedMeasurementInOther(viewForPosition);
        this.f16108f = (this.f16111i.getTotalSpace() - this.f16105c) / 2;
        if (this.f16126x == Integer.MAX_VALUE) {
            this.f16109g = (H() - this.f16106d) / 2;
        } else {
            this.f16109g = (H() - this.f16106d) - this.f16126x;
        }
        this.f16117o = w();
        this.f16122t = ((int) Math.abs(L() / this.f16117o)) + 1;
        this.f16123u = ((int) Math.abs(K() / this.f16117o)) + 1;
        SavedState savedState = this.f16116n;
        if (savedState != null) {
            this.f16113k = savedState.f16131d;
            this.f16115m = savedState.f16129b;
            this.f16110h = savedState.f16130c;
        }
        int i10 = this.f16115m;
        if (i10 != -1) {
            if (this.f16113k) {
                f10 = i10;
                f11 = -this.f16117o;
            } else {
                f10 = i10;
                f11 = this.f16117o;
            }
            this.f16110h = f10 * f11;
        }
        detachAndScrapAttachedViews(recycler);
        I(recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f16116n = null;
        this.f16115m = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f16116n = new SavedState((SavedState) parcelable);
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.f16116n != null) {
            return new SavedState(this.f16116n);
        }
        SavedState savedState = new SavedState();
        savedState.f16129b = this.f16115m;
        savedState.f16130c = this.f16110h;
        savedState.f16131d = this.f16113k;
        return savedState;
    }

    public int q() {
        if (getItemCount() == 0) {
            return 0;
        }
        int r10 = r();
        if (!this.f16120r) {
            return Math.abs(r10);
        }
        int itemCount = !this.f16113k ? r10 >= 0 ? r10 % getItemCount() : (r10 % getItemCount()) + getItemCount() : r10 > 0 ? getItemCount() - (r10 % getItemCount()) : (-r10) % getItemCount();
        if (itemCount == getItemCount()) {
            return 0;
        }
        return itemCount;
    }

    public float s() {
        float f10 = this.B;
        if (f10 == 0.0f) {
            return Float.MAX_VALUE;
        }
        return 1.0f / f10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f16107e == 1) {
            return 0;
        }
        return scrollBy(i10, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i10) {
        if (this.f16120r || (i10 >= 0 && i10 < getItemCount())) {
            this.f16115m = i10;
            this.f16110h = i10 * (this.f16113k ? -this.f16117o : this.f16117o);
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f16107e == 0) {
            return 0;
        }
        return scrollBy(i10, recycler, state);
    }

    public void setOrientation(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i10);
        }
        assertNotInLayoutOrScroll(null);
        if (i10 == this.f16107e) {
            return;
        }
        this.f16107e = i10;
        this.f16111i = null;
        this.f16126x = Integer.MAX_VALUE;
        removeAllViews();
    }

    public void setRecycleChildrenOnDetach(boolean z10) {
        this.f16119q = z10;
    }

    public void setReverseLayout(boolean z10) {
        assertNotInLayoutOrScroll(null);
        if (z10 == this.f16112j) {
            return;
        }
        this.f16112j = z10;
        removeAllViews();
    }

    public void setSmoothScrollbarEnabled(boolean z10) {
        this.f16114l = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i10) {
        int E2 = E(i10);
        if (this.f16107e == 1) {
            recyclerView.smoothScrollBy(0, E2, this.f16125w);
        } else {
            recyclerView.smoothScrollBy(E2, 0, this.f16125w);
        }
    }

    public int t() {
        int i10 = this.f16126x;
        return i10 == Integer.MAX_VALUE ? (H() - this.f16106d) / 2 : i10;
    }

    public boolean u() {
        return this.f16121s;
    }

    public boolean v() {
        return this.f16120r;
    }

    public float w() {
        return (this.f16105c * (((this.A - 1.0f) / 2.0f) + 1.0f)) + this.f16128z;
    }

    public float x() {
        if (this.f16113k) {
            return 0.0f;
        }
        return (getItemCount() - 1) * this.f16117o;
    }

    public int y() {
        return this.f16124v;
    }

    public float z() {
        if (this.f16113k) {
            return (-(getItemCount() - 1)) * this.f16117o;
        }
        return 0.0f;
    }

    public BannerLayoutManager(Context context, int i10) {
        this(context, i10, false);
    }

    public BannerLayoutManager(Context context, int i10, boolean z10) {
        this.f16104b = new SparseArray<>();
        this.f16112j = false;
        this.f16113k = false;
        this.f16114l = true;
        this.f16115m = -1;
        this.f16116n = null;
        this.f16120r = true;
        this.f16124v = -1;
        this.f16126x = Integer.MAX_VALUE;
        this.f16128z = 20;
        this.A = 1.2f;
        this.B = 1.0f;
        Q(true);
        U(5);
        setOrientation(i10);
        setReverseLayout(z10);
        setItemPrefetchEnabled(false);
    }
}
