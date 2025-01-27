package com.martian.libmars.widget.o;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import java.util.HashSet;

/* loaded from: classes2.dex */
public class b extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10419a = "RoundedDrawable";

    /* renamed from: b, reason: collision with root package name */
    public static final int f10420b = -16777216;

    /* renamed from: c, reason: collision with root package name */
    private final RectF f10421c = new RectF();

    /* renamed from: d, reason: collision with root package name */
    private final RectF f10422d = new RectF();

    /* renamed from: e, reason: collision with root package name */
    private final RectF f10423e;

    /* renamed from: f, reason: collision with root package name */
    private final Bitmap f10424f;

    /* renamed from: g, reason: collision with root package name */
    private final Paint f10425g;

    /* renamed from: h, reason: collision with root package name */
    private final int f10426h;

    /* renamed from: i, reason: collision with root package name */
    private final int f10427i;

    /* renamed from: j, reason: collision with root package name */
    private final RectF f10428j;
    private final Paint k;
    private final Matrix l;
    private final RectF m;
    private Shader.TileMode n;
    private Shader.TileMode o;
    private boolean p;
    private float q;
    private final boolean[] r;
    private boolean s;
    private float t;
    private ColorStateList u;
    private ImageView.ScaleType v;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10429a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f10429a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10429a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10429a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10429a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10429a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10429a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10429a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public b(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.f10423e = rectF;
        this.f10428j = new RectF();
        this.l = new Matrix();
        this.m = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.n = tileMode;
        this.o = tileMode;
        this.p = true;
        this.q = 0.0f;
        this.r = new boolean[]{true, true, true, true};
        this.s = false;
        this.t = 0.0f;
        this.u = ColorStateList.valueOf(-16777216);
        this.v = ImageView.ScaleType.FIT_CENTER;
        this.f10424f = bitmap;
        int width = bitmap.getWidth();
        this.f10426h = width;
        int height = bitmap.getHeight();
        this.f10427i = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.f10425g = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.k = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.u.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.t);
    }

    private void D() {
        float width;
        float height;
        int i2 = a.f10429a[this.v.ordinal()];
        if (i2 == 1) {
            this.f10428j.set(this.f10421c);
            RectF rectF = this.f10428j;
            float f2 = this.t;
            rectF.inset(f2 / 2.0f, f2 / 2.0f);
            this.l.reset();
            this.l.setTranslate((int) (((this.f10428j.width() - this.f10426h) * 0.5f) + 0.5f), (int) (((this.f10428j.height() - this.f10427i) * 0.5f) + 0.5f));
        } else if (i2 == 2) {
            this.f10428j.set(this.f10421c);
            RectF rectF2 = this.f10428j;
            float f3 = this.t;
            rectF2.inset(f3 / 2.0f, f3 / 2.0f);
            this.l.reset();
            float f4 = 0.0f;
            if (this.f10426h * this.f10428j.height() > this.f10428j.width() * this.f10427i) {
                width = this.f10428j.height() / this.f10427i;
                f4 = (this.f10428j.width() - (this.f10426h * width)) * 0.5f;
                height = 0.0f;
            } else {
                width = this.f10428j.width() / this.f10426h;
                height = (this.f10428j.height() - (this.f10427i * width)) * 0.5f;
            }
            this.l.setScale(width, width);
            Matrix matrix = this.l;
            float f5 = this.t;
            matrix.postTranslate(((int) (f4 + 0.5f)) + (f5 / 2.0f), ((int) (height + 0.5f)) + (f5 / 2.0f));
        } else if (i2 == 3) {
            this.l.reset();
            float min = (((float) this.f10426h) > this.f10421c.width() || ((float) this.f10427i) > this.f10421c.height()) ? Math.min(this.f10421c.width() / this.f10426h, this.f10421c.height() / this.f10427i) : 1.0f;
            float width2 = (int) (((this.f10421c.width() - (this.f10426h * min)) * 0.5f) + 0.5f);
            float height2 = (int) (((this.f10421c.height() - (this.f10427i * min)) * 0.5f) + 0.5f);
            this.l.setScale(min, min);
            this.l.postTranslate(width2, height2);
            this.f10428j.set(this.f10423e);
            this.l.mapRect(this.f10428j);
            RectF rectF3 = this.f10428j;
            float f6 = this.t;
            rectF3.inset(f6 / 2.0f, f6 / 2.0f);
            this.l.setRectToRect(this.f10423e, this.f10428j, Matrix.ScaleToFit.FILL);
        } else if (i2 == 5) {
            this.f10428j.set(this.f10423e);
            this.l.setRectToRect(this.f10423e, this.f10421c, Matrix.ScaleToFit.END);
            this.l.mapRect(this.f10428j);
            RectF rectF4 = this.f10428j;
            float f7 = this.t;
            rectF4.inset(f7 / 2.0f, f7 / 2.0f);
            this.l.setRectToRect(this.f10423e, this.f10428j, Matrix.ScaleToFit.FILL);
        } else if (i2 == 6) {
            this.f10428j.set(this.f10423e);
            this.l.setRectToRect(this.f10423e, this.f10421c, Matrix.ScaleToFit.START);
            this.l.mapRect(this.f10428j);
            RectF rectF5 = this.f10428j;
            float f8 = this.t;
            rectF5.inset(f8 / 2.0f, f8 / 2.0f);
            this.l.setRectToRect(this.f10423e, this.f10428j, Matrix.ScaleToFit.FILL);
        } else if (i2 != 7) {
            this.f10428j.set(this.f10423e);
            this.l.setRectToRect(this.f10423e, this.f10421c, Matrix.ScaleToFit.CENTER);
            this.l.mapRect(this.f10428j);
            RectF rectF6 = this.f10428j;
            float f9 = this.t;
            rectF6.inset(f9 / 2.0f, f9 / 2.0f);
            this.l.setRectToRect(this.f10423e, this.f10428j, Matrix.ScaleToFit.FILL);
        } else {
            this.f10428j.set(this.f10421c);
            RectF rectF7 = this.f10428j;
            float f10 = this.t;
            rectF7.inset(f10 / 2.0f, f10 / 2.0f);
            this.l.reset();
            this.l.setRectToRect(this.f10423e, this.f10428j, Matrix.ScaleToFit.FILL);
        }
        this.f10422d.set(this.f10428j);
        this.p = true;
    }

    private static boolean a(boolean[] booleans) {
        for (boolean z : booleans) {
            if (z) {
                return false;
            }
        }
        return true;
    }

    private static boolean b(boolean[] booleans) {
        for (boolean z : booleans) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    public static Bitmap c(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Throwable th) {
            th.printStackTrace();
            Log.w(f10419a, "Failed to create bitmap from drawable!");
            return null;
        }
    }

    public static b d(Bitmap bitmap) {
        if (bitmap != null) {
            return new b(bitmap);
        }
        return null;
    }

    public static Drawable e(Drawable drawable) {
        if (drawable == null || (drawable instanceof b)) {
            return drawable;
        }
        if (!(drawable instanceof LayerDrawable)) {
            Bitmap c2 = c(drawable);
            return c2 != null ? new b(c2) : drawable;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        for (int i2 = 0; i2 < numberOfLayers; i2++) {
            layerDrawable.setDrawableByLayerId(layerDrawable.getId(i2), e(layerDrawable.getDrawable(i2)));
        }
        return layerDrawable;
    }

    private static boolean p(int index, boolean[] booleans) {
        int length = booleans.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                return true;
            }
            if (booleans[i2] != (i2 == index)) {
                return false;
            }
            i2++;
        }
    }

    private void q(Canvas canvas) {
        if (a(this.r) || this.q == 0.0f) {
            return;
        }
        RectF rectF = this.f10422d;
        float f2 = rectF.left;
        float f3 = rectF.top;
        float width = rectF.width() + f2;
        float height = this.f10422d.height() + f3;
        float f4 = this.q;
        if (!this.r[0]) {
            this.m.set(f2, f3, f2 + f4, f3 + f4);
            canvas.drawRect(this.m, this.f10425g);
        }
        if (!this.r[1]) {
            this.m.set(width - f4, f3, width, f4);
            canvas.drawRect(this.m, this.f10425g);
        }
        if (!this.r[2]) {
            this.m.set(width - f4, height - f4, width, height);
            canvas.drawRect(this.m, this.f10425g);
        }
        if (this.r[3]) {
            return;
        }
        this.m.set(f2, height - f4, f4 + f2, height);
        canvas.drawRect(this.m, this.f10425g);
    }

    private void r(Canvas canvas) {
        float f2;
        if (a(this.r) || this.q == 0.0f) {
            return;
        }
        RectF rectF = this.f10422d;
        float f3 = rectF.left;
        float f4 = rectF.top;
        float width = rectF.width() + f3;
        float height = f4 + this.f10422d.height();
        float f5 = this.q;
        float f6 = this.t / 2.0f;
        if (!this.r[0]) {
            canvas.drawLine(f3 - f6, f4, f3 + f5, f4, this.k);
            canvas.drawLine(f3, f4 - f6, f3, f4 + f5, this.k);
        }
        if (!this.r[1]) {
            canvas.drawLine((width - f5) - f6, f4, width, f4, this.k);
            canvas.drawLine(width, f4 - f6, width, f4 + f5, this.k);
        }
        if (this.r[2]) {
            f2 = f5;
        } else {
            f2 = f5;
            canvas.drawLine((width - f5) - f6, height, width + f6, height, this.k);
            canvas.drawLine(width, height - f2, width, height, this.k);
        }
        if (this.r[3]) {
            return;
        }
        canvas.drawLine(f3 - f6, height, f3 + f2, height, this.k);
        canvas.drawLine(f3, height - f2, f3, height, this.k);
    }

    public b A(Shader.TileMode tileModeX) {
        if (this.n != tileModeX) {
            this.n = tileModeX;
            this.p = true;
            invalidateSelf();
        }
        return this;
    }

    public b B(Shader.TileMode tileModeY) {
        if (this.o != tileModeY) {
            this.o = tileModeY;
            this.p = true;
            invalidateSelf();
        }
        return this;
    }

    public Bitmap C() {
        return c(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.p) {
            BitmapShader bitmapShader = new BitmapShader(this.f10424f, this.n, this.o);
            Shader.TileMode tileMode = this.n;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.o == tileMode2) {
                bitmapShader.setLocalMatrix(this.l);
            }
            this.f10425g.setShader(bitmapShader);
            this.p = false;
        }
        if (this.s) {
            if (this.t <= 0.0f) {
                canvas.drawOval(this.f10422d, this.f10425g);
                return;
            } else {
                canvas.drawOval(this.f10422d, this.f10425g);
                canvas.drawOval(this.f10428j, this.k);
                return;
            }
        }
        if (!b(this.r)) {
            canvas.drawRect(this.f10422d, this.f10425g);
            if (this.t > 0.0f) {
                canvas.drawRect(this.f10428j, this.k);
                return;
            }
            return;
        }
        float f2 = this.q;
        if (this.t <= 0.0f) {
            canvas.drawRoundRect(this.f10422d, f2, f2, this.f10425g);
            q(canvas);
        } else {
            canvas.drawRoundRect(this.f10422d, f2, f2, this.f10425g);
            canvas.drawRoundRect(this.f10428j, f2, f2, this.k);
            q(canvas);
            r(canvas);
        }
    }

    public int f() {
        return this.u.getDefaultColor();
    }

    public ColorStateList g() {
        return this.u;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f10425g.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f10425g.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f10427i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f10426h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float h() {
        return this.t;
    }

    public float i() {
        return this.q;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.u.isStateful();
    }

    public float j(int corner) {
        if (this.r[corner]) {
            return this.q;
        }
        return 0.0f;
    }

    public ImageView.ScaleType k() {
        return this.v;
    }

    public Bitmap l() {
        return this.f10424f;
    }

    public Shader.TileMode m() {
        return this.n;
    }

    public Shader.TileMode n() {
        return this.o;
    }

    public boolean o() {
        return this.s;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@NonNull Rect bounds) {
        super.onBoundsChange(bounds);
        this.f10421c.set(bounds);
        D();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] state) {
        int colorForState = this.u.getColorForState(state, 0);
        if (this.k.getColor() == colorForState) {
            return super.onStateChange(state);
        }
        this.k.setColor(colorForState);
        return true;
    }

    public b s(@ColorInt int color) {
        return t(ColorStateList.valueOf(color));
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.f10425g.setAlpha(alpha);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
        this.f10425g.setColorFilter(cf);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean dither) {
        this.f10425g.setDither(dither);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean filter) {
        this.f10425g.setFilterBitmap(filter);
        invalidateSelf();
    }

    public b t(ColorStateList colors) {
        if (colors == null) {
            colors = ColorStateList.valueOf(0);
        }
        this.u = colors;
        this.k.setColor(colors.getColorForState(getState(), -16777216));
        return this;
    }

    public b u(float width) {
        this.t = width;
        this.k.setStrokeWidth(width);
        return this;
    }

    public b v(float radius) {
        w(radius, radius, radius, radius);
        return this;
    }

    public b w(float topLeft, float topRight, float bottomRight, float bottomLeft) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(topLeft));
        hashSet.add(Float.valueOf(topRight));
        hashSet.add(Float.valueOf(bottomRight));
        hashSet.add(Float.valueOf(bottomLeft));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() > 1) {
            throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
        }
        if (hashSet.isEmpty()) {
            this.q = 0.0f;
        } else {
            float floatValue = ((Float) hashSet.iterator().next()).floatValue();
            if (Float.isInfinite(floatValue) || Float.isNaN(floatValue) || floatValue < 0.0f) {
                throw new IllegalArgumentException("Invalid radius value: " + floatValue);
            }
            this.q = floatValue;
        }
        boolean[] zArr = this.r;
        zArr[0] = topLeft > 0.0f;
        zArr[1] = topRight > 0.0f;
        zArr[2] = bottomRight > 0.0f;
        zArr[3] = bottomLeft > 0.0f;
        return this;
    }

    public b x(int corner, float radius) {
        if (radius != 0.0f) {
            float f2 = this.q;
            if (f2 != 0.0f && f2 != radius) {
                throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
            }
        }
        if (radius == 0.0f) {
            if (p(corner, this.r)) {
                this.q = 0.0f;
            }
            this.r[corner] = false;
        } else {
            if (this.q == 0.0f) {
                this.q = radius;
            }
            this.r[corner] = true;
        }
        return this;
    }

    public b y(boolean oval) {
        this.s = oval;
        return this;
    }

    public b z(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.v != scaleType) {
            this.v = scaleType;
            D();
        }
        return this;
    }
}
