package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ao {

    /* renamed from: a */
    private static JSONObject f23437a;

    public static JSONObject a(Context context, JSONArray jSONArray, String str) {
        JSONObject jSONObject = f23437a;
        if (jSONObject != null && jSONObject.length() > 0) {
            return f23437a;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(bt.f23628x, "Android");
            jSONObject2.put(com.kuaishou.weapon.p0.t.f11222v, Build.MODEL);
            jSONObject2.put(n3.a.f28757w, DeviceConfig.getAppVersionName(context));
            jSONObject2.put(bt.f23611g, UMUtils.getUMId(context));
            jSONObject2.put("ov", Build.VERSION.RELEASE);
            jSONObject2.put("chn", UMUtils.getChannel(context));
            jSONObject2.put(bt.al, UMUtils.getZid(context));
            jSONObject2.put(n3.a.f28754t, "9.7.9");
            jSONObject2.put("ak", UMUtils.getAppkey(context));
            String idfa = DeviceConfig.getIdfa(context);
            if (!TextUtils.isEmpty(idfa)) {
                jSONObject2.put("tk_idfa", idfa);
            }
            jSONObject2.put("db", Build.BRAND);
            jSONObject2.put("tk_aid", DeviceConfig.getAndroidId(context));
            String oaid = DeviceConfig.getOaid(context);
            if (!TextUtils.isEmpty(oaid)) {
                jSONObject2.put("tk_oaid", oaid);
            }
            String imeiNew = DeviceConfig.getImeiNew(context);
            if (!TextUtils.isEmpty(imeiNew)) {
                jSONObject2.put("tk_imei", imeiNew);
            }
            jSONObject2.put("boa", Build.BOARD);
            jSONObject2.put("mant", Build.TIME);
            String[] localeInfo = DeviceConfig.getLocaleInfo(context);
            jSONObject2.put("ct", localeInfo[0]);
            jSONObject2.put("lang", localeInfo[1]);
            jSONObject2.put("tz", DeviceConfig.getTimeZone(context));
            jSONObject2.put("pkg", DeviceConfig.getPackageName(context));
            jSONObject2.put("disn", DeviceConfig.getAppName(context));
            String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
            if ("Wi-Fi".equals(networkAccessMode[0])) {
                jSONObject2.put("ac", "wifi");
            } else if ("2G/3G".equals(networkAccessMode[0])) {
                jSONObject2.put("ac", "2G/3G");
            } else {
                jSONObject2.put("ac", "unknown");
            }
            if (!"".equals(networkAccessMode[1])) {
                jSONObject2.put("ast", networkAccessMode[1]);
            }
            jSONObject2.put("nt", DeviceConfig.getNetworkType(context));
            String deviceToken = UMUtils.getDeviceToken(context);
            if (!TextUtils.isEmpty(deviceToken)) {
                jSONObject2.put(bt.f23583a, deviceToken);
            }
            int[] resolutionArray = DeviceConfig.getResolutionArray(context);
            if (resolutionArray != null) {
                jSONObject2.put("rl", resolutionArray[1] + m5.h.f28447r + resolutionArray[0]);
            }
            jSONObject2.put("car", DeviceConfig.getNetworkOperatorName(context));
            jSONObject2.put(bt.f23595b, "9.7.9");
            if (DeviceConfig.isHarmony(context)) {
                jSONObject2.put("oos", "harmony");
            } else {
                jSONObject2.put("oos", "Android");
            }
            jSONObject2.put(com.umeng.ccg.a.f24241r, str);
            jSONObject2.put("sdk", jSONArray);
            f23437a = jSONObject2;
        } catch (Throwable unused) {
        }
        return f23437a;
    }

    public static JSONObject a(Context context, JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONObject jSONObject2;
        JSONObject jSONObject3 = null;
        try {
            jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            jSONObject2 = new JSONObject();
        } catch (Throwable unused) {
        }
        try {
            jSONObject2.put("ekv", jSONArray);
            return jSONObject2;
        } catch (Throwable unused2) {
            jSONObject3 = jSONObject2;
            return jSONObject3;
        }
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("header", jSONObject);
            jSONObject3.put("analytics", jSONObject2);
        } catch (Throwable unused) {
        }
        return jSONObject3;
    }

    public static JSONObject a(Context context, String str) {
        JSONObject jSONObject = null;
        try {
            an anVar = new an();
            String uMId = UMUtils.getUMId(context);
            if (TextUtils.isEmpty(uMId)) {
                return null;
            }
            anVar.a(uMId);
            String appkey = UMUtils.getAppkey(context);
            if (TextUtils.isEmpty(appkey)) {
                return null;
            }
            anVar.b(appkey);
            anVar.c(UMUtils.getAppVersionName(context));
            anVar.d("9.7.9");
            anVar.e(UMUtils.getChannel(context));
            anVar.f(Build.VERSION.SDK_INT + "");
            anVar.g(Build.BRAND);
            anVar.h(Build.MODEL);
            String[] localeInfo = DeviceConfig.getLocaleInfo(context);
            anVar.i(localeInfo[1]);
            anVar.j(localeInfo[0]);
            int[] resolutionArray = DeviceConfig.getResolutionArray(context);
            anVar.b(Integer.valueOf(resolutionArray[1]));
            anVar.a(Integer.valueOf(resolutionArray[0]));
            anVar.k(as.a(context, "install_datetime", ""));
            try {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(an.f23411a, anVar.a());
                    jSONObject2.put(an.f23413c, anVar.c());
                    jSONObject2.put(an.f23412b, anVar.b());
                    jSONObject2.put(an.f23414d, anVar.d());
                    jSONObject2.put(an.f23415e, anVar.e());
                    jSONObject2.put(an.f23416f, anVar.f());
                    jSONObject2.put(an.f23417g, anVar.g());
                    jSONObject2.put(an.f23418h, anVar.h());
                    jSONObject2.put(an.f23421k, anVar.k());
                    jSONObject2.put(an.f23420j, anVar.j());
                    jSONObject2.put(an.f23422l, anVar.l());
                    jSONObject2.put(an.f23419i, anVar.i());
                    jSONObject2.put(an.f23423m, anVar.m());
                    jSONObject2.put(bt.al, UMUtils.getZid(context));
                    jSONObject2.put("platform", "android");
                    jSONObject2.put("optional", new JSONObject(as.a()));
                    String[] split = str.split("@");
                    if (split.length == 4) {
                        try {
                            long parseLong = Long.parseLong(split[0]);
                            String str2 = split[1];
                            jSONObject2.put("s1", parseLong);
                            jSONObject2.put("s2", str2);
                        } catch (Throwable unused) {
                        }
                    }
                    try {
                        String str3 = Build.BRAND;
                        String a10 = at.a(str3);
                        String b10 = at.b(str3);
                        if (!TextUtils.isEmpty(a10) && !TextUtils.isEmpty(b10)) {
                            jSONObject2.put(an.f23424n, a10);
                            jSONObject2.put(an.f23425o, b10);
                        } else {
                            jSONObject2.put(an.f23424n, "Android");
                            jSONObject2.put(an.f23425o, Build.VERSION.RELEASE);
                        }
                    } catch (Throwable unused2) {
                    }
                    return jSONObject2;
                } catch (JSONException e10) {
                    e = e10;
                    jSONObject = jSONObject2;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + e.getMessage());
                    return jSONObject;
                } catch (Throwable th2) {
                    th = th2;
                    jSONObject = jSONObject2;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + th.getMessage());
                    return jSONObject;
                }
            } catch (JSONException e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static JSONObject a(Context context, int i10, JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (Throwable unused) {
        }
        try {
            String zid = UMUtils.getZid(context);
            if (TextUtils.isEmpty(zid)) {
                return jSONObject;
            }
            jSONObject.put("atoken", zid);
            String deviceToken = UMUtils.getDeviceToken(context);
            if (!TextUtils.isEmpty(deviceToken)) {
                jSONObject.put("device_token", deviceToken);
            }
            jSONObject.put(com.baidu.mobads.sdk.internal.bm.f6904i, Build.MODEL);
            jSONObject.put(bt.f23628x, "android");
            jSONObject.put(bt.f23629y, Build.VERSION.RELEASE);
            jSONObject.put(com.umeng.ccg.a.f24241r, str);
            jSONObject.put("sdk", jSONArray);
            jSONObject.put(com.kwad.sdk.m.e.TAG, i10);
            return jSONObject;
        } catch (Throwable unused2) {
            jSONObject2 = jSONObject;
            return jSONObject2;
        }
    }
}
