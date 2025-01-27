package com.kwad.sdk.utils;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class bb {
    private static final SimpleDateFormat aAC;
    private static final SimpleDateFormat aAD;
    private static final SimpleDateFormat aAE;
    private static final SimpleDateFormat aAF;
    private static final SimpleDateFormat aAG;
    private static final SimpleDateFormat aAH;
    private static final SimpleDateFormat aAI;

    static {
        Locale locale = Locale.US;
        aAC = new SimpleDateFormat("MM/dd", locale);
        aAD = new SimpleDateFormat("yyyy/MM/dd", locale);
        aAE = new SimpleDateFormat("MM月dd日", locale);
        aAF = new SimpleDateFormat("yyyy年MM月dd日", locale);
        aAG = new SimpleDateFormat("HH:mm", locale);
        aAH = new SimpleDateFormat("MM-dd", locale);
        aAI = new SimpleDateFormat("yyyy-MM-dd", locale);
    }

    public static boolean eO(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static boolean eP(String str) {
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
