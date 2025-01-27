package com.ss.android.socialbase.appdownloader.f;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.czhj.sdk.common.utils.RomUtils;
import com.martian.ads.ad.AdConfig;
import com.ss.android.socialbase.appdownloader.g;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    public static String f21917a = null;

    /* renamed from: b */
    public static String f21918b = "";

    /* renamed from: c */
    public static String f21919c = null;

    /* renamed from: d */
    private static String f21920d = "";

    /* renamed from: e */
    private static String f21921e;

    /* renamed from: f */
    private static String f21922f;

    /* renamed from: g */
    private static String f21923g;

    /* renamed from: h */
    private static Boolean f21924h;

    public static boolean a() {
        return a("EMUI") || a("MAGICUI");
    }

    public static boolean b() {
        return a("MAGICUI");
    }

    public static boolean c() {
        return a("MIUI");
    }

    public static boolean d() {
        return a(AdConfig.UnionType.VIVO);
    }

    public static boolean e() {
        r();
        return a(f21917a);
    }

    public static boolean f() {
        return a("FLYME");
    }

    public static boolean g() {
        return a("SAMSUNG");
    }

    public static String h() {
        if (f21921e == null) {
            a("");
        }
        return f21921e;
    }

    public static String i() {
        if (f21922f == null) {
            a("");
        }
        return f21922f;
    }

    public static String j() {
        if (f21919c == null) {
            a("");
        }
        return f21919c;
    }

    @NonNull
    public static String k() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    @NonNull
    public static String l() {
        String str = Build.DISPLAY;
        return str == null ? "" : str.trim();
    }

    public static boolean m() {
        s();
        return "V10".equals(f21923g);
    }

    public static boolean n() {
        s();
        return "V11".equals(f21923g);
    }

    public static boolean o() {
        s();
        return "V12".equals(f21923g);
    }

    public static boolean p() {
        if (f21924h == null) {
            f21924h = Boolean.valueOf(d.g().equals("harmony"));
        }
        return f21924h.booleanValue();
    }

    public static boolean q() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("honor")) {
            String str2 = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str2) || !str2.toLowerCase().startsWith("honor")) {
                return false;
            }
        }
        return true;
    }

    private static void r() {
        if (TextUtils.isEmpty(f21917a)) {
            DownloadComponentManager.ensureOPPO();
            f21917a = DownloadConstants.UPPER_OPPO;
            f21920d = "ro.build.version." + DownloadConstants.LOWER_OPPO + "rom";
            f21918b = "com." + DownloadConstants.LOWER_OPPO + ".market";
        }
    }

    private static void s() {
        if (f21923g == null) {
            try {
                f21923g = d("ro.miui.ui.version.name");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            String str = f21923g;
            if (str == null) {
                str = "";
            }
            f21923g = str;
        }
    }

    public static boolean a(String str) {
        r();
        String str2 = f21921e;
        if (str2 != null) {
            return str2.equals(str);
        }
        String d10 = d("ro.miui.ui.version.name");
        f21922f = d10;
        if (TextUtils.isEmpty(d10)) {
            String d11 = d("ro.build.version.emui");
            f21922f = d11;
            if (TextUtils.isEmpty(d11)) {
                String d12 = d("ro.build.version.magic");
                f21922f = d12;
                if (TextUtils.isEmpty(d12)) {
                    String d13 = d(f21920d);
                    f21922f = d13;
                    if (TextUtils.isEmpty(d13)) {
                        String d14 = d("ro.vivo.os.version");
                        f21922f = d14;
                        if (TextUtils.isEmpty(d14)) {
                            String d15 = d("ro.smartisan.version");
                            f21922f = d15;
                            if (TextUtils.isEmpty(d15)) {
                                String d16 = d("ro.gn.sv.version");
                                f21922f = d16;
                                if (TextUtils.isEmpty(d16)) {
                                    String d17 = d("ro.lenovo.lvp.version");
                                    f21922f = d17;
                                    if (!TextUtils.isEmpty(d17)) {
                                        f21921e = "LENOVO";
                                        f21919c = "com.lenovo.leos.appstore";
                                    } else if (k().toUpperCase().contains("SAMSUNG")) {
                                        f21921e = "SAMSUNG";
                                        f21919c = "com.sec.android.app.samsungapps";
                                    } else if (k().toUpperCase().contains("ZTE")) {
                                        f21921e = "ZTE";
                                        f21919c = "zte.com.market";
                                    } else if (k().toUpperCase().contains("NUBIA")) {
                                        f21921e = "NUBIA";
                                        f21919c = "cn.nubia.neostore";
                                    } else if (l().toUpperCase().contains("FLYME")) {
                                        f21921e = "FLYME";
                                        f21919c = "com.meizu.mstore";
                                        f21922f = l();
                                    } else if (k().toUpperCase().contains("ONEPLUS")) {
                                        f21921e = "ONEPLUS";
                                        f21922f = d(RomUtils.B);
                                        if (g.a(f21918b) > -1) {
                                            f21919c = f21918b;
                                        } else {
                                            f21919c = "com.heytap.market";
                                        }
                                    } else {
                                        f21921e = k().toUpperCase();
                                        f21919c = "";
                                        f21922f = "";
                                    }
                                } else {
                                    f21921e = "QIONEE";
                                    f21919c = "com.gionee.aora.market";
                                }
                            } else {
                                f21921e = "SMARTISAN";
                                f21919c = "com.smartisanos.appstore";
                            }
                        } else {
                            f21921e = AdConfig.UnionType.VIVO;
                            f21919c = "com.bbk.appstore";
                        }
                    } else {
                        f21921e = f21917a;
                        if (g.a(f21918b) > -1) {
                            f21919c = f21918b;
                        } else {
                            f21919c = "com.heytap.market";
                        }
                    }
                } else {
                    f21921e = "MAGICUI";
                    f21919c = "com.hihonor.appmarket";
                }
            } else {
                String str3 = q() ? "MAGICUI" : "EMUI";
                f21921e = str3;
                if (TextUtils.equals(str3, "MAGICUI")) {
                    f21919c = "com.hihonor.appmarket";
                } else {
                    f21919c = "com.huawei.appmarket";
                }
            }
        } else {
            f21921e = "MIUI";
            f21919c = "com.xiaomi.market";
            f21923g = f21922f;
        }
        return f21921e.equals(str);
    }

    public static String b(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                DownloadUtils.safeClose(bufferedReader);
                return readLine;
            } catch (Throwable unused) {
                DownloadUtils.safeClose(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static String c(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
    }

    public static String d(String str) {
        if (!DownloadSetting.getGlobalSettings().optBoolean(DownloadSettingKeys.ENABLE_REFLECT_SYSTEM_PROPERTIES, true)) {
            return b(str);
        }
        try {
            return c(str);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return b(str);
        }
    }
}
