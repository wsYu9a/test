package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class u implements com.kwad.sdk.core.d<com.kwad.components.core.k.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.k.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.k.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.core.k.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Ot = jSONObject.optInt("currentActiveCount");
        aVar.Ou = jSONObject.optLong("lastForceActiveTimestamp");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.k.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.Ot;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "currentActiveCount", i10);
        }
        long j10 = aVar.Ou;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "lastForceActiveTimestamp", j10);
        }
        return jSONObject;
    }
}
