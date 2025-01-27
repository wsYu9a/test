package com.martian.mibook.ui.viewpagerlayoutmanager;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ie.c;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public abstract class ViewPagerLayoutManager extends LinearLayoutManager {
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = -1;
    public static final int D = 0;
    public static final int E = 1;
    public static final int F = Integer.MAX_VALUE;

    /* renamed from: z */
    public static final int f16151z = -1;

    /* renamed from: b */
    public SparseArray<View> f16152b;

    /* renamed from: c */
    public int f16153c;

    /* renamed from: d */
    public int f16154d;

    /* renamed from: e */
    public int f16155e;

    /* renamed from: f */
    public int f16156f;

    /* renamed from: g */
    public int f16157g;

    /* renamed from: h */
    public float f16158h;

    /* renamed from: i */
    public ie.a f16159i;

    /* renamed from: j */
    public boolean f16160j;

    /* renamed from: k */
    public boolean f16161k;

    /* renamed from: l */
    public boolean f16162l;

    /* renamed from: m */
    public int f16163m;

    /* renamed from: n */
    public SavedState f16164n;

    /* renamed from: o */
    public float f16165o;

    /* renamed from: p */
    public a f16166p;

    /* renamed from: q */
    public boolean f16167q;

    /* renamed from: r */
    public boolean f16168r;

    /* renamed from: s */
    public boolean f16169s;

    /* renamed from: t */
    public int f16170t;

    /* renamed from: u */
    public int f16171u;

    /* renamed from: v */
    public int f16172v;

    /* renamed from: w */
    public Interpolator f16173w;

    /* renamed from: x */
    public int f16174x;

    /* renamed from: y */
    public View f16175y;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: b */
        public int f16176b;

        /* renamed from: c */
        public float f16177c;

        /* renamed from: d */
        public boolean f16178d;

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
            parcel.writeInt(this.f16176b);
            parcel.writeFloat(this.f16177c);
            parcel.writeInt(this.f16178d ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            this.f16176b = parcel.readInt();
            this.f16177c = parcel.readFloat();
            this.f16178d = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f16176b = savedState.f16176b;
            this.f16177c = savedState.f16177c;
            this.f16178d = savedState.f16178d;
        }
    }

    public interface a {
        void onPageScrollStateChanged(int i10);

        void onPageSelected(int i10);
    }

    public ViewPagerLayoutManager(Context context) {
        this(context, 0, false);
    }

    private int scrollBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        ensureLayoutState();
        float f10 = i10;
        float r10 = f10 / r();
        if (Math.abs(r10) < 1.0E-8f) {
            return 0;
        }
        float f11 = this.f16158h + r10;
        if (!this.f16168r && f11 < z()) {
            i10 = (int) (f10 - ((f11 - z()) * r()));
        } else if (!this.f16168r && f11 > w()) {
            i10 = (int) ((w() - this.f16158h) * r());
        }
        this.f16158h += i10 / r();
        G(recycler);
        return i10;
    }

    public final int A(int i10) {
        if (this.f16155e == 1) {
            if (i10 == 33) {
                return !this.f16161k ? 1 : 0;
            }
            if (i10 == 130) {
                return this.f16161k ? 1 : 0;
            }
            return -1;
        }
        if (i10 == 17) {
            return !this.f16161k ? 1 : 0;
        }
        if (i10 == 66) {
            return this.f16161k ? 1 : 0;
        }
        return -1;
    }

    public final float B() {
        if (this.f16161k) {
            if (!this.f16168r) {
                return this.f16158h;
            }
            float f10 = this.f16158h;
            if (f10 <= 0.0f) {
                return f10 % (this.f16165o * getItemCount());
            }
            float itemCount = getItemCount();
            float f11 = this.f16165o;
            return (itemCount * (-f11)) + (this.f16158h % (f11 * getItemCount()));
        }
        if (!this.f16168r) {
            return this.f16158h;
        }
        float f12 = this.f16158h;
        if (f12 >= 0.0f) {
            return f12 % (this.f16165o * getItemCount());
        }
        float itemCount2 = getItemCount();
        float f13 = this.f16165o;
        return (itemCount2 * f13) + (this.f16158h % (f13 * getItemCount()));
    }

    public int C() {
        float p10;
        float r10;
        if (this.f16168r) {
            p10 = (q() * this.f16165o) - this.f16158h;
            r10 = r();
        } else {
            p10 = (p() * (!this.f16161k ? this.f16165o : -this.f16165o)) - this.f16158h;
            r10 = r();
        }
        return (int) (p10 * r10);
    }

    public int D(int i10) {
        float f10;
        float r10;
        if (this.f16168r) {
            f10 = ((q() + (!this.f16161k ? i10 - q() : (-q()) - i10)) * this.f16165o) - this.f16158h;
            r10 = r();
        } else {
            f10 = (i10 * (!this.f16161k ? this.f16165o : -this.f16165o)) - this.f16158h;
            r10 = r();
        }
        return (int) (f10 * r10);
    }

    public final float E(int i10) {
        return i10 * (this.f16161k ? -this.f16165o : this.f16165o);
    }

    public boolean F() {
        return this.f16162l;
    }

    public final void G(RecyclerView.Recycler recycler) {
        int i10;
        int i11;
        int i12;
        detachAndScrapAttachedViews(recycler);
        this.f16152b.clear();
        int itemCount = getItemCount();
        if (itemCount == 0) {
            return;
        }
        int q10 = this.f16161k ? -q() : q();
        int i13 = q10 - this.f16170t;
        int i14 = this.f16171u + q10;
        if (W()) {
            int i15 = this.f16172v;
            if (i15 % 2 == 0) {
                i11 = i15 / 2;
                i12 = (q10 - i11) + 1;
            } else {
                i11 = (i15 - 1) / 2;
                i12 = q10 - i11;
            }
            int i16 = i12;
            i14 = i11 + q10 + 1;
            i13 = i16;
        }
        if (!this.f16168r) {
            if (i13 < 0) {
                if (W()) {
                    i14 = this.f16172v;
                }
                i13 = 0;
            }
            if (i14 > itemCount) {
                i14 = itemCount;
            }
        }
        float f10 = Float.MIN_VALUE;
        while (i13 < i14) {
            if (W() || !K(E(i13) - this.f16158h)) {
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
                L(viewForPosition);
                float E2 = E(i13) - this.f16158h;
                H(viewForPosition, E2);
                float V = this.f16169s ? V(viewForPosition, E2) : i10;
                if (V > f10) {
                    addView(viewForPosition);
                } else {
                    addView(viewForPosition, 0);
                }
                if (i13 == q10) {
                    this.f16175y = viewForPosition;
                }
                this.f16152b.put(i13, viewForPosition);
                f10 = V;
            }
            i13++;
        }
        this.f16175y.requestFocus();
    }

    public final void H(View view, float f10) {
        int k10 = k(view, f10);
        int l10 = l(view, f10);
        if (this.f16155e == 1) {
            int i10 = this.f16157g;
            int i11 = this.f16156f;
            layoutDecorated(view, i10 + k10, i11 + l10, i10 + k10 + this.f16154d, i11 + l10 + this.f16153c);
        } else {
            int i12 = this.f16156f;
            int i13 = this.f16157g;
            layoutDecorated(view, i12 + k10, i13 + l10, i12 + k10 + this.f16153c, i13 + l10 + this.f16154d);
        }
        Q(view, f10);
    }

    public float I() {
        return this.f16159i.n() - this.f16156f;
    }

    public float J() {
        return ((-this.f16153c) - this.f16159i.m()) - this.f16156f;
    }

    public final boolean K(float f10) {
        return f10 > I() || f10 < J();
    }

    public final void L(View view) {
        view.setRotation(0.0f);
        view.setRotationY(0.0f);
        view.setRotationX(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setAlpha(1.0f);
    }

    public void M(int i10) {
        assertNotInLayoutOrScroll(null);
        if (this.f16174x == i10) {
            return;
        }
        this.f16174x = i10;
        removeAllViews();
    }

    public void N(boolean z10) {
        assertNotInLayoutOrScroll(null);
        if (this.f16169s == z10) {
            return;
        }
        this.f16169s = z10;
        requestLayout();
    }

    public void O(boolean z10) {
        assertNotInLayoutOrScroll(null);
        if (z10 == this.f16168r) {
            return;
        }
        this.f16168r = z10;
        requestLayout();
    }

    public abstract float P();

    public abstract void Q(View view, float f10);

    public void R(int i10) {
        assertNotInLayoutOrScroll(null);
        if (this.f16172v == i10) {
            return;
        }
        this.f16172v = i10;
        removeAllViews();
    }

    public void S(a aVar) {
        this.f16166p = aVar;
    }

    public void T(Interpolator interpolator) {
        this.f16173w = interpolator;
    }

    public void U() {
    }

    public float V(View view, float f10) {
        return 0.0f;
    }

    public final boolean W() {
        return this.f16172v != -1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.f16155e == 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.f16155e == 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return m();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return n();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return o();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return m();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return n();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return o();
    }

    public void ensureLayoutState() {
        if (this.f16159i == null) {
            this.f16159i = ie.a.b(this, this.f16155e);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View findViewByPosition(int i10) {
        int itemCount = getItemCount();
        if (itemCount == 0) {
            return null;
        }
        for (int i11 = 0; i11 < this.f16152b.size(); i11++) {
            int keyAt = this.f16152b.keyAt(i11);
            if (keyAt < 0) {
                int i12 = keyAt % itemCount;
                if (i12 == 0) {
                    i12 = -itemCount;
                }
                if (i12 + itemCount == i10) {
                    return this.f16152b.valueAt(i11);
                }
            } else if (i10 == keyAt % itemCount) {
                return this.f16152b.valueAt(i11);
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int getOrientation() {
        return this.f16155e;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public boolean getRecycleChildrenOnDetach() {
        return this.f16167q;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public boolean getReverseLayout() {
        return this.f16160j;
    }

    public int k(View view, float f10) {
        if (this.f16155e == 1) {
            return 0;
        }
        return (int) f10;
    }

    public int l(View view, float f10) {
        if (this.f16155e == 1) {
            return (int) f10;
        }
        return 0;
    }

    public final int m() {
        if (getChildCount() == 0) {
            return 0;
        }
        if (this.f16162l) {
            return (int) this.f16165o;
        }
        return 1;
    }

    public final int n() {
        if (getChildCount() == 0) {
            return 0;
        }
        if (!this.f16162l) {
            return !this.f16161k ? p() : (getItemCount() - p()) - 1;
        }
        float B2 = B();
        return !this.f16161k ? (int) B2 : (int) (((getItemCount() - 1) * this.f16165o) + B2);
    }

    public final int o() {
        if (getChildCount() == 0) {
            return 0;
        }
        return !this.f16162l ? getItemCount() : (int) (getItemCount() * this.f16165o);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
        this.f16158h = 0.0f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i10, int i11) {
        int p10 = p();
        View findViewByPosition = findViewByPosition(p10);
        if (findViewByPosition == null) {
            return true;
        }
        if (recyclerView.hasFocus()) {
            int A2 = A(i10);
            if (A2 != -1) {
                c.a(recyclerView, this, A2 == 1 ? p10 - 1 : p10 + 1);
            }
        } else {
            findViewByPosition.addFocusables(arrayList, i10, i11);
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.f16167q) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view, int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return null;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        float f10;
        float f11;
        if (state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            this.f16158h = 0.0f;
            return;
        }
        ensureLayoutState();
        resolveShouldLayoutReverse();
        View y10 = y(recycler, state, 0);
        if (y10 == null) {
            removeAndRecycleAllViews(recycler);
            this.f16158h = 0.0f;
            return;
        }
        measureChildWithMargins(y10, 0, 0);
        this.f16153c = this.f16159i.e(y10);
        this.f16154d = this.f16159i.f(y10);
        this.f16156f = (this.f16159i.n() - this.f16153c) / 2;
        if (this.f16174x == Integer.MAX_VALUE) {
            this.f16157g = (this.f16159i.p() - this.f16154d) / 2;
        } else {
            this.f16157g = (this.f16159i.p() - this.f16154d) - this.f16174x;
        }
        this.f16165o = P();
        U();
        if (this.f16165o == 0.0f) {
            this.f16170t = 1;
            this.f16171u = 1;
        } else {
            this.f16170t = ((int) Math.abs(J() / this.f16165o)) + 1;
            this.f16171u = ((int) Math.abs(I() / this.f16165o)) + 1;
        }
        SavedState savedState = this.f16164n;
        if (savedState != null) {
            this.f16161k = savedState.f16178d;
            this.f16163m = savedState.f16176b;
            this.f16158h = savedState.f16177c;
        }
        int i10 = this.f16163m;
        if (i10 != -1) {
            if (this.f16161k) {
                f10 = i10;
                f11 = -this.f16165o;
            } else {
                f10 = i10;
                f11 = this.f16165o;
            }
            this.f16158h = f10 * f11;
        }
        G(recycler);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f16164n = null;
        this.f16163m = -1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f16164n = new SavedState((SavedState) parcelable);
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.f16164n != null) {
            return new SavedState(this.f16164n);
        }
        SavedState savedState = new SavedState();
        savedState.f16176b = this.f16163m;
        savedState.f16177c = this.f16158h;
        savedState.f16178d = this.f16161k;
        return savedState;
    }

    public int p() {
        if (getItemCount() == 0) {
            return 0;
        }
        int q10 = q();
        if (!this.f16168r) {
            return Math.abs(q10);
        }
        int itemCount = !this.f16161k ? q10 >= 0 ? q10 % getItemCount() : (q10 % getItemCount()) + getItemCount() : q10 > 0 ? getItemCount() - (q10 % getItemCount()) : (-q10) % getItemCount();
        if (itemCount == getItemCount()) {
            return 0;
        }
        return itemCount;
    }

    public int q() {
        float f10 = this.f16165o;
        if (f10 == 0.0f) {
            return 0;
        }
        return Math.round(this.f16158h / f10);
    }

    public float r() {
        return 1.0f;
    }

    public final void resolveShouldLayoutReverse() {
        if (this.f16155e == 1 || !isLayoutRTL()) {
            this.f16161k = this.f16160j;
        } else {
            this.f16161k = !this.f16160j;
        }
    }

    public int s() {
        int i10 = this.f16174x;
        return i10 == Integer.MAX_VALUE ? (this.f16159i.p() - this.f16154d) / 2 : i10;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f16155e == 1) {
            return 0;
        }
        return scrollBy(i10, recycler, state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i10) {
        if (this.f16168r || (i10 >= 0 && i10 < getItemCount())) {
            this.f16163m = i10;
            this.f16158h = i10 * (this.f16161k ? -this.f16165o : this.f16165o);
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f16155e == 0) {
            return 0;
        }
        return scrollBy(i10, recycler, state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setOrientation(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i10);
        }
        assertNotInLayoutOrScroll(null);
        if (i10 == this.f16155e) {
            return;
        }
        this.f16155e = i10;
        this.f16159i = null;
        this.f16174x = Integer.MAX_VALUE;
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setRecycleChildrenOnDetach(boolean z10) {
        this.f16167q = z10;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setReverseLayout(boolean z10) {
        assertNotInLayoutOrScroll(null);
        if (z10 == this.f16160j) {
            return;
        }
        this.f16160j = z10;
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setSmoothScrollbarEnabled(boolean z10) {
        this.f16162l = z10;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i10) {
        int D2;
        int i11;
        if (this.f16168r) {
            int p10 = p();
            int itemCount = getItemCount();
            if (i10 < p10) {
                int i12 = p10 - i10;
                int i13 = (itemCount - p10) + i10;
                i11 = i12 < i13 ? p10 - i12 : p10 + i13;
            } else {
                int i14 = i10 - p10;
                int i15 = (itemCount + p10) - i10;
                i11 = i14 < i15 ? p10 + i14 : p10 - i15;
            }
            D2 = D(i11);
        } else {
            D2 = D(i10);
        }
        if (this.f16155e == 1) {
            recyclerView.smoothScrollBy(0, D2, this.f16173w);
        } else {
            recyclerView.smoothScrollBy(D2, 0, this.f16173w);
        }
    }

    public boolean t() {
        return this.f16169s;
    }

    public boolean u() {
        return this.f16168r;
    }

    public int v(View view) {
        for (int i10 = 0; i10 < this.f16152b.size(); i10++) {
            int keyAt = this.f16152b.keyAt(i10);
            if (this.f16152b.get(keyAt) == view) {
                return keyAt;
            }
        }
        return -1;
    }

    public float w() {
        if (this.f16161k) {
            return 0.0f;
        }
        return (getItemCount() - 1) * this.f16165o;
    }

    public int x() {
        return this.f16172v;
    }

    public final View y(RecyclerView.Recycler recycler, RecyclerView.State state, int i10) {
        if (i10 >= state.getItemCount() || i10 < 0) {
            return null;
        }
        try {
            return recycler.getViewForPosition(i10);
        } catch (Exception unused) {
            return y(recycler, state, i10 + 1);
        }
    }

    public float z() {
        if (this.f16161k) {
            return (-(getItemCount() - 1)) * this.f16165o;
        }
        return 0.0f;
    }

    public ViewPagerLayoutManager(Context context, int i10, boolean z10) {
        super(context);
        this.f16152b = new SparseArray<>();
        this.f16160j = false;
        this.f16161k = false;
        this.f16162l = true;
        this.f16163m = -1;
        this.f16164n = null;
        this.f16168r = false;
        this.f16172v = -1;
        this.f16174x = Integer.MAX_VALUE;
        setOrientation(i10);
        setReverseLayout(z10);
        setAutoMeasureEnabled(true);
        setItemPrefetchEnabled(false);
    }
}
