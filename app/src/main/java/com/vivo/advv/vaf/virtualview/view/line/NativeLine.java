package com.vivo.advv.vaf.virtualview.view.line;

import android.view.View;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.util.ViewUtils;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class NativeLine extends LineBase {
    private static final String TAG = "NativeLine_TMTEST";
    private NativeLineImp mNative;

    public static class Builder implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new NativeLine(vafContext, viewCache);
        }
    }

    public NativeLine(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        this.mNative = new NativeLineImp(vafContext.forViewConstruction(), this);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void comLayout(int i2, int i3, int i4, int i5) {
        super.comLayout(i2, i3, i4, i5);
        this.mNative.comLayout(i2, i3, i4, i5);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void destroy() {
        super.destroy();
        this.mNative.destroy();
        this.mNative = null;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredHeight() {
        return this.mNative.getComMeasuredHeight();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredWidth() {
        return this.mNative.getComMeasuredWidth();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public View getNativeView() {
        return this.mNative;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void measureComponent(int i2, int i3) {
        this.mNative.measureComponent(ViewUtils.scaleWidthMeasureSpec(i2, this.mScaleFactor, this.mParams), ViewUtils.scaleHeightMeasureSpec(i3, this.mScaleFactor, this.mParams));
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.mNative.onComLayout(z, i2, i3, i4, i5);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComMeasure(int i2, int i3) {
        this.mNative.onComMeasure(ViewUtils.scaleWidthMeasureSpec(i2, this.mScaleFactor, this.mParams), ViewUtils.scaleHeightMeasureSpec(i3, this.mScaleFactor, this.mParams));
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void onParseValueFinished(float f2) {
        super.onParseValueFinished(f2);
        float[] fArr = this.mDashEffect;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        if (copyOf != null && copyOf.length > 0) {
            for (int i2 = 0; i2 < copyOf.length; i2++) {
                copyOf[i2] = copyOf[i2] * this.mScaleFactor;
            }
        }
        this.mDashEffect = copyOf;
        this.mNative.setPaintParam(this.mLineColor, (int) (this.mLineWidth * this.mScaleFactor), this.mStyle);
    }
}
