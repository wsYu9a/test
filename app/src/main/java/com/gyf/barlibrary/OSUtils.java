package com.gyf.barlibrary;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.umeng.analytics.pro.am;

/* loaded from: classes.dex */
public class OSUtils {
    private static final String KEY_DISPLAY = "ro.build.display.id";
    private static final String KEY_EMUI_VERSION_NAME = "ro.build.version.emui";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";

    public static String getEMUIVersion() {
        return isEMUI() ? getSystemProperty(KEY_EMUI_VERSION_NAME, "") : "";
    }

    private static String getFlymeOSFlag() {
        return getSystemProperty(KEY_DISPLAY, "");
    }

    public static String getFlymeOSVersion() {
        return isFlymeOS() ? getSystemProperty(KEY_DISPLAY, "") : "";
    }

    public static String getMIUIVersion() {
        return isMIUI() ? getSystemProperty(KEY_MIUI_VERSION_NAME, "") : "";
    }

    private static String getSystemProperty(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return str2;
        }
    }

    public static boolean isEMUI() {
        return !TextUtils.isEmpty(getSystemProperty(KEY_EMUI_VERSION_NAME, ""));
    }

    public static boolean isEMUI3_0() {
        return getEMUIVersion().contains("EmotionUI_3.0");
    }

    public static boolean isEMUI3_1() {
        String eMUIVersion = getEMUIVersion();
        return "EmotionUI 3".equals(eMUIVersion) || eMUIVersion.contains("EmotionUI_3.1");
    }

    public static boolean isEMUI3_x() {
        return isEMUI3_0() || isEMUI3_1();
    }

    public static boolean isFlymeOS() {
        return getFlymeOSFlag().toLowerCase().contains("flyme");
    }

    public static boolean isFlymeOS4Later() {
        String flymeOSVersion = getFlymeOSVersion();
        if (flymeOSVersion.isEmpty()) {
            return false;
        }
        try {
            return (flymeOSVersion.toLowerCase().contains(am.x) ? Integer.valueOf(flymeOSVersion.substring(9, 10)).intValue() : Integer.valueOf(flymeOSVersion.substring(6, 7)).intValue()) >= 4;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isFlymeOS5() {
        String flymeOSVersion = getFlymeOSVersion();
        if (flymeOSVersion.isEmpty()) {
            return false;
        }
        try {
            return (flymeOSVersion.toLowerCase().contains(am.x) ? Integer.valueOf(flymeOSVersion.substring(9, 10)).intValue() : Integer.valueOf(flymeOSVersion.substring(6, 7)).intValue()) == 5;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isMIUI() {
        return !TextUtils.isEmpty(getSystemProperty(KEY_MIUI_VERSION_NAME, ""));
    }

    public static boolean isMIUI6Later() {
        String mIUIVersion = getMIUIVersion();
        if (mIUIVersion.isEmpty()) {
            return false;
        }
        try {
            return Integer.valueOf(mIUIVersion.substring(1)).intValue() >= 6;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
