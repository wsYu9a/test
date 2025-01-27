package com.kwad.sdk.core.b.a;

import com.kwad.sdk.m.c;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b implements com.kwad.sdk.core.d<c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(c.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(c.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aRG = jSONObject.optString("originalActStr");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.aRG)) {
            aVar.aRG = "";
        }
        aVar.aRH = jSONObject.optString("targetField");
        if (obj.toString().equals(aVar.aRH)) {
            aVar.aRH = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.aRG;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "originalActStr", aVar.aRG);
        }
        String str2 = aVar.aRH;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "targetField", aVar.aRH);
        }
        return jSONObject;
    }
}
