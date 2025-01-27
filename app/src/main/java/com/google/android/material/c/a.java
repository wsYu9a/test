package com.google.android.material.c;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.g.b;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    public static final float f6910a = 1.0f;

    /* renamed from: b */
    public static final float f6911b = 0.54f;

    /* renamed from: c */
    public static final float f6912c = 0.38f;

    /* renamed from: d */
    public static final float f6913d = 0.32f;

    /* renamed from: e */
    public static final float f6914e = 0.12f;

    private a() {
    }

    @ColorInt
    public static int a(@ColorInt int i2, @IntRange(from = 0, to = 255) int i3) {
        return ColorUtils.setAlphaComponent(i2, (Color.alpha(i2) * i3) / 255);
    }

    @ColorInt
    public static int b(@NonNull Context context, @AttrRes int i2, @ColorInt int i3) {
        TypedValue a2 = b.a(context, i2);
        return a2 != null ? a2.data : i3;
    }

    @ColorInt
    public static int c(Context context, @AttrRes int i2, String str) {
        return b.f(context, i2, str);
    }

    @ColorInt
    public static int d(@NonNull View view, @AttrRes int i2) {
        return b.g(view, i2);
    }

    @ColorInt
    public static int e(@NonNull View view, @AttrRes int i2, @ColorInt int i3) {
        return b(view.getContext(), i2, i3);
    }

    @ColorInt
    public static int f(@ColorInt int i2, @ColorInt int i3) {
        return ColorUtils.compositeColors(i3, i2);
    }

    @ColorInt
    public static int g(@ColorInt int i2, @ColorInt int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return f(i2, ColorUtils.setAlphaComponent(i3, Math.round(Color.alpha(i3) * f2)));
    }

    @ColorInt
    public static int h(@NonNull View view, @AttrRes int i2, @AttrRes int i3) {
        return i(view, i2, i3, 1.0f);
    }

    @ColorInt
    public static int i(@NonNull View view, @AttrRes int i2, @AttrRes int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return g(d(view, i2), d(view, i3), f2);
    }
}
