package com.vivo.advv.vaf.virtualview.Helper;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes4.dex */
public class RtlHelper {
    private static boolean sEnable = true;

    public static int getRealLeft(boolean z, int i2, int i3, int i4, int i5) {
        if (!z) {
            return i4;
        }
        return ((i3 - i5) - (i4 - i2)) + i2;
    }

    public static boolean isEnable() {
        return sEnable;
    }

    public static boolean isRtl() {
        return sEnable && Build.VERSION.SDK_INT >= 17 && 1 == TextUtils.getLayoutDirectionFromLocale(Locale.getDefault());
    }

    public static int resolveRtlGravity(int i2) {
        return (i2 & 2) != 0 ? (i2 & (-3)) | 1 : (i2 & 1) != 0 ? (i2 & (-2)) | 2 : i2;
    }

    public static void setEnable(boolean z) {
        sEnable = z;
    }
}
