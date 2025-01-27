package com.kwad.components.ad.reward.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.widget.d;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class KSCouponLabelTextView extends TextView implements d {
    private final Rect BQ;
    private final RectF BR;
    private final RectF BU;
    private float BW;
    private float BX;
    private float BY;
    private final RectF BZ;
    private final RectF Ca;
    private final Path Cb;
    private Path Cc;
    private Path Cd;
    private boolean Ce;
    private final Paint mPaint;

    @ColorInt
    private int strokeColor;

    public KSCouponLabelTextView(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.BQ = new Rect();
        this.BR = new RectF();
        this.BZ = new RectF();
        this.Ca = new RectF();
        this.Cb = new Path();
        this.BU = new RectF();
        this.Ce = true;
        a(context, null, 0);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(Context context, AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSCouponLabelTextView, i10, 0);
        int color = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.BW = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_labelRadius, 8.0f);
        this.BX = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeSize, 2.0f);
        this.strokeColor = obtainStyledAttributes.getColor(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeColor, color);
        this.BY = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_sideRadius, 16.0f);
        obtainStyledAttributes.recycle();
        ky();
    }

    private void b(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        path.moveTo(rectF.left, rectF.top + this.BW);
        this.BU.set(rectF);
        RectF rectF4 = this.BU;
        float f10 = rectF4.top;
        float f11 = this.BW;
        rectF4.bottom = f10 + (f11 * 2.0f);
        rectF4.right = rectF4.left + (f11 * 2.0f);
        path.arcTo(rectF4, 180.0f, 90.0f);
        path.lineTo(rectF.width() - this.BW, rectF.top);
        this.BU.set(rectF);
        RectF rectF5 = this.BU;
        float f12 = rectF5.right;
        float f13 = this.BW;
        rectF5.left = f12 - (f13 * 2.0f);
        rectF5.bottom = rectF5.top + (f13 * 2.0f);
        path.arcTo(rectF5, 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF3.top);
        path.arcTo(rectF3, 270.0f, -180.0f);
        path.lineTo(rectF.right, rectF.bottom - this.BW);
        this.BU.set(rectF);
        RectF rectF6 = this.BU;
        float f14 = rectF6.right;
        float f15 = this.BW;
        rectF6.left = f14 - (f15 * 2.0f);
        rectF6.top = rectF6.bottom - (f15 * 2.0f);
        path.arcTo(rectF6, 0.0f, 90.0f);
        path.lineTo(rectF.left + this.BW, rectF.bottom);
        this.BU.set(rectF);
        RectF rectF7 = this.BU;
        float f16 = rectF7.left;
        float f17 = this.BW;
        rectF7.right = f16 + (f17 * 2.0f);
        rectF7.top = rectF7.bottom - (f17 * 2.0f);
        path.arcTo(rectF7, 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF2.bottom);
        path.arcTo(rectF2, 90.0f, -180.0f);
        path.close();
    }

    private void ky() {
        this.mPaint.setColor(this.strokeColor);
        this.mPaint.setStrokeWidth(this.BX);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.BQ.setEmpty();
        getDrawingRect(this.BQ);
        float f10 = this.BX / 2.0f;
        this.BR.set(this.BQ);
        RectF rectF = this.BR;
        rectF.left += f10;
        rectF.top += f10;
        rectF.right -= f10;
        rectF.bottom -= f10;
        a(rectF, this.BZ);
        b(this.BR, this.Ca);
        Path path = this.Cc;
        if (path == null) {
            this.Cc = new Path();
        } else {
            path.reset();
        }
        Path path2 = this.Cd;
        if (path2 == null) {
            this.Cd = new Path();
        } else {
            path2.reset();
        }
        a(this.Cb, this.Cc, this.Cd, this.BR, this.BZ, this.Ca);
        canvas.drawPath(this.Cb, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.Ce) {
            if (getPaddingLeft() + getPaddingRight() + getPaint().measureText(getText().toString()) <= getMeasuredWidth()) {
                return;
            }
            setVisibility(8);
        }
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.BQ = new Rect();
        this.BR = new RectF();
        this.BZ = new RectF();
        this.Ca = new RectF();
        this.Cb = new Path();
        this.BU = new RectF();
        this.Ce = true;
        a(context, attributeSet, 0);
    }

    @RequiresApi(api = 19)
    private void a(Path path, Path path2, Path path3, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        float f10 = this.BW;
        path.addRoundRect(rectF, f10, f10, Path.Direction.CW);
        path2.addArc(rectF2, 90.0f, -180.0f);
        path3.addArc(rectF3, 90.0f, 180.0f);
        Path path4 = this.Cc;
        Path.Op op = Path.Op.DIFFERENCE;
        path.op(path4, op);
        path.op(this.Cd, op);
    }

    private void a(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        float f10 = rectF2.left;
        float f11 = this.BY;
        float f12 = f10 - f11;
        rectF2.left = f12;
        rectF2.right = f12 + (f11 * 2.0f);
        float height = rectF.height();
        float f13 = this.BY;
        float f14 = rectF2.top + ((height - (f13 * 2.0f)) / 2.0f);
        rectF2.top = f14;
        rectF2.bottom = f14 + (f13 * 2.0f);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mPaint = new Paint();
        this.BQ = new Rect();
        this.BR = new RectF();
        this.BZ = new RectF();
        this.Ca = new RectF();
        this.Cb = new Path();
        this.BU = new RectF();
        this.Ce = true;
        a(context, attributeSet, i10);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        int color = getResources().getColor(R.color.ksad_reward_main_color);
        this.strokeColor = color;
        setTextColor(color);
        ky();
        invalidate();
    }

    private void b(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        float f10 = rectF2.right;
        float f11 = this.BY;
        float f12 = f10 + f11;
        rectF2.right = f12;
        rectF2.left = f12 - (f11 * 2.0f);
        float height = rectF.height();
        float f13 = this.BY;
        float f14 = rectF2.top + ((height - (f13 * 2.0f)) / 2.0f);
        rectF2.top = f14;
        rectF2.bottom = f14 + (f13 * 2.0f);
    }
}
