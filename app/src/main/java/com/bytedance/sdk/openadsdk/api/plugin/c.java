package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.sdk.internal.bm;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.shu.priory.config.AdKeys;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
final class c {

    /* renamed from: b */
    private static SharedPreferences f8054b;

    /* renamed from: c */
    private static final List<Pair<String, JSONObject>> f8055c = new CopyOnWriteArrayList();

    /* renamed from: a */
    static final Map<String, String> f8053a = new HashMap();

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.c$1 */
    public static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f8056a;

        /* renamed from: b */
        final /* synthetic */ JSONObject f8057b;

        public AnonymousClass1(String str, JSONObject jSONObject) {
            str = str;
            jSONObject = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(c.f(str, jSONObject));
            c.b(arrayList);
        }
    }

    public static void b(String str, JSONObject jSONObject) {
        f8055c.add(new Pair<>(str, jSONObject));
    }

    private static void d(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager == null) {
            e(str, jSONObject);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 1);
        bundle.putString("event_name", str);
        bundle.putString("event_extra", jSONObject.toString());
        adManager.getExtra(Bundle.class, bundle);
    }

    private static void e(String str, JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.e.a.a().b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.c.1

            /* renamed from: a */
            final /* synthetic */ String f8056a;

            /* renamed from: b */
            final /* synthetic */ JSONObject f8057b;

            public AnonymousClass1(String str2, JSONObject jSONObject2) {
                str = str2;
                jSONObject = jSONObject2;
            }

            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c.f(str, jSONObject));
                c.b(arrayList);
            }
        });
    }

    public static JSONObject f(String str, JSONObject jSONObject) {
        String str2 = "6.4.1.1";
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("support_abi", Arrays.toString(Build.SUPPORTED_ABIS));
            jSONObject2.put("ad_sdk_version", "6.4.1.1");
            String a10 = e.a("com.byted.pangle");
            if (!TextUtils.isEmpty(a10)) {
                str2 = a10;
            }
            jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, str2);
            jSONObject2.put(o3.a.f29032k, System.currentTimeMillis() / 1000);
            jSONObject2.put("is_plugin", true);
            Map<String, String> map = f8053a;
            jSONObject.put("appid", map.get("appid"));
            jSONObject2.put("event_extra", jSONObject.toString());
            jSONObject2.put("type", str);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(bm.f6904i, Build.MODEL);
            jSONObject3.put("vendor", Build.MANUFACTURER);
            jSONObject3.put("imei", map.get("imei"));
            jSONObject3.put(AdKeys.OAID, map.get(AdKeys.OAID));
            jSONObject2.put("device_info", jSONObject3);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public static void a(int i10, String str, long j10) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("duration", Long.valueOf(j10));
            jSONObject.putOpt("code", Integer.valueOf(i10));
            jSONObject.putOpt(b7.d.f1362o, str);
            jSONObject.putOpt("load_record", b.a());
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        e("plugin_load_failed", jSONObject);
    }

    public static void b(List<JSONObject> list) {
        if (list == null) {
            return;
        }
        if (f8054b == null) {
            f8054b = TTAppContextHolder.getContext().getSharedPreferences("tt_sdk_settings_other", 0);
        }
        String format = String.format("https://%s%s", f8054b.getString("url_stats", "api-access.pangolin-sdk-toutiao.com"), "/api/ad/union/sdk/stats/batch/");
        JSONObject jSONObject = new JSONObject();
        try {
            List<Pair<String, JSONObject>> list2 = f8055c;
            if (list2.size() > 0) {
                for (Pair<String, JSONObject> pair : list2) {
                    list.add(f((String) pair.first, (JSONObject) pair.second));
                }
                f8055c.clear();
            }
            jSONObject.put("stats_list", new JSONArray((Collection) list));
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.api.plugin.b.c.a().a(true, format, com.bytedance.sdk.openadsdk.api.plugin.c.b.a(jSONObject).toString().getBytes());
    }

    public static void a(String str, JSONObject jSONObject) {
        d("zeus_" + str, jSONObject);
    }

    public static void a() {
        List<Pair<String, JSONObject>> list = f8055c;
        if (list.size() <= 0) {
            return;
        }
        try {
            for (Pair<String, JSONObject> pair : list) {
                if (pair != null) {
                    d((String) pair.first, (JSONObject) pair.second);
                }
            }
            f8055c.clear();
        } catch (Exception unused) {
        }
    }

    public static void a(AdConfig adConfig) {
        String str;
        if (adConfig == null) {
            return;
        }
        Map<String, String> map = f8053a;
        map.put("appid", adConfig.getAppId());
        int pluginUpdateConfig = adConfig.getPluginUpdateConfig();
        if (pluginUpdateConfig != 0) {
            str = pluginUpdateConfig + "";
        } else {
            str = "2";
        }
        map.put("plugin_update_conf", str);
        TTCustomController customController = adConfig.getCustomController();
        if (customController != null) {
            try {
                map.put(AdKeys.OAID, customController.getDevOaid());
                map.put("imei", customController.getDevImei());
            } catch (Exception unused) {
            }
        }
    }
}
