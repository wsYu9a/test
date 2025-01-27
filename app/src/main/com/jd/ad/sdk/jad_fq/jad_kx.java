package com.jd.ad.sdk.jad_fq;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public final class jad_kx {
    public static boolean jad_an(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int length = str.length();
            if (length % 4 != 0) {
                return false;
            }
            char[] charArray = str.toCharArray();
            for (int i10 = 0; i10 < length; i10++) {
                if (i10 == length - 3 && charArray[i10] == '=') {
                    return false;
                }
                char c10 = charArray[i10];
                if ((c10 < 'A' || c10 > 'Z') && ((c10 < 'a' || c10 > 'z') && !((c10 >= '0' && c10 <= '9') || c10 == '_' || c10 == '-' || c10 == '='))) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
