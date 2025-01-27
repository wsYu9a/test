package com.kwad.sdk.utils;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public final class bj {
    public static boolean aj(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
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
            if (split.length >= split2.length) {
                return true;
            }
        }
        return false;
    }
}
