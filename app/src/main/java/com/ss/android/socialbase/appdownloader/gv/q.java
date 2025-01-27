package com.ss.android.socialbase.appdownloader.gv;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.cdo.oaps.ad.af;
import com.martian.mipush.d;
import com.ss.android.socialbase.appdownloader.lg;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* loaded from: classes4.dex */
public class q {

    /* renamed from: g */
    private static String f24458g = "";
    private static String gv = null;

    /* renamed from: i */
    public static String f24459i = null;

    /* renamed from: j */
    public static String f24460j = null;
    private static String lg = null;
    private static String q = null;
    private static Boolean y = null;
    public static String zx = "";

    private static void ei() {
        if (lg == null) {
            try {
                lg = g("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = lg;
            if (str == null) {
                str = "";
            }
            lg = str;
        }
    }

    public static boolean g() {
        s();
        return j(f24460j);
    }

    public static boolean gv() {
        return j("SAMSUNG");
    }

    public static boolean i() {
        return j("VIVO");
    }

    public static boolean j() {
        return j(d.f14902c);
    }

    public static String k() {
        if (f24459i == null) {
            j("");
        }
        return f24459i;
    }

    public static String lg() {
        if (q == null) {
            j("");
        }
        return q;
    }

    public static boolean nt() {
        ei();
        return "V10".equals(lg);
    }

    public static boolean p() {
        ei();
        return "V11".equals(lg);
    }

    @NonNull
    public static String pa() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static boolean q() {
        return j(d.f14903d);
    }

    public static boolean r() {
        ei();
        return "V12".equals(lg);
    }

    private static void s() {
        if (TextUtils.isEmpty(f24460j)) {
            DownloadComponentManager.ensureOPPO();
            f24460j = DownloadConstants.UPPER_OPPO;
            f24458g = "ro.build.version." + DownloadConstants.LOWER_OPPO + "rom";
            zx = "com." + DownloadConstants.LOWER_OPPO + ".market";
        }
    }

    @NonNull
    public static String t() {
        String str = Build.DISPLAY;
        return str == null ? "" : str.trim();
    }

    public static boolean w() {
        if (y == null) {
            y = Boolean.valueOf(g.lg().equals("harmony"));
        }
        return y.booleanValue();
    }

    public static String y() {
        if (gv == null) {
            j("");
        }
        return gv;
    }

    public static boolean zx() {
        return j(d.f14901b);
    }

    public static String i(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
    }

    public static boolean j(String str) {
        s();
        String str2 = q;
        if (str2 != null) {
            return str2.equals(str);
        }
        String g2 = g("ro.miui.ui.version.name");
        gv = g2;
        if (TextUtils.isEmpty(g2)) {
            String g3 = g("ro.build.version.emui");
            gv = g3;
            if (TextUtils.isEmpty(g3)) {
                String g4 = g(f24458g);
                gv = g4;
                if (TextUtils.isEmpty(g4)) {
                    String g5 = g("ro.vivo.os.version");
                    gv = g5;
                    if (TextUtils.isEmpty(g5)) {
                        String g6 = g("ro.smartisan.version");
                        gv = g6;
                        if (TextUtils.isEmpty(g6)) {
                            String g7 = g("ro.gn.sv.version");
                            gv = g7;
                            if (TextUtils.isEmpty(g7)) {
                                String g8 = g("ro.lenovo.lvp.version");
                                gv = g8;
                                if (!TextUtils.isEmpty(g8)) {
                                    q = "LENOVO";
                                    f24459i = "com.lenovo.leos.appstore";
                                } else if (pa().toUpperCase().contains("SAMSUNG")) {
                                    q = "SAMSUNG";
                                    f24459i = "com.sec.android.app.samsungapps";
                                } else if (pa().toUpperCase().contains("ZTE")) {
                                    q = "ZTE";
                                    f24459i = "zte.com.market";
                                } else if (pa().toUpperCase().contains("NUBIA")) {
                                    q = "NUBIA";
                                    f24459i = "cn.nubia.neostore";
                                } else if (t().toUpperCase().contains(d.f14903d)) {
                                    q = d.f14903d;
                                    f24459i = "com.meizu.mstore";
                                    gv = t();
                                } else if (pa().toUpperCase().contains("ONEPLUS")) {
                                    q = "ONEPLUS";
                                    gv = g("ro.rom.version");
                                    if (lg.j(zx) > -1) {
                                        f24459i = zx;
                                    } else {
                                        f24459i = af.f6508e;
                                    }
                                } else {
                                    q = pa().toUpperCase();
                                    f24459i = "";
                                    gv = "";
                                }
                            } else {
                                q = "QIONEE";
                                f24459i = "com.gionee.aora.market";
                            }
                        } else {
                            q = d.f14905f;
                            f24459i = "com.smartisanos.appstore";
                        }
                    } else {
                        q = "VIVO";
                        f24459i = "com.bbk.appstore";
                    }
                } else {
                    q = f24460j;
                    if (lg.j(zx) > -1) {
                        f24459i = zx;
                    } else {
                        f24459i = af.f6508e;
                    }
                }
            } else {
                q = d.f14902c;
                f24459i = "com.huawei.appmarket";
            }
        } else {
            q = d.f14901b;
            f24459i = "com.xiaomi.market";
            lg = gv;
        }
        return q.equals(str);
    }

    public static String zx(String str) {
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

    public static String g(String str) {
        if (DownloadSetting.getGlobalSettings().optBoolean(DownloadSettingKeys.ENABLE_REFLECT_SYSTEM_PROPERTIES, true)) {
            try {
                return i(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return zx(str);
            }
        }
        return zx(str);
    }
}
