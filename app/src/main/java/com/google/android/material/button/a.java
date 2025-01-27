package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.g.c;
import com.google.android.material.h.b;
import com.google.android.material.internal.u;
import com.google.android.material.j.j;
import com.google.android.material.j.o;
import com.google.android.material.j.s;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
class a {

    /* renamed from: a */
    private static final boolean f6900a;

    /* renamed from: b */
    private final MaterialButton f6901b;

    /* renamed from: c */
    @NonNull
    private o f6902c;

    /* renamed from: d */
    private int f6903d;

    /* renamed from: e */
    private int f6904e;

    /* renamed from: f */
    private int f6905f;

    /* renamed from: g */
    private int f6906g;

    /* renamed from: h */
    private int f6907h;

    /* renamed from: i */
    private int f6908i;

    /* renamed from: j */
    @Nullable
    private PorterDuff.Mode f6909j;

    @Nullable
    private ColorStateList k;

    @Nullable
    private ColorStateList l;

    @Nullable
    private ColorStateList m;

    @Nullable
    private Drawable n;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private boolean r;
    private LayerDrawable s;

    static {
        f6900a = Build.VERSION.SDK_INT >= 21;
    }

    a(MaterialButton materialButton, @NonNull o oVar) {
        this.f6901b = materialButton;
        this.f6902c = oVar;
    }

    private void A(@NonNull o oVar) {
        if (d() != null) {
            d().setShapeAppearanceModel(oVar);
        }
        if (l() != null) {
            l().setShapeAppearanceModel(oVar);
        }
        if (c() != null) {
            c().setShapeAppearanceModel(oVar);
        }
    }

    private void C() {
        j d2 = d();
        j l = l();
        if (d2 != null) {
            d2.D0(this.f6908i, this.l);
            if (l != null) {
                l.C0(this.f6908i, this.o ? com.google.android.material.c.a.d(this.f6901b, R.attr.colorSurface) : 0);
            }
        }
    }

    @NonNull
    private InsetDrawable D(Drawable drawable) {
        return new InsetDrawable(drawable, this.f6903d, this.f6905f, this.f6904e, this.f6906g);
    }

    private Drawable a() {
        j jVar = new j(this.f6902c);
        jVar.Y(this.f6901b.getContext());
        DrawableCompat.setTintList(jVar, this.k);
        PorterDuff.Mode mode = this.f6909j;
        if (mode != null) {
            DrawableCompat.setTintMode(jVar, mode);
        }
        jVar.D0(this.f6908i, this.l);
        j jVar2 = new j(this.f6902c);
        jVar2.setTint(0);
        jVar2.C0(this.f6908i, this.o ? com.google.android.material.c.a.d(this.f6901b, R.attr.colorSurface) : 0);
        if (f6900a) {
            j jVar3 = new j(this.f6902c);
            this.n = jVar3;
            DrawableCompat.setTint(jVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(b.d(this.m), D(new LayerDrawable(new Drawable[]{jVar2, jVar})), this.n);
            this.s = rippleDrawable;
            return rippleDrawable;
        }
        com.google.android.material.h.a aVar = new com.google.android.material.h.a(this.f6902c);
        this.n = aVar;
        DrawableCompat.setTintList(aVar, b.d(this.m));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{jVar2, jVar, this.n});
        this.s = layerDrawable;
        return D(layerDrawable);
    }

    @Nullable
    private j e(boolean z) {
        LayerDrawable layerDrawable = this.s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return f6900a ? (j) ((LayerDrawable) ((InsetDrawable) this.s.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0) : (j) this.s.getDrawable(!z ? 1 : 0);
    }

    @Nullable
    private j l() {
        return e(true);
    }

    void B(int i2, int i3) {
        Drawable drawable = this.n;
        if (drawable != null) {
            drawable.setBounds(this.f6903d, this.f6905f, i3 - this.f6904e, i2 - this.f6906g);
        }
    }

    int b() {
        return this.f6907h;
    }

    @Nullable
    public s c() {
        LayerDrawable layerDrawable = this.s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.s.getNumberOfLayers() > 2 ? (s) this.s.getDrawable(2) : (s) this.s.getDrawable(1);
    }

    @Nullable
    j d() {
        return e(false);
    }

    @Nullable
    ColorStateList f() {
        return this.m;
    }

    @NonNull
    o g() {
        return this.f6902c;
    }

    @Nullable
    ColorStateList h() {
        return this.l;
    }

    int i() {
        return this.f6908i;
    }

    ColorStateList j() {
        return this.k;
    }

    PorterDuff.Mode k() {
        return this.f6909j;
    }

    boolean m() {
        return this.p;
    }

    boolean n() {
        return this.r;
    }

    void o(@NonNull TypedArray typedArray) {
        this.f6903d = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
        this.f6904e = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
        this.f6905f = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
        this.f6906g = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
        int i2 = R.styleable.MaterialButton_cornerRadius;
        if (typedArray.hasValue(i2)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i2, -1);
            this.f6907h = dimensionPixelSize;
            u(this.f6902c.w(dimensionPixelSize));
            this.q = true;
        }
        this.f6908i = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
        this.f6909j = u.j(typedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.k = c.a(this.f6901b.getContext(), typedArray, R.styleable.MaterialButton_backgroundTint);
        this.l = c.a(this.f6901b.getContext(), typedArray, R.styleable.MaterialButton_strokeColor);
        this.m = c.a(this.f6901b.getContext(), typedArray, R.styleable.MaterialButton_rippleColor);
        this.r = typedArray.getBoolean(R.styleable.MaterialButton_android_checkable, false);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_elevation, 0);
        int paddingStart = ViewCompat.getPaddingStart(this.f6901b);
        int paddingTop = this.f6901b.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.f6901b);
        int paddingBottom = this.f6901b.getPaddingBottom();
        if (typedArray.hasValue(R.styleable.MaterialButton_android_background)) {
            q();
        } else {
            this.f6901b.setInternalBackground(a());
            j d2 = d();
            if (d2 != null) {
                d2.m0(dimensionPixelSize2);
            }
        }
        ViewCompat.setPaddingRelative(this.f6901b, paddingStart + this.f6903d, paddingTop + this.f6905f, paddingEnd + this.f6904e, paddingBottom + this.f6906g);
    }

    void p(int i2) {
        if (d() != null) {
            d().setTint(i2);
        }
    }

    void q() {
        this.p = true;
        this.f6901b.setSupportBackgroundTintList(this.k);
        this.f6901b.setSupportBackgroundTintMode(this.f6909j);
    }

    void r(boolean z) {
        this.r = z;
    }

    void s(int i2) {
        if (this.q && this.f6907h == i2) {
            return;
        }
        this.f6907h = i2;
        this.q = true;
        u(this.f6902c.w(i2));
    }

    void t(@Nullable ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            boolean z = f6900a;
            if (z && (this.f6901b.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f6901b.getBackground()).setColor(b.d(colorStateList));
            } else {
                if (z || !(this.f6901b.getBackground() instanceof com.google.android.material.h.a)) {
                    return;
                }
                ((com.google.android.material.h.a) this.f6901b.getBackground()).setTintList(b.d(colorStateList));
            }
        }
    }

    void u(@NonNull o oVar) {
        this.f6902c = oVar;
        A(oVar);
    }

    void v(boolean z) {
        this.o = z;
        C();
    }

    void w(@Nullable ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            C();
        }
    }

    void x(int i2) {
        if (this.f6908i != i2) {
            this.f6908i = i2;
            C();
        }
    }

    void y(@Nullable ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            if (d() != null) {
                DrawableCompat.setTintList(d(), this.k);
            }
        }
    }

    void z(@Nullable PorterDuff.Mode mode) {
        if (this.f6909j != mode) {
            this.f6909j = mode;
            if (d() == null || this.f6909j == null) {
                return;
            }
            DrawableCompat.setTintMode(d(), this.f6909j);
        }
    }
}
