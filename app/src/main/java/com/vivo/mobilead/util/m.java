package com.vivo.mobilead.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/* loaded from: classes4.dex */
public class m {
    private static DisplayMetrics a(Context context) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return null;
        }
        return resources.getDisplayMetrics();
    }

    public static int b(Context context, float f2) {
        DisplayMetrics a2 = a(context);
        return a2 == null ? (int) f2 : (int) TypedValue.applyDimension(1, f2, a2);
    }

    public static int c(Context context) {
        Configuration configuration;
        if (context == null || context.getResources() == null || (configuration = context.getResources().getConfiguration()) == null) {
            return 1;
        }
        return configuration.orientation;
    }

    public static int d(Context context) {
        int i2;
        if (com.vivo.mobilead.manager.f.j().c() != null) {
            try {
                i2 = com.vivo.mobilead.manager.f.j().c().getResources().getDisplayMetrics().heightPixels;
            } catch (Exception unused) {
            }
            if (i2 != 0 && context != null) {
                try {
                    return context.getResources().getDisplayMetrics().heightPixels;
                } catch (Exception unused2) {
                    return i2;
                }
            }
        }
        i2 = 0;
        return i2 != 0 ? i2 : i2;
    }

    public static int e(Context context) {
        int i2;
        if (com.vivo.mobilead.manager.f.j().c() != null) {
            try {
                i2 = com.vivo.mobilead.manager.f.j().c().getResources().getDisplayMetrics().widthPixels;
            } catch (Exception unused) {
            }
            if (i2 != 0 && context != null) {
                try {
                    return context.getResources().getDisplayMetrics().widthPixels;
                } catch (Exception unused2) {
                    return i2;
                }
            }
        }
        i2 = 0;
        return i2 != 0 ? i2 : i2;
    }

    public static int a(Context context, float f2) {
        DisplayMetrics a2 = a(context);
        return a2 == null ? (int) f2 : (int) ((f2 * a2.density) + 0.5f);
    }

    public static float b(Context context) {
        Configuration configuration;
        if (context == null) {
            return 1.0f;
        }
        int e2 = e(context);
        Resources resources = context.getResources();
        if (resources == null || (configuration = resources.getConfiguration()) == null) {
            return 1.0f;
        }
        float f2 = configuration.orientation == 1 ? 1080.0f : 2160.0f;
        if (e2 == 0) {
            return 1.0f;
        }
        return (e2 * 1.0f) / f2;
    }

    public static int c(Context context, float f2) {
        DisplayMetrics a2 = a(context);
        return a2 == null ? (int) f2 : (int) ((f2 / a2.density) + 0.5f);
    }
}
