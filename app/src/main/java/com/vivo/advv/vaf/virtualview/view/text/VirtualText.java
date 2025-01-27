package com.vivo.advv.vaf.virtualview.view.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.Helper.VirtualViewUtils;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import com.vivo.advv.vaf.virtualview.util.ViewUtils;

/* loaded from: classes4.dex */
public class VirtualText extends TextBase {
    private static final String TAG = "VirtualText_TMTEST";
    protected int mDescent;
    protected String mDrawText;
    protected ViewBase.VirtualViewImp mImp;
    protected int mTextHeight;

    public static class Builder implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new VirtualText(vafContext, viewCache);
        }
    }

    public VirtualText(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        this.mTextHeight = 0;
        this.mDrawText = "";
        ViewBase.VirtualViewImp virtualViewImp = new ViewBase.VirtualViewImp();
        this.mImp = virtualViewImp;
        virtualViewImp.setAntiAlias(true);
        this.mImp.setViewBase(this);
    }

    public int getTextSize() {
        return this.mTextSize;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected void makeContentRect() {
        float measureText = this.mPaint.measureText(this.mDrawText);
        Rect rect = this.mContentRect;
        if (rect == null) {
            this.mContentRect = new Rect(0, 0, (int) (measureText * this.mScaleFactor), this.mTextHeight);
        } else {
            rect.set(0, 0, (int) (measureText * this.mScaleFactor), this.mTextHeight);
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void measureComponent(int i2, int i3) {
        this.mImp.measureComponent(ViewUtils.scaleWidthMeasureSpec(i2, this.mScaleFactor, this.mParams), ViewUtils.scaleHeightMeasureSpec(i3, this.mScaleFactor, this.mParams));
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected void onComDraw(Canvas canvas) {
        float height;
        int i2;
        super.onComDraw(canvas);
        if (this.mContentRect == null) {
            makeContentRect();
        }
        Rect rect = this.mContentRect;
        if (rect == null) {
            VVLog.w(TAG, "skip draw text");
            return;
        }
        int i3 = (int) (this.mPaddingLeft * this.mScaleFactor);
        int i4 = this.mGravity;
        if ((i4 & 2) != 0) {
            float width = this.mMeasuredWidth - rect.width();
            float f2 = this.mPaddingLeft;
            float f3 = this.mScaleFactor;
            i3 = (int) ((width - (f2 * f3)) - (this.mPaddingRight * f3));
        } else if ((i4 & 4) != 0) {
            i3 = (this.mMeasuredWidth - rect.width()) / 2;
        }
        int i5 = this.mGravity;
        if ((i5 & 16) != 0) {
            height = this.mMeasuredHeight - (this.mPaddingBottom * this.mScaleFactor);
        } else {
            if ((i5 & 32) != 0) {
                Paint.FontMetricsInt fontMetricsInt = this.mPaint.getFontMetricsInt();
                i2 = this.mDescent + (((this.mMeasuredHeight - fontMetricsInt.bottom) - fontMetricsInt.top) / 2);
                canvas.save();
                canvas.clipRect(0, 0, this.mMeasuredWidth, this.mMeasuredHeight);
                canvas.drawText(this.mDrawText, i3, i2 - this.mDescent, this.mPaint);
                canvas.restore();
                int i6 = this.mBorderColor;
                int i7 = this.mMeasuredWidth;
                int i8 = this.mMeasuredHeight;
                float f4 = this.mBorderWidth;
                float f5 = this.mScaleFactor;
                VirtualViewUtils.drawBorder(canvas, i6, i7, i8, (int) (f4 * f5), (int) (this.mBorderTopLeftRadius * f5), (int) (this.mBorderTopRightRadius * f5), (int) (this.mBorderBottomLeftRadius * f5), (int) (this.mBorderBottomRightRadius * f5));
            }
            height = this.mContentRect.height() + (this.mPaddingTop * this.mScaleFactor);
        }
        i2 = (int) height;
        canvas.save();
        canvas.clipRect(0, 0, this.mMeasuredWidth, this.mMeasuredHeight);
        canvas.drawText(this.mDrawText, i3, i2 - this.mDescent, this.mPaint);
        canvas.restore();
        int i62 = this.mBorderColor;
        int i72 = this.mMeasuredWidth;
        int i82 = this.mMeasuredHeight;
        float f42 = this.mBorderWidth;
        float f52 = this.mScaleFactor;
        VirtualViewUtils.drawBorder(canvas, i62, i72, i82, (int) (f42 * f52), (int) (this.mBorderTopLeftRadius * f52), (int) (this.mBorderTopRightRadius * f52), (int) (this.mBorderBottomLeftRadius * f52), (int) (this.mBorderBottomRightRadius * f52));
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComMeasure(int i2, int i3) {
        this.mImp.onComMeasure(ViewUtils.scaleWidthMeasureSpec(i2, this.mScaleFactor, this.mParams), ViewUtils.scaleHeightMeasureSpec(i3, this.mScaleFactor, this.mParams));
    }

    @Override // com.vivo.advv.vaf.virtualview.view.text.TextBase, com.vivo.advv.vaf.virtualview.core.ViewBase
    public void onParseValueFinished(float f2) {
        super.onParseValueFinished(f2);
        if ((this.mTextStyle & 1) != 0) {
            this.mPaint.setFakeBoldText(true);
        }
        if ((this.mTextStyle & 8) != 0) {
            this.mPaint.setStrikeThruText(true);
        }
        if ((this.mTextStyle & 2) != 0) {
            this.mPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
        }
        this.mPaint.setTextSize(this.mTextSize * this.mScaleFactor);
        this.mPaint.setColor(this.mTextColor);
        Paint.FontMetricsInt fontMetricsInt = this.mPaint.getFontMetricsInt();
        int i2 = fontMetricsInt.descent;
        this.mTextHeight = i2 - fontMetricsInt.ascent;
        this.mDescent = i2;
        String str = this.mText;
        this.mDrawText = str;
        if (TextUtils.isEmpty(str)) {
            setText("");
        } else {
            setText(this.mText);
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void reset() {
        super.reset();
        this.mImp.reset();
        this.mDrawText = this.mText;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void setData(Object obj) {
        super.setData(obj);
        if (obj instanceof String) {
            this.mDrawText = (String) obj;
            if (this.mIsDrawed) {
                refresh();
                return;
            }
            return;
        }
        VVLog.e(TAG, "setData type error:" + obj);
    }

    @Override // com.vivo.advv.vaf.virtualview.view.text.TextBase
    public void setText(String str) {
        this.mDrawText = str;
        super.setText(str);
    }

    public void setTextSize(int i2) {
        if (this.mTextSize != i2) {
            this.mTextSize = i2;
            refresh();
        }
    }
}
