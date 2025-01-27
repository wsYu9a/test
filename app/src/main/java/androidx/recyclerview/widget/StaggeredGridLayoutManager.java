package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {

    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    /* renamed from: a */
    private static final String f3482a = "StaggeredGridLManager";

    /* renamed from: b */
    static final boolean f3483b = false;

    /* renamed from: c */
    static final int f3484c = Integer.MIN_VALUE;

    /* renamed from: d */
    private static final float f3485d = 0.33333334f;
    private int[] A;

    /* renamed from: f */
    Span[] f3487f;

    /* renamed from: g */
    @NonNull
    OrientationHelper f3488g;

    /* renamed from: h */
    @NonNull
    OrientationHelper f3489h;

    /* renamed from: i */
    private int f3490i;

    /* renamed from: j */
    private int f3491j;

    @NonNull
    private final LayoutState k;
    private BitSet n;
    private boolean s;
    private boolean t;
    private SavedState u;
    private int v;

    /* renamed from: e */
    private int f3486e = -1;
    boolean l = false;
    boolean m = false;
    int o = -1;
    int p = Integer.MIN_VALUE;
    LazySpanLookup q = new LazySpanLookup();
    private int r = 2;
    private final Rect w = new Rect();
    private final AnchorInfo x = new AnchorInfo();
    private boolean y = false;
    private boolean z = true;
    private final Runnable B = new Runnable() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.g();
        }
    };

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.g();
        }
    }

    class AnchorInfo {

        /* renamed from: a */
        int f3493a;

        /* renamed from: b */
        int f3494b;

        /* renamed from: c */
        boolean f3495c;

        /* renamed from: d */
        boolean f3496d;

        /* renamed from: e */
        boolean f3497e;

        /* renamed from: f */
        int[] f3498f;

        AnchorInfo() {
            c();
        }

        void a() {
            this.f3494b = this.f3495c ? StaggeredGridLayoutManager.this.f3488g.getEndAfterPadding() : StaggeredGridLayoutManager.this.f3488g.getStartAfterPadding();
        }

        void b(int i2) {
            if (this.f3495c) {
                this.f3494b = StaggeredGridLayoutManager.this.f3488g.getEndAfterPadding() - i2;
            } else {
                this.f3494b = StaggeredGridLayoutManager.this.f3488g.getStartAfterPadding() + i2;
            }
        }

        void c() {
            this.f3493a = -1;
            this.f3494b = Integer.MIN_VALUE;
            this.f3495c = false;
            this.f3496d = false;
            this.f3497e = false;
            int[] iArr = this.f3498f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void d(Span[] spanArr) {
            int length = spanArr.length;
            int[] iArr = this.f3498f;
            if (iArr == null || iArr.length < length) {
                this.f3498f = new int[StaggeredGridLayoutManager.this.f3487f.length];
            }
            for (int i2 = 0; i2 < length; i2++) {
                this.f3498f[i2] = spanArr[i2].m(Integer.MIN_VALUE);
            }
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;

        /* renamed from: e */
        Span f3500e;

        /* renamed from: f */
        boolean f3501f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int getSpanIndex() {
            Span span = this.f3500e;
            if (span == null) {
                return -1;
            }
            return span.f3524f;
        }

        public boolean isFullSpan() {
            return this.f3501f;
        }

        public void setFullSpan(boolean z) {
            this.f3501f = z;
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState.1
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: a */
        int f3509a;

        /* renamed from: b */
        int f3510b;

        /* renamed from: c */
        int f3511c;

        /* renamed from: d */
        int[] f3512d;

        /* renamed from: e */
        int f3513e;

        /* renamed from: f */
        int[] f3514f;

        /* renamed from: g */
        List<LazySpanLookup.FullSpanItem> f3515g;

        /* renamed from: h */
        boolean f3516h;

        /* renamed from: i */
        boolean f3517i;

        /* renamed from: j */
        boolean f3518j;

        /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState$1 */
        static class AnonymousClass1 implements Parcelable.Creator<SavedState> {
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState() {
        }

        void a() {
            this.f3512d = null;
            this.f3511c = 0;
            this.f3509a = -1;
            this.f3510b = -1;
        }

        void b() {
            this.f3512d = null;
            this.f3511c = 0;
            this.f3513e = 0;
            this.f3514f = null;
            this.f3515g = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f3509a);
            parcel.writeInt(this.f3510b);
            parcel.writeInt(this.f3511c);
            if (this.f3511c > 0) {
                parcel.writeIntArray(this.f3512d);
            }
            parcel.writeInt(this.f3513e);
            if (this.f3513e > 0) {
                parcel.writeIntArray(this.f3514f);
            }
            parcel.writeInt(this.f3516h ? 1 : 0);
            parcel.writeInt(this.f3517i ? 1 : 0);
            parcel.writeInt(this.f3518j ? 1 : 0);
            parcel.writeList(this.f3515g);
        }

        SavedState(Parcel parcel) {
            this.f3509a = parcel.readInt();
            this.f3510b = parcel.readInt();
            int readInt = parcel.readInt();
            this.f3511c = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f3512d = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f3513e = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f3514f = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f3516h = parcel.readInt() == 1;
            this.f3517i = parcel.readInt() == 1;
            this.f3518j = parcel.readInt() == 1;
            this.f3515g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f3511c = savedState.f3511c;
            this.f3509a = savedState.f3509a;
            this.f3510b = savedState.f3510b;
            this.f3512d = savedState.f3512d;
            this.f3513e = savedState.f3513e;
            this.f3514f = savedState.f3514f;
            this.f3516h = savedState.f3516h;
            this.f3517i = savedState.f3517i;
            this.f3518j = savedState.f3518j;
            this.f3515g = savedState.f3515g;
        }
    }

    class Span {

        /* renamed from: a */
        static final int f3519a = Integer.MIN_VALUE;

        /* renamed from: b */
        ArrayList<View> f3520b = new ArrayList<>();

        /* renamed from: c */
        int f3521c = Integer.MIN_VALUE;

        /* renamed from: d */
        int f3522d = Integer.MIN_VALUE;

        /* renamed from: e */
        int f3523e = 0;

        /* renamed from: f */
        final int f3524f;

        Span(int i2) {
            this.f3524f = i2;
        }

        void a(View view) {
            LayoutParams k = k(view);
            k.f3500e = this;
            this.f3520b.add(view);
            this.f3522d = Integer.MIN_VALUE;
            if (this.f3520b.size() == 1) {
                this.f3521c = Integer.MIN_VALUE;
            }
            if (k.isItemRemoved() || k.isItemChanged()) {
                this.f3523e += StaggeredGridLayoutManager.this.f3488g.getDecoratedMeasurement(view);
            }
        }

        void b(boolean z, int i2) {
            int j2 = z ? j(Integer.MIN_VALUE) : m(Integer.MIN_VALUE);
            e();
            if (j2 == Integer.MIN_VALUE) {
                return;
            }
            if (!z || j2 >= StaggeredGridLayoutManager.this.f3488g.getEndAfterPadding()) {
                if (z || j2 <= StaggeredGridLayoutManager.this.f3488g.getStartAfterPadding()) {
                    if (i2 != Integer.MIN_VALUE) {
                        j2 += i2;
                    }
                    this.f3522d = j2;
                    this.f3521c = j2;
                }
            }
        }

        void c() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            ArrayList<View> arrayList = this.f3520b;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams k = k(view);
            this.f3522d = StaggeredGridLayoutManager.this.f3488g.getDecoratedEnd(view);
            if (k.f3501f && (fullSpanItem = StaggeredGridLayoutManager.this.q.getFullSpanItem(k.getViewLayoutPosition())) != null && fullSpanItem.f3506b == 1) {
                this.f3522d += fullSpanItem.a(this.f3524f);
            }
        }

        void d() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            View view = this.f3520b.get(0);
            LayoutParams k = k(view);
            this.f3521c = StaggeredGridLayoutManager.this.f3488g.getDecoratedStart(view);
            if (k.f3501f && (fullSpanItem = StaggeredGridLayoutManager.this.q.getFullSpanItem(k.getViewLayoutPosition())) != null && fullSpanItem.f3506b == -1) {
                this.f3521c -= fullSpanItem.a(this.f3524f);
            }
        }

        void e() {
            this.f3520b.clear();
            n();
            this.f3523e = 0;
        }

        int f(int i2, int i3, boolean z, boolean z2, boolean z3) {
            int startAfterPadding = StaggeredGridLayoutManager.this.f3488g.getStartAfterPadding();
            int endAfterPadding = StaggeredGridLayoutManager.this.f3488g.getEndAfterPadding();
            int i4 = i3 > i2 ? 1 : -1;
            while (i2 != i3) {
                View view = this.f3520b.get(i2);
                int decoratedStart = StaggeredGridLayoutManager.this.f3488g.getDecoratedStart(view);
                int decoratedEnd = StaggeredGridLayoutManager.this.f3488g.getDecoratedEnd(view);
                boolean z4 = false;
                boolean z5 = !z3 ? decoratedStart >= endAfterPadding : decoratedStart > endAfterPadding;
                if (!z3 ? decoratedEnd > startAfterPadding : decoratedEnd >= startAfterPadding) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (decoratedStart < startAfterPadding || decoratedEnd > endAfterPadding) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    }
                }
                i2 += i4;
            }
            return -1;
        }

        public int findFirstCompletelyVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.l ? h(this.f3520b.size() - 1, -1, true) : h(0, this.f3520b.size(), true);
        }

        public int findFirstPartiallyVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.l ? g(this.f3520b.size() - 1, -1, true) : g(0, this.f3520b.size(), true);
        }

        public int findFirstVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.l ? h(this.f3520b.size() - 1, -1, false) : h(0, this.f3520b.size(), false);
        }

        public int findLastCompletelyVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.l ? h(0, this.f3520b.size(), true) : h(this.f3520b.size() - 1, -1, true);
        }

        public int findLastPartiallyVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.l ? g(0, this.f3520b.size(), true) : g(this.f3520b.size() - 1, -1, true);
        }

        public int findLastVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.l ? h(0, this.f3520b.size(), false) : h(this.f3520b.size() - 1, -1, false);
        }

        int g(int i2, int i3, boolean z) {
            return f(i2, i3, false, false, z);
        }

        public int getDeletedSize() {
            return this.f3523e;
        }

        public View getFocusableViewAfter(int i2, int i3) {
            View view = null;
            if (i3 != -1) {
                int size = this.f3520b.size() - 1;
                while (size >= 0) {
                    View view2 = this.f3520b.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.l && staggeredGridLayoutManager.getPosition(view2) >= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.l && staggeredGridLayoutManager2.getPosition(view2) <= i2) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f3520b.size();
                int i4 = 0;
                while (i4 < size2) {
                    View view3 = this.f3520b.get(i4);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.l && staggeredGridLayoutManager3.getPosition(view3) <= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.l && staggeredGridLayoutManager4.getPosition(view3) >= i2) || !view3.hasFocusable()) {
                        break;
                    }
                    i4++;
                    view = view3;
                }
            }
            return view;
        }

        int h(int i2, int i3, boolean z) {
            return f(i2, i3, z, true, false);
        }

        int i() {
            int i2 = this.f3522d;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            c();
            return this.f3522d;
        }

        int j(int i2) {
            int i3 = this.f3522d;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.f3520b.size() == 0) {
                return i2;
            }
            c();
            return this.f3522d;
        }

        LayoutParams k(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        int l() {
            int i2 = this.f3521c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            d();
            return this.f3521c;
        }

        int m(int i2) {
            int i3 = this.f3521c;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.f3520b.size() == 0) {
                return i2;
            }
            d();
            return this.f3521c;
        }

        void n() {
            this.f3521c = Integer.MIN_VALUE;
            this.f3522d = Integer.MIN_VALUE;
        }

        void o(int i2) {
            int i3 = this.f3521c;
            if (i3 != Integer.MIN_VALUE) {
                this.f3521c = i3 + i2;
            }
            int i4 = this.f3522d;
            if (i4 != Integer.MIN_VALUE) {
                this.f3522d = i4 + i2;
            }
        }

        void p() {
            int size = this.f3520b.size();
            View remove = this.f3520b.remove(size - 1);
            LayoutParams k = k(remove);
            k.f3500e = null;
            if (k.isItemRemoved() || k.isItemChanged()) {
                this.f3523e -= StaggeredGridLayoutManager.this.f3488g.getDecoratedMeasurement(remove);
            }
            if (size == 1) {
                this.f3521c = Integer.MIN_VALUE;
            }
            this.f3522d = Integer.MIN_VALUE;
        }

        void q() {
            View remove = this.f3520b.remove(0);
            LayoutParams k = k(remove);
            k.f3500e = null;
            if (this.f3520b.size() == 0) {
                this.f3522d = Integer.MIN_VALUE;
            }
            if (k.isItemRemoved() || k.isItemChanged()) {
                this.f3523e -= StaggeredGridLayoutManager.this.f3488g.getDecoratedMeasurement(remove);
            }
            this.f3521c = Integer.MIN_VALUE;
        }

        void r(View view) {
            LayoutParams k = k(view);
            k.f3500e = this;
            this.f3520b.add(0, view);
            this.f3521c = Integer.MIN_VALUE;
            if (this.f3520b.size() == 1) {
                this.f3522d = Integer.MIN_VALUE;
            }
            if (k.isItemRemoved() || k.isItemChanged()) {
                this.f3523e += StaggeredGridLayoutManager.this.f3488g.getDecoratedMeasurement(view);
            }
        }

        void s(int i2) {
            this.f3521c = i2;
            this.f3522d = i2;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i2, i3);
        setOrientation(properties.orientation);
        setSpanCount(properties.spanCount);
        setReverseLayout(properties.reverseLayout);
        this.k = new LayoutState();
        k();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.m
            if (r0 == 0) goto L9
            int r0 = r6.u()
            goto Ld
        L9:
            int r0 = r6.t()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1a
            if (r7 >= r8) goto L16
            int r2 = r8 + 1
            goto L1c
        L16:
            int r2 = r7 + 1
            r3 = r8
            goto L1d
        L1a:
            int r2 = r7 + r8
        L1c:
            r3 = r7
        L1d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.q
            r4.e(r3)
            r4 = 1
            if (r9 == r4) goto L3c
            r5 = 2
            if (r9 == r5) goto L36
            if (r9 == r1) goto L2b
            goto L41
        L2b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.q
            r9.h(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.q
            r7.g(r8, r4)
            goto L41
        L36:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.q
            r9.h(r7, r8)
            goto L41
        L3c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.q
            r9.g(r7, r8)
        L41:
            if (r2 > r0) goto L44
            return
        L44:
            boolean r7 = r6.m
            if (r7 == 0) goto L4d
            int r7 = r6.t()
            goto L51
        L4d:
            int r7 = r6.u()
        L51:
            if (r3 > r7) goto L56
            r6.requestLayout()
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.A(int, int, int):void");
    }

    private void C(View view, int i2, int i3, boolean z) {
        calculateItemDecorationsForChild(view, this.w);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        Rect rect = this.w;
        int U = U(i2, i4 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        Rect rect2 = this.w;
        int U2 = U(i3, i5 + rect2.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect2.bottom);
        if (z ? shouldReMeasureChild(view, U, U2, layoutParams) : shouldMeasureChild(view, U, U2, layoutParams)) {
            view.measure(U, U2);
        }
    }

    private void D(View view, LayoutParams layoutParams, boolean z) {
        if (layoutParams.f3501f) {
            if (this.f3490i == 1) {
                C(view, this.v, RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z);
                return;
            } else {
                C(view, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), this.v, z);
                return;
            }
        }
        if (this.f3490i == 1) {
            C(view, RecyclerView.LayoutManager.getChildMeasureSpec(this.f3491j, getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).width, false), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z);
        } else {
            C(view, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), RecyclerView.LayoutManager.getChildMeasureSpec(this.f3491j, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).height, false), z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0157, code lost:
    
        if (g() != false) goto L193;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void E(androidx.recyclerview.widget.RecyclerView.Recycler r9, androidx.recyclerview.widget.RecyclerView.State r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.E(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, boolean):void");
    }

    private boolean F(int i2) {
        if (this.f3490i == 0) {
            return (i2 == -1) != this.m;
        }
        return ((i2 == -1) == this.m) == isLayoutRTL();
    }

    private void H(View view) {
        for (int i2 = this.f3486e - 1; i2 >= 0; i2--) {
            this.f3487f[i2].r(view);
        }
    }

    private void I(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (!layoutState.f3336f || layoutState.n) {
            return;
        }
        if (layoutState.f3337g == 0) {
            if (layoutState.f3340j == -1) {
                J(recycler, layoutState.l);
                return;
            } else {
                K(recycler, layoutState.k);
                return;
            }
        }
        if (layoutState.f3340j != -1) {
            int x = x(layoutState.l) - layoutState.l;
            K(recycler, x < 0 ? layoutState.k : Math.min(x, layoutState.f3337g) + layoutState.k);
        } else {
            int i2 = layoutState.k;
            int w = i2 - w(i2);
            J(recycler, w < 0 ? layoutState.l : layoutState.l - Math.min(w, layoutState.f3337g));
        }
    }

    private void J(RecyclerView.Recycler recycler, int i2) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.f3488g.getDecoratedStart(childAt) < i2 || this.f3488g.getTransformedStartWithDecoration(childAt) < i2) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.f3501f) {
                for (int i3 = 0; i3 < this.f3486e; i3++) {
                    if (this.f3487f[i3].f3520b.size() == 1) {
                        return;
                    }
                }
                for (int i4 = 0; i4 < this.f3486e; i4++) {
                    this.f3487f[i4].p();
                }
            } else if (layoutParams.f3500e.f3520b.size() == 1) {
                return;
            } else {
                layoutParams.f3500e.p();
            }
            removeAndRecycleView(childAt, recycler);
        }
    }

    private void K(RecyclerView.Recycler recycler, int i2) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f3488g.getDecoratedEnd(childAt) > i2 || this.f3488g.getTransformedEndWithDecoration(childAt) > i2) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.f3501f) {
                for (int i3 = 0; i3 < this.f3486e; i3++) {
                    if (this.f3487f[i3].f3520b.size() == 1) {
                        return;
                    }
                }
                for (int i4 = 0; i4 < this.f3486e; i4++) {
                    this.f3487f[i4].q();
                }
            } else if (layoutParams.f3500e.f3520b.size() == 1) {
                return;
            } else {
                layoutParams.f3500e.q();
            }
            removeAndRecycleView(childAt, recycler);
        }
    }

    private void L() {
        if (this.f3489h.getMode() == 1073741824) {
            return;
        }
        float f2 = 0.0f;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            float decoratedMeasurement = this.f3489h.getDecoratedMeasurement(childAt);
            if (decoratedMeasurement >= f2) {
                if (((LayoutParams) childAt.getLayoutParams()).isFullSpan()) {
                    decoratedMeasurement = (decoratedMeasurement * 1.0f) / this.f3486e;
                }
                f2 = Math.max(f2, decoratedMeasurement);
            }
        }
        int i3 = this.f3491j;
        int round = Math.round(f2 * this.f3486e);
        if (this.f3489h.getMode() == Integer.MIN_VALUE) {
            round = Math.min(round, this.f3489h.getTotalSpace());
        }
        S(round);
        if (this.f3491j == i3) {
            return;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt2 = getChildAt(i4);
            LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (!layoutParams.f3501f) {
                if (isLayoutRTL() && this.f3490i == 1) {
                    int i5 = this.f3486e;
                    int i6 = layoutParams.f3500e.f3524f;
                    childAt2.offsetLeftAndRight(((-((i5 - 1) - i6)) * this.f3491j) - ((-((i5 - 1) - i6)) * i3));
                } else {
                    int i7 = layoutParams.f3500e.f3524f;
                    int i8 = this.f3491j * i7;
                    int i9 = i7 * i3;
                    if (this.f3490i == 1) {
                        childAt2.offsetLeftAndRight(i8 - i9);
                    } else {
                        childAt2.offsetTopAndBottom(i8 - i9);
                    }
                }
            }
        }
    }

    private void M(int i2) {
        LayoutState layoutState = this.k;
        layoutState.f3340j = i2;
        layoutState.f3339i = this.m != (i2 == -1) ? -1 : 1;
    }

    private void N(int i2, int i3) {
        for (int i4 = 0; i4 < this.f3486e; i4++) {
            if (!this.f3487f[i4].f3520b.isEmpty()) {
                T(this.f3487f[i4], i2, i3);
            }
        }
    }

    private boolean O(RecyclerView.State state, AnchorInfo anchorInfo) {
        anchorInfo.f3493a = this.s ? q(state.getItemCount()) : m(state.getItemCount());
        anchorInfo.f3494b = Integer.MIN_VALUE;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void R(int r5, androidx.recyclerview.widget.RecyclerView.State r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.LayoutState r0 = r4.k
            r1 = 0
            r0.f3337g = r1
            r0.f3338h = r5
            boolean r0 = r4.isSmoothScrolling()
            r2 = 1
            if (r0 == 0) goto L2e
            int r6 = r6.getTargetScrollPosition()
            r0 = -1
            if (r6 == r0) goto L2e
            boolean r0 = r4.m
            if (r6 >= r5) goto L1b
            r5 = 1
            goto L1c
        L1b:
            r5 = 0
        L1c:
            if (r0 != r5) goto L25
            androidx.recyclerview.widget.OrientationHelper r5 = r4.f3488g
            int r5 = r5.getTotalSpace()
            goto L2f
        L25:
            androidx.recyclerview.widget.OrientationHelper r5 = r4.f3488g
            int r5 = r5.getTotalSpace()
            r6 = r5
            r5 = 0
            goto L30
        L2e:
            r5 = 0
        L2f:
            r6 = 0
        L30:
            boolean r0 = r4.getClipToPadding()
            if (r0 == 0) goto L4d
            androidx.recyclerview.widget.LayoutState r0 = r4.k
            androidx.recyclerview.widget.OrientationHelper r3 = r4.f3488g
            int r3 = r3.getStartAfterPadding()
            int r3 = r3 - r6
            r0.k = r3
            androidx.recyclerview.widget.LayoutState r6 = r4.k
            androidx.recyclerview.widget.OrientationHelper r0 = r4.f3488g
            int r0 = r0.getEndAfterPadding()
            int r0 = r0 + r5
            r6.l = r0
            goto L5d
        L4d:
            androidx.recyclerview.widget.LayoutState r0 = r4.k
            androidx.recyclerview.widget.OrientationHelper r3 = r4.f3488g
            int r3 = r3.getEnd()
            int r3 = r3 + r5
            r0.l = r3
            androidx.recyclerview.widget.LayoutState r5 = r4.k
            int r6 = -r6
            r5.k = r6
        L5d:
            androidx.recyclerview.widget.LayoutState r5 = r4.k
            r5.m = r1
            r5.f3336f = r2
            androidx.recyclerview.widget.OrientationHelper r6 = r4.f3488g
            int r6 = r6.getMode()
            if (r6 != 0) goto L74
            androidx.recyclerview.widget.OrientationHelper r6 = r4.f3488g
            int r6 = r6.getEnd()
            if (r6 != 0) goto L74
            r1 = 1
        L74:
            r5.n = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.R(int, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    private void T(Span span, int i2, int i3) {
        int deletedSize = span.getDeletedSize();
        if (i2 == -1) {
            if (span.l() + deletedSize <= i3) {
                this.n.set(span.f3524f, false);
            }
        } else if (span.i() - deletedSize >= i3) {
            this.n.set(span.f3524f, false);
        }
    }

    private int U(int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0) {
            return i2;
        }
        int mode = View.MeasureSpec.getMode(i2);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - i3) - i4), mode) : i2;
    }

    private void a(View view) {
        for (int i2 = this.f3486e - 1; i2 >= 0; i2--) {
            this.f3487f[i2].a(view);
        }
    }

    private void b(AnchorInfo anchorInfo) {
        SavedState savedState = this.u;
        int i2 = savedState.f3511c;
        if (i2 > 0) {
            if (i2 == this.f3486e) {
                for (int i3 = 0; i3 < this.f3486e; i3++) {
                    this.f3487f[i3].e();
                    SavedState savedState2 = this.u;
                    int i4 = savedState2.f3512d[i3];
                    if (i4 != Integer.MIN_VALUE) {
                        i4 += savedState2.f3517i ? this.f3488g.getEndAfterPadding() : this.f3488g.getStartAfterPadding();
                    }
                    this.f3487f[i3].s(i4);
                }
            } else {
                savedState.b();
                SavedState savedState3 = this.u;
                savedState3.f3509a = savedState3.f3510b;
            }
        }
        SavedState savedState4 = this.u;
        this.t = savedState4.f3518j;
        setReverseLayout(savedState4.f3516h);
        resolveShouldLayoutReverse();
        SavedState savedState5 = this.u;
        int i5 = savedState5.f3509a;
        if (i5 != -1) {
            this.o = i5;
            anchorInfo.f3495c = savedState5.f3517i;
        } else {
            anchorInfo.f3495c = this.m;
        }
        if (savedState5.f3513e > 1) {
            LazySpanLookup lazySpanLookup = this.q;
            lazySpanLookup.f3503b = savedState5.f3514f;
            lazySpanLookup.f3504c = savedState5.f3515g;
        }
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.a(state, this.f3488g, o(!this.z), n(!this.z), this, this.z);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.b(state, this.f3488g, o(!this.z), n(!this.z), this, this.z, this.m);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.c(state, this.f3488g, o(!this.z), n(!this.z), this, this.z);
    }

    private int convertFocusDirectionToLayoutDirection(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 17 ? i2 != 33 ? i2 != 66 ? (i2 == 130 && this.f3490i == 1) ? 1 : Integer.MIN_VALUE : this.f3490i == 0 ? 1 : Integer.MIN_VALUE : this.f3490i == 1 ? -1 : Integer.MIN_VALUE : this.f3490i == 0 ? -1 : Integer.MIN_VALUE : (this.f3490i != 1 && isLayoutRTL()) ? -1 : 1 : (this.f3490i != 1 && isLayoutRTL()) ? 1 : -1;
    }

    private void e(View view, LayoutParams layoutParams, LayoutState layoutState) {
        if (layoutState.f3340j == 1) {
            if (layoutParams.f3501f) {
                a(view);
                return;
            } else {
                layoutParams.f3500e.a(view);
                return;
            }
        }
        if (layoutParams.f3501f) {
            H(view);
        } else {
            layoutParams.f3500e.r(view);
        }
    }

    private int f(int i2) {
        if (getChildCount() == 0) {
            return this.m ? 1 : -1;
        }
        return (i2 < t()) != this.m ? -1 : 1;
    }

    private boolean h(Span span) {
        if (this.m) {
            if (span.i() < this.f3488g.getEndAfterPadding()) {
                ArrayList<View> arrayList = span.f3520b;
                return !span.k(arrayList.get(arrayList.size() - 1)).f3501f;
            }
        } else if (span.l() > this.f3488g.getStartAfterPadding()) {
            return !span.k(span.f3520b.get(0)).f3501f;
        }
        return false;
    }

    private LazySpanLookup.FullSpanItem i(int i2) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f3507c = new int[this.f3486e];
        for (int i3 = 0; i3 < this.f3486e; i3++) {
            fullSpanItem.f3507c[i3] = i2 - this.f3487f[i3].j(i2);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem j(int i2) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f3507c = new int[this.f3486e];
        for (int i3 = 0; i3 < this.f3486e; i3++) {
            fullSpanItem.f3507c[i3] = this.f3487f[i3].m(i2) - i2;
        }
        return fullSpanItem;
    }

    private void k() {
        this.f3488g = OrientationHelper.createOrientationHelper(this, this.f3490i);
        this.f3489h = OrientationHelper.createOrientationHelper(this, 1 - this.f3490i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int l(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        int i2;
        Span span;
        int decoratedMeasurement;
        int i3;
        int i4;
        int decoratedMeasurement2;
        ?? r9 = 0;
        this.n.set(0, this.f3486e, true);
        if (this.k.n) {
            i2 = layoutState.f3340j == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            i2 = layoutState.f3340j == 1 ? layoutState.l + layoutState.f3337g : layoutState.k - layoutState.f3337g;
        }
        N(layoutState.f3340j, i2);
        int endAfterPadding = this.m ? this.f3488g.getEndAfterPadding() : this.f3488g.getStartAfterPadding();
        boolean z = false;
        while (layoutState.a(state) && (this.k.n || !this.n.isEmpty())) {
            View b2 = layoutState.b(recycler);
            LayoutParams layoutParams = (LayoutParams) b2.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            int d2 = this.q.d(viewLayoutPosition);
            boolean z2 = d2 == -1;
            if (z2) {
                span = layoutParams.f3501f ? this.f3487f[r9] : z(layoutState);
                this.q.k(viewLayoutPosition, span);
            } else {
                span = this.f3487f[d2];
            }
            Span span2 = span;
            layoutParams.f3500e = span2;
            if (layoutState.f3340j == 1) {
                addView(b2);
            } else {
                addView(b2, r9);
            }
            D(b2, layoutParams, r9);
            if (layoutState.f3340j == 1) {
                int v = layoutParams.f3501f ? v(endAfterPadding) : span2.j(endAfterPadding);
                int decoratedMeasurement3 = this.f3488g.getDecoratedMeasurement(b2) + v;
                if (z2 && layoutParams.f3501f) {
                    LazySpanLookup.FullSpanItem i5 = i(v);
                    i5.f3506b = -1;
                    i5.f3505a = viewLayoutPosition;
                    this.q.addFullSpanItem(i5);
                }
                i3 = decoratedMeasurement3;
                decoratedMeasurement = v;
            } else {
                int y = layoutParams.f3501f ? y(endAfterPadding) : span2.m(endAfterPadding);
                decoratedMeasurement = y - this.f3488g.getDecoratedMeasurement(b2);
                if (z2 && layoutParams.f3501f) {
                    LazySpanLookup.FullSpanItem j2 = j(y);
                    j2.f3506b = 1;
                    j2.f3505a = viewLayoutPosition;
                    this.q.addFullSpanItem(j2);
                }
                i3 = y;
            }
            if (layoutParams.f3501f && layoutState.f3339i == -1) {
                if (z2) {
                    this.y = true;
                } else {
                    if (!(layoutState.f3340j == 1 ? c() : d())) {
                        LazySpanLookup.FullSpanItem fullSpanItem = this.q.getFullSpanItem(viewLayoutPosition);
                        if (fullSpanItem != null) {
                            fullSpanItem.f3508d = true;
                        }
                        this.y = true;
                    }
                }
            }
            e(b2, layoutParams, layoutState);
            if (isLayoutRTL() && this.f3490i == 1) {
                int endAfterPadding2 = layoutParams.f3501f ? this.f3489h.getEndAfterPadding() : this.f3489h.getEndAfterPadding() - (((this.f3486e - 1) - span2.f3524f) * this.f3491j);
                decoratedMeasurement2 = endAfterPadding2;
                i4 = endAfterPadding2 - this.f3489h.getDecoratedMeasurement(b2);
            } else {
                int startAfterPadding = layoutParams.f3501f ? this.f3489h.getStartAfterPadding() : (span2.f3524f * this.f3491j) + this.f3489h.getStartAfterPadding();
                i4 = startAfterPadding;
                decoratedMeasurement2 = this.f3489h.getDecoratedMeasurement(b2) + startAfterPadding;
            }
            if (this.f3490i == 1) {
                layoutDecoratedWithMargins(b2, i4, decoratedMeasurement, decoratedMeasurement2, i3);
            } else {
                layoutDecoratedWithMargins(b2, decoratedMeasurement, i4, i3, decoratedMeasurement2);
            }
            if (layoutParams.f3501f) {
                N(this.k.f3340j, i2);
            } else {
                T(span2, this.k.f3340j, i2);
            }
            I(recycler, this.k);
            if (this.k.m && b2.hasFocusable()) {
                if (layoutParams.f3501f) {
                    this.n.clear();
                } else {
                    this.n.set(span2.f3524f, false);
                    z = true;
                    r9 = 0;
                }
            }
            z = true;
            r9 = 0;
        }
        if (!z) {
            I(recycler, this.k);
        }
        int startAfterPadding2 = this.k.f3340j == -1 ? this.f3488g.getStartAfterPadding() - y(this.f3488g.getStartAfterPadding()) : v(this.f3488g.getEndAfterPadding()) - this.f3488g.getEndAfterPadding();
        if (startAfterPadding2 > 0) {
            return Math.min(layoutState.f3337g, startAfterPadding2);
        }
        return 0;
    }

    private int m(int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            int position = getPosition(getChildAt(i3));
            if (position >= 0 && position < i2) {
                return position;
            }
        }
        return 0;
    }

    private int q(int i2) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i2) {
                return position;
            }
        }
        return 0;
    }

    private void r(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int endAfterPadding;
        int v = v(Integer.MIN_VALUE);
        if (v != Integer.MIN_VALUE && (endAfterPadding = this.f3488g.getEndAfterPadding() - v) > 0) {
            int i2 = endAfterPadding - (-scrollBy(-endAfterPadding, recycler, state));
            if (!z || i2 <= 0) {
                return;
            }
            this.f3488g.offsetChildren(i2);
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.f3490i == 1 || !isLayoutRTL()) {
            this.m = this.l;
        } else {
            this.m = !this.l;
        }
    }

    private void s(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int startAfterPadding;
        int y = y(Integer.MAX_VALUE);
        if (y != Integer.MAX_VALUE && (startAfterPadding = y - this.f3488g.getStartAfterPadding()) > 0) {
            int scrollBy = startAfterPadding - scrollBy(startAfterPadding, recycler, state);
            if (!z || scrollBy <= 0) {
                return;
            }
            this.f3488g.offsetChildren(-scrollBy);
        }
    }

    private int v(int i2) {
        int j2 = this.f3487f[0].j(i2);
        for (int i3 = 1; i3 < this.f3486e; i3++) {
            int j3 = this.f3487f[i3].j(i2);
            if (j3 > j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    private int w(int i2) {
        int m = this.f3487f[0].m(i2);
        for (int i3 = 1; i3 < this.f3486e; i3++) {
            int m2 = this.f3487f[i3].m(i2);
            if (m2 > m) {
                m = m2;
            }
        }
        return m;
    }

    private int x(int i2) {
        int j2 = this.f3487f[0].j(i2);
        for (int i3 = 1; i3 < this.f3486e; i3++) {
            int j3 = this.f3487f[i3].j(i2);
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    private int y(int i2) {
        int m = this.f3487f[0].m(i2);
        for (int i3 = 1; i3 < this.f3486e; i3++) {
            int m2 = this.f3487f[i3].m(i2);
            if (m2 < m) {
                m = m2;
            }
        }
        return m;
    }

    private Span z(LayoutState layoutState) {
        int i2;
        int i3;
        int i4 = -1;
        if (F(layoutState.f3340j)) {
            i2 = this.f3486e - 1;
            i3 = -1;
        } else {
            i2 = 0;
            i4 = this.f3486e;
            i3 = 1;
        }
        Span span = null;
        if (layoutState.f3340j == 1) {
            int i5 = Integer.MAX_VALUE;
            int startAfterPadding = this.f3488g.getStartAfterPadding();
            while (i2 != i4) {
                Span span2 = this.f3487f[i2];
                int j2 = span2.j(startAfterPadding);
                if (j2 < i5) {
                    span = span2;
                    i5 = j2;
                }
                i2 += i3;
            }
            return span;
        }
        int i6 = Integer.MIN_VALUE;
        int endAfterPadding = this.f3488g.getEndAfterPadding();
        while (i2 != i4) {
            Span span3 = this.f3487f[i2];
            int m = span3.m(endAfterPadding);
            if (m > i6) {
                span = span3;
                i6 = m;
            }
            i2 += i3;
        }
        return span;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        if (r10 == r11) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008a, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0088, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0086, code lost:
    
        if (r10 == r11) goto L99;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    android.view.View B() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f3486e
            r2.<init>(r3)
            int r3 = r12.f3486e
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.f3490i
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.isLayoutRTL()
            if (r3 == 0) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = -1
        L21:
            boolean r6 = r12.m
            if (r6 == 0) goto L27
            r6 = -1
            goto L2b
        L27:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L2b:
            if (r0 >= r6) goto L2e
            r5 = 1
        L2e:
            if (r0 == r6) goto Lab
            android.view.View r7 = r12.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.f3500e
            int r9 = r9.f3524f
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.f3500e
            boolean r9 = r12.h(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.f3500e
            int r9 = r9.f3524f
            r2.clear(r9)
        L54:
            boolean r9 = r8.f3501f
            if (r9 == 0) goto L59
            goto La9
        L59:
            int r9 = r0 + r5
            if (r9 == r6) goto La9
            android.view.View r9 = r12.getChildAt(r9)
            boolean r10 = r12.m
            if (r10 == 0) goto L77
            androidx.recyclerview.widget.OrientationHelper r10 = r12.f3488g
            int r10 = r10.getDecoratedEnd(r7)
            androidx.recyclerview.widget.OrientationHelper r11 = r12.f3488g
            int r11 = r11.getDecoratedEnd(r9)
            if (r10 >= r11) goto L74
            return r7
        L74:
            if (r10 != r11) goto L8a
            goto L88
        L77:
            androidx.recyclerview.widget.OrientationHelper r10 = r12.f3488g
            int r10 = r10.getDecoratedStart(r7)
            androidx.recyclerview.widget.OrientationHelper r11 = r12.f3488g
            int r11 = r11.getDecoratedStart(r9)
            if (r10 <= r11) goto L86
            return r7
        L86:
            if (r10 != r11) goto L8a
        L88:
            r10 = 1
            goto L8b
        L8a:
            r10 = 0
        L8b:
            if (r10 == 0) goto La9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r8 = r8.f3500e
            int r8 = r8.f3524f
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r9.f3500e
            int r9 = r9.f3524f
            int r8 = r8 - r9
            if (r8 >= 0) goto La0
            r8 = 1
            goto La1
        La0:
            r8 = 0
        La1:
            if (r3 >= 0) goto La5
            r9 = 1
            goto La6
        La5:
            r9 = 0
        La6:
            if (r8 == r9) goto La9
            return r7
        La9:
            int r0 = r0 + r5
            goto L2e
        Lab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.B():android.view.View");
    }

    void G(int i2, RecyclerView.State state) {
        int t;
        int i3;
        if (i2 > 0) {
            t = u();
            i3 = 1;
        } else {
            t = t();
            i3 = -1;
        }
        this.k.f3336f = true;
        R(t, state);
        M(i3);
        LayoutState layoutState = this.k;
        layoutState.f3338h = t + layoutState.f3339i;
        layoutState.f3337g = Math.abs(i2);
    }

    boolean P(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i2;
        if (!state.isPreLayout() && (i2 = this.o) != -1) {
            if (i2 >= 0 && i2 < state.getItemCount()) {
                SavedState savedState = this.u;
                if (savedState == null || savedState.f3509a == -1 || savedState.f3511c < 1) {
                    View findViewByPosition = findViewByPosition(this.o);
                    if (findViewByPosition != null) {
                        anchorInfo.f3493a = this.m ? u() : t();
                        if (this.p != Integer.MIN_VALUE) {
                            if (anchorInfo.f3495c) {
                                anchorInfo.f3494b = (this.f3488g.getEndAfterPadding() - this.p) - this.f3488g.getDecoratedEnd(findViewByPosition);
                            } else {
                                anchorInfo.f3494b = (this.f3488g.getStartAfterPadding() + this.p) - this.f3488g.getDecoratedStart(findViewByPosition);
                            }
                            return true;
                        }
                        if (this.f3488g.getDecoratedMeasurement(findViewByPosition) > this.f3488g.getTotalSpace()) {
                            anchorInfo.f3494b = anchorInfo.f3495c ? this.f3488g.getEndAfterPadding() : this.f3488g.getStartAfterPadding();
                            return true;
                        }
                        int decoratedStart = this.f3488g.getDecoratedStart(findViewByPosition) - this.f3488g.getStartAfterPadding();
                        if (decoratedStart < 0) {
                            anchorInfo.f3494b = -decoratedStart;
                            return true;
                        }
                        int endAfterPadding = this.f3488g.getEndAfterPadding() - this.f3488g.getDecoratedEnd(findViewByPosition);
                        if (endAfterPadding < 0) {
                            anchorInfo.f3494b = endAfterPadding;
                            return true;
                        }
                        anchorInfo.f3494b = Integer.MIN_VALUE;
                    } else {
                        int i3 = this.o;
                        anchorInfo.f3493a = i3;
                        int i4 = this.p;
                        if (i4 == Integer.MIN_VALUE) {
                            anchorInfo.f3495c = f(i3) == 1;
                            anchorInfo.a();
                        } else {
                            anchorInfo.b(i4);
                        }
                        anchorInfo.f3496d = true;
                    }
                } else {
                    anchorInfo.f3494b = Integer.MIN_VALUE;
                    anchorInfo.f3493a = this.o;
                }
                return true;
            }
            this.o = -1;
            this.p = Integer.MIN_VALUE;
        }
        return false;
    }

    void Q(RecyclerView.State state, AnchorInfo anchorInfo) {
        if (P(state, anchorInfo) || O(state, anchorInfo)) {
            return;
        }
        anchorInfo.a();
        anchorInfo.f3493a = 0;
    }

    void S(int i2) {
        this.f3491j = i2 / this.f3486e;
        this.v = View.MeasureSpec.makeMeasureSpec(i2, this.f3489h.getMode());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.u == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    boolean c() {
        int j2 = this.f3487f[0].j(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.f3486e; i2++) {
            if (this.f3487f[i2].j(Integer.MIN_VALUE) != j2) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.f3490i == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.f3490i == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void collectAdjacentPrefetchPositions(int i2, int i3, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int j2;
        int i4;
        if (this.f3490i != 0) {
            i2 = i3;
        }
        if (getChildCount() == 0 || i2 == 0) {
            return;
        }
        G(i2, state);
        int[] iArr = this.A;
        if (iArr == null || iArr.length < this.f3486e) {
            this.A = new int[this.f3486e];
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.f3486e; i6++) {
            LayoutState layoutState = this.k;
            if (layoutState.f3339i == -1) {
                j2 = layoutState.k;
                i4 = this.f3487f[i6].m(j2);
            } else {
                j2 = this.f3487f[i6].j(layoutState.l);
                i4 = this.k.l;
            }
            int i7 = j2 - i4;
            if (i7 >= 0) {
                this.A[i5] = i7;
                i5++;
            }
        }
        Arrays.sort(this.A, 0, i5);
        for (int i8 = 0; i8 < i5 && this.k.a(state); i8++) {
            layoutPrefetchRegistry.addPosition(this.k.f3338h, this.A[i8]);
            LayoutState layoutState2 = this.k;
            layoutState2.f3338h += layoutState2.f3339i;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i2) {
        int f2 = f(i2);
        PointF pointF = new PointF();
        if (f2 == 0) {
            return null;
        }
        if (this.f3490i == 0) {
            pointF.x = f2;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = f2;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    boolean d() {
        int m = this.f3487f[0].m(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.f3486e; i2++) {
            if (this.f3487f[i2].m(Integer.MIN_VALUE) != m) {
                return false;
            }
        }
        return true;
    }

    public int[] findFirstCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f3486e];
        } else if (iArr.length < this.f3486e) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f3486e + ", array size:" + iArr.length);
        }
        for (int i2 = 0; i2 < this.f3486e; i2++) {
            iArr[i2] = this.f3487f[i2].findFirstCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findFirstVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f3486e];
        } else if (iArr.length < this.f3486e) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f3486e + ", array size:" + iArr.length);
        }
        for (int i2 = 0; i2 < this.f3486e; i2++) {
            iArr[i2] = this.f3487f[i2].findFirstVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f3486e];
        } else if (iArr.length < this.f3486e) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f3486e + ", array size:" + iArr.length);
        }
        for (int i2 = 0; i2 < this.f3486e; i2++) {
            iArr[i2] = this.f3487f[i2].findLastCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f3486e];
        } else if (iArr.length < this.f3486e) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f3486e + ", array size:" + iArr.length);
        }
        for (int i2 = 0; i2 < this.f3486e; i2++) {
            iArr[i2] = this.f3487f[i2].findLastVisibleItemPosition();
        }
        return iArr;
    }

    boolean g() {
        int t;
        int u;
        if (getChildCount() == 0 || this.r == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.m) {
            t = u();
            u = t();
        } else {
            t = t();
            u = u();
        }
        if (t == 0 && B() != null) {
            this.q.a();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
        if (!this.y) {
            return false;
        }
        int i2 = this.m ? -1 : 1;
        int i3 = u + 1;
        LazySpanLookup.FullSpanItem firstFullSpanItemInRange = this.q.getFirstFullSpanItemInRange(t, i3, i2, true);
        if (firstFullSpanItemInRange == null) {
            this.y = false;
            this.q.c(i3);
            return false;
        }
        LazySpanLookup.FullSpanItem firstFullSpanItemInRange2 = this.q.getFirstFullSpanItemInRange(t, firstFullSpanItemInRange.f3505a, i2 * (-1), true);
        if (firstFullSpanItemInRange2 == null) {
            this.q.c(firstFullSpanItemInRange.f3505a);
        } else {
            this.q.c(firstFullSpanItemInRange2.f3505a + 1);
        }
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.f3490i == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.f3490i == 1 ? this.f3486e : super.getColumnCountForAccessibility(recycler, state);
    }

    public int getGapStrategy() {
        return this.r;
    }

    public int getOrientation() {
        return this.f3490i;
    }

    public boolean getReverseLayout() {
        return this.l;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.f3490i == 0 ? this.f3486e : super.getRowCountForAccessibility(recycler, state);
    }

    public int getSpanCount() {
        return this.f3486e;
    }

    public void invalidateSpanAssignments() {
        this.q.a();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return this.r != 0;
    }

    boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    View n(boolean z) {
        int startAfterPadding = this.f3488g.getStartAfterPadding();
        int endAfterPadding = this.f3488g.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.f3488g.getDecoratedStart(childAt);
            int decoratedEnd = this.f3488g.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd <= endAfterPadding || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    View o(boolean z) {
        int startAfterPadding = this.f3488g.getStartAfterPadding();
        int endAfterPadding = this.f3488g.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int decoratedStart = this.f3488g.getDecoratedStart(childAt);
            if (this.f3488g.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart >= startAfterPadding || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int i2) {
        super.offsetChildrenHorizontal(i2);
        for (int i3 = 0; i3 < this.f3486e; i3++) {
            this.f3487f[i3].o(i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int i2) {
        super.offsetChildrenVertical(i2);
        for (int i3 = 0; i3 < this.f3486e; i3++) {
            this.f3487f[i3].o(i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        removeCallbacks(this.B);
        for (int i2 = 0; i2 < this.f3486e; i2++) {
            this.f3487f[i2].e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @Nullable
    public View onFocusSearchFailed(View view, int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        View findContainingItemView;
        View focusableViewAfter;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        resolveShouldLayoutReverse();
        int convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i2);
        if (convertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        boolean z = layoutParams.f3501f;
        Span span = layoutParams.f3500e;
        int u = convertFocusDirectionToLayoutDirection == 1 ? u() : t();
        R(u, state);
        M(convertFocusDirectionToLayoutDirection);
        LayoutState layoutState = this.k;
        layoutState.f3338h = layoutState.f3339i + u;
        layoutState.f3337g = (int) (this.f3488g.getTotalSpace() * f3485d);
        LayoutState layoutState2 = this.k;
        layoutState2.m = true;
        layoutState2.f3336f = false;
        l(recycler, layoutState2, state);
        this.s = this.m;
        if (!z && (focusableViewAfter = span.getFocusableViewAfter(u, convertFocusDirectionToLayoutDirection)) != null && focusableViewAfter != findContainingItemView) {
            return focusableViewAfter;
        }
        if (F(convertFocusDirectionToLayoutDirection)) {
            for (int i3 = this.f3486e - 1; i3 >= 0; i3--) {
                View focusableViewAfter2 = this.f3487f[i3].getFocusableViewAfter(u, convertFocusDirectionToLayoutDirection);
                if (focusableViewAfter2 != null && focusableViewAfter2 != findContainingItemView) {
                    return focusableViewAfter2;
                }
            }
        } else {
            for (int i4 = 0; i4 < this.f3486e; i4++) {
                View focusableViewAfter3 = this.f3487f[i4].getFocusableViewAfter(u, convertFocusDirectionToLayoutDirection);
                if (focusableViewAfter3 != null && focusableViewAfter3 != findContainingItemView) {
                    return focusableViewAfter3;
                }
            }
        }
        boolean z2 = (this.l ^ true) == (convertFocusDirectionToLayoutDirection == -1);
        if (!z) {
            View findViewByPosition = findViewByPosition(z2 ? span.findFirstPartiallyVisibleItemPosition() : span.findLastPartiallyVisibleItemPosition());
            if (findViewByPosition != null && findViewByPosition != findContainingItemView) {
                return findViewByPosition;
            }
        }
        if (F(convertFocusDirectionToLayoutDirection)) {
            for (int i5 = this.f3486e - 1; i5 >= 0; i5--) {
                if (i5 != span.f3524f) {
                    View findViewByPosition2 = findViewByPosition(z2 ? this.f3487f[i5].findFirstPartiallyVisibleItemPosition() : this.f3487f[i5].findLastPartiallyVisibleItemPosition());
                    if (findViewByPosition2 != null && findViewByPosition2 != findContainingItemView) {
                        return findViewByPosition2;
                    }
                }
            }
        } else {
            for (int i6 = 0; i6 < this.f3486e; i6++) {
                View findViewByPosition3 = findViewByPosition(z2 ? this.f3487f[i6].findFirstPartiallyVisibleItemPosition() : this.f3487f[i6].findLastPartiallyVisibleItemPosition());
                if (findViewByPosition3 != null && findViewByPosition3 != findContainingItemView) {
                    return findViewByPosition3;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View o = o(false);
            View n = n(false);
            if (o == null || n == null) {
                return;
            }
            int position = getPosition(o);
            int position2 = getPosition(n);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.f3490i == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.f3501f ? this.f3486e : 1, -1, -1, false, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, layoutParams2.getSpanIndex(), layoutParams2.f3501f ? this.f3486e : 1, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        A(i2, i3, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.q.a();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i2, int i3, int i4) {
        A(i2, i3, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        A(i2, i3, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3, Object obj) {
        A(i2, i3, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        E(recycler, state, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.o = -1;
        this.p = Integer.MIN_VALUE;
        this.u = null;
        this.x.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.u = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        int m;
        int startAfterPadding;
        int[] iArr;
        if (this.u != null) {
            return new SavedState(this.u);
        }
        SavedState savedState = new SavedState();
        savedState.f3516h = this.l;
        savedState.f3517i = this.s;
        savedState.f3518j = this.t;
        LazySpanLookup lazySpanLookup = this.q;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f3503b) == null) {
            savedState.f3513e = 0;
        } else {
            savedState.f3514f = iArr;
            savedState.f3513e = iArr.length;
            savedState.f3515g = lazySpanLookup.f3504c;
        }
        if (getChildCount() > 0) {
            savedState.f3509a = this.s ? u() : t();
            savedState.f3510b = p();
            int i2 = this.f3486e;
            savedState.f3511c = i2;
            savedState.f3512d = new int[i2];
            for (int i3 = 0; i3 < this.f3486e; i3++) {
                if (this.s) {
                    m = this.f3487f[i3].j(Integer.MIN_VALUE);
                    if (m != Integer.MIN_VALUE) {
                        startAfterPadding = this.f3488g.getEndAfterPadding();
                        m -= startAfterPadding;
                        savedState.f3512d[i3] = m;
                    } else {
                        savedState.f3512d[i3] = m;
                    }
                } else {
                    m = this.f3487f[i3].m(Integer.MIN_VALUE);
                    if (m != Integer.MIN_VALUE) {
                        startAfterPadding = this.f3488g.getStartAfterPadding();
                        m -= startAfterPadding;
                        savedState.f3512d[i3] = m;
                    } else {
                        savedState.f3512d[i3] = m;
                    }
                }
            }
        } else {
            savedState.f3509a = -1;
            savedState.f3510b = -1;
            savedState.f3511c = 0;
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i2) {
        if (i2 == 0) {
            g();
        }
    }

    int p() {
        View n = this.m ? n(true) : o(true);
        if (n == null) {
            return -1;
        }
        return getPosition(n);
    }

    int scrollBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        G(i2, state);
        int l = l(recycler, this.k, state);
        if (this.k.f3337g >= l) {
            i2 = i2 < 0 ? -l : l;
        }
        this.f3488g.offsetChildren(-i2);
        this.s = this.m;
        LayoutState layoutState = this.k;
        layoutState.f3337g = 0;
        I(recycler, layoutState);
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i2, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i2) {
        SavedState savedState = this.u;
        if (savedState != null && savedState.f3509a != i2) {
            savedState.a();
        }
        this.o = i2;
        this.p = Integer.MIN_VALUE;
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i2, int i3) {
        SavedState savedState = this.u;
        if (savedState != null) {
            savedState.a();
        }
        this.o = i2;
        this.p = i3;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i2, recycler, state);
    }

    public void setGapStrategy(int i2) {
        assertNotInLayoutOrScroll(null);
        if (i2 == this.r) {
            return;
        }
        if (i2 != 0 && i2 != 2) {
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
        this.r = i2;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i2, int i3) {
        int chooseSize;
        int chooseSize2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f3490i == 1) {
            chooseSize2 = RecyclerView.LayoutManager.chooseSize(i3, rect.height() + paddingTop, getMinimumHeight());
            chooseSize = RecyclerView.LayoutManager.chooseSize(i2, (this.f3491j * this.f3486e) + paddingLeft, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.LayoutManager.chooseSize(i2, rect.width() + paddingLeft, getMinimumWidth());
            chooseSize2 = RecyclerView.LayoutManager.chooseSize(i3, (this.f3491j * this.f3486e) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    public void setOrientation(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i2 == this.f3490i) {
            return;
        }
        this.f3490i = i2;
        OrientationHelper orientationHelper = this.f3488g;
        this.f3488g = this.f3489h;
        this.f3489h = orientationHelper;
        requestLayout();
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.u;
        if (savedState != null && savedState.f3516h != z) {
            savedState.f3516h = z;
        }
        this.l = z;
        requestLayout();
    }

    public void setSpanCount(int i2) {
        assertNotInLayoutOrScroll(null);
        if (i2 != this.f3486e) {
            invalidateSpanAssignments();
            this.f3486e = i2;
            this.n = new BitSet(this.f3486e);
            this.f3487f = new Span[this.f3486e];
            for (int i3 = 0; i3 < this.f3486e; i3++) {
                this.f3487f[i3] = new Span(i3);
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i2) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i2);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.u == null;
    }

    int t() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    int u() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    static class LazySpanLookup {

        /* renamed from: a */
        private static final int f3502a = 10;

        /* renamed from: b */
        int[] f3503b;

        /* renamed from: c */
        List<FullSpanItem> f3504c;

        LazySpanLookup() {
        }

        private int f(int i2) {
            if (this.f3504c == null) {
                return -1;
            }
            FullSpanItem fullSpanItem = getFullSpanItem(i2);
            if (fullSpanItem != null) {
                this.f3504c.remove(fullSpanItem);
            }
            int size = this.f3504c.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                }
                if (this.f3504c.get(i3).f3505a >= i2) {
                    break;
                }
                i3++;
            }
            if (i3 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem2 = this.f3504c.get(i3);
            this.f3504c.remove(i3);
            return fullSpanItem2.f3505a;
        }

        private void i(int i2, int i3) {
            List<FullSpanItem> list = this.f3504c;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f3504c.get(size);
                int i4 = fullSpanItem.f3505a;
                if (i4 >= i2) {
                    fullSpanItem.f3505a = i4 + i3;
                }
            }
        }

        private void j(int i2, int i3) {
            List<FullSpanItem> list = this.f3504c;
            if (list == null) {
                return;
            }
            int i4 = i2 + i3;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f3504c.get(size);
                int i5 = fullSpanItem.f3505a;
                if (i5 >= i2) {
                    if (i5 < i4) {
                        this.f3504c.remove(size);
                    } else {
                        fullSpanItem.f3505a = i5 - i3;
                    }
                }
            }
        }

        void a() {
            int[] iArr = this.f3503b;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f3504c = null;
        }

        public void addFullSpanItem(FullSpanItem fullSpanItem) {
            if (this.f3504c == null) {
                this.f3504c = new ArrayList();
            }
            int size = this.f3504c.size();
            for (int i2 = 0; i2 < size; i2++) {
                FullSpanItem fullSpanItem2 = this.f3504c.get(i2);
                if (fullSpanItem2.f3505a == fullSpanItem.f3505a) {
                    this.f3504c.remove(i2);
                }
                if (fullSpanItem2.f3505a >= fullSpanItem.f3505a) {
                    this.f3504c.add(i2, fullSpanItem);
                    return;
                }
            }
            this.f3504c.add(fullSpanItem);
        }

        void b(int i2) {
            int[] iArr = this.f3503b;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i2, 10) + 1];
                this.f3503b = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i2 >= iArr.length) {
                int[] iArr3 = new int[l(i2)];
                this.f3503b = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f3503b;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        int c(int i2) {
            List<FullSpanItem> list = this.f3504c;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f3504c.get(size).f3505a >= i2) {
                        this.f3504c.remove(size);
                    }
                }
            }
            return e(i2);
        }

        int d(int i2) {
            int[] iArr = this.f3503b;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            return iArr[i2];
        }

        int e(int i2) {
            int[] iArr = this.f3503b;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            int f2 = f(i2);
            if (f2 == -1) {
                int[] iArr2 = this.f3503b;
                Arrays.fill(iArr2, i2, iArr2.length, -1);
                return this.f3503b.length;
            }
            int i3 = f2 + 1;
            Arrays.fill(this.f3503b, i2, i3, -1);
            return i3;
        }

        void g(int i2, int i3) {
            int[] iArr = this.f3503b;
            if (iArr == null || i2 >= iArr.length) {
                return;
            }
            int i4 = i2 + i3;
            b(i4);
            int[] iArr2 = this.f3503b;
            System.arraycopy(iArr2, i2, iArr2, i4, (iArr2.length - i2) - i3);
            Arrays.fill(this.f3503b, i2, i4, -1);
            i(i2, i3);
        }

        public FullSpanItem getFirstFullSpanItemInRange(int i2, int i3, int i4, boolean z) {
            List<FullSpanItem> list = this.f3504c;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                FullSpanItem fullSpanItem = this.f3504c.get(i5);
                int i6 = fullSpanItem.f3505a;
                if (i6 >= i3) {
                    return null;
                }
                if (i6 >= i2 && (i4 == 0 || fullSpanItem.f3506b == i4 || (z && fullSpanItem.f3508d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem getFullSpanItem(int i2) {
            List<FullSpanItem> list = this.f3504c;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f3504c.get(size);
                if (fullSpanItem.f3505a == i2) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        void h(int i2, int i3) {
            int[] iArr = this.f3503b;
            if (iArr == null || i2 >= iArr.length) {
                return;
            }
            int i4 = i2 + i3;
            b(i4);
            int[] iArr2 = this.f3503b;
            System.arraycopy(iArr2, i4, iArr2, i2, (iArr2.length - i2) - i3);
            int[] iArr3 = this.f3503b;
            Arrays.fill(iArr3, iArr3.length - i3, iArr3.length, -1);
            j(i2, i3);
        }

        void k(int i2, Span span) {
            b(i2);
            this.f3503b[i2] = span.f3524f;
        }

        int l(int i2) {
            int length = this.f3503b.length;
            while (length <= i2) {
                length *= 2;
            }
            return length;
        }

        @SuppressLint({"BanParcelableUsage"})
        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1
                AnonymousClass1() {
                }

                @Override // android.os.Parcelable.Creator
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                public FullSpanItem[] newArray(int i2) {
                    return new FullSpanItem[i2];
                }
            };

            /* renamed from: a */
            int f3505a;

            /* renamed from: b */
            int f3506b;

            /* renamed from: c */
            int[] f3507c;

            /* renamed from: d */
            boolean f3508d;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem$1 */
            static class AnonymousClass1 implements Parcelable.Creator<FullSpanItem> {
                AnonymousClass1() {
                }

                @Override // android.os.Parcelable.Creator
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                public FullSpanItem[] newArray(int i2) {
                    return new FullSpanItem[i2];
                }
            }

            FullSpanItem(Parcel parcel) {
                this.f3505a = parcel.readInt();
                this.f3506b = parcel.readInt();
                this.f3508d = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f3507c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            int a(int i2) {
                int[] iArr = this.f3507c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i2];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f3505a + ", mGapDir=" + this.f3506b + ", mHasUnwantedGapAfter=" + this.f3508d + ", mGapPerSpan=" + Arrays.toString(this.f3507c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.f3505a);
                parcel.writeInt(this.f3506b);
                parcel.writeInt(this.f3508d ? 1 : 0);
                int[] iArr = this.f3507c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f3507c);
                }
            }

            FullSpanItem() {
            }
        }
    }

    public StaggeredGridLayoutManager(int i2, int i3) {
        this.f3490i = i3;
        setSpanCount(i2);
        this.k = new LayoutState();
        k();
    }
}
