package com.ss.android.socialbase.appdownloader.gv;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: g */
    private static String f24443g;

    /* renamed from: i */
    private static String f24444i;

    /* renamed from: j */
    private static String f24445j;
    private static Boolean q;
    private static String zx;

    public static String g() {
        if (f24443g == null) {
            f24443g = j("getBuildVersion");
        }
        return f24443g;
    }

    public static boolean gv() {
        return q() && zx(zx(), j()) && j(Process.myUid()) == 0;
    }

    public static String i() {
        if (f24444i == null) {
            f24444i = j("getReleaseType");
        }
        return f24444i;
    }

    public static boolean j(Context context) {
        return context != null && i(context) == 0 && q();
    }

    public static String lg() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean q() {
        if (q == null) {
            q = Boolean.FALSE;
            try {
                q = Boolean.valueOf("156".equals(j("ro.config.hw_optb", "0")) && "true".equals(j("hw_mc.pure_mode.enable", "false")));
            } catch (Exception unused) {
            }
        }
        return q.booleanValue();
    }

    public static boolean zx(Context context) {
        return context != null && g(context) == 0 && gv();
    }

    public static String j() {
        if (f24445j == null) {
            f24445j = j("getApiVersion");
        }
        return f24445j;
    }

    public static String zx() {
        if (zx == null) {
            zx = j("getVersion");
        }
        return zx;
    }

    public static int g(Context context) {
        return (context == null || Settings.Secure.getInt(context.getContentResolver(), "pure_enhanced_mode_state", 1) != 0) ? 1 : 0;
    }

    public static int i(Context context) {
        if (context == null) {
            return 1;
        }
        if (zx(zx(), j())) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 1) == 0 ? 0 : 1;
        }
        return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
    }

    private static String j(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, EnvironmentCompat.MEDIA_UNKNOWN);
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static boolean zx(String str, String str2) {
        return !TextUtils.isEmpty(str2) && str.startsWith("3");
    }

    private static int j(int i2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.UserHandleEx");
            return ((Integer) cls.getMethod("getUserId", Integer.TYPE).invoke(cls, Integer.valueOf(i2))).intValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return 1;
        }
    }

    private static String j(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]).toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
