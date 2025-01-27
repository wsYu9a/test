package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.ranger.d;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b implements com.kwad.sdk.core.d<d.a> {
    /* renamed from: a */
    private static void a2(d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("originalActStr");
        aVar.axY = optString;
        if (optString == JSONObject.NULL) {
            aVar.axY = "";
        }
        String optString2 = jSONObject.optString("targetField");
        aVar.axZ = optString2;
        if (optString2 == JSONObject.NULL) {
            aVar.axZ = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.axY;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "originalActStr", aVar.axY);
        }
        String str2 = aVar.axZ;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "targetField", aVar.axZ);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(d.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(d.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
