package com.kwad.sdk.core.a.kwai;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fz implements com.kwad.sdk.core.d<com.kwad.sdk.f.kwai.a> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.f.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("sceneId");
        aVar.sceneId = optString;
        if (optString == JSONObject.NULL) {
            aVar.sceneId = "";
        }
        aVar.atl = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("packages");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                com.kwad.sdk.f.kwai.b bVar = new com.kwad.sdk.f.kwai.b();
                bVar.parseJson(optJSONArray.optJSONObject(i2));
                aVar.atl.add(bVar);
            }
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.f.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.sceneId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sceneId", aVar.sceneId);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "packages", aVar.atl);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.f.kwai.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.f.kwai.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
