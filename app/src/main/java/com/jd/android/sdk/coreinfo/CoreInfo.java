package com.jd.android.sdk.coreinfo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.fingerprint.FingerprintManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.czhj.sdk.common.utils.RomUtils;
import com.gyf.immersionbar.b;
import com.jd.ad.sdk.jad_an.jad_an;
import com.jd.ad.sdk.jad_an.jad_bo;
import com.jd.ad.sdk.jad_an.jad_cp;
import com.jd.ad.sdk.jad_dq.jad_bo;
import com.jd.ad.sdk.jad_lo.jad_dq;
import com.jd.ad.sdk.jad_lo.jad_er;
import com.jd.ad.sdk.jad_lo.jad_hu;
import com.jd.android.sdk.coreinfo.util.Logger;
import com.umeng.analytics.pro.bt;
import hf.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import m5.h;
import o4.c;

/* loaded from: classes2.dex */
public class CoreInfo {
    private static final String TAG = "BaseInfo.CoreInfo";
    public static jad_bo sensitiveApi;

    public static class App {
        public static String getAppName(Context context) {
            String str;
            String str2;
            if (TextUtils.isEmpty(jad_cp.jad_an)) {
                str = "";
                if (context == null) {
                    str2 = "context is null";
                } else {
                    PackageInfo jad_an = jad_cp.jad_an(context, 16384);
                    if (jad_an == null) {
                        str2 = "packageInfo is null";
                    } else {
                        jad_cp.jad_an = context.getPackageManager().getApplicationLabel(jad_an.applicationInfo).toString();
                    }
                }
                Logger.w("AppInfo", str2);
                jad_an.jad_an(str, "getAppName() --> ", CoreInfo.TAG);
                return str;
            }
            str = jad_cp.jad_an;
            jad_an.jad_an(str, "getAppName() --> ", CoreInfo.TAG);
            return str;
        }

        public static long getFirstInstallTime(Context context) {
            String str;
            long j10 = 0;
            if (jad_cp.jad_er <= 0) {
                if (context == null) {
                    str = "context is null";
                } else {
                    PackageInfo jad_an = jad_cp.jad_an(context, 16384);
                    if (jad_an == null) {
                        str = "packageInfo is null";
                    } else {
                        jad_cp.jad_er = jad_an.firstInstallTime;
                    }
                }
                Logger.w("AppInfo", str);
                Logger.debugWithStackTrace(CoreInfo.TAG, "getFirstInstallTime() --> ".concat(String.valueOf(j10)));
                return j10;
            }
            j10 = jad_cp.jad_er;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getFirstInstallTime() --> ".concat(String.valueOf(j10)));
            return j10;
        }

        public static long getLastUpdateTime(Context context) {
            String str;
            long j10 = 0;
            if (jad_cp.jad_fs <= 0) {
                if (context == null) {
                    str = "context is null";
                } else {
                    PackageInfo jad_an = jad_cp.jad_an(context, 16384);
                    if (jad_an == null) {
                        str = "packageInfo is null";
                    } else {
                        jad_cp.jad_fs = jad_an.lastUpdateTime;
                    }
                }
                Logger.w("AppInfo", str);
                Logger.debugWithStackTrace(CoreInfo.TAG, "getLastUpdateTime() --> ".concat(String.valueOf(j10)));
                return j10;
            }
            j10 = jad_cp.jad_fs;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getLastUpdateTime() --> ".concat(String.valueOf(j10)));
            return j10;
        }

        public static String getPackageName(Context context) {
            String jad_an = jad_cp.jad_an(context);
            jad_an.jad_an(jad_an, "getPackageName() --> ", CoreInfo.TAG);
            return jad_an;
        }

        public static List<ActivityManager.RunningAppProcessInfo> getRunningAppProcesses(Context context) {
            jad_bo jad_boVar = CoreInfo.sensitiveApi;
            List<ActivityManager.RunningAppProcessInfo> jad_dq = jad_boVar != null ? jad_boVar.jad_dq(context) : new ArrayList<>();
            Logger.debugWithStackTrace(CoreInfo.TAG, "getRunningAppProcesses() --> ".concat(String.valueOf(jad_dq)));
            return jad_dq;
        }

        public static List<ActivityManager.RunningServiceInfo> getRunningServices(Context context) {
            return getRunningServices(context, Integer.MAX_VALUE);
        }

        public static List<ActivityManager.RunningTaskInfo> getRunningTasks(Context context) {
            return getRunningTasks(context, Integer.MAX_VALUE);
        }

        public static long getSignatureHash(Context context) {
            long jad_bo = jad_cp.jad_bo(context);
            Logger.debugWithStackTrace(CoreInfo.TAG, "getSignatureHash() --> ".concat(String.valueOf(jad_bo)));
            return jad_bo;
        }

        public static int getStatusBarHeight(Context context) {
            int dimensionPixelSize;
            if (context == null) {
                Logger.w("AppInfo", "context is null");
                dimensionPixelSize = 0;
            } else {
                Resources resources = context.getResources();
                dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier(b.f10638c, "dimen", "android"));
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getStatusBarHeight() --> ".concat(String.valueOf(dimensionPixelSize)));
            return dimensionPixelSize;
        }

        public static int getVersionCode(Context context) {
            int i10;
            String str;
            if (jad_cp.jad_dq <= 0) {
                i10 = 0;
                if (context == null) {
                    str = "context is null";
                } else {
                    PackageInfo jad_an = jad_cp.jad_an(context, 16384);
                    if (jad_an == null) {
                        str = "packageInfo is null";
                    } else {
                        jad_cp.jad_dq = jad_an.versionCode;
                    }
                }
                Logger.w("AppInfo", str);
                Logger.debugWithStackTrace(CoreInfo.TAG, "getVersionCode() --> ".concat(String.valueOf(i10)));
                return i10;
            }
            i10 = jad_cp.jad_dq;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getVersionCode() --> ".concat(String.valueOf(i10)));
            return i10;
        }

        public static String getVersionName(Context context) {
            String str;
            String str2;
            if (TextUtils.isEmpty(jad_cp.jad_cp)) {
                str = "";
                if (context == null) {
                    str2 = "context is null";
                } else {
                    PackageInfo jad_an = jad_cp.jad_an(context, 16384);
                    if (jad_an == null) {
                        str2 = "packageInfo is null";
                    } else {
                        jad_cp.jad_cp = jad_an.versionName;
                    }
                }
                Logger.w("AppInfo", str2);
                jad_an.jad_an(str, "getVersionName() --> ", CoreInfo.TAG);
                return str;
            }
            str = jad_cp.jad_cp;
            jad_an.jad_an(str, "getVersionName() --> ", CoreInfo.TAG);
            return str;
        }

        @TargetApi(17)
        public static boolean isNavigationBarVisible(Activity activity) {
            boolean z10 = false;
            if (activity == null) {
                Logger.w("AppInfo", "activity is null");
            } else {
                Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getRealMetrics(displayMetrics);
                int i10 = displayMetrics.heightPixels;
                int i11 = displayMetrics.widthPixels;
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics2);
                int i12 = displayMetrics2.heightPixels;
                int i13 = displayMetrics2.widthPixels;
                if (i10 - i12 > 0 || i11 - i13 > 0) {
                    z10 = true;
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "isNavigationBarVisible() --> ".concat(String.valueOf(z10)));
            return z10;
        }

        public static List<ActivityManager.RunningServiceInfo> getRunningServices(Context context, int i10) {
            jad_bo jad_boVar = CoreInfo.sensitiveApi;
            List<ActivityManager.RunningServiceInfo> jad_an = jad_boVar != null ? jad_boVar.jad_an(context, i10) : new ArrayList<>();
            Logger.debugWithStackTrace(CoreInfo.TAG, "getRunningServices() --> ".concat(String.valueOf(jad_an)));
            return jad_an;
        }

        public static List<ActivityManager.RunningTaskInfo> getRunningTasks(Context context, int i10) {
            jad_bo jad_boVar = CoreInfo.sensitiveApi;
            List<ActivityManager.RunningTaskInfo> jad_bo = jad_boVar != null ? jad_boVar.jad_bo(context, i10) : new ArrayList<>();
            Logger.debugWithStackTrace(CoreInfo.TAG, "getRunningTasks() --> ".concat(String.valueOf(jad_bo)));
            return jad_bo;
        }
    }

    public static class Device {
        public static jad_dq<ArrayList<NetworkInterface>> networkInterfacesSupplier;
        public static jad_dq<WifiInfo> wifiInfoSupplier;
        public static jad_dq<List<ScanResult>> wifiListSupplier;

        public static boolean checkPipes() {
            boolean f10 = a.f();
            Logger.debugWithStackTrace(CoreInfo.TAG, "checkPipes() --> ".concat(String.valueOf(f10)));
            return f10;
        }

        public static String getAndroidId(Context context) {
            String str;
            if (TextUtils.isEmpty(a.f10697a)) {
                if (context == null) {
                    Logger.w("Baseinfo.DeviceInfo", "context is null");
                    str = "";
                    jad_an.jad_an(str, "getAndroidId() --> ", CoreInfo.TAG);
                    return str;
                }
                a.f10697a = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Settings.Secure.getString(context.getContentResolver(), "android_id"));
            }
            str = a.f10697a;
            jad_an.jad_an(str, "getAndroidId() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getAndroidIdForDeviceFinger(Context context) {
            String str;
            if (TextUtils.isEmpty(a.f10698b)) {
                String str2 = "";
                if (context != null) {
                    try {
                        if (Build.VERSION.SDK_INT < 28) {
                            str = com.jd.ad.sdk.jad_dq.jad_an.jad_an(context, "android_id");
                            try {
                                if (TextUtils.isEmpty(str)) {
                                    str = com.jd.ad.sdk.jad_dq.jad_an.jad_bo(context, "android_id");
                                }
                            } catch (Throwable unused) {
                            }
                        } else {
                            str = "";
                        }
                        str.equals("");
                        if (str.equals("")) {
                            str2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
                        }
                        str2 = str;
                    } catch (Throwable unused2) {
                    }
                }
                a.f10698b = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(str2);
            }
            String str3 = a.f10698b;
            jad_an.jad_an(str3, "getAndroidIdForDeviceFinger() --> ", CoreInfo.TAG);
            return str3;
        }

        public static long getAvailableInternalMemorySize(Context context) {
            long j10;
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                j10 = statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (Exception unused) {
                j10 = 0;
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getAvailableInternalMemorySize() --> ".concat(String.valueOf(j10)));
            return j10;
        }

        public static int getBatteryLevel(Context context) {
            int i10 = -1;
            if (context != null) {
                try {
                    i10 = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("level", -1);
                } catch (Throwable unused) {
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getBatteryLevel() --> ".concat(String.valueOf(i10)));
            return i10;
        }

        public static int getBatteryPlugged(Context context) {
            int i10 = -1;
            if (context != null) {
                try {
                    i10 = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("plugged", -1);
                } catch (Throwable unused) {
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getBatteryPlugged() --> ".concat(String.valueOf(i10)));
            return i10;
        }

        public static int getBatteryScale(Context context) {
            int i10 = -1;
            if (context != null) {
                try {
                    i10 = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("scale", -1);
                } catch (Throwable unused) {
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getBatteryScale() --> ".concat(String.valueOf(i10)));
            return i10;
        }

        public static int getBatteryStatus(Context context) {
            int i10 = -1;
            if (context != null) {
                try {
                    i10 = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("status", -1);
                } catch (Throwable unused) {
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getBatteryStatus() --> ".concat(String.valueOf(i10)));
            return i10;
        }

        public static String getBluetoothMac(Context context) {
            String str = "";
            try {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                String address = defaultAdapter != null ? defaultAdapter.getAddress() : "";
                if (TextUtils.isEmpty(address) || TextUtils.equals("02:00:00:00:00:00", address)) {
                    address = Settings.Secure.getString(context.getContentResolver(), "bluetooth_address");
                }
                if (!TextUtils.isEmpty(address)) {
                    str = address;
                }
            } catch (Exception unused) {
            }
            jad_an.jad_an(str, "getBluetoothMac() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getBluetoothName(Context context) {
            String str = "";
            try {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                String name = defaultAdapter != null ? defaultAdapter.getName() : "";
                if (!TextUtils.isEmpty(name)) {
                    str = name;
                }
            } catch (Exception unused) {
            }
            jad_an.jad_an(str, "getBluetoothName() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getBoard() {
            if (TextUtils.isEmpty(a.f10703g)) {
                a.f10703g = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.BOARD);
            }
            String str = a.f10703g;
            jad_an.jad_an(str, "getBoard() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getBoardPlatform() {
            if (TextUtils.isEmpty(a.f10704h)) {
                a.f10704h = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(jad_hu.jad_an("ro.board.platform", ""));
            }
            String str = a.f10704h;
            jad_an.jad_an(str, "getBoardPlatform() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getBootloaderVersion() {
            if (TextUtils.isEmpty(a.f10708l)) {
                a.f10708l = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.BOOTLOADER);
            }
            String str = a.f10708l;
            jad_an.jad_an(str, "getBootloaderVersion() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getBrand() {
            if (TextUtils.isEmpty(a.f10701e)) {
                a.f10701e = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.BRAND);
            }
            String str = a.f10701e;
            jad_an.jad_an(str, "getBrand() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getCPUMaxFreq() {
            String str;
            if (TextUtils.isEmpty(a.f10714r)) {
                String jad_an = com.jd.ad.sdk.jad_lo.jad_cp.jad_an("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq", false);
                if (jad_an.length() == 0) {
                    str = "";
                    jad_an.jad_an(str, "getCPUMaxFreq() --> ", CoreInfo.TAG);
                    return str;
                }
                a.f10714r = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(jad_an);
            }
            str = a.f10714r;
            jad_an.jad_an(str, "getCPUMaxFreq() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getCPUNum() {
            String str;
            if (TextUtils.isEmpty(a.f10712p)) {
                try {
                    a.f10712p = String.valueOf(new File("/sys/devices/system/cpu/").listFiles(new com.jd.ad.sdk.jad_cp.jad_an()).length);
                } catch (Exception e10) {
                    Logger.e("Baseinfo.DeviceInfo", "An exception happens when call getCPUNum()", e10);
                    str = "1";
                }
            }
            str = a.f10712p;
            jad_an.jad_an(str, "getCPUNum() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getCPUSerialNo() {
            LineNumberReader lineNumberReader;
            Throwable th2;
            InputStreamReader inputStreamReader;
            String str;
            if (TextUtils.isEmpty(a.f10711o)) {
                try {
                    inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("cat /proc/cpuinfo | grep Serial").getInputStream());
                    try {
                        lineNumberReader = new LineNumberReader(inputStreamReader);
                        for (int i10 = 0; i10 < 100; i10 += 2) {
                            try {
                                String readLine = lineNumberReader.readLine();
                                if (readLine != null && readLine.indexOf("Serial") >= 0) {
                                    str = readLine.substring(readLine.indexOf(":") + 1).trim();
                                    break;
                                }
                            } catch (Throwable th3) {
                                try {
                                    th3.printStackTrace();
                                } catch (Throwable th4) {
                                    th2 = th4;
                                    try {
                                        th2.printStackTrace();
                                        str = "";
                                        a.f10711o = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(str);
                                        String str2 = a.f10711o;
                                        jad_an.jad_an(str2, "getCPUSerialNo() --> ", CoreInfo.TAG);
                                        return str2;
                                    } finally {
                                    }
                                }
                            }
                        }
                    } catch (Throwable th5) {
                        lineNumberReader = null;
                        th2 = th5;
                    }
                } catch (Throwable th6) {
                    lineNumberReader = null;
                    th2 = th6;
                    inputStreamReader = null;
                }
                str = "";
                a.f10711o = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(str);
            }
            String str22 = a.f10711o;
            jad_an.jad_an(str22, "getCPUSerialNo() --> ", CoreInfo.TAG);
            return str22;
        }

        public static int getCellId(Context context) {
            Logger.debugWithStackTrace(CoreInfo.TAG, "getCellId() --> -1");
            return -1;
        }

        public static CellLocation getCellLocationForDeviceFinger(Context context) {
            Logger.debugWithStackTrace(CoreInfo.TAG, "getCellLocationForDeviceFinger() --> ".concat("null"));
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
        
            if (r2 == null) goto L160;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.String getCpuCurFreq() {
            /*
                r0 = 0
                java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
                java.lang.String r2 = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"
                r1.<init>(r2)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
                r2.<init>(r1)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
                java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
                java.lang.String r0 = r0.trim()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
                r1.close()     // Catch: java.io.IOException -> L18
            L18:
                r2.close()     // Catch: java.io.IOException -> L50
                goto L50
            L1c:
                r0 = move-exception
                goto L20
            L1e:
                goto L24
            L20:
                r3 = r1
                r1 = r0
                r0 = r3
                goto L36
            L24:
                r0 = r1
                goto L44
            L26:
                r2 = move-exception
                goto L2a
            L28:
                goto L2f
            L2a:
                r3 = r2
                r2 = r0
                r0 = r1
                r1 = r3
                goto L36
            L2f:
                r2 = r0
                goto L24
            L31:
                r1 = move-exception
                goto L35
            L33:
                goto L43
            L35:
                r2 = r0
            L36:
                if (r0 == 0) goto L3d
                r0.close()     // Catch: java.io.IOException -> L3c
                goto L3d
            L3c:
            L3d:
                if (r2 == 0) goto L42
                r2.close()     // Catch: java.io.IOException -> L42
            L42:
                throw r1
            L43:
                r2 = r0
            L44:
                if (r0 == 0) goto L4b
                r0.close()     // Catch: java.io.IOException -> L4a
                goto L4b
            L4a:
            L4b:
                java.lang.String r0 = ""
                if (r2 == 0) goto L50
                goto L18
            L50:
                java.lang.String r1 = "getCpuCurFreq() --> "
                java.lang.String r2 = "BaseInfo.CoreInfo"
                com.jd.ad.sdk.jad_an.jad_an.jad_an(r0, r1, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jd.android.sdk.coreinfo.CoreInfo.Device.getCpuCurFreq():java.lang.String");
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0059, code lost:
        
            if (r2 == null) goto L163;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.String getCpuMinFreq() {
            /*
                java.lang.String r0 = com.jd.android.sdk.coreinfo.a.f10715s
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 == 0) goto L5c
                r0 = 0
                java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
                java.lang.String r2 = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"
                r1.<init>(r2)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
                r2.<init>(r1)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
                java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
                java.lang.String r0 = r0.trim()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
                java.lang.String r0 = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(r0)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
                com.jd.android.sdk.coreinfo.a.f10715s = r0     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
                r1.close()     // Catch: java.io.IOException -> L26
            L26:
                r2.close()     // Catch: java.io.IOException -> L5c
                goto L5c
            L2a:
                r0 = move-exception
                goto L2e
            L2c:
                goto L32
            L2e:
                r3 = r1
                r1 = r0
                r0 = r3
                goto L44
            L32:
                r0 = r1
                goto L52
            L34:
                r2 = move-exception
                goto L38
            L36:
                goto L3d
            L38:
                r3 = r2
                r2 = r0
                r0 = r1
                r1 = r3
                goto L44
            L3d:
                r2 = r0
                goto L32
            L3f:
                r1 = move-exception
                goto L43
            L41:
                goto L51
            L43:
                r2 = r0
            L44:
                if (r0 == 0) goto L4b
                r0.close()     // Catch: java.io.IOException -> L4a
                goto L4b
            L4a:
            L4b:
                if (r2 == 0) goto L50
                r2.close()     // Catch: java.io.IOException -> L50
            L50:
                throw r1
            L51:
                r2 = r0
            L52:
                if (r0 == 0) goto L59
                r0.close()     // Catch: java.io.IOException -> L58
                goto L59
            L58:
            L59:
                if (r2 == 0) goto L5c
                goto L26
            L5c:
                java.lang.String r0 = com.jd.android.sdk.coreinfo.a.f10715s
                java.lang.String r1 = "getCpuMinFreq() --> "
                java.lang.String r2 = "BaseInfo.CoreInfo"
                com.jd.ad.sdk.jad_an.jad_an.jad_an(r0, r1, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jd.android.sdk.coreinfo.CoreInfo.Device.getCpuMinFreq():java.lang.String");
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
        
            if (r2 == null) goto L158;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.String getCpuName() {
            /*
                java.lang.String r0 = com.jd.android.sdk.coreinfo.a.f10713q
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 == 0) goto L59
                r0 = 0
                java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3c
                java.lang.String r2 = "/proc/cpuinfo"
                r1.<init>(r2)     // Catch: java.lang.Throwable -> L3c
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L36
                r2.<init>(r1)     // Catch: java.lang.Throwable -> L36
                java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L29
                java.lang.String r3 = ":\\s+"
                r4 = 2
                java.lang.String[] r0 = r0.split(r3, r4)     // Catch: java.lang.Throwable -> L29
                int r3 = r0.length     // Catch: java.lang.Throwable -> L29
                if (r3 < r4) goto L2b
                r3 = 1
                r0 = r0[r3]     // Catch: java.lang.Throwable -> L29
                com.jd.android.sdk.coreinfo.a.f10713q = r0     // Catch: java.lang.Throwable -> L29
                goto L2b
            L29:
                r0 = move-exception
                goto L32
            L2b:
                r1.close()     // Catch: java.io.IOException -> L2e
            L2e:
                r2.close()     // Catch: java.io.IOException -> L59
                goto L59
            L32:
                r5 = r1
                r1 = r0
                r0 = r5
                goto L3e
            L36:
                r2 = move-exception
                r5 = r2
                r2 = r0
                r0 = r1
                r1 = r5
                goto L3e
            L3c:
                r1 = move-exception
                r2 = r0
            L3e:
                r1.printStackTrace()     // Catch: java.lang.Throwable -> L4b
                if (r0 == 0) goto L48
                r0.close()     // Catch: java.io.IOException -> L47
                goto L48
            L47:
            L48:
                if (r2 == 0) goto L59
                goto L2e
            L4b:
                r1 = move-exception
                if (r0 == 0) goto L53
                r0.close()     // Catch: java.io.IOException -> L52
                goto L53
            L52:
            L53:
                if (r2 == 0) goto L58
                r2.close()     // Catch: java.io.IOException -> L58
            L58:
                throw r1
            L59:
                java.lang.String r0 = com.jd.android.sdk.coreinfo.a.f10713q
                java.lang.String r1 = "getCpuName() --> "
                java.lang.String r2 = "BaseInfo.CoreInfo"
                com.jd.ad.sdk.jad_an.jad_an.jad_an(r0, r1, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jd.android.sdk.coreinfo.CoreInfo.Device.getCpuName():java.lang.String");
        }

        public static float getDensity(Context context) {
            DisplayMetrics l10 = a.l(context);
            float f10 = l10 == null ? 1.0f : l10.density;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getDensity() --> ".concat(String.valueOf(f10)));
            return f10;
        }

        public static String getDensityDpi(Context context) {
            String valueOf = String.valueOf(getDensityDpiInt(context));
            Logger.d(CoreInfo.TAG, "getDensityDpi() --> ".concat(String.valueOf(valueOf)));
            return valueOf;
        }

        public static int getDensityDpiInt(Context context) {
            DisplayMetrics l10 = a.l(context);
            int i10 = l10 == null ? 160 : l10.densityDpi;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getDensityDpiInt() --> ".concat(String.valueOf(i10)));
            return i10;
        }

        public static String getDeviceId(Context context) {
            Logger.debugWithStackTrace(CoreInfo.TAG, "getDeviceId() --> ".concat(""));
            return "";
        }

        public static String getDeviceIdForDeviceFinger(Context context) {
            Logger.debugWithStackTrace(CoreInfo.TAG, "getDeviceIdForDeviceFinger() --> ".concat(""));
            return "";
        }

        public static String getDeviceName() {
            jad_bo jad_boVar = CoreInfo.sensitiveApi;
            String jad_an = jad_boVar != null ? jad_boVar.jad_an() : "";
            jad_an.jad_an(jad_an, "getDeviceName() --> ", CoreInfo.TAG);
            return jad_an;
        }

        public static String getDisplayMetrics(Context context) {
            String str;
            DisplayMetrics l10 = a.l(context);
            if (l10 == null) {
                str = "";
            } else {
                str = l10.widthPixels + h.f28447r + l10.heightPixels;
            }
            jad_an.jad_an(str, "getDisplayMetrics() --> ", CoreInfo.TAG);
            return str;
        }

        public static DisplayMetrics getDisplayMetricsObject(Context context) {
            DisplayMetrics l10 = a.l(context);
            Logger.debugWithStackTrace(CoreInfo.TAG, "getDisplayMetricsObject() --> ".concat(String.valueOf(l10)));
            return l10;
        }

        public static String getDisplayMetricsWithNavigationBar(Context context) {
            String jad_anVar = com.jd.ad.sdk.jad_dq.jad_bo.jad_an(context).toString();
            jad_an.jad_an(jad_anVar, "getDisplayMetricsWithNavigationBar() --> ", CoreInfo.TAG);
            return jad_anVar;
        }

        public static long getExternalStorageSize() {
            long j10 = 0;
            if (a.f10718v <= 0) {
                try {
                    a.f10718v = a.a(Environment.getExternalStorageDirectory().getPath());
                } catch (Exception e10) {
                    Logger.e("Baseinfo.DeviceInfo", "An exception happens when call getExternalStorageSize()", e10);
                }
            }
            j10 = a.f10718v;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getExternalStorageSize() --> ".concat(String.valueOf(j10)));
            return j10;
        }

        public static int getGateway(Context context) {
            DhcpInfo dhcpInfo;
            int i10 = 0;
            try {
                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                if (wifiManager != null && (dhcpInfo = wifiManager.getDhcpInfo()) != null) {
                    i10 = dhcpInfo.gateway;
                }
            } catch (Throwable unused) {
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getGateway() --> ".concat(String.valueOf(i10)));
            return i10;
        }

        public static String getHardwareName() {
            if (TextUtils.isEmpty(a.f10707k)) {
                a.f10707k = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.HARDWARE);
            }
            String str = a.f10707k;
            jad_an.jad_an(str, "getHardwareName() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getHardwareSerialNo() {
            jad_bo jad_boVar = CoreInfo.sensitiveApi;
            String jad_bo = jad_boVar != null ? jad_boVar.jad_bo() : "";
            jad_an.jad_an(jad_bo, "getHardwareSerialNo() --> ", CoreInfo.TAG);
            return jad_bo;
        }

        public static String getHostName() {
            if (TextUtils.isEmpty(a.f10709m)) {
                a.f10709m = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.HOST);
            }
            String str = a.f10709m;
            jad_an.jad_an(str, "getHostName() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getIpAddressFromWifiInfo(Context context) {
            WifiInfo k10;
            String str = "";
            if (context == null) {
                Logger.e("Baseinfo.DeviceInfo", "getIpAddressFromWifiInfo context is null");
            } else {
                NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
                if (networkInfo != null && networkInfo.isConnected() && (k10 = a.k(context)) != null) {
                    int ipAddress = k10.getIpAddress();
                    str = (ipAddress & 255) + p1.b.f29697h + ((ipAddress >> 8) & 255) + p1.b.f29697h + ((ipAddress >> 16) & 255) + p1.b.f29697h + ((ipAddress >> 24) & 255);
                }
            }
            jad_an.jad_an(str, "getIpAddressFromWifiInfo() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getLinuxVersion() {
            String str;
            if (TextUtils.isEmpty(a.f10710n)) {
                try {
                    str = com.jd.ad.sdk.jad_lo.jad_cp.jad_an("/proc/version", false);
                    try {
                        if (TextUtils.isEmpty(str)) {
                            str = com.jd.ad.sdk.jad_lo.jad_an.jad_an("uname -a");
                        }
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    str = "";
                }
                a.f10710n = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(str);
            }
            String str2 = a.f10710n;
            jad_an.jad_an(str2, "getLinuxVersion() --> ", CoreInfo.TAG);
            return str2;
        }

        public static String getManufacture() {
            if (TextUtils.isEmpty(a.f10700d)) {
                a.f10700d = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.MANUFACTURER);
            }
            String str = a.f10700d;
            jad_an.jad_an(str, "getManufacture() --> ", CoreInfo.TAG);
            return str;
        }

        public static long getMemAvailSize(Context context) {
            long j10 = 0;
            if (context == null) {
                Logger.w("Baseinfo.DeviceInfo", "context is null");
            } else {
                try {
                    ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    j10 = memoryInfo.availMem >> 10;
                } catch (Exception e10) {
                    Logger.e("Baseinfo.DeviceInfo", "An exception happens when call getMemAvailSize()", e10);
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getMemAvailSize() --> ".concat(String.valueOf(j10)));
            return j10;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0046, code lost:
        
            if (r3 == null) goto L99;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.String[] getMemInfo() {
            /*
                r0 = 3
                java.lang.String[] r1 = new java.lang.String[r0]
                r2 = 0
                java.lang.String r3 = ""
                r1[r2] = r3
                r4 = 1
                r1[r4] = r3
                r4 = 2
                r1[r4] = r3
                r3 = 0
                java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3c java.io.FileNotFoundException -> L3e
                java.lang.String r5 = "/proc/meminfo"
                r4.<init>(r5)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3c java.io.FileNotFoundException -> L3e
                java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3c java.io.FileNotFoundException -> L3e
                r6 = 8192(0x2000, float:1.148E-41)
                r5.<init>(r4, r6)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3c java.io.FileNotFoundException -> L3e
            L1d:
                if (r2 >= r0) goto L34
                java.lang.String r3 = r5.readLine()     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2a java.io.FileNotFoundException -> L2c
                r1[r2] = r3     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2a java.io.FileNotFoundException -> L2c
                int r2 = r2 + 1
                goto L1d
            L28:
                goto L2e
            L2a:
                goto L30
            L2c:
                goto L32
            L2e:
                r3 = r5
                goto L40
            L30:
                r3 = r5
                goto L43
            L32:
                r3 = r5
                goto L46
            L34:
                r5.close()     // Catch: java.io.IOException -> L38
                goto L4f
            L38:
                r0 = move-exception
                goto L4c
            L3a:
                goto L40
            L3c:
                goto L43
            L3e:
                goto L46
            L40:
                if (r3 == 0) goto L4f
                goto L48
            L43:
                if (r3 == 0) goto L4f
                goto L48
            L46:
                if (r3 == 0) goto L4f
            L48:
                r3.close()     // Catch: java.io.IOException -> L38
                goto L4f
            L4c:
                r0.printStackTrace()
            L4f:
                java.lang.String r0 = java.lang.String.valueOf(r1)
                java.lang.String r2 = "getMemInfo() --> "
                java.lang.String r0 = r2.concat(r0)
                java.lang.String r2 = "BaseInfo.CoreInfo"
                com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(r2, r0)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jd.android.sdk.coreinfo.CoreInfo.Device.getMemInfo():java.lang.String[]");
        }

        public static long getMemState(Context context) {
            long j10;
            BufferedReader bufferedReader = null;
            String str = null;
            BufferedReader bufferedReader2 = null;
            try {
                BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/proc/meminfo"))), 1024);
                String str2 = null;
                while (true) {
                    try {
                        String readLine = bufferedReader3.readLine();
                        if (readLine != null) {
                            if (readLine.startsWith("MemTotal")) {
                                str = readLine;
                            } else if (readLine.startsWith("MemFree")) {
                                str2 = readLine;
                            }
                            if (str != null && str2 != null) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (Exception unused) {
                        bufferedReader2 = bufferedReader3;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException unused2) {
                            }
                        }
                        j10 = 0;
                        Logger.debugWithStackTrace(CoreInfo.TAG, "getMemState() --> ".concat(String.valueOf(j10)));
                        return j10;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader3;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                }
                long d10 = a.d(str);
                long d11 = a.d(str2);
                ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                j10 = new long[]{d10, d11, memoryInfo.availMem}[0];
                try {
                    bufferedReader3.close();
                } catch (IOException unused4) {
                }
            } catch (Exception unused5) {
            } catch (Throwable th3) {
                th = th3;
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getMemState() --> ".concat(String.valueOf(j10)));
            return j10;
        }

        public static long getMemTotalSize(Context context) {
            long j10 = 0;
            if (a.f10716t <= 0) {
                if (context == null) {
                    Logger.w("Baseinfo.DeviceInfo", "context is null");
                } else {
                    try {
                        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
                        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                        activityManager.getMemoryInfo(memoryInfo);
                        a.f10716t = memoryInfo.totalMem >> 10;
                    } catch (Exception e10) {
                        Logger.e("Baseinfo.DeviceInfo", "An exception happens when call getMemTotalSize()", e10);
                    }
                }
                Logger.debugWithStackTrace(CoreInfo.TAG, "getMemTotalSize() --> ".concat(String.valueOf(j10)));
                return j10;
            }
            j10 = a.f10716t;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getMemTotalSize() --> ".concat(String.valueOf(j10)));
            return j10;
        }

        public static String getModel() {
            if (TextUtils.isEmpty(a.f10702f)) {
                if (TextUtils.isEmpty(a.f10701e)) {
                    a.f10701e = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.BRAND);
                }
                if ("xiaomi".equalsIgnoreCase(a.f10701e)) {
                    a.f10702f = jad_hu.jad_an("ro.product.marketname", "");
                }
                if (TextUtils.isEmpty(a.f10702f)) {
                    a.f10702f = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.MODEL);
                }
            }
            String str = a.f10702f;
            jad_an.jad_an(str, "getModel() --> ", CoreInfo.TAG);
            return str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0068, code lost:
        
            if (android.text.TextUtils.isEmpty(r0) == false) goto L101;
         */
        @java.lang.Deprecated
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.String getNetAddressInfo() {
            /*
                java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L6b
                r0.<init>()     // Catch: java.lang.Throwable -> L6b
                java.util.ArrayList r1 = com.jd.android.sdk.coreinfo.a.g()     // Catch: java.lang.Throwable -> L6b
                if (r1 == 0) goto L60
                java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L6b
            Lf:
                boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L6b
                if (r2 == 0) goto L60
                java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L6b
                java.net.NetworkInterface r2 = (java.net.NetworkInterface) r2     // Catch: java.lang.Throwable -> L6b
                java.util.Enumeration r2 = r2.getInetAddresses()     // Catch: java.lang.Throwable -> L6b
            L1f:
                boolean r3 = r2.hasMoreElements()     // Catch: java.lang.Throwable -> L6b
                if (r3 == 0) goto Lf
                java.lang.Object r3 = r2.nextElement()     // Catch: java.lang.Throwable -> L6b
                java.net.InetAddress r3 = (java.net.InetAddress) r3     // Catch: java.lang.Throwable -> L6b
                boolean r4 = r3.isLoopbackAddress()     // Catch: java.lang.Throwable -> L6b
                if (r4 != 0) goto L1f
                java.lang.String r4 = r3.getHostAddress()     // Catch: java.lang.Throwable -> L6b
                boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L6b
                if (r5 != 0) goto L1f
                boolean r3 = r3 instanceof java.net.Inet4Address     // Catch: java.lang.Throwable -> L6b
                if (r3 == 0) goto L50
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6b
                r3.<init>()     // Catch: java.lang.Throwable -> L6b
                r3.append(r4)     // Catch: java.lang.Throwable -> L6b
                java.lang.String r4 = "%ipv4"
                r3.append(r4)     // Catch: java.lang.Throwable -> L6b
                java.lang.String r4 = r3.toString()     // Catch: java.lang.Throwable -> L6b
            L50:
                int r3 = r0.length()     // Catch: java.lang.Throwable -> L6b
                if (r3 != 0) goto L5a
            L56:
                r0.append(r4)     // Catch: java.lang.Throwable -> L6b
                goto L1f
            L5a:
                java.lang.String r3 = ", "
                r0.append(r3)     // Catch: java.lang.Throwable -> L6b
                goto L56
            L60:
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L6b
                boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L6b
                if (r1 != 0) goto L6b
                goto L6d
            L6b:
                java.lang.String r0 = ""
            L6d:
                java.lang.String r1 = "getNetAddressInfo() --> "
                java.lang.String r2 = "BaseInfo.CoreInfo"
                com.jd.ad.sdk.jad_an.jad_an.jad_an(r0, r1, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jd.android.sdk.coreinfo.CoreInfo.Device.getNetAddressInfo():java.lang.String");
        }

        public static String[][] getNetAddresses() {
            String[][] strArr;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            try {
                ArrayList<NetworkInterface> g10 = a.g();
                if (g10 != null) {
                    Iterator<NetworkInterface> it = g10.iterator();
                    while (it.hasNext()) {
                        Enumeration<InetAddress> inetAddresses = it.next().getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement = inetAddresses.nextElement();
                            if (!nextElement.isLoopbackAddress()) {
                                String hostAddress = nextElement.getHostAddress();
                                if (!TextUtils.isEmpty(hostAddress)) {
                                    if (nextElement instanceof Inet4Address) {
                                        arrayList.add(hostAddress);
                                    } else if (nextElement instanceof Inet6Address) {
                                        arrayList2.add(hostAddress);
                                    }
                                }
                            }
                        }
                    }
                }
                strArr = new String[][]{(String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()])};
            } catch (Throwable unused) {
                strArr = (String[][]) Array.newInstance((Class<?>) String.class, 0, 0);
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getNetAddresses() --> ".concat(String.valueOf(strArr)));
            return strArr;
        }

        public static List<String> getNetAddressesForIPv4() {
            ArrayList arrayList = new ArrayList();
            try {
                ArrayList<NetworkInterface> g10 = a.g();
                if (g10 != null) {
                    Iterator<NetworkInterface> it = g10.iterator();
                    while (it.hasNext()) {
                        Enumeration<InetAddress> inetAddresses = it.next().getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement = inetAddresses.nextElement();
                            if (!nextElement.isLoopbackAddress()) {
                                String hostAddress = nextElement.getHostAddress();
                                if (!TextUtils.isEmpty(hostAddress) && (nextElement instanceof Inet4Address)) {
                                    arrayList.add(hostAddress);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
                arrayList = new ArrayList();
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getNetAddressesForIPv4() --> ".concat(String.valueOf(arrayList)));
            return arrayList;
        }

        public static List<String> getNetAddressesForIPv6() {
            ArrayList arrayList = new ArrayList();
            try {
                ArrayList<NetworkInterface> g10 = a.g();
                if (g10 != null) {
                    Iterator<NetworkInterface> it = g10.iterator();
                    while (it.hasNext()) {
                        Enumeration<InetAddress> inetAddresses = it.next().getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement = inetAddresses.nextElement();
                            if (!nextElement.isLoopbackAddress()) {
                                String hostAddress = nextElement.getHostAddress();
                                if (!TextUtils.isEmpty(hostAddress) && (nextElement instanceof Inet6Address)) {
                                    arrayList.add(hostAddress);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
                arrayList = new ArrayList();
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getNetAddressesForIPv6() --> ".concat(String.valueOf(arrayList)));
            return arrayList;
        }

        public static int getNetmask(Context context) {
            DhcpInfo dhcpInfo;
            int i10 = 0;
            try {
                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                if (wifiManager != null && (dhcpInfo = wifiManager.getDhcpInfo()) != null) {
                    i10 = dhcpInfo.netmask;
                }
            } catch (Throwable unused) {
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getNetmask() --> ".concat(String.valueOf(i10)));
            return i10;
        }

        public static String getNetworkISO(Context context) {
            String str = "";
            try {
                String networkCountryIso = ((TelephonyManager) context.getSystemService("phone")).getNetworkCountryIso();
                if (!TextUtils.isEmpty(networkCountryIso)) {
                    str = networkCountryIso;
                }
            } catch (Exception unused) {
            }
            jad_an.jad_an(str, "getNetworkISO() --> ", CoreInfo.TAG);
            return str;
        }

        public static ArrayList<NetworkInterface> getNetworkInterfaces() {
            ArrayList<NetworkInterface> list = Collections.list(NetworkInterface.getNetworkInterfaces());
            Logger.debugWithStackTrace(CoreInfo.TAG, "getNetworkInterfaces() --> ".concat(String.valueOf(list)));
            return list;
        }

        public static String getNetworkOperator(Context context) {
            String str;
            try {
                str = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(((TelephonyManager) context.getSystemService("phone")).getNetworkOperator());
            } catch (Exception unused) {
                str = "";
            }
            jad_an.jad_an(str, "getNetworkOperator() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getNetworkOperatorName(Context context) {
            String str;
            try {
                str = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName());
            } catch (Exception unused) {
                str = "";
            }
            jad_an.jad_an(str, "getNetworkOperatorName() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getNetworkType(Context context) {
            String o10 = a.o(context);
            Logger.debugWithStackTrace(CoreInfo.TAG, "getNetworkType() --> ".concat(o10));
            return o10;
        }

        public static String getNetworkTypeForDeviceFinger(Context context) {
            NetworkInfo activeNetworkInfo;
            String str = "";
            if (context != null) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                        str = activeNetworkInfo.getSubtypeName();
                        String typeName = activeNetworkInfo.getTypeName();
                        if (activeNetworkInfo.getType() == 1) {
                            str = typeName;
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            jad_an.jad_an(str, "getNetworkTypeForDeviceFinger() --> ", CoreInfo.TAG);
            return str;
        }

        public static int getNetworkTypeInt(Context context) {
            jad_bo jad_boVar = CoreInfo.sensitiveApi;
            int jad_an = jad_boVar != null ? jad_boVar.jad_an(context) : 0;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getNetworkTypeInt() --> ".concat(String.valueOf(jad_an)));
            return jad_an;
        }

        public static String getProductName() {
            if (TextUtils.isEmpty(a.f10699c)) {
                a.f10699c = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.PRODUCT);
            }
            String str = a.f10699c;
            jad_an.jad_an(str, "getProductName() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getRadioVersion() {
            if (TextUtils.isEmpty(a.f10706j)) {
                a.f10706j = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.getRadioVersion());
            }
            String str = a.f10706j;
            jad_an.jad_an(str, "getRadioVersion() --> ", CoreInfo.TAG);
            return str;
        }

        public static ScreenSize getRealScreenSize(Context context) {
            jad_bo.jad_an jad_an = com.jd.ad.sdk.jad_dq.jad_bo.jad_an(context);
            ScreenSize screenSize = new ScreenSize(jad_an.jad_an, jad_an.jad_bo);
            Logger.debugWithStackTrace(CoreInfo.TAG, "getRealScreenSize() --> ".concat(String.valueOf(screenSize)));
            return screenSize;
        }

        public static long getRomSize() {
            long j10 = 0;
            if (a.f10717u <= 0) {
                try {
                    a.f10717u = a.a(Environment.getDataDirectory().getPath());
                } catch (Exception e10) {
                    Logger.e("Baseinfo.DeviceInfo", "An exception happens when call getRomSize()", e10);
                }
            }
            j10 = a.f10717u;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getRomSize() --> ".concat(String.valueOf(j10)));
            return j10;
        }

        public static String getSDCardId() {
            String jad_an = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(com.jd.ad.sdk.jad_lo.jad_cp.jad_an("/sys/block/mmcblk0/device/cid", false));
            jad_an.jad_an(jad_an, "getSDCardId() --> ", CoreInfo.TAG);
            return jad_an;
        }

        public static float getScaledDensity(Context context) {
            DisplayMetrics l10 = a.l(context);
            float f10 = l10 == null ? 1.0f : l10.scaledDensity;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getScaledDensity() --> ".concat(String.valueOf(f10)));
            return f10;
        }

        public static int getScreenHeight(Context context) {
            DisplayMetrics l10 = a.l(context);
            int i10 = l10 == null ? 320 : l10.heightPixels;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getScreenHeight() --> ".concat(String.valueOf(i10)));
            return i10;
        }

        public static int getScreenHeight2() {
            DisplayMetrics displayMetrics;
            try {
                displayMetrics = Resources.getSystem().getDisplayMetrics();
            } catch (Exception e10) {
                Logger.e("Baseinfo.DeviceInfo", "An exception happends when call getSystemDisplayMetricsObject()", e10);
                displayMetrics = null;
            }
            int i10 = displayMetrics == null ? 320 : displayMetrics.heightPixels;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getScreenHeight2() --> ".concat(String.valueOf(i10)));
            return i10;
        }

        public static int getScreenWidth(Context context) {
            DisplayMetrics l10 = a.l(context);
            int i10 = l10 == null ? 240 : l10.widthPixels;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getScreenWidth() --> ".concat(String.valueOf(i10)));
            return i10;
        }

        public static int getScreenWidth2() {
            DisplayMetrics displayMetrics;
            try {
                displayMetrics = Resources.getSystem().getDisplayMetrics();
            } catch (Exception e10) {
                Logger.e("Baseinfo.DeviceInfo", "An exception happends when call getSystemDisplayMetricsObject()", e10);
                displayMetrics = null;
            }
            int i10 = displayMetrics == null ? 240 : displayMetrics.widthPixels;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getScreenWidth2() --> ".concat(String.valueOf(i10)));
            return i10;
        }

        public static List<Sensor> getSensorList(Context context) {
            List<Sensor> sensorList = ((SensorManager) context.getSystemService(bt.f23586ac)).getSensorList(-1);
            Logger.debugWithStackTrace(CoreInfo.TAG, "getSensorList() --> ".concat(String.valueOf(sensorList)));
            return sensorList;
        }

        public static String getSimCountryIso(Context context) {
            String str = "";
            if (context != null) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        str = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(telephonyManager.getSimCountryIso());
                    }
                } catch (Throwable unused) {
                }
            }
            jad_an.jad_an(str, "getSimCountryIso() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getSimOperator(Context context) {
            String str;
            String str2 = "";
            if (context != null) {
                try {
                    str2 = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(((TelephonyManager) context.getSystemService("phone")).getSimOperator());
                } catch (Throwable th2) {
                    str = "DeviceInfo.getSimOperator() exception: " + th2.getMessage();
                }
                jad_an.jad_an(str2, "getSimOperator() --> ", CoreInfo.TAG);
                return str2;
            }
            str = "context is null";
            Logger.w("Baseinfo.DeviceInfo", str);
            jad_an.jad_an(str2, "getSimOperator() --> ", CoreInfo.TAG);
            return str2;
        }

        public static String getSimOperatorName(Context context) {
            String str = "";
            if (context != null) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        str = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(telephonyManager.getSimOperatorName());
                    }
                } catch (Throwable unused) {
                }
            }
            jad_an.jad_an(str, "getSimOperatorName() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getSimSerialNo(Context context) {
            com.jd.ad.sdk.jad_an.jad_bo jad_boVar = CoreInfo.sensitiveApi;
            String jad_cp = jad_boVar != null ? jad_boVar.jad_cp(context) : "";
            jad_an.jad_an(jad_cp, "getSimSerialNo() --> ", CoreInfo.TAG);
            return jad_cp;
        }

        public static String getSubscriberId(Context context) {
            Logger.debugWithStackTrace(CoreInfo.TAG, "getSubscriberId() --> ".concat(""));
            return "";
        }

        public static String getSubscriberIdForDeviceFinger(Context context) {
            Logger.debugWithStackTrace(CoreInfo.TAG, "getSubscriberIdForDeviceFinger() --> ".concat(""));
            return "";
        }

        public static String[] getSuppportedABIs() {
            String[] strArr = a.f10705i;
            if (strArr == null || strArr.length == 0) {
                a.f10705i = Build.SUPPORTED_ABIS;
            }
            String[] strArr2 = a.f10705i;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getSuppportedABIs() --> ".concat(String.valueOf(strArr2)));
            return strArr2;
        }

        public static String getUserAgent(Context context) {
            String jad_an = com.jd.ad.sdk.jad_dq.jad_dq.jad_an(context, 1000L);
            jad_an.jad_an(jad_an, "getUserAgent() --> ", CoreInfo.TAG);
            return jad_an;
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
        
            if ("02:00:00:00:00:00".equals(r2) == false) goto L31;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.String getWifiBSSID(android.content.Context r2) {
            /*
                android.net.wifi.WifiInfo r2 = com.jd.android.sdk.coreinfo.a.k(r2)
                if (r2 == 0) goto L18
                java.lang.String r2 = r2.getBSSID()
                boolean r0 = android.text.TextUtils.isEmpty(r2)
                if (r0 != 0) goto L18
                java.lang.String r0 = "02:00:00:00:00:00"
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L1a
            L18:
                java.lang.String r2 = ""
            L1a:
                java.lang.String r0 = "getWifiBSSID() --> "
                java.lang.String r1 = "BaseInfo.CoreInfo"
                com.jd.ad.sdk.jad_an.jad_an.jad_an(r2, r0, r1)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jd.android.sdk.coreinfo.CoreInfo.Device.getWifiBSSID(android.content.Context):java.lang.String");
        }

        public static List<String> getWifiBSSIDList(Context context) {
            List<String> h10 = a.h(context);
            Logger.debugWithStackTrace(CoreInfo.TAG, "getWifiBSSIDList() --> ".concat(String.valueOf(h10)));
            return h10;
        }

        public static Map<String, String> getWifiBssidAndSsidMap(Context context) {
            HashMap hashMap = new HashMap();
            List<ScanResult> n10 = a.n(context);
            if (n10 != null && !n10.isEmpty()) {
                for (ScanResult scanResult : n10) {
                    hashMap.put(scanResult.BSSID, scanResult.SSID);
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getWifiBssidAndSsidMap() --> ".concat(String.valueOf(hashMap)));
            return hashMap;
        }

        public static WifiInfo getWifiInfo(Context context) {
            WifiInfo b10 = a.b(context);
            Logger.debugWithStackTrace(CoreInfo.TAG, "getWifiInfo() --> ".concat(String.valueOf(b10)));
            if (!Logger.printStack) {
                Logger.d(CoreInfo.TAG, Logger.getStackTrace());
            }
            return b10;
        }

        public static int getWifiLinkSpeed(Context context) {
            WifiInfo k10 = a.k(context);
            int linkSpeed = k10 != null ? k10.getLinkSpeed() : -1;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getWifiLinkSpeed() --> ".concat(String.valueOf(linkSpeed)));
            return linkSpeed;
        }

        public static List<String> getWifiList(Context context) {
            List<String> h10 = a.h(context);
            Logger.debugWithStackTrace(CoreInfo.TAG, "getWifiList() --> ".concat(String.valueOf(h10)));
            return h10;
        }

        @Deprecated
        public static String getWifiMacAddress(Context context) {
            com.jd.ad.sdk.jad_an.jad_bo jad_boVar = CoreInfo.sensitiveApi;
            return jad_boVar != null ? jad_boVar.jad_bo(context) : "";
        }

        @Deprecated
        public static String getWifiMacAddressForDeviceFinger(Context context) {
            return "";
        }

        @Deprecated
        public static String getWifiMacAddressOver23() {
            com.jd.ad.sdk.jad_an.jad_bo jad_boVar = CoreInfo.sensitiveApi;
            return jad_boVar != null ? jad_boVar.jad_cp() : "";
        }

        public static int getWifiRssi(Context context) {
            WifiInfo wifiInfo;
            int rssi = (!TextUtils.equals(a.o(context), "wifi") || (wifiInfo = getWifiInfo(context)) == null) ? 0 : wifiInfo.getRssi();
            Logger.debugWithStackTrace(CoreInfo.TAG, "getWifiRssi() --> ".concat(String.valueOf(rssi)));
            return rssi;
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
        
            if ("<unknown ssid>".equals(r2) == false) goto L31;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.String getWifiSSID(android.content.Context r2) {
            /*
                android.net.wifi.WifiInfo r2 = com.jd.android.sdk.coreinfo.a.k(r2)
                if (r2 == 0) goto L18
                java.lang.String r2 = r2.getSSID()
                boolean r0 = android.text.TextUtils.isEmpty(r2)
                if (r0 != 0) goto L18
                java.lang.String r0 = "<unknown ssid>"
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L1a
            L18:
                java.lang.String r2 = ""
            L1a:
                java.lang.String r0 = "getWifiSSID() --> "
                java.lang.String r1 = "BaseInfo.CoreInfo"
                com.jd.ad.sdk.jad_an.jad_an.jad_an(r2, r0, r1)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jd.android.sdk.coreinfo.CoreInfo.Device.getWifiSSID(android.content.Context):java.lang.String");
        }

        public static List<String> getWifiSSIDList(Context context) {
            ArrayList arrayList = new ArrayList();
            List<ScanResult> n10 = a.n(context);
            if (n10 != null && !n10.isEmpty()) {
                Iterator<ScanResult> it = n10.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().SSID);
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getWifiSSIDList() --> ".concat(String.valueOf(arrayList)));
            return arrayList;
        }

        public static List<ScanResult> getWifiScanResultList(Context context) {
            List<ScanResult> e10 = a.e(context);
            Logger.debugWithStackTrace(CoreInfo.TAG, "getWifiScanResultList() --> ".concat(String.valueOf(e10)));
            if (!Logger.printStack) {
                Logger.d(CoreInfo.TAG, Logger.getStackTrace());
            }
            return e10;
        }

        public static boolean isBluetoothAvailabel() {
            if (!a.D) {
                a.C = BluetoothAdapter.getDefaultAdapter() != null;
                a.D = true;
            }
            boolean z10 = a.C;
            Logger.debugWithStackTrace(CoreInfo.TAG, "isBluetoothAvailabel() --> ".concat(String.valueOf(z10)));
            return z10;
        }

        public static boolean isBluetoothEnabled() {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            boolean z10 = defaultAdapter != null && defaultAdapter.isEnabled();
            Logger.debugWithStackTrace(CoreInfo.TAG, "isBluetoothEnabled() --> ".concat(String.valueOf(z10)));
            return z10;
        }

        @TargetApi(23)
        public static boolean isFingerprintAvailable(Context context) {
            boolean z10;
            FingerprintManager a10;
            boolean isHardwareDetected;
            if (!a.f10722z) {
                z10 = false;
                if (context == null) {
                    Logger.w("Baseinfo.DeviceInfo", "context is null");
                } else if (Build.VERSION.SDK_INT >= 23 && (a10 = p7.b.a(context.getSystemService("fingerprint"))) != null) {
                    try {
                        isHardwareDetected = a10.isHardwareDetected();
                        a.f10721y = isHardwareDetected;
                        a.f10722z = true;
                    } catch (Throwable th2) {
                        Logger.e("Baseinfo.DeviceInfo", "An error occors when call isFingerprintAvailable()", th2);
                    }
                }
                Logger.debugWithStackTrace(CoreInfo.TAG, "isFingerprintAvailable() --> ".concat(String.valueOf(z10)));
                return z10;
            }
            z10 = a.f10721y;
            Logger.debugWithStackTrace(CoreInfo.TAG, "isFingerprintAvailable() --> ".concat(String.valueOf(z10)));
            return z10;
        }

        public static boolean isGPSAvailable(Context context) {
            boolean z10;
            if (!a.f10720x) {
                z10 = false;
                if (context == null) {
                    Logger.w("Baseinfo.DeviceInfo", "context is null");
                } else {
                    LocationManager locationManager = (LocationManager) context.getSystemService("location");
                    if (locationManager != null) {
                        List<String> allProviders = locationManager.getAllProviders();
                        if (allProviders != null && allProviders.contains("gps")) {
                            z10 = true;
                        }
                        a.f10719w = z10;
                        a.f10720x = true;
                    }
                }
                Logger.debugWithStackTrace(CoreInfo.TAG, "isGPSAvailable() --> ".concat(String.valueOf(z10)));
                return z10;
            }
            z10 = a.f10719w;
            Logger.debugWithStackTrace(CoreInfo.TAG, "isGPSAvailable() --> ".concat(String.valueOf(z10)));
            return z10;
        }

        public static boolean isNFCAvailable(Context context) {
            boolean m10 = a.m(context);
            Logger.debugWithStackTrace(CoreInfo.TAG, "isNFCAvailable() --> ".concat(String.valueOf(m10)));
            return m10;
        }

        public static boolean isNFCEnabled(Context context) {
            NfcAdapter defaultAdapter;
            boolean z10 = a.m(context) && (defaultAdapter = ((NfcManager) context.getSystemService("nfc")).getDefaultAdapter()) != null && defaultAdapter.isEnabled();
            Logger.debugWithStackTrace(CoreInfo.TAG, "isNFCEnabled() --> ".concat(String.valueOf(z10)));
            return z10;
        }

        public static boolean isQEmuDriverFile() {
            boolean c10 = a.c();
            Logger.debugWithStackTrace(CoreInfo.TAG, "isQEmuDriverFile() --> ".concat(String.valueOf(c10)));
            return c10;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
        
            if (r2.contains("test-keys") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        
            r0 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0029, code lost:
        
            if (r1 != false) goto L70;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static boolean isRoot() {
            /*
                r0 = 0
                java.lang.String[] r1 = com.jd.android.sdk.coreinfo.a.E     // Catch: java.lang.Throwable -> L1a
                int r2 = r1.length     // Catch: java.lang.Throwable -> L1a
                r3 = 0
            L5:
                r4 = 1
                if (r3 >= r2) goto L1c
                r5 = r1[r3]     // Catch: java.lang.Throwable -> L1a
                java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L1a
                r6.<init>(r5)     // Catch: java.lang.Throwable -> L1a
                boolean r5 = r6.exists()     // Catch: java.lang.Throwable -> L1a
                if (r5 == 0) goto L17
                r1 = 1
                goto L1d
            L17:
                int r3 = r3 + 1
                goto L5
            L1a:
                r1 = move-exception
                goto L2d
            L1c:
                r1 = 0
            L1d:
                java.lang.String r2 = android.os.Build.TAGS     // Catch: java.lang.Throwable -> L1a
                if (r2 == 0) goto L29
                java.lang.String r3 = "test-keys"
                boolean r2 = r2.contains(r3)     // Catch: java.lang.Throwable -> L1a
                if (r2 != 0) goto L2b
            L29:
                if (r1 == 0) goto L30
            L2b:
                r0 = 1
                goto L30
            L2d:
                r1.printStackTrace()
            L30:
                java.lang.String r1 = java.lang.String.valueOf(r0)
                java.lang.String r2 = "isRoot() --> "
                java.lang.String r1 = r2.concat(r1)
                java.lang.String r2 = "BaseInfo.CoreInfo"
                com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(r2, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jd.android.sdk.coreinfo.CoreInfo.Device.isRoot():boolean");
        }

        public static boolean isSensorAvailable(Context context, int i10) {
            List<Sensor> sensorList;
            boolean z10 = false;
            if (context == null) {
                Logger.w("Baseinfo.DeviceInfo", "context is null");
            } else {
                SensorManager sensorManager = (SensorManager) context.getSystemService(bt.f23586ac);
                if (sensorManager != null && (sensorList = sensorManager.getSensorList(i10)) != null && sensorList.size() > 0) {
                    z10 = true;
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "isSensorAvailable() --> ".concat(String.valueOf(z10)));
            return z10;
        }

        public static boolean isStorageRemovable(Context context) {
            List storageVolumes;
            boolean isRemovable;
            String state;
            boolean z10 = false;
            if (context == null) {
                Logger.w("Baseinfo.DeviceInfo", "context is null");
            } else {
                try {
                    if (Build.VERSION.SDK_INT >= 24) {
                        storageVolumes = ((StorageManager) context.getSystemService("storage")).getStorageVolumes();
                        if (storageVolumes != null) {
                            Iterator it = storageVolumes.iterator();
                            while (it.hasNext()) {
                                StorageVolume a10 = c.a(it.next());
                                isRemovable = a10.isRemovable();
                                if (isRemovable) {
                                    state = a10.getState();
                                    if (state.equals("mounted")) {
                                        z10 = true;
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        z10 = a.i(context);
                    }
                } catch (Exception e10) {
                    Logger.e("Baseinfo.DeviceInfo", "An exception happends when call storageIsRemovable()", e10);
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "isStorageRemovable() --> ".concat(String.valueOf(z10)));
            return z10;
        }

        public static void setUserAgent(String str) {
            if (!TextUtils.isEmpty(str)) {
                com.jd.ad.sdk.jad_dq.jad_dq.jad_an = str;
            }
            jad_an.jad_an(str, "setUserAgent() --> ", CoreInfo.TAG);
        }

        public static String getUserAgent(Context context, long j10) {
            String jad_an = com.jd.ad.sdk.jad_dq.jad_dq.jad_an(context, j10);
            jad_an.jad_an(jad_an, "getUserAgent() --> ", CoreInfo.TAG);
            return jad_an;
        }
    }

    public static class System {
        public static int getAndroidSDKVersion() {
            if (com.jd.ad.sdk.jad_an.jad_dq.jad_jt == 0) {
                com.jd.ad.sdk.jad_an.jad_dq.jad_jt = Build.VERSION.SDK_INT;
            }
            int i10 = com.jd.ad.sdk.jad_an.jad_dq.jad_jt;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getAndroidSDKVersion() --> ".concat(String.valueOf(i10)));
            return i10;
        }

        public static String getAndroidVersion() {
            if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_fs)) {
                com.jd.ad.sdk.jad_an.jad_dq.jad_fs = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.VERSION.RELEASE);
            }
            String str = com.jd.ad.sdk.jad_an.jad_dq.jad_fs;
            jad_an.jad_an(str, "getAndroidVersion() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getCountry(Context context) {
            Resources resources;
            Configuration configuration;
            Locale locale;
            LocaleList locales;
            int size;
            try {
                if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_iv) && context != null && (resources = context.getResources()) != null && (configuration = resources.getConfiguration()) != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        locales = configuration.getLocales();
                        if (locales != null) {
                            size = locales.size();
                            if (size > 0) {
                                locale = locales.get(0);
                            }
                        }
                    } else {
                        locale = configuration.locale;
                    }
                    com.jd.ad.sdk.jad_an.jad_dq.jad_iv = locale.getCountry();
                }
            } catch (Exception unused) {
            }
            String str = com.jd.ad.sdk.jad_an.jad_dq.jad_iv;
            jad_an.jad_an(str, "getCountry() --> ", CoreInfo.TAG);
            return str;
        }

        public static long getElapsedRealtime() {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Logger.debugWithStackTrace(CoreInfo.TAG, "getElapsedRealtime() --> ".concat(String.valueOf(elapsedRealtime)));
            return elapsedRealtime;
        }

        public static List<PackageInfo> getInstalledPkgs(Context context, int i10) {
            jad_er.jad_an();
            com.jd.ad.sdk.jad_an.jad_bo jad_boVar = CoreInfo.sensitiveApi;
            List<PackageInfo> jad_cp = jad_boVar != null ? jad_boVar.jad_cp(context, i10) : new ArrayList<>();
            Logger.debugWithStackTrace(CoreInfo.TAG, "getInstalledPkgs() --> ".concat(String.valueOf(jad_cp)));
            return jad_cp;
        }

        public static String getLanguage(Context context) {
            Resources resources;
            Configuration configuration;
            Locale locale;
            LocaleList locales;
            int size;
            try {
                if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_jw) && context != null && (resources = context.getResources()) != null && (configuration = resources.getConfiguration()) != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        locales = configuration.getLocales();
                        if (locales != null) {
                            size = locales.size();
                            if (size > 0) {
                                locale = locales.get(0);
                            }
                        }
                    } else {
                        locale = configuration.locale;
                    }
                    com.jd.ad.sdk.jad_an.jad_dq.jad_jw = locale.getLanguage();
                }
            } catch (Exception unused) {
            }
            String str = com.jd.ad.sdk.jad_an.jad_dq.jad_jw;
            jad_an.jad_an(str, "getLanguage() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getOSFingerprint() {
            if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_dq)) {
                com.jd.ad.sdk.jad_an.jad_dq.jad_dq = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.FINGERPRINT);
            }
            String str = com.jd.ad.sdk.jad_an.jad_dq.jad_dq;
            jad_an.jad_an(str, "getOSFingerprint() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getOSName() {
            if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_an)) {
                com.jd.ad.sdk.jad_an.jad_dq.jad_an = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.DISPLAY);
            }
            String str = com.jd.ad.sdk.jad_an.jad_dq.jad_an;
            jad_an.jad_an(str, "getOSName() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getOSVersionTags() {
            if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_cp)) {
                com.jd.ad.sdk.jad_an.jad_dq.jad_cp = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.TAGS);
            }
            String str = com.jd.ad.sdk.jad_an.jad_dq.jad_cp;
            jad_an.jad_an(str, "getOSVersionTags() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getOSVersionType() {
            if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_bo)) {
                com.jd.ad.sdk.jad_an.jad_dq.jad_bo = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.TYPE);
            }
            String str = com.jd.ad.sdk.jad_an.jad_dq.jad_bo;
            jad_an.jad_an(str, "getOSVersionType() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getRomName() {
            StringBuilder sb2;
            String str;
            String valueOf;
            String str2;
            StringBuilder sb3;
            StringBuilder sb4;
            String str3;
            if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_er)) {
                if (TextUtils.isEmpty(com.jd.ad.sdk.jad_dq.jad_cp.jad_bo)) {
                    String jad_an = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.miui.ui.version.name");
                    if (TextUtils.isEmpty(jad_an) || "".equals(jad_an)) {
                        String jad_an2 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.build.version.emui");
                        if (TextUtils.isEmpty(jad_an2) || "".equals(jad_an2)) {
                            String jad_an3 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.lenovo.series");
                            if (TextUtils.isEmpty(jad_an3) || "".equals(jad_an3)) {
                                String jad_an4 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.build.nubia.rom.name");
                                if (TextUtils.isEmpty(jad_an4) || "".equals(jad_an4)) {
                                    String jad_an5 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.meizu.product.model");
                                    if (TextUtils.isEmpty(jad_an5) || "".equals(jad_an5)) {
                                        String jad_an6 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.build.version.opporom");
                                        if (TextUtils.isEmpty(jad_an6) || "".equals(jad_an6)) {
                                            String jad_an7 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an(RomUtils.f8683v);
                                            if (TextUtils.isEmpty(jad_an7) || "".equals(jad_an7)) {
                                                String jad_an8 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.aa.romver");
                                                if (TextUtils.isEmpty(jad_an8) || "".equals(jad_an8)) {
                                                    String jad_an9 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.lewa.version");
                                                    if (TextUtils.isEmpty(jad_an9) || "".equals(jad_an9)) {
                                                        jad_an9 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.gn.gnromvernumber");
                                                        if (TextUtils.isEmpty(jad_an9) || "".equals(jad_an9)) {
                                                            String jad_an10 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.build.tyd.kbstyle_version");
                                                            if (TextUtils.isEmpty(jad_an10) || "".equals(jad_an10)) {
                                                                sb2 = new StringBuilder();
                                                                sb2.append(com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.build.fingerprint"));
                                                                sb2.append("/");
                                                                str = "ro.build.rom.moduleID";
                                                            } else {
                                                                valueOf = String.valueOf(jad_an10);
                                                                str2 = "dido/";
                                                            }
                                                        } else {
                                                            sb3 = new StringBuilder("amigo/");
                                                        }
                                                    } else {
                                                        sb3 = new StringBuilder("tcl/");
                                                    }
                                                    sb3.append(jad_an9);
                                                    sb3.append("/");
                                                    sb2 = sb3;
                                                } else {
                                                    sb4 = new StringBuilder("htc/");
                                                    sb4.append(jad_an8);
                                                    sb4.append("/");
                                                    str3 = "ro.build.description";
                                                }
                                            } else {
                                                valueOf = String.valueOf(jad_an7);
                                                str2 = "vivo/FUNTOUCH/";
                                            }
                                        } else {
                                            valueOf = String.valueOf(jad_an6);
                                            str2 = "Oppo/COLOROS/";
                                        }
                                    } else {
                                        sb2 = new StringBuilder("Meizu/FLYME/");
                                    }
                                    str = "ro.build.display.id";
                                } else {
                                    sb4 = new StringBuilder("Zte/NUBIA/");
                                    sb4.append(jad_an4);
                                    sb4.append(e.f26694a);
                                    str3 = "ro.build.nubia.rom.code";
                                }
                                StringBuilder sb5 = sb4;
                                str = str3;
                                sb2 = sb5;
                            } else {
                                sb2 = new StringBuilder("Lenovo/VIBE/");
                                str = RomUtils.f8684w;
                            }
                            sb2.append(com.jd.ad.sdk.jad_dq.jad_cp.jad_an(str));
                            com.jd.ad.sdk.jad_dq.jad_cp.jad_bo = sb2.toString();
                        } else {
                            valueOf = String.valueOf(jad_an2);
                            str2 = "HuaWei/EMOTION/";
                        }
                    } else {
                        valueOf = String.valueOf(jad_an);
                        str2 = "XiaoMi/MIUI/";
                    }
                    com.jd.ad.sdk.jad_dq.jad_cp.jad_bo = str2.concat(valueOf);
                }
                com.jd.ad.sdk.jad_an.jad_dq.jad_er = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(com.jd.ad.sdk.jad_dq.jad_cp.jad_bo);
            }
            String str4 = com.jd.ad.sdk.jad_an.jad_dq.jad_er;
            jad_an.jad_an(str4, "getRomName() --> ", CoreInfo.TAG);
            return str4;
        }

        public static String getTimeZoneID() {
            TimeZone timeZone;
            try {
                if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_hu) && (timeZone = TimeZone.getDefault()) != null) {
                    com.jd.ad.sdk.jad_an.jad_dq.jad_hu = timeZone.getID();
                }
            } catch (Throwable unused) {
            }
            String str = com.jd.ad.sdk.jad_an.jad_dq.jad_hu;
            jad_an.jad_an(str, "getTimeZoneID() --> ", CoreInfo.TAG);
            return str;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static boolean isPkgInstalled(android.content.Context r2, java.lang.String r3) {
            /*
                com.jd.ad.sdk.jad_lo.jad_er.jad_an()
                r0 = 0
                if (r2 == 0) goto L1f
                boolean r1 = android.text.TextUtils.isEmpty(r3)
                if (r1 == 0) goto Ld
                goto L1f
            Ld:
                android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch: java.lang.Throwable -> L16 android.content.pm.PackageManager.NameNotFoundException -> L1a
                android.content.pm.PackageInfo r2 = r2.getPackageInfo(r3, r0)     // Catch: java.lang.Throwable -> L16 android.content.pm.PackageManager.NameNotFoundException -> L1a
                goto L1b
            L16:
                r2 = move-exception
                r2.printStackTrace()
            L1a:
                r2 = 0
            L1b:
                if (r2 == 0) goto L26
                r0 = 1
                goto L26
            L1f:
                java.lang.String r2 = "PackageInfoUtil"
                java.lang.String r3 = "isPackageInstalled parameter error!"
                com.jd.android.sdk.coreinfo.util.Logger.e(r2, r3)
            L26:
                java.lang.String r2 = java.lang.String.valueOf(r0)
                java.lang.String r3 = "isPkgInstalled() --> "
                java.lang.String r2 = r3.concat(r2)
                java.lang.String r3 = "BaseInfo.CoreInfo"
                com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(r3, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jd.android.sdk.coreinfo.CoreInfo.System.isPkgInstalled(android.content.Context, java.lang.String):boolean");
        }
    }
}
