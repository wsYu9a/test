package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ek implements com.kwad.sdk.core.d<com.kwad.sdk.kwai.kwai.kwai.a> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.kwai.kwai.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.gq = jSONObject.optLong("lastShowTimestamp");
        aVar.UX = jSONObject.optInt("showCount");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.kwai.kwai.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = aVar.gq;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "lastShowTimestamp", j2);
        }
        int i2 = aVar.UX;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showCount", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.kwai.kwai.kwai.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.kwai.kwai.kwai.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
