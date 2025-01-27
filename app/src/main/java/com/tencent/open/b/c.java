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
    static String f25446a;

    /* renamed from: b */
    static String f25447b;

    /* renamed from: c */
    static String f25448c;

    /* renamed from: d */
    private static String f25449d;

    /* renamed from: e */
    private static String f25450e;

    public static String a() {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        try {
            Context a2 = com.tencent.open.utils.d.a();
            return (a2 == null || (wifiManager = (WifiManager) a2.getSystemService(com.alipay.mobilesecuritysdk.constant.a.I)) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? "" : connectionInfo.getMacAddress();
        } catch (SecurityException e2) {
            com.tencent.open.a.f.b("openSDK_LOG.MobileInfoUtil", "getLocalMacAddress>>>", e2);
            return "";
        }
    }

    public static String b() {
        return Locale.getDefault().getLanguage();
    }

    public static String c(Context context) {
        String str = f25447b;
        if (str != null && str.length() > 0) {
            return f25447b;
        }
        if (context == null) {
            return "";
        }
        try {
            String simSerialNumber = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
            f25447b = simSerialNumber;
            return simSerialNumber;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(Context context) {
        String str = f25448c;
        if (str != null && str.length() > 0) {
            return f25448c;
        }
        if (context == null) {
            return "";
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            f25448c = string;
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e(Context context) {
        try {
            if (f25450e == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                StringBuilder sb = new StringBuilder();
                sb.append("imei=");
                sb.append(b(context));
                sb.append(Typography.amp);
                sb.append("model=");
                sb.append(Build.MODEL);
                sb.append(Typography.amp);
                sb.append("os=");
                sb.append(Build.VERSION.RELEASE);
                sb.append(Typography.amp);
                sb.append("apilevel=");
                sb.append(Build.VERSION.SDK_INT);
                sb.append(Typography.amp);
                String b2 = a.b(context);
                if (b2 == null) {
                    b2 = "";
                }
                sb.append("network=");
                sb.append(b2);
                sb.append(Typography.amp);
                sb.append("sdcard=");
                sb.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                sb.append(Typography.amp);
                sb.append("display=");
                sb.append(displayMetrics.widthPixels);
                sb.append('*');
                sb.append(displayMetrics.heightPixels);
                sb.append(Typography.amp);
                sb.append("manu=");
                sb.append(Build.MANUFACTURER);
                sb.append("&");
                sb.append("wifi=");
                sb.append(a.e(context));
                f25450e = sb.toString();
            }
            return f25450e;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(Context context) {
        String str = f25446a;
        if (str != null && str.length() > 0) {
            return f25446a;
        }
        if (context == null) {
            return "";
        }
        try {
            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            f25446a = deviceId;
            return deviceId;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f25449d)) {
            return f25449d;
        }
        if (context == null) {
            return "";
        }
        f25449d = "";
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            f25449d = windowManager.getDefaultDisplay().getWidth() + "x" + windowManager.getDefaultDisplay().getHeight();
        }
        return f25449d;
    }
}
