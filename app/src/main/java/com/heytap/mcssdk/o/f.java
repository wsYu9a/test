package com.heytap.mcssdk.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class f {

    /* renamed from: a */
    public static final int f8945a = 0;

    /* renamed from: b */
    public static final int f8946b = 1;

    /* renamed from: c */
    public static final int f8947c = 2;

    /* renamed from: d */
    public static final int f8948d = 3;

    /* renamed from: e */
    public static final int f8949e = 4;

    /* renamed from: f */
    public static final int f8950f = 5;

    /* renamed from: g */
    public static final int f8951g = 6;

    /* renamed from: h */
    public static final int f8952h = 7;

    /* renamed from: i */
    public static final int f8953i = 8;

    /* renamed from: j */
    public static final int f8954j = 9;
    public static final int k = 10;
    public static final int l = 11;
    public static final int m = 12;
    public static final int n = 13;
    public static final int o = 14;
    public static final int p = 15;
    private static final int q = -1;
    private static final int r = -101;
    private static final int s = -101;
    private static final int t = -1;
    private static final int u = 0;
    private static final int v = 1;
    private static final int w = 2;
    private static final int x = 3;

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
        } catch (Exception e2) {
            e.c(e2);
            return "0";
        }
    }

    private static int b(int i2) {
        int i3 = -101;
        if (i2 != -101) {
            i3 = -1;
            if (i2 != -1) {
                switch (i2) {
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
        return i3;
    }

    public static String c(Context context) {
        TelephonyManager telephonyManager;
        int i2 = 0;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    i2 = -101;
                } else if (type == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    i2 = telephonyManager.getNetworkType();
                }
            } else {
                i2 = -1;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int b2 = b(i2);
        return b2 != -101 ? (b2 == -1 || b2 == 0) ? "UNKNOWN" : b2 != 1 ? b2 != 2 ? b2 != 3 ? "UNKNOWN" : "4G" : "3G" : "2G" : "WIFI";
    }

    public static boolean d(Context context) {
        try {
            String a2 = a(context);
            if (!a2.equals("UNINET") && !a2.equals("UNIWAP") && !a2.equals("CMNET") && !a2.equals("CMWAP") && !a2.equals("CTNET")) {
                if (!a2.equals("CTWAP")) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            e.c(e2);
            return false;
        }
    }

    public static boolean e(Context context) {
        try {
            String a2 = a(context);
            if (!a2.equals("3GNET")) {
                if (!a2.equals("3GWAP")) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            e.c(e2);
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
        } catch (Exception e2) {
            e.c(e2);
            return false;
        }
    }

    public static boolean g(Context context) {
        String a2 = a(context);
        return a2.equals("CMWAP") || a2.equals("3GWAP") || a2.equals("UNIWAP");
    }

    public static boolean h(Context context) {
        try {
            return a(context).equals("WIFI");
        } catch (Exception e2) {
            e.c(e2);
            return false;
        }
    }
}
