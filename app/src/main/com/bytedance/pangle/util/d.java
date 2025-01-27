package com.bytedance.pangle.util;

import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class d {
    public static <T> boolean a(@Nullable T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static <T> boolean a(@Nullable T[] tArr, T[] tArr2) {
        if (tArr2 == null) {
            return true;
        }
        for (T t10 : tArr2) {
            if (!a(tArr, t10)) {
                return false;
            }
        }
        return true;
    }

    private static <T> boolean a(@Nullable T[] tArr, T t10) {
        int i10;
        if (tArr != null) {
            i10 = 0;
            while (i10 < tArr.length) {
                T t11 = tArr[i10];
                if (t11 == t10 || (t11 != null && t11.equals(t10))) {
                    break;
                }
                i10++;
            }
        }
        i10 = -1;
        return i10 != -1;
    }
}
