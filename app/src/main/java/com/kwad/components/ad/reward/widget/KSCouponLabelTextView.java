package com.kwad.components.ad.reward.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
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
    private final RectF Ab;
    private float Ad;
    private float Ae;
    private float Af;
    private final RectF Ag;
    private final RectF Ah;
    private final Path Ai;
    private Path Aj;
    private Path Ak;
    private boolean Al;
    private final Paint mPaint;

    @ColorInt
    private int strokeColor;
    private final Rect zX;
    private final RectF zY;

    public KSCouponLabelTextView(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.zX = new Rect();
        this.zY = new RectF();
        this.Ag = new RectF();
        this.Ah = new RectF();
        this.Ai = new Path();
        this.Ab = new RectF();
        this.Al = true;
        init(context, null, 0);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.zX = new Rect();
        this.zY = new RectF();
        this.Ag = new RectF();
        this.Ah = new RectF();
        this.Ai = new Path();
        this.Ab = new RectF();
        this.Al = true;
        init(context, attributeSet, 0);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mPaint = new Paint();
        this.zX = new Rect();
        this.zY = new RectF();
        this.Ag = new RectF();
        this.Ah = new RectF();
        this.Ai = new Path();
        this.Ab = new RectF();
        this.Al = true;
        init(context, attributeSet, i2);
    }

    @RequiresApi(api = 19)
    private void a(Path path, Path path2, Path path3, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        float f2 = this.Ad;
        path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
        path2.addArc(rectF2, 90.0f, -180.0f);
        path3.addArc(rectF3, 90.0f, 180.0f);
        path.op(this.Aj, Path.Op.DIFFERENCE);
        path.op(this.Ak, Path.Op.DIFFERENCE);
    }

    private void a(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        float f2 = rectF2.left;
        float f3 = this.Af;
        float f4 = f2 - f3;
        rectF2.left = f4;
        rectF2.right = f4 + (f3 * 2.0f);
        float height = rectF.height();
        float f5 = this.Af;
        float f6 = rectF2.top + ((height - (f5 * 2.0f)) / 2.0f);
        rectF2.top = f6;
        rectF2.bottom = f6 + (f5 * 2.0f);
    }

    private void b(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        path.moveTo(rectF.left, rectF.top + this.Ad);
        this.Ab.set(rectF);
        RectF rectF4 = this.Ab;
        float f2 = rectF4.top;
        float f3 = this.Ad;
        rectF4.bottom = f2 + (f3 * 2.0f);
        rectF4.right = rectF4.left + (f3 * 2.0f);
        path.arcTo(rectF4, 180.0f, 90.0f);
        path.lineTo(rectF.width() - this.Ad, rectF.top);
        this.Ab.set(rectF);
        RectF rectF5 = this.Ab;
        float f4 = rectF5.right;
        float f5 = this.Ad;
        rectF5.left = f4 - (f5 * 2.0f);
        rectF5.bottom = rectF5.top + (f5 * 2.0f);
        path.arcTo(rectF5, 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF3.top);
        path.arcTo(rectF3, 270.0f, -180.0f);
        path.lineTo(rectF.right, rectF.bottom - this.Ad);
        this.Ab.set(rectF);
        RectF rectF6 = this.Ab;
        float f6 = rectF6.right;
        float f7 = this.Ad;
        rectF6.left = f6 - (f7 * 2.0f);
        rectF6.top = rectF6.bottom - (f7 * 2.0f);
        path.arcTo(rectF6, 0.0f, 90.0f);
        path.lineTo(rectF.left + this.Ad, rectF.bottom);
        this.Ab.set(rectF);
        RectF rectF7 = this.Ab;
        float f8 = rectF7.left;
        float f9 = this.Ad;
        rectF7.right = f8 + (f9 * 2.0f);
        rectF7.top = rectF7.bottom - (f9 * 2.0f);
        path.arcTo(rectF7, 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF2.bottom);
        path.arcTo(rectF2, 90.0f, -180.0f);
        path.close();
    }

    private void b(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        float f2 = rectF2.right;
        float f3 = this.Af;
        float f4 = f2 + f3;
        rectF2.right = f4;
        rectF2.left = f4 - (f3 * 2.0f);
        float height = rectF.height();
        float f5 = this.Af;
        float f6 = rectF2.top + ((height - (f5 * 2.0f)) / 2.0f);
        rectF2.top = f6;
        rectF2.bottom = f6 + (f5 * 2.0f);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void init(Context context, AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSCouponLabelTextView, i2, 0);
        int color = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.Ad = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_labelRadius, 8.0f);
        this.Ae = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeSize, 2.0f);
        this.strokeColor = obtainStyledAttributes.getColor(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeColor, color);
        this.Af = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_sideRadius, 16.0f);
        obtainStyledAttributes.recycle();
        ka();
    }

    private void ka() {
        this.mPaint.setColor(this.strokeColor);
        this.mPaint.setStrokeWidth(this.Ae);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        int color = getResources().getColor(R.color.ksad_reward_main_color);
        this.strokeColor = color;
        setTextColor(color);
        ka();
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.zX.setEmpty();
        getDrawingRect(this.zX);
        float f2 = this.Ae / 2.0f;
        this.zY.set(this.zX);
        RectF rectF = this.zY;
        rectF.left += f2;
        rectF.top += f2;
        rectF.right -= f2;
        rectF.bottom -= f2;
        a(rectF, this.Ag);
        b(this.zY, this.Ah);
        if (Build.VERSION.SDK_INT >= 19) {
            Path path = this.Aj;
            if (path == null) {
                this.Aj = new Path();
            } else {
                path.reset();
            }
            Path path2 = this.Ak;
            if (path2 == null) {
                this.Ak = new Path();
            } else {
                path2.reset();
            }
            a(this.Ai, this.Aj, this.Ak, this.zY, this.Ag, this.Ah);
        } else {
            b(this.Ai, this.zY, this.Ag, this.Ah);
        }
        canvas.drawPath(this.Ai, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.Al) {
            if (((float) (getPaddingLeft() + getPaddingRight())) + getPaint().measureText(getText().toString()) <= ((float) getMeasuredWidth())) {
                return;
            }
            setVisibility(8);
        }
    }
}
