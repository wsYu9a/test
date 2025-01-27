package com.google.android.material.m;

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
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.transition.ArcMotion;
import androidx.transition.PathMotion;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.google.android.material.m.u;
import com.vivo.advv.Color;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class l extends Transition {
    public static final int S = 0;
    public static final int T = 1;
    public static final int U = 2;
    public static final int V = 0;
    public static final int W = 1;
    public static final int X = 2;
    public static final int Y = 3;
    public static final int Z = 0;
    public static final int a0 = 1;
    public static final int b0 = 2;
    private static final float k0 = -1.0f;

    @Nullable
    private com.google.android.material.j.o A0;

    @Nullable
    private e B0;

    @Nullable
    private e C0;

    @Nullable
    private e D0;

    @Nullable
    private e F0;
    private boolean G0;
    private float H0;
    private float I0;
    private boolean l0 = false;
    private boolean m0 = false;

    @IdRes
    private int n0 = R.id.content;

    @IdRes
    private int o0 = -1;

    @IdRes
    private int p0 = -1;

    @ColorInt
    private int q0 = 0;

    @ColorInt
    private int r0 = 0;

    @ColorInt
    private int s0 = 0;

    @ColorInt
    private int t0 = 1375731712;
    private int u0 = 0;
    private int v0 = 0;
    private int w0 = 0;

    @Nullable
    private View x0;

    @Nullable
    private View y0;

    @Nullable
    private com.google.android.material.j.o z0;
    private static final String c0 = l.class.getSimpleName();
    private static final String d0 = "materialContainerTransition:bounds";
    private static final String e0 = "materialContainerTransition:shapeAppearance";
    private static final String[] f0 = {d0, e0};
    private static final f g0 = new f(new e(0.0f, 0.25f), new e(0.0f, 1.0f), new e(0.0f, 1.0f), new e(0.0f, 0.75f), null);
    private static final f h0 = new f(new e(0.6f, 0.9f), new e(0.0f, 1.0f), new e(0.0f, 0.9f), new e(0.3f, 0.9f), null);
    private static final f i0 = new f(new e(0.1f, 0.4f), new e(0.1f, 1.0f), new e(0.1f, 1.0f), new e(0.1f, 0.9f), null);
    private static final f j0 = new f(new e(0.6f, 0.9f), new e(0.0f, 0.9f), new e(0.0f, 0.9f), new e(0.2f, 0.9f), null);

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ h f7548a;

        a(h hVar) {
            this.f7548a = hVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f7548a.o(valueAnimator.getAnimatedFraction());
        }
    }

    class b extends t {

        /* renamed from: a */
        final /* synthetic */ View f7550a;

        /* renamed from: b */
        final /* synthetic */ h f7551b;

        /* renamed from: c */
        final /* synthetic */ View f7552c;

        /* renamed from: d */
        final /* synthetic */ View f7553d;

        b(View view, h hVar, View view2, View view3) {
            this.f7550a = view;
            this.f7551b = hVar;
            this.f7552c = view2;
            this.f7553d = view3;
        }

        @Override // com.google.android.material.m.t, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            l.this.removeListener(this);
            if (l.this.m0) {
                return;
            }
            this.f7552c.setAlpha(1.0f);
            this.f7553d.setAlpha(1.0f);
            com.google.android.material.internal.u.g(this.f7550a).remove(this.f7551b);
        }

        @Override // com.google.android.material.m.t, androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
            com.google.android.material.internal.u.g(this.f7550a).add(this.f7551b);
            this.f7552c.setAlpha(0.0f);
            this.f7553d.setAlpha(0.0f);
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
        private final float f7555a;

        /* renamed from: b */
        @FloatRange(from = 0.0d, to = 1.0d)
        private final float f7556b;

        public e(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
            this.f7555a = f2;
            this.f7556b = f3;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float c() {
            return this.f7556b;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float d() {
            return this.f7555a;
        }
    }

    private static class f {

        /* renamed from: a */
        @NonNull
        private final e f7557a;

        /* renamed from: b */
        @NonNull
        private final e f7558b;

        /* renamed from: c */
        @NonNull
        private final e f7559c;

        /* renamed from: d */
        @NonNull
        private final e f7560d;

        /* synthetic */ f(e eVar, e eVar2, e eVar3, e eVar4, a aVar) {
            this(eVar, eVar2, eVar3, eVar4);
        }

        private f(@NonNull e eVar, @NonNull e eVar2, @NonNull e eVar3, @NonNull e eVar4) {
            this.f7557a = eVar;
            this.f7558b = eVar2;
            this.f7559c = eVar3;
            this.f7560d = eVar4;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface g {
    }

    private static final class h extends Drawable {

        /* renamed from: a */
        private static final int f7561a = 754974720;

        /* renamed from: b */
        private static final int f7562b = -7829368;

        /* renamed from: c */
        private static final float f7563c = 0.3f;

        /* renamed from: d */
        private static final float f7564d = 1.5f;
        private final RectF A;
        private final RectF B;
        private final RectF C;
        private final RectF D;
        private final f E;
        private final com.google.android.material.m.a F;
        private final com.google.android.material.m.f G;
        private final boolean H;
        private final Paint I;
        private final Path J;
        private com.google.android.material.m.c K;
        private com.google.android.material.m.h L;
        private RectF M;
        private float N;
        private float O;
        private float P;

        /* renamed from: e */
        private final View f7565e;

        /* renamed from: f */
        private final RectF f7566f;

        /* renamed from: g */
        private final com.google.android.material.j.o f7567g;

        /* renamed from: h */
        private final float f7568h;

        /* renamed from: i */
        private final View f7569i;

        /* renamed from: j */
        private final RectF f7570j;
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

        class a implements u.c {
            a() {
            }

            @Override // com.google.android.material.m.u.c
            public void a(Canvas canvas) {
                h.this.f7565e.draw(canvas);
            }
        }

        class b implements u.c {
            b() {
            }

            @Override // com.google.android.material.m.u.c
            public void a(Canvas canvas) {
                h.this.f7569i.draw(canvas);
            }
        }

        /* synthetic */ h(PathMotion pathMotion, View view, RectF rectF, com.google.android.material.j.o oVar, float f2, View view2, RectF rectF2, com.google.android.material.j.o oVar2, float f3, int i2, int i3, int i4, int i5, boolean z, boolean z2, com.google.android.material.m.a aVar, com.google.android.material.m.f fVar, f fVar2, boolean z3, a aVar2) {
            this(pathMotion, view, rectF, oVar, f2, view2, rectF2, oVar2, f3, i2, i3, i4, i5, z, z2, aVar, fVar, fVar2, z3);
        }

        private static float d(RectF rectF, float f2) {
            return ((rectF.centerX() / (f2 / 2.0f)) - 1.0f) * f7563c;
        }

        private static float e(RectF rectF, float f2) {
            return (rectF.centerY() / f2) * f7564d;
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
            u.r(canvas, bounds, rectF.left, rectF.top, this.L.f7538b, this.K.f7521b, new b());
        }

        private void l(Canvas canvas) {
            n(canvas, this.n);
            Rect bounds = getBounds();
            RectF rectF = this.A;
            u.r(canvas, bounds, rectF.left, rectF.top, this.L.f7537a, this.K.f7520a, new a());
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
            this.q.setAlpha((int) (this.v ? u.k(0.0f, 255.0f, f2) : u.k(255.0f, 0.0f, f2)));
            this.s.getPosTan(this.t * f2, this.u, null);
            float[] fArr = this.u;
            float f3 = fArr[0];
            float f4 = fArr[1];
            com.google.android.material.m.h a2 = this.G.a(f2, ((Float) Preconditions.checkNotNull(Float.valueOf(this.E.f7558b.f7555a))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.E.f7558b.f7556b))).floatValue(), this.f7566f.width(), this.f7566f.height(), this.f7570j.width(), this.f7570j.height());
            this.L = a2;
            RectF rectF = this.A;
            float f5 = a2.f7539c;
            rectF.set(f3 - (f5 / 2.0f), f4, (f5 / 2.0f) + f3, a2.f7540d + f4);
            RectF rectF2 = this.C;
            com.google.android.material.m.h hVar = this.L;
            float f6 = hVar.f7541e;
            rectF2.set(f3 - (f6 / 2.0f), f4, f3 + (f6 / 2.0f), hVar.f7542f + f4);
            this.B.set(this.A);
            this.D.set(this.C);
            float floatValue = ((Float) Preconditions.checkNotNull(Float.valueOf(this.E.f7559c.f7555a))).floatValue();
            float floatValue2 = ((Float) Preconditions.checkNotNull(Float.valueOf(this.E.f7559c.f7556b))).floatValue();
            boolean b2 = this.G.b(this.L);
            RectF rectF3 = b2 ? this.B : this.D;
            float l = u.l(0.0f, 1.0f, floatValue, floatValue2, f2);
            if (!b2) {
                l = 1.0f - l;
            }
            this.G.c(rectF3, l, this.L);
            this.M = new RectF(Math.min(this.B.left, this.D.left), Math.min(this.B.top, this.D.top), Math.max(this.B.right, this.D.right), Math.max(this.B.bottom, this.D.bottom));
            this.r.b(f2, this.f7567g, this.k, this.A, this.B, this.D, this.E.f7560d);
            this.N = u.k(this.f7568h, this.l, f2);
            float d2 = d(this.M, this.w);
            float e2 = e(this.M, this.x);
            float f7 = this.N;
            float f8 = (int) (e2 * f7);
            this.O = f8;
            this.p.setShadowLayer(f7, (int) (d2 * f7), f8, f7561a);
            this.K = this.F.a(f2, ((Float) Preconditions.checkNotNull(Float.valueOf(this.E.f7557a.f7555a))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.E.f7557a.f7556b))).floatValue());
            if (this.n.getColor() != 0) {
                this.n.setAlpha(this.K.f7520a);
            }
            if (this.o.getColor() != 0) {
                this.o.setAlpha(this.K.f7521b);
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
            if (this.K.f7522c) {
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

        private h(PathMotion pathMotion, View view, RectF rectF, com.google.android.material.j.o oVar, float f2, View view2, RectF rectF2, com.google.android.material.j.o oVar2, float f3, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4, int i5, boolean z, boolean z2, com.google.android.material.m.a aVar, com.google.android.material.m.f fVar, f fVar2, boolean z3) {
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
            this.f7565e = view;
            this.f7566f = rectF;
            this.f7567g = oVar;
            this.f7568h = f2;
            this.f7569i = view2;
            this.f7570j = rectF2;
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
            paint4.setShader(u.c(i5));
            paint5.setStyle(Paint.Style.STROKE);
            paint5.setStrokeWidth(10.0f);
            p(0.0f);
        }
    }

    public l() {
        this.G0 = Build.VERSION.SDK_INT >= 28;
        this.H0 = -1.0f;
        this.I0 = -1.0f;
        setInterpolator(com.google.android.material.a.a.f6608b);
    }

    private f I(boolean z) {
        PathMotion pathMotion = getPathMotion();
        return ((pathMotion instanceof ArcMotion) || (pathMotion instanceof k)) ? h0(z, i0, j0) : h0(z, g0, h0);
    }

    private static RectF J(View view, @Nullable View view2, float f2, float f3) {
        if (view2 == null) {
            return new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        }
        RectF g2 = u.g(view2);
        g2.offset(f2, f3);
        return g2;
    }

    private static com.google.android.material.j.o K(@NonNull View view, @NonNull RectF rectF, @Nullable com.google.android.material.j.o oVar) {
        return u.b(a0(view, oVar), rectF);
    }

    private static void L(@NonNull TransitionValues transitionValues, @Nullable View view, @IdRes int i2, @Nullable com.google.android.material.j.o oVar) {
        if (i2 != -1) {
            transitionValues.view = u.f(transitionValues.view, i2);
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
        RectF h2 = view4.getParent() == null ? u.h(view4) : u.g(view4);
        transitionValues.values.put(d0, h2);
        transitionValues.values.put(e0, K(view4, h2, oVar));
    }

    private static float O(float f2, View view) {
        return f2 != -1.0f ? f2 : ViewCompat.getElevation(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static com.google.android.material.j.o a0(@NonNull View view, @Nullable com.google.android.material.j.o oVar) {
        if (oVar != null) {
            return oVar;
        }
        int i2 = com.google.android.material.R.id.mtrl_motion_snapshot_view;
        if (view.getTag(i2) instanceof com.google.android.material.j.o) {
            return (com.google.android.material.j.o) view.getTag(i2);
        }
        Context context = view.getContext();
        int j02 = j0(context);
        return j02 != -1 ? com.google.android.material.j.o.b(context, j02, 0).m() : view instanceof com.google.android.material.j.s ? ((com.google.android.material.j.s) view).getShapeAppearanceModel() : com.google.android.material.j.o.a().m();
    }

    private f h0(boolean z, f fVar, f fVar2) {
        if (!z) {
            fVar = fVar2;
        }
        return new f((e) u.d(this.B0, fVar.f7557a), (e) u.d(this.C0, fVar.f7558b), (e) u.d(this.D0, fVar.f7559c), (e) u.d(this.F0, fVar.f7560d), null);
    }

    @StyleRes
    private static int j0(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{com.google.android.material.R.attr.transitionShapeAppearance});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private boolean m0(@NonNull RectF rectF, @NonNull RectF rectF2) {
        int i2 = this.u0;
        if (i2 == 0) {
            return u.a(rectF2) > u.a(rectF);
        }
        if (i2 == 1) {
            return true;
        }
        if (i2 == 2) {
            return false;
        }
        throw new IllegalArgumentException("Invalid transition direction: " + this.u0);
    }

    public void A0(int i2) {
        this.w0 = i2;
    }

    public void B0(boolean z) {
        this.m0 = z;
    }

    public void C0(@Nullable e eVar) {
        this.D0 = eVar;
    }

    public void D0(@Nullable e eVar) {
        this.C0 = eVar;
    }

    public void E0(@ColorInt int i2) {
        this.t0 = i2;
    }

    public void F0(@Nullable e eVar) {
        this.F0 = eVar;
    }

    public void G0(@ColorInt int i2) {
        this.r0 = i2;
    }

    public void H0(float f2) {
        this.H0 = f2;
    }

    public void I0(@Nullable com.google.android.material.j.o oVar) {
        this.z0 = oVar;
    }

    public void J0(@Nullable View view) {
        this.x0 = view;
    }

    public void K0(@IdRes int i2) {
        this.o0 = i2;
    }

    public void L0(int i2) {
        this.u0 = i2;
    }

    @ColorInt
    public int M() {
        return this.q0;
    }

    @IdRes
    public int N() {
        return this.n0;
    }

    @ColorInt
    public int P() {
        return this.s0;
    }

    public float Q() {
        return this.I0;
    }

    @Nullable
    public com.google.android.material.j.o R() {
        return this.A0;
    }

    @Nullable
    public View S() {
        return this.y0;
    }

    @IdRes
    public int T() {
        return this.p0;
    }

    public int U() {
        return this.v0;
    }

    @Nullable
    public e V() {
        return this.B0;
    }

    public int W() {
        return this.w0;
    }

    @Nullable
    public e X() {
        return this.D0;
    }

    @Nullable
    public e Y() {
        return this.C0;
    }

    @ColorInt
    public int Z() {
        return this.t0;
    }

    @Nullable
    public e b0() {
        return this.F0;
    }

    @ColorInt
    public int c0() {
        return this.r0;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        L(transitionValues, this.y0, this.p0, this.A0);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        L(transitionValues, this.x0, this.o0, this.z0);
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        View e2;
        if (transitionValues != null && transitionValues2 != null) {
            RectF rectF = (RectF) transitionValues.values.get(d0);
            com.google.android.material.j.o oVar = (com.google.android.material.j.o) transitionValues.values.get(e0);
            if (rectF != null && oVar != null) {
                RectF rectF2 = (RectF) transitionValues2.values.get(d0);
                com.google.android.material.j.o oVar2 = (com.google.android.material.j.o) transitionValues2.values.get(e0);
                if (rectF2 == null || oVar2 == null) {
                    Log.w(c0, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
                    return null;
                }
                View view = transitionValues.view;
                View view2 = transitionValues2.view;
                View view3 = view2.getParent() != null ? view2 : view;
                if (this.n0 == view3.getId()) {
                    e2 = (View) view3.getParent();
                } else {
                    e2 = u.e(view3, this.n0);
                    view3 = null;
                }
                RectF g2 = u.g(e2);
                float f2 = -g2.left;
                float f3 = -g2.top;
                RectF J = J(e2, view3, f2, f3);
                rectF.offset(f2, f3);
                rectF2.offset(f2, f3);
                boolean m0 = m0(rectF, rectF2);
                h hVar = new h(getPathMotion(), view, rectF, oVar, O(this.H0, view), view2, rectF2, oVar2, O(this.I0, view2), this.q0, this.r0, this.s0, this.t0, m0, this.G0, com.google.android.material.m.b.a(this.v0, m0), com.google.android.material.m.g.a(this.w0, m0, rectF, rectF2), I(m0), this.l0, null);
                hVar.setBounds(Math.round(J.left), Math.round(J.top), Math.round(J.right), Math.round(J.bottom));
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.addUpdateListener(new a(hVar));
                addListener(new b(e2, hVar, view, view2));
                return ofFloat;
            }
            Log.w(c0, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
        }
        return null;
    }

    public float d0() {
        return this.H0;
    }

    @Nullable
    public com.google.android.material.j.o e0() {
        return this.z0;
    }

    @Nullable
    public View f0() {
        return this.x0;
    }

    @IdRes
    public int g0() {
        return this.o0;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return f0;
    }

    public int i0() {
        return this.u0;
    }

    public boolean k0() {
        return this.l0;
    }

    public boolean l0() {
        return this.G0;
    }

    public boolean n0() {
        return this.m0;
    }

    public void o0(@ColorInt int i2) {
        this.q0 = i2;
        this.r0 = i2;
        this.s0 = i2;
    }

    public void p0(@ColorInt int i2) {
        this.q0 = i2;
    }

    public void q0(boolean z) {
        this.l0 = z;
    }

    public void r0(@IdRes int i2) {
        this.n0 = i2;
    }

    public void s0(boolean z) {
        this.G0 = z;
    }

    public void t0(@ColorInt int i2) {
        this.s0 = i2;
    }

    public void u0(float f2) {
        this.I0 = f2;
    }

    public void v0(@Nullable com.google.android.material.j.o oVar) {
        this.A0 = oVar;
    }

    public void w0(@Nullable View view) {
        this.y0 = view;
    }

    public void x0(@IdRes int i2) {
        this.p0 = i2;
    }

    public void y0(int i2) {
        this.v0 = i2;
    }

    public void z0(@Nullable e eVar) {
        this.B0 = eVar;
    }
}
