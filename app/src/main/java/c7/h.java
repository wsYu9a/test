package c7;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

@SuppressLint({"DefaultLocale"})
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a */
    public static final String f1747a = "0";

    /* renamed from: b */
    public static final int f1748b = 21;

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
                return "none";
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
        } catch (Exception e10) {
            e.c(e10);
            return "";
        }
    }

    public static String e() {
        return SystemProperties.get("ro.build.display.id", "");
    }

    public static boolean f(String str) {
        return TextUtils.isEmpty(str) || "null".equals(str);
    }
}
