package com.vivo.mobilead.util;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public class r0 {
    private static boolean a(char c2) {
        return c2 / 128 == 0;
    }

    public static double a(String str) {
        double d2 = 0.0d;
        if (str == null) {
            return 0.0d;
        }
        for (char c2 : str.toCharArray()) {
            d2 += a(c2) ? 0.5d : 1.0d;
        }
        return Math.ceil(d2);
    }

    public static String a(String str, int i2) {
        try {
            if (!TextUtils.isEmpty(str) && i2 >= 1) {
                double d2 = i2;
                if (d2 > a(str)) {
                    return str;
                }
                StringBuffer stringBuffer = new StringBuffer();
                double d3 = 0.0d;
                for (char c2 : str.toCharArray()) {
                    d3 += String.valueOf(c2).getBytes("UTF-8").length == 3 ? 1.0d : 0.5d;
                    if (d3 > d2) {
                        break;
                    }
                    stringBuffer.append(c2);
                }
                return stringBuffer.toString();
            }
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return str.length() > i2 ? str.substring(0, i2) : str;
        }
    }
}
