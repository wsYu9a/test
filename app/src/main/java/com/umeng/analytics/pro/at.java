package com.umeng.analytics.pro;

import android.os.Build;
import android.text.TextUtils;
import com.martian.ads.ad.AdConfig;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: classes4.dex */
public class at {

    /* renamed from: a */
    private static String f23449a = "";

    /* renamed from: b */
    private static String f23450b = "";

    /* renamed from: c */
    private static final String f23451c = "hw_sc.build.platform.version";

    /* renamed from: d */
    private static final String f23452d = "ro.build.version.emui";

    /* renamed from: e */
    private static final String f23453e = "ro.build.version.magic";

    /* renamed from: f */
    private static final String f23454f = "ro.miui.ui.version.name";

    /* renamed from: g */
    private static final String f23455g = "ro.build.version.opporom";

    /* renamed from: h */
    private static final String f23456h = "ro.vivo.os.name";

    /* renamed from: i */
    private static final String f23457i = "ro.vivo.os.version";

    /* renamed from: j */
    private static final String f23458j = "ro.build.version.oplusrom";

    /* renamed from: k */
    private static final String f23459k = "ro.rom.version";

    private static boolean a() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return !TextUtils.isEmpty((String) cls.getMethod("getOsBrand", null).invoke(cls, null));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(f23449a)) {
            e(str);
        }
        return f23450b;
    }

    public static String c(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replaceAll(" ", "").toUpperCase();
    }

    private static String d(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void e(String str) {
        char c10;
        try {
            String c11 = c(str);
            switch (c11.hashCode()) {
                case -1881642058:
                    if (c11.equals("REALME")) {
                        c10 = 4;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1706170181:
                    if (c11.equals("XIAOMI")) {
                        c10 = 2;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -602397472:
                    if (c11.equals("ONEPLUS")) {
                        c10 = 7;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 2432928:
                    if (c11.equals("OPPO")) {
                        c10 = 5;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 2634924:
                    if (c11.equals(AdConfig.UnionType.VIVO)) {
                        c10 = 6;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 68924490:
                    if (c11.equals(ke.e.f27805c)) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 77852109:
                    if (c11.equals("REDMI")) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 2141820391:
                    if (c11.equals(ke.e.f27804b)) {
                        c10 = 0;
                        break;
                    }
                    c10 = 65535;
                    break;
                default:
                    c10 = 65535;
                    break;
            }
            switch (c10) {
                case 0:
                    if (!a()) {
                        f23449a = "EMUI";
                        f23450b = d("ro.build.version.emui");
                        break;
                    } else {
                        f23450b = d("hw_sc.build.platform.version");
                        f23449a = "HarmonyOS";
                        break;
                    }
                case 1:
                    if (!TextUtils.isEmpty(d(f23453e))) {
                        f23449a = "MagicUI";
                        f23450b = d(f23453e);
                        break;
                    } else {
                        f23449a = "EMUI";
                        f23450b = d("ro.build.version.emui");
                        break;
                    }
                case 2:
                case 3:
                    f23449a = "MIUI";
                    f23450b = d(f23454f);
                    break;
                case 4:
                case 5:
                    f23449a = "ColorOS";
                    f23450b = d(f23455g);
                    break;
                case 6:
                    f23449a = "Funtouch";
                    f23450b = d(f23457i);
                    break;
                case 7:
                    f23449a = "HydrogenOS";
                    String d10 = d("ro.rom.version");
                    if (TextUtils.isEmpty(d10)) {
                        f23449a = "ColorOS";
                        d10 = d(f23458j);
                    }
                    f23450b = d10;
                    break;
                default:
                    f23449a = "Android";
                    f23450b = Build.VERSION.RELEASE;
                    break;
            }
        } catch (Throwable unused) {
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(f23449a)) {
            e(str);
        }
        return f23449a;
    }
}
