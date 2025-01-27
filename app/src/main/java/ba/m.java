package ba;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.LocaleList;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.FloatRange;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes3.dex */
public class m {

    /* renamed from: a */
    public static final String f1492a = "PREFERENCE_UNIQUE_DEVICEID";

    /* renamed from: b */
    public static final String f1493b = "000000000000000";

    /* renamed from: c */
    public static String f1494c = null;

    /* renamed from: d */
    public static final int f1495d = 0;

    /* renamed from: e */
    public static final float f1496e = 0.0f;

    /* renamed from: f */
    public static final int f1497f = 32;

    public static void A(Activity activity, int i10) {
        C(activity.getWindow(), i10, 1.0f);
    }

    public static void B(Activity activity, int i10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        C(activity.getWindow(), i10, f10);
    }

    public static void C(Window window, int i10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(J(i10, f10));
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1280);
    }

    public static boolean D(Context context) {
        if (w() || !H()) {
            return false;
        }
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            Method method = loadClass.getMethod("isFeatureSupport", Integer.TYPE);
            if (method != null) {
                return ((Boolean) method.invoke(loadClass, 32)).booleanValue();
            }
            return false;
        } catch (ClassNotFoundException e10) {
            e10.printStackTrace();
            return false;
        } catch (NoSuchMethodException e11) {
            e11.printStackTrace();
            return false;
        } catch (Exception e12) {
            e12.printStackTrace();
            return false;
        }
    }

    public static boolean E(Object obj, String str) {
        try {
            return Class.forName(str).isInstance(obj);
        } catch (ClassNotFoundException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static boolean F(Context context) {
        Locale locale;
        LocaleList locales;
        if (Build.VERSION.SDK_INT >= 24) {
            locales = context.getResources().getConfiguration().getLocales();
            locale = locales.get(0);
        } else {
            locale = context.getResources().getConfiguration().locale;
        }
        if (!"zh".equalsIgnoreCase(locale.getLanguage())) {
            return false;
        }
        String upperCase = locale.getCountry().toUpperCase(Locale.getDefault());
        upperCase.hashCode();
        return upperCase.equals("HK") || upperCase.equals("TW");
    }

    public static boolean G(String str) {
        if (l.q(str)) {
            return false;
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt != '0' && charAt != '-') {
                return !str.contains("unknown");
            }
        }
        return false;
    }

    public static boolean H() {
        return Build.MANUFACTURER.equalsIgnoreCase(ke.e.f27807e);
    }

    public static boolean I() {
        return Build.MANUFACTURER.equalsIgnoreCase("xiaomi");
    }

    public static int J(int i10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return (i10 & 16777215) | (((int) ((((-16777216) & i10) == 0 ? 255 : i10 >>> 24) * f10)) << 24);
    }

    public static void K(Context context, String str) {
        f1494c = str;
        j.o(context, f1492a, str);
    }

    public static void L(ViewGroup viewGroup, int i10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        int J = J(i10, f10);
        View findViewById = viewGroup.findViewById(R.id.custom);
        if (findViewById == null && J != 0) {
            findViewById = new View(viewGroup.getContext());
            findViewById.setId(R.id.custom);
            viewGroup.addView(findViewById, new ViewGroup.LayoutParams(-1, j(viewGroup.getContext())));
        }
        if (findViewById != null) {
            findViewById.setBackgroundColor(J);
        }
    }

    public static int M(Resources resources, int i10) {
        return (int) ((i10 * resources.getDisplayMetrics().scaledDensity) + 0.5d);
    }

    public static boolean N(Context context) {
        if (context == null) {
            return false;
        }
        try {
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
        }
        return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion >= 30;
    }

    public static int a(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Resources resources, float f10) {
        return (int) ((f10 * resources.getDisplayMetrics().density) + 0.5f);
    }

    @SuppressLint({"HardwareIds"})
    public static String c(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return string == null ? "" : string;
    }

    public static String d(Context context) {
        if (!l.q(f1494c)) {
            return f1494c;
        }
        String g10 = g(context);
        f1494c = g10;
        if (G(g10)) {
            return f1494c;
        }
        K(context, UUID.randomUUID().toString().replaceAll("-", ""));
        return f1494c;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String e(Context context) {
        int phoneCount;
        int phoneCount2;
        String str = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                if (!n()) {
                    str = telephonyManager.getDeviceId();
                } else if (u()) {
                    phoneCount2 = telephonyManager.getPhoneCount();
                    str = phoneCount2 == 2 ? telephonyManager.getImei(0) : telephonyManager.getImei();
                } else {
                    phoneCount = telephonyManager.getPhoneCount();
                    str = phoneCount == 2 ? telephonyManager.getDeviceId(0) : telephonyManager.getDeviceId();
                }
            }
        } catch (SecurityException unused) {
        }
        return str;
    }

    @SuppressLint({"HardwareIds"})
    public static String f(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return "";
        }
        String macAddress = connectionInfo.getMacAddress();
        return "02:00:00:00:00:00".equalsIgnoreCase(macAddress) ? "" : macAddress;
    }

    public static String g(Context context) {
        return j.j(context, f1492a);
    }

    public static int h(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int i(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int j(Context context) {
        int identifier = context.getResources().getIdentifier(com.gyf.immersionbar.b.f10638c, "dimen", "android");
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : (int) TypedValue.applyDimension(1, 24, Resources.getSystem().getDisplayMetrics());
    }

    public static int k(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public static String l(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return "Unknown";
        }
    }

    public static boolean m() {
        return Build.VERSION.SDK_INT >= 22;
    }

    public static boolean n() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean o() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean p(Activity activity) {
        try {
            Class<?> loadClass = activity.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            Method method = loadClass.getMethod("hasNotchInScreen", null);
            if (method != null) {
                return ((Boolean) method.invoke(loadClass, null)).booleanValue();
            }
            return false;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static boolean q(Activity activity) {
        if (activity == null) {
            return false;
        }
        String str = Build.MANUFACTURER;
        if (l.q(str)) {
            return false;
        }
        if (str.equalsIgnoreCase(ke.e.f27804b)) {
            return p(activity);
        }
        if (str.equalsIgnoreCase("xiaomi")) {
            return t(activity);
        }
        if (str.equalsIgnoreCase("oppo")) {
            return r(activity);
        }
        if (str.equalsIgnoreCase(ke.e.f27807e)) {
            return s();
        }
        return false;
    }

    public static boolean r(Activity activity) {
        return activity.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean s() {
        try {
            Class<?> cls = Class.forName("android.util.FtFeature");
            Method method = cls.getMethod("isFeatureSupport", Integer.TYPE);
            if (method != null) {
                return ((Boolean) method.invoke(cls, 32)).booleanValue();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return false;
    }

    public static boolean t(Activity activity) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method method = cls.getMethod("getInt", String.class, Integer.TYPE);
            if (method != null) {
                return ((Integer) method.invoke(cls, "ro.miui.notch", 0)).intValue() == 1;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return false;
    }

    public static boolean u() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean v() {
        return Build.VERSION.SDK_INT >= 27;
    }

    public static boolean w() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean x() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean y() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static void z(Activity activity) {
        B(activity, 0, 0.0f);
    }
}
