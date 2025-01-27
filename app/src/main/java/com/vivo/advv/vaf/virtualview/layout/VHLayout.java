package com.vivo.advv.vaf.virtualview.layout;

import android.view.View;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.ViewFactory;
import com.vivo.advv.vaf.virtualview.core.Layout;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import com.vivo.advv.vaf.virtualview.util.ViewUtils;

/* loaded from: classes4.dex */
public class VHLayout extends Layout {
    private static final String TAG = "VHLayout_TMTEST";
    protected int mMeasureChildrenHeight;
    protected int mMeasureChildrenWidth;
    public int mOrientation;

    public static class Builder implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new VHLayout(vafContext, viewCache);
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

    public VHLayout(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        this.mOrientation = 1;
    }

    private int getChildrenHeight() {
        if (this.mMeasureChildrenHeight <= 0) {
            this.mMeasureChildrenHeight = 0;
            int size = this.mSubViews.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mMeasureChildrenHeight += this.mSubViews.get(i2).getComMeasuredHeightWithMargin();
            }
        }
        return this.mMeasureChildrenHeight;
    }

    private int getChildrenWidth() {
        if (this.mMeasureChildrenWidth <= 0) {
            this.mMeasureChildrenWidth = 0;
            int size = this.mSubViews.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mMeasureChildrenWidth += this.mSubViews.get(i2).getComMeasuredWidthWithMargin();
            }
        }
        return this.mMeasureChildrenWidth;
    }

    private int getRealHeight(int i2, int i3) {
        float f2;
        float f3;
        float f4;
        int comMeasuredHeightWithMargin;
        float f5;
        float f6;
        float f7;
        int comMeasuredHeightWithMargin2;
        int i4 = 0;
        if (Integer.MIN_VALUE == i2) {
            int i5 = this.mOrientation;
            if (1 != i5) {
                if (i5 == 0) {
                    int size = this.mSubViews.size();
                    int i6 = 0;
                    while (i4 < size) {
                        ViewBase viewBase = this.mSubViews.get(i4);
                        if (!viewBase.isGone()) {
                            i6 += viewBase.getComMeasuredHeightWithMargin();
                        }
                        i4++;
                    }
                    this.mMeasureChildrenHeight = i6;
                    f5 = i6;
                    f6 = this.mPaddingTop + this.mPaddingBottom + (this.mBorderWidth << 1);
                    f7 = this.mScaleFactor;
                }
                return Math.min(i3, i4);
            }
            int size2 = this.mSubViews.size();
            int i7 = 0;
            while (i4 < size2) {
                ViewBase viewBase2 = this.mSubViews.get(i4);
                if (!viewBase2.isGone() && (comMeasuredHeightWithMargin2 = viewBase2.getComMeasuredHeightWithMargin()) > i7) {
                    i7 = comMeasuredHeightWithMargin2;
                }
                i4++;
            }
            this.mMeasureChildrenHeight = i7;
            f5 = i7;
            f6 = this.mPaddingTop + this.mPaddingBottom + (this.mBorderWidth << 1);
            f7 = this.mScaleFactor;
            i4 = (int) (f5 + (f6 * f7));
            return Math.min(i3, i4);
        }
        if (1073741824 == i2) {
            return i3;
        }
        int i8 = this.mOrientation;
        if (1 == i8) {
            int size3 = this.mSubViews.size();
            int i9 = 0;
            while (i4 < size3) {
                ViewBase viewBase3 = this.mSubViews.get(i4);
                if (!viewBase3.isGone() && (comMeasuredHeightWithMargin = viewBase3.getComMeasuredHeightWithMargin()) > i9) {
                    i9 = comMeasuredHeightWithMargin;
                }
                i4++;
            }
            this.mMeasureChildrenHeight = i9;
            f2 = i9;
            f3 = this.mPaddingTop + this.mPaddingBottom + (this.mBorderWidth << 1);
            f4 = this.mScaleFactor;
        } else {
            if (i8 != 0) {
                return 0;
            }
            int size4 = this.mSubViews.size();
            int i10 = 0;
            while (i4 < size4) {
                ViewBase viewBase4 = this.mSubViews.get(i4);
                if (!viewBase4.isGone()) {
                    i10 += viewBase4.getComMeasuredHeightWithMargin();
                }
                i4++;
            }
            this.mMeasureChildrenHeight = i10;
            f2 = i10;
            f3 = this.mPaddingTop + this.mPaddingBottom + (this.mBorderWidth << 1);
            f4 = this.mScaleFactor;
        }
        return (int) (f2 + (f3 * f4));
    }

    private int getRealWidth(int i2, int i3) {
        float f2;
        float f3;
        float f4;
        int comMeasuredWidthWithMargin;
        if (Integer.MIN_VALUE != i2) {
            if (1073741824 == i2) {
                return i3;
            }
            VVLog.e(TAG, "getRealWidth error mode:" + i2);
            return i3;
        }
        int i4 = this.mOrientation;
        int i5 = 0;
        if (1 != i4) {
            if (i4 == 0) {
                int size = this.mSubViews.size();
                int i6 = 0;
                while (i5 < size) {
                    ViewBase viewBase = this.mSubViews.get(i5);
                    if (!viewBase.isGone() && (comMeasuredWidthWithMargin = viewBase.getComMeasuredWidthWithMargin()) > i6) {
                        i6 = comMeasuredWidthWithMargin;
                    }
                    i5++;
                }
                this.mMeasureChildrenWidth = i6;
                f2 = i6;
                f3 = this.mPaddingLeft + this.mPaddingRight + (this.mBorderWidth << 1);
                f4 = this.mScaleFactor;
            }
            return Math.min(i3, i5);
        }
        int size2 = this.mSubViews.size();
        int i7 = 0;
        while (i5 < size2) {
            ViewBase viewBase2 = this.mSubViews.get(i5);
            if (!viewBase2.isGone()) {
                i7 += viewBase2.getComMeasuredWidthWithMargin();
            }
            i5++;
        }
        this.mMeasureChildrenWidth = i7;
        f2 = i7;
        f3 = this.mPaddingLeft + this.mPaddingRight + (this.mBorderWidth << 1);
        f4 = this.mScaleFactor;
        i5 = (int) (f2 + (f3 * f4));
        return Math.min(i3, i5);
    }

    private void measureHorizontal(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size3 = this.mSubViews.size();
        boolean z = false;
        int i4 = 0;
        for (int i5 = 0; i5 < size3; i5++) {
            ViewBase viewBase = this.mSubViews.get(i5);
            if (!viewBase.isGone()) {
                Layout.Params comLayoutParams = viewBase.getComLayoutParams();
                if (1073741824 != mode2 && -1 == comLayoutParams.mLayoutHeight) {
                    z = true;
                }
                if (mode != 0) {
                    measureComChild(viewBase, View.MeasureSpec.makeMeasureSpec(size - i4, 1073741824), i3);
                } else {
                    measureComChild(viewBase, i2, i3);
                }
                i4 += viewBase.getComMeasuredWidthWithMargin();
            }
        }
        setComMeasuredDimension(getRealWidth(mode, size), getRealHeight(mode2, size2));
        if (z) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getComMeasuredHeight(), 1073741824);
            int size4 = this.mSubViews.size();
            for (int i6 = 0; i6 < size4; i6++) {
                ViewBase viewBase2 = this.mSubViews.get(i6);
                if (!viewBase2.isGone() && -1 == viewBase2.getComLayoutParams().mLayoutHeight) {
                    measureComChild(viewBase2, i2, makeMeasureSpec);
                }
            }
        }
    }

    private final void measureVertical(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size3 = this.mSubViews.size();
        boolean z = false;
        for (int i4 = 0; i4 < size3; i4++) {
            ViewBase viewBase = this.mSubViews.get(i4);
            if (!viewBase.isGone()) {
                Params params = (Params) viewBase.getComLayoutParams();
                if (1073741824 != mode && -1 == params.mLayoutWidth) {
                    z = true;
                }
                measureComChild(viewBase, i2, i3);
            }
        }
        setComMeasuredDimension(getRealWidth(mode, size), getRealHeight(mode2, size2));
        if (z) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getComMeasuredWidth(), 1073741824);
            int size4 = this.mSubViews.size();
            for (int i5 = 0; i5 < size4; i5++) {
                ViewBase viewBase2 = this.mSubViews.get(i5);
                if (!viewBase2.isGone() && -1 == viewBase2.getComLayoutParams().mLayoutWidth) {
                    measureComChild(viewBase2, makeMeasureSpec, i3);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010e  */
    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onComLayout(boolean r10, int r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.advv.vaf.virtualview.layout.VHLayout.onComLayout(boolean, int, int, int, int):void");
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComMeasure(int i2, int i3) {
        int scaleWidthMeasureSpec = ViewUtils.scaleWidthMeasureSpec(i2, this.mScaleFactor, this.mParams);
        int scaleHeightMeasureSpec = ViewUtils.scaleHeightMeasureSpec(i3, this.mScaleFactor, this.mParams);
        this.mMeasureChildrenWidth = 0;
        this.mMeasureChildrenHeight = 0;
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

    @Override // com.vivo.advv.vaf.virtualview.core.Layout
    public Params generateParams(ViewFactory viewFactory) {
        return new Params(viewFactory);
    }
}
