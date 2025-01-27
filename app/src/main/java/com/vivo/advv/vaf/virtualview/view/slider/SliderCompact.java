package com.vivo.advv.vaf.virtualview.view.slider;

import com.vivo.advv.Utils;
import com.vivo.advv.expr.common.ExprCode;
import com.vivo.advv.vaf.expr.engine.ExprEngine;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.core.NativeViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import com.vivo.advv.vaf.virtualview.view.slider.SliderView;

/* loaded from: classes4.dex */
public class SliderCompact extends NativeViewBase implements SliderView.Listener {
    private static final String TAG = "Slider_TMTEST";
    protected int mCur;
    protected SliderCompactImp mNative;
    protected ExprCode mScrollCode;
    protected int mTotal;

    public static class Builder implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new SliderCompact(vafContext, viewCache);
        }
    }

    public SliderCompact(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        SliderCompactImp sliderCompactImp = new SliderCompactImp(vafContext);
        this.mNative = sliderCompactImp;
        this.__mNative = sliderCompactImp;
        sliderCompactImp.setListener(this);
    }

    public void callScroll() {
        if (this.mScrollCode != null) {
            ExprEngine exprEngine = this.mContext.getExprEngine();
            if (exprEngine != null) {
                exprEngine.getEngineContext().getDataManager().replaceData(getViewCache().getComponentData());
            }
            if (exprEngine == null || !exprEngine.execute(this, this.mScrollCode)) {
                VVLog.e(TAG, "callPageFlip execute failed");
            }
        }
    }

    public int getCur() {
        return this.mCur;
    }

    public int getTotal() {
        return this.mTotal;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public boolean isContainer() {
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.view.slider.SliderView.Listener
    public void onScroll(int i2, int i3) {
        this.mCur = i2;
        this.mTotal = i3;
        callScroll();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.NativeViewBase, com.vivo.advv.vaf.virtualview.core.ViewBase
    public void reset() {
        super.reset();
        this.mNative.reset();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, ExprCode exprCode) {
        boolean attribute = super.setAttribute(i2, exprCode);
        if (attribute) {
            return attribute;
        }
        if (i2 != 1490730380) {
            return false;
        }
        this.mScrollCode = exprCode;
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void setData(Object obj) {
        this.mNative.setData(obj);
        super.setData(obj);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setRPAttribute(int i2, float f2) {
        boolean rPAttribute = super.setRPAttribute(i2, f2);
        if (rPAttribute) {
            return rPAttribute;
        }
        if (i2 == 3536714) {
            this.mNative.setSpan(rp2px(f2));
            return true;
        }
        if (i2 != 2146088563) {
            return false;
        }
        this.mNative.setItemWidth(rp2px(f2));
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, float f2) {
        boolean attribute = super.setAttribute(i2, f2);
        if (attribute) {
            return attribute;
        }
        if (i2 == 3536714) {
            this.mNative.setSpan(Utils.dp2px(f2));
            return true;
        }
        if (i2 != 2146088563) {
            return false;
        }
        this.mNative.setItemWidth(Utils.dp2px(f2));
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setRPAttribute(int i2, int i3) {
        boolean rPAttribute = super.setRPAttribute(i2, i3);
        if (rPAttribute) {
            return rPAttribute;
        }
        if (i2 == 3536714) {
            this.mNative.setSpan(rp2px(i3));
            return true;
        }
        if (i2 != 2146088563) {
            return false;
        }
        this.mNative.setItemWidth(rp2px(i3));
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, int i3) {
        boolean attribute = super.setAttribute(i2, i3);
        if (attribute) {
            return attribute;
        }
        if (i2 == -1439500848) {
            this.mNative.setOrientation(i3);
            return true;
        }
        if (i2 == 3536714) {
            this.mNative.setSpan(Utils.dp2px(i3));
            return true;
        }
        if (i2 != 2146088563) {
            return false;
        }
        this.mNative.setItemWidth(Utils.dp2px(i3));
        return true;
    }
}
