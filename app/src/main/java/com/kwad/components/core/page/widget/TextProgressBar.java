package com.kwad.components.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.kwad.sdk.n.m;

/* loaded from: classes3.dex */
public class TextProgressBar extends ProgressBar {

    @Nullable
    private String SG;
    private LinearGradient SH;
    private Matrix SI;
    private boolean SJ;
    private boolean SK;
    private boolean SL;
    private int SM;
    private int SN;
    private Drawable SO;
    private int SP;
    private Rect SQ;
    private int[] SR;
    private int SS;
    private int ST;
    private boolean SU;
    private Paint mPaint;
    private RectF mRectF;

    public TextProgressBar(Context context) {
        this(context, null);
    }

    private void qT() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(-1);
        this.mPaint.setTextSize(com.kwad.sdk.c.a.a.a(getContext(), 12.0f));
        this.SP = com.kwad.sdk.c.a.a.a(getContext(), 2.0f);
        this.mRectF = new RectF();
        this.SS = -1;
        this.ST = -117146;
    }

    private void setProgressText(int i10) {
        this.SG = String.valueOf((int) (((i10 * 1.0f) / getMax()) * 100.0f)) + "%";
    }

    public final void e(String str, int i10) {
        this.SG = str;
        this.SJ = true;
        setProgress(i10);
        invalidate();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        int width;
        try {
            if (this.SK) {
                canvas.save();
                canvas.rotate(90.0f);
                canvas.translate(0.0f, -getWidth());
                super.onDraw(canvas);
                canvas.restore();
            } else {
                super.onDraw(canvas);
            }
            if (!TextUtils.isEmpty(this.SG)) {
                Paint paint = this.mPaint;
                String str = this.SG;
                paint.getTextBounds(str, 0, str.length(), this.SQ);
            }
            int height = (getHeight() / 2) - this.SQ.centerY();
            Drawable drawable = this.SO;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.SO.getIntrinsicHeight();
                int width2 = (((getWidth() - this.SQ.width()) - intrinsicWidth) - this.SP) / 2;
                int i10 = intrinsicWidth + width2;
                this.SO.setBounds(width2, (getHeight() - intrinsicHeight) / 2, i10, (getHeight() + intrinsicHeight) / 2);
                this.SO.draw(canvas);
                width = i10 + this.SP;
            } else {
                width = (getWidth() / 2) - this.SQ.centerX();
            }
            if (this.SR != null) {
                float progress = ((getProgress() * 1.0f) / getMax()) * getWidth();
                float f10 = width;
                if (progress >= f10) {
                    if (this.SH == null) {
                        this.SH = new LinearGradient(f10, 0.0f, width + this.SQ.width(), 0.0f, this.SR, (float[]) null, Shader.TileMode.CLAMP);
                        Matrix matrix = new Matrix();
                        this.SI = matrix;
                        this.SH.setLocalMatrix(matrix);
                    }
                    this.mPaint.setShader(this.SH);
                    this.SI.setScale(((progress - f10) * 1.0f) / this.SQ.width(), 1.0f, f10, 0.0f);
                    this.SH.setLocalMatrix(this.SI);
                } else {
                    this.mPaint.setShader(null);
                }
                canvas.drawText(this.SG, f10, height, this.mPaint);
                return;
            }
            if (!isIndeterminate() && !this.SU) {
                this.mPaint.setColor(this.SS);
                String str2 = this.SG;
                if (str2 != null) {
                    canvas.drawText(str2, width, height, this.mPaint);
                }
                return;
            }
            float width3 = (getWidth() * getProgress()) / getMax();
            int save = canvas.save();
            this.mRectF.set(width3, 0.0f, getWidth(), getHeight());
            canvas.clipRect(this.mRectF);
            this.mPaint.setColor(this.ST);
            String str3 = this.SG;
            if (str3 != null) {
                canvas.drawText(str3, width, height, this.mPaint);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            this.mRectF.set(0.0f, 0.0f, width3, getHeight());
            canvas.clipRect(this.mRectF);
            this.mPaint.setColor(this.SS);
            String str4 = this.SG;
            if (str4 != null) {
                canvas.drawText(str4, width, height, this.mPaint);
            }
            canvas.restoreToCount(save2);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i10, int i11) {
        try {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null && !TextUtils.isEmpty(this.SG)) {
                Rect rect = new Rect();
                Paint paint = this.mPaint;
                String str = this.SG;
                paint.getTextBounds(str, 0, str.length(), rect);
                if (layoutParams.width == -2) {
                    int width = rect.width() + this.SM + this.SN;
                    layoutParams.width = width;
                    i10 = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
                }
                if (layoutParams.height == -2) {
                    int height = rect.height();
                    layoutParams.height = height;
                    i11 = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
                }
            }
            if (!this.SK) {
                super.onMeasure(i10, i11);
            } else {
                super.onMeasure(i11, i10);
                setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        if (this.SK) {
            super.onSizeChanged(i11, i10, i12, i13);
        } else {
            super.onSizeChanged(i10, i11, i12, i13);
        }
    }

    public void setDrawableLeft(Drawable drawable) {
        this.SO = drawable;
    }

    public void setDrawablePadding(int i10) {
        this.SP = i10;
    }

    public void setHasProgress(boolean z10) {
        this.SL = z10;
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        this.SM = i10;
        this.SN = i12;
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i10) {
        if (this.SL) {
            super.setProgress(i10);
        } else {
            super.setProgress(0);
        }
    }

    public void setTextColor(int i10) {
        this.SU = false;
        this.SS = i10;
        postInvalidate();
    }

    public void setTextDimen(float f10) {
        this.mPaint.setTextSize(f10);
    }

    public void setTextDimenSp(int i10) {
        this.mPaint.setTextSize(TypedValue.applyDimension(2, i10, getResources().getDisplayMetrics()));
    }

    public void setVertical(boolean z10) {
        this.SK = z10;
    }

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(m.wrapContextIfNeed(context), attributeSet);
        this.SK = false;
        this.SL = true;
        this.SQ = new Rect();
        qT();
    }

    public final void setTextColor(@ColorInt int i10, @ColorInt int i11) {
        this.SU = true;
        this.SS = i10;
        this.ST = i11;
        postInvalidate();
    }
}
