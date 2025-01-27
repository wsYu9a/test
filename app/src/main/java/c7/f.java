package c7;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

@SuppressLint({"DefaultLocale"})
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a */
    public static final int f1719a = 0;

    /* renamed from: b */
    public static final int f1720b = 1;

    /* renamed from: c */
    public static final int f1721c = 2;

    /* renamed from: d */
    public static final int f1722d = 3;

    /* renamed from: e */
    public static final int f1723e = 4;

    /* renamed from: f */
    public static final int f1724f = 5;

    /* renamed from: g */
    public static final int f1725g = 6;

    /* renamed from: h */
    public static final int f1726h = 7;

    /* renamed from: i */
    public static final int f1727i = 8;

    /* renamed from: j */
    public static final int f1728j = 9;

    /* renamed from: k */
    public static final int f1729k = 10;

    /* renamed from: l */
    public static final int f1730l = 11;

    /* renamed from: m */
    public static final int f1731m = 12;

    /* renamed from: n */
    public static final int f1732n = 13;

    /* renamed from: o */
    public static final int f1733o = 14;

    /* renamed from: p */
    public static final int f1734p = 15;

    /* renamed from: q */
    public static final int f1735q = -1;

    /* renamed from: r */
    public static final int f1736r = -101;

    /* renamed from: s */
    public static final int f1737s = -101;

    /* renamed from: t */
    public static final int f1738t = -1;

    /* renamed from: u */
    public static final int f1739u = 0;

    /* renamed from: v */
    public static final int f1740v = 1;

    /* renamed from: w */
    public static final int f1741w = 2;

    /* renamed from: x */
    public static final int f1742x = 3;

    @SuppressLint({"DefaultLocale"})
    public static String a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo == null) {
                return "0";
            }
            String upperCase = activeNetworkInfo.getTypeName().toUpperCase();
            if (!upperCase.equals("MOBILE")) {
                return upperCase;
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            return !TextUtils.isEmpty(extraInfo) ? extraInfo.toUpperCase() : upperCase;
        } catch (Exception e10) {
            e.c(e10);
            return "0";
        }
    }

    public static int b(int i10) {
        int i11 = -101;
        if (i10 != -101) {
            i11 = -1;
            if (i10 != -1) {
                switch (i10) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 1;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 2;
                    case 13:
                        return 3;
                    default:
                        return 0;
                }
            }
        }
        return i11;
    }

    public static String c(Context context) {
        TelephonyManager telephonyManager;
        int i10 = 0;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    i10 = -101;
                } else if (type == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    i10 = telephonyManager.getNetworkType();
                }
            } else {
                i10 = -1;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        int b10 = b(i10);
        return b10 != -101 ? (b10 == -1 || b10 == 0) ? "UNKNOWN" : b10 != 1 ? b10 != 2 ? b10 != 3 ? "UNKNOWN" : "4G" : "3G" : "2G" : "WIFI";
    }

    public static boolean d(Context context) {
        try {
            String a10 = a(context);
            if (!a10.equals("UNINET") && !a10.equals("UNIWAP") && !a10.equals("CMNET") && !a10.equals("CMWAP") && !a10.equals("CTNET")) {
                if (!a10.equals("CTWAP")) {
                    return false;
                }
            }
            return true;
        } catch (Exception e10) {
            e.c(e10);
            return false;
        }
    }

    public static boolean e(Context context) {
        try {
            String a10 = a(context);
            if (!a10.equals("3GNET")) {
                if (!a10.equals("3GWAP")) {
                    return false;
                }
            }
            return true;
        } catch (Exception e10) {
            e.c(e10);
            return false;
        }
    }

    public static boolean f(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception e10) {
            e.c(e10);
            return false;
        }
    }

    public static boolean g(Context context) {
        String a10 = a(context);
        return a10.equals("CMWAP") || a10.equals("3GWAP") || a10.equals("UNIWAP");
    }

    public static boolean h(Context context) {
        try {
            return a(context).equals("WIFI");
        } catch (Exception e10) {
            e.c(e10);
            return false;
        }
    }
}
