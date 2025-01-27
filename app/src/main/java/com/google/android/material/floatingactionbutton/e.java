package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.j.j;
import com.google.android.material.j.o;
import java.util.ArrayList;

@RequiresApi(21)
/* loaded from: classes.dex */
class e extends d {

    static class a extends j {
        a(o oVar) {
            super(oVar);
        }

        @Override // com.google.android.material.j.j, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    e(FloatingActionButton floatingActionButton, com.google.android.material.i.c cVar) {
        super(floatingActionButton, cVar);
    }

    @NonNull
    private Animator m0(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.R, "elevation", f2).setDuration(0L)).with(ObjectAnimator.ofFloat(this.R, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f3).setDuration(100L));
        animatorSet.setInterpolator(d.f7194a);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void A() {
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void C() {
        i0();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void E(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (!this.R.isEnabled()) {
                this.R.setElevation(0.0f);
                this.R.setTranslationZ(0.0f);
                return;
            }
            this.R.setElevation(this.A);
            if (this.R.isPressed()) {
                this.R.setTranslationZ(this.C);
            } else if (this.R.isFocused() || this.R.isHovered()) {
                this.R.setTranslationZ(this.B);
            } else {
                this.R.setTranslationZ(0.0f);
            }
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void F(float f2, float f3, float f4) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 21) {
            this.R.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(d.n, m0(f2, f4));
            stateListAnimator.addState(d.o, m0(f2, f3));
            stateListAnimator.addState(d.p, m0(f2, f3));
            stateListAnimator.addState(d.q, m0(f2, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.R, "elevation", f2).setDuration(0L));
            if (i2 >= 22 && i2 <= 24) {
                FloatingActionButton floatingActionButton = this.R;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.R, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(d.f7194a);
            stateListAnimator.addState(d.r, animatorSet);
            stateListAnimator.addState(d.s, m0(0.0f, 0.0f));
            this.R.setStateListAnimator(stateListAnimator);
        }
        if (c0()) {
            i0();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    boolean N() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void Y(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.v;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(com.google.android.material.h.b.d(colorStateList));
        } else {
            super.Y(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    boolean c0() {
        return this.S.a() || !e0();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void g0() {
    }

    @Override // com.google.android.material.floatingactionbutton.d
    @NonNull
    j j() {
        return new a((o) Preconditions.checkNotNull(this.t));
    }

    @NonNull
    c l0(int i2, ColorStateList colorStateList) {
        Context context = this.R.getContext();
        c cVar = new c((o) Preconditions.checkNotNull(this.t));
        cVar.f(ContextCompat.getColor(context, R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(context, R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_outer_color));
        cVar.e(i2);
        cVar.d(colorStateList);
        return cVar;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public float n() {
        return this.R.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void s(@NonNull Rect rect) {
        if (this.S.a()) {
            super.s(rect);
        } else if (e0()) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (this.D - this.R.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void x(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable drawable;
        j j2 = j();
        this.u = j2;
        j2.setTintList(colorStateList);
        if (mode != null) {
            this.u.setTintMode(mode);
        }
        this.u.Y(this.R.getContext());
        if (i2 > 0) {
            this.w = l0(i2, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.w), (Drawable) Preconditions.checkNotNull(this.u)});
        } else {
            this.w = null;
            drawable = this.u;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(com.google.android.material.h.b.d(colorStateList2), drawable, null);
        this.v = rippleDrawable;
        this.x = rippleDrawable;
    }
}
