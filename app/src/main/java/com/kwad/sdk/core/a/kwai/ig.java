package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ig implements com.kwad.sdk.core.d<com.kwad.sdk.ranger.a.kwai.c> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.ranger.a.kwai.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("name");
        cVar.name = optString;
        if (optString == JSONObject.NULL) {
            cVar.name = "";
        }
        String optString2 = jSONObject.optString("detect_info");
        cVar.ayF = optString2;
        if (optString2 == JSONObject.NULL) {
            cVar.ayF = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.ranger.a.kwai.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = cVar.name;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "name", cVar.name);
        }
        String str2 = cVar.ayF;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "detect_info", cVar.ayF);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.ranger.a.kwai.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.ranger.a.kwai.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }
}
