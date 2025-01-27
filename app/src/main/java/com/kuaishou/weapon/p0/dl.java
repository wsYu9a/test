package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.os.Process;

/* loaded from: classes.dex */
public final class dl {

    /* renamed from: a, reason: collision with root package name */
    private static a f9292a;

    public enum a {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    private dl() {
    }

    public static String a(Context context) {
        return b(context) ? "arm64-v8a" : "armeabi-v7a";
    }

    public static boolean b(Context context) {
        return c(context) == a.ARM64_V8A;
    }

    private static a c(Context context) {
        a aVar;
        a aVar2 = f9292a;
        if (aVar2 != null) {
            return aVar2;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            if (i2 < 23) {
                if (i2 >= 21) {
                    try {
                        Class<?> cls = Class.forName("dalvik.system.VMRuntime");
                        f9292a = ((Boolean) cls.getDeclaredMethod("is64Bit", new Class[0]).invoke(cls.getDeclaredMethod("getRuntime", new Class[0]).invoke(cls, new Object[0]), new Object[0])).booleanValue() ? a.ARM64_V8A : a.ARMEABI_V7A;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        try {
                            f9292a = context.getApplicationInfo().nativeLibraryDir.contains("arm64") ? a.ARM64_V8A : a.UNKNOWN;
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            aVar = a.UNKNOWN;
                        }
                    }
                }
                return f9292a;
            }
            if (Process.is64Bit()) {
                aVar = a.ARM64_V8A;
            }
            f9292a = aVar;
            return f9292a;
        }
        aVar = a.ARMEABI_V7A;
        f9292a = aVar;
        return f9292a;
    }
}
