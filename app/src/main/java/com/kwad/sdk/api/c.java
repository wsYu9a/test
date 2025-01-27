package com.kwad.sdk.api;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.IKsAdSDK;

/* loaded from: classes2.dex */
public final class c {
    private static IKsAdSDK Zj;

    @Nullable
    public static <T> T a(String str, Object... objArr) {
        try {
            T t = (T) Zj.dM(str, objArr);
            if (t != null) {
                return t;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(IKsAdSDK iKsAdSDK) {
        Zj = iKsAdSDK;
    }

    public static String aZ(String str) {
        return (String) a("TRANSFORM_API_HOST", str);
    }

    public static IKsAdSDK ti() {
        return Zj;
    }

    public static boolean tj() {
        Boolean bool = (Boolean) a("enableDynamic", new Object[0]);
        return (bool == null || bool.booleanValue()) ? false : true;
    }

    public static int tk() {
        Integer num = (Integer) a("getAutoRevertTime", new Object[0]);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }
}
