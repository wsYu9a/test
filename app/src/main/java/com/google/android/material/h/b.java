package com.google.android.material.h;

import android.R;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    public static final boolean f7245a;

    /* renamed from: b */
    private static final int[] f7246b;

    /* renamed from: c */
    private static final int[] f7247c;

    /* renamed from: d */
    private static final int[] f7248d;

    /* renamed from: e */
    private static final int[] f7249e;

    /* renamed from: f */
    private static final int[] f7250f;

    /* renamed from: g */
    private static final int[] f7251g;

    /* renamed from: h */
    private static final int[] f7252h;

    /* renamed from: i */
    private static final int[] f7253i;

    /* renamed from: j */
    private static final int[] f7254j;
    private static final int[] k;

    @VisibleForTesting
    static final String l;

    @VisibleForTesting
    static final String m = "Use a non-transparent color for the default color as it will be used to finish ripple animations.";

    static {
        f7245a = Build.VERSION.SDK_INT >= 21;
        f7246b = new int[]{R.attr.state_pressed};
        f7247c = new int[]{R.attr.state_hovered, R.attr.state_focused};
        f7248d = new int[]{R.attr.state_focused};
        f7249e = new int[]{R.attr.state_hovered};
        f7250f = new int[]{R.attr.state_selected, R.attr.state_pressed};
        f7251g = new int[]{R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};
        f7252h = new int[]{R.attr.state_selected, R.attr.state_focused};
        f7253i = new int[]{R.attr.state_selected, R.attr.state_hovered};
        f7254j = new int[]{R.attr.state_selected};
        k = new int[]{R.attr.state_enabled, R.attr.state_pressed};
        l = b.class.getSimpleName();
    }

    private b() {
    }

    @NonNull
    public static ColorStateList a(@Nullable ColorStateList colorStateList) {
        if (f7245a) {
            return new ColorStateList(new int[][]{f7254j, StateSet.NOTHING}, new int[]{c(colorStateList, f7250f), c(colorStateList, f7246b)});
        }
        int[] iArr = f7250f;
        int[] iArr2 = f7251g;
        int[] iArr3 = f7252h;
        int[] iArr4 = f7253i;
        int[] iArr5 = f7246b;
        int[] iArr6 = f7247c;
        int[] iArr7 = f7248d;
        int[] iArr8 = f7249e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, f7254j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{c(colorStateList, iArr), c(colorStateList, iArr2), c(colorStateList, iArr3), c(colorStateList, iArr4), 0, c(colorStateList, iArr5), c(colorStateList, iArr6), c(colorStateList, iArr7), c(colorStateList, iArr8), 0});
    }

    @ColorInt
    @TargetApi(21)
    private static int b(@ColorInt int i2) {
        return ColorUtils.setAlphaComponent(i2, Math.min(Color.alpha(i2) * 2, 255));
    }

    @ColorInt
    private static int c(@Nullable ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f7245a ? b(colorForState) : colorForState;
    }

    @NonNull
    public static ColorStateList d(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 22 && i2 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(k, 0)) != 0) {
            Log.w(l, m);
        }
        return colorStateList;
    }

    public static boolean e(@NonNull int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i2 : iArr) {
            if (i2 == 16842910) {
                z = true;
            } else if (i2 == 16842908 || i2 == 16842919 || i2 == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }
}
