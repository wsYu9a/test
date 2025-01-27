package com.kwad.sdk.core.a.kwai;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ih implements com.kwad.sdk.core.d<com.kwad.sdk.ranger.a.kwai.d> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.ranger.a.kwai.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.ayG = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("ranger");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                com.kwad.sdk.ranger.a.kwai.c cVar = new com.kwad.sdk.ranger.a.kwai.c();
                cVar.parseJson(optJSONArray.optJSONObject(i2));
                dVar.ayG.add(cVar);
            }
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.ranger.a.kwai.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "ranger", dVar.ayG);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.ranger.a.kwai.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.ranger.a.kwai.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }
}
