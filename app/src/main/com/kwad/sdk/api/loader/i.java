package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes3.dex */
final class i {
    static String apX = "autoRevert";

    public static boolean K(String str, String str2) {
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
        for (int i10 = 0; i10 < split.length && i10 < split2.length; i10++) {
            try {
                int parseInt = Integer.parseInt(split[i10]) - Integer.parseInt(split2[i10]);
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

    public static String aQ(Context context) {
        return getVersion(context, "curversion");
    }

    public static String aR(Context context) {
        return getVersion(context, "newversion");
    }

    public static String aS(Context context) {
        return getVersion(context, "apiversion");
    }

    private static void d(Context context, String str, String str2) {
        b.c(context, str, str2);
    }

    private static String getVersion(Context context, String str) {
        return b.b(context, str, "");
    }

    public static void o(Context context, String str) {
        d(context, "curversion", str);
    }

    public static void p(Context context, String str) {
        d(context, "newversion", str);
    }

    public static void q(Context context, String str) {
        d(context, "apiversion", str);
    }
}
