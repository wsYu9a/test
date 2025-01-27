package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.AttrRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.XmlRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.text.BidiFormatter;
import com.google.android.material.a.h;
import com.google.android.material.g.c;
import com.google.android.material.g.d;
import com.google.android.material.h.b;
import com.google.android.material.internal.l;
import com.google.android.material.internal.n;
import com.google.android.material.j.j;
import com.vivo.advv.Color;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes.dex */
public class a extends j implements TintAwareDrawable, Drawable.Callback, l.b {
    private static final boolean D = false;
    private static final String F = "http://schemas.android.com/apk/res-auto";

    @ColorInt
    private int A0;

    @ColorInt
    private int B0;
    private boolean C0;

    @ColorInt
    private int D0;
    private int F0;

    @Nullable
    private ColorFilter G0;

    @Nullable
    private ColorStateList H;

    @Nullable
    private PorterDuffColorFilter H0;

    @Nullable
    private ColorStateList I;

    @Nullable
    private ColorStateList I0;
    private float J;

    @Nullable
    private PorterDuff.Mode J0;
    private float K;
    private int[] K0;

    @Nullable
    private ColorStateList L;
    private boolean L0;
    private float M;

    @Nullable
    private ColorStateList M0;

    @Nullable
    private ColorStateList N;

    @NonNull
    private WeakReference<InterfaceC0085a> N0;

    @Nullable
    private CharSequence O;
    private TextUtils.TruncateAt O0;
    private boolean P;
    private boolean P0;

    @Nullable
    private Drawable Q;
    private int Q0;

    @Nullable
    private ColorStateList R;
    private boolean R0;
    private float S;
    private boolean T;
    private boolean U;

    @Nullable
    private Drawable V;

    @Nullable
    private Drawable W;

    @Nullable
    private ColorStateList X;
    private float Y;

    @Nullable
    private CharSequence Z;
    private boolean a0;
    private boolean b0;

    @Nullable
    private Drawable c0;

    @Nullable
    private ColorStateList d0;

    @Nullable
    private h e0;

    @Nullable
    private h f0;
    private float g0;
    private float h0;
    private float i0;
    private float j0;
    private float k0;
    private float l0;
    private float m0;
    private float n0;

    @NonNull
    private final Context o0;
    private final Paint p0;

    @Nullable
    private final Paint q0;
    private final Paint.FontMetrics r0;
    private final RectF s0;
    private final PointF t0;
    private final Path u0;

    @NonNull
    private final l v0;

    @ColorInt
    private int w0;

    @ColorInt
    private int x0;

    @ColorInt
    private int y0;

    @ColorInt
    private int z0;
    private static final int[] E = {R.attr.state_enabled};
    private static final ShapeDrawable G = new ShapeDrawable(new OvalShape());

    /* renamed from: com.google.android.material.chip.a$a */
    public interface InterfaceC0085a {
        void a();
    }

    private a(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(context, attributeSet, i2, i3);
        this.K = -1.0f;
        this.p0 = new Paint(1);
        this.r0 = new Paint.FontMetrics();
        this.s0 = new RectF();
        this.t0 = new PointF();
        this.u0 = new Path();
        this.F0 = 255;
        this.J0 = PorterDuff.Mode.SRC_IN;
        this.N0 = new WeakReference<>(null);
        Y(context);
        this.o0 = context;
        l lVar = new l(this);
        this.v0 = lVar;
        this.O = "";
        lVar.e().density = context.getResources().getDisplayMetrics().density;
        this.q0 = null;
        int[] iArr = E;
        setState(iArr);
        c3(iArr);
        this.P0 = true;
        if (b.f7245a) {
            G.setTint(-1);
        }
    }

    private boolean F3() {
        return this.b0 && this.c0 != null && this.C0;
    }

    private boolean G3() {
        return this.P && this.Q != null;
    }

    private boolean H3() {
        return this.U && this.V != null;
    }

    private void I3(@Nullable Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void J3() {
        this.M0 = this.L0 ? b.d(this.N) : null;
    }

    @TargetApi(21)
    private void K3() {
        this.W = new RippleDrawable(b.d(K1()), this.V, G);
    }

    private void O0(@Nullable Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.V) {
            if (drawable.isStateful()) {
                drawable.setState(C1());
            }
            DrawableCompat.setTintList(drawable, this.X);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        Drawable drawable2 = this.Q;
        if (drawable == drawable2 && this.T) {
            DrawableCompat.setTintList(drawable2, this.R);
        }
    }

    private void P0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (G3() || F3()) {
            float f2 = this.g0 + this.h0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f3 = rect.left + f2;
                rectF.left = f3;
                rectF.right = f3 + this.S;
            } else {
                float f4 = rect.right - f2;
                rectF.right = f4;
                rectF.left = f4 - this.S;
            }
            float exactCenterY = rect.exactCenterY();
            float f5 = this.S;
            float f6 = exactCenterY - (f5 / 2.0f);
            rectF.top = f6;
            rectF.bottom = f6 + f5;
        }
    }

    @Nullable
    private ColorFilter Q1() {
        ColorFilter colorFilter = this.G0;
        return colorFilter != null ? colorFilter : this.H0;
    }

    private void Q2(@Nullable ColorStateList colorStateList) {
        if (this.H != colorStateList) {
            this.H = colorStateList;
            onStateChange(getState());
        }
    }

    private void R0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.set(rect);
        if (H3()) {
            float f2 = this.n0 + this.m0 + this.Y + this.l0 + this.k0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.right = rect.right - f2;
            } else {
                rectF.left = rect.left + f2;
            }
        }
    }

    private void S0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (H3()) {
            float f2 = this.n0 + this.m0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f3 = rect.right - f2;
                rectF.right = f3;
                rectF.left = f3 - this.Y;
            } else {
                float f4 = rect.left + f2;
                rectF.left = f4;
                rectF.right = f4 + this.Y;
            }
            float exactCenterY = rect.exactCenterY();
            float f5 = this.Y;
            float f6 = exactCenterY - (f5 / 2.0f);
            rectF.top = f6;
            rectF.bottom = f6 + f5;
        }
    }

    private static boolean S1(@Nullable int[] iArr, @AttrRes int i2) {
        if (iArr == null) {
            return false;
        }
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    private void T0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (H3()) {
            float f2 = this.n0 + this.m0 + this.Y + this.l0 + this.k0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f3 = rect.right;
                rectF.right = f3;
                rectF.left = f3 - f2;
            } else {
                int i2 = rect.left;
                rectF.left = i2;
                rectF.right = i2 + f2;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private void V0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (this.O != null) {
            float Q0 = this.g0 + Q0() + this.j0;
            float U0 = this.n0 + U0() + this.k0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.left = rect.left + Q0;
                rectF.right = rect.right - U0;
            } else {
                rectF.left = rect.left + U0;
                rectF.right = rect.right - Q0;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private float W0() {
        this.v0.e().getFontMetrics(this.r0);
        Paint.FontMetrics fontMetrics = this.r0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private boolean Y0() {
        return this.b0 && this.c0 != null && this.a0;
    }

    @NonNull
    public static a Z0(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        a aVar = new a(context, attributeSet, i2, i3);
        aVar.f2(attributeSet, i2, i3);
        return aVar;
    }

    @NonNull
    public static a a1(@NonNull Context context, @XmlRes int i2) {
        AttributeSet a2 = com.google.android.material.d.a.a(context, i2, "chip");
        int styleAttribute = a2.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = com.google.android.material.R.style.Widget_MaterialComponents_Chip_Entry;
        }
        return Z0(context, a2, com.google.android.material.R.attr.chipStandaloneStyle, styleAttribute);
    }

    private void b1(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (F3()) {
            P0(rect, this.s0);
            RectF rectF = this.s0;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.c0.setBounds(0, 0, (int) this.s0.width(), (int) this.s0.height());
            this.c0.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void c1(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.R0) {
            return;
        }
        this.p0.setColor(this.x0);
        this.p0.setStyle(Paint.Style.FILL);
        this.p0.setColorFilter(Q1());
        this.s0.set(rect);
        canvas.drawRoundRect(this.s0, n1(), n1(), this.p0);
    }

    private static boolean c2(@Nullable ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private void d1(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (G3()) {
            P0(rect, this.s0);
            RectF rectF = this.s0;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.Q.setBounds(0, 0, (int) this.s0.width(), (int) this.s0.height());
            this.Q.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private static boolean d2(@Nullable Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private void e1(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.M <= 0.0f || this.R0) {
            return;
        }
        this.p0.setColor(this.z0);
        this.p0.setStyle(Paint.Style.STROKE);
        if (!this.R0) {
            this.p0.setColorFilter(Q1());
        }
        RectF rectF = this.s0;
        float f2 = rect.left;
        float f3 = this.M;
        rectF.set(f2 + (f3 / 2.0f), rect.top + (f3 / 2.0f), rect.right - (f3 / 2.0f), rect.bottom - (f3 / 2.0f));
        float f4 = this.K - (this.M / 2.0f);
        canvas.drawRoundRect(this.s0, f4, f4, this.p0);
    }

    private static boolean e2(@Nullable d dVar) {
        ColorStateList colorStateList;
        return (dVar == null || (colorStateList = dVar.f7231f) == null || !colorStateList.isStateful()) ? false : true;
    }

    private void f1(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.R0) {
            return;
        }
        this.p0.setColor(this.w0);
        this.p0.setStyle(Paint.Style.FILL);
        this.s0.set(rect);
        canvas.drawRoundRect(this.s0, n1(), n1(), this.p0);
    }

    private void f2(@Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        TypedArray j2 = n.j(this.o0, attributeSet, com.google.android.material.R.styleable.Chip, i2, i3, new int[0]);
        this.R0 = j2.hasValue(com.google.android.material.R.styleable.Chip_shapeAppearance);
        Q2(c.a(this.o0, j2, com.google.android.material.R.styleable.Chip_chipSurfaceColor));
        s2(c.a(this.o0, j2, com.google.android.material.R.styleable.Chip_chipBackgroundColor));
        I2(j2.getDimension(com.google.android.material.R.styleable.Chip_chipMinHeight, 0.0f));
        int i4 = com.google.android.material.R.styleable.Chip_chipCornerRadius;
        if (j2.hasValue(i4)) {
            u2(j2.getDimension(i4, 0.0f));
        }
        M2(c.a(this.o0, j2, com.google.android.material.R.styleable.Chip_chipStrokeColor));
        O2(j2.getDimension(com.google.android.material.R.styleable.Chip_chipStrokeWidth, 0.0f));
        q3(c.a(this.o0, j2, com.google.android.material.R.styleable.Chip_rippleColor));
        v3(j2.getText(com.google.android.material.R.styleable.Chip_android_text));
        w3(c.f(this.o0, j2, com.google.android.material.R.styleable.Chip_android_textAppearance));
        int i5 = j2.getInt(com.google.android.material.R.styleable.Chip_android_ellipsize, 0);
        if (i5 == 1) {
            i3(TextUtils.TruncateAt.START);
        } else if (i5 == 2) {
            i3(TextUtils.TruncateAt.MIDDLE);
        } else if (i5 == 3) {
            i3(TextUtils.TruncateAt.END);
        }
        H2(j2.getBoolean(com.google.android.material.R.styleable.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue(F, "chipIconEnabled") != null && attributeSet.getAttributeValue(F, "chipIconVisible") == null) {
            H2(j2.getBoolean(com.google.android.material.R.styleable.Chip_chipIconEnabled, false));
        }
        y2(c.d(this.o0, j2, com.google.android.material.R.styleable.Chip_chipIcon));
        int i6 = com.google.android.material.R.styleable.Chip_chipIconTint;
        if (j2.hasValue(i6)) {
            E2(c.a(this.o0, j2, i6));
        }
        C2(j2.getDimension(com.google.android.material.R.styleable.Chip_chipIconSize, 0.0f));
        g3(j2.getBoolean(com.google.android.material.R.styleable.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue(F, "closeIconEnabled") != null && attributeSet.getAttributeValue(F, "closeIconVisible") == null) {
            g3(j2.getBoolean(com.google.android.material.R.styleable.Chip_closeIconEnabled, false));
        }
        R2(c.d(this.o0, j2, com.google.android.material.R.styleable.Chip_closeIcon));
        d3(c.a(this.o0, j2, com.google.android.material.R.styleable.Chip_closeIconTint));
        Y2(j2.getDimension(com.google.android.material.R.styleable.Chip_closeIconSize, 0.0f));
        i2(j2.getBoolean(com.google.android.material.R.styleable.Chip_android_checkable, false));
        r2(j2.getBoolean(com.google.android.material.R.styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue(F, "checkedIconEnabled") != null && attributeSet.getAttributeValue(F, "checkedIconVisible") == null) {
            r2(j2.getBoolean(com.google.android.material.R.styleable.Chip_checkedIconEnabled, false));
        }
        k2(c.d(this.o0, j2, com.google.android.material.R.styleable.Chip_checkedIcon));
        int i7 = com.google.android.material.R.styleable.Chip_checkedIconTint;
        if (j2.hasValue(i7)) {
            o2(c.a(this.o0, j2, i7));
        }
        t3(h.c(this.o0, j2, com.google.android.material.R.styleable.Chip_showMotionSpec));
        j3(h.c(this.o0, j2, com.google.android.material.R.styleable.Chip_hideMotionSpec));
        K2(j2.getDimension(com.google.android.material.R.styleable.Chip_chipStartPadding, 0.0f));
        n3(j2.getDimension(com.google.android.material.R.styleable.Chip_iconStartPadding, 0.0f));
        l3(j2.getDimension(com.google.android.material.R.styleable.Chip_iconEndPadding, 0.0f));
        B3(j2.getDimension(com.google.android.material.R.styleable.Chip_textStartPadding, 0.0f));
        y3(j2.getDimension(com.google.android.material.R.styleable.Chip_textEndPadding, 0.0f));
        a3(j2.getDimension(com.google.android.material.R.styleable.Chip_closeIconStartPadding, 0.0f));
        V2(j2.getDimension(com.google.android.material.R.styleable.Chip_closeIconEndPadding, 0.0f));
        w2(j2.getDimension(com.google.android.material.R.styleable.Chip_chipEndPadding, 0.0f));
        p3(j2.getDimensionPixelSize(com.google.android.material.R.styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        j2.recycle();
    }

    private void g1(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (H3()) {
            S0(rect, this.s0);
            RectF rectF = this.s0;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.V.setBounds(0, 0, (int) this.s0.width(), (int) this.s0.height());
            if (b.f7245a) {
                this.W.setBounds(this.V.getBounds());
                this.W.jumpToCurrentState();
                this.W.draw(canvas);
            } else {
                this.V.draw(canvas);
            }
            canvas.translate(-f2, -f3);
        }
    }

    private void h1(@NonNull Canvas canvas, @NonNull Rect rect) {
        this.p0.setColor(this.A0);
        this.p0.setStyle(Paint.Style.FILL);
        this.s0.set(rect);
        if (!this.R0) {
            canvas.drawRoundRect(this.s0, n1(), n1(), this.p0);
        } else {
            h(new RectF(rect), this.u0);
            super.q(canvas, this.p0, this.u0, v());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean h2(@androidx.annotation.NonNull int[] r7, @androidx.annotation.NonNull int[] r8) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.a.h2(int[], int[]):boolean");
    }

    private void i1(@NonNull Canvas canvas, @NonNull Rect rect) {
        Paint paint = this.q0;
        if (paint != null) {
            paint.setColor(ColorUtils.setAlphaComponent(-16777216, 127));
            canvas.drawRect(rect, this.q0);
            if (G3() || F3()) {
                P0(rect, this.s0);
                canvas.drawRect(this.s0, this.q0);
            }
            if (this.O != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.q0);
            }
            if (H3()) {
                S0(rect, this.s0);
                canvas.drawRect(this.s0, this.q0);
            }
            this.q0.setColor(ColorUtils.setAlphaComponent(-65536, 127));
            R0(rect, this.s0);
            canvas.drawRect(this.s0, this.q0);
            this.q0.setColor(ColorUtils.setAlphaComponent(Color.GREEN, 127));
            T0(rect, this.s0);
            canvas.drawRect(this.s0, this.q0);
        }
    }

    private void j1(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.O != null) {
            Paint.Align X0 = X0(rect, this.t0);
            V0(rect, this.s0);
            if (this.v0.d() != null) {
                this.v0.e().drawableState = getState();
                this.v0.k(this.o0);
            }
            this.v0.e().setTextAlign(X0);
            int i2 = 0;
            boolean z = Math.round(this.v0.f(M1().toString())) > Math.round(this.s0.width());
            if (z) {
                i2 = canvas.save();
                canvas.clipRect(this.s0);
            }
            CharSequence charSequence = this.O;
            if (z && this.O0 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.v0.e(), this.s0.width(), this.O0);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.t0;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.v0.e());
            if (z) {
                canvas.restoreToCount(i2);
            }
        }
    }

    public float A1() {
        return this.Y;
    }

    @Deprecated
    public void A2(@BoolRes int i2) {
        G2(i2);
    }

    public void A3(@StringRes int i2) {
        v3(this.o0.getResources().getString(i2));
    }

    public float B1() {
        return this.l0;
    }

    public void B2(@DrawableRes int i2) {
        y2(AppCompatResources.getDrawable(this.o0, i2));
    }

    public void B3(float f2) {
        if (this.j0 != f2) {
            this.j0 = f2;
            invalidateSelf();
            g2();
        }
    }

    @NonNull
    public int[] C1() {
        return this.K0;
    }

    public void C2(float f2) {
        if (this.S != f2) {
            float Q0 = Q0();
            this.S = f2;
            float Q02 = Q0();
            invalidateSelf();
            if (Q0 != Q02) {
                g2();
            }
        }
    }

    public void C3(@DimenRes int i2) {
        B3(this.o0.getResources().getDimension(i2));
    }

    @Nullable
    public ColorStateList D1() {
        return this.X;
    }

    public void D2(@DimenRes int i2) {
        C2(this.o0.getResources().getDimension(i2));
    }

    public void D3(boolean z) {
        if (this.L0 != z) {
            this.L0 = z;
            J3();
            onStateChange(getState());
        }
    }

    public void E1(@NonNull RectF rectF) {
        T0(getBounds(), rectF);
    }

    public void E2(@Nullable ColorStateList colorStateList) {
        this.T = true;
        if (this.R != colorStateList) {
            this.R = colorStateList;
            if (G3()) {
                DrawableCompat.setTintList(this.Q, colorStateList);
            }
            onStateChange(getState());
        }
    }

    boolean E3() {
        return this.P0;
    }

    public TextUtils.TruncateAt F1() {
        return this.O0;
    }

    public void F2(@ColorRes int i2) {
        E2(AppCompatResources.getColorStateList(this.o0, i2));
    }

    @Nullable
    public h G1() {
        return this.f0;
    }

    public void G2(@BoolRes int i2) {
        H2(this.o0.getResources().getBoolean(i2));
    }

    public float H1() {
        return this.i0;
    }

    public void H2(boolean z) {
        if (this.P != z) {
            boolean G3 = G3();
            this.P = z;
            boolean G32 = G3();
            if (G3 != G32) {
                if (G32) {
                    O0(this.Q);
                } else {
                    I3(this.Q);
                }
                invalidateSelf();
                g2();
            }
        }
    }

    public float I1() {
        return this.h0;
    }

    public void I2(float f2) {
        if (this.J != f2) {
            this.J = f2;
            invalidateSelf();
            g2();
        }
    }

    @Px
    public int J1() {
        return this.Q0;
    }

    public void J2(@DimenRes int i2) {
        I2(this.o0.getResources().getDimension(i2));
    }

    @Nullable
    public ColorStateList K1() {
        return this.N;
    }

    public void K2(float f2) {
        if (this.g0 != f2) {
            this.g0 = f2;
            invalidateSelf();
            g2();
        }
    }

    @Nullable
    public h L1() {
        return this.e0;
    }

    public void L2(@DimenRes int i2) {
        K2(this.o0.getResources().getDimension(i2));
    }

    @Nullable
    public CharSequence M1() {
        return this.O;
    }

    public void M2(@Nullable ColorStateList colorStateList) {
        if (this.L != colorStateList) {
            this.L = colorStateList;
            if (this.R0) {
                E0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Nullable
    public d N1() {
        return this.v0.d();
    }

    public void N2(@ColorRes int i2) {
        M2(AppCompatResources.getColorStateList(this.o0, i2));
    }

    public float O1() {
        return this.k0;
    }

    public void O2(float f2) {
        if (this.M != f2) {
            this.M = f2;
            this.p0.setStrokeWidth(f2);
            if (this.R0) {
                super.H0(f2);
            }
            invalidateSelf();
        }
    }

    public float P1() {
        return this.j0;
    }

    public void P2(@DimenRes int i2) {
        O2(this.o0.getResources().getDimension(i2));
    }

    float Q0() {
        if (G3() || F3()) {
            return this.h0 + this.S + this.i0;
        }
        return 0.0f;
    }

    public boolean R1() {
        return this.L0;
    }

    public void R2(@Nullable Drawable drawable) {
        Drawable x1 = x1();
        if (x1 != drawable) {
            float U0 = U0();
            this.V = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            if (b.f7245a) {
                K3();
            }
            float U02 = U0();
            I3(x1);
            if (H3()) {
                O0(this.V);
            }
            invalidateSelf();
            if (U0 != U02) {
                g2();
            }
        }
    }

    public void S2(@Nullable CharSequence charSequence) {
        if (this.Z != charSequence) {
            this.Z = BidiFormatter.getInstance().unicodeWrap(charSequence);
            invalidateSelf();
        }
    }

    public boolean T1() {
        return this.a0;
    }

    @Deprecated
    public void T2(boolean z) {
        g3(z);
    }

    float U0() {
        if (H3()) {
            return this.l0 + this.Y + this.m0;
        }
        return 0.0f;
    }

    @Deprecated
    public boolean U1() {
        return V1();
    }

    @Deprecated
    public void U2(@BoolRes int i2) {
        f3(i2);
    }

    public boolean V1() {
        return this.b0;
    }

    public void V2(float f2) {
        if (this.m0 != f2) {
            this.m0 = f2;
            invalidateSelf();
            if (H3()) {
                g2();
            }
        }
    }

    @Deprecated
    public boolean W1() {
        return X1();
    }

    public void W2(@DimenRes int i2) {
        V2(this.o0.getResources().getDimension(i2));
    }

    @NonNull
    Paint.Align X0(@NonNull Rect rect, @NonNull PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.O != null) {
            float Q0 = this.g0 + Q0() + this.j0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                pointF.x = rect.left + Q0;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - Q0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - W0();
        }
        return align;
    }

    public boolean X1() {
        return this.P;
    }

    public void X2(@DrawableRes int i2) {
        R2(AppCompatResources.getDrawable(this.o0, i2));
    }

    @Deprecated
    public boolean Y1() {
        return a2();
    }

    public void Y2(float f2) {
        if (this.Y != f2) {
            this.Y = f2;
            invalidateSelf();
            if (H3()) {
                g2();
            }
        }
    }

    public boolean Z1() {
        return d2(this.V);
    }

    public void Z2(@DimenRes int i2) {
        Y2(this.o0.getResources().getDimension(i2));
    }

    @Override // com.google.android.material.internal.l.b
    public void a() {
        g2();
        invalidateSelf();
    }

    public boolean a2() {
        return this.U;
    }

    public void a3(float f2) {
        if (this.l0 != f2) {
            this.l0 = f2;
            invalidateSelf();
            if (H3()) {
                g2();
            }
        }
    }

    boolean b2() {
        return this.R0;
    }

    public void b3(@DimenRes int i2) {
        a3(this.o0.getResources().getDimension(i2));
    }

    public boolean c3(@NonNull int[] iArr) {
        if (Arrays.equals(this.K0, iArr)) {
            return false;
        }
        this.K0 = iArr;
        if (H3()) {
            return h2(getState(), iArr);
        }
        return false;
    }

    public void d3(@Nullable ColorStateList colorStateList) {
        if (this.X != colorStateList) {
            this.X = colorStateList;
            if (H3()) {
                DrawableCompat.setTintList(this.V, colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.j.j, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i2 = this.F0;
        int a2 = i2 < 255 ? com.google.android.material.b.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i2) : 0;
        f1(canvas, bounds);
        c1(canvas, bounds);
        if (this.R0) {
            super.draw(canvas);
        }
        e1(canvas, bounds);
        h1(canvas, bounds);
        d1(canvas, bounds);
        b1(canvas, bounds);
        if (this.P0) {
            j1(canvas, bounds);
        }
        g1(canvas, bounds);
        i1(canvas, bounds);
        if (this.F0 < 255) {
            canvas.restoreToCount(a2);
        }
    }

    public void e3(@ColorRes int i2) {
        d3(AppCompatResources.getColorStateList(this.o0, i2));
    }

    public void f3(@BoolRes int i2) {
        g3(this.o0.getResources().getBoolean(i2));
    }

    protected void g2() {
        InterfaceC0085a interfaceC0085a = this.N0.get();
        if (interfaceC0085a != null) {
            interfaceC0085a.a();
        }
    }

    public void g3(boolean z) {
        if (this.U != z) {
            boolean H3 = H3();
            this.U = z;
            boolean H32 = H3();
            if (H3 != H32) {
                if (H32) {
                    O0(this.V);
                } else {
                    I3(this.V);
                }
                invalidateSelf();
                g2();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.F0;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public ColorFilter getColorFilter() {
        return this.G0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.J;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.g0 + Q0() + this.j0 + this.v0.f(M1().toString()) + this.k0 + U0() + this.n0), this.Q0);
    }

    @Override // com.google.android.material.j.j, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.j.j, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.R0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.K);
        } else {
            outline.setRoundRect(bounds, this.K);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public void h3(@Nullable InterfaceC0085a interfaceC0085a) {
        this.N0 = new WeakReference<>(interfaceC0085a);
    }

    public void i2(boolean z) {
        if (this.a0 != z) {
            this.a0 = z;
            float Q0 = Q0();
            if (!z && this.C0) {
                this.C0 = false;
            }
            float Q02 = Q0();
            invalidateSelf();
            if (Q0 != Q02) {
                g2();
            }
        }
    }

    public void i3(@Nullable TextUtils.TruncateAt truncateAt) {
        this.O0 = truncateAt;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // com.google.android.material.j.j, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return c2(this.H) || c2(this.I) || c2(this.L) || (this.L0 && c2(this.M0)) || e2(this.v0.d()) || Y0() || d2(this.Q) || d2(this.c0) || c2(this.I0);
    }

    public void j2(@BoolRes int i2) {
        i2(this.o0.getResources().getBoolean(i2));
    }

    public void j3(@Nullable h hVar) {
        this.f0 = hVar;
    }

    @Nullable
    public Drawable k1() {
        return this.c0;
    }

    public void k2(@Nullable Drawable drawable) {
        if (this.c0 != drawable) {
            float Q0 = Q0();
            this.c0 = drawable;
            float Q02 = Q0();
            I3(this.c0);
            O0(this.c0);
            invalidateSelf();
            if (Q0 != Q02) {
                g2();
            }
        }
    }

    public void k3(@AnimatorRes int i2) {
        j3(h.d(this.o0, i2));
    }

    @Nullable
    public ColorStateList l1() {
        return this.d0;
    }

    @Deprecated
    public void l2(boolean z) {
        r2(z);
    }

    public void l3(float f2) {
        if (this.i0 != f2) {
            float Q0 = Q0();
            this.i0 = f2;
            float Q02 = Q0();
            invalidateSelf();
            if (Q0 != Q02) {
                g2();
            }
        }
    }

    @Nullable
    public ColorStateList m1() {
        return this.I;
    }

    @Deprecated
    public void m2(@BoolRes int i2) {
        r2(this.o0.getResources().getBoolean(i2));
    }

    public void m3(@DimenRes int i2) {
        l3(this.o0.getResources().getDimension(i2));
    }

    public float n1() {
        return this.R0 ? R() : this.K;
    }

    public void n2(@DrawableRes int i2) {
        k2(AppCompatResources.getDrawable(this.o0, i2));
    }

    public void n3(float f2) {
        if (this.h0 != f2) {
            float Q0 = Q0();
            this.h0 = f2;
            float Q02 = Q0();
            invalidateSelf();
            if (Q0 != Q02) {
                g2();
            }
        }
    }

    public float o1() {
        return this.n0;
    }

    public void o2(@Nullable ColorStateList colorStateList) {
        if (this.d0 != colorStateList) {
            this.d0 = colorStateList;
            if (Y0()) {
                DrawableCompat.setTintList(this.c0, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void o3(@DimenRes int i2) {
        n3(this.o0.getResources().getDimension(i2));
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i2);
        if (G3()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.Q, i2);
        }
        if (F3()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.c0, i2);
        }
        if (H3()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.V, i2);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        boolean onLevelChange = super.onLevelChange(i2);
        if (G3()) {
            onLevelChange |= this.Q.setLevel(i2);
        }
        if (F3()) {
            onLevelChange |= this.c0.setLevel(i2);
        }
        if (H3()) {
            onLevelChange |= this.V.setLevel(i2);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // com.google.android.material.j.j, android.graphics.drawable.Drawable, com.google.android.material.internal.l.b
    public boolean onStateChange(@NonNull int[] iArr) {
        if (this.R0) {
            super.onStateChange(iArr);
        }
        return h2(iArr, C1());
    }

    @Nullable
    public Drawable p1() {
        Drawable drawable = this.Q;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    public void p2(@ColorRes int i2) {
        o2(AppCompatResources.getColorStateList(this.o0, i2));
    }

    public void p3(@Px int i2) {
        this.Q0 = i2;
    }

    public float q1() {
        return this.S;
    }

    public void q2(@BoolRes int i2) {
        r2(this.o0.getResources().getBoolean(i2));
    }

    public void q3(@Nullable ColorStateList colorStateList) {
        if (this.N != colorStateList) {
            this.N = colorStateList;
            J3();
            onStateChange(getState());
        }
    }

    @Nullable
    public ColorStateList r1() {
        return this.R;
    }

    public void r2(boolean z) {
        if (this.b0 != z) {
            boolean F3 = F3();
            this.b0 = z;
            boolean F32 = F3();
            if (F3 != F32) {
                if (F32) {
                    O0(this.c0);
                } else {
                    I3(this.c0);
                }
                invalidateSelf();
                g2();
            }
        }
    }

    public void r3(@ColorRes int i2) {
        q3(AppCompatResources.getColorStateList(this.o0, i2));
    }

    public float s1() {
        return this.J;
    }

    public void s2(@Nullable ColorStateList colorStateList) {
        if (this.I != colorStateList) {
            this.I = colorStateList;
            onStateChange(getState());
        }
    }

    void s3(boolean z) {
        this.P0 = z;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    @Override // com.google.android.material.j.j, android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.F0 != i2) {
            this.F0 = i2;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.j.j, android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        if (this.G0 != colorFilter) {
            this.G0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.j.j, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        if (this.I0 != colorStateList) {
            this.I0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.j.j, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.J0 != mode) {
            this.J0 = mode;
            this.H0 = com.google.android.material.d.a.c(this, this.I0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (G3()) {
            visible |= this.Q.setVisible(z, z2);
        }
        if (F3()) {
            visible |= this.c0.setVisible(z, z2);
        }
        if (H3()) {
            visible |= this.V.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public float t1() {
        return this.g0;
    }

    public void t2(@ColorRes int i2) {
        s2(AppCompatResources.getColorStateList(this.o0, i2));
    }

    public void t3(@Nullable h hVar) {
        this.e0 = hVar;
    }

    @Nullable
    public ColorStateList u1() {
        return this.L;
    }

    @Deprecated
    public void u2(float f2) {
        if (this.K != f2) {
            this.K = f2;
            setShapeAppearanceModel(getShapeAppearanceModel().w(f2));
        }
    }

    public void u3(@AnimatorRes int i2) {
        t3(h.d(this.o0, i2));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public float v1() {
        return this.M;
    }

    @Deprecated
    public void v2(@DimenRes int i2) {
        u2(this.o0.getResources().getDimension(i2));
    }

    public void v3(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.O, charSequence)) {
            return;
        }
        this.O = charSequence;
        this.v0.j(true);
        invalidateSelf();
        g2();
    }

    public void w1(@NonNull RectF rectF) {
        R0(getBounds(), rectF);
    }

    public void w2(float f2) {
        if (this.n0 != f2) {
            this.n0 = f2;
            invalidateSelf();
            g2();
        }
    }

    public void w3(@Nullable d dVar) {
        this.v0.i(dVar, this.o0);
    }

    @Nullable
    public Drawable x1() {
        Drawable drawable = this.V;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    public void x2(@DimenRes int i2) {
        w2(this.o0.getResources().getDimension(i2));
    }

    public void x3(@StyleRes int i2) {
        w3(new d(this.o0, i2));
    }

    @Nullable
    public CharSequence y1() {
        return this.Z;
    }

    public void y2(@Nullable Drawable drawable) {
        Drawable p1 = p1();
        if (p1 != drawable) {
            float Q0 = Q0();
            this.Q = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            float Q02 = Q0();
            I3(p1);
            if (G3()) {
                O0(this.Q);
            }
            invalidateSelf();
            if (Q0 != Q02) {
                g2();
            }
        }
    }

    public void y3(float f2) {
        if (this.k0 != f2) {
            this.k0 = f2;
            invalidateSelf();
            g2();
        }
    }

    public float z1() {
        return this.m0;
    }

    @Deprecated
    public void z2(boolean z) {
        H2(z);
    }

    public void z3(@DimenRes int i2) {
        y3(this.o0.getResources().getDimension(i2));
    }
}
