package com.kwad.sdk.core.b.a;

import com.kwad.sdk.m.a.a;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class bc implements com.kwad.sdk.core.d<com.kwad.sdk.m.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.m.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.m.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.m.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aRM = jSONObject.optString("nodeClassName");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.aRM)) {
            aVar.aRM = "";
        }
        aVar.aRN = jSONObject.optString("childFieldName");
        if (obj.toString().equals(aVar.aRN)) {
            aVar.aRN = "";
        }
        aVar.aRO = jSONObject.optBoolean("childFieldIsStatic");
        aVar.aRP = jSONObject.optString("reportKey");
        if (obj.toString().equals(aVar.aRP)) {
            aVar.aRP = "";
        }
        a.b bVar = new a.b();
        aVar.aRQ = bVar;
        bVar.parseJson(jSONObject.optJSONObject("childMethod"));
        com.kwad.sdk.m.a.a aVar2 = new com.kwad.sdk.m.a.a();
        aVar.aRR = aVar2;
        aVar2.parseJson(jSONObject.optJSONObject("deepNode"));
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.m.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.aRM;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "nodeClassName", aVar.aRM);
        }
        String str2 = aVar.aRN;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "childFieldName", aVar.aRN);
        }
        boolean z10 = aVar.aRO;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "childFieldIsStatic", z10);
        }
        String str3 = aVar.aRP;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "reportKey", aVar.aRP);
        }
        com.kwad.sdk.utils.x.a(jSONObject, "childMethod", aVar.aRQ);
        com.kwad.sdk.utils.x.a(jSONObject, "deepNode", aVar.aRR);
        return jSONObject;
    }
}
