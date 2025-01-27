package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.os.Process;

/* loaded from: classes2.dex */
public final class dm {

    /* renamed from: a */
    private static a f11076a;

    public enum a {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    private dm() {
    }

    public static String a(Context context) {
        return b(context) ? "arm64-v8a" : "armeabi-v7a";
    }

    public static boolean b(Context context) {
        return c(context) == a.ARM64_V8A;
    }

    private static a c(Context context) {
        boolean is64Bit;
        a aVar = f11076a;
        if (aVar != null) {
            return aVar;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            is64Bit = Process.is64Bit();
            f11076a = is64Bit ? a.ARM64_V8A : a.ARMEABI_V7A;
        } else {
            try {
                Class<?> cls = Class.forName("dalvik.system.VMRuntime");
                f11076a = ((Boolean) cls.getDeclaredMethod("is64Bit", null).invoke(cls.getDeclaredMethod("getRuntime", null).invoke(cls, null), null)).booleanValue() ? a.ARM64_V8A : a.ARMEABI_V7A;
            } catch (Throwable th2) {
                th2.printStackTrace();
                try {
                    if (context.getApplicationInfo().nativeLibraryDir.contains("arm64")) {
                        f11076a = a.ARM64_V8A;
                    } else {
                        f11076a = a.UNKNOWN;
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    f11076a = a.UNKNOWN;
                }
            }
        }
        return f11076a;
    }
}
