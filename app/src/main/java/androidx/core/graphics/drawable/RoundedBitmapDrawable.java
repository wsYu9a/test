package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class RoundedBitmapDrawable extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private static final int f1780a = 3;

    /* renamed from: b, reason: collision with root package name */
    final Bitmap f1781b;

    /* renamed from: c, reason: collision with root package name */
    private int f1782c;

    /* renamed from: f, reason: collision with root package name */
    private final BitmapShader f1785f;

    /* renamed from: h, reason: collision with root package name */
    private float f1787h;
    private boolean l;
    private int m;
    private int n;

    /* renamed from: d, reason: collision with root package name */
    private int f1783d = 119;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f1784e = new Paint(3);

    /* renamed from: g, reason: collision with root package name */
    private final Matrix f1786g = new Matrix();

    /* renamed from: i, reason: collision with root package name */
    final Rect f1788i = new Rect();

    /* renamed from: j, reason: collision with root package name */
    private final RectF f1789j = new RectF();
    private boolean k = true;

    RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        this.f1782c = 160;
        if (resources != null) {
            this.f1782c = resources.getDisplayMetrics().densityDpi;
        }
        this.f1781b = bitmap;
        if (bitmap != null) {
            a();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f1785f = new BitmapShader(bitmap, tileMode, tileMode);
        } else {
            this.n = -1;
            this.m = -1;
            this.f1785f = null;
        }
    }

    private void a() {
        this.m = this.f1781b.getScaledWidth(this.f1782c);
        this.n = this.f1781b.getScaledHeight(this.f1782c);
    }

    private static boolean c(float f2) {
        return f2 > 0.05f;
    }

    private void d() {
        this.f1787h = Math.min(this.n, this.m) / 2;
    }

    void b(int i2, int i3, int i4, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Bitmap bitmap = this.f1781b;
        if (bitmap == null) {
            return;
        }
        e();
        if (this.f1784e.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f1788i, this.f1784e);
            return;
        }
        RectF rectF = this.f1789j;
        float f2 = this.f1787h;
        canvas.drawRoundRect(rectF, f2, f2, this.f1784e);
    }

    void e() {
        if (this.k) {
            if (this.l) {
                int min = Math.min(this.m, this.n);
                b(this.f1783d, min, min, getBounds(), this.f1788i);
                int min2 = Math.min(this.f1788i.width(), this.f1788i.height());
                this.f1788i.inset(Math.max(0, (this.f1788i.width() - min2) / 2), Math.max(0, (this.f1788i.height() - min2) / 2));
                this.f1787h = min2 * 0.5f;
            } else {
                b(this.f1783d, this.m, this.n, getBounds(), this.f1788i);
            }
            this.f1789j.set(this.f1788i);
            if (this.f1785f != null) {
                Matrix matrix = this.f1786g;
                RectF rectF = this.f1789j;
                matrix.setTranslate(rectF.left, rectF.top);
                this.f1786g.preScale(this.f1789j.width() / this.f1781b.getWidth(), this.f1789j.height() / this.f1781b.getHeight());
                this.f1785f.setLocalMatrix(this.f1786g);
                this.f1784e.setShader(this.f1785f);
            }
            this.k = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1784e.getAlpha();
    }

    @Nullable
    public final Bitmap getBitmap() {
        return this.f1781b;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f1784e.getColorFilter();
    }

    public float getCornerRadius() {
        return this.f1787h;
    }

    public int getGravity() {
        return this.f1783d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        return (this.f1783d != 119 || this.l || (bitmap = this.f1781b) == null || bitmap.hasAlpha() || this.f1784e.getAlpha() < 255 || c(this.f1787h)) ? -3 : -1;
    }

    @NonNull
    public final Paint getPaint() {
        return this.f1784e;
    }

    public boolean hasAntiAlias() {
        return this.f1784e.isAntiAlias();
    }

    public boolean hasMipMap() {
        throw new UnsupportedOperationException();
    }

    public boolean isCircular() {
        return this.l;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.l) {
            d();
        }
        this.k = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (i2 != this.f1784e.getAlpha()) {
            this.f1784e.setAlpha(i2);
            invalidateSelf();
        }
    }

    public void setAntiAlias(boolean z) {
        this.f1784e.setAntiAlias(z);
        invalidateSelf();
    }

    public void setCircular(boolean z) {
        this.l = z;
        this.k = true;
        if (!z) {
            setCornerRadius(0.0f);
            return;
        }
        d();
        this.f1784e.setShader(this.f1785f);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1784e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setCornerRadius(float f2) {
        if (this.f1787h == f2) {
            return;
        }
        this.l = false;
        if (c(f2)) {
            this.f1784e.setShader(this.f1785f);
        } else {
            this.f1784e.setShader(null);
        }
        this.f1787h = f2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f1784e.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f1784e.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setGravity(int i2) {
        if (this.f1783d != i2) {
            this.f1783d = i2;
            this.k = true;
            invalidateSelf();
        }
    }

    public void setMipMap(boolean z) {
        throw new UnsupportedOperationException();
    }

    public void setTargetDensity(@NonNull Canvas canvas) {
        setTargetDensity(canvas.getDensity());
    }

    public void setTargetDensity(@NonNull DisplayMetrics displayMetrics) {
        setTargetDensity(displayMetrics.densityDpi);
    }

    public void setTargetDensity(int i2) {
        if (this.f1782c != i2) {
            if (i2 == 0) {
                i2 = 160;
            }
            this.f1782c = i2;
            if (this.f1781b != null) {
                a();
            }
            invalidateSelf();
        }
    }
}
