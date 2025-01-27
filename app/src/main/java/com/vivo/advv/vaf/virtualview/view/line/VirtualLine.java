package com.vivo.advv.vaf.virtualview.view.line;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.util.ViewUtils;

/* loaded from: classes4.dex */
public class VirtualLine extends LineBase {
    private static final String TAG = "VirtualLine_TMTEST";
    protected ViewBase.VirtualViewImp mImp;
    protected Path mPath;

    public static class Builder implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new VirtualLine(vafContext, viewCache);
        }
    }

    public VirtualLine(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        ViewBase.VirtualViewImp virtualViewImp = new ViewBase.VirtualViewImp();
        this.mImp = virtualViewImp;
        virtualViewImp.setAntiAlias(true);
        this.mImp.setViewBase(this);
        this.mPaint.setColor(-16777216);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void measureComponent(int i2, int i3) {
        this.mImp.measureComponent(ViewUtils.scaleWidthMeasureSpec(i2, this.mScaleFactor, this.mParams), ViewUtils.scaleHeightMeasureSpec(i3, this.mScaleFactor, this.mParams));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onComDraw(android.graphics.Canvas r11) {
        /*
            r10 = this;
            super.onComDraw(r11)
            android.graphics.Paint r0 = r10.mPaint
            float r0 = r0.getStrokeWidth()
            int r0 = (int) r0
            boolean r1 = r10.mIsHorizontal
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L57
            int r1 = r10.mGravity
            r4 = r1 & 32
            if (r4 == 0) goto L1a
            int r0 = r10.mMeasuredHeight
        L18:
            int r0 = r0 >> r3
            goto L23
        L1a:
            r1 = r1 & 16
            if (r1 == 0) goto L18
            int r1 = r10.mMeasuredHeight
            int r0 = r0 >> r3
            int r0 = r1 - r0
        L23:
            int r1 = r10.mStyle
            if (r1 != r3) goto L39
            int r1 = r10.mPaddingLeft
            float r3 = (float) r1
            float r6 = (float) r0
            int r0 = r10.mMeasuredWidth
            int r1 = r10.mPaddingRight
            int r0 = r0 - r1
            float r5 = (float) r0
            android.graphics.Paint r7 = r10.mPaint
            r2 = r11
            r4 = r6
            r2.drawLine(r3, r4, r5, r6, r7)
            goto L9c
        L39:
            if (r1 != r2) goto L9c
            android.graphics.Path r1 = r10.mPath
            int r2 = r10.mPaddingLeft
            float r2 = (float) r2
            float r0 = (float) r0
            r1.moveTo(r2, r0)
            android.graphics.Path r1 = r10.mPath
            int r2 = r10.mMeasuredWidth
            int r3 = r10.mPaddingRight
            int r2 = r2 - r3
            float r2 = (float) r2
            r1.lineTo(r2, r0)
            android.graphics.Path r0 = r10.mPath
            android.graphics.Paint r1 = r10.mPaint
            r11.drawPath(r0, r1)
            goto L9c
        L57:
            int r1 = r10.mGravity
            r4 = r1 & 4
            if (r4 == 0) goto L61
            int r0 = r10.mMeasuredWidth
        L5f:
            int r0 = r0 >> r3
            goto L69
        L61:
            r1 = r1 & r2
            if (r1 == 0) goto L5f
            int r1 = r10.mMeasuredWidth
            int r0 = r0 >> r3
            int r0 = r1 - r0
        L69:
            int r1 = r10.mStyle
            if (r1 != r3) goto L7f
            float r7 = (float) r0
            int r0 = r10.mPaddingTop
            float r6 = (float) r0
            int r0 = r10.mMeasuredHeight
            int r1 = r10.mPaddingBottom
            int r0 = r0 - r1
            float r8 = (float) r0
            android.graphics.Paint r9 = r10.mPaint
            r4 = r11
            r5 = r7
            r4.drawLine(r5, r6, r7, r8, r9)
            goto L9c
        L7f:
            if (r1 != r2) goto L9c
            android.graphics.Path r1 = r10.mPath
            float r0 = (float) r0
            int r2 = r10.mPaddingTop
            float r2 = (float) r2
            r1.moveTo(r0, r2)
            android.graphics.Path r1 = r10.mPath
            int r2 = r10.mMeasuredHeight
            int r3 = r10.mPaddingBottom
            int r2 = r2 - r3
            float r2 = (float) r2
            r1.lineTo(r0, r2)
            android.graphics.Path r0 = r10.mPath
            android.graphics.Paint r1 = r10.mPaint
            r11.drawPath(r0, r1)
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.advv.vaf.virtualview.view.line.VirtualLine.onComDraw(android.graphics.Canvas):void");
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
        this.mPaint.setStrokeWidth(this.mLineWidth * this.mScaleFactor);
        this.mPaint.setColor(this.mLineColor);
        int i2 = this.mStyle;
        if (i2 == 1) {
            this.mPaint.setStyle(Paint.Style.FILL);
            return;
        }
        if (i2 != 2) {
            return;
        }
        if (this.mPath == null) {
            this.mPath = new Path();
        }
        this.mPath.reset();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setPathEffect(new DashPathEffect(this.mDashEffect, 1.0f));
    }

    public void setColor(int i2) {
        this.mLineColor = i2;
        this.mPaint.setColor(i2);
        refresh();
    }
}
