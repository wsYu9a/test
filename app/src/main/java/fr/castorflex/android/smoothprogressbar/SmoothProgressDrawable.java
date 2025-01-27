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

/* loaded from: classes4.dex */
public class SmoothProgressDrawable extends Drawable implements Animatable {
    public static final long A = 16;
    public static final float B = 0.01f;

    /* renamed from: b */
    public final Rect f26077b;

    /* renamed from: c */
    public b f26078c;

    /* renamed from: d */
    public Interpolator f26079d;

    /* renamed from: e */
    public Rect f26080e;

    /* renamed from: f */
    public Paint f26081f;

    /* renamed from: g */
    public int[] f26082g;

    /* renamed from: h */
    public int f26083h;

    /* renamed from: i */
    public boolean f26084i;

    /* renamed from: j */
    public float f26085j;

    /* renamed from: k */
    public int f26086k;

    /* renamed from: l */
    public int f26087l;

    /* renamed from: m */
    public float f26088m;

    /* renamed from: n */
    public float f26089n;

    /* renamed from: o */
    public float f26090o;

    /* renamed from: p */
    public boolean f26091p;

    /* renamed from: q */
    public boolean f26092q;

    /* renamed from: r */
    public boolean f26093r;

    /* renamed from: s */
    public float f26094s;

    /* renamed from: t */
    public boolean f26095t;

    /* renamed from: u */
    public boolean f26096u;

    /* renamed from: v */
    public int f26097v;

    /* renamed from: w */
    public int f26098w;

    /* renamed from: x */
    public float f26099x;

    /* renamed from: y */
    public Drawable f26100y;

    /* renamed from: z */
    public final Runnable f26101z;

    public static class Builder {

        /* renamed from: a */
        public Interpolator f26102a;

        /* renamed from: b */
        public int f26103b;

        /* renamed from: c */
        public int[] f26104c;

        /* renamed from: d */
        public float f26105d;

        /* renamed from: e */
        public float f26106e;

        /* renamed from: f */
        public float f26107f;

        /* renamed from: g */
        public boolean f26108g;

        /* renamed from: h */
        public boolean f26109h;

        /* renamed from: i */
        public float f26110i;

        /* renamed from: j */
        public int f26111j;

        /* renamed from: k */
        public boolean f26112k;

        /* renamed from: l */
        public boolean f26113l;

        /* renamed from: m */
        public Drawable f26114m;

        /* renamed from: n */
        public b f26115n;

        public Builder(Context context) {
            g(context);
        }

        public Builder a(Drawable drawable) {
            this.f26114m = drawable;
            return this;
        }

        public SmoothProgressDrawable b() {
            if (this.f26113l) {
                this.f26114m = lh.b.a(this.f26104c, this.f26110i);
            }
            return new SmoothProgressDrawable(this.f26102a, this.f26103b, this.f26111j, this.f26104c, this.f26110i, this.f26105d, this.f26106e, this.f26107f, this.f26108g, this.f26109h, this.f26115n, this.f26112k, this.f26114m, null);
        }

        public Builder c(b bVar) {
            this.f26115n = bVar;
            return this;
        }

        public Builder d(int i10) {
            this.f26104c = new int[]{i10};
            return this;
        }

        public Builder e(int[] iArr) {
            if (iArr == null || iArr.length == 0) {
                throw new IllegalArgumentException("Your color array must not be empty");
            }
            this.f26104c = iArr;
            return this;
        }

        public Builder f() {
            this.f26113l = true;
            return this;
        }

        public final void g(Context context) {
            Resources resources = context.getResources();
            this.f26102a = new AccelerateInterpolator();
            this.f26103b = resources.getInteger(R.integer.spb_default_sections_count);
            this.f26104c = new int[]{resources.getColor(R.color.spb_default_color)};
            float parseFloat = Float.parseFloat(resources.getString(R.string.spb_default_speed));
            this.f26105d = parseFloat;
            this.f26106e = parseFloat;
            this.f26107f = parseFloat;
            this.f26108g = resources.getBoolean(R.bool.spb_default_reversed);
            this.f26111j = resources.getDimensionPixelSize(R.dimen.spb_default_stroke_separator_length);
            this.f26110i = resources.getDimensionPixelOffset(R.dimen.spb_default_stroke_width);
            this.f26112k = resources.getBoolean(R.bool.spb_default_progressiveStart_activated);
        }

        public Builder h(Interpolator interpolator) {
            if (interpolator == null) {
                throw new IllegalArgumentException("Interpolator can't be null");
            }
            this.f26102a = interpolator;
            return this;
        }

        public Builder i(boolean z10) {
            this.f26109h = z10;
            return this;
        }

        public Builder j(boolean z10) {
            this.f26112k = z10;
            return this;
        }

        public Builder k(float f10) {
            if (f10 < 0.0f) {
                throw new IllegalArgumentException("progressiveStartSpeed must be >= 0");
            }
            this.f26106e = f10;
            return this;
        }

        public Builder l(float f10) {
            if (f10 < 0.0f) {
                throw new IllegalArgumentException("progressiveStopSpeed must be >= 0");
            }
            this.f26107f = f10;
            return this;
        }

        public Builder m(boolean z10) {
            this.f26108g = z10;
            return this;
        }

        public Builder n(int i10) {
            if (i10 <= 0) {
                throw new IllegalArgumentException("SectionsCount must be > 0");
            }
            this.f26103b = i10;
            return this;
        }

        public Builder o(int i10) {
            if (i10 < 0) {
                throw new IllegalArgumentException("SeparatorLength must be >= 0");
            }
            this.f26111j = i10;
            return this;
        }

        public Builder p(float f10) {
            if (f10 < 0.0f) {
                throw new IllegalArgumentException("Speed must be >= 0");
            }
            this.f26105d = f10;
            return this;
        }

        public Builder q(float f10) {
            if (f10 < 0.0f) {
                throw new IllegalArgumentException("The width must be >= 0");
            }
            this.f26110i = f10;
            return this;
        }
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SmoothProgressDrawable.this.t()) {
                SmoothProgressDrawable smoothProgressDrawable = SmoothProgressDrawable.this;
                SmoothProgressDrawable.b(smoothProgressDrawable, smoothProgressDrawable.f26090o * 0.01f);
            } else if (SmoothProgressDrawable.this.u()) {
                SmoothProgressDrawable smoothProgressDrawable2 = SmoothProgressDrawable.this;
                SmoothProgressDrawable.b(smoothProgressDrawable2, smoothProgressDrawable2.f26089n * 0.01f);
            } else {
                SmoothProgressDrawable smoothProgressDrawable3 = SmoothProgressDrawable.this;
                SmoothProgressDrawable.b(smoothProgressDrawable3, smoothProgressDrawable3.f26088m * 0.01f);
            }
            if (SmoothProgressDrawable.this.f26085j >= SmoothProgressDrawable.this.f26094s) {
                SmoothProgressDrawable.this.f26092q = true;
                SmoothProgressDrawable smoothProgressDrawable4 = SmoothProgressDrawable.this;
                SmoothProgressDrawable.c(smoothProgressDrawable4, smoothProgressDrawable4.f26094s);
            }
            SmoothProgressDrawable smoothProgressDrawable5 = SmoothProgressDrawable.this;
            smoothProgressDrawable5.scheduleSelf(smoothProgressDrawable5.f26101z, SystemClock.uptimeMillis() + 16);
            SmoothProgressDrawable.this.invalidateSelf();
        }
    }

    public interface b {
        void onStart();

        void onStop();
    }

    public /* synthetic */ SmoothProgressDrawable(Interpolator interpolator, int i10, int i11, int[] iArr, float f10, float f11, float f12, float f13, boolean z10, boolean z11, b bVar, boolean z12, Drawable drawable, a aVar) {
        this(interpolator, i10, i11, iArr, f10, f11, f12, f13, z10, z11, bVar, z12, drawable);
    }

    public static /* synthetic */ float b(SmoothProgressDrawable smoothProgressDrawable, float f10) {
        float f11 = smoothProgressDrawable.f26085j + f10;
        smoothProgressDrawable.f26085j = f11;
        return f11;
    }

    public static /* synthetic */ float c(SmoothProgressDrawable smoothProgressDrawable, float f10) {
        float f11 = smoothProgressDrawable.f26085j - f10;
        smoothProgressDrawable.f26085j = f11;
        return f11;
    }

    public void A(b bVar) {
        this.f26078c = bVar;
    }

    public void B(int i10) {
        C(new int[]{i10});
    }

    public void C(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("Colors cannot be null or empty");
        }
        this.f26083h = 0;
        this.f26082g = iArr;
        invalidateSelf();
    }

    public void D(Interpolator interpolator) {
        if (interpolator == null) {
            throw new IllegalArgumentException("Interpolator cannot be null");
        }
        this.f26079d = interpolator;
        invalidateSelf();
    }

    public void E(boolean z10) {
        if (this.f26093r == z10) {
            return;
        }
        this.f26093r = z10;
        invalidateSelf();
    }

    public void F(boolean z10) {
        this.f26096u = z10;
    }

    public void G(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("SpeedProgressiveStart must be >= 0");
        }
        this.f26089n = f10;
        invalidateSelf();
    }

    public void H(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("SpeedProgressiveStop must be >= 0");
        }
        this.f26090o = f10;
        invalidateSelf();
    }

    public void I(boolean z10) {
        if (this.f26091p == z10) {
            return;
        }
        this.f26091p = z10;
        invalidateSelf();
    }

    public void J(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("SectionsCount must be > 0");
        }
        this.f26087l = i10;
        float f10 = 1.0f / i10;
        this.f26094s = f10;
        this.f26085j %= f10;
        invalidateSelf();
    }

    public void K(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("SeparatorLength must be >= 0");
        }
        this.f26086k = i10;
        invalidateSelf();
    }

    public void L(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Speed must be >= 0");
        }
        this.f26088m = f10;
        invalidateSelf();
    }

    public void M(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("The strokeWidth must be >= 0");
        }
        this.f26081f.setStrokeWidth(f10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.f26080e = bounds;
        canvas.clipRect(bounds);
        int width = this.f26080e.width();
        if (this.f26091p) {
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
        return this.f26084i;
    }

    public final void j(int i10) {
        if (i10 < 0 || i10 >= this.f26082g.length) {
            throw new IllegalArgumentException(String.format("Index %d not valid", Integer.valueOf(i10)));
        }
    }

    public final int k(int i10) {
        int i11 = i10 - 1;
        return i11 < 0 ? this.f26082g.length - 1 : i11;
    }

    public final void l(Canvas canvas, float f10, float f11) {
        int save = canvas.save();
        canvas.clipRect(f10, (int) ((canvas.getHeight() - this.f26099x) / 2.0f), f11, (int) ((canvas.getHeight() + this.f26099x) / 2.0f));
        this.f26100y.draw(canvas);
        canvas.restoreToCount(save);
    }

    public final void m(Canvas canvas, float f10, float f11) {
        if (this.f26100y == null) {
            return;
        }
        this.f26077b.top = (int) ((canvas.getHeight() - this.f26099x) / 2.0f);
        this.f26077b.bottom = (int) ((canvas.getHeight() + this.f26099x) / 2.0f);
        Rect rect = this.f26077b;
        rect.left = 0;
        rect.right = this.f26093r ? canvas.getWidth() / 2 : canvas.getWidth();
        this.f26100y.setBounds(this.f26077b);
        if (!isRunning()) {
            if (!this.f26093r) {
                l(canvas, 0.0f, this.f26077b.width());
                return;
            }
            canvas.save();
            canvas.translate(canvas.getWidth() / 2, 0.0f);
            l(canvas, 0.0f, this.f26077b.width());
            canvas.scale(-1.0f, 1.0f);
            l(canvas, 0.0f, this.f26077b.width());
            canvas.restore();
            return;
        }
        if (t() || u()) {
            if (f10 > f11) {
                f11 = f10;
                f10 = f11;
            }
            if (f10 > 0.0f) {
                if (this.f26093r) {
                    canvas.save();
                    canvas.translate(canvas.getWidth() / 2, 0.0f);
                    if (this.f26091p) {
                        l(canvas, 0.0f, f10);
                        canvas.scale(-1.0f, 1.0f);
                        l(canvas, 0.0f, f10);
                    } else {
                        l(canvas, (canvas.getWidth() / 2) - f10, canvas.getWidth() / 2);
                        canvas.scale(-1.0f, 1.0f);
                        l(canvas, (canvas.getWidth() / 2) - f10, canvas.getWidth() / 2);
                    }
                    canvas.restore();
                } else {
                    l(canvas, 0.0f, f10);
                }
            }
            if (f11 <= canvas.getWidth()) {
                if (!this.f26093r) {
                    l(canvas, f11, canvas.getWidth());
                    return;
                }
                canvas.save();
                canvas.translate(canvas.getWidth() / 2, 0.0f);
                if (this.f26091p) {
                    l(canvas, f11, canvas.getWidth() / 2);
                    canvas.scale(-1.0f, 1.0f);
                    l(canvas, f11, canvas.getWidth() / 2);
                } else {
                    l(canvas, 0.0f, (canvas.getWidth() / 2) - f11);
                    canvas.scale(-1.0f, 1.0f);
                    l(canvas, 0.0f, (canvas.getWidth() / 2) - f11);
                }
                canvas.restore();
            }
        }
    }

    public final void n(Canvas canvas, int i10, float f10, float f11, float f12, float f13, int i11) {
        this.f26081f.setColor(this.f26082g[i11]);
        if (!this.f26093r) {
            canvas.drawLine(f10, f11, f12, f13, this.f26081f);
            return;
        }
        if (this.f26091p) {
            float f14 = i10;
            canvas.drawLine(f14 + f10, f11, f14 + f12, f13, this.f26081f);
            canvas.drawLine(f14 - f10, f11, f14 - f12, f13, this.f26081f);
        } else {
            canvas.drawLine(f10, f11, f12, f13, this.f26081f);
            float f15 = i10 * 2;
            canvas.drawLine(f15 - f10, f11, f15 - f12, f13, this.f26081f);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void o(android.graphics.Canvas r24) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.castorflex.android.smoothprogressbar.SmoothProgressDrawable.o(android.graphics.Canvas):void");
    }

    public Drawable p() {
        return this.f26100y;
    }

    public int[] q() {
        return this.f26082g;
    }

    public float r() {
        return this.f26099x;
    }

    public final int s(int i10) {
        int i11 = i10 + 1;
        if (i11 >= this.f26082g.length) {
            return 0;
        }
        return i11;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j10) {
        this.f26084i = true;
        super.scheduleSelf(runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f26081f.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f26081f.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f26096u) {
            y(0);
        }
        if (isRunning()) {
            return;
        }
        b bVar = this.f26078c;
        if (bVar != null) {
            bVar.onStart();
        }
        scheduleSelf(this.f26101z, SystemClock.uptimeMillis() + 16);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (isRunning()) {
            b bVar = this.f26078c;
            if (bVar != null) {
                bVar.onStop();
            }
            this.f26084i = false;
            unscheduleSelf(this.f26101z);
        }
    }

    public boolean t() {
        return this.f26095t;
    }

    public boolean u() {
        return this.f26098w < this.f26087l;
    }

    public void v() {
        w(0);
    }

    public void w(int i10) {
        y(i10);
        start();
    }

    public void x() {
        this.f26095t = true;
        this.f26097v = 0;
    }

    public final void y(int i10) {
        j(i10);
        this.f26085j = 0.0f;
        this.f26095t = false;
        this.f26097v = 0;
        this.f26098w = 0;
        this.f26083h = i10;
    }

    public void z(Drawable drawable) {
        if (this.f26100y == drawable) {
            return;
        }
        this.f26100y = drawable;
        invalidateSelf();
    }

    public SmoothProgressDrawable(Interpolator interpolator, int i10, int i11, int[] iArr, float f10, float f11, float f12, float f13, boolean z10, boolean z11, b bVar, boolean z12, Drawable drawable) {
        this.f26077b = new Rect();
        this.f26101z = new a();
        this.f26084i = false;
        this.f26079d = interpolator;
        this.f26087l = i10;
        this.f26097v = 0;
        this.f26098w = i10;
        this.f26086k = i11;
        this.f26088m = f11;
        this.f26089n = f12;
        this.f26090o = f13;
        this.f26091p = z10;
        this.f26082g = iArr;
        this.f26083h = 0;
        this.f26093r = z11;
        this.f26095t = false;
        this.f26100y = drawable;
        this.f26099x = f10;
        this.f26094s = 1.0f / i10;
        Paint paint = new Paint();
        this.f26081f = paint;
        paint.setStrokeWidth(f10);
        this.f26081f.setStyle(Paint.Style.STROKE);
        this.f26081f.setDither(false);
        this.f26081f.setAntiAlias(false);
        this.f26096u = z12;
        this.f26078c = bVar;
    }
}
