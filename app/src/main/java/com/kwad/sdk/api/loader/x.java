package com.kwad.sdk.api.loader;

import android.os.Build;
import android.os.Process;

/* loaded from: classes3.dex */
final class x {
    public static boolean is64Bit() {
        boolean is64Bit;
        if (Build.VERSION.SDK_INT >= 23) {
            is64Bit = Process.is64Bit();
            return is64Bit;
        }
        try {
            return ((Boolean) ApiReflect.ci("dalvik.system.VMRuntime").cl("getRuntime").cl("is64Bit").get()).booleanValue();
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static String yT() {
        return is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }
}
