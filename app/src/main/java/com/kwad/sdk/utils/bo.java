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

/* loaded from: classes3.dex */
public final class bo {
    private static String aVc = null;
    private static String aVd = "";
    private static boolean aVe = false;
    private static String aVf = "";
    private static String aVg = "";
    private static int aVh = 0;
    private static boolean aVi = false;
    private static int aVj = 0;
    private static boolean aVk = false;
    private static String aVp;
    private static String aVq;
    private static int aVy;
    private static long aVz;
    private static final String[] aVl = {"", ""};
    private static String aVm = "";
    private static String aVn = "";
    private static String aVo = "";
    private static int aVr = -1;
    private static boolean aVs = false;
    private static boolean aVt = false;
    private static boolean aVu = false;
    private static boolean aVv = false;
    private static boolean aVw = false;
    private static boolean aVx = false;
    private static String aVA = "";
    private static String aVB = "";
    public static String aVC = "";
    private static final List<String> aVD = Arrays.asList("a5f5faddde9e9f02", "8e17f7422b35fbea", "b88c3c236923d9d9", "cb36bf76cca443d0", "5d4e49ed381836c5", "cffa38e9136f93e9", "62bd2daa59ea0173", "b7aad49a2d5bc5d9", "f2138912c5e5dd5c", "330a1e81a2bf9f31", "59c0f432ccbef844", "521376155e535f39", "aa5ec6ce14abd680", "5522a09bb500d82f", "6dfe4a96800edfb4", "ecc9a2dded8cdf72", "399f868043955b11", "34dc327c00dbff94", "d1b4e3862c309f8b", "68bdbf71f863ccac", "01558dd995085a35", "351174200a06da52", "fa0988506c76ff4b", "8eb8ef823312c61a", "a72e81be65c4638b", "416d15a015c8f324", "474086ea2d737519", "befdddf908c8d749", "780ee58a6f57aab6", "cfe86fa07cae3601", "704ff4d1534f0ff4", "9298b9e9bbd7cdea", "7b634c42f236c6e8", "11eacf22b9ceab7d", "2941a4f39eec5864", "87d134dc5ba45550", "fdd2313bb1750eb9", "6560ef232d8424bb", "5d876286e1064482", "f66fefb916f4962d", "7baf82d0ac49f596", "57748921d8d88ed4", "120cd57f1a50b8f5", "e164f9610ddd9fc8", "6256f0e8da6389de", "bcb22df712476416", "714fa9aff63f7adb", "cb8252e4da7cf610", "e18f649aa80e140c", "966790a9db5ea8d8", "e1769e681af901dd", "d23f2574a60964a4", "d717e6298d3c9cb2", "f5ea5e8ba730864e", "a8a0a223d1a42232", "6675a4f231f5c8db", "3edb7c2103e5c75a", "8ce6a9a216b326c4", "af606153eb3be0a7", "7ae255c3d760c920", "e50e94c40048c5fd", "55009bca30f9dc4c", "c37566487909214a", "891b74f7e534d14a", "726e190aae663525", "df473127d30fb669", "bfbcc646d92dfd48", "a4a1954c44751936", "da4a44a3d7c4d8be", "5ff5bca4a775dd30", "14917461e1917c53", "14ce20d0a80955fa", "a56a63de4d3f3d39", "f780246adc7bd556", "3495a541aea0da72", "f7f205ce47fed2a5", "f52db3f434279c3a", "dca17088c97dee5e", "dd53a8b3a2a4ccc0", "52e07629290d45e4", "cda522b0f8f50d9a", "b85a1c8bcd51d82c", "e344a00cd3f5e93a", "fa59d8a66d7bdd88", "68fb1f1393a216e8", "4c30ab1fb10af181", "b1376e0578099143", "88752f72d8d305fd", "fddf20078d27bf3c", "dab2120bffa2be8c", "c7c8dde481793471", "e4b1bdbcabfc284d");

    private static long OP() {
        BufferedReader bufferedReader;
        Throwable th2;
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
                } catch (Throwable th3) {
                    th2 = th3;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    throw th2;
                }
            } while (!readLine.contains("MemTotal"));
            long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue() << 10;
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            return longValue;
        } catch (Exception unused2) {
        } catch (Throwable th4) {
            bufferedReader = null;
            th2 = th4;
        }
    }

    public static long OR() {
        return com.kwad.sdk.crash.utils.h.L(Environment.getDataDirectory());
    }

    public static long OS() {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ac(1024L)) {
            return 0L;
        }
        return com.kwad.sdk.crash.utils.h.K(Environment.getDataDirectory());
    }

    public static long OT() {
        long freeMemory;
        try {
            freeMemory = Runtime.getRuntime().freeMemory();
        } catch (Throwable unused) {
        }
        if (freeMemory > 0) {
            return freeMemory;
        }
        return 0L;
    }

    public static int OU() {
        int i10 = aVy;
        if (i10 > 0) {
            return i10;
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        aVy = availableProcessors;
        return availableProcessors;
    }

    public static String OV() {
        return Build.MODEL;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006f A[Catch: all -> 0x001a, TRY_LEAVE, TryCatch #0 {all -> 0x001a, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x0013, B:12:0x0021, B:14:0x0027, B:16:0x002d, B:17:0x0030, B:19:0x0036, B:21:0x0040, B:22:0x0043, B:24:0x0049, B:26:0x0053, B:27:0x0056, B:29:0x005c, B:31:0x0066, B:32:0x0069, B:34:0x006f), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized long OW() {
        /*
            java.lang.Class<com.kwad.sdk.utils.bo> r0 = com.kwad.sdk.utils.bo.class
            monitor-enter(r0)
            boolean r1 = com.kwad.sdk.utils.az.usePhoneStateDisable()     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L1f
            java.lang.String r1 = com.kwad.sdk.utils.az.Od()     // Catch: java.lang.Throwable -> L1a
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L1c
            java.lang.String[] r1 = com.kwad.sdk.utils.az.Oe()     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L1f
            goto L1c
        L1a:
            r1 = move-exception
            goto L7a
        L1c:
            r1 = 1
            goto L21
        L1f:
            r1 = 0
        L21:
            boolean r3 = com.kwad.sdk.utils.az.Ob()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L30
            android.location.Location r3 = com.kwad.sdk.utils.az.Oc()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L30
            r3 = 64
            long r1 = r1 | r3
        L30:
            boolean r3 = com.kwad.sdk.utils.az.usePhoneStateDisable()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L43
            java.lang.String r3 = com.kwad.sdk.utils.az.Of()     // Catch: java.lang.Throwable -> L1a
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L1a
            if (r3 != 0) goto L43
            r3 = 2
            long r1 = r1 | r3
        L43:
            boolean r3 = com.kwad.sdk.utils.az.Og()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L56
            java.lang.String r3 = com.kwad.sdk.utils.az.Oh()     // Catch: java.lang.Throwable -> L1a
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L1a
            if (r3 != 0) goto L56
            r3 = 4
            long r1 = r1 | r3
        L56:
            boolean r3 = com.kwad.sdk.utils.az.Oi()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L69
            java.lang.String r3 = com.kwad.sdk.utils.az.Oj()     // Catch: java.lang.Throwable -> L1a
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L1a
            if (r3 != 0) goto L69
            r3 = 2048(0x800, double:1.012E-320)
            long r1 = r1 | r3
        L69:
            boolean r3 = com.kwad.sdk.utils.az.Om()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L78
            java.util.List r3 = com.kwad.sdk.utils.az.On()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L78
            r3 = 16
            long r1 = r1 | r3
        L78:
            monitor-exit(r0)
            return r1
        L7a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1a
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.bo.OW():long");
    }

    public static String OX() {
        return Build.BRAND;
    }

    public static String OY() {
        return Build.CPU_ABI;
    }

    public static synchronized long OZ() {
        long elapsedRealtime;
        synchronized (bo.class) {
            elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
        }
        return elapsedRealtime;
    }

    public static synchronized long Pa() {
        long j10;
        synchronized (bo.class) {
            j10 = Build.TIME;
        }
        return j10;
    }

    public static synchronized String Pb() {
        String str;
        synchronized (bo.class) {
            str = Build.FINGERPRINT;
        }
        return str;
    }

    public static synchronized String Pc() {
        synchronized (bo.class) {
            if (!TextUtils.isEmpty(aVc)) {
                return aVc;
            }
            String radioVersion = Build.getRadioVersion();
            aVc = radioVersion;
            return radioVersion;
        }
    }

    public static synchronized String Pd() {
        String name;
        synchronized (bo.class) {
            name = ay.getName();
        }
        return name;
    }

    public static synchronized String Pe() {
        String version;
        synchronized (bo.class) {
            version = ay.getVersion();
        }
        return version;
    }

    public static String Pf() {
        return Build.MANUFACTURER;
    }

    public static int Pg() {
        if (aVr == -1) {
            aVr = dz(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext()) ? 4 : 3;
        }
        return aVr;
    }

    public static String Ph() {
        if (TextUtils.isEmpty(aVq)) {
            aVq = System.getProperty("os.arch");
        }
        return aVq;
    }

    public static int Pi() {
        return Build.VERSION.SDK_INT;
    }

    public static String Pj() {
        if (az.Ok() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ac(8L)) {
            return "";
        }
        if (TextUtils.isEmpty(aVC)) {
            return aVC;
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if ((nextElement instanceof Inet4Address) && !nextElement.isLoopbackAddress()) {
                        String hostAddress = nextElement.getHostAddress();
                        aVC = hostAddress;
                        return hostAddress;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    private static String Pk() {
        try {
            return a(Long.toHexString(new Random(System.currentTimeMillis()).nextLong()), 16, '0');
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String Pl() {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return null;
        }
        String h10 = ad.h("ksadsdk_pref", "android_id", (String) null);
        ad.i(h10, "ksadsdk_pref", "android_id");
        return h10;
    }

    private static String a(String str, int i10, char c10) {
        StringBuilder sb2 = new StringBuilder();
        while (sb2.length() + str.length() < 16) {
            sb2.append('0');
        }
        sb2.append(str);
        return sb2.toString();
    }

    @SuppressLint({"HardwareIds"})
    public static String cO(Context context) {
        if (!TextUtils.isEmpty(aVo) || context == null || aVv) {
            return aVo;
        }
        if (az.usePhoneStateDisable()) {
            return az.Of();
        }
        if (!q.MV()) {
            return aVo;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            aVo = string;
            if (!hl(string)) {
                aVo = "";
            }
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(aVo)) {
            aVv = true;
        }
        return aVo;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String cS(Context context) {
        synchronized (bo.class) {
            if (context != null) {
                if (!aVt && TextUtils.isEmpty(aVm) && SystemUtil.m41do(context) && !az.usePhoneStateDisable() && q.Nc()) {
                    try {
                        aVm = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSubscriberId();
                    } catch (Exception unused) {
                    }
                    aVt = TextUtils.isEmpty(aVm);
                    return aVm;
                }
            }
            return aVm;
        }
    }

    public static String cg(boolean z10) {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar == null) {
            return "";
        }
        Context context = fVar.getContext();
        String bt = com.kwad.sdk.core.e.a.bt(context);
        return !TextUtils.isEmpty(bt) ? bt : z10 ? bt : TextUtils.isEmpty(ds(context)) ? ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).zR() : bt;
    }

    public static int checkSelfPermission(@NonNull Context context, @NonNull String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    @SuppressLint({"HardwareIds"})
    public static synchronized String dA(@Nullable Context context) {
        synchronized (bo.class) {
            if (TextUtils.isEmpty(aVd) && context != null && !aVe) {
                if (az.Og()) {
                    String Oh = az.Oh();
                    aVd = Oh;
                    return Oh;
                }
                if (!q.MW()) {
                    return aVd;
                }
                try {
                    WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                    if (connectionInfo != null) {
                        aVd = connectionInfo.getMacAddress();
                    }
                    if (hj(aVd)) {
                        Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            NetworkInterface networkInterface = (NetworkInterface) it.next();
                            if (networkInterface != null && "wlan0".equals(networkInterface.getName())) {
                                byte[] hardwareAddress = networkInterface.getHardwareAddress();
                                if (hardwareAddress != null && hardwareAddress.length != 0) {
                                    StringBuilder sb2 = new StringBuilder();
                                    for (byte b10 : hardwareAddress) {
                                        sb2.append(String.format("%02X:", Byte.valueOf(b10)));
                                    }
                                    if (sb2.length() > 0) {
                                        sb2.deleteCharAt(sb2.length() - 1);
                                    }
                                    aVd = sb2.toString();
                                }
                            }
                        }
                    }
                    if (hj(aVd)) {
                        aVd = com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream());
                    }
                    if (!hj(aVd)) {
                        aVd = aVd.toUpperCase(Locale.US);
                    }
                } catch (Exception unused) {
                    aVe = true;
                }
                aVe = hj(aVd);
                return aVd;
            }
            return aVd;
        }
    }

    @Nullable
    public static List<String> dB(@NonNull Context context) {
        String[] list;
        if (d.bW(context)) {
            return new ArrayList();
        }
        if (!dC(context)) {
            return new ArrayList();
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data");
        if (!file.exists() || !file.isDirectory() || (list = file.list()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && !str.startsWith(p1.b.f29697h)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static boolean dC(@NonNull Context context) {
        if (context.getApplicationInfo().targetSdkVersion < 30 || Build.VERSION.SDK_INT < 30) {
            return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        }
        return false;
    }

    public static long dp(Context context) {
        if (context == null || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ac(1024L)) {
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

    public static int dq(Context context) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ac(512L)) {
            return 0;
        }
        try {
            return ((BatteryManager) context.getApplicationContext().getSystemService("batterymanager")).getIntProperty(4);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static long dr(Context context) {
        long j10 = aVz;
        if (j10 > 0) {
            return j10;
        }
        if (context == null) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long j11 = memoryInfo.totalMem;
            if (j11 <= 0) {
                j11 = OP();
            }
            aVz = j11;
            return j11;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    private static synchronized String ds(@Nullable Context context) {
        boolean z10;
        synchronized (bo.class) {
            if (az.usePhoneStateDisable() && !TextUtils.isEmpty(az.Od())) {
                return az.Od();
            }
            if (aVs) {
                return aVf;
            }
            if (TextUtils.isEmpty(aVf) && context != null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    return aVf;
                }
                if (az.usePhoneStateDisable()) {
                    return aVf;
                }
                if (!q.Nb()) {
                    return aVf;
                }
                try {
                    z10 = SystemUtil.m41do(context);
                    if (z10) {
                        try {
                            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                            aVf = deviceId;
                            if (TextUtils.isEmpty(deviceId)) {
                                aVs = true;
                            }
                        } catch (Exception e10) {
                            e = e10;
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                            if (z10) {
                                aVs = true;
                            }
                            return aVf;
                        }
                    }
                } catch (Exception e11) {
                    e = e11;
                    z10 = false;
                }
                return aVf;
            }
            return aVf;
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String dt(@Nullable Context context) {
        boolean z10;
        String meid;
        synchronized (bo.class) {
            if (aVx) {
                return aVg;
            }
            if (TextUtils.isEmpty(aVg) && context != null) {
                if (az.usePhoneStateDisable()) {
                    return aVg;
                }
                if (!q.Na()) {
                    return aVo;
                }
                try {
                    z10 = SystemUtil.m41do(context);
                    if (z10) {
                        try {
                            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                            if (telephonyManager != null) {
                                if (Build.VERSION.SDK_INT >= 26) {
                                    meid = telephonyManager.getMeid();
                                    aVg = meid;
                                    if (TextUtils.isEmpty(meid)) {
                                        aVx = true;
                                    }
                                } else if (telephonyManager.getPhoneType() == 2) {
                                    String deviceId = telephonyManager.getDeviceId();
                                    aVg = deviceId;
                                    if (TextUtils.isEmpty(deviceId)) {
                                        aVx = true;
                                    }
                                } else {
                                    aVg = null;
                                    aVx = true;
                                }
                            }
                        } catch (Exception e10) {
                            e = e10;
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                            if (z10) {
                                aVx = true;
                            }
                            return aVg;
                        }
                    }
                } catch (Exception e11) {
                    e = e11;
                    z10 = false;
                }
                return aVg;
            }
            return aVg;
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String[] du(@Nullable Context context) {
        String deviceId;
        String imei;
        synchronized (bo.class) {
            if (az.usePhoneStateDisable() && az.Oe() != null) {
                return az.Oe();
            }
            if (aVw) {
                return aVl;
            }
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 29) {
                return aVl;
            }
            String[] strArr = aVl;
            boolean z10 = false;
            if (TextUtils.isEmpty(strArr[0]) && TextUtils.isEmpty(strArr[1]) && context != null) {
                if (az.usePhoneStateDisable()) {
                    return strArr;
                }
                if (!q.Nb()) {
                    return strArr;
                }
                try {
                    boolean m41do = SystemUtil.m41do(context);
                    if (m41do) {
                        try {
                            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                            if (telephonyManager != null) {
                                if (i10 >= 26) {
                                    int min = Math.min(dv(context), 2);
                                    for (int i11 = 0; i11 < min; i11++) {
                                        String[] strArr2 = aVl;
                                        imei = telephonyManager.getImei(i11);
                                        strArr2[i11] = imei;
                                    }
                                    String[] strArr3 = aVl;
                                    if (TextUtils.isEmpty(strArr3[0]) && TextUtils.isEmpty(strArr3[1])) {
                                        aVw = true;
                                    }
                                } else if (telephonyManager.getPhoneType() == 1) {
                                    if (i10 >= 23) {
                                        int min2 = Math.min(dv(context), 2);
                                        for (int i12 = 0; i12 < min2; i12++) {
                                            String[] strArr4 = aVl;
                                            deviceId = telephonyManager.getDeviceId(i12);
                                            strArr4[i12] = deviceId;
                                        }
                                    } else {
                                        strArr[0] = telephonyManager.getDeviceId();
                                        strArr[1] = null;
                                    }
                                    String[] strArr5 = aVl;
                                    if (TextUtils.isEmpty(strArr5[0]) && TextUtils.isEmpty(strArr5[1])) {
                                        aVw = true;
                                    }
                                } else {
                                    strArr[0] = null;
                                    strArr[1] = null;
                                    aVw = true;
                                }
                            }
                        } catch (Exception e10) {
                            e = e10;
                            z10 = m41do;
                            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                            if (z10) {
                                aVw = true;
                            }
                            return aVl;
                        }
                    }
                } catch (Exception e11) {
                    e = e11;
                }
                return aVl;
            }
            return strArr;
        }
    }

    public static synchronized int dv(Context context) {
        int phoneCount;
        synchronized (bo.class) {
            if (aVi || aVh > 0 || Build.VERSION.SDK_INT < 23 || context == null || az.usePhoneStateDisable()) {
                return aVh;
            }
            try {
                phoneCount = ((TelephonyManager) context.getSystemService("phone")).getPhoneCount();
                aVh = phoneCount;
            } catch (Exception unused) {
            }
            int i10 = aVh;
            aVi = i10 == 0;
            return i10;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static int dw(Context context) {
        int activeSubscriptionInfoCount;
        if (context == null || aVj > 0 || aVk || Build.VERSION.SDK_INT < 22 || !SystemUtil.m41do(context) || az.usePhoneStateDisable()) {
            return aVj;
        }
        try {
            activeSubscriptionInfoCount = x7.b.a(context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoCount();
            aVj = activeSubscriptionInfoCount;
        } catch (Throwable unused) {
        }
        int i10 = aVj;
        aVk = i10 != 0;
        return i10;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String dx(Context context) {
        if (!TextUtils.isEmpty(aVn) || context == null) {
            return aVn;
        }
        if (aVu) {
            return aVn;
        }
        if (az.usePhoneStateDisable()) {
            return aVn;
        }
        if (!q.Nd()) {
            return aVn;
        }
        try {
            if (SystemUtil.m41do(context)) {
                aVn = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSimSerialNumber();
            }
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
            aVn = null;
        }
        if (TextUtils.isEmpty(aVn)) {
            aVu = true;
        }
        String str = TextUtils.isEmpty(aVn) ? "" : aVn;
        aVn = str;
        return str;
    }

    public static synchronized int dy(Context context) {
        int ringerMode;
        synchronized (bo.class) {
            try {
                ringerMode = ((AudioManager) context.getSystemService("audio")).getRingerMode();
            } catch (Exception unused) {
                return -1;
            }
        }
        return ringerMode;
    }

    private static boolean dz(Context context) {
        return (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) ? false : true;
    }

    public static String getDeviceId() {
        try {
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
        }
        if (!TextUtils.isEmpty(aVp)) {
            return aVp;
        }
        String Pl = Pl();
        if (!TextUtils.isEmpty(Pl)) {
            String str = "ANDROID_" + Pl;
            aVp = str;
            return str;
        }
        String cO = cO(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext());
        if (!TextUtils.isEmpty(cO) && !hk(cO) && hl(cO)) {
            String str2 = "ANDROID_" + cO;
            aVp = str2;
            return str2;
        }
        String Pk = Pk();
        if (!TextUtils.isEmpty(Pk)) {
            aVp = "ANDROID_" + Pk;
            hm(Pk);
            return aVp;
        }
        return "ANDROID_";
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getLocale() {
        Locale locale;
        LocaleList localeList;
        if (Build.VERSION.SDK_INT >= 24) {
            localeList = LocaleList.getDefault();
            locale = localeList.get(0);
        } else {
            locale = Locale.getDefault();
        }
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

    private static boolean hj(String str) {
        return TextUtils.isEmpty(str) || str.equals("02:00:00:00:00:00");
    }

    private static boolean hk(String str) {
        return aVD.contains(str.toLowerCase(Locale.US));
    }

    private static boolean hl(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            try {
                if (str.charAt(i10) != '0') {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static void hm(String str) {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return;
        }
        ad.a("ksadsdk_pref", "android_id", str, true);
    }

    public static String hn(String str) {
        StructStat stat;
        StructTimespec structTimespec;
        StructTimespec structTimespec2;
        long j10;
        StructTimespec structTimespec3;
        long j11;
        String valueOf;
        if (!TextUtils.isEmpty(aVB) || TextUtils.isEmpty(str)) {
            return aVB;
        }
        int i10 = Build.VERSION.SDK_INT;
        try {
            stat = Os.stat(str);
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
        if (stat == null) {
            return aVB;
        }
        String str2 = "";
        if (i10 >= 27) {
            structTimespec = stat.st_atim;
            if (structTimespec == null) {
                valueOf = "";
            } else {
                structTimespec2 = stat.st_atim;
                j10 = structTimespec2.tv_sec;
                str2 = String.valueOf(j10);
                structTimespec3 = stat.st_atim;
                j11 = structTimespec3.tv_nsec;
                valueOf = String.valueOf(j11);
            }
            aVB = str2 + p1.b.f29697h + valueOf;
        } else {
            long j12 = stat.st_atime;
            if (j12 != 0) {
                str2 = String.valueOf(j12);
            }
            aVB = str2;
        }
        return aVB;
    }

    public static String u(@Nullable Context context, boolean z10) {
        if (az.usePhoneStateDisable() && !TextUtils.isEmpty(az.Od())) {
            return az.Od();
        }
        String ds = ds(context);
        return !TextUtils.isEmpty(ds) ? ds : z10 ? ds : TextUtils.isEmpty(com.kwad.sdk.core.e.a.bt(context)) ? ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).zQ() : ds;
    }
}
