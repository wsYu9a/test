package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class kc implements com.kwad.sdk.core.d<com.kwad.sdk.m.b.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.m.b.a.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.m.b.a.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.m.b.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.name = jSONObject.optString("name");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(cVar.name)) {
            cVar.name = "";
        }
        cVar.aSd = jSONObject.optString("detect_info");
        if (obj.toString().equals(cVar.aSd)) {
            cVar.aSd = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.m.b.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = cVar.name;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "name", cVar.name);
        }
        String str2 = cVar.aSd;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "detect_info", cVar.aSd);
        }
        return jSONObject;
    }
}
