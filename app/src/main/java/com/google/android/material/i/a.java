package com.google.android.material.i;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;

@Deprecated
/* loaded from: classes.dex */
public class a extends DrawableWrapper {

    /* renamed from: b */
    static final double f7255b = Math.cos(Math.toRadians(45.0d));

    /* renamed from: c */
    static final float f7256c = 1.5f;

    /* renamed from: d */
    static final float f7257d = 0.25f;

    /* renamed from: e */
    static final float f7258e = 0.5f;

    /* renamed from: f */
    static final float f7259f = 1.0f;

    /* renamed from: g */
    @NonNull
    final Paint f7260g;

    /* renamed from: h */
    @NonNull
    final Paint f7261h;

    /* renamed from: i */
    @NonNull
    final RectF f7262i;

    /* renamed from: j */
    float f7263j;
    Path k;
    float l;
    float m;
    float n;
    float o;
    private boolean p;
    private final int q;
    private final int r;
    private final int s;
    private boolean t;
    private float u;
    private boolean v;

    public a(Context context, Drawable drawable, float f2, float f3, float f4) {
        super(drawable);
        this.p = true;
        this.t = true;
        this.v = false;
        this.q = ContextCompat.getColor(context, R.color.design_fab_shadow_start_color);
        this.r = ContextCompat.getColor(context, R.color.design_fab_shadow_mid_color);
        this.s = ContextCompat.getColor(context, R.color.design_fab_shadow_end_color);
        Paint paint = new Paint(5);
        this.f7260g = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f7263j = Math.round(f2);
        this.f7262i = new RectF();
        Paint paint2 = new Paint(paint);
        this.f7261h = paint2;
        paint2.setAntiAlias(false);
        p(f3, f4);
    }

    private void a(@NonNull Rect rect) {
        float f2 = this.m;
        float f3 = f7256c * f2;
        this.f7262i.set(rect.left + f2, rect.top + f3, rect.right - f2, rect.bottom - f3);
        Drawable wrappedDrawable = getWrappedDrawable();
        RectF rectF = this.f7262i;
        wrappedDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        b();
    }

    private void b() {
        float f2 = this.f7263j;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        RectF rectF2 = new RectF(rectF);
        float f3 = this.n;
        rectF2.inset(-f3, -f3);
        Path path = this.k;
        if (path == null) {
            this.k = new Path();
        } else {
            path.reset();
        }
        this.k.setFillType(Path.FillType.EVEN_ODD);
        this.k.moveTo(-this.f7263j, 0.0f);
        this.k.rLineTo(-this.n, 0.0f);
        this.k.arcTo(rectF2, 180.0f, 90.0f, false);
        this.k.arcTo(rectF, 270.0f, -90.0f, false);
        this.k.close();
        float f4 = -rectF2.top;
        if (f4 > 0.0f) {
            float f5 = this.f7263j / f4;
            this.f7260g.setShader(new RadialGradient(0.0f, 0.0f, f4, new int[]{0, this.q, this.r, this.s}, new float[]{0.0f, f5, ((1.0f - f5) / 2.0f) + f5, 1.0f}, Shader.TileMode.CLAMP));
        }
        this.f7261h.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.q, this.r, this.s}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f7261h.setAntiAlias(false);
    }

    public static float c(float f2, float f3, boolean z) {
        if (!z) {
            return f2;
        }
        double d2 = f2;
        double d3 = 1.0d - f7255b;
        double d4 = f3;
        Double.isNaN(d4);
        Double.isNaN(d2);
        return (float) (d2 + (d3 * d4));
    }

    public static float d(float f2, float f3, boolean z) {
        if (!z) {
            return f2 * f7256c;
        }
        double d2 = f2 * f7256c;
        double d3 = 1.0d - f7255b;
        double d4 = f3;
        Double.isNaN(d4);
        Double.isNaN(d2);
        return (float) (d2 + (d3 * d4));
    }

    private void e(@NonNull Canvas canvas) {
        int i2;
        float f2;
        int i3;
        float f3;
        float f4;
        float f5;
        int save = canvas.save();
        canvas.rotate(this.u, this.f7262i.centerX(), this.f7262i.centerY());
        float f6 = this.f7263j;
        float f7 = (-f6) - this.n;
        float f8 = f6 * 2.0f;
        boolean z = this.f7262i.width() - f8 > 0.0f;
        boolean z2 = this.f7262i.height() - f8 > 0.0f;
        float f9 = this.o;
        float f10 = f6 / ((f9 - (0.5f * f9)) + f6);
        float f11 = f6 / ((f9 - (f7257d * f9)) + f6);
        float f12 = f6 / ((f9 - (f9 * 1.0f)) + f6);
        int save2 = canvas.save();
        RectF rectF = this.f7262i;
        canvas.translate(rectF.left + f6, rectF.top + f6);
        canvas.scale(f10, f11);
        canvas.drawPath(this.k, this.f7260g);
        if (z) {
            canvas.scale(1.0f / f10, 1.0f);
            i2 = save2;
            f2 = f12;
            i3 = save;
            f3 = f11;
            canvas.drawRect(0.0f, f7, this.f7262i.width() - f8, -this.f7263j, this.f7261h);
        } else {
            i2 = save2;
            f2 = f12;
            i3 = save;
            f3 = f11;
        }
        canvas.restoreToCount(i2);
        int save3 = canvas.save();
        RectF rectF2 = this.f7262i;
        canvas.translate(rectF2.right - f6, rectF2.bottom - f6);
        float f13 = f2;
        canvas.scale(f10, f13);
        canvas.rotate(180.0f);
        canvas.drawPath(this.k, this.f7260g);
        if (z) {
            canvas.scale(1.0f / f10, 1.0f);
            f4 = f3;
            f5 = f13;
            canvas.drawRect(0.0f, f7, this.f7262i.width() - f8, (-this.f7263j) + this.n, this.f7261h);
        } else {
            f4 = f3;
            f5 = f13;
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF3 = this.f7262i;
        canvas.translate(rectF3.left + f6, rectF3.bottom - f6);
        canvas.scale(f10, f5);
        canvas.rotate(270.0f);
        canvas.drawPath(this.k, this.f7260g);
        if (z2) {
            canvas.scale(1.0f / f5, 1.0f);
            canvas.drawRect(0.0f, f7, this.f7262i.height() - f8, -this.f7263j, this.f7261h);
        }
        canvas.restoreToCount(save4);
        int save5 = canvas.save();
        RectF rectF4 = this.f7262i;
        canvas.translate(rectF4.right - f6, rectF4.top + f6);
        float f14 = f4;
        canvas.scale(f10, f14);
        canvas.rotate(90.0f);
        canvas.drawPath(this.k, this.f7260g);
        if (z2) {
            canvas.scale(1.0f / f14, 1.0f);
            canvas.drawRect(0.0f, f7, this.f7262i.height() - f8, -this.f7263j, this.f7261h);
        }
        canvas.restoreToCount(save5);
        canvas.restoreToCount(i3);
    }

    private static int q(float f2) {
        int round = Math.round(f2);
        return round % 2 == 1 ? round - 1 : round;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.p) {
            a(getBounds());
            this.p = false;
        }
        e(canvas);
        super.draw(canvas);
    }

    public float f() {
        return this.f7263j;
    }

    public float g() {
        return this.m;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        int ceil = (int) Math.ceil(d(this.m, this.f7263j, this.t));
        int ceil2 = (int) Math.ceil(c(this.m, this.f7263j, this.t));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public float h() {
        float f2 = this.m;
        return (Math.max(f2, this.f7263j + ((f2 * f7256c) / 2.0f)) * 2.0f) + (this.m * f7256c * 2.0f);
    }

    public float i() {
        float f2 = this.m;
        return (Math.max(f2, this.f7263j + (f2 / 2.0f)) * 2.0f) + (this.m * 2.0f);
    }

    public float j() {
        return this.o;
    }

    public void k(boolean z) {
        this.t = z;
        invalidateSelf();
    }

    public void l(float f2) {
        float round = Math.round(f2);
        if (this.f7263j == round) {
            return;
        }
        this.f7263j = round;
        this.p = true;
        invalidateSelf();
    }

    public void m(float f2) {
        p(this.o, f2);
    }

    public final void n(float f2) {
        if (this.u != f2) {
            this.u = f2;
            invalidateSelf();
        }
    }

    public void o(float f2) {
        p(f2, this.m);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.p = true;
    }

    public void p(float f2, float f3) {
        if (f2 < 0.0f || f3 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float q = q(f2);
        float q2 = q(f3);
        if (q > q2) {
            if (!this.v) {
                this.v = true;
            }
            q = q2;
        }
        if (this.o == q && this.m == q2) {
            return;
        }
        this.o = q;
        this.m = q2;
        this.n = Math.round(q * f7256c);
        this.l = q2;
        this.p = true;
        invalidateSelf();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        super.setAlpha(i2);
        this.f7260g.setAlpha(i2);
        this.f7261h.setAlpha(i2);
    }
}
