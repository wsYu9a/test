package com.google.android.material.h;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.j.j;
import com.google.android.material.j.o;
import com.google.android.material.j.s;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class a extends Drawable implements s, TintAwareDrawable {

    /* renamed from: a */
    private b f7242a;

    /* synthetic */ a(b bVar, C0092a c0092a) {
        this(bVar);
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    /* renamed from: a */
    public a mutate() {
        this.f7242a = new b(this.f7242a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f7242a;
        if (bVar.f7244b) {
            bVar.f7243a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f7242a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f7242a.f7243a.getOpacity();
    }

    @Override // com.google.android.material.j.s
    @NonNull
    public o getShapeAppearanceModel() {
        return this.f7242a.f7243a.getShapeAppearanceModel();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.f7242a.f7243a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(@NonNull int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.f7242a.f7243a.setState(iArr)) {
            onStateChange = true;
        }
        boolean e2 = com.google.android.material.h.b.e(iArr);
        b bVar = this.f7242a;
        if (bVar.f7244b == e2) {
            return onStateChange;
        }
        bVar.f7244b = e2;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f7242a.f7243a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f7242a.f7243a.setColorFilter(colorFilter);
    }

    @Override // com.google.android.material.j.s
    public void setShapeAppearanceModel(@NonNull o oVar) {
        this.f7242a.f7243a.setShapeAppearanceModel(oVar);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int i2) {
        this.f7242a.f7243a.setTint(i2);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.f7242a.f7243a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        this.f7242a.f7243a.setTintMode(mode);
    }

    public a(o oVar) {
        this(new b(new j(oVar)));
    }

    static final class b extends Drawable.ConstantState {

        /* renamed from: a */
        @NonNull
        j f7243a;

        /* renamed from: b */
        boolean f7244b;

        public b(j jVar) {
            this.f7243a = jVar;
            this.f7244b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        /* renamed from: a */
        public a newDrawable() {
            return new a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public b(@NonNull b bVar) {
            this.f7243a = (j) bVar.f7243a.getConstantState().newDrawable();
            this.f7244b = bVar.f7244b;
        }
    }

    private a(b bVar) {
        this.f7242a = bVar;
    }
}
