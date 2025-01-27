package oe;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class a {
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("1[3456789]\\d{9}");
    }
}
