package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.g.a;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.vivo.advv.Color;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    private static final boolean f7315a;

    /* renamed from: b */
    private static final String f7316b = "CollapsingTextHelper";

    /* renamed from: c */
    private static final String f7317c = "…";

    /* renamed from: d */
    private static final boolean f7318d = false;

    /* renamed from: e */
    @NonNull
    private static final Paint f7319e;
    private com.google.android.material.g.a A;
    private com.google.android.material.g.a B;

    @Nullable
    private CharSequence C;

    @Nullable
    private CharSequence D;
    private boolean E;
    private boolean F;

    @Nullable
    private Bitmap G;
    private Paint H;
    private float I;
    private float J;
    private int[] K;
    private boolean L;

    @NonNull
    private final TextPaint M;

    @NonNull
    private final TextPaint N;
    private TimeInterpolator O;
    private TimeInterpolator P;
    private float Q;
    private float R;
    private float S;
    private ColorStateList T;
    private float U;
    private float V;
    private float W;
    private ColorStateList X;
    private StaticLayout Y;
    private float Z;
    private float a0;
    private float b0;
    private CharSequence c0;

    /* renamed from: f */
    private final View f7320f;

    /* renamed from: g */
    private boolean f7321g;

    /* renamed from: h */
    private float f7322h;

    /* renamed from: i */
    @NonNull
    private final Rect f7323i;

    /* renamed from: j */
    @NonNull
    private final Rect f7324j;

    @NonNull
    private final RectF k;
    private ColorStateList p;
    private ColorStateList q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    private Typeface x;
    private Typeface y;
    private Typeface z;
    private int l = 16;
    private int m = 16;
    private float n = 15.0f;
    private float o = 15.0f;
    private int d0 = 1;

    /* renamed from: com.google.android.material.internal.a$a */
    class C0093a implements a.InterfaceC0091a {
        C0093a() {
        }

        @Override // com.google.android.material.g.a.InterfaceC0091a
        public void a(Typeface typeface) {
            a.this.W(typeface);
        }
    }

    class b implements a.InterfaceC0091a {
        b() {
        }

        @Override // com.google.android.material.g.a.InterfaceC0091a
        public void a(Typeface typeface) {
            a.this.f0(typeface);
        }
    }

    static {
        f7315a = Build.VERSION.SDK_INT < 18;
        Paint paint = null;
        f7319e = null;
        if (0 != 0) {
            paint.setAntiAlias(true);
            paint.setColor(Color.MAGENTA);
        }
    }

    public a(View view) {
        this.f7320f = view;
        TextPaint textPaint = new TextPaint(129);
        this.M = textPaint;
        this.N = new TextPaint(textPaint);
        this.f7324j = new Rect();
        this.f7323i = new Rect();
        this.k = new RectF();
    }

    private void F(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.o);
        textPaint.setTypeface(this.x);
    }

    private void G(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.n);
        textPaint.setTypeface(this.y);
    }

    private void H(float f2) {
        this.k.left = L(this.f7323i.left, this.f7324j.left, f2, this.O);
        this.k.top = L(this.r, this.s, f2, this.O);
        this.k.right = L(this.f7323i.right, this.f7324j.right, f2, this.O);
        this.k.bottom = L(this.f7323i.bottom, this.f7324j.bottom, f2, this.O);
    }

    private static boolean I(float f2, float f3) {
        return Math.abs(f2 - f3) < 0.001f;
    }

    private boolean J() {
        return ViewCompat.getLayoutDirection(this.f7320f) == 1;
    }

    private static float L(float f2, float f3, float f4, @Nullable TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return com.google.android.material.a.a.a(f2, f3, f4);
    }

    private static boolean O(@NonNull Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }

    private void S(float f2) {
        this.Z = f2;
        ViewCompat.postInvalidateOnAnimation(this.f7320f);
    }

    private boolean X(Typeface typeface) {
        com.google.android.material.g.a aVar = this.B;
        if (aVar != null) {
            aVar.c();
        }
        if (this.x == typeface) {
            return false;
        }
        this.x = typeface;
        return true;
    }

    private static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return android.graphics.Color.argb((int) ((android.graphics.Color.alpha(i2) * f3) + (android.graphics.Color.alpha(i3) * f2)), (int) ((android.graphics.Color.red(i2) * f3) + (android.graphics.Color.red(i3) * f2)), (int) ((android.graphics.Color.green(i2) * f3) + (android.graphics.Color.green(i3) * f2)), (int) ((android.graphics.Color.blue(i2) * f3) + (android.graphics.Color.blue(i3) * f2)));
    }

    private void b() {
        StaticLayout staticLayout;
        float f2 = this.J;
        g(this.o);
        CharSequence charSequence = this.D;
        if (charSequence != null && (staticLayout = this.Y) != null) {
            this.c0 = TextUtils.ellipsize(charSequence, this.M, staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.c0;
        float measureText = charSequence2 != null ? this.M.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.m, this.E ? 1 : 0);
        int i2 = absoluteGravity & 112;
        if (i2 == 48) {
            this.s = this.f7324j.top;
        } else if (i2 != 80) {
            this.s = this.f7324j.centerY() - ((this.M.descent() - this.M.ascent()) / 2.0f);
        } else {
            this.s = this.f7324j.bottom + this.M.ascent();
        }
        int i3 = absoluteGravity & 8388615;
        if (i3 == 1) {
            this.u = this.f7324j.centerX() - (measureText / 2.0f);
        } else if (i3 != 5) {
            this.u = this.f7324j.left;
        } else {
            this.u = this.f7324j.right - measureText;
        }
        g(this.n);
        float height = this.Y != null ? r1.getHeight() : 0.0f;
        CharSequence charSequence3 = this.D;
        float measureText2 = charSequence3 != null ? this.M.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        StaticLayout staticLayout2 = this.Y;
        if (staticLayout2 != null && this.d0 > 1 && !this.E) {
            measureText2 = staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.Y;
        this.b0 = staticLayout3 != null ? staticLayout3.getLineLeft(0) : 0.0f;
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.l, this.E ? 1 : 0);
        int i4 = absoluteGravity2 & 112;
        if (i4 == 48) {
            this.r = this.f7323i.top;
        } else if (i4 != 80) {
            this.r = this.f7323i.centerY() - (height / 2.0f);
        } else {
            this.r = (this.f7323i.bottom - height) + this.M.descent();
        }
        int i5 = absoluteGravity2 & 8388615;
        if (i5 == 1) {
            this.t = this.f7323i.centerX() - (measureText2 / 2.0f);
        } else if (i5 != 5) {
            this.t = this.f7323i.left;
        } else {
            this.t = this.f7323i.right - measureText2;
        }
        h();
        i0(f2);
    }

    private void b0(float f2) {
        this.a0 = f2;
        ViewCompat.postInvalidateOnAnimation(this.f7320f);
    }

    private void d() {
        f(this.f7322h);
    }

    private boolean e(@NonNull CharSequence charSequence) {
        return (J() ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
    }

    private void f(float f2) {
        H(f2);
        this.v = L(this.t, this.u, f2, this.O);
        this.w = L(this.r, this.s, f2, this.O);
        i0(L(this.n, this.o, f2, this.P));
        TimeInterpolator timeInterpolator = com.google.android.material.a.a.f6608b;
        S(1.0f - L(0.0f, 1.0f, 1.0f - f2, timeInterpolator));
        b0(L(1.0f, 0.0f, f2, timeInterpolator));
        if (this.q != this.p) {
            this.M.setColor(a(w(), u(), f2));
        } else {
            this.M.setColor(u());
        }
        this.M.setShadowLayer(L(this.U, this.Q, f2, null), L(this.V, this.R, f2, null), L(this.W, this.S, f2, null), a(v(this.X), v(this.T), f2));
        ViewCompat.postInvalidateOnAnimation(this.f7320f);
    }

    private void g(float f2) {
        boolean z;
        float f3;
        boolean z2;
        if (this.C == null) {
            return;
        }
        float width = this.f7324j.width();
        float width2 = this.f7323i.width();
        if (I(f2, this.o)) {
            f3 = this.o;
            this.I = 1.0f;
            Typeface typeface = this.z;
            Typeface typeface2 = this.x;
            if (typeface != typeface2) {
                this.z = typeface2;
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            float f4 = this.n;
            Typeface typeface3 = this.z;
            Typeface typeface4 = this.y;
            if (typeface3 != typeface4) {
                this.z = typeface4;
                z = true;
            } else {
                z = false;
            }
            if (I(f2, f4)) {
                this.I = 1.0f;
            } else {
                this.I = f2 / this.n;
            }
            float f5 = this.o / this.n;
            width = width2 * f5 > width ? Math.min(width / f5, width2) : width2;
            f3 = f4;
            z2 = z;
        }
        if (width > 0.0f) {
            z2 = this.J != f3 || this.L || z2;
            this.J = f3;
            this.L = false;
        }
        if (this.D == null || z2) {
            this.M.setTextSize(this.J);
            this.M.setTypeface(this.z);
            this.M.setLinearText(this.I != 1.0f);
            this.E = e(this.C);
            StaticLayout i2 = i(p0() ? this.d0 : 1, width, this.E);
            this.Y = i2;
            this.D = i2.getText();
        }
    }

    private boolean g0(Typeface typeface) {
        com.google.android.material.g.a aVar = this.A;
        if (aVar != null) {
            aVar.c();
        }
        if (this.y == typeface) {
            return false;
        }
        this.y = typeface;
        return true;
    }

    private void h() {
        Bitmap bitmap = this.G;
        if (bitmap != null) {
            bitmap.recycle();
            this.G = null;
        }
    }

    private StaticLayout i(int i2, float f2, boolean z) {
        StaticLayout staticLayout;
        try {
            staticLayout = StaticLayoutBuilderCompat.c(this.C, this.M, (int) f2).e(TextUtils.TruncateAt.END).h(z).d(Layout.Alignment.ALIGN_NORMAL).g(false).i(i2).a();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e2) {
            Log.e(f7316b, e2.getCause().getMessage(), e2);
            staticLayout = null;
        }
        return (StaticLayout) Preconditions.checkNotNull(staticLayout);
    }

    private void i0(float f2) {
        g(f2);
        boolean z = f7315a && this.I != 1.0f;
        this.F = z;
        if (z) {
            l();
        }
        ViewCompat.postInvalidateOnAnimation(this.f7320f);
    }

    private void k(@NonNull Canvas canvas, float f2, float f3) {
        int alpha = this.M.getAlpha();
        canvas.translate(f2, f3);
        float f4 = alpha;
        this.M.setAlpha((int) (this.a0 * f4));
        this.Y.draw(canvas);
        this.M.setAlpha((int) (this.Z * f4));
        int lineBaseline = this.Y.getLineBaseline(0);
        CharSequence charSequence = this.c0;
        float f5 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f5, this.M);
        String trim = this.c0.toString().trim();
        if (trim.endsWith(f7317c)) {
            trim = trim.substring(0, trim.length() - 1);
        }
        String str = trim;
        this.M.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.Y.getLineEnd(0), str.length()), 0.0f, f5, (Paint) this.M);
    }

    private void l() {
        if (this.G != null || this.f7323i.isEmpty() || TextUtils.isEmpty(this.D)) {
            return;
        }
        f(0.0f);
        int width = this.Y.getWidth();
        int height = this.Y.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.G = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.Y.draw(new Canvas(this.G));
        if (this.H == null) {
            this.H = new Paint(3);
        }
    }

    private boolean p0() {
        return (this.d0 <= 1 || this.E || this.F) ? false : true;
    }

    private float q(int i2, int i3) {
        return (i3 == 17 || (i3 & 7) == 1) ? (i2 / 2.0f) - (c() / 2.0f) : ((i3 & 8388613) == 8388613 || (i3 & 5) == 5) ? this.E ? this.f7324j.left : this.f7324j.right - c() : this.E ? this.f7324j.right - c() : this.f7324j.left;
    }

    private float r(@NonNull RectF rectF, int i2, int i3) {
        return (i3 == 17 || (i3 & 7) == 1) ? (i2 / 2.0f) + (c() / 2.0f) : ((i3 & 8388613) == 8388613 || (i3 & 5) == 5) ? this.E ? rectF.left + c() : this.f7324j.right : this.E ? this.f7324j.right : rectF.left + c();
    }

    @ColorInt
    private int v(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.K;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    @ColorInt
    private int w() {
        return v(this.p);
    }

    public float A() {
        return this.n;
    }

    public Typeface B() {
        Typeface typeface = this.y;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public float C() {
        return this.f7322h;
    }

    public int D() {
        return this.d0;
    }

    @Nullable
    public CharSequence E() {
        return this.C;
    }

    public final boolean K() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.q;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.p) != null && colorStateList.isStateful());
    }

    void M() {
        this.f7321g = this.f7324j.width() > 0 && this.f7324j.height() > 0 && this.f7323i.width() > 0 && this.f7323i.height() > 0;
    }

    public void N() {
        if (this.f7320f.getHeight() <= 0 || this.f7320f.getWidth() <= 0) {
            return;
        }
        b();
        d();
    }

    public void P(int i2, int i3, int i4, int i5) {
        if (O(this.f7324j, i2, i3, i4, i5)) {
            return;
        }
        this.f7324j.set(i2, i3, i4, i5);
        this.L = true;
        M();
    }

    public void Q(@NonNull Rect rect) {
        P(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void R(int i2) {
        com.google.android.material.g.d dVar = new com.google.android.material.g.d(this.f7320f.getContext(), i2);
        ColorStateList colorStateList = dVar.f7231f;
        if (colorStateList != null) {
            this.q = colorStateList;
        }
        float f2 = dVar.f7230e;
        if (f2 != 0.0f) {
            this.o = f2;
        }
        ColorStateList colorStateList2 = dVar.m;
        if (colorStateList2 != null) {
            this.T = colorStateList2;
        }
        this.R = dVar.n;
        this.S = dVar.o;
        this.Q = dVar.p;
        com.google.android.material.g.a aVar = this.B;
        if (aVar != null) {
            aVar.c();
        }
        this.B = new com.google.android.material.g.a(new C0093a(), dVar.e());
        dVar.h(this.f7320f.getContext(), this.B);
        N();
    }

    public void T(ColorStateList colorStateList) {
        if (this.q != colorStateList) {
            this.q = colorStateList;
            N();
        }
    }

    public void U(int i2) {
        if (this.m != i2) {
            this.m = i2;
            N();
        }
    }

    public void V(float f2) {
        if (this.o != f2) {
            this.o = f2;
            N();
        }
    }

    public void W(Typeface typeface) {
        if (X(typeface)) {
            N();
        }
    }

    public void Y(int i2, int i3, int i4, int i5) {
        if (O(this.f7323i, i2, i3, i4, i5)) {
            return;
        }
        this.f7323i.set(i2, i3, i4, i5);
        this.L = true;
        M();
    }

    public void Z(@NonNull Rect rect) {
        Y(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void a0(int i2) {
        com.google.android.material.g.d dVar = new com.google.android.material.g.d(this.f7320f.getContext(), i2);
        ColorStateList colorStateList = dVar.f7231f;
        if (colorStateList != null) {
            this.p = colorStateList;
        }
        float f2 = dVar.f7230e;
        if (f2 != 0.0f) {
            this.n = f2;
        }
        ColorStateList colorStateList2 = dVar.m;
        if (colorStateList2 != null) {
            this.X = colorStateList2;
        }
        this.V = dVar.n;
        this.W = dVar.o;
        this.U = dVar.p;
        com.google.android.material.g.a aVar = this.A;
        if (aVar != null) {
            aVar.c();
        }
        this.A = new com.google.android.material.g.a(new b(), dVar.e());
        dVar.h(this.f7320f.getContext(), this.A);
        N();
    }

    public float c() {
        if (this.C == null) {
            return 0.0f;
        }
        F(this.N);
        TextPaint textPaint = this.N;
        CharSequence charSequence = this.C;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void c0(ColorStateList colorStateList) {
        if (this.p != colorStateList) {
            this.p = colorStateList;
            N();
        }
    }

    public void d0(int i2) {
        if (this.l != i2) {
            this.l = i2;
            N();
        }
    }

    public void e0(float f2) {
        if (this.n != f2) {
            this.n = f2;
            N();
        }
    }

    public void f0(Typeface typeface) {
        if (g0(typeface)) {
            N();
        }
    }

    public void h0(float f2) {
        float clamp = MathUtils.clamp(f2, 0.0f, 1.0f);
        if (clamp != this.f7322h) {
            this.f7322h = clamp;
            d();
        }
    }

    public void j(@NonNull Canvas canvas) {
        int save = canvas.save();
        if (this.D == null || !this.f7321g) {
            return;
        }
        boolean z = false;
        float lineLeft = (this.v + this.Y.getLineLeft(0)) - (this.b0 * 2.0f);
        this.M.setTextSize(this.J);
        float f2 = this.v;
        float f3 = this.w;
        if (this.F && this.G != null) {
            z = true;
        }
        float f4 = this.I;
        if (f4 != 1.0f) {
            canvas.scale(f4, f4, f2, f3);
        }
        if (z) {
            canvas.drawBitmap(this.G, f2, f3, this.H);
            canvas.restoreToCount(save);
            return;
        }
        if (p0()) {
            k(canvas, lineLeft, f3);
        } else {
            canvas.translate(f2, f3);
            this.Y.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    public void j0(int i2) {
        if (i2 != this.d0) {
            this.d0 = i2;
            h();
            N();
        }
    }

    public void k0(TimeInterpolator timeInterpolator) {
        this.O = timeInterpolator;
        N();
    }

    public final boolean l0(int[] iArr) {
        this.K = iArr;
        if (!K()) {
            return false;
        }
        N();
        return true;
    }

    public void m(@NonNull RectF rectF, int i2, int i3) {
        this.E = e(this.C);
        rectF.left = q(i2, i3);
        rectF.top = this.f7324j.top;
        rectF.right = r(rectF, i2, i3);
        rectF.bottom = this.f7324j.top + p();
    }

    public void m0(@Nullable CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.C, charSequence)) {
            this.C = charSequence;
            this.D = null;
            h();
            N();
        }
    }

    public ColorStateList n() {
        return this.q;
    }

    public void n0(TimeInterpolator timeInterpolator) {
        this.P = timeInterpolator;
        N();
    }

    public int o() {
        return this.m;
    }

    public void o0(Typeface typeface) {
        boolean X = X(typeface);
        boolean g0 = g0(typeface);
        if (X || g0) {
            N();
        }
    }

    public float p() {
        F(this.N);
        return -this.N.ascent();
    }

    public float s() {
        return this.o;
    }

    public Typeface t() {
        Typeface typeface = this.x;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    @ColorInt
    public int u() {
        return v(this.q);
    }

    public ColorStateList x() {
        return this.p;
    }

    public int y() {
        return this.l;
    }

    public float z() {
        G(this.N);
        return -this.N.ascent();
    }
}
