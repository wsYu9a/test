package com.vivo.advv.vaf.virtualview.view.grid;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.vivo.advv.vaf.virtualview.Helper.RtlHelper;

/* loaded from: classes4.dex */
public class GridView extends ViewGroup {
    protected static final int DEFAULT_COLUMN_COUNT = 2;
    protected static final int DEFAULT_ITEM_HEIGHT = 0;
    private static final String TAG = "GridView_TMTEST";
    protected int mAutoDimDirection;
    protected float mAutoDimX;
    protected float mAutoDimY;
    protected int mCalItemHeight;
    protected int mColumnCount;
    protected int mItemHeight;
    protected int mItemHorizontalMargin;
    protected int mItemVerticalMargin;
    protected int mItemWidth;
    protected int mRowCount;

    public GridView(Context context) {
        super(context);
        this.mColumnCount = 2;
        this.mItemHeight = 0;
        this.mItemHorizontalMargin = 0;
        this.mItemVerticalMargin = 0;
        this.mAutoDimDirection = 0;
        this.mAutoDimX = 1.0f;
        this.mAutoDimY = 1.0f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int i6 = 0;
        for (int i7 = 0; i7 < this.mRowCount; i7++) {
            int i8 = paddingLeft;
            for (int i9 = 0; i9 < this.mColumnCount && i6 < childCount; i9++) {
                View childAt = getChildAt(i6);
                int realLeft = RtlHelper.getRealLeft(RtlHelper.isRtl(), 0, i4 - i2, i8, this.mItemWidth);
                childAt.layout(realLeft, paddingTop, this.mItemWidth + realLeft, this.mCalItemHeight + paddingTop);
                i6++;
                i8 += this.mItemWidth + this.mItemHorizontalMargin;
            }
            paddingTop += this.mCalItemHeight + this.mItemVerticalMargin;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a2 A[LOOP:0: B:17:0x00a0->B:18:0x00a2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ce  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r9, int r10) {
        /*
            r8 = this;
            int r0 = r8.mAutoDimDirection
            r1 = 1
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 <= 0) goto L3c
            if (r0 == r1) goto L25
            r3 = 2
            if (r0 == r3) goto Ld
            goto L3c
        Ld:
            int r0 = android.view.View.MeasureSpec.getMode(r10)
            if (r2 != r0) goto L3c
            int r9 = android.view.View.MeasureSpec.getSize(r10)
            float r9 = (float) r9
            float r0 = r8.mAutoDimX
            float r9 = r9 * r0
            float r0 = r8.mAutoDimY
            float r9 = r9 / r0
            int r9 = (int) r9
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r2)
            goto L3c
        L25:
            int r0 = android.view.View.MeasureSpec.getMode(r9)
            if (r2 != r0) goto L3c
            int r10 = android.view.View.MeasureSpec.getSize(r9)
            float r10 = (float) r10
            float r0 = r8.mAutoDimY
            float r10 = r10 * r0
            float r0 = r8.mAutoDimX
            float r10 = r10 / r0
            int r10 = (int) r10
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r2)
        L3c:
            int r0 = android.view.View.MeasureSpec.getSize(r9)
            int r3 = android.view.View.MeasureSpec.getSize(r10)
            android.view.View.MeasureSpec.getMode(r9)
            int r9 = android.view.View.MeasureSpec.getMode(r10)
            int r4 = r8.getPaddingLeft()
            int r5 = r8.getPaddingRight()
            int r4 = r4 + r5
            int r5 = r8.mItemHorizontalMargin
            int r6 = r8.mColumnCount
            int r6 = r6 - r1
            int r5 = r5 * r6
            int r4 = r4 + r5
            int r5 = r8.getChildCount()
            int r4 = r0 - r4
            int r6 = r8.mColumnCount
            int r4 = r4 / r6
            r8.mItemWidth = r4
            int r4 = r8.mItemHeight
            r6 = 0
            if (r4 > 0) goto L91
            if (r5 <= 0) goto L83
            android.view.View r4 = r8.getChildAt(r6)
            int r7 = r8.mItemWidth
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r2)
            r4.measure(r7, r10)
            int r10 = r4.getMeasuredHeight()
            r8.mCalItemHeight = r10
            r10 = 1
            goto L94
        L83:
            int r10 = r8.getPaddingTop()
            int r10 = r3 - r10
            int r4 = r8.getPaddingBottom()
            int r10 = r10 - r4
            r8.mCalItemHeight = r10
            goto L93
        L91:
            r8.mCalItemHeight = r4
        L93:
            r10 = 0
        L94:
            int r4 = r8.mItemWidth
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r2)
            int r7 = r8.mCalItemHeight
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r2)
        La0:
            if (r10 >= r5) goto Lac
            android.view.View r7 = r8.getChildAt(r10)
            r7.measure(r4, r2)
            int r10 = r10 + 1
            goto La0
        Lac:
            int r10 = r8.mColumnCount
            int r2 = r5 / r10
            int r5 = r5 % r10
            if (r5 <= 0) goto Lb4
            r6 = 1
        Lb4:
            int r2 = r2 + r6
            r8.mRowCount = r2
            int r10 = r8.mCalItemHeight
            int r10 = r10 * r2
            int r2 = r2 - r1
            int r1 = r8.mItemVerticalMargin
            int r2 = r2 * r1
            int r10 = r10 + r2
            int r1 = r8.getPaddingTop()
            int r10 = r10 + r1
            int r1 = r8.getPaddingBottom()
            int r10 = r10 + r1
            if (r9 != 0) goto Lce
            goto Ld2
        Lce:
            int r10 = java.lang.Math.min(r3, r10)
        Ld2:
            r8.setMeasuredDimension(r0, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.advv.vaf.virtualview.view.grid.GridView.onMeasure(int, int):void");
    }

    public void setAutoDimDirection(int i2) {
        this.mAutoDimDirection = i2;
    }

    public void setAutoDimX(float f2) {
        this.mAutoDimX = f2;
    }

    public void setAutoDimY(float f2) {
        this.mAutoDimY = f2;
    }

    public void setColumnCount(int i2) {
        this.mColumnCount = i2;
    }

    public void setItemHeight(int i2) {
        this.mItemHeight = i2;
    }

    public void setItemHorizontalMargin(int i2) {
        this.mItemHorizontalMargin = i2;
    }

    public void setItemVerticalMargin(int i2) {
        this.mItemVerticalMargin = i2;
    }
}
