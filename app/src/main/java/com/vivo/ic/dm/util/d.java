package com.vivo.ic.dm.util;

import android.os.Build;

/* loaded from: classes4.dex */
public class d {
    public static int a(int i2) {
        return Build.VERSION.SDK_INT >= 23 ? i2 | 67108864 : i2;
    }

    public static int b(int i2) {
        return Build.VERSION.SDK_INT >= 23 ? i2 | 33554432 : i2;
    }
}
