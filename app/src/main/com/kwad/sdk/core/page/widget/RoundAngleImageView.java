package com.kwad.sdk.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes3.dex */
public class RoundAngleImageView extends ImageView {
    private float[] aBu;
    private Path mPath;
    private RectF mRectF;

    public RoundAngleImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        float[] fArr = this.aBu;
        if (fArr == null || fArr.length != 8) {
            super.onDraw(canvas);
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float[] fArr2 = this.aBu;
        float f10 = fArr2[0] + fArr2[3];
        float f11 = fArr2[1] + fArr2[7];
        this.mPath.rewind();
        float f12 = measuredWidth;
        if (f12 >= f10) {
            float f13 = measuredHeight;
            if (f13 > f11) {
                this.mRectF.set(0.0f, 0.0f, f12, f13);
                this.mPath.addRoundRect(this.mRectF, this.aBu, Path.Direction.CW);
                canvas.clipPath(this.mPath);
            }
        }
        super.onDraw(canvas);
    }

    public void setRadius(float f10) {
        this.aBu = new float[8];
        int i10 = 0;
        while (true) {
            float[] fArr = this.aBu;
            if (i10 >= fArr.length) {
                return;
            }
            fArr[i10] = f10;
            i10++;
        }
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mPath = new Path();
        this.mRectF = new RectF();
    }

    public void setRadius(float[] fArr) {
        this.aBu = new float[8];
        int i10 = 0;
        while (true) {
            float[] fArr2 = this.aBu;
            if (i10 >= fArr2.length) {
                return;
            }
            fArr2[i10] = fArr[i10];
            i10++;
        }
    }
}
