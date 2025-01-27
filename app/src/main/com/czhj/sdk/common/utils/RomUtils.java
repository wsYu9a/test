package com.czhj.sdk.common.utils;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import ke.e;
import p3.f;

/* loaded from: classes2.dex */
public final class RomUtils {
    public static final String A = "ro.build.MiFavor_version";
    public static final String B = "ro.rom.version";
    public static final String C = "ro.build.rom.id";
    public static final String D = "hw_sc.build.platform.version";
    public static final String E = "unknown";
    public static RomInfo F = null;

    /* renamed from: u, reason: collision with root package name */
    public static final String f8682u = "ro.build.version.emui";

    /* renamed from: v, reason: collision with root package name */
    public static final String f8683v = "ro.vivo.os.build.display.id";

    /* renamed from: w, reason: collision with root package name */
    public static final String f8684w = "ro.build.version.incremental";

    /* renamed from: y, reason: collision with root package name */
    public static final String f8686y = "ro.letv.release.version";

    /* renamed from: z, reason: collision with root package name */
    public static final String f8687z = "ro.build.uiversion";

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f8662a = {"EMUI", "huawei"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f8663b = {"FuntouchOS", e.f27807e};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f8664c = {"MIUI", "xiaomi"};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f8665d = {"ColorOS", "oppo"};

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f8666e = {"EUI", "letv"};

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f8667f = {"360", "qiku"};

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f8668g = {"zte"};

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f8669h = {"oneplus"};

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f8670i = {"NubiaUI", "nubia"};

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f8671j = {"coolpad", "yulong"};

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f8672k = {"lg", "lge"};

    /* renamed from: l, reason: collision with root package name */
    public static final String[] f8673l = {"google"};

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f8674m = {"samsung"};

    /* renamed from: n, reason: collision with root package name */
    public static final String[] f8675n = {"Flyme", "meizu"};

    /* renamed from: o, reason: collision with root package name */
    public static final String[] f8676o = {"lenovo"};

    /* renamed from: p, reason: collision with root package name */
    public static final String[] f8677p = {"SmartisanOS", "deltainno"};

    /* renamed from: q, reason: collision with root package name */
    public static final String[] f8678q = {"Sense", "htc"};

    /* renamed from: r, reason: collision with root package name */
    public static final String[] f8679r = {"sony"};

    /* renamed from: s, reason: collision with root package name */
    public static final String[] f8680s = {"amigo", "gionee"};

    /* renamed from: t, reason: collision with root package name */
    public static final String[] f8681t = {"motorola"};

    /* renamed from: x, reason: collision with root package name */
    public static final String[] f8685x = {"ro.build.version.opporom", "ro.build.version.oplusrom.display"};

    public static class RomInfo {

        /* renamed from: a, reason: collision with root package name */
        public String f8688a;

        /* renamed from: b, reason: collision with root package name */
        public String f8689b;

        /* renamed from: c, reason: collision with root package name */
        public String f8690c;

        public String getName() {
            return this.f8688a;
        }

        public String getOsMarket() {
            return this.f8690c;
        }

        public String getVersion() {
            return this.f8689b;
        }

        public String toString() {
            return "RomInfo{name=" + this.f8688a + ", version=" + this.f8689b + ", osMarket=" + this.f8690c + f.f29748d;
        }
    }

    public RomUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String a() {
        try {
            String str = Build.BRAND;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static String b() {
        try {
            String str = Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static String c(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused2) {
                    }
                    return readLine;
                }
            } catch (Throwable unused3) {
                if (bufferedReader == null) {
                    return "";
                }
                bufferedReader.close();
                return "";
            }
            bufferedReader.close();
            return "";
        } catch (Throwable unused4) {
            return "";
        }
    }

    public static String e(String str) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static RomInfo getRomInfo() {
        RomInfo romInfo;
        RomInfo romInfo2;
        String str;
        RomInfo romInfo3;
        String str2;
        RomInfo romInfo4;
        String str3;
        RomInfo romInfo5;
        String str4;
        RomInfo romInfo6;
        String str5;
        RomInfo romInfo7 = F;
        if (romInfo7 != null) {
            return romInfo7;
        }
        F = new RomInfo();
        String a10 = a();
        String b10 = b();
        if (c()) {
            F.f8688a = "harmony";
            romInfo6 = F;
            str5 = a("hw_sc.build.platform.version");
        } else {
            String[] strArr = f8662a;
            if (!a(a10, b10, strArr)) {
                String[] strArr2 = f8663b;
                if (a(a10, b10, strArr2)) {
                    F.f8688a = strArr2[0];
                    F.f8689b = a(f8683v);
                    romInfo4 = F;
                    str3 = "com.bbk.appstore";
                } else {
                    String[] strArr3 = f8664c;
                    if (!a(a10, b10, strArr3)) {
                        String[] strArr4 = f8665d;
                        if (a(a10, b10, strArr4)) {
                            F.f8688a = strArr4[0];
                            for (String str6 : f8685x) {
                                String a11 = a(str6);
                                if (!TextUtils.isEmpty(str6)) {
                                    F.f8689b = a11;
                                }
                            }
                            if (Build.VERSION.SDK_INT < 29) {
                                romInfo5 = F;
                                str4 = "com.oppo.market";
                            } else {
                                romInfo5 = F;
                                str4 = "com.heytap.market";
                            }
                            romInfo5.f8690c = str4;
                            return F;
                        }
                        String[] strArr5 = f8666e;
                        if (a(a10, b10, strArr5)) {
                            F.f8688a = strArr5[0];
                            romInfo3 = F;
                            str2 = f8686y;
                        } else {
                            String[] strArr6 = f8667f;
                            if (a(a10, b10, strArr6)) {
                                F.f8688a = strArr6[0];
                                romInfo3 = F;
                                str2 = f8687z;
                            } else {
                                String[] strArr7 = f8668g;
                                if (a(a10, b10, strArr7)) {
                                    F.f8688a = strArr7[0];
                                    romInfo3 = F;
                                    str2 = A;
                                } else {
                                    String[] strArr8 = f8669h;
                                    if (a(a10, b10, strArr8)) {
                                        F.f8688a = strArr8[0];
                                        romInfo3 = F;
                                        str2 = B;
                                    } else {
                                        String[] strArr9 = f8670i;
                                        if (a(a10, b10, strArr9)) {
                                            F.f8688a = strArr9[0];
                                            F.f8689b = a(C);
                                            romInfo4 = F;
                                            str3 = "cn.nubia.neostore";
                                        } else {
                                            String[] strArr10 = f8671j;
                                            if (a(a10, b10, strArr10)) {
                                                romInfo = F;
                                                b10 = strArr10[0];
                                            } else {
                                                String[] strArr11 = f8672k;
                                                if (a(a10, b10, strArr11)) {
                                                    romInfo = F;
                                                    b10 = strArr11[0];
                                                } else {
                                                    String[] strArr12 = f8673l;
                                                    if (a(a10, b10, strArr12)) {
                                                        romInfo = F;
                                                        b10 = strArr12[0];
                                                    } else {
                                                        String[] strArr13 = f8674m;
                                                        if (a(a10, b10, strArr13)) {
                                                            romInfo = F;
                                                            b10 = strArr13[0];
                                                        } else {
                                                            String[] strArr14 = f8675n;
                                                            if (a(a10, b10, strArr14)) {
                                                                F.f8688a = strArr14[0];
                                                                romInfo2 = F;
                                                                str = "com.meizu.mstore";
                                                            } else {
                                                                String[] strArr15 = f8676o;
                                                                if (a(a10, b10, strArr15)) {
                                                                    romInfo = F;
                                                                    b10 = strArr15[0];
                                                                } else {
                                                                    String[] strArr16 = f8677p;
                                                                    if (a(a10, b10, strArr16)) {
                                                                        F.f8688a = strArr16[0];
                                                                        romInfo2 = F;
                                                                        str = "com.smartisanos.appstore";
                                                                    } else {
                                                                        String[] strArr17 = f8678q;
                                                                        if (a(a10, b10, strArr17)) {
                                                                            romInfo = F;
                                                                            b10 = strArr17[0];
                                                                        } else {
                                                                            String[] strArr18 = f8679r;
                                                                            if (a(a10, b10, strArr18)) {
                                                                                romInfo = F;
                                                                                b10 = strArr18[0];
                                                                            } else {
                                                                                String[] strArr19 = f8680s;
                                                                                if (a(a10, b10, strArr19)) {
                                                                                    romInfo = F;
                                                                                    b10 = strArr19[0];
                                                                                } else {
                                                                                    String[] strArr20 = f8681t;
                                                                                    if (a(a10, b10, strArr20)) {
                                                                                        romInfo = F;
                                                                                        b10 = strArr20[0];
                                                                                    } else {
                                                                                        romInfo = F;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            romInfo2.f8690c = str;
                                                            romInfo3 = F;
                                                            str2 = "";
                                                        }
                                                    }
                                                }
                                            }
                                            romInfo.f8688a = b10;
                                            romInfo3 = F;
                                            str2 = "";
                                        }
                                    }
                                }
                            }
                        }
                        romInfo3.f8689b = a(str2);
                        return F;
                    }
                    F.f8688a = strArr3[0];
                    F.f8689b = a(f8684w);
                    romInfo4 = F;
                    str3 = "com.xiaomi.market";
                }
                romInfo4.f8690c = str3;
                return F;
            }
            F.f8688a = strArr[0];
            String a12 = a("ro.build.version.emui");
            String[] split = a12.split(hf.e.f26694a);
            if (split.length <= 1) {
                F.f8689b = a12;
                F.f8690c = "com.huawei.appmarket";
                return F;
            }
            romInfo6 = F;
            str5 = split[1];
        }
        romInfo6.f8689b = str5;
        F.f8690c = "com.huawei.appmarket";
        return F;
    }

    public static boolean is360() {
        return f8667f[0].equals(getRomInfo().f8688a);
    }

    public static boolean isCoolpad() {
        return f8671j[0].equals(getRomInfo().f8688a);
    }

    public static boolean isGionee() {
        return f8680s[0].equals(getRomInfo().f8688a);
    }

    public static boolean isGoogle() {
        return f8673l[0].equals(getRomInfo().f8688a);
    }

    public static boolean isHtc() {
        return f8678q[0].equals(getRomInfo().f8688a);
    }

    public static boolean isHuawei() {
        return f8662a[0].equals(getRomInfo().f8688a) || c();
    }

    public static boolean isLeeco() {
        return f8666e[0].equals(getRomInfo().f8688a);
    }

    public static boolean isLenovo() {
        return f8676o[0].equals(getRomInfo().f8688a);
    }

    public static boolean isLg() {
        return f8672k[0].equals(getRomInfo().f8688a);
    }

    public static boolean isMeizu() {
        return f8675n[0].equals(getRomInfo().f8688a);
    }

    public static boolean isMotorola() {
        return f8681t[0].equals(getRomInfo().f8688a);
    }

    public static boolean isNubia() {
        return f8670i[0].equals(getRomInfo().f8688a);
    }

    public static boolean isOneplus() {
        return f8669h[0].equals(getRomInfo().f8688a);
    }

    public static boolean isOppo() {
        return f8665d[0].equals(getRomInfo().f8688a);
    }

    public static boolean isSamsung() {
        return f8674m[0].equals(getRomInfo().f8688a);
    }

    public static boolean isSmartisan() {
        return f8677p[0].equals(getRomInfo().f8688a);
    }

    public static boolean isSony() {
        return f8679r[0].equals(getRomInfo().f8688a);
    }

    public static boolean isVivo() {
        return f8663b[0].equals(getRomInfo().f8688a);
    }

    public static boolean isXiaomi() {
        return f8664c[0].equals(getRomInfo().f8688a);
    }

    public static boolean isZte() {
        return f8668g[0].equals(getRomInfo().f8688a);
    }

    public static String a(String str) {
        String b10 = !TextUtils.isEmpty(str) ? b(str) : "";
        if (TextUtils.isEmpty(b10) || b10.equals("unknown")) {
            try {
                String str2 = Build.DISPLAY;
                if (!TextUtils.isEmpty(str2)) {
                    b10 = str2.toLowerCase();
                }
            } catch (Throwable unused) {
            }
        }
        return TextUtils.isEmpty(b10) ? "unknown" : b10;
    }

    public static String b(String str) {
        String d10 = d(str);
        if (!TextUtils.isEmpty(d10)) {
            return d10;
        }
        String e10 = e(str);
        return (TextUtils.isEmpty(e10) && Build.VERSION.SDK_INT < 28) ? c(str) : e10;
    }

    public static boolean c() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Object invoke = cls.getMethod("getOsBrand", null).invoke(cls, null);
            if (invoke == null) {
                return false;
            }
            return "harmony".equalsIgnoreCase(invoke.toString());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }
}
