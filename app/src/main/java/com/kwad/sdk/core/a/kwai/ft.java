package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ft implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.j> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url");
        jVar.url = optString;
        if (optString == JSONObject.NULL) {
            jVar.url = "";
        }
        String optString2 = jSONObject.optString("host");
        jVar.host = optString2;
        if (optString2 == JSONObject.NULL) {
            jVar.host = "";
        }
        jVar.httpCode = jSONObject.optInt("http_code");
        String optString3 = jSONObject.optString("error_msg");
        jVar.errorMsg = optString3;
        if (optString3 == JSONObject.NULL) {
            jVar.errorMsg = "";
        }
        String optString4 = jSONObject.optString("req_type");
        jVar.agz = optString4;
        if (optString4 == JSONObject.NULL) {
            jVar.agz = "";
        }
        jVar.agA = jSONObject.optInt("use_ip");
        String optString5 = jSONObject.optString("ok_http_version");
        jVar.agB = optString5;
        if (optString5 == JSONObject.NULL) {
            jVar.agB = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = jVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", jVar.url);
        }
        String str2 = jVar.host;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "host", jVar.host);
        }
        int i2 = jVar.httpCode;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "http_code", i2);
        }
        String str3 = jVar.errorMsg;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "error_msg", jVar.errorMsg);
        }
        String str4 = jVar.agz;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "req_type", jVar.agz);
        }
        int i3 = jVar.agA;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "use_ip", i3);
        }
        String str5 = jVar.agB;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ok_http_version", jVar.agB);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        a2(jVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        return b2(jVar, jSONObject);
    }
}
