package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class CircularProgressDrawable extends Drawable implements Animatable {
    public static final int DEFAULT = 1;
    public static final int LARGE = 0;

    /* renamed from: c */
    private static final float f3635c = 11.0f;

    /* renamed from: d */
    private static final float f3636d = 3.0f;

    /* renamed from: e */
    private static final int f3637e = 12;

    /* renamed from: f */
    private static final int f3638f = 6;

    /* renamed from: g */
    private static final float f3639g = 7.5f;

    /* renamed from: h */
    private static final float f3640h = 2.5f;

    /* renamed from: i */
    private static final int f3641i = 10;

    /* renamed from: j */
    private static final int f3642j = 5;
    private static final float l = 0.75f;
    private static final float m = 0.5f;
    private static final int n = 1332;
    private static final float o = 216.0f;
    private static final float p = 0.8f;
    private static final float q = 0.01f;
    private static final float r = 0.20999998f;
    private final Ring s;
    private float t;
    private Resources u;
    private Animator v;
    float w;
    boolean x;

    /* renamed from: a */
    private static final Interpolator f3633a = new LinearInterpolator();

    /* renamed from: b */
    private static final Interpolator f3634b = new FastOutSlowInInterpolator();
    private static final int[] k = {-16777216};

    /* renamed from: androidx.swiperefreshlayout.widget.CircularProgressDrawable$1 */
    class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ Ring f3643a;

        AnonymousClass1(Ring ring) {
            ring = ring;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            CircularProgressDrawable.this.h(floatValue, ring);
            CircularProgressDrawable.this.b(floatValue, ring, false);
            CircularProgressDrawable.this.invalidateSelf();
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.CircularProgressDrawable$2 */
    class AnonymousClass2 implements Animator.AnimatorListener {

        /* renamed from: a */
        final /* synthetic */ Ring f3645a;

        AnonymousClass2(Ring ring) {
            ring = ring;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            CircularProgressDrawable.this.b(1.0f, ring, true);
            ring.M();
            ring.v();
            CircularProgressDrawable circularProgressDrawable = CircularProgressDrawable.this;
            if (!circularProgressDrawable.x) {
                circularProgressDrawable.w += 1.0f;
                return;
            }
            circularProgressDrawable.x = false;
            animator.cancel();
            animator.setDuration(1332L);
            animator.start();
            ring.I(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            CircularProgressDrawable.this.w = 0.0f;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ProgressDrawableSize {
    }

    private static class Ring {

        /* renamed from: a */
        final RectF f3647a = new RectF();

        /* renamed from: b */
        final Paint f3648b;

        /* renamed from: c */
        final Paint f3649c;

        /* renamed from: d */
        final Paint f3650d;

        /* renamed from: e */
        float f3651e;

        /* renamed from: f */
        float f3652f;

        /* renamed from: g */
        float f3653g;

        /* renamed from: h */
        float f3654h;

        /* renamed from: i */
        int[] f3655i;

        /* renamed from: j */
        int f3656j;
        float k;
        float l;
        float m;
        boolean n;
        Path o;
        float p;
        float q;
        int r;
        int s;
        int t;
        int u;

        Ring() {
            Paint paint = new Paint();
            this.f3648b = paint;
            Paint paint2 = new Paint();
            this.f3649c = paint2;
            Paint paint3 = new Paint();
            this.f3650d = paint3;
            this.f3651e = 0.0f;
            this.f3652f = 0.0f;
            this.f3653g = 0.0f;
            this.f3654h = 5.0f;
            this.p = 1.0f;
            this.t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        void A(int i2) {
            this.f3650d.setColor(i2);
        }

        void B(float f2) {
            this.q = f2;
        }

        void C(int i2) {
            this.u = i2;
        }

        void D(ColorFilter colorFilter) {
            this.f3648b.setColorFilter(colorFilter);
        }

        void E(int i2) {
            this.f3656j = i2;
            this.u = this.f3655i[i2];
        }

        void F(@NonNull int[] iArr) {
            this.f3655i = iArr;
            E(0);
        }

        void G(float f2) {
            this.f3652f = f2;
        }

        void H(float f2) {
            this.f3653g = f2;
        }

        void I(boolean z) {
            if (this.n != z) {
                this.n = z;
            }
        }

        void J(float f2) {
            this.f3651e = f2;
        }

        void K(Paint.Cap cap) {
            this.f3648b.setStrokeCap(cap);
        }

        void L(float f2) {
            this.f3654h = f2;
            this.f3648b.setStrokeWidth(f2);
        }

        void M() {
            this.k = this.f3651e;
            this.l = this.f3652f;
            this.m = this.f3653g;
        }

        void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f3647a;
            float f2 = this.q;
            float f3 = (this.f3654h / 2.0f) + f2;
            if (f2 <= 0.0f) {
                f3 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.r * this.p) / 2.0f, this.f3654h / 2.0f);
            }
            rectF.set(rect.centerX() - f3, rect.centerY() - f3, rect.centerX() + f3, rect.centerY() + f3);
            float f4 = this.f3651e;
            float f5 = this.f3653g;
            float f6 = (f4 + f5) * 360.0f;
            float f7 = ((this.f3652f + f5) * 360.0f) - f6;
            this.f3648b.setColor(this.u);
            this.f3648b.setAlpha(this.t);
            float f8 = this.f3654h / 2.0f;
            rectF.inset(f8, f8);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f3650d);
            float f9 = -f8;
            rectF.inset(f9, f9);
            canvas.drawArc(rectF, f6, f7, false, this.f3648b);
            b(canvas, f6, f7, rectF);
        }

        void b(Canvas canvas, float f2, float f3, RectF rectF) {
            if (this.n) {
                Path path = this.o;
                if (path == null) {
                    Path path2 = new Path();
                    this.o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f4 = (this.r * this.p) / 2.0f;
                this.o.moveTo(0.0f, 0.0f);
                this.o.lineTo(this.r * this.p, 0.0f);
                Path path3 = this.o;
                float f5 = this.r;
                float f6 = this.p;
                path3.lineTo((f5 * f6) / 2.0f, this.s * f6);
                this.o.offset((min + rectF.centerX()) - f4, rectF.centerY() + (this.f3654h / 2.0f));
                this.o.close();
                this.f3649c.setColor(this.u);
                this.f3649c.setAlpha(this.t);
                canvas.save();
                canvas.rotate(f2 + f3, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.o, this.f3649c);
                canvas.restore();
            }
        }

        int c() {
            return this.t;
        }

        float d() {
            return this.s;
        }

        float e() {
            return this.p;
        }

        float f() {
            return this.r;
        }

        int g() {
            return this.f3650d.getColor();
        }

        float h() {
            return this.q;
        }

        int[] i() {
            return this.f3655i;
        }

        float j() {
            return this.f3652f;
        }

        int k() {
            return this.f3655i[l()];
        }

        int l() {
            return (this.f3656j + 1) % this.f3655i.length;
        }

        float m() {
            return this.f3653g;
        }

        boolean n() {
            return this.n;
        }

        float o() {
            return this.f3651e;
        }

        int p() {
            return this.f3655i[this.f3656j];
        }

        float q() {
            return this.l;
        }

        float r() {
            return this.m;
        }

        float s() {
            return this.k;
        }

        Paint.Cap t() {
            return this.f3648b.getStrokeCap();
        }

        float u() {
            return this.f3654h;
        }

        void v() {
            E(l());
        }

        void w() {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            J(0.0f);
            G(0.0f);
            H(0.0f);
        }

        void x(int i2) {
            this.t = i2;
        }

        void y(float f2, float f3) {
            this.r = (int) f2;
            this.s = (int) f3;
        }

        void z(float f2) {
            if (f2 != this.p) {
                this.p = f2;
            }
        }
    }

    public CircularProgressDrawable(@NonNull Context context) {
        this.u = ((Context) Preconditions.checkNotNull(context)).getResources();
        Ring ring = new Ring();
        this.s = ring;
        ring.F(k);
        setStrokeWidth(f3640h);
        g();
    }

    private void a(float f2, Ring ring) {
        h(f2, ring);
        float floor = (float) (Math.floor(ring.r() / p) + 1.0d);
        ring.J(ring.s() + (((ring.q() - 0.01f) - ring.s()) * f2));
        ring.G(ring.q());
        ring.H(ring.r() + ((floor - ring.r()) * f2));
    }

    private int c(float f2, int i2, int i3) {
        return ((((i2 >> 24) & 255) + ((int) ((((i3 >> 24) & 255) - r0) * f2))) << 24) | ((((i2 >> 16) & 255) + ((int) ((((i3 >> 16) & 255) - r1) * f2))) << 16) | ((((i2 >> 8) & 255) + ((int) ((((i3 >> 8) & 255) - r2) * f2))) << 8) | ((i2 & 255) + ((int) (f2 * ((i3 & 255) - r8))));
    }

    private float d() {
        return this.t;
    }

    private void e(float f2) {
        this.t = f2;
    }

    private void f(float f2, float f3, float f4, float f5) {
        Ring ring = this.s;
        float f6 = this.u.getDisplayMetrics().density;
        ring.L(f3 * f6);
        ring.B(f2 * f6);
        ring.E(0);
        ring.y(f4 * f6, f5 * f6);
    }

    private void g() {
        Ring ring = this.s;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.1

            /* renamed from: a */
            final /* synthetic */ Ring f3643a;

            AnonymousClass1(Ring ring2) {
                ring = ring2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressDrawable.this.h(floatValue, ring);
                CircularProgressDrawable.this.b(floatValue, ring, false);
                CircularProgressDrawable.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f3633a);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.2

            /* renamed from: a */
            final /* synthetic */ Ring f3645a;

            AnonymousClass2(Ring ring2) {
                ring = ring2;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                CircularProgressDrawable.this.b(1.0f, ring, true);
                ring.M();
                ring.v();
                CircularProgressDrawable circularProgressDrawable = CircularProgressDrawable.this;
                if (!circularProgressDrawable.x) {
                    circularProgressDrawable.w += 1.0f;
                    return;
                }
                circularProgressDrawable.x = false;
                animator.cancel();
                animator.setDuration(1332L);
                animator.start();
                ring.I(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                CircularProgressDrawable.this.w = 0.0f;
            }
        });
        this.v = ofFloat;
    }

    void b(float f2, Ring ring, boolean z) {
        float interpolation;
        float f3;
        if (this.x) {
            a(f2, ring);
            return;
        }
        if (f2 != 1.0f || z) {
            float r2 = ring.r();
            if (f2 < 0.5f) {
                interpolation = ring.s();
                f3 = (f3634b.getInterpolation(f2 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float s = ring.s() + 0.79f;
                interpolation = s - (((1.0f - f3634b.getInterpolation((f2 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f3 = s;
            }
            float f4 = r2 + (r * f2);
            float f5 = (f2 + this.w) * o;
            ring.J(interpolation);
            ring.G(f3);
            ring.H(f4);
            e(f5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.t, bounds.exactCenterX(), bounds.exactCenterY());
        this.s.a(canvas, bounds);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.s.c();
    }

    public boolean getArrowEnabled() {
        return this.s.n();
    }

    public float getArrowHeight() {
        return this.s.d();
    }

    public float getArrowScale() {
        return this.s.e();
    }

    public float getArrowWidth() {
        return this.s.f();
    }

    public int getBackgroundColor() {
        return this.s.g();
    }

    public float getCenterRadius() {
        return this.s.h();
    }

    @NonNull
    public int[] getColorSchemeColors() {
        return this.s.i();
    }

    public float getEndTrim() {
        return this.s.j();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float getProgressRotation() {
        return this.s.m();
    }

    public float getStartTrim() {
        return this.s.o();
    }

    @NonNull
    public Paint.Cap getStrokeCap() {
        return this.s.t();
    }

    public float getStrokeWidth() {
        return this.s.u();
    }

    void h(float f2, Ring ring) {
        if (f2 > 0.75f) {
            ring.C(c((f2 - 0.75f) / 0.25f, ring.p(), ring.k()));
        } else {
            ring.C(ring.p());
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.v.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.s.x(i2);
        invalidateSelf();
    }

    public void setArrowDimensions(float f2, float f3) {
        this.s.y(f2, f3);
        invalidateSelf();
    }

    public void setArrowEnabled(boolean z) {
        this.s.I(z);
        invalidateSelf();
    }

    public void setArrowScale(float f2) {
        this.s.z(f2);
        invalidateSelf();
    }

    public void setBackgroundColor(int i2) {
        this.s.A(i2);
        invalidateSelf();
    }

    public void setCenterRadius(float f2) {
        this.s.B(f2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.s.D(colorFilter);
        invalidateSelf();
    }

    public void setColorSchemeColors(@NonNull int... iArr) {
        this.s.F(iArr);
        this.s.E(0);
        invalidateSelf();
    }

    public void setProgressRotation(float f2) {
        this.s.H(f2);
        invalidateSelf();
    }

    public void setStartEndTrim(float f2, float f3) {
        this.s.J(f2);
        this.s.G(f3);
        invalidateSelf();
    }

    public void setStrokeCap(@NonNull Paint.Cap cap) {
        this.s.K(cap);
        invalidateSelf();
    }

    public void setStrokeWidth(float f2) {
        this.s.L(f2);
        invalidateSelf();
    }

    public void setStyle(int i2) {
        if (i2 == 0) {
            f(f3635c, 3.0f, 12.0f, 6.0f);
        } else {
            f(f3639g, f3640h, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.v.cancel();
        this.s.M();
        if (this.s.j() != this.s.o()) {
            this.x = true;
            this.v.setDuration(666L);
            this.v.start();
        } else {
            this.s.E(0);
            this.s.w();
            this.v.setDuration(1332L);
            this.v.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.v.cancel();
        e(0.0f);
        this.s.I(false);
        this.s.E(0);
        this.s.w();
        invalidateSelf();
    }
}
