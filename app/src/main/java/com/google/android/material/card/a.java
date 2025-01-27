package com.google.android.material.card;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.g.c;
import com.google.android.material.h.b;
import com.google.android.material.j.e;
import com.google.android.material.j.f;
import com.google.android.material.j.j;
import com.google.android.material.j.n;
import com.google.android.material.j.o;
import com.vivo.advv.Color;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
class a {

    /* renamed from: b */
    private static final int f6917b = -1;

    /* renamed from: d */
    private static final float f6919d = 1.5f;

    /* renamed from: e */
    private static final int f6920e = 2;

    /* renamed from: f */
    @NonNull
    private final MaterialCardView f6921f;

    /* renamed from: h */
    @NonNull
    private final j f6923h;

    /* renamed from: i */
    @NonNull
    private final j f6924i;

    /* renamed from: j */
    @Dimension
    private final int f6925j;

    @Dimension
    private final int k;

    @Dimension
    private int l;

    @Nullable
    private Drawable m;

    @Nullable
    private Drawable n;

    @Nullable
    private ColorStateList o;

    @Nullable
    private ColorStateList p;

    @Nullable
    private o q;

    @Nullable
    private ColorStateList r;

    @Nullable
    private Drawable s;

    @Nullable
    private LayerDrawable t;

    @Nullable
    private j u;

    @Nullable
    private j v;
    private boolean x;

    /* renamed from: a */
    private static final int[] f6916a = {R.attr.state_checked};

    /* renamed from: c */
    private static final double f6918c = Math.cos(Math.toRadians(45.0d));

    /* renamed from: g */
    @NonNull
    private final Rect f6922g = new Rect();
    private boolean w = false;

    /* renamed from: com.google.android.material.card.a$a */
    class C0084a extends InsetDrawable {
        C0084a(Drawable drawable, int i2, int i3, int i4, int i5) {
            super(drawable, i2, i3, i4, i5);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    public a(@NonNull MaterialCardView materialCardView, AttributeSet attributeSet, int i2, @StyleRes int i3) {
        this.f6921f = materialCardView;
        j jVar = new j(materialCardView.getContext(), attributeSet, i2, i3);
        this.f6923h = jVar;
        jVar.Y(materialCardView.getContext());
        jVar.u0(Color.DKGRAY);
        o.b v = jVar.getShapeAppearanceModel().v();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.CardView, i2, com.google.android.material.R.style.CardView);
        int i4 = com.google.android.material.R.styleable.CardView_cardCornerRadius;
        if (obtainStyledAttributes.hasValue(i4)) {
            v.o(obtainStyledAttributes.getDimension(i4, 0.0f));
        }
        this.f6924i = new j();
        N(v.m());
        Resources resources = materialCardView.getResources();
        this.f6925j = resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_card_checked_icon_margin);
        this.k = resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_card_checked_icon_size);
        obtainStyledAttributes.recycle();
    }

    private boolean R() {
        return this.f6921f.getPreventCornerOverlap() && !e();
    }

    private boolean S() {
        return this.f6921f.getPreventCornerOverlap() && e() && this.f6921f.getUseCompatPadding();
    }

    private void W(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 23 || !(this.f6921f.getForeground() instanceof InsetDrawable)) {
            this.f6921f.setForeground(z(drawable));
        } else {
            ((InsetDrawable) this.f6921f.getForeground()).setDrawable(drawable);
        }
    }

    private void Y() {
        Drawable drawable;
        if (b.f7245a && (drawable = this.s) != null) {
            ((RippleDrawable) drawable).setColor(this.o);
            return;
        }
        j jVar = this.u;
        if (jVar != null) {
            jVar.n0(this.o);
        }
    }

    private float a() {
        return Math.max(Math.max(b(this.q.q(), this.f6923h.R()), b(this.q.s(), this.f6923h.S())), Math.max(b(this.q.k(), this.f6923h.u()), b(this.q.i(), this.f6923h.t())));
    }

    private float b(e eVar, float f2) {
        if (!(eVar instanceof n)) {
            if (eVar instanceof f) {
                return f2 / 2.0f;
            }
            return 0.0f;
        }
        double d2 = 1.0d - f6918c;
        double d3 = f2;
        Double.isNaN(d3);
        return (float) (d2 * d3);
    }

    private float c() {
        return this.f6921f.getMaxCardElevation() + (S() ? a() : 0.0f);
    }

    private float d() {
        return (this.f6921f.getMaxCardElevation() * f6919d) + (S() ? a() : 0.0f);
    }

    private boolean e() {
        return Build.VERSION.SDK_INT >= 21 && this.f6923h.d0();
    }

    @NonNull
    private Drawable f() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = this.n;
        if (drawable != null) {
            stateListDrawable.addState(f6916a, drawable);
        }
        return stateListDrawable;
    }

    @NonNull
    private Drawable g() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        j i2 = i();
        this.u = i2;
        i2.n0(this.o);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, this.u);
        return stateListDrawable;
    }

    @NonNull
    private Drawable h() {
        if (!b.f7245a) {
            return g();
        }
        this.v = i();
        return new RippleDrawable(this.o, null, this.v);
    }

    @NonNull
    private j i() {
        return new j(this.q);
    }

    @NonNull
    private Drawable p() {
        if (this.s == null) {
            this.s = h();
        }
        if (this.t == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.s, this.f6924i, f()});
            this.t = layerDrawable;
            layerDrawable.setId(2, com.google.android.material.R.id.mtrl_card_checked_layer_id);
        }
        return this.t;
    }

    private float r() {
        if (!this.f6921f.getPreventCornerOverlap()) {
            return 0.0f;
        }
        if (Build.VERSION.SDK_INT >= 21 && !this.f6921f.getUseCompatPadding()) {
            return 0.0f;
        }
        double d2 = 1.0d - f6918c;
        double cardViewRadius = this.f6921f.getCardViewRadius();
        Double.isNaN(cardViewRadius);
        return (float) (d2 * cardViewRadius);
    }

    @NonNull
    private Drawable z(Drawable drawable) {
        int ceil;
        int i2;
        if ((Build.VERSION.SDK_INT < 21) || this.f6921f.getUseCompatPadding()) {
            int ceil2 = (int) Math.ceil(d());
            ceil = (int) Math.ceil(c());
            i2 = ceil2;
        } else {
            ceil = 0;
            i2 = 0;
        }
        return new C0084a(drawable, ceil, i2, ceil, i2);
    }

    boolean A() {
        return this.w;
    }

    boolean B() {
        return this.x;
    }

    void C(@NonNull TypedArray typedArray) {
        ColorStateList a2 = c.a(this.f6921f.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_strokeColor);
        this.r = a2;
        if (a2 == null) {
            this.r = ColorStateList.valueOf(-1);
        }
        this.l = typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_strokeWidth, 0);
        boolean z = typedArray.getBoolean(com.google.android.material.R.styleable.MaterialCardView_android_checkable, false);
        this.x = z;
        this.f6921f.setLongClickable(z);
        this.p = c.a(this.f6921f.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_checkedIconTint);
        I(c.d(this.f6921f.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_checkedIcon));
        ColorStateList a3 = c.a(this.f6921f.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_rippleColor);
        this.o = a3;
        if (a3 == null) {
            this.o = ColorStateList.valueOf(com.google.android.material.c.a.d(this.f6921f, com.google.android.material.R.attr.colorControlHighlight));
        }
        G(c.a(this.f6921f.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_cardForegroundColor));
        Y();
        V();
        Z();
        this.f6921f.setBackgroundInternal(z(this.f6923h));
        Drawable p = this.f6921f.isClickable() ? p() : this.f6924i;
        this.m = p;
        this.f6921f.setForeground(z(p));
    }

    void D(int i2, int i3) {
        int i4;
        int i5;
        if (this.t != null) {
            int i6 = this.f6925j;
            int i7 = this.k;
            int i8 = (i2 - i6) - i7;
            int i9 = (i3 - i6) - i7;
            if ((Build.VERSION.SDK_INT < 21) || this.f6921f.getUseCompatPadding()) {
                i9 -= (int) Math.ceil(d() * 2.0f);
                i8 -= (int) Math.ceil(c() * 2.0f);
            }
            int i10 = i9;
            int i11 = this.f6925j;
            if (ViewCompat.getLayoutDirection(this.f6921f) == 1) {
                i5 = i8;
                i4 = i11;
            } else {
                i4 = i8;
                i5 = i11;
            }
            this.t.setLayerInset(2, i4, this.f6925j, i5, i10);
        }
    }

    void E(boolean z) {
        this.w = z;
    }

    void F(ColorStateList colorStateList) {
        this.f6923h.n0(colorStateList);
    }

    void G(@Nullable ColorStateList colorStateList) {
        j jVar = this.f6924i;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        jVar.n0(colorStateList);
    }

    void H(boolean z) {
        this.x = z;
    }

    void I(@Nullable Drawable drawable) {
        this.n = drawable;
        if (drawable != null) {
            Drawable wrap = DrawableCompat.wrap(drawable.mutate());
            this.n = wrap;
            DrawableCompat.setTintList(wrap, this.p);
        }
        if (this.t != null) {
            this.t.setDrawableByLayerId(com.google.android.material.R.id.mtrl_card_checked_layer_id, f());
        }
    }

    void J(@Nullable ColorStateList colorStateList) {
        this.p = colorStateList;
        Drawable drawable = this.n;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        }
    }

    void K(float f2) {
        N(this.q.w(f2));
        this.m.invalidateSelf();
        if (S() || R()) {
            U();
        }
        if (S()) {
            X();
        }
    }

    void L(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f6923h.o0(f2);
        j jVar = this.f6924i;
        if (jVar != null) {
            jVar.o0(f2);
        }
        j jVar2 = this.v;
        if (jVar2 != null) {
            jVar2.o0(f2);
        }
    }

    void M(@Nullable ColorStateList colorStateList) {
        this.o = colorStateList;
        Y();
    }

    void N(@NonNull o oVar) {
        this.q = oVar;
        this.f6923h.setShapeAppearanceModel(oVar);
        this.f6923h.t0(!r0.d0());
        j jVar = this.f6924i;
        if (jVar != null) {
            jVar.setShapeAppearanceModel(oVar);
        }
        j jVar2 = this.v;
        if (jVar2 != null) {
            jVar2.setShapeAppearanceModel(oVar);
        }
        j jVar3 = this.u;
        if (jVar3 != null) {
            jVar3.setShapeAppearanceModel(oVar);
        }
    }

    void O(ColorStateList colorStateList) {
        if (this.r == colorStateList) {
            return;
        }
        this.r = colorStateList;
        Z();
    }

    void P(@Dimension int i2) {
        if (i2 == this.l) {
            return;
        }
        this.l = i2;
        Z();
    }

    void Q(int i2, int i3, int i4, int i5) {
        this.f6922g.set(i2, i3, i4, i5);
        U();
    }

    void T() {
        Drawable drawable = this.m;
        Drawable p = this.f6921f.isClickable() ? p() : this.f6924i;
        this.m = p;
        if (drawable != p) {
            W(p);
        }
    }

    void U() {
        int a2 = (int) ((R() || S() ? a() : 0.0f) - r());
        MaterialCardView materialCardView = this.f6921f;
        Rect rect = this.f6922g;
        materialCardView.m(rect.left + a2, rect.top + a2, rect.right + a2, rect.bottom + a2);
    }

    void V() {
        this.f6923h.m0(this.f6921f.getCardElevation());
    }

    void X() {
        if (!A()) {
            this.f6921f.setBackgroundInternal(z(this.f6923h));
        }
        this.f6921f.setForeground(z(this.m));
    }

    void Z() {
        this.f6924i.D0(this.l, this.r);
    }

    @RequiresApi(api = 23)
    void j() {
        Drawable drawable = this.s;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i2 = bounds.bottom;
            this.s.setBounds(bounds.left, bounds.top, bounds.right, i2 - 1);
            this.s.setBounds(bounds.left, bounds.top, bounds.right, i2);
        }
    }

    @NonNull
    j k() {
        return this.f6923h;
    }

    ColorStateList l() {
        return this.f6923h.y();
    }

    ColorStateList m() {
        return this.f6924i.y();
    }

    @Nullable
    Drawable n() {
        return this.n;
    }

    @Nullable
    ColorStateList o() {
        return this.p;
    }

    float q() {
        return this.f6923h.R();
    }

    @FloatRange(from = f6918c, to = 1.0d)
    float s() {
        return this.f6923h.z();
    }

    @Nullable
    ColorStateList t() {
        return this.o;
    }

    o u() {
        return this.q;
    }

    @ColorInt
    int v() {
        ColorStateList colorStateList = this.r;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    @Nullable
    ColorStateList w() {
        return this.r;
    }

    @Dimension
    int x() {
        return this.l;
    }

    @NonNull
    Rect y() {
        return this.f6922g;
    }
}
