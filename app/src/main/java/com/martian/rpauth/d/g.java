package com.martian.rpauth.d;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public class g {
    public static boolean a(String mobiles) {
        if (TextUtils.isEmpty(mobiles)) {
            return false;
        }
        return mobiles.matches("[1][3456789]\\d{9}");
    }
}
