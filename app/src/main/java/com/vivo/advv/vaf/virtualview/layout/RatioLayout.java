package com.vivo.advv.vaf.virtualview.layout;

import android.view.View;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.Helper.RtlHelper;
import com.vivo.advv.vaf.virtualview.ViewFactory;
import com.vivo.advv.vaf.virtualview.core.Layout;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import com.vivo.advv.vaf.virtualview.util.ViewUtils;

/* loaded from: classes4.dex */
public class RatioLayout extends Layout {
    private static final String TAG = "RatioLayout_TMTEST";
    protected int mFixDim;
    protected int mMeasureChildrenHeight;
    protected int mMeasureChildrenWidth;
    protected int mOrientation;
    protected int mTotalRatio;

    public static class Builder implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new RatioLayout(vafContext, viewCache);
        }
    }

    public RatioLayout(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        this.mOrientation = 1;
        this.mMeasureChildrenWidth = 0;
        this.mMeasureChildrenHeight = 0;
    }

    private void findTotalRatio() {
        this.mTotalRatio = 0;
        int size = this.mSubViews.size();
        for (int i2 = 0; i2 < size; i2++) {
            ViewBase viewBase = this.mSubViews.get(i2);
            if (!viewBase.isGone()) {
                this.mTotalRatio = (int) (this.mTotalRatio + ((Params) viewBase.getComLayoutParams()).mLayoutRatio);
            }
        }
    }

    private int getRealHeight(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int comMeasuredHeightWithMargin;
        int comMeasuredHeightWithMargin2;
        int i7 = 0;
        if (Integer.MIN_VALUE == i2) {
            if (1 != this.mOrientation) {
                return i3;
            }
            int size = this.mSubViews.size();
            int i8 = 0;
            while (i7 < size) {
                ViewBase viewBase = this.mSubViews.get(i7);
                if (!viewBase.isGone() && (comMeasuredHeightWithMargin2 = viewBase.getComMeasuredHeightWithMargin()) > i8) {
                    i8 = comMeasuredHeightWithMargin2;
                }
                i7++;
            }
            this.mMeasureChildrenHeight = i8;
            return Math.min(i3, i8 + this.mPaddingTop + this.mPaddingBottom + (this.mBorderWidth << 1));
        }
        if (1073741824 == i2) {
            return i3;
        }
        int i9 = this.mOrientation;
        if (1 == i9) {
            int size2 = this.mSubViews.size();
            i4 = 0;
            while (i7 < size2) {
                ViewBase viewBase2 = this.mSubViews.get(i7);
                if (!viewBase2.isGone() && (comMeasuredHeightWithMargin = viewBase2.getComMeasuredHeightWithMargin()) > i4) {
                    i4 = comMeasuredHeightWithMargin;
                }
                i7++;
            }
            this.mMeasureChildrenHeight = i4;
            i5 = this.mPaddingTop + this.mPaddingBottom;
            i6 = this.mBorderWidth;
        } else {
            if (i9 != 0) {
                return i3;
            }
            int size3 = this.mSubViews.size();
            i4 = 0;
            while (i7 < size3) {
                ViewBase viewBase3 = this.mSubViews.get(i7);
                if (!viewBase3.isGone()) {
                    i4 += viewBase3.getComMeasuredHeightWithMargin();
                }
                i7++;
            }
            i5 = this.mPaddingTop + this.mPaddingBottom;
            i6 = this.mBorderWidth;
        }
        return i4 + i5 + (i6 << 1);
    }

    private int getRealWidth(int i2, int i3) {
        int comMeasuredWidthWithMargin;
        if (Integer.MIN_VALUE != i2) {
            if (1073741824 == i2) {
                return i3;
            }
            VVLog.e(TAG, "getRealWidth error mode:" + i2);
            return i3;
        }
        int i4 = this.mOrientation;
        if (1 == i4 || i4 != 0) {
            return i3;
        }
        int size = this.mSubViews.size();
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            ViewBase viewBase = this.mSubViews.get(i6);
            if (!viewBase.isGone() && (comMeasuredWidthWithMargin = viewBase.getComMeasuredWidthWithMargin()) > i5) {
                i5 = comMeasuredWidthWithMargin;
            }
        }
        this.mMeasureChildrenWidth = i5;
        return Math.min(i3, i5 + this.mPaddingLeft + this.mPaddingRight + (this.mBorderWidth << 1));
    }

    private void measureHorizontal(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        this.mFixDim = 0;
        findTotalRatio();
        int size3 = this.mSubViews.size();
        boolean z = false;
        for (int i4 = 0; i4 < size3; i4++) {
            ViewBase viewBase = this.mSubViews.get(i4);
            if (!viewBase.isGone()) {
                Params params = (Params) viewBase.getComLayoutParams();
                if ((1073741824 != mode2 && -1 == params.mLayoutHeight) || params.mLayoutRatio > 0.0f) {
                    z = true;
                }
                measureHorizontalRatioComChild(viewBase, i2, i3);
                if (params.mLayoutRatio <= 0.0f) {
                    this.mFixDim += viewBase.getComMeasuredWidthWithMargin();
                } else {
                    this.mFixDim += params.mLayoutMarginLeft + params.mLayoutMarginRight;
                }
            }
        }
        setComMeasuredDimension(getRealWidth(mode, size), getRealHeight(mode2, size2));
        if (z) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getComMeasuredWidth(), 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getComMeasuredHeight(), 1073741824);
            int size4 = this.mSubViews.size();
            for (int i5 = 0; i5 < size4; i5++) {
                ViewBase viewBase2 = this.mSubViews.get(i5);
                if (!viewBase2.isGone()) {
                    Params params2 = (Params) viewBase2.getComLayoutParams();
                    if (-1 == params2.mLayoutHeight || params2.mLayoutRatio > 0.0f) {
                        measureHorizontalRatioComChild(viewBase2, makeMeasureSpec, makeMeasureSpec2);
                    }
                }
            }
        }
    }

    private final void measureVertical(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        this.mFixDim = 0;
        findTotalRatio();
        int size3 = this.mSubViews.size();
        boolean z = false;
        for (int i4 = 0; i4 < size3; i4++) {
            ViewBase viewBase = this.mSubViews.get(i4);
            if (!viewBase.isGone()) {
                Params params = (Params) viewBase.getComLayoutParams();
                if ((1073741824 != mode && -1 == params.mLayoutWidth) || params.mLayoutRatio > 0.0f) {
                    z = true;
                }
                measureVerticalRatioComChild(viewBase, i2, i3);
                if (params.mLayoutRatio <= 0.0f) {
                    this.mFixDim += viewBase.getComMeasuredHeightWithMargin();
                } else {
                    this.mFixDim += params.mLayoutMarginTop + params.mLayoutMarginBottom;
                }
            }
        }
        setComMeasuredDimension(getRealWidth(mode, size), getRealHeight(mode2, size2));
        if (z) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getComMeasuredWidth(), 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getComMeasuredHeight(), 1073741824);
            int size4 = this.mSubViews.size();
            for (int i5 = 0; i5 < size4; i5++) {
                ViewBase viewBase2 = this.mSubViews.get(i5);
                if (!viewBase2.isGone()) {
                    Params params2 = (Params) viewBase2.getComLayoutParams();
                    if (-1 == params2.mLayoutWidth || params2.mLayoutRatio > 0.0f) {
                        measureVerticalRatioComChild(viewBase2, makeMeasureSpec, makeMeasureSpec2);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
    
        if (r5 >= 0) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected int getRatioChildMeasureSpec(int r3, int r4, int r5, float r6) {
        /*
            r2 = this;
            int r0 = android.view.View.MeasureSpec.getMode(r3)
            int r3 = android.view.View.MeasureSpec.getSize(r3)
            int r3 = r3 - r4
            int r4 = r2.mFixDim
            int r3 = r3 - r4
            r4 = 0
            int r3 = java.lang.Math.max(r4, r3)
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 == r1) goto L16
            goto L2e
        L16:
            r0 = 0
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 <= 0) goto L29
            float r3 = (float) r3
            float r6 = r6 * r3
            int r3 = r2.mTotalRatio
            float r3 = (float) r3
            float r6 = r6 / r3
            int r3 = (int) r6
            if (r3 >= 0) goto L27
            r5 = 0
            goto L2b
        L27:
            r5 = r3
            goto L2b
        L29:
            if (r5 < 0) goto L2e
        L2b:
            r4 = 1073741824(0x40000000, float:2.0)
            goto L2f
        L2e:
            r5 = 0
        L2f:
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.advv.vaf.virtualview.layout.RatioLayout.getRatioChildMeasureSpec(int, int, int, float):int");
    }

    protected void measureHorizontalRatioComChild(ViewBase viewBase, int i2, int i3) {
        Params params = (Params) viewBase.getComLayoutParams();
        int childMeasureSpec = Layout.getChildMeasureSpec(i3, this.mPaddingTop + this.mPaddingBottom + (this.mBorderWidth << 1) + params.mLayoutMarginTop + params.mLayoutMarginBottom, params.mLayoutHeight);
        float f2 = params.mLayoutRatio;
        viewBase.measureComponent(f2 > 0.0f ? getRatioChildMeasureSpec(i2, this.mPaddingLeft + this.mPaddingRight + (this.mBorderWidth << 1), params.mLayoutWidth, f2) : Layout.getChildMeasureSpec(i2, this.mPaddingLeft + this.mPaddingRight + (this.mBorderWidth << 1) + params.mLayoutMarginLeft + params.mLayoutMarginRight, params.mLayoutWidth), childMeasureSpec);
    }

    protected void measureVerticalRatioComChild(ViewBase viewBase, int i2, int i3) {
        Params params = (Params) viewBase.getComLayoutParams();
        int childMeasureSpec = Layout.getChildMeasureSpec(i2, this.mPaddingLeft + this.mPaddingRight + (this.mBorderWidth << 1) + params.mLayoutMarginLeft + params.mLayoutMarginRight, params.mLayoutWidth);
        float f2 = params.mLayoutRatio;
        viewBase.measureComponent(childMeasureSpec, f2 > 0.0f ? getRatioChildMeasureSpec(i3, this.mPaddingTop + this.mPaddingBottom + (this.mBorderWidth << 1), params.mLayoutHeight, f2) : Layout.getChildMeasureSpec(i3, this.mPaddingTop + this.mPaddingBottom + (this.mBorderWidth << 1) + params.mLayoutMarginTop + params.mLayoutMarginBottom, params.mLayoutHeight));
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6 = this.mOrientation;
        int i7 = 0;
        if (i6 == 0) {
            int i8 = i3 + this.mPaddingTop + this.mBorderWidth;
            int size = this.mSubViews.size();
            while (i7 < size) {
                ViewBase viewBase = this.mSubViews.get(i7);
                if (!viewBase.isGone()) {
                    Params params = (Params) viewBase.getComLayoutParams();
                    int comMeasuredWidth = viewBase.getComMeasuredWidth();
                    int comMeasuredHeight = viewBase.getComMeasuredHeight();
                    int i9 = i8 + params.mLayoutMarginTop;
                    int i10 = params.mLayoutGravity;
                    int realLeft = RtlHelper.getRealLeft(isRtl(), i2, getWidth(), (i10 & 4) != 0 ? ((i4 + i2) - comMeasuredWidth) >> 1 : (i10 & 2) != 0 ? (((i4 - this.mPaddingRight) - this.mBorderWidth) - params.mLayoutMarginRight) - comMeasuredWidth : this.mPaddingLeft + i2 + this.mBorderWidth + params.mLayoutMarginLeft, comMeasuredWidth);
                    viewBase.comLayout(realLeft, i9, comMeasuredWidth + realLeft, i9 + comMeasuredHeight);
                    i8 = i9 + comMeasuredHeight + params.mLayoutMarginBottom;
                }
                i7++;
            }
            return;
        }
        if (i6 != 1) {
            return;
        }
        int i11 = this.mPaddingLeft + i2 + this.mBorderWidth;
        int size2 = this.mSubViews.size();
        while (i7 < size2) {
            ViewBase viewBase2 = this.mSubViews.get(i7);
            if (!viewBase2.isGone()) {
                Params params2 = (Params) viewBase2.getComLayoutParams();
                int comMeasuredWidth2 = viewBase2.getComMeasuredWidth();
                int comMeasuredHeight2 = viewBase2.getComMeasuredHeight();
                int i12 = i11 + params2.mLayoutMarginLeft;
                int i13 = params2.mLayoutGravity;
                int i14 = (i13 & 32) != 0 ? ((i5 + i3) - comMeasuredHeight2) >> 1 : (i13 & 16) != 0 ? (((i5 - comMeasuredHeight2) - this.mPaddingBottom) - this.mBorderWidth) - params2.mLayoutMarginBottom : this.mPaddingTop + i3 + this.mBorderWidth + params2.mLayoutMarginTop;
                int realLeft2 = RtlHelper.getRealLeft(isRtl(), i2, getWidth(), i12, comMeasuredWidth2);
                viewBase2.comLayout(realLeft2, i14, realLeft2 + comMeasuredWidth2, comMeasuredHeight2 + i14);
                i11 = i12 + comMeasuredWidth2 + params2.mLayoutMarginRight;
            }
            i7++;
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
        int i5 = this.mOrientation;
        if (i5 == 0) {
            measureVertical(scaleWidthMeasureSpec, scaleHeightMeasureSpec);
        } else {
            if (i5 != 1) {
                return;
            }
            measureHorizontal(scaleWidthMeasureSpec, scaleHeightMeasureSpec);
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.Layout, com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, int i3) {
        boolean attribute = super.setAttribute(i2, i3);
        if (attribute) {
            return attribute;
        }
        if (i2 != -1439500848) {
            return false;
        }
        this.mOrientation = i3;
        return true;
    }

    public static class Params extends Layout.Params {
        public int mLayoutGravity;
        public float mLayoutRatio;

        public Params(ViewFactory viewFactory) {
            super(viewFactory);
            this.mLayoutRatio = 0.0f;
        }

        @Override // com.vivo.advv.vaf.virtualview.core.Layout.Params
        public boolean setAttribute(int i2, float f2) {
            boolean attribute = super.setAttribute(i2, f2);
            if (attribute) {
                return attribute;
            }
            if (i2 != 1999032065) {
                return false;
            }
            this.mLayoutRatio = f2;
            return true;
        }

        @Override // com.vivo.advv.vaf.virtualview.core.Layout.Params
        public boolean setAttribute(int i2, int i3) {
            boolean attribute = super.setAttribute(i2, i3);
            if (attribute) {
                return attribute;
            }
            if (i2 == 516361156) {
                this.mLayoutGravity = i3;
                return true;
            }
            if (i2 != 1999032065) {
                return false;
            }
            this.mLayoutRatio = i3;
            return true;
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.Layout
    public Params generateParams(ViewFactory viewFactory) {
        return new Params(viewFactory);
    }
}
