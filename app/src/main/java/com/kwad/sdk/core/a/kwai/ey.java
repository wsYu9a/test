package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ey implements com.kwad.sdk.core.d<com.kwad.sdk.utils.a.a> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.utils.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aCK = jSONObject.optInt("put_count");
        aVar.aCL = jSONObject.optInt("get_failed_count");
        aVar.aCM = jSONObject.optInt("get_success_count");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.utils.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.aCK;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "put_count", i2);
        }
        int i3 = aVar.aCL;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "get_failed_count", i3);
        }
        int i4 = aVar.aCM;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "get_success_count", i4);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.utils.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.utils.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
