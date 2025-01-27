package com.gyf.barlibrary;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public class NotchUtils {
    private static final String NOTCH_HUA_WEI = "com.huawei.android.util.HwNotchSizeUtil";
    private static final String NOTCH_OPPO = "com.oppo.feature.screen.heteromorphism";
    private static final String NOTCH_VIVO = "android.util.FtFeature";
    private static final String NOTCH_XIAO_MI = "ro.miui.notch";
    private static final String SYSTEM_PROPERTIES = "android.os.SystemProperties";

    private static DisplayCutout getDisplayCutout(Activity activity) {
        Window window;
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 28 || activity == null || (window = activity.getWindow()) == null || (rootWindowInsets = window.getDecorView().getRootWindowInsets()) == null) {
            return null;
        }
        return rootWindowInsets.getDisplayCutout();
    }

    private static boolean hasNotchAtAndroidP(View view) {
        return getDisplayCutout(view) != null;
    }

    private static boolean hasNotchAtHuaWei(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(NOTCH_HUA_WEI);
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    private static boolean hasNotchAtOPPO(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature(NOTCH_OPPO);
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean hasNotchAtVIVO(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(NOTCH_VIVO);
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0042 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean hasNotchAtXiaoMi(android.content.Context r6) {
        /*
            java.lang.String r0 = android.os.Build.MANUFACTURER
            java.lang.String r1 = "Xiaomi"
            boolean r0 = r1.equals(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L3e
            java.lang.ClassLoader r6 = r6.getClassLoader()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r0 = "android.os.SystemProperties"
            java.lang.Class r6 = r6.loadClass(r0)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r0 = "getInt"
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch: java.lang.Throwable -> L3e
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r2] = r5     // Catch: java.lang.Throwable -> L3e
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> L3e
            r4[r1] = r5     // Catch: java.lang.Throwable -> L3e
            java.lang.reflect.Method r0 = r6.getMethod(r0, r4)     // Catch: java.lang.Throwable -> L3e
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = "ro.miui.notch"
            r3[r2] = r4     // Catch: java.lang.Throwable -> L3e
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L3e
            r3[r1] = r4     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r6 = r0.invoke(r6, r3)     // Catch: java.lang.Throwable -> L3e
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch: java.lang.Throwable -> L3e
            int r6 = r6.intValue()     // Catch: java.lang.Throwable -> L3e
            goto L3f
        L3e:
            r6 = 0
        L3f:
            if (r6 != r1) goto L42
            goto L43
        L42:
            r1 = 0
        L43:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gyf.barlibrary.NotchUtils.hasNotchAtXiaoMi(android.content.Context):boolean");
    }

    public static boolean hasNotchScreen(Activity activity) {
        return activity != null && (hasNotchAtXiaoMi(activity) || hasNotchAtHuaWei(activity) || hasNotchAtOPPO(activity) || hasNotchAtVIVO(activity) || hasNotchAtAndroidP(activity));
    }

    private static boolean hasNotchAtAndroidP(Activity activity) {
        return getDisplayCutout(activity) != null;
    }

    private static DisplayCutout getDisplayCutout(View view) {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 28 || view == null || (rootWindowInsets = view.getRootWindowInsets()) == null) {
            return null;
        }
        return rootWindowInsets.getDisplayCutout();
    }

    public static boolean hasNotchScreen(View view) {
        return view != null && (hasNotchAtXiaoMi(view.getContext()) || hasNotchAtHuaWei(view.getContext()) || hasNotchAtOPPO(view.getContext()) || hasNotchAtVIVO(view.getContext()) || hasNotchAtAndroidP(view));
    }
}
