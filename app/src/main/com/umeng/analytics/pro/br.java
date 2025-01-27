package com.umeng.analytics.pro;

import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

@Deprecated
/* loaded from: classes4.dex */
public class br {

    /* renamed from: a */
    private static final String f23579a = "ro.build.version.emui";

    /* renamed from: b */
    private static final String f23580b = "hw_sc.build.platform.version";

    public static boolean a() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return !TextUtils.isEmpty((String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, "ro.build.flyme.version", ""));
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b() {
        return d() && !g();
    }

    @Deprecated
    public static boolean c() {
        return d() && g();
    }

    public static boolean d() {
        return Build.MANUFACTURER.equalsIgnoreCase(ke.e.f27805c);
    }

    public static boolean e() {
        String str = Build.BRAND;
        if (!str.equalsIgnoreCase("huawei") && !str.equalsIgnoreCase("honor") && !str.equalsIgnoreCase("华为")) {
            String a10 = a("ro.build.version.emui");
            String a11 = a("hw_sc.build.platform.version");
            if (TextUtils.isEmpty(a10) && TextUtils.isEmpty(a11)) {
                return false;
            }
        }
        return true;
    }

    public static boolean f() {
        return !TextUtils.isEmpty(a("ro.coolos.version"));
    }

    private static boolean g() {
        return !TextUtils.isEmpty(a("ro.build.version.emui"));
    }

    private static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
        } catch (Throwable unused) {
            return "";
        }
    }
}
