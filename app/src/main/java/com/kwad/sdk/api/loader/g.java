package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes2.dex */
final class g {
    static String ZA = "autoRevert";

    public static String ao(Context context) {
        return getVersion(context, "curversion");
    }

    public static String ap(Context context) {
        return getVersion(context, "newversion");
    }

    static String aq(Context context) {
        return getVersion(context, "apiversion");
    }

    private static void b(Context context, String str, String str2) {
        t.c(context, str, str2);
    }

    private static String getVersion(Context context, String str) {
        return t.d(context, str, "");
    }

    public static void h(Context context, String str) {
        b(context, "curversion", str);
    }

    public static void i(Context context, String str) {
        b(context, "newversion", str);
    }

    static void j(Context context, String str) {
        b(context, "apiversion", str);
    }

    static boolean q(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        for (int i2 = 0; i2 < split.length && i2 < split2.length; i2++) {
            try {
                int parseInt = Integer.parseInt(split[i2]) - Integer.parseInt(split2[i2]);
                if (parseInt > 0) {
                    return true;
                }
                if (parseInt < 0) {
                    return false;
                }
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return split.length > split2.length;
    }
}
