package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.j.o;
import com.google.android.material.j.s;
import com.vivo.advv.Color;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
class d {

    /* renamed from: b */
    static final long f7195b = 100;

    /* renamed from: c */
    static final long f7196c = 100;

    /* renamed from: d */
    static final int f7197d = 0;

    /* renamed from: e */
    static final int f7198e = 1;

    /* renamed from: f */
    static final int f7199f = 2;

    /* renamed from: g */
    static final float f7200g = 1.5f;

    /* renamed from: h */
    private static final float f7201h = 0.0f;

    /* renamed from: i */
    private static final float f7202i = 0.0f;

    /* renamed from: j */
    private static final float f7203j = 0.0f;
    private static final float k = 1.0f;
    private static final float l = 1.0f;
    private static final float m = 1.0f;
    float A;
    float B;
    float C;
    int D;

    @NonNull
    private final com.google.android.material.internal.k E;

    @Nullable
    private com.google.android.material.a.h F;

    @Nullable
    private com.google.android.material.a.h G;

    @Nullable
    private Animator H;

    @Nullable
    private com.google.android.material.a.h I;

    @Nullable
    private com.google.android.material.a.h J;
    private float K;
    private int M;
    private ArrayList<Animator.AnimatorListener> O;
    private ArrayList<Animator.AnimatorListener> P;
    private ArrayList<i> Q;
    final FloatingActionButton R;
    final com.google.android.material.i.c S;

    @Nullable
    private ViewTreeObserver.OnPreDrawListener X;

    @Nullable
    o t;

    @Nullable
    com.google.android.material.j.j u;

    @Nullable
    Drawable v;

    @Nullable
    com.google.android.material.floatingactionbutton.c w;

    @Nullable
    Drawable x;
    boolean y;

    /* renamed from: a */
    static final TimeInterpolator f7194a = com.google.android.material.a.a.f6609c;
    static final int[] n = {R.attr.state_pressed, R.attr.state_enabled};
    static final int[] o = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    static final int[] p = {R.attr.state_focused, R.attr.state_enabled};
    static final int[] q = {R.attr.state_hovered, R.attr.state_enabled};
    static final int[] r = {R.attr.state_enabled};
    static final int[] s = new int[0];
    boolean z = true;
    private float L = 1.0f;
    private int N = 0;
    private final Rect T = new Rect();
    private final RectF U = new RectF();
    private final RectF V = new RectF();
    private final Matrix W = new Matrix();

    class a extends AnimatorListenerAdapter {

        /* renamed from: a */
        private boolean f7204a;

        /* renamed from: b */
        final /* synthetic */ boolean f7205b;

        /* renamed from: c */
        final /* synthetic */ j f7206c;

        a(boolean z, j jVar) {
            this.f7205b = z;
            this.f7206c = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f7204a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.N = 0;
            d.this.H = null;
            if (this.f7204a) {
                return;
            }
            FloatingActionButton floatingActionButton = d.this.R;
            boolean z = this.f7205b;
            floatingActionButton.c(z ? 8 : 4, z);
            j jVar = this.f7206c;
            if (jVar != null) {
                jVar.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.R.c(0, this.f7205b);
            d.this.N = 1;
            d.this.H = animator;
            this.f7204a = false;
        }
    }

    class b extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ boolean f7208a;

        /* renamed from: b */
        final /* synthetic */ j f7209b;

        b(boolean z, j jVar) {
            this.f7208a = z;
            this.f7209b = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.N = 0;
            d.this.H = null;
            j jVar = this.f7209b;
            if (jVar != null) {
                jVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.R.c(0, this.f7208a);
            d.this.N = 2;
            d.this.H = animator;
        }
    }

    class c extends com.google.android.material.a.g {
        c() {
        }

        @Override // com.google.android.material.a.g, android.animation.TypeEvaluator
        /* renamed from: a */
        public Matrix evaluate(float f2, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
            d.this.L = f2;
            return super.evaluate(f2, matrix, matrix2);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.d$d */
    class C0090d implements TypeEvaluator<Float> {

        /* renamed from: a */
        FloatEvaluator f7212a = new FloatEvaluator();

        C0090d() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public Float evaluate(float f2, Float f3, Float f4) {
            float floatValue = this.f7212a.evaluate(f2, (Number) f3, (Number) f4).floatValue();
            if (floatValue < 0.1f) {
                floatValue = 0.0f;
            }
            return Float.valueOf(floatValue);
        }
    }

    class e implements ViewTreeObserver.OnPreDrawListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            d.this.H();
            return true;
        }
    }

    private class f extends l {
        f() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.l
        protected float a() {
            return 0.0f;
        }
    }

    private class g extends l {
        g() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.l
        protected float a() {
            d dVar = d.this;
            return dVar.A + dVar.B;
        }
    }

    private class h extends l {
        h() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.l
        protected float a() {
            d dVar = d.this;
            return dVar.A + dVar.C;
        }
    }

    interface i {
        void a();

        void b();
    }

    interface j {
        void a();

        void b();
    }

    private class k extends l {
        k() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.l
        protected float a() {
            return d.this.A;
        }
    }

    private abstract class l extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        private boolean f7219a;

        /* renamed from: b */
        private float f7220b;

        /* renamed from: c */
        private float f7221c;

        private l() {
        }

        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.j0((int) this.f7221c);
            this.f7219a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            if (!this.f7219a) {
                com.google.android.material.j.j jVar = d.this.u;
                this.f7220b = jVar == null ? 0.0f : jVar.x();
                this.f7221c = a();
                this.f7219a = true;
            }
            d dVar = d.this;
            float f2 = this.f7220b;
            dVar.j0((int) (f2 + ((this.f7221c - f2) * valueAnimator.getAnimatedFraction())));
        }

        /* synthetic */ l(d dVar, a aVar) {
            this();
        }
    }

    d(FloatingActionButton floatingActionButton, com.google.android.material.i.c cVar) {
        this.R = floatingActionButton;
        this.S = cVar;
        com.google.android.material.internal.k kVar = new com.google.android.material.internal.k();
        this.E = kVar;
        kVar.a(n, i(new h()));
        kVar.a(o, i(new g()));
        kVar.a(p, i(new g()));
        kVar.a(q, i(new g()));
        kVar.a(r, i(new k()));
        kVar.a(s, i(new f()));
        this.K = floatingActionButton.getRotation();
    }

    private boolean d0() {
        return ViewCompat.isLaidOut(this.R) && !this.R.isInEditMode();
    }

    private void g(float f2, @NonNull Matrix matrix) {
        matrix.reset();
        if (this.R.getDrawable() == null || this.M == 0) {
            return;
        }
        RectF rectF = this.U;
        RectF rectF2 = this.V;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i2 = this.M;
        rectF2.set(0.0f, 0.0f, i2, i2);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i3 = this.M;
        matrix.postScale(f2, f2, i3 / 2.0f, i3 / 2.0f);
    }

    @NonNull
    private AnimatorSet h(@NonNull com.google.android.material.a.h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.R, (Property<FloatingActionButton, Float>) View.ALPHA, f2);
        hVar.h("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.R, (Property<FloatingActionButton, Float>) View.SCALE_X, f3);
        hVar.h("scale").a(ofFloat2);
        k0(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.R, (Property<FloatingActionButton, Float>) View.SCALE_Y, f3);
        hVar.h("scale").a(ofFloat3);
        k0(ofFloat3);
        arrayList.add(ofFloat3);
        g(f4, this.W);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.R, new com.google.android.material.a.f(), new c(), new Matrix(this.W));
        hVar.h("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    @NonNull
    private ValueAnimator i(@NonNull l lVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f7194a);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(lVar);
        valueAnimator.addUpdateListener(lVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    private void k0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new C0090d());
    }

    private com.google.android.material.a.h l() {
        if (this.G == null) {
            this.G = com.google.android.material.a.h.d(this.R.getContext(), com.google.android.material.R.animator.design_fab_hide_motion_spec);
        }
        return (com.google.android.material.a.h) Preconditions.checkNotNull(this.G);
    }

    private com.google.android.material.a.h m() {
        if (this.F == null) {
            this.F = com.google.android.material.a.h.d(this.R.getContext(), com.google.android.material.R.animator.design_fab_show_motion_spec);
        }
        return (com.google.android.material.a.h) Preconditions.checkNotNull(this.F);
    }

    @NonNull
    private ViewTreeObserver.OnPreDrawListener r() {
        if (this.X == null) {
            this.X = new e();
        }
        return this.X;
    }

    void A() {
        this.E.c();
    }

    void B() {
        com.google.android.material.j.j jVar = this.u;
        if (jVar != null) {
            com.google.android.material.j.k.f(this.R, jVar);
        }
        if (N()) {
            this.R.getViewTreeObserver().addOnPreDrawListener(r());
        }
    }

    void C() {
    }

    void D() {
        ViewTreeObserver viewTreeObserver = this.R.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.X;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.X = null;
        }
    }

    void E(int[] iArr) {
        this.E.d(iArr);
    }

    void F(float f2, float f3, float f4) {
        i0();
        j0(f2);
    }

    void G(@NonNull Rect rect) {
        Preconditions.checkNotNull(this.x, "Didn't initialize content background");
        if (!c0()) {
            this.S.setBackgroundDrawable(this.x);
        } else {
            this.S.setBackgroundDrawable(new InsetDrawable(this.x, rect.left, rect.top, rect.right, rect.bottom));
        }
    }

    void H() {
        float rotation = this.R.getRotation();
        if (this.K != rotation) {
            this.K = rotation;
            g0();
        }
    }

    void I() {
        ArrayList<i> arrayList = this.Q;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    void J() {
        ArrayList<i> arrayList = this.Q;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public void K(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.P;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    void L(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.O;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    void M(@NonNull i iVar) {
        ArrayList<i> arrayList = this.Q;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(iVar);
    }

    boolean N() {
        return true;
    }

    void O(@Nullable ColorStateList colorStateList) {
        com.google.android.material.j.j jVar = this.u;
        if (jVar != null) {
            jVar.setTintList(colorStateList);
        }
        com.google.android.material.floatingactionbutton.c cVar = this.w;
        if (cVar != null) {
            cVar.d(colorStateList);
        }
    }

    void P(@Nullable PorterDuff.Mode mode) {
        com.google.android.material.j.j jVar = this.u;
        if (jVar != null) {
            jVar.setTintMode(mode);
        }
    }

    final void Q(float f2) {
        if (this.A != f2) {
            this.A = f2;
            F(f2, this.B, this.C);
        }
    }

    void R(boolean z) {
        this.y = z;
    }

    final void S(@Nullable com.google.android.material.a.h hVar) {
        this.J = hVar;
    }

    final void T(float f2) {
        if (this.B != f2) {
            this.B = f2;
            F(this.A, f2, this.C);
        }
    }

    final void U(float f2) {
        this.L = f2;
        Matrix matrix = this.W;
        g(f2, matrix);
        this.R.setImageMatrix(matrix);
    }

    final void V(int i2) {
        if (this.M != i2) {
            this.M = i2;
            h0();
        }
    }

    void W(int i2) {
        this.D = i2;
    }

    final void X(float f2) {
        if (this.C != f2) {
            this.C = f2;
            F(this.A, this.B, f2);
        }
    }

    void Y(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.v;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, com.google.android.material.h.b.d(colorStateList));
        }
    }

    void Z(boolean z) {
        this.z = z;
        i0();
    }

    final void a0(@NonNull o oVar) {
        this.t = oVar;
        com.google.android.material.j.j jVar = this.u;
        if (jVar != null) {
            jVar.setShapeAppearanceModel(oVar);
        }
        Object obj = this.v;
        if (obj instanceof s) {
            ((s) obj).setShapeAppearanceModel(oVar);
        }
        com.google.android.material.floatingactionbutton.c cVar = this.w;
        if (cVar != null) {
            cVar.g(oVar);
        }
    }

    final void b0(@Nullable com.google.android.material.a.h hVar) {
        this.I = hVar;
    }

    boolean c0() {
        return true;
    }

    public void d(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.P == null) {
            this.P = new ArrayList<>();
        }
        this.P.add(animatorListener);
    }

    void e(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.O == null) {
            this.O = new ArrayList<>();
        }
        this.O.add(animatorListener);
    }

    final boolean e0() {
        return !this.y || this.R.getSizeDimension() >= this.D;
    }

    void f(@NonNull i iVar) {
        if (this.Q == null) {
            this.Q = new ArrayList<>();
        }
        this.Q.add(iVar);
    }

    void f0(@Nullable j jVar, boolean z) {
        if (z()) {
            return;
        }
        Animator animator = this.H;
        if (animator != null) {
            animator.cancel();
        }
        if (!d0()) {
            this.R.c(0, z);
            this.R.setAlpha(1.0f);
            this.R.setScaleY(1.0f);
            this.R.setScaleX(1.0f);
            U(1.0f);
            if (jVar != null) {
                jVar.a();
                return;
            }
            return;
        }
        if (this.R.getVisibility() != 0) {
            this.R.setAlpha(0.0f);
            this.R.setScaleY(0.0f);
            this.R.setScaleX(0.0f);
            U(0.0f);
        }
        com.google.android.material.a.h hVar = this.I;
        if (hVar == null) {
            hVar = m();
        }
        AnimatorSet h2 = h(hVar, 1.0f, 1.0f, 1.0f);
        h2.addListener(new b(z, jVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.O;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                h2.addListener(it.next());
            }
        }
        h2.start();
    }

    void g0() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.K % 90.0f != 0.0f) {
                if (this.R.getLayerType() != 1) {
                    this.R.setLayerType(1, null);
                }
            } else if (this.R.getLayerType() != 0) {
                this.R.setLayerType(0, null);
            }
        }
        com.google.android.material.j.j jVar = this.u;
        if (jVar != null) {
            jVar.v0((int) this.K);
        }
    }

    final void h0() {
        U(this.L);
    }

    final void i0() {
        Rect rect = this.T;
        s(rect);
        G(rect);
        this.S.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    com.google.android.material.j.j j() {
        return new com.google.android.material.j.j((o) Preconditions.checkNotNull(this.t));
    }

    void j0(float f2) {
        com.google.android.material.j.j jVar = this.u;
        if (jVar != null) {
            jVar.m0(f2);
        }
    }

    @Nullable
    final Drawable k() {
        return this.x;
    }

    float n() {
        return this.A;
    }

    boolean o() {
        return this.y;
    }

    @Nullable
    final com.google.android.material.a.h p() {
        return this.J;
    }

    float q() {
        return this.B;
    }

    void s(@NonNull Rect rect) {
        int sizeDimension = this.y ? (this.D - this.R.getSizeDimension()) / 2 : 0;
        int max = Math.max(sizeDimension, (int) Math.ceil(this.z ? n() + this.C : 0.0f));
        int max2 = Math.max(sizeDimension, (int) Math.ceil(r1 * f7200g));
        rect.set(max, max2, max, max2);
    }

    float t() {
        return this.C;
    }

    @Nullable
    final o u() {
        return this.t;
    }

    @Nullable
    final com.google.android.material.a.h v() {
        return this.I;
    }

    void w(@Nullable j jVar, boolean z) {
        if (y()) {
            return;
        }
        Animator animator = this.H;
        if (animator != null) {
            animator.cancel();
        }
        if (!d0()) {
            this.R.c(z ? 8 : 4, z);
            if (jVar != null) {
                jVar.b();
                return;
            }
            return;
        }
        com.google.android.material.a.h hVar = this.J;
        if (hVar == null) {
            hVar = l();
        }
        AnimatorSet h2 = h(hVar, 0.0f, 0.0f, 0.0f);
        h2.addListener(new a(z, jVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.P;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                h2.addListener(it.next());
            }
        }
        h2.start();
    }

    void x(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        com.google.android.material.j.j j2 = j();
        this.u = j2;
        j2.setTintList(colorStateList);
        if (mode != null) {
            this.u.setTintMode(mode);
        }
        this.u.u0(Color.DKGRAY);
        this.u.Y(this.R.getContext());
        com.google.android.material.h.a aVar = new com.google.android.material.h.a(this.u.getShapeAppearanceModel());
        aVar.setTintList(com.google.android.material.h.b.d(colorStateList2));
        this.v = aVar;
        this.x = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.u), aVar});
    }

    boolean y() {
        return this.R.getVisibility() == 0 ? this.N == 1 : this.N != 2;
    }

    boolean z() {
        return this.R.getVisibility() != 0 ? this.N == 2 : this.N != 1;
    }
}
