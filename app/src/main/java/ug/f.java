package ug;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.martian.ads.ad.AdConfig;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: classes4.dex */
public final class f {
    public static boolean a() {
        return Build.MANUFACTURER.equalsIgnoreCase("ASUS") || Build.BRAND.equalsIgnoreCase("ASUS");
    }

    public static boolean b() {
        return Build.MANUFACTURER.equalsIgnoreCase("BLACKSHARK") || Build.BRAND.equalsIgnoreCase("BLACKSHARK");
    }

    public static boolean c(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean d() {
        return t("ro.odm.manufacturer", "").equalsIgnoreCase("PRIZE");
    }

    public static boolean e() {
        return !TextUtils.isEmpty(t("ro.build.version.emui", ""));
    }

    public static boolean f() {
        return !TextUtils.isEmpty(t("ro.build.freeme.label", ""));
    }

    public static boolean g() {
        return Build.BRAND.equalsIgnoreCase(ke.e.f27805c);
    }

    public static boolean h() {
        if (!Build.MANUFACTURER.equalsIgnoreCase(ke.e.f27804b)) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase(ke.e.f27804b) && !str.equalsIgnoreCase(ke.e.f27805c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean i() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("LENOVO")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("LENOVO") && !str.equalsIgnoreCase("ZUK")) {
                return false;
            }
        }
        return true;
    }

    public static boolean j() {
        return Build.MANUFACTURER.equalsIgnoreCase("MEIZU") || Build.BRAND.equalsIgnoreCase("MEIZU") || Build.DISPLAY.toUpperCase().contains("FLYME");
    }

    public static boolean k() {
        return !TextUtils.isEmpty(t("ro.miui.ui.version.name", ""));
    }

    public static boolean l() {
        return Build.MANUFACTURER.equalsIgnoreCase("MOTOLORA") || Build.BRAND.equalsIgnoreCase("MOTOLORA");
    }

    public static boolean m() {
        return Build.MANUFACTURER.equalsIgnoreCase("NUBIA") || Build.BRAND.equalsIgnoreCase("NUBIA");
    }

    public static boolean n() {
        return Build.MANUFACTURER.equalsIgnoreCase("ONEPLUS") || Build.BRAND.equalsIgnoreCase("ONEPLUS");
    }

    public static boolean o() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("OPPO")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("OPPO") && !str.equalsIgnoreCase("REALME") && TextUtils.isEmpty(t("ro.build.version.opporom", ""))) {
                return false;
            }
        }
        return true;
    }

    public static boolean p() {
        return Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG") || Build.BRAND.equalsIgnoreCase("SAMSUNG");
    }

    public static boolean q() {
        return Build.MANUFACTURER.equalsIgnoreCase(AdConfig.UnionType.VIVO) || Build.BRAND.equalsIgnoreCase(AdConfig.UnionType.VIVO) || !TextUtils.isEmpty(t("ro.vivo.os.version", ""));
    }

    public static boolean r() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("XIAOMI") && !str.equalsIgnoreCase("REDMI")) {
                return false;
            }
        }
        return true;
    }

    public static boolean s() {
        return Build.MANUFACTURER.equalsIgnoreCase("ZTE") || Build.BRAND.equalsIgnoreCase("ZTE");
    }

    public static String t(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e10) {
            e.b("System property invoke error: " + e10);
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }
}
