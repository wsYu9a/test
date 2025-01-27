package com.heytap.mcssdk.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class h {

    /* renamed from: a */
    private static final String f8959a = "0";

    /* renamed from: b */
    private static final int f8960b = 21;

    public static String a() {
        return Build.VERSION.RELEASE;
    }

    public static String b(Context context) {
        String lowerCase = d(context).toLowerCase();
        lowerCase.hashCode();
        switch (lowerCase) {
            case "china net":
            case "中国电信":
            case "chinanet":
                return "China Net";
            case "chinamobile":
            case "china mobile":
            case "中国移动":
                return "China Mobile";
            case "chinaunicom":
            case "中国联通":
            case "china unicom":
                return "China Unicom";
            default:
                return com.baidu.mobads.sdk.internal.a.f5472a;
        }
    }

    public static String c() {
        String str = Build.MODEL;
        if (!f(str)) {
            return str.toUpperCase();
        }
        e.A("No MODEL.");
        return "0";
    }

    public static String d(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? telephonyManager.getNetworkOperatorName() : "";
        } catch (Exception e2) {
            e.c(e2);
            return "";
        }
    }

    public static String e() {
        return SystemProperties.get("ro.build.display.id", "");
    }

    private static boolean f(String str) {
        return TextUtils.isEmpty(str) || "null".equals(str);
    }
}
