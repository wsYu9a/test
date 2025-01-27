package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ft implements com.kwad.sdk.core.d<com.kwad.components.ad.interstitial.c.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.interstitial.c.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.interstitial.c.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.ad.interstitial.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.hY = jSONObject.optLong("lastShowTimestamp");
        bVar.kL = jSONObject.optInt("currentDailyAdShowCount");
        bVar.kM = jSONObject.optInt("currentDailyRetainShowCount");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.ad.interstitial.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = bVar.hY;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "lastShowTimestamp", j10);
        }
        int i10 = bVar.kL;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "currentDailyAdShowCount", i10);
        }
        int i11 = bVar.kM;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "currentDailyRetainShowCount", i11);
        }
        return jSONObject;
    }
}
