package com.jd.android.sdk.coreinfo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.jd.ad.sdk.jad_an.jad_bo;
import com.jd.ad.sdk.jad_lo.jad_dq;
import com.jd.ad.sdk.jad_lo.jad_fs;
import com.jd.android.sdk.coreinfo.CoreInfo;
import com.jd.android.sdk.coreinfo.util.Logger;
import com.kuaishou.weapon.p0.g;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class a {
    public static boolean A = false;
    public static boolean B = false;
    public static boolean C = false;
    public static boolean D = false;
    public static final String[] E = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    /* renamed from: a */
    public static String f10697a = "";

    /* renamed from: b */
    public static String f10698b = "";

    /* renamed from: c */
    public static String f10699c = "";

    /* renamed from: d */
    public static String f10700d = "";

    /* renamed from: e */
    public static String f10701e = "";

    /* renamed from: f */
    public static String f10702f = "";

    /* renamed from: g */
    public static String f10703g = "";

    /* renamed from: h */
    public static String f10704h = "";

    /* renamed from: i */
    public static String[] f10705i = null;

    /* renamed from: j */
    public static String f10706j = "";

    /* renamed from: k */
    public static String f10707k = "";

    /* renamed from: l */
    public static String f10708l = "";

    /* renamed from: m */
    public static String f10709m = "";

    /* renamed from: n */
    public static String f10710n = "";

    /* renamed from: o */
    public static String f10711o = "";

    /* renamed from: p */
    public static String f10712p = "";

    /* renamed from: q */
    public static String f10713q = "";

    /* renamed from: r */
    public static String f10714r = "";

    /* renamed from: s */
    public static String f10715s = "";

    /* renamed from: t */
    public static long f10716t = 0;

    /* renamed from: u */
    public static long f10717u = 0;

    /* renamed from: v */
    public static long f10718v = 0;

    /* renamed from: w */
    public static boolean f10719w = false;

    /* renamed from: x */
    public static boolean f10720x = false;

    /* renamed from: y */
    public static boolean f10721y = false;

    /* renamed from: z */
    public static boolean f10722z = false;

    public static long a(String str) {
        StatFs statFs = new StatFs(str);
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    public static WifiInfo b(Context context) {
        String str;
        if (context == null) {
            str = "getWifiConnectionInfo context is null";
        } else {
            if (jad_fs.jad_an(context, g.f11106g)) {
                try {
                    WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                    if (wifiManager != null) {
                        return wifiManager.getConnectionInfo();
                    }
                } catch (Exception e10) {
                    Logger.e("Baseinfo.DeviceInfo", "", e10);
                }
                return null;
            }
            str = "ACCESS_FINE_LOCATION permission is not granted, give up get wifi info.";
        }
        Logger.e("Baseinfo.DeviceInfo", str);
        return null;
    }

    public static boolean c() {
        File file = new File("/proc/tty/drivers");
        if (!file.exists() || !file.canRead()) {
            return false;
        }
        byte[] bArr = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bArr);
            fileInputStream.close();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return new String(bArr).indexOf("goldfish") != -1;
    }

    public static long d(String str) {
        int indexOf;
        String trim;
        int lastIndexOf;
        long j10;
        if (str == null || (indexOf = str.indexOf(58)) == -1 || (lastIndexOf = (trim = str.substring(indexOf + 1).trim()).lastIndexOf(32)) == -1) {
            return -1L;
        }
        String substring = trim.substring(lastIndexOf + 1);
        try {
            long parseLong = Long.parseLong(trim.substring(0, lastIndexOf).trim());
            if ("kb".equalsIgnoreCase(substring)) {
                j10 = 1024;
            } else if ("mb".equalsIgnoreCase(substring)) {
                j10 = 1048576;
            } else {
                if (!"gb".equalsIgnoreCase(substring)) {
                    return parseLong;
                }
                j10 = DownloadConstants.GB;
            }
            return parseLong * j10;
        } catch (Exception unused) {
            return -1L;
        }
    }

    public static List<ScanResult> e(Context context) {
        String str;
        if (context == null) {
            str = "getWifiScanResultList context is null";
        } else {
            if (jad_fs.jad_an(context, g.f11106g)) {
                try {
                    WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                    if (wifiManager != null) {
                        return wifiManager.getScanResults();
                    }
                } catch (Exception e10) {
                    Logger.e("Baseinfo.DeviceInfo", "", e10);
                }
                return null;
            }
            str = "ACCESS_FINE_LOCATION permission is not granted, give up scan wifi list.";
        }
        Logger.e("Baseinfo.DeviceInfo", str);
        return null;
    }

    public static boolean f() {
        try {
            String[] strArr = {"/dev/socket/qemud", "/dev/qemu_pipe"};
            boolean z10 = false;
            for (int i10 = 0; i10 < 2; i10++) {
                if (new File(strArr[i10]).exists()) {
                    z10 = true;
                }
            }
            return z10;
        } catch (Exception unused) {
            return false;
        }
    }

    public static ArrayList<NetworkInterface> g() {
        jad_dq<ArrayList<NetworkInterface>> jad_dqVar = CoreInfo.Device.networkInterfacesSupplier;
        return jad_dqVar != null ? jad_dqVar.jad_an() : Collections.list(NetworkInterface.getNetworkInterfaces());
    }

    public static List<String> h(Context context) {
        ArrayList arrayList = new ArrayList();
        List<ScanResult> n10 = n(context);
        if (n10 != null && !n10.isEmpty()) {
            Iterator<ScanResult> it = n10.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().BSSID);
            }
        }
        return arrayList;
    }

    public static boolean i(Context context) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Method method = StorageManager.class.getMethod("getVolumeList", null);
            method.setAccessible(true);
            Object[] objArr = (Object[]) method.invoke(storageManager, null);
            if (objArr == null) {
                return false;
            }
            for (Object obj : objArr) {
                if (((Boolean) obj.getClass().getMethod("isRemovable", null).invoke(obj, null)).booleanValue() && ((String) obj.getClass().getMethod("getState", null).invoke(obj, null)).equals("mounted")) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            Logger.e("Baseinfo.DeviceInfo", "An exception happends when call storageIsRemovable()", e10);
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    @Deprecated
    public static String j(Context context) {
        try {
            if (((TelephonyManager) context.getSystemService("phone")) == null) {
                return "";
            }
            jad_bo jad_boVar = CoreInfo.sensitiveApi;
            int jad_an = jad_boVar != null ? jad_boVar.jad_an(context) : 0;
            if (jad_an == 20) {
                return "5g";
            }
            switch (jad_an) {
            }
            return "mobile";
        } catch (Throwable th2) {
            Logger.e("Baseinfo.DeviceInfo", "An exception happends when call getMobileDataType()", th2);
            return "mobile";
        }
    }

    public static WifiInfo k(Context context) {
        jad_dq<WifiInfo> jad_dqVar = CoreInfo.Device.wifiInfoSupplier;
        return jad_dqVar != null ? jad_dqVar.jad_an() : b(context);
    }

    public static DisplayMetrics l(Context context) {
        if (context == null) {
            Logger.w("Baseinfo.DeviceInfo", "context is null");
            return null;
        }
        try {
            return context.getResources().getDisplayMetrics();
        } catch (Exception e10) {
            Logger.e("Baseinfo.DeviceInfo", "An exception happends when call getDisplayMetricsObject()", e10);
            return null;
        }
    }

    public static boolean m(Context context) {
        if (!B) {
            if (context == null) {
                Logger.w("Baseinfo.DeviceInfo", "context is null");
                return false;
            }
            A = context.getPackageManager().hasSystemFeature("android.hardware.nfc");
            B = true;
        }
        return A;
    }

    public static List<ScanResult> n(Context context) {
        jad_dq<List<ScanResult>> jad_dqVar = CoreInfo.Device.wifiListSupplier;
        return jad_dqVar != null ? jad_dqVar.jad_an() : e(context);
    }

    @SuppressLint({"MissingPermission"})
    public static String o(Context context) {
        if (context == null) {
            Logger.w("Baseinfo.DeviceInfo", "context is null");
            return "";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "";
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getType() == 0) {
                    return CoreInfo.sensitiveApi != null ? j(context) : "mobile";
                }
                try {
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                    if (networkInfo != null && networkInfo.getState() != null) {
                        NetworkInfo.State state = networkInfo.getState();
                        if (state == NetworkInfo.State.CONNECTED) {
                            return "wifi";
                        }
                        if (state == NetworkInfo.State.CONNECTING) {
                            return "wifi";
                        }
                    }
                } catch (Throwable th2) {
                    Logger.e("Baseinfo.DeviceInfo", "An exception happends when call getNetworkType()", th2);
                }
                try {
                    NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(9);
                    if (networkInfo2 != null && networkInfo2.getState() != null) {
                        NetworkInfo.State state2 = networkInfo2.getState();
                        if (state2 == NetworkInfo.State.CONNECTED) {
                            return "enterNet";
                        }
                        if (state2 == NetworkInfo.State.CONNECTING) {
                            return "enterNet";
                        }
                    }
                } catch (Throwable th3) {
                    Logger.e("Baseinfo.DeviceInfo", "An exception happends when call getNetworkType()", th3);
                }
                return "";
            }
            return "none";
        } catch (Throwable th4) {
            Logger.e("Baseinfo.DeviceInfo", "An exception happends when call getNetworkType()", th4);
            return "";
        }
    }
}
