package com.vivo.mobilead.lottie.a;

import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* loaded from: classes4.dex */
public final class c {
    public static Interpolator a(float f2, float f3, float f4, float f5) {
        return Build.VERSION.SDK_INT >= 21 ? new PathInterpolator(f2, f3, f4, f5) : new b(f2, f3, f4, f5);
    }
}
