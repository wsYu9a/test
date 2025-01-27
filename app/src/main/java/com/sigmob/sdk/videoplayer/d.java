package com.sigmob.sdk.videoplayer;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.view.Display;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    public static int f20720a;

    public static int a(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Activity activity) {
        Resources resources;
        int identifier;
        if (!d(activity) || (resources = activity.getResources()) == null || (identifier = resources.getIdentifier(com.gyf.immersionbar.b.f10639d, "dimen", "android")) == 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public static void c(Context context) {
        Window b10;
        if (!g.f20758r || (b10 = b(context)) == null) {
            return;
        }
        b10.setFlags(1024, 1024);
    }

    public static void d(Context context) {
        Window b10 = b(context);
        if (b10 != null) {
            f20720a = b10.getDecorView().getSystemUiVisibility();
            b10.getDecorView().setSystemUiVisibility(5638);
        }
    }

    public static void e(Context context) {
        Window b10 = b(context);
        if (b10 != null) {
            b10.clearFlags(134217728);
            b10.getDecorView().setSystemUiVisibility(b10.getDecorView().getSystemUiVisibility() | 1796);
            b10.addFlags(Integer.MIN_VALUE);
            b10.setStatusBarColor(0);
            b10.setNavigationBarColor(0);
        }
    }

    public static boolean f(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static Activity g(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return g(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static void h(Context context) {
        Window b10;
        if (!g.f20758r || (b10 = b(context)) == null) {
            return;
        }
        b10.clearFlags(1024);
    }

    public static void i(Context context) {
        Window b10 = b(context);
        if (b10 != null) {
            b10.getDecorView().setSystemUiVisibility(f20720a);
        }
    }

    public static void a(Activity activity) {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(activity)).screenOrientation = -1;
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static Window b(Context context) {
        Activity g10 = g(context);
        if (g10 != null) {
            return g10.getWindow();
        }
        return null;
    }

    public static void c(Activity activity) {
        if (Build.VERSION.SDK_INT == 26 && e(activity)) {
            a(activity);
        }
    }

    public static boolean d(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        return point2.y != point.y;
    }

    public static boolean e(Activity activity) {
        try {
            Field declaredField = Class.forName("com.android.internal.R$styleable").getDeclaredField("Window");
            declaredField.setAccessible(true);
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) declaredField.get(null));
            Method declaredMethod = ActivityInfo.class.getDeclaredMethod("isTranslucentOrFloating", TypedArray.class);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(null, obtainStyledAttributes)).booleanValue();
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static int a(Context context) {
        int identifier = context.getResources().getIdentifier(com.gyf.immersionbar.b.f10638c, "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField(com.gyf.immersionbar.b.f10638c).get(cls.newInstance()).toString()));
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static void a(Context context, int i10) {
        Activity g10 = g(context);
        if (g10 != null) {
            g10.setRequestedOrientation(i10);
        }
    }

    public static String a(long j10) {
        if (j10 <= 0 || j10 >= 86400000) {
            return "00:00";
        }
        long j11 = j10 / 1000;
        int i10 = (int) (j11 % 60);
        int i11 = (int) ((j11 / 60) % 60);
        int i12 = (int) (j11 / 3600);
        Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
        return (i12 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i12), Integer.valueOf(i11), Integer.valueOf(i10)) : formatter.format("%02d:%02d", Integer.valueOf(i11), Integer.valueOf(i10))).toString();
    }
}
