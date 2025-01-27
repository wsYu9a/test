package com.kwad.sdk.core.webview.a.b;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.utils.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b {
    public static final Map<String, JSONObject> aqb = new HashMap();
    public static boolean aqc = true;

    public static class a {
        public String msg;
    }

    public static void O(String str, String str2) {
        t.putValue(dl(str), "c_" + str2, System.currentTimeMillis());
    }

    private static void P(String str, String str2) {
        a(str, str2, 1, "");
    }

    public static void Q(String str, String str2) {
        a(str, "", 2, str2);
    }

    public static void a(com.kwad.sdk.f.kwai.b bVar, int i2) {
        KSLoggerReporter.a(ILoggerReporter.Category.APM_LOG, new HybridLoadMsg().setSceneId(bVar.atm).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(i2).setPackageUrl(bVar.packageUrl).setInterval(String.valueOf(System.currentTimeMillis() - bVar.Az())));
    }

    public static void a(com.kwad.sdk.f.kwai.b bVar, int i2, int i3, String str) {
        KSLoggerReporter.a(ILoggerReporter.Category.ERROR_LOG, new HybridLoadMsg().setSceneId(bVar.atm).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(0).setPackageUrl(bVar.packageUrl).setFailState(i3).setInterval(String.valueOf(System.currentTimeMillis() - bVar.Az())).setFailReason(str));
    }

    private static void a(String str, String str2, int i2, String str3) {
        long currentTimeMillis;
        JSONObject jSONObject = aqb.get(str2);
        if (jSONObject == null) {
            currentTimeMillis = -3;
        } else {
            long optLong = jSONObject.optLong("c_loadUrl");
            if (optLong <= 0) {
                currentTimeMillis = -2;
            } else {
                currentTimeMillis = System.currentTimeMillis() - optLong;
                if (currentTimeMillis > 100000 || currentTimeMillis < 0) {
                    currentTimeMillis = -1;
                }
            }
        }
        KSLoggerReporter.a(i2 == 2 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG, new WebViewLoadMsg().setUrl(str).setState(i2).setCostTime(jSONObject != null ? jSONObject.toString() : "").setInterval(String.valueOf(currentTimeMillis)).setFailReason(str3));
        dm(str2);
    }

    public static void a(String str, String str2, int i2, String str3, long j2) {
        String str4 = i2 == 2 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG;
        if (j2 > 60000 || j2 < 0) {
            j2 = -1;
        }
        KSLoggerReporter.b(str4, new HybridLoadMsg().setSceneId(str2).setUrl(str).setState(i2).setInterval(String.valueOf(j2)).setFailReason(str3));
    }

    public static void a(String str, String str2, String str3, String str4) {
        JSONObject dl = dl(str2);
        t.putValue(dl, "c_" + str3, System.currentTimeMillis());
        if (str3.equals("pageStatus")) {
            try {
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(str4);
                int optInt = jSONObject.optInt("status");
                String optString = jSONObject.optString("errorMsg", "");
                String optString2 = jSONObject.optString("webViewCostParams", "");
                if (!TextUtils.isEmpty(optString2)) {
                    JSONObject jSONObject2 = new JSONObject(optString2);
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        dl.put(next, jSONObject2.opt(next));
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    if (optInt == 1) {
                        P(str, str2);
                    } else {
                        Q(str, optString);
                    }
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            } finally {
                dm(str2);
            }
        }
    }

    public static void b(String str, String str2, String str3) {
        if (str3.contains("/")) {
            str3 = str3.substring(str3.lastIndexOf("/") + 1);
        }
        t.putValue(dl(str), "c_responseStart_" + str2 + "_" + str3, System.currentTimeMillis());
    }

    public static void c(String str, String str2, String str3) {
        if (str3.contains("/")) {
            str3 = str3.substring(str3.lastIndexOf("/") + 1);
        }
        t.putValue(dl(str), "c_responseEnd_" + str2 + "_" + str3, System.currentTimeMillis());
    }

    private static JSONObject dl(String str) {
        Map<String, JSONObject> map = aqb;
        JSONObject jSONObject = map.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        map.put(str, jSONObject2);
        return jSONObject2;
    }

    private static void dm(String str) {
        aqb.remove(str);
    }

    public static void dn(String str) {
        JSONObject dl = dl(str);
        long zb = com.kwad.sdk.core.webview.a.a.za().zb();
        long currentTimeMillis = zb <= 0 ? -1L : System.currentTimeMillis() - zb;
        t.putValue(dl, "c_loadUrl", System.currentTimeMillis());
        t.putValue(dl, "c_init_interval", currentTimeMillis);
        t.putValue(dl, "c_init_state", aqc ? 1 : 2);
        aqc = false;
    }
}
