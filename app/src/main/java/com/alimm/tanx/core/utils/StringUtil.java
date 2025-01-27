package com.alimm.tanx.core.utils;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class StringUtil implements NotConfused {
    public static String filterNonPrintableCharacters(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        for (char c10 : str.toCharArray()) {
            if (isPrintable(c10)) {
                sb2.append(c10);
            }
        }
        System.currentTimeMillis();
        return sb2.toString();
    }

    public static boolean isNull(String str) {
        return TextUtils.isEmpty(str);
    }

    public static boolean isPrintable(char c10) {
        return (Character.isISOControl(c10) || Character.getType(c10) == 0) ? false : true;
    }
}
