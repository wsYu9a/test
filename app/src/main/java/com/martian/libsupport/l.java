package com.martian.libsupport;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.FloatRange;
import androidx.core.os.EnvironmentCompat;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a */
    private static final String f10610a = "PREFERENCE_UNIQUE_DEVICEID";

    /* renamed from: b */
    private static final String f10611b = "000000000000000";

    /* renamed from: c */
    private static String f10612c = null;

    /* renamed from: d */
    private static final int f10613d = 0;

    /* renamed from: e */
    private static final float f10614e = 0.0f;

    /* renamed from: f */
    public static final int f10615f = 32;

    private l() {
    }

    public static boolean A() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean B() {
        return Build.VERSION.SDK_INT >= 27;
    }

    public static boolean C() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean D() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static void E(Activity activity) {
        G(activity, 0, 0.0f);
    }

    public static void F(Activity activity, int color) {
        H(activity.getWindow(), color, 1.0f);
    }

    public static void G(Activity activity, int color, @FloatRange(from = 0.0d, to = 1.0d) float alpha) {
        H(activity.getWindow(), color, alpha);
    }

    public static void H(Window window, int color, @FloatRange(from = 0.0d, to = 1.0d) float alpha) {
        if (r()) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(O(color, alpha));
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1024 | 256);
            return;
        }
        if (p()) {
            window.addFlags(67108864);
            Q((ViewGroup) window.getDecorView(), color, alpha);
        } else if (m()) {
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1024 | 256);
        }
    }

    public static boolean I(Context context) {
        if (C() || !M()) {
            return false;
        }
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            Method method = loadClass.getMethod("isFeatureSupport", Integer.TYPE);
            if (method != null) {
                return ((Boolean) method.invoke(loadClass, 32)).booleanValue();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean J(Object object, String className) {
        try {
            return Class.forName(className).isInstance(object);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean K() {
        return Locale.getDefault().toString().contains("Hant");
    }

    private static boolean L(String deviceId) {
        if (k.p(deviceId)) {
            return false;
        }
        for (int i2 = 0; i2 < deviceId.length(); i2++) {
            char charAt = deviceId.charAt(i2);
            if (charAt != '0' && charAt != '-') {
                return !deviceId.contains(EnvironmentCompat.MEDIA_UNKNOWN);
            }
        }
        return false;
    }

    public static boolean M() {
        return Build.MANUFACTURER.equalsIgnoreCase("vivo");
    }

    public static boolean N() {
        return Build.MANUFACTURER.equalsIgnoreCase("xiaomi");
    }

    public static int O(int color, @FloatRange(from = 0.0d, to = 1.0d) float alpha) {
        return (color & 16777215) | (((int) ((((-16777216) & color) == 0 ? 255 : color >>> 24) * alpha)) << 24);
    }

    private static void P(Context context, String deviceId) {
        f10612c = deviceId;
        h.o(context, f10610a, deviceId);
    }

    public static void Q(ViewGroup container, int color, @FloatRange(from = 0.0d, to = 1.0d) float alpha) {
        if (p()) {
            int O = O(color, alpha);
            View findViewById = container.findViewById(android.R.id.custom);
            if (findViewById == null && O != 0) {
                findViewById = new View(container.getContext());
                findViewById.setId(android.R.id.custom);
                container.addView(findViewById, new ViewGroup.LayoutParams(-1, i(container.getContext())));
            }
            if (findViewById != null) {
                findViewById.setBackgroundColor(O);
            }
        }
    }

    public static int a(Context ctx, float dipValue) {
        return (int) ((dipValue * ctx.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @SuppressLint({"HardwareIds"})
    public static String b(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return string == null ? "" : string;
    }

    public static String c(Context context) {
        if (!k.p(f10612c)) {
            return f10612c;
        }
        String f2 = f(context);
        f10612c = f2;
        if (L(f2)) {
            return f10612c;
        }
        P(context, UUID.randomUUID().toString().replaceAll("-", ""));
        return f10612c;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String d(Context context) {
        String str;
        str = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            str = telephonyManager != null ? t() ? A() ? telephonyManager.getPhoneCount() == 2 ? telephonyManager.getImei(0) : telephonyManager.getImei() : telephonyManager.getPhoneCount() == 2 ? telephonyManager.getDeviceId(0) : telephonyManager.getDeviceId() : telephonyManager.getDeviceId() : "";
        } catch (SecurityException unused) {
        }
        return str;
    }

    @SuppressLint({"HardwareIds"})
    public static String e(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(com.alipay.mobilesecuritysdk.constant.a.I);
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return "";
        }
        String macAddress = connectionInfo.getMacAddress();
        return "02:00:00:00:00:00".equalsIgnoreCase(macAddress) ? "" : macAddress;
    }

    private static String f(Context context) {
        return h.j(context, f10610a);
    }

    public static int g(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int h(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int i(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", BaseWrapper.BASE_PKG_SYSTEM);
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : (int) TypedValue.applyDimension(1, 24, Resources.getSystem().getDisplayMetrics());
    }

    public static int j(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static String k(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "Unknown";
        }
    }

    public static boolean l() {
        return Build.VERSION.SDK_INT >= 15;
    }

    public static boolean m() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean n() {
        return Build.VERSION.SDK_INT >= 17;
    }

    public static boolean o() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public static boolean p() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public static boolean q() {
        return Build.VERSION.SDK_INT >= 20;
    }

    public static boolean r() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean s() {
        return Build.VERSION.SDK_INT >= 22;
    }

    public static boolean t() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean u() {
        return Build.VERSION.SDK_INT >= 24;
    }

    private static boolean v(Activity activity) {
        try {
            Class<?> loadClass = activity.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            Method method = loadClass.getMethod("hasNotchInScreen", new Class[0]);
            if (method != null) {
                return ((Boolean) method.invoke(loadClass, new Object[0])).booleanValue();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static boolean w(Activity activity) {
        if (activity == null) {
            return false;
        }
        String str = Build.MANUFACTURER;
        if (k.p(str)) {
            return false;
        }
        if (str.equalsIgnoreCase("HUAWEI")) {
            return v(activity);
        }
        if (str.equalsIgnoreCase("xiaomi")) {
            return z(activity);
        }
        if (str.equalsIgnoreCase("oppo")) {
            return x(activity);
        }
        if (str.equalsIgnoreCase("vivo")) {
            return y();
        }
        return false;
    }

    private static boolean x(Activity activity) {
        return activity.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    private static boolean y() {
        try {
            Class<?> cls = Class.forName("android.util.FtFeature");
            Method method = cls.getMethod("isFeatureSupport", Integer.TYPE);
            if (method != null) {
                return ((Boolean) method.invoke(cls, 32)).booleanValue();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    private static boolean z(Activity activity) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method method = cls.getMethod("getInt", String.class, Integer.TYPE);
            if (method != null) {
                return ((Integer) method.invoke(cls, "ro.miui.notch", 0)).intValue() == 1;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }
}
