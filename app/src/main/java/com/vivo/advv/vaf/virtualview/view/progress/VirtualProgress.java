package com.vivo.advv.vaf.virtualview.view.progress;

import android.graphics.Canvas;
import com.vivo.advv.Color;
import com.vivo.advv.Utils;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.core.VirtualViewBase;

/* loaded from: classes4.dex */
public class VirtualProgress extends VirtualViewBase {
    private static final String TAG = "Progress_TMTEST";
    public static final int TYPE_Normal = 1;
    private int mCur;
    private int mInitPos;
    private int mProgressColor;
    private int mTotal;
    private int mType;

    public static class Builder implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new VirtualProgress(vafContext, viewCache);
        }
    }

    public VirtualProgress(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        this.mType = 1;
        this.mInitPos = 0;
        this.mProgressColor = Color.BLUE;
        this.mCur = 0;
        this.mTotal = 0;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected void onComDraw(Canvas canvas) {
        super.onComDraw(canvas);
        int i2 = this.mInitPos;
        int i3 = this.mCur;
        if (i3 > 0) {
            float f2 = i2;
            float f3 = this.mMeasuredWidth - i2;
            float f4 = this.mPaddingLeft;
            float f5 = this.mScaleFactor;
            i2 = (int) (f2 + ((((f3 - (f4 * f5)) - (this.mPaddingRight * f5)) * i3) / this.mTotal));
        }
        if (i2 > 0) {
            float f6 = this.mPaddingLeft;
            float f7 = this.mScaleFactor;
            float f8 = f6 * f7;
            canvas.drawRect(f8, this.mPaddingTop * f7, i2 + f8, this.mMeasuredHeight - (this.mPaddingBottom * f7), this.mPaint);
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void onParseValueFinished(float f2) {
        super.onParseValueFinished(f2);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void reset() {
        super.reset();
        this.mInitPos = 0;
        this.mCur = 0;
        this.mTotal = 0;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, float f2) {
        boolean attribute = super.setAttribute(i2, f2);
        if (attribute) {
            return attribute;
        }
        if (i2 != -266541503) {
            return false;
        }
        this.mInitPos = Utils.dp2px(f2);
        return true;
    }

    public void setProgress(int i2, int i3) {
        if (this.mCur != i2) {
            this.mCur = i2;
            this.mTotal = i3;
            refresh();
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, int i3) {
        boolean attribute = super.setAttribute(i2, i3);
        if (attribute) {
            return attribute;
        }
        if (i2 == -266541503) {
            this.mInitPos = Utils.dp2px(i3);
            return true;
        }
        if (i2 == 3575610) {
            this.mType = i3;
            return true;
        }
        if (i2 != 94842723) {
            return false;
        }
        this.mProgressColor = i3;
        this.mPaint.setColor(i3);
        return true;
    }
}
