package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.ranger.kwai.a;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class an implements com.kwad.sdk.core.d<com.kwad.sdk.ranger.kwai.a> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.ranger.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("nodeClassName");
        aVar.ayo = optString;
        if (optString == JSONObject.NULL) {
            aVar.ayo = "";
        }
        String optString2 = jSONObject.optString("childFieldName");
        aVar.ayp = optString2;
        if (optString2 == JSONObject.NULL) {
            aVar.ayp = "";
        }
        aVar.ayq = jSONObject.optBoolean("childFieldIsStatic");
        String optString3 = jSONObject.optString("reportKey");
        aVar.ayr = optString3;
        if (optString3 == JSONObject.NULL) {
            aVar.ayr = "";
        }
        a.b bVar = new a.b();
        aVar.ays = bVar;
        bVar.parseJson(jSONObject.optJSONObject("childMethod"));
        com.kwad.sdk.ranger.kwai.a aVar2 = new com.kwad.sdk.ranger.kwai.a();
        aVar.ayt = aVar2;
        aVar2.parseJson(jSONObject.optJSONObject("deepNode"));
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.ranger.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.ayo;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "nodeClassName", aVar.ayo);
        }
        String str2 = aVar.ayp;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "childFieldName", aVar.ayp);
        }
        boolean z = aVar.ayq;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "childFieldIsStatic", z);
        }
        String str3 = aVar.ayr;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "reportKey", aVar.ayr);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "childMethod", aVar.ays);
        com.kwad.sdk.utils.t.a(jSONObject, "deepNode", aVar.ayt);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.ranger.kwai.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.ranger.kwai.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
