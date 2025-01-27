package com.vivo.advv.vaf.virtualview.view.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.text.TextUtils;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.util.ViewUtils;

/* loaded from: classes4.dex */
public class VirtualImage extends ImageBase {
    private static final String TAG = "VirtualImage_TMTEST";
    protected Bitmap mBitmap;
    private ViewBase.VirtualViewImp mImp;
    protected Matrix mMatrix;

    public static class Builder implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new VirtualImage(vafContext, viewCache);
        }
    }

    public VirtualImage(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        this.mImp = new ViewBase.VirtualViewImp();
        this.mMatrix = new Matrix();
        this.mImp.setViewBase(this);
    }

    @Override // com.vivo.advv.vaf.virtualview.view.image.ImageBase
    public void loadImage(String str) {
        if (this.mMeasuredWidth <= 0 || this.mMeasuredHeight <= 0) {
            return;
        }
        this.mContext.getImageLoader().bindBitmap(str, this, this.mMeasuredWidth, this.mMeasuredHeight);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected void makeContentRect() {
        if (this.mBitmap != null) {
            Rect rect = this.mContentRect;
            if (rect == null) {
                this.mContentRect = new Rect(0, 0, (int) (this.mBitmap.getWidth() * this.mScaleFactor), (int) (this.mBitmap.getHeight() * this.mScaleFactor));
                return;
            } else {
                rect.set(0, 0, (int) (r0.getWidth() * this.mScaleFactor), (int) (this.mBitmap.getHeight() * this.mScaleFactor));
                return;
            }
        }
        if (this.mMeasuredWidth <= 0 || this.mMeasuredHeight <= 0 || TextUtils.isEmpty(this.mSrc)) {
            return;
        }
        loadImage(this.mSrc);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void measureComponent(int i2, int i3) {
        this.mImp.measureComponent(ViewUtils.scaleWidthMeasureSpec(i2, this.mScaleFactor, this.mParams), ViewUtils.scaleWidthMeasureSpec(i3, this.mScaleFactor, this.mParams));
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected void onComDraw(Canvas canvas) {
        super.onComDraw(canvas);
        if (this.mContentRect == null) {
            makeContentRect();
        }
        if (this.mContentRect != null) {
            int i2 = this.mScaleType;
            if (i2 == 0) {
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, this.mPaint);
                return;
            }
            if (i2 == 1) {
                this.mMatrix.setScale(this.mMeasuredWidth / r0.width(), this.mMeasuredHeight / this.mContentRect.height());
                canvas.drawBitmap(this.mBitmap, this.mMatrix, this.mPaint);
            } else {
                if (i2 != 2) {
                    return;
                }
                this.mMatrix.setScale(this.mMeasuredWidth / r0.width(), this.mMeasuredHeight / this.mContentRect.height());
                canvas.drawBitmap(this.mBitmap, this.mMatrix, this.mPaint);
            }
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComMeasure(int i2, int i3) {
        this.mImp.onComMeasure(ViewUtils.scaleWidthMeasureSpec(i2, this.mScaleFactor, this.mParams), ViewUtils.scaleHeightMeasureSpec(i3, this.mScaleFactor, this.mParams));
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void onParseValueFinished(float f2) {
        super.onParseValueFinished(f2);
        this.mPaint.setFilterBitmap(true);
        loadImage(this.mSrc);
    }

    @Override // com.vivo.advv.vaf.virtualview.view.image.ImageBase, com.vivo.advv.vaf.virtualview.core.ViewBase
    public void reset() {
        super.reset();
        this.mImp.reset();
        this.mBitmap = null;
    }

    @Override // com.vivo.advv.vaf.virtualview.view.image.ImageBase
    public void setBitmap(Bitmap bitmap, boolean z) {
        this.mBitmap = bitmap;
        this.mContentRect = null;
        if (z) {
            refresh();
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.view.image.ImageBase
    public void setSrc(String str) {
        if (TextUtils.equals(this.mSrc, str)) {
            return;
        }
        this.mSrc = str;
        loadImage(str);
    }
}
