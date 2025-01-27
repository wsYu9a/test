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
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class FrameLayout extends Layout {
    private static final String TAG = "FrameLayout_TMTEST";
    private List<ViewBase> mMatchParentView;

    public static class Builder implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new FrameLayout(vafContext, viewCache);
        }
    }

    public static class Params extends Layout.Params {
        public int mLayoutGravity;

        public Params(ViewFactory viewFactory) {
            super(viewFactory);
        }

        @Override // com.vivo.advv.vaf.virtualview.core.Layout.Params
        public boolean setAttribute(int i2, int i3) {
            boolean attribute = super.setAttribute(i2, i3);
            if (attribute) {
                return attribute;
            }
            if (i2 != 516361156) {
                return false;
            }
            this.mLayoutGravity = i3;
            return true;
        }
    }

    public FrameLayout(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        this.mMatchParentView = new ArrayList();
    }

    private int getRealHeight(int i2, int i3) {
        int comMeasuredHeightWithMargin;
        int comMeasuredHeightWithMargin2;
        int i4 = 0;
        if (Integer.MIN_VALUE == i2) {
            int size = this.mSubViews.size();
            int i5 = 0;
            while (i4 < size) {
                ViewBase viewBase = this.mSubViews.get(i4);
                if (!viewBase.isGone() && (comMeasuredHeightWithMargin2 = viewBase.getComMeasuredHeightWithMargin()) > i5) {
                    i5 = comMeasuredHeightWithMargin2;
                }
                i4++;
            }
            return Math.min(i3, (int) (i5 + ((this.mPaddingTop + this.mPaddingBottom + (this.mBorderWidth << 1)) * this.mScaleFactor)));
        }
        if (1073741824 == i2) {
            return i3;
        }
        int size2 = this.mSubViews.size();
        int i6 = 0;
        while (i4 < size2) {
            ViewBase viewBase2 = this.mSubViews.get(i4);
            if (!viewBase2.isGone() && (comMeasuredHeightWithMargin = viewBase2.getComMeasuredHeightWithMargin()) > i6) {
                i6 = comMeasuredHeightWithMargin;
            }
            i4++;
        }
        return (int) (i6 + ((this.mPaddingTop + this.mPaddingBottom + (this.mBorderWidth << 1)) * this.mScaleFactor));
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
        int size = this.mSubViews.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            ViewBase viewBase = this.mSubViews.get(i5);
            if (!viewBase.isGone() && (comMeasuredWidthWithMargin = viewBase.getComMeasuredWidthWithMargin()) > i4) {
                i4 = comMeasuredWidthWithMargin;
            }
        }
        return Math.min(i3, (int) (i4 + ((this.mPaddingLeft + this.mPaddingRight + (this.mBorderWidth << 1)) * this.mScaleFactor)));
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        float f2;
        int i6;
        float f3;
        int i7;
        int size = this.mSubViews.size();
        for (int i8 = 0; i8 < size; i8++) {
            ViewBase viewBase = this.mSubViews.get(i8);
            if (!viewBase.isGone()) {
                int comMeasuredWidth = viewBase.getComMeasuredWidth();
                int comMeasuredHeight = viewBase.getComMeasuredHeight();
                int i9 = ((Params) viewBase.getComLayoutParams()).mLayoutGravity;
                if ((i9 & 4) != 0) {
                    i6 = ((i4 + i2) - comMeasuredWidth) >> 1;
                } else {
                    if ((i9 & 2) != 0) {
                        float f4 = this.mPaddingRight;
                        float f5 = this.mScaleFactor;
                        f2 = (((i4 - (f4 * f5)) - (r4.mLayoutMarginRight * f5)) - comMeasuredWidth) - (this.mBorderWidth * f5);
                    } else {
                        float f6 = this.mPaddingLeft;
                        float f7 = this.mScaleFactor;
                        f2 = i2 + (f6 * f7) + (r4.mLayoutMarginLeft * f7) + (this.mBorderWidth * f7);
                    }
                    i6 = (int) f2;
                }
                if ((i9 & 32) != 0) {
                    i7 = ((i5 + i3) - comMeasuredHeight) >> 1;
                } else {
                    if ((i9 & 16) != 0) {
                        float f8 = this.mPaddingBottom;
                        float f9 = this.mScaleFactor;
                        f3 = (((i5 - comMeasuredHeight) - (f8 * f9)) - (r4.mLayoutMarginBottom * f9)) - (this.mBorderWidth * f9);
                    } else {
                        float f10 = this.mPaddingTop;
                        float f11 = this.mScaleFactor;
                        f3 = i3 + (f10 * f11) + (r4.mLayoutMarginTop * f11) + (this.mBorderWidth * f11);
                    }
                    i7 = (int) f3;
                }
                int realLeft = RtlHelper.getRealLeft(isRtl(), i2, getWidth(), i6, comMeasuredWidth);
                viewBase.comLayout(realLeft, i7, comMeasuredWidth + realLeft, comMeasuredHeight + i7);
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
        this.mMatchParentView.clear();
        int size3 = this.mSubViews.size();
        for (int i5 = 0; i5 < size3; i5++) {
            ViewBase viewBase = this.mSubViews.get(i5);
            if (!viewBase.isGone()) {
                Layout.Params comLayoutParams = viewBase.getComLayoutParams();
                if ((1073741824 != mode2 && -1 == comLayoutParams.mLayoutHeight) || (1073741824 != mode && -1 == comLayoutParams.mLayoutWidth)) {
                    this.mMatchParentView.add(viewBase);
                }
                measureComChild(viewBase, scaleWidthMeasureSpec, scaleHeightMeasureSpec);
            }
        }
        setComMeasuredDimension(getRealWidth(mode, size), getRealHeight(mode2, size2));
        if (this.mMatchParentView.size() > 0) {
            int size4 = this.mMatchParentView.size();
            for (int i6 = 0; i6 < size4; i6++) {
                measureComChild(this.mMatchParentView.get(i6), View.MeasureSpec.makeMeasureSpec(this.mMeasuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mMeasuredHeight, 1073741824));
            }
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.Layout
    public Params generateParams(ViewFactory viewFactory) {
        return new Params(viewFactory);
    }
}
