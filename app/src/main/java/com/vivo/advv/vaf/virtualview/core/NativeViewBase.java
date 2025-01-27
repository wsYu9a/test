package com.vivo.advv.vaf.virtualview.core;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.util.ViewUtils;

/* loaded from: classes4.dex */
public class NativeViewBase extends ViewBase {
    protected View __mNative;

    public NativeViewBase(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void comLayout(int i2, int i3, int i4, int i5) {
        super.comLayout(i2, i3, i4, i5);
        View view = this.__mNative;
        if (view instanceof IView) {
            ((IView) view).comLayout(i2, i3, i4, i5);
        } else {
            view.layout(i2, i3, i4, i5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredHeight() {
        View view = this.__mNative;
        return view instanceof IView ? ((IView) view).getComMeasuredHeight() : view.getMeasuredHeight();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredWidth() {
        View view = this.__mNative;
        return view instanceof IView ? ((IView) view).getComMeasuredWidth() : view.getMeasuredWidth();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public View getNativeView() {
        return this.__mNative;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void measureComponent(int i2, int i3) {
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
        View view = this.__mNative;
        if (view instanceof IView) {
            ((IView) view).measureComponent(scaleWidthMeasureSpec, scaleHeightMeasureSpec);
        } else {
            view.measure(scaleWidthMeasureSpec, scaleHeightMeasureSpec);
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        KeyEvent.Callback callback = this.__mNative;
        if (callback instanceof IView) {
            ((IView) callback).onComLayout(z, i2, i3, i4, i5);
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
        KeyEvent.Callback callback = this.__mNative;
        if (callback instanceof IView) {
            ((IView) callback).onComMeasure(scaleWidthMeasureSpec, scaleHeightMeasureSpec);
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void onParseValueFinished(float f2) {
        super.onParseValueFinished(f2);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void reset() {
        super.reset();
        if (Build.VERSION.SDK_INT >= 16) {
            this.__mNative.setBackground(null);
        } else {
            this.__mNative.setBackgroundDrawable(null);
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected void setBackgroundColor(int i2) {
        this.__mNative.setBackgroundColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void setBackgroundImage(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.__mNative.setBackground(new BitmapDrawable(this.mContext.forViewConstruction().getResources(), bitmap));
        } else {
            this.__mNative.setBackgroundDrawable(new BitmapDrawable(this.mContext.forViewConstruction().getResources(), bitmap));
        }
    }
}
