package com.oplus.quickgame.sdk.engine.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.am;
import com.cdo.oaps.ad.OapsKey;
import com.martian.mibook.application.MiConfigSingleton;
import com.oplus.quickgame.sdk.QuickGame;
import com.oplus.quickgame.sdk.engine.callback.Callback;
import com.oplus.quickgame.sdk.engine.utils.d;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class QgRouterManager {

    /* renamed from: a */
    private static boolean f16209a = false;

    /* renamed from: b */
    private static String f16210b = "SP_GameEngineConfig";

    /* renamed from: c */
    private static String f16211c = "NEW_ENGINE_CONFIG_NATVIE_CACHE_KEY";

    /* renamed from: d */
    private static String f16212d = "NEW_ENGINE_CONFIG_NATVIE_CACHE_SAVE_DATE";

    static final class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f16213a;

        a(Context context) {
            this.f16213a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            QgRouterManager.e(this.f16213a);
        }
    }

    private static void a(Context context, String str) {
        context.getSharedPreferences(f16210b, 0).edit().putString(f16211c, str).putLong(f16212d, System.currentTimeMillis()).apply();
    }

    private static boolean a(String str, long j2) {
        JSONObject jSONObject;
        String str2;
        boolean z;
        String str3;
        try {
            jSONObject = new JSONObject(new JSONObject(str).getString(MiConfigSingleton.t0));
            try {
                str2 = jSONObject.getString("xgame_open_max_interval");
                z = true;
            } catch (JSONException unused) {
                str2 = "0";
                z = false;
                if (z) {
                }
                str3 = "快游戏引擎配置检测失败：不符合json格式";
                i.c("QuickGame", str3);
                return false;
            }
        } catch (JSONException unused2) {
            jSONObject = null;
        }
        if (z || jSONObject == null) {
            str3 = "快游戏引擎配置检测失败：不符合json格式";
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis > j2 && currentTimeMillis - j2 <= (Long.parseLong(str2) * 60) * 1000) {
                return true;
            }
            str3 = "快游戏引擎配置检测失败：不符合最大有效时间：" + str2 + "min，return 空";
        }
        i.c("QuickGame", str3);
        return false;
    }

    private static String b(Context context) {
        return context.getSharedPreferences(f16210b, 0).getString(f16211c, "");
    }

    private static long c(Context context) {
        return context.getSharedPreferences(f16210b, 0).getLong(f16212d, 0L);
    }

    public static boolean configDataCache(String str) {
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str).getString(MiConfigSingleton.t0));
            String string = jSONObject.getString("xgame_open_imei_range_2");
            String string2 = jSONObject.getString("xgame_open_phone_black_list");
            String string3 = jSONObject.getString("xgame_open_android_version_black_list");
            String string4 = jSONObject.getString("xgame_open_max_interval");
            d.a("xgame_open_imei_range_2", string);
            d.a("xgame_open_phone_black_list", string2);
            d.a("xgame_open_android_version_black_list", string3);
            d.a("xgame_open_max_interval", string4);
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static QuickGame.Req createReq(Context context, String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, Callback callback) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            str2 = "context =null 或者 url=空";
        } else if (!QuickGame.isUriSupported(str)) {
            str2 = "传入的url不支持快游戏引擎启动；url" + str;
        } else if (!QuickGame.isEngineInstalled(context)) {
            str2 = "快游戏引擎未安装，不支持引擎启动；";
        } else if (!QuickGame.isUseEngineConfig(context)) {
            str2 = "游戏引擎配置检索失败，不支持引擎启动；";
        } else if (!QuickGame.isUseEngine(context)) {
            str2 = "快游戏引擎配置不持支本次引擎启动；请检索日志QgRouterManager";
        } else {
            if (map != null) {
                QuickGame.Builder createBuilder = QuickGame.createBuilder(map.get("origin"), map.get("secret"));
                createBuilder.setRequestUrl(str);
                createBuilder.setCallback(callback);
                if ("1".equals(map2.get(OapsKey.KEY_SIGN_TYPE))) {
                    createBuilder.signAsPlatform();
                }
                j.a(map, 0, createBuilder);
                j.a(map2, 1, createBuilder);
                j.a(map4, 2, createBuilder);
                j.a(map3, 3, createBuilder);
                return createBuilder.build();
            }
            str2 = "deepLinkParams = null";
        }
        i.c("QuickGame", str2);
        return null;
    }

    private static boolean d(Context context) {
        String str;
        if (n.g(context)) {
            d.a aVar = d.a.OPEN;
            if (d.a(aVar, context)) {
                i.a("QgRouterManager", "open : is in imei range");
                if (d.a(aVar)) {
                    str = "open : is in androidver black list";
                } else {
                    i.a("QgRouterManager", "open : is not in androidver black list");
                    if (!d.b(aVar)) {
                        i.a("QgRouterManager", "open : is not in phone black list");
                        i.a("QgRouterManager", "isUseNewEngine");
                        return true;
                    }
                    str = "open : is in phone black list";
                }
            } else {
                str = "open : is not in imei range";
            }
        } else {
            str = "open : new engine is not installed";
        }
        i.a("QgRouterManager", str);
        return false;
    }

    public static void e(Context context) {
        String str;
        f16209a = true;
        com.oplus.quickgame.sdk.engine.b.c a2 = new com.oplus.quickgame.sdk.engine.b.a().a(com.oplus.quickgame.sdk.engine.b.b.d().b(m.a()).a(MonitorConstants.CONNECT_TYPE_GET).a("Content-Type", "application/json;charset=UTF-8").a(HttpHeaders.ACCEPT, am.f5520d).a());
        if (a2 != null) {
            String a3 = a2.a();
            i.c("QuickGame", "快游戏下载引擎配置-> 成功，配置json：" + a3);
            if (configDataCache(a3)) {
                a(context, a3);
                f16209a = false;
            } else {
                a(context, "");
                str = "配置数据不符合json格式";
            }
        } else {
            str = "快游戏下载引擎配置失败";
        }
        i.c("QuickGame", str);
        f16209a = false;
    }

    public static boolean isUseEngine(Context context) {
        return d(context);
    }

    public static boolean isUseXGameManageGameCache(Context context) {
        String str;
        if (!QuickGame.isEngineInstalled(context)) {
            str = "快游戏引擎未安装，不支持引擎启动；";
        } else if (!QuickGame.isUseEngineConfig(context)) {
            str = "游戏引擎配置检索失败，不支持引擎启动；";
        } else {
            if (QuickGame.isUseEngine(context)) {
                return true;
            }
            str = "快游戏引擎配置不持支本次引擎启动；请检索日志QgRouterManager";
        }
        i.c("XGameCleanProvider", str);
        return false;
    }

    public static String requestEngineConfigIfNeed(Context context) {
        String b2 = b(context);
        i.c("QuickGame", "从缓存中获取 快游戏引擎配置：" + b2);
        long c2 = c(context);
        if (!TextUtils.isEmpty(b2) && a(b2, c2)) {
            i.c("QuickGame", "缓存未失效");
            return b2;
        }
        if (!f16209a) {
            if (l.a()) {
                l.a(new a(context));
            } else {
                e(context);
            }
        }
        return "";
    }
}
