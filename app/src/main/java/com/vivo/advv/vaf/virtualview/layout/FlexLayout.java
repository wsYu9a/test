package com.vivo.advv.vaf.virtualview.layout;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.ViewFactory;
import com.vivo.advv.vaf.virtualview.core.Layout;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.util.ViewUtils;
import com.vivo.advv.virtualview.common.StringBase;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* loaded from: classes4.dex */
public class FlexLayout extends Layout {
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    private static final String TAG = "FlexLayout_TMTEST";
    private int mAlignContent;
    private int mAlignItems;
    private boolean[] mChildrenFrozen;
    private Drawable mDividerDrawableHorizontal;
    private Drawable mDividerDrawableVertical;
    private int mDividerHorizontalHeight;
    private int mDividerVerticalWidth;
    private int mFlexDirection;
    private List<FlexLine> mFlexLines;
    private int mFlexWrap;
    private int mJustifyContent;
    private SparseIntArray mOrderCache;
    private int[] mReorderedIndices;
    private int mShowDividerHorizontal;
    private int mShowDividerVertical;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface AlignContent {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface AlignItems {
    }

    public static class Builder implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new FlexLayout(vafContext, viewCache);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface DividerMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FlexDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FlexWrap {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface JustifyContent {
    }

    private static class Order implements Comparable<Order> {
        int index;
        int order;

        private Order() {
        }

        public String toString() {
            return "Order{order=" + this.order + ", index=" + this.index + '}';
        }

        /* synthetic */ Order(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull Order order) {
            int i2 = this.order;
            int i3 = order.order;
            return i2 != i3 ? i2 - i3 : this.index - order.index;
        }
    }

    public FlexLayout(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        this.mFlexLines = new ArrayList();
        this.mFlexDirection = 0;
        this.mFlexWrap = 0;
        this.mJustifyContent = 0;
        this.mAlignItems = 0;
        this.mAlignContent = 0;
    }

    private void addFlexLine(FlexLine flexLine) {
        if (isMainAxisDirectionHorizontal(this.mFlexDirection)) {
            if ((this.mShowDividerVertical & 4) > 0) {
                int i2 = flexLine.mMainSize;
                int i3 = this.mDividerVerticalWidth;
                flexLine.mMainSize = i2 + i3;
                flexLine.mDividerLengthInMainSize += i3;
            }
        } else if ((this.mShowDividerHorizontal & 4) > 0) {
            int i4 = flexLine.mMainSize;
            int i5 = this.mDividerHorizontalHeight;
            flexLine.mMainSize = i4 + i5;
            flexLine.mDividerLengthInMainSize += i5;
        }
        this.mFlexLines.add(flexLine);
    }

    private void addFlexLineIfLastFlexItem(int i2, int i3, FlexLine flexLine) {
        if (i2 != i3 - 1 || flexLine.mItemCount == 0) {
            return;
        }
        addFlexLine(flexLine);
    }

    private boolean allFlexLinesAreDummyBefore(int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.mFlexLines.get(i3).mItemCount > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean allViewsAreGoneBefore(int i2, int i3) {
        for (int i4 = 1; i4 <= i3; i4++) {
            ViewBase reorderedChildAt = getReorderedChildAt(i2 - i4);
            if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 2) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void checkSizeConstraints(com.vivo.advv.vaf.virtualview.core.ViewBase r7) {
        /*
            r6 = this;
            com.vivo.advv.vaf.virtualview.core.Layout$Params r0 = r7.getComLayoutParams()
            com.vivo.advv.vaf.virtualview.layout.FlexLayout$Params r0 = (com.vivo.advv.vaf.virtualview.layout.FlexLayout.Params) r0
            int r1 = r7.getComMeasuredWidth()
            int r2 = r7.getComMeasuredHeight()
            int r3 = r7.getComMeasuredWidth()
            int r4 = r0.minWidth
            r5 = 1
            if (r3 >= r4) goto L19
        L17:
            r1 = r4
            goto L22
        L19:
            int r3 = r7.getComMeasuredWidth()
            int r4 = r0.maxWidth
            if (r3 <= r4) goto L24
            goto L17
        L22:
            r3 = 1
            goto L25
        L24:
            r3 = 0
        L25:
            int r4 = r0.minHeight
            if (r2 >= r4) goto L2b
            r2 = r4
            goto L32
        L2b:
            int r0 = r0.maxHeight
            if (r2 <= r0) goto L31
            r2 = r0
            goto L32
        L31:
            r5 = r3
        L32:
            if (r5 == 0) goto L41
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measureComponent(r1, r0)
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.advv.vaf.virtualview.layout.FlexLayout.checkSizeConstraints(com.vivo.advv.vaf.virtualview.core.ViewBase):void");
    }

    @NonNull
    private List<Order> createOrders(int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            Params params = (Params) this.mSubViews.get(i3).getComLayoutParams();
            Order order = new Order();
            order.order = params.order;
            order.index = i3;
            arrayList.add(order);
        }
        return arrayList;
    }

    private int[] createReorderedIndices() {
        int size = this.mSubViews.size();
        return sortOrdersIntoReorderedIndices(size, createOrders(size));
    }

    private void determineCrossSize(int i2, int i3, int i4, int i5) {
        int mode;
        int size;
        if (i2 == 0 || i2 == 1) {
            mode = View.MeasureSpec.getMode(i4);
            size = View.MeasureSpec.getSize(i4);
        } else {
            if (i2 != 2 && i2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + i2);
            }
            mode = View.MeasureSpec.getMode(i3);
            size = View.MeasureSpec.getSize(i3);
        }
        if (mode == 1073741824) {
            int sumOfCrossSize = getSumOfCrossSize() + i5;
            int i6 = 0;
            if (this.mFlexLines.size() == 1) {
                this.mFlexLines.get(0).mCrossSize = size - i5;
                return;
            }
            if (this.mFlexLines.size() < 2 || sumOfCrossSize >= size) {
                return;
            }
            int i7 = this.mAlignContent;
            if (i7 == 1) {
                int i8 = size - sumOfCrossSize;
                FlexLine flexLine = new FlexLine();
                flexLine.mCrossSize = i8;
                this.mFlexLines.add(0, flexLine);
                return;
            }
            if (i7 == 2) {
                int i9 = (size - sumOfCrossSize) / 2;
                ArrayList arrayList = new ArrayList();
                FlexLine flexLine2 = new FlexLine();
                flexLine2.mCrossSize = i9;
                int size2 = this.mFlexLines.size();
                while (i6 < size2) {
                    if (i6 == 0) {
                        arrayList.add(flexLine2);
                    }
                    arrayList.add(this.mFlexLines.get(i6));
                    if (i6 == this.mFlexLines.size() - 1) {
                        arrayList.add(flexLine2);
                    }
                    i6++;
                }
                this.mFlexLines = arrayList;
                return;
            }
            if (i7 == 3) {
                float size3 = (size - sumOfCrossSize) / (this.mFlexLines.size() - 1);
                ArrayList arrayList2 = new ArrayList();
                int size4 = this.mFlexLines.size();
                float f2 = 0.0f;
                while (i6 < size4) {
                    arrayList2.add(this.mFlexLines.get(i6));
                    if (i6 != this.mFlexLines.size() - 1) {
                        FlexLine flexLine3 = new FlexLine();
                        if (i6 == this.mFlexLines.size() - 2) {
                            flexLine3.mCrossSize = Math.round(f2 + size3);
                            f2 = 0.0f;
                        } else {
                            flexLine3.mCrossSize = Math.round(size3);
                        }
                        int i10 = flexLine3.mCrossSize;
                        f2 += size3 - i10;
                        if (f2 > 1.0f) {
                            flexLine3.mCrossSize = i10 + 1;
                            f2 -= 1.0f;
                        } else if (f2 < -1.0f) {
                            flexLine3.mCrossSize = i10 - 1;
                            f2 += 1.0f;
                        }
                        arrayList2.add(flexLine3);
                    }
                    i6++;
                }
                this.mFlexLines = arrayList2;
                return;
            }
            if (i7 == 4) {
                int size5 = (size - sumOfCrossSize) / (this.mFlexLines.size() * 2);
                ArrayList arrayList3 = new ArrayList();
                FlexLine flexLine4 = new FlexLine();
                flexLine4.mCrossSize = size5;
                for (FlexLine flexLine5 : this.mFlexLines) {
                    arrayList3.add(flexLine4);
                    arrayList3.add(flexLine5);
                    arrayList3.add(flexLine4);
                }
                this.mFlexLines = arrayList3;
                return;
            }
            if (i7 != 5) {
                return;
            }
            float size6 = (size - sumOfCrossSize) / this.mFlexLines.size();
            int size7 = this.mFlexLines.size();
            float f3 = 0.0f;
            while (i6 < size7) {
                FlexLine flexLine6 = this.mFlexLines.get(i6);
                float f4 = flexLine6.mCrossSize + size6;
                if (i6 == this.mFlexLines.size() - 1) {
                    f4 += f3;
                    f3 = 0.0f;
                }
                int round = Math.round(f4);
                f3 += f4 - round;
                if (f3 > 1.0f) {
                    round++;
                    f3 -= 1.0f;
                } else if (f3 < -1.0f) {
                    round--;
                    f3 += 1.0f;
                }
                flexLine6.mCrossSize = round;
                i6++;
            }
        }
    }

    private void determineMainSize(int i2, int i3, int i4) {
        int i5;
        int comPaddingLeft;
        int comPaddingRight;
        if (i2 == 0 || i2 == 1) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (mode != 1073741824) {
                size = getLargestMainSize();
            }
            i5 = size;
            comPaddingLeft = getComPaddingLeft();
            comPaddingRight = getComPaddingRight();
        } else {
            if (i2 != 2 && i2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + i2);
            }
            int mode2 = View.MeasureSpec.getMode(i4);
            i5 = View.MeasureSpec.getSize(i4);
            if (mode2 != 1073741824) {
                i5 = getLargestMainSize();
            }
            comPaddingLeft = getComPaddingTop();
            comPaddingRight = getComPaddingBottom();
        }
        int i6 = comPaddingLeft + comPaddingRight;
        int i7 = 0;
        for (FlexLine flexLine : this.mFlexLines) {
            i7 = flexLine.mMainSize < i5 ? expandFlexItems(flexLine, i2, i5, i6, i7) : shrinkFlexItems(flexLine, i2, i5, i6, i7);
        }
    }

    private int expandFlexItems(FlexLine flexLine, int i2, int i3, int i4, int i5) {
        int i6;
        double d2;
        double d3;
        float f2 = flexLine.mTotalFlexGrow;
        if (f2 <= 0.0f || i3 < (i6 = flexLine.mMainSize)) {
            return i5 + flexLine.mItemCount;
        }
        float f3 = (i3 - i6) / f2;
        flexLine.mMainSize = i4 + flexLine.mDividerLengthInMainSize;
        int i7 = i5;
        boolean z = false;
        float f4 = 0.0f;
        for (int i8 = 0; i8 < flexLine.mItemCount; i8++) {
            ViewBase reorderedChildAt = getReorderedChildAt(i7);
            if (reorderedChildAt != null) {
                if (reorderedChildAt.getVisibility() != 2) {
                    Params params = (Params) reorderedChildAt.getComLayoutParams();
                    if (isMainAxisDirectionHorizontal(i2)) {
                        if (!this.mChildrenFrozen[i7]) {
                            float comMeasuredWidth = reorderedChildAt.getComMeasuredWidth() + (params.flexGrow * f3);
                            if (i8 == flexLine.mItemCount - 1) {
                                comMeasuredWidth += f4;
                                f4 = 0.0f;
                            }
                            int round = Math.round(comMeasuredWidth);
                            int i9 = params.maxWidth;
                            if (round > i9) {
                                this.mChildrenFrozen[i7] = true;
                                flexLine.mTotalFlexGrow -= params.flexGrow;
                                round = i9;
                                z = true;
                            } else {
                                f4 += comMeasuredWidth - round;
                                double d4 = f4;
                                if (d4 > 1.0d) {
                                    round++;
                                    Double.isNaN(d4);
                                    d3 = d4 - 1.0d;
                                } else if (d4 < -1.0d) {
                                    round--;
                                    Double.isNaN(d4);
                                    d3 = d4 + 1.0d;
                                }
                                f4 = (float) d3;
                            }
                            reorderedChildAt.measureComponent(View.MeasureSpec.makeMeasureSpec(round, 1073741824), View.MeasureSpec.makeMeasureSpec(reorderedChildAt.getComMeasuredHeight(), 1073741824));
                        }
                        flexLine.mMainSize += reorderedChildAt.getComMeasuredWidth() + params.mLayoutMarginLeft + params.mLayoutMarginRight;
                    } else {
                        if (!this.mChildrenFrozen[i7]) {
                            float comMeasuredHeight = reorderedChildAt.getComMeasuredHeight() + (params.flexGrow * f3);
                            if (i8 == flexLine.mItemCount - 1) {
                                comMeasuredHeight += f4;
                                f4 = 0.0f;
                            }
                            int round2 = Math.round(comMeasuredHeight);
                            int i10 = params.maxHeight;
                            if (round2 > i10) {
                                this.mChildrenFrozen[i7] = true;
                                flexLine.mTotalFlexGrow -= params.flexGrow;
                                round2 = i10;
                                z = true;
                            } else {
                                f4 += comMeasuredHeight - round2;
                                double d5 = f4;
                                if (d5 > 1.0d) {
                                    round2++;
                                    Double.isNaN(d5);
                                    d2 = d5 - 1.0d;
                                } else if (d5 < -1.0d) {
                                    round2--;
                                    Double.isNaN(d5);
                                    d2 = d5 + 1.0d;
                                }
                                f4 = (float) d2;
                            }
                            reorderedChildAt.measureComponent(View.MeasureSpec.makeMeasureSpec(reorderedChildAt.getComMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(round2, 1073741824));
                        }
                        flexLine.mMainSize += reorderedChildAt.getComMeasuredHeight() + params.mLayoutMarginTop + params.mLayoutMarginBottom;
                    }
                }
                i7++;
            }
        }
        if (z && i6 != flexLine.mMainSize) {
            expandFlexItems(flexLine, i2, i3, i4, i5);
        }
        return i7;
    }

    private int getLargestMainSize() {
        Iterator<FlexLine> it = this.mFlexLines.iterator();
        int i2 = Integer.MIN_VALUE;
        while (it.hasNext()) {
            i2 = Math.max(i2, it.next().mMainSize);
        }
        return i2;
    }

    private int getSumOfCrossSize() {
        int size = this.mFlexLines.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            FlexLine flexLine = this.mFlexLines.get(i3);
            if (hasDividerBeforeFlexLine(i3)) {
                i2 += isMainAxisDirectionHorizontal(this.mFlexDirection) ? this.mDividerHorizontalHeight : this.mDividerVerticalWidth;
            }
            if (hasEndDividerAfterFlexLine(i3)) {
                i2 += isMainAxisDirectionHorizontal(this.mFlexDirection) ? this.mDividerHorizontalHeight : this.mDividerVerticalWidth;
            }
            i2 += flexLine.mCrossSize;
        }
        return i2;
    }

    private boolean hasDividerBeforeChildAtAlongMainAxis(int i2, int i3) {
        return allViewsAreGoneBefore(i2, i3) ? isMainAxisDirectionHorizontal(this.mFlexDirection) ? (this.mShowDividerVertical & 1) != 0 : (this.mShowDividerHorizontal & 1) != 0 : isMainAxisDirectionHorizontal(this.mFlexDirection) ? (this.mShowDividerVertical & 2) != 0 : (this.mShowDividerHorizontal & 2) != 0;
    }

    private boolean hasDividerBeforeFlexLine(int i2) {
        if (i2 < 0 || i2 >= this.mFlexLines.size()) {
            return false;
        }
        return allFlexLinesAreDummyBefore(i2) ? isMainAxisDirectionHorizontal(this.mFlexDirection) ? (this.mShowDividerHorizontal & 1) != 0 : (this.mShowDividerVertical & 1) != 0 : isMainAxisDirectionHorizontal(this.mFlexDirection) ? (this.mShowDividerHorizontal & 2) != 0 : (this.mShowDividerVertical & 2) != 0;
    }

    private boolean hasEndDividerAfterFlexLine(int i2) {
        if (i2 < 0 || i2 >= this.mFlexLines.size()) {
            return false;
        }
        do {
            i2++;
            if (i2 >= this.mFlexLines.size()) {
                return isMainAxisDirectionHorizontal(this.mFlexDirection) ? (this.mShowDividerHorizontal & 4) != 0 : (this.mShowDividerVertical & 4) != 0;
            }
        } while (this.mFlexLines.get(i2).mItemCount <= 0);
        return false;
    }

    private boolean isMainAxisDirectionHorizontal(int i2) {
        return i2 == 0 || i2 == 1;
    }

    private boolean isOrderChangedFromLastMeasurement() {
        int size = this.mSubViews.size();
        if (this.mOrderCache == null) {
            this.mOrderCache = new SparseIntArray(size);
        }
        if (this.mOrderCache.size() != size) {
            return true;
        }
        for (int i2 = 0; i2 < size; i2++) {
            ViewBase viewBase = this.mSubViews.get(i2);
            if (viewBase != null && ((Params) viewBase.getComLayoutParams()).order != this.mOrderCache.get(i2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean isWrapRequired(int r3, int r4, int r5, int r6, com.vivo.advv.vaf.virtualview.layout.FlexLayout.Params r7, int r8, int r9) {
        /*
            r2 = this;
            int r0 = r2.mFlexWrap
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r7 = r7.wrapBefore
            r0 = 1
            if (r7 == 0) goto Lc
            return r0
        Lc:
            if (r3 != 0) goto Lf
            return r1
        Lf:
            int r3 = r2.mFlexDirection
            boolean r3 = r2.isMainAxisDirectionHorizontal(r3)
            if (r3 == 0) goto L29
            boolean r3 = r2.hasDividerBeforeChildAtAlongMainAxis(r8, r9)
            if (r3 == 0) goto L20
            int r3 = r2.mDividerVerticalWidth
            int r6 = r6 + r3
        L20:
            int r3 = r2.mShowDividerVertical
            r3 = r3 & 4
            if (r3 <= 0) goto L3b
            int r3 = r2.mDividerVerticalWidth
            goto L3a
        L29:
            boolean r3 = r2.hasDividerBeforeChildAtAlongMainAxis(r8, r9)
            if (r3 == 0) goto L32
            int r3 = r2.mDividerHorizontalHeight
            int r6 = r6 + r3
        L32:
            int r3 = r2.mShowDividerHorizontal
            r3 = r3 & 4
            if (r3 <= 0) goto L3b
            int r3 = r2.mDividerHorizontalHeight
        L3a:
            int r6 = r6 + r3
        L3b:
            int r5 = r5 + r6
            if (r4 >= r5) goto L3f
            r1 = 1
        L3f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.advv.vaf.virtualview.layout.FlexLayout.isWrapRequired(int, int, int, int, com.vivo.advv.vaf.virtualview.layout.FlexLayout$Params, int, int):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void layoutHorizontal(boolean r28, int r29, int r30, int r31, int r32) {
        /*
            Method dump skipped, instructions count: 493
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.advv.vaf.virtualview.layout.FlexLayout.layoutHorizontal(boolean, int, int, int, int):void");
    }

    private void layoutSingleChildHorizontal(ViewBase viewBase, FlexLine flexLine, int i2, int i3, int i4, int i5, int i6, int i7) {
        Params params = (Params) viewBase.getComLayoutParams();
        int i8 = params.alignSelf;
        if (i8 != -1) {
            i3 = i8;
        }
        int i9 = flexLine.mCrossSize;
        if (i3 != 0) {
            if (i3 == 1) {
                if (i2 == 2) {
                    viewBase.comLayout(i4, (i5 - i9) + viewBase.getComMeasuredHeight() + params.mLayoutMarginTop, i6, (i7 - i9) + viewBase.getComMeasuredHeight() + params.mLayoutMarginTop);
                    return;
                }
                int i10 = i5 + i9;
                int comMeasuredHeight = i10 - viewBase.getComMeasuredHeight();
                int i11 = params.mLayoutMarginBottom;
                viewBase.comLayout(i4, comMeasuredHeight - i11, i6, i10 - i11);
                return;
            }
            if (i3 == 2) {
                int comMeasuredHeight2 = (i9 - viewBase.getComMeasuredHeight()) / 2;
                if (i2 != 2) {
                    int i12 = i5 + comMeasuredHeight2;
                    viewBase.comLayout(i4, (params.mLayoutMarginTop + i12) - params.mLayoutMarginBottom, i6, ((i12 + viewBase.getComMeasuredHeight()) + params.mLayoutMarginTop) - params.mLayoutMarginBottom);
                    return;
                } else {
                    int i13 = i5 - comMeasuredHeight2;
                    viewBase.comLayout(i4, (params.mLayoutMarginTop + i13) - params.mLayoutMarginBottom, i6, ((i13 + viewBase.getComMeasuredHeight()) + params.mLayoutMarginTop) - params.mLayoutMarginBottom);
                    return;
                }
            }
            if (i3 == 3) {
                if (i2 != 2) {
                    int max = Math.max(flexLine.mMaxBaseline - viewBase.getComBaseline(), params.mLayoutMarginTop);
                    viewBase.comLayout(i4, i5 + max, i6, i7 + max);
                    return;
                } else {
                    int max2 = Math.max((flexLine.mMaxBaseline - viewBase.getComMeasuredHeight()) + viewBase.getComBaseline(), params.mLayoutMarginBottom);
                    viewBase.comLayout(i4, i5 - max2, i6, i7 - max2);
                    return;
                }
            }
            if (i3 != 4) {
                return;
            }
        }
        if (i2 != 2) {
            int i14 = params.mLayoutMarginTop;
            viewBase.comLayout(i4, i5 + i14, i6, i7 + i14);
        } else {
            int i15 = params.mLayoutMarginBottom;
            viewBase.comLayout(i4, i5 - i15, i6, i7 - i15);
        }
    }

    private void layoutSingleChildVertical(ViewBase viewBase, FlexLine flexLine, boolean z, int i2, int i3, int i4, int i5, int i6) {
        Params params = (Params) viewBase.getComLayoutParams();
        int i7 = params.alignSelf;
        if (i7 != -1) {
            i2 = i7;
        }
        int i8 = flexLine.mCrossSize;
        if (i2 != 0) {
            if (i2 == 1) {
                if (z) {
                    viewBase.comLayout((i3 - i8) + viewBase.getComMeasuredWidth() + params.mLayoutMarginLeft, i4, (i5 - i8) + viewBase.getComMeasuredWidth() + params.mLayoutMarginLeft, i6);
                    return;
                } else {
                    viewBase.comLayout(((i3 + i8) - viewBase.getComMeasuredWidth()) - params.mLayoutMarginRight, i4, ((i5 + i8) - viewBase.getComMeasuredWidth()) - params.mLayoutMarginRight, i6);
                    return;
                }
            }
            if (i2 == 2) {
                int comMeasuredWidth = (i8 - viewBase.getComMeasuredWidth()) / 2;
                if (z) {
                    int i9 = params.mLayoutMarginLeft;
                    int i10 = params.mLayoutMarginRight;
                    viewBase.comLayout(((i3 - comMeasuredWidth) + i9) - i10, i4, ((i5 - comMeasuredWidth) + i9) - i10, i6);
                    return;
                } else {
                    int i11 = params.mLayoutMarginLeft;
                    int i12 = params.mLayoutMarginRight;
                    viewBase.comLayout(((i3 + comMeasuredWidth) + i11) - i12, i4, ((i5 + comMeasuredWidth) + i11) - i12, i6);
                    return;
                }
            }
            if (i2 != 3 && i2 != 4) {
                return;
            }
        }
        if (z) {
            int i13 = params.mLayoutMarginRight;
            viewBase.comLayout(i3 - i13, i4, i5 - i13, i6);
        } else {
            int i14 = params.mLayoutMarginLeft;
            viewBase.comLayout(i3 + i14, i4, i5 + i14, i6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void layoutVertical(boolean r27, boolean r28, int r29, int r30, int r31, int r32) {
        /*
            Method dump skipped, instructions count: 490
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.advv.vaf.virtualview.layout.FlexLayout.layoutVertical(boolean, boolean, int, int, int, int):void");
    }

    private void measureHorizontal(int i2, int i3) {
        int i4;
        int combineMeasuredStates;
        int i5;
        Params params;
        int i6;
        int i7;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        this.mFlexLines.clear();
        int size2 = this.mSubViews.size();
        int i8 = this.mPaddingLeft;
        int i9 = this.mPaddingRight;
        FlexLine flexLine = new FlexLine();
        int i10 = i8 + i9;
        flexLine.mMainSize = i10;
        FlexLine flexLine2 = flexLine;
        int i11 = 0;
        int i12 = Integer.MIN_VALUE;
        int i13 = 0;
        int i14 = 0;
        while (i13 < size2) {
            ViewBase reorderedChildAt = getReorderedChildAt(i13);
            if (reorderedChildAt == null) {
                addFlexLineIfLastFlexItem(i13, size2, flexLine2);
            } else if (reorderedChildAt.getVisibility() == 2) {
                flexLine2.mItemCount++;
                addFlexLineIfLastFlexItem(i13, size2, flexLine2);
            } else {
                Params params2 = (Params) reorderedChildAt.getComLayoutParams();
                if (params2.alignSelf == 4) {
                    flexLine2.mIndicesAlignSelfStretch.add(Integer.valueOf(i13));
                }
                int i15 = params2.mLayoutWidth;
                float f2 = params2.flexBasisPercent;
                if (f2 != -1.0f && mode == 1073741824) {
                    i15 = Math.round(size * f2);
                }
                reorderedChildAt.measureComponent(Layout.getChildMeasureSpec(i2, getComPaddingLeft() + getComPaddingRight() + params2.mLayoutMarginLeft + params2.mLayoutMarginRight, i15), Layout.getChildMeasureSpec(i3, getComPaddingTop() + getComPaddingBottom() + params2.mLayoutMarginTop + params2.mLayoutMarginBottom, params2.mLayoutHeight));
                checkSizeConstraints(reorderedChildAt);
                combineMeasuredStates = ViewCompat.combineMeasuredStates(i11, 0);
                int max = Math.max(i12, reorderedChildAt.getComMeasuredHeight() + params2.mLayoutMarginTop + params2.mLayoutMarginBottom);
                int i16 = mode;
                i5 = mode;
                int i17 = i13;
                FlexLine flexLine3 = flexLine2;
                if (isWrapRequired(i16, size, flexLine2.mMainSize, reorderedChildAt.getComMeasuredWidth() + params2.mLayoutMarginLeft + params2.mLayoutMarginRight, params2, i17, i14)) {
                    if (flexLine3.mItemCount > 0) {
                        addFlexLine(flexLine3);
                    }
                    flexLine2 = new FlexLine();
                    flexLine2.mItemCount = 1;
                    flexLine2.mMainSize = i10;
                    params = params2;
                    i12 = reorderedChildAt.getComMeasuredHeight() + params.mLayoutMarginTop + params.mLayoutMarginBottom;
                    i6 = 0;
                } else {
                    params = params2;
                    flexLine3.mItemCount++;
                    i6 = i14 + 1;
                    flexLine2 = flexLine3;
                    i12 = max;
                }
                flexLine2.mMainSize += reorderedChildAt.getComMeasuredWidth() + params.mLayoutMarginLeft + params.mLayoutMarginRight;
                flexLine2.mTotalFlexGrow += params.flexGrow;
                flexLine2.mTotalFlexShrink += params.flexShrink;
                flexLine2.mCrossSize = Math.max(flexLine2.mCrossSize, i12);
                i7 = i17;
                if (hasDividerBeforeChildAtAlongMainAxis(i7, i6)) {
                    int i18 = flexLine2.mMainSize;
                    int i19 = this.mDividerVerticalWidth;
                    flexLine2.mMainSize = i18 + i19;
                    flexLine2.mDividerLengthInMainSize += i19;
                }
                if (this.mFlexWrap != 2) {
                    flexLine2.mMaxBaseline = Math.max(flexLine2.mMaxBaseline, reorderedChildAt.getComBaseline() + params.mLayoutMarginTop);
                } else {
                    flexLine2.mMaxBaseline = Math.max(flexLine2.mMaxBaseline, (reorderedChildAt.getComMeasuredHeight() - reorderedChildAt.getComBaseline()) + params.mLayoutMarginBottom);
                }
                addFlexLineIfLastFlexItem(i7, size2, flexLine2);
                i14 = i6;
                i13 = i7 + 1;
                i11 = combineMeasuredStates;
                mode = i5;
            }
            combineMeasuredStates = i11;
            i7 = i13;
            i5 = mode;
            i13 = i7 + 1;
            i11 = combineMeasuredStates;
            mode = i5;
        }
        determineMainSize(this.mFlexDirection, i2, i3);
        if (this.mAlignItems == 3) {
            int i20 = 0;
            for (FlexLine flexLine4 : this.mFlexLines) {
                int i21 = i20;
                int i22 = Integer.MIN_VALUE;
                while (true) {
                    i4 = flexLine4.mItemCount + i20;
                    if (i21 < i4) {
                        ViewBase reorderedChildAt2 = getReorderedChildAt(i21);
                        Params params3 = (Params) reorderedChildAt2.getComLayoutParams();
                        i22 = this.mFlexWrap != 2 ? Math.max(i22, reorderedChildAt2.getComMeasuredHeight() + Math.max(flexLine4.mMaxBaseline - reorderedChildAt2.getComBaseline(), params3.mLayoutMarginTop) + params3.mLayoutMarginBottom) : Math.max(i22, reorderedChildAt2.getComMeasuredHeight() + params3.mLayoutMarginTop + Math.max((flexLine4.mMaxBaseline - reorderedChildAt2.getComMeasuredHeight()) + reorderedChildAt2.getComBaseline(), params3.mLayoutMarginBottom));
                        i21++;
                    }
                }
                flexLine4.mCrossSize = i22;
                i20 = i4;
            }
        }
        determineCrossSize(this.mFlexDirection, i2, i3, getComPaddingTop() + getComPaddingBottom());
        stretchViews(this.mFlexDirection, this.mAlignItems);
        setMeasuredDimensionForFlex(this.mFlexDirection, i2, i3, i11);
    }

    private void measureVertical(int i2, int i3) {
        Params params;
        int i4;
        int i5;
        int i6;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        this.mFlexLines.clear();
        int size2 = this.mSubViews.size();
        int comPaddingTop = getComPaddingTop();
        int comPaddingBottom = getComPaddingBottom();
        FlexLine flexLine = new FlexLine();
        int i7 = comPaddingTop + comPaddingBottom;
        flexLine.mMainSize = i7;
        int i8 = Integer.MIN_VALUE;
        FlexLine flexLine2 = flexLine;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i10 < size2) {
            ViewBase reorderedChildAt = getReorderedChildAt(i10);
            if (reorderedChildAt == null) {
                addFlexLineIfLastFlexItem(i10, size2, flexLine2);
            } else if (reorderedChildAt.getVisibility() == 2) {
                flexLine2.mItemCount++;
                addFlexLineIfLastFlexItem(i10, size2, flexLine2);
            } else {
                Params params2 = (Params) reorderedChildAt.getComLayoutParams();
                if (params2.alignSelf == 4) {
                    flexLine2.mIndicesAlignSelfStretch.add(Integer.valueOf(i10));
                }
                int i12 = params2.mLayoutHeight;
                float f2 = params2.flexBasisPercent;
                if (f2 != -1.0f && mode == 1073741824) {
                    i12 = Math.round(size * f2);
                }
                int i13 = i10;
                reorderedChildAt.measureComponent(Layout.getChildMeasureSpec(i2, getComPaddingLeft() + getComPaddingRight() + params2.mLayoutMarginLeft + params2.mLayoutMarginRight, params2.mLayoutWidth), Layout.getChildMeasureSpec(i3, getComPaddingTop() + getComPaddingBottom() + params2.mLayoutMarginTop + params2.mLayoutMarginBottom, i12));
                checkSizeConstraints(reorderedChildAt);
                int combineMeasuredStates = ViewCompat.combineMeasuredStates(i9, 0);
                int max = Math.max(i8, reorderedChildAt.getComMeasuredWidth() + params2.mLayoutMarginLeft + params2.mLayoutMarginRight);
                FlexLine flexLine3 = flexLine2;
                if (isWrapRequired(mode, size, flexLine2.mMainSize, reorderedChildAt.getComMeasuredHeight() + params2.mLayoutMarginTop + params2.mLayoutMarginBottom, params2, i13, i11)) {
                    if (flexLine3.mItemCount > 0) {
                        addFlexLine(flexLine3);
                    }
                    flexLine2 = new FlexLine();
                    flexLine2.mItemCount = 1;
                    flexLine2.mMainSize = i7;
                    params = params2;
                    i5 = reorderedChildAt.getComMeasuredWidth() + params.mLayoutMarginLeft + params.mLayoutMarginRight;
                    i4 = 0;
                } else {
                    params = params2;
                    flexLine3.mItemCount++;
                    flexLine2 = flexLine3;
                    i4 = i11 + 1;
                    i5 = max;
                }
                flexLine2.mMainSize += reorderedChildAt.getComMeasuredHeight() + params.mLayoutMarginTop + params.mLayoutMarginBottom;
                flexLine2.mTotalFlexGrow += params.flexGrow;
                flexLine2.mTotalFlexShrink += params.flexShrink;
                flexLine2.mCrossSize = Math.max(flexLine2.mCrossSize, i5);
                i6 = i13;
                if (hasDividerBeforeChildAtAlongMainAxis(i6, i4)) {
                    flexLine2.mMainSize += this.mDividerHorizontalHeight;
                }
                addFlexLineIfLastFlexItem(i6, size2, flexLine2);
                i11 = i4;
                i8 = i5;
                i9 = combineMeasuredStates;
                i10 = i6 + 1;
            }
            i6 = i10;
            i10 = i6 + 1;
        }
        determineMainSize(this.mFlexDirection, i2, i3);
        determineCrossSize(this.mFlexDirection, i2, i3, getComPaddingLeft() + getComPaddingRight());
        stretchViews(this.mFlexDirection, this.mAlignItems);
        setMeasuredDimensionForFlex(this.mFlexDirection, i2, i3, i9);
    }

    private void setMeasuredDimensionForFlex(int i2, int i3, int i4, int i5) {
        int sumOfCrossSize;
        int largestMainSize;
        int resolveSizeAndState;
        int resolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        if (i2 == 0 || i2 == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getComPaddingTop() + getComPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else {
            if (i2 != 2 && i2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + i2);
            }
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getComPaddingLeft() + getComPaddingRight();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i5 = ViewCompat.combineMeasuredStates(i5, 16777216);
            } else {
                size = largestMainSize;
            }
            resolveSizeAndState = ViewCompat.resolveSizeAndState(size, i3, i5);
        } else if (mode == 0) {
            resolveSizeAndState = ViewCompat.resolveSizeAndState(largestMainSize, i3, i5);
        } else {
            if (mode != 1073741824) {
                throw new IllegalStateException("Unknown width mode is set: " + mode);
            }
            if (size < largestMainSize) {
                i5 = ViewCompat.combineMeasuredStates(i5, 16777216);
            }
            resolveSizeAndState = ViewCompat.resolveSizeAndState(size, i3, i5);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i5 = ViewCompat.combineMeasuredStates(i5, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            resolveSizeAndState2 = ViewCompat.resolveSizeAndState(size2, i4, i5);
        } else if (mode2 == 0) {
            resolveSizeAndState2 = ViewCompat.resolveSizeAndState(sumOfCrossSize, i4, i5);
        } else {
            if (mode2 != 1073741824) {
                throw new IllegalStateException("Unknown height mode is set: " + mode2);
            }
            if (size2 < sumOfCrossSize) {
                i5 = ViewCompat.combineMeasuredStates(i5, 256);
            }
            resolveSizeAndState2 = ViewCompat.resolveSizeAndState(size2, i4, i5);
        }
        setComMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    private int shrinkFlexItems(FlexLine flexLine, int i2, int i3, int i4, int i5) {
        int i6 = flexLine.mMainSize;
        float f2 = flexLine.mTotalFlexShrink;
        if (f2 <= 0.0f || i3 > i6) {
            return i5 + flexLine.mItemCount;
        }
        float f3 = (i6 - i3) / f2;
        flexLine.mMainSize = i4 + flexLine.mDividerLengthInMainSize;
        int i7 = i5;
        boolean z = false;
        float f4 = 0.0f;
        for (int i8 = 0; i8 < flexLine.mItemCount; i8++) {
            ViewBase reorderedChildAt = getReorderedChildAt(i7);
            if (reorderedChildAt != null) {
                if (reorderedChildAt.getVisibility() != 2) {
                    Params params = (Params) reorderedChildAt.getComLayoutParams();
                    if (isMainAxisDirectionHorizontal(i2)) {
                        if (!this.mChildrenFrozen[i7]) {
                            float comMeasuredWidth = reorderedChildAt.getComMeasuredWidth() - (params.flexShrink * f3);
                            if (i8 == flexLine.mItemCount - 1) {
                                comMeasuredWidth += f4;
                                f4 = 0.0f;
                            }
                            int round = Math.round(comMeasuredWidth);
                            int i9 = params.minWidth;
                            if (round < i9) {
                                this.mChildrenFrozen[i7] = true;
                                flexLine.mTotalFlexShrink -= params.flexShrink;
                                round = i9;
                                z = true;
                            } else {
                                f4 += comMeasuredWidth - round;
                                double d2 = f4;
                                if (d2 > 1.0d) {
                                    round++;
                                    f4 -= 1.0f;
                                } else if (d2 < -1.0d) {
                                    round--;
                                    f4 += 1.0f;
                                }
                            }
                            reorderedChildAt.measureComponent(View.MeasureSpec.makeMeasureSpec(round, 1073741824), View.MeasureSpec.makeMeasureSpec(reorderedChildAt.getComMeasuredHeight(), 1073741824));
                        }
                        flexLine.mMainSize += reorderedChildAt.getComMeasuredWidth() + params.mLayoutMarginLeft + params.mLayoutMarginRight;
                    } else {
                        if (!this.mChildrenFrozen[i7]) {
                            float comMeasuredHeight = reorderedChildAt.getComMeasuredHeight() - (params.flexShrink * f3);
                            if (i8 == flexLine.mItemCount - 1) {
                                comMeasuredHeight += f4;
                                f4 = 0.0f;
                            }
                            int round2 = Math.round(comMeasuredHeight);
                            int i10 = params.minHeight;
                            if (round2 < i10) {
                                this.mChildrenFrozen[i7] = true;
                                flexLine.mTotalFlexShrink -= params.flexShrink;
                                round2 = i10;
                                z = true;
                            } else {
                                f4 += comMeasuredHeight - round2;
                                double d3 = f4;
                                if (d3 > 1.0d) {
                                    round2++;
                                    f4 -= 1.0f;
                                } else if (d3 < -1.0d) {
                                    round2--;
                                    f4 += 1.0f;
                                }
                            }
                            reorderedChildAt.measureComponent(View.MeasureSpec.makeMeasureSpec(reorderedChildAt.getComMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(round2, 1073741824));
                        }
                        flexLine.mMainSize += reorderedChildAt.getComMeasuredHeight() + params.mLayoutMarginTop + params.mLayoutMarginBottom;
                    }
                }
                i7++;
            }
        }
        if (z && i6 != flexLine.mMainSize) {
            shrinkFlexItems(flexLine, i2, i3, i4, i5);
        }
        return i7;
    }

    private int[] sortOrdersIntoReorderedIndices(int i2, List<Order> list) {
        Collections.sort(list);
        if (this.mOrderCache == null) {
            this.mOrderCache = new SparseIntArray(i2);
        }
        this.mOrderCache.clear();
        int[] iArr = new int[i2];
        int i3 = 0;
        for (Order order : list) {
            iArr[i3] = order.index;
            this.mOrderCache.append(i3, order.order);
            i3++;
        }
        return iArr;
    }

    private void stretchViewHorizontally(ViewBase viewBase, int i2) {
        Params params = (Params) viewBase.getComLayoutParams();
        viewBase.measureComponent(View.MeasureSpec.makeMeasureSpec(Math.max((i2 - params.mLayoutMarginLeft) - params.mLayoutMarginRight, 0), 1073741824), View.MeasureSpec.makeMeasureSpec(viewBase.getComMeasuredHeight(), 1073741824));
    }

    private void stretchViewVertically(ViewBase viewBase, int i2) {
        Params params = (Params) viewBase.getComLayoutParams();
        viewBase.measureComponent(View.MeasureSpec.makeMeasureSpec(viewBase.getComMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((i2 - params.mLayoutMarginTop) - params.mLayoutMarginBottom, 0), 1073741824));
    }

    private void stretchViews(int i2, int i3) {
        if (i3 != 4) {
            for (FlexLine flexLine : this.mFlexLines) {
                Iterator<Integer> it = flexLine.mIndicesAlignSelfStretch.iterator();
                while (it.hasNext()) {
                    ViewBase reorderedChildAt = getReorderedChildAt(it.next().intValue());
                    if (i2 == 0 || i2 == 1) {
                        stretchViewVertically(reorderedChildAt, flexLine.mCrossSize);
                    } else {
                        if (i2 != 2 && i2 != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: " + i2);
                        }
                        stretchViewHorizontally(reorderedChildAt, flexLine.mCrossSize);
                    }
                }
            }
            return;
        }
        int i4 = 0;
        for (FlexLine flexLine2 : this.mFlexLines) {
            int i5 = 0;
            while (i5 < flexLine2.mItemCount) {
                ViewBase reorderedChildAt2 = getReorderedChildAt(i4);
                int i6 = ((Params) reorderedChildAt2.getComLayoutParams()).alignSelf;
                if (i6 == -1 || i6 == 4) {
                    if (i2 == 0 || i2 == 1) {
                        stretchViewVertically(reorderedChildAt2, flexLine2.mCrossSize);
                    } else {
                        if (i2 != 2 && i2 != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: " + i2);
                        }
                        stretchViewHorizontally(reorderedChildAt2, flexLine2.mCrossSize);
                    }
                }
                i5++;
                i4++;
            }
        }
    }

    public ViewBase getReorderedChildAt(int i2) {
        if (i2 < 0) {
            return null;
        }
        int[] iArr = this.mReorderedIndices;
        if (i2 >= iArr.length) {
            return null;
        }
        return this.mSubViews.get(iArr[i2]);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6 = this.mFlexDirection;
        if (i6 == 0) {
            layoutHorizontal(false, i2, i3, i4, i5);
            return;
        }
        if (i6 == 1) {
            layoutHorizontal(true, i2, i3, i4, i5);
            return;
        }
        if (i6 == 2) {
            layoutVertical(this.mFlexWrap == 2, false, i2, i3, i4, i5);
        } else {
            if (i6 == 3) {
                layoutVertical(this.mFlexWrap == 2, true, i2, i3, i4, i5);
                return;
            }
            throw new IllegalStateException("Invalid flex direction is set: " + this.mFlexDirection);
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComMeasure(int i2, int i3) {
        int scaleWidthMeasureSpec = ViewUtils.scaleWidthMeasureSpec(i2, this.mScaleFactor, this.mParams);
        int scaleHeightMeasureSpec = ViewUtils.scaleHeightMeasureSpec(i3, this.mScaleFactor, this.mParams);
        if (isOrderChangedFromLastMeasurement()) {
            this.mReorderedIndices = createReorderedIndices();
        }
        boolean[] zArr = this.mChildrenFrozen;
        if (zArr == null || zArr.length < this.mSubViews.size()) {
            this.mChildrenFrozen = new boolean[this.mSubViews.size()];
        }
        int i4 = this.mFlexDirection;
        if (i4 == 0 || i4 == 1) {
            measureHorizontal(scaleWidthMeasureSpec, scaleHeightMeasureSpec);
        } else {
            if (i4 != 2 && i4 != 3) {
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.mFlexDirection);
            }
            measureVertical(scaleWidthMeasureSpec, scaleHeightMeasureSpec);
        }
        Arrays.fill(this.mChildrenFrozen, false);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.Layout, com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, int i3) {
        boolean attribute = super.setAttribute(i2, i3);
        if (attribute) {
            return attribute;
        }
        switch (i2) {
            case StringBase.STR_ID_alignItems /* -1063257157 */:
                this.mAlignItems = i3;
                return true;
            case StringBase.STR_ID_flexDirection /* -975171706 */:
                this.mFlexDirection = i3;
                return true;
            case StringBase.STR_ID_alignContent /* -752601676 */:
                this.mAlignContent = i3;
                return true;
            case StringBase.STR_ID_flexWrap /* 1744216035 */:
                this.mFlexWrap = i3;
                return true;
            case StringBase.STR_ID_justifyContent /* 1860657097 */:
                this.mJustifyContent = i3;
                return true;
            default:
                return false;
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.Layout
    public Params generateParams(ViewFactory viewFactory) {
        return new Params(viewFactory);
    }

    public static class Params extends Layout.Params {
        public static final int ALIGN_SELF_AUTO = -1;
        public static final int ALIGN_SELF_BASELINE = 3;
        public static final int ALIGN_SELF_CENTER = 2;
        public static final int ALIGN_SELF_FLEX_END = 1;
        public static final int ALIGN_SELF_FLEX_START = 0;
        public static final int ALIGN_SELF_STRETCH = 4;
        public static final float FLEX_BASIS_PERCENT_DEFAULT = -1.0f;
        private static final float FLEX_GROW_DEFAULT = 0.0f;
        private static final float FLEX_SHRINK_DEFAULT = 1.0f;
        private static final int MAX_SIZE = 16777215;
        private static final int ORDER_DEFAULT = 1;
        public int alignSelf;
        public float flexBasisPercent;
        public float flexGrow;
        public float flexShrink;
        public int maxHeight;
        public int maxWidth;
        public int minHeight;
        public int minWidth;
        public int order;
        public boolean wrapBefore;

        public Params(ViewFactory viewFactory) {
            super(viewFactory);
            this.order = 1;
            this.flexGrow = 0.0f;
            this.flexShrink = 1.0f;
            this.alignSelf = -1;
            this.flexBasisPercent = -1.0f;
            this.maxWidth = 16777215;
            this.maxHeight = 16777215;
            this.order = 1;
            this.flexGrow = 0.0f;
            this.flexShrink = 1.0f;
            this.alignSelf = -1;
            this.flexBasisPercent = -1.0f;
            this.minWidth = 0;
            this.minHeight = 0;
            this.maxWidth = 16777215;
            this.maxHeight = 16777215;
            this.wrapBefore = false;
        }

        @Override // com.vivo.advv.vaf.virtualview.core.Layout.Params
        public boolean setAttribute(int i2, int i3) {
            boolean attribute = super.setAttribute(i2, i3);
            if (attribute) {
                return attribute;
            }
            if (i2 != 1743739820) {
                return false;
            }
            this.flexGrow = i3;
            return true;
        }

        public Params(Params params, ViewFactory viewFactory) {
            super(viewFactory);
            this.order = 1;
            this.flexGrow = 0.0f;
            this.flexShrink = 1.0f;
            this.alignSelf = -1;
            this.flexBasisPercent = -1.0f;
            this.maxWidth = 16777215;
            this.maxHeight = 16777215;
            this.order = params.order;
            this.flexGrow = params.flexGrow;
            this.flexShrink = params.flexShrink;
            this.alignSelf = params.alignSelf;
            this.flexBasisPercent = params.flexBasisPercent;
            this.minWidth = params.minWidth;
            this.minHeight = params.minHeight;
            this.maxWidth = params.maxWidth;
            this.maxHeight = params.maxHeight;
            this.wrapBefore = params.wrapBefore;
        }
    }
}
