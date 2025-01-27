package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.media.AudioManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.Os;
import android.system.StructStat;
import android.system.StructTimespec;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.service.ServiceProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/* loaded from: classes2.dex */
public final class bd {
    private static String aAT = null;
    private static String aAU = "";
    private static boolean aAV = false;
    private static String aAW = "";
    private static String aAX = "";
    private static int aAY = 0;
    private static boolean aAZ = false;
    private static int aBa = 0;
    private static boolean aBb = false;
    private static String aBd = "";
    private static String aBe = "";
    private static String aBf = "";
    private static String aBg = null;
    private static String aBh = null;
    private static int aBi = -1;
    private static boolean aBj = false;
    private static boolean aBk = false;
    private static boolean aBl = false;
    private static boolean aBm = false;
    private static boolean aBn = false;
    private static boolean aBo = false;
    private static int aBp = 0;
    private static long aBq = 0;
    private static String aBr = "";
    private static String aBs = "";
    private static final String[] aBc = {"", ""};
    private static final List<String> aBt = Arrays.asList("a5f5faddde9e9f02", "8e17f7422b35fbea", "b88c3c236923d9d9", "cb36bf76cca443d0", "5d4e49ed381836c5", "cffa38e9136f93e9", "62bd2daa59ea0173", "b7aad49a2d5bc5d9", "f2138912c5e5dd5c", "330a1e81a2bf9f31", "59c0f432ccbef844", "521376155e535f39", "aa5ec6ce14abd680", "5522a09bb500d82f", "6dfe4a96800edfb4", "ecc9a2dded8cdf72", "399f868043955b11", "34dc327c00dbff94", "d1b4e3862c309f8b", "68bdbf71f863ccac", "01558dd995085a35", "351174200a06da52", "fa0988506c76ff4b", "8eb8ef823312c61a", "a72e81be65c4638b", "416d15a015c8f324", "474086ea2d737519", "befdddf908c8d749", "780ee58a6f57aab6", "cfe86fa07cae3601", "704ff4d1534f0ff4", "9298b9e9bbd7cdea", "7b634c42f236c6e8", "11eacf22b9ceab7d", "2941a4f39eec5864", "87d134dc5ba45550", "fdd2313bb1750eb9", "6560ef232d8424bb", "5d876286e1064482", "f66fefb916f4962d", "7baf82d0ac49f596", "57748921d8d88ed4", "120cd57f1a50b8f5", "e164f9610ddd9fc8", "6256f0e8da6389de", "bcb22df712476416", "714fa9aff63f7adb", "cb8252e4da7cf610", "e18f649aa80e140c", "966790a9db5ea8d8", "e1769e681af901dd", "d23f2574a60964a4", "d717e6298d3c9cb2", "f5ea5e8ba730864e", "a8a0a223d1a42232", "6675a4f231f5c8db", "3edb7c2103e5c75a", "8ce6a9a216b326c4", "af606153eb3be0a7", "7ae255c3d760c920", "e50e94c40048c5fd", "55009bca30f9dc4c", "c37566487909214a", "891b74f7e534d14a", "726e190aae663525", "df473127d30fb669", "bfbcc646d92dfd48", "a4a1954c44751936", "da4a44a3d7c4d8be", "5ff5bca4a775dd30", "14917461e1917c53", "14ce20d0a80955fa", "a56a63de4d3f3d39", "f780246adc7bd556", "3495a541aea0da72", "f7f205ce47fed2a5", "f52db3f434279c3a", "dca17088c97dee5e", "dd53a8b3a2a4ccc0", "52e07629290d45e4", "cda522b0f8f50d9a", "b85a1c8bcd51d82c", "e344a00cd3f5e93a", "fa59d8a66d7bdd88", "68fb1f1393a216e8", "4c30ab1fb10af181", "b1376e0578099143", "88752f72d8d305fd", "fddf20078d27bf3c", "dab2120bffa2be8c", "c7c8dde481793471", "e4b1bdbcabfc284d");

    private static long EA() {
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return 0L;
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    throw th;
                }
            } while (!readLine.contains("MemTotal"));
            long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue() << 10;
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            return longValue;
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static long EC() {
        return com.kwad.sdk.crash.utils.h.F(Environment.getDataDirectory());
    }

    public static long ED() {
        if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(1024L)) {
            return 0L;
        }
        return com.kwad.sdk.crash.utils.h.E(Environment.getDataDirectory());
    }

    public static int EE() {
        int i2 = aBp;
        if (i2 > 0) {
            return i2;
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        aBp = availableProcessors;
        return availableProcessors;
    }

    public static String EF() {
        return Build.MODEL;
    }

    public static synchronized long EG() {
        long j2;
        synchronized (bd.class) {
            j2 = 0;
            if (at.DW() && (!TextUtils.isEmpty(at.DX()) || at.DY() != null)) {
                j2 = 1;
            }
            if (at.DU() && at.DV() != null) {
                j2 |= 64;
            }
            if (at.DW() && !TextUtils.isEmpty(at.DZ())) {
                j2 |= 2;
            }
            if (at.Ea() && !TextUtils.isEmpty(at.Eb())) {
                j2 |= 4;
            }
            if (at.Ec() && !TextUtils.isEmpty(at.Ed())) {
                j2 |= 2048;
            }
            if (at.Eg()) {
                if (at.Eh() != null) {
                    j2 |= 16;
                }
            }
        }
        return j2;
    }

    public static String EH() {
        return Build.BRAND;
    }

    public static synchronized long EI() {
        long elapsedRealtime;
        synchronized (bd.class) {
            elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
        }
        return elapsedRealtime;
    }

    public static synchronized long EJ() {
        long j2;
        synchronized (bd.class) {
            j2 = Build.TIME;
        }
        return j2;
    }

    public static synchronized String EK() {
        String str;
        synchronized (bd.class) {
            str = Build.FINGERPRINT;
        }
        return str;
    }

    public static synchronized String EL() {
        synchronized (bd.class) {
            if (!TextUtils.isEmpty(aAT)) {
                return aAT;
            }
            String radioVersion = Build.getRadioVersion();
            aAT = radioVersion;
            return radioVersion;
        }
    }

    public static synchronized String EM() {
        String name;
        synchronized (bd.class) {
            name = as.getName();
        }
        return name;
    }

    public static synchronized String EN() {
        String version;
        synchronized (bd.class) {
            version = as.getVersion();
        }
        return version;
    }

    public static String EO() {
        return Build.MANUFACTURER;
    }

    public static int EP() {
        if (aBi == -1) {
            aBi = cZ(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext()) ? 4 : 3;
        }
        return aBi;
    }

    public static String EQ() {
        if (TextUtils.isEmpty(aBh)) {
            aBh = System.getProperty("os.arch");
        }
        return aBh;
    }

    public static int ER() {
        return Build.VERSION.SDK_INT;
    }

    public static String ES() {
        if (at.Ee() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(8L)) {
            return "";
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if ((nextElement instanceof Inet4Address) && !nextElement.isLoopbackAddress()) {
                        return nextElement.getHostAddress();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    private static String ET() {
        try {
            return a(Long.toHexString(new Random(System.currentTimeMillis()).nextLong()), 16, '0');
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String EU() {
        if (((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext() == null) {
            return null;
        }
        String h2 = y.h("ksadsdk_pref", "android_id", (String) null);
        y.i(h2, "ksadsdk_pref", "android_id");
        return h2;
    }

    public static String EV() {
        if (!TextUtils.isEmpty(aBr)) {
            return aBr;
        }
        try {
            String Q = q.Q(new File("/proc/sys/kernel/random/boot_id"));
            aBr = TextUtils.isEmpty(Q) ? "" : Q.substring(0, Q.indexOf("\n"));
        } catch (Throwable unused) {
        }
        return aBr;
    }

    private static String a(String str, int i2, char c2) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + str.length() < 16) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }

    public static String bI(boolean z) {
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        String aR = com.kwad.sdk.core.e.a.aR(context);
        return (TextUtils.isEmpty(aR) && !z && TextUtils.isEmpty(cS(context))) ? ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sC() : aR;
    }

    public static long cP(Context context) {
        if (context == null || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(1024L)) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static int cQ(Context context) {
        if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(512L)) {
            return 0;
        }
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((BatteryManager) context.getApplicationContext().getSystemService("batterymanager")).getIntProperty(4);
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public static long cR(Context context) {
        long j2 = aBq;
        if (j2 > 0) {
            return j2;
        }
        if (context == null) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long j3 = memoryInfo.totalMem;
            if (j3 <= 0) {
                j3 = EA();
            }
            aBq = j3;
            return j3;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    private static synchronized String cS(@Nullable Context context) {
        synchronized (bd.class) {
            if (at.DW() && !TextUtils.isEmpty(at.DX())) {
                return at.DX();
            }
            if (aBj) {
                return aAW;
            }
            if (TextUtils.isEmpty(aAW) && context != null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    return aAW;
                }
                if (at.DW()) {
                    return aAW;
                }
                if (!o.CZ()) {
                    return aAW;
                }
                boolean z = false;
                try {
                    z = SystemUtil.cO(context);
                    if (z) {
                        String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                        aAW = deviceId;
                        if (TextUtils.isEmpty(deviceId)) {
                            aBj = true;
                        }
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.b.printStackTrace(e2);
                    if (z) {
                        aBj = true;
                    }
                }
                return aAW;
            }
            return aAW;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004c, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) != false) goto L90;
     */
    @android.annotation.SuppressLint({"HardwareIds", "MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized java.lang.String cT(@androidx.annotation.Nullable android.content.Context r5) {
        /*
            java.lang.Class<com.kwad.sdk.utils.bd> r0 = com.kwad.sdk.utils.bd.class
            monitor-enter(r0)
            boolean r1 = com.kwad.sdk.utils.bd.aBo     // Catch: java.lang.Throwable -> L79
            if (r1 == 0) goto Lb
            java.lang.String r5 = com.kwad.sdk.utils.bd.aAX     // Catch: java.lang.Throwable -> L79
            monitor-exit(r0)
            return r5
        Lb:
            java.lang.String r1 = com.kwad.sdk.utils.bd.aAX     // Catch: java.lang.Throwable -> L79
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L79
            if (r1 == 0) goto L75
            if (r5 != 0) goto L16
            goto L75
        L16:
            boolean r1 = com.kwad.sdk.utils.at.DW()     // Catch: java.lang.Throwable -> L79
            if (r1 == 0) goto L20
            java.lang.String r5 = com.kwad.sdk.utils.bd.aAX     // Catch: java.lang.Throwable -> L79
            monitor-exit(r0)
            return r5
        L20:
            boolean r1 = com.kwad.sdk.utils.o.CY()     // Catch: java.lang.Throwable -> L79
            if (r1 != 0) goto L2a
            java.lang.String r5 = com.kwad.sdk.utils.bd.aBf     // Catch: java.lang.Throwable -> L79
            monitor-exit(r0)
            return r5
        L2a:
            r1 = 0
            r2 = 1
            boolean r1 = com.kwad.sdk.utils.SystemUtil.cO(r5)     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L79
            if (r1 == 0) goto L71
            java.lang.String r3 = "phone"
            java.lang.Object r5 = r5.getSystemService(r3)     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L79
            android.telephony.TelephonyManager r5 = (android.telephony.TelephonyManager) r5     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L79
            if (r5 == 0) goto L71
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L79
            r4 = 26
            if (r3 < r4) goto L51
            java.lang.String r5 = r5.getMeid()     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L79
            com.kwad.sdk.utils.bd.aAX = r5     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L79
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L79
            if (r5 == 0) goto L71
        L4e:
            com.kwad.sdk.utils.bd.aBo = r2     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L79
            goto L71
        L51:
            int r3 = r5.getPhoneType()     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L79
            r4 = 2
            if (r3 != r4) goto L65
            java.lang.String r5 = r5.getDeviceId()     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L79
            com.kwad.sdk.utils.bd.aAX = r5     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L79
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L79
            if (r5 == 0) goto L71
            goto L4e
        L65:
            r5 = 0
            com.kwad.sdk.utils.bd.aAX = r5     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L79
            goto L4e
        L69:
            r5 = move-exception
            com.kwad.sdk.core.d.b.printStackTrace(r5)     // Catch: java.lang.Throwable -> L79
            if (r1 == 0) goto L71
            com.kwad.sdk.utils.bd.aBo = r2     // Catch: java.lang.Throwable -> L79
        L71:
            java.lang.String r5 = com.kwad.sdk.utils.bd.aAX     // Catch: java.lang.Throwable -> L79
            monitor-exit(r0)
            return r5
        L75:
            java.lang.String r5 = com.kwad.sdk.utils.bd.aAX     // Catch: java.lang.Throwable -> L79
            monitor-exit(r0)
            return r5
        L79:
            r5 = move-exception
            monitor-exit(r0)
            goto L7d
        L7c:
            throw r5
        L7d:
            goto L7c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.bd.cT(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x008a, code lost:
    
        if (android.text.TextUtils.isEmpty(r10[1]) != false) goto L135;
     */
    @android.annotation.SuppressLint({"HardwareIds", "MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized java.lang.String[] cU(@androidx.annotation.Nullable android.content.Context r10) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.bd.cU(android.content.Context):java.lang.String[]");
    }

    public static synchronized int cV(Context context) {
        synchronized (bd.class) {
            if (aAZ || aAY > 0 || Build.VERSION.SDK_INT < 23 || context == null || at.DW()) {
                return aAY;
            }
            try {
                aAY = ((TelephonyManager) context.getSystemService("phone")).getPhoneCount();
            } catch (Exception unused) {
            }
            int i2 = aAY;
            aAZ = i2 == 0;
            return i2;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static int cW(Context context) {
        if (context == null || aBa > 0 || aBb || Build.VERSION.SDK_INT < 22 || !SystemUtil.cO(context) || at.DW()) {
            return aBa;
        }
        try {
            aBa = ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoCount();
        } catch (Throwable unused) {
        }
        int i2 = aBa;
        aBb = i2 != 0;
        return i2;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String cX(Context context) {
        if (!TextUtils.isEmpty(aBe) || context == null) {
            return aBe;
        }
        if (!aBl && !at.DW() && o.Db()) {
            try {
                if (SystemUtil.cO(context)) {
                    aBe = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSimSerialNumber();
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
                aBe = null;
            }
            if (TextUtils.isEmpty(aBe)) {
                aBl = true;
            }
            String str = TextUtils.isEmpty(aBe) ? "" : aBe;
            aBe = str;
            return str;
        }
        return aBe;
    }

    public static synchronized int cY(Context context) {
        int ringerMode;
        synchronized (bd.class) {
            ringerMode = ((AudioManager) context.getSystemService("audio")).getRingerMode();
        }
        return ringerMode;
    }

    private static boolean cZ(Context context) {
        return (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) ? false : true;
    }

    public static int checkSelfPermission(@NonNull Context context, @NonNull String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    @SuppressLint({"HardwareIds"})
    public static String cm(Context context) {
        if (!TextUtils.isEmpty(aBf) || context == null || aBm) {
            return aBf;
        }
        if (at.DW()) {
            return at.DZ();
        }
        if (!o.CU()) {
            return aBf;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            aBf = string;
            if (!eT(string)) {
                aBf = "";
            }
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(aBf)) {
            aBm = true;
        }
        return aBf;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String cq(Context context) {
        synchronized (bd.class) {
            if (context != null) {
                if (!aBk && TextUtils.isEmpty(aBd) && SystemUtil.cO(context) && !at.DW() && o.Da()) {
                    try {
                        aBd = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSubscriberId();
                    } catch (Exception unused) {
                    }
                    aBk = TextUtils.isEmpty(aBd);
                    return aBd;
                }
            }
            return aBd;
        }
    }

    @SuppressLint({"HardwareIds"})
    public static synchronized String da(@Nullable Context context) {
        synchronized (bd.class) {
            if (TextUtils.isEmpty(aAU) && context != null && !aAV) {
                if (at.Ea()) {
                    String Eb = at.Eb();
                    aAU = Eb;
                    return Eb;
                }
                if (!o.CV()) {
                    return aAU;
                }
                try {
                    WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService(com.alipay.mobilesecuritysdk.constant.a.I)).getConnectionInfo();
                    if (connectionInfo != null) {
                        aAU = connectionInfo.getMacAddress();
                    }
                    if (eR(aAU)) {
                        Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            NetworkInterface networkInterface = (NetworkInterface) it.next();
                            if (networkInterface != null && "wlan0".equals(networkInterface.getName())) {
                                byte[] hardwareAddress = networkInterface.getHardwareAddress();
                                if (hardwareAddress != null && hardwareAddress.length != 0) {
                                    StringBuilder sb = new StringBuilder();
                                    for (byte b2 : hardwareAddress) {
                                        sb.append(String.format("%02X:", Byte.valueOf(b2)));
                                    }
                                    if (sb.length() > 0) {
                                        sb.deleteCharAt(sb.length() - 1);
                                    }
                                    aAU = sb.toString();
                                }
                            }
                        }
                    }
                    if (eR(aAU)) {
                        aAU = com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream());
                    }
                    if (!eR(aAU)) {
                        aAU = aAU.toUpperCase(Locale.US);
                    }
                } catch (Exception unused) {
                    aAV = true;
                }
                aAV = eR(aAU);
                return aAU;
            }
            return aAU;
        }
    }

    @Nullable
    public static List<String> db(@NonNull Context context) {
        String[] list;
        if (!c.bw(context) && dc(context)) {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data");
            if (!file.exists() || !file.isDirectory() || (list = file.list()) == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (!TextUtils.isEmpty(str) && !str.startsWith(".")) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public static boolean dc(@NonNull Context context) {
        return context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f9325j) == 0;
    }

    private static boolean eR(String str) {
        return TextUtils.isEmpty(str) || str.equals("02:00:00:00:00:00");
    }

    private static boolean eS(String str) {
        return aBt.contains(str.toLowerCase(Locale.US));
    }

    private static boolean eT(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            try {
                if (str.charAt(i2) != '0') {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static void eU(String str) {
        if (((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext() == null) {
            return;
        }
        y.a("ksadsdk_pref", "android_id", str, true);
    }

    public static String eV(String str) {
        String valueOf;
        if (!TextUtils.isEmpty(aBs) || TextUtils.isEmpty(str)) {
            return aBs;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            try {
                StructStat stat = Os.stat(str);
                if (stat == null) {
                    return aBs;
                }
                String str2 = "";
                if (i2 >= 27) {
                    StructTimespec structTimespec = stat.st_atim;
                    if (structTimespec == null) {
                        valueOf = "";
                    } else {
                        str2 = String.valueOf(structTimespec.tv_sec);
                        valueOf = String.valueOf(stat.st_atim.tv_nsec);
                    }
                    aBs = str2 + "." + valueOf;
                } else {
                    long j2 = stat.st_atime;
                    if (j2 != 0) {
                        str2 = String.valueOf(j2);
                    }
                    aBs = str2;
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
        return aBs;
    }

    public static String getDeviceId() {
        try {
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        if (!TextUtils.isEmpty(aBg)) {
            return aBg;
        }
        String EU = EU();
        if (!TextUtils.isEmpty(EU)) {
            String str = "ANDROID_" + EU;
            aBg = str;
            return str;
        }
        String cm = cm(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext());
        if (!TextUtils.isEmpty(cm) && !eS(cm) && eT(cm)) {
            String str2 = "ANDROID_" + cm;
            aBg = str2;
            return str2;
        }
        String ET = ET();
        if (!TextUtils.isEmpty(ET)) {
            aBg = "ANDROID_" + ET;
            eU(ET);
            return aBg;
        }
        return "ANDROID_";
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getLocale() {
        Locale locale = Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
        if (locale == null) {
            locale = Locale.CHINESE;
        }
        return String.valueOf(locale);
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getScreenHeight(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getScreenWidth(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String u(@Nullable Context context, boolean z) {
        if (at.DW() && !TextUtils.isEmpty(at.DX())) {
            return at.DX();
        }
        String cS = cS(context);
        return (TextUtils.isEmpty(cS) && !z && TextUtils.isEmpty(com.kwad.sdk.core.e.a.aR(context))) ? ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sB() : cS;
    }
}
