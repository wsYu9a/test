package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class p implements com.kwad.sdk.core.d<com.kwad.components.core.i.a> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.JR = jSONObject.optInt("currentActiveCount");
        aVar.JS = jSONObject.optLong("lastForceActiveTimestamp");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.JR;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentActiveCount", i2);
        }
        long j2 = aVar.JS;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "lastForceActiveTimestamp", j2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.i.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.i.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
