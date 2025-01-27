package com.kwai.library.ipneigh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
final class b {
    private static final Pattern aZg = Pattern.compile("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$");

    @SuppressLint({"DefaultLocale"})
    public static String ez(int i10) {
        return String.format("%d.%d.%d.%d", Integer.valueOf(i10 & 255), Integer.valueOf((i10 >> 8) & 255), Integer.valueOf((i10 >> 16) & 255), Integer.valueOf((i10 >> 24) & 255));
    }

    private static boolean hD(String str) {
        if (str == null) {
            return false;
        }
        return aZg.matcher(str).matches();
    }

    public static String hE(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\\s+");
        return (split.length >= 5 && hD(split[4])) ? split[4] : "";
    }

    public static boolean isWifiConnected(Context context) {
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo != null) {
                if (networkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
