package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public class JinniuCouponLayout extends LinearLayout {
    private float BP;
    private Rect BQ;
    private RectF BR;
    private RectF BS;
    private RectF BT;
    private RectF BU;
    private Path BV;

    @ColorInt
    private int endColor;
    private Paint mPaint;
    private float mRadius;

    @ColorInt
    private int startColor;

    public JinniuCouponLayout(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.BP = 4.0f;
        this.mRadius = 10.0f;
        this.BQ = new Rect();
        this.BR = new RectF();
        this.BS = new RectF();
        this.BT = new RectF();
        this.BU = new RectF();
        this.BV = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, null, 0);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_JinniuCouponLayout, i10, 0);
        this.mRadius = obtainStyledAttributes.getDimension(R.styleable.ksad_JinniuCouponLayout_ksad_outerRadius, 4.0f);
        this.BP = obtainStyledAttributes.getDimension(R.styleable.ksad_JinniuCouponLayout_ksad_verticalRadius, 10.0f);
        obtainStyledAttributes.recycle();
        this.mPaint.setAntiAlias(true);
    }

    private void setGradientPaint(RectF rectF) {
        this.mPaint.setShader(new LinearGradient(rectF.left, rectF.top, rectF.right, rectF.bottom, this.startColor, this.endColor, Shader.TileMode.CLAMP));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.BQ.setEmpty();
        getDrawingRect(this.BQ);
        this.BR.set(this.BQ);
        if (getChildCount() > 1) {
            View childAt = getChildAt(0);
            RectF rectF = this.BS;
            if (rectF == null) {
                this.BS = new RectF();
            } else {
                rectF.setEmpty();
            }
            RectF rectF2 = this.BT;
            if (rectF2 == null) {
                this.BT = new RectF();
            } else {
                rectF2.setEmpty();
            }
            float measuredWidth = childAt.getMeasuredWidth();
            Rect rect = this.BQ;
            float f10 = rect.left + measuredWidth;
            RectF rectF3 = this.BS;
            int i10 = rect.top;
            float f11 = this.BP;
            rectF3.set(f10, i10 - f11, (2.0f * f11) + f10, i10 + f11);
            RectF rectF4 = this.BT;
            RectF rectF5 = this.BS;
            float f12 = rectF5.left;
            int i11 = this.BQ.bottom;
            float f13 = this.BP;
            rectF4.set(f12, i11 - f13, rectF5.right, i11 + f13);
            a(this.BV, this.BR, this.BS, this.BT);
            setGradientPaint(this.BR);
            canvas.drawPath(this.BV, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    private void a(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        RectF rectF4 = this.BR;
        path.moveTo(rectF4.left, rectF4.top + this.mRadius);
        this.BU.set(rectF);
        RectF rectF5 = this.BU;
        float f10 = rectF5.top;
        float f11 = this.mRadius;
        rectF5.bottom = f10 + (f11 * 2.0f);
        rectF5.right = rectF5.left + (f11 * 2.0f);
        path.arcTo(rectF5, 180.0f, 90.0f);
        path.lineTo(rectF2.left, rectF2.top);
        path.arcTo(rectF2, -180.0f, -180.0f);
        path.lineTo(rectF.width() - this.mRadius, rectF.top);
        this.BU.set(rectF);
        RectF rectF6 = this.BU;
        float f12 = rectF6.right;
        float f13 = this.mRadius;
        rectF6.left = f12 - (f13 * 2.0f);
        rectF6.bottom = rectF6.top + (f13 * 2.0f);
        path.arcTo(rectF6, 270.0f, 90.0f);
        this.BU.set(rectF);
        RectF rectF7 = this.BU;
        float f14 = rectF7.right;
        float f15 = this.mRadius;
        rectF7.left = f14 - (f15 * 2.0f);
        rectF7.top = rectF7.bottom - (f15 * 2.0f);
        path.arcTo(rectF7, 0.0f, 90.0f);
        path.lineTo(rectF3.right, rectF3.bottom);
        path.arcTo(rectF3, 0.0f, -180.0f);
        path.lineTo(rectF.left + this.mRadius, rectF.bottom);
        this.BU.set(rectF);
        RectF rectF8 = this.BU;
        float f16 = rectF8.left;
        float f17 = this.mRadius;
        rectF8.right = f16 + (f17 * 2.0f);
        rectF8.top = rectF8.bottom - (f17 * 2.0f);
        path.arcTo(rectF8, 90.0f, 90.0f);
    }

    public JinniuCouponLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.BP = 4.0f;
        this.mRadius = 10.0f;
        this.BQ = new Rect();
        this.BR = new RectF();
        this.BS = new RectF();
        this.BT = new RectF();
        this.BU = new RectF();
        this.BV = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, attributeSet, 0);
    }

    public JinniuCouponLayout(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mPaint = new Paint();
        this.BP = 4.0f;
        this.mRadius = 10.0f;
        this.BQ = new Rect();
        this.BR = new RectF();
        this.BS = new RectF();
        this.BT = new RectF();
        this.BU = new RectF();
        this.BV = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, attributeSet, i10);
    }

    @RequiresApi(api = 21)
    public JinniuCouponLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mPaint = new Paint();
        this.BP = 4.0f;
        this.mRadius = 10.0f;
        this.BQ = new Rect();
        this.BR = new RectF();
        this.BS = new RectF();
        this.BT = new RectF();
        this.BU = new RectF();
        this.BV = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, attributeSet, i10);
    }
}
