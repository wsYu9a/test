package com.kwad.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public final class n {
    private static boolean aoG;
    private static long aoo;

    public static void Ba() {
        if (aoG) {
            return;
        }
        aoG = true;
        aoo = SystemClock.elapsedRealtime();
    }

    public static void a(Throwable th2, String str) {
        try {
            m.a(com.kwai.adclient.kscommerciallogger.model.a.aYA, str);
            com.kwad.components.core.d.a.reportSdkCaughtException(th2);
        } catch (Throwable unused) {
        }
        aK(ServiceProvider.MA());
        com.kwad.sdk.core.d.c.d("SDKRevertHelper", "onInitError revert");
    }

    public static void aJ(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - aoo;
        com.kwad.sdk.core.d.c.d("SDKRevertHelper", "onException revert time: " + elapsedRealtime);
        if (elapsedRealtime < 10000) {
            aK(context);
        }
    }

    private static void aK(Context context) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putString("curversion", "").putBoolean("initFail", true).apply();
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
        }
    }

    public static void aL(Context context) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean("initFail", false).apply();
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
        }
    }

    public static boolean aM(Context context) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getBoolean("initFail", false);
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            return false;
        }
    }

    private static SdkConfig aN(Context context) {
        SdkConfig sdkConfig;
        try {
            sdkConfig = SdkConfig.create(b(context, "sdkconfig", ""));
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            sdkConfig = null;
        }
        return sdkConfig == null ? new SdkConfig.Builder().build() : sdkConfig;
    }

    private static String b(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getString(str, str2);
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            return str2;
        }
    }

    public static void checkInitSDK(Context context) {
        try {
            if (l.At().zE()) {
                return;
            }
            KsAdSDK.init(context, aN(context));
        } catch (Throwable th2) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th2);
        }
    }

    public static void l(Throwable th2) {
        a(th2, Log.getStackTraceString(th2));
    }
}
