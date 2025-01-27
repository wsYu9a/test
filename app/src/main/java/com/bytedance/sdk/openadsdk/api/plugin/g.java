package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.sdk.internal.bj;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.api.plugin.lg;
import com.heytap.mcssdk.n.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class g {

    /* renamed from: i */
    private static SharedPreferences f6373i;
    private static ScheduledExecutorService zx = Executors.newSingleThreadScheduledExecutor(new lg.zx("tt_pangle_thread_pl_report"));

    /* renamed from: g */
    private static final List<Pair<String, JSONObject>> f6372g = new ArrayList();

    /* renamed from: j */
    static final Map<String, String> f6374j = new HashMap();
    private static volatile boolean q = false;

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.g$1 */
    static class AnonymousClass1 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ String f6375j;
        final /* synthetic */ JSONObject zx;

        AnonymousClass1(String str, JSONObject jSONObject) {
            str = str;
            jSONObject = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(g.gv(str, jSONObject));
            g.i(arrayList);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.g$2 */
    static class AnonymousClass2 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ List f6376j;

        AnonymousClass2(List list) {
            list = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.i(list);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.g$3 */
    static class AnonymousClass3 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ Bundle f6377j;

        AnonymousClass3(Bundle bundle) {
            bundle = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle bundle = bundle;
            if (bundle == null) {
                return;
            }
            try {
                String string = bundle.getString("event_name");
                String string2 = bundle.getString("event_extra");
                JSONObject jSONObject = TextUtils.isEmpty(string2) ? new JSONObject() : new JSONObject(string2);
                ArrayList arrayList = new ArrayList();
                arrayList.add(g.gv(string, jSONObject));
                g.i(arrayList);
            } catch (Exception unused) {
            }
        }
    }

    public static JSONObject gv(String str, JSONObject jSONObject) {
        String str2 = "5.2.0.5";
        JSONObject jSONObject2 = new JSONObject();
        try {
            int i2 = Build.VERSION.SDK_INT;
            jSONObject.put("os_api", i2);
            jSONObject.put("support_abi", Arrays.toString(i2 >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2}));
            jSONObject2.put("ad_sdk_version", "5.2.0.5");
            String j2 = gv.j("com.byted.pangle");
            if (!TextUtils.isEmpty(j2)) {
                str2 = j2;
            }
            jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, str2);
            jSONObject2.put("timestamp", System.currentTimeMillis() / 1000);
            jSONObject2.put("is_plugin", true);
            jSONObject2.put("event_extra", jSONObject.toString());
            jSONObject2.put("type", str);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(bj.f5604i, Build.MODEL);
            jSONObject3.put("vendor", Build.MANUFACTURER);
            Map<String, String> map = f6374j;
            jSONObject3.put("imei", map.get("imei"));
            jSONObject3.put("oaid", map.get("oaid"));
            jSONObject2.put("device_info", jSONObject3);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public static void i(String str, JSONObject jSONObject) {
        f6372g.add(new Pair<>(str, jSONObject));
    }

    public static void j(Context context) {
        f6373i = context.getSharedPreferences("tt_sdk_settings_other", 0);
    }

    private static void q(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager == null) {
            zx(str, jSONObject);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 1);
        bundle.putString("event_name", str);
        bundle.putString("event_extra", jSONObject.toString());
        adManager.getExtra(Bundle.class, bundle);
    }

    public static void i(List<JSONObject> list) {
        if (list == null) {
            return;
        }
        SharedPreferences sharedPreferences = f6373i;
        String format = String.format("https://%s%s", sharedPreferences != null ? sharedPreferences.getString("url_alog", "api-access.pangolin-sdk-toutiao.com") : "api-access.pangolin-sdk-toutiao.com", "/api/ad/union/sdk/stats/batch/");
        JSONObject jSONObject = new JSONObject();
        try {
            List<Pair<String, JSONObject>> list2 = f6372g;
            if (list2.size() > 0) {
                Iterator<Pair<String, JSONObject>> it = list2.iterator();
                while (it.hasNext()) {
                    Pair<String, JSONObject> next = it.next();
                    list.add(gv((String) next.first, (JSONObject) next.second));
                    it.remove();
                }
            }
            jSONObject.put("stats_list", new JSONArray((Collection) list));
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.api.plugin.j.i.j().j(true, format, com.bytedance.sdk.openadsdk.api.plugin.zx.zx.j(jSONObject).toString().getBytes());
    }

    public static final void j(int i2, String str, long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("duration", Long.valueOf(j2));
            jSONObject.putOpt("code", Integer.valueOf(i2));
            jSONObject.putOpt(d.l, str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        q("plugin_load_failed", jSONObject);
    }

    public static final void zx(int i2, String str, long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("duration", Long.valueOf(j2));
            jSONObject.putOpt("code", Integer.valueOf(i2));
            jSONObject.putOpt(d.l, str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zx("plugin_load_failed", jSONObject);
    }

    public static void j(String str, JSONObject jSONObject) {
        q("zeus_" + str, jSONObject);
    }

    public static void zx(String str, JSONObject jSONObject) {
        if (q) {
            return;
        }
        zx.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.g.1

            /* renamed from: j */
            final /* synthetic */ String f6375j;
            final /* synthetic */ JSONObject zx;

            AnonymousClass1(String str2, JSONObject jSONObject2) {
                str = str2;
                jSONObject = jSONObject2;
            }

            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(g.gv(str, jSONObject));
                g.i(arrayList);
            }
        });
    }

    public static void j() {
        if (q) {
            return;
        }
        try {
            q = true;
            zx.shutdown();
        } catch (Throwable unused) {
        }
    }

    public static void j(List<JSONObject> list) {
        if (q) {
            return;
        }
        if (list != null && list.isEmpty() && f6372g.isEmpty()) {
            return;
        }
        zx.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.g.2

            /* renamed from: j */
            final /* synthetic */ List f6376j;

            AnonymousClass2(List list2) {
                list = list2;
            }

            @Override // java.lang.Runnable
            public void run() {
                g.i(list);
            }
        });
    }

    public static void j(Bundle bundle) {
        if (q) {
            return;
        }
        zx.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.g.3

            /* renamed from: j */
            final /* synthetic */ Bundle f6377j;

            AnonymousClass3(Bundle bundle2) {
                bundle = bundle2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle2 = bundle;
                if (bundle2 == null) {
                    return;
                }
                try {
                    String string = bundle2.getString("event_name");
                    String string2 = bundle.getString("event_extra");
                    JSONObject jSONObject = TextUtils.isEmpty(string2) ? new JSONObject() : new JSONObject(string2);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(g.gv(string, jSONObject));
                    g.i(arrayList);
                } catch (Exception unused) {
                }
            }
        });
    }

    public static void j(AdConfig adConfig) {
        if (adConfig == null) {
            return;
        }
        Map<String, String> map = f6374j;
        map.put("appid", adConfig.getAppId());
        Object extra = adConfig.getExtra("plugin_update_conf");
        if (extra instanceof Integer) {
            String num = ((Integer) extra).toString();
            if (num == null) {
                num = "2";
            }
            map.put("plugin_update_conf", num);
        }
        TTCustomController customController = adConfig.getCustomController();
        if (customController != null) {
            try {
                map.put("oaid", customController.getDevOaid());
                map.put("imei", customController.getDevImei());
            } catch (Exception unused) {
            }
        }
    }
}
