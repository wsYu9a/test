package com.gyf.immersionbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.TypedValue;
import android.view.DisplayCutout;
import android.view.View;
import w6.l;

/* loaded from: classes2.dex */
public class NotchUtils {
    private static final String NOTCH_HUA_WEI = "com.huawei.android.util.HwNotchSizeUtil";
    private static final String NOTCH_LENOVO = "config_screen_has_notch";
    private static final String NOTCH_MEIZU = "flyme.config.FlymeFeature";
    private static final String NOTCH_OPPO = "com.oppo.feature.screen.heteromorphism";
    private static final String NOTCH_VIVO = "android.util.FtFeature";
    private static final String NOTCH_XIAO_MI = "ro.miui.notch";
    private static final String SYSTEM_PROPERTIES = "android.os.SystemProperties";

    public class a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ l f10625b;

        /* renamed from: c */
        public final /* synthetic */ Activity f10626c;

        public a(l lVar, Activity activity) {
            this.f10625b = lVar;
            this.f10626c = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = this.f10625b;
            if (lVar != null) {
                lVar.a(NotchUtils.getNotchHeight(this.f10626c));
            }
        }
    }

    private static int dp2px(Context context, int i10) {
        return (int) TypedValue.applyDimension(1, i10, context.getResources().getDisplayMetrics());
    }

    private static DisplayCutout getDisplayCutout(Activity activity) {
        return getDisplayCutout(activity.getWindow().getDecorView());
    }

    private static int[] getHuaWeiNotchSize(Context context) {
        int[] iArr = {0, 0};
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(NOTCH_HUA_WEI);
            return (int[]) loadClass.getMethod("getNotchSize", null).invoke(loadClass, null);
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return iArr;
        }
    }

    private static int getLenovoNotchHeight(Context context) {
        int identifier = context.getResources().getIdentifier("notch_h", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static int getMeizuNotchHeight(Context context) {
        int identifier = context.getResources().getIdentifier("fringe_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getNotchHeight(Activity activity) {
        int safeInsetLeft;
        int safeInsetLeft2;
        int safeInsetRight;
        int safeInsetTop;
        if (!hasNotchScreen(activity)) {
            return 0;
        }
        int H0 = d.H0(activity);
        DisplayCutout displayCutout = getDisplayCutout(activity);
        if (Build.VERSION.SDK_INT >= 28 && displayCutout != null) {
            if (activity.getResources().getConfiguration().orientation == 1) {
                safeInsetTop = displayCutout.getSafeInsetTop();
                return safeInsetTop;
            }
            safeInsetLeft = displayCutout.getSafeInsetLeft();
            if (safeInsetLeft == 0) {
                safeInsetRight = displayCutout.getSafeInsetRight();
                return safeInsetRight;
            }
            safeInsetLeft2 = displayCutout.getSafeInsetLeft();
            return safeInsetLeft2;
        }
        int xiaoMiNotchHeight = hasNotchAtXiaoMi(activity) ? getXiaoMiNotchHeight(activity) : 0;
        if (hasNotchAtHuaWei(activity)) {
            xiaoMiNotchHeight = getHuaWeiNotchSize(activity)[1];
        }
        if (hasNotchAtVIVO(activity) && (xiaoMiNotchHeight = dp2px(activity, 32)) < H0) {
            xiaoMiNotchHeight = H0;
        }
        if (!hasNotchAtOPPO(activity)) {
            H0 = xiaoMiNotchHeight;
        } else if (80 >= H0) {
            H0 = 80;
        }
        if (hasNotchAtLenovo(activity)) {
            H0 = getLenovoNotchHeight(activity);
        }
        return hasNotchAtMeiZu() ? getMeizuNotchHeight(activity) : H0;
    }

    private static int getXiaoMiNotchHeight(Context context) {
        int identifier = context.getResources().getIdentifier("notch_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static boolean hasNotchAtAndroidP(View view) {
        return getDisplayCutout(view) != null;
    }

    @SuppressLint({"PrivateApi"})
    private static boolean hasNotchAtHuaWei(Context context) {
        if (OSUtils.isHuaWei()) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass(NOTCH_HUA_WEI);
                return ((Boolean) loadClass.getMethod("hasNotchInScreen", null).invoke(loadClass, null)).booleanValue();
            } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            }
        }
        return false;
    }

    private static boolean hasNotchAtLenovo(Context context) {
        int identifier;
        if (!OSUtils.isLenovo() || (identifier = context.getResources().getIdentifier(NOTCH_LENOVO, "bool", "android")) <= 0) {
            return false;
        }
        return context.getResources().getBoolean(identifier);
    }

    private static boolean hasNotchAtMeiZu() {
        if (OSUtils.isMeizu()) {
            try {
                return ((Boolean) Class.forName(NOTCH_MEIZU).getDeclaredField("IS_FRINGE_DEVICE").get(null)).booleanValue();
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static boolean hasNotchAtOPPO(Context context) {
        if (OSUtils.isOppo()) {
            try {
                return context.getPackageManager().hasSystemFeature(NOTCH_OPPO);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @SuppressLint({"PrivateApi"})
    private static boolean hasNotchAtVIVO(Context context) {
        if (!OSUtils.isVivo()) {
            return false;
        }
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(NOTCH_VIVO);
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0041 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"PrivateApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean hasNotchAtXiaoMi(android.content.Context r6) {
        /*
            r0 = 2
            r1 = 1
            boolean r2 = com.gyf.immersionbar.OSUtils.isXiaoMi()
            r3 = 0
            if (r2 == 0) goto L3d
            java.lang.ClassLoader r6 = r6.getClassLoader()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = "android.os.SystemProperties"
            java.lang.Class r6 = r6.loadClass(r2)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = "getInt"
            java.lang.Class[] r4 = new java.lang.Class[r0]     // Catch: java.lang.Throwable -> L3c
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r3] = r5     // Catch: java.lang.Throwable -> L3c
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> L3c
            r4[r1] = r5     // Catch: java.lang.Throwable -> L3c
            java.lang.reflect.Method r2 = r6.getMethod(r2, r4)     // Catch: java.lang.Throwable -> L3c
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L3c
            java.lang.String r5 = "ro.miui.notch"
            r0[r3] = r5     // Catch: java.lang.Throwable -> L3c
            r0[r1] = r4     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r6 = r2.invoke(r6, r0)     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L3d
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch: java.lang.Throwable -> L3c
            int r6 = r6.intValue()     // Catch: java.lang.Throwable -> L3c
            goto L3e
        L3c:
        L3d:
            r6 = 0
        L3e:
            if (r6 != r1) goto L41
            goto L42
        L41:
            r1 = 0
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gyf.immersionbar.NotchUtils.hasNotchAtXiaoMi(android.content.Context):boolean");
    }

    public static boolean hasNotchScreen(Activity activity) {
        if (activity != null) {
            return Build.VERSION.SDK_INT >= 28 ? hasNotchAtAndroidP(activity) : hasNotchAtXiaoMi(activity) || hasNotchAtHuaWei(activity) || hasNotchAtOPPO(activity) || hasNotchAtVIVO(activity) || hasNotchAtLenovo(activity) || hasNotchAtMeiZu();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
    
        r2 = r2.getRootWindowInsets();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.view.DisplayCutout getDisplayCutout(android.view.View r2) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto L13
            if (r2 == 0) goto L13
            android.view.WindowInsets r2 = o4.a.a(r2)
            if (r2 == 0) goto L13
            android.view.DisplayCutout r2 = b0.k1.a(r2)
            return r2
        L13:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gyf.immersionbar.NotchUtils.getDisplayCutout(android.view.View):android.view.DisplayCutout");
    }

    private static boolean hasNotchAtAndroidP(Activity activity) {
        return getDisplayCutout(activity) != null;
    }

    public static boolean hasNotchScreen(View view) {
        if (view == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return hasNotchAtAndroidP(view);
        }
        return hasNotchAtXiaoMi(view.getContext()) || hasNotchAtHuaWei(view.getContext()) || hasNotchAtOPPO(view.getContext()) || hasNotchAtVIVO(view.getContext());
    }

    public static void getNotchHeight(Activity activity, l lVar) {
        activity.getWindow().getDecorView().post(new a(lVar, activity));
    }
}
