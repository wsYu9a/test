package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class em implements com.kwad.sdk.core.d<com.kwad.components.ad.interstitial.b.a> {
    /* renamed from: a */
    private static void a2(com.kwad.components.ad.interstitial.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.jl = jSONObject.optLong("lastShowCardTimeStamp");
        aVar.jm = jSONObject.optInt("cardShowCount");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.ad.interstitial.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = aVar.jl;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "lastShowCardTimeStamp", j2);
        }
        int i2 = aVar.jm;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardShowCount", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.interstitial.b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.interstitial.b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
