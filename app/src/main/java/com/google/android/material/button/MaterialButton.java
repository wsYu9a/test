package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.j.k;
import com.google.android.material.j.o;
import com.google.android.material.j.s;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public class MaterialButton extends AppCompatButton implements Checkable, s {

    /* renamed from: e */
    public static final int f6874e = 1;

    /* renamed from: f */
    public static final int f6875f = 2;

    /* renamed from: g */
    public static final int f6876g = 3;

    /* renamed from: h */
    public static final int f6877h = 4;

    /* renamed from: i */
    private static final String f6878i = "MaterialButton";

    @NonNull
    private final com.google.android.material.button.a k;

    @NonNull
    private final LinkedHashSet<b> l;

    @Nullable
    private c m;

    @Nullable
    private PorterDuff.Mode n;

    @Nullable
    private ColorStateList o;

    @Nullable
    private Drawable p;

    @Px
    private int q;

    @Px
    private int r;

    @Px
    private int s;
    private boolean t;
    private boolean u;
    private int v;

    /* renamed from: c */
    private static final int[] f6872c = {R.attr.state_checkable};

    /* renamed from: d */
    private static final int[] f6873d = {R.attr.state_checked};

    /* renamed from: j */
    private static final int f6879j = com.google.android.material.R.style.Widget_MaterialComponents_Button;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public interface b {
        void a(MaterialButton materialButton, boolean z);
    }

    interface c {
        void a(MaterialButton materialButton, boolean z);
    }

    static class d extends AbsSavedState {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: b */
        boolean f6880b;

        static class a implements Parcelable.ClassLoaderCreator<d> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: a */
            public d createFromParcel(@NonNull Parcel parcel) {
                return new d(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: b */
            public d createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: c */
            public d[] newArray(int i2) {
                return new d[i2];
            }
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(@NonNull Parcel parcel) {
            this.f6880b = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f6880b ? 1 : 0);
        }

        public d(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            a(parcel);
        }
    }

    public MaterialButton(@NonNull Context context) {
        this(context, null);
    }

    private boolean d() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    private boolean e() {
        com.google.android.material.button.a aVar = this.k;
        return (aVar == null || aVar.m()) ? false : true;
    }

    private void g(boolean z) {
        if (z) {
            TextViewCompat.setCompoundDrawablesRelative(this, this.p, null, null, null);
        } else {
            TextViewCompat.setCompoundDrawablesRelative(this, null, null, this.p, null);
        }
    }

    @NonNull
    private String getA11yClassName() {
        return (c() ? CompoundButton.class : Button.class).getName();
    }

    private void h(boolean z) {
        Drawable drawable = this.p;
        boolean z2 = false;
        if (drawable != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.p = mutate;
            DrawableCompat.setTintList(mutate, this.o);
            PorterDuff.Mode mode = this.n;
            if (mode != null) {
                DrawableCompat.setTintMode(this.p, mode);
            }
            int i2 = this.q;
            if (i2 == 0) {
                i2 = this.p.getIntrinsicWidth();
            }
            int i3 = this.q;
            if (i3 == 0) {
                i3 = this.p.getIntrinsicHeight();
            }
            Drawable drawable2 = this.p;
            int i4 = this.r;
            drawable2.setBounds(i4, 0, i2 + i4, i3);
        }
        int i5 = this.v;
        boolean z3 = i5 == 1 || i5 == 2;
        if (z) {
            g(z3);
            return;
        }
        Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this);
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[2];
        if ((z3 && drawable3 != this.p) || (!z3 && drawable4 != this.p)) {
            z2 = true;
        }
        if (z2) {
            g(z3);
        }
    }

    private void i() {
        if (this.p == null || getLayout() == null) {
            return;
        }
        int i2 = this.v;
        if (i2 == 1 || i2 == 3) {
            this.r = 0;
            h(false);
            return;
        }
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        int min = Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
        int i3 = this.q;
        if (i3 == 0) {
            i3 = this.p.getIntrinsicWidth();
        }
        int measuredWidth = (((((getMeasuredWidth() - min) - ViewCompat.getPaddingEnd(this)) - i3) - this.s) - ViewCompat.getPaddingStart(this)) / 2;
        if (d() != (this.v == 4)) {
            measuredWidth = -measuredWidth;
        }
        if (this.r != measuredWidth) {
            this.r = measuredWidth;
            h(false);
        }
    }

    public void a(@NonNull b bVar) {
        this.l.add(bVar);
    }

    public void b() {
        this.l.clear();
    }

    public boolean c() {
        com.google.android.material.button.a aVar = this.k;
        return aVar != null && aVar.n();
    }

    public void f(@NonNull b bVar) {
        this.l.remove(bVar);
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Px
    public int getCornerRadius() {
        if (e()) {
            return this.k.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.p;
    }

    public int getIconGravity() {
        return this.v;
    }

    @Px
    public int getIconPadding() {
        return this.s;
    }

    @Px
    public int getIconSize() {
        return this.q;
    }

    public ColorStateList getIconTint() {
        return this.o;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.n;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (e()) {
            return this.k.f();
        }
        return null;
    }

    @Override // com.google.android.material.j.s
    @NonNull
    public o getShapeAppearanceModel() {
        if (e()) {
            return this.k.g();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (e()) {
            return this.k.h();
        }
        return null;
    }

    @Px
    public int getStrokeWidth() {
        if (e()) {
            return this.k.i();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        return e() ? this.k.j() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return e() ? this.k.k() : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.t;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (e()) {
            k.f(this, this.k.d());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (c()) {
            Button.mergeDrawableStates(onCreateDrawableState, f6872c);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(onCreateDrawableState, f6873d);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(c());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        com.google.android.material.button.a aVar;
        super.onLayout(z, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT != 21 || (aVar = this.k) == null) {
            return;
        }
        aVar.B(i5 - i3, i4 - i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        i();
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        setChecked(dVar.f6880b);
    }

    @Override // android.widget.TextView, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f6880b = this.t;
        return dVar;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        i();
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i2) {
        if (e()) {
            this.k.p(i2);
        } else {
            super.setBackgroundColor(i2);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (!e()) {
            super.setBackgroundDrawable(drawable);
        } else {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            Log.w(f6878i, "Do not set the background; MaterialButton manages its own background drawable.");
            this.k.q();
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        setBackgroundDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (e()) {
            this.k.r(z);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (c() && isEnabled() && this.t != z) {
            this.t = z;
            refreshDrawableState();
            if (this.u) {
                return;
            }
            this.u = true;
            Iterator<b> it = this.l.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.t);
            }
            this.u = false;
        }
    }

    public void setCornerRadius(@Px int i2) {
        if (e()) {
            this.k.s(i2);
        }
    }

    public void setCornerRadiusResource(@DimenRes int i2) {
        if (e()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        if (e()) {
            this.k.d().m0(f2);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.p != drawable) {
            this.p = drawable;
            h(true);
        }
    }

    public void setIconGravity(int i2) {
        if (this.v != i2) {
            this.v = i2;
            i();
        }
    }

    public void setIconPadding(@Px int i2) {
        if (this.s != i2) {
            this.s = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(@DrawableRes int i2) {
        setIcon(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    public void setIconSize(@Px int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.q != i2) {
            this.q = i2;
            h(true);
        }
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.o != colorStateList) {
            this.o = colorStateList;
            h(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.n != mode) {
            this.n = mode;
            h(false);
        }
    }

    public void setIconTintResource(@ColorRes int i2) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), i2));
    }

    void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    void setOnPressedChangeListenerInternal(@Nullable c cVar) {
        this.m = cVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        c cVar = this.m;
        if (cVar != null) {
            cVar.a(this, z);
        }
        super.setPressed(z);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (e()) {
            this.k.t(colorStateList);
        }
    }

    public void setRippleColorResource(@ColorRes int i2) {
        if (e()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    @Override // com.google.android.material.j.s
    public void setShapeAppearanceModel(@NonNull o oVar) {
        if (!e()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.k.u(oVar);
    }

    void setShouldDrawSurfaceColorStroke(boolean z) {
        if (e()) {
            this.k.v(z);
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (e()) {
            this.k.w(colorStateList);
        }
    }

    public void setStrokeColorResource(@ColorRes int i2) {
        if (e()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    public void setStrokeWidth(@Px int i2) {
        if (e()) {
            this.k.x(i2);
        }
    }

    public void setStrokeWidthResource(@DimenRes int i2) {
        if (e()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (e()) {
            this.k.y(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (e()) {
            this.k.z(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.t);
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.materialButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialButton(@androidx.annotation.NonNull android.content.Context r9, @androidx.annotation.Nullable android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r6 = com.google.android.material.button.MaterialButton.f6879j
            android.content.Context r9 = com.google.android.material.theme.a.a.c(r9, r10, r11, r6)
            r8.<init>(r9, r10, r11)
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.l = r9
            r9 = 0
            r8.t = r9
            r8.u = r9
            android.content.Context r7 = r8.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialButton
            int[] r5 = new int[r9]
            r0 = r7
            r1 = r10
            r3 = r11
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.n.j(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconPadding
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.s = r1
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconTintMode
            r2 = -1
            int r1 = r0.getInt(r1, r2)
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r1 = com.google.android.material.internal.u.j(r1, r2)
            r8.n = r1
            android.content.Context r1 = r8.getContext()
            int r2 = com.google.android.material.R.styleable.MaterialButton_iconTint
            android.content.res.ColorStateList r1 = com.google.android.material.g.c.a(r1, r0, r2)
            r8.o = r1
            android.content.Context r1 = r8.getContext()
            int r2 = com.google.android.material.R.styleable.MaterialButton_icon
            android.graphics.drawable.Drawable r1 = com.google.android.material.g.c.d(r1, r0, r2)
            r8.p = r1
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconGravity
            r2 = 1
            int r1 = r0.getInteger(r1, r2)
            r8.v = r1
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconSize
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.q = r1
            com.google.android.material.j.o$b r10 = com.google.android.material.j.o.e(r7, r10, r11, r6)
            com.google.android.material.j.o r10 = r10.m()
            com.google.android.material.button.a r11 = new com.google.android.material.button.a
            r11.<init>(r8, r10)
            r8.k = r11
            r11.o(r0)
            r0.recycle()
            int r10 = r8.s
            r8.setCompoundDrawablePadding(r10)
            android.graphics.drawable.Drawable r10 = r8.p
            if (r10 == 0) goto L84
            r9 = 1
        L84:
            r8.h(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
