package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class jl implements com.kwad.sdk.core.d<WebViewLoadMsg> {
    /* renamed from: a */
    private static void a2(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url");
        webViewLoadMsg.url = optString;
        if (optString == JSONObject.NULL) {
            webViewLoadMsg.url = "";
        }
        webViewLoadMsg.state = jSONObject.optInt("state");
        String optString2 = jSONObject.optString(com.umeng.analytics.pro.am.aU);
        webViewLoadMsg.interval = optString2;
        if (optString2 == JSONObject.NULL) {
            webViewLoadMsg.interval = "";
        }
        String optString3 = jSONObject.optString("fail_reason");
        webViewLoadMsg.failReason = optString3;
        if (optString3 == JSONObject.NULL) {
            webViewLoadMsg.failReason = "";
        }
        String optString4 = jSONObject.optString("cost_time");
        webViewLoadMsg.costTime = optString4;
        if (optString4 == JSONObject.NULL) {
            webViewLoadMsg.costTime = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = webViewLoadMsg.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", webViewLoadMsg.url);
        }
        int i2 = webViewLoadMsg.state;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "state", i2);
        }
        String str2 = webViewLoadMsg.interval;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.umeng.analytics.pro.am.aU, webViewLoadMsg.interval);
        }
        String str3 = webViewLoadMsg.failReason;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fail_reason", webViewLoadMsg.failReason);
        }
        String str4 = webViewLoadMsg.costTime;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cost_time", webViewLoadMsg.costTime);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        a2(webViewLoadMsg, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        return b2(webViewLoadMsg, jSONObject);
    }
}
