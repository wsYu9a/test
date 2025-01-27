package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Process;

/* loaded from: classes2.dex */
public final class AbiUtil {
    private static Abi ayP;

    public enum Abi {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    public static String bu(Context context) {
        return isArm64(context) ? "arm64-v8a" : "armeabi-v7a";
    }

    private static Abi bv(Context context) {
        Abi abi;
        Abi abi2 = ayP;
        if (abi2 != null) {
            return abi2;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            if (i2 < 23) {
                if (i2 >= 21) {
                    try {
                        ayP = ((Boolean) s.a(s.a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0])).booleanValue() ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        try {
                            ayP = context.getApplicationInfo().nativeLibraryDir.contains("arm64") ? Abi.ARM64_V8A : Abi.UNKNOWN;
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            abi = Abi.UNKNOWN;
                        }
                    }
                }
                return ayP;
            }
            if (Process.is64Bit()) {
                abi = Abi.ARM64_V8A;
            }
            ayP = abi;
            return ayP;
        }
        abi = Abi.ARMEABI_V7A;
        ayP = abi;
        return ayP;
    }

    public static boolean isArm64(Context context) {
        return bv(context) == Abi.ARM64_V8A;
    }
}
