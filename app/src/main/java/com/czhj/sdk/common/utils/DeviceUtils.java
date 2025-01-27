package com.czhj.sdk.common.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.IBinder;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.downloader.core.download.g;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.umeng.analytics.pro.bt;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import o4.c;

/* loaded from: classes2.dex */
public class DeviceUtils {
    public static String A = null;
    public static Display B = null;

    /* renamed from: b */
    public static final int f8583b = 31457280;

    /* renamed from: c */
    public static final String f8584c = "getSimState";

    /* renamed from: d */
    public static final String f8585d = "getImei";

    /* renamed from: e */
    public static final String f8586e = "getLine1Number";

    /* renamed from: f */
    public static final int f8587f = 31457280;

    /* renamed from: g */
    public static final int f8588g = 104857600;

    /* renamed from: h */
    public static final int f8589h = -1;

    /* renamed from: i */
    public static String f8590i;

    /* renamed from: j */
    public static int f8591j;

    /* renamed from: k */
    public static String f8592k;

    /* renamed from: l */
    public static String f8593l;

    /* renamed from: m */
    public static String f8594m;

    /* renamed from: n */
    public static String f8595n;

    /* renamed from: p */
    public static boolean f8597p;

    /* renamed from: q */
    public static long f8598q;

    /* renamed from: r */
    public static long f8599r;

    /* renamed from: s */
    public static long f8600s;

    /* renamed from: t */
    public static long f8601t;

    /* renamed from: v */
    public static Network f8603v;

    /* renamed from: w */
    public static long f8604w;

    /* renamed from: x */
    public static String f8605x;

    /* renamed from: y */
    public static String f8606y;

    /* renamed from: z */
    public static String f8607z;

    /* renamed from: a */
    public static final String[] f8582a = {"/system/lib/libdroid4x.so", "/system/bin/mount.vboxsf", "/system/lib/vboxguest.ko", "/etc/mumu-configs", "/system/lib/vboxsf.ko", "/system/lib/vboxvideo.ko", "/data/.bluestacks.prop", "/system/bin/microvirt-vbox-sf", "/system/lib/tboxsf.ko", "/system/bin/androVM-vbox-sf", "/system/bin/microvirtd", "/system/bin/windroyed", "/system/lib/libdroid4x.so"};

    /* renamed from: o */
    public static NetworkType f8596o = NetworkType.UNKNOWN;

    /* renamed from: u */
    public static ArrayList<Network> f8602u = new ArrayList<>();

    /* renamed from: com.czhj.sdk.common.utils.DeviceUtils$1 */
    public class AnonymousClass1 extends ConnectivityManager.NetworkCallback {

        /* renamed from: a */
        public final /* synthetic */ Context f8608a;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            SigmobLog.d("updateNetworkType registerNetworkCallback  onAvailable " + network.hashCode());
            super.onAvailable(network);
            DeviceUtils.f8602u.add(network);
            DeviceUtils.updateNetworkType(context);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            DeviceUtils.updateNetworkType(context);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            SigmobLog.d("updateNetworkType registerNetworkCallback onLost" + network.hashCode());
            super.onLost(network);
            NetworkType unused = DeviceUtils.f8596o = NetworkType.UNKNOWN;
            boolean unused2 = DeviceUtils.f8597p = false;
            try {
                Network unused3 = DeviceUtils.f8603v = network;
                DeviceUtils.f8602u.remove(network);
                DeviceUtils.updateNetworkType(context);
            } catch (Throwable unused4) {
            }
        }
    }

    public static class NetBroadcastReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                DeviceUtils.updateNetworkType(context);
            }
        }
    }

    public enum NetworkType {
        UNKNOWN(0),
        ETHERNET(101),
        WIFI(100),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        MOBILE_4G(4),
        MOBILE_5G(5);

        private final int mId;

        NetworkType(int i10) {
            this.mId = i10;
        }

        public static NetworkType b(Context context, int i10) {
            if (i10 == 9) {
                return ETHERNET;
            }
            if (i10 != 0) {
                if (i10 == 1) {
                    return WIFI;
                }
                if (i10 != 2 && i10 != 3 && i10 != 4 && i10 != 5) {
                    return UNKNOWN;
                }
            }
            return DeviceUtils.getDataNetworkType(context);
        }

        public int getId() {
            return this.mId;
        }

        @Override // java.lang.Enum
        public String toString() {
            return Integer.toString(this.mId);
        }
    }

    public static boolean a(int i10, int i11) {
        return (i10 & i11) != 0;
    }

    public static long diskCacheSizeBytes(File file, long j10) {
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j10 = (statFs.getBlockCount() * statFs.getBlockSize()) / 50;
        } catch (IllegalArgumentException unused) {
            SigmobLog.d("Unable to calculate 2% of available disk space, defaulting to minimum");
        }
        return Math.max(Math.min(j10, g.f19257g), ba.g.f1469c);
    }

    public static NetworkType getActiveNetworkType() {
        return f8596o;
    }

    public static String getAndroidId(Context context) {
        if (f8594m == null && context != null) {
            try {
                SigmobLog.d("private : AndroidId");
                f8594m = Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Throwable th2) {
                f8594m = "";
                SigmobLog.e(th2.getMessage());
                f8594m = "";
            }
        }
        return f8594m;
    }

    public static String getApkSha1OrMd5(Context context, String str) {
        Signature[] signatureArr;
        Signature signature;
        String str2;
        String str3;
        String str4 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals("SHA1") && (str3 = f8605x) != null) {
            return str3;
        }
        if (str.equals("MD5") && (str2 = f8606y) != null) {
            return str2;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0 && (signature = signatureArr[0]) != null) {
                byte[] byteArray = signature.toByteArray();
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                if (messageDigest != null) {
                    byte[] digest = messageDigest.digest(byteArray);
                    StringBuilder sb2 = new StringBuilder();
                    for (byte b10 : digest) {
                        sb2.append(Integer.toHexString((b10 & 255) | 256).substring(1, 3).toUpperCase());
                        sb2.append(":");
                    }
                    str4 = sb2.substring(0, sb2.length() - 1);
                    if (str.equals("SHA1")) {
                        f8605x = str4;
                    } else if (str.equals("MD5")) {
                        f8606y = str4;
                    }
                }
            }
        } catch (Exception e10) {
            SigmobLog.e(e10.getMessage());
        }
        return str4;
    }

    public static int getAppLaunchCount(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            SigmobLog.d("getAppLaunchCount==" + str);
            if (launchIntentForPackage == null) {
                return 0;
            }
            ComponentName component = launchIntentForPackage.getComponent();
            SigmobLog.d("getAppLaunchCount==" + str);
            Object invoke = Class.forName("com.android.internal.app.IUsageStats$Stub").getMethod("asInterface", IBinder.class).invoke(null, Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "usagestats"));
            Object invoke2 = invoke.getClass().getMethod("getPkgUsageStats", ComponentName.class).invoke(invoke, component);
            SigmobLog.d("getAppLaunchCount==" + str);
            if (invoke2 == null) {
                return 0;
            }
            Class<?> cls = Class.forName("com.android.internal.os.PkgUsageStats");
            SigmobLog.d("getAppLaunchCount==" + str);
            return cls.getDeclaredField("launchCount").getInt(invoke2);
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static float getBatteryLevel(Context context) {
        if (((BatteryManager) context.getSystemService("batterymanager")) == null) {
            return 0.0f;
        }
        return r1.getIntProperty(4) / 100.0f;
    }

    public static boolean getBatterySaveEnable(Context context) {
        BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
        return batteryManager != null && batteryManager.getIntProperty(4) < 16;
    }

    public static int getBatteryState(Context context) {
        int i10 = Build.VERSION.SDK_INT;
        BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
        if (batteryManager == null) {
            return 0;
        }
        int intProperty = i10 >= 26 ? batteryManager.getIntProperty(6) : 0;
        if (intProperty == 2) {
            return 2;
        }
        if (intProperty == 3 || intProperty == 4) {
            return 1;
        }
        return intProperty != 5 ? 0 : 3;
    }

    public static String getBlueToothName(Context context) {
        if (TextUtils.isEmpty(f8595n)) {
            try {
                f8595n = Settings.Secure.getString(context.getContentResolver(), "bluetooth_name");
            } catch (Throwable th2) {
                SigmobLog.e(th2.getMessage());
            }
        }
        return f8595n;
    }

    public static long getBootSystemTime() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public static String getCPUInfo() {
        try {
            return Build.SUPPORTED_ABIS[0];
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            return null;
        }
    }

    public static String getCell_ip() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return "0.0.0.0";
        } catch (SocketException | Exception e10) {
            e10.printStackTrace();
            return "0.0.0.0";
        }
    }

    public static ConnectivityManager getConnectivityManager(Context context) {
        if (context != null) {
            return (ConnectivityManager) context.getSystemService("connectivity");
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.czhj.sdk.common.utils.DeviceUtils.NetworkType getDataNetworkType(android.content.Context r4) {
        /*
            java.lang.String r0 = "getDataNetworkType "
            com.czhj.sdk.logger.SigmobLog.d(r0)
            android.telephony.TelephonyManager r1 = getTelephonyManager(r4)
            if (r1 == 0) goto L1b
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L16
            int r1 = d1.b.a(r1)
            goto L1c
        L16:
            int r1 = r1.getNetworkType()     // Catch: java.lang.Exception -> L1b
            goto L1c
        L1b:
            r1 = 0
        L1c:
            android.net.ConnectivityManager r4 = getConnectivityManager(r4)
            if (r1 != 0) goto L2e
            if (r4 == 0) goto L2e
            android.net.NetworkInfo r4 = r4.getActiveNetworkInfo()
            if (r4 == 0) goto L2e
            int r1 = r4.getSubtype()
        L2e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            com.czhj.sdk.logger.SigmobLog.d(r4)
            r4 = 20
            if (r1 == r4) goto L53
            switch(r1) {
                case 1: goto L50;
                case 2: goto L50;
                case 3: goto L4d;
                case 4: goto L50;
                case 5: goto L4d;
                case 6: goto L4d;
                case 7: goto L50;
                case 8: goto L4d;
                case 9: goto L4d;
                case 10: goto L4d;
                case 11: goto L50;
                case 12: goto L4d;
                case 13: goto L4a;
                case 14: goto L4d;
                case 15: goto L4d;
                default: goto L47;
            }
        L47:
            com.czhj.sdk.common.utils.DeviceUtils$NetworkType r4 = com.czhj.sdk.common.utils.DeviceUtils.NetworkType.MOBILE
            return r4
        L4a:
            com.czhj.sdk.common.utils.DeviceUtils$NetworkType r4 = com.czhj.sdk.common.utils.DeviceUtils.NetworkType.MOBILE_4G
            return r4
        L4d:
            com.czhj.sdk.common.utils.DeviceUtils$NetworkType r4 = com.czhj.sdk.common.utils.DeviceUtils.NetworkType.MOBILE_3G
            return r4
        L50:
            com.czhj.sdk.common.utils.DeviceUtils$NetworkType r4 = com.czhj.sdk.common.utils.DeviceUtils.NetworkType.MOBILE_2G
            return r4
        L53:
            com.czhj.sdk.common.utils.DeviceUtils$NetworkType r4 = com.czhj.sdk.common.utils.DeviceUtils.NetworkType.MOBILE_5G
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.sdk.common.utils.DeviceUtils.getDataNetworkType(android.content.Context):com.czhj.sdk.common.utils.DeviceUtils$NetworkType");
    }

    public static float getDensityDpi(Context context) {
        try {
            return getRealMetrics(context).densityDpi;
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            return 0.0f;
        }
    }

    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    public static String getDeviceDispaly() {
        return Build.DISPLAY;
    }

    public static Locale getDeviceLocale(Context context) {
        try {
            return context.getResources().getConfiguration().locale;
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            return null;
        }
    }

    public static String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getDeviceName(Context context) {
        try {
            return Settings.Global.getString(context.getContentResolver(), bt.J);
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            return null;
        }
    }

    public static int getDeviceOSLevel() {
        return Build.VERSION.SDK_INT;
    }

    public static String getDeviceOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getDeviceScreenHeightDip(Context context) {
        if (context == null) {
            return 0;
        }
        return Dips.screenHeightAsIntDips(context);
    }

    public static int getDeviceScreenRealHeightDip(Context context) {
        if (context == null) {
            return 0;
        }
        return Dips.pixelsToIntDips(getRealMetrics(context).heightPixels, context);
    }

    public static int getDeviceScreenRealWidthDip(Context context) {
        if (context == null) {
            return 0;
        }
        return Dips.pixelsToIntDips(getRealMetrics(context).widthPixels, context);
    }

    public static int getDeviceScreenWidthDip(Context context) {
        return Dips.screenWidthAsIntDips(context);
    }

    public static String getDeviceSerial() {
        return Build.SERIAL;
    }

    public static String getDeviceType(Context context) {
        return isTablet(context) ? "pad" : "phone";
    }

    public static Display getDisplay(Context context) {
        if (B == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return null;
            }
            B = windowManager.getDefaultDisplay();
        }
        return B;
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        try {
            return context.getResources().getDisplayMetrics();
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            return null;
        }
    }

    public static String getNetworkOperator(Context context) {
        String str = A;
        if (str != null) {
            return str;
        }
        TelephonyManager telephonyManager = getTelephonyManager(context);
        if (telephonyManager != null) {
            A = (telephonyManager.getPhoneType() == 2 && telephonyManager.getSimState() == 5) ? telephonyManager.getSimOperator() : telephonyManager.getNetworkOperator();
            if (A == null) {
                A = "";
            }
        }
        return A;
    }

    public static String getNetworkOperatorForUrl(Context context) {
        return getNetworkOperator(context);
    }

    public static String getNetworkOperatorName(Context context) {
        String str = f8607z;
        if (str != null) {
            return str;
        }
        TelephonyManager telephonyManager = getTelephonyManager(context);
        if (telephonyManager != null) {
            f8607z = (telephonyManager.getPhoneType() == 2 && telephonyManager.getSimState() == 5) ? telephonyManager.getSimOperatorName() : telephonyManager.getNetworkOperatorName();
            if (f8607z == null) {
                f8607z = "";
            }
        }
        return f8607z;
    }

    public static int getOrientationInt(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    public static String getProperty(String str) {
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static DisplayMetrics getRealMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display display = getDisplay(context);
        if (display == null) {
            return context.getResources().getDisplayMetrics();
        }
        display.getRealMetrics(displayMetrics);
        return displayMetrics;
    }

    public static String getRotation(Context context) {
        Display display = getDisplay(context);
        if (display == null) {
            return "0";
        }
        int rotation = display.getRotation();
        return rotation != 1 ? rotation != 2 ? rotation != 3 ? "0" : "270" : "180" : "90";
    }

    public static String getSDCardPath(Context context) {
        List storageVolumes;
        boolean isRemovable;
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        if (Build.VERSION.SDK_INT >= 24) {
            storageVolumes = storageManager.getStorageVolumes();
            Iterator it = storageVolumes.iterator();
            while (it.hasNext()) {
                StorageVolume a10 = c.a(it.next());
                isRemovable = a10.isRemovable();
                if (isRemovable) {
                    try {
                        return (String) a10.getClass().getMethod("getPath", null).invoke(a10, null);
                    } catch (Exception e10) {
                        SigmobLog.e(e10.getMessage());
                    }
                }
            }
        } else {
            try {
                Method method = storageManager.getClass().getMethod("getVolumeList", null);
                Class<?> cls = Class.forName("android.os.storage.StorageVolume");
                Method method2 = cls.getMethod("getPath", null);
                Method method3 = cls.getMethod("isRemovable", null);
                Object invoke = method.invoke(storageManager, null);
                int length = Array.getLength(invoke);
                for (int i10 = 0; i10 < length; i10++) {
                    try {
                        Object obj = Array.get(invoke, i10);
                        Object invoke2 = method3.invoke(obj, null);
                        if ((invoke2 instanceof Boolean) && ((Boolean) invoke2).booleanValue()) {
                            Object invoke3 = method2.invoke(obj, null);
                            if (invoke3 instanceof String) {
                                return (String) invoke3;
                            }
                            continue;
                        }
                    } catch (Throwable unused) {
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        return null;
    }

    public static long getSysteTotalMemorySize(Context context) {
        long j10;
        try {
            j10 = f8604w;
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
        if (j10 > 0) {
            return j10;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
            long j11 = memoryInfo.totalMem;
            f8604w = j11;
            return j11;
        }
        return 0L;
    }

    public static TelephonyManager getTelephonyManager(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (!isCanUsePhoneState(context)) {
                return null;
            }
        } catch (Throwable unused) {
        }
        return (TelephonyManager) context.getSystemService("phone");
    }

    public static WifiManager getWifiManager(Context context) {
        if (context == null || !isCanUseWifiState(context)) {
            return null;
        }
        return (WifiManager) context.getSystemService("wifi");
    }

    public static WindowManager getWindowManger(Context context) {
        return (WindowManager) context.getSystemService("window");
    }

    public static boolean isCanRetryIMEI() {
        boolean z10 = System.currentTimeMillis() - f8598q > 30000;
        if (z10) {
            f8598q = System.currentTimeMillis();
        }
        SigmobLog.d("isCanRetryIMEI status " + z10);
        return z10;
    }

    public static boolean isCanRetryLocation() {
        boolean z10 = System.currentTimeMillis() - f8600s > 36000;
        if (z10) {
            f8600s = System.currentTimeMillis();
        }
        SigmobLog.d("isCanRetryLocation status " + z10);
        return z10;
    }

    public static boolean isCanRetryWIFI() {
        boolean z10 = System.currentTimeMillis() - f8601t > 30000;
        if (z10) {
            f8601t = System.currentTimeMillis();
        }
        SigmobLog.d("isCanRetryWIFI status " + z10);
        return z10;
    }

    public static boolean isCanUseLocation(Context context) {
        boolean z10 = context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f11107h) == 0 || context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f11106g) == 0;
        SigmobLog.d("isCanUseLocation status " + z10);
        return z10;
    }

    public static boolean isCanUsePhoneState(Context context) {
        return context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f11102c) == 0;
    }

    public static boolean isCanUseWifiState(Context context) {
        boolean z10 = context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f11103d) == 0;
        SigmobLog.d("isCanUseWifiState status " + z10);
        return z10;
    }

    public static boolean isCanUseWriteExternal(Context context) {
        boolean z10 = context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        SigmobLog.d("isCanUseWriteExternal status " + z10);
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x000b, B:10:0x0017, B:13:0x0028, B:15:0x0034, B:16:0x004c, B:17:0x004e, B:20:0x005c, B:21:0x0072, B:22:0x0074, B:24:0x0080, B:26:0x008b, B:28:0x0093, B:30:0x009e, B:32:0x00a6, B:33:0x00c8, B:34:0x00ca, B:36:0x00d0, B:38:0x00dd, B:48:0x00aa, B:50:0x00b6, B:51:0x00bb, B:54:0x0099, B:55:0x0086, B:56:0x0060, B:58:0x0066, B:60:0x006e, B:61:0x0038, B:63:0x0040, B:65:0x0048, B:66:0x0023), top: B:7:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c A[Catch: all -> 0x0020, TRY_ENTER, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x000b, B:10:0x0017, B:13:0x0028, B:15:0x0034, B:16:0x004c, B:17:0x004e, B:20:0x005c, B:21:0x0072, B:22:0x0074, B:24:0x0080, B:26:0x008b, B:28:0x0093, B:30:0x009e, B:32:0x00a6, B:33:0x00c8, B:34:0x00ca, B:36:0x00d0, B:38:0x00dd, B:48:0x00aa, B:50:0x00b6, B:51:0x00bb, B:54:0x0099, B:55:0x0086, B:56:0x0060, B:58:0x0066, B:60:0x006e, B:61:0x0038, B:63:0x0040, B:65:0x0048, B:66:0x0023), top: B:7:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0080 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x000b, B:10:0x0017, B:13:0x0028, B:15:0x0034, B:16:0x004c, B:17:0x004e, B:20:0x005c, B:21:0x0072, B:22:0x0074, B:24:0x0080, B:26:0x008b, B:28:0x0093, B:30:0x009e, B:32:0x00a6, B:33:0x00c8, B:34:0x00ca, B:36:0x00d0, B:38:0x00dd, B:48:0x00aa, B:50:0x00b6, B:51:0x00bb, B:54:0x0099, B:55:0x0086, B:56:0x0060, B:58:0x0066, B:60:0x006e, B:61:0x0038, B:63:0x0040, B:65:0x0048, B:66:0x0023), top: B:7:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0093 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x000b, B:10:0x0017, B:13:0x0028, B:15:0x0034, B:16:0x004c, B:17:0x004e, B:20:0x005c, B:21:0x0072, B:22:0x0074, B:24:0x0080, B:26:0x008b, B:28:0x0093, B:30:0x009e, B:32:0x00a6, B:33:0x00c8, B:34:0x00ca, B:36:0x00d0, B:38:0x00dd, B:48:0x00aa, B:50:0x00b6, B:51:0x00bb, B:54:0x0099, B:55:0x0086, B:56:0x0060, B:58:0x0066, B:60:0x006e, B:61:0x0038, B:63:0x0040, B:65:0x0048, B:66:0x0023), top: B:7:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a6 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x000b, B:10:0x0017, B:13:0x0028, B:15:0x0034, B:16:0x004c, B:17:0x004e, B:20:0x005c, B:21:0x0072, B:22:0x0074, B:24:0x0080, B:26:0x008b, B:28:0x0093, B:30:0x009e, B:32:0x00a6, B:33:0x00c8, B:34:0x00ca, B:36:0x00d0, B:38:0x00dd, B:48:0x00aa, B:50:0x00b6, B:51:0x00bb, B:54:0x0099, B:55:0x0086, B:56:0x0060, B:58:0x0066, B:60:0x006e, B:61:0x0038, B:63:0x0040, B:65:0x0048, B:66:0x0023), top: B:7:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d0 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x000b, B:10:0x0017, B:13:0x0028, B:15:0x0034, B:16:0x004c, B:17:0x004e, B:20:0x005c, B:21:0x0072, B:22:0x0074, B:24:0x0080, B:26:0x008b, B:28:0x0093, B:30:0x009e, B:32:0x00a6, B:33:0x00c8, B:34:0x00ca, B:36:0x00d0, B:38:0x00dd, B:48:0x00aa, B:50:0x00b6, B:51:0x00bb, B:54:0x0099, B:55:0x0086, B:56:0x0060, B:58:0x0066, B:60:0x006e, B:61:0x0038, B:63:0x0040, B:65:0x0048, B:66:0x0023), top: B:7:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fe A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00aa A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x000b, B:10:0x0017, B:13:0x0028, B:15:0x0034, B:16:0x004c, B:17:0x004e, B:20:0x005c, B:21:0x0072, B:22:0x0074, B:24:0x0080, B:26:0x008b, B:28:0x0093, B:30:0x009e, B:32:0x00a6, B:33:0x00c8, B:34:0x00ca, B:36:0x00d0, B:38:0x00dd, B:48:0x00aa, B:50:0x00b6, B:51:0x00bb, B:54:0x0099, B:55:0x0086, B:56:0x0060, B:58:0x0066, B:60:0x006e, B:61:0x0038, B:63:0x0040, B:65:0x0048, B:66:0x0023), top: B:7:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0060 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x000b, B:10:0x0017, B:13:0x0028, B:15:0x0034, B:16:0x004c, B:17:0x004e, B:20:0x005c, B:21:0x0072, B:22:0x0074, B:24:0x0080, B:26:0x008b, B:28:0x0093, B:30:0x009e, B:32:0x00a6, B:33:0x00c8, B:34:0x00ca, B:36:0x00d0, B:38:0x00dd, B:48:0x00aa, B:50:0x00b6, B:51:0x00bb, B:54:0x0099, B:55:0x0086, B:56:0x0060, B:58:0x0066, B:60:0x006e, B:61:0x0038, B:63:0x0040, B:65:0x0048, B:66:0x0023), top: B:7:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0038 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x000b, B:10:0x0017, B:13:0x0028, B:15:0x0034, B:16:0x004c, B:17:0x004e, B:20:0x005c, B:21:0x0072, B:22:0x0074, B:24:0x0080, B:26:0x008b, B:28:0x0093, B:30:0x009e, B:32:0x00a6, B:33:0x00c8, B:34:0x00ca, B:36:0x00d0, B:38:0x00dd, B:48:0x00aa, B:50:0x00b6, B:51:0x00bb, B:54:0x0099, B:55:0x0086, B:56:0x0060, B:58:0x0066, B:60:0x006e, B:61:0x0038, B:63:0x0040, B:65:0x0048, B:66:0x0023), top: B:7:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isEmulator() {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.sdk.common.utils.DeviceUtils.isEmulator():boolean");
    }

    public static boolean isNetworkConnected() {
        return f8597p;
    }

    public static boolean isNetworkValid(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities != null) {
            return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(4) || (Build.VERSION.SDK_INT >= 23 ? networkCapabilities.hasCapability(16) : false);
        }
        return false;
    }

    public static boolean isRoot() {
        return (new File("/system/bin/su").exists() && a("/system/bin/su")) || (new File("/system/xbin/su").exists() && a("/system/xbin/su"));
    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static int memoryCacheSizeBytes(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager == null) {
            return 0;
        }
        long memoryClass = activityManager.getMemoryClass();
        try {
            if (a(context.getApplicationInfo().flags, ApplicationInfo.class.getDeclaredField("FLAG_LARGE_HEAP").getInt(null))) {
                memoryClass = ((Integer) new ReflectionUtil.MethodBuilder(activityManager, "getLargeMemoryClass").execute()).intValue();
            }
        } catch (Throwable unused) {
            SigmobLog.d("Unable to reflectively determine large heap size.");
        }
        return (int) Math.min(ba.g.f1469c, (memoryClass / 8) * 1048576);
    }

    @SuppressLint({"MissingPermission"})
    public static void registerNetworkChange(Context context) {
        NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(0).addTransportType(1).build();
        ConnectivityManager connectivityManager = getConnectivityManager(context);
        if (connectivityManager == null) {
            return;
        }
        connectivityManager.registerNetworkCallback(build, new ConnectivityManager.NetworkCallback() { // from class: com.czhj.sdk.common.utils.DeviceUtils.1

            /* renamed from: a */
            public final /* synthetic */ Context f8608a;

            public AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                SigmobLog.d("updateNetworkType registerNetworkCallback  onAvailable " + network.hashCode());
                super.onAvailable(network);
                DeviceUtils.f8602u.add(network);
                DeviceUtils.updateNetworkType(context);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                super.onCapabilitiesChanged(network, networkCapabilities);
                DeviceUtils.updateNetworkType(context);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                SigmobLog.d("updateNetworkType registerNetworkCallback onLost" + network.hashCode());
                super.onLost(network);
                NetworkType unused = DeviceUtils.f8596o = NetworkType.UNKNOWN;
                boolean unused2 = DeviceUtils.f8597p = false;
                try {
                    Network unused3 = DeviceUtils.f8603v = network;
                    DeviceUtils.f8602u.remove(network);
                    DeviceUtils.updateNetworkType(context);
                } catch (Throwable unused4) {
                }
            }
        });
    }

    public static void resetRetryIMEI() {
        f8598q = 0L;
    }

    @SuppressLint({"MissingPermission"})
    public static void updateNetworkType(Context context) {
        NetworkType b10;
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        try {
            if (a(context)) {
                if (Build.VERSION.SDK_INT >= 23) {
                    activeNetwork = getConnectivityManager(context).getActiveNetwork();
                    if (activeNetwork == null || activeNetwork == f8603v) {
                        NetworkCapabilities networkCapabilities2 = null;
                        for (int size = f8602u.size() - 1; size >= 0; size--) {
                            networkCapabilities2 = getConnectivityManager(context).getNetworkCapabilities(f8602u.get(size));
                            if (networkCapabilities2 != null) {
                                break;
                            }
                        }
                        networkCapabilities = networkCapabilities2;
                    } else {
                        networkCapabilities = getConnectivityManager(context).getNetworkCapabilities(activeNetwork);
                    }
                    if (networkCapabilities == null) {
                        return;
                    }
                    f8597p = isNetworkValid(networkCapabilities);
                    b10 = (networkCapabilities.hasCapability(12) && networkCapabilities.hasTransport(1)) ? NetworkType.WIFI : (networkCapabilities.hasCapability(12) && networkCapabilities.hasTransport(0)) ? getDataNetworkType(context) : NetworkType.UNKNOWN;
                } else {
                    NetworkInfo activeNetworkInfo = getConnectivityManager(context).getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        f8597p = activeNetworkInfo.isAvailable();
                    }
                    b10 = NetworkType.b(context, activeNetworkInfo != null ? activeNetworkInfo.getType() : -1);
                }
                f8596o = b10;
            }
        } catch (Exception unused) {
        }
    }

    public static boolean a(Context context) {
        return context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f11100a) == 0;
    }

    public static boolean a(String str) {
        Process process;
        try {
            process = Runtime.getRuntime().exec("ls -l " + str);
        } catch (Throwable unused) {
            process = null;
        }
        try {
            String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
            if (readLine != null && readLine.length() >= 4) {
                char charAt = readLine.charAt(3);
                if (charAt == 's' || charAt == 'x') {
                    process.destroy();
                    return true;
                }
            }
        } catch (Throwable unused2) {
            if (process == null) {
                return false;
            }
            process.destroy();
            return false;
        }
        process.destroy();
        return false;
    }
}
