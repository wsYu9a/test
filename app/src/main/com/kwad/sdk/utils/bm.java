package com.kwad.sdk.utils;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class bm {
    private static final SimpleDateFormat aUM;
    private static final SimpleDateFormat aUN;
    private static final SimpleDateFormat aUO;
    private static final SimpleDateFormat aUP;
    private static final SimpleDateFormat aUQ;
    private static final SimpleDateFormat aUR;
    private static final SimpleDateFormat aUS;

    static {
        Locale locale = Locale.US;
        aUM = new SimpleDateFormat("MM/dd", locale);
        aUN = new SimpleDateFormat("yyyy/MM/dd", locale);
        aUO = new SimpleDateFormat("MM月dd日", locale);
        aUP = new SimpleDateFormat("yyyy年MM月dd日", locale);
        aUQ = new SimpleDateFormat("HH:mm", locale);
        aUR = new SimpleDateFormat("MM-dd", locale);
        aUS = new SimpleDateFormat("yyyy-MM-dd", locale);
    }

    public static boolean hd(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches(".*\\.kpg.*");
    }

    public static boolean isEquals(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.equals(str2);
    }

    public static boolean isNullString(String str) {
        return TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str);
    }
}
