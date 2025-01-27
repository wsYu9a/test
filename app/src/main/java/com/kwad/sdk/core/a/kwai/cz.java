package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class cz implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.kwai.b> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.crash.online.monitor.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("appId");
        bVar.appId = optString;
        if (optString == JSONObject.NULL) {
            bVar.appId = "";
        }
        String optString2 = jSONObject.optString("pluginListenerName");
        bVar.asn = optString2;
        if (optString2 == JSONObject.NULL) {
            bVar.asn = "";
        }
        String optString3 = jSONObject.optString("reportMethodName");
        bVar.aso = optString3;
        if (optString3 == JSONObject.NULL) {
            bVar.aso = "";
        }
        String optString4 = jSONObject.optString("otherProxyClassName");
        bVar.asp = optString4;
        if (optString4 == JSONObject.NULL) {
            bVar.asp = "";
        }
        String optString5 = jSONObject.optString("otherFieldName");
        bVar.asq = optString5;
        if (optString5 == JSONObject.NULL) {
            bVar.asq = "";
        }
        String optString6 = jSONObject.optString("otherLevelFieldName");
        bVar.asr = optString6;
        if (optString6 == JSONObject.NULL) {
            bVar.asr = "";
        }
        String optString7 = jSONObject.optString("blockTag");
        bVar.ass = optString7;
        if (optString7 == JSONObject.NULL) {
            bVar.ass = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.crash.online.monitor.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.appId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appId", bVar.appId);
        }
        String str2 = bVar.asn;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pluginListenerName", bVar.asn);
        }
        String str3 = bVar.aso;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "reportMethodName", bVar.aso);
        }
        String str4 = bVar.asp;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "otherProxyClassName", bVar.asp);
        }
        String str5 = bVar.asq;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "otherFieldName", bVar.asq);
        }
        String str6 = bVar.asr;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "otherLevelFieldName", bVar.asr);
        }
        String str7 = bVar.ass;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "blockTag", bVar.ass);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.online.monitor.kwai.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.online.monitor.kwai.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
