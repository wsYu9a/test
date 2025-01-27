package com.kwad.components.core.r;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.kwad.sdk.utils.s;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public final class i {
    private static Method PU;
    private static Method PV;
    private static Field PW;
    private static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;

    static {
        try {
            PU = Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        }
        try {
            PV = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        }
        try {
            PW = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
        }
        try {
            SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = ((Integer) s.c((Class<?>) View.class, "SYSTEM_UI_FLAG_LIGHT_STATUS_BAR")).intValue();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private static void a(Activity activity, boolean z, boolean z2) {
        Method method = PV;
        if (method == null) {
            a(activity.getWindow(), z);
            return;
        }
        try {
            method.invoke(activity, Boolean.valueOf(z));
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    private static void a(Window window, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            a(window.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", z);
            return;
        }
        View decorView = window.getDecorView();
        if (decorView != null) {
            g(decorView, z);
            setStatusBarColor(window, 0);
        }
    }

    private static boolean a(WindowManager.LayoutParams layoutParams, String str, boolean z) {
        try {
            int intValue = ((Integer) s.d(layoutParams, str)).intValue();
            int intValue2 = ((Integer) s.d(layoutParams, "meizuFlags")).intValue();
            int i2 = z ? intValue | intValue2 : (intValue ^ (-1)) & intValue2;
            if (intValue2 == i2) {
                return false;
            }
            s.a(layoutParams, "meizuFlags", Integer.valueOf(i2));
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void b(Activity activity, boolean z) {
        a(activity, true, true);
    }

    private static void g(View view, boolean z) {
        int systemUiVisibility = view.getSystemUiVisibility();
        int i2 = z ? SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | systemUiVisibility : (SYSTEM_UI_FLAG_LIGHT_STATUS_BAR ^ (-1)) & systemUiVisibility;
        if (i2 != systemUiVisibility) {
            view.setSystemUiVisibility(i2);
        }
    }

    private static void setStatusBarColor(Window window, int i2) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = PW;
        if (field != null) {
            try {
                if (field.getInt(attributes) != 0) {
                    PW.set(attributes, 0);
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
    }
}
