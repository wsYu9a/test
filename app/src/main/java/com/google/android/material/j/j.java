package com.google.android.material.j;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import com.google.android.material.R;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.j.o;
import com.google.android.material.j.p;
import com.google.android.material.j.q;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;

/* loaded from: classes.dex */
public class j extends Drawable implements TintAwareDrawable, s {

    /* renamed from: b */
    private static final float f7413b = 0.75f;

    /* renamed from: c */
    private static final float f7414c = 0.25f;

    /* renamed from: d */
    public static final int f7415d = 0;

    /* renamed from: e */
    public static final int f7416e = 1;

    /* renamed from: f */
    public static final int f7417f = 2;

    @Nullable
    private PorterDuffColorFilter A;

    @NonNull
    private final RectF B;
    private boolean C;

    /* renamed from: h */
    private d f7419h;

    /* renamed from: i */
    private final q.i[] f7420i;

    /* renamed from: j */
    private final q.i[] f7421j;
    private final BitSet k;
    private boolean l;
    private final Matrix m;
    private final Path n;
    private final Path o;
    private final RectF p;
    private final RectF q;
    private final Region r;
    private final Region s;
    private o t;
    private final Paint u;
    private final Paint v;
    private final com.google.android.material.i.b w;

    @NonNull
    private final p.a x;
    private final p y;

    @Nullable
    private PorterDuffColorFilter z;

    /* renamed from: a */
    private static final String f7412a = j.class.getSimpleName();

    /* renamed from: g */
    private static final Paint f7418g = new Paint(1);

    class a implements p.a {
        a() {
        }

        @Override // com.google.android.material.j.p.a
        public void a(@NonNull q qVar, Matrix matrix, int i2) {
            j.this.k.set(i2, qVar.e());
            j.this.f7420i[i2] = qVar.f(matrix);
        }

        @Override // com.google.android.material.j.p.a
        public void b(@NonNull q qVar, Matrix matrix, int i2) {
            j.this.k.set(i2 + 4, qVar.e());
            j.this.f7421j[i2] = qVar.f(matrix);
        }
    }

    class b implements o.c {

        /* renamed from: a */
        final /* synthetic */ float f7423a;

        b(float f2) {
            this.f7423a = f2;
        }

        @Override // com.google.android.material.j.o.c
        @NonNull
        public com.google.android.material.j.d a(@NonNull com.google.android.material.j.d dVar) {
            return dVar instanceof m ? dVar : new com.google.android.material.j.b(this.f7423a, dVar);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    /* synthetic */ j(d dVar, a aVar) {
        this(dVar);
    }

    private boolean L0(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f7419h.f7428d == null || color2 == (colorForState2 = this.f7419h.f7428d.getColorForState(iArr, (color2 = this.u.getColor())))) {
            z = false;
        } else {
            this.u.setColor(colorForState2);
            z = true;
        }
        if (this.f7419h.f7429e == null || color == (colorForState = this.f7419h.f7429e.getColorForState(iArr, (color = this.v.getColor())))) {
            return z;
        }
        this.v.setColor(colorForState);
        return true;
    }

    private boolean M0() {
        PorterDuffColorFilter porterDuffColorFilter = this.z;
        PorterDuffColorFilter porterDuffColorFilter2 = this.A;
        d dVar = this.f7419h;
        this.z = k(dVar.f7431g, dVar.f7432h, this.u, true);
        d dVar2 = this.f7419h;
        this.A = k(dVar2.f7430f, dVar2.f7432h, this.v, false);
        d dVar3 = this.f7419h;
        if (dVar3.u) {
            this.w.d(dVar3.f7431g.getColorForState(getState(), 0));
        }
        return (ObjectsCompat.equals(porterDuffColorFilter, this.z) && ObjectsCompat.equals(porterDuffColorFilter2, this.A)) ? false : true;
    }

    private float N() {
        if (X()) {
            return this.v.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private void N0() {
        float U = U();
        this.f7419h.r = (int) Math.ceil(0.75f * U);
        this.f7419h.s = (int) Math.ceil(U * f7414c);
        M0();
        Z();
    }

    private boolean V() {
        d dVar = this.f7419h;
        int i2 = dVar.q;
        return i2 != 1 && dVar.r > 0 && (i2 == 2 || i0());
    }

    private boolean W() {
        Paint.Style style = this.f7419h.v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean X() {
        Paint.Style style = this.f7419h.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.v.getStrokeWidth() > 0.0f;
    }

    private void Z() {
        super.invalidateSelf();
    }

    @Nullable
    private PorterDuffColorFilter f(@NonNull Paint paint, boolean z) {
        int color;
        int l;
        if (!z || (l = l((color = paint.getColor()))) == color) {
            return null;
        }
        return new PorterDuffColorFilter(l, PorterDuff.Mode.SRC_IN);
    }

    private void f0(@NonNull Canvas canvas) {
        if (V()) {
            canvas.save();
            h0(canvas);
            if (!this.C) {
                o(canvas);
                canvas.restore();
                return;
            }
            int width = (int) (this.B.width() - getBounds().width());
            int height = (int) (this.B.height() - getBounds().height());
            if (width < 0 || height < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap createBitmap = Bitmap.createBitmap(((int) this.B.width()) + (this.f7419h.r * 2) + width, ((int) this.B.height()) + (this.f7419h.r * 2) + height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            float f2 = (getBounds().left - this.f7419h.r) - width;
            float f3 = (getBounds().top - this.f7419h.r) - height;
            canvas2.translate(-f2, -f3);
            o(canvas2);
            canvas.drawBitmap(createBitmap, f2, f3, (Paint) null);
            createBitmap.recycle();
            canvas.restore();
        }
    }

    private void g(@NonNull RectF rectF, @NonNull Path path) {
        h(rectF, path);
        if (this.f7419h.f7434j != 1.0f) {
            this.m.reset();
            Matrix matrix = this.m;
            float f2 = this.f7419h.f7434j;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.m);
        }
        path.computeBounds(this.B, true);
    }

    private static int g0(int i2, int i3) {
        return (i2 * (i3 + (i3 >>> 7))) >>> 8;
    }

    private void h0(@NonNull Canvas canvas) {
        int H = H();
        int I = I();
        if (Build.VERSION.SDK_INT < 21 && this.C) {
            Rect clipBounds = canvas.getClipBounds();
            int i2 = this.f7419h.r;
            clipBounds.inset(-i2, -i2);
            clipBounds.offset(H, I);
            canvas.clipRect(clipBounds, Region.Op.REPLACE);
        }
        canvas.translate(H, I);
    }

    private void i() {
        o y = getShapeAppearanceModel().y(new b(-N()));
        this.t = y;
        this.y.d(y, this.f7419h.k, w(), this.o);
    }

    @NonNull
    private PorterDuffColorFilter j(@NonNull ColorStateList colorStateList, @NonNull PorterDuff.Mode mode, boolean z) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = l(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    @NonNull
    private PorterDuffColorFilter k(@Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, @NonNull Paint paint, boolean z) {
        return (colorStateList == null || mode == null) ? f(paint, z) : j(colorStateList, mode, z);
    }

    @ColorInt
    private int l(@ColorInt int i2) {
        float U = U() + B();
        ElevationOverlayProvider elevationOverlayProvider = this.f7419h.f7426b;
        return elevationOverlayProvider != null ? elevationOverlayProvider.e(i2, U) : i2;
    }

    @NonNull
    public static j m(Context context) {
        return n(context, 0.0f);
    }

    @NonNull
    public static j n(Context context, float f2) {
        int c2 = com.google.android.material.c.a.c(context, R.attr.colorSurface, j.class.getSimpleName());
        j jVar = new j();
        jVar.Y(context);
        jVar.n0(ColorStateList.valueOf(c2));
        jVar.m0(f2);
        return jVar;
    }

    private void o(@NonNull Canvas canvas) {
        if (this.k.cardinality() > 0) {
            Log.w(f7412a, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f7419h.s != 0) {
            canvas.drawPath(this.n, this.w.c());
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this.f7420i[i2].b(this.w, this.f7419h.r, canvas);
            this.f7421j[i2].b(this.w, this.f7419h.r, canvas);
        }
        if (this.C) {
            int H = H();
            int I = I();
            canvas.translate(-H, -I);
            canvas.drawPath(this.n, f7418g);
            canvas.translate(H, I);
        }
    }

    private void p(@NonNull Canvas canvas) {
        r(canvas, this.u, this.n, this.f7419h.f7425a, v());
    }

    private void r(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull o oVar, @NonNull RectF rectF) {
        if (!oVar.u(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float a2 = oVar.t().a(rectF) * this.f7419h.k;
            canvas.drawRoundRect(rectF, a2, a2, paint);
        }
    }

    private void s(@NonNull Canvas canvas) {
        r(canvas, this.v, this.o, this.t, w());
    }

    @NonNull
    private RectF w() {
        this.q.set(v());
        float N = N();
        this.q.inset(N, N);
        return this.q;
    }

    public Paint.Style A() {
        return this.f7419h.v;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void A0(int i2) {
        d dVar = this.f7419h;
        if (dVar.s != i2) {
            dVar.s = i2;
            Z();
        }
    }

    public float B() {
        return this.f7419h.n;
    }

    @Deprecated
    public void B0(@NonNull r rVar) {
        setShapeAppearanceModel(rVar);
    }

    @Deprecated
    public void C(int i2, int i3, @NonNull Path path) {
        h(new RectF(0.0f, 0.0f, i2, i3), path);
    }

    public void C0(float f2, @ColorInt int i2) {
        H0(f2);
        E0(ColorStateList.valueOf(i2));
    }

    public float D() {
        return this.f7419h.f7434j;
    }

    public void D0(float f2, @Nullable ColorStateList colorStateList) {
        H0(f2);
        E0(colorStateList);
    }

    public int E() {
        return this.f7419h.t;
    }

    public void E0(@Nullable ColorStateList colorStateList) {
        d dVar = this.f7419h;
        if (dVar.f7429e != colorStateList) {
            dVar.f7429e = colorStateList;
            onStateChange(getState());
        }
    }

    public int F() {
        return this.f7419h.q;
    }

    public void F0(@ColorInt int i2) {
        G0(ColorStateList.valueOf(i2));
    }

    @Deprecated
    public int G() {
        return (int) x();
    }

    public void G0(ColorStateList colorStateList) {
        this.f7419h.f7430f = colorStateList;
        M0();
        Z();
    }

    public int H() {
        double d2 = this.f7419h.s;
        double sin = Math.sin(Math.toRadians(r0.t));
        Double.isNaN(d2);
        return (int) (d2 * sin);
    }

    public void H0(float f2) {
        this.f7419h.l = f2;
        invalidateSelf();
    }

    public int I() {
        double d2 = this.f7419h.s;
        double cos = Math.cos(Math.toRadians(r0.t));
        Double.isNaN(d2);
        return (int) (d2 * cos);
    }

    public void I0(float f2) {
        d dVar = this.f7419h;
        if (dVar.p != f2) {
            dVar.p = f2;
            N0();
        }
    }

    public int J() {
        return this.f7419h.r;
    }

    public void J0(boolean z) {
        d dVar = this.f7419h;
        if (dVar.u != z) {
            dVar.u = z;
            invalidateSelf();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int K() {
        return this.f7419h.s;
    }

    public void K0(float f2) {
        I0(f2 - x());
    }

    @Nullable
    @Deprecated
    public r L() {
        o shapeAppearanceModel = getShapeAppearanceModel();
        if (shapeAppearanceModel instanceof r) {
            return (r) shapeAppearanceModel;
        }
        return null;
    }

    @Nullable
    public ColorStateList M() {
        return this.f7419h.f7429e;
    }

    @Nullable
    public ColorStateList O() {
        return this.f7419h.f7430f;
    }

    public float P() {
        return this.f7419h.l;
    }

    @Nullable
    public ColorStateList Q() {
        return this.f7419h.f7431g;
    }

    public float R() {
        return this.f7419h.f7425a.r().a(v());
    }

    public float S() {
        return this.f7419h.f7425a.t().a(v());
    }

    public float T() {
        return this.f7419h.p;
    }

    public float U() {
        return x() + T();
    }

    public void Y(Context context) {
        this.f7419h.f7426b = new ElevationOverlayProvider(context);
        N0();
    }

    public boolean a0() {
        ElevationOverlayProvider elevationOverlayProvider = this.f7419h.f7426b;
        return elevationOverlayProvider != null && elevationOverlayProvider.l();
    }

    public boolean b0() {
        return this.f7419h.f7426b != null;
    }

    public boolean c0(int i2, int i3) {
        return getTransparentRegion().contains(i2, i3);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean d0() {
        return this.f7419h.f7425a.u(v());
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.u.setColorFilter(this.z);
        int alpha = this.u.getAlpha();
        this.u.setAlpha(g0(alpha, this.f7419h.m));
        this.v.setColorFilter(this.A);
        this.v.setStrokeWidth(this.f7419h.l);
        int alpha2 = this.v.getAlpha();
        this.v.setAlpha(g0(alpha2, this.f7419h.m));
        if (this.l) {
            i();
            g(v(), this.n);
            this.l = false;
        }
        f0(canvas);
        if (W()) {
            p(canvas);
        }
        if (X()) {
            s(canvas);
        }
        this.u.setAlpha(alpha);
        this.v.setAlpha(alpha2);
    }

    @Deprecated
    public boolean e0() {
        int i2 = this.f7419h.q;
        return i2 == 0 || i2 == 2;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f7419h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.f7419h.q == 2) {
            return;
        }
        if (d0()) {
            outline.setRoundRect(getBounds(), R() * this.f7419h.k);
            return;
        }
        g(v(), this.n);
        if (this.n.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.n);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        Rect rect2 = this.f7419h.f7433i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // com.google.android.material.j.s
    @NonNull
    public o getShapeAppearanceModel() {
        return this.f7419h.f7425a;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.r.set(getBounds());
        g(v(), this.n);
        this.s.setPath(this.n, this.r);
        this.r.op(this.s, Region.Op.DIFFERENCE);
        return this.r;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected final void h(@NonNull RectF rectF, @NonNull Path path) {
        p pVar = this.y;
        d dVar = this.f7419h;
        pVar.e(dVar.f7425a, dVar.k, rectF, this.x, path);
    }

    public boolean i0() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 < 21 || !(d0() || this.n.isConvex() || i2 >= 29);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.l = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f7419h.f7431g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f7419h.f7430f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f7419h.f7429e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f7419h.f7428d) != null && colorStateList4.isStateful())));
    }

    public void j0(float f2) {
        setShapeAppearanceModel(this.f7419h.f7425a.w(f2));
    }

    public void k0(@NonNull com.google.android.material.j.d dVar) {
        setShapeAppearanceModel(this.f7419h.f7425a.x(dVar));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void l0(boolean z) {
        this.y.m(z);
    }

    public void m0(float f2) {
        d dVar = this.f7419h;
        if (dVar.o != f2) {
            dVar.o = f2;
            N0();
        }
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.f7419h = new d(this.f7419h);
        return this;
    }

    public void n0(@Nullable ColorStateList colorStateList) {
        d dVar = this.f7419h;
        if (dVar.f7428d != colorStateList) {
            dVar.f7428d = colorStateList;
            onStateChange(getState());
        }
    }

    public void o0(float f2) {
        d dVar = this.f7419h;
        if (dVar.k != f2) {
            dVar.k = f2;
            this.l = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.l = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.l.b
    protected boolean onStateChange(int[] iArr) {
        boolean z = L0(iArr) || M0();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public void p0(int i2, int i3, int i4, int i5) {
        d dVar = this.f7419h;
        if (dVar.f7433i == null) {
            dVar.f7433i = new Rect();
        }
        this.f7419h.f7433i.set(i2, i3, i4, i5);
        invalidateSelf();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void q(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull RectF rectF) {
        r(canvas, paint, path, this.f7419h.f7425a, rectF);
    }

    public void q0(Paint.Style style) {
        this.f7419h.v = style;
        Z();
    }

    public void r0(float f2) {
        d dVar = this.f7419h;
        if (dVar.n != f2) {
            dVar.n = f2;
            N0();
        }
    }

    public void s0(float f2) {
        d dVar = this.f7419h;
        if (dVar.f7434j != f2) {
            dVar.f7434j = f2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        d dVar = this.f7419h;
        if (dVar.m != i2) {
            dVar.m = i2;
            Z();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f7419h.f7427c = colorFilter;
        Z();
    }

    @Override // com.google.android.material.j.s
    public void setShapeAppearanceModel(@NonNull o oVar) {
        this.f7419h.f7425a = oVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.f7419h.f7431g = colorStateList;
        M0();
        Z();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        d dVar = this.f7419h;
        if (dVar.f7432h != mode) {
            dVar.f7432h = mode;
            M0();
            Z();
        }
    }

    public float t() {
        return this.f7419h.f7425a.j().a(v());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void t0(boolean z) {
        this.C = z;
    }

    public float u() {
        return this.f7419h.f7425a.l().a(v());
    }

    public void u0(int i2) {
        this.w.d(i2);
        this.f7419h.u = false;
        Z();
    }

    @NonNull
    protected RectF v() {
        this.p.set(getBounds());
        return this.p;
    }

    public void v0(int i2) {
        d dVar = this.f7419h;
        if (dVar.t != i2) {
            dVar.t = i2;
            Z();
        }
    }

    public void w0(int i2) {
        d dVar = this.f7419h;
        if (dVar.q != i2) {
            dVar.q = i2;
            Z();
        }
    }

    public float x() {
        return this.f7419h.o;
    }

    @Deprecated
    public void x0(int i2) {
        m0(i2);
    }

    @Nullable
    public ColorStateList y() {
        return this.f7419h.f7428d;
    }

    @Deprecated
    public void y0(boolean z) {
        w0(!z ? 1 : 0);
    }

    public float z() {
        return this.f7419h.k;
    }

    @Deprecated
    public void z0(int i2) {
        this.f7419h.r = i2;
    }

    public j() {
        this(new o());
    }

    public j(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        this(o.e(context, attributeSet, i2, i3).m());
    }

    @Deprecated
    public j(@NonNull r rVar) {
        this((o) rVar);
    }

    public j(@NonNull o oVar) {
        this(new d(oVar, null));
    }

    private j(@NonNull d dVar) {
        this.f7420i = new q.i[4];
        this.f7421j = new q.i[4];
        this.k = new BitSet(8);
        this.m = new Matrix();
        this.n = new Path();
        this.o = new Path();
        this.p = new RectF();
        this.q = new RectF();
        this.r = new Region();
        this.s = new Region();
        Paint paint = new Paint(1);
        this.u = paint;
        Paint paint2 = new Paint(1);
        this.v = paint2;
        this.w = new com.google.android.material.i.b();
        this.y = new p();
        this.B = new RectF();
        this.C = true;
        this.f7419h = dVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = f7418g;
        paint3.setColor(-1);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        M0();
        L0(getState());
        this.x = new a();
    }

    static final class d extends Drawable.ConstantState {

        /* renamed from: a */
        @NonNull
        public o f7425a;

        /* renamed from: b */
        @Nullable
        public ElevationOverlayProvider f7426b;

        /* renamed from: c */
        @Nullable
        public ColorFilter f7427c;

        /* renamed from: d */
        @Nullable
        public ColorStateList f7428d;

        /* renamed from: e */
        @Nullable
        public ColorStateList f7429e;

        /* renamed from: f */
        @Nullable
        public ColorStateList f7430f;

        /* renamed from: g */
        @Nullable
        public ColorStateList f7431g;

        /* renamed from: h */
        @Nullable
        public PorterDuff.Mode f7432h;

        /* renamed from: i */
        @Nullable
        public Rect f7433i;

        /* renamed from: j */
        public float f7434j;
        public float k;
        public float l;
        public int m;
        public float n;
        public float o;
        public float p;
        public int q;
        public int r;
        public int s;
        public int t;
        public boolean u;
        public Paint.Style v;

        public d(o oVar, ElevationOverlayProvider elevationOverlayProvider) {
            this.f7428d = null;
            this.f7429e = null;
            this.f7430f = null;
            this.f7431g = null;
            this.f7432h = PorterDuff.Mode.SRC_IN;
            this.f7433i = null;
            this.f7434j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.f7425a = oVar;
            this.f7426b = elevationOverlayProvider;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            j jVar = new j(this, null);
            jVar.l = true;
            return jVar;
        }

        public d(@NonNull d dVar) {
            this.f7428d = null;
            this.f7429e = null;
            this.f7430f = null;
            this.f7431g = null;
            this.f7432h = PorterDuff.Mode.SRC_IN;
            this.f7433i = null;
            this.f7434j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.f7425a = dVar.f7425a;
            this.f7426b = dVar.f7426b;
            this.l = dVar.l;
            this.f7427c = dVar.f7427c;
            this.f7428d = dVar.f7428d;
            this.f7429e = dVar.f7429e;
            this.f7432h = dVar.f7432h;
            this.f7431g = dVar.f7431g;
            this.m = dVar.m;
            this.f7434j = dVar.f7434j;
            this.s = dVar.s;
            this.q = dVar.q;
            this.u = dVar.u;
            this.k = dVar.k;
            this.n = dVar.n;
            this.o = dVar.o;
            this.p = dVar.p;
            this.r = dVar.r;
            this.t = dVar.t;
            this.f7430f = dVar.f7430f;
            this.v = dVar.v;
            if (dVar.f7433i != null) {
                this.f7433i = new Rect(dVar.f7433i);
            }
        }
    }
}
