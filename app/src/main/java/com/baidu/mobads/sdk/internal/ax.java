package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.cdo.oaps.ad.wrapper.BaseWrapper;

/* loaded from: classes.dex */
public class ax {

    /* renamed from: a */
    private static DisplayMetrics f5561a;

    /* renamed from: b */
    private static float f5562b;

    public static Rect a(Context context) {
        DisplayMetrics f2 = f(context);
        try {
            return f2.widthPixels > f2.heightPixels ? new Rect(0, 0, f2.heightPixels, f2.widthPixels) : new Rect(0, 0, f2.widthPixels, f2.heightPixels);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int b(Context context) {
        return a(context).width();
    }

    public static int c(Context context) {
        return a(context).height();
    }

    public static Rect d(Context context) {
        DisplayMetrics f2 = f(context);
        return new Rect(0, 0, f2.widthPixels, f2.heightPixels);
    }

    public static float e(Context context) {
        if (f5562b < 0.01d) {
            f5562b = f(context).density;
        }
        return f5562b;
    }

    public static DisplayMetrics f(Context context) {
        try {
            DisplayMetrics displayMetrics = f5561a;
            if (displayMetrics != null && displayMetrics.widthPixels > 0) {
                return displayMetrics;
            }
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            if (bj.a(context).a() >= 17) {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics2);
            } else {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics2);
            }
            f5561a = displayMetrics2;
        } catch (Throwable th) {
            f5561a = new DisplayMetrics();
            bq.a().a(th);
        }
        return f5561a;
    }

    public static int g(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", BaseWrapper.BASE_PKG_SYSTEM));
    }

    public static int b(Context context, int i2) {
        try {
            return (int) (i2 * e(context));
        } catch (Exception unused) {
            return i2;
        }
    }

    public static int b(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context, int i2) {
        try {
            return (int) (i2 / e(context));
        } catch (Exception unused) {
            return i2;
        }
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
