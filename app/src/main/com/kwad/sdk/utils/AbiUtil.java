package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Process;

/* loaded from: classes3.dex */
public final class AbiUtil {
    private static Abi aSs;

    public enum Abi {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    public static String bU(Context context) {
        return isArm64(context) ? "arm64-v8a" : "armeabi-v7a";
    }

    private static Abi bV(Context context) {
        boolean is64Bit;
        Abi abi = aSs;
        if (abi != null) {
            return abi;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            is64Bit = Process.is64Bit();
            aSs = is64Bit ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
        } else {
            try {
                aSs = ((Boolean) w.callMethod(w.a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0])).booleanValue() ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
            } catch (Throwable th2) {
                th2.printStackTrace();
                try {
                    if (context.getApplicationInfo().nativeLibraryDir.contains("arm64")) {
                        aSs = Abi.ARM64_V8A;
                    } else {
                        aSs = Abi.UNKNOWN;
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    aSs = Abi.UNKNOWN;
                }
            }
        }
        return aSs;
    }

    public static boolean isArm64(Context context) {
        return bV(context) == Abi.ARM64_V8A;
    }
}
