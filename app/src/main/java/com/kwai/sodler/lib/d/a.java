package com.kwai.sodler.lib.d;

import android.os.Build;
import android.os.Process;
import com.kwad.sdk.utils.s;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a {
    private static String aLd;
    private static String aLe;
    private static final Map<String, String> aLf;

    static {
        HashMap hashMap = new HashMap();
        aLf = hashMap;
        hashMap.put("mips", "mips");
        hashMap.put("mips64", "mips64");
        hashMap.put("x86", "x86");
        hashMap.put("x86_64", "x86_64");
        hashMap.put("arm64", "arm64-v8a");
    }

    private static boolean is64Bit() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return Process.is64Bit();
        }
        if (i2 < 21) {
            return false;
        }
        Boolean bool = null;
        try {
            bool = (Boolean) s.a(s.a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static String tz() {
        return is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }
}
