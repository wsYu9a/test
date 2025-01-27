package com.martian.libmars.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.Px;
import com.martian.libmars.R;

/* loaded from: classes3.dex */
public class RoundedLayout extends FrameLayout {

    /* renamed from: b */
    public final Path f12675b;

    /* renamed from: c */
    public final Paint f12676c;

    /* renamed from: d */
    public final RectF f12677d;

    /* renamed from: e */
    public final float[] f12678e;

    /* renamed from: f */
    public boolean f12679f;

    /* renamed from: g */
    public int f12680g;

    /* renamed from: h */
    public boolean f12681h;

    /* renamed from: i */
    public boolean f12682i;

    /* renamed from: j */
    public boolean f12683j;

    /* renamed from: k */
    public boolean f12684k;

    /* renamed from: l */
    public boolean f12685l;

    /* renamed from: m */
    public int f12686m;

    /* renamed from: n */
    public int f12687n;

    /* renamed from: o */
    public int f12688o;

    /* renamed from: p */
    public float f12689p;

    /* renamed from: q */
    public final GradientDrawable f12690q;

    public RoundedLayout(Context context) {
        super(context);
        this.f12675b = new Path();
        this.f12676c = new Paint();
        this.f12677d = new RectF();
        this.f12678e = new float[8];
        this.f12679f = false;
        this.f12690q = new GradientDrawable();
        c(context, null, 0, 0);
    }

    public final void a() {
        if (this.f12679f) {
            float f10 = this.f12680g;
            if (this.f12681h) {
                f10 = Math.max(this.f12677d.width(), this.f12677d.height()) / 2.0f;
            }
            this.f12675b.reset();
            this.f12675b.addRoundRect(this.f12677d, b(f10), Path.Direction.CW);
            this.f12675b.close();
            this.f12690q.setCornerRadii(b(f10));
        }
    }

    public final float[] b(float f10) {
        float[] fArr = this.f12678e;
        boolean z10 = this.f12682i;
        fArr[0] = z10 ? f10 : 0.0f;
        fArr[1] = z10 ? f10 : 0.0f;
        boolean z11 = this.f12683j;
        fArr[2] = z11 ? f10 : 0.0f;
        fArr[3] = z11 ? f10 : 0.0f;
        boolean z12 = this.f12685l;
        fArr[4] = z12 ? f10 : 0.0f;
        fArr[5] = z12 ? f10 : 0.0f;
        boolean z13 = this.f12684k;
        fArr[6] = z13 ? f10 : 0.0f;
        if (!z13) {
            f10 = 0.0f;
        }
        fArr[7] = f10;
        return fArr;
    }

    public final void c(Context context, AttributeSet attributeSet, int i10, int i11) {
        if (isInEditMode()) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundedLayout, i10, i11);
        this.f12680g = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedLayout_rlRoundedCornerRadius, 0);
        this.f12681h = obtainStyledAttributes.getBoolean(R.styleable.RoundedLayout_rlRoundAsCircle, false);
        this.f12682i = obtainStyledAttributes.getBoolean(R.styleable.RoundedLayout_rlRoundTopLeft, true);
        this.f12683j = obtainStyledAttributes.getBoolean(R.styleable.RoundedLayout_rlRoundTopRight, true);
        this.f12684k = obtainStyledAttributes.getBoolean(R.styleable.RoundedLayout_rlRoundBottomLeft, false);
        this.f12685l = obtainStyledAttributes.getBoolean(R.styleable.RoundedLayout_rlRoundBottomRight, false);
        this.f12686m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedLayout_rlRoundingBorderWidth, 0);
        this.f12687n = obtainStyledAttributes.getColor(R.styleable.RoundedLayout_rlRoundingBorderColor, 0);
        this.f12688o = obtainStyledAttributes.getColor(R.styleable.RoundedLayout_rlRoundingBackgroundColor, 0);
        if (obtainStyledAttributes.hasValue(R.styleable.RoundedLayout_rlRoundingElevation)) {
            this.f12689p = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedLayout_rlRoundingElevation, 0);
        }
        obtainStyledAttributes.recycle();
        setRoundingElevation(this.f12689p);
        this.f12676c.setAntiAlias(true);
        this.f12676c.setColor(this.f12687n);
        this.f12676c.setStyle(Paint.Style.STROKE);
        this.f12676c.setStrokeWidth(this.f12686m * 2);
        this.f12690q.setColor(this.f12688o);
        this.f12690q.setCornerRadii(b(this.f12680g));
        super.setBackgroundDrawable(this.f12690q);
    }

    public boolean d() {
        return this.f12681h;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        try {
            canvas.clipPath(this.f12675b);
        } catch (UnsupportedOperationException unused) {
        }
        super.draw(canvas);
        if (this.f12686m <= 0 || this.f12687n == 0) {
            return;
        }
        canvas.drawPath(this.f12675b, this.f12676c);
    }

    public boolean e() {
        return this.f12684k;
    }

    public boolean f() {
        return this.f12685l;
    }

    public boolean g() {
        return this.f12682i;
    }

    public int getRoundedCornerRadius() {
        return this.f12680g;
    }

    public int getRoundingBorderColor() {
        return this.f12687n;
    }

    public int getRoundingBorderWidth() {
        return this.f12686m;
    }

    public float getRoundingElevation() {
        return this.f12689p;
    }

    public boolean h() {
        return this.f12683j;
    }

    public void i(int i10, boolean z10, boolean z11, boolean z12, boolean z13) {
        if (this.f12680g == i10 && this.f12682i == z10 && this.f12683j == z11 && this.f12684k == z13 && this.f12685l == z12) {
            return;
        }
        this.f12680g = i10;
        this.f12682i = z10;
        this.f12683j = z11;
        this.f12684k = z13;
        this.f12685l = z12;
        a();
        postInvalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f12679f = false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f12677d.set(0.0f, 0.0f, i12 - i10, i13 - i11);
        if (this.f12679f) {
            return;
        }
        this.f12679f = true;
        a();
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f12677d.set(0.0f, 0.0f, i10, i11);
        a();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
    }

    @Override // android.view.View
    public void setElevation(@Px float f10) {
        super.setElevation(f10);
        this.f12689p = f10;
    }

    public void setRoundAsCircle(boolean z10) {
        if (z10 != this.f12681h) {
            this.f12681h = z10;
            a();
            postInvalidate();
        }
    }

    public void setRoundedCornerRadius(int i10) {
        i(i10, true, true, true, true);
    }

    public void setRoundingBackgroundColor(int i10) {
        int i11 = this.f12688o;
        if (i10 != i11) {
            this.f12690q.setColor(i11);
            postInvalidate();
        }
    }

    public void setRoundingBorderColor(int i10) {
        if (i10 != this.f12687n) {
            this.f12687n = i10;
            this.f12676c.setColor(i10);
            postInvalidate();
        }
    }

    public void setRoundingBorderWidth(int i10) {
        if (i10 != this.f12686m) {
            this.f12686m = i10;
            this.f12676c.setStrokeWidth(i10 * 2);
            postInvalidate();
        }
    }

    public void setRoundingElevation(float f10) {
        this.f12689p = f10;
        setElevation(f10);
    }

    public RoundedLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12675b = new Path();
        this.f12676c = new Paint();
        this.f12677d = new RectF();
        this.f12678e = new float[8];
        this.f12679f = false;
        this.f12690q = new GradientDrawable();
        c(context, attributeSet, 0, 0);
    }

    public RoundedLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12675b = new Path();
        this.f12676c = new Paint();
        this.f12677d = new RectF();
        this.f12678e = new float[8];
        this.f12679f = false;
        this.f12690q = new GradientDrawable();
        c(context, attributeSet, i10, 0);
    }

    @TargetApi(21)
    public RoundedLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f12675b = new Path();
        this.f12676c = new Paint();
        this.f12677d = new RectF();
        this.f12678e = new float[8];
        this.f12679f = false;
        this.f12690q = new GradientDrawable();
        c(context, attributeSet, i10, i11);
    }
}
