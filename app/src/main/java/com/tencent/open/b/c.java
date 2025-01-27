package com.tencent.open.b;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.util.Locale;
import kotlin.text.Typography;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    static String f23179a;

    /* renamed from: b */
    static String f23180b;

    /* renamed from: c */
    static String f23181c;

    /* renamed from: d */
    private static String f23182d;

    /* renamed from: e */
    private static String f23183e;

    public static String a() {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        try {
            Context a10 = com.tencent.open.utils.d.a();
            return (a10 == null || (wifiManager = (WifiManager) a10.getSystemService("wifi")) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? "" : connectionInfo.getMacAddress();
        } catch (SecurityException e10) {
            com.tencent.open.a.f.b("openSDK_LOG.MobileInfoUtil", "getLocalMacAddress>>>", e10);
            return "";
        }
    }

    public static String b() {
        return Locale.getDefault().getLanguage();
    }

    public static String c(Context context) {
        String str = f23180b;
        if (str != null && str.length() > 0) {
            return f23180b;
        }
        if (context == null) {
            return "";
        }
        try {
            String simSerialNumber = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
            f23180b = simSerialNumber;
            return simSerialNumber;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(Context context) {
        String str = f23181c;
        if (str != null && str.length() > 0) {
            return f23181c;
        }
        if (context == null) {
            return "";
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            f23181c = string;
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e(Context context) {
        try {
            if (f23183e == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("imei=");
                sb2.append(b(context));
                sb2.append(Typography.amp);
                sb2.append("model=");
                sb2.append(Build.MODEL);
                sb2.append(Typography.amp);
                sb2.append("os=");
                sb2.append(Build.VERSION.RELEASE);
                sb2.append(Typography.amp);
                sb2.append("apilevel=");
                sb2.append(Build.VERSION.SDK_INT);
                sb2.append(Typography.amp);
                String b10 = a.b(context);
                if (b10 == null) {
                    b10 = "";
                }
                sb2.append("network=");
                sb2.append(b10);
                sb2.append(Typography.amp);
                sb2.append("sdcard=");
                sb2.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                sb2.append(Typography.amp);
                sb2.append("display=");
                sb2.append(displayMetrics.widthPixels);
                sb2.append('*');
                sb2.append(displayMetrics.heightPixels);
                sb2.append(Typography.amp);
                sb2.append("manu=");
                sb2.append(Build.MANUFACTURER);
                sb2.append("&");
                sb2.append("wifi=");
                sb2.append(a.e(context));
                f23183e = sb2.toString();
            }
            return f23183e;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(Context context) {
        String str = f23179a;
        if (str != null && str.length() > 0) {
            return f23179a;
        }
        if (context == null) {
            return "";
        }
        try {
            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            f23179a = deviceId;
            return deviceId;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f23182d)) {
            return f23182d;
        }
        if (context == null) {
            return "";
        }
        f23182d = "";
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            f23182d = windowManager.getDefaultDisplay().getWidth() + "x" + windowManager.getDefaultDisplay().getHeight();
        }
        return f23182d;
    }
}
