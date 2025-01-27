package com.vivo.advv.vaf.virtualview.layout;

import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.Helper.RtlHelper;
import com.vivo.advv.vaf.virtualview.ViewFactory;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.layout.VHLayout;
import com.vivo.advv.vaf.virtualview.util.VVLog;

/* loaded from: classes4.dex */
public class VH2Layout extends VHLayout {
    private static final String TAG = "VH2Layout_TMTEST";

    public static class Builder implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new VH2Layout(vafContext, viewCache);
        }
    }

    public static class Params extends VHLayout.Params {
        public int mLayoutDirection;

        public Params(ViewFactory viewFactory) {
            super(viewFactory);
            this.mLayoutDirection = 1;
        }

        @Override // com.vivo.advv.vaf.virtualview.layout.VHLayout.Params, com.vivo.advv.vaf.virtualview.core.Layout.Params
        public boolean setAttribute(int i2, int i3) {
            boolean attribute = super.setAttribute(i2, i3);
            if (attribute) {
                return attribute;
            }
            if (i2 != -1955718283) {
                return false;
            }
            this.mLayoutDirection = i3;
            return true;
        }
    }

    public VH2Layout(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
    }

    @Override // com.vivo.advv.vaf.virtualview.layout.VHLayout, com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        float f2;
        int i6;
        int i7;
        float f3;
        int i8;
        int i9 = this.mOrientation;
        int i10 = 0;
        if (i9 == 0) {
            float f4 = this.mPaddingTop;
            float f5 = this.mScaleFactor;
            int i11 = (int) (i3 + (f4 * f5));
            int i12 = (int) (i5 - (this.mPaddingBottom * f5));
            int size = this.mSubViews.size();
            int i13 = 0;
            while (i10 < size) {
                ViewBase viewBase = this.mSubViews.get(i10);
                if (!viewBase.isGone()) {
                    Params params = (Params) viewBase.getComLayoutParams();
                    int comMeasuredWidth = viewBase.getComMeasuredWidth();
                    int comMeasuredHeight = viewBase.getComMeasuredHeight();
                    int i14 = params.mLayoutDirection;
                    if ((i14 & 2) != 0) {
                        float f6 = params.mLayoutMarginTop;
                        float f7 = this.mScaleFactor;
                        i13 = (int) (i11 + (f6 * f7));
                        i11 = (int) (i13 + comMeasuredHeight + (params.mLayoutMarginBottom * f7));
                    } else if ((i14 & 8) != 0) {
                        float f8 = params.mLayoutMarginBottom;
                        float f9 = this.mScaleFactor;
                        i13 = (int) (i12 - ((f8 * f9) + comMeasuredHeight));
                        i12 = (int) (i13 - (params.mLayoutMarginTop * f9));
                    } else {
                        VVLog.e(TAG, "onComLayout VERTICAL direction invalidate:" + params.mLayoutDirection);
                    }
                    int i15 = params.mLayoutGravity;
                    if ((i15 & 4) != 0) {
                        i6 = ((i4 + i2) - comMeasuredWidth) >> 1;
                    } else {
                        if ((i15 & 2) != 0) {
                            float f10 = this.mPaddingRight;
                            float f11 = this.mScaleFactor;
                            f2 = ((i4 - (f10 * f11)) - (params.mLayoutMarginRight * f11)) - comMeasuredWidth;
                        } else {
                            float f12 = this.mPaddingLeft;
                            float f13 = this.mScaleFactor;
                            f2 = i2 + (f12 * f13) + (params.mLayoutMarginLeft * f13);
                        }
                        i6 = (int) f2;
                    }
                    int realLeft = RtlHelper.getRealLeft(isRtl(), i2, getWidth(), i6, comMeasuredWidth);
                    viewBase.comLayout(realLeft, i13, comMeasuredWidth + realLeft, comMeasuredHeight + i13);
                }
                i10++;
            }
            return;
        }
        if (i9 != 1) {
            return;
        }
        float f14 = this.mPaddingLeft;
        float f15 = this.mScaleFactor;
        int i16 = (int) (i2 + (f14 * f15));
        int i17 = (int) (i4 - (this.mPaddingRight * f15));
        int size2 = this.mSubViews.size();
        int i18 = 0;
        while (i10 < size2) {
            ViewBase viewBase2 = this.mSubViews.get(i10);
            if (viewBase2.isGone()) {
                i7 = size2;
            } else {
                Params params2 = (Params) viewBase2.getComLayoutParams();
                int comMeasuredWidth2 = viewBase2.getComMeasuredWidth();
                int comMeasuredHeight2 = viewBase2.getComMeasuredHeight();
                int i19 = params2.mLayoutDirection;
                if ((i19 & 1) != 0) {
                    float f16 = params2.mLayoutMarginLeft;
                    float f17 = this.mScaleFactor;
                    i18 = (int) (i16 + (f16 * f17));
                    i7 = size2;
                    i16 = (int) (i18 + comMeasuredWidth2 + (params2.mLayoutMarginRight * f17));
                } else {
                    i7 = size2;
                    if ((i19 & 4) != 0) {
                        float f18 = params2.mLayoutMarginRight;
                        float f19 = this.mScaleFactor;
                        i18 = (int) (i17 - ((f18 * f19) + comMeasuredWidth2));
                        i17 = (int) (i18 - (params2.mLayoutMarginLeft * f19));
                    } else {
                        VVLog.e(TAG, "onComLayout HORIZONTAL direction invalidate:" + params2.mLayoutDirection);
                    }
                }
                int i20 = params2.mLayoutGravity;
                if ((i20 & 32) != 0) {
                    i8 = ((i5 + i3) - comMeasuredHeight2) >> 1;
                } else {
                    if ((i20 & 16) != 0) {
                        float f20 = this.mPaddingBottom;
                        float f21 = this.mScaleFactor;
                        f3 = ((i5 - comMeasuredHeight2) - (f20 * f21)) - (params2.mLayoutMarginBottom * f21);
                    } else {
                        float f22 = this.mPaddingTop;
                        float f23 = this.mScaleFactor;
                        f3 = i3 + (f22 * f23) + (params2.mLayoutMarginTop * f23);
                    }
                    i8 = (int) f3;
                }
                int realLeft2 = RtlHelper.getRealLeft(isRtl(), i2, getWidth(), i18, comMeasuredWidth2);
                viewBase2.comLayout(realLeft2, i8, comMeasuredWidth2 + realLeft2, comMeasuredHeight2 + i8);
            }
            i10++;
            size2 = i7;
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.layout.VHLayout, com.vivo.advv.vaf.virtualview.core.Layout
    public Params generateParams(ViewFactory viewFactory) {
        return new Params(viewFactory);
    }
}
