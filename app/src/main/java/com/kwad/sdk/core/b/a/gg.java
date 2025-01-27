package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class gg implements com.kwad.sdk.core.d<com.kwad.sdk.utils.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aWT = jSONObject.optInt("put_count");
        aVar.aWU = jSONObject.optInt("get_failed_count");
        aVar.aWV = jSONObject.optInt("get_success_count");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.aWT;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "put_count", i10);
        }
        int i11 = aVar.aWU;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "get_failed_count", i11);
        }
        int i12 = aVar.aWV;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "get_success_count", i12);
        }
        return jSONObject;
    }
}
