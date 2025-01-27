package com.kwad.sdk.api.loader;

import android.os.Build;
import android.os.Process;

/* loaded from: classes2.dex */
final class w {
    static boolean is64Bit() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return Process.is64Bit();
        }
        if (i2 >= 21) {
            try {
                return ((Boolean) Reflect.bf("dalvik.system.VMRuntime").bi("getRuntime").bi("is64Bit").get()).booleanValue();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static String tz() {
        return is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }
}
