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
import com.kwad.sdk.j.k;

/* loaded from: classes2.dex */
public class TextProgressBar extends ProgressBar {
    private boolean NB;
    private int NC;
    private int ND;
    private Drawable NE;
    private int NF;
    private Rect NG;
    private int[] NH;
    private int NI;
    private int NJ;
    private boolean NK;

    @Nullable
    private String Nv;
    private LinearGradient Nw;
    private Matrix Nx;
    private boolean Ny;
    private boolean Nz;
    private Paint mPaint;
    private RectF mRectF;

    public TextProgressBar(Context context) {
        this(context, null);
    }

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(k.wrapContextIfNeed(context), attributeSet);
        this.Nz = false;
        this.NB = true;
        this.NG = new Rect();
        oV();
    }

    private void oV() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(-1);
        this.mPaint.setTextSize(com.kwad.sdk.c.kwai.a.a(getContext(), 12.0f));
        this.NF = com.kwad.sdk.c.kwai.a.a(getContext(), 2.0f);
        this.mRectF = new RectF();
        this.NI = -1;
        this.NJ = -117146;
    }

    private void setProgressText(int i2) {
        this.Nv = String.valueOf((int) (((i2 * 1.0f) / getMax()) * 100.0f)) + "%";
    }

    public final void f(String str, int i2) {
        this.Nv = str;
        this.Ny = true;
        setProgress(i2);
        invalidate();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        int width;
        if (this.Nz) {
            canvas.save();
            canvas.rotate(90.0f);
            canvas.translate(0.0f, -getWidth());
            super.onDraw(canvas);
            canvas.restore();
        } else {
            super.onDraw(canvas);
        }
        if (!TextUtils.isEmpty(this.Nv)) {
            Paint paint = this.mPaint;
            String str = this.Nv;
            paint.getTextBounds(str, 0, str.length(), this.NG);
        }
        int height = (getHeight() / 2) - this.NG.centerY();
        Drawable drawable = this.NE;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.NE.getIntrinsicHeight();
            int width2 = (((getWidth() - this.NG.width()) - intrinsicWidth) - this.NF) / 2;
            int i2 = intrinsicWidth + width2;
            this.NE.setBounds(width2, (getHeight() - intrinsicHeight) / 2, i2, (getHeight() + intrinsicHeight) / 2);
            this.NE.draw(canvas);
            width = i2 + this.NF;
        } else {
            width = (getWidth() / 2) - this.NG.centerX();
        }
        if (this.NH != null) {
            float progress = ((getProgress() * 1.0f) / getMax()) * getWidth();
            float f2 = width;
            if (progress >= f2) {
                if (this.Nw == null) {
                    this.Nw = new LinearGradient(f2, 0.0f, width + this.NG.width(), 0.0f, this.NH, (float[]) null, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    this.Nx = matrix;
                    this.Nw.setLocalMatrix(matrix);
                }
                this.mPaint.setShader(this.Nw);
                this.Nx.setScale(((progress - f2) * 1.0f) / this.NG.width(), 1.0f, f2, 0.0f);
                this.Nw.setLocalMatrix(this.Nx);
            } else {
                this.mPaint.setShader(null);
            }
            canvas.drawText(this.Nv, f2, height, this.mPaint);
            return;
        }
        if (!isIndeterminate() && !this.NK) {
            this.mPaint.setColor(this.NI);
            String str2 = this.Nv;
            if (str2 != null) {
                canvas.drawText(str2, width, height, this.mPaint);
            }
            return;
        }
        float width3 = (getWidth() * getProgress()) / getMax();
        int save = canvas.save();
        this.mRectF.set(width3, 0.0f, getWidth(), getHeight());
        canvas.clipRect(this.mRectF);
        this.mPaint.setColor(this.NJ);
        String str3 = this.Nv;
        if (str3 != null) {
            canvas.drawText(str3, width, height, this.mPaint);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        this.mRectF.set(0.0f, 0.0f, width3, getHeight());
        canvas.clipRect(this.mRectF);
        this.mPaint.setColor(this.NI);
        String str4 = this.Nv;
        if (str4 != null) {
            canvas.drawText(str4, width, height, this.mPaint);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && !TextUtils.isEmpty(this.Nv)) {
            Rect rect = new Rect();
            Paint paint = this.mPaint;
            String str = this.Nv;
            paint.getTextBounds(str, 0, str.length(), rect);
            if (layoutParams.width == -2) {
                int width = rect.width() + this.NC + this.ND;
                layoutParams.width = width;
                i2 = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
            }
            if (layoutParams.height == -2) {
                int height = rect.height();
                layoutParams.height = height;
                i3 = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
            }
        }
        if (!this.Nz) {
            super.onMeasure(i2, i3);
        } else {
            super.onMeasure(i3, i2);
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (this.Nz) {
            super.onSizeChanged(i3, i2, i4, i5);
        } else {
            super.onSizeChanged(i2, i3, i4, i5);
        }
    }

    public void setDrawableLeft(Drawable drawable) {
        this.NE = drawable;
    }

    public void setDrawablePadding(int i2) {
        this.NF = i2;
    }

    public void setHasProgress(boolean z) {
        this.NB = z;
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        this.NC = i2;
        this.ND = i4;
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i2) {
        if (this.NB) {
            super.setProgress(i2);
        } else {
            super.setProgress(0);
        }
    }

    public void setTextColor(int i2) {
        this.NK = false;
        this.NI = i2;
        postInvalidate();
    }

    public final void setTextColor(@ColorInt int i2, @ColorInt int i3) {
        this.NK = true;
        this.NI = i2;
        this.NJ = i3;
        postInvalidate();
    }

    public void setTextDimen(float f2) {
        this.mPaint.setTextSize(f2);
    }

    public void setTextDimenSp(int i2) {
        this.mPaint.setTextSize(TypedValue.applyDimension(2, i2, getResources().getDisplayMetrics()));
    }

    public void setVertical(boolean z) {
        this.Nz = z;
    }
}
