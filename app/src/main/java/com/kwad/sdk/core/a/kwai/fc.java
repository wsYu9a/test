package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fc implements com.kwad.sdk.core.d<com.kwad.components.ad.fullscreen.a.b> {
    /* renamed from: a */
    private static void a2(com.kwad.components.ad.fullscreen.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.gq = jSONObject.optLong("lastShowTimestamp");
        bVar.gr = jSONObject.optInt("currentDailyCount");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.ad.fullscreen.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = bVar.gq;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "lastShowTimestamp", j2);
        }
        int i2 = bVar.gr;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentDailyCount", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.fullscreen.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.fullscreen.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
