package com.google.android.material.m.w;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.ArcMotion;
import android.transition.PathMotion;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.m.w.v;
import com.vivo.advv.Color;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class l extends Transition {

    /* renamed from: a */
    public static final int f7621a = 0;

    /* renamed from: b */
    public static final int f7622b = 1;

    /* renamed from: c */
    public static final int f7623c = 2;

    /* renamed from: d */
    public static final int f7624d = 0;

    /* renamed from: e */
    public static final int f7625e = 1;

    /* renamed from: f */
    public static final int f7626f = 2;

    /* renamed from: g */
    public static final int f7627g = 3;

    /* renamed from: h */
    public static final int f7628h = 0;

    /* renamed from: i */
    public static final int f7629i = 1;

    /* renamed from: j */
    public static final int f7630j = 2;
    private static final float s = -1.0f;

    @Nullable
    private View F;

    @Nullable
    private View G;

    @Nullable
    private com.google.android.material.j.o H;

    @Nullable
    private com.google.android.material.j.o I;

    @Nullable
    private e J;

    @Nullable
    private e K;

    @Nullable
    private e L;

    @Nullable
    private e M;
    private boolean N;
    private float O;
    private float P;
    private boolean t = false;
    private boolean u = false;

    @IdRes
    private int v = R.id.content;

    @IdRes
    private int w = -1;

    @IdRes
    private int x = -1;

    @ColorInt
    private int y = 0;

    @ColorInt
    private int z = 0;

    @ColorInt
    private int A = 0;

    @ColorInt
    private int B = 1375731712;
    private int C = 0;
    private int D = 0;
    private int E = 0;
    private static final String k = l.class.getSimpleName();
    private static final String l = "materialContainerTransition:bounds";
    private static final String m = "materialContainerTransition:shapeAppearance";
    private static final String[] n = {l, m};
    private static final f o = new f(new e(0.0f, 0.25f), new e(0.0f, 1.0f), new e(0.0f, 1.0f), new e(0.0f, 0.75f), null);
    private static final f p = new f(new e(0.6f, 0.9f), new e(0.0f, 1.0f), new e(0.0f, 0.9f), new e(0.3f, 0.9f), null);
    private static final f q = new f(new e(0.1f, 0.4f), new e(0.1f, 1.0f), new e(0.1f, 1.0f), new e(0.1f, 0.9f), null);
    private static final f r = new f(new e(0.6f, 0.9f), new e(0.0f, 0.9f), new e(0.0f, 0.9f), new e(0.2f, 0.9f), null);

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ h f7631a;

        a(h hVar) {
            this.f7631a = hVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f7631a.o(valueAnimator.getAnimatedFraction());
        }
    }

    class b extends u {

        /* renamed from: a */
        final /* synthetic */ View f7633a;

        /* renamed from: b */
        final /* synthetic */ h f7634b;

        /* renamed from: c */
        final /* synthetic */ View f7635c;

        /* renamed from: d */
        final /* synthetic */ View f7636d;

        b(View view, h hVar, View view2, View view3) {
            this.f7633a = view;
            this.f7634b = hVar;
            this.f7635c = view2;
            this.f7636d = view3;
        }

        @Override // com.google.android.material.m.w.u, android.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            l.this.removeListener(this);
            if (l.this.u) {
                return;
            }
            this.f7635c.setAlpha(1.0f);
            this.f7636d.setAlpha(1.0f);
            com.google.android.material.internal.u.g(this.f7633a).remove(this.f7634b);
        }

        @Override // com.google.android.material.m.w.u, android.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
            com.google.android.material.internal.u.g(this.f7633a).add(this.f7634b);
            this.f7635c.setAlpha(0.0f);
            this.f7636d.setAlpha(0.0f);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface c {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface d {
    }

    public static class e {

        /* renamed from: a */
        @FloatRange(from = 0.0d, to = 1.0d)
        private final float f7638a;

        /* renamed from: b */
        @FloatRange(from = 0.0d, to = 1.0d)
        private final float f7639b;

        public e(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
            this.f7638a = f2;
            this.f7639b = f3;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float c() {
            return this.f7639b;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float d() {
            return this.f7638a;
        }
    }

    private static class f {

        /* renamed from: a */
        @NonNull
        private final e f7640a;

        /* renamed from: b */
        @NonNull
        private final e f7641b;

        /* renamed from: c */
        @NonNull
        private final e f7642c;

        /* renamed from: d */
        @NonNull
        private final e f7643d;

        /* synthetic */ f(e eVar, e eVar2, e eVar3, e eVar4, a aVar) {
            this(eVar, eVar2, eVar3, eVar4);
        }

        private f(@NonNull e eVar, @NonNull e eVar2, @NonNull e eVar3, @NonNull e eVar4) {
            this.f7640a = eVar;
            this.f7641b = eVar2;
            this.f7642c = eVar3;
            this.f7643d = eVar4;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface g {
    }

    private static final class h extends Drawable {

        /* renamed from: a */
        private static final int f7644a = 754974720;

        /* renamed from: b */
        private static final int f7645b = -7829368;

        /* renamed from: c */
        private static final float f7646c = 0.3f;

        /* renamed from: d */
        private static final float f7647d = 1.5f;
        private final RectF A;
        private final RectF B;
        private final RectF C;
        private final RectF D;
        private final f E;
        private final com.google.android.material.m.w.a F;
        private final com.google.android.material.m.w.f G;
        private final boolean H;
        private final Paint I;
        private final Path J;
        private com.google.android.material.m.w.c K;
        private com.google.android.material.m.w.h L;
        private RectF M;
        private float N;
        private float O;
        private float P;

        /* renamed from: e */
        private final View f7648e;

        /* renamed from: f */
        private final RectF f7649f;

        /* renamed from: g */
        private final com.google.android.material.j.o f7650g;

        /* renamed from: h */
        private final float f7651h;

        /* renamed from: i */
        private final View f7652i;

        /* renamed from: j */
        private final RectF f7653j;
        private final com.google.android.material.j.o k;
        private final float l;
        private final Paint m;
        private final Paint n;
        private final Paint o;
        private final Paint p;
        private final Paint q;
        private final j r;
        private final PathMeasure s;
        private final float t;
        private final float[] u;
        private final boolean v;
        private final float w;
        private final float x;
        private final boolean y;
        private final com.google.android.material.j.j z;

        class a implements v.c {
            a() {
            }

            @Override // com.google.android.material.m.w.v.c
            public void a(Canvas canvas) {
                h.this.f7648e.draw(canvas);
            }
        }

        class b implements v.c {
            b() {
            }

            @Override // com.google.android.material.m.w.v.c
            public void a(Canvas canvas) {
                h.this.f7652i.draw(canvas);
            }
        }

        /* synthetic */ h(PathMotion pathMotion, View view, RectF rectF, com.google.android.material.j.o oVar, float f2, View view2, RectF rectF2, com.google.android.material.j.o oVar2, float f3, int i2, int i3, int i4, int i5, boolean z, boolean z2, com.google.android.material.m.w.a aVar, com.google.android.material.m.w.f fVar, f fVar2, boolean z3, a aVar2) {
            this(pathMotion, view, rectF, oVar, f2, view2, rectF2, oVar2, f3, i2, i3, i4, i5, z, z2, aVar, fVar, fVar2, z3);
        }

        private static float d(RectF rectF, float f2) {
            return ((rectF.centerX() / (f2 / 2.0f)) - 1.0f) * f7646c;
        }

        private static float e(RectF rectF, float f2) {
            return (rectF.centerY() / f2) * f7647d;
        }

        private void f(Canvas canvas, RectF rectF, Path path, @ColorInt int i2) {
            PointF m = m(rectF);
            if (this.P == 0.0f) {
                path.reset();
                path.moveTo(m.x, m.y);
            } else {
                path.lineTo(m.x, m.y);
                this.I.setColor(i2);
                canvas.drawPath(path, this.I);
            }
        }

        private void g(Canvas canvas, RectF rectF, @ColorInt int i2) {
            this.I.setColor(i2);
            canvas.drawRect(rectF, this.I);
        }

        private void h(Canvas canvas) {
            canvas.save();
            canvas.clipPath(this.r.d(), Region.Op.DIFFERENCE);
            if (Build.VERSION.SDK_INT > 28) {
                j(canvas);
            } else {
                i(canvas);
            }
            canvas.restore();
        }

        private void i(Canvas canvas) {
            com.google.android.material.j.j jVar = this.z;
            RectF rectF = this.M;
            jVar.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            this.z.m0(this.N);
            this.z.A0((int) this.O);
            this.z.setShapeAppearanceModel(this.r.c());
            this.z.draw(canvas);
        }

        private void j(Canvas canvas) {
            com.google.android.material.j.o c2 = this.r.c();
            if (!c2.u(this.M)) {
                canvas.drawPath(this.r.d(), this.p);
            } else {
                float a2 = c2.r().a(this.M);
                canvas.drawRoundRect(this.M, a2, a2, this.p);
            }
        }

        private void k(Canvas canvas) {
            n(canvas, this.o);
            Rect bounds = getBounds();
            RectF rectF = this.C;
            v.r(canvas, bounds, rectF.left, rectF.top, this.L.f7611b, this.K.f7594b, new b());
        }

        private void l(Canvas canvas) {
            n(canvas, this.n);
            Rect bounds = getBounds();
            RectF rectF = this.A;
            v.r(canvas, bounds, rectF.left, rectF.top, this.L.f7610a, this.K.f7593a, new a());
        }

        private static PointF m(RectF rectF) {
            return new PointF(rectF.centerX(), rectF.top);
        }

        private void n(Canvas canvas, Paint paint) {
            if (paint.getColor() == 0 || paint.getAlpha() <= 0) {
                return;
            }
            canvas.drawRect(getBounds(), paint);
        }

        public void o(float f2) {
            if (this.P != f2) {
                p(f2);
            }
        }

        private void p(float f2) {
            this.P = f2;
            this.q.setAlpha((int) (this.v ? v.k(0.0f, 255.0f, f2) : v.k(255.0f, 0.0f, f2)));
            this.s.getPosTan(this.t * f2, this.u, null);
            float[] fArr = this.u;
            float f3 = fArr[0];
            float f4 = fArr[1];
            com.google.android.material.m.w.h a2 = this.G.a(f2, ((Float) Preconditions.checkNotNull(Float.valueOf(this.E.f7641b.f7638a))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.E.f7641b.f7639b))).floatValue(), this.f7649f.width(), this.f7649f.height(), this.f7653j.width(), this.f7653j.height());
            this.L = a2;
            RectF rectF = this.A;
            float f5 = a2.f7612c;
            rectF.set(f3 - (f5 / 2.0f), f4, (f5 / 2.0f) + f3, a2.f7613d + f4);
            RectF rectF2 = this.C;
            com.google.android.material.m.w.h hVar = this.L;
            float f6 = hVar.f7614e;
            rectF2.set(f3 - (f6 / 2.0f), f4, f3 + (f6 / 2.0f), hVar.f7615f + f4);
            this.B.set(this.A);
            this.D.set(this.C);
            float floatValue = ((Float) Preconditions.checkNotNull(Float.valueOf(this.E.f7642c.f7638a))).floatValue();
            float floatValue2 = ((Float) Preconditions.checkNotNull(Float.valueOf(this.E.f7642c.f7639b))).floatValue();
            boolean b2 = this.G.b(this.L);
            RectF rectF3 = b2 ? this.B : this.D;
            float l = v.l(0.0f, 1.0f, floatValue, floatValue2, f2);
            if (!b2) {
                l = 1.0f - l;
            }
            this.G.c(rectF3, l, this.L);
            this.M = new RectF(Math.min(this.B.left, this.D.left), Math.min(this.B.top, this.D.top), Math.max(this.B.right, this.D.right), Math.max(this.B.bottom, this.D.bottom));
            this.r.b(f2, this.f7650g, this.k, this.A, this.B, this.D, this.E.f7643d);
            this.N = v.k(this.f7651h, this.l, f2);
            float d2 = d(this.M, this.w);
            float e2 = e(this.M, this.x);
            float f7 = this.N;
            float f8 = (int) (e2 * f7);
            this.O = f8;
            this.p.setShadowLayer(f7, (int) (d2 * f7), f8, f7644a);
            this.K = this.F.a(f2, ((Float) Preconditions.checkNotNull(Float.valueOf(this.E.f7640a.f7638a))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.E.f7640a.f7639b))).floatValue());
            if (this.n.getColor() != 0) {
                this.n.setAlpha(this.K.f7593a);
            }
            if (this.o.getColor() != 0) {
                this.o.setAlpha(this.K.f7594b);
            }
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            if (this.q.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.q);
            }
            int save = this.H ? canvas.save() : -1;
            if (this.y && this.N > 0.0f) {
                h(canvas);
            }
            this.r.a(canvas);
            n(canvas, this.m);
            if (this.K.f7595c) {
                l(canvas);
                k(canvas);
            } else {
                k(canvas);
                l(canvas);
            }
            if (this.H) {
                canvas.restoreToCount(save);
                f(canvas, this.A, this.J, Color.MAGENTA);
                g(canvas, this.B, -256);
                g(canvas, this.A, Color.GREEN);
                g(canvas, this.D, Color.CYAN);
                g(canvas, this.C, Color.BLUE);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i2) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }

        private h(PathMotion pathMotion, View view, RectF rectF, com.google.android.material.j.o oVar, float f2, View view2, RectF rectF2, com.google.android.material.j.o oVar2, float f3, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4, int i5, boolean z, boolean z2, com.google.android.material.m.w.a aVar, com.google.android.material.m.w.f fVar, f fVar2, boolean z3) {
            Paint paint = new Paint();
            this.m = paint;
            Paint paint2 = new Paint();
            this.n = paint2;
            Paint paint3 = new Paint();
            this.o = paint3;
            this.p = new Paint();
            Paint paint4 = new Paint();
            this.q = paint4;
            this.r = new j();
            this.u = new float[]{rectF.centerX(), rectF.top};
            com.google.android.material.j.j jVar = new com.google.android.material.j.j();
            this.z = jVar;
            Paint paint5 = new Paint();
            this.I = paint5;
            this.J = new Path();
            this.f7648e = view;
            this.f7649f = rectF;
            this.f7650g = oVar;
            this.f7651h = f2;
            this.f7652i = view2;
            this.f7653j = rectF2;
            this.k = oVar2;
            this.l = f3;
            this.v = z;
            this.y = z2;
            this.F = aVar;
            this.G = fVar;
            this.E = fVar2;
            this.H = z3;
            WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
            windowManager.getDefaultDisplay().getMetrics(new DisplayMetrics());
            this.w = r12.widthPixels;
            this.x = r12.heightPixels;
            paint.setColor(i2);
            paint2.setColor(i3);
            paint3.setColor(i4);
            jVar.n0(ColorStateList.valueOf(0));
            jVar.w0(2);
            jVar.t0(false);
            jVar.u0(-7829368);
            RectF rectF3 = new RectF(rectF);
            this.A = rectF3;
            this.B = new RectF(rectF3);
            RectF rectF4 = new RectF(rectF3);
            this.C = rectF4;
            this.D = new RectF(rectF4);
            PointF m = m(rectF);
            PointF m2 = m(rectF2);
            PathMeasure pathMeasure = new PathMeasure(pathMotion.getPath(m.x, m.y, m2.x, m2.y), false);
            this.s = pathMeasure;
            this.t = pathMeasure.getLength();
            paint4.setStyle(Paint.Style.FILL);
            paint4.setShader(v.c(i5));
            paint5.setStyle(Paint.Style.STROKE);
            paint5.setStrokeWidth(10.0f);
            p(0.0f);
        }
    }

    public l() {
        this.N = Build.VERSION.SDK_INT >= 28;
        this.O = -1.0f;
        this.P = -1.0f;
        setInterpolator(com.google.android.material.a.a.f6608b);
    }

    private f A(boolean z, f fVar, f fVar2) {
        if (!z) {
            fVar = fVar2;
        }
        return new f((e) v.d(this.J, fVar.f7640a), (e) v.d(this.K, fVar.f7641b), (e) v.d(this.L, fVar.f7642c), (e) v.d(this.M, fVar.f7643d), null);
    }

    @StyleRes
    private static int C(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{com.google.android.material.R.attr.transitionShapeAppearance});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private boolean F(@NonNull RectF rectF, @NonNull RectF rectF2) {
        int i2 = this.C;
        if (i2 == 0) {
            return v.a(rectF2) > v.a(rectF);
        }
        if (i2 == 1) {
            return true;
        }
        if (i2 == 2) {
            return false;
        }
        throw new IllegalArgumentException("Invalid transition direction: " + this.C);
    }

    private f b(boolean z) {
        PathMotion pathMotion = getPathMotion();
        return ((pathMotion instanceof ArcMotion) || (pathMotion instanceof k)) ? A(z, q, r) : A(z, o, p);
    }

    private static RectF c(View view, @Nullable View view2, float f2, float f3) {
        if (view2 == null) {
            return new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        }
        RectF g2 = v.g(view2);
        g2.offset(f2, f3);
        return g2;
    }

    private static com.google.android.material.j.o d(@NonNull View view, @NonNull RectF rectF, @Nullable com.google.android.material.j.o oVar) {
        return v.b(t(view, oVar), rectF);
    }

    private static void e(@NonNull TransitionValues transitionValues, @Nullable View view, @IdRes int i2, @Nullable com.google.android.material.j.o oVar) {
        if (i2 != -1) {
            transitionValues.view = v.f(transitionValues.view, i2);
        } else if (view != null) {
            transitionValues.view = view;
        } else {
            View view2 = transitionValues.view;
            int i3 = com.google.android.material.R.id.mtrl_motion_snapshot_view;
            if (view2.getTag(i3) instanceof View) {
                View view3 = (View) transitionValues.view.getTag(i3);
                transitionValues.view.setTag(i3, null);
                transitionValues.view = view3;
            }
        }
        View view4 = transitionValues.view;
        if (!ViewCompat.isLaidOut(view4) && view4.getWidth() == 0 && view4.getHeight() == 0) {
            return;
        }
        RectF h2 = view4.getParent() == null ? v.h(view4) : v.g(view4);
        transitionValues.values.put(l, h2);
        transitionValues.values.put(m, d(view4, h2, oVar));
    }

    private static float h(float f2, View view) {
        return f2 != -1.0f ? f2 : ViewCompat.getElevation(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static com.google.android.material.j.o t(@NonNull View view, @Nullable com.google.android.material.j.o oVar) {
        if (oVar != null) {
            return oVar;
        }
        int i2 = com.google.android.material.R.id.mtrl_motion_snapshot_view;
        if (view.getTag(i2) instanceof com.google.android.material.j.o) {
            return (com.google.android.material.j.o) view.getTag(i2);
        }
        Context context = view.getContext();
        int C = C(context);
        return C != -1 ? com.google.android.material.j.o.b(context, C, 0).m() : view instanceof com.google.android.material.j.s ? ((com.google.android.material.j.s) view).getShapeAppearanceModel() : com.google.android.material.j.o.a().m();
    }

    public int B() {
        return this.C;
    }

    public boolean D() {
        return this.t;
    }

    public boolean E() {
        return this.N;
    }

    public boolean G() {
        return this.u;
    }

    public void H(@ColorInt int i2) {
        this.y = i2;
        this.z = i2;
        this.A = i2;
    }

    public void I(@ColorInt int i2) {
        this.y = i2;
    }

    public void J(boolean z) {
        this.t = z;
    }

    public void K(@IdRes int i2) {
        this.v = i2;
    }

    public void L(boolean z) {
        this.N = z;
    }

    public void M(@ColorInt int i2) {
        this.A = i2;
    }

    public void N(float f2) {
        this.P = f2;
    }

    public void O(@Nullable com.google.android.material.j.o oVar) {
        this.I = oVar;
    }

    public void P(@Nullable View view) {
        this.G = view;
    }

    public void Q(@IdRes int i2) {
        this.x = i2;
    }

    public void R(int i2) {
        this.D = i2;
    }

    public void S(@Nullable e eVar) {
        this.J = eVar;
    }

    public void T(int i2) {
        this.E = i2;
    }

    public void U(boolean z) {
        this.u = z;
    }

    public void V(@Nullable e eVar) {
        this.L = eVar;
    }

    public void W(@Nullable e eVar) {
        this.K = eVar;
    }

    public void X(@ColorInt int i2) {
        this.B = i2;
    }

    public void Y(@Nullable e eVar) {
        this.M = eVar;
    }

    public void Z(@ColorInt int i2) {
        this.z = i2;
    }

    public void a0(float f2) {
        this.O = f2;
    }

    public void b0(@Nullable com.google.android.material.j.o oVar) {
        this.H = oVar;
    }

    public void c0(@Nullable View view) {
        this.F = view;
    }

    @Override // android.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        e(transitionValues, this.G, this.x, this.I);
    }

    @Override // android.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        e(transitionValues, this.F, this.w, this.H);
    }

    @Override // android.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        View e2;
        if (transitionValues != null && transitionValues2 != null) {
            RectF rectF = (RectF) transitionValues.values.get(l);
            com.google.android.material.j.o oVar = (com.google.android.material.j.o) transitionValues.values.get(m);
            if (rectF != null && oVar != null) {
                RectF rectF2 = (RectF) transitionValues2.values.get(l);
                com.google.android.material.j.o oVar2 = (com.google.android.material.j.o) transitionValues2.values.get(m);
                if (rectF2 == null || oVar2 == null) {
                    Log.w(k, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
                    return null;
                }
                View view = transitionValues.view;
                View view2 = transitionValues2.view;
                View view3 = view2.getParent() != null ? view2 : view;
                if (this.v == view3.getId()) {
                    e2 = (View) view3.getParent();
                } else {
                    e2 = v.e(view3, this.v);
                    view3 = null;
                }
                RectF g2 = v.g(e2);
                float f2 = -g2.left;
                float f3 = -g2.top;
                RectF c2 = c(e2, view3, f2, f3);
                rectF.offset(f2, f3);
                rectF2.offset(f2, f3);
                boolean F = F(rectF, rectF2);
                h hVar = new h(getPathMotion(), view, rectF, oVar, h(this.O, view), view2, rectF2, oVar2, h(this.P, view2), this.y, this.z, this.A, this.B, F, this.N, com.google.android.material.m.w.b.a(this.D, F), com.google.android.material.m.w.g.a(this.E, F, rectF, rectF2), b(F), this.t, null);
                hVar.setBounds(Math.round(c2.left), Math.round(c2.top), Math.round(c2.right), Math.round(c2.bottom));
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.addUpdateListener(new a(hVar));
                addListener(new b(e2, hVar, view, view2));
                return ofFloat;
            }
            Log.w(k, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
        }
        return null;
    }

    public void d0(@IdRes int i2) {
        this.w = i2;
    }

    public void e0(int i2) {
        this.C = i2;
    }

    @ColorInt
    public int f() {
        return this.y;
    }

    @IdRes
    public int g() {
        return this.v;
    }

    @Override // android.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return n;
    }

    @ColorInt
    public int i() {
        return this.A;
    }

    public float j() {
        return this.P;
    }

    @Nullable
    public com.google.android.material.j.o k() {
        return this.I;
    }

    @Nullable
    public View l() {
        return this.G;
    }

    @IdRes
    public int m() {
        return this.x;
    }

    public int n() {
        return this.D;
    }

    @Nullable
    public e o() {
        return this.J;
    }

    public int p() {
        return this.E;
    }

    @Nullable
    public e q() {
        return this.L;
    }

    @Nullable
    public e r() {
        return this.K;
    }

    @ColorInt
    public int s() {
        return this.B;
    }

    @Nullable
    public e u() {
        return this.M;
    }

    @ColorInt
    public int v() {
        return this.z;
    }

    public float w() {
        return this.O;
    }

    @Nullable
    public com.google.android.material.j.o x() {
        return this.H;
    }

    @Nullable
    public View y() {
        return this.F;
    }

    @IdRes
    public int z() {
        return this.w;
    }
}
