package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.j;
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
    public static final String RTD_SP_FILE = "um_rtd_conf";
    public static final String RTD_START_TIME = "startTime";

    /* renamed from: a */
    static double[] f25568a = null;

    /* renamed from: b */
    private static String f25569b = null;

    /* renamed from: c */
    private static String f25570c = null;

    /* renamed from: d */
    private static String f25571d = null;

    /* renamed from: e */
    private static int f25572e = 0;
    public static boolean enable = true;

    /* renamed from: f */
    private static Object f25573f = new Object();

    /* renamed from: g */
    private static boolean f25574g = false;

    /* renamed from: h */
    private static String f25575h = "";
    public static long kContinueSessionMillis = 30000;
    public static String mWrapperType;
    public static String mWrapperVersion;

    static void a(String str) {
        f25570c = str;
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
        return f25568a;
    }

    public static String getRealTimeDebugKey() {
        String str;
        synchronized (f25573f) {
            str = f25575h;
        }
        return str;
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(f25571d)) {
            f25571d = com.umeng.common.b.a(context).c();
        }
        return f25571d;
    }

    public static int getVerticalType(Context context) {
        if (f25572e == 0) {
            f25572e = com.umeng.common.b.a(context).d();
        }
        return f25572e;
    }

    public static boolean isRealTimeDebugMode() {
        boolean z;
        synchronized (f25573f) {
            z = f25574g;
        }
        return z;
    }

    public static void turnOffRealTimeDebug() {
        synchronized (f25573f) {
            f25574g = false;
            f25575h = "";
        }
    }

    public static void turnOnRealTimeDebug(Map<String, String> map) {
        synchronized (f25573f) {
            f25574g = true;
            if (map != null && map.containsKey(DEBUG_KEY)) {
                f25575h = map.get(DEBUG_KEY);
            }
        }
    }

    static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.A, 0, "\\|");
        } else {
            f25571d = str;
            com.umeng.common.b.a(context).a(f25571d);
        }
    }

    static void a(Context context, int i2) {
        f25572e = i2;
        com.umeng.common.b.a(context).a(f25572e);
    }
}
