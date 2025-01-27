package com.shu.priory.param;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.shu.priory.config.AdKeys;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.config.Version;
import com.shu.priory.utils.h;
import com.shu.priory.utils.l;
import com.sigmob.windad.WindAds;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class UploadData {

    /* renamed from: a */
    public static volatile Context f17173a;

    /* renamed from: b */
    private static volatile JSONObject f17174b;

    /* renamed from: c */
    private static volatile JSONObject f17175c;

    public static String getAdStatis() {
        try {
            boolean d10 = com.shu.priory.utils.e.d(f17173a, "dataToggle");
            if (f17173a == null || !d10) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("last_session_id", com.shu.priory.utils.e.c(f17173a, "sessionID"));
            jSONObject.put("last_adunit_id", com.shu.priory.utils.e.c(f17173a, "adUnitID"));
            jSONObject.put("last_req_duration", com.shu.priory.utils.e.b(f17173a, "reqDuration"));
            jSONObject.put("last_imp_duration", com.shu.priory.utils.e.b(f17173a, "impFailCnt"));
            jSONObject.put("last_clk_duration", com.shu.priory.utils.e.b(f17173a, "clkFailCnt"));
            jSONObject.put("req_fail_cnt", com.shu.priory.utils.e.b(f17173a, "reqFailCnt"));
            jSONObject.put("imp_fail_cnt", com.shu.priory.utils.e.b(f17173a, "impFailCnt"));
            jSONObject.put("clk_fail_cnt", com.shu.priory.utils.e.b(f17173a, "clkFailCnt"));
            return jSONObject.toString();
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "getAdStatis error " + th2.getMessage());
            return "";
        }
    }

    public static String getApiVer() {
        return "3.0.2";
    }

    public static String getAppInfo(AdParam adParam) {
        return a.a(adParam, f17173a);
    }

    public static String getCurrency(AdParam adParam) {
        if (adParam == null || adParam.getParameter(AdKeys.CURRENCY) == null) {
            return "";
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (String str : adParam.getStringParam(AdKeys.CURRENCY).split(",")) {
                jSONArray.put(str);
            }
            return jSONArray.toString();
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "getCurrency error " + th2.getMessage());
            return WindAds.CNY;
        }
    }

    public static String getDevice(AdParam adParam) {
        JSONObject jSONObject;
        if (f17173a == null) {
            return "";
        }
        try {
            if (f17174b == null) {
                f17174b = c.a(f17173a);
            }
            if (adParam != null && adParam.hasParam(bt.f23592ai)) {
                int intParam = adParam.getIntParam(bt.f23592ai);
                c.a(intParam);
                f17174b.put(bt.f23592ai, intParam);
            }
            if (TextUtils.isEmpty(f17174b.optString("imei")) && adParam != null && adParam.getBooleanParam(AdKeys.IS_IMEI_ALLOWED)) {
                String c10 = c.c(f17173a);
                f17174b.put("imei", c10);
                f17174b.put("imei_md5", com.shu.priory.utils.f.a(c10));
            }
            if (TextUtils.isEmpty(f17174b.optString("adid")) && adParam != null && adParam.getBooleanParam(AdKeys.IS_ANDROID_ID_ALLOWED)) {
                String b10 = c.b(f17173a);
                f17174b.put("adid", b10);
                f17174b.put("adid_md5", com.shu.priory.utils.f.a(b10));
            }
            if (adParam != null && adParam.getBooleanParam(AdKeys.IS_LOCATION_ALLOWED)) {
                adParam.getBooleanParam(AdKeys.IS_LOCATION_ALLOWED);
            }
            JSONObject geoInfo = getGeoInfo();
            if (geoInfo != null) {
                f17174b.put("geo", geoInfo);
            }
            f17174b.put("ts", System.currentTimeMillis());
            f17174b.put(bd.f23524d, c.d(f17173a));
            if (adParam != null) {
                String stringParam = adParam.getStringParam(AdKeys.OAID);
                if (TextUtils.isEmpty(stringParam)) {
                    stringParam = l.a().a(f17173a);
                    if (!TextUtils.isEmpty(stringParam)) {
                        jSONObject = f17174b;
                    }
                } else {
                    jSONObject = f17174b;
                }
                jSONObject.put(AdKeys.OAID, stringParam);
            } else if (Build.VERSION.SDK_INT >= 29) {
                l.a().a(f17173a);
            }
            if (adParam != null) {
                String stringParam2 = adParam.getStringParam(AdKeys.CUSTOM_PARAM);
                if (!TextUtils.isEmpty(stringParam2)) {
                    f17174b.put("cus", stringParam2);
                }
            }
            return f17174b.toString();
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "getDevice error " + th2.getMessage());
            return "";
        }
    }

    public static String getExt(AdParam adParam) {
        return (adParam == null || adParam.getParameter("ext") == null) ? "" : adParam.getParameter("ext").toString();
    }

    public static String getExtraInfo() {
        if (f17173a == null) {
            return "";
        }
        try {
            if (f17175c == null) {
                f17175c = d.a(f17173a);
            }
            f17175c.put("ba", d.b(f17173a));
            f17175c.put("ud", d.c());
            f17175c.put("uc", d.c(f17173a));
            return f17175c.toString().replaceAll("\"", "\\\\\"");
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "getDevice error " + th2.getMessage());
            return "";
        }
    }

    private static JSONObject getGeoInfo() {
        return null;
    }

    public static String getImps(AdParam adParam) {
        return adParam == null ? "" : f.a(adParam);
    }

    public static String getRequestID(AdParam adParam) {
        return adParam == null ? "" : adParam.getStringParam(AdKeys.REQUEST_ID);
    }

    public static String getSdkVer() {
        return Version.getVersion();
    }

    public static String getSettleType(AdParam adParam) {
        if (adParam == null) {
            return "0";
        }
        try {
            String stringParam = adParam.getStringParam(AdKeys.SETTLE_TYPE);
            return !TextUtils.isEmpty(stringParam) ? stringParam : "0";
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "getSettleType error " + th2.getMessage());
            return "";
        }
    }

    public static void initParam(Context context) {
        if (context != null) {
            f17173a = context.getApplicationContext();
        }
    }
}
