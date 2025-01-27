package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.flexbox.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s4.d;

/* loaded from: classes2.dex */
public class FlexboxLayout extends ViewGroup implements d {

    /* renamed from: s */
    public static final int f8976s = 0;

    /* renamed from: t */
    public static final int f8977t = 1;

    /* renamed from: u */
    public static final int f8978u = 2;

    /* renamed from: v */
    public static final int f8979v = 4;

    /* renamed from: b */
    public int f8980b;

    /* renamed from: c */
    public int f8981c;

    /* renamed from: d */
    public int f8982d;

    /* renamed from: e */
    public int f8983e;

    /* renamed from: f */
    public int f8984f;

    /* renamed from: g */
    public int f8985g;

    /* renamed from: h */
    @Nullable
    public Drawable f8986h;

    /* renamed from: i */
    @Nullable
    public Drawable f8987i;

    /* renamed from: j */
    public int f8988j;

    /* renamed from: k */
    public int f8989k;

    /* renamed from: l */
    public int f8990l;

    /* renamed from: m */
    public int f8991m;

    /* renamed from: n */
    public int[] f8992n;

    /* renamed from: o */
    public SparseIntArray f8993o;

    /* renamed from: p */
    public b f8994p;

    /* renamed from: q */
    public List<com.google.android.flexbox.a> f8995q;

    /* renamed from: r */
    public b.C0255b f8996r;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    private void y(int widthMeasureSpec, int heightMeasureSpec) {
        this.f8995q.clear();
        this.f8996r.a();
        this.f8994p.c(this.f8996r, widthMeasureSpec, heightMeasureSpec);
        this.f8995q = this.f8996r.f9092a;
        this.f8994p.p(widthMeasureSpec, heightMeasureSpec);
        if (this.f8983e == 3) {
            for (com.google.android.flexbox.a aVar : this.f8995q) {
                int i10 = Integer.MIN_VALUE;
                for (int i11 = 0; i11 < aVar.f9073h; i11++) {
                    View s10 = s(aVar.f9080o + i11);
                    if (s10 != null && s10.getVisibility() != 8) {
                        LayoutParams layoutParams = (LayoutParams) s10.getLayoutParams();
                        i10 = this.f8981c != 2 ? Math.max(i10, s10.getMeasuredHeight() + Math.max(aVar.f9077l - s10.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) : Math.max(i10, s10.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + Math.max((aVar.f9077l - s10.getMeasuredHeight()) + s10.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
                    }
                }
                aVar.f9072g = i10;
            }
        }
        this.f8994p.o(widthMeasureSpec, heightMeasureSpec, getPaddingTop() + getPaddingBottom());
        this.f8994p.X();
        A(this.f8980b, widthMeasureSpec, heightMeasureSpec, this.f8996r.f9093b);
    }

    private void z(int widthMeasureSpec, int heightMeasureSpec) {
        this.f8995q.clear();
        this.f8996r.a();
        this.f8994p.f(this.f8996r, widthMeasureSpec, heightMeasureSpec);
        this.f8995q = this.f8996r.f9092a;
        this.f8994p.p(widthMeasureSpec, heightMeasureSpec);
        this.f8994p.o(widthMeasureSpec, heightMeasureSpec, getPaddingLeft() + getPaddingRight());
        this.f8994p.X();
        A(this.f8980b, widthMeasureSpec, heightMeasureSpec, this.f8996r.f9093b);
    }

    public final void A(int flexDirection, int widthMeasureSpec, int heightMeasureSpec, int childState) {
        int sumOfCrossSize;
        int largestMainSize;
        int resolveSizeAndState;
        int resolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (flexDirection == 0 || flexDirection == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                childState = View.combineMeasuredStates(childState, 16777216);
            } else {
                size = largestMainSize;
            }
            resolveSizeAndState = View.resolveSizeAndState(size, widthMeasureSpec, childState);
        } else if (mode == 0) {
            resolveSizeAndState = View.resolveSizeAndState(largestMainSize, widthMeasureSpec, childState);
        } else {
            if (mode != 1073741824) {
                throw new IllegalStateException("Unknown width mode is set: " + mode);
            }
            if (size < largestMainSize) {
                childState = View.combineMeasuredStates(childState, 16777216);
            }
            resolveSizeAndState = View.resolveSizeAndState(size, widthMeasureSpec, childState);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                childState = View.combineMeasuredStates(childState, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, heightMeasureSpec, childState);
        } else if (mode2 == 0) {
            resolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, heightMeasureSpec, childState);
        } else {
            if (mode2 != 1073741824) {
                throw new IllegalStateException("Unknown height mode is set: " + mode2);
            }
            if (size2 < sumOfCrossSize) {
                childState = View.combineMeasuredStates(childState, 256);
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, heightMeasureSpec, childState);
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    public final void B() {
        if (this.f8986h == null && this.f8987i == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    @Override // s4.d
    public void a(View view, int index, int indexInFlexLine, com.google.android.flexbox.a flexLine) {
        if (t(index, indexInFlexLine)) {
            if (j()) {
                int i10 = flexLine.f9070e;
                int i11 = this.f8991m;
                flexLine.f9070e = i10 + i11;
                flexLine.f9071f += i11;
                return;
            }
            int i12 = flexLine.f9070e;
            int i13 = this.f8990l;
            flexLine.f9070e = i12 + i13;
            flexLine.f9071f += i13;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (this.f8993o == null) {
            this.f8993o = new SparseIntArray(getChildCount());
        }
        this.f8992n = this.f8994p.n(child, index, params, this.f8993o);
        super.addView(child, index, params);
    }

    @Override // s4.d
    public int b(int widthSpec, int padding, int childDimension) {
        return ViewGroup.getChildMeasureSpec(widthSpec, padding, childDimension);
    }

    @Override // s4.d
    public View c(int index) {
        return getChildAt(index);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams p10) {
        return p10 instanceof LayoutParams;
    }

    @Override // s4.d
    public int d(int heightSpec, int padding, int childDimension) {
        return ViewGroup.getChildMeasureSpec(heightSpec, padding, childDimension);
    }

    @Override // s4.d
    public int e(View view) {
        return 0;
    }

    @Override // s4.d
    public void f(com.google.android.flexbox.a flexLine) {
        if (j()) {
            if ((this.f8989k & 4) > 0) {
                int i10 = flexLine.f9070e;
                int i11 = this.f8991m;
                flexLine.f9070e = i10 + i11;
                flexLine.f9071f += i11;
                return;
            }
            return;
        }
        if ((this.f8988j & 4) > 0) {
            int i12 = flexLine.f9070e;
            int i13 = this.f8990l;
            flexLine.f9070e = i12 + i13;
            flexLine.f9071f += i13;
        }
    }

    @Override // s4.d
    public View g(int index) {
        return s(index);
    }

    @Override // s4.d
    public int getAlignContent() {
        return this.f8984f;
    }

    @Override // s4.d
    public int getAlignItems() {
        return this.f8983e;
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.f8986h;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.f8987i;
    }

    @Override // s4.d
    public int getFlexDirection() {
        return this.f8980b;
    }

    @Override // s4.d
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // s4.d
    public List<com.google.android.flexbox.a> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.f8995q.size());
        for (com.google.android.flexbox.a aVar : this.f8995q) {
            if (aVar.d() != 0) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    @Override // s4.d
    public List<com.google.android.flexbox.a> getFlexLinesInternal() {
        return this.f8995q;
    }

    @Override // s4.d
    public int getFlexWrap() {
        return this.f8981c;
    }

    @Override // s4.d
    public int getJustifyContent() {
        return this.f8982d;
    }

    @Override // s4.d
    public int getLargestMainSize() {
        Iterator<com.google.android.flexbox.a> it = this.f8995q.iterator();
        int i10 = Integer.MIN_VALUE;
        while (it.hasNext()) {
            i10 = Math.max(i10, it.next().f9070e);
        }
        return i10;
    }

    @Override // s4.d
    public int getMaxLine() {
        return this.f8985g;
    }

    public int getShowDividerHorizontal() {
        return this.f8988j;
    }

    public int getShowDividerVertical() {
        return this.f8989k;
    }

    @Override // s4.d
    public int getSumOfCrossSize() {
        int size = this.f8995q.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            com.google.android.flexbox.a aVar = this.f8995q.get(i11);
            if (u(i11)) {
                i10 += j() ? this.f8990l : this.f8991m;
            }
            if (v(i11)) {
                i10 += j() ? this.f8990l : this.f8991m;
            }
            i10 += aVar.f9072g;
        }
        return i10;
    }

    @Override // s4.d
    public void h(int position, View view) {
    }

    @Override // s4.d
    public int i(View view, int index, int indexInFlexLine) {
        int i10;
        int i11;
        if (j()) {
            i10 = t(index, indexInFlexLine) ? this.f8991m : 0;
            if ((this.f8989k & 4) <= 0) {
                return i10;
            }
            i11 = this.f8991m;
        } else {
            i10 = t(index, indexInFlexLine) ? this.f8990l : 0;
            if ((this.f8988j & 4) <= 0) {
                return i10;
            }
            i11 = this.f8990l;
        }
        return i10 + i11;
    }

    @Override // s4.d
    public boolean j() {
        int i10 = this.f8980b;
        return i10 == 0 || i10 == 1;
    }

    public final boolean k(int flexLineIndex) {
        for (int i10 = 0; i10 < flexLineIndex; i10++) {
            if (this.f8995q.get(i10).d() > 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean l(int index, int indexInFlexLine) {
        for (int i10 = 1; i10 <= indexInFlexLine; i10++) {
            View s10 = s(index - i10);
            if (s10 != null && s10.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    public final void m(Canvas canvas, boolean isRtl, boolean fromBottomToTop) {
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.f8995q.size();
        for (int i10 = 0; i10 < size; i10++) {
            com.google.android.flexbox.a aVar = this.f8995q.get(i10);
            for (int i11 = 0; i11 < aVar.f9073h; i11++) {
                int i12 = aVar.f9080o + i11;
                View s10 = s(i12);
                if (s10 != null && s10.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) s10.getLayoutParams();
                    if (t(i12, i11)) {
                        q(canvas, isRtl ? s10.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : (s10.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f8991m, aVar.f9067b, aVar.f9072g);
                    }
                    if (i11 == aVar.f9073h - 1 && (this.f8989k & 4) > 0) {
                        q(canvas, isRtl ? (s10.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f8991m : s10.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, aVar.f9067b, aVar.f9072g);
                    }
                }
            }
            if (u(i10)) {
                o(canvas, paddingLeft, fromBottomToTop ? aVar.f9069d : aVar.f9067b - this.f8990l, max);
            }
            if (v(i10) && (this.f8988j & 4) > 0) {
                o(canvas, paddingLeft, fromBottomToTop ? aVar.f9067b - this.f8990l : aVar.f9069d, max);
            }
        }
    }

    public final void n(Canvas canvas, boolean isRtl, boolean fromBottomToTop) {
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.f8995q.size();
        for (int i10 = 0; i10 < size; i10++) {
            com.google.android.flexbox.a aVar = this.f8995q.get(i10);
            for (int i11 = 0; i11 < aVar.f9073h; i11++) {
                int i12 = aVar.f9080o + i11;
                View s10 = s(i12);
                if (s10 != null && s10.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) s10.getLayoutParams();
                    if (t(i12, i11)) {
                        o(canvas, aVar.f9066a, fromBottomToTop ? s10.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : (s10.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f8990l, aVar.f9072g);
                    }
                    if (i11 == aVar.f9073h - 1 && (this.f8988j & 4) > 0) {
                        o(canvas, aVar.f9066a, fromBottomToTop ? (s10.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f8990l : s10.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, aVar.f9072g);
                    }
                }
            }
            if (u(i10)) {
                q(canvas, isRtl ? aVar.f9068c : aVar.f9066a - this.f8991m, paddingTop, max);
            }
            if (v(i10) && (this.f8989k & 4) > 0) {
                q(canvas, isRtl ? aVar.f9066a - this.f8991m : aVar.f9068c, paddingTop, max);
            }
        }
    }

    public final void o(Canvas canvas, int left, int top, int length) {
        Drawable drawable = this.f8986h;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(left, top, length + left, this.f8990l + top);
        this.f8986h.draw(canvas);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f8987i == null && this.f8986h == null) {
            return;
        }
        if (this.f8988j == 0 && this.f8989k == 0) {
            return;
        }
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i10 = this.f8980b;
        if (i10 == 0) {
            m(canvas, layoutDirection == 1, this.f8981c == 2);
            return;
        }
        if (i10 == 1) {
            m(canvas, layoutDirection != 1, this.f8981c == 2);
            return;
        }
        if (i10 == 2) {
            boolean z10 = layoutDirection == 1;
            if (this.f8981c == 2) {
                z10 = !z10;
            }
            n(canvas, z10, false);
            return;
        }
        if (i10 != 3) {
            return;
        }
        boolean z11 = layoutDirection == 1;
        if (this.f8981c == 2) {
            z11 = !z11;
        }
        n(canvas, z11, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        boolean z10;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i10 = this.f8980b;
        if (i10 == 0) {
            w(layoutDirection == 1, left, top, right, bottom);
            return;
        }
        if (i10 == 1) {
            w(layoutDirection != 1, left, top, right, bottom);
            return;
        }
        if (i10 == 2) {
            z10 = layoutDirection == 1;
            x(this.f8981c == 2 ? !z10 : z10, false, left, top, right, bottom);
        } else if (i10 == 3) {
            z10 = layoutDirection == 1;
            x(this.f8981c == 2 ? !z10 : z10, true, left, top, right, bottom);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.f8980b);
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.f8993o == null) {
            this.f8993o = new SparseIntArray(getChildCount());
        }
        if (this.f8994p.O(this.f8993o)) {
            this.f8992n = this.f8994p.m(this.f8993o);
        }
        int i10 = this.f8980b;
        if (i10 == 0 || i10 == 1) {
            y(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        if (i10 == 2 || i10 == 3) {
            z(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        throw new IllegalStateException("Invalid value for the flex direction is set: " + this.f8980b);
    }

    public final void q(Canvas canvas, int left, int top, int length) {
        Drawable drawable = this.f8987i;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(left, top, this.f8991m + left, length + top);
        this.f8987i.draw(canvas);
    }

    @Override // android.view.ViewGroup
    /* renamed from: r */
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    public View s(int index) {
        if (index < 0) {
            return null;
        }
        int[] iArr = this.f8992n;
        if (index >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[index]);
    }

    @Override // s4.d
    public void setAlignContent(int alignContent) {
        if (this.f8984f != alignContent) {
            this.f8984f = alignContent;
            requestLayout();
        }
    }

    @Override // s4.d
    public void setAlignItems(int alignItems) {
        if (this.f8983e != alignItems) {
            this.f8983e = alignItems;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable divider) {
        setDividerDrawableHorizontal(divider);
        setDividerDrawableVertical(divider);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable divider) {
        if (divider == this.f8986h) {
            return;
        }
        this.f8986h = divider;
        if (divider != null) {
            this.f8990l = divider.getIntrinsicHeight();
        } else {
            this.f8990l = 0;
        }
        B();
        requestLayout();
    }

    public void setDividerDrawableVertical(@Nullable Drawable divider) {
        if (divider == this.f8987i) {
            return;
        }
        this.f8987i = divider;
        if (divider != null) {
            this.f8991m = divider.getIntrinsicWidth();
        } else {
            this.f8991m = 0;
        }
        B();
        requestLayout();
    }

    @Override // s4.d
    public void setFlexDirection(int flexDirection) {
        if (this.f8980b != flexDirection) {
            this.f8980b = flexDirection;
            requestLayout();
        }
    }

    @Override // s4.d
    public void setFlexLines(List<com.google.android.flexbox.a> flexLines) {
        this.f8995q = flexLines;
    }

    @Override // s4.d
    public void setFlexWrap(int flexWrap) {
        if (this.f8981c != flexWrap) {
            this.f8981c = flexWrap;
            requestLayout();
        }
    }

    @Override // s4.d
    public void setJustifyContent(int justifyContent) {
        if (this.f8982d != justifyContent) {
            this.f8982d = justifyContent;
            requestLayout();
        }
    }

    @Override // s4.d
    public void setMaxLine(int maxLine) {
        if (this.f8985g != maxLine) {
            this.f8985g = maxLine;
            requestLayout();
        }
    }

    public void setShowDivider(int dividerMode) {
        setShowDividerVertical(dividerMode);
        setShowDividerHorizontal(dividerMode);
    }

    public void setShowDividerHorizontal(int dividerMode) {
        if (dividerMode != this.f8988j) {
            this.f8988j = dividerMode;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int dividerMode) {
        if (dividerMode != this.f8989k) {
            this.f8989k = dividerMode;
            requestLayout();
        }
    }

    public final boolean t(int index, int indexInFlexLine) {
        return l(index, indexInFlexLine) ? j() ? (this.f8989k & 1) != 0 : (this.f8988j & 1) != 0 : j() ? (this.f8989k & 2) != 0 : (this.f8988j & 2) != 0;
    }

    public final boolean u(int flexLineIndex) {
        if (flexLineIndex < 0 || flexLineIndex >= this.f8995q.size()) {
            return false;
        }
        return k(flexLineIndex) ? j() ? (this.f8988j & 1) != 0 : (this.f8989k & 1) != 0 : j() ? (this.f8988j & 2) != 0 : (this.f8989k & 2) != 0;
    }

    public final boolean v(int flexLineIndex) {
        if (flexLineIndex < 0 || flexLineIndex >= this.f8995q.size()) {
            return false;
        }
        for (int i10 = flexLineIndex + 1; i10 < this.f8995q.size(); i10++) {
            if (this.f8995q.get(i10).d() > 0) {
                return false;
            }
        }
        return j() ? (this.f8988j & 4) != 0 : (this.f8989k & 4) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0190  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void w(boolean r29, int r30, int r31, int r32, int r33) {
        /*
            Method dump skipped, instructions count: 547
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.w(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0185  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void x(boolean r30, boolean r31, int r32, int r33, int r34, int r35) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.x(boolean, boolean, int, int, int, int):void");
    }

    public FlexboxLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        return lp instanceof LayoutParams ? new LayoutParams((LayoutParams) lp) : lp instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) lp) : new LayoutParams(lp);
    }

    public FlexboxLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f8985g = -1;
        this.f8994p = new b(this);
        this.f8995q = new ArrayList();
        this.f8996r = new b.C0255b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.FlexboxLayout, defStyleAttr, 0);
        this.f8980b = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexDirection, 0);
        this.f8981c = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexWrap, 0);
        this.f8982d = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_justifyContent, 0);
        this.f8983e = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignItems, 0);
        this.f8984f = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignContent, 0);
        this.f8985g = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_maxLine, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i10 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDivider, 0);
        if (i10 != 0) {
            this.f8989k = i10;
            this.f8988j = i10;
        }
        int i11 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerVertical, 0);
        if (i11 != 0) {
            this.f8989k = i11;
        }
        int i12 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (i12 != 0) {
            this.f8988j = i12;
        }
        obtainStyledAttributes.recycle();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();

        /* renamed from: b */
        public int f8997b;

        /* renamed from: c */
        public float f8998c;

        /* renamed from: d */
        public float f8999d;

        /* renamed from: e */
        public int f9000e;

        /* renamed from: f */
        public float f9001f;

        /* renamed from: g */
        public int f9002g;

        /* renamed from: h */
        public int f9003h;

        /* renamed from: i */
        public int f9004i;

        /* renamed from: j */
        public int f9005j;

        /* renamed from: k */
        public boolean f9006k;

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

        public LayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.f8997b = 1;
            this.f8998c = 0.0f;
            this.f8999d = 1.0f;
            this.f9000e = -1;
            this.f9001f = -1.0f;
            this.f9002g = -1;
            this.f9003h = -1;
            this.f9004i = 16777215;
            this.f9005j = 16777215;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.FlexboxLayout_Layout);
            this.f8997b = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_order, 1);
            this.f8998c = obtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.f8999d = obtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.f9000e = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.f9001f = obtainStyledAttributes.getFraction(R.styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.f9002g = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minWidth, -1);
            this.f9003h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minHeight, -1);
            this.f9004i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxWidth, 16777215);
            this.f9005j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxHeight, 16777215);
            this.f9006k = obtainStyledAttributes.getBoolean(R.styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            obtainStyledAttributes.recycle();
        }

        @Override // com.google.android.flexbox.FlexItem
        public int A() {
            return this.f9005j;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void B(int alignSelf) {
            this.f9000e = alignSelf;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void e(int order) {
            this.f8997b = order;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int g() {
            return this.f9000e;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return this.f8997b;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float h() {
            return this.f8999d;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void i(int maxWidth) {
            this.f9004i = maxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void j(boolean wrapBefore) {
            this.f9006k = wrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int k() {
            return this.f9002g;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void l(int maxHeight) {
            this.f9005j = maxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int m() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void n(int minHeight) {
            this.f9003h = minHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float o() {
            return this.f8998c;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float p() {
            return this.f9001f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean q() {
            return this.f9006k;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int r() {
            return this.f9004i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void s(float flexGrow) {
            this.f8998c = flexGrow;
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
            this.f9001f = flexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void u(float flexShrink) {
            this.f8999d = flexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void v(int minWidth) {
            this.f9002g = minWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int w() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f8997b);
            parcel.writeFloat(this.f8998c);
            parcel.writeFloat(this.f8999d);
            parcel.writeInt(this.f9000e);
            parcel.writeFloat(this.f9001f);
            parcel.writeInt(this.f9002g);
            parcel.writeInt(this.f9003h);
            parcel.writeInt(this.f9004i);
            parcel.writeInt(this.f9005j);
            parcel.writeByte(this.f9006k ? (byte) 1 : (byte) 0);
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
            return this.f9003h;
        }

        public LayoutParams(LayoutParams source) {
            super((ViewGroup.MarginLayoutParams) source);
            this.f8997b = 1;
            this.f8998c = 0.0f;
            this.f8999d = 1.0f;
            this.f9000e = -1;
            this.f9001f = -1.0f;
            this.f9002g = -1;
            this.f9003h = -1;
            this.f9004i = 16777215;
            this.f9005j = 16777215;
            this.f8997b = source.f8997b;
            this.f8998c = source.f8998c;
            this.f8999d = source.f8999d;
            this.f9000e = source.f9000e;
            this.f9001f = source.f9001f;
            this.f9002g = source.f9002g;
            this.f9003h = source.f9003h;
            this.f9004i = source.f9004i;
            this.f9005j = source.f9005j;
            this.f9006k = source.f9006k;
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            this.f8997b = 1;
            this.f8998c = 0.0f;
            this.f8999d = 1.0f;
            this.f9000e = -1;
            this.f9001f = -1.0f;
            this.f9002g = -1;
            this.f9003h = -1;
            this.f9004i = 16777215;
            this.f9005j = 16777215;
        }

        public LayoutParams(int width, int height) {
            super(new ViewGroup.LayoutParams(width, height));
            this.f8997b = 1;
            this.f8998c = 0.0f;
            this.f8999d = 1.0f;
            this.f9000e = -1;
            this.f9001f = -1.0f;
            this.f9002g = -1;
            this.f9003h = -1;
            this.f9004i = 16777215;
            this.f9005j = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
            this.f8997b = 1;
            this.f8998c = 0.0f;
            this.f8999d = 1.0f;
            this.f9000e = -1;
            this.f9001f = -1.0f;
            this.f9002g = -1;
            this.f9003h = -1;
            this.f9004i = 16777215;
            this.f9005j = 16777215;
        }

        public LayoutParams(Parcel in) {
            super(0, 0);
            this.f8997b = 1;
            this.f8998c = 0.0f;
            this.f8999d = 1.0f;
            this.f9000e = -1;
            this.f9001f = -1.0f;
            this.f9002g = -1;
            this.f9003h = -1;
            this.f9004i = 16777215;
            this.f9005j = 16777215;
            this.f8997b = in.readInt();
            this.f8998c = in.readFloat();
            this.f8999d = in.readFloat();
            this.f9000e = in.readInt();
            this.f9001f = in.readFloat();
            this.f9002g = in.readInt();
            this.f9003h = in.readInt();
            this.f9004i = in.readInt();
            this.f9005j = in.readInt();
            this.f9006k = in.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = in.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = in.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = in.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = in.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = in.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = in.readInt();
        }
    }
}
