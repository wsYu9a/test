package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class jk implements com.kwad.sdk.core.d<WebViewCommercialMsg> {
    /* renamed from: a */
    private static void a2(WebViewCommercialMsg webViewCommercialMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("category");
        webViewCommercialMsg.category = optString;
        if (optString == JSONObject.NULL) {
            webViewCommercialMsg.category = "";
        }
        String optString2 = jSONObject.optString("tag");
        webViewCommercialMsg.tag = optString2;
        if (optString2 == JSONObject.NULL) {
            webViewCommercialMsg.tag = "";
        }
        webViewCommercialMsg.msg = jSONObject.optJSONObject("msg");
        webViewCommercialMsg.extraParam = jSONObject.optJSONObject("extraParam");
        String optString3 = jSONObject.optString("event_id");
        webViewCommercialMsg.eventId = optString3;
        if (optString3 == JSONObject.NULL) {
            webViewCommercialMsg.eventId = "";
        }
        webViewCommercialMsg.rate = jSONObject.optDouble("rate");
        String optString4 = jSONObject.optString("suffixRatio");
        webViewCommercialMsg.suffixRatio = optString4;
        if (optString4 == JSONObject.NULL) {
            webViewCommercialMsg.suffixRatio = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(WebViewCommercialMsg webViewCommercialMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = webViewCommercialMsg.category;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "category", webViewCommercialMsg.category);
        }
        String str2 = webViewCommercialMsg.tag;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tag", webViewCommercialMsg.tag);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "msg", webViewCommercialMsg.msg);
        com.kwad.sdk.utils.t.putValue(jSONObject, "extraParam", webViewCommercialMsg.extraParam);
        String str3 = webViewCommercialMsg.eventId;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "event_id", webViewCommercialMsg.eventId);
        }
        double d2 = webViewCommercialMsg.rate;
        if (d2 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rate", d2);
        }
        String str4 = webViewCommercialMsg.suffixRatio;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "suffixRatio", webViewCommercialMsg.suffixRatio);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebViewCommercialMsg webViewCommercialMsg, JSONObject jSONObject) {
        a2(webViewCommercialMsg, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebViewCommercialMsg webViewCommercialMsg, JSONObject jSONObject) {
        return b2(webViewCommercialMsg, jSONObject);
    }
}
