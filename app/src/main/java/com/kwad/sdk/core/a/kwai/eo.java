package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class eo implements com.kwad.sdk.core.d<com.kwad.components.ad.interstitial.a.b> {
    /* renamed from: a */
    private static void a2(com.kwad.components.ad.interstitial.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.gq = jSONObject.optLong("lastShowTimestamp");
        bVar.jj = jSONObject.optInt("currentDailyAdShowCount");
        bVar.jk = jSONObject.optInt("currentDailyRetainShowCount");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.ad.interstitial.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = bVar.gq;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "lastShowTimestamp", j2);
        }
        int i2 = bVar.jj;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentDailyAdShowCount", i2);
        }
        int i3 = bVar.jk;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentDailyRetainShowCount", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.interstitial.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.interstitial.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
