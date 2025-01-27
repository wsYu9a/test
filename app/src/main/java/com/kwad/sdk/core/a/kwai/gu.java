package com.kwad.sdk.core.a.kwai;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class gu implements com.kwad.sdk.core.d<com.kwad.sdk.ranger.a.kwai.b> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.ranger.a.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.amB = jSONObject.optInt("func_ratio_count");
        bVar.ayE = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("func_values");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                com.kwad.sdk.ranger.a.kwai.a aVar = new com.kwad.sdk.ranger.a.kwai.a();
                aVar.parseJson(optJSONArray.optJSONObject(i2));
                bVar.ayE.add(aVar);
            }
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.ranger.a.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = bVar.amB;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "func_ratio_count", i2);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "func_values", bVar.ayE);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.ranger.a.kwai.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.ranger.a.kwai.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
