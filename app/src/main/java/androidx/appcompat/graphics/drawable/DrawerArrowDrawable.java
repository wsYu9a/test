package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class DrawerArrowDrawable extends Drawable {
    public static final int ARROW_DIRECTION_END = 3;
    public static final int ARROW_DIRECTION_LEFT = 0;
    public static final int ARROW_DIRECTION_RIGHT = 1;
    public static final int ARROW_DIRECTION_START = 2;

    /* renamed from: a */
    private static final float f390a = (float) Math.toRadians(45.0d);

    /* renamed from: b */
    private final Paint f391b;

    /* renamed from: c */
    private float f392c;

    /* renamed from: d */
    private float f393d;

    /* renamed from: e */
    private float f394e;

    /* renamed from: f */
    private float f395f;

    /* renamed from: g */
    private boolean f396g;

    /* renamed from: h */
    private final Path f397h;

    /* renamed from: i */
    private final int f398i;

    /* renamed from: j */
    private boolean f399j;
    private float k;
    private float l;
    private int m;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ArrowDirection {
    }

    public DrawerArrowDrawable(Context context) {
        Paint paint = new Paint();
        this.f391b = paint;
        this.f397h = new Path();
        this.f399j = false;
        this.m = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        setColor(obtainStyledAttributes.getColor(R.styleable.DrawerArrowToggle_color, 0));
        setBarThickness(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f));
        setSpinEnabled(obtainStyledAttributes.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
        setGapSize(Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.f398i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.f393d = Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0f));
        this.f392c = Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.f394e = obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private static float a(float f2, float f3, float f4) {
        return f2 + ((f3 - f2) * f4);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i2 = this.m;
        boolean z = false;
        if (i2 != 0 && (i2 == 1 || (i2 == 3 ? DrawableCompat.getLayoutDirection(this) == 0 : DrawableCompat.getLayoutDirection(this) == 1))) {
            z = true;
        }
        float f2 = this.f392c;
        float a2 = a(this.f393d, (float) Math.sqrt(f2 * f2 * 2.0f), this.k);
        float a3 = a(this.f393d, this.f394e, this.k);
        float round = Math.round(a(0.0f, this.l, this.k));
        float a4 = a(0.0f, f390a, this.k);
        float a5 = a(z ? 0.0f : -180.0f, z ? 180.0f : 0.0f, this.k);
        double d2 = a2;
        double d3 = a4;
        double cos = Math.cos(d3);
        Double.isNaN(d2);
        boolean z2 = z;
        float round2 = Math.round(cos * d2);
        double sin = Math.sin(d3);
        Double.isNaN(d2);
        float round3 = Math.round(d2 * sin);
        this.f397h.rewind();
        float a6 = a(this.f395f + this.f391b.getStrokeWidth(), -this.l, this.k);
        float f3 = (-a3) / 2.0f;
        this.f397h.moveTo(f3 + round, 0.0f);
        this.f397h.rLineTo(a3 - (round * 2.0f), 0.0f);
        this.f397h.moveTo(f3, a6);
        this.f397h.rLineTo(round2, round3);
        this.f397h.moveTo(f3, -a6);
        this.f397h.rLineTo(round2, -round3);
        this.f397h.close();
        canvas.save();
        float strokeWidth = this.f391b.getStrokeWidth();
        float height = bounds.height() - (3.0f * strokeWidth);
        canvas.translate(bounds.centerX(), ((((int) (height - (2.0f * r5))) / 4) * 2) + (strokeWidth * 1.5f) + this.f395f);
        if (this.f396g) {
            canvas.rotate(a5 * (this.f399j ^ z2 ? -1 : 1));
        } else if (z2) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f397h, this.f391b);
        canvas.restore();
    }

    public float getArrowHeadLength() {
        return this.f392c;
    }

    public float getArrowShaftLength() {
        return this.f394e;
    }

    public float getBarLength() {
        return this.f393d;
    }

    public float getBarThickness() {
        return this.f391b.getStrokeWidth();
    }

    @ColorInt
    public int getColor() {
        return this.f391b.getColor();
    }

    public int getDirection() {
        return this.m;
    }

    public float getGapSize() {
        return this.f395f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f398i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f398i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final Paint getPaint() {
        return this.f391b;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.k;
    }

    public boolean isSpinEnabled() {
        return this.f396g;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (i2 != this.f391b.getAlpha()) {
            this.f391b.setAlpha(i2);
            invalidateSelf();
        }
    }

    public void setArrowHeadLength(float f2) {
        if (this.f392c != f2) {
            this.f392c = f2;
            invalidateSelf();
        }
    }

    public void setArrowShaftLength(float f2) {
        if (this.f394e != f2) {
            this.f394e = f2;
            invalidateSelf();
        }
    }

    public void setBarLength(float f2) {
        if (this.f393d != f2) {
            this.f393d = f2;
            invalidateSelf();
        }
    }

    public void setBarThickness(float f2) {
        if (this.f391b.getStrokeWidth() != f2) {
            this.f391b.setStrokeWidth(f2);
            double d2 = f2 / 2.0f;
            double cos = Math.cos(f390a);
            Double.isNaN(d2);
            this.l = (float) (d2 * cos);
            invalidateSelf();
        }
    }

    public void setColor(@ColorInt int i2) {
        if (i2 != this.f391b.getColor()) {
            this.f391b.setColor(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f391b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setDirection(int i2) {
        if (i2 != this.m) {
            this.m = i2;
            invalidateSelf();
        }
    }

    public void setGapSize(float f2) {
        if (f2 != this.f395f) {
            this.f395f = f2;
            invalidateSelf();
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.k != f2) {
            this.k = f2;
            invalidateSelf();
        }
    }

    public void setSpinEnabled(boolean z) {
        if (this.f396g != z) {
            this.f396g = z;
            invalidateSelf();
        }
    }

    public void setVerticalMirror(boolean z) {
        if (this.f399j != z) {
            this.f399j = z;
            invalidateSelf();
        }
    }
}
