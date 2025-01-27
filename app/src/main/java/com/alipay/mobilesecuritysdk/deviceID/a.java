package com.alipay.mobilesecuritysdk.deviceID;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f5226a = new a();

    private a() {
    }

    public static a h() {
        return f5226a;
    }

    public String a() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls.newInstance(), "gsm.version.baseband", "no message");
        } catch (Exception unused) {
            return null;
        }
    }

    public String b() {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            return (defaultAdapter == null || defaultAdapter.isEnabled()) ? defaultAdapter.getAddress() : "";
        } catch (Exception unused) {
            return null;
        }
    }

    public String c() {
        String[] strArr = {"", ""};
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"), 8192);
            String[] split = bufferedReader.readLine().split("\\s+");
            for (int i2 = 2; i2 < split.length; i2++) {
                strArr[0] = String.valueOf(strArr[0]) + split[i2] + " ";
            }
            strArr[1] = String.valueOf(strArr[1]) + bufferedReader.readLine().split("\\s+")[2];
            bufferedReader.close();
            return strArr[1];
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String d() {
        /*
            r6 = this;
            java.lang.String r0 = ""
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.io.FileNotFoundException -> L39
            java.lang.String r2 = "/proc/cpuinfo"
            r1.<init>(r2)     // Catch: java.io.FileNotFoundException -> L39
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.io.IOException -> L1d
            r3 = 1024(0x400, float:1.435E-42)
            r2.<init>(r1, r3)     // Catch: java.io.IOException -> L1d
            java.lang.String r3 = r2.readLine()     // Catch: java.io.IOException -> L1d
            r2.close()     // Catch: java.io.IOException -> L1b
            r1.close()     // Catch: java.io.IOException -> L1b
            goto L3a
        L1b:
            r1 = move-exception
            goto L1f
        L1d:
            r1 = move-exception
            r3 = r0
        L1f:
            java.lang.String r2 = "deviceid"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.io.FileNotFoundException -> L37
            java.lang.String r5 = "getCpuNum"
            r4.<init>(r5)     // Catch: java.io.FileNotFoundException -> L37
            java.lang.String r1 = r1.getLocalizedMessage()     // Catch: java.io.FileNotFoundException -> L37
            r4.append(r1)     // Catch: java.io.FileNotFoundException -> L37
            java.lang.String r1 = r4.toString()     // Catch: java.io.FileNotFoundException -> L37
            android.util.Log.i(r2, r1)     // Catch: java.io.FileNotFoundException -> L37
            goto L3a
        L37:
            goto L3a
        L39:
            r3 = r0
        L3a:
            if (r3 == 0) goto L4c
            r0 = 58
            int r0 = r3.indexOf(r0)
            int r0 = r0 + 1
            java.lang.String r0 = r3.substring(r0)
            java.lang.String r0 = r0.trim()
        L4c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobilesecuritysdk.deviceID.a.d():java.lang.String");
    }

    public String e(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return String.valueOf(Integer.toString(displayMetrics.widthPixels)) + "*" + Integer.toString(displayMetrics.heightPixels);
        } catch (Exception unused) {
            return null;
        }
    }

    public String f(Context context) {
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    return telephonyManager.getDeviceId();
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public String g(Context context) {
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    return telephonyManager.getSubscriberId();
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public String i(Context context) {
        return ((WifiManager) context.getSystemService(com.alipay.mobilesecuritysdk.constant.a.I)).getConnectionInfo().getMacAddress();
    }

    public String j(Context context) {
        return Integer.toString(((TelephonyManager) context.getSystemService("phone")).getNetworkType());
    }

    public String k() {
        return Build.VERSION.RELEASE;
    }

    public String l(Context context) {
        return context.getPackageName();
    }

    public String m() {
        return Build.MODEL;
    }

    public String n(Context context) {
        return context.getResources().getDisplayMetrics().toString();
    }

    public String o() {
        return Build.DISPLAY;
    }

    public long p() {
        long[] jArr = new long[2];
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                long blockSize = statFs.getBlockSize();
                long blockCount = statFs.getBlockCount();
                long availableBlocks = statFs.getAvailableBlocks();
                jArr[0] = blockCount * blockSize;
                jArr[1] = blockSize * availableBlocks;
            }
        } catch (Exception unused) {
        }
        return jArr[0];
    }

    public String q() {
        int i2;
        try {
            try {
                i2 = Build.VERSION.class.getField("SDK_INT").getInt(null);
            } catch (Exception unused) {
                i2 = 2;
            }
        } catch (Exception unused2) {
            i2 = Integer.parseInt((String) Build.VERSION.class.getField("SDK").get(null));
        }
        return Integer.toString(i2);
    }

    public long r() {
        long j2 = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            j2 = Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue();
            bufferedReader.close();
            return j2;
        } catch (IOException e2) {
            Log.i(c.f5228b, "getTotalMemory" + e2.getLocalizedMessage());
            return j2;
        }
    }
}
