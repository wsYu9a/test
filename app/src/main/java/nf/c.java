package nf;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class c extends Drawable implements Animatable {
    public static final int A = 1332;
    public static final byte B = 5;
    public static final byte C = 10;
    public static final byte D = 5;
    public static final float E = 5.0f;
    public static final byte F = 12;
    public static final byte G = 6;
    public static final float H = 0.8f;

    /* renamed from: n */
    public static final float f28882n = 1080.0f;

    /* renamed from: o */
    public static final byte f28883o = 0;

    /* renamed from: p */
    public static final byte f28884p = 1;

    /* renamed from: q */
    public static final byte f28885q = 40;

    /* renamed from: r */
    public static final float f28886r = 8.75f;

    /* renamed from: s */
    public static final float f28887s = 2.5f;

    /* renamed from: t */
    public static final byte f28888t = 56;

    /* renamed from: u */
    public static final float f28889u = 12.5f;

    /* renamed from: v */
    public static final float f28890v = 3.0f;

    /* renamed from: x */
    public static final float f28892x = 0.75f;

    /* renamed from: y */
    public static final float f28893y = 0.5f;

    /* renamed from: z */
    public static final float f28894z = 0.5f;

    /* renamed from: b */
    public final List<Animation> f28895b = new ArrayList();

    /* renamed from: c */
    public final d f28896c = new d();

    /* renamed from: d */
    public float f28897d;

    /* renamed from: e */
    public View f28898e;

    /* renamed from: f */
    public Animation f28899f;

    /* renamed from: g */
    public float f28900g;

    /* renamed from: h */
    public float f28901h;

    /* renamed from: i */
    public float f28902i;

    /* renamed from: j */
    public boolean f28903j;

    /* renamed from: k */
    public boolean f28904k;

    /* renamed from: l */
    public static final Interpolator f28880l = new LinearInterpolator();

    /* renamed from: m */
    public static final Interpolator f28881m = new FastOutSlowInInterpolator();

    /* renamed from: w */
    public static final int[] f28891w = {-16777216};

    public class a extends Animation {

        /* renamed from: b */
        public final /* synthetic */ d f28905b;

        public a(d dVar) {
            this.f28905b = dVar;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            c cVar = c.this;
            if (cVar.f28903j) {
                cVar.a(f10, this.f28905b);
                return;
            }
            float c10 = cVar.c(this.f28905b);
            d dVar = this.f28905b;
            float f11 = dVar.f28920l;
            float f12 = dVar.f28919k;
            float f13 = dVar.f28921m;
            c.this.l(f10, dVar);
            if (f10 <= 0.5f) {
                this.f28905b.f28912d = f12 + ((0.8f - c10) * c.f28881m.getInterpolation(f10 / 0.5f));
            }
            if (f10 > 0.5f) {
                this.f28905b.f28913e = f11 + ((0.8f - c10) * c.f28881m.getInterpolation((f10 - 0.5f) / 0.5f));
            }
            c.this.f(f13 + (0.25f * f10));
            c cVar2 = c.this;
            cVar2.g((f10 * 216.0f) + ((cVar2.f28900g / 5.0f) * 1080.0f));
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: nf.c$c */
    public @interface InterfaceC0748c {
    }

    public class d {

        /* renamed from: a */
        public final RectF f28909a = new RectF();

        /* renamed from: b */
        public final Paint f28910b;

        /* renamed from: c */
        public final Paint f28911c;

        /* renamed from: d */
        public float f28912d;

        /* renamed from: e */
        public float f28913e;

        /* renamed from: f */
        public float f28914f;

        /* renamed from: g */
        public float f28915g;

        /* renamed from: h */
        public float f28916h;

        /* renamed from: i */
        public int[] f28917i;

        /* renamed from: j */
        public int f28918j;

        /* renamed from: k */
        public float f28919k;

        /* renamed from: l */
        public float f28920l;

        /* renamed from: m */
        public float f28921m;

        /* renamed from: n */
        public boolean f28922n;

        /* renamed from: o */
        public Path f28923o;

        /* renamed from: p */
        public float f28924p;

        /* renamed from: q */
        public double f28925q;

        /* renamed from: r */
        public int f28926r;

        /* renamed from: s */
        public int f28927s;

        /* renamed from: t */
        public int f28928t;

        public d() {
            Paint paint = new Paint();
            this.f28910b = paint;
            Paint paint2 = new Paint();
            this.f28911c = paint2;
            this.f28912d = 0.0f;
            this.f28913e = 0.0f;
            this.f28914f = 0.0f;
            this.f28915g = 5.0f;
            this.f28916h = 2.5f;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
        }

        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f28909a;
            rectF.set(rect);
            float f10 = this.f28916h;
            rectF.inset(f10, f10);
            float f11 = this.f28912d;
            float f12 = this.f28914f;
            float f13 = (f11 + f12) * 360.0f;
            float f14 = ((this.f28913e + f12) * 360.0f) - f13;
            if (f14 != 0.0f) {
                this.f28910b.setColor(this.f28928t);
                canvas.drawArc(rectF, f13, f14, false, this.f28910b);
            }
            b(canvas, f13, f14, rect);
        }

        public final void b(Canvas canvas, float f10, float f11, Rect rect) {
            if (this.f28922n) {
                Path path = this.f28923o;
                if (path == null) {
                    Path path2 = new Path();
                    this.f28923o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float f12 = (((int) this.f28916h) / 2) * this.f28924p;
                float cos = (float) ((this.f28925q * Math.cos(l5.c.f27899e)) + rect.exactCenterX());
                float sin = (float) ((this.f28925q * Math.sin(l5.c.f27899e)) + rect.exactCenterY());
                this.f28923o.moveTo(0.0f, 0.0f);
                this.f28923o.lineTo(this.f28926r * this.f28924p, 0.0f);
                Path path3 = this.f28923o;
                float f13 = this.f28926r;
                float f14 = this.f28924p;
                path3.lineTo((f13 * f14) / 2.0f, this.f28927s * f14);
                this.f28923o.offset(cos - f12, sin);
                this.f28923o.close();
                this.f28911c.setColor(this.f28928t);
                canvas.rotate((f10 + f11) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.f28923o, this.f28911c);
            }
        }

        public int c() {
            return this.f28917i[d()];
        }

        public final int d() {
            return (this.f28918j + 1) % this.f28917i.length;
        }

        public int e() {
            return this.f28917i[this.f28918j];
        }

        public void f() {
            h(d());
        }

        public void g() {
            this.f28919k = 0.0f;
            this.f28920l = 0.0f;
            this.f28921m = 0.0f;
            this.f28912d = 0.0f;
            this.f28913e = 0.0f;
            this.f28914f = 0.0f;
        }

        public void h(int i10) {
            this.f28918j = i10;
            this.f28928t = this.f28917i[i10];
        }

        public void i(int i10, int i11) {
            float min = Math.min(i10, i11);
            double d10 = this.f28925q;
            this.f28916h = (float) ((d10 <= l5.c.f27899e || min < 0.0f) ? Math.ceil(this.f28915g / 2.0f) : (min / 2.0f) - d10);
        }

        public void j() {
            this.f28919k = this.f28912d;
            this.f28920l = this.f28913e;
            this.f28921m = this.f28914f;
        }
    }

    public c(View view) {
        this.f28898e = view;
        e(f28891w);
        m(1);
        j();
    }

    public void a(float f10, d dVar) {
        l(f10, dVar);
        float floor = (float) (Math.floor(dVar.f28921m / 0.8f) + 1.0d);
        float c10 = c(dVar);
        float f11 = dVar.f28919k;
        float f12 = dVar.f28920l;
        i(f11 + (((f12 - c10) - f11) * f10), f12);
        float f13 = dVar.f28921m;
        f(f13 + ((floor - f13) * f10));
    }

    public final int b(float f10, int i10, int i11) {
        return ((((i10 >> 24) & 255) + ((int) ((((i11 >> 24) & 255) - r0) * f10))) << 24) | ((((i10 >> 16) & 255) + ((int) ((((i11 >> 16) & 255) - r1) * f10))) << 16) | ((((i10 >> 8) & 255) + ((int) ((((i11 >> 8) & 255) - r2) * f10))) << 8) | ((i10 & 255) + ((int) (f10 * ((i11 & 255) - r8))));
    }

    public float c(d dVar) {
        return (float) Math.toRadians(dVar.f28915g / (dVar.f28925q * 6.283185307179586d));
    }

    public void d(float f10) {
        d dVar = this.f28896c;
        if (dVar.f28924p != f10) {
            dVar.f28924p = f10;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.f28897d, bounds.exactCenterX(), bounds.exactCenterY());
        this.f28896c.a(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public void e(@ColorInt int... iArr) {
        d dVar = this.f28896c;
        dVar.f28917i = iArr;
        dVar.h(0);
    }

    public void f(float f10) {
        this.f28896c.f28914f = f10;
        invalidateSelf();
    }

    public void g(float f10) {
        this.f28897d = f10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f28902i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f28901h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final void h(int i10, int i11, float f10, float f11, float f12, float f13) {
        float f14 = Resources.getSystem().getDisplayMetrics().density;
        this.f28901h = i10 * f14;
        this.f28902i = i11 * f14;
        this.f28896c.h(0);
        float f15 = f11 * f14;
        this.f28896c.f28910b.setStrokeWidth(f15);
        d dVar = this.f28896c;
        dVar.f28915g = f15;
        dVar.f28925q = f10 * f14;
        dVar.f28926r = (int) (f12 * f14);
        dVar.f28927s = (int) (f13 * f14);
        dVar.i((int) this.f28901h, (int) this.f28902i);
        invalidateSelf();
    }

    public void i(float f10, float f11) {
        d dVar = this.f28896c;
        dVar.f28912d = f10;
        dVar.f28913e = f11;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f28904k;
    }

    public final void j() {
        d dVar = this.f28896c;
        a aVar = new a(dVar);
        aVar.setRepeatCount(-1);
        aVar.setRepeatMode(1);
        aVar.setInterpolator(f28880l);
        aVar.setAnimationListener(new b(dVar));
        this.f28899f = aVar;
    }

    public void k(boolean z10) {
        d dVar = this.f28896c;
        if (dVar.f28922n != z10) {
            dVar.f28922n = z10;
            invalidateSelf();
        }
    }

    public void l(float f10, d dVar) {
        if (f10 > 0.75f) {
            dVar.f28928t = b((f10 - 0.75f) / 0.25f, dVar.e(), dVar.c());
        }
    }

    public void m(int i10) {
        if (i10 == 0) {
            h(56, 56, 12.5f, 3.0f, 12.0f, 6.0f);
        } else {
            h(40, 40, 8.75f, 2.5f, 10.0f, 5.0f);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f28896c.f28910b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f28904k) {
            return;
        }
        this.f28899f.reset();
        this.f28896c.j();
        d dVar = this.f28896c;
        if (dVar.f28913e != dVar.f28912d) {
            this.f28903j = true;
            this.f28899f.setDuration(666L);
            this.f28898e.startAnimation(this.f28899f);
        } else {
            dVar.h(0);
            this.f28896c.g();
            this.f28899f.setDuration(1332L);
            this.f28898e.startAnimation(this.f28899f);
        }
        this.f28904k = true;
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f28904k) {
            this.f28898e.clearAnimation();
            this.f28896c.h(0);
            this.f28896c.g();
            k(false);
            g(0.0f);
            this.f28904k = false;
        }
    }

    public class b implements Animation.AnimationListener {

        /* renamed from: a */
        public final /* synthetic */ d f28907a;

        public b(d dVar) {
            this.f28907a = dVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            this.f28907a.j();
            this.f28907a.f();
            d dVar = this.f28907a;
            dVar.f28912d = dVar.f28913e;
            c cVar = c.this;
            if (!cVar.f28903j) {
                cVar.f28900g = (cVar.f28900g + 1.0f) % 5.0f;
                return;
            }
            cVar.f28903j = false;
            animation.setDuration(1332L);
            c.this.k(false);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            c.this.f28900g = 0.0f;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }
}
