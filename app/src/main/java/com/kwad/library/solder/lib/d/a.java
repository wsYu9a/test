package com.kwad.library.solder.lib.d;

import android.os.Build;
import android.os.Process;
import com.kwad.sdk.utils.w;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class a {
    private static String anx;
    private static String any;
    private static final Map<String, String> anz;

    static {
        HashMap hashMap = new HashMap();
        anz = hashMap;
        hashMap.put("mips", "mips");
        hashMap.put("mips64", "mips64");
        hashMap.put("x86", "x86");
        hashMap.put("x86_64", "x86_64");
        hashMap.put("arm64", "arm64-v8a");
    }

    private static boolean is64Bit() {
        Boolean bool;
        boolean is64Bit;
        if (Build.VERSION.SDK_INT >= 23) {
            is64Bit = Process.is64Bit();
            return is64Bit;
        }
        try {
            bool = (Boolean) w.callMethod(w.a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0]);
        } catch (Exception e10) {
            e10.printStackTrace();
            bool = null;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static String yT() {
        return is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }
}
