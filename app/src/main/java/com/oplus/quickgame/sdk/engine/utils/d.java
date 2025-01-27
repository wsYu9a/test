package com.oplus.quickgame.sdk.engine.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import kotlin.text.Typography;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private static HashMap<String, String> f16214a = new HashMap<>(8);

    public enum a {
        INSTALL,
        OPEN
    }

    private static int a(char c2) {
        int i2;
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        int i3 = 65;
        if (c2 < 'A' || c2 > 'Z') {
            i3 = 97;
            if (c2 < 'a' || c2 > 'z') {
                return 0;
            }
            i2 = c2 + Typography.dollar;
        } else {
            i2 = c2 + '\n';
        }
        return i2 - i3;
    }

    private static int a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 3) {
            try {
                return Integer.parseInt(str.substring(str.length() - 1, str.length())) + (Integer.parseInt(str.substring(str.length() - 2, str.length() - 1)) * 10) + (Integer.parseInt(str.substring(str.length() - 3, str.length() - 2)) * 100);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return -1;
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f16214a.put(str, str2);
    }

    public static boolean a(a aVar) {
        String c2 = c(aVar == a.INSTALL ? "xgame_install_android_version_black_list" : "xgame_open_android_version_black_list");
        String[] split = TextUtils.isEmpty(c2) ? null : c2.split("#");
        if (split == null) {
            return false;
        }
        int c3 = e.c();
        for (String str : split) {
            if (String.valueOf(c3).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(a aVar, Context context) {
        int a2;
        String c2 = c(aVar == a.INSTALL ? "xgame_install_imei_range_2" : "xgame_open_imei_range_2");
        String[] split = !TextUtils.isEmpty(c2) ? c2.split("-") : null;
        if (split != null && split.length >= 2) {
            int[] iArr = new int[2];
            try {
                iArr[0] = Integer.parseInt(split[0]);
                iArr[1] = Integer.parseInt(split[1]);
                if (Build.VERSION.SDK_INT >= 29) {
                    String d2 = e.d(context);
                    if (TextUtils.isEmpty(d2)) {
                        return true;
                    }
                    a2 = b(d2);
                } else {
                    String b2 = e.b(context);
                    if (TextUtils.isEmpty(b2)) {
                        return true;
                    }
                    a2 = a(b2);
                }
                if (a2 != -1 && a2 >= iArr[0] && a2 <= iArr[1]) {
                    return true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    private static int b(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 3) {
            try {
                return ((a(str.substring(str.length() - 1).toCharArray()[0]) + ((a(str.substring(str.length() - 2, str.length() - 1).toCharArray()[0]) * 10) + (a(str.substring(str.length() - 3, str.length() - 2).toCharArray()[0]) * 100))) * 999) / 6882;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return -1;
    }

    public static boolean b(a aVar) {
        String c2 = c(aVar == a.INSTALL ? "xgame_install_phone_black_list" : "xgame_open_phone_black_list");
        String[] split = TextUtils.isEmpty(c2) ? null : c2.split("#");
        if (split == null) {
            return false;
        }
        for (String str : split) {
            if (Build.MODEL.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    private static String c(String str) {
        return TextUtils.isEmpty(str) ? "" : f16214a.get(str);
    }
}
