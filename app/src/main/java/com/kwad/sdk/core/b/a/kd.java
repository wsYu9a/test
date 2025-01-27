package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class kd implements com.kwad.sdk.core.d<com.kwad.sdk.m.b.a.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.m.b.a.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.m.b.a.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.m.b.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aSe = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("ranger");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                com.kwad.sdk.m.b.a.c cVar = new com.kwad.sdk.m.b.a.c();
                cVar.parseJson(optJSONArray.optJSONObject(i10));
                dVar.aSe.add(cVar);
            }
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.m.b.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "ranger", dVar.aSe);
        return jSONObject;
    }
}
