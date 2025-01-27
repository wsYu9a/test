package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.martian.ads.ad.AdConfig;
import com.umeng.analytics.pro.j;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class MobclickAgent {

    public enum EScenarioType {
        E_UM_NORMAL(0),
        E_UM_GAME(1);


        /* renamed from: a */
        private int f25581a;

        EScenarioType(int i2) {
            this.f25581a = i2;
        }

        public int toValue() {
            return this.f25581a;
        }
    }

    public enum PageMode {
        AUTO,
        MANUAL,
        LEGACY_AUTO,
        LEGACY_MANUAL
    }

    public static void clearPreProperties(Context context) {
        getAgent().g(context);
    }

    public static void disable() {
        AnalyticsConfig.enable = false;
    }

    private static void disableExceptionCatch() {
        b.a().a(false);
        AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    }

    public static void enableEncrypt(boolean z) {
    }

    public static b getAgent() {
        return b.a();
    }

    public static JSONObject getPreProperties(Context context) {
        return getAgent().h(context);
    }

    private static void init(Context context) {
        b.a().a(context);
    }

    public static void onEvent(Context context, String str) {
        b.a().a(context, str, (String) null, -1L, 1);
    }

    public static void onEventObject(Context context, String str, Map<String, Object> map) {
        if (map == null) {
            UMLog.aq(j.f25930a, 0, "\\|");
        } else {
            b.a().a(context, str, map, -1L);
        }
    }

    public static void onEventValue(Context context, String str, Map<String, String> map, int i2) {
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("__ct__", Integer.valueOf(i2));
        b.a().a(context, str, hashMap, -1L);
    }

    private static void onGKVEvent(Context context, String str, HashMap<String, Object> hashMap) {
        b.a().a(context, str, hashMap);
    }

    public static void onKillProcess(Context context) {
        b.a().d(context);
    }

    public static void onPageEnd(String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.D, 0, "\\|");
        } else {
            b.a().b(str);
        }
    }

    public static void onPageStart(String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.C, 0, "\\|");
        } else {
            b.a().a(str);
        }
    }

    public static void onPause(Context context) {
        b.a().c(context);
    }

    public static void onProfileSignIn(String str) {
        onProfileSignIn("_adhoc", str);
    }

    public static void onProfileSignOff() {
        b.a().j();
    }

    public static void onResume(Context context) {
        if (context == null) {
            UMLog.aq(j.n, 0, "\\|");
        } else {
            b.a().b(context);
        }
    }

    public static void registerPreProperties(Context context, JSONObject jSONObject) {
        getAgent().a(context, jSONObject);
    }

    public static void reportError(Context context, String str) {
        try {
            Class<?> cls = Class.forName("com.umeng.umcrash.UMCrash");
            Method declaredMethod = cls.getDeclaredMethod("generateCustomLog", String.class, String.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(cls, str, AdConfig.UnionType.DEFAULT);
            }
        } catch (Throwable unused) {
        }
    }

    public static void setCatchUncaughtExceptions(boolean z) {
        b.a().a(z);
    }

    public static void setCheckDevice(boolean z) {
    }

    public static void setDebugMode(boolean z) {
    }

    public static void setFirstLaunchEvent(Context context, List<String> list) {
        getAgent().a(context, list);
    }

    private static void setGameScenarioType(Context context) {
        b.a().a(context, EScenarioType.E_UM_GAME);
    }

    public static void setLatencyWindow(long j2) {
    }

    public static void setLocation(double d2, double d3) {
        b.a().a(d2, d3);
    }

    public static void setOpenGLContext(GL10 gl10) {
        b.a().a(gl10);
    }

    public static void setPageCollectionMode(PageMode pageMode) {
        UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION = pageMode;
    }

    public static void setScenarioType(Context context, EScenarioType eScenarioType) {
    }

    public static void setSecret(Context context, String str) {
        b.a().c(context, str);
    }

    public static void setSessionContinueMillis(long j2) {
        if (j2 <= 30000) {
            j2 = 30000;
        }
        b.a().a(j2);
    }

    private static void setSysListener(ISysListener iSysListener) {
        b.a().a(iSysListener);
    }

    public static void unregisterPreProperty(Context context, String str) {
        getAgent().f(context, str);
    }

    public static void onEvent(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            UMLog.aq(j.k, 0, "\\|");
        } else {
            b.a().a(context, str, str2, -1L, 1);
        }
    }

    public static void onProfileSignIn(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            UMLog.aq(j.t, 0, "\\|");
            return;
        }
        if (str2.length() > 64) {
            UMLog.aq(j.u, 0, "\\|");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            b.a().a("_adhoc", str2);
        } else if (str.length() > 32) {
            UMLog.aq(j.v, 0, "\\|");
        } else {
            b.a().a(str, str2);
        }
    }

    public static void onEvent(Context context, String str, Map<String, String> map) {
        if (map == null) {
            UMLog.aq(j.f25930a, 0, "\\|");
        } else {
            b.a().a(context, str, new HashMap(map), -1L);
        }
    }

    public static void reportError(Context context, Throwable th) {
        try {
            Class<?> cls = Class.forName("com.umeng.umcrash.UMCrash");
            Method declaredMethod = cls.getDeclaredMethod("generateCustomLog", Throwable.class, String.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(cls, th, AdConfig.UnionType.DEFAULT);
            }
        } catch (Throwable unused) {
        }
    }
}
