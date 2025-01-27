package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ij implements com.kwad.sdk.core.d<com.kwad.sdk.m.b.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.m.b.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.m.b.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.m.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aEX = jSONObject.optInt("func_ratio_count");
        bVar.aSc = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("func_values");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                com.kwad.sdk.m.b.a.a aVar = new com.kwad.sdk.m.b.a.a();
                aVar.parseJson(optJSONArray.optJSONObject(i10));
                bVar.aSc.add(aVar);
            }
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.m.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = bVar.aEX;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "func_ratio_count", i10);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "func_values", bVar.aSc);
        return jSONObject;
    }
}
