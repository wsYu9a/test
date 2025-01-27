package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.reward.h.m;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ay implements com.kwad.sdk.core.d<m.a> {
    /* renamed from: a */
    private static void a2(m.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("name");
        aVar.name = optString;
        if (optString == JSONObject.NULL) {
            aVar.name = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(m.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.name;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "name", aVar.name);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(m.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(m.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
