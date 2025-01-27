package com.czhj.sdk.common.utils;

import android.content.Context;
import android.util.TypedValue;

/* loaded from: classes2.dex */
public class Dips {
    public static float a(float f10, Context context) {
        return TypedValue.applyDimension(1, f10, context.getResources().getDisplayMetrics());
    }

    public static int asIntPixels(float f10, Context context) {
        if (f10 == 0.0f || context == null) {
            return 0;
        }
        return (int) (a(f10, context) + 0.5f);
    }

    public static float b(float f10, Context context) {
        return f10 * getDensity(context);
    }

    public static float c(float f10, Context context) {
        return f10 / getDensity(context);
    }

    public static int dipsToIntPixels(float f10, Context context) {
        if (f10 == 0.0f || context == null) {
            return 0;
        }
        return (int) (b(f10, context) + 0.5f);
    }

    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int pixelsToIntDips(float f10, Context context) {
        if (f10 == 0.0f || context == null) {
            return 0;
        }
        return (int) (c(f10, context) + 0.5f);
    }

    public static int screenHeightAsIntDips(Context context) {
        if (context == null) {
            return 0;
        }
        return pixelsToIntDips(context.getResources().getDisplayMetrics().heightPixels, context);
    }

    public static int screenWidthAsIntDips(Context context) {
        if (context == null) {
            return 0;
        }
        return pixelsToIntDips(context.getResources().getDisplayMetrics().widthPixels, context);
    }
}
