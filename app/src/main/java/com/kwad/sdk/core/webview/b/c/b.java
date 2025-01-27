package com.kwad.sdk.core.webview.b.c;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.utils.x;
import hf.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b {
    public static final Map<String, JSONObject> aIS = new HashMap();
    public static boolean aIT = true;

    public static class a {
        public String msg;
    }

    public static void a(com.kwad.sdk.g.a.b bVar, int i10) {
        com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, new HybridLoadMsg().setSceneId(bVar.aMy).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(i10).setPackageUrl(bVar.packageUrl).setInterval(String.valueOf(System.currentTimeMillis() - bVar.Kj())));
    }

    public static void ae(String str, String str2) {
        x.putValue(fg(str), "c_" + str2, System.currentTimeMillis());
    }

    private static void af(String str, String str2) {
        a(str, str2, 1, "");
    }

    public static void ag(String str, String str2) {
        a(str, "", 2, str2);
    }

    public static void c(String str, String str2, String str3) {
        if (str3.contains("/")) {
            str3 = str3.substring(str3.lastIndexOf("/") + 1);
        }
        x.putValue(fg(str), "c_responseStart_" + str2 + e.f26694a + str3, System.currentTimeMillis());
    }

    public static void d(String str, String str2, String str3) {
        if (str3.contains("/")) {
            str3 = str3.substring(str3.lastIndexOf("/") + 1);
        }
        x.putValue(fg(str), "c_responseEnd_" + str2 + e.f26694a + str3, System.currentTimeMillis());
    }

    private static JSONObject fg(String str) {
        Map<String, JSONObject> map = aIS;
        JSONObject jSONObject = map.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        map.put(str, jSONObject2);
        return jSONObject2;
    }

    private static void fh(String str) {
        aIS.remove(str);
    }

    public static void fi(String str) {
        JSONObject fg2 = fg(str);
        long IM = com.kwad.sdk.core.webview.b.a.IL().IM();
        long currentTimeMillis = IM <= 0 ? -1L : System.currentTimeMillis() - IM;
        x.putValue(fg2, "c_loadUrl", System.currentTimeMillis());
        x.putValue(fg2, "c_init_interval", currentTimeMillis);
        x.putValue(fg2, "c_init_state", aIT ? 1 : 2);
        aIT = false;
    }

    public static void a(com.kwad.sdk.g.a.b bVar, int i10, int i11, String str) {
        com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.ERROR_LOG, new HybridLoadMsg().setSceneId(bVar.aMy).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(0).setPackageUrl(bVar.packageUrl).setFailState(i11).setInterval(String.valueOf(System.currentTimeMillis() - bVar.Kj())).setFailReason(str));
    }

    public static void a(String str, String str2, int i10, String str3, long j10) {
        String str4;
        if (i10 == 2) {
            str4 = ILoggerReporter.Category.ERROR_LOG;
        } else {
            str4 = ILoggerReporter.Category.APM_LOG;
        }
        if (j10 > 60000 || j10 < 0) {
            j10 = -1;
        }
        com.kwad.sdk.commercial.b.b(str4, new HybridLoadMsg().setSceneId(str2).setUrl(str).setState(i10).setInterval(String.valueOf(j10)).setFailReason(str3));
    }

    public static void a(String str, String str2, String str3, String str4) {
        JSONObject fg2 = fg(str2);
        x.putValue(fg2, "c_" + str3, System.currentTimeMillis());
        if (str3.equals("pageStatus")) {
            try {
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str4);
                    int optInt = jSONObject.optInt("status");
                    String optString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG, "");
                    String optString2 = jSONObject.optString("webViewCostParams", "");
                    if (!TextUtils.isEmpty(optString2)) {
                        JSONObject jSONObject2 = new JSONObject(optString2);
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            fg2.put(next, jSONObject2.opt(next));
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        if (optInt == 1) {
                            af(str, str2);
                        } else {
                            ag(str, optString);
                        }
                    }
                    fh(str2);
                } catch (Exception e10) {
                    com.kwad.sdk.core.d.c.printStackTrace(e10);
                    fh(str2);
                }
            } catch (Throwable th2) {
                fh(str2);
                throw th2;
            }
        }
    }

    private static void a(String str, String str2, int i10, String str3) {
        long currentTimeMillis;
        String str4;
        JSONObject jSONObject = aIS.get(str2);
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
        if (i10 == 2) {
            str4 = ILoggerReporter.Category.ERROR_LOG;
        } else {
            str4 = ILoggerReporter.Category.APM_LOG;
        }
        com.kwad.sdk.commercial.b.a(str4, new WebViewLoadMsg().setUrl(str).setState(i10).setCostTime(jSONObject != null ? jSONObject.toString() : "").setInterval(String.valueOf(currentTimeMillis)).setFailReason(str3));
        fh(str2);
    }
}
