package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class bc {
    private static Class<?> aAJ;

    private static String eQ(String str) {
        try {
            return com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec("getprop " + str).getInputStream());
        } catch (IOException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            return null;
        }
    }

    @SuppressLint({"PrivateApi"})
    private static Object g(String str, Object... objArr) {
        try {
            if (aAJ == null) {
                aAJ = Class.forName("android.os.SystemProperties");
            }
            return s.c(aAJ, str, objArr);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
            return null;
        }
    }

    public static String get(String str) {
        Object g2 = g(MonitorConstants.CONNECT_TYPE_GET, str);
        return g2 instanceof String ? (String) g2 : eQ(str);
    }
}
