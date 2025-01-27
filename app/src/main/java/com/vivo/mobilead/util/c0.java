package com.vivo.mobilead.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* loaded from: classes4.dex */
public class c0 {
    public static int a(Context context) {
        ConnectivityManager connectivityManager;
        int i2;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            i2 = 0;
        } catch (Exception e2) {
            VOpenLog.w("NetUtils", "" + e2.getMessage());
        }
        if (connectivityManager == null) {
            return 0;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                return 100;
            }
            if (activeNetworkInfo.getType() == 9) {
                return 101;
            }
            if (activeNetworkInfo.getType() == 7) {
                return 102;
            }
            if (activeNetworkInfo.getType() == 0) {
                i2 = 3;
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 3;
                    case 13:
                        return 4;
                    default:
                        if (!activeNetworkInfo.getSubtypeName().equalsIgnoreCase("TD-SCDMA") && !activeNetworkInfo.getSubtypeName().equalsIgnoreCase("WCDMA")) {
                            if (!activeNetworkInfo.getSubtypeName().equalsIgnoreCase("CDMA2000")) {
                                return 1;
                            }
                        }
                        break;
                }
            }
            return 1;
        }
        return i2;
    }

    public static boolean b(Context context) {
        return h0.K().l() == 0;
    }

    public static boolean c(Context context) {
        return h0.K().l() != 0;
    }
}
