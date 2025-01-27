package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a */
    @NonNull
    private final Rect f7018a;

    /* renamed from: b */
    private final ColorStateList f7019b;

    /* renamed from: c */
    private final ColorStateList f7020c;

    /* renamed from: d */
    private final ColorStateList f7021d;

    /* renamed from: e */
    private final int f7022e;

    /* renamed from: f */
    private final com.google.android.material.j.o f7023f;

    private b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i2, com.google.android.material.j.o oVar, @NonNull Rect rect) {
        Preconditions.checkArgumentNonnegative(rect.left);
        Preconditions.checkArgumentNonnegative(rect.top);
        Preconditions.checkArgumentNonnegative(rect.right);
        Preconditions.checkArgumentNonnegative(rect.bottom);
        this.f7018a = rect;
        this.f7019b = colorStateList2;
        this.f7020c = colorStateList;
        this.f7021d = colorStateList3;
        this.f7022e = i2;
        this.f7023f = oVar;
    }

    @NonNull
    static b a(@NonNull Context context, @StyleRes int i2) {
        Preconditions.checkArgument(i2 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.MaterialCalendarItem);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList a2 = com.google.android.material.g.c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList a3 = com.google.android.material.g.c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList a4 = com.google.android.material.g.c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        com.google.android.material.j.o m = com.google.android.material.j.o.b(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).m();
        obtainStyledAttributes.recycle();
        return new b(a2, a3, a4, dimensionPixelSize, m, rect);
    }

    int b() {
        return this.f7018a.bottom;
    }

    int c() {
        return this.f7018a.left;
    }

    int d() {
        return this.f7018a.right;
    }

    int e() {
        return this.f7018a.top;
    }

    void f(@NonNull TextView textView) {
        com.google.android.material.j.j jVar = new com.google.android.material.j.j();
        com.google.android.material.j.j jVar2 = new com.google.android.material.j.j();
        jVar.setShapeAppearanceModel(this.f7023f);
        jVar2.setShapeAppearanceModel(this.f7023f);
        jVar.n0(this.f7020c);
        jVar.D0(this.f7022e, this.f7021d);
        textView.setTextColor(this.f7019b);
        Drawable rippleDrawable = Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(this.f7019b.withAlpha(30), jVar, jVar2) : jVar;
        Rect rect = this.f7018a;
        ViewCompat.setBackground(textView, new InsetDrawable(rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
