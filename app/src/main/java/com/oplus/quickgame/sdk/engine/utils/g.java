package com.oplus.quickgame.sdk.engine.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.oplus.quickgame.sdk.engine.callback.Callback;
import com.oplus.quickgame.sdk.engine.observer.RequestObserver;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.umeng.analytics.AnalyticsConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: a */
    public static String f16228a = "xgame_hap_game_cache_manage";

    /* renamed from: b */
    public static String f16229b = "action_game_cache";

    /* renamed from: c */
    public static String f16230c = "action_query_game_cache";

    /* renamed from: d */
    public static String f16231d = "action_delete_game_cache";

    /* renamed from: e */
    public static String f16232e = "action_query_game_pkg_list";

    /* renamed from: f */
    public static String f16233f = "action_delete_one_game_cache";

    static final class a extends Callback {
        a() {
        }

        @Override // com.oplus.quickgame.sdk.engine.callback.Callback
        public void onResponse(Callback.Response response) {
            i.a("GameUtil", "wrapCallback onResponse=" + response);
        }
    }

    private static class b extends Callback {

        /* renamed from: a */
        private Callback f16234a;

        /* renamed from: b */
        private Context f16235b;

        /* renamed from: c */
        private String f16236c;

        /* renamed from: d */
        private Map<String, String> f16237d;

        public b(Context context, String str, Callback callback, Map<String, String> map) {
            this.f16234a = callback;
            this.f16235b = context;
            this.f16236c = str;
            this.f16237d = map;
        }

        @Override // com.oplus.quickgame.sdk.engine.callback.Callback
        public void onResponse(Callback.Response response) {
            if (response != null && response.getCode() == 1) {
                try {
                    i.b("GameUtil", "wrapper onResponse " + response);
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(c.a("Y29tLmhleXRhcC54Z2FtZQ=="), c.a("Y29tLm5lYXJtZS5pbnN0YW50LnF1aWNrZ2FtZS5hY3Rpdml0eS5HYW1lVHJhbnNmZXJBY3Rpdml0eQ==")));
                    intent.putExtra("req_uri", this.f16236c);
                    intent.putExtra("tsf_key", this.f16237d.get("tsf_key"));
                    Context context = this.f16235b;
                    if (context instanceof Activity) {
                        i.b("task_info", "router task id is " + ((Activity) context).getTaskId());
                    } else {
                        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                    }
                    if (this.f16237d.containsKey("in_one_task") && "1".equals(this.f16237d.get("in_one_task"))) {
                        intent.putExtra("in_one_task", this.f16237d.get("in_one_task"));
                    } else {
                        if (!this.f16237d.containsKey("in_tsf") || !"1".equals(this.f16237d.get("in_tsf"))) {
                            throw new IllegalArgumentException("invalid launch mode.");
                        }
                        intent.putExtra("in_tsf", this.f16237d.get("in_tsf"));
                    }
                    this.f16235b.startActivity(intent);
                } catch (Exception e2) {
                    i.b("GameUtil", "wrapper onResponse ex:" + e2.getMessage());
                    response = new Callback.Response();
                    response.setCode(-4);
                    response.setMsg("start transform page failed");
                }
            }
            Callback callback = this.f16234a;
            if (callback != null) {
                callback.onResponse(response);
            }
        }
    }

    public static Callback a(Context context, String str, Callback callback, Map<String, String> map) {
        if (callback == null) {
            callback = new a();
        }
        return new b(context, str, callback, map);
    }

    public static String a() {
        return System.currentTimeMillis() + "_" + new Random().nextInt();
    }

    public static void a(Context context, Callback callback, String str, String str2) {
        synchronized (g.class) {
            try {
                ContentValues contentValues = new ContentValues();
                Uri parse = Uri.parse("content://" + f16228a);
                contentValues.put("req_url", f.a(context, str2, parse.toString()));
                contentValues.put("origin", str);
                contentValues.put(f16229b, f16231d);
                context.getContentResolver().registerContentObserver(parse, false, new RequestObserver(context, null, callback, parse));
                context.getContentResolver().insert(parse, contentValues);
            } catch (Throwable th) {
                a(callback, th, th.getMessage().contains("Failed to find provider") ? -16 : -4);
            }
        }
    }

    public static void a(Context context, Callback callback, String str, String str2, String str3) {
        synchronized (g.class) {
            try {
                ContentValues contentValues = new ContentValues();
                Uri parse = Uri.parse("content://" + f16228a);
                contentValues.put("req_url", f.a(context, str2, parse.toString()));
                contentValues.put("origin", str);
                contentValues.put(f16229b, f16233f);
                contentValues.put("game_cache_pkg_name", str3);
                context.getContentResolver().registerContentObserver(parse, false, new RequestObserver(context, null, callback, parse));
                context.getContentResolver().insert(parse, contentValues);
            } catch (Throwable th) {
                a(callback, th, th.getMessage().contains("Failed to find provider") ? -16 : -4);
            }
        }
    }

    private static void a(Callback callback, Throwable th, int i2) {
        Callback.Response response = new Callback.Response();
        response.setCode(i2);
        response.setMsg(th.getMessage());
        callback.onResponse(response);
    }

    public static boolean a(Context context, String str, Map<String, String> map) {
        return str != null && str.startsWith("hap://game") && n.d(context) >= 1003;
    }

    public static void b(Context context, Callback callback, String str, String str2) {
        synchronized (g.class) {
            try {
                ContentValues contentValues = new ContentValues();
                Uri parse = Uri.parse("content://" + f16228a);
                contentValues.put("req_url", f.a(context, str2, parse.toString()));
                contentValues.put("origin", str);
                contentValues.put(f16229b, f16230c);
                context.getContentResolver().registerContentObserver(parse, false, new RequestObserver(context, null, callback, parse));
                context.getContentResolver().insert(parse, contentValues);
            } catch (Throwable th) {
                a(callback, th, th.getMessage().contains("Failed to find provider") ? -16 : -4);
            }
        }
    }

    public static boolean b(Context context, String str, Map<String, String> map) {
        if (str != null && str.startsWith("hap://game") && n.d(context) >= 1001) {
            if (map != null && "1".equals(map.get("in_one_task"))) {
                return true;
            }
            try {
                if ("1".equals(Uri.parse(str).getQueryParameter("in_one_task"))) {
                    return true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static void c(Context context, Callback callback, String str, String str2) {
        synchronized (g.class) {
            try {
                ContentValues contentValues = new ContentValues();
                Uri parse = Uri.parse("content://" + f16228a);
                contentValues.put("req_url", f.a(context, str2, parse.toString()));
                contentValues.put("origin", str);
                contentValues.put(f16229b, f16232e);
                context.getContentResolver().registerContentObserver(parse, false, new RequestObserver(context, null, callback, parse));
                context.getContentResolver().insert(parse, contentValues);
            } catch (Throwable th) {
                a(callback, th, th.getMessage().contains("Failed to find provider") ? -16 : -4);
            }
        }
    }

    public static void d(Context context, Callback callback, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        Uri parse = Uri.parse("content://" + f16228a);
        contentValues.put("req_url", f.a(context, str2, parse.toString()));
        contentValues.put("origin", str);
        contentValues.put(f16229b, "action_upload_error_log");
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            jSONObject.put("id", "xgame_test_report_" + new SimpleDateFormat("HH:mm:ss").format(new Date(currentTimeMillis)).replaceAll(":", ""));
            jSONObject.put(AnalyticsConfig.RTD_START_TIME, currentTimeMillis - TTAdConstant.AD_MAX_EVENT_TIME);
            jSONObject.put("endTime", currentTimeMillis);
            jSONObject.put("useWifi", false);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        contentValues.put("action_game_cache_params", jSONObject.toString());
        context.getContentResolver().registerContentObserver(parse, false, new RequestObserver(context, null, callback, parse));
        context.getContentResolver().insert(parse, contentValues);
    }
}
