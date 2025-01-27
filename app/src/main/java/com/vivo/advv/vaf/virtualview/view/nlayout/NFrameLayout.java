package com.vivo.advv.vaf.virtualview.view.nlayout;

import android.graphics.Canvas;
import android.view.View;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.layout.FrameLayout;
import com.vivo.advv.vaf.virtualview.util.ViewUtils;

/* loaded from: classes4.dex */
public class NFrameLayout extends FrameLayout implements INativeLayout {
    private static final String TAG = "NFrameLayout_TMTEST";
    private NativeLayoutImpl mNative;

    public static class Builder implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new NFrameLayout(vafContext, viewCache);
        }
    }

    public NFrameLayout(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        NativeLayoutImpl nativeLayoutImpl = new NativeLayoutImpl(vafContext.forViewConstruction());
        this.mNative = nativeLayoutImpl;
        nativeLayoutImpl.setVirtualViewOnly(this);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.Layout, com.vivo.advv.vaf.virtualview.core.ViewBase
    public void comDraw(Canvas canvas) {
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void comLayout(int i2, int i3, int i4, int i5) {
        this.mDrawLeft = i2;
        this.mDrawTop = i3;
        this.mNative.layout(i2, i3, i4, i5);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public View getNativeView() {
        return this.mNative;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public boolean isContainer() {
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.view.nlayout.INativeLayout
    public void layoutDraw(Canvas canvas) {
        super.comDraw(canvas);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.Layout, com.vivo.advv.vaf.virtualview.core.ViewBase
    protected void onComDraw(Canvas canvas) {
    }

    @Override // com.vivo.advv.vaf.virtualview.layout.FrameLayout, com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.mNative.onLayout(z, i2, i3, i4, i5);
    }

    @Override // com.vivo.advv.vaf.virtualview.layout.FrameLayout, com.vivo.advv.vaf.virtualview.core.IView
    public void onComMeasure(int i2, int i3) {
        this.mNative.measure(ViewUtils.scaleWidthMeasureSpec(i2, this.mScaleFactor, this.mParams), ViewUtils.scaleHeightMeasureSpec(i3, this.mScaleFactor, this.mParams));
    }

    @Override // com.vivo.advv.vaf.virtualview.view.nlayout.INativeLayout
    public void onLayoutLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onComLayout(z, i2, i3, i4, i5);
    }

    @Override // com.vivo.advv.vaf.virtualview.view.nlayout.INativeLayout
    public void onLayoutMeasure(int i2, int i3) {
        super.onComMeasure(i2, i3);
    }
}
