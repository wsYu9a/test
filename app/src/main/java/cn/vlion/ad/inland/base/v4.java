package cn.vlion.ad.inland.base;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.system.Os;
import android.system.StructStat;
import android.system.StructTimespec;
import android.telephony.TelephonyManager;
import android.text.format.DateFormat;
import androidx.media3.common.C;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.bt;
import java.io.File;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;

/* loaded from: classes.dex */
public final class v4 {

    /* renamed from: a */
    public static int f3467a;

    /* renamed from: b */
    public static int f3468b;

    /* renamed from: c */
    public static long f3469c;

    public static String a(Context context, String str) {
        try {
            LogVlion.e("getAppCode appPackage=====" + str);
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return "";
            }
            int i10 = packageInfo.versionCode;
            LogVlion.e("getAppCode versionCode =====" + i10);
            return String.valueOf(i10);
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static int b(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            Object systemService = context.getSystemService(BatteryManager.class.getName());
            if (systemService == null) {
                return 0;
            }
            Method declaredMethod = systemService.getClass().getDeclaredMethod("getIntProperty", String.class);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(systemService, "battery_status");
            if (invoke != null) {
                return ((Integer) invoke).intValue();
            }
            return 0;
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static int c() {
        return Build.VERSION.SDK_INT;
    }

    public static String d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            boolean is24HourFormat = DateFormat.is24HourFormat(context);
            LogVlion.e("getTimezone is24HourFormat=" + is24HourFormat);
            return is24HourFormat ? "24" : Constants.VIA_REPORT_TYPE_SET_AVATAR;
        } catch (Throwable th2) {
            p.a(th2, "getTimezone Exception=", th2);
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0083, code lost:
    
        r4 = "";
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0089 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008a  */
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String e(android.content.Context r4) {
        /*
            java.lang.String r0 = ""
            if (r4 != 0) goto L5
            return r0
        L5:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L5b
            r2 = 29
            if (r1 < r2) goto Lc
            return r0
        Lc:
            boolean r2 = cn.vlion.ad.inland.base.a0.c(r4)     // Catch: java.lang.Throwable -> L5b
            if (r2 != 0) goto L13
            return r0
        L13:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5b
            r2.<init>()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r3 = "getIMEI="
            r2.append(r3)     // Catch: java.lang.Throwable -> L5b
            int r3 = cn.vlion.ad.inland.base.v4.f3467a     // Catch: java.lang.Throwable -> L5b
            r2.append(r3)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L5b
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r2)     // Catch: java.lang.Throwable -> L5b
            int r2 = cn.vlion.ad.inland.base.v4.f3467a     // Catch: java.lang.Throwable -> L5b
            r3 = 1
            if (r2 < r3) goto L2f
            return r0
        L2f:
            int r2 = r2 + r3
            cn.vlion.ad.inland.base.v4.f3467a = r2     // Catch: java.lang.Throwable -> L5b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5b
            r2.<init>()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r3 = "getIMEI +="
            r2.append(r3)     // Catch: java.lang.Throwable -> L5b
            int r3 = cn.vlion.ad.inland.base.v4.f3467a     // Catch: java.lang.Throwable -> L5b
            r2.append(r3)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L5b
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r2)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r2 = "phone"
            java.lang.Object r4 = r4.getSystemService(r2)     // Catch: java.lang.Throwable -> L5b
            android.telephony.TelephonyManager r4 = (android.telephony.TelephonyManager) r4     // Catch: java.lang.Throwable -> L5b
            if (r4 == 0) goto L82
            r2 = 26
            if (r1 < r2) goto L5d
            java.lang.String r4 = b1.e.a(r4)     // Catch: java.lang.Throwable -> L5b
            goto L83
        L5b:
            r4 = move-exception
            goto L62
        L5d:
            java.lang.String r4 = r4.getDeviceId()     // Catch: java.lang.Throwable -> L5b
            goto L83
        L62:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r1 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
            r1.upLoadCatchException(r4)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "获取IMEI异常"
            r1.append(r2)
            java.lang.String r4 = r4.getMessage()
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r4)
        L82:
            r4 = r0
        L83:
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 == 0) goto L8a
            return r0
        L8a:
            java.lang.String r0 = "获取IMEI="
            cn.vlion.ad.inland.base.y.a(r0, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.v4.e(android.content.Context):java.lang.String");
    }

    public static long f(Context context) {
        if (context == null) {
            return -1L;
        }
        try {
            File filesDir = context.getFilesDir();
            if (filesDir != null) {
                long totalSpace = filesDir.getTotalSpace();
                LogVlion.e("getInternalStorageMemory totalSpace=" + totalSpace);
                return totalSpace;
            }
        } catch (Throwable th2) {
            p.a(th2, "getInternalStorageMemory Exception=", th2);
        }
        return -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010e A[Catch: all -> 0x014a, TryCatch #4 {all -> 0x014a, blocks: (B:44:0x0108, B:46:0x010e, B:47:0x011a, B:49:0x0120, B:52:0x012c, B:54:0x0135, B:56:0x014c, B:58:0x0152, B:59:0x015a), top: B:43:0x0108, outer: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x018d A[Catch: all -> 0x01c2, TRY_LEAVE, TryCatch #0 {all -> 0x01c2, blocks: (B:65:0x0187, B:67:0x018d, B:70:0x019b, B:72:0x01a5), top: B:64:0x0187 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String g(android.content.Context r13) {
        /*
            Method dump skipped, instructions count: 501
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.v4.g(android.content.Context):java.lang.String");
    }

    public static long h(Context context) {
        if (context == null) {
            return -1L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                long j10 = memoryInfo.totalMem / C.MICROS_PER_SECOND;
                LogVlion.e("getMemory totalMem=" + j10);
                return j10;
            }
        } catch (Throwable th2) {
            p.a(th2, "getMemory Exception=", th2);
        }
        return -1L;
    }

    public static long i(Context context) {
        if (context == null) {
            return -1L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                long j10 = memoryInfo.totalMem;
                LogVlion.e("getMemory totalMem=" + j10);
                return j10;
            }
        } catch (Throwable th2) {
            p.a(th2, "getMemory Exception=", th2);
        }
        return -1L;
    }

    public static int j(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            float f10 = context.getResources().getDisplayMetrics().densityDpi;
            LogVlion.e("getPpi screenDensity=" + f10);
            return (int) f10;
        } catch (Throwable th2) {
            p.a(th2, "getPpi Exception=", th2);
            return -1;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static String k(Context context) {
        WifiInfo connectionInfo;
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return "";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                String str = "<unknown ssid>";
                if (Build.VERSION.SDK_INT >= 26) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                    if (connectivityManager != null && connectivityManager.getActiveNetworkInfo() != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                        str = activeNetworkInfo.getExtraInfo();
                        LogVlion.e("getSSID activeNetworkInfo.getExtraInfo()  " + activeNetworkInfo.getExtraInfo());
                    }
                } else {
                    str = connectionInfo.getSSID();
                }
                if (str == null) {
                    str = connectionInfo.getSSID();
                }
                LogVlion.e("getSSID ssid=" + str);
                LogVlion.e("getSSID winfo=" + connectionInfo.toString());
                return (str.length() > 2 && str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') ? str.substring(1, str.length() - 1) : str;
            }
        } catch (Throwable th2) {
            p.a(th2, "getSSID Exception=", th2);
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0039 A[Catch: all -> 0x0008, TryCatch #0 {all -> 0x0008, blocks: (B:4:0x0003, B:13:0x0039, B:15:0x0041, B:16:0x0047, B:23:0x001b, B:8:0x000a, B:20:0x0015), top: B:2:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0041 A[Catch: all -> 0x0008, TryCatch #0 {all -> 0x0008, blocks: (B:4:0x0003, B:13:0x0039, B:15:0x0041, B:16:0x0047, B:23:0x001b, B:8:0x000a, B:20:0x0015), top: B:2:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] l(android.content.Context r3) {
        /*
            r0 = 0
            if (r3 != 0) goto La
            int[] r3 = new int[]{r0, r0}     // Catch: java.lang.Throwable -> L8
            return r3
        L8:
            r3 = move-exception
            goto L4c
        La:
            java.lang.String r1 = "window"
            java.lang.Object r3 = r3.getSystemService(r1)     // Catch: java.lang.Throwable -> L1a
            android.view.WindowManager r3 = (android.view.WindowManager) r3     // Catch: java.lang.Throwable -> L1a
            if (r3 != 0) goto L15
            goto L36
        L15:
            android.view.Display r3 = r3.getDefaultDisplay()     // Catch: java.lang.Throwable -> L1a
            goto L37
        L1a:
            r3 = move-exception
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r1 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()     // Catch: java.lang.Throwable -> L8
            r1.upLoadCatchException(r3)     // Catch: java.lang.Throwable -> L8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8
            r1.<init>()     // Catch: java.lang.Throwable -> L8
            java.lang.String r2 = "getDisplayApiL +="
            r1.append(r2)     // Catch: java.lang.Throwable -> L8
            r1.append(r3)     // Catch: java.lang.Throwable -> L8
            java.lang.String r3 = r1.toString()     // Catch: java.lang.Throwable -> L8
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r3)     // Catch: java.lang.Throwable -> L8
        L36:
            r3 = 0
        L37:
            if (r3 == 0) goto L3e
            int r1 = r3.getWidth()     // Catch: java.lang.Throwable -> L8
            goto L3f
        L3e:
            r1 = 0
        L3f:
            if (r3 == 0) goto L46
            int r3 = r3.getHeight()     // Catch: java.lang.Throwable -> L8
            goto L47
        L46:
            r3 = 0
        L47:
            int[] r3 = new int[]{r1, r3}     // Catch: java.lang.Throwable -> L8
            return r3
        L4c:
            java.lang.String r1 = "getScreenSize +="
            cn.vlion.ad.inland.base.p.a(r3, r1, r3)
            int[] r3 = new int[]{r0, r0}
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.v4.l(android.content.Context):int[]");
    }

    public static long m(Context context) {
        if (context == null) {
            return -1L;
        }
        try {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                long totalSpace = externalFilesDir.getTotalSpace();
                LogVlion.e("getSdStorageMemory totalSpace=" + totalSpace);
                return totalSpace;
            }
        } catch (Throwable th2) {
            p.a(th2, "getSdStorageMemory Exception=", th2);
        }
        return -1L;
    }

    @SuppressLint({"MissingPermission"})
    public static String n(Context context) {
        String serial;
        String serial2;
        if (context == null) {
            return "";
        }
        try {
        } catch (Throwable th2) {
            StringBuilder a10 = l1.a("getSerialno  e===");
            a10.append(th2.getMessage());
            LogVlion.e(a10.toString());
        }
        if (Build.VERSION.SDK_INT >= 26) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getSerialno Build.getSerial()=");
            serial = Build.getSerial();
            sb2.append(serial);
            LogVlion.e(sb2.toString());
            serial2 = Build.getSerial();
            return serial2;
        }
        String simSerialNumber = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
        if (simSerialNumber != null && !simSerialNumber.isEmpty()) {
            LogVlion.e("getSerialno  telephonyManager=serialNumber==" + simSerialNumber);
            return simSerialNumber;
        }
        return "";
    }

    public static String o(Context context) {
        try {
            return Build.VERSION.SDK_INT >= 29 ? Settings.Secure.getString(context.getContentResolver(), "android_id") : "";
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static boolean p(Context context) {
        return context != null && (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        StringBuilder a10 = l1.a("getAndroidID=");
        a10.append(f3468b);
        LogVlion.e(a10.toString());
        int i10 = f3468b;
        if (i10 >= 1) {
            return "";
        }
        f3468b = i10 + 1;
        StringBuilder a11 = l1.a("getAndroidID +=");
        a11.append(f3468b);
        LogVlion.e(a11.toString());
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return string == null ? "" : string;
    }

    public static String b() {
        String str = "unknown";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                for (InetAddress inetAddress : Collections.list(networkInterfaces.nextElement().getInetAddresses())) {
                    if (inetAddress instanceof Inet4Address) {
                        if (inetAddress.getHostAddress() != null && !inetAddress.getHostAddress().equals(com.sigmob.sdk.videocache.h.f20606j)) {
                            str = inetAddress.getHostAddress();
                        }
                        LogVlion.e("getIPv4Address ip=" + inetAddress.getHostAddress());
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return str;
    }

    public static String c(Context context) {
        try {
            return Settings.Global.getString(context.getContentResolver(), bt.J);
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String d() {
        StructTimespec structTimespec;
        long j10;
        long j11;
        try {
            StructStat stat = Os.stat("/data/data");
            if (Build.VERSION.SDK_INT < 27) {
                return stat.st_atime + ".0";
            }
            structTimespec = stat.st_atim;
            StringBuilder sb2 = new StringBuilder();
            j10 = structTimespec.tv_sec;
            sb2.append(j10);
            sb2.append(p1.b.f29697h);
            j11 = structTimespec.tv_nsec;
            sb2.append(j11);
            return sb2.toString();
        } catch (Throwable th2) {
            p.a(th2, "getUpdateMark +=", th2);
            return "";
        }
    }

    public static long a() {
        try {
            return new StatFs(Environment.getDataDirectory().getPath()).getAvailableBytes();
        } catch (Throwable th2) {
            p.a(th2, "getDisplayApiL +=", th2);
            return 0L;
        }
    }
}
