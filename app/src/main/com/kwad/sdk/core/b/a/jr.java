package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class jr implements com.kwad.sdk.core.d<com.kwad.components.ad.splashscreen.local.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.splashscreen.local.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.splashscreen.local.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.ad.splashscreen.local.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.hY = jSONObject.optLong("lastShowTimestamp");
        aVar.hZ = jSONObject.optInt("currentDailyCount");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.ad.splashscreen.local.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = aVar.hY;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "lastShowTimestamp", j10);
        }
        int i10 = aVar.hZ;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "currentDailyCount", i10);
        }
        return jSONObject;
    }
}
