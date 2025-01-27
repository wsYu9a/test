package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.b;
import java.util.ArrayList;
import java.util.List;
import s4.d;

/* loaded from: classes2.dex */
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements d, RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static final String B = "FlexboxLayoutManager";
    public static final Rect C = new Rect();
    public static final boolean D = false;
    public static final /* synthetic */ boolean E = false;
    public b.C0255b A;

    /* renamed from: b */
    public int f9007b;

    /* renamed from: c */
    public int f9008c;

    /* renamed from: d */
    public int f9009d;

    /* renamed from: e */
    public int f9010e;

    /* renamed from: f */
    public int f9011f;

    /* renamed from: g */
    public boolean f9012g;

    /* renamed from: h */
    public boolean f9013h;

    /* renamed from: i */
    public List<com.google.android.flexbox.a> f9014i;

    /* renamed from: j */
    public final com.google.android.flexbox.b f9015j;

    /* renamed from: k */
    public RecyclerView.Recycler f9016k;

    /* renamed from: l */
    public RecyclerView.State f9017l;

    /* renamed from: m */
    public c f9018m;

    /* renamed from: n */
    public b f9019n;

    /* renamed from: o */
    public OrientationHelper f9020o;

    /* renamed from: p */
    public OrientationHelper f9021p;

    /* renamed from: q */
    public SavedState f9022q;

    /* renamed from: r */
    public int f9023r;

    /* renamed from: s */
    public int f9024s;

    /* renamed from: t */
    public int f9025t;

    /* renamed from: u */
    public int f9026u;

    /* renamed from: v */
    public boolean f9027v;

    /* renamed from: w */
    public SparseArray<View> f9028w;

    /* renamed from: x */
    public final Context f9029x;

    /* renamed from: y */
    public View f9030y;

    /* renamed from: z */
    public int f9031z;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: b */
        public int f9041b;

        /* renamed from: c */
        public int f9042c;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel source) {
                return new SavedState(source);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        public final boolean D(int itemCount) {
            int i10 = this.f9041b;
            return i10 >= 0 && i10 < itemCount;
        }

        public final void E() {
            this.f9041b = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NonNull
        public String toString() {
            return "SavedState{mAnchorPosition=" + this.f9041b + ", mAnchorOffset=" + this.f9042c + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.f9041b);
            dest.writeInt(this.f9042c);
        }

        public /* synthetic */ SavedState(SavedState savedState, a aVar) {
            this(savedState);
        }

        public SavedState() {
        }

        public SavedState(Parcel in) {
            this.f9041b = in.readInt();
            this.f9042c = in.readInt();
        }

        public SavedState(SavedState savedState) {
            this.f9041b = savedState.f9041b;
            this.f9042c = savedState.f9042c;
        }
    }

    public FlexboxLayoutManager(Context context) {
        this(context, 0, 1);
    }

    private void ensureLayoutState() {
        if (this.f9018m == null) {
            this.f9018m = new c();
        }
    }

    public static boolean isMeasurementUpToDate(int childSize, int spec, int dimension) {
        int mode = View.MeasureSpec.getMode(spec);
        int size = View.MeasureSpec.getSize(spec);
        if (dimension > 0 && childSize != dimension) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= childSize;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == childSize;
        }
        return true;
    }

    private boolean shouldMeasureChild(View child, int widthSpec, int heightSpec, RecyclerView.LayoutParams lp) {
        return (!child.isLayoutRequested() && isMeasurementCacheEnabled() && isMeasurementUpToDate(child.getWidth(), widthSpec, ((ViewGroup.MarginLayoutParams) lp).width) && isMeasurementUpToDate(child.getHeight(), heightSpec, ((ViewGroup.MarginLayoutParams) lp).height)) ? false : true;
    }

    public final View A(int fromIndex, int toIndex, boolean completelyVisible) {
        int i10 = toIndex > fromIndex ? 1 : -1;
        while (fromIndex != toIndex) {
            View childAt = getChildAt(fromIndex);
            if (K(childAt, completelyVisible)) {
                return childAt;
            }
            fromIndex += i10;
        }
        return null;
    }

    public final View B(int start, int end, int itemCount) {
        int position;
        u();
        ensureLayoutState();
        int startAfterPadding = this.f9020o.getStartAfterPadding();
        int endAfterPadding = this.f9020o.getEndAfterPadding();
        int i10 = end > start ? 1 : -1;
        View view = null;
        View view2 = null;
        while (start != end) {
            View childAt = getChildAt(start);
            if (childAt != null && (position = getPosition(childAt)) >= 0 && position < itemCount) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.f9020o.getDecoratedStart(childAt) >= startAfterPadding && this.f9020o.getDecoratedEnd(childAt) <= endAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            start += i10;
        }
        return view != null ? view : view2;
    }

    public final int C(View view) {
        return getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    public final int D(View view) {
        return getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }

    public final int E(View view) {
        return getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    public final int F(View view) {
        return getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    public int G(int position) {
        return this.f9015j.f9089c[position];
    }

    public final int H(int delta, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || delta == 0) {
            return 0;
        }
        u();
        int i10 = 1;
        this.f9018m.f9065j = true;
        boolean z10 = !j() && this.f9012g;
        if (!z10 ? delta <= 0 : delta >= 0) {
            i10 = -1;
        }
        int abs = Math.abs(delta);
        Y(i10, abs);
        int v10 = this.f9018m.f9061f + v(recycler, state, this.f9018m);
        if (v10 < 0) {
            return 0;
        }
        if (z10) {
            if (abs > v10) {
                delta = (-i10) * v10;
            }
        } else if (abs > v10) {
            delta = i10 * v10;
        }
        this.f9020o.offsetChildren(-delta);
        this.f9018m.f9062g = delta;
        return delta;
    }

    public final int I(int delta) {
        int i10;
        if (getChildCount() == 0 || delta == 0) {
            return 0;
        }
        u();
        boolean j10 = j();
        View view = this.f9030y;
        int width = j10 ? view.getWidth() : view.getHeight();
        int width2 = j10 ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(delta);
            if (delta < 0) {
                i10 = Math.min((width2 + this.f9019n.f9047d) - width, abs);
            } else {
                if (this.f9019n.f9047d + delta <= 0) {
                    return delta;
                }
                i10 = this.f9019n.f9047d;
            }
        } else {
            if (delta > 0) {
                return Math.min((width2 - this.f9019n.f9047d) - width, delta);
            }
            if (this.f9019n.f9047d + delta >= 0) {
                return delta;
            }
            i10 = this.f9019n.f9047d;
        }
        return -i10;
    }

    public boolean J() {
        return this.f9012g;
    }

    public final boolean K(View view, boolean completelyVisible) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int D2 = D(view);
        int F = F(view);
        int E2 = E(view);
        int C2 = C(view);
        return completelyVisible ? (paddingLeft <= D2 && width >= E2) && (paddingTop <= F && height >= C2) : (D2 >= width || E2 >= paddingLeft) && (F >= height || C2 >= paddingTop);
    }

    public final int L(com.google.android.flexbox.a flexLine, c layoutState) {
        return j() ? M(flexLine, layoutState) : N(flexLine, layoutState);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int M(com.google.android.flexbox.a r22, com.google.android.flexbox.FlexboxLayoutManager.c r23) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.M(com.google.android.flexbox.a, com.google.android.flexbox.FlexboxLayoutManager$c):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int N(com.google.android.flexbox.a r26, com.google.android.flexbox.FlexboxLayoutManager.c r27) {
        /*
            Method dump skipped, instructions count: 541
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.N(com.google.android.flexbox.a, com.google.android.flexbox.FlexboxLayoutManager$c):int");
    }

    public final void O(RecyclerView.Recycler recycler, c layoutState) {
        if (layoutState.f9065j) {
            if (layoutState.f9064i == -1) {
                P(recycler, layoutState);
            } else {
                Q(recycler, layoutState);
            }
        }
    }

    public final void P(RecyclerView.Recycler recycler, c layoutState) {
        int childCount;
        int i10;
        View childAt;
        int i11;
        if (layoutState.f9061f < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt(childCount - 1)) == null || (i11 = this.f9015j.f9089c[getPosition(childAt)]) == -1) {
            return;
        }
        com.google.android.flexbox.a aVar = this.f9014i.get(i11);
        int i12 = i10;
        while (true) {
            if (i12 < 0) {
                break;
            }
            View childAt2 = getChildAt(i12);
            if (childAt2 != null) {
                if (!r(childAt2, layoutState.f9061f)) {
                    break;
                }
                if (aVar.f9080o != getPosition(childAt2)) {
                    continue;
                } else if (i11 <= 0) {
                    childCount = i12;
                    break;
                } else {
                    i11 += layoutState.f9064i;
                    aVar = this.f9014i.get(i11);
                    childCount = i12;
                }
            }
            i12--;
        }
        recycleChildren(recycler, childCount, i10);
    }

    public final void Q(RecyclerView.Recycler recycler, c layoutState) {
        int childCount;
        View childAt;
        if (layoutState.f9061f < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt(0)) == null) {
            return;
        }
        int i10 = this.f9015j.f9089c[getPosition(childAt)];
        int i11 = -1;
        if (i10 == -1) {
            return;
        }
        com.google.android.flexbox.a aVar = this.f9014i.get(i10);
        int i12 = 0;
        while (true) {
            if (i12 >= childCount) {
                break;
            }
            View childAt2 = getChildAt(i12);
            if (childAt2 != null) {
                if (!s(childAt2, layoutState.f9061f)) {
                    break;
                }
                if (aVar.f9081p != getPosition(childAt2)) {
                    continue;
                } else if (i10 >= this.f9014i.size() - 1) {
                    i11 = i12;
                    break;
                } else {
                    i10 += layoutState.f9064i;
                    aVar = this.f9014i.get(i10);
                    i11 = i12;
                }
            }
            i12++;
        }
        recycleChildren(recycler, 0, i11);
    }

    public final void R() {
        int heightMode = j() ? getHeightMode() : getWidthMode();
        this.f9018m.f9057b = heightMode == 0 || heightMode == Integer.MIN_VALUE;
    }

    public final void S() {
        int layoutDirection = getLayoutDirection();
        int i10 = this.f9007b;
        if (i10 == 0) {
            this.f9012g = layoutDirection == 1;
            this.f9013h = this.f9008c == 2;
            return;
        }
        if (i10 == 1) {
            this.f9012g = layoutDirection != 1;
            this.f9013h = this.f9008c == 2;
            return;
        }
        if (i10 == 2) {
            boolean z10 = layoutDirection == 1;
            this.f9012g = z10;
            if (this.f9008c == 2) {
                this.f9012g = !z10;
            }
            this.f9013h = false;
            return;
        }
        if (i10 != 3) {
            this.f9012g = false;
            this.f9013h = false;
            return;
        }
        boolean z11 = layoutDirection == 1;
        this.f9012g = z11;
        if (this.f9008c == 2) {
            this.f9012g = !z11;
        }
        this.f9013h = true;
    }

    public final boolean T(RecyclerView.State state, b anchorInfo) {
        if (getChildCount() == 0) {
            return false;
        }
        View y10 = anchorInfo.f9048e ? y(state.getItemCount()) : w(state.getItemCount());
        if (y10 == null) {
            return false;
        }
        anchorInfo.s(y10);
        if (state.isPreLayout() || !supportsPredictiveItemAnimations()) {
            return true;
        }
        if (this.f9020o.getDecoratedStart(y10) < this.f9020o.getEndAfterPadding() && this.f9020o.getDecoratedEnd(y10) >= this.f9020o.getStartAfterPadding()) {
            return true;
        }
        anchorInfo.f9046c = anchorInfo.f9048e ? this.f9020o.getEndAfterPadding() : this.f9020o.getStartAfterPadding();
        return true;
    }

    public final boolean U(RecyclerView.State state, b anchorInfo, SavedState savedState) {
        int i10;
        View childAt;
        if (!state.isPreLayout() && (i10 = this.f9023r) != -1) {
            if (i10 >= 0 && i10 < state.getItemCount()) {
                anchorInfo.f9044a = this.f9023r;
                anchorInfo.f9045b = this.f9015j.f9089c[anchorInfo.f9044a];
                SavedState savedState2 = this.f9022q;
                if (savedState2 != null && savedState2.D(state.getItemCount())) {
                    anchorInfo.f9046c = this.f9020o.getStartAfterPadding() + savedState.f9042c;
                    anchorInfo.f9050g = true;
                    anchorInfo.f9045b = -1;
                    return true;
                }
                if (this.f9024s != Integer.MIN_VALUE) {
                    if (j() || !this.f9012g) {
                        anchorInfo.f9046c = this.f9020o.getStartAfterPadding() + this.f9024s;
                    } else {
                        anchorInfo.f9046c = this.f9024s - this.f9020o.getEndPadding();
                    }
                    return true;
                }
                View findViewByPosition = findViewByPosition(this.f9023r);
                if (findViewByPosition == null) {
                    if (getChildCount() > 0 && (childAt = getChildAt(0)) != null) {
                        anchorInfo.f9048e = this.f9023r < getPosition(childAt);
                    }
                    anchorInfo.r();
                } else {
                    if (this.f9020o.getDecoratedMeasurement(findViewByPosition) > this.f9020o.getTotalSpace()) {
                        anchorInfo.r();
                        return true;
                    }
                    if (this.f9020o.getDecoratedStart(findViewByPosition) - this.f9020o.getStartAfterPadding() < 0) {
                        anchorInfo.f9046c = this.f9020o.getStartAfterPadding();
                        anchorInfo.f9048e = false;
                        return true;
                    }
                    if (this.f9020o.getEndAfterPadding() - this.f9020o.getDecoratedEnd(findViewByPosition) < 0) {
                        anchorInfo.f9046c = this.f9020o.getEndAfterPadding();
                        anchorInfo.f9048e = true;
                        return true;
                    }
                    anchorInfo.f9046c = anchorInfo.f9048e ? this.f9020o.getDecoratedEnd(findViewByPosition) + this.f9020o.getTotalSpaceChange() : this.f9020o.getDecoratedStart(findViewByPosition);
                }
                return true;
            }
            this.f9023r = -1;
            this.f9024s = Integer.MIN_VALUE;
        }
        return false;
    }

    public final void V(RecyclerView.State state, b anchorInfo) {
        if (U(state, anchorInfo, this.f9022q) || T(state, anchorInfo)) {
            return;
        }
        anchorInfo.r();
        anchorInfo.f9044a = 0;
        anchorInfo.f9045b = 0;
    }

    public final void W(int positionStart) {
        if (positionStart >= findLastVisibleItemPosition()) {
            return;
        }
        int childCount = getChildCount();
        this.f9015j.t(childCount);
        this.f9015j.u(childCount);
        this.f9015j.s(childCount);
        if (positionStart >= this.f9015j.f9089c.length) {
            return;
        }
        this.f9031z = positionStart;
        View childClosestToStart = getChildClosestToStart();
        if (childClosestToStart == null) {
            return;
        }
        this.f9023r = getPosition(childClosestToStart);
        if (j() || !this.f9012g) {
            this.f9024s = this.f9020o.getDecoratedStart(childClosestToStart) - this.f9020o.getStartAfterPadding();
        } else {
            this.f9024s = this.f9020o.getDecoratedEnd(childClosestToStart) + this.f9020o.getEndPadding();
        }
    }

    public final void X(int childCount) {
        int i10;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        boolean z10 = false;
        if (j()) {
            int i11 = this.f9025t;
            if (i11 != Integer.MIN_VALUE && i11 != width) {
                z10 = true;
            }
            i10 = this.f9018m.f9057b ? this.f9029x.getResources().getDisplayMetrics().heightPixels : this.f9018m.f9056a;
        } else {
            int i12 = this.f9026u;
            if (i12 != Integer.MIN_VALUE && i12 != height) {
                z10 = true;
            }
            i10 = this.f9018m.f9057b ? this.f9029x.getResources().getDisplayMetrics().widthPixels : this.f9018m.f9056a;
        }
        int i13 = i10;
        this.f9025t = width;
        this.f9026u = height;
        int i14 = this.f9031z;
        if (i14 == -1 && (this.f9023r != -1 || z10)) {
            if (this.f9019n.f9048e) {
                return;
            }
            this.f9014i.clear();
            this.A.a();
            if (j()) {
                this.f9015j.e(this.A, makeMeasureSpec, makeMeasureSpec2, i13, this.f9019n.f9044a, this.f9014i);
            } else {
                this.f9015j.h(this.A, makeMeasureSpec, makeMeasureSpec2, i13, this.f9019n.f9044a, this.f9014i);
            }
            this.f9014i = this.A.f9092a;
            this.f9015j.p(makeMeasureSpec, makeMeasureSpec2);
            this.f9015j.X();
            b bVar = this.f9019n;
            bVar.f9045b = this.f9015j.f9089c[bVar.f9044a];
            this.f9018m.f9058c = this.f9019n.f9045b;
            return;
        }
        int min = i14 != -1 ? Math.min(i14, this.f9019n.f9044a) : this.f9019n.f9044a;
        this.A.a();
        if (j()) {
            if (this.f9014i.size() > 0) {
                this.f9015j.j(this.f9014i, min);
                this.f9015j.b(this.A, makeMeasureSpec, makeMeasureSpec2, i13, min, this.f9019n.f9044a, this.f9014i);
            } else {
                this.f9015j.s(childCount);
                this.f9015j.d(this.A, makeMeasureSpec, makeMeasureSpec2, i13, 0, this.f9014i);
            }
        } else if (this.f9014i.size() > 0) {
            this.f9015j.j(this.f9014i, min);
            this.f9015j.b(this.A, makeMeasureSpec2, makeMeasureSpec, i13, min, this.f9019n.f9044a, this.f9014i);
        } else {
            this.f9015j.s(childCount);
            this.f9015j.g(this.A, makeMeasureSpec, makeMeasureSpec2, i13, 0, this.f9014i);
        }
        this.f9014i = this.A.f9092a;
        this.f9015j.q(makeMeasureSpec, makeMeasureSpec2, min);
        this.f9015j.Y(min);
    }

    public final void Y(int layoutDirection, int absDelta) {
        this.f9018m.f9064i = layoutDirection;
        boolean j10 = j();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z10 = !j10 && this.f9012g;
        if (layoutDirection == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt == null) {
                return;
            }
            this.f9018m.f9060e = this.f9020o.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View z11 = z(childAt, this.f9014i.get(this.f9015j.f9089c[position]));
            this.f9018m.f9063h = 1;
            c cVar = this.f9018m;
            cVar.f9059d = position + cVar.f9063h;
            if (this.f9015j.f9089c.length <= this.f9018m.f9059d) {
                this.f9018m.f9058c = -1;
            } else {
                c cVar2 = this.f9018m;
                cVar2.f9058c = this.f9015j.f9089c[cVar2.f9059d];
            }
            if (z10) {
                this.f9018m.f9060e = this.f9020o.getDecoratedStart(z11);
                this.f9018m.f9061f = (-this.f9020o.getDecoratedStart(z11)) + this.f9020o.getStartAfterPadding();
                c cVar3 = this.f9018m;
                cVar3.f9061f = Math.max(cVar3.f9061f, 0);
            } else {
                this.f9018m.f9060e = this.f9020o.getDecoratedEnd(z11);
                this.f9018m.f9061f = this.f9020o.getDecoratedEnd(z11) - this.f9020o.getEndAfterPadding();
            }
            if ((this.f9018m.f9058c == -1 || this.f9018m.f9058c > this.f9014i.size() - 1) && this.f9018m.f9059d <= getFlexItemCount()) {
                int i10 = absDelta - this.f9018m.f9061f;
                this.A.a();
                if (i10 > 0) {
                    if (j10) {
                        this.f9015j.d(this.A, makeMeasureSpec, makeMeasureSpec2, i10, this.f9018m.f9059d, this.f9014i);
                    } else {
                        this.f9015j.g(this.A, makeMeasureSpec, makeMeasureSpec2, i10, this.f9018m.f9059d, this.f9014i);
                    }
                    this.f9015j.q(makeMeasureSpec, makeMeasureSpec2, this.f9018m.f9059d);
                    this.f9015j.Y(this.f9018m.f9059d);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            if (childAt2 == null) {
                return;
            }
            this.f9018m.f9060e = this.f9020o.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View x10 = x(childAt2, this.f9014i.get(this.f9015j.f9089c[position2]));
            this.f9018m.f9063h = 1;
            int i11 = this.f9015j.f9089c[position2];
            if (i11 == -1) {
                i11 = 0;
            }
            if (i11 > 0) {
                this.f9018m.f9059d = position2 - this.f9014i.get(i11 - 1).c();
            } else {
                this.f9018m.f9059d = -1;
            }
            this.f9018m.f9058c = i11 > 0 ? i11 - 1 : 0;
            if (z10) {
                this.f9018m.f9060e = this.f9020o.getDecoratedEnd(x10);
                this.f9018m.f9061f = this.f9020o.getDecoratedEnd(x10) - this.f9020o.getEndAfterPadding();
                c cVar4 = this.f9018m;
                cVar4.f9061f = Math.max(cVar4.f9061f, 0);
            } else {
                this.f9018m.f9060e = this.f9020o.getDecoratedStart(x10);
                this.f9018m.f9061f = (-this.f9020o.getDecoratedStart(x10)) + this.f9020o.getStartAfterPadding();
            }
        }
        c cVar5 = this.f9018m;
        cVar5.f9056a = absDelta - cVar5.f9061f;
    }

    public final void Z(b anchorInfo, boolean fromNextLine, boolean considerInfinite) {
        if (considerInfinite) {
            R();
        } else {
            this.f9018m.f9057b = false;
        }
        if (j() || !this.f9012g) {
            this.f9018m.f9056a = this.f9020o.getEndAfterPadding() - anchorInfo.f9046c;
        } else {
            this.f9018m.f9056a = anchorInfo.f9046c - getPaddingRight();
        }
        this.f9018m.f9059d = anchorInfo.f9044a;
        this.f9018m.f9063h = 1;
        this.f9018m.f9064i = 1;
        this.f9018m.f9060e = anchorInfo.f9046c;
        this.f9018m.f9061f = Integer.MIN_VALUE;
        this.f9018m.f9058c = anchorInfo.f9045b;
        if (!fromNextLine || this.f9014i.size() <= 1 || anchorInfo.f9045b < 0 || anchorInfo.f9045b >= this.f9014i.size() - 1) {
            return;
        }
        com.google.android.flexbox.a aVar = this.f9014i.get(anchorInfo.f9045b);
        c.l(this.f9018m);
        c.u(this.f9018m, aVar.c());
    }

    @Override // s4.d
    public void a(View view, int index, int indexInFlexLine, com.google.android.flexbox.a flexLine) {
        calculateItemDecorationsForChild(view, C);
        if (j()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            flexLine.f9070e += leftDecorationWidth;
            flexLine.f9071f += leftDecorationWidth;
        } else {
            int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
            flexLine.f9070e += topDecorationHeight;
            flexLine.f9071f += topDecorationHeight;
        }
    }

    public final void a0(b anchorInfo, boolean fromPreviousLine, boolean considerInfinite) {
        if (considerInfinite) {
            R();
        } else {
            this.f9018m.f9057b = false;
        }
        if (j() || !this.f9012g) {
            this.f9018m.f9056a = anchorInfo.f9046c - this.f9020o.getStartAfterPadding();
        } else {
            this.f9018m.f9056a = (this.f9030y.getWidth() - anchorInfo.f9046c) - this.f9020o.getStartAfterPadding();
        }
        this.f9018m.f9059d = anchorInfo.f9044a;
        this.f9018m.f9063h = 1;
        this.f9018m.f9064i = -1;
        this.f9018m.f9060e = anchorInfo.f9046c;
        this.f9018m.f9061f = Integer.MIN_VALUE;
        this.f9018m.f9058c = anchorInfo.f9045b;
        if (!fromPreviousLine || anchorInfo.f9045b <= 0 || this.f9014i.size() <= anchorInfo.f9045b) {
            return;
        }
        com.google.android.flexbox.a aVar = this.f9014i.get(anchorInfo.f9045b);
        c.m(this.f9018m);
        c.v(this.f9018m, aVar.c());
    }

    @Override // s4.d
    public int b(int widthSpec, int padding, int childDimension) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), padding, childDimension, canScrollHorizontally());
    }

    @Override // s4.d
    public View c(int index) {
        View view = this.f9028w.get(index);
        return view != null ? view : this.f9016k.getViewForPosition(index);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.f9008c == 0) {
            return j();
        }
        if (j()) {
            int width = getWidth();
            View view = this.f9030y;
            if (width <= (view != null ? view.getWidth() : 0)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.f9008c == 0) {
            return !j();
        }
        if (j()) {
            return true;
        }
        int height = getHeight();
        View view = this.f9030y;
        return height > (view != null ? view.getHeight() : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
        return lp instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(@NonNull RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(@NonNull RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(@NonNull RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public final int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        u();
        View w10 = w(itemCount);
        View y10 = y(itemCount);
        if (state.getItemCount() == 0 || w10 == null || y10 == null) {
            return 0;
        }
        return Math.min(this.f9020o.getTotalSpace(), this.f9020o.getDecoratedEnd(y10) - this.f9020o.getDecoratedStart(w10));
    }

    public final int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View w10 = w(itemCount);
        View y10 = y(itemCount);
        if (state.getItemCount() != 0 && w10 != null && y10 != null) {
            int position = getPosition(w10);
            int position2 = getPosition(y10);
            int abs = Math.abs(this.f9020o.getDecoratedEnd(y10) - this.f9020o.getDecoratedStart(w10));
            int i10 = this.f9015j.f9089c[position];
            if (i10 != 0 && i10 != -1) {
                return Math.round((i10 * (abs / ((r4[position2] - i10) + 1))) + (this.f9020o.getStartAfterPadding() - this.f9020o.getDecoratedStart(w10)));
            }
        }
        return 0;
    }

    public final int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View w10 = w(itemCount);
        View y10 = y(itemCount);
        if (state.getItemCount() == 0 || w10 == null || y10 == null) {
            return 0;
        }
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        return (int) ((Math.abs(this.f9020o.getDecoratedEnd(y10) - this.f9020o.getDecoratedStart(w10)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1)) * state.getItemCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int targetPosition) {
        View childAt;
        if (getChildCount() == 0 || (childAt = getChildAt(0)) == null) {
            return null;
        }
        int i10 = targetPosition < getPosition(childAt) ? -1 : 1;
        return j() ? new PointF(0.0f, i10) : new PointF(i10, 0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(@NonNull RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(@NonNull RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(@NonNull RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // s4.d
    public int d(int heightSpec, int padding, int childDimension) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), padding, childDimension, canScrollVertically());
    }

    @Override // s4.d
    public int e(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (j()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return leftDecorationWidth + rightDecorationWidth;
    }

    @Override // s4.d
    public void f(com.google.android.flexbox.a flexLine) {
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View A = A(0, getChildCount(), true);
        if (A == null) {
            return -1;
        }
        return getPosition(A);
    }

    public int findFirstVisibleItemPosition() {
        View A = A(0, getChildCount(), false);
        if (A == null) {
            return -1;
        }
        return getPosition(A);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View A = A(getChildCount() - 1, -1, true);
        if (A == null) {
            return -1;
        }
        return getPosition(A);
    }

    public int findLastVisibleItemPosition() {
        View A = A(getChildCount() - 1, -1, false);
        if (A == null) {
            return -1;
        }
        return getPosition(A);
    }

    public final int fixLayoutEndGap(int endOffset, RecyclerView.Recycler recycler, RecyclerView.State state, boolean canOffsetChildren) {
        int i10;
        int endAfterPadding;
        if (j() || !this.f9012g) {
            int endAfterPadding2 = this.f9020o.getEndAfterPadding() - endOffset;
            if (endAfterPadding2 <= 0) {
                return 0;
            }
            i10 = -H(-endAfterPadding2, recycler, state);
        } else {
            int startAfterPadding = endOffset - this.f9020o.getStartAfterPadding();
            if (startAfterPadding <= 0) {
                return 0;
            }
            i10 = H(startAfterPadding, recycler, state);
        }
        int i11 = endOffset + i10;
        if (!canOffsetChildren || (endAfterPadding = this.f9020o.getEndAfterPadding() - i11) <= 0) {
            return i10;
        }
        this.f9020o.offsetChildren(endAfterPadding);
        return endAfterPadding + i10;
    }

    public final int fixLayoutStartGap(int startOffset, RecyclerView.Recycler recycler, RecyclerView.State state, boolean canOffsetChildren) {
        int i10;
        int startAfterPadding;
        if (j() || !this.f9012g) {
            int startAfterPadding2 = startOffset - this.f9020o.getStartAfterPadding();
            if (startAfterPadding2 <= 0) {
                return 0;
            }
            i10 = -H(startAfterPadding2, recycler, state);
        } else {
            int endAfterPadding = this.f9020o.getEndAfterPadding() - startOffset;
            if (endAfterPadding <= 0) {
                return 0;
            }
            i10 = H(-endAfterPadding, recycler, state);
        }
        int i11 = startOffset + i10;
        if (!canOffsetChildren || (startAfterPadding = i11 - this.f9020o.getStartAfterPadding()) <= 0) {
            return i10;
        }
        this.f9020o.offsetChildren(-startAfterPadding);
        return i10 - startAfterPadding;
    }

    @Override // s4.d
    public View g(int index) {
        return c(index);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context c10, AttributeSet attrs) {
        return new LayoutParams(c10, attrs);
    }

    @Override // s4.d
    public int getAlignContent() {
        return 5;
    }

    @Override // s4.d
    public int getAlignItems() {
        return this.f9010e;
    }

    public final View getChildClosestToStart() {
        return getChildAt(0);
    }

    @Override // s4.d
    public int getFlexDirection() {
        return this.f9007b;
    }

    @Override // s4.d
    public int getFlexItemCount() {
        return this.f9017l.getItemCount();
    }

    @Override // s4.d
    @NonNull
    public List<com.google.android.flexbox.a> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.f9014i.size());
        int size = this.f9014i.size();
        for (int i10 = 0; i10 < size; i10++) {
            com.google.android.flexbox.a aVar = this.f9014i.get(i10);
            if (aVar.c() != 0) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    @Override // s4.d
    public List<com.google.android.flexbox.a> getFlexLinesInternal() {
        return this.f9014i;
    }

    @Override // s4.d
    public int getFlexWrap() {
        return this.f9008c;
    }

    @Override // s4.d
    public int getJustifyContent() {
        return this.f9009d;
    }

    @Override // s4.d
    public int getLargestMainSize() {
        if (this.f9014i.size() == 0) {
            return 0;
        }
        int size = this.f9014i.size();
        int i10 = Integer.MIN_VALUE;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = Math.max(i10, this.f9014i.get(i11).f9070e);
        }
        return i10;
    }

    @Override // s4.d
    public int getMaxLine() {
        return this.f9011f;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.f9027v;
    }

    @Override // s4.d
    public int getSumOfCrossSize() {
        int size = this.f9014i.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            i10 += this.f9014i.get(i11).f9072g;
        }
        return i10;
    }

    @Override // s4.d
    public void h(int position, View view) {
        this.f9028w.put(position, view);
    }

    @Override // s4.d
    public int i(View view, int index, int indexInFlexLine) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (j()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return topDecorationHeight + bottomDecorationHeight;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // s4.d
    public boolean j() {
        int i10 = this.f9007b;
        return i10 == 0 || i10 == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter oldAdapter, RecyclerView.Adapter newAdapter) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.f9030y = (View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView view, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(view, recycler);
        if (this.f9027v) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(@NonNull RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsAdded(recyclerView, positionStart, itemCount);
        W(positionStart);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(@NonNull RecyclerView recyclerView, int from, int to, int itemCount) {
        super.onItemsMoved(recyclerView, from, to, itemCount);
        W(Math.min(from, to));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(@NonNull RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsRemoved(recyclerView, positionStart, itemCount);
        W(positionStart);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int positionStart, int itemCount, Object payload) {
        super.onItemsUpdated(recyclerView, positionStart, itemCount, payload);
        W(positionStart);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i10;
        int i11;
        this.f9016k = recycler;
        this.f9017l = state;
        int itemCount = state.getItemCount();
        if (itemCount == 0 && state.isPreLayout()) {
            return;
        }
        S();
        u();
        ensureLayoutState();
        this.f9015j.t(itemCount);
        this.f9015j.u(itemCount);
        this.f9015j.s(itemCount);
        this.f9018m.f9065j = false;
        SavedState savedState = this.f9022q;
        if (savedState != null && savedState.D(itemCount)) {
            this.f9023r = this.f9022q.f9041b;
        }
        if (!this.f9019n.f9049f || this.f9023r != -1 || this.f9022q != null) {
            this.f9019n.t();
            V(state, this.f9019n);
            this.f9019n.f9049f = true;
        }
        detachAndScrapAttachedViews(recycler);
        if (this.f9019n.f9048e) {
            a0(this.f9019n, false, true);
        } else {
            Z(this.f9019n, false, true);
        }
        X(itemCount);
        v(recycler, state, this.f9018m);
        if (this.f9019n.f9048e) {
            i11 = this.f9018m.f9060e;
            Z(this.f9019n, true, false);
            v(recycler, state, this.f9018m);
            i10 = this.f9018m.f9060e;
        } else {
            i10 = this.f9018m.f9060e;
            a0(this.f9019n, true, false);
            v(recycler, state, this.f9018m);
            i11 = this.f9018m.f9060e;
        }
        if (getChildCount() > 0) {
            if (this.f9019n.f9048e) {
                fixLayoutStartGap(i11 + fixLayoutEndGap(i10, recycler, state, true), recycler, state, false);
            } else {
                fixLayoutEndGap(i10 + fixLayoutStartGap(i11, recycler, state, true), recycler, state, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f9022q = null;
        this.f9023r = -1;
        this.f9024s = Integer.MIN_VALUE;
        this.f9031z = -1;
        this.f9019n.t();
        this.f9028w.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof SavedState) {
            this.f9022q = (SavedState) state;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.f9022q != null) {
            return new SavedState(this.f9022q);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            View childClosestToStart = getChildClosestToStart();
            savedState.f9041b = getPosition(childClosestToStart);
            savedState.f9042c = this.f9020o.getDecoratedStart(childClosestToStart) - this.f9020o.getStartAfterPadding();
        } else {
            savedState.E();
        }
        return savedState;
    }

    public final boolean r(View view, int scrollingOffset) {
        return (j() || !this.f9012g) ? this.f9020o.getDecoratedStart(view) >= this.f9020o.getEnd() - scrollingOffset : this.f9020o.getDecoratedEnd(view) <= scrollingOffset;
    }

    public final void recycleChildren(RecyclerView.Recycler recycler, int startIndex, int endIndex) {
        while (endIndex >= startIndex) {
            removeAndRecycleViewAt(endIndex, recycler);
            endIndex--;
        }
    }

    public final boolean s(View view, int scrollingOffset) {
        return (j() || !this.f9012g) ? this.f9020o.getDecoratedEnd(view) <= scrollingOffset : this.f9020o.getEnd() - this.f9020o.getDecoratedStart(view) <= scrollingOffset;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!j() || this.f9008c == 0) {
            int H = H(dx, recycler, state);
            this.f9028w.clear();
            return H;
        }
        int I = I(dx);
        b.l(this.f9019n, I);
        this.f9021p.offsetChildren(-I);
        return I;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int position) {
        this.f9023r = position;
        this.f9024s = Integer.MIN_VALUE;
        SavedState savedState = this.f9022q;
        if (savedState != null) {
            savedState.E();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (j() || (this.f9008c == 0 && !j())) {
            int H = H(dy, recycler, state);
            this.f9028w.clear();
            return H;
        }
        int I = I(dy);
        b.l(this.f9019n, I);
        this.f9021p.offsetChildren(-I);
        return I;
    }

    @Override // s4.d
    public void setAlignContent(int alignContent) {
        throw new UnsupportedOperationException("Setting the alignContent in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to use this attribute.");
    }

    @Override // s4.d
    public void setAlignItems(int alignItems) {
        int i10 = this.f9010e;
        if (i10 != alignItems) {
            if (i10 == 4 || alignItems == 4) {
                removeAllViews();
                t();
            }
            this.f9010e = alignItems;
            requestLayout();
        }
    }

    @Override // s4.d
    public void setFlexDirection(int flexDirection) {
        if (this.f9007b != flexDirection) {
            removeAllViews();
            this.f9007b = flexDirection;
            this.f9020o = null;
            this.f9021p = null;
            t();
            requestLayout();
        }
    }

    @Override // s4.d
    public void setFlexLines(List<com.google.android.flexbox.a> flexLines) {
        this.f9014i = flexLines;
    }

    @Override // s4.d
    public void setFlexWrap(int flexWrap) {
        if (flexWrap == 2) {
            throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
        }
        int i10 = this.f9008c;
        if (i10 != flexWrap) {
            if (i10 == 0 || flexWrap == 0) {
                removeAllViews();
                t();
            }
            this.f9008c = flexWrap;
            this.f9020o = null;
            this.f9021p = null;
            requestLayout();
        }
    }

    @Override // s4.d
    public void setJustifyContent(int justifyContent) {
        if (this.f9009d != justifyContent) {
            this.f9009d = justifyContent;
            requestLayout();
        }
    }

    @Override // s4.d
    public void setMaxLine(int maxLine) {
        if (this.f9011f != maxLine) {
            this.f9011f = maxLine;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean recycleChildrenOnDetach) {
        this.f9027v = recycleChildrenOnDetach;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(position);
        startSmoothScroll(linearSmoothScroller);
    }

    public final void t() {
        this.f9014i.clear();
        this.f9019n.t();
        this.f9019n.f9047d = 0;
    }

    public final void u() {
        if (this.f9020o != null) {
            return;
        }
        if (j()) {
            if (this.f9008c == 0) {
                this.f9020o = OrientationHelper.createHorizontalHelper(this);
                this.f9021p = OrientationHelper.createVerticalHelper(this);
                return;
            } else {
                this.f9020o = OrientationHelper.createVerticalHelper(this);
                this.f9021p = OrientationHelper.createHorizontalHelper(this);
                return;
            }
        }
        if (this.f9008c == 0) {
            this.f9020o = OrientationHelper.createVerticalHelper(this);
            this.f9021p = OrientationHelper.createHorizontalHelper(this);
        } else {
            this.f9020o = OrientationHelper.createHorizontalHelper(this);
            this.f9021p = OrientationHelper.createVerticalHelper(this);
        }
    }

    public final int v(RecyclerView.Recycler recycler, RecyclerView.State state, c layoutState) {
        if (layoutState.f9061f != Integer.MIN_VALUE) {
            if (layoutState.f9056a < 0) {
                c.q(layoutState, layoutState.f9056a);
            }
            O(recycler, layoutState);
        }
        int i10 = layoutState.f9056a;
        int i11 = layoutState.f9056a;
        boolean j10 = j();
        int i12 = 0;
        while (true) {
            if ((i11 > 0 || this.f9018m.f9057b) && layoutState.D(state, this.f9014i)) {
                com.google.android.flexbox.a aVar = this.f9014i.get(layoutState.f9058c);
                layoutState.f9059d = aVar.f9080o;
                i12 += L(aVar, layoutState);
                if (j10 || !this.f9012g) {
                    c.c(layoutState, aVar.a() * layoutState.f9064i);
                } else {
                    c.d(layoutState, aVar.a() * layoutState.f9064i);
                }
                i11 -= aVar.a();
            }
        }
        c.i(layoutState, i12);
        if (layoutState.f9061f != Integer.MIN_VALUE) {
            c.q(layoutState, i12);
            if (layoutState.f9056a < 0) {
                c.q(layoutState, layoutState.f9056a);
            }
            O(recycler, layoutState);
        }
        return i10 - layoutState.f9056a;
    }

    public final View w(int itemCount) {
        View B2 = B(0, getChildCount(), itemCount);
        if (B2 == null) {
            return null;
        }
        int i10 = this.f9015j.f9089c[getPosition(B2)];
        if (i10 == -1) {
            return null;
        }
        return x(B2, this.f9014i.get(i10));
    }

    public final View x(View firstView, com.google.android.flexbox.a firstVisibleLine) {
        boolean j10 = j();
        int i10 = firstVisibleLine.f9073h;
        for (int i11 = 1; i11 < i10; i11++) {
            View childAt = getChildAt(i11);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (!this.f9012g || j10) {
                    if (this.f9020o.getDecoratedStart(firstView) <= this.f9020o.getDecoratedStart(childAt)) {
                    }
                    firstView = childAt;
                } else {
                    if (this.f9020o.getDecoratedEnd(firstView) >= this.f9020o.getDecoratedEnd(childAt)) {
                    }
                    firstView = childAt;
                }
            }
        }
        return firstView;
    }

    public final View y(int itemCount) {
        View B2 = B(getChildCount() - 1, -1, itemCount);
        if (B2 == null) {
            return null;
        }
        return z(B2, this.f9014i.get(this.f9015j.f9089c[getPosition(B2)]));
    }

    public final View z(View lastView, com.google.android.flexbox.a lastVisibleLine) {
        boolean j10 = j();
        int childCount = (getChildCount() - lastVisibleLine.f9073h) - 1;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (!this.f9012g || j10) {
                    if (this.f9020o.getDecoratedEnd(lastView) >= this.f9020o.getDecoratedEnd(childAt)) {
                    }
                    lastView = childAt;
                } else {
                    if (this.f9020o.getDecoratedStart(lastView) <= this.f9020o.getDecoratedStart(childAt)) {
                    }
                    lastView = childAt;
                }
            }
        }
        return lastView;
    }

    public class b {

        /* renamed from: i */
        public static final /* synthetic */ boolean f9043i = false;

        /* renamed from: a */
        public int f9044a;

        /* renamed from: b */
        public int f9045b;

        /* renamed from: c */
        public int f9046c;

        /* renamed from: d */
        public int f9047d;

        /* renamed from: e */
        public boolean f9048e;

        /* renamed from: f */
        public boolean f9049f;

        /* renamed from: g */
        public boolean f9050g;

        public b() {
            this.f9047d = 0;
        }

        public static /* synthetic */ int l(b bVar, int i10) {
            int i11 = bVar.f9047d + i10;
            bVar.f9047d = i11;
            return i11;
        }

        public final void r() {
            if (FlexboxLayoutManager.this.j() || !FlexboxLayoutManager.this.f9012g) {
                this.f9046c = this.f9048e ? FlexboxLayoutManager.this.f9020o.getEndAfterPadding() : FlexboxLayoutManager.this.f9020o.getStartAfterPadding();
            } else {
                this.f9046c = this.f9048e ? FlexboxLayoutManager.this.f9020o.getEndAfterPadding() : FlexboxLayoutManager.this.getWidth() - FlexboxLayoutManager.this.f9020o.getStartAfterPadding();
            }
        }

        public final void s(View anchor) {
            OrientationHelper orientationHelper = FlexboxLayoutManager.this.f9008c == 0 ? FlexboxLayoutManager.this.f9021p : FlexboxLayoutManager.this.f9020o;
            if (FlexboxLayoutManager.this.j() || !FlexboxLayoutManager.this.f9012g) {
                if (this.f9048e) {
                    this.f9046c = orientationHelper.getDecoratedEnd(anchor) + orientationHelper.getTotalSpaceChange();
                } else {
                    this.f9046c = orientationHelper.getDecoratedStart(anchor);
                }
            } else if (this.f9048e) {
                this.f9046c = orientationHelper.getDecoratedStart(anchor) + orientationHelper.getTotalSpaceChange();
            } else {
                this.f9046c = orientationHelper.getDecoratedEnd(anchor);
            }
            this.f9044a = FlexboxLayoutManager.this.getPosition(anchor);
            this.f9050g = false;
            int[] iArr = FlexboxLayoutManager.this.f9015j.f9089c;
            int i10 = this.f9044a;
            if (i10 == -1) {
                i10 = 0;
            }
            int i11 = iArr[i10];
            this.f9045b = i11 != -1 ? i11 : 0;
            if (FlexboxLayoutManager.this.f9014i.size() > this.f9045b) {
                this.f9044a = ((com.google.android.flexbox.a) FlexboxLayoutManager.this.f9014i.get(this.f9045b)).f9080o;
            }
        }

        public final void t() {
            this.f9044a = -1;
            this.f9045b = -1;
            this.f9046c = Integer.MIN_VALUE;
            this.f9049f = false;
            this.f9050g = false;
            if (FlexboxLayoutManager.this.j()) {
                if (FlexboxLayoutManager.this.f9008c == 0) {
                    this.f9048e = FlexboxLayoutManager.this.f9007b == 1;
                    return;
                } else {
                    this.f9048e = FlexboxLayoutManager.this.f9008c == 2;
                    return;
                }
            }
            if (FlexboxLayoutManager.this.f9008c == 0) {
                this.f9048e = FlexboxLayoutManager.this.f9007b == 3;
            } else {
                this.f9048e = FlexboxLayoutManager.this.f9008c == 2;
            }
        }

        @NonNull
        public String toString() {
            return "AnchorInfo{mPosition=" + this.f9044a + ", mFlexLinePosition=" + this.f9045b + ", mCoordinate=" + this.f9046c + ", mPerpendicularCoordinate=" + this.f9047d + ", mLayoutFromEnd=" + this.f9048e + ", mValid=" + this.f9049f + ", mAssignedFromSavedState=" + this.f9050g + '}';
        }

        public /* synthetic */ b(FlexboxLayoutManager flexboxLayoutManager, a aVar) {
            this();
        }
    }

    public FlexboxLayoutManager(Context context, int flexDirection) {
        this(context, flexDirection, 1);
    }

    public static class c {

        /* renamed from: k */
        public static final int f9052k = Integer.MIN_VALUE;

        /* renamed from: l */
        public static final int f9053l = -1;

        /* renamed from: m */
        public static final int f9054m = 1;

        /* renamed from: n */
        public static final int f9055n = 1;

        /* renamed from: a */
        public int f9056a;

        /* renamed from: b */
        public boolean f9057b;

        /* renamed from: c */
        public int f9058c;

        /* renamed from: d */
        public int f9059d;

        /* renamed from: e */
        public int f9060e;

        /* renamed from: f */
        public int f9061f;

        /* renamed from: g */
        public int f9062g;

        /* renamed from: h */
        public int f9063h;

        /* renamed from: i */
        public int f9064i;

        /* renamed from: j */
        public boolean f9065j;

        public c() {
            this.f9063h = 1;
            this.f9064i = 1;
        }

        public static /* synthetic */ int c(c cVar, int i10) {
            int i11 = cVar.f9060e + i10;
            cVar.f9060e = i11;
            return i11;
        }

        public static /* synthetic */ int d(c cVar, int i10) {
            int i11 = cVar.f9060e - i10;
            cVar.f9060e = i11;
            return i11;
        }

        public static /* synthetic */ int i(c cVar, int i10) {
            int i11 = cVar.f9056a - i10;
            cVar.f9056a = i11;
            return i11;
        }

        public static /* synthetic */ int l(c cVar) {
            int i10 = cVar.f9058c;
            cVar.f9058c = i10 + 1;
            return i10;
        }

        public static /* synthetic */ int m(c cVar) {
            int i10 = cVar.f9058c;
            cVar.f9058c = i10 - 1;
            return i10;
        }

        public static /* synthetic */ int n(c cVar, int i10) {
            int i11 = cVar.f9058c + i10;
            cVar.f9058c = i11;
            return i11;
        }

        public static /* synthetic */ int q(c cVar, int i10) {
            int i11 = cVar.f9061f + i10;
            cVar.f9061f = i11;
            return i11;
        }

        public static /* synthetic */ int u(c cVar, int i10) {
            int i11 = cVar.f9059d + i10;
            cVar.f9059d = i11;
            return i11;
        }

        public static /* synthetic */ int v(c cVar, int i10) {
            int i11 = cVar.f9059d - i10;
            cVar.f9059d = i11;
            return i11;
        }

        public final boolean D(RecyclerView.State state, List<com.google.android.flexbox.a> flexLines) {
            int i10;
            int i11 = this.f9059d;
            return i11 >= 0 && i11 < state.getItemCount() && (i10 = this.f9058c) >= 0 && i10 < flexLines.size();
        }

        @NonNull
        public String toString() {
            return "LayoutState{mAvailable=" + this.f9056a + ", mFlexLinePosition=" + this.f9058c + ", mPosition=" + this.f9059d + ", mOffset=" + this.f9060e + ", mScrollingOffset=" + this.f9061f + ", mLastScrollDelta=" + this.f9062g + ", mItemDirection=" + this.f9063h + ", mLayoutDirection=" + this.f9064i + '}';
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public FlexboxLayoutManager(Context context, int flexDirection, int flexWrap) {
        this.f9011f = -1;
        this.f9014i = new ArrayList();
        this.f9015j = new com.google.android.flexbox.b(this);
        this.f9019n = new b();
        this.f9023r = -1;
        this.f9024s = Integer.MIN_VALUE;
        this.f9025t = Integer.MIN_VALUE;
        this.f9026u = Integer.MIN_VALUE;
        this.f9028w = new SparseArray<>();
        this.f9031z = -1;
        this.A = new b.C0255b();
        setFlexDirection(flexDirection);
        setFlexWrap(flexWrap);
        setAlignItems(4);
        this.f9029x = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsUpdated(recyclerView, positionStart, itemCount);
        W(positionStart);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();

        /* renamed from: b */
        public float f9032b;

        /* renamed from: c */
        public float f9033c;

        /* renamed from: d */
        public int f9034d;

        /* renamed from: e */
        public float f9035e;

        /* renamed from: f */
        public int f9036f;

        /* renamed from: g */
        public int f9037g;

        /* renamed from: h */
        public int f9038h;

        /* renamed from: i */
        public int f9039i;

        /* renamed from: j */
        public boolean f9040j;

        public class a implements Parcelable.Creator<LayoutParams> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public LayoutParams createFromParcel(Parcel source) {
                return new LayoutParams(source);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public LayoutParams[] newArray(int size) {
                return new LayoutParams[size];
            }
        }

        public LayoutParams(Context c10, AttributeSet attrs) {
            super(c10, attrs);
            this.f9032b = 0.0f;
            this.f9033c = 1.0f;
            this.f9034d = -1;
            this.f9035e = -1.0f;
            this.f9038h = 16777215;
            this.f9039i = 16777215;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int A() {
            return this.f9039i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void B(int alignSelf) {
            this.f9034d = alignSelf;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void e(int order) {
            throw new UnsupportedOperationException("Setting the order in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to reorder using the attribute.");
        }

        @Override // com.google.android.flexbox.FlexItem
        public int g() {
            return this.f9034d;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return 1;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float h() {
            return this.f9033c;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void i(int maxWidth) {
            this.f9038h = maxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void j(boolean wrapBefore) {
            this.f9040j = wrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int k() {
            return this.f9036f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void l(int maxHeight) {
            this.f9039i = maxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int m() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void n(int minHeight) {
            this.f9037g = minHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float o() {
            return this.f9032b;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float p() {
            return this.f9035e;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean q() {
            return this.f9040j;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int r() {
            return this.f9038h;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void s(float flexGrow) {
            this.f9032b = flexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setHeight(int height) {
            ((ViewGroup.MarginLayoutParams) this).height = height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWidth(int width) {
            ((ViewGroup.MarginLayoutParams) this).width = width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void t(float flexBasisPercent) {
            this.f9035e = flexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void u(float flexShrink) {
            this.f9033c = flexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void v(int minWidth) {
            this.f9036f = minWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int w() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeFloat(this.f9032b);
            parcel.writeFloat(this.f9033c);
            parcel.writeInt(this.f9034d);
            parcel.writeFloat(this.f9035e);
            parcel.writeInt(this.f9036f);
            parcel.writeInt(this.f9037g);
            parcel.writeInt(this.f9038h);
            parcel.writeInt(this.f9039i);
            parcel.writeByte(this.f9040j ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.google.android.flexbox.FlexItem
        public int x() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int y() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int z() {
            return this.f9037g;
        }

        public LayoutParams(int width, int height) {
            super(width, height);
            this.f9032b = 0.0f;
            this.f9033c = 1.0f;
            this.f9034d = -1;
            this.f9035e = -1.0f;
            this.f9038h = 16777215;
            this.f9039i = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
            this.f9032b = 0.0f;
            this.f9033c = 1.0f;
            this.f9034d = -1;
            this.f9035e = -1.0f;
            this.f9038h = 16777215;
            this.f9039i = 16777215;
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            this.f9032b = 0.0f;
            this.f9033c = 1.0f;
            this.f9034d = -1;
            this.f9035e = -1.0f;
            this.f9038h = 16777215;
            this.f9039i = 16777215;
        }

        public LayoutParams(RecyclerView.LayoutParams source) {
            super(source);
            this.f9032b = 0.0f;
            this.f9033c = 1.0f;
            this.f9034d = -1;
            this.f9035e = -1.0f;
            this.f9038h = 16777215;
            this.f9039i = 16777215;
        }

        public LayoutParams(LayoutParams source) {
            super((RecyclerView.LayoutParams) source);
            this.f9032b = 0.0f;
            this.f9033c = 1.0f;
            this.f9034d = -1;
            this.f9035e = -1.0f;
            this.f9038h = 16777215;
            this.f9039i = 16777215;
            this.f9032b = source.f9032b;
            this.f9033c = source.f9033c;
            this.f9034d = source.f9034d;
            this.f9035e = source.f9035e;
            this.f9036f = source.f9036f;
            this.f9037g = source.f9037g;
            this.f9038h = source.f9038h;
            this.f9039i = source.f9039i;
            this.f9040j = source.f9040j;
        }

        public LayoutParams(Parcel in) {
            super(-2, -2);
            this.f9032b = 0.0f;
            this.f9033c = 1.0f;
            this.f9034d = -1;
            this.f9035e = -1.0f;
            this.f9038h = 16777215;
            this.f9039i = 16777215;
            this.f9032b = in.readFloat();
            this.f9033c = in.readFloat();
            this.f9034d = in.readInt();
            this.f9035e = in.readFloat();
            this.f9036f = in.readInt();
            this.f9037g = in.readInt();
            this.f9038h = in.readInt();
            this.f9039i = in.readInt();
            this.f9040j = in.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = in.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = in.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = in.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = in.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = in.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = in.readInt();
        }
    }

    public FlexboxLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.f9011f = -1;
        this.f9014i = new ArrayList();
        this.f9015j = new com.google.android.flexbox.b(this);
        this.f9019n = new b();
        this.f9023r = -1;
        this.f9024s = Integer.MIN_VALUE;
        this.f9025t = Integer.MIN_VALUE;
        this.f9026u = Integer.MIN_VALUE;
        this.f9028w = new SparseArray<>();
        this.f9031z = -1;
        this.A = new b.C0255b();
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attrs, defStyleAttr, defStyleRes);
        int i10 = properties.orientation;
        if (i10 != 0) {
            if (i10 == 1) {
                if (properties.reverseLayout) {
                    setFlexDirection(3);
                } else {
                    setFlexDirection(2);
                }
            }
        } else if (properties.reverseLayout) {
            setFlexDirection(1);
        } else {
            setFlexDirection(0);
        }
        setFlexWrap(1);
        setAlignItems(4);
        this.f9029x = context;
    }
}
