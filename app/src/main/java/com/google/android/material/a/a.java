package com.google.android.material.a;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.RestrictTo;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    public static final TimeInterpolator f6607a = new LinearInterpolator();

    /* renamed from: b */
    public static final TimeInterpolator f6608b = new FastOutSlowInInterpolator();

    /* renamed from: c */
    public static final TimeInterpolator f6609c = new FastOutLinearInInterpolator();

    /* renamed from: d */
    public static final TimeInterpolator f6610d = new LinearOutSlowInInterpolator();

    /* renamed from: e */
    public static final TimeInterpolator f6611e = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int b(int i2, int i3, float f2) {
        return i2 + Math.round(f2 * (i3 - i2));
    }
}
