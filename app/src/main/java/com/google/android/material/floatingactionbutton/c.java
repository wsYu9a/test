package com.google.android.material.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.j.o;
import com.google.android.material.j.p;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
class c extends Drawable {

    /* renamed from: a */
    private static final float f7183a = 1.3333f;

    /* renamed from: c */
    @NonNull
    private final Paint f7185c;

    /* renamed from: i */
    @Dimension
    float f7191i;

    /* renamed from: j */
    @ColorInt
    private int f7192j;

    @ColorInt
    private int k;

    @ColorInt
    private int l;

    @ColorInt
    private int m;

    @ColorInt
    private int n;
    private o p;

    @Nullable
    private ColorStateList q;

    /* renamed from: b */
    private final p f7184b = new p();

    /* renamed from: d */
    private final Path f7186d = new Path();

    /* renamed from: e */
    private final Rect f7187e = new Rect();

    /* renamed from: f */
    private final RectF f7188f = new RectF();

    /* renamed from: g */
    private final RectF f7189g = new RectF();

    /* renamed from: h */
    private final b f7190h = new b();
    private boolean o = true;

    private class b extends Drawable.ConstantState {
        private b() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return c.this;
        }

        /* synthetic */ b(c cVar, a aVar) {
            this();
        }
    }

    c(o oVar) {
        this.p = oVar;
        Paint paint = new Paint(1);
        this.f7185c = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    @NonNull
    private Shader a() {
        copyBounds(this.f7187e);
        float height = this.f7191i / r0.height();
        return new LinearGradient(0.0f, r0.top, 0.0f, r0.bottom, new int[]{ColorUtils.compositeColors(this.f7192j, this.n), ColorUtils.compositeColors(this.k, this.n), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.k, 0), this.n), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.m, 0), this.n), ColorUtils.compositeColors(this.m, this.n), ColorUtils.compositeColors(this.l, this.n)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }

    @NonNull
    protected RectF b() {
        this.f7189g.set(getBounds());
        return this.f7189g;
    }

    public o c() {
        return this.p;
    }

    void d(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.n = colorStateList.getColorForState(getState(), this.n);
        }
        this.q = colorStateList;
        this.o = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.o) {
            this.f7185c.setShader(a());
            this.o = false;
        }
        float strokeWidth = this.f7185c.getStrokeWidth() / 2.0f;
        copyBounds(this.f7187e);
        this.f7188f.set(this.f7187e);
        float min = Math.min(this.p.r().a(b()), this.f7188f.width() / 2.0f);
        if (this.p.u(b())) {
            this.f7188f.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f7188f, min, min, this.f7185c);
        }
    }

    public void e(@Dimension float f2) {
        if (this.f7191i != f2) {
            this.f7191i = f2;
            this.f7185c.setStrokeWidth(f2 * f7183a);
            this.o = true;
            invalidateSelf();
        }
    }

    void f(@ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @ColorInt int i5) {
        this.f7192j = i2;
        this.k = i3;
        this.l = i4;
        this.m = i5;
    }

    public void g(o oVar) {
        this.p = oVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f7190h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f7191i > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.p.u(b())) {
            outline.setRoundRect(getBounds(), this.p.r().a(b()));
            return;
        }
        copyBounds(this.f7187e);
        this.f7188f.set(this.f7187e);
        this.f7184b.d(this.p, 1.0f, this.f7188f, this.f7186d);
        if (this.f7186d.isConvex()) {
            outline.setConvexPath(this.f7186d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        if (!this.p.u(b())) {
            return true;
        }
        int round = Math.round(this.f7191i);
        rect.set(round, round, round, round);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.q;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.o = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.q;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.n)) != this.n) {
            this.o = true;
            this.n = colorForState;
        }
        if (this.o) {
            invalidateSelf();
        }
        return this.o;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.f7185c.setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f7185c.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
