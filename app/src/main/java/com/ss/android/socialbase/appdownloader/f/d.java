package com.ss.android.socialbase.appdownloader.f;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private static String f21912a;

    /* renamed from: b */
    private static String f21913b;

    /* renamed from: c */
    private static String f21914c;

    /* renamed from: d */
    private static String f21915d;

    /* renamed from: e */
    private static Boolean f21916e;

    public static boolean a(Context context) {
        return context != null && c(context) == 0 && e();
    }

    public static boolean b(Context context) {
        return context != null && d(context) == 0 && f();
    }

    public static String c() {
        if (f21914c == null) {
            f21914c = a("getReleaseType");
        }
        return f21914c;
    }

    public static String d() {
        if (f21915d == null) {
            f21915d = a("getBuildVersion");
        }
        return f21915d;
    }

    public static boolean e() {
        if (f21916e == null) {
            f21916e = Boolean.FALSE;
            try {
                f21916e = Boolean.valueOf("156".equals(a("ro.config.hw_optb", "0")) && "true".equals(a("hw_mc.pure_mode.enable", "false")));
            } catch (Exception unused) {
            }
        }
        return f21916e.booleanValue();
    }

    public static boolean f() {
        return e() && b(b(), a()) && a(Process.myUid()) == 0;
    }

    public static String g() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return (String) cls.getMethod("getOsBrand", null).invoke(cls, null);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a() {
        if (f21912a == null) {
            f21912a = a("getApiVersion");
        }
        return f21912a;
    }

    public static String b() {
        if (f21913b == null) {
            f21913b = a("getVersion");
        }
        return f21913b;
    }

    public static int c(Context context) {
        if (context == null) {
            return 1;
        }
        if (b(b(), a())) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 1) == 0 ? 0 : 1;
        }
        return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
    }

    public static int d(Context context) {
        return (context == null || Settings.Secure.getInt(context.getContentResolver(), "pure_enhanced_mode_state", 1) != 0) ? 1 : 0;
    }

    private static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static boolean b(String str, String str2) {
        return !TextUtils.isEmpty(str2) && str.startsWith("3");
    }

    private static int a(int i10) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.UserHandleEx");
            return ((Integer) cls.getMethod("getUserId", Integer.TYPE).invoke(cls, Integer.valueOf(i10))).intValue();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 1;
        }
    }

    private static String a(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, null).invoke(cls, null).toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
