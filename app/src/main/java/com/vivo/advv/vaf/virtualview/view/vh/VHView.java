package com.vivo.advv.vaf.virtualview.view.vh;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.vivo.advv.vaf.virtualview.util.VVLog;

/* loaded from: classes4.dex */
public class VHView extends ViewGroup {
    private static final String TAG = "VHView_TMTEST";
    protected int mItemCount;
    protected int mItemHeight;
    protected int mItemMargin;
    protected int mItemWidth;
    protected int mOrientation;

    public VHView(Context context) {
        super(context);
        this.mOrientation = 1;
        this.mItemMargin = 0;
        this.mItemWidth = 0;
        this.mItemHeight = 0;
        this.mItemCount = 0;
    }

    private void layoutHorizontal(boolean z, int i2, int i3, int i4, int i5) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i6 = this.mItemHeight + paddingTop;
        for (int i7 = 0; i7 < this.mItemCount; i7++) {
            getChildAt(i7).layout(paddingLeft, paddingTop, this.mItemWidth + paddingLeft, i6);
            paddingLeft += this.mItemWidth + this.mItemMargin;
        }
    }

    private void layoutVertical(boolean z, int i2, int i3, int i4, int i5) {
        int paddingLeft = getPaddingLeft();
        int i6 = this.mItemWidth + paddingLeft;
        int paddingTop = getPaddingTop();
        for (int i7 = 0; i7 < this.mItemCount; i7++) {
            getChildAt(i7).layout(paddingLeft, paddingTop, i6, this.mItemHeight + paddingTop);
            paddingTop += this.mItemHeight + this.mItemMargin;
        }
    }

    private void measureHorizontal(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        if (this.mItemHeight == 0) {
            this.mItemHeight = (View.MeasureSpec.getSize(i3) - getPaddingTop()) - getPaddingBottom();
        }
        if (this.mItemWidth == 0) {
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int i4 = this.mItemMargin;
            int i5 = this.mItemCount;
            int i6 = paddingLeft + (i4 * (i5 - 1));
            if (i5 > 1) {
                this.mItemWidth = (size - i6) / i5;
            } else {
                this.mItemWidth = size - i6;
            }
        } else if (this.mItemCount > 0) {
            int paddingLeft2 = getPaddingLeft() + getPaddingRight();
            int i7 = this.mItemMargin;
            int i8 = this.mItemWidth;
            size = paddingLeft2 + ((i7 + i8) * (this.mItemCount - 1)) + i8;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mItemWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.mItemHeight, 1073741824);
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            getChildAt(i9).measure(makeMeasureSpec, makeMeasureSpec2);
        }
        setMeasuredDimension(size, this.mItemHeight + getPaddingTop() + getPaddingBottom());
    }

    private void measureVertical(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        if (this.mItemWidth == 0) {
            this.mItemWidth = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
        }
        if (this.mItemHeight == 0) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int i4 = this.mItemMargin;
            int i5 = this.mItemCount;
            int i6 = paddingTop + (i4 * (i5 - 1));
            if (i5 > 1) {
                this.mItemHeight = (size - i6) / i5;
            } else {
                this.mItemHeight = size - i6;
            }
        } else if (this.mItemCount > 0) {
            int paddingTop2 = getPaddingTop() + getPaddingBottom();
            int i7 = this.mItemMargin;
            int i8 = this.mItemHeight;
            size = paddingTop2 + ((i7 + i8) * (this.mItemCount - 1)) + i8;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mItemWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.mItemHeight, 1073741824);
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            getChildAt(i9).measure(makeMeasureSpec, makeMeasureSpec2);
        }
        setMeasuredDimension(this.mItemWidth + getPaddingLeft() + getPaddingRight(), size);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6 = this.mOrientation;
        if (i6 == 0) {
            layoutVertical(z, i2, i3, i4, i5);
            return;
        }
        if (i6 == 1) {
            layoutHorizontal(z, i2, i3, i4, i5);
            return;
        }
        VVLog.e(TAG, "onLayout invalidate orientation:" + this.mOrientation);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        this.mItemCount = getChildCount();
        int i4 = this.mOrientation;
        if (i4 == 0) {
            measureVertical(i2, i3);
            return;
        }
        if (i4 == 1) {
            measureHorizontal(i2, i3);
            return;
        }
        VVLog.e(TAG, "onMeasure invalidate orientation:" + this.mOrientation);
    }

    public void setItemHeight(int i2) {
        this.mItemHeight = i2;
    }

    public void setItemMargin(int i2) {
        this.mItemMargin = i2;
    }

    public void setItemWidth(int i2) {
        this.mItemWidth = i2;
    }

    public void setOrientation(int i2) {
        this.mOrientation = i2;
    }
}
