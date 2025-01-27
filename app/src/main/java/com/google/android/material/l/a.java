package com.google.android.material.l;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.g.c;
import com.google.android.material.g.d;
import com.google.android.material.internal.l;
import com.google.android.material.internal.n;
import com.google.android.material.j.g;
import com.google.android.material.j.i;
import com.google.android.material.j.j;
import com.tencent.bugly.beta.tinker.TinkerReport;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class a extends j implements l.b {

    @StyleRes
    private static final int D = R.style.Widget_MaterialComponents_Tooltip;

    @AttrRes
    private static final int E = R.attr.tooltipStyle;

    @Nullable
    private CharSequence F;

    @NonNull
    private final Context G;

    @Nullable
    private final Paint.FontMetrics H;

    @NonNull
    private final l I;

    @NonNull
    private final View.OnLayoutChangeListener J;

    @NonNull
    private final Rect K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;

    /* renamed from: com.google.android.material.l.a$a */
    class ViewOnLayoutChangeListenerC0096a implements View.OnLayoutChangeListener {
        ViewOnLayoutChangeListenerC0096a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            a.this.p1(view);
        }
    }

    private a(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(context, attributeSet, i2, i3);
        this.H = new Paint.FontMetrics();
        l lVar = new l(this);
        this.I = lVar;
        this.J = new ViewOnLayoutChangeListenerC0096a();
        this.K = new Rect();
        this.G = context;
        lVar.e().density = context.getResources().getDisplayMetrics().density;
        lVar.e().setTextAlign(Paint.Align.CENTER);
    }

    private float P0() {
        int i2;
        if (((this.K.right - getBounds().right) - this.Q) - this.O < 0) {
            i2 = ((this.K.right - getBounds().right) - this.Q) - this.O;
        } else {
            if (((this.K.left - getBounds().left) - this.Q) + this.O <= 0) {
                return 0.0f;
            }
            i2 = ((this.K.left - getBounds().left) - this.Q) + this.O;
        }
        return i2;
    }

    private float Q0() {
        this.I.e().getFontMetrics(this.H);
        Paint.FontMetrics fontMetrics = this.H;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private float R0(@NonNull Rect rect) {
        return rect.centerY() - Q0();
    }

    @NonNull
    public static a S0(@NonNull Context context) {
        return U0(context, null, E, D);
    }

    @NonNull
    public static a T0(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        return U0(context, attributeSet, E, D);
    }

    @NonNull
    public static a U0(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        a aVar = new a(context, attributeSet, i2, i3);
        aVar.f1(attributeSet, i2, i3);
        return aVar;
    }

    private g V0() {
        float f2 = -P0();
        double width = getBounds().width();
        double d2 = this.P;
        double sqrt = Math.sqrt(2.0d);
        Double.isNaN(d2);
        Double.isNaN(width);
        float f3 = ((float) (width - (d2 * sqrt))) / 2.0f;
        return new com.google.android.material.j.l(new i(this.P), Math.min(Math.max(f2, -f3), f3));
    }

    private void X0(@NonNull Canvas canvas) {
        if (this.F == null) {
            return;
        }
        int R0 = (int) R0(getBounds());
        if (this.I.d() != null) {
            this.I.e().drawableState = getState();
            this.I.k(this.G);
        }
        CharSequence charSequence = this.F;
        canvas.drawText(charSequence, 0, charSequence.length(), r0.centerX(), R0, this.I.e());
    }

    private float e1() {
        CharSequence charSequence = this.F;
        if (charSequence == null) {
            return 0.0f;
        }
        return this.I.f(charSequence.toString());
    }

    private void f1(@Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        TypedArray j2 = n.j(this.G, attributeSet, R.styleable.Tooltip, i2, i3, new int[0]);
        this.P = this.G.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
        setShapeAppearanceModel(getShapeAppearanceModel().v().t(V0()).m());
        k1(j2.getText(R.styleable.Tooltip_android_text));
        l1(c.f(this.G, j2, R.styleable.Tooltip_android_textAppearance));
        n0(ColorStateList.valueOf(j2.getColor(R.styleable.Tooltip_backgroundTint, com.google.android.material.c.a.f(ColorUtils.setAlphaComponent(com.google.android.material.c.a.c(this.G, android.R.attr.colorBackground, a.class.getCanonicalName()), 229), ColorUtils.setAlphaComponent(com.google.android.material.c.a.c(this.G, R.attr.colorOnBackground, a.class.getCanonicalName()), TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND)))));
        E0(ColorStateList.valueOf(com.google.android.material.c.a.c(this.G, R.attr.colorSurface, a.class.getCanonicalName())));
        this.L = j2.getDimensionPixelSize(R.styleable.Tooltip_android_padding, 0);
        this.M = j2.getDimensionPixelSize(R.styleable.Tooltip_android_minWidth, 0);
        this.N = j2.getDimensionPixelSize(R.styleable.Tooltip_android_minHeight, 0);
        this.O = j2.getDimensionPixelSize(R.styleable.Tooltip_android_layout_margin, 0);
        j2.recycle();
    }

    public void p1(@NonNull View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.Q = iArr[0];
        view.getWindowVisibleDisplayFrame(this.K);
    }

    public void W0(@Nullable View view) {
        if (view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.J);
    }

    public int Y0() {
        return this.O;
    }

    public int Z0() {
        return this.N;
    }

    @Override // com.google.android.material.internal.l.b
    public void a() {
        invalidateSelf();
    }

    public int a1() {
        return this.M;
    }

    @Nullable
    public CharSequence b1() {
        return this.F;
    }

    @Nullable
    public d c1() {
        return this.I.d();
    }

    public int d1() {
        return this.L;
    }

    @Override // com.google.android.material.j.j, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        float P0 = P0();
        double d2 = this.P;
        double sqrt = Math.sqrt(2.0d);
        Double.isNaN(d2);
        double d3 = d2 * sqrt;
        double d4 = this.P;
        Double.isNaN(d4);
        canvas.translate(P0, (float) (-(d3 - d4)));
        super.draw(canvas);
        X0(canvas);
        canvas.restore();
    }

    public void g1(@Px int i2) {
        this.O = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.I.e().getTextSize(), this.N);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) Math.max((this.L * 2) + e1(), this.M);
    }

    public void h1(@Px int i2) {
        this.N = i2;
        invalidateSelf();
    }

    public void i1(@Px int i2) {
        this.M = i2;
        invalidateSelf();
    }

    public void j1(@Nullable View view) {
        if (view == null) {
            return;
        }
        p1(view);
        view.addOnLayoutChangeListener(this.J);
    }

    public void k1(@Nullable CharSequence charSequence) {
        if (TextUtils.equals(this.F, charSequence)) {
            return;
        }
        this.F = charSequence;
        this.I.j(true);
        invalidateSelf();
    }

    public void l1(@Nullable d dVar) {
        this.I.i(dVar, this.G);
    }

    public void m1(@StyleRes int i2) {
        l1(new d(this.G, i2));
    }

    public void n1(@Px int i2) {
        this.L = i2;
        invalidateSelf();
    }

    public void o1(@StringRes int i2) {
        k1(this.G.getResources().getString(i2));
    }

    @Override // com.google.android.material.j.j, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        setShapeAppearanceModel(getShapeAppearanceModel().v().t(V0()).m());
    }

    @Override // com.google.android.material.j.j, android.graphics.drawable.Drawable, com.google.android.material.internal.l.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }
}
