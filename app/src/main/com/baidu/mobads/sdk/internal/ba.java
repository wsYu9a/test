package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* loaded from: classes2.dex */
public class ba {

    /* renamed from: a */
    private static DisplayMetrics f6854a;

    /* renamed from: b */
    private static float f6855b;

    public static Rect a(Context context) {
        DisplayMetrics f10 = f(context);
        try {
            return f10.widthPixels > f10.heightPixels ? new Rect(0, 0, f10.heightPixels, f10.widthPixels) : new Rect(0, 0, f10.widthPixels, f10.heightPixels);
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
        DisplayMetrics f10 = f(context);
        return new Rect(0, 0, f10.widthPixels, f10.heightPixels);
    }

    public static float e(Context context) {
        if (f6855b < 0.01d) {
            f6855b = f(context).density;
        }
        return f6855b;
    }

    public static DisplayMetrics f(Context context) {
        try {
            DisplayMetrics displayMetrics = f6854a;
            if (displayMetrics != null && displayMetrics.widthPixels > 0) {
                return displayMetrics;
            }
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            if (bm.a(context).a() >= 17) {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics2);
            } else {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics2);
            }
            f6854a = displayMetrics2;
        } catch (Throwable th2) {
            f6854a = new DisplayMetrics();
            bt.a().a(th2);
        }
        return f6854a;
    }

    public static int g(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier(com.gyf.immersionbar.b.f10638c, "dimen", "android"));
    }

    public static int b(Context context, int i10) {
        try {
            return (int) (i10 * e(context));
        } catch (Exception unused) {
            return i10;
        }
    }

    public static int b(Context context, float f10) {
        return (int) ((f10 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context, int i10) {
        try {
            return (int) (i10 / e(context));
        } catch (Exception unused) {
            return i10;
        }
    }

    public static int a(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
