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
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import com.martian.libmars.R;

/* loaded from: classes2.dex */
public class RoundedLayout extends FrameLayout {

    /* renamed from: a */
    private final Path f10365a;

    /* renamed from: b */
    private final Paint f10366b;

    /* renamed from: c */
    private final RectF f10367c;

    /* renamed from: d */
    private final float[] f10368d;

    /* renamed from: e */
    private boolean f10369e;

    /* renamed from: f */
    private int f10370f;

    /* renamed from: g */
    private boolean f10371g;

    /* renamed from: h */
    private boolean f10372h;

    /* renamed from: i */
    private boolean f10373i;

    /* renamed from: j */
    private boolean f10374j;
    private boolean k;
    private int l;
    private int m;
    private float n;
    private final GradientDrawable o;

    public RoundedLayout(Context context) {
        super(context);
        this.f10365a = new Path();
        this.f10366b = new Paint();
        this.f10367c = new RectF();
        this.f10368d = new float[8];
        this.f10369e = false;
        this.o = new GradientDrawable();
        c(context, null, 0, 0);
    }

    private void a() {
        if (this.f10369e) {
            float f2 = this.f10370f;
            if (this.f10371g) {
                f2 = Math.max(this.f10367c.width(), this.f10367c.height()) / 2.0f;
            }
            this.f10365a.reset();
            this.f10365a.addRoundRect(this.f10367c, b(f2), Path.Direction.CW);
            this.f10365a.close();
            this.o.setCornerRadii(b(f2));
        }
    }

    private float[] b(float cornerRadius) {
        float[] fArr = this.f10368d;
        boolean z = this.f10372h;
        fArr[0] = z ? cornerRadius : 0.0f;
        fArr[1] = z ? cornerRadius : 0.0f;
        boolean z2 = this.f10373i;
        fArr[2] = z2 ? cornerRadius : 0.0f;
        fArr[3] = z2 ? cornerRadius : 0.0f;
        boolean z3 = this.k;
        fArr[4] = z3 ? cornerRadius : 0.0f;
        fArr[5] = z3 ? cornerRadius : 0.0f;
        boolean z4 = this.f10374j;
        fArr[6] = z4 ? cornerRadius : 0.0f;
        if (!z4) {
            cornerRadius = 0.0f;
        }
        fArr[7] = cornerRadius;
        return fArr;
    }

    private void c(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        if (isInEditMode()) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.RoundedLayout, defStyleAttr, defStyleRes);
        this.f10370f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedLayout_rlRoundedCornerRadius, 0);
        this.f10371g = obtainStyledAttributes.getBoolean(R.styleable.RoundedLayout_rlRoundAsCircle, false);
        this.f10372h = obtainStyledAttributes.getBoolean(R.styleable.RoundedLayout_rlRoundTopLeft, true);
        this.f10373i = obtainStyledAttributes.getBoolean(R.styleable.RoundedLayout_rlRoundTopRight, true);
        this.f10374j = obtainStyledAttributes.getBoolean(R.styleable.RoundedLayout_rlRoundBottomLeft, false);
        this.k = obtainStyledAttributes.getBoolean(R.styleable.RoundedLayout_rlRoundBottomRight, false);
        this.l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedLayout_rlRoundingBorderWidth, 0);
        this.m = obtainStyledAttributes.getColor(R.styleable.RoundedLayout_rlRoundingBorderColor, 0);
        if (obtainStyledAttributes.hasValue(R.styleable.RoundedLayout_rlRoundingElevation)) {
            this.n = obtainStyledAttributes.getDimensionPixelSize(r3, 0);
        }
        obtainStyledAttributes.recycle();
        setRoundingElevation(this.n);
        this.f10366b.setAntiAlias(true);
        this.f10366b.setColor(this.m);
        this.f10366b.setStyle(Paint.Style.STROKE);
        this.f10366b.setStrokeWidth(this.l * 2);
        this.o.setColor(this.m);
        this.o.setCornerRadii(b(this.f10370f));
        super.setBackgroundDrawable(this.o);
    }

    public boolean d() {
        return this.f10371g;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        try {
            canvas.clipPath(this.f10365a);
        } catch (UnsupportedOperationException unused) {
        }
        super.draw(canvas);
        if (this.l <= 0 || this.m == 0) {
            return;
        }
        canvas.drawPath(this.f10365a, this.f10366b);
    }

    public boolean e() {
        return this.f10374j;
    }

    public boolean f() {
        return this.k;
    }

    public boolean g() {
        return this.f10372h;
    }

    public int getRoundedCornerRadius() {
        return this.f10370f;
    }

    public int getRoundingBorderColor() {
        return this.m;
    }

    public int getRoundingBorderWidth() {
        return this.l;
    }

    public float getRoundingElevation() {
        return this.n;
    }

    public boolean h() {
        return this.f10373i;
    }

    public void i(int cornerRadius, boolean topLeft, boolean topRight, boolean bottomRight, boolean bottomLeft) {
        if (this.f10370f == cornerRadius && this.f10372h == topLeft && this.f10373i == topRight && this.f10374j == bottomLeft && this.k == bottomRight) {
            return;
        }
        this.f10370f = cornerRadius;
        this.f10372h = topLeft;
        this.f10373i = topRight;
        this.f10374j = bottomLeft;
        this.k = bottomRight;
        a();
        postInvalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f10369e = false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.f10367c.set(0.0f, 0.0f, right - left, bottom - top);
        if (this.f10369e) {
            return;
        }
        this.f10369e = true;
        a();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h2, int oldw, int oldh) {
        super.onSizeChanged(w, h2, oldw, oldh);
        a();
    }

    @Override // android.view.View
    public void setBackground(Drawable background) {
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable background) {
    }

    @Override // android.view.View
    @TargetApi(21)
    public void setElevation(@Px float elevation) {
        super.setElevation(elevation);
        this.n = elevation;
    }

    public void setRoundAsCircle(boolean asCircle) {
        if (asCircle != this.f10371g) {
            this.f10371g = asCircle;
            a();
            postInvalidate();
        }
    }

    public void setRoundedCornerRadius(int cornerRadius) {
        i(cornerRadius, true, true, true, true);
    }

    public void setRoundingBorderColor(int color) {
        if (color != this.m) {
            this.m = color;
            this.f10366b.setColor(color);
            this.o.setColor(this.m | (-16777216));
            postInvalidate();
        }
    }

    public void setRoundingBorderWidth(int width) {
        if (width != this.l) {
            this.l = width;
            this.f10366b.setStrokeWidth(width * 2);
            postInvalidate();
        }
    }

    public void setRoundingElevation(float elevation) {
        this.n = elevation;
        if (Build.VERSION.SDK_INT >= 21) {
            setElevation(elevation);
        } else {
            ViewCompat.setElevation(this, elevation);
        }
    }

    public RoundedLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f10365a = new Path();
        this.f10366b = new Paint();
        this.f10367c = new RectF();
        this.f10368d = new float[8];
        this.f10369e = false;
        this.o = new GradientDrawable();
        c(context, attrs, 0, 0);
    }

    public RoundedLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f10365a = new Path();
        this.f10366b = new Paint();
        this.f10367c = new RectF();
        this.f10368d = new float[8];
        this.f10369e = false;
        this.o = new GradientDrawable();
        c(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public RoundedLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.f10365a = new Path();
        this.f10366b = new Paint();
        this.f10367c = new RectF();
        this.f10368d = new float[8];
        this.f10369e = false;
        this.o = new GradientDrawable();
        c(context, attrs, defStyleAttr, defStyleRes);
    }
}
