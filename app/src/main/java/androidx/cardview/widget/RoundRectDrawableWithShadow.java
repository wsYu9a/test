package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.cardview.R;

/* loaded from: classes.dex */
class RoundRectDrawableWithShadow extends Drawable {

    /* renamed from: a */
    private static final double f1112a = Math.cos(Math.toRadians(45.0d));

    /* renamed from: b */
    private static final float f1113b = 1.5f;

    /* renamed from: c */
    static RoundRectHelper f1114c;

    /* renamed from: d */
    private final int f1115d;

    /* renamed from: f */
    private Paint f1117f;

    /* renamed from: g */
    private Paint f1118g;

    /* renamed from: h */
    private final RectF f1119h;

    /* renamed from: i */
    private float f1120i;

    /* renamed from: j */
    private Path f1121j;
    private float k;
    private float l;
    private float m;
    private ColorStateList n;
    private final int p;
    private final int q;
    private boolean o = true;
    private boolean r = true;
    private boolean s = false;

    /* renamed from: e */
    private Paint f1116e = new Paint(5);

    interface RoundRectHelper {
        void drawRoundRect(Canvas canvas, RectF rectF, float f2, Paint paint);
    }

    RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f2, float f3, float f4) {
        this.p = resources.getColor(R.color.cardview_shadow_start_color);
        this.q = resources.getColor(R.color.cardview_shadow_end_color);
        this.f1115d = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        n(colorStateList);
        Paint paint = new Paint(5);
        this.f1117f = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f1120i = (int) (f2 + 0.5f);
        this.f1119h = new RectF();
        Paint paint2 = new Paint(this.f1117f);
        this.f1118g = paint2;
        paint2.setAntiAlias(false);
        s(f3, f4);
    }

    private void a(Rect rect) {
        float f2 = this.k;
        float f3 = f1113b * f2;
        this.f1119h.set(rect.left + f2, rect.top + f3, rect.right - f2, rect.bottom - f3);
        b();
    }

    private void b() {
        float f2 = this.f1120i;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        RectF rectF2 = new RectF(rectF);
        float f3 = this.l;
        rectF2.inset(-f3, -f3);
        Path path = this.f1121j;
        if (path == null) {
            this.f1121j = new Path();
        } else {
            path.reset();
        }
        this.f1121j.setFillType(Path.FillType.EVEN_ODD);
        this.f1121j.moveTo(-this.f1120i, 0.0f);
        this.f1121j.rLineTo(-this.l, 0.0f);
        this.f1121j.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f1121j.arcTo(rectF, 270.0f, -90.0f, false);
        this.f1121j.close();
        float f4 = this.f1120i;
        float f5 = f4 / (this.l + f4);
        Paint paint = this.f1117f;
        float f6 = this.f1120i + this.l;
        int i2 = this.p;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f6, new int[]{i2, i2, this.q}, new float[]{0.0f, f5, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f1118g;
        float f7 = this.f1120i;
        float f8 = this.l;
        int i3 = this.p;
        paint2.setShader(new LinearGradient(0.0f, (-f7) + f8, 0.0f, (-f7) - f8, new int[]{i3, i3, this.q}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f1118g.setAntiAlias(false);
    }

    static float c(float f2, float f3, boolean z) {
        if (!z) {
            return f2;
        }
        double d2 = f2;
        double d3 = 1.0d - f1112a;
        double d4 = f3;
        Double.isNaN(d4);
        Double.isNaN(d2);
        return (float) (d2 + (d3 * d4));
    }

    static float d(float f2, float f3, boolean z) {
        if (!z) {
            return f2 * f1113b;
        }
        double d2 = f2 * f1113b;
        double d3 = 1.0d - f1112a;
        double d4 = f3;
        Double.isNaN(d4);
        Double.isNaN(d2);
        return (float) (d2 + (d3 * d4));
    }

    private void e(Canvas canvas) {
        float f2 = this.f1120i;
        float f3 = (-f2) - this.l;
        float f4 = f2 + this.f1115d + (this.m / 2.0f);
        float f5 = f4 * 2.0f;
        boolean z = this.f1119h.width() - f5 > 0.0f;
        boolean z2 = this.f1119h.height() - f5 > 0.0f;
        int save = canvas.save();
        RectF rectF = this.f1119h;
        canvas.translate(rectF.left + f4, rectF.top + f4);
        canvas.drawPath(this.f1121j, this.f1117f);
        if (z) {
            canvas.drawRect(0.0f, f3, this.f1119h.width() - f5, -this.f1120i, this.f1118g);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        RectF rectF2 = this.f1119h;
        canvas.translate(rectF2.right - f4, rectF2.bottom - f4);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f1121j, this.f1117f);
        if (z) {
            canvas.drawRect(0.0f, f3, this.f1119h.width() - f5, (-this.f1120i) + this.l, this.f1118g);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        RectF rectF3 = this.f1119h;
        canvas.translate(rectF3.left + f4, rectF3.bottom - f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f1121j, this.f1117f);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.f1119h.height() - f5, -this.f1120i, this.f1118g);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF4 = this.f1119h;
        canvas.translate(rectF4.right - f4, rectF4.top + f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f1121j, this.f1117f);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.f1119h.height() - f5, -this.f1120i, this.f1118g);
        }
        canvas.restoreToCount(save4);
    }

    private void n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.n = colorStateList;
        this.f1116e.setColor(colorStateList.getColorForState(getState(), this.n.getDefaultColor()));
    }

    private void s(float f2, float f3) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f2 + ". Must be >= 0");
        }
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f3 + ". Must be >= 0");
        }
        float t = t(f2);
        float t2 = t(f3);
        if (t > t2) {
            if (!this.s) {
                this.s = true;
            }
            t = t2;
        }
        if (this.m == t && this.k == t2) {
            return;
        }
        this.m = t;
        this.k = t2;
        this.l = (int) ((t * f1113b) + this.f1115d + 0.5f);
        this.o = true;
        invalidateSelf();
    }

    private int t(float f2) {
        int i2 = (int) (f2 + 0.5f);
        return i2 % 2 == 1 ? i2 - 1 : i2;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.o) {
            a(getBounds());
            this.o = false;
        }
        canvas.translate(0.0f, this.m / 2.0f);
        e(canvas);
        canvas.translate(0.0f, (-this.m) / 2.0f);
        f1114c.drawRoundRect(canvas, this.f1119h, this.f1120i, this.f1116e);
    }

    ColorStateList f() {
        return this.n;
    }

    float g() {
        return this.f1120i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil(d(this.k, this.f1120i, this.r));
        int ceil2 = (int) Math.ceil(c(this.k, this.f1120i, this.r));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    void h(Rect rect) {
        getPadding(rect);
    }

    float i() {
        return this.k;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.n;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    float j() {
        float f2 = this.k;
        return (Math.max(f2, this.f1120i + this.f1115d + ((f2 * f1113b) / 2.0f)) * 2.0f) + (((this.k * f1113b) + this.f1115d) * 2.0f);
    }

    float k() {
        float f2 = this.k;
        return (Math.max(f2, this.f1120i + this.f1115d + (f2 / 2.0f)) * 2.0f) + ((this.k + this.f1115d) * 2.0f);
    }

    float l() {
        return this.m;
    }

    void m(boolean z) {
        this.r = z;
        invalidateSelf();
    }

    void o(@Nullable ColorStateList colorStateList) {
        n(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.o = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.n;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f1116e.getColor() == colorForState) {
            return false;
        }
        this.f1116e.setColor(colorForState);
        this.o = true;
        invalidateSelf();
        return true;
    }

    void p(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f2 + ". Must be >= 0");
        }
        float f3 = (int) (f2 + 0.5f);
        if (this.f1120i == f3) {
            return;
        }
        this.f1120i = f3;
        this.o = true;
        invalidateSelf();
    }

    void q(float f2) {
        s(this.m, f2);
    }

    void r(float f2) {
        s(f2, this.k);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f1116e.setAlpha(i2);
        this.f1117f.setAlpha(i2);
        this.f1118g.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1116e.setColorFilter(colorFilter);
    }
}
