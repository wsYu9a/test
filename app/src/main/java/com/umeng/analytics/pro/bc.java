package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class bc {

    /* renamed from: a */
    private static String f23520a;

    public static JSONObject a(Context context) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            if (TextUtils.isEmpty(f23520a)) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("appkey", UMUtils.getAppkey(context));
                jSONObject3.put("channel", UMUtils.getChannel(context));
                jSONObject3.put(com.baidu.mobads.sdk.internal.bm.f6905j, Build.BRAND);
                jSONObject3.put("osVersion", Build.VERSION.RELEASE);
                jSONObject3.put(bt.f23611g, UMUtils.getUMId(context));
                jSONObject3.put(bt.al, UMUtils.getZid(context));
                jSONObject3.put("deviceModel", Build.MODEL);
                jSONObject3.put("platform", "Android");
                jSONObject3.put("appVersion", DeviceConfig.getAppVersionName(context));
                jSONObject3.put(b7.b.f1305b0, "9.7.9");
                f23520a = jSONObject3.toString();
                jSONObject = new JSONObject(f23520a);
            } else {
                try {
                    jSONObject = new JSONObject(f23520a);
                } catch (Exception unused) {
                }
            }
            jSONObject2 = jSONObject;
            jSONObject2.put("sessionid", DeviceConfig.getSid(context));
            jSONObject2.put("ts", System.currentTimeMillis());
        } catch (Throwable unused2) {
        }
        return jSONObject2;
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            try {
                jSONObject.put("ekverr", jSONObject2);
            } catch (Throwable unused) {
            }
        }
    }
}
