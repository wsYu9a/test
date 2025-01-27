package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.c.a;
import com.google.android.material.g.b;
import com.google.android.material.internal.u;

/* loaded from: classes.dex */
public class ElevationOverlayProvider {

    /* renamed from: a */
    private static final float f7132a = 4.5f;

    /* renamed from: b */
    private static final float f7133b = 2.0f;

    /* renamed from: c */
    private final boolean f7134c;

    /* renamed from: d */
    private final int f7135d;

    /* renamed from: e */
    private final int f7136e;

    /* renamed from: f */
    private final float f7137f;

    public ElevationOverlayProvider(@NonNull Context context) {
        this.f7134c = b.b(context, R.attr.elevationOverlayEnabled, false);
        this.f7135d = a.b(context, R.attr.elevationOverlayColor, 0);
        this.f7136e = a.b(context, R.attr.colorSurface, 0);
        this.f7137f = context.getResources().getDisplayMetrics().density;
    }

    private boolean m(@ColorInt int i2) {
        return ColorUtils.setAlphaComponent(i2, 255) == this.f7136e;
    }

    public int a(float f2) {
        return Math.round(b(f2) * 255.0f);
    }

    public float b(float f2) {
        if (this.f7137f <= 0.0f || f2 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f2 / r0)) * f7132a) + f7133b) / 100.0f, 1.0f);
    }

    @ColorInt
    public int c(@ColorInt int i2, float f2) {
        float b2 = b(f2);
        return ColorUtils.setAlphaComponent(a.g(ColorUtils.setAlphaComponent(i2, 255), this.f7135d, b2), Color.alpha(i2));
    }

    @ColorInt
    public int d(@ColorInt int i2, float f2, @NonNull View view) {
        return c(i2, f2 + i(view));
    }

    @ColorInt
    public int e(@ColorInt int i2, float f2) {
        return (this.f7134c && m(i2)) ? c(i2, f2) : i2;
    }

    @ColorInt
    public int f(@ColorInt int i2, float f2, @NonNull View view) {
        return e(i2, f2 + i(view));
    }

    @ColorInt
    public int g(float f2) {
        return e(this.f7136e, f2);
    }

    @ColorInt
    public int h(float f2, @NonNull View view) {
        return g(f2 + i(view));
    }

    public float i(@NonNull View view) {
        return u.h(view);
    }

    @ColorInt
    public int j() {
        return this.f7135d;
    }

    @ColorInt
    public int k() {
        return this.f7136e;
    }

    public boolean l() {
        return this.f7134c;
    }
}
