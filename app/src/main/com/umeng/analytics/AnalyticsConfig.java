package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.l;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Map;

/* loaded from: classes4.dex */
public class AnalyticsConfig {
    public static boolean CATCH_EXCEPTION = false;
    public static boolean CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    public static boolean CLEAR_EKV_BL = false;
    public static boolean CLEAR_EKV_WL = false;
    public static final String DEBUG_KEY = "debugkey";
    public static final String DEBUG_MODE_PERIOD = "sendaging";
    public static String GPU_RENDERER = "";
    public static String GPU_VENDER = "";
    public static final String RTD_PERIOD = "period";
    public static final String RTD_START_TIME = "startTime";

    /* renamed from: a */
    static double[] f23302a = null;

    /* renamed from: b */
    private static String f23303b = null;

    /* renamed from: c */
    private static String f23304c = null;

    /* renamed from: d */
    private static String f23305d = null;

    /* renamed from: e */
    private static int f23306e = 0;
    public static boolean enable = true;
    public static long kContinueSessionMillis = 30000;
    public static String mWrapperType;
    public static String mWrapperVersion;
    public static final String RTD_SP_FILE = bd.b().b(bd.A);

    /* renamed from: f */
    private static Object f23307f = new Object();

    /* renamed from: g */
    private static boolean f23308g = false;

    /* renamed from: h */
    private static String f23309h = "";

    public static void a(String str) {
        f23304c = str;
    }

    public static String getAppkey(Context context) {
        return UMUtils.getAppkey(context);
    }

    public static String getChannel(Context context) {
        return UMUtils.getChannel(context);
    }

    public static String getGameSdkVersion(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.analytics.game.GameSdkVersion");
            return (String) cls.getDeclaredField("SDK_VERSION").get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static double[] getLocation() {
        return f23302a;
    }

    public static String getRealTimeDebugKey() {
        String str;
        synchronized (f23307f) {
            str = f23309h;
        }
        return str;
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(f23305d)) {
            f23305d = com.umeng.common.b.a(context).c();
        }
        return f23305d;
    }

    public static int getVerticalType(Context context) {
        if (f23306e == 0) {
            f23306e = com.umeng.common.b.a(context).d();
        }
        return f23306e;
    }

    public static boolean isRealTimeDebugMode() {
        boolean z10;
        synchronized (f23307f) {
            z10 = f23308g;
        }
        return z10;
    }

    public static void turnOffRealTimeDebug() {
        synchronized (f23307f) {
            f23308g = false;
            f23309h = "";
        }
    }

    public static void turnOnRealTimeDebug(Map<String, String> map) {
        synchronized (f23307f) {
            try {
                f23308g = true;
                if (map != null && map.containsKey(DEBUG_KEY)) {
                    f23309h = map.get(DEBUG_KEY);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(l.A, 0, "\\|");
        } else {
            f23305d = str;
            com.umeng.common.b.a(context).a(f23305d);
        }
    }

    public static void a(Context context, int i10) {
        f23306e = i10;
        com.umeng.common.b.a(context).a(f23306e);
    }
}
