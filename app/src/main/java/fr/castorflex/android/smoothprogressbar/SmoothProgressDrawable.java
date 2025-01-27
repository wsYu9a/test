package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;

/* loaded from: classes5.dex */
public class SmoothProgressDrawable extends Drawable implements Animatable {

    /* renamed from: a */
    private static final long f35262a = 16;

    /* renamed from: b */
    private static final float f35263b = 0.01f;
    private final Runnable A;

    /* renamed from: c */
    private final Rect f35264c;

    /* renamed from: d */
    private b f35265d;

    /* renamed from: e */
    private Interpolator f35266e;

    /* renamed from: f */
    private Rect f35267f;

    /* renamed from: g */
    private Paint f35268g;

    /* renamed from: h */
    private int[] f35269h;

    /* renamed from: i */
    private int f35270i;

    /* renamed from: j */
    private boolean f35271j;
    private float k;
    private int l;
    private int m;
    private float n;
    private float o;
    private float p;
    private boolean q;
    private boolean r;
    private boolean s;
    private float t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private float y;
    private Drawable z;

    public static class Builder {

        /* renamed from: a */
        private Interpolator f35272a;

        /* renamed from: b */
        private int f35273b;

        /* renamed from: c */
        private int[] f35274c;

        /* renamed from: d */
        private float f35275d;

        /* renamed from: e */
        private float f35276e;

        /* renamed from: f */
        private float f35277f;

        /* renamed from: g */
        private boolean f35278g;

        /* renamed from: h */
        private boolean f35279h;

        /* renamed from: i */
        private float f35280i;

        /* renamed from: j */
        private int f35281j;
        private boolean k;
        private boolean l;
        private Drawable m;
        private b n;

        public Builder(Context context) {
            g(context);
        }

        private void g(Context context) {
            Resources resources = context.getResources();
            this.f35272a = new AccelerateInterpolator();
            this.f35273b = resources.getInteger(R.integer.spb_default_sections_count);
            this.f35274c = new int[]{resources.getColor(R.color.spb_default_color)};
            float parseFloat = Float.parseFloat(resources.getString(R.string.spb_default_speed));
            this.f35275d = parseFloat;
            this.f35276e = parseFloat;
            this.f35277f = parseFloat;
            this.f35278g = resources.getBoolean(R.bool.spb_default_reversed);
            this.f35281j = resources.getDimensionPixelSize(R.dimen.spb_default_stroke_separator_length);
            this.f35280i = resources.getDimensionPixelOffset(R.dimen.spb_default_stroke_width);
            this.k = resources.getBoolean(R.bool.spb_default_progressiveStart_activated);
        }

        public Builder a(Drawable drawable) {
            this.m = drawable;
            return this;
        }

        public SmoothProgressDrawable b() {
            if (this.l) {
                this.m = fr.castorflex.android.smoothprogressbar.b.a(this.f35274c, this.f35280i);
            }
            return new SmoothProgressDrawable(this.f35272a, this.f35273b, this.f35281j, this.f35274c, this.f35280i, this.f35275d, this.f35276e, this.f35277f, this.f35278g, this.f35279h, this.n, this.k, this.m, null);
        }

        public Builder c(b bVar) {
            this.n = bVar;
            return this;
        }

        public Builder d(int i2) {
            this.f35274c = new int[]{i2};
            return this;
        }

        public Builder e(int[] iArr) {
            if (iArr == null || iArr.length == 0) {
                throw new IllegalArgumentException("Your color array must not be empty");
            }
            this.f35274c = iArr;
            return this;
        }

        public Builder f() {
            this.l = true;
            return this;
        }

        public Builder h(Interpolator interpolator) {
            if (interpolator == null) {
                throw new IllegalArgumentException("Interpolator can't be null");
            }
            this.f35272a = interpolator;
            return this;
        }

        public Builder i(boolean z) {
            this.f35279h = z;
            return this;
        }

        public Builder j(boolean z) {
            this.k = z;
            return this;
        }

        public Builder k(float f2) {
            if (f2 < 0.0f) {
                throw new IllegalArgumentException("progressiveStartSpeed must be >= 0");
            }
            this.f35276e = f2;
            return this;
        }

        public Builder l(float f2) {
            if (f2 < 0.0f) {
                throw new IllegalArgumentException("progressiveStopSpeed must be >= 0");
            }
            this.f35277f = f2;
            return this;
        }

        public Builder m(boolean z) {
            this.f35278g = z;
            return this;
        }

        public Builder n(int i2) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("SectionsCount must be > 0");
            }
            this.f35273b = i2;
            return this;
        }

        public Builder o(int i2) {
            if (i2 < 0) {
                throw new IllegalArgumentException("SeparatorLength must be >= 0");
            }
            this.f35281j = i2;
            return this;
        }

        public Builder p(float f2) {
            if (f2 < 0.0f) {
                throw new IllegalArgumentException("Speed must be >= 0");
            }
            this.f35275d = f2;
            return this;
        }

        public Builder q(float f2) {
            if (f2 < 0.0f) {
                throw new IllegalArgumentException("The width must be >= 0");
            }
            this.f35280i = f2;
            return this;
        }
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SmoothProgressDrawable.this.t()) {
                SmoothProgressDrawable smoothProgressDrawable = SmoothProgressDrawable.this;
                SmoothProgressDrawable.b(smoothProgressDrawable, smoothProgressDrawable.p * 0.01f);
            } else if (SmoothProgressDrawable.this.u()) {
                SmoothProgressDrawable smoothProgressDrawable2 = SmoothProgressDrawable.this;
                SmoothProgressDrawable.b(smoothProgressDrawable2, smoothProgressDrawable2.o * 0.01f);
            } else {
                SmoothProgressDrawable smoothProgressDrawable3 = SmoothProgressDrawable.this;
                SmoothProgressDrawable.b(smoothProgressDrawable3, smoothProgressDrawable3.n * 0.01f);
            }
            if (SmoothProgressDrawable.this.k >= SmoothProgressDrawable.this.t) {
                SmoothProgressDrawable.this.r = true;
                SmoothProgressDrawable smoothProgressDrawable4 = SmoothProgressDrawable.this;
                SmoothProgressDrawable.c(smoothProgressDrawable4, smoothProgressDrawable4.t);
            }
            SmoothProgressDrawable smoothProgressDrawable5 = SmoothProgressDrawable.this;
            smoothProgressDrawable5.scheduleSelf(smoothProgressDrawable5.A, SystemClock.uptimeMillis() + 16);
            SmoothProgressDrawable.this.invalidateSelf();
        }
    }

    public interface b {
        void onStart();

        void onStop();
    }

    /* synthetic */ SmoothProgressDrawable(Interpolator interpolator, int i2, int i3, int[] iArr, float f2, float f3, float f4, float f5, boolean z, boolean z2, b bVar, boolean z3, Drawable drawable, a aVar) {
        this(interpolator, i2, i3, iArr, f2, f3, f4, f5, z, z2, bVar, z3, drawable);
    }

    static /* synthetic */ float b(SmoothProgressDrawable smoothProgressDrawable, float f2) {
        float f3 = smoothProgressDrawable.k + f2;
        smoothProgressDrawable.k = f3;
        return f3;
    }

    static /* synthetic */ float c(SmoothProgressDrawable smoothProgressDrawable, float f2) {
        float f3 = smoothProgressDrawable.k - f2;
        smoothProgressDrawable.k = f3;
        return f3;
    }

    private void j(int i2) {
        if (i2 < 0 || i2 >= this.f35269h.length) {
            throw new IllegalArgumentException(String.format("Index %d not valid", Integer.valueOf(i2)));
        }
    }

    private int k(int i2) {
        int i3 = i2 - 1;
        return i3 < 0 ? this.f35269h.length - 1 : i3;
    }

    private void l(Canvas canvas, float f2, float f3) {
        int save = canvas.save();
        canvas.clipRect(f2, (int) ((canvas.getHeight() - this.y) / 2.0f), f3, (int) ((canvas.getHeight() + this.y) / 2.0f));
        this.z.draw(canvas);
        canvas.restoreToCount(save);
    }

    private void m(Canvas canvas, float f2, float f3) {
        if (this.z == null) {
            return;
        }
        this.f35264c.top = (int) ((canvas.getHeight() - this.y) / 2.0f);
        this.f35264c.bottom = (int) ((canvas.getHeight() + this.y) / 2.0f);
        Rect rect = this.f35264c;
        rect.left = 0;
        rect.right = this.s ? canvas.getWidth() / 2 : canvas.getWidth();
        this.z.setBounds(this.f35264c);
        if (!isRunning()) {
            if (!this.s) {
                l(canvas, 0.0f, this.f35264c.width());
                return;
            }
            canvas.save();
            canvas.translate(canvas.getWidth() / 2, 0.0f);
            l(canvas, 0.0f, this.f35264c.width());
            canvas.scale(-1.0f, 1.0f);
            l(canvas, 0.0f, this.f35264c.width());
            canvas.restore();
            return;
        }
        if (t() || u()) {
            if (f2 > f3) {
                f3 = f2;
                f2 = f3;
            }
            if (f2 > 0.0f) {
                if (this.s) {
                    canvas.save();
                    canvas.translate(canvas.getWidth() / 2, 0.0f);
                    if (this.q) {
                        l(canvas, 0.0f, f2);
                        canvas.scale(-1.0f, 1.0f);
                        l(canvas, 0.0f, f2);
                    } else {
                        l(canvas, (canvas.getWidth() / 2) - f2, canvas.getWidth() / 2);
                        canvas.scale(-1.0f, 1.0f);
                        l(canvas, (canvas.getWidth() / 2) - f2, canvas.getWidth() / 2);
                    }
                    canvas.restore();
                } else {
                    l(canvas, 0.0f, f2);
                }
            }
            if (f3 <= canvas.getWidth()) {
                if (!this.s) {
                    l(canvas, f3, canvas.getWidth());
                    return;
                }
                canvas.save();
                canvas.translate(canvas.getWidth() / 2, 0.0f);
                if (this.q) {
                    l(canvas, f3, canvas.getWidth() / 2);
                    canvas.scale(-1.0f, 1.0f);
                    l(canvas, f3, canvas.getWidth() / 2);
                } else {
                    l(canvas, 0.0f, (canvas.getWidth() / 2) - f3);
                    canvas.scale(-1.0f, 1.0f);
                    l(canvas, 0.0f, (canvas.getWidth() / 2) - f3);
                }
                canvas.restore();
            }
        }
    }

    private void n(Canvas canvas, int i2, float f2, float f3, float f4, float f5, int i3) {
        this.f35268g.setColor(this.f35269h[i3]);
        if (!this.s) {
            canvas.drawLine(f2, f3, f4, f5, this.f35268g);
            return;
        }
        if (this.q) {
            float f6 = i2;
            canvas.drawLine(f6 + f2, f3, f6 + f4, f5, this.f35268g);
            canvas.drawLine(f6 - f2, f3, f6 - f4, f5, this.f35268g);
        } else {
            canvas.drawLine(f2, f3, f4, f5, this.f35268g);
            float f7 = i2 * 2;
            canvas.drawLine(f7 - f2, f3, f7 - f4, f5, this.f35268g);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void o(android.graphics.Canvas r24) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.castorflex.android.smoothprogressbar.SmoothProgressDrawable.o(android.graphics.Canvas):void");
    }

    private int s(int i2) {
        int i3 = i2 + 1;
        if (i3 >= this.f35269h.length) {
            return 0;
        }
        return i3;
    }

    private void y(int i2) {
        j(i2);
        this.k = 0.0f;
        this.u = false;
        this.w = 0;
        this.x = 0;
        this.f35270i = i2;
    }

    public void A(b bVar) {
        this.f35265d = bVar;
    }

    public void B(int i2) {
        C(new int[]{i2});
    }

    public void C(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("Colors cannot be null or empty");
        }
        this.f35270i = 0;
        this.f35269h = iArr;
        invalidateSelf();
    }

    public void D(Interpolator interpolator) {
        if (interpolator == null) {
            throw new IllegalArgumentException("Interpolator cannot be null");
        }
        this.f35266e = interpolator;
        invalidateSelf();
    }

    public void E(boolean z) {
        if (this.s == z) {
            return;
        }
        this.s = z;
        invalidateSelf();
    }

    public void F(boolean z) {
        this.v = z;
    }

    public void G(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("SpeedProgressiveStart must be >= 0");
        }
        this.o = f2;
        invalidateSelf();
    }

    public void H(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("SpeedProgressiveStop must be >= 0");
        }
        this.p = f2;
        invalidateSelf();
    }

    public void I(boolean z) {
        if (this.q == z) {
            return;
        }
        this.q = z;
        invalidateSelf();
    }

    public void J(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("SectionsCount must be > 0");
        }
        this.m = i2;
        float f2 = 1.0f / i2;
        this.t = f2;
        this.k %= f2;
        invalidateSelf();
    }

    public void K(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("SeparatorLength must be >= 0");
        }
        this.l = i2;
        invalidateSelf();
    }

    public void L(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Speed must be >= 0");
        }
        this.n = f2;
        invalidateSelf();
    }

    public void M(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("The strokeWidth must be >= 0");
        }
        this.f35268g.setStrokeWidth(f2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.f35267f = bounds;
        canvas.clipRect(bounds);
        int width = this.f35267f.width();
        if (this.q) {
            canvas.translate(width, 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        o(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f35271j;
    }

    public Drawable p() {
        return this.z;
    }

    public int[] q() {
        return this.f35269h;
    }

    public float r() {
        return this.y;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j2) {
        this.f35271j = true;
        super.scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f35268g.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f35268g.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.v) {
            y(0);
        }
        if (isRunning()) {
            return;
        }
        b bVar = this.f35265d;
        if (bVar != null) {
            bVar.onStart();
        }
        scheduleSelf(this.A, SystemClock.uptimeMillis() + 16);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (isRunning()) {
            b bVar = this.f35265d;
            if (bVar != null) {
                bVar.onStop();
            }
            this.f35271j = false;
            unscheduleSelf(this.A);
        }
    }

    public boolean t() {
        return this.u;
    }

    public boolean u() {
        return this.x < this.m;
    }

    public void v() {
        w(0);
    }

    public void w(int i2) {
        y(i2);
        start();
    }

    public void x() {
        this.u = true;
        this.w = 0;
    }

    public void z(Drawable drawable) {
        if (this.z == drawable) {
            return;
        }
        this.z = drawable;
        invalidateSelf();
    }

    private SmoothProgressDrawable(Interpolator interpolator, int i2, int i3, int[] iArr, float f2, float f3, float f4, float f5, boolean z, boolean z2, b bVar, boolean z3, Drawable drawable) {
        this.f35264c = new Rect();
        this.A = new a();
        this.f35271j = false;
        this.f35266e = interpolator;
        this.m = i2;
        this.w = 0;
        this.x = i2;
        this.l = i3;
        this.n = f3;
        this.o = f4;
        this.p = f5;
        this.q = z;
        this.f35269h = iArr;
        this.f35270i = 0;
        this.s = z2;
        this.u = false;
        this.z = drawable;
        this.y = f2;
        this.t = 1.0f / i2;
        Paint paint = new Paint();
        this.f35268g = paint;
        paint.setStrokeWidth(f2);
        this.f35268g.setStyle(Paint.Style.STROKE);
        this.f35268g.setDither(false);
        this.f35268g.setAntiAlias(false);
        this.v = z3;
        this.f35265d = bVar;
    }
}
