package com.vivo.advv.vaf.virtualview.layout;

import android.view.View;
import com.vivo.advv.Utils;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.Helper.RtlHelper;
import com.vivo.advv.vaf.virtualview.core.Layout;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import com.vivo.advv.vaf.virtualview.util.ViewUtils;
import com.vivo.advv.virtualview.common.StringBase;

/* loaded from: classes4.dex */
public class GridLayout extends Layout {
    private static final String TAG = "GridLayout_TMTEST";
    protected int mColCount;
    protected int mItemHeight;
    protected int mItemHorizontalMargin;
    protected int mItemVerticalMargin;
    protected int mItemWidth;

    public static class Builder implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new GridLayout(vafContext, viewCache);
        }
    }

    public GridLayout(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        this.mItemHorizontalMargin = 0;
        this.mItemVerticalMargin = 0;
        this.mColCount = 1;
        this.mItemHeight = -1;
    }

    private int getRealHeight(int i2, int i3) {
        int comMeasuredHeight;
        int i4;
        int i5;
        if (i2 != Integer.MIN_VALUE && i2 != 0) {
            return i3;
        }
        int i6 = 0;
        if (this.mSubViews.size() > 0) {
            int size = this.mSubViews.size();
            int i7 = this.mColCount;
            int i8 = (size / i7) + (size % i7 > 0 ? 1 : 0);
            int i9 = this.mItemHeight;
            if (i9 > 0) {
                comMeasuredHeight = (i9 * i8) + this.mPaddingTop + this.mPaddingBottom;
                i4 = i8 - 1;
                i5 = this.mItemVerticalMargin;
            } else {
                comMeasuredHeight = (this.mSubViews.get(0).getComMeasuredHeight() * i8) + this.mPaddingTop + this.mPaddingBottom;
                i4 = i8 - 1;
                i5 = this.mItemVerticalMargin;
            }
            i6 = comMeasuredHeight + (i4 * i5);
        }
        return Integer.MIN_VALUE == i2 ? Math.min(i3, i6) : i6;
    }

    private int getRealWidth(int i2, int i3) {
        if (Integer.MIN_VALUE != i2) {
            if (1073741824 == i2) {
                return i3;
            }
            VVLog.e(TAG, "getRealWidth error mode:" + i2);
            return i3;
        }
        int i4 = this.mPaddingLeft + this.mPaddingRight;
        int size = this.mSubViews.size();
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            i4 += this.mSubViews.get(i6).getComMeasuredWidthWithMargin();
            i5++;
            if (i5 >= this.mColCount) {
                break;
            }
            i4 += this.mItemHorizontalMargin;
        }
        return Math.min(i3, i4);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.mSubViews.size() > 0) {
            int i6 = this.mPaddingLeft + i2;
            int i7 = i3 + this.mPaddingTop;
            int size = this.mSubViews.size();
            ViewBase viewBase = this.mSubViews.get(0);
            getComMeasuredWidth();
            int comMeasuredWidth = viewBase.getComMeasuredWidth();
            int comMeasuredHeight = viewBase.getComMeasuredHeight();
            int i8 = this.mColCount;
            int i9 = (size / i8) + (size % i8 > 0 ? 1 : 0);
            int i10 = 0;
            for (int i11 = 0; i11 < i9; i11++) {
                int i12 = i6;
                int i13 = 0;
                while (i13 < this.mColCount && i10 < size) {
                    int i14 = i10 + 1;
                    ViewBase viewBase2 = this.mSubViews.get(i10);
                    if (!viewBase2.isGone()) {
                        int realLeft = RtlHelper.getRealLeft(isRtl(), i2, getWidth(), i12, comMeasuredWidth);
                        viewBase2.comLayout(realLeft, i7, realLeft + comMeasuredWidth, i7 + comMeasuredHeight);
                        i12 += this.mItemHorizontalMargin + comMeasuredWidth;
                    }
                    i13++;
                    i10 = i14;
                }
                int i15 = this.mItemHeight;
                i7 += i15 > 0 ? i15 + this.mItemVerticalMargin : this.mItemVerticalMargin + comMeasuredHeight;
            }
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComMeasure(int i2, int i3) {
        int scaleWidthMeasureSpec = ViewUtils.scaleWidthMeasureSpec(i2, this.mScaleFactor, this.mParams);
        int scaleHeightMeasureSpec = ViewUtils.scaleHeightMeasureSpec(i3, this.mScaleFactor, this.mParams);
        int i4 = this.mAutoDimDirection;
        if (i4 > 0) {
            if (i4 != 1) {
                if (i4 == 2 && 1073741824 == View.MeasureSpec.getMode(scaleHeightMeasureSpec)) {
                    scaleWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(scaleHeightMeasureSpec) * this.mAutoDimX) / this.mAutoDimY), 1073741824);
                }
            } else if (1073741824 == View.MeasureSpec.getMode(scaleWidthMeasureSpec)) {
                scaleHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(scaleWidthMeasureSpec) * this.mAutoDimY) / this.mAutoDimX), 1073741824);
            }
        }
        int size = View.MeasureSpec.getSize(scaleWidthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(scaleHeightMeasureSpec);
        int mode = View.MeasureSpec.getMode(scaleWidthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(scaleHeightMeasureSpec);
        int i5 = this.mPaddingLeft + this.mPaddingRight;
        int i6 = this.mItemHorizontalMargin;
        int i7 = this.mColCount;
        this.mItemWidth = (size - (i5 + (i6 * (i7 - 1)))) / i7;
        int size3 = this.mSubViews.size();
        for (int i8 = 0; i8 < size3; i8++) {
            ViewBase viewBase = this.mSubViews.get(i8);
            if (!viewBase.isGone()) {
                if (this.mItemHeight > 0) {
                    viewBase.measureComponent(View.MeasureSpec.makeMeasureSpec(this.mItemWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mItemHeight, 1073741824));
                } else {
                    Layout.Params comLayoutParams = viewBase.getComLayoutParams();
                    viewBase.measureComponent(View.MeasureSpec.makeMeasureSpec(this.mItemWidth, 1073741824), Layout.getChildMeasureSpec(scaleHeightMeasureSpec, this.mPaddingLeft + this.mPaddingRight + (this.mBorderWidth << 1) + comLayoutParams.mLayoutMarginLeft + comLayoutParams.mLayoutMarginRight, comLayoutParams.mLayoutHeight));
                }
            }
        }
        setComMeasuredDimension(getRealWidth(mode, size), getRealHeight(mode2, size2));
    }

    @Override // com.vivo.advv.vaf.virtualview.core.Layout, com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, float f2) {
        boolean attribute = super.setAttribute(i2, f2);
        if (attribute) {
            return attribute;
        }
        if (i2 == 196203191) {
            this.mItemVerticalMargin = Utils.dp2px(f2);
            return true;
        }
        if (i2 == 1671241242) {
            this.mItemHeight = Utils.dp2px(Math.round(f2));
            return true;
        }
        if (i2 != 2129234981) {
            return false;
        }
        this.mItemHorizontalMargin = Utils.dp2px(f2);
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.Layout, com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setRPAttribute(int i2, float f2) {
        boolean rPAttribute = super.setRPAttribute(i2, f2);
        if (rPAttribute) {
            return rPAttribute;
        }
        if (i2 == 196203191) {
            this.mItemVerticalMargin = rp2px(f2);
            return true;
        }
        if (i2 == 1671241242) {
            this.mItemHeight = rp2px(f2);
            return true;
        }
        if (i2 != 2129234981) {
            return false;
        }
        this.mItemHorizontalMargin = rp2px(f2);
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.Layout, com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, int i3) {
        boolean attribute = super.setAttribute(i2, i3);
        if (attribute) {
            return attribute;
        }
        if (i2 == -669528209) {
            this.mColCount = i3;
            return true;
        }
        if (i2 == 196203191) {
            this.mItemVerticalMargin = Utils.dp2px(i3);
            return true;
        }
        if (i2 == 1671241242) {
            this.mItemHeight = Utils.dp2px(i3);
            return true;
        }
        if (i2 != 2129234981) {
            return false;
        }
        this.mItemHorizontalMargin = Utils.dp2px(i3);
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.Layout, com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setRPAttribute(int i2, int i3) {
        boolean rPAttribute = super.setRPAttribute(i2, i3);
        if (rPAttribute) {
            return rPAttribute;
        }
        if (i2 == 196203191) {
            this.mItemVerticalMargin = rp2px(i3);
            return true;
        }
        if (i2 == 1671241242) {
            this.mItemHeight = rp2px(i3);
            return true;
        }
        if (i2 != 2129234981) {
            return false;
        }
        this.mItemHorizontalMargin = rp2px(i3);
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.Layout, com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, String str) {
        if (i2 == 196203191) {
            this.mViewCache.put(this, StringBase.STR_ID_itemVerticalMargin, str, 1);
            return true;
        }
        if (i2 != 2129234981) {
            return super.setAttribute(i2, str);
        }
        this.mViewCache.put(this, StringBase.STR_ID_itemHorizontalMargin, str, 1);
        return true;
    }
}
