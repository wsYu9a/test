package com.vivo.advv.vaf.virtualview.view.line;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.view.View;
import com.vivo.advv.vaf.virtualview.Helper.VirtualViewUtils;
import com.vivo.advv.vaf.virtualview.core.IView;

/* loaded from: classes4.dex */
public class NativeLineImp extends View implements IView {
    private static final String TAG = "NLineImp_TMTEST";
    protected LineBase mBase;
    protected Paint mPaint;

    public NativeLineImp(Context context, LineBase lineBase) {
        super(context);
        this.mPaint = new Paint();
        this.mBase = lineBase;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void comLayout(int i2, int i3, int i4, int i5) {
        layout(i2, i3, i4, i5);
    }

    public void destroy() {
        this.mBase = null;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredHeight() {
        return getMeasuredHeight();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredWidth() {
        return getMeasuredWidth();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void measureComponent(int i2, int i3) {
        measure(i2, i3);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        onLayout(z, i2, i3, i4, i5);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComMeasure(int i2, int i3) {
        onMeasure(i2, i3);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i2;
        int i3;
        int measuredWidth = getMeasuredWidth();
        int comMeasuredHeight = getComMeasuredHeight();
        VirtualViewUtils.drawBackground(canvas, this.mBase.getBackground(), measuredWidth, comMeasuredHeight, 0, 0, 0, 0, 0);
        int strokeWidth = (int) this.mPaint.getStrokeWidth();
        int align = this.mBase.getAlign();
        if (this.mBase.horizontal()) {
            if ((align & 32) != 0) {
                i3 = comMeasuredHeight >> 1;
            } else {
                i3 = strokeWidth >> 1;
                if ((align & 16) != 0) {
                    i3 = comMeasuredHeight - i3;
                }
            }
            float f2 = i3;
            canvas.drawLine(this.mBase.getComPaddingLeft(), f2, measuredWidth - this.mBase.getComPaddingRight(), f2, this.mPaint);
            return;
        }
        if ((align & 4) != 0) {
            i2 = measuredWidth >> 1;
        } else {
            i2 = strokeWidth >> 1;
            if ((align & 2) != 0) {
                i2 = measuredWidth - i2;
            }
        }
        float f3 = i2;
        canvas.drawLine(f3, this.mBase.getComPaddingTop(), f3, comMeasuredHeight - this.mBase.getComPaddingBottom(), this.mPaint);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        float strokeWidth;
        float strokeWidth2;
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int i4 = this.mBase.getComLayoutParams().mLayoutWidth;
        int i5 = this.mBase.getComLayoutParams().mLayoutHeight;
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                if (i4 != -1) {
                    if (i4 == -2) {
                        strokeWidth2 = Math.min(size, this.mPaint.getStrokeWidth());
                        size = (int) strokeWidth2;
                    }
                    size = i4;
                }
            } else if (mode != 0) {
                size = 0;
            } else if (i4 != -1) {
                if (i4 == -2) {
                    strokeWidth2 = this.mPaint.getStrokeWidth();
                    size = (int) strokeWidth2;
                }
                size = i4;
            }
        }
        if (mode2 != 1073741824) {
            if (mode2 == Integer.MIN_VALUE) {
                if (i5 != -1) {
                    if (i5 == -2) {
                        strokeWidth = Math.min(size2, this.mPaint.getStrokeWidth());
                        size2 = (int) strokeWidth;
                    }
                    size2 = i5;
                }
            } else if (mode2 != 0) {
                size2 = 0;
            } else if (i5 != -1) {
                if (i5 == -2) {
                    strokeWidth = this.mPaint.getStrokeWidth();
                    size2 = (int) strokeWidth;
                }
                size2 = i5;
            }
        }
        setMeasuredDimension(size, size2);
    }

    public void setColor(int i2) {
        this.mPaint.setColor(i2);
    }

    public void setPaintParam(int i2, int i3, int i4) {
        this.mPaint.setStrokeWidth(i3);
        this.mPaint.setColor(i2);
        this.mPaint.setAntiAlias(true);
        if (i4 == 1) {
            this.mPaint.setStyle(Paint.Style.FILL);
        } else {
            if (i4 != 2) {
                return;
            }
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setPathEffect(new DashPathEffect(this.mBase.mDashEffect, 1.0f));
            setLayerType(1, null);
        }
    }
}
