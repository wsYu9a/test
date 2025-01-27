package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class dz implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.a.kwai.a> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.webview.a.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("Access-Control-Allow-Origin");
        aVar.apS = optString;
        if (optString == JSONObject.NULL) {
            aVar.apS = "";
        }
        String optString2 = jSONObject.optString("Timing-Allow-Origin");
        aVar.apT = optString2;
        if (optString2 == JSONObject.NULL) {
            aVar.apT = "";
        }
        String optString3 = jSONObject.optString("content-type");
        aVar.apU = optString3;
        if (optString3 == JSONObject.NULL) {
            aVar.apU = "";
        }
        String optString4 = jSONObject.optString("Date");
        aVar.apV = optString4;
        if (optString4 == JSONObject.NULL) {
            aVar.apV = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.webview.a.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.apS;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Access-Control-Allow-Origin", aVar.apS);
        }
        String str2 = aVar.apT;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Timing-Allow-Origin", aVar.apT);
        }
        String str3 = aVar.apU;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "content-type", aVar.apU);
        }
        String str4 = aVar.apV;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Date", aVar.apV);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.a.kwai.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.a.kwai.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
