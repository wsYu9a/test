package v9;

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

/* loaded from: classes3.dex */
public class b extends Drawable {

    /* renamed from: u */
    public static final String f31257u = "RoundedDrawable";

    /* renamed from: v */
    public static final int f31258v = -16777216;

    /* renamed from: a */
    public final RectF f31259a = new RectF();

    /* renamed from: b */
    public final RectF f31260b = new RectF();

    /* renamed from: c */
    public final RectF f31261c;

    /* renamed from: d */
    public final Bitmap f31262d;

    /* renamed from: e */
    public final Paint f31263e;

    /* renamed from: f */
    public final int f31264f;

    /* renamed from: g */
    public final int f31265g;

    /* renamed from: h */
    public final RectF f31266h;

    /* renamed from: i */
    public final Paint f31267i;

    /* renamed from: j */
    public final Matrix f31268j;

    /* renamed from: k */
    public final RectF f31269k;

    /* renamed from: l */
    public Shader.TileMode f31270l;

    /* renamed from: m */
    public Shader.TileMode f31271m;

    /* renamed from: n */
    public boolean f31272n;

    /* renamed from: o */
    public float f31273o;

    /* renamed from: p */
    public final boolean[] f31274p;

    /* renamed from: q */
    public boolean f31275q;

    /* renamed from: r */
    public float f31276r;

    /* renamed from: s */
    public ColorStateList f31277s;

    /* renamed from: t */
    public ImageView.ScaleType f31278t;

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f31279a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f31279a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31279a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31279a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31279a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31279a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31279a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f31279a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public b(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.f31261c = rectF;
        this.f31266h = new RectF();
        this.f31268j = new Matrix();
        this.f31269k = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f31270l = tileMode;
        this.f31271m = tileMode;
        this.f31272n = true;
        this.f31273o = 0.0f;
        this.f31274p = new boolean[]{true, true, true, true};
        this.f31275q = false;
        this.f31276r = 0.0f;
        this.f31277s = ColorStateList.valueOf(-16777216);
        this.f31278t = ImageView.ScaleType.FIT_CENTER;
        this.f31262d = bitmap;
        int width = bitmap.getWidth();
        this.f31264f = width;
        int height = bitmap.getHeight();
        this.f31265g = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.f31263e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f31267i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.f31277s.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.f31276r);
    }

    public static boolean a(boolean[] zArr) {
        for (boolean z10 : zArr) {
            if (z10) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(boolean[] zArr) {
        for (boolean z10 : zArr) {
            if (z10) {
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
        } catch (Throwable th2) {
            th2.printStackTrace();
            Log.w(f31257u, "Failed to create bitmap from drawable!");
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
        if (drawable == null) {
            return drawable;
        }
        if (drawable instanceof b) {
            return drawable;
        }
        if (!(drawable instanceof LayerDrawable)) {
            Bitmap c10 = c(drawable);
            return c10 != null ? new b(c10) : drawable;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        for (int i10 = 0; i10 < numberOfLayers; i10++) {
            layerDrawable.setDrawableByLayerId(layerDrawable.getId(i10), e(layerDrawable.getDrawable(i10)));
        }
        return layerDrawable;
    }

    public static boolean p(int i10, boolean[] zArr) {
        int length = zArr.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                return true;
            }
            if (zArr[i11] != (i11 == i10)) {
                return false;
            }
            i11++;
        }
    }

    public b A(Shader.TileMode tileMode) {
        if (this.f31270l != tileMode) {
            this.f31270l = tileMode;
            this.f31272n = true;
            invalidateSelf();
        }
        return this;
    }

    public b B(Shader.TileMode tileMode) {
        if (this.f31271m != tileMode) {
            this.f31271m = tileMode;
            this.f31272n = true;
            invalidateSelf();
        }
        return this;
    }

    public Bitmap C() {
        return c(this);
    }

    public final void D() {
        float width;
        float height;
        int i10 = a.f31279a[this.f31278t.ordinal()];
        if (i10 == 1) {
            this.f31266h.set(this.f31259a);
            RectF rectF = this.f31266h;
            float f10 = this.f31276r;
            rectF.inset(f10 / 2.0f, f10 / 2.0f);
            this.f31268j.reset();
            this.f31268j.setTranslate((int) (((this.f31266h.width() - this.f31264f) * 0.5f) + 0.5f), (int) (((this.f31266h.height() - this.f31265g) * 0.5f) + 0.5f));
        } else if (i10 == 2) {
            this.f31266h.set(this.f31259a);
            RectF rectF2 = this.f31266h;
            float f11 = this.f31276r;
            rectF2.inset(f11 / 2.0f, f11 / 2.0f);
            this.f31268j.reset();
            float f12 = 0.0f;
            if (this.f31264f * this.f31266h.height() > this.f31266h.width() * this.f31265g) {
                width = this.f31266h.height() / this.f31265g;
                f12 = (this.f31266h.width() - (this.f31264f * width)) * 0.5f;
                height = 0.0f;
            } else {
                width = this.f31266h.width() / this.f31264f;
                height = (this.f31266h.height() - (this.f31265g * width)) * 0.5f;
            }
            this.f31268j.setScale(width, width);
            Matrix matrix = this.f31268j;
            float f13 = this.f31276r;
            matrix.postTranslate(((int) (f12 + 0.5f)) + (f13 / 2.0f), ((int) (height + 0.5f)) + (f13 / 2.0f));
        } else if (i10 == 3) {
            this.f31268j.reset();
            float min = (((float) this.f31264f) > this.f31259a.width() || ((float) this.f31265g) > this.f31259a.height()) ? Math.min(this.f31259a.width() / this.f31264f, this.f31259a.height() / this.f31265g) : 1.0f;
            float width2 = (int) (((this.f31259a.width() - (this.f31264f * min)) * 0.5f) + 0.5f);
            float height2 = (int) (((this.f31259a.height() - (this.f31265g * min)) * 0.5f) + 0.5f);
            this.f31268j.setScale(min, min);
            this.f31268j.postTranslate(width2, height2);
            this.f31266h.set(this.f31261c);
            this.f31268j.mapRect(this.f31266h);
            RectF rectF3 = this.f31266h;
            float f14 = this.f31276r;
            rectF3.inset(f14 / 2.0f, f14 / 2.0f);
            this.f31268j.setRectToRect(this.f31261c, this.f31266h, Matrix.ScaleToFit.FILL);
        } else if (i10 == 5) {
            this.f31266h.set(this.f31261c);
            this.f31268j.setRectToRect(this.f31261c, this.f31259a, Matrix.ScaleToFit.END);
            this.f31268j.mapRect(this.f31266h);
            RectF rectF4 = this.f31266h;
            float f15 = this.f31276r;
            rectF4.inset(f15 / 2.0f, f15 / 2.0f);
            this.f31268j.setRectToRect(this.f31261c, this.f31266h, Matrix.ScaleToFit.FILL);
        } else if (i10 == 6) {
            this.f31266h.set(this.f31261c);
            this.f31268j.setRectToRect(this.f31261c, this.f31259a, Matrix.ScaleToFit.START);
            this.f31268j.mapRect(this.f31266h);
            RectF rectF5 = this.f31266h;
            float f16 = this.f31276r;
            rectF5.inset(f16 / 2.0f, f16 / 2.0f);
            this.f31268j.setRectToRect(this.f31261c, this.f31266h, Matrix.ScaleToFit.FILL);
        } else if (i10 != 7) {
            this.f31266h.set(this.f31261c);
            this.f31268j.setRectToRect(this.f31261c, this.f31259a, Matrix.ScaleToFit.CENTER);
            this.f31268j.mapRect(this.f31266h);
            RectF rectF6 = this.f31266h;
            float f17 = this.f31276r;
            rectF6.inset(f17 / 2.0f, f17 / 2.0f);
            this.f31268j.setRectToRect(this.f31261c, this.f31266h, Matrix.ScaleToFit.FILL);
        } else {
            this.f31266h.set(this.f31259a);
            RectF rectF7 = this.f31266h;
            float f18 = this.f31276r;
            rectF7.inset(f18 / 2.0f, f18 / 2.0f);
            this.f31268j.reset();
            this.f31268j.setRectToRect(this.f31261c, this.f31266h, Matrix.ScaleToFit.FILL);
        }
        this.f31260b.set(this.f31266h);
        this.f31272n = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f31272n) {
            BitmapShader bitmapShader = new BitmapShader(this.f31262d, this.f31270l, this.f31271m);
            Shader.TileMode tileMode = this.f31270l;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.f31271m == tileMode2) {
                bitmapShader.setLocalMatrix(this.f31268j);
            }
            this.f31263e.setShader(bitmapShader);
            this.f31272n = false;
        }
        if (this.f31275q) {
            if (this.f31276r <= 0.0f) {
                canvas.drawOval(this.f31260b, this.f31263e);
                return;
            } else {
                canvas.drawOval(this.f31260b, this.f31263e);
                canvas.drawOval(this.f31266h, this.f31267i);
                return;
            }
        }
        if (!b(this.f31274p)) {
            canvas.drawRect(this.f31260b, this.f31263e);
            if (this.f31276r > 0.0f) {
                canvas.drawRect(this.f31266h, this.f31267i);
                return;
            }
            return;
        }
        float f10 = this.f31273o;
        if (this.f31276r <= 0.0f) {
            canvas.drawRoundRect(this.f31260b, f10, f10, this.f31263e);
            q(canvas);
        } else {
            canvas.drawRoundRect(this.f31260b, f10, f10, this.f31263e);
            canvas.drawRoundRect(this.f31266h, f10, f10, this.f31267i);
            q(canvas);
            r(canvas);
        }
    }

    public int f() {
        return this.f31277s.getDefaultColor();
    }

    public ColorStateList g() {
        return this.f31277s;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f31263e.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f31263e.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f31265g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f31264f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float h() {
        return this.f31276r;
    }

    public float i() {
        return this.f31273o;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f31277s.isStateful();
    }

    public float j(int i10) {
        if (this.f31274p[i10]) {
            return this.f31273o;
        }
        return 0.0f;
    }

    public ImageView.ScaleType k() {
        return this.f31278t;
    }

    public Bitmap l() {
        return this.f31262d;
    }

    public Shader.TileMode m() {
        return this.f31270l;
    }

    public Shader.TileMode n() {
        return this.f31271m;
    }

    public boolean o() {
        return this.f31275q;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.f31259a.set(rect);
        D();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.f31277s.getColorForState(iArr, 0);
        if (this.f31267i.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.f31267i.setColor(colorForState);
        return true;
    }

    public final void q(Canvas canvas) {
        if (a(this.f31274p) || this.f31273o == 0.0f) {
            return;
        }
        RectF rectF = this.f31260b;
        float f10 = rectF.left;
        float f11 = rectF.top;
        float width = rectF.width() + f10;
        float height = this.f31260b.height() + f11;
        float f12 = this.f31273o;
        if (!this.f31274p[0]) {
            this.f31269k.set(f10, f11, f10 + f12, f11 + f12);
            canvas.drawRect(this.f31269k, this.f31263e);
        }
        if (!this.f31274p[1]) {
            this.f31269k.set(width - f12, f11, width, f12);
            canvas.drawRect(this.f31269k, this.f31263e);
        }
        if (!this.f31274p[2]) {
            this.f31269k.set(width - f12, height - f12, width, height);
            canvas.drawRect(this.f31269k, this.f31263e);
        }
        if (this.f31274p[3]) {
            return;
        }
        this.f31269k.set(f10, height - f12, f12 + f10, height);
        canvas.drawRect(this.f31269k, this.f31263e);
    }

    public final void r(Canvas canvas) {
        float f10;
        if (a(this.f31274p) || this.f31273o == 0.0f) {
            return;
        }
        RectF rectF = this.f31260b;
        float f11 = rectF.left;
        float f12 = rectF.top;
        float width = rectF.width() + f11;
        float height = f12 + this.f31260b.height();
        float f13 = this.f31273o;
        float f14 = this.f31276r / 2.0f;
        if (!this.f31274p[0]) {
            canvas.drawLine(f11 - f14, f12, f11 + f13, f12, this.f31267i);
            canvas.drawLine(f11, f12 - f14, f11, f12 + f13, this.f31267i);
        }
        if (!this.f31274p[1]) {
            canvas.drawLine((width - f13) - f14, f12, width, f12, this.f31267i);
            canvas.drawLine(width, f12 - f14, width, f12 + f13, this.f31267i);
        }
        if (this.f31274p[2]) {
            f10 = f13;
        } else {
            f10 = f13;
            canvas.drawLine((width - f13) - f14, height, width + f14, height, this.f31267i);
            canvas.drawLine(width, height - f10, width, height, this.f31267i);
        }
        if (this.f31274p[3]) {
            return;
        }
        canvas.drawLine(f11 - f14, height, f11 + f10, height, this.f31267i);
        canvas.drawLine(f11, height - f10, f11, height, this.f31267i);
    }

    public b s(@ColorInt int i10) {
        return t(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f31263e.setAlpha(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f31263e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z10) {
        this.f31263e.setDither(z10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z10) {
        this.f31263e.setFilterBitmap(z10);
        invalidateSelf();
    }

    public b t(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f31277s = colorStateList;
        this.f31267i.setColor(colorStateList.getColorForState(getState(), -16777216));
        return this;
    }

    public b u(float f10) {
        this.f31276r = f10;
        this.f31267i.setStrokeWidth(f10);
        return this;
    }

    public b v(float f10) {
        w(f10, f10, f10, f10);
        return this;
    }

    public b w(float f10, float f11, float f12, float f13) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f10));
        hashSet.add(Float.valueOf(f11));
        hashSet.add(Float.valueOf(f12));
        hashSet.add(Float.valueOf(f13));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() > 1) {
            throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
        }
        if (hashSet.isEmpty()) {
            this.f31273o = 0.0f;
        } else {
            float floatValue = ((Float) hashSet.iterator().next()).floatValue();
            if (Float.isInfinite(floatValue) || Float.isNaN(floatValue) || floatValue < 0.0f) {
                throw new IllegalArgumentException("Invalid radius value: " + floatValue);
            }
            this.f31273o = floatValue;
        }
        boolean[] zArr = this.f31274p;
        zArr[0] = f10 > 0.0f;
        zArr[1] = f11 > 0.0f;
        zArr[2] = f12 > 0.0f;
        zArr[3] = f13 > 0.0f;
        return this;
    }

    public b x(int i10, float f10) {
        if (f10 != 0.0f) {
            float f11 = this.f31273o;
            if (f11 != 0.0f && f11 != f10) {
                throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
            }
        }
        if (f10 == 0.0f) {
            if (p(i10, this.f31274p)) {
                this.f31273o = 0.0f;
            }
            this.f31274p[i10] = false;
        } else {
            if (this.f31273o == 0.0f) {
                this.f31273o = f10;
            }
            this.f31274p[i10] = true;
        }
        return this;
    }

    public b y(boolean z10) {
        this.f31275q = z10;
        return this;
    }

    public b z(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.f31278t != scaleType) {
            this.f31278t = scaleType;
            D();
        }
        return this;
    }
}
