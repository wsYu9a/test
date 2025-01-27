package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes.dex */
class RoundRectDrawable extends Drawable {

    /* renamed from: a */
    private float f1102a;

    /* renamed from: c */
    private final RectF f1104c;

    /* renamed from: d */
    private final Rect f1105d;

    /* renamed from: e */
    private float f1106e;

    /* renamed from: h */
    private ColorStateList f1109h;

    /* renamed from: i */
    private PorterDuffColorFilter f1110i;

    /* renamed from: j */
    private ColorStateList f1111j;

    /* renamed from: f */
    private boolean f1107f = false;

    /* renamed from: g */
    private boolean f1108g = true;
    private PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    private final Paint f1103b = new Paint(5);

    RoundRectDrawable(ColorStateList colorStateList, float f2) {
        this.f1102a = f2;
        c(colorStateList);
        this.f1104c = new RectF();
        this.f1105d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void c(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1109h = colorStateList;
        this.f1103b.setColor(colorStateList.getColorForState(getState(), this.f1109h.getDefaultColor()));
    }

    private void f(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f1104c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f1105d.set(rect);
        if (this.f1107f) {
            this.f1105d.inset((int) Math.ceil(RoundRectDrawableWithShadow.c(this.f1106e, this.f1102a, this.f1108g)), (int) Math.ceil(RoundRectDrawableWithShadow.d(this.f1106e, this.f1102a, this.f1108g)));
            this.f1104c.set(this.f1105d);
        }
    }

    float b() {
        return this.f1106e;
    }

    void d(float f2, boolean z, boolean z2) {
        if (f2 == this.f1106e && this.f1107f == z && this.f1108g == z2) {
            return;
        }
        this.f1106e = f2;
        this.f1107f = z;
        this.f1108g = z2;
        f(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f1103b;
        if (this.f1110i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f1110i);
            z = true;
        }
        RectF rectF = this.f1104c;
        float f2 = this.f1102a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    void e(float f2) {
        if (f2 == this.f1102a) {
            return;
        }
        this.f1102a = f2;
        f(null);
        invalidateSelf();
    }

    public ColorStateList getColor() {
        return this.f1109h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f1105d, this.f1102a);
    }

    public float getRadius() {
        return this.f1102a;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f1111j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f1109h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        f(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f1109h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.f1103b.getColor();
        if (z) {
            this.f1103b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f1111j;
        if (colorStateList2 == null || (mode = this.k) == null) {
            return z;
        }
        this.f1110i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f1103b.setAlpha(i2);
    }

    public void setColor(@Nullable ColorStateList colorStateList) {
        c(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1103b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f1111j = colorStateList;
        this.f1110i = a(colorStateList, this.k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.k = mode;
        this.f1110i = a(this.f1111j, mode);
        invalidateSelf();
    }
}
