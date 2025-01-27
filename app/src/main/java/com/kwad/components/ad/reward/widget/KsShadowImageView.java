package com.kwad.components.ad.reward.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class KsShadowImageView extends ImageView {
    private boolean CA;
    private boolean CB;
    private boolean CC;
    private boolean CD;
    private Rect CE;

    @ColorInt
    private int CF;
    private Paint Cx;
    private BlurMaskFilter Cy;
    private int Cz;

    public KsShadowImageView(Context context) {
        super(context);
        this.CD = true;
        a(context, null, 0);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet, int i10) {
        this.Cx = new Paint();
        this.Cy = new BlurMaskFilter(50.0f, BlurMaskFilter.Blur.OUTER);
        this.CE = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShadowImageView, i10, 0);
        this.Cz = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_KsShadowImageView_ksad_shadowSize, 20);
        this.CF = obtainStyledAttributes.getColor(R.styleable.ksad_KsShadowImageView_ksad_shadowColor, Color.parseColor("#33000000"));
        this.CA = obtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableLeftShadow, true);
        this.CB = obtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableRightShadow, true);
        this.CC = obtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableTopShadow, true);
        this.CD = obtainStyledAttributes.getBoolean(R.styleable.ksad_KsShadowImageView_ksad_enableBottomShadow, true);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.Cx.setMaskFilter(this.Cy);
        this.Cx.setColor(this.CF);
        this.Cx.setStyle(Paint.Style.FILL);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Rect rect = this.CE;
        rect.left = this.CA ? this.Cz : 0;
        rect.top = this.CC ? this.Cz : 0;
        rect.right = measuredWidth - (this.CB ? this.Cz : 0);
        rect.bottom = measuredHeight - (this.CD ? this.Cz : 0);
        canvas.drawRect(rect, this.Cx);
    }

    public KsShadowImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.CD = true;
        a(context, attributeSet, 0);
    }

    public KsShadowImageView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.CD = true;
        a(context, attributeSet, i10);
    }

    @RequiresApi(api = 21)
    public KsShadowImageView(Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.CD = true;
        a(context, attributeSet, i10);
    }
}
